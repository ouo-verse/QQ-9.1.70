package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.task.ch;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ch;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ch extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ch$a;", "", "", "b", "d", "f", "e", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.ch$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String str, String qimei36) {
            String upperCase;
            Intrinsics.checkNotNullParameter(qimei36, "qimei36");
            if (TextUtils.isEmpty(qimei36)) {
                upperCase = "";
            } else {
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                upperCase = qimei36.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            }
            ABTestController.getInstance().doInit1504(upperCase);
        }

        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!PrivacyPolicyHelper.isUserAllow()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TabSdkInitTask", 2, "return for user not allow");
                }
            } else {
                com.tencent.mobileqq.statistics.o.e(true);
                com.tencent.mobileqq.statistics.o.d(new o.c() { // from class: com.tencent.mobileqq.startup.task.cg
                    @Override // com.tencent.mobileqq.statistics.o.c
                    public final void a(String str, String str2) {
                        ch.Companion.c(str, str2);
                    }
                });
            }
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                ABTestController.getInstance().doInit1505(ABTestController.getInstance().getLoginAccountUin(), true);
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                ABTestController.getInstance().doInit571(ABTestController.getInstance().getLoginAccountUin(), true);
            }
        }

        public final void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ABTestController.getInstance().doInit8881(ABTestController.getInstance().getLoginAccountUin(), true);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ch() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (1 == MobileQQ.sProcessId) {
            Companion companion = INSTANCE;
            companion.b();
            companion.f();
        }
        Companion companion2 = INSTANCE;
        companion2.d();
        if (9 == MobileQQ.sProcessId) {
            companion2.e();
        }
    }
}
