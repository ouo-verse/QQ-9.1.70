package com.tencent.mobileqq.minigame.api.impl;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeRequest;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeResponse;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.security.MessageDigest;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameAppLaunchHelper {
    private static final long DELAY_FOR_TOKEN_REQ_TIMEOUT = 2000;
    public static final int FLAG_ACCESS_TOKEN = 2;
    public static final int FLAG_ENCRY_KEY = 128;
    public static final int FLAG_OPENID = 1;
    public static final int FLAG_PAY_TOKEN = 4;
    public static final int FLAG_PFKEY = 64;
    private static final int MSG_TOKEN_REQ_TIMEOUT = 1;
    private static final String TAG = "MiniGameAppLaunchHelper";
    private static MiniGameAppLaunchHelper sInstance;
    private volatile boolean mIsLaunching;
    private NewIntent mNewIntent = null;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int genFlagFromParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        boolean contains = str.contains("$OPID$");
        boolean z16 = contains;
        if (str.contains("$AT$")) {
            z16 = (contains ? 1 : 0) | 2;
        }
        boolean z17 = z16;
        if (str.contains("$PT$")) {
            z17 = (z16 ? 1 : 0) | 4;
        }
        ?? r06 = z17;
        if (str.contains("$PF$")) {
            r06 = (z17 ? 1 : 0) | 64;
        }
        return str.contains("$ESK$") ? r06 | 128 : r06;
    }

    private String getApkSign(Context context, String str) {
        String str2 = "";
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            if (signatureArr == null) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            str2 = HexUtil.bytes2HexStr(messageDigest.digest()).toLowerCase();
            messageDigest.reset();
            return str2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getApkSign exception:", e16);
            return str2;
        }
    }

    public static Bundle getBundleFromParams(String str) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                try {
                    bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "getBundleFromParams exception:", e16);
                }
            }
        }
        return bundle;
    }

    public static MiniGameAppLaunchHelper getInstance() {
        if (sInstance == null) {
            synchronized (MiniGameAppLaunchHelper.class) {
                if (sInstance == null) {
                    sInstance = new MiniGameAppLaunchHelper();
                }
            }
        }
        return sInstance;
    }

    private int getLaunchFlag(int i3) {
        int i16;
        if ((i3 & 67108864) == 67108864) {
            i16 = 335544320;
        } else {
            i16 = 268435456;
        }
        if ((i3 & 536870912) == 536870912) {
            i16 |= 536870912;
        }
        if ((i3 & 4194304) == 4194304) {
            return i16 | 4194304;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$launchWithToken$0(String str, Context context, String str2, int i3, MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback, Message message) {
        if (message.what == 1) {
            NewIntent newIntent = this.mNewIntent;
            if (newIntent != null) {
                newIntent.setObserver(null);
                this.mNewIntent = null;
            }
            QLog.d(TAG, 1, "launchWithToken time out");
            launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str));
            this.mIsLaunching = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0325  */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.StringBuilder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$launchWithToken$1(WeakReferenceHandler weakReferenceHandler, String str, String str2, MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback, Context context, int i3, int i16, boolean z16, Bundle bundle) {
        String str3;
        MiniGameAppLaunchHelper miniGameAppLaunchHelper;
        NewIntent newIntent;
        String str4;
        String str5;
        String str6;
        String str7;
        MiniGameAppLaunchHelper miniGameAppLaunchHelper2;
        String str8;
        String str9;
        String str10;
        boolean z17;
        String str11;
        ?? r75 = this;
        int i17 = 1;
        QLog.d(TAG, 1, "launchWithToken reqToken rsp, isSuccess=", Boolean.valueOf(z16));
        weakReferenceHandler.removeMessages(1);
        if (z16) {
            byte[] byteArray = bundle.getByteArray("data");
            try {
                FastAuthorize$AuthorizeResponse fastAuthorize$AuthorizeResponse = new FastAuthorize$AuthorizeResponse();
                fastAuthorize$AuthorizeResponse.mergeFrom(byteArray);
                ?? isColorLevel = QLog.isColorLevel();
                r75 = "msg=";
                if (isColorLevel != 0) {
                    try {
                        ?? sb5 = new StringBuilder();
                        sb5.append("ret=");
                        str5 = "ret=";
                        sb5.append(fastAuthorize$AuthorizeResponse.ret.get());
                        sb5.append(", ");
                        sb5.append("msg=");
                        sb5.append(fastAuthorize$AuthorizeResponse.f342473msg.get());
                        sb5.append(", ");
                        sb5.append("access_token=");
                        sb5.append(fastAuthorize$AuthorizeResponse.access_token.get());
                        sb5.append(", ");
                        sb5.append("expires_in=");
                        str6 = "expires_in=";
                        str7 = "access_token=";
                        sb5.append(fastAuthorize$AuthorizeResponse.expires_in.get());
                        sb5.append(", ");
                        sb5.append("openid=");
                        sb5.append(fastAuthorize$AuthorizeResponse.openid.get());
                        sb5.append(", ");
                        sb5.append("pay_token=");
                        sb5.append(fastAuthorize$AuthorizeResponse.pay_token.get());
                        sb5.append(", ");
                        sb5.append("pf=");
                        sb5.append(fastAuthorize$AuthorizeResponse.f342474pf.get());
                        sb5.append(", ");
                        sb5.append("pfkey=");
                        sb5.append(fastAuthorize$AuthorizeResponse.pfkey.get());
                        sb5.append(", ");
                        sb5.append("encrykey=");
                        sb5.append(fastAuthorize$AuthorizeResponse.encrykey.get());
                        sb5.append(", ");
                        sb5.append("apk_name=");
                        sb5.append(fastAuthorize$AuthorizeResponse.apk_name.get());
                        sb5.append(", ");
                        QLog.d(TAG, 2, "launchWithToken FastAuthorize.AuthorizeResponse=[" + sb5 + "]");
                        str4 = sb5;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        r75 = this;
                        str4 = str;
                        i17 = 1;
                        QLog.e(TAG, 1, "launchWithToken parse rsp exception:", e);
                        str3 = str4;
                        miniGameAppLaunchHelper = r75;
                        QLog.d(TAG, i17, "launchWithToken with replacedParams");
                        launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str3));
                        newIntent = miniGameAppLaunchHelper.mNewIntent;
                        if (newIntent != null) {
                        }
                        miniGameAppLaunchHelper.mIsLaunching = false;
                    }
                } else {
                    str6 = "expires_in=";
                    str7 = "access_token=";
                    str5 = "ret=";
                    str4 = isColorLevel;
                }
                try {
                    if (fastAuthorize$AuthorizeResponse.ret.get().equals("0") && fastAuthorize$AuthorizeResponse.apk_name.has()) {
                        String str12 = fastAuthorize$AuthorizeResponse.apk_name.get();
                        try {
                            if (TextUtils.isEmpty(str12)) {
                                str4 = str;
                                str10 = str2;
                            } else {
                                str10 = str2;
                                try {
                                    if (str12.contains(str10)) {
                                        String replace = fastAuthorize$AuthorizeResponse.access_token.has() ? str.replace("$AT$", fastAuthorize$AuthorizeResponse.access_token.get()) : str;
                                        str4 = replace;
                                        if (fastAuthorize$AuthorizeResponse.pay_token.has()) {
                                            str4 = replace.replace("$PT$", fastAuthorize$AuthorizeResponse.pay_token.get());
                                        }
                                        try {
                                            if (fastAuthorize$AuthorizeResponse.openid.has()) {
                                                str11 = str4.replace("$OPID$", fastAuthorize$AuthorizeResponse.openid.get());
                                            } else {
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append(str5);
                                                sb6.append(fastAuthorize$AuthorizeResponse.ret.get());
                                                sb6.append(", ");
                                                sb6.append("msg=");
                                                sb6.append(fastAuthorize$AuthorizeResponse.f342473msg.get());
                                                sb6.append(", ");
                                                sb6.append(str7);
                                                sb6.append(fastAuthorize$AuthorizeResponse.access_token.get());
                                                sb6.append(", ");
                                                sb6.append(str6);
                                                str11 = str4;
                                                try {
                                                    sb6.append(fastAuthorize$AuthorizeResponse.expires_in.get());
                                                    sb6.append(", ");
                                                    sb6.append("openid=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.openid.get());
                                                    sb6.append(", ");
                                                    sb6.append("pay_token=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.pay_token.get());
                                                    sb6.append(", ");
                                                    sb6.append("pf=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.f342474pf.get());
                                                    sb6.append(", ");
                                                    sb6.append("pfkey=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.pfkey.get());
                                                    sb6.append(", ");
                                                    sb6.append("encrykey=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.encrykey.get());
                                                    sb6.append(", ");
                                                    sb6.append("apk_name=");
                                                    sb6.append(fastAuthorize$AuthorizeResponse.apk_name.get());
                                                    sb6.append(", ");
                                                    QLog.d(TAG, 1, "launchWithToken FastAuthorize.AuthorizeResponse=[" + ((Object) sb6) + "]");
                                                } catch (InvalidProtocolBufferMicroException e17) {
                                                    e = e17;
                                                    str4 = str11;
                                                    r75 = this;
                                                    i17 = 1;
                                                    QLog.e(TAG, 1, "launchWithToken parse rsp exception:", e);
                                                    str3 = str4;
                                                    miniGameAppLaunchHelper = r75;
                                                    QLog.d(TAG, i17, "launchWithToken with replacedParams");
                                                    launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str3));
                                                    newIntent = miniGameAppLaunchHelper.mNewIntent;
                                                    if (newIntent != null) {
                                                    }
                                                    miniGameAppLaunchHelper.mIsLaunching = false;
                                                }
                                            }
                                            if (fastAuthorize$AuthorizeResponse.pfkey.has()) {
                                                str11 = str11.replace("$PF$", fastAuthorize$AuthorizeResponse.pfkey.get());
                                            }
                                            if (fastAuthorize$AuthorizeResponse.encrykey.has()) {
                                                str11 = str11.replace("$ESK$", fastAuthorize$AuthorizeResponse.encrykey.get());
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d(TAG, 2, "launchWithToken replacedParams=", str11);
                                            }
                                            str8 = str11;
                                            miniGameAppLaunchHelper2 = this;
                                        } catch (InvalidProtocolBufferMicroException e18) {
                                            e = e18;
                                        }
                                    } else {
                                        str4 = str;
                                    }
                                } catch (InvalidProtocolBufferMicroException e19) {
                                    e = e19;
                                    str9 = str;
                                    r75 = this;
                                    str4 = str9;
                                    i17 = 1;
                                    QLog.e(TAG, 1, "launchWithToken parse rsp exception:", e);
                                    str3 = str4;
                                    miniGameAppLaunchHelper = r75;
                                    QLog.d(TAG, i17, "launchWithToken with replacedParams");
                                    launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str3));
                                    newIntent = miniGameAppLaunchHelper.mNewIntent;
                                    if (newIntent != null) {
                                    }
                                    miniGameAppLaunchHelper.mIsLaunching = false;
                                }
                            }
                            QLog.d(TAG, 1, "launchWithToken pkg not match, pkg=", str12, ", pkgName=", str10);
                            if (miniGameAppLaunchResultCallback != null) {
                                z17 = false;
                                try {
                                    miniGameAppLaunchResultCallback.onResult(false);
                                } catch (InvalidProtocolBufferMicroException e26) {
                                    e = e26;
                                    r75 = this;
                                    i17 = 1;
                                    QLog.e(TAG, 1, "launchWithToken parse rsp exception:", e);
                                    str3 = str4;
                                    miniGameAppLaunchHelper = r75;
                                    QLog.d(TAG, i17, "launchWithToken with replacedParams");
                                    launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str3));
                                    newIntent = miniGameAppLaunchHelper.mNewIntent;
                                    if (newIntent != null) {
                                    }
                                    miniGameAppLaunchHelper.mIsLaunching = false;
                                }
                            } else {
                                z17 = false;
                            }
                            this.mIsLaunching = z17;
                            return;
                        } catch (InvalidProtocolBufferMicroException e27) {
                            e = e27;
                            str9 = str4;
                        }
                    } else {
                        miniGameAppLaunchHelper2 = this;
                        str8 = str;
                        QLog.d(TAG, 1, "launchWithToken start without login state");
                    }
                    i17 = 1;
                    str3 = str8;
                    miniGameAppLaunchHelper = miniGameAppLaunchHelper2;
                } catch (InvalidProtocolBufferMicroException e28) {
                    e = e28;
                }
            } catch (InvalidProtocolBufferMicroException e29) {
                e = e29;
                str4 = str;
            }
        } else {
            str3 = str;
            QLog.d(TAG, 1, "launchWithToken start without login state");
            miniGameAppLaunchHelper = r75;
        }
        QLog.d(TAG, i17, "launchWithToken with replacedParams");
        launchAppInner(context, str2, i3, miniGameAppLaunchResultCallback, getBundleFromParams(str3));
        newIntent = miniGameAppLaunchHelper.mNewIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
            miniGameAppLaunchHelper.mNewIntent = null;
        }
        miniGameAppLaunchHelper.mIsLaunching = false;
    }

    private void launchAppInner(Context context, String str, int i3, final MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback, Bundle bundle) {
        int a16 = com.tencent.mobileqq.bigbrother.d.b().a(new com.tencent.mobileqq.bigbrother.b() { // from class: com.tencent.mobileqq.minigame.api.impl.f
            @Override // com.tencent.mobileqq.bigbrother.b
            public final void onJump(int i16, int i17) {
                MiniGameAppLaunchHelper.lambda$launchAppInner$2(MiniGameAppLaunchResultCallback.this, i16, i17);
            }
        });
        bundle.putInt("key_callback_id", a16);
        boolean t16 = com.tencent.open.business.base.a.t(context, str, warpMetaDreamLaunch(str, bundle), i3);
        QLog.d(TAG, 1, "launchAppInner result=", Boolean.valueOf(t16));
        if (t16) {
            return;
        }
        com.tencent.mobileqq.bigbrother.d.b().d(a16);
        if (miniGameAppLaunchResultCallback != null) {
            miniGameAppLaunchResultCallback.onResult(false);
        }
    }

    private static Bundle warpMetaDreamLaunch(String str, Bundle bundle) {
        if ("com.tencent.letsgo".equals(str)) {
            bundle.putBoolean(JefsClass.EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT, true);
            bundle.putString(JefsClass.EXTRA_KEY_DIALOG_CONTENT_TEXT, "\u5373\u5c06\u79bb\u5f00QQ\uff0c\u6253\u5f00\u201c\u5143\u68a6\u4e4b\u661f\u201d");
            bundle.putString(JefsClass.EXTRA_KEY_DIALOG_CONFIRM_TEXT, "\u786e\u8ba4");
            bundle.putString(JefsClass.EXTRA_KEY_DIALOG_CANCEL_TEXT, "\u53d6\u6d88");
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$launchAppInner$2(MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback, int i3, int i16) {
        QLog.d(TAG, 1, "launchAppInner onJump action=", Integer.valueOf(i16));
        if (i16 == 1) {
            return;
        }
        com.tencent.mobileqq.bigbrother.d.b().d(i3);
        if (miniGameAppLaunchResultCallback != null) {
            miniGameAppLaunchResultCallback.onResult(i16 == 2);
        }
    }

    public void launchApp(Context context, String str, String str2, int i3, String str3, MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback) {
        String str4 = str3;
        if (this.mIsLaunching) {
            QLog.d(TAG, 1, "launchApp mIsLaunching");
            return;
        }
        this.mIsLaunching = true;
        int launchFlag = getLaunchFlag(i3);
        if (str4.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str4 = str4.substring(1);
        }
        String str5 = str4;
        int genFlagFromParams = genFlagFromParams(str5);
        if (genFlagFromParams == 0) {
            QLog.d(TAG, 1, "launchApp no paramFlags");
            launchAppInner(context, str2, launchFlag, miniGameAppLaunchResultCallback, getBundleFromParams(str5));
            this.mIsLaunching = false;
            return;
        }
        String apkSign = getApkSign(context, str2);
        if (TextUtils.isEmpty(apkSign)) {
            QLog.d(TAG, 1, "launchApp apkSign null");
            launchAppInner(context, str2, launchFlag, miniGameAppLaunchResultCallback, getBundleFromParams(str5));
            this.mIsLaunching = false;
        } else {
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.d(TAG, 1, "launchApp no network");
                launchAppInner(context, str2, launchFlag, miniGameAppLaunchResultCallback, getBundleFromParams(str5));
                this.mIsLaunching = false;
                return;
            }
            launchWithToken(context, str, str2, str5, miniGameAppLaunchResultCallback, launchFlag, genFlagFromParams, apkSign);
        }
    }

    private void launchWithToken(final Context context, String str, final String str2, final String str3, final MiniGameAppLaunchResultCallback miniGameAppLaunchResultCallback, final int i3, int i16, String str4) {
        long j3;
        FastAuthorize$AuthorizeRequest fastAuthorize$AuthorizeRequest = new FastAuthorize$AuthorizeRequest();
        long j16 = 0;
        try {
            j3 = Long.parseLong(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "launchWithToken parse uin exception:", e16);
            j3 = 0;
        }
        fastAuthorize$AuthorizeRequest.uin.set(j3);
        try {
            j16 = Long.parseLong(str);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "launchWithToken parse appid exception:", e17);
        }
        fastAuthorize$AuthorizeRequest.client_id.set(j16);
        fastAuthorize$AuthorizeRequest.f342472pf.set("");
        fastAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.business.base.a.f(context));
        fastAuthorize$AuthorizeRequest.sdkp.set("a");
        fastAuthorize$AuthorizeRequest.f342471os.set(Build.DISPLAY);
        fastAuthorize$AuthorizeRequest.skey.set("");
        fastAuthorize$AuthorizeRequest.flags.set(i16);
        fastAuthorize$AuthorizeRequest.apk_sign.set(str4);
        if (this.mNewIntent == null) {
            this.mNewIntent = new NewIntent(context, com.tencent.biz.m.class);
        }
        this.mNewIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try {
            this.mNewIntent.putExtra("data", fastAuthorize$AuthorizeRequest.toByteArray());
            final WeakReferenceHandler weakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.minigame.api.impl.d
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean lambda$launchWithToken$0;
                    lambda$launchWithToken$0 = MiniGameAppLaunchHelper.this.lambda$launchWithToken$0(str3, context, str2, i3, miniGameAppLaunchResultCallback, message);
                    return lambda$launchWithToken$0;
                }
            });
            this.mNewIntent.setObserver(new com.tencent.open.appcommon.d() { // from class: com.tencent.mobileqq.minigame.api.impl.e
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i17, boolean z16, Bundle bundle) {
                    MiniGameAppLaunchHelper.this.lambda$launchWithToken$1(weakReferenceHandler, str3, str2, miniGameAppLaunchResultCallback, context, i3, i17, z16, bundle);
                }
            });
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                peekAppRuntime.startServlet(this.mNewIntent);
                weakReferenceHandler.sendEmptyMessageDelayed(1, 2000L);
            } else {
                QLog.d(TAG, 1, "launchWithToken app null");
                if (miniGameAppLaunchResultCallback != null) {
                    miniGameAppLaunchResultCallback.onResult(false);
                }
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "launchWithToken toByteArray exception:", e18);
            if (miniGameAppLaunchResultCallback != null) {
                miniGameAppLaunchResultCallback.onResult(false);
            }
            this.mIsLaunching = false;
        }
    }
}
