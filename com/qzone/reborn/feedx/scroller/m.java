package com.qzone.reborn.feedx.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.p;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JL\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/scroller/m;", "Lcom/qzone/reborn/base/p;", "", "pageId", "", "state", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "g", tl.h.F, "I", "getMPageId", "()I", "setMPageId", "(I)V", "mPageId", "", "i", "Ljava/util/Map;", "mRepeatMap", "<init>", "j", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends p {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPageId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, Integer> mRepeatMap = new LinkedHashMap();

    public m(int i3) {
        this.mPageId = i3;
    }

    private final void m(int pageId, String state) {
        if (AppSetting.isDebugVersion()) {
            QLog.d("QZoneListFrameMonitorScroller", 2, "[handleScrollStateChange] page id: " + pageId + ", state is: " + state);
        }
    }

    @Override // com.qzone.reborn.base.p
    public void g(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        super.g(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        Integer num = (Integer) RFSafeMapUtils.getVal(this.mRepeatMap, Integer.valueOf(this.mPageId));
        if ((num == null ? -2 : num.intValue()) == newState) {
            return;
        }
        if (newState == 0) {
            m(this.mPageId, "SCROLL_STATE_IDLE");
            com.qzone.reborn.tracer.monitor.b.a().endPageScroll(this.mPageId);
            RFSafeMapUtils.put(this.mRepeatMap, Integer.valueOf(this.mPageId), Integer.valueOf(newState));
        } else {
            if (newState != 1) {
                return;
            }
            m(this.mPageId, "SCROLL_STATE_DRAGGING");
            com.qzone.reborn.tracer.monitor.b.a().startPageScroll(this.mPageId);
            RFSafeMapUtils.put(this.mRepeatMap, Integer.valueOf(this.mPageId), Integer.valueOf(newState));
        }
    }
}
