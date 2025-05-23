package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.immersive.album.event.QFSSelectAlbumEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends c implements View.OnClickListener {
    private static final List<Integer> H;
    private View D;
    private TextView E;
    private TextView F;
    private FeedCloudMeta$FeedAlbum G;

    static {
        ArrayList arrayList = new ArrayList();
        H = arrayList;
        arrayList.add(57);
        arrayList.add(501);
        arrayList.add(503);
        arrayList.add(591);
        arrayList.add(80001);
        arrayList.add(59);
        arrayList.add(Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED));
        arrayList.add(80000);
        arrayList.add(80002);
        arrayList.add(73);
        arrayList.add(71);
        arrayList.add(80003);
        arrayList.add(57);
        arrayList.add(52);
    }

    public g(a aVar) {
        super(aVar);
    }

    private void A(boolean z16) {
        int i3;
        View view = this.D;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void B(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!w() && feedCloudMeta$StFeed != null) {
            A(true);
            if (feedCloudMeta$StFeed.album_infos.get().size() == 0) {
                return;
            }
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = feedCloudMeta$StFeed.album_infos.get(0).album.get();
            this.G = feedCloudMeta$FeedAlbum;
            TextView textView = this.E;
            if (textView != null && this.F != null) {
                textView.setText(feedCloudMeta$FeedAlbum.title.get());
                this.F.setText("\u00b7" + this.D.getResources().getString(R.string.f1901841e) + this.G.feed_count.get() + this.D.getResources().getString(R.string.f1901941f));
                return;
            }
            return;
        }
        A(false);
    }

    private void t(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (u() != 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(u()));
            }
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private long u() {
        List<FeedCloudMeta$FeedAlbumInfo> list;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null || (list = feedCloudMeta$StFeed.album_infos.get()) == null || list.size() == 0) {
            return 0L;
        }
        return list.get(0).get().album.get().f398441id.get();
    }

    private void v() {
        if (!TextUtils.equals(p().getDtPageId(), "pg_xsj_explore_page") && !TextUtils.equals(p().getDtPageId(), "pg_xsj_gzh_page")) {
            x();
        } else {
            z();
        }
    }

    private boolean w() {
        return H.contains(Integer.valueOf(k().sourceType));
    }

    private void x() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        boolean z16 = true;
        if (this.G == null) {
            QLog.e("QFSFeedAlbumEntranceView", 1, "[jumpAlbumPage] mFeedAlbum is null.");
            return;
        }
        RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
        RFWPlayerPreRenderBean activity = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10004).setActivity((Activity) this.f90604h.getContext());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null) {
            feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
        } else {
            feedCloudMeta$StVideo = null;
        }
        rFWPlayerPreRenderHelper.playerRender(gb0.b.f(activity.setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setPreloadOriginData(gb0.b.m(new e30.b(this.f90602e))).setSourceType(com.tencent.biz.qqcircle.immersive.manager.g.e().i(p())).setIsJumpTrigger(uq3.o.U0()).setMultiLevel(false)));
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(this.G.f398441id.get());
        qCircleFeedAlbumInfo.title = this.G.title.get();
        qCircleFeedAlbumInfo.mFeedCount = this.G.feed_count.get();
        if (this.G.status.get() != 2) {
            z16 = false;
        }
        qCircleFeedAlbumInfo.isDraft = z16;
        QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
        try {
            qCircleAlbumBean.setFromReportBean(p().m466clone());
        } catch (Exception e16) {
            RFWLog.i("QFSFeedAlbumEntranceView", RFWLog.USR, "[jumpAlbumPage] -> " + e16.getMessage());
        }
        qCircleAlbumBean.setSourceType(52);
        qCircleAlbumBean.setFeed(this.f90602e);
        com.tencent.biz.qqcircle.launcher.c.u(this.f90604h.getContext(), qCircleAlbumBean);
    }

    private void y(@NonNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f39111as);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.D = inflate.findViewById(R.id.f39101ar);
        this.E = (TextView) inflate.findViewById(R.id.f39151aw);
        this.F = (TextView) inflate.findViewById(R.id.f39081ap);
        this.D.setOnClickListener(this);
        t(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_ALBUM_ENTRANCE);
    }

    private void z() {
        boolean z16;
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(this.G.f398441id.get());
        qCircleFeedAlbumInfo.title = this.G.title.get();
        qCircleFeedAlbumInfo.mFeedCount = this.G.feed_count.get();
        if (this.G.status.get() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        qCircleFeedAlbumInfo.isDraft = z16;
        QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
        try {
            qCircleAlbumBean.setFromReportBean(p().m466clone());
        } catch (Exception e16) {
            RFWLog.i("QFSFeedAlbumEntranceView", RFWLog.USR, "[jumpAlbumPage] -> " + e16.getMessage());
        }
        qCircleAlbumBean.setSourceType(52);
        qCircleAlbumBean.setFeed(this.f90602e);
        SimpleEventBus.getInstance().dispatchEvent(new QFSSelectAlbumEvent(qCircleAlbumBean, j().hashCode()));
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 115;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        if (!isElementCanActivate()) {
            A(false);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean f16 = c40.a.f(this.f90602e);
        if (this.f90602e != null) {
            QLog.i("QFSFeedAlbumEntranceView", 1, "feed:" + this.f90602e.f398449id.get() + " hasAlbum:" + f16 + " albumId:" + u());
        }
        return f16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39101ar) {
            v();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        y(this.f90604h);
        A(!w());
        B(this.f90602e);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        A(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
