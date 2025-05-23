package com.qzone.reborn.feedx.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.viewmodel.r;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001f\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014JH\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016JJ\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/scroller/l;", "Lhh/b;", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "isScrollUp", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "l", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/viewmodel/r;", "Lcom/qzone/reborn/feedx/viewmodel/r;", "getScrollViewModel", "()Lcom/qzone/reborn/feedx/viewmodel/r;", "setScrollViewModel", "(Lcom/qzone/reborn/feedx/viewmodel/r;)V", "scrollViewModel", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "<init>", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends hh.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private r scrollViewModel;

    public l(r scrollViewModel) {
        Intrinsics.checkNotNullParameter(scrollViewModel, "scrollViewModel");
        this.scrollViewModel = scrollViewModel;
        this.TAG = "QZoneFriendFeedxSimpleScroller";
    }

    @Override // hh.b
    /* renamed from: c, reason: from getter */
    protected String getTAG() {
        return this.TAG;
    }

    @Override // hh.b
    public void l(RecyclerView recyclerView, int dx5, int dy5, boolean isScrollUp, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.l(recyclerView, dx5, dy5, isScrollUp, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible);
        this.scrollViewModel.Q1(recyclerView, dx5, dy5);
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.m(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        this.scrollViewModel.R1(recyclerView, newState);
    }
}
