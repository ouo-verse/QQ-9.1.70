package com.tencent.mobileqq.takedown;

import androidx.annotation.Keep;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.takedown.config.TakeDownConfigManager;
import com.tencent.mobileqq.takedown.exception.TakeDownException;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/takedown/MethodHandler;", "Lrf0/a;", "", PushClientConstants.TAG_CLASS_NAME, "methodName", "args", "returnType", "", "successVisitorMethod", "", "checkExecutionMethod", "checkExecutionMethodThrow", "<init>", "()V", "Companion", "a", "code_takedown_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MethodHandler implements rf0.a {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    private static final String METHOD_REPORT_KEY = "method_use_report";

    @Deprecated
    @NotNull
    public static final String TAG = "MethodHandler";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/takedown/MethodHandler$a;", "", "", "METHOD_REPORT_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "code_takedown_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            Companion = new a(null);
        }
    }

    public MethodHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void successVisitorMethod$lambda$1(String className, String methodName, String args, String returnType) {
        Intrinsics.checkNotNullParameter(className, "$className");
        Intrinsics.checkNotNullParameter(methodName, "$methodName");
        Intrinsics.checkNotNullParameter(args, "$args");
        Intrinsics.checkNotNullParameter(returnType, "$returnType");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("method", className + '#' + methodName + '#' + args + '#' + returnType);
        Unit unit = Unit.INSTANCE;
        QQBeaconReport.report(currentUin, METHOD_REPORT_KEY, linkedHashMap);
    }

    @Override // rf0.a
    public boolean checkExecutionMethod(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, className, methodName, args, returnType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "checkExecutionMethod " + className + ':' + methodName + ':' + args + ':' + returnType);
        }
        return !TakeDownConfigManager.f291393a.b(className, methodName, args, returnType);
    }

    @Override // rf0.a
    public void checkExecutionMethodThrow(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, className, methodName, args, returnType);
            return;
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "checkExecutionMethodThrow " + className + ':' + methodName + ':' + args + ':' + returnType);
        }
        if (!TakeDownConfigManager.f291393a.b(className, methodName, args, returnType)) {
        } else {
            throw new TakeDownException(className, methodName, args, returnType, "this method is Used!!");
        }
    }

    @Override // rf0.a
    public void successVisitorMethod(@NotNull final String className, @NotNull final String methodName, @NotNull final String args, @NotNull final String returnType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, className, methodName, args, returnType);
            return;
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.takedown.a
            @Override // java.lang.Runnable
            public final void run() {
                MethodHandler.successVisitorMethod$lambda$1(className, methodName, args, returnType);
            }
        }, 16, null, true);
    }
}
