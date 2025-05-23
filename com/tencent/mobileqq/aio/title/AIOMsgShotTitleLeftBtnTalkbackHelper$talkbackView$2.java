package com.tencent.mobileqq.aio.title;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOMsgShotTitleLeftBtnTalkbackHelper$talkbackView$2 extends Lambda implements Function0<View> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOMsgShotTitleLeftBtnTalkbackHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgShotTitleLeftBtnTalkbackHelper$talkbackView$2(AIOMsgShotTitleLeftBtnTalkbackHelper aIOMsgShotTitleLeftBtnTalkbackHelper) {
        super(0);
        this.this$0 = aIOMsgShotTitleLeftBtnTalkbackHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgShotTitleLeftBtnTalkbackHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOMsgShotTitleLeftBtnTalkbackHelper this$0, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClickListener = this$0.onClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final View invoke() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        view = this.this$0.leftBtn;
        View view9 = new View(view.getContext());
        final AIOMsgShotTitleLeftBtnTalkbackHelper aIOMsgShotTitleLeftBtnTalkbackHelper = this.this$0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        view2 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        layoutParams.addRule(5, view2.getId());
        view3 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        layoutParams.addRule(6, view3.getId());
        view4 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        layoutParams.addRule(8, view4.getId());
        view5 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        layoutParams.addRule(7, view5.getId());
        view9.setLayoutParams(layoutParams);
        view6 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        ViewParent parent = view6.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.addView(view9);
        }
        view9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view10) {
                AIOMsgShotTitleLeftBtnTalkbackHelper$talkbackView$2.b(AIOMsgShotTitleLeftBtnTalkbackHelper.this, view10);
            }
        });
        view7 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        ViewCompat.setImportantForAccessibility(view7, 2);
        view8 = aIOMsgShotTitleLeftBtnTalkbackHelper.leftBtn;
        AccessibilityUtil.c(view9, view8.getContext().getString(R.string.f170549u3), Button.class.getName());
        return view9;
    }
}
