package com.qzone.reborn.feedx.viewmodel;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0006R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/r;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "listener", "", "N1", "S1", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "M1", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "Q1", "newState", "R1", "", "offSet", "sumOffSet", "", "O1", "P1", "", "i", "Ljava/util/List;", "mScrollListeners", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRefreshListeners", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class r extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<RecyclerView.OnScrollListener> mScrollListeners = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<QZoneFeedxRefreshView.b> mRefreshListeners = new ArrayList();

    public final void M1(QZoneFeedxRefreshView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mRefreshListeners.add(listener);
    }

    public final void N1(RecyclerView.OnScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mScrollListeners.add(listener);
    }

    public final boolean O1(float offSet, float sumOffSet) {
        Iterator<QZoneFeedxRefreshView.b> it = this.mRefreshListeners.iterator();
        while (it.hasNext()) {
            if (it.next().a(offSet, sumOffSet)) {
                return true;
            }
        }
        return false;
    }

    public final void P1() {
        Iterator<QZoneFeedxRefreshView.b> it = this.mRefreshListeners.iterator();
        while (it.hasNext()) {
            it.next().onRelease();
        }
    }

    public final void Q1(RecyclerView recyclerView, int dx5, int dy5) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Iterator<RecyclerView.OnScrollListener> it = this.mScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrolled(recyclerView, dx5, dy5);
        }
    }

    public final void R1(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Iterator<RecyclerView.OnScrollListener> it = this.mScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChanged(recyclerView, newState);
        }
    }

    public final void S1(RecyclerView.OnScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mScrollListeners.remove(listener);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneFriendFeedxScrollViewModel";
    }
}
