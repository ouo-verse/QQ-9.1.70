package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class QFSFeedChildVideoSprPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ImageView I;
    private FrameLayout J;
    private FrameLayout K;
    private QFSVideoView L;

    /* JADX WARN: Multi-variable type inference failed */
    private void h1() {
        int height;
        QFSVideoView qFSVideoView = this.L;
        if (qFSVideoView == null) {
            return;
        }
        int i3 = 0;
        if ((qFSVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) && (((FrameLayout.LayoutParams) this.L.getLayoutParams()).gravity & 48) == 48) {
            RFWLog.d("QFSFeedChildVideoSprPresenter", RFWLog.USR, "adjustView, but view is in other layout mode");
            return;
        }
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        int i16 = ((FeedCloudMeta$StFeed) t16).video.width.get();
        int i17 = ((FeedCloudMeta$StFeed) this.f85017h).video.height.get();
        if (!TransitionHelper.shouldVideoYFullScreen(i16, i17) && ((!TransitionHelper.isFolderScreenOpenMode(this.L.getContext()) || I0()) && (!com.tencent.biz.qqcircle.utils.bz.p() || I0()))) {
            if (TransitionHelper.shouldFullScreen(i16, i17)) {
                QLog.d("QFSFeedChildVideoSprPresenter", 1, "[adjustViewSize] FullScreen");
                Y0(this.I, -1, -1);
            } else {
                QLog.d("QFSFeedChildVideoSprPresenter", 1, "[adjustViewSize] XFullScreen");
                Y0(this.I, i16, i17);
            }
        } else {
            View findViewById = ((Activity) this.f85016f.getContext()).findViewById(R.id.f73923uv);
            if (findViewById != null) {
                i3 = findViewById.getHeight() - ImmersiveUtils.dpToPx(56.0f);
            }
            if (com.tencent.biz.qqcircle.utils.bz.s(m0()) && (height = QCircleHostGlobalInfo.getQFunctionZoneSize().getHeight()) != 0) {
                i3 = height - ImmersiveUtils.dpToPx(56.0f);
            }
            TransitionHelper.setSizeWhenYFullScreen(i3, this.I, i16, i17);
        }
        int realScreenWidth = TransitionHelper.getRealScreenWidth(this.L.getContext()) / 2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.width = TransitionHelper.getRealScreenWidth(this.L.getContext());
        layoutParams.gravity = 19;
        layoutParams.setMargins(-realScreenWidth, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.I.setLayoutParams(layoutParams);
        this.I.requestLayout();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.K.getLayoutParams();
        layoutParams2.width = realScreenWidth;
        layoutParams2.setMargins(realScreenWidth, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        this.K.setLayoutParams(layoutParams2);
        this.K.requestLayout();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(final com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (!(hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.u)) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoSprPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (QFSFeedChildVideoSprPresenter.this.f85016f == null) {
                    return;
                }
                if (1 == ((com.tencent.biz.qqcircle.immersive.feed.event.u) hVar).b()) {
                    View view = QFSFeedChildVideoSprPresenter.this.f85016f;
                    if (((com.tencent.biz.qqcircle.immersive.feed.event.u) hVar).a()) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    view.setVisibility(i3);
                    return;
                }
                QFSFeedChildVideoSprPresenter.this.I.setImageDrawable(new BitmapDrawable((Resources) null, ((com.tencent.biz.qqcircle.immersive.feed.event.u) hVar).c()));
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        if (!com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENBALE_SPR_COMPARE, 0)) {
            return;
        }
        View inflate = ((ViewStub) view.findViewById(R.id.f165237va4)).inflate();
        this.f85016f = inflate;
        this.J = (FrameLayout) inflate.findViewById(R.id.f57252mt);
        this.L = (QFSVideoView) view.findViewById(R.id.f74163vi);
        this.K = (FrameLayout) this.f85016f.findViewById(R.id.f57232mr);
        this.I = (ImageView) this.f85016f.findViewById(R.id.f57242ms);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        View view = this.f85016f;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        this.I.setImageDrawable(null);
        h1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (this.f85016f == null) {
            return;
        }
        this.I.setImageDrawable(null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildVideoSprPresenter";
    }
}
