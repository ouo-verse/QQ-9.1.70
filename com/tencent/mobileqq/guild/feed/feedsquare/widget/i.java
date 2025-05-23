package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aio.widget.textView.view.AioTextView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000*\n\u0010\u0004\"\u00020\u00032\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lwq0/l;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/m;", "b", "Landroid/view/MotionEvent;", "LongClickEvent", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {
    @NotNull
    public static final m b(@NotNull final wq0.l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return new m() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.h
            @Override // com.tencent.mobileqq.guild.feed.feedsquare.widget.m
            public final boolean a(MotionEvent motionEvent) {
                boolean c16;
                c16 = i.c(wq0.l.this, motionEvent);
                return c16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.text.style.ClickableSpan[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v12 */
    public static final boolean c(wq0.l this_createLongClickEventProcessor, MotionEvent event) {
        AioTextView aioTextView;
        Spannable spannable;
        boolean z16;
        Intrinsics.checkNotNullParameter(this_createLongClickEventProcessor, "$this_createLongClickEventProcessor");
        Intrinsics.checkNotNullParameter(event, "event");
        View view = this_createLongClickEventProcessor.getView();
        com.tencent.mobileqq.guild.feed.a aVar = null;
        if (view instanceof AioTextView) {
            aioTextView = (AioTextView) view;
        } else {
            aioTextView = null;
        }
        if (aioTextView == null) {
            return false;
        }
        CharSequence text = this_createLongClickEventProcessor.getText();
        if (text instanceof Spannable) {
            spannable = (Spannable) text;
        } else {
            spannable = null;
        }
        if (spannable == null) {
            return false;
        }
        com.tencent.guild.aio.input.at.hashtag.ui.l lVar = com.tencent.guild.aio.input.at.hashtag.ui.l.f110969a;
        Rect rect = new Rect();
        if (aioTextView.getGlobalVisibleRect(rect) && rect.contains((int) event.getRawX(), (int) event.getRawY())) {
            int rawX = (int) (event.getRawX() - rect.left);
            int rawY = (int) (event.getRawY() - rect.top);
            int paddingLeft = rawX - aioTextView.getPaddingLeft();
            int paddingTop = rawY - aioTextView.getPaddingTop();
            int scrollX = paddingLeft + aioTextView.getScrollX();
            int scrollY = paddingTop + aioTextView.getScrollY();
            Layout i3 = aioTextView.i();
            if (i3 != null) {
                int lineForVertical = i3.getLineForVertical(scrollY);
                float f16 = scrollX;
                int offsetForHorizontal = i3.getOffsetForHorizontal(lineForVertical, f16);
                if (f16 - i3.getSecondaryHorizontal(offsetForHorizontal) <= aioTextView.q().getTextSize()) {
                    ?? link = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.tencent.mobileqq.guild.feed.a.class);
                    Intrinsics.checkNotNullExpressionValue(link, "link");
                    if (link.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        aVar = link[0];
                    } else {
                        QLog.w("LinkTouchUtils", 1, "span is null, line=" + lineForVertical + " off=" + offsetForHorizontal + " x=" + scrollX);
                    }
                }
            }
        }
        com.tencent.mobileqq.guild.feed.a aVar2 = aVar;
        Logger.f235387a.d().d("LongClickEventProcessor", 1, "find clickableSpan, spannable: " + ((Object) spannable));
        if (aVar2 == null) {
            return false;
        }
        aVar2.a(aioTextView);
        return true;
    }
}
