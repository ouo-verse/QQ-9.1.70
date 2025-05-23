package com.tencent.qqnt.kernel.msf;

import android.os.Bundle;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine;
import com.tencent.qqnt.kernel.nativeinterface.MsfRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/c;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperEngine;", "d", "Lmqq/util/WeakReference;", "wrapperEngine", "<init>", "(Lmqq/util/WeakReference;)V", "e", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<IQQNTWrapperEngine> wrapperEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017Jn\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0010R\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/c$a;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperEngine;", "wrapper", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "ssoCmd", "", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "transInfoMap", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.msf.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull AppRuntime app, @NotNull IQQNTWrapperEngine wrapper, long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, String> transInfoMap) {
            String str;
            Integer num;
            Integer num2;
            Integer num3;
            Byte b16;
            int i3;
            int i16;
            boolean z16;
            String str2 = traceInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, app, wrapper, Long.valueOf(requestId), ssoCmd, pbBuffer, param, str2, transInfoMap);
                return;
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            String str3 = null;
            if (param != null) {
                str = param.account;
            } else {
                str = null;
            }
            if (param != null) {
                num = Integer.valueOf(param.accountType);
            } else {
                num = null;
            }
            QLog.d("KernelECDHObserver", 1, "SendToServer cmd: " + ssoCmd + ", traceId: " + str2 + ", tmpUin:" + str + ", uinType: " + num);
            NewIntent newIntent = new NewIntent(app.getApplicationContext(), d.class);
            newIntent.withouLogin = true;
            newIntent.putExtra("cmd", ssoCmd);
            newIntent.putExtra("data", pbBuffer);
            newIntent.putExtra("type", 1);
            newIntent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, requestId);
            newIntent.putExtra("trans_info", transInfoMap);
            if (str2 != null) {
                if (traceInfo.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    str2 = null;
                }
                if (str2 != null) {
                    newIntent.putExtra("trace_info", str2);
                }
            }
            newIntent.setObserver(new c(new WeakReference(wrapper)));
            if (param != null) {
                num2 = Integer.valueOf(param.sendOptions);
            } else {
                num2 = null;
            }
            if (num2 != null && (num2.intValue() & 1) != 0 && !AppNetConnInfo.isNetSupport()) {
                newIntent.putExtra("result", -101);
                newIntent.putExtra("data_error_msg", "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
                newIntent.getObserver().onReceive(1, false, newIntent.getExtras());
                return;
            }
            if (num2 != null && (num2.intValue() & 2) != 0) {
                newIntent.putExtra("extra_send_without_resend", true);
            }
            if (num2 != null && (num2.intValue() & 4) != 0) {
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
                    KLog.i(KLog.f359087a, "KernelSendObserver", new Object[]{"ssoCmd: " + ssoCmd + " sendTimeout: " + i17}, null, 4, null);
                }
                newIntent.putExtra("resend_num", param.resendNum);
            }
            if (param != null) {
                num3 = Integer.valueOf(param.reqTargetAccountType);
            } else {
                num3 = null;
            }
            newIntent.putExtra("req_target_account_type", num3);
            if (param != null) {
                b16 = Byte.valueOf((byte) param.accountType);
            } else {
                b16 = null;
            }
            newIntent.putExtra("extra_uin_type", b16);
            if (param != null) {
                str3 = param.account;
            }
            newIntent.putExtra("extra_uin", str3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull WeakReference<IQQNTWrapperEngine> wrapperEngine) {
        Intrinsics.checkNotNullParameter(wrapperEngine, "wrapperEngine");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrapperEngine);
        } else {
            this.wrapperEngine = wrapperEngine;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // mqq.observer.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
        MsfRspInfo msfRspInfo;
        IQQNTWrapperEngine iQQNTWrapperEngine;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
            return;
        }
        QLog.d("KernelECDHObserver", 1, "send ECDH onReceive isSuccess: " + isSuccess);
        if (bundle != null) {
            String string = bundle.getString("cmd");
            long j3 = bundle.getLong(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0L);
            int i3 = bundle.getInt("result");
            int i16 = bundle.getInt("trpc_result");
            int i17 = bundle.getInt("trpc_func_result");
            String string2 = bundle.getString("data_error_msg", "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            byte[] byteArray = bundle.getByteArray("bytes_bodybuffer");
            if (byteArray == null) {
                byteArray = new byte[0];
            }
            byte[] bArr = byteArray;
            Intrinsics.checkNotNullExpressionValue(bArr, "bundle.getByteArray(KSer\u2026DYBUFFER) ?: ByteArray(0)");
            Serializable serializable = bundle.getSerializable("trans_info");
            MsfRspInfo msfRspInfo2 = new MsfRspInfo(i3, i16, i17, string2, bArr, new HashMap());
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
                        msfRspInfo = new MsfRspInfo(i3, i16, i17, string2, bArr, hashMap);
                        KLog.i(KLog.f359087a, "KernelECDHObserver", new Object[]{"onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(j3)), TuplesKt.to("ssoCmd", string), TuplesKt.to("isSuccess", Boolean.valueOf(isSuccess)), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errorMsg", string2)}, null, 4, null);
                        iQQNTWrapperEngine = this.wrapperEngine.get();
                        if (iQQNTWrapperEngine == null) {
                            iQQNTWrapperEngine.onSendSSOReply(j3, string, i3, string2, msfRspInfo);
                            return;
                        }
                        return;
                    }
                }
            }
            msfRspInfo = msfRspInfo2;
            KLog.i(KLog.f359087a, "KernelECDHObserver", new Object[]{"onReceive", TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, Long.valueOf(j3)), TuplesKt.to("ssoCmd", string), TuplesKt.to("isSuccess", Boolean.valueOf(isSuccess)), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errorMsg", string2)}, null, 4, null);
            iQQNTWrapperEngine = this.wrapperEngine.get();
            if (iQQNTWrapperEngine == null) {
            }
        }
    }
}
