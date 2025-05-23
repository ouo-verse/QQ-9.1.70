package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.adapter.r;
import com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.ag;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSFullScreenBaseCommentPanelPart {

    /* renamed from: k0, reason: collision with root package name */
    private QCircleAlbumSlidBottomView f86595k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f86596l0;

    private int sa() {
        int max = Math.max(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
        int dip2px = DisplayUtil.dip2px(getContext(), 400.0f);
        int min = Math.min(max / 2, dip2px);
        QLog.d("QFSFullScreenCommentPanelPart", 1, "[getPanelSize] screenW: " + max + ", maxPanelW: " + dip2px + ", result: " + min);
        return min;
    }

    private void ta() {
        FrameLayout frameLayout = this.f82770d;
        if (frameLayout != null && this.f86595k0 != null && frameLayout.getVisibility() == 0) {
            this.f86595k0.d();
        }
    }

    private void ua() {
        if (this.f86595k0 != null && this.f86596l0 != null) {
            int sa5 = sa();
            this.f86595k0.setPanelSize(sa5);
            ViewGroup.LayoutParams layoutParams = this.f86596l0.getLayoutParams();
            layoutParams.width = sa5;
            this.f86596l0.setLayoutParams(layoutParams);
        }
    }

    private void va() {
        this.f86595k0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.xa(view);
            }
        });
        this.f86595k0.c(new a());
    }

    public static boolean wa() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_full_screen_comment", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ta();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    protected void adjustCloseBtnSize(int i3) {
        ImageView imageView = this.G;
        if (imageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.rightMargin = DisplayUtil.dip2px(this.G.getContext(), 4.0f);
        int dip2px = (DisplayUtil.dip2px(this.G.getContext(), 44.0f) - DisplayUtil.dip2px(this.G.getContext(), 18.0f)) / 2;
        this.G.setPadding(dip2px, dip2px, dip2px, dip2px);
        this.G.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    protected void dismissCommentPanel() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.f86595k0;
        if (qCircleAlbumSlidBottomView != null && qCircleAlbumSlidBottomView.getVisibility() == 0) {
            this.f86595k0.d();
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    public int getBlockContainerHeight() {
        if (getBlockContainer() != null && getBlockContainer().getRecyclerView() != null) {
            return getBlockContainer().getRecyclerView().getHeight();
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart, com.tencent.biz.qqcircle.bizparts.ag
    protected com.tencent.biz.qqcircle.comment.effect.d handleCommentOrReplyAdded(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    protected void handleConfigChange() {
        dismissCommentPanel();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    protected void initSlideView() {
        FrameLayout frameLayout = this.f82770d;
        if (frameLayout == null) {
            return;
        }
        this.f86595k0 = (QCircleAlbumSlidBottomView) frameLayout.findViewById(R.id.f30830pe);
        this.f86596l0 = this.f82770d.findViewById(R.id.f164859u25);
        va();
        ua();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean isAllowAiComment() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean isAllowCommentVideo() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a
    public boolean isFullScreenComment() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart, com.tencent.biz.qqcircle.bizparts.ag
    protected ArrayList<MultiViewBlock> prepareAdapters() {
        if (this.f82768b0 == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("orientation_type_flag", 0);
            this.f82768b0 = new r(bundle);
        }
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        arrayList.add(this.f82768b0);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart
    protected void showCommentPanel() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.f86595k0;
        if (qCircleAlbumSlidBottomView != null && qCircleAlbumSlidBottomView.getVisibility() != 0) {
            this.f86595k0.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleAlbumSlidBottomView.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onDismiss() {
            String str;
            ((QFSFullScreenBaseCommentPanelPart) b.this).W = false;
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(b.this.getContextHashcode(), 0);
            ((QFSFullScreenBaseCommentPanelPart) b.this).f82770d.setVisibility(8);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (((ag) b.this).mInfo != null && ((ag) b.this).mInfo.mFeed != null) {
                str = ((ag) b.this).mInfo.mFeed.f398449id.get();
            } else {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(23, str, false));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onShow() {
            String str;
            ((QFSFullScreenBaseCommentPanelPart) b.this).W = true;
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(b.this.getContextHashcode(), 1);
            b.this.f86595k0.setParentConsumeEvent(false);
            if (((ag) b.this).mInfo != null && ((ag) b.this).mInfo.mFeed != null) {
                str = ((ag) b.this).mInfo.mFeed.f398449id.get();
            } else {
                str = "";
            }
            QCirclePanelStateEvent qCirclePanelStateEvent = new QCirclePanelStateEvent(23, str, true);
            qCirclePanelStateEvent.setArg(Boolean.valueOf(b.this.needResetBlockWhenShowPanel()));
            SimpleEventBus.getInstance().dispatchEvent(qCirclePanelStateEvent);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
