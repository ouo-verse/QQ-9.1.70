package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aio.widget.textView.view.AioTextView;
import com.tencent.guild.aio.input.at.hashtag.ui.l;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/click/a;", "Lcom/tencent/aio/widget/textView/view/b;", "Landroid/view/View;", "view", "Landroid/text/Spanned;", "spannable", "Landroid/view/MotionEvent;", "event", "", "e", "Landroid/widget/TextView;", "textView", "Landroid/text/Spannable;", "", "onTouchEvent", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "d", "a", "c", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends com.tencent.aio.widget.textView.view.b {
    private final Object e(View view, Spanned spannable, MotionEvent event) {
        if (view instanceof AioTextView) {
            return ((AioTextView) view).n((int) event.getX(), (int) event.getY(), ClickableSpan.class);
        }
        if ((view instanceof TextView) && spannable != null) {
            return l.f110969a.b((TextView) view, spannable, event);
        }
        return null;
    }

    @Override // com.tencent.aio.widget.textView.view.b
    public boolean a(@NotNull View view, @Nullable Layout layout, @Nullable Spanned spannable, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Logger.f235387a.d().i("GestureMovementMethod", 1, "onDoubleTap action:" + event.getAction());
        return true;
    }

    @Override // com.tencent.aio.widget.textView.view.b
    public boolean b(@NotNull View view, @Nullable Layout layout, @Nullable Spanned spannable, @NotNull MotionEvent event) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Object e16 = e(view, spannable, event);
        if (e16 instanceof com.tencent.mobileqq.guild.feed.a) {
            return ((com.tencent.mobileqq.guild.feed.a) e16).a(view);
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            return viewGroup.performClick();
        }
        return false;
    }

    @Override // com.tencent.aio.widget.textView.view.b
    public boolean c(@NotNull View view, @Nullable Layout layout, @Nullable Spanned spannable, @NotNull MotionEvent event) {
        ViewGroup viewGroup;
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Object e16 = e(view, spannable, event);
        if (e16 instanceof ClickableSpan) {
            ((ClickableSpan) e16).onClick(view);
            z16 = true;
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                z16 = viewGroup.performClick();
            } else {
                z16 = false;
            }
        }
        Logger.f235387a.d().i("GestureMovementMethod", 1, "onSingleTapConfirmed result:" + z16);
        return z16;
    }

    @Override // com.tencent.aio.widget.textView.view.b
    public boolean d(@NotNull View view, @Nullable Layout layout, @Nullable Spanned spannable, @NotNull MotionEvent event) {
        AioTextView aioTextView;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        AioTextView aioTextView2 = null;
        if (view instanceof AioTextView) {
            aioTextView = (AioTextView) view;
        } else {
            aioTextView = null;
        }
        if (aioTextView == null) {
            return false;
        }
        boolean z16 = true;
        if (event.getAction() != 1 && event.getAction() != 0) {
            z16 = false;
        }
        if (z16) {
            aioTextView2 = aioTextView;
        }
        if (aioTextView2 == null) {
            return false;
        }
        return aioTextView2.n((int) event.getX(), (int) event.getY(), ClickableSpan.class) instanceof ClickableSpan;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(@Nullable TextView textView, @Nullable Spannable spannable, @Nullable MotionEvent event) {
        if (textView != null && spannable != null && event != null) {
            if (event.getAction() != 1 && event.getAction() != 0) {
                return super.onTouchEvent(textView, spannable, event);
            }
            if (l.f110969a.b(textView, spannable, event) != null) {
                return true;
            }
            return false;
        }
        return super.onTouchEvent(textView, spannable, event);
    }
}
