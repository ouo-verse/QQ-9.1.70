package com.qzone.reborn.intimate.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/intimate/widget/k;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "Z", "isGuestDraftShow", "()Z", "setGuestDraftShow", "(Z)V", "e", "isHistoryShow", "setHistoryShow", "f", "isManualShow", "setManualShow", "", tl.h.F, "I", "getDataListSize", "()I", "setDataListSize", "(I)V", "dataListSize", "<init>", "(ZZZI)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isGuestDraftShow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isHistoryShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isManualShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int dataListSize;

    public k(boolean z16, boolean z17, boolean z18, int i3) {
        this.isGuestDraftShow = z16;
        this.isHistoryShow = z17;
        this.isManualShow = z18;
        this.dataListSize = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        int i3;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (this.isGuestDraftShow) {
            childAdapterPosition = parent.getChildAdapterPosition(view) - 1;
        } else {
            childAdapterPosition = parent.getChildAdapterPosition(view);
        }
        if (this.isGuestDraftShow) {
            i3 = this.dataListSize - 1;
        } else {
            i3 = this.dataListSize;
        }
        boolean z16 = this.isHistoryShow;
        if (z16 && this.isManualShow) {
            int i16 = i3 - 1;
            if (childAdapterPosition == i16 || childAdapterPosition == i3 - 2) {
                outRect.left = ViewUtils.dpToPx(16.0f);
                outRect.right = ViewUtils.dpToPx(16.0f);
                outRect.top = childAdapterPosition != i16 ? ViewUtils.dpToPx(10.0f) : 0;
                outRect.bottom = ViewUtils.dpToPx(16.0f);
                return;
            }
        } else if ((z16 || this.isManualShow) && childAdapterPosition == i3 - 1) {
            outRect.left = ViewUtils.dpToPx(16.0f);
            outRect.right = ViewUtils.dpToPx(16.0f);
            outRect.top = ViewUtils.dpToPx(10.0f);
            outRect.bottom = ViewUtils.dpToPx(16.0f);
            return;
        }
        if (childAdapterPosition % 2 == 0) {
            outRect.left = ViewUtils.dpToPx(16.0f);
            outRect.right = ViewUtils.dpToPx(8.0f);
        } else {
            outRect.left = ViewUtils.dpToPx(8.0f);
            outRect.right = ViewUtils.dpToPx(16.0f);
        }
        boolean z17 = this.isGuestDraftShow;
        if (z17 && childAdapterPosition == -1) {
            outRect.top = 0;
            outRect.bottom = 0;
            outRect.left = ViewUtils.dpToPx(16.0f);
            outRect.right = ViewUtils.dpToPx(16.0f);
            return;
        }
        if (childAdapterPosition >= 2) {
            outRect.top = ViewUtils.dpToPx(10.0f);
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        } else if (z17) {
            outRect.top = ViewUtils.dpToPx(16.0f);
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        } else {
            outRect.top = 0;
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        }
    }
}
