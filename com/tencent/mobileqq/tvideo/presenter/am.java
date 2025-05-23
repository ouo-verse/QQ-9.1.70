package com.tencent.mobileqq.tvideo.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayPanelEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoIntroEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import tvideo.CoverBaseInfo;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class am extends af {
    private TextView L;
    private TextView M;
    private View N;
    private View P;

    private void n1(View view) {
        this.L = (TextView) view.findViewById(R.id.ywk);
        this.M = (TextView) view.findViewById(R.id.f166931j64);
        ImageView imageView = (ImageView) view.findViewById(R.id.f165728xe2);
        View findViewById = view.findViewById(R.id.xrh);
        this.N = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                am.this.o1(view2);
            }
        });
        this.P = view.findViewById(R.id.f112676ok);
        i1(view.findViewById(R.id.sxn), this.P);
        Option requestWidth = Option.obtain().setUrl("https://ugd.gtimg.com//vg/1675652241725_tvideo_full_screen_intro_icon.png").setTargetView(imageView).setRequestHeight(imageView.getHeight()).setRequestWidth(imageView.getWidth());
        requestWidth.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(requestWidth, null);
        VideoReport.setElementParams(this.N, gy2.c.g());
        VideoReport.setElementExposePolicy(this.N, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.N, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.N, "info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoIntroEvent());
        VideoReport.reportEvent("clck", this.N, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.C = view;
        n1(view);
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.af, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSTVideoAuthPayPanelEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.af, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSTVideoAuthPayPanelEvent) {
            QLog.d("QFSTVideoFullScreenTitlePresenter", 4, "QFSTVideoAuthPayPanelEvent");
            l1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        VideoBaseInfo videoBaseInfo;
        CoverBaseInfo coverBaseInfo;
        super.L0(feedCloudMeta$StFeed, i3);
        Video q16 = jy2.g.q(feedCloudMeta$StFeed);
        if (q16 != null && (coverBaseInfo = q16.cover_base_info) != null) {
            this.L.setText(coverBaseInfo.title);
        }
        if (q16 != null && (videoBaseInfo = q16.video_base_info) != null) {
            this.M.setText(videoBaseInfo.plot_title);
        }
        if (jy2.g.J(q16)) {
            this.N.setVisibility(8);
        } else {
            this.N.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.af, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoFullScreenTitlePresenter";
    }
}
