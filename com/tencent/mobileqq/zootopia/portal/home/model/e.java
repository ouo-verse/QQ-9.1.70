package com.tencent.mobileqq.zootopia.portal.home.model;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/e;", "Lcom/tencent/mobileqq/zootopia/portal/home/model/a;", "Landroid/support/v7/widget/LinearLayoutManager;", "linearLayoutManager", "", "d", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "newState", "", "a", "dx", "dy", "b", "c", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "reset", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "I", "lastPosition", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int lastPosition;

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.lastPosition = -1;
    }

    private final int d(LinearLayoutManager linearLayoutManager) {
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int i3 = -1;
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return -1;
        }
        int i16 = -1;
        while (true) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                return i16;
            }
            Rect rect = new Rect();
            findViewByPosition.getGlobalVisibleRect(rect);
            int i17 = rect.bottom - rect.top;
            if (i17 > i3) {
                i16 = findFirstVisibleItemPosition;
                i3 = i17;
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return i16;
            }
            findFirstVisibleItemPosition++;
        }
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void reset() {
        this.lastPosition = -1;
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void a(RecyclerView recyclerView, int newState) {
        if (newState == 0) {
            c(recyclerView);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void c(RecyclerView recyclerView) {
        ZootopiaPlayerView backgroundView;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int d16 = d(linearLayoutManager);
            if (d16 == -1) {
                QLog.i("ZootopiaListController", 1, "pickItemToPlay view is not ready");
                return;
            }
            QLog.i("ZootopiaListController", 1, "pickItemToPlay curMaxPos " + d16 + " lastMaxPos " + this.lastPosition);
            View findViewByPosition = linearLayoutManager.findViewByPosition(d16);
            if ((findViewByPosition instanceof ZootopiaMapItemView) && (backgroundView = ((ZootopiaMapItemView) findViewByPosition).getBackgroundView()) != null) {
                ZootopiaPlayerView.z(backgroundView, false, false, 3, null);
            }
            this.lastPosition = d16;
        }
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void b(RecyclerView recyclerView, int dx5, int dy5) {
        if (recyclerView != null && dx5 == 0 && dy5 == 0 && recyclerView.isShown()) {
            c(recyclerView);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void onViewAttachedToWindow(View v3) {
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.model.a
    public void onViewDetachedFromWindow(View v3) {
    }
}
