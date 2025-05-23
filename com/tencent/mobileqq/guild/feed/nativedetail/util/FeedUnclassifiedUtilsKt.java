package com.tencent.mobileqq.guild.feed.nativedetail.util;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.guild.feed.nativedetail.util.FeedUnclassifiedUtilsKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import yl1.p;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a5\u0010\u0010\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00a8\u0006\u0011"}, d2 = {BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function0;", "initializer", "Lkotlin/Lazy;", "d", "Landroid/view/View;", "", "detectThresholdMillis", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isScrolling", "", "listener", "Landroid/view/View$OnScrollChangeListener;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedUnclassifiedUtilsKt {
    /* JADX WARN: Type inference failed for: r13v0, types: [com.tencent.mobileqq.guild.feed.nativedetail.util.FeedUnclassifiedUtilsKt$setOnVerticalScrollStateChangeListener$delayCheckRunnable$1] */
    @NotNull
    public static final View.OnScrollChangeListener b(@NotNull final View view, final long j3, @NotNull final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Ref.LongRef longRef = new Ref.LongRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final ?? r132 = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.util.FeedUnclassifiedUtilsKt$setOnVerticalScrollStateChangeListener$delayCheckRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                long coerceAtLeast;
                long elapsedRealtime = SystemClock.elapsedRealtime() - Ref.LongRef.this.element;
                long j16 = j3;
                if (elapsedRealtime >= j16) {
                    booleanRef.element = false;
                    booleanRef2.element = false;
                    listener.invoke(Boolean.FALSE);
                } else {
                    View view2 = view;
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j16 - elapsedRealtime, 0L);
                    view2.postDelayed(this, coerceAtLeast);
                }
            }
        };
        View.OnScrollChangeListener onScrollChangeListener = new View.OnScrollChangeListener() { // from class: yl1.j
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i3, int i16, int i17, int i18) {
                FeedUnclassifiedUtilsKt.c(Ref.BooleanRef.this, listener, longRef, booleanRef2, view, r132, j3, view2, i3, i16, i17, i18);
            }
        };
        view.setOnScrollChangeListener(onScrollChangeListener);
        return onScrollChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Ref.BooleanRef isScrolling, Function1 listener, Ref.LongRef lastScrollChangeTime, Ref.BooleanRef hasPendingCheck, View this_setOnVerticalScrollStateChangeListener, FeedUnclassifiedUtilsKt$setOnVerticalScrollStateChangeListener$delayCheckRunnable$1 delayCheckRunnable, long j3, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(isScrolling, "$isScrolling");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(lastScrollChangeTime, "$lastScrollChangeTime");
        Intrinsics.checkNotNullParameter(hasPendingCheck, "$hasPendingCheck");
        Intrinsics.checkNotNullParameter(this_setOnVerticalScrollStateChangeListener, "$this_setOnVerticalScrollStateChangeListener");
        Intrinsics.checkNotNullParameter(delayCheckRunnable, "$delayCheckRunnable");
        if (i16 != i18) {
            if (!isScrolling.element) {
                listener.invoke(Boolean.TRUE);
            }
            isScrolling.element = true;
            lastScrollChangeTime.element = SystemClock.elapsedRealtime();
            if (!hasPendingCheck.element) {
                hasPendingCheck.element = true;
                this_setOnVerticalScrollStateChangeListener.postDelayed(delayCheckRunnable, j3);
            }
        }
    }

    @NotNull
    public static final <R> Lazy<R> d(@NotNull Function0<? extends R> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new p(initializer);
    }
}
