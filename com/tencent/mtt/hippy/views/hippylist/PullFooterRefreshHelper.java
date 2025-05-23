package com.tencent.mtt.hippy.views.hippylist;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class PullFooterRefreshHelper extends PullRefreshHelper {
    public static final String EVENT_TYPE_FOOTER_PULLING = "onFooterPulling";
    public static final String EVENT_TYPE_FOOTER_RELEASED = "onFooterReleased";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mtt.hippy.views.hippylist.PullFooterRefreshHelper$1, reason: invalid class name */
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
    public PullFooterRefreshHelper(@NonNull HippyRecyclerView hippyRecyclerView, @NonNull RenderNode renderNode) {
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
        endAnimation();
        if (getVisibleSize() < width) {
            setVisibleSize(width);
        }
        HippyRecyclerListAdapter adapter = this.mRecyclerView.getAdapter();
        if (adapter != null) {
            this.mRecyclerView.smoothScrollToPosition(adapter.getNUM_BACKGOURND_ICON());
        }
    }

    protected int getOffsetFromEnd() {
        int computeHorizontalScrollRange;
        int computeHorizontalScrollOffset;
        HippyRecyclerView hippyRecyclerView = this.mRecyclerView;
        if (isVertical()) {
            computeHorizontalScrollRange = hippyRecyclerView.computeVerticalScrollRange() - hippyRecyclerView.computeVerticalScrollExtent();
            computeHorizontalScrollOffset = hippyRecyclerView.computeVerticalScrollOffset();
        } else {
            computeHorizontalScrollRange = hippyRecyclerView.computeHorizontalScrollRange() - hippyRecyclerView.computeHorizontalScrollExtent();
            computeHorizontalScrollOffset = hippyRecyclerView.computeHorizontalScrollOffset();
        }
        return computeHorizontalScrollRange - computeHorizontalScrollOffset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r6 != 0) goto L18;
     */
    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int handleDrag(int i3) {
        int max;
        int i16;
        int i17 = AnonymousClass1.$SwitchMap$com$tencent$mtt$hippy$views$hippylist$PullRefreshHelper$PullRefreshStatus[this.mRefreshStatus.ordinal()];
        int i18 = 0;
        if (i17 != 1) {
            if (i17 == 2 || i17 == 3) {
                if (i3 > 0) {
                    max = Math.max(0, i3 - getOffsetFromEnd());
                } else {
                    max = Math.max(-Math.round(getVisibleSize() * 2.4f), i3);
                }
            }
            i16 = 0;
        } else {
            if (i3 > 0) {
                max = Math.max(0, i3 - getOffsetFromEnd());
                if (max != 0) {
                    this.mRefreshStatus = PullRefreshHelper.PullRefreshStatus.PULL_STATUS_DRAGGING;
                    i18 = getVisibleSize() + Math.round(max / 2.4f);
                    setVisibleSize(i18);
                }
                int i19 = i18;
                i18 = max;
                i16 = i19;
            }
            i16 = 0;
        }
        if (i18 != 0) {
            endAnimation();
            sendPullingEvent(i16);
        }
        return i18 - Math.round(i18 / 2.4f);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    protected void sendPullingEvent(int i3) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("contentOffset", PixelUtil.px2dp(i3));
        new HippyViewEvent("onFooterPulling").send(this.mItemView, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper
    protected void sendReleasedEvent() {
        new HippyViewEvent("onFooterReleased").send(this.mItemView, null);
    }
}
