package com.tencent.mobileqq.aio.reserve1.unreadbubble;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class UnreadBubbleVB$unreadText$2 extends Lambda implements Function0<TextView> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ UnreadBubbleVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnreadBubbleVB$unreadText$2(UnreadBubbleVB unreadBubbleVB) {
        super(0);
        this.this$0 = unreadBubbleVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) unreadBubbleVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UnreadBubbleVB this$0, TextView this_apply, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        z16 = this$0.mShowArrow;
        a.C7352a c7352a = new a.C7352a(z16, false, 2, null);
        this$0.sendIntent(c7352a);
        if (!c7352a.b()) {
            this_apply.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TextView invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        DisplayMetrics displayMetrics = this.this$0.getMContext().getResources().getDisplayMetrics();
        final TextView textView = new TextView(this.this$0.getMContext());
        final UnreadBubbleVB unreadBubbleVB = this.this$0;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.bottomToBottom = R.id.slg;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
        layoutParams.setMarginEnd((int) TypedValue.applyDimension(1, 10.0f, displayMetrics));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(0, TypedValue.applyDimension(2, 16.0f, displayMetrics));
        textView.setSingleLine(true);
        textView.setTextColor(unreadBubbleVB.getMContext().getColor(R.color.f158017al3));
        textView.setId(R.id.f114346t3);
        textView.setGravity(1);
        textView.setVisibility(8);
        textView.setPadding(0, (int) TypedValue.applyDimension(1, 2.0f, displayMetrics), 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.reserve1.unreadbubble.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnreadBubbleVB$unreadText$2.b(UnreadBubbleVB.this, textView, view);
            }
        });
        return textView;
    }
}
