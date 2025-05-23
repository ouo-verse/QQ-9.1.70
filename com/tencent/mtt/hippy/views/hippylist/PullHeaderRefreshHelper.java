package com.tencent.mtt.hippy.views.hippylist;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper;

/* loaded from: classes20.dex */
public class PullHeaderRefreshHelper extends PullRefreshHelper {
    public static final String EVENT_TYPE_HEADER_PULLING = "onHeaderPulling";
    public static final String EVENT_TYPE_HEADER_RELEASED = "onHeaderReleased";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mtt.hippy.views.hippylist.PullHeaderRefreshHelper$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus;

        static {
            int[] iArr = new int[PullRefreshHelper.PullRefreshStatus.values().length];
            $SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus = iArr;
            try {
                iArr[PullRefreshHelper.PullRefreshStatus.PULL_STATUS_FOLDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus[PullRefreshHelper.PullRefreshStatus.PULL_STATUS_DRAGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus[PullRefreshHelper.PullRefreshStatus.PULL_STATUS_REFRESHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PullHeaderRefreshHelper(HippyRecyclerView hippyRecyclerView, RenderNode renderNode) {
        super(hippyRecyclerView, renderNode);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    public void enableRefresh() {
        int width;
        this.mRefreshStatus = PullRefreshHelper.PullRefreshStatus.PULL_STATUS_REFRESHING;
        if (isVertical()) {
            width = this.mRenderNode.getHeight();
        } else {
            width = this.mRenderNode.getWidth();
        }
        if (this.mRecyclerView.getFirstChildPosition() > 0) {
            endAnimation();
            setVisibleSize(width);
            this.mRecyclerView.smoothScrollToPosition(0);
        } else {
            int visibleSize = getVisibleSize();
            if (visibleSize < width) {
                smoothResizeTo(visibleSize, width, 200);
            }
        }
    }

    protected int getOffset() {
        if (isVertical()) {
            return this.mRecyclerView.computeVerticalScrollOffset();
        }
        return this.mRecyclerView.computeHorizontalScrollOffset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r6 != 0) goto L18;
     */
    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int handleDrag(int i3) {
        int min;
        int i16;
        int i17 = AnonymousClass1.$SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus[this.mRefreshStatus.ordinal()];
        int i18 = 0;
        if (i17 != 1) {
            if (i17 == 2 || i17 == 3) {
                if (i3 < 0) {
                    min = Math.min(0, i3 + getOffset());
                } else {
                    min = Math.min(Math.round(getVisibleSize() * 2.4f), i3);
                }
            }
            i16 = 0;
        } else {
            if (i3 < 0) {
                min = Math.min(0, i3 + getOffset());
                if (min != 0) {
                    this.mRefreshStatus = PullRefreshHelper.PullRefreshStatus.PULL_STATUS_DRAGGING;
                    i18 = getVisibleSize() - Math.round(min / 2.4f);
                    setVisibleSize(i18);
                }
                int i19 = i18;
                i18 = min;
                i16 = i19;
            }
            i16 = 0;
        }
        if (i18 != 0) {
            endAnimation();
            sendPullingEvent(i16);
            if (this.mRecyclerView.getFirstChildPosition() > 0) {
                return i18 - Math.round(i18 / 2.4f);
            }
            return i18;
        }
        return i18;
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    protected void sendPullingEvent(int i3) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("contentOffset", PixelUtil.px2dp(i3));
        new HippyViewEvent("onHeaderPulling").send(this.mItemView, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    protected void sendReleasedEvent() {
        new HippyViewEvent("onHeaderReleased").send(this.mItemView, null);
    }
}
