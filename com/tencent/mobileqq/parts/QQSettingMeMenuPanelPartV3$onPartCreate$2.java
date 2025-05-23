package com.tencent.mobileqq.parts;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/bean/k;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/activity/qqsettingme/bean/k;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes16.dex */
final class QQSettingMeMenuPanelPartV3$onPartCreate$2 extends Lambda implements Function1<com.tencent.mobileqq.activity.qqsettingme.bean.k, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQSettingMeMenuPanelPartV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeMenuPanelPartV3$onPartCreate$2(QQSettingMeMenuPanelPartV3 qQSettingMeMenuPanelPartV3) {
        super(1);
        this.this$0 = qQSettingMeMenuPanelPartV3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeMenuPanelPartV3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQSettingMeMenuPanelPartV3 this$0, com.tencent.mobileqq.activity.qqsettingme.bean.k kVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9(kVar.b(), kVar.a());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.k kVar) {
        invoke2(kVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final com.tencent.mobileqq.activity.qqsettingme.bean.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            return;
        }
        View partRootView = this.this$0.getPartRootView();
        final QQSettingMeMenuPanelPartV3 qQSettingMeMenuPanelPartV3 = this.this$0;
        partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.v
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeMenuPanelPartV3$onPartCreate$2.b(QQSettingMeMenuPanelPartV3.this, kVar);
            }
        });
    }
}
