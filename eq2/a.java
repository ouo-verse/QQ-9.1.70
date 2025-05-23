package eq2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.m;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeRequest;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeResponse;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import nl0.h;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import tencent.im.qqgame.QQGameCheckDownload$StartApkReq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: h, reason: collision with root package name */
    protected static boolean f396996h = false;

    /* renamed from: i, reason: collision with root package name */
    protected static String f396997i = "";

    /* renamed from: d, reason: collision with root package name */
    protected String f397001d;

    /* renamed from: a, reason: collision with root package name */
    protected NewIntent f396998a = null;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f396999b = null;

    /* renamed from: c, reason: collision with root package name */
    protected Handler f397000c = null;

    /* renamed from: e, reason: collision with root package name */
    protected int f397002e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected HashMap<String, String> f397003f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    protected boolean f397004g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: eq2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class HandlerC10260a extends Handler {
        HandlerC10260a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                a.f396996h = false;
                if (QLog.isColorLevel()) {
                    QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends WtloginListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f397006b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WtloginHelper f397007c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f397008d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f397009e;

        b(String str, WtloginHelper wtloginHelper, int i3, Context context) {
            this.f397006b = str;
            this.f397007c = wtloginHelper;
            this.f397008d = i3;
            this.f397009e = context;
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
            super.OnException(errMsg, i3, wUserSigInfo);
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, "geta1 OnException " + errMsg);
            }
            a.f396996h = false;
            a.this.f397000c.removeMessages(0);
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
            a.this.f397000c.removeMessages(0);
            a.f396996h = false;
            if (i16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(getClass().getSimpleName(), 2, "geta1 failed " + i16);
                    return;
                }
                return;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(this.f397006b));
            intent.putExtras(this.f397007c.PrepareQloginResult(str, j18, j19, i16, wFastLoginInfo));
            intent.setFlags(this.f397008d);
            this.f397009e.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f397011a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f397012b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f397013c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f397014d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f397015e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f397016f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f397017g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, Context context, String str, int i3, AppInterface appInterface, String str2, String str3, String str4) {
            super(looper);
            this.f397011a = context;
            this.f397012b = str;
            this.f397013c = i3;
            this.f397014d = appInterface;
            this.f397015e = str2;
            this.f397016f = str3;
            this.f397017g = str4;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    a aVar = a.this;
                    aVar.f397004g = true;
                    NewIntent newIntent = aVar.f396998a;
                    if (newIntent != null) {
                        newIntent.setObserver(null);
                        a.this.f396998a = null;
                    }
                    a.this.i(this.f397014d, this.f397011a, this.f397015e, this.f397016f, this.f397012b, "", this.f397013c, this.f397017g);
                    return;
                }
                return;
            }
            a aVar2 = a.this;
            aVar2.f397004g = true;
            NewIntent newIntent2 = aVar2.f396998a;
            if (newIntent2 != null) {
                newIntent2.setObserver(null);
                a.this.f396998a = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
            }
            com.tencent.open.business.base.a.t(this.f397011a, this.f397012b, a.g(a.this.f397001d), this.f397013c);
            a.f396996h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f397019d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f397020e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f397021f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f397022h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f397023i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f397024m;

        d(long j3, String str, String str2, String str3, Context context, int i3) {
            this.f397019d = j3;
            this.f397020e = str;
            this.f397021f = str2;
            this.f397022h = str3;
            this.f397023i = context;
            this.f397024m = i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x03c9  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x03ef  */
        /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x03a9  */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            NewIntent newIntent;
            String str;
            String str2;
            String str3;
            String str4;
            d dVar = this;
            String str5 = "AppLaucherHelper";
            if (QLog.isColorLevel()) {
                QLog.d("AppLaucherHelper", 2, "t=" + (System.currentTimeMillis() - dVar.f397019d));
                QLog.d(a.this.getClass().getSimpleName(), 2, "onReceive");
            }
            new Bundle();
            String str6 = dVar.f397020e;
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                try {
                    FastAuthorize$AuthorizeResponse fastAuthorize$AuthorizeResponse = new FastAuthorize$AuthorizeResponse();
                    fastAuthorize$AuthorizeResponse.mergeFrom(byteArray);
                    if (!QLog.isColorLevel()) {
                        str = "ret=";
                        str2 = "access_token=";
                    } else {
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("ret=");
                            str = "ret=";
                            sb5.append(fastAuthorize$AuthorizeResponse.ret.get());
                            sb5.append(", ");
                            sb5.append("msg=");
                            sb5.append(fastAuthorize$AuthorizeResponse.f342473msg.get());
                            sb5.append(", ");
                            sb5.append("access_token=");
                            sb5.append(fastAuthorize$AuthorizeResponse.access_token.get());
                            sb5.append(", ");
                            sb5.append("expires_in=");
                            str2 = "access_token=";
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
                            QLog.d("AppLaucherHelper", 2, "FastAuthorize.AuthorizeResponse=[" + sb5.toString() + "]");
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            dVar = this;
                            str6 = str6;
                            if (QLog.isColorLevel()) {
                            }
                            Bundle g16 = a.g(a.this.f397001d);
                            if (QLog.isColorLevel()) {
                            }
                            com.tencent.open.business.base.a.t(dVar.f397023i, str6, g16, dVar.f397024m);
                            a.f396996h = false;
                            newIntent = a.this.f396998a;
                            if (newIntent != null) {
                            }
                        }
                    }
                    dVar = this;
                    try {
                        a.this.f396999b.removeMessages(0);
                        a.this.f396999b.removeMessages(1);
                        a.this.f397003f.remove(dVar.f397020e);
                        if (fastAuthorize$AuthorizeResponse.ret.get().equals("0") && fastAuthorize$AuthorizeResponse.apk_name.has()) {
                            if (!fastAuthorize$AuthorizeResponse.access_token.has()) {
                                str3 = "AppLaucherHelper";
                                str4 = "]";
                            } else {
                                String str7 = fastAuthorize$AuthorizeResponse.access_token.get();
                                a aVar = a.this;
                                str3 = "AppLaucherHelper";
                                try {
                                    str4 = "]";
                                    aVar.f397001d = aVar.f397001d.replace("$AT$", str7);
                                } catch (InvalidProtocolBufferMicroException e17) {
                                    e = e17;
                                    str6 = str6;
                                    str5 = str3;
                                    if (QLog.isColorLevel()) {
                                        QLog.d(str5, 2, e.getMessage());
                                    }
                                    Bundle g162 = a.g(a.this.f397001d);
                                    if (QLog.isColorLevel()) {
                                    }
                                    com.tencent.open.business.base.a.t(dVar.f397023i, str6, g162, dVar.f397024m);
                                    a.f396996h = false;
                                    newIntent = a.this.f396998a;
                                    if (newIntent != null) {
                                    }
                                }
                            }
                            try {
                                if (fastAuthorize$AuthorizeResponse.pay_token.has()) {
                                    String str8 = fastAuthorize$AuthorizeResponse.pay_token.get();
                                    a aVar2 = a.this;
                                    aVar2.f397001d = aVar2.f397001d.replace("$PT$", str8);
                                }
                                if (fastAuthorize$AuthorizeResponse.openid.has()) {
                                    String str9 = fastAuthorize$AuthorizeResponse.openid.get();
                                    a aVar3 = a.this;
                                    aVar3.f397001d = aVar3.f397001d.replace("$OPID$", str9);
                                    str5 = str3;
                                } else {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("FastAuthorize.AuthorizeResponse=[");
                                    sb6.append(str + fastAuthorize$AuthorizeResponse.ret.get() + ", msg=" + fastAuthorize$AuthorizeResponse.f342473msg.get() + ", " + str2 + fastAuthorize$AuthorizeResponse.access_token.get() + ", expires_in=" + fastAuthorize$AuthorizeResponse.expires_in.get() + ", openid=" + fastAuthorize$AuthorizeResponse.openid.get() + ", pay_token=" + fastAuthorize$AuthorizeResponse.pay_token.get() + ", pf=" + fastAuthorize$AuthorizeResponse.f342474pf.get() + ", pfkey=" + fastAuthorize$AuthorizeResponse.pfkey.get() + ", encrykey=" + fastAuthorize$AuthorizeResponse.encrykey.get() + ", apk_name=" + fastAuthorize$AuthorizeResponse.apk_name.get() + ", ");
                                    sb6.append(str4);
                                    str5 = str3;
                                    QLog.d(str5, 1, sb6.toString());
                                }
                                if (fastAuthorize$AuthorizeResponse.pfkey.has()) {
                                    String str10 = fastAuthorize$AuthorizeResponse.pfkey.get();
                                    a aVar4 = a.this;
                                    aVar4.f397001d = aVar4.f397001d.replace("$PF$", str10);
                                }
                                if (fastAuthorize$AuthorizeResponse.encrykey.has()) {
                                    String str11 = fastAuthorize$AuthorizeResponse.encrykey.get();
                                    a aVar5 = a.this;
                                    aVar5.f397001d = aVar5.f397001d.replace("$ESK$", str11);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(str5, 2, "mParams=" + a.this.f397001d);
                                }
                                String str12 = fastAuthorize$AuthorizeResponse.apk_name.get();
                                if ("qqgamecenter".equals(dVar.f397021f)) {
                                    if (str12 != null && str12.split(",").length > 1) {
                                        str6 = dVar.f397020e;
                                    } else {
                                        if (!TextUtils.isEmpty(str12) && str12.contains(dVar.f397020e)) {
                                            str6 = str6;
                                        }
                                        a.f396996h = false;
                                        a.this.b(dVar.f397022h, dVar.f397020e, dVar.f397023i, dVar.f397024m);
                                        return;
                                    }
                                } else {
                                    str6 = str12;
                                }
                                try {
                                    if (!TextUtils.isEmpty(str12) && str12.contains(dVar.f397020e)) {
                                        QLog.d(str5, 4, "pkg=" + str6);
                                    }
                                    QLog.d(str5, 2, "from=" + dVar.f397021f + ",pkg=" + str12 + ",packageName=" + dVar.f397020e);
                                    a.f396996h = false;
                                    return;
                                } catch (InvalidProtocolBufferMicroException e18) {
                                    e = e18;
                                    if (QLog.isColorLevel()) {
                                    }
                                    Bundle g1622 = a.g(a.this.f397001d);
                                    if (QLog.isColorLevel()) {
                                    }
                                    com.tencent.open.business.base.a.t(dVar.f397023i, str6, g1622, dVar.f397024m);
                                    a.f396996h = false;
                                    newIntent = a.this.f396998a;
                                    if (newIntent != null) {
                                    }
                                }
                            } catch (InvalidProtocolBufferMicroException e19) {
                                e = e19;
                                str5 = str3;
                                str6 = str6;
                                if (QLog.isColorLevel()) {
                                }
                                Bundle g16222 = a.g(a.this.f397001d);
                                if (QLog.isColorLevel()) {
                                }
                                com.tencent.open.business.base.a.t(dVar.f397023i, str6, g16222, dVar.f397024m);
                                a.f396996h = false;
                                newIntent = a.this.f396998a;
                                if (newIntent != null) {
                                }
                            }
                        } else {
                            QLog.d("AppLaucherHelper", 4, "start without login state");
                            str6 = str6;
                        }
                    } catch (InvalidProtocolBufferMicroException e26) {
                        e = e26;
                    }
                } catch (InvalidProtocolBufferMicroException e27) {
                    e = e27;
                }
            } else {
                QLog.e("AppLaucherHelper", 1, "FastAuthorize.AuthorizeRequest failed");
            }
            Bundle g162222 = a.g(a.this.f397001d);
            if (QLog.isColorLevel()) {
                QLog.d(str5, 2, "lauchApp now ,bundleData:" + g162222);
            }
            com.tencent.open.business.base.a.t(dVar.f397023i, str6, g162222, dVar.f397024m);
            a.f396996h = false;
            newIntent = a.this.f396998a;
            if (newIntent != null) {
                newIntent.setObserver(null);
                a.this.f396998a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements h {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f397025d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f397026e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f397027f;

        e(Context context, String str, int i3) {
            this.f397025d = context;
            this.f397026e = str;
            this.f397027f = i3;
        }

        @Override // nl0.h
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_START_APK);
            return hashSet;
        }

        @Override // nl0.h
        public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
            QLog.i("AppLaucherHelper", 2, "[onTrpcRsp] onTrpcRsp isSucc:" + z16 + ", cmd:" + str + ",trpcRspRetCode:" + i3 + ", trpcRspFuncRetCode:" + i16);
            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).removeListener(this);
            a.f396996h = false;
            a.this.f396999b.removeMessages(0);
            if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_START_APK.equals(str)) {
                if (intent == null) {
                    QLog.e("AppLaucherHelper", 2, "[onTrpcRsp] onTrpcRsp request null.");
                    return;
                }
                if (i16 != 0) {
                    QLog.e("AppLaucherHelper", 2, "[onTrpcRsp] trpcRspFuncRetCode == " + i16 + " ,return.");
                    return;
                }
                if (i3 != 0) {
                    QLog.e("AppLaucherHelper", 2, "[onTrpcRsp] trpcRspRetCode == " + i3 + " ,return.");
                    return;
                }
                if (z16) {
                    try {
                        Bundle g16 = a.g(a.this.f397001d);
                        if (QLog.isColorLevel()) {
                            QLog.d(getClass().getSimpleName(), 2, "[onTrpcRsp] lauchApp now:");
                        }
                        com.tencent.open.business.base.a.t(this.f397025d, this.f397026e, g16, this.f397027f);
                        a.f396996h = false;
                        NewIntent newIntent = a.this.f396998a;
                        if (newIntent != null) {
                            newIntent.setObserver(null);
                            a.this.f396998a = null;
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("AppLaucherHelper", 1, e16, new Object[0]);
                        return;
                    }
                }
                QLog.e("AppLaucherHelper", 2, "[onTrpcRsp] return failed.");
            }
        }
    }

    public static void c() {
        f396997i = "";
    }

    public static Bundle g(String str) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split != null) {
            for (String str2 : split) {
                int indexOf = str2.indexOf(61);
                if (indexOf != -1) {
                    try {
                        bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                    } catch (Exception e16) {
                        QLog.d("AppLaucherHelper", 2, e16.getMessage(), e16);
                    }
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static int h(String str) {
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
        if (str.contains("$ESK$")) {
            return r06 | 128;
        }
        return r06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AppInterface appInterface, Context context, String str, String str2, String str3, String str4, int i3, String str5) {
        long j3;
        QLog.i("AppLaucherHelper", 1, "[startGetLauchKeys] appid:" + str + ", pkgname:" + str3 + "\uff0c from:" + str5);
        d dVar = new d(System.currentTimeMillis(), str3, str5, str, context, i3);
        if (this.f396998a == null) {
            this.f396998a = new NewIntent(context, m.class);
        }
        FastAuthorize$AuthorizeRequest fastAuthorize$AuthorizeRequest = new FastAuthorize$AuthorizeRequest();
        long j16 = 0;
        try {
            j3 = Long.parseLong(appInterface.getCurrentAccountUin());
        } catch (Exception unused) {
            j3 = 0;
        }
        fastAuthorize$AuthorizeRequest.uin.set(j3);
        try {
            j16 = Long.parseLong(str);
        } catch (Exception unused2) {
        }
        fastAuthorize$AuthorizeRequest.client_id.set(j16);
        String str6 = "";
        fastAuthorize$AuthorizeRequest.f342472pf.set("");
        fastAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.business.base.a.f(context));
        fastAuthorize$AuthorizeRequest.sdkp.set("a");
        fastAuthorize$AuthorizeRequest.f342471os.set(Build.DISPLAY);
        fastAuthorize$AuthorizeRequest.skey.set(str4);
        int h16 = h(str2);
        if (h16 == 0) {
            QLog.i("AppLaucherHelper", 1, "[startGetLauchKeys] flag == 0");
            com.tencent.open.business.base.a.t(context, str3, g(this.f397001d), i3);
            f396996h = false;
            return;
        }
        fastAuthorize$AuthorizeRequest.flags.set(h16);
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str3, 64).signatures;
            if (signatureArr != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(signatureArr[0].toByteArray());
                    str6 = HexUtil.bytes2HexStr(messageDigest.digest()).toLowerCase();
                    messageDigest.reset();
                } catch (NoSuchAlgorithmException e16) {
                    e16.printStackTrace();
                }
            }
        } catch (Exception unused3) {
        }
        if (TextUtils.isEmpty(str6)) {
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, "no sign");
            }
            f396996h = false;
            com.tencent.open.business.base.a.t(context, str3, g(this.f397001d), i3);
            return;
        }
        fastAuthorize$AuthorizeRequest.apk_sign.set(str6);
        this.f396998a.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try {
            this.f396998a.putExtra("data", fastAuthorize$AuthorizeRequest.toByteArray());
            this.f396998a.setObserver(dVar);
            appInterface.startServlet(this.f396998a);
            this.f396999b.sendEmptyMessageDelayed(0, 2000L);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, e17.getMessage());
            }
            f396996h = false;
        }
    }

    public void b(String str, String str2, Context context, int i3) {
        QLog.i("AppLaucherHelper", 2, "[checkStartAppByGameCenter] check=>flags:" + i3);
        QQGameCheckDownload$StartApkReq qQGameCheckDownload$StartApkReq = new QQGameCheckDownload$StartApkReq();
        qQGameCheckDownload$StartApkReq.app_id.set(str);
        qQGameCheckDownload$StartApkReq.pkg_name.set(str2);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_START_APK);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(new e(context, str2, i3));
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_START_APK, qQGameCheckDownload$StartApkReq.toByteArray(), bundle);
        this.f396999b.sendEmptyMessageDelayed(0, 2000L);
    }

    public boolean d(AppInterface appInterface, Context context, String str, String str2, String str3, int i3) {
        return e(appInterface, context, str, str2, str3, i3, "");
    }

    public boolean e(AppInterface appInterface, Context context, String str, String str2, String str3, int i3, String str4) {
        if (f396996h) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, "lauchApp");
        }
        f396996h = true;
        if (this.f396999b == null) {
            this.f396999b = new c(Looper.getMainLooper(), context, str3, i3, appInterface, str, str2, str4);
        }
        if (str2.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            this.f397001d = str2.substring(1);
        } else {
            this.f397001d = str2;
        }
        i(appInterface, context, str, str2, str3, "", i3, str4);
        return true;
    }

    public boolean f(String str, Context context, String str2, AppInterface appInterface, String str3, String str4, int i3, String str5) {
        long j3;
        if (f396996h) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
        }
        if (TextUtils.isEmpty(str2) || !AuthorizeConfig.y().h0(str2)) {
            return false;
        }
        f396996h = true;
        if (this.f397000c == null) {
            this.f397000c = new HandlerC10260a();
        }
        Long l3 = 0L;
        try {
            l3 = Long.valueOf(str3);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("appcenter", 2, "parse appid error = " + str3);
            }
        }
        try {
            j3 = Long.valueOf(str5).longValue();
        } catch (Exception unused2) {
            j3 = 1;
        }
        WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
        WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
        WtloginHelper wtloginHelper = new WtloginHelper(appInterface.getApplication().getApplicationContext(), (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
        wtloginHelper.GetA1WithA1(appInterface.getAccount(), 16L, 16L, str4.getBytes(), 1L, l3.longValue(), j3, "5.2".getBytes(), util.getPkgSigFromApkName(context, str4), new WUserSigInfo(), new WFastLoginInfo());
        wtloginHelper.SetListener(new b(str, wtloginHelper, i3, context));
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("source", "AppLaucherHelper");
            QQBeaconReport.report(appInterface.getAccount(), "wtlogin_invalid_init", hashMap);
        } catch (Exception e16) {
            QLog.e("AppLaucherHelper", 1, e16, new Object[0]);
        }
        this.f397000c.sendEmptyMessageDelayed(0, 10000L);
        return true;
    }
}
