package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSPublishTempInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ah extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static final int J = ImmersiveUtils.dpToPx(16.0f);
    private ImageView I;

    /* JADX WARN: Multi-variable type inference failed */
    private void g1() {
        if (this.f85017h != 0 && this.I != null && j1()) {
            int i3 = ((FeedCloudMeta$StFeed) this.f85017h).video.width.get();
            int i16 = ((FeedCloudMeta$StFeed) this.f85017h).video.height.get();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.I.getLayoutParams();
            int dpToPx = ImmersiveUtils.dpToPx(48.0f);
            int i17 = J;
            layoutParams.topMargin = dpToPx + i17;
            if (!TransitionHelper.shouldVideoYFullScreen(i3, i16) && (!TransitionHelper.isFolderScreenOpenMode(this.I.getContext()) || I0())) {
                layoutParams.leftMargin = i17;
            } else {
                layoutParams.leftMargin = ((DisplayUtil.getInstantScreenWidth(this.I.getContext()) - ((int) ((i3 / i16) * ((DisplayUtil.getInstantScreenHeight(this.I.getContext()) - DisplayUtil.getTopHeight(this.I.getContext())) - ImmersiveUtils.dpToPx(50.0f))))) / 2) + i17;
            }
            this.I.setLayoutParams(layoutParams);
        }
    }

    private void h1() {
        g1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean j1() {
        QFSPublishTempInfo qFSPublishTempInfo = QFSTabFeedViewModel.Y.get(((FeedCloudMeta$StFeed) this.f85017h).video.fileId.get());
        int i3 = 8;
        if (qFSPublishTempInfo != null) {
            QLog.d("QFSFeedChildHDRIconPres", 1, "show HDR icon tempInfo:" + qFSPublishTempInfo.isHdr());
            ImageView imageView = this.I;
            if (qFSPublishTempInfo.isHdr()) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            return qFSPublishTempInfo.isHdr();
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).video.attachOption.isHdrVideo.get()) {
            this.I.setVisibility(0);
            QLog.d("QFSFeedChildHDRIconPres", 1, "show HDR icon:" + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(((FeedCloudMeta$StFeed) this.f85017h).content.get()));
            return true;
        }
        this.I.setVisibility(8);
        QLog.d("QFSFeedChildHDRIconPres", 1, "remove HDR icon:" + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(((FeedCloudMeta$StFeed) this.f85017h).content.get()));
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        this.I = (ImageView) view.findViewById(R.id.f43531mq);
        QLog.d("QFSFeedChildHDRIconPres", 4, "initView:" + hashCode());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        QLog.d("QFSFeedChildHDRIconPres", 4, "onBindData:" + hashCode());
        g1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        g1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            QLog.d("QFSFeedChildHDRIconPres", 4, "onConfigChange:" + hashCode());
            h1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildHDRIconPres";
    }
}
