package com.tencent.biz.pubaccount.weishi.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSComboHomePageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "pageChangeEvent", "Ljava/lang/String;", "getPageChangeEvent", "()Ljava/lang/String;", "bottomBarId", "getBottomBarId", "", "pageIndex", "I", "getPageIndex", "()I", HippyTKDListViewAdapter.SCROLL_STATE, "getScrollState", "setScrollState", "(I)V", "", "offset", UserInfo.SEX_FEMALE, "getOffset", "()F", "setOffset", "(F)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSComboHomePageChangeEvent extends WSSimpleBaseEvent {
    public static final String EVENT_ON_PAGE_SCROLLED = "onPageScrolled";
    public static final String EVENT_ON_PAGE_SCROLL_STATE_CHANGED = "onPageScrollStateChanged";
    public static final String EVENT_ON_PAGE_SELECTED = "onPageSelected";
    private final String bottomBarId;
    private float offset;
    private final String pageChangeEvent;
    private final int pageIndex;
    private int scrollState;

    public WSComboHomePageChangeEvent(String pageChangeEvent, String bottomBarId, int i3) {
        Intrinsics.checkNotNullParameter(pageChangeEvent, "pageChangeEvent");
        Intrinsics.checkNotNullParameter(bottomBarId, "bottomBarId");
        this.pageChangeEvent = pageChangeEvent;
        this.bottomBarId = bottomBarId;
        this.pageIndex = i3;
    }

    public final String getBottomBarId() {
        return this.bottomBarId;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final String getPageChangeEvent() {
        return this.pageChangeEvent;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final int getScrollState() {
        return this.scrollState;
    }

    public final void setOffset(float f16) {
        this.offset = f16;
    }

    public final void setScrollState(int i3) {
        this.scrollState = i3;
    }
}
