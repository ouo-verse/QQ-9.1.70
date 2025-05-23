package com.tencent.qqnt.aio.adapter.toppopup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class TroopOnlineMemberPopupView$mContent$2 extends Lambda implements Function0<FrameLayout> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopOnlineMemberPopupView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopOnlineMemberPopupView$mContent$2(TroopOnlineMemberPopupView troopOnlineMemberPopupView) {
        super(0);
        this.this$0 = troopOnlineMemberPopupView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopOnlineMemberPopupView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final FrameLayout invoke() {
        Context context;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        context = this.this$0.mContext;
        View view2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        TroopOnlineMemberPopupView troopOnlineMemberPopupView = this.this$0;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, x.a(112.0f)));
        frameLayout.setBackgroundColor(-1);
        view = troopOnlineMemberPopupView.mPrompt;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrompt");
        } else {
            view2 = view;
        }
        frameLayout.addView(view2);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.toppopup.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TroopOnlineMemberPopupView$mContent$2.b(view3);
            }
        });
        return frameLayout;
    }
}
