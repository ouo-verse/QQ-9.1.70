package com.tencent.mobileqq.gateway.localphone.ecdh;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gateway.localphone.ecdh.g;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/g;", "", "", "phoneType", "serviceType", "Lne1/a;", "callback", "Landroid/os/Bundle;", "extras", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "extra", "i", "", "f", "k", tl.h.F, "l", "", "b", "[I", "e", "()[I", "loginServiceTypes", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f213618a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final int[] loginServiceTypes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/gateway/localphone/ecdh/g$a", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f213620a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f213621b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f213622c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ne1.a f213623d;

        a(int i3, int i16, long j3, ne1.a aVar) {
            this.f213620a = i3;
            this.f213621b = i16;
            this.f213622c = j3;
            this.f213623d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(int i3, int i16) {
            QQToast.makeText(BaseApplication.getContext(), "\u53d6\u53f7\u5931\u8d25Type:" + i3 + ",Code:" + i16, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(int i3) {
            QQToast.makeText(BaseApplication.getContext(), "\u53d6\u53f7\u6210\u529fType:" + i3, 0).show();
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (g.f213618a.l()) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final int i3 = this.f213620a;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gateway.localphone.ecdh.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a.e(i3);
                    }
                });
            }
            j.f213630a.a("get_local_phone_report", true, this.f213620a, this.f213621b, 0, System.currentTimeMillis() - this.f213622c);
            QLog.d("LocalPhoneComponent", 1, "onSuccess phoneType: " + this.f213621b + " serviceType: " + this.f213620a);
            this.f213623d.a(data);
        }

        @Override // ne1.a
        public void onFail(final int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            if (g.f213618a.l()) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final int i3 = this.f213620a;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gateway.localphone.ecdh.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a.d(i3, errorCode);
                    }
                });
            }
            j.f213630a.a("get_local_phone_report", false, this.f213620a, this.f213621b, errorCode, System.currentTimeMillis() - this.f213622c);
            QLog.e("LocalPhoneComponent", 1, "onFail phoneType: " + this.f213621b + " serviceType: " + this.f213620a + " errCode: " + errorCode);
            this.f213623d.onFail(errorCode, errorMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f213618a = new g();
            loginServiceTypes = new int[]{1, 3, 5, 6, 7, 8, 9, 10};
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean f() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("gateway_check_mobile_network", false)) {
            QLog.d("LocalPhoneComponent", 1, "needCheckNetwork united config switch is close!");
            return false;
        }
        QLog.d("LocalPhoneComponent", 1, "needCheckNetwork switch is open");
        if (k() && h()) {
            return false;
        }
        if (l()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gateway.localphone.ecdh.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.g();
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        QQToast.makeText(BaseApplication.getContext(), "\u53d6\u53f7\u5931\u8d25\uff0c \u79fb\u52a8\u7f51\u7edc\u5f02\u5e38", 0).show();
    }

    private final boolean h() {
        boolean z16;
        Object systemService = BaseApplication.getContext().getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        int simState = ((TelephonyManager) systemService).getSimState();
        if (simState != 0 && simState != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("LocalPhoneComponent", 1, "hasSimCard result : ", Boolean.valueOf(z16));
        return z16;
    }

    private final void i(int phoneType, int serviceType, final ne1.a callback, Bundle extra) {
        QLog.d("LocalPhoneComponent", 1, "start ipcToMainProcess ");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("phone_type", phoneType);
            bundle.putInt("service_type", serviceType);
            if (extra != null) {
                bundle.putAll(extra);
            }
            QIPCClientHelper.getInstance().callServer("LocalPhoneIPCModule", "get_local_phone", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.gateway.localphone.ecdh.d
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    g.j(ne1.a.this, eIPCResult);
                }
            });
        } catch (Exception e16) {
            QLog.e("LocalPhoneComponent", 1, "ipcToMainProcess error: " + e16);
            callback.onFail(-1, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ne1.a callback, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Bundle bundle = eIPCResult.data;
        if (bundle == null) {
            QLog.e("LocalPhoneComponent", 1, "ipcToMainProcess callback failed!!");
            callback.onFail(-1, "IPC to main process failed!!");
            return;
        }
        int i3 = bundle.getInt("ret_code");
        String string = bundle.getString("error_msg");
        if (i3 != 0) {
            callback.onFail(i3, string);
            QLog.e("LocalPhoneComponent", 1, "ipcToMainProcess failed");
            return;
        }
        byte[] byteArray = bundle.getByteArray(GetCMShowInfoServlet.EXTRA_RESULT_DATA);
        GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp = new GetLocalPhone$OIDBGetPhoneRsp();
        getLocalPhone$OIDBGetPhoneRsp.mergeFrom(byteArray);
        QLog.e("LocalPhoneComponent", 1, "ipcToMainProcess success!!!");
        callback.a(getLocalPhone$OIDBGetPhoneRsp);
    }

    private final boolean k() {
        try {
            Object systemService = BaseApplication.getContext().getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Method method = connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(connectivityManager, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e16) {
            QLog.e("LocalPhoneComponent", 1, "getMobileDataEnabled error : ", e16.getMessage());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        return false;
    }

    @JvmStatic
    public static final void m(int phoneType, final int serviceType, @NotNull ne1.a callback, @Nullable Bundle extras) {
        boolean z16;
        boolean contains;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (extras != null) {
            z16 = extras.getBoolean("bool_compare_mibao");
        } else {
            z16 = false;
        }
        QLog.d("LocalPhoneComponent", 1, "startGetPhone phoneType: " + phoneType + " serviceType: " + serviceType + " needCompareMibao: " + z16);
        long currentTimeMillis = System.currentTimeMillis();
        g gVar = f213618a;
        if (gVar.l()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gateway.localphone.ecdh.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.o(serviceType);
                }
            });
        }
        a aVar = new a(serviceType, phoneType, currentTimeMillis, callback);
        if (!TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
            gVar.i(phoneType, serviceType, aVar, extras);
            return;
        }
        if (gVar.f()) {
            callback.onFail(-5, "mobile network invalid!!");
            QLog.d("LocalPhoneComponent", 1, "startGetPhone check network failed");
            j.f213630a.a("get_local_phone_report", false, serviceType, phoneType, -5, System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        QLog.d("LocalPhoneComponent", 4, "startGetPhone extras: " + extras);
        contains = ArraysKt___ArraysKt.contains(loginServiceTypes, serviceType);
        if (contains) {
            gVar.p(phoneType, serviceType, aVar, extras);
        } else {
            gVar.q(phoneType, serviceType, aVar, extras);
        }
    }

    public static /* synthetic */ void n(int i3, int i16, ne1.a aVar, Bundle bundle, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            bundle = null;
        }
        m(i3, i16, aVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(int i3) {
        QQToast.makeText(BaseApplication.getContext(), "\u5f00\u59cb\u53d6\u53f7type:" + i3, 0).show();
    }

    private final void p(int phoneType, int serviceType, ne1.a callback, Bundle extras) {
        QLog.d("LocalPhoneComponent", 1, "startLoginGetPhone ");
        new LocalPhoneLoginModule().k(phoneType, serviceType, callback, extras);
    }

    private final void q(int phoneType, int serviceType, ne1.a callback, Bundle extras) {
        QLog.d("LocalPhoneComponent", 1, "startLogoutGetPhone ");
        new LocalPhoneLogoutModule().k(phoneType, serviceType, callback, extras);
    }

    @NotNull
    public final int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return loginServiceTypes;
    }
}
