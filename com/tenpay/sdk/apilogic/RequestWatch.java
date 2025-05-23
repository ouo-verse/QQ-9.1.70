package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.ndk.CertUtil;
import com.tenpay.payment.QWalletWearPayBean;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.download.HttpOpGetFile;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.AESUtils;
import com.tenpay.sdk.util.QrcodePaySetting;
import com.tenpay.sdk.util.RSAUtils;
import com.tenpay.sdk.util.UinConfigManager;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RequestWatch implements Net.NetListener {
    public static final int AUTHOR_BUS = 3;
    public static final int CREATE_SESSION_BUS = 1;
    public static final int ERROR_NEED_AUTHOR = 9000;
    public static final int ERROR_NEED_CREATE_SESSION = 9001;
    public static final int ERROR_NO_OPEN_CODEPAY = 9002;
    public static final int ERROR_SERVER_CLOSE_WEARPAY = 9004;
    public static final int GET_PAY_CODE_BUS = 2;
    public static final int HAVE_OPEN_AUTHOR_VIEW = -2;
    public static final int NEED_OPEN_AUTHOR_VIEW = 10001;
    public static final int PAY_RESULT_NOTIFY_BUS = 4;
    public static final int PRE_LOAD_QWALLET_PLUG = 998;
    private static final int SP_MODE = 0;
    private static final String TAG = "RequestWatch";
    public static final int WEAR_APP_EXIT = 5;
    private static RequestWatch qrCodeWatchManager;
    public int businessType;
    public ResultReceiver callback;
    private Context context;
    private int forbid_watch;

    /* renamed from: iv, reason: collision with root package name */
    public byte[] f386829iv;
    public byte[] key;
    private String localImageCachePath;
    private String mCid;
    private String mDefaultCardInfo;
    private String mPayTypes;
    private String mQrPayType;
    private String mTokenMd5;
    public String reqData;
    private String uin;
    private String wearpay_auth;
    private String mQrCodePrefix = "50";
    public Long mPayTypeIndex = -1L;
    private long mTimestamp = -2;
    private Handler mHandler = new Handler();
    public boolean isAuthorView = false;
    private String imageNetUrl = "https://3gimg.qq.com/trom/commpic/qb_tenpay_wear_authorization.png";
    protected List<TenpayBL> mBlList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LoadImgTask extends AsyncTask<String, Void, String[]> {
        public LoadImgTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String[] doInBackground(String... strArr) {
            String str = strArr[0];
            File file = new File(RequestWatch.this.localImageCachePath);
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            try {
                HttpOpGetFile httpOpGetFile = new HttpOpGetFile();
                httpOpGetFile.setFilePathName(RequestWatch.this.localImageCachePath, "qb_tenpay_wear_authorization.png");
                httpOpGetFile.startRun(RequestWatch.this.context, str);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    RequestWatch() {
    }

    private void codePayGen(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", str);
        hashMap.put("device_id", QFuncProxy.getDeviceId(context));
        hashMap.put("device_type", NetUtil.getDeviceType(context));
        hashMap.put("device_name", NetUtil.getDeviceName(context));
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("cn", this.mCid);
        hashMap.put("token_md5", this.mTokenMd5);
        hashMap.put(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, Integer.toString(new Random(System.currentTimeMillis()).nextInt()));
        sendActivityRequestWithoutLoading(Cgi.URI_CODE_PAY_CODE_GEN, hashMap);
    }

    private void codePayMark() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uin", this.uin);
            hashMap.put("device_id", QFuncProxy.getDeviceId(this.context));
            hashMap.put("device_type", NetUtil.getDeviceType(this.context));
            hashMap.put("device_name", NetUtil.getDeviceName(this.context));
            hashMap.put("timestamp", this.mTimestamp + "");
            hashMap.put("guid", com.tencent.mobileqq.base.b.d());
            hashMap.put("token_md5", this.mTokenMd5);
            hashMap.put("reserve", CertUtil.getInstance(this.context).getTokenCount(this.mCid) + "");
        } catch (Exception unused) {
        }
        new TenpayBL().doTask(this.context.getApplicationContext(), Cgi.URI_CODE_PAY_CODE_MARK, hashMap, "", "", this.uin, true);
    }

    private void dealAuthorReq(String str, ResultReceiver resultReceiver, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (isPermission(str, jSONObject2.optString("macAddress"))) {
                jSONObject.put("retcode", 0);
            } else if (this.isAuthorView) {
                jSONObject.put("retcode", -2);
            } else {
                jSONObject.put("retcode", 10001);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        bundle.putString("retData", jSONObject.toString());
        bundle.putInt("businessType", this.businessType);
        resultReceiver.send(0, bundle);
    }

    private void dealCreateSessionReq(Context context, String str, ResultReceiver resultReceiver, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
        } catch (NoSuchAlgorithmException e16) {
            QLog.e(TAG, 1, "", e16);
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "", e17);
        }
        if (!TextUtils.isEmpty(this.mCid) && CertUtil.getInstance(context).isCertExist(this.mCid)) {
            if (isPermission(str, jSONObject2.optString("macAddress"))) {
                RSAUtils.initRsaKeys();
                jSONObject.put("retcode", 0);
                jSONObject.put("modulus", RSAUtils.modulus);
                jSONObject.put("public_exponent", RSAUtils.public_exponent);
            } else {
                jSONObject.put("retcode", 9000);
            }
            bundle.putString("retData", jSONObject.toString());
            bundle.putInt("businessType", this.businessType);
            resultReceiver.send(0, bundle);
        }
        jSONObject.put("retcode", 9002);
        bundle.putString("retData", jSONObject.toString());
        bundle.putInt("businessType", this.businessType);
        resultReceiver.send(0, bundle);
    }

    private void dealPayCodeReq(final String str, final ResultReceiver resultReceiver, final Bundle bundle, final JSONObject jSONObject, final JSONObject jSONObject2) {
        try {
            if (!jSONObject2.isNull("key") && !jSONObject2.isNull("iv")) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.apilogic.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestWatch.this.lambda$dealPayCodeReq$1(str, resultReceiver, bundle, jSONObject, jSONObject2);
                    }
                }, 64, null, false);
            }
            if (this.key != null && this.f386829iv != null) {
                getPayCodePreCheck(str, resultReceiver, bundle, jSONObject, jSONObject2);
            }
            jSONObject.put("retcode", 9001);
            bundle.putString("retData", jSONObject.toString());
            bundle.putInt("businessType", this.businessType);
            resultReceiver.send(0, bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
            onExceptionBack();
        } catch (Exception e17) {
            QLog.e(TAG, 1, "", e17);
            onExceptionBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: desKeyByPrivateKey, reason: merged with bridge method [inline-methods] */
    public void lambda$dealPayCodeReq$1(String str, ResultReceiver resultReceiver, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            RSAPrivateKey privateKey = RSAUtils.getPrivateKey(RSAUtils.modulus, RSAUtils.private_exponent);
            String decryptByPrivateKey = RSAUtils.decryptByPrivateKey(jSONObject2.optString("key", "").trim(), privateKey);
            String decryptByPrivateKey2 = RSAUtils.decryptByPrivateKey(jSONObject2.optString("iv", "").trim(), privateKey);
            if (!TextUtils.isEmpty(decryptByPrivateKey) && !TextUtils.isEmpty(decryptByPrivateKey2)) {
                this.key = Base64.decode(decryptByPrivateKey.getBytes(), 0);
                byte[] decode = Base64.decode(decryptByPrivateKey2.getBytes(), 0);
                this.f386829iv = decode;
                if (this.key.length == 16 && decode.length == 16) {
                    reqSavePass();
                    getPayCodePreCheck(str, resultReceiver, bundle, jSONObject, jSONObject2);
                } else {
                    jSONObject.put("retcode", 9001);
                    bundle.putString("retData", jSONObject.toString());
                    bundle.putInt("businessType", this.businessType);
                    resultReceiver.send(0, bundle);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
            onExceptionBack();
        } catch (Exception e17) {
            QLog.e(TAG, 1, "", e17);
            onExceptionBack();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x003a, code lost:
    
        if (r0.get(1) != r6) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x003c, code lost:
    
        r1 = r1 + r0.getActualMaximum(6);
        r0.add(1, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0048, code lost:
    
        if (r0.get(1) != r6) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004a, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getBetweenDay(Date date, Date date2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date2);
        int i3 = gregorianCalendar2.get(6) - gregorianCalendar.get(6);
        System.out.println("days=" + i3);
        int i16 = gregorianCalendar2.get(1);
    }

    private void getCode() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.apilogic.g
            @Override // java.lang.Runnable
            public final void run() {
                RequestWatch.this.lambda$getCode$2();
            }
        }, 16, null, false);
    }

    public static RequestWatch getInstance() {
        if (qrCodeWatchManager == null) {
            qrCodeWatchManager = new RequestWatch();
        }
        return qrCodeWatchManager;
    }

    private void getPayCodePreCheck(String str, ResultReceiver resultReceiver, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (isPermission(str, jSONObject2.optString("macAddress"))) {
            if (this.forbid_watch != 1) {
                getCode();
                return;
            }
            jSONObject.put("retcode", 9004);
            bundle.putString("retData", jSONObject.toString());
            bundle.putInt("businessType", this.businessType);
            resultReceiver.send(0, bundle);
            return;
        }
        jSONObject.put("retcode", 9000);
        bundle.putString("retData", jSONObject.toString());
        bundle.putInt("businessType", this.businessType);
        resultReceiver.send(0, bundle);
    }

    private JSONArray getPayTypeJSON(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("\\|")) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str3 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
                        String[] split = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split.length > 2) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i3 = 1; i3 < split.length; i3++) {
                                if (i3 > 1) {
                                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                }
                                stringBuffer.append(split[i3]);
                            }
                            jSONObject.put(split[0], stringBuffer.toString());
                        } else if (split.length == 2) {
                            jSONObject.put(split[0], split[1]);
                        } else if (split.length == 1) {
                            jSONObject.put(split[0], "");
                        }
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("name"))) {
                        jSONArray.mo162put(jSONObject);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        return jSONArray;
    }

    private void getQRCode(final Context context, final String str, final ResultReceiver resultReceiver) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.apilogic.e
            @Override // java.lang.Runnable
            public final void run() {
                RequestWatch.this.lambda$getQRCode$3(context, resultReceiver, str);
            }
        }, 16, null, false);
    }

    private void getServerTimeStamps() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", this.uin);
        sendActivityRequestWithoutLoading(Cgi.URL_WALLET_GATE, hashMap);
    }

    private void initPayType(String str) {
        if (this.mPayTypes != null) {
            if ("0".equals(this.mQrPayType)) {
                this.mPayTypeIndex = 0L;
            } else if (this.mQrPayType != null) {
                String[] split = this.mPayTypes.split("\\|");
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (this.mQrPayType.equals(split[i3])) {
                        this.mPayTypeIndex = Long.valueOf(i3 + 1);
                    }
                }
            }
            JSONArray payTypeJSON = getPayTypeJSON(this.mPayTypes);
            if (this.mPayTypeIndex.longValue() == -1) {
                if (payTypeJSON != null && payTypeJSON.length() > 0) {
                    this.mPayTypeIndex = 1L;
                    this.context.getSharedPreferences("qb_tenpay_pay_" + str, 0);
                    String[] split2 = this.mPayTypes.split("\\|");
                    QrcodePaySetting.prepare(this.context, str);
                    QrcodePaySetting.putString("qrcode_last_pay", split2[(int) (this.mPayTypeIndex.longValue() - 1)]);
                    QrcodePaySetting.commit();
                    return;
                }
                this.mPayTypeIndex = 0L;
            }
        }
    }

    private boolean isPermission(String str, String str2) {
        if (TextUtils.isEmpty(this.wearpay_auth)) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",");
        stringBuffer.append(str2);
        return new String(Base64.encode(stringBuffer.toString().getBytes(), 0)).trim().equals(this.wearpay_auth.trim());
    }

    private boolean isValateDate() {
        long timestamp;
        long systemTime;
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_pay_code_wear_pay_bean_" + this.uin, QWalletWearPayBean.class, null);
        if (qWalletWearPayBean == null) {
            timestamp = 0;
        } else {
            timestamp = qWalletWearPayBean.getTimestamp();
        }
        this.mTimestamp = timestamp;
        if (qWalletWearPayBean == null) {
            systemTime = 0;
        } else {
            systemTime = qWalletWearPayBean.getSystemTime();
        }
        if (systemTime == 0 || getBetweenDay(new Date(systemTime), new Date(System.currentTimeMillis())) > 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCode$2() {
        if (!TextUtils.isEmpty(this.mCid) && CertUtil.getInstance(this.context).isCertExist(this.mCid)) {
            if (CertUtil.getInstance(this.context).getTokenCount(this.mCid) > 0) {
                getQRCode(this.context, this.uin, this.callback);
                return;
            } else if (isValateDate()) {
                codePayGen(this.context, this.uin);
                return;
            } else {
                getServerTimeStamps();
                return;
            }
        }
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", 9002);
            bundle.putString("retData", jSONObject.toString());
            bundle.putInt("businessType", this.businessType);
            this.callback.send(0, bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getQRCode$3(Context context, ResultReceiver resultReceiver, String str) {
        if (this.key != null && this.f386829iv != null) {
            String token = CertUtil.getInstance(context).getToken(this.mCid);
            if (token != null) {
                long longValue = (this.mPayTypeIndex.longValue() << 49) + Long.parseLong(token);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.mQrCodePrefix);
                String l3 = Long.toString(longValue);
                int length = 16 - l3.length();
                for (int i3 = 0; i3 < length; i3++) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(l3);
                String stringBuffer2 = stringBuffer.toString();
                try {
                    Bundle bundle = new Bundle();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UinConfigManager.KEY_QRCODE, stringBuffer2);
                    jSONObject.put("retcode", 0);
                    jSONObject.put("payTypeIndex", this.mPayTypeIndex);
                    jSONObject.put("cardList", this.mPayTypes);
                    bundle.putInt("businessType", this.businessType);
                    byte[] encrypt = AESUtils.encrypt(jSONObject.toString(), this.key, this.f386829iv);
                    if (encrypt != null) {
                        bundle.putString("retData", new String(Base64.encode(encrypt, 0)));
                    }
                    resultReceiver.send(0, bundle);
                    codePayMark();
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "", e16);
                    onExceptionBack();
                    return;
                }
            }
            codePayGen(context, str);
            return;
        }
        onExceptionBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reqGetCode$0(Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) {
        dealCreateSessionReq(this.context, this.uin, this.callback, bundle, jSONObject, jSONObject2);
    }

    private void loadAuthor(Context context, String str) {
        String str2 = null;
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_pay_code_wear_pay_bean_" + str, QWalletWearPayBean.class, null);
        if (qWalletWearPayBean != null) {
            str2 = qWalletWearPayBean.getAuth();
        }
        this.wearpay_auth = str2;
    }

    private void loadQrpayConstant(Context context, String str) {
        QrcodePaySetting.prepare(context, str);
        this.mCid = QrcodePaySetting.getString("qrcode_pay_cid", "");
        this.mTokenMd5 = QrcodePaySetting.getString("qrcode_pay_tokenmd5", "");
        this.mPayTypes = QrcodePaySetting.getString("qrcode_pay_types", "");
        this.mQrPayType = QrcodePaySetting.getString("qrcode_last_pay", "");
        this.mQrCodePrefix = QrcodePaySetting.getString("qrcode_code_prefix", "50");
        this.forbid_watch = QrcodePaySetting.getInt("forbid_watch", 0);
    }

    private void onErrorCallback(JSONObject jSONObject) {
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retcode", -1);
            if (!TextUtils.isEmpty(jSONObject.optString("retcode"))) {
                jSONObject2.put("errorCode", jSONObject.optString("retcode"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("retmsg"))) {
                jSONObject2.put("errorMsg", jSONObject.optString("retmsg"));
            }
            bundle.putString("retData", jSONObject2.toString());
            bundle.putInt("businessType", this.businessType);
            this.callback.send(0, bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private void onExceptionBack() {
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retcode", -1);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        bundle.putString("retData", jSONObject.toString());
        bundle.putInt("businessType", this.businessType);
        this.callback.send(0, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reqGetCode() {
        JSONObject jSONObject;
        final Bundle bundle = new Bundle();
        final JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.reqData);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        final JSONObject jSONObject3 = jSONObject;
        int i3 = this.businessType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    dealAuthorReq(this.uin, this.callback, bundle, jSONObject2, jSONObject3);
                    return;
                }
                return;
            }
            dealPayCodeReq(this.uin, this.callback, bundle, jSONObject2, jSONObject3);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.apilogic.d
            @Override // java.lang.Runnable
            public final void run() {
                RequestWatch.this.lambda$reqGetCode$0(bundle, jSONObject2, jSONObject3);
            }
        }, 16, null, false);
    }

    private void reqGetPass() {
        DataProxy.reqGetEncryption(new ResultReceiver(this.mHandler) { // from class: com.tenpay.sdk.apilogic.RequestWatch.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                Bundle baseRespResult = DataProxy.getBaseRespResult(bundle);
                if (baseRespResult != null) {
                    byte[] byteArray = baseRespResult.getByteArray("key");
                    byte[] byteArray2 = baseRespResult.getByteArray("iv");
                    if (byteArray != null && byteArray.length > 0) {
                        RequestWatch.this.key = byteArray;
                    }
                    if (byteArray2 != null && byteArray2.length > 0) {
                        RequestWatch.this.f386829iv = byteArray2;
                    }
                }
                RequestWatch.this.reqGetCode();
            }
        });
    }

    private void reqSavePass() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("key", this.key);
        bundle.putByteArray("iv", this.f386829iv);
        DataProxy.reqPutEncryption(bundle);
    }

    private void saveTimestamp(Context context, String str, long j3) {
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_pay_code_wear_pay_bean_" + str, QWalletWearPayBean.class, null);
        if (qWalletWearPayBean == null) {
            qWalletWearPayBean = QWalletWearPayBean.create();
        }
        qWalletWearPayBean.setTimestamp(j3);
        qWalletWearPayBean.setSystemTime(System.currentTimeMillis());
        com.tencent.mobileqq.qwallet.utils.g.p("qwallet_pay_code_wear_pay_bean_" + str, qWalletWearPayBean);
    }

    public void doAction(Context context, String str, Map<String, String> map, ResultReceiver resultReceiver) {
        this.uin = str;
        this.callback = resultReceiver;
        this.context = context;
        this.businessType = Integer.parseInt(map.get("businessType"));
        this.reqData = map.get("reqData");
        if (this.businessType == 998) {
            return;
        }
        String str2 = context.getApplicationContext().getCacheDir().getAbsolutePath() + "/";
        this.localImageCachePath = str2;
        if (!isImageExist(str2)) {
            new LoadImgTask().execute(this.imageNetUrl);
        }
        loadAuthor(context, str);
        loadQrpayConstant(context, str);
        initPayType(str);
        reqGetPass();
    }

    public boolean isImageExist(String str) {
        return new File(str + "qb_tenpay_wear_authorization.png").exists();
    }

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        onErrorCallback(jSONObject);
    }

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        onErrorCallback(jSONObject);
    }

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        if (str.equals(Cgi.URI_CODE_PAY_CODE_GEN)) {
            this.mTokenMd5 = jSONObject.optString("token_md5");
            this.mPayTypes = jSONObject.optString("pay_desc");
            this.mQrCodePrefix = jSONObject.optString("code_prefix");
            int optInt = jSONObject.optInt("forbid_watch");
            QrcodePaySetting.prepare(this.context, this.uin);
            QrcodePaySetting.putBoolean("qrcode_bindcard_refresh", false);
            QrcodePaySetting.putString("qrcode_pay_tokenmd5", this.mTokenMd5);
            QrcodePaySetting.putString("qrcode_pay_types", this.mPayTypes);
            QrcodePaySetting.putString("qrcode_code_prefix", this.mQrCodePrefix);
            QrcodePaySetting.putInt("forbid_watch", optInt);
            QrcodePaySetting.commit();
            if (CertUtil.getInstance(this.context).setTokens(this.mCid, jSONObject.optString("token"))) {
                getQRCode(this.context, this.uin, this.callback);
            } else {
                onErrorCallback(jSONObject);
            }
        }
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            long parseLong = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mTimestamp = parseLong;
            saveTimestamp(this.context, this.uin, parseLong);
            codePayGen(this.context, this.uin);
        }
    }

    public void requestData(Context context, String str, Map<String, String> map, ResultReceiver resultReceiver) {
        doAction(context, str, map, resultReceiver);
    }

    public void sendActivityRequestWithoutLoading(String str, HashMap<String, String> hashMap) {
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(this);
        tenpayBL.doTask(this.context.getApplicationContext(), str, hashMap, "", "", this.uin, true);
        this.mBlList.add(tenpayBL);
    }
}
