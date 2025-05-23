package com.tencent.mobileqq.guild.contentshare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJP\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/widget/BounceScrollView;", "Landroid/widget/ScrollView;", "", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "", "isTouchEvent", "overScrollBy", "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "d", "I", "mMaxOverScrollY", "e", "mMaxOverScrollX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BounceScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMaxOverScrollY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMaxOverScrollX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BounceScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxOverScrollY = 200;
        this.mMaxOverScrollX = 200;
        setOverScrollMode(2);
        setFadingEdgeLength(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r6 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(0, r6.getMeasuredHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean onTouchEvent = super.onTouchEvent(ev5);
        if ((ev5.getAction() & 255) == 1) {
            if (getScrollY() < 0) {
                smoothScrollTo(0, 0);
                return true;
            }
            if (getChildCount() > 0 && (r6 = getChildAt(0)) != null && getScrollY() > coerceAtLeast) {
                smoothScrollTo(0, coerceAtLeast);
                return true;
            }
        }
        return onTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        boolean z18;
        boolean z19;
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i17 = scrollX + deltaX;
        if (!z16) {
            i3 = 0;
        } else {
            i3 = this.mMaxOverScrollX;
        }
        int i18 = scrollY + deltaY;
        if (!z17) {
            i16 = 0;
        } else {
            i16 = this.mMaxOverScrollY;
        }
        int i19 = -i3;
        int i26 = i3 + scrollRangeX;
        int i27 = -i16;
        int i28 = i16 + scrollRangeY;
        if (i17 > i26) {
            i17 = i26;
        } else if (i17 < i19) {
            i17 = i19;
        } else {
            z18 = false;
            if (i18 <= i28) {
                i18 = i28;
            } else if (i18 < i27) {
                i18 = i27;
            } else {
                z19 = false;
                onOverScrolled(i17, i18, z18, z19);
                if (!z18 && !z19) {
                    return false;
                }
            }
            z19 = true;
            onOverScrolled(i17, i18, z18, z19);
            return !z18 ? true : true;
        }
        z18 = true;
        if (i18 <= i28) {
        }
        z19 = true;
        onOverScrolled(i17, i18, z18, z19);
        if (!z18) {
        }
    }
}
