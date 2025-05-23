package com.tencent.mobileqq.parts;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.quiblurview.QQBlurView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QQSettingMeProfileMaskPartV3$runnable$2 extends Lambda implements Function0<Runnable> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQSettingMeProfileMaskPartV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeProfileMaskPartV3$runnable$2(QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3) {
        super(0);
        this.this$0 = qQSettingMeProfileMaskPartV3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeProfileMaskPartV3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQSettingMeProfileMaskPartV3 this$0) {
        QQBlurView qQBlurView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        qQBlurView = this$0.blurView;
        if (qQBlurView != null) {
            qQBlurView.onPause();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Runnable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3 = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.parts.as
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileMaskPartV3$runnable$2.b(QQSettingMeProfileMaskPartV3.this);
            }
        };
    }
}
