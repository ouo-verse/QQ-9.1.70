package com.tencent.mobileqq.parts;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
final class QQSettingMeFloatingViewPartV3$onPartCreate$3 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQSettingMeViewModel $model;
    final /* synthetic */ QQSettingMeFloatingViewPartV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeFloatingViewPartV3$onPartCreate$3(QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3, QQSettingMeViewModel qQSettingMeViewModel) {
        super(1);
        this.this$0 = qQSettingMeFloatingViewPartV3;
        this.$model = qQSettingMeViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeFloatingViewPartV3, (Object) qQSettingMeViewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQSettingMeFloatingViewPartV3 this$0, Boolean it, QQSettingMeViewModel qQSettingMeViewModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this$0.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            qQSettingMeFloatingViewV3.setDefaultMarginTop(this$0.W9(it.booleanValue()));
        }
        this$0.ia(Intrinsics.areEqual(Boolean.TRUE, qQSettingMeViewModel.R1().getValue()));
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = this$0.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV32 != null) {
            qQSettingMeFloatingViewV32.C();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            return;
        }
        final QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3 = this.this$0;
        final QQSettingMeViewModel qQSettingMeViewModel = this.$model;
        qQSettingMeFloatingViewPartV3.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.parts.s
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeFloatingViewPartV3$onPartCreate$3.b(QQSettingMeFloatingViewPartV3.this, bool, qQSettingMeViewModel);
            }
        });
    }
}
