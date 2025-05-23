package com.tencent.mobileqq.app.automator;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018J\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/app/automator/DefaultAutomator;", "Lcom/tencent/mobileqq/app/automator/AbsAutomator;", "Lcom/tencent/mobileqq/app/automator/b;", "automator", "", "steps", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "S1", "", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getTag", "G", "Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/app/automator/d;", "H", "Lcom/tencent/mobileqq/app/automator/d;", "stepCreator", "Lcom/tencent/mobileqq/app/automator/f;", "I", "Lcom/tencent/mobileqq/app/automator/f;", "traceCallback", "J", "a", "QAutomator_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DefaultAutomator extends AbsAutomator {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final d stepCreator;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final f traceCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/automator/DefaultAutomator$a;", "", "", "MAX_RUNNING", "I", "<init>", "()V", "QAutomator_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.DefaultAutomator$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.traceCallback.Q();
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.traceCallback.S();
    }

    @Override // com.tencent.mobileqq.app.automator.d
    @NotNull
    public AsyncStep<?> S1(@NotNull b automator, @Nullable String steps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 2, (Object) this, (Object) automator, (Object) steps);
        }
        Intrinsics.checkNotNullParameter(automator, "automator");
        AsyncStep<?> S1 = this.stepCreator.S1(this, steps);
        Intrinsics.checkNotNullExpressionValue(S1, "stepCreator.createStep(this, steps)");
        return S1;
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, com.tencent.mobileqq.app.automator.b
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.tag;
    }
}
