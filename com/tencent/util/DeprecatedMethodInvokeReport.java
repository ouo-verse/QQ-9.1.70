package com.tencent.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0002\t\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/util/DeprecatedMethodInvokeReport;", "", "", "module", "method", "extra", "", "c", "", "a", "Z", "reportEnabled", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "methodInvokeRecord", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class DeprecatedMethodInvokeReport {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<DeprecatedMethodInvokeReport> f383940d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean reportEnabled;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> methodInvokeRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/util/DeprecatedMethodInvokeReport$a;", "", "", "module", "method", "extra", "", "b", "Lcom/tencent/util/DeprecatedMethodInvokeReport;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/util/DeprecatedMethodInvokeReport;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "REPORT_EVENT_NAME", "Ljava/lang/String;", "SWITCH_NAME", "TAG", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.util.DeprecatedMethodInvokeReport$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
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

        private final DeprecatedMethodInvokeReport a() {
            return (DeprecatedMethodInvokeReport) DeprecatedMethodInvokeReport.f383940d.getValue();
        }

        @JvmStatic
        public final void b(@NotNull String module, @NotNull String method, @NotNull String extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, module, method, extra);
                return;
            }
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(extra, "extra");
            a().c(module, method, extra);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ(\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/util/DeprecatedMethodInvokeReport$b;", "", "", "chatType", "", "peerUin", QQBrowserActivity.KEY_MSG_TYPE, "msgClass", "a", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f383943a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34713);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f383943a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        @NotNull
        public static final String a(int chatType, @NotNull String peerUin, int msgType, @NotNull String msgClass) {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            Intrinsics.checkNotNullParameter(msgClass, "msgClass");
            return "type:" + chatType + " peerUin:" + peerUin + " msgType:" + msgType + " msgClass:" + msgClass;
        }
    }

    static {
        Lazy<DeprecatedMethodInvokeReport> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(DeprecatedMethodInvokeReport$Companion$instance$2.INSTANCE);
        f383940d = lazy;
    }

    public DeprecatedMethodInvokeReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.reportEnabled = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("method_invoke_report_enabled_9030", true);
            this.methodInvokeRecord = new ConcurrentHashMap<>();
        }
    }

    @JvmStatic
    public static final void d(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.b(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String module, String method, String extra) {
    }
}
