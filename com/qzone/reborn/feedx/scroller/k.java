package com.qzone.reborn.feedx.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0014JJ\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/scroller/k;", "Lhh/b;", "", "pageId", "", "state", "", "r", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getMPageId", "()I", "setMPageId", "(I)V", "mPageId", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "mRepeatMap", "<init>", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends hh.b {

    /* renamed from: C, reason: from kotlin metadata */
    private Map<Integer, Integer> mRepeatMap = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mPageId;

    public k(int i3) {
        this.mPageId = i3;
    }

    private final void r(int pageId, String state) {
        if (AppSetting.isDebugVersion()) {
            QLog.d("QZoneFrameMonitorScroller", 2, "[handleScrollStateChange] page id: " + pageId + ", state is: " + state);
        }
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneFrameMonitorScroller";
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.m(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        Integer num = (Integer) RFSafeMapUtils.getVal(this.mRepeatMap, Integer.valueOf(this.mPageId));
        if ((num == null ? -2 : num.intValue()) == newState) {
            return;
        }
        if (newState == 0) {
            r(this.mPageId, "SCROLL_STATE_IDLE");
            com.qzone.reborn.tracer.monitor.b.a().endPageScroll(this.mPageId);
            RFSafeMapUtils.put(this.mRepeatMap, Integer.valueOf(this.mPageId), Integer.valueOf(newState));
        } else {
            if (newState != 1) {
                return;
            }
            r(this.mPageId, "SCROLL_STATE_DRAGGING");
            com.qzone.reborn.tracer.monitor.b.a().startPageScroll(this.mPageId);
            RFSafeMapUtils.put(this.mRepeatMap, Integer.valueOf(this.mPageId), Integer.valueOf(newState));
        }
    }
}
