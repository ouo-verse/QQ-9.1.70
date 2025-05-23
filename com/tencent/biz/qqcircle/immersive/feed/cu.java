package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cu extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ImageView I;
    private View J;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        j1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void j1() {
        if (fb0.a.a(getTAG())) {
            QLog.d(getTAG(), 1, "[onShareBtnClick] return: fastDoubleClick");
        } else {
            k1(0);
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true, true));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k1(int i3) {
        if (this.f85017h == 0) {
            QLog.e("QFSFullScreenSharePresenter", 1, "[openSharePanel] mData == null");
            return;
        }
        if (s0() == null) {
            QLog.d("QFSFullScreenSharePresenter", 1, "[openSharePanel] feed ioc should not be null.");
            return;
        }
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.source = i3;
        c16.feedBlockData = this.E;
        QCircleExtraTypeInfo r16 = r();
        c16.extraTypeInfo = r16;
        r16.mDataPosition = this.f85018i;
        c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
        c16.mReportBean = getReportBean();
        c16.isShowDeletePush = false;
        c16.isShowDeletePushDisable = false;
        c16.isShowPersonalQrcode = false;
        c16.isShowPersonalQrcodeDown = false;
        c16.isShowSetToPublicPermission = false;
        c16.isShowSetToPrivatePermission = false;
        c16.isShowDeleteAndEditAlbum = false;
        c16.isShowPlayRate = false;
        c16.isShowCollect = false;
        c16.isShowUnCollect = false;
        c16.isShowFeedback = false;
        c16.isShowWatchLater = false;
        c16.isShowCancelWatchLater = false;
        c16.isNotAllowDownload = false;
        c16.isShowCopySchemaLink = false;
        c16.isShowFeedBindQQGroup = false;
        c16.isShowBackgroundMusic = false;
        c16.isShowCopyContent = false;
        c16.isShowDisLike = false;
        c16.isShowHideThisWork = false;
        c16.isShowQCircleEnterFloatingWindow = false;
        c16.isShowDelete = false;
        if (QCirclePluginUtil.isFeedOwner((FeedCloudMeta$StFeed) this.f85017h)) {
            c16.isShowReport = false;
        } else {
            c16.isShowReport = true;
            c16.isShowUnStick = false;
            c16.isShowStick = false;
        }
        br.D1(c16);
        s0().onHandlerMessage("event_open_share", c16);
        w20.a.j().m();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = view.findViewById(R.id.f42741kl);
        this.I = (ImageView) view.findViewById(R.id.f42731kk);
        this.J.setVisibility(0);
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ct
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cu.this.h1(view2);
            }
        });
        this.I.setImageResource(com.tencent.biz.qqcircle.k.p());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        f0(this.J, "em_xsj_share_button");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenSharePresenter";
    }
}
