package cl2;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u00060\bR\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcl2/a;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "", "curLine", "", ReportConstant.COSTREPORT_PREFIX, "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onLayoutChildren", "d", "I", "mPaddingHorizontal", "e", "mPaddingVertical", "f", "mMaxLine", "<set-?>", h.F, "r", "()I", "layoutChildIndex", "<init>", "(III)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends RecyclerView.LayoutManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mPaddingHorizontal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mPaddingVertical;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mMaxLine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int layoutChildIndex = -1;

    public a(int i3, int i16, int i17) {
        this.mPaddingHorizontal = i3;
        this.mPaddingVertical = i16;
        this.mMaxLine = i17;
    }

    private final boolean s(int curLine) {
        int i3 = this.mMaxLine;
        if (i3 != 0 && curLine >= i3) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        int width = getWidth();
        int itemCount = getItemCount();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < itemCount; i19++) {
            View viewForPosition = recycler.getViewForPosition(i19);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(index)");
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int i26 = i3 + decoratedMeasuredWidth;
            if (i26 <= width) {
                addView(viewForPosition);
                layoutDecorated(viewForPosition, i26 - decoratedMeasuredWidth, i17, i26, i17 + decoratedMeasuredHeight);
                i18 = Math.max(i18, decoratedMeasuredHeight);
                i3 = i26 + this.mPaddingHorizontal;
            } else {
                i16++;
                if (s(i16)) {
                    int i27 = decoratedMeasuredWidth + this.mPaddingHorizontal;
                    if (i18 == 0) {
                        i18 = decoratedMeasuredHeight;
                    }
                    i17 += i18 + this.mPaddingVertical;
                    addView(viewForPosition);
                    layoutDecorated(viewForPosition, 0, i17, decoratedMeasuredWidth, i17 + decoratedMeasuredHeight);
                    i18 = decoratedMeasuredHeight;
                    i3 = i27;
                } else {
                    return;
                }
            }
            this.layoutChildIndex = i19;
        }
    }

    /* renamed from: r, reason: from getter */
    public final int getLayoutChildIndex() {
        return this.layoutChildIndex;
    }
}
