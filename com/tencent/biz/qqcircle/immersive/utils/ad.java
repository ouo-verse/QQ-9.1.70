package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.events.QFSTransitionChangeLocationEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ad {
    public static int a(List<e30.b> list, int i3, String str, int i16) {
        if (list != null && list.size() != 0) {
            if (i3 >= 0 && i3 < list.size() && list.get(i3) != null && list.get(i3).g() != null && TextUtils.equals(list.get(i3).g().f398449id.get(), str)) {
                return i3 + i16;
            }
            for (int i17 = 0; i17 < list.size(); i17++) {
                if (list.get(i17) != null && list.get(i17).g() != null && TextUtils.equals(str, list.get(i17).g().f398449id.get())) {
                    return i17 + i16;
                }
            }
        }
        return -1;
    }

    private static int[] b(com.tencent.qui.video.floatingview.view.m mVar) {
        return new int[]{((com.tencent.biz.qui.quicommon.e.f() - mVar.l()) - mVar.t()) + com.tencent.qui.video.floatingview.view.m.f363980m, mVar.s() + cx.h() + com.tencent.qui.video.floatingview.view.m.f363980m};
    }

    public static RectF c(boolean z16) {
        int[] b16 = b(new com.tencent.qui.video.floatingview.view.m(z16, true));
        float a16 = cx.a(2.0f);
        return new RectF(b16[0] + a16, b16[1] + com.tencent.mobileqq.qui.b.f276860a.h(p40.f.n()), (b16[0] + (r0.t() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2))) - a16, b16[1] + (r0.c() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2)));
    }

    public static void d(String str, Boolean bool, int i3) {
        int[] b16 = b(new com.tencent.qui.video.floatingview.view.m(bool.booleanValue(), true));
        float a16 = cx.a(2.0f);
        RectF rectF = new RectF(b16[0] + a16, b16[1] + com.tencent.mobileqq.qui.b.f276860a.h(p40.f.n()), (b16[0] + (r0.t() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2))) - a16, b16[1] + (r0.c() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2)));
        QFSTransitionChangeLocationEvent qFSTransitionChangeLocationEvent = new QFSTransitionChangeLocationEvent();
        qFSTransitionChangeLocationEvent.setLeft((int) rectF.left);
        qFSTransitionChangeLocationEvent.setTop((int) rectF.top);
        qFSTransitionChangeLocationEvent.setRight((int) rectF.right);
        qFSTransitionChangeLocationEvent.setBottom((int) rectF.bottom);
        qFSTransitionChangeLocationEvent.setPageCode(i3);
        qFSTransitionChangeLocationEvent.setCoverUrl(str);
        com.tencent.xaction.log.b.a("QFSGridLocationTransUtils", 1, "notifyFloatWindowLocationChange:" + qFSTransitionChangeLocationEvent);
        SimpleEventBus.getInstance().dispatchEvent(qFSTransitionChangeLocationEvent);
    }

    private static void e(List<e30.b> list, RecyclerView recyclerView, int i3, int i16, int i17) {
        if (recyclerView == null) {
            return;
        }
        for (int i18 = 0; i18 < recyclerView.getChildCount(); i18++) {
            View childAt = recyclerView.getChildAt(i18);
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
            if (childViewHolder != null && childViewHolder.getLayoutPosition() == i3) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                QFSTransitionChangeLocationEvent qFSTransitionChangeLocationEvent = new QFSTransitionChangeLocationEvent();
                qFSTransitionChangeLocationEvent.setLeft(iArr[0]);
                qFSTransitionChangeLocationEvent.setTop(iArr[1]);
                qFSTransitionChangeLocationEvent.setRight(iArr[0] + childAt.getWidth());
                qFSTransitionChangeLocationEvent.setBottom(iArr[1] + childAt.getHeight());
                qFSTransitionChangeLocationEvent.setPageCode(i16);
                int i19 = i3 - i17;
                if (list.size() > i19) {
                    qFSTransitionChangeLocationEvent.setCoverUrl(list.get(i19).g().cover.picUrl.get());
                }
                SimpleEventBus.getInstance().dispatchEvent(qFSTransitionChangeLocationEvent);
            }
        }
    }

    public static void f(List<e30.b> list, RecyclerView recyclerView, RecyclerView recyclerView2, QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        g(list, recyclerView, recyclerView2, qFSLayerFeedPosSyncEvent, 0);
    }

    public static void g(List<e30.b> list, RecyclerView recyclerView, RecyclerView recyclerView2, QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent, int i3) {
        int a16;
        int i16;
        if (recyclerView == null || list == null || (a16 = a(list, qFSLayerFeedPosSyncEvent.getPos(), qFSLayerFeedPosSyncEvent.getFeedId(), i3)) < 0 || !(recyclerView.getLayoutManager() instanceof SafeGridLayoutManager)) {
            return;
        }
        recyclerView.stopScroll();
        SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            i16 = childAt.getHeight();
        } else {
            i16 = 0;
        }
        if (recyclerView2 != null && a16 > safeGridLayoutManager.findLastVisibleItemPosition()) {
            recyclerView2.scrollBy(0, ImmersiveUtils.getScreenHeight());
        }
        if (a16 < safeGridLayoutManager.findFirstVisibleItemPosition() || a16 > safeGridLayoutManager.findLastVisibleItemPosition()) {
            safeGridLayoutManager.scrollToPositionWithOffset(a16, (recyclerView.getHeight() / 2) - (i16 / 2));
        }
        e(list, recyclerView, a16, qFSLayerFeedPosSyncEvent.getPageCode(), i3);
    }

    public static void h(List<e30.b> list, RecyclerView recyclerView, RecyclerView recyclerView2, int i3) {
        if (recyclerView == null || list == null || !(recyclerView.getLayoutManager() instanceof SafeGridLayoutManager)) {
            return;
        }
        recyclerView.stopScroll();
        SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
        if (recyclerView2 != null) {
            recyclerView2.scrollBy(0, ImmersiveUtils.getScreenHeight());
        }
        View findViewByPosition = safeGridLayoutManager.findViewByPosition(i3);
        if (findViewByPosition == null) {
            return;
        }
        recyclerView.smoothScrollBy(0, (findViewByPosition.getTop() + (findViewByPosition.getHeight() / 2)) - (recyclerView.getHeight() / 2));
    }
}
