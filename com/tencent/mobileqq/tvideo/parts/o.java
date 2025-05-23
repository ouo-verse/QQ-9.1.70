package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.player.events.RFWTVKPlayerStatusEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandFullScreenEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsAdItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowStatusEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPendantToastEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScrollToNextEvent;
import com.tencent.mobileqq.tvideo.event.TVideoHalfWebViewHideEvent;
import com.tencent.mobileqq.tvideo.parts.ai;
import com.tencent.mobileqq.tvideo.pr.TVideoPrFloatShowShowEvent;
import com.tencent.mobileqq.tvideo.pr.TVideoRightPrPositionEvent;
import com.tencent.mobileqq.tvideo.pr.f;
import com.tencent.mobileqq.tvideo.webview.TVideoPublicWebView;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tvideo.TVideoFloatPr$FlowPoolReportInfo;
import tvideo.TVideoFloatPr$FlowPoolReportMap;
import tvideo.TVideoFloatPr$GetQqPromotionData;
import tvideo.TVideoFloatPr$QqDisplayInfo;
import tvideo.TVideoFloatPr$QqH5DisplayInfo;
import tvideo.TVideoFloatPr$QqPromotions;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class o extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {
    private TVideoPublicWebView C;
    private TVideoPublicWebView D;
    private TextView E;
    private ImageView F;
    private int H;
    private my2.b I;
    private ai K;
    private Video L;
    private String M;
    private String N;
    private int P;

    /* renamed from: e, reason: collision with root package name */
    private QCircleLayerBean f304570e;

    /* renamed from: f, reason: collision with root package name */
    private View f304571f;

    /* renamed from: h, reason: collision with root package name */
    private View f304572h;

    /* renamed from: i, reason: collision with root package name */
    private TVideoPublicWebView f304573i;

    /* renamed from: m, reason: collision with root package name */
    private TVideoPublicWebView f304574m;

    /* renamed from: d, reason: collision with root package name */
    private String f304569d = "https://fuli.v.qq.com/h5/activity/vg_activity/qq-video-list/index.html?topic=";
    private final SparseArray<Map<String, String>> J = new SparseArray<>();
    private final AtomicBoolean Q = new AtomicBoolean(true);
    private final AtomicBoolean R = new AtomicBoolean(false);
    private final ai.a S = new ai.a() { // from class: com.tencent.mobileqq.tvideo.parts.c
        @Override // com.tencent.mobileqq.tvideo.parts.ai.a
        public final void a(int i3, String str, String str2) {
            o.this.Da(i3, str, str2);
        }
    };
    private final com.tencent.mobileqq.tvideo.pr.c G = new com.tencent.mobileqq.tvideo.pr.c();

    public o(QCircleLayerBean qCircleLayerBean) {
        this.f304570e = qCircleLayerBean;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(QFSTVideoPendantToastEvent qFSTVideoPendantToastEvent, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        jy2.f.f411169a.i(getActivity(), qFSTVideoPendantToastEvent.getJumpUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.F.setTag("view_never_show_tag");
            this.F.setVisibility(8);
            this.E.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i3, String str, String str2) {
        if (X9(i3) != null && !ScreenUtils.isLandscape()) {
            if (X9(i3).getVisibility() == 0) {
                QLog.d("QFSLayerTVideoFloatWebViewPart", 1, " onDelayShowWebView VISIBLE");
                return;
            }
            if (!TextUtils.isEmpty(str2) && !str2.equals(this.M) && !str2.equals(this.N)) {
                return;
            }
            ja(true, X9(i3));
            X9(i3).loadUrl(str);
            Fa(X9(i3));
        }
    }

    private void Ea(QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent) {
        Map<String, Object> i3 = gy2.c.i(qFSTVideoPageWebViewShowEvent.getVideoFeed());
        i3.put("tag_name", qFSTVideoPageWebViewShowEvent.getWord());
        VideoReport.reportEvent("imp", this.f304574m, i3);
    }

    private void Fa(TVideoPublicWebView tVideoPublicWebView) {
        VideoReport.reportEvent("imp", tVideoPublicWebView, null);
    }

    private void Ga(TVideoPublicWebView tVideoPublicWebView) {
        if (tVideoPublicWebView != null && tVideoPublicWebView.getParent() != null && tVideoPublicWebView.getVisibility() == 0) {
            VideoReport.reportEvent("imp_end", tVideoPublicWebView, null);
        }
    }

    private void Ha() {
        com.tencent.mobileqq.tvideo.pr.c cVar;
        if (!ScreenUtils.isLandscape() && (cVar = this.G) != null) {
            cVar.R1(this.L);
        }
    }

    private void Ia() {
        this.R.set(false);
        TVideoPublicWebView tVideoPublicWebView = this.C;
        if (tVideoPublicWebView != null) {
            ja(false, tVideoPublicWebView);
            this.C.loadUrl("about:blank");
        }
    }

    private void Ja(final QFSTVideoPendantToastEvent qFSTVideoPendantToastEvent) {
        if (this.F != null && this.E != null && qFSTVideoPendantToastEvent.getShowTime() != 0) {
            jy2.f.f411169a.j(this.F, "https://ugd.gtimg.com/vg/1686738890098_icon_tvideo_pendant_toast.png");
            this.E.setText(qFSTVideoPendantToastEvent.getToastContent());
            this.F.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setTag("");
            if (!TextUtils.isEmpty(qFSTVideoPendantToastEvent.getJumpUrl())) {
                this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o.this.Ba(qFSTVideoPendantToastEvent, view);
                    }
                });
            }
            pw2.g.b(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.Ca();
                }
            }, qFSTVideoPendantToastEvent.getShowTime() * 1000);
        }
    }

    private void K9(TVideoPublicWebView tVideoPublicWebView) {
        if (!AppSetting.t(getContext())) {
            return;
        }
        int g16 = cx.g();
        ViewGroup.LayoutParams layoutParams = tVideoPublicWebView.getLayoutParams();
        int i3 = g16 / 2;
        layoutParams.width = i3;
        layoutParams.height = i3;
        tVideoPublicWebView.setLayoutParams(layoutParams);
    }

    private String L9(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && (this.f304570e instanceof TVideoLayerBean)) {
            if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = "?&";
            } else {
                str2 = ContainerUtils.FIELD_DELIMITER;
            }
            return str + str2 + "ts_msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + ((TVideoLayerBean) this.f304570e).getMsgType() + ContainerUtils.FIELD_DELIMITER + "notify_ext" + ContainerUtils.KEY_VALUE_DELIMITER + ((TVideoLayerBean) this.f304570e).getNotifyExt();
        }
        return str;
    }

    private void M9(View view, int i3) {
        if (view != null && view.getParent() != null) {
            Map<String, Object> g16 = gy2.c.g();
            if (this.J.get(i3) != null) {
                g16.putAll(this.J.get(i3));
            }
            VideoReport.setElementParams(view, g16);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementId(view, "resource_icon");
        }
    }

    private void N9(int i3) {
        if (i3 == 0) {
            return;
        }
        TVideoPublicWebView tVideoPublicWebView = this.D;
        if (tVideoPublicWebView != null && tVideoPublicWebView.getParent() != null && this.D.getVisibility() != 8 && this.P == 0) {
            if (!ScreenUtils.isLandscape()) {
                P9();
                return;
            }
            return;
        }
        this.P = i3;
        QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "changeRightWebViewPos mRightWebView = " + this.D + " mRightWebYPos = " + this.P);
    }

    private void O9() {
        TVideoPublicWebView tVideoPublicWebView = this.D;
        if (tVideoPublicWebView != null && tVideoPublicWebView.getParent() != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams.bottomToBottom = R.id.f122077cz;
            layoutParams.topToTop = -1;
            layoutParams.topToBottom = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cx.a(90.0f);
            this.D.setLayoutParams(layoutParams);
        }
    }

    private void P9() {
        TVideoPublicWebView tVideoPublicWebView = this.D;
        if (tVideoPublicWebView != null && tVideoPublicWebView.getParent() != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams.topToBottom = R.id.uzk;
            layoutParams.bottomToBottom = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = cx.a(17.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
            int i3 = this.P;
            if (i3 != 0) {
                layoutParams.topToBottom = -1;
                layoutParams.topToTop = R.id.f122077cz;
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i3 - cx.a(96.0f);
            }
            this.D.setLayoutParams(layoutParams);
        }
    }

    private void Q9(int i3, String str, int i16) {
        if (i16 == 0) {
            return;
        }
        if (this.K == null) {
            this.K = new ai(this.S);
        }
        this.K.b(i16, i3, str, this.G.D);
    }

    private void R9(TVideoFloatPr$QqPromotions tVideoFloatPr$QqPromotions) throws InvalidProtocolBufferMicroException {
        TVideoFloatPr$QqDisplayInfo tVideoFloatPr$QqDisplayInfo;
        if (tVideoFloatPr$QqPromotions != null && (tVideoFloatPr$QqDisplayInfo = tVideoFloatPr$QqPromotions.displayInfo) != null) {
            int i3 = tVideoFloatPr$QqDisplayInfo.displayType.get();
            if (i3 == 0) {
                QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "checkShowWebView QqDisplayTypeUnknown");
                return;
            }
            if ((2 == i3 || 1 == i3) && ScreenUtils.isLandscape()) {
                QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "checkShowWebView QqDisplayTypeOpenFace isLandscape");
                return;
            }
            V9(tVideoFloatPr$QqPromotions, i3);
            qa(getPartRootView(), i3);
            TVideoFloatPr$QqH5DisplayInfo tVideoFloatPr$QqH5DisplayInfo = new TVideoFloatPr$QqH5DisplayInfo();
            tVideoFloatPr$QqH5DisplayInfo.mergeFrom(tVideoFloatPr$QqPromotions.displayInfo.displayBytes.get().toByteArray());
            String L9 = L9(tVideoFloatPr$QqH5DisplayInfo.url.get());
            int i16 = tVideoFloatPr$QqH5DisplayInfo.showTime.get();
            Q9(i3, L9, tVideoFloatPr$QqH5DisplayInfo.showTime.get());
            QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "qqH5DisplayInfo = " + L9 + " delayShowTime = " + i16);
            if (X9(i3) != null && i16 == 0) {
                ja(true, X9(i3));
                X9(i3).loadUrl(L9);
                Fa(X9(i3));
            }
        }
    }

    private void S9(TVideoPublicWebView tVideoPublicWebView) {
        QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "destroyWebView");
        jy2.f.f411169a.b(tVideoPublicWebView);
    }

    private void T9() {
        com.tencent.mobileqq.tvideo.pr.e.e().c();
        this.G.f304603m.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.tvideo.parts.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                o.this.sa((TVideoFloatPr$GetQqPromotionData) obj);
            }
        });
        this.G.C.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.tvideo.parts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                o.this.ta((String) obj);
            }
        });
    }

    private String U9(QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent) {
        String str = this.f304569d + Uri.encode(qFSTVideoPageWebViewShowEvent.getWord());
        if (!TextUtils.isEmpty(qFSTVideoPageWebViewShowEvent.getAppCallTest())) {
            return str + "&isCallAppTest=" + qFSTVideoPageWebViewShowEvent.getAppCallTest();
        }
        return str;
    }

    private void V9(TVideoFloatPr$QqPromotions tVideoFloatPr$QqPromotions, int i3) {
        TVideoFloatPr$FlowPoolReportInfo tVideoFloatPr$FlowPoolReportInfo;
        if (tVideoFloatPr$QqPromotions != null && (tVideoFloatPr$FlowPoolReportInfo = tVideoFloatPr$QqPromotions.reportInfo) != null && tVideoFloatPr$FlowPoolReportInfo.report != null) {
            HashMap hashMap = new HashMap();
            for (TVideoFloatPr$FlowPoolReportMap tVideoFloatPr$FlowPoolReportMap : tVideoFloatPr$QqPromotions.reportInfo.report.get()) {
                if (tVideoFloatPr$FlowPoolReportMap == null) {
                    return;
                } else {
                    hashMap.put(tVideoFloatPr$FlowPoolReportMap.key.get(), tVideoFloatPr$FlowPoolReportMap.value.get());
                }
            }
            gy2.c.C(hashMap);
            this.J.put(i3, hashMap);
        }
    }

    private String W9() {
        if (jy2.g.y(this)) {
            return "qqSecFeed";
        }
        return "qqFeed";
    }

    private TVideoPublicWebView X9(int i3) {
        if (i3 == 1) {
            return this.f304573i;
        }
        if (i3 == 2) {
            return this.C;
        }
        if (i3 == 3) {
            return this.D;
        }
        return null;
    }

    private void Y9(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        if (configuration.orientation == 2) {
            ha();
            ja(false, this.f304573i);
            ja(false, this.C);
            O9();
            return;
        }
        P9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z9, reason: merged with bridge method [inline-methods] */
    public void Aa(QFSTVideoEpisodeExpandEvent qFSTVideoEpisodeExpandEvent) {
        ja(!qFSTVideoEpisodeExpandEvent.isExpand(), this.D);
        ia(!qFSTVideoEpisodeExpandEvent.isExpand());
        ca(qFSTVideoEpisodeExpandEvent.isExpand(), !qFSTVideoEpisodeExpandEvent.isClickEpisodeItem());
    }

    private void aa() {
        ja(false, this.C);
    }

    private void ba(QFSTVideoFeedsItemSelectedEvent qFSTVideoFeedsItemSelectedEvent) {
        Ia();
        int position = qFSTVideoFeedsItemSelectedEvent.getPosition();
        Video tVideoFeed = qFSTVideoFeedsItemSelectedEvent.getTVideoFeed();
        VideoBaseInfo videoBaseInfo = tVideoFeed.video_base_info;
        if (videoBaseInfo == null) {
            return;
        }
        this.L = tVideoFeed;
        String str = videoBaseInfo.cid;
        String str2 = videoBaseInfo.vid;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.M = str;
        this.N = str2;
        String h16 = com.tencent.mobileqq.tvideo.pr.e.e().h(this.M, this.N);
        if (this.Q.compareAndSet(true, false) || !TextUtils.isEmpty(h16)) {
            com.tencent.mobileqq.tvideo.pr.c cVar = this.G;
            f.a i3 = new f.a(W9(), ox2.b.e().d()).h(str).k(str2).i(position);
            if (!TextUtils.isEmpty(h16)) {
                str2 = h16;
            }
            cVar.Q1(i3.j(str2).g());
        }
        if (position > 0 && TextUtils.isEmpty(h16)) {
            QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "request longvideo selected");
            Ha();
        }
    }

    private void ca(boolean z16, boolean z17) {
        TVideoPublicWebView tVideoPublicWebView = this.C;
        if (tVideoPublicWebView != null) {
            if (z16) {
                if (tVideoPublicWebView.getVisibility() == 0) {
                    this.R.set(true);
                    ja(false, this.C);
                    return;
                }
                return;
            }
            if (this.R.compareAndSet(true, false) && z17) {
                ja(true, this.C);
            }
        }
    }

    private void da(RFWTVKPlayerStatusEvent rFWTVKPlayerStatusEvent) {
        my2.b bVar = this.I;
        if (bVar != null) {
            bVar.c(rFWTVKPlayerStatusEvent);
        }
    }

    private void ea(boolean z16) {
        QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "handleRightShowEvent isShow = " + z16);
        ja(z16, this.D);
        ia(z16);
    }

    private boolean ga(boolean z16, View view, View view2) {
        if (view == view2 && z16) {
            return "view_never_show_tag".equals(view.getTag());
        }
        return false;
    }

    private void ha() {
        TVideoPublicWebView tVideoPublicWebView = this.f304574m;
        if (tVideoPublicWebView != null && this.f304571f != null) {
            tVideoPublicWebView.loadUrl("about:blank");
            this.f304571f.setVisibility(8);
            SimpleEventBus.getInstance().dispatchEvent(new TVideoHalfWebViewHideEvent());
        }
    }

    private void ia(boolean z16) {
        ImageView imageView = this.F;
        if (imageView == null || this.E == null || ga(z16, imageView, imageView)) {
            return;
        }
        if (z16) {
            this.F.setVisibility(0);
            this.E.setVisibility(0);
        } else {
            this.F.setVisibility(8);
            this.E.setVisibility(8);
        }
    }

    private void ja(boolean z16, TVideoPublicWebView tVideoPublicWebView) {
        if (tVideoPublicWebView != null && tVideoPublicWebView.getParent() != null) {
            if (z16) {
                tVideoPublicWebView.setVisibility(0);
                return;
            } else {
                tVideoPublicWebView.setVisibility(8);
                return;
            }
        }
        QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "hideOrShowWeb webView.getParent() == null");
    }

    private void la(QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent) {
        TVideoPublicWebView tVideoPublicWebView = this.f304574m;
        if (tVideoPublicWebView != null) {
            tVideoPublicWebView.setVisibility(0);
            this.f304571f.setVisibility(0);
            this.f304574m.loadUrl(U9(qFSTVideoPageWebViewShowEvent));
            Ea(qFSTVideoPageWebViewShowEvent);
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f45581s_)).inflate();
        View findViewById = inflate.findViewById(R.id.f122077cz);
        this.f304571f = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.this.ua(view);
            }
        });
        TVideoPublicWebView tVideoPublicWebView2 = (TVideoPublicWebView) inflate.findViewById(R.id.x5p);
        this.f304574m = tVideoPublicWebView2;
        tVideoPublicWebView2.loadUrl(U9(qFSTVideoPageWebViewShowEvent));
        this.f304574m.setVisibilityChangeListener(new TVideoPublicWebView.c() { // from class: com.tencent.mobileqq.tvideo.parts.n
            @Override // com.tencent.mobileqq.tvideo.webview.TVideoPublicWebView.c
            public final void a(int i3) {
                o.this.va(i3);
            }
        });
        VideoReport.setElementExposePolicy(this.f304574m, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f304574m, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.f304574m, "tag_content");
        Ea(qFSTVideoPageWebViewShowEvent);
        K9(this.f304574m);
    }

    private TVideoPublicWebView ma(View view) {
        this.C = (TVideoPublicWebView) ((ViewStub) view.findViewById(R.id.f45601sb)).inflate().findViewById(R.id.yho);
        if (AppSetting.t(getContext())) {
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            layoutParams.width = cx.a(250.0f);
            this.C.setLayoutParams(layoutParams);
        }
        return this.C;
    }

    private TVideoPublicWebView na(View view) {
        View inflate = ((ViewStub) view.findViewById(R.id.f45591sa)).inflate();
        View findViewById = inflate.findViewById(R.id.f122077cz);
        this.f304572h = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o.this.wa(view2);
            }
        });
        TVideoPublicWebView tVideoPublicWebView = (TVideoPublicWebView) inflate.findViewById(R.id.vgu);
        this.f304573i = tVideoPublicWebView;
        tVideoPublicWebView.setVisibilityChangeListener(new TVideoPublicWebView.c() { // from class: com.tencent.mobileqq.tvideo.parts.e
            @Override // com.tencent.mobileqq.tvideo.webview.TVideoPublicWebView.c
            public final void a(int i3) {
                o.this.xa(i3);
            }
        });
        K9(this.f304573i);
        return this.f304573i;
    }

    private TVideoPublicWebView oa(View view) {
        View inflate = ((ViewStub) view.findViewById(R.id.f45611sc)).inflate();
        this.D = (TVideoPublicWebView) inflate.findViewById(R.id.f74903xi);
        this.E = (TextView) inflate.findViewById(R.id.f2368073);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f99225p8);
        this.F = imageView;
        imageView.setTag("view_never_show_tag");
        this.I = new my2.b(this.D);
        if (ScreenUtils.isLandscape()) {
            O9();
        } else {
            P9();
        }
        return this.D;
    }

    private TVideoPublicWebView pa(View view) {
        int i3 = this.H;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return oa(view);
            }
            return ma(view);
        }
        return na(view);
    }

    private void qa(View view, int i3) {
        if (view == null) {
            return;
        }
        this.H = i3;
        if (X9(i3) != null) {
            QLog.d("QFSLayerTVideoFloatWebViewPart", 1, this.H + " hasInitView");
            return;
        }
        TVideoPublicWebView pa5 = pa(view);
        if (pa5 != null) {
            pa5.setVisibility(8);
            M9(pa5, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ra(TVideoFloatPr$GetQqPromotionData tVideoFloatPr$GetQqPromotionData) {
        try {
            boolean z16 = true;
            for (TVideoFloatPr$QqPromotions tVideoFloatPr$QqPromotions : tVideoFloatPr$GetQqPromotionData.promotions.get()) {
                if (tVideoFloatPr$QqPromotions.displayInfo.displayType.get() == 2 || tVideoFloatPr$QqPromotions.displayInfo.displayType.get() == 1) {
                    z16 = false;
                }
                R9(tVideoFloatPr$QqPromotions);
                if (z16) {
                    QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "request longvideo promotions shouldGetLongVideoBanner");
                    Ha();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sa(final TVideoFloatPr$GetQqPromotionData tVideoFloatPr$GetQqPromotionData) {
        if (tVideoFloatPr$GetQqPromotionData != null && !bl.b(tVideoFloatPr$GetQqPromotionData.promotions.get())) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.j
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.ra(tVideoFloatPr$GetQqPromotionData);
                }
            });
        } else {
            QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "request longvideo promotions empty");
            Ha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ta(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(this.N) || ScreenUtils.isLandscape()) {
            return;
        }
        QLog.d("QFSLayerTVideoFloatWebViewPart", 1, "longVideoBubbleUrl = " + str);
        qa(getPartRootView(), 2);
        ja(true, X9(2));
        X9(2).loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ua(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ha();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void va(int i3) {
        if (i3 == 8) {
            ha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ja(false, this.f304573i);
        Ga(this.f304573i);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(int i3) {
        if (i3 == 8) {
            this.f304572h.setVisibility(8);
        } else {
            this.f304572h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoEpisodeExpandEvent) {
            pw2.g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.i
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.Aa(simpleBaseEvent);
                }
            });
            return;
        }
        if (simpleBaseEvent instanceof RFWTVKPlayerStatusEvent) {
            da((RFWTVKPlayerStatusEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof TVideoPrFloatShowShowEvent) {
            TVideoPrFloatShowShowEvent tVideoPrFloatShowShowEvent = (TVideoPrFloatShowShowEvent) simpleBaseEvent;
            ea(tVideoPrFloatShowShowEvent.isShow());
            if (tVideoPrFloatShowShowEvent.isHandleLeftWebView()) {
                ca(!tVideoPrFloatShowShowEvent.isShow(), tVideoPrFloatShowShowEvent.isNeedRestore());
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoEpisodeExpandFullScreenEvent) {
            ea(!((QFSTVideoEpisodeExpandFullScreenEvent) simpleBaseEvent).isExpand());
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoPageWebViewShowEvent) {
            QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = (QFSTVideoPageWebViewShowEvent) simpleBaseEvent;
            if (!qFSTVideoPageWebViewShowEvent.isFromAuthPay()) {
                la(qFSTVideoPageWebViewShowEvent);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoPendantToastEvent) {
            Ja((QFSTVideoPendantToastEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoFeedsItemSelectedEvent) {
            ba((QFSTVideoFeedsItemSelectedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoFeedsAdItemSelectedEvent) {
            aa();
            return;
        }
        if (simpleBaseEvent instanceof TVideoRightPrPositionEvent) {
            N9(((TVideoRightPrPositionEvent) simpleBaseEvent).getYPosition());
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoScrollToNextEvent) {
            ha();
        } else if (simpleBaseEvent instanceof QFSTVideoChannelClickEvent) {
            ja(false, this.f304573i);
        } else if (simpleBaseEvent instanceof QFSTVideoFloatingWindowStatusEvent) {
            ja(false, this.f304573i);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoEpisodeExpandEvent.class);
        arrayList.add(RFWTVKPlayerStatusEvent.class);
        arrayList.add(TVideoPrFloatShowShowEvent.class);
        arrayList.add(QFSTVideoEpisodeExpandFullScreenEvent.class);
        arrayList.add(QFSTVideoPageWebViewShowEvent.class);
        arrayList.add(QFSTVideoPendantToastEvent.class);
        arrayList.add(QFSTVideoFeedsItemSelectedEvent.class);
        arrayList.add(TVideoRightPrPositionEvent.class);
        arrayList.add(QFSTVideoFeedsAdItemSelectedEvent.class);
        arrayList.add(QFSTVideoScrollToNextEvent.class);
        arrayList.add(QFSTVideoChannelClickEvent.class);
        arrayList.add(QFSTVideoFloatingWindowStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoFloatWebViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        View view = this.f304571f;
        if (view != null && view.getVisibility() == 0) {
            ha();
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Y9(configuration);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        T9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        my2.b bVar = this.I;
        if (bVar != null) {
            bVar.e();
        }
        Ga(this.C);
        Ga(this.D);
        Ga(this.f304573i);
        S9(this.C);
        S9(this.D);
        S9(this.f304573i);
        S9(this.f304574m);
        ai aiVar = this.K;
        if (aiVar != null) {
            aiVar.d();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (jy2.g.u(this)) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.f
            @Override // java.lang.Runnable
            public final void run() {
                o.this.za(simpleBaseEvent);
            }
        });
    }
}
