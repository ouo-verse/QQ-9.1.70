package com.tenpay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.ndk.BCDEncUtil;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.ndk.PassWdEncUtil;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.ToolPool;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenUtils {
    public static final long ERROR_DELAY_TIME = 60000;
    public static final String FILE_PRECONNECT_NAME = "pre_connect";
    public static final int INVALID_SEX = 0;
    public static final String KEY_PRECONNECT_LAST_TIME = "pre_connect_last_time";
    private static final String PROTOCAL_HTTP = "http";
    private static final String PROTOCAL_HTTPS = "https";
    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 2;
    private static final String TAG = "TenUtils";
    public static final String TYPE_PRECONNECT_M = "type_mqq_and_myun";
    private static AtomicBoolean isShowingPermissionDialog = new AtomicBoolean(false);
    private static String mSubscriberId;

    public static void broadCastIdVerified() {
        QwLog.i("start broadcast...");
        Intent intent = new Intent("com.qwallet.report");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", true);
        intent.putExtra("type", 1);
        intent.putExtra("params", bundle);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    public static void checkUpdate(ResultReceiver resultReceiver) {
        Bundle bundle = new Bundle();
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        bundle.putParcelable("receiver", resultReceiver2);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "getConditionSearchManager", bundle);
    }

    public static void closeSoftKeyBoard(Activity activity) {
        View peekDecorView = activity.getWindow().peekDecorView();
        if (peekDecorView != null) {
            ((InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    public static void editTxtLimLen(final Context context, EditText editText, final String str, final int i3) {
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.util.TenUtils.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(editable.toString()) && editable.length() >= i3) {
                        QQToast.makeText(context, 1, str, 0).show();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i16, int i17, int i18) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i16, int i17, int i18) {
                }
            });
        }
    }

    public static Map<String, String> getArguments(String str) {
        String substring = str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : substring.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static void getAvatar(String str, int i3, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("req_uin", str);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, i3);
        DataProxy.reqAvatar(resultReceiver, bundle);
    }

    public static String getEncWithMacPasswd(Context context, String str, String str2) {
        String hexdigest = MD5.hexdigest(str);
        QwLog.i("\u5bc6\u7801MD5\u503c\uff1a" + hexdigest);
        PassWdEncUtil passWdEncUtil = new PassWdEncUtil(context);
        String bcdEncode = new BCDEncUtil(context).bcdEncode(str2);
        if (ToolPool.instance().isPwd2048()) {
            passWdEncUtil.encryptPasswdWithRsa(hexdigest, str2);
            String rSA2048Res = passWdEncUtil.getRSA2048Res();
            QwLog.i("RSA256(\u5bc6\u7801MD5)\u503c\uff1a" + rSA2048Res);
            return Cgi.ENCRYPT_VERSION + bcdEncode + Utils.sha256(str2 + str) + rSA2048Res;
        }
        passWdEncUtil.encryptPasswdWithMacNew(hexdigest, str2);
        String encryptPasswd = passWdEncUtil.getEncryptPasswd();
        QwLog.i("RSA(\u5bc6\u7801MD5)\u503c\uff1a" + encryptPasswd);
        return bcdEncode + Cgi.SHA + encryptPasswd;
    }

    public static String getEncWithNoMacPasswd(Context context, String str, long j3) {
        String l3 = Long.toString((System.currentTimeMillis() / 1000) + j3);
        String hexdigest = MD5.hexdigest(str);
        QwLog.i("\u5bc6\u7801MD5\u503c\uff1a" + hexdigest);
        PassWdEncUtil passWdEncUtil = new PassWdEncUtil(context);
        String bcdEncode = new BCDEncUtil(context).bcdEncode(l3);
        if (ToolPool.instance().isPwd2048()) {
            passWdEncUtil.encryptPasswdWithRsa(hexdigest, l3);
            String rSA2048Res = passWdEncUtil.getRSA2048Res();
            QwLog.i("RSA256(\u5bc6\u7801MD5)\u503c\uff1a" + rSA2048Res);
            return Cgi.ENCRYPT_VERSION + bcdEncode + Utils.sha256(j3 + str) + rSA2048Res;
        }
        passWdEncUtil.encryptPasswdWithNoMacNew(hexdigest, l3);
        String encryptPasswd = passWdEncUtil.getEncryptPasswd();
        QwLog.i("RSA(\u5bc6\u7801MD5)\u503c\uff1a" + encryptPasswd);
        return bcdEncode + Cgi.SHA + encryptPasswd;
    }

    public static void getGroupNickname(String str, int i3, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("req_uin", str);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, i3);
        DataProxy.reqGroupNickname(resultReceiver, bundle);
    }

    public static String getJsonFromSP(String str, String str2, String str3, boolean z16) {
        BaseApplication context = BaseApplication.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (z16) {
            DesDecUtil desDecUtil = new DesDecUtil(context);
            desDecUtil.decDesWithStringKey(str2 + QFuncProxy.getDeviceId(context), sharedPreferences.getString(str3, ""));
            return desDecUtil.getDecRes();
        }
        return sharedPreferences.getString(str3, "");
    }

    public static String getNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) BaseApplication.context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "";
        }
        if (NetworkMonitor.getType(networkInfo) == 1) {
            return Global.TRACKING_WIFI;
        }
        if (NetworkMonitor.getType(networkInfo) != 0) {
            return "";
        }
        String subtypeName = networkInfo.getSubtypeName();
        switch (NetworkMonitor.getSubtype(networkInfo)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                break;
            case 13:
                return "4G";
            default:
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return subtypeName;
                }
                break;
        }
        return "3G";
    }

    public static String getQrCodePaySign(Context context, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", map.get("uin"));
        hashMap.put("device_id=", map.get("device_id"));
        hashMap.put("device_type=", map.get("device_type"));
        hashMap.put("guid=", map.get("guid"));
        hashMap.put("timestamp=", ((System.currentTimeMillis() / 1000) + Long.parseLong(map.get("timestamp"))) + "");
        hashMap.put("cn=", map.get("cn"));
        hashMap.put("random=", map.get(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM));
        if (!TextUtils.isEmpty(map.get("token_md5"))) {
            hashMap.put("token_md5=", map.get("token_md5"));
        }
        return CertUtil.getInstance(context).genUserSigNoEncode(map.get("cn"), Utils.sortAndCatValues(hashMap));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject getServerConfig(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb5.append(new String(bArr, 0, read));
                }
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(sb5.toString(), 0)));
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    QLog.e(TAG, 1, "", e17);
                }
                return jSONObject;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e18) {
                        QLog.e(TAG, 1, "", e18);
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            QLog.e(TAG, 1, "", e);
            if (fileInputStream == null) {
                return null;
            }
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e26) {
                QLog.e(TAG, 1, "", e26);
                return null;
            }
        }
    }

    public static String getSexStrByType(Context context, int i3) {
        int i16;
        if (i3 == 1) {
            i16 = R.string.f1794139a;
        } else {
            i16 = R.string.f1794639f;
        }
        return context.getResources().getString(i16);
    }

    public static int getSexTypeByID(String str) {
        int parseInt;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() == 18) {
                    parseInt = Integer.parseInt(str.substring(16, 17));
                } else if (str.length() == 15) {
                    parseInt = Integer.parseInt(str.substring(14, 15));
                }
                if (parseInt % 2 != 1) {
                    return 2;
                }
                return 1;
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static String getSubscriberId(Context context) {
        if (mSubscriberId == null) {
            mSubscriberId = QFuncProxy.getDeviceId(context);
        }
        return mSubscriberId;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00c9: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:202), block:B:56:0x00c9 */
    public static synchronized String getTestIP(String str) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Closeable closeable;
        synchronized (TenUtils.class) {
            String str2 = DataProxy.getTenpayExternalPath() + "debug";
            Closeable closeable2 = null;
            try {
                try {
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        QwLog.i("hosts is : " + readLine);
                                        if (!readLine.startsWith("#") && readLine.contains(str)) {
                                            String str3 = readLine.split(" ")[0];
                                            Utils.closeObject(bufferedReader);
                                            Utils.closeObject(inputStreamReader);
                                            Utils.closeObject(fileInputStream);
                                            return str3;
                                        }
                                    } else {
                                        Utils.closeObject(bufferedReader);
                                        Utils.closeObject(inputStreamReader);
                                        break;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e(TAG, 1, "", e);
                                    QwLog.i("\u8bfb\u53d6" + str2 + "\u51fa\u9519\uff01");
                                    Utils.closeObject(bufferedReader);
                                    Utils.closeObject(inputStreamReader);
                                    Utils.closeObject(fileInputStream);
                                    return null;
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            bufferedReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            Utils.closeObject(closeable2);
                            Utils.closeObject(inputStreamReader);
                            Utils.closeObject(fileInputStream);
                            throw th;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        inputStreamReader = null;
                        bufferedReader = null;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    inputStreamReader = null;
                    fileInputStream = null;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    th = th7;
                    inputStreamReader = null;
                    fileInputStream = null;
                }
                Utils.closeObject(fileInputStream);
                return null;
            } catch (Throwable th8) {
                th = th8;
                closeable2 = closeable;
            }
        }
    }

    public static String getUrlHead(int i3, int i16) {
        String str;
        String str2;
        if (TextUtils.isEmpty(Cgi.wallet_domain)) {
            str = Cgi.DOMAIN_YUN_SERVER;
        } else {
            str = Cgi.wallet_domain;
        }
        if (i3 != 0 && i3 != 3) {
            str2 = "http";
        } else {
            str2 = "https";
        }
        String format = String.format("%s://%s", str2, str);
        QwLog.i("getUrlHead head=" + format + " type = " + i3);
        return format;
    }

    public static boolean isNeedPreConnect(Context context, String str, String str2) {
        JSONObject optJSONObject;
        JSONObject serverConfig = getServerConfig(DataProxy.getTenpayInternalPath() + str + "/hbThemeConfig.cfg");
        if (serverConfig == null || (optJSONObject = serverConfig.optJSONObject("pre_connection")) == null) {
            return false;
        }
        String optString = optJSONObject.optString(QCircleLpReportDc05502.KEY_BEGIN_TIME);
        String optString2 = optJSONObject.optString("end_time");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            long dateToStamp = Utils.dateToStamp(optString);
            long dateToStamp2 = Utils.dateToStamp(optString2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= dateToStamp && currentTimeMillis <= dateToStamp2) {
                long parseInt = Integer.parseInt(optJSONObject.optString("request_interval"));
                SharedPreferences sharedPreferences = context.getSharedPreferences("pre_connect" + str, 4);
                if (TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis - sharedPreferences.getLong("pre_connect_last_time" + str2, 0L)) < parseInt) {
                    return false;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("pre_connect_last_time" + str2, currentTimeMillis);
                edit.commit();
                return true;
            }
        }
        return false;
    }

    public static void notifyToExit(Context context, long j3) {
        Intent intent = new Intent(Cgi.BROADCAST_INTENT_ACTION_EXIT);
        intent.putExtra("ID", j3);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public static void openAio(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("send_uin", str);
        bundle.putInt("send_type", i3);
        DataProxy.openAio(bundle);
    }

    public static boolean readCtPayRedPointShown(Context context, String str) {
        return context.getSharedPreferences("qb_tenpay_pay_" + str, 0).getBoolean("ctpay_redpoint", false);
    }

    public static boolean readOpenCtPayRedPointShown(Context context, String str) {
        return context.getSharedPreferences("qb_tenpay_pay_" + str, 0).getBoolean("open_ctpay_redpoint", false);
    }

    public static void saveCtPayRedPointShown(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("qb_tenpay_pay_" + str, 0).edit();
        edit.putBoolean("ctpay_redpoint", true);
        edit.commit();
    }

    public static void saveJsonToSP(String str, String str2, String str3, String str4, boolean z16) {
        BaseApplication context = BaseApplication.getContext();
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (!z16) {
            edit.putString(str3, str4);
        } else {
            DesEncUtil desEncUtil = new DesEncUtil(context);
            desEncUtil.encryptDesWithStringKey(str2 + QFuncProxy.getDeviceId(context), str4);
            edit.putString(str3, desEncUtil.getDesEncResult());
        }
        edit.commit();
    }

    public static void saveOpenCtPayRedPointShown(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("qb_tenpay_pay_" + str, 0).edit();
        edit.putBoolean("open_ctpay_redpoint", true);
        edit.commit();
    }

    public static String getEncWithMacPasswd(Context context, String str, long j3) {
        return getEncWithMacPasswd(context, str, Long.toString((System.currentTimeMillis() / 1000) + j3));
    }
}
