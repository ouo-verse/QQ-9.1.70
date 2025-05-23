package com.qzone.reborn.feedx.itemview.friendlike;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.util.RecycleExtKt;
import com.qzone.reborn.feedx.itemview.friendlike.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/h;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "", "isHorizontalCompleteVisible", "", "onStartRefreshData", "Lcom/qzone/reborn/feedx/itemview/friendlike/f$a;", "holder", "", "position", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "onScrollStateChanged", "i", tl.h.F, "j", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoView;", "e", "d", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Z", "needCheckOnRefresh", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needCheckOnRefresh;

    public h(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        recyclerView.addOnScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(h this$0, QZoneFrdHotVideoItemLayout videoItemLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoItemLayout, "$videoItemLayout");
        if (this$0.needCheckOnRefresh && this$0.isHorizontalCompleteVisible(videoItemLayout)) {
            this$0.needCheckOnRefresh = false;
            QLog.i("QZoneFrdHotVideoPlayController", 1, "start play video after refresh, position=" + i3);
            QZoneFrdHotVideoView videoView = videoItemLayout.getVideoView();
            if (videoView.isPlaying()) {
                return;
            }
            videoView.play();
        }
    }

    private final boolean isHorizontalCompleteVisible(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i3 = rect.left;
        return i3 >= 0 && rect.right - i3 >= QZoneFrdHotVideoItemLayout.INSTANCE.a();
    }

    public final QZoneFrdHotVideoView e() {
        Object obj;
        Iterator it = RecycleExtKt.getVisibleItemViewList(this.recyclerView).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            QZoneFrdHotVideoItemLayout qZoneFrdHotVideoItemLayout = (QZoneFrdHotVideoItemLayout) obj;
            if (isHorizontalCompleteVisible(qZoneFrdHotVideoItemLayout) && qZoneFrdHotVideoItemLayout.c()) {
                break;
            }
        }
        QZoneFrdHotVideoItemLayout qZoneFrdHotVideoItemLayout2 = (QZoneFrdHotVideoItemLayout) obj;
        if (qZoneFrdHotVideoItemLayout2 != null) {
            return qZoneFrdHotVideoItemLayout2.getVideoView();
        }
        return null;
    }

    public final void f(f.a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.needCheckOnRefresh) {
            final QZoneFrdHotVideoItemLayout videoItemLayout = holder.getVideoItemLayout();
            if (videoItemLayout.c()) {
                videoItemLayout.post(new Runnable() { // from class: com.qzone.reborn.feedx.itemview.friendlike.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.g(h.this, videoItemLayout, position);
                    }
                });
            }
        }
    }

    public final void h() {
        int collectionSizeOrDefault;
        List allItemViewList = RecycleExtKt.getAllItemViewList(this.recyclerView);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(allItemViewList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = allItemViewList.iterator();
        while (it.hasNext()) {
            arrayList.add(((QZoneFrdHotVideoItemLayout) it.next()).getVideoView());
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((QZoneFrdHotVideoView) it5.next()).pause();
        }
    }

    public final void i() {
        int collectionSizeOrDefault;
        List allItemViewList = RecycleExtKt.getAllItemViewList(this.recyclerView);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(allItemViewList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = allItemViewList.iterator();
        while (it.hasNext()) {
            arrayList.add(((QZoneFrdHotVideoItemLayout) it.next()).getVideoView());
        }
        QZoneFrdHotVideoView e16 = e();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!Intrinsics.areEqual((QZoneFrdHotVideoView) obj, e16)) {
                arrayList2.add(obj);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            ((QZoneFrdHotVideoView) it5.next()).pause();
        }
        if (e16 == null || e16.isPlaying()) {
            return;
        }
        e16.play();
    }

    public final void j() {
        int collectionSizeOrDefault;
        List allItemViewList = RecycleExtKt.getAllItemViewList(this.recyclerView);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(allItemViewList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = allItemViewList.iterator();
        while (it.hasNext()) {
            arrayList.add(((QZoneFrdHotVideoItemLayout) it.next()).getVideoView());
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((QZoneFrdHotVideoView) it5.next()).a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            i();
        }
    }

    public final void onStartRefreshData() {
        QLog.i("QZoneFrdHotVideoPlayController", 1, "onStartRefreshData");
        this.needCheckOnRefresh = true;
    }
}
