package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.app.AIOImportPreviewFragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TDocAIOImportFacadeImpl implements ITDocAIOImportFacade {
    private static final String AIO_IMPORT_CONFIG_KEY = "tdoc_aio_import";
    private static final String CONNECT_APP_ID = "101860798";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRE_TIME = "expire_time";
    private static final String KEY_OPEN_ID = "openid";
    private static final String KEY_PAY_TOKEN = "pay_token";
    private static final int MB = 1048576;
    private static final int MEDIA_TYPE_AUDIO = 4;
    private static final int MEDIA_TYPE_FILE = 5;
    private static final int MEDIA_TYPE_LINK = 6;
    private static final int MEDIA_TYPE_PIC = 2;
    private static final int MEDIA_TYPE_TEXT = 1;
    private static final int MEDIA_TYPE_VIDEO = 3;
    private static final int MSG_TYPE_MIX = 2;
    private static final int MSG_TYPE_MULTI_MSG_FORWARD = 3;
    private static final int MSG_TYPE_SINGLE = 1;
    public static final String TAG = "TDocAIOImportFacadeImpl";
    private final List<String> aioImportSupportExtensions = Collections.synchronizedList(new ArrayList());
    private StringBuffer connectCookie = new StringBuffer();
    private final AtomicLong connectCookieExpiredTime = new AtomicLong(0);
    private final AtomicBoolean isCanceled = new AtomicBoolean(false);
    private StringBuffer curOperationId = new StringBuffer();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291667a;

        a(IGetExternalInterface.d dVar) {
            this.f291667a = dVar;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            QLog.i(TDocAIOImportFacadeImpl.TAG, 1, "[getConnectCookie] onComplete");
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int i3, String str) {
            QLog.e(TDocAIOImportFacadeImpl.TAG, 1, "[getConnectCookie] onFailure, code:" + i3 + " msg:" + str);
            this.f291667a.a(null);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int i3) {
            QLog.e(TDocAIOImportFacadeImpl.TAG, 1, "[getConnectCookie] onPermission, code:" + i3);
            this.f291667a.a(null);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject jSONObject) {
            String optString = jSONObject.optString("openid");
            String optString2 = jSONObject.optString("access_token");
            String optString3 = jSONObject.optString("expire_time");
            String str = "qq_connect_open_id=" + optString + ";qq_connect_access_token=" + optString2 + ";qq_connect_expired_time=" + optString3 + ";qq_connect_pay_token=" + jSONObject.optString(TDocAIOImportFacadeImpl.KEY_PAY_TOKEN);
            TDocAIOImportFacadeImpl.this.connectCookie = new StringBuffer(str);
            if (!TextUtils.isEmpty(optString3)) {
                TDocAIOImportFacadeImpl.this.connectCookieExpiredTime.set(Long.parseLong(optString3));
            }
            QLog.i(TDocAIOImportFacadeImpl.TAG, 1, "[getConnectCookie] onSuccess, cookie:" + str);
            this.f291667a.a(str);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject jSONObject) {
            QLog.i(TDocAIOImportFacadeImpl.TAG, 1, "[getConnectCookie] onTrigger:" + jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f291669a;

        /* renamed from: b, reason: collision with root package name */
        public String f291670b;

        /* renamed from: c, reason: collision with root package name */
        public String f291671c;

        /* renamed from: d, reason: collision with root package name */
        public String f291672d;

        /* renamed from: e, reason: collision with root package name */
        public String f291673e;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f291675a;

        /* renamed from: d, reason: collision with root package name */
        public long f291678d;

        /* renamed from: g, reason: collision with root package name */
        public int f291681g;

        /* renamed from: b, reason: collision with root package name */
        public String f291676b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f291677c = "";

        /* renamed from: e, reason: collision with root package name */
        public String f291679e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f291680f = "";

        c() {
        }
    }

    private String convert2JsonData(List<AIOMsgItem> list, int i3, String str, String str2, String str3, String str4) {
        int i16;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            jSONObject2.put("sessionId", str);
            jSONObject2.put("sessionName", str2);
            jSONObject2.put("msgNumber", list.size());
            jSONObject2.put("encryptionType", 2);
            jSONObject.put(SessionDbHelper.SESSION_ID, jSONObject2);
            JSONArray jSONArray = new JSONArray();
            for (AIOMsgItem aIOMsgItem : list) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(MessageRoamJsPlugin.USERTYPE, 1);
                jSONObject4.put("uid", String.valueOf(aIOMsgItem.getMsgRecord().senderUin));
                jSONObject4.put("nick", aIOMsgItem.getMsgRecord().sendNickName);
                jSONObject3.put("sender", jSONObject4);
                jSONObject3.put("msgTime", String.valueOf(aIOMsgItem.getMsgRecord().msgTime));
                jSONObject3.put("msgStyle", 1);
                JSONArray jSONArray2 = new JSONArray();
                try {
                    for (Iterator<c> it = getMediaInfoList(aIOMsgItem).iterator(); it.hasNext(); it = it) {
                        c next = it.next();
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject5.put("text", jr2.a.a(str3, str4, next.f291676b));
                        jSONObject5.put("md5", next.f291677c);
                        jSONObject5.put("size", next.f291678d);
                        jSONObject6.put("msg", jSONObject5);
                        jSONObject6.put("mediaType", next.f291675a);
                        jSONObject6.put("fileUrl", next.f291679e);
                        jSONObject6.put("fileId", next.f291680f);
                        jSONObject6.put("storeId", String.valueOf(next.f291681g));
                        jSONArray2.mo162put(jSONObject6);
                    }
                    jSONObject3.put(QAdVrReportParams.ParamKey.MEDIA, jSONArray2);
                    if (jSONArray2.length() > 1) {
                        i16 = 2;
                    } else {
                        i16 = 1;
                    }
                    jSONObject3.put(QQBrowserActivity.KEY_MSG_TYPE, i16);
                    jSONArray.mo162put(jSONObject3);
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e(TAG, 1, "[getJsonData] error", th);
                    return jSONObject.toString();
                }
            }
            jSONObject.put("chat", jSONArray);
        } catch (Throwable th6) {
            th = th6;
        }
        return jSONObject.toString();
    }

    private c convert2MediaInfo(int i3, MsgElement msgElement) {
        c cVar = new c();
        cVar.f291675a = convert2MediaType(i3, msgElement);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 5) {
                        VideoElement videoElement = msgElement.videoElement;
                        cVar.f291676b = videoElement.fileName;
                        cVar.f291677c = videoElement.videoMd5;
                        cVar.f291678d = videoElement.fileSize;
                        cVar.f291680f = videoElement.fileUuid;
                        cVar.f291681g = videoElement.storeID;
                    }
                } else {
                    FileElement fileElement = msgElement.fileElement;
                    cVar.f291676b = fileElement.fileName;
                    cVar.f291677c = fileElement.fileMd5;
                    cVar.f291678d = fileElement.fileSize;
                    cVar.f291680f = fileElement.fileUuid;
                    cVar.f291681g = fileElement.storeID;
                }
            } else {
                PicElement picElement = msgElement.picElement;
                cVar.f291676b = picElement.fileName;
                cVar.f291677c = picElement.md5HexStr;
                cVar.f291678d = picElement.fileSize;
                cVar.f291679e = picElement.originImageUrl;
                cVar.f291680f = picElement.fileUuid;
                cVar.f291681g = picElement.storeID;
            }
        } else {
            cVar.f291676b = msgElement.textElement.content;
        }
        return cVar;
    }

    private int convert2MediaType(int i3, MsgElement msgElement) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return 0;
                    }
                } else {
                    int intValue = msgElement.fileElement.subElementType.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                return 5;
                            }
                            return 4;
                        }
                    }
                }
                return 3;
            }
            return 2;
        }
        int intValue2 = msgElement.textElement.subElementType.intValue();
        if (intValue2 != 1 && intValue2 != 2) {
            return 1;
        }
        return 6;
    }

    private String generateNonce() {
        String str = (System.currentTimeMillis() / 1000) + "#";
        Random random = new Random();
        StringBuilder sb5 = new StringBuilder(str);
        for (int i3 = 0; i3 < 16 - str.length(); i3++) {
            sb5.append(random.nextInt(10));
        }
        return sb5.toString();
    }

    private List<c> getMediaInfoList(AIOMsgItem aIOMsgItem) {
        ArrayList arrayList = new ArrayList();
        Iterator<MsgElement> it = aIOMsgItem.getMsgRecord().getElements().iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            c cVar = new c();
            if (next.getElementType() == 1) {
                cVar = convert2MediaInfo(1, next);
            } else if (next.getElementType() == 2) {
                cVar = convert2MediaInfo(2, next);
            } else if (next.getElementType() == 5) {
                cVar = convert2MediaInfo(5, next);
            } else if (next.getElementType() == 3) {
                cVar = convert2MediaInfo(3, next);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void getSecretKeyAndSupportExtensions(Activity activity, final IGetExternalInterface.d dVar) {
        int i3;
        if (this.isCanceled.get()) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        final String generateNonce = generateNonce();
        try {
            jSONObject2.put("FileName", currentTimeMillis + ".chat");
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("Files", jSONArray);
            jSONObject.put("Sign", generateNonce);
            if (this.aioImportSupportExtensions.isEmpty()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("NeedMediaExtList", i3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getSecretKeyAndSupportExtensions] generate param failed", th5);
        }
        getConnectCookie(activity, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.b
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.this.lambda$getSecretKeyAndSupportExtensions$5(jSONObject, dVar, generateNonce, obj);
            }
        });
    }

    private void importFile(final Activity activity, final String str, final String str2, final String str3, final String str4, final ITDocAIOImportFacade.a aVar) {
        if (this.isCanceled.get()) {
            return;
        }
        getConnectCookie(activity, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.e
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.this.lambda$importFile$7(str, str2, str3, str4, activity, aVar, obj);
            }
        });
    }

    private boolean isSupportSaveToTencentDocs(AIOMsgItem aIOMsgItem) {
        Iterator<MsgElement> it = aIOMsgItem.getMsgRecord().getElements().iterator();
        while (it.hasNext()) {
            int elementType = it.next().getElementType();
            if (elementType != 1 && elementType != 2 && elementType != 5 && elementType != 3) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cancelImport$2(Object obj) {
        if (obj != null) {
            QLog.i(TAG, 1, "[cancelImport] result:" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelImport$3() {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "https://docs.qq.com/v1/import/third/cancel" + ("?operationId=" + ((Object) this.curOperationId)), ITeamWorkHandler.DOCS_DOMAIN, null, false, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.l
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.lambda$cancelImport$2(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSecretKeyAndSupportExtensions$4(IGetExternalInterface.d dVar, String str, Object obj) {
        JSONArray optJSONArray;
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int optInt = jSONObject.optInt("ret", -1);
                if (optInt != 0) {
                    QLog.i(TAG, 1, "[getSecretKeyAndSupportExtensions] ret:" + optInt + ", msg:" + jSONObject.optString("msg"));
                    dVar.a(null);
                    return;
                }
                b bVar = new b();
                JSONObject optJSONObject = jSONObject.optJSONObject("StorageAccess");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("CosKeyList")) != null && optJSONArray.length() > 0) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    bVar.f291669a = optJSONObject2.optString("CosFileKey");
                    bVar.f291670b = optJSONObject2.optString("CosPutUrl");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject(AECameraConstants.REQ_EXTRA);
                if (optJSONObject3 != null) {
                    String optString = optJSONObject3.optString("OperationId");
                    bVar.f291671c = optString;
                    this.curOperationId = new StringBuffer(optString);
                    bVar.f291672d = optJSONObject3.optString("CryptoKey");
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("MediaExtList");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.aioImportSupportExtensions.clear();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            this.aioImportSupportExtensions.add(optJSONArray2.optString(i3));
                        }
                    }
                }
                bVar.f291673e = str;
                dVar.a(bVar);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[getSecretKeyAndSupportExtensions] parse result failed", th5);
                dVar.a(null);
                return;
            }
        }
        dVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSecretKeyAndSupportExtensions$5(JSONObject jSONObject, final IGetExternalInterface.d dVar, final String str, Object obj) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            str2 = null;
        }
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "https://docs.qq.com/v1/import/third/secretKey", ITeamWorkHandler.DOCS_DOMAIN, str2, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.m
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj2) {
                TDocAIOImportFacadeImpl.this.lambda$getSecretKeyAndSupportExtensions$4(dVar, str, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$importFile$6(Activity activity, String str, ITDocAIOImportFacade.a aVar, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int optInt = jSONObject.optInt("ret", -1);
                if (optInt != 0) {
                    String optString = jSONObject.optString("msg");
                    QLog.i(TAG, 1, "[importFile] ret:" + optInt + ", msg:" + optString);
                    if (TextUtils.isEmpty(optString)) {
                        optString = activity.getString(R.string.f169382i7);
                    }
                    aVar.a(false, optInt, optString);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("docInfo");
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("url");
                    if (!TextUtils.isEmpty(optString2)) {
                        String optString3 = jSONObject.optString("hint");
                        openH5Page(activity, optString2, optJSONObject.optString("title"));
                        aVar.a(true, 0, optString3);
                        return;
                    }
                }
                lambda$queryImportProgress$8(activity, str, aVar);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[importFile] parse result failed", th5);
                aVar.a(false, -1, activity.getString(R.string.f169382i7));
                return;
            }
        }
        QLog.i(TAG, 1, "[importFile] result is invalid");
        lambda$queryImportProgress$8(activity, str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$importFile$7(final String str, String str2, String str3, String str4, final Activity activity, final ITDocAIOImportFacade.a aVar, Object obj) {
        String str5;
        if (obj instanceof String) {
            str5 = (String) obj;
        } else {
            str5 = null;
        }
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("operation_id=" + str + "&cos_file_key=" + str2 + "&document=" + str3 + "&filename=" + str4 + "&scene_type=13", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "https://docs.qq.com/v1/import/third", ITeamWorkHandler.DOCS_DOMAIN, str5, null, false, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.j
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj2) {
                TDocAIOImportFacadeImpl.this.lambda$importFile$6(activity, str, aVar, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openH5Page$11(Activity activity, String str, String str2, Object obj) {
        StringBuilder sb5 = new StringBuilder();
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            sb5.append(obj);
            sb5.append(";");
        }
        Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("isShowAd", false);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra("cookie", sb5.toString());
        intent.putExtra("fragmentClass", AIOImportPreviewFragment.class);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryImportProgress$10(final String str, final ITDocAIOImportFacade.a aVar, final Activity activity, Object obj) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            str2 = null;
        }
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "https://docs.qq.com/v1/import/third/progress" + ("?operationId=" + str), ITeamWorkHandler.DOCS_DOMAIN, str2, false, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.d
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj2) {
                TDocAIOImportFacadeImpl.this.lambda$queryImportProgress$9(aVar, activity, str, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryImportProgress$9(final ITDocAIOImportFacade.a aVar, final Activity activity, final String str, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int optInt = jSONObject.optInt("code", -1);
                if (optInt != 200) {
                    String optString = jSONObject.optString("msg");
                    QLog.i(TAG, 1, "[queryImportProgress] code:" + optInt + ", msg:" + optString);
                    if (TextUtils.isEmpty(optString)) {
                        optString = activity.getString(R.string.f169382i7);
                    }
                    aVar.a(false, optInt, optString);
                    return;
                }
                int optInt2 = jSONObject.optInt("progress");
                if (optInt2 < 0) {
                    QLog.i(TAG, 1, "[queryImportProgress] progress is less than 0");
                    aVar.a(false, -1, activity.getString(R.string.f169382i7));
                    return;
                }
                String optString2 = jSONObject.optString("status");
                if (optInt2 != 100 && !TextUtils.equals(optString2, "Done")) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            TDocAIOImportFacadeImpl.this.lambda$queryImportProgress$8(activity, str, aVar);
                        }
                    }, 128, null, false, 500L);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("docInfo");
                if (optJSONObject == null) {
                    QLog.i(TAG, 1, "[queryImportProgress] docInfo is null");
                    aVar.a(false, -1, activity.getString(R.string.f169382i7));
                    return;
                }
                String optString3 = optJSONObject.optString("url");
                if (TextUtils.isEmpty(optString3)) {
                    QLog.i(TAG, 1, "[queryImportProgress] docUrl is empty");
                    aVar.a(false, -1, activity.getString(R.string.f169382i7));
                    return;
                } else {
                    String optString4 = jSONObject.optString("hint");
                    openH5Page(activity, optString3, optJSONObject.optString("title"));
                    aVar.a(true, 0, optString4);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[queryImportProgress] parse result failed", th5);
                aVar.a(false, -1, activity.getString(R.string.f169382i7));
                return;
            }
        }
        QLog.i(TAG, 1, "[queryImportProgress] result is invalid");
        aVar.a(false, -1, activity.getString(R.string.f169382i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToTencentDocs$0(ITDocAIOImportFacade.a aVar, Activity activity, ArrayList arrayList, int i3, String str, String str2, Object obj) {
        File file;
        try {
            if (!(obj instanceof b)) {
                aVar.a(false, -1, activity.getString(R.string.f169382i7));
                return;
            }
            b bVar = (b) obj;
            String a16 = jr2.a.a(bVar.f291672d, bVar.f291673e, convert2JsonData(arrayList, i3, str, str2, bVar.f291672d, bVar.f291673e));
            String encode = URLEncoder.encode(a16, "UTF-8");
            if (encode.getBytes().length <= 1048576) {
                QLog.i(TAG, 1, "[saveToTencentDocs] data size less than 1M");
                importFile(activity, bVar.f291671c, bVar.f291669a, "v1.0.0#" + encode, System.currentTimeMillis() + ".chat", aVar);
                return;
            }
            try {
                File saveToFile = saveToFile(activity, "v1.0.0#" + a16);
                if (saveToFile == null) {
                    QLog.i(TAG, 1, "[saveToTencentDocs] dstFile is null");
                    aVar.a(false, -1, activity.getString(R.string.f169382i7));
                    return;
                }
                if (((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).uploadFile2Cos(saveToFile, bVar.f291670b)) {
                    file = saveToFile;
                    importFile(activity, bVar.f291671c, bVar.f291669a, "", saveToFile.getName(), aVar);
                } else {
                    file = saveToFile;
                    aVar.a(false, -1, activity.getString(R.string.f169382i7));
                }
                FileUtils.deleteFile(file);
            } catch (Throwable th5) {
                th = th5;
                QLog.e(TAG, 1, "[saveToTencentDocs] error", th);
                aVar.a(false, -1, activity.getString(R.string.f169382i7));
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToTencentDocs$1(final ITDocAIOImportFacade.a aVar, final Activity activity, final ArrayList arrayList, final int i3, final String str, final String str2) {
        aVar.b();
        getSecretKeyAndSupportExtensions(activity, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.f
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.this.lambda$saveToTencentDocs$0(aVar, activity, arrayList, i3, str, str2, obj);
            }
        });
    }

    private void openH5Page(final Activity activity, final String str, final String str2) {
        getConnectCookie(activity, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.k
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.lambda$openH5Page$11(activity, str, str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryImportProgress, reason: merged with bridge method [inline-methods] */
    public void lambda$queryImportProgress$8(final Activity activity, final String str, final ITDocAIOImportFacade.a aVar) {
        if (this.isCanceled.get()) {
            return;
        }
        getConnectCookie(activity, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.i
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TDocAIOImportFacadeImpl.this.lambda$queryImportProgress$10(str, aVar, activity, obj);
            }
        });
    }

    private File saveToFile(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        BufferedWriter bufferedWriter = null;
        sb5.append(context.getExternalFilesDir(null).getAbsolutePath());
        sb5.append("/tdoc/tmp");
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            QLog.i(TAG, 1, "[saveAndEncryptData] srcDir or dstDir mkdirs failed");
            return null;
        }
        File file2 = new File(file, System.currentTimeMillis() + ".chat");
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, false)));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.close();
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    try {
                        QLog.e(TAG, 1, "[saveToFile] failed, content:" + str, th);
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        return file2;
                    } catch (Throwable th6) {
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
        return file2;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade
    public void cancelImport(Context context) {
        this.isCanceled.set(true);
        if (!TextUtils.isEmpty(this.curOperationId.toString())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    TDocAIOImportFacadeImpl.this.lambda$cancelImport$3();
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade
    public void getConnectCookie(Activity activity, IGetExternalInterface.d dVar) {
        if (!TextUtils.isEmpty(this.connectCookie.toString()) && this.connectCookieExpiredTime.get() * 1000 > System.currentTimeMillis()) {
            QLog.i(TAG, 1, "[getConnectCookie] use cache, cookie:" + this.connectCookie.toString());
            dVar.a(this.connectCookie.toString());
            return;
        }
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
        Bundle bundle = new Bundle();
        bundle.putString("urlSummary", ITeamWorkHandler.DOCS_DOMAIN);
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, 0, CONNECT_APP_ID, bundle).d("loginSilent", null, new a(dVar));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade
    public boolean isAIOImportEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(AIO_IMPORT_CONFIG_KEY, false);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade
    public void reportSaveToTencentDocs(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("source3", "s_qq_msg_import");
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).report("qq_aio", "msg_imp", str, hashMap);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade
    public void saveToTencentDocs(final Activity activity, final int i3, final String str, final String str2, List<AIOMsgItem> list, final ITDocAIOImportFacade.a aVar) {
        this.isCanceled.set(false);
        final ArrayList arrayList = new ArrayList();
        boolean z16 = true;
        for (AIOMsgItem aIOMsgItem : list) {
            if (isSupportSaveToTencentDocs(aIOMsgItem)) {
                arrayList.add(aIOMsgItem);
            } else {
                z16 = false;
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i(TAG, 1, "[saveToTencentDocs] support list is empty");
            QQToast.makeText(activity, 1, R.string.f169412i_, 0).show();
        } else {
            if (!z16) {
                QQToast.makeText(activity, R.string.f169402i9, 0).show();
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    TDocAIOImportFacadeImpl.this.lambda$saveToTencentDocs$1(aVar, activity, arrayList, i3, str, str2);
                }
            }, 128, null, false);
        }
    }
}
