package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.bubble.CustomBubbleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/c;", "", "Landroid/view/View;", "anchorView", "Lar4/a;", "data", "Lcom/tencent/mobileqq/widget/tip/a;", "a", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d;", "b", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f272913a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f272913a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.widget.tip.a a(@NotNull View anchorView, @NotNull ar4.a data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.tip.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) anchorView, (Object) data);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.widget.tip.a bubbleTip = com.tencent.mobileqq.widget.tip.a.r(anchorView.getContext()).q0(14.0f).j0(10.0f, 8.0f, 10.0f, 8.0f).S(anchorView).o0(data.f26812c).k0(0).R(0);
        String str = data.f26813d;
        Intrinsics.checkNotNullExpressionValue(str, "data.avatar");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(data.f26813d, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(data.avatar, options)");
            bubbleTip.U(new Drawable[]{drawable});
        }
        int i3 = data.f26818i;
        if (i3 != 0) {
            if (i3 != 1) {
                bubbleTip.p0(-1);
                bubbleTip.W(Color.parseColor("#0099FF"));
            } else {
                bubbleTip.p0(-16777216);
                bubbleTip.W(-1);
                bubbleTip.e0(true);
            }
        } else {
            bubbleTip.p0(-1);
            bubbleTip.W(Color.parseColor("#B2000000"));
        }
        bubbleTip.b0(data.f26816g * 1000);
        Intrinsics.checkNotNullExpressionValue(bubbleTip, "bubbleTip");
        return bubbleTip;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.widget.bubble.d b(@NotNull View anchorView, @NotNull ar4.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.widget.bubble.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) anchorView, (Object) data);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(data, "data");
        Context context = anchorView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "anchorView.context");
        CustomBubbleView customBubbleView = new CustomBubbleView(context, null, 2, null);
        customBubbleView.setLeftDrawable(customBubbleView.getContext().getDrawable(R.drawable.nnq));
        String str = data.f26812c;
        Intrinsics.checkNotNullExpressionValue(str, "data.tips");
        customBubbleView.setTipsText(str);
        String str2 = data.f26814e.f26819a;
        Intrinsics.checkNotNullExpressionValue(str2, "data.clickBttn.tips");
        customBubbleView.setBtnText(str2);
        return new com.tencent.mobileqq.qqlive.widget.bubble.d().g(anchorView).h(customBubbleView).j(data.f26816g * 1000);
    }
}
