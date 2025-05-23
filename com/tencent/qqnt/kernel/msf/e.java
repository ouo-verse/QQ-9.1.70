package com.tencent.qqnt.kernel.msf;

import android.os.Bundle;
import com.tencent.mobileqq.injector.w;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.MsfRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u001c\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/e;", "Lmqq/observer/BusinessObserver;", "", "a", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "onReceive", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "d", "Lmqq/util/WeakReference;", "getWrapperSession", "()Lmqq/util/WeakReference;", "setWrapperSession", "(Lmqq/util/WeakReference;)V", "wrapperSession", "Ldx3/e;", "e", "Ldx3/e;", "getSPackageReceiverModule", "()Ldx3/e;", "setSPackageReceiverModule", "(Ldx3/e;)V", "sPackageReceiverModule", "<init>", "f", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList f359154h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<IQQNTWrapperSession> wrapperSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_PackageReceiverModule.yml", version = 1)
    @Nullable
    private dx3.e sPackageReceiverModule;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJn\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0010J~\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/e$a;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", SessionDbHelper.SESSION_ID, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "ssoCmd", "", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "transInfoMap", "", "b", "", "oidbCmd", "serviceType", "version", "a", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.msf.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull AppRuntime app, @NotNull IQQNTWrapperSession session, long requestId, int oidbCmd, int serviceType, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap, @Nullable String version) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, app, session, Long.valueOf(requestId), Integer.valueOf(oidbCmd), Integer.valueOf(serviceType), pbBuffer, param, traceInfo, transInfoMap, version);
                return;
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(session, "session");
            QLog.d("KernelSendObserver", 1, "KSC: SendToServer oidb cmd: " + oidbCmd);
            g gVar = g.f359158a;
            String currentUin = app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            g.e(gVar, currentUin, null, String.valueOf(oidbCmd), 2, null);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(oidbCmd);
            oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(pbBuffer));
            oidb_sso_oidbssopkg.str_client_version.set(version);
            NewIntent newIntent = new NewIntent(app.getApplicationContext(), f.class);
            newIntent.putExtra("cmd", "OidbSvcTrpcTcp.0x" + oidbCmd + "_" + serviceType);
            newIntent.putExtra("cmd_int", oidbCmd);
            newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
            newIntent.putExtra("type", 0);
            newIntent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, requestId);
            if (traceInfo != null) {
                String str = traceInfo.length() > 0 ? traceInfo : null;
                if (str != null) {
                    newIntent.putExtra("trace_info", str);
                }
            }
            if (transInfoMap != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, byte[]> entry : transInfoMap.entrySet()) {
                    hashMap.put(entry.getKey(), new String(entry.getValue(), Charsets.UTF_8));
                }
                newIntent.putExtra("trans_info", hashMap);
            }
            newIntent.setObserver(new e(new WeakReference(session)));
            Integer valueOf = param != null ? Integer.valueOf(param.sendOptions) : null;
            if (valueOf != null && (valueOf.intValue() & 1) != 0 && !AppNetConnInfo.isNetSupport()) {
                QLog.d("KernelSendObserver", 1, "KSC: doOnSendOidbRequest but network err, cmd: " + oidbCmd);
                newIntent.putExtra("result", -101);
                newIntent.putExtra("data_error_msg", "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
                newIntent.getObserver().onReceive(0, false, newIntent.getExtras());
                return;
            }
            if (param != null && (param.sendTimeout != 0 || param.sendTimeoutOnSlowNet != 0)) {
                if (AppNetConnInfo.isWifiConn()) {
                    i3 = param.resendNum + 1;
                    i16 = param.sendTimeout;
                } else {
                    i3 = param.resendNum + 1;
                    i16 = param.sendTimeoutOnSlowNet;
                }
                int i17 = i3 * i16;
                if (i17 > 0) {
                    newIntent.putExtra("timeout", i17);
                    KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"oidbCmd: " + oidbCmd + " sendTimeout: " + i17}, null, 4, null);
                }
                newIntent.putExtra("resend_num", param.resendNum);
            }
            newIntent.putExtra("req_target_account_type", param != null ? Integer.valueOf(param.reqTargetAccountType) : null);
            app.startServlet(newIntent);
        }

        public final void b(@NotNull AppRuntime app, @NotNull IQQNTWrapperSession session, long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap) {
            Integer num;
            int i3;
            int i16;
            boolean z16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, app, session, Long.valueOf(requestId), ssoCmd, pbBuffer, param, traceInfo, transInfoMap);
                return;
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(session, "session");
            QLog.d("KernelSendObserver", 1, "KSC: SendToServer sso cmd: " + ssoCmd);
            g gVar = g.f359158a;
            String currentUin = app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            g.e(gVar, currentUin, ssoCmd, null, 4, null);
            NewIntent newIntent = new NewIntent(app.getApplicationContext(), f.class);
            newIntent.putExtra("cmd", ssoCmd);
            newIntent.putExtra("data", pbBuffer);
            newIntent.putExtra("type", 1);
            newIntent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, requestId);
            if (transInfoMap != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, byte[]> entry : transInfoMap.entrySet()) {
                    hashMap.put(entry.getKey(), new String(entry.getValue(), Charsets.UTF_8));
                }
                newIntent.putExtra("trans_info", hashMap);
            }
            Integer num2 = null;
            if (traceInfo != null) {
                if (traceInfo.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str = traceInfo;
                } else {
                    str = null;
                }
                if (str != null) {
                    newIntent.putExtra("trace_info", str);
                }
            }
            newIntent.setObserver(new e(new WeakReference(session)));
            if (param != null) {
                num = Integer.valueOf(param.sendOptions);
            } else {
                num = null;
            }
            if (num != null && (num.intValue() & 1) != 0 && !AppNetConnInfo.isNetSupport()) {
                QLog.d("KernelSendObserver", 1, "KSC: doOnSendSSORequest but network err, cmd: " + ssoCmd);
                newIntent.putExtra("result", -101);
                newIntent.putExtra("data_error_msg", "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
                newIntent.getObserver().onReceive(1, false, newIntent.getExtras());
                return;
            }
            if (num != null && (num.intValue() & 2) != 0) {
                newIntent.putExtra("extra_send_without_resend", true);
            }
            if (num != null && (num.intValue() & 4) != 0) {
                newIntent.putExtra("extra_no_need_answer", true);
            }
            if (param != null && (param.sendTimeout != 0 || param.sendTimeoutOnSlowNet != 0)) {
                if (AppNetConnInfo.isWifiConn()) {
                    i3 = param.resendNum + 1;
                    i16 = param.sendTimeout;
                } else {
                    i3 = param.resendNum + 1;
                    i16 = param.sendTimeoutOnSlowNet;
                }
                int i17 = i3 * i16;
                if (i17 > 0) {
                    newIntent.putExtra("timeout", i17);
                    KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"KSC: ssoCmd: " + ssoCmd + " sendTimeout: " + i17}, null, 4, null);
                }
                newIntent.putExtra("resend_num", param.resendNum);
            }
            if (param != null) {
                num2 = Integer.valueOf(param.reqTargetAccountType);
            }
            newIntent.putExtra("req_target_account_type", num2);
            app.startServlet(newIntent);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f359154h = arrayList;
        arrayList.add(w.class);
        INSTANCE = new Companion(null);
    }

    public e(@NotNull WeakReference<IQQNTWrapperSession> wrapperSession) {
        Intrinsics.checkNotNullParameter(wrapperSession, "wrapperSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrapperSession);
        } else {
            this.wrapperSession = wrapperSession;
            a();
        }
    }

    @QAutoInitMethod
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.sPackageReceiverModule = (dx3.e) com.tencent.mobileqq.qroute.utils.b.a(f359154h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0206  */
    @Override // mqq.observer.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(int type, boolean isSuccess, @NotNull Bundle bundle) {
        String str;
        Object obj;
        MsfRspInfo msfRspInfo;
        boolean z16;
        boolean z17;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        long j3 = bundle.getLong(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0L);
        int i3 = bundle.getInt("result");
        int i16 = bundle.getInt("trpc_result");
        int i17 = bundle.getInt("trpc_func_result");
        String errorMsg = bundle.getString("data_error_msg", "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
        KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"KSC: onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(j3)), TuplesKt.to("isSuccess", Boolean.valueOf(isSuccess)), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errorMsg", errorMsg)}, null, 4, null);
        dx3.e eVar = this.sPackageReceiverModule;
        if (eVar != null) {
            if (eVar != null) {
                Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                str = errorMsg;
                obj = "result";
                eVar.a(j3, type, i3, errorMsg, isSuccess, bundle);
                unit = Unit.INSTANCE;
            } else {
                str = errorMsg;
                obj = "result";
                unit = null;
            }
            if (unit != null) {
                return;
            }
        } else {
            str = errorMsg;
            obj = "result";
        }
        byte[] byteArray = bundle.getByteArray("bytes_bodybuffer");
        if (byteArray == null) {
            byteArray = new byte[0];
        }
        byte[] bArr = byteArray;
        Intrinsics.checkNotNullExpressionValue(bArr, "bundle.getByteArray(KSer\u2026DYBUFFER) ?: ByteArray(0)");
        Serializable serializable = bundle.getSerializable("trans_info");
        MsfRspInfo msfRspInfo2 = new MsfRspInfo(i3, i16, i17, str, bArr, new HashMap());
        if (serializable != null && (serializable instanceof HashMap)) {
            HashMap hashMap = (HashMap) serializable;
            Set keySet = hashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "transInfo.keys");
            if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                Iterator it = keySet.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof String)) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16) {
                Collection values = hashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "transInfo.values");
                Collection collection = values;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator it5 = collection.iterator();
                    while (it5.hasNext()) {
                        if (!(it5.next() instanceof byte[])) {
                            z17 = false;
                            break;
                        }
                    }
                }
                z17 = true;
                if (z17) {
                    msfRspInfo = new MsfRspInfo(i3, i16, i17, str, bArr, hashMap);
                    if (bundle.getInt("type", 0) != 0) {
                        int i18 = bundle.getInt("cmd_int", 0);
                        String str2 = str;
                        KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"KSC: onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(j3)), TuplesKt.to("cmd", Integer.valueOf(i18)), TuplesKt.to("isSuccess", Boolean.valueOf(isSuccess)), TuplesKt.to(obj, Integer.valueOf(i3)), TuplesKt.to("errorMsg", str2)}, null, 4, null);
                        g gVar = g.f359158a;
                        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
                        g.c(gVar, currentUin, null, String.valueOf(i18), 2, null);
                        IQQNTWrapperSession iQQNTWrapperSession = this.wrapperSession.get();
                        if (iQQNTWrapperSession != null) {
                            iQQNTWrapperSession.onSendOidbReply(j3, i18, i3, str2, msfRspInfo);
                            return;
                        }
                        return;
                    }
                    String str3 = str;
                    String string = bundle.getString("cmd");
                    KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"KSC: onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(j3)), TuplesKt.to("ssoCmd", string), TuplesKt.to("isSuccess", Boolean.valueOf(isSuccess)), TuplesKt.to(obj, Integer.valueOf(i3)), TuplesKt.to("errorMsg", str3)}, null, 4, null);
                    g gVar2 = g.f359158a;
                    String currentUin2 = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                    Intrinsics.checkNotNullExpressionValue(currentUin2, "sMobileQQ.peekAppRuntime().currentUin");
                    g.c(gVar2, currentUin2, string, null, 4, null);
                    IQQNTWrapperSession iQQNTWrapperSession2 = this.wrapperSession.get();
                    if (iQQNTWrapperSession2 != null) {
                        iQQNTWrapperSession2.onSendSSOReply(j3, string, i3, str3, msfRspInfo);
                        return;
                    }
                    return;
                }
            }
        }
        msfRspInfo = msfRspInfo2;
        if (bundle.getInt("type", 0) != 0) {
        }
    }
}
