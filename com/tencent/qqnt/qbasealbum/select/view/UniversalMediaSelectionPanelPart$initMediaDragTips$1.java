package com.tencent.qqnt.qbasealbum.select.view;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class UniversalMediaSelectionPanelPart$initMediaDragTips$1 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ UniversalMediaSelectionPanelPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalMediaSelectionPanelPart$initMediaDragTips$1(UniversalMediaSelectionPanelPart universalMediaSelectionPanelPart) {
        super(1);
        this.this$0 = universalMediaSelectionPanelPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) universalMediaSelectionPanelPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        view.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            return;
        }
        final View findViewById = this.this$0.getPartRootView().findViewById(R.id.yzc);
        findViewById.setVisibility(0);
        findViewById.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.select.view.m
            @Override // java.lang.Runnable
            public final void run() {
                UniversalMediaSelectionPanelPart$initMediaDragTips$1.b(findViewById);
            }
        }, 3000L);
    }
}
