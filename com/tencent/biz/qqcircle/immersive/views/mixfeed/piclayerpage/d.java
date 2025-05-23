package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.album.event.QFSSelectAlbumEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.aa;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private static final Pattern f90960a0 = Pattern.compile("#?\\{tagName=.*?\\}");
    private LinearLayout I;
    private QCircleAsyncTextView J;
    private QCircleAsyncTextView K;
    private LinearLayout L;
    private ImageView M;
    private TextView N;
    private ImageView P;
    private View Q;
    private View R;
    private TextView S;
    private LinearLayout T;
    private TextView U;
    private TextView V;
    private TextView W;
    private View X;
    private View Y;
    private BoldClickableSpan.OnClickBoldTextListener Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (d.this.V.getLayout() != null && d.this.V.getWidth() != ((int) d.this.V.getLayout().getLineWidth(0))) {
                d.this.V.removeOnLayoutChangeListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) d.this.V.getLayout().getLineWidth(0), -2);
                layoutParams.gravity = 16;
                d.this.V.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements RFWAsyncRichTextView.OnClickAtTextListener {
        b() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
        public void onClick(String str) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(str);
            qCircleInitBean.setFeed((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) d.this).f85017h);
            qCircleInitBean.setEnableReleaseAudioFocus(false);
            if (d.this.getReportBean() != null) {
                qCircleInitBean.setFromReportBean(d.this.getReportBean().m466clone());
            }
            com.tencent.biz.qqcircle.launcher.c.d0(d.this.m0(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements RFWAsyncRichTextView.OnClickHashTagTextListener {
        c() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
        public void onClick(String str) {
            QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
            FeedCloudMeta$StTagInfo c16 = QFSTagInfosUtil.c(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) d.this).f85017h).tagInfos.get(), str);
            if (c16 == null) {
                c16 = new FeedCloudMeta$StTagInfo();
                c16.tagName.set(str);
            }
            qCirclePolymerizationBean.setTagInfo(c16);
            if (d.this.getReportBean() != null) {
                qCirclePolymerizationBean.setFromReportBean(d.this.getReportBean().m466clone());
            }
            qCirclePolymerizationBean.setPolymerizationType(7);
            qCirclePolymerizationBean.setExt1From(3);
            qCirclePolymerizationBean.setEnableReleaseAudioFocus(false);
            d.this.o1(c16);
            com.tencent.biz.qqcircle.launcher.c.G(d.this.m0(), qCirclePolymerizationBean);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A1() {
        boolean z16 = false;
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = ((FeedCloudMeta$StFeed) this.f85017h).album_infos.get(0).album;
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbum.f398441id.get());
        qCircleFeedAlbumInfo.title = feedCloudMeta$FeedAlbum.title.get();
        qCircleFeedAlbumInfo.mFeedCount = feedCloudMeta$FeedAlbum.feed_count.get();
        if (feedCloudMeta$FeedAlbum.status.get() == 2) {
            z16 = true;
        }
        qCircleFeedAlbumInfo.isDraft = z16;
        QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
        try {
            qCircleAlbumBean.setFromReportBean(getReportBean().m466clone());
        } catch (Exception e16) {
            RFWLog.i("QFSNewContentDetailBodyDescPresenter", RFWLog.USR, "[jumpAlbumPage] -> " + e16.getMessage());
        }
        qCircleAlbumBean.setSourceType(52);
        qCircleAlbumBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
        SimpleEventBus.getInstance().dispatchEvent(new QFSSelectAlbumEvent(qCircleAlbumBean, m0().hashCode()));
    }

    private void B1(CharSequence charSequence) {
        if (this.J == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setVisibility(0);
        this.J.setSpecialClickAreaColor(R.color.qui_common_text_link);
        this.J.setNeedSpecialHashTagAreaBackground(false);
        this.J.setOnClickAtTextListener(new b());
        this.J.setOnClickHashTagTextListener(new c());
        this.J.setText(charSequence);
        p1(charSequence);
    }

    private void C1() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        this.V.setLayoutParams(layoutParams);
        this.V.addOnLayoutChangeListener(new a());
    }

    private void E1(CharSequence charSequence) {
        if (this.K == null) {
            QLog.e(getTAG(), 1, "[setTitle] mTvTitle == null");
        } else if (TextUtils.isEmpty(charSequence)) {
            this.K.setVisibility(8);
        } else {
            this.K.setVisibility(0);
            this.K.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F1() {
        if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[setTitleAndDesc] mData == null");
            return;
        }
        this.Z = new BoldClickableSpan.OnClickBoldTextListener() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.c
            @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
            public final void onClick(Object obj) {
                d.this.y1(obj);
            }
        };
        T t16 = this.f85017h;
        CharSequence[] O = r.O((FeedCloudMeta$StFeed) t16, ((FeedCloudMeta$StFeed) t16).content.get(), this.Z, true);
        E1(O[0]);
        B1(O[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G1() {
        String b16 = o.b((FeedCloudMeta$StFeed) this.f85017h);
        Long a16 = o.a((FeedCloudMeta$StFeed) this.f85017h);
        if (b16 != null && a16 != null) {
            this.R.setVisibility(0);
            ((TextView) this.C.findViewById(R.id.f39081ap)).setText(b16);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, a16);
            q1(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_ALBUM_ENTRANCE, hashMap);
            return;
        }
        this.R.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H1() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).musicInfo != null && this.Q != null && this.S != null) {
            if (!o.c((FeedCloudMeta$StFeed) t16)) {
                QLog.d("QFSNewContentDetailBodyDescPresenter", 1, "[updateFeedMusicView] musicName text is empty");
                this.Q.setVisibility(8);
                this.S.setText("");
                return;
            } else {
                this.Q.setVisibility(0);
                this.S.setText(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.musicName.get());
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_music_id", Long.valueOf(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.ID.get()));
                hashMap.put("xsj_music_name", ((FeedCloudMeta$StFeed) this.f85017h).musicInfo.musicName.get());
                q1(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_MUSIC_BAR, hashMap);
                return;
            }
        }
        QLog.e("QFSNewContentDetailBodyDescPresenter", 1, "[updateFeedMusicView] mFeed == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I1() {
        if (s0() != null && !com.tencent.biz.qqcircle.immersive.views.mixfeed.d.g(s0().getMInitBean())) {
            this.T.setVisibility(8);
            return;
        }
        if (!uq3.o.w()) {
            return;
        }
        String a16 = aa.a((FeedCloudMeta$StFeed) this.f85017h);
        if (TextUtils.isEmpty(a16)) {
            this.T.setVisibility(8);
            QLog.d("QFSNewContentDetailBodyDescPresenter", 1, "[updatePoiView] poi text is empty");
            return;
        }
        this.T.setVisibility(0);
        if (a16.contains("\u00b7")) {
            int indexOf = a16.indexOf("\u00b7");
            this.U.setText(a16.substring(0, indexOf));
            this.V.setText(a16.substring(indexOf + 1));
            C1();
            this.X.setVisibility(0);
            this.V.setVisibility(0);
        } else {
            this.U.setText(a16);
            this.X.setVisibility(8);
            this.V.setVisibility(8);
        }
        if (!TextUtils.isEmpty(((FeedCloudMeta$StFeed) this.f85017h).poiInfo.distanceText.get())) {
            this.W.setText(((FeedCloudMeta$StFeed) this.f85017h).poiInfo.distanceText.get());
            this.Y.setVisibility(0);
        } else {
            this.W.setText("");
            this.Y.setVisibility(8);
        }
        this.T.setOnClickListener(this);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LBS_NAME, a16);
        q1(this.T, QCircleDaTongConstant.ElementId.EM_XSJ_POI_BUTTON, hashMap);
    }

    private void J1(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        if (this.L == null) {
            return;
        }
        if (!QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed)) {
            this.L.setVisibility(8);
            return;
        }
        cq cqVar = cq.f92752a;
        boolean s16 = cqVar.s(feedCloudMeta$StFeed);
        QLog.d("QFSNewContentDetailBodyDescPresenter", 1, "[updatePrivateIconView] rightFlag=" + i3 + ", isFeedFromQZone=" + s16 + ", fromEvent=" + z16);
        if (s16) {
            Drawable l3 = cqVar.l(m0(), i3);
            int d16 = QFSQUIUtilsKt.d(m0(), R.color.qui_common_icon_secondary);
            if (l3 != null) {
                this.L.setVisibility(0);
                this.P.setVisibility(0);
                this.L.setClickable(true);
                l3.setColorFilter(new LightingColorFilter(0, d16));
                this.M.setImageDrawable(l3);
                this.N.setText(cqVar.j(i3));
                return;
            }
            this.L.setVisibility(8);
            return;
        }
        if (i3 == 2) {
            this.L.setVisibility(0);
            this.P.setVisibility(8);
            this.L.setClickable(false);
            this.M.setImageDrawable(QFSQUIUtilsKt.f(m0(), R.drawable.qui_lock, R.color.qui_common_icon_secondary));
            this.N.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19299490));
            return;
        }
        this.L.setVisibility(8);
    }

    private void K1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.L == null) {
            return;
        }
        if (!QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed)) {
            this.L.setVisibility(8);
        } else {
            J1(s1(feedCloudMeta$StFeed), feedCloudMeta$StFeed, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n1() {
        boolean z16;
        if (this.I == null) {
            return;
        }
        if (!o.c((FeedCloudMeta$StFeed) this.f85017h) && o.b((FeedCloudMeta$StFeed) this.f85017h) == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.C.findViewById(R.id.f54602fn).setVisibility(0);
        } else {
            this.C.findViewById(R.id.f54602fn).setVisibility(8);
        }
        bz.d(this.I, new Size(DisplayUtil.getInstantScreenWidth(this.I.getContext()), -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (this.J == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_topic_id", feedCloudMeta$StTagInfo.tagId.get());
        buildElementParams.put("xsj_topic_name", feedCloudMeta$StTagInfo.tagName.get());
        buildElementParams.put("xsj_action_type", "clck");
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC);
        VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC);
        VideoReport.setElementParams(this.J, buildElementParams);
        VideoReport.setElementClickPolicy(this.J, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.J, buildElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1(CharSequence charSequence) {
        T t16;
        if (this.J != null && (t16 = this.f85017h) != 0 && !((FeedCloudMeta$StFeed) t16).tagInfos.isEmpty()) {
            String b16 = QFSTagInfosUtil.b(((FeedCloudMeta$StFeed) this.f85017h).tagInfos.get());
            String a16 = QFSTagInfosUtil.a(((FeedCloudMeta$StFeed) this.f85017h).tagInfos.get());
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            if (getReportBean() != null) {
                VideoReport.setPageId(this.J, getReportBean().getDtPageId());
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_topic_name", b16);
            buildElementParams.put("xsj_custom_pgid", Integer.valueOf(y0()));
            buildElementParams.put("xsj_topic_id", a16);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC);
            VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC);
            VideoReport.reportEvent("ev_xsj_abnormal_imp", this.J, buildElementParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q1(View view, String str, Map<String, Object> map) {
        if (this.f85017h != 0 && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap(map);
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            hashMap.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private void r1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_USER_VIDEO_BUTTON);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private int s1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        cq cqVar = cq.f92752a;
        if (!cqVar.s(feedCloudMeta$StFeed)) {
            return feedCloudMeta$StFeed.right.ugcRight.rightFlag.get();
        }
        return cqVar.i(feedCloudMeta$StFeed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1() {
        T t16 = this.f85017h;
        if (t16 != 0) {
            cq cqVar = cq.f92752a;
            if (cqVar.s((FeedCloudMeta$StFeed) t16)) {
                cqVar.u(m0(), (FeedCloudMeta$StFeed) this.f85017h, 2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w1(View view) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            QLog.e("QFSNewContentDetailBodyDescPresenter", 1, "[jumpMusicPage] mFeed == null.");
            return;
        }
        if (((FeedCloudMeta$StFeed) t16).musicInfo.status.get() == 1) {
            QCircleToast.u(view.getContext().getString(R.string.f183963kl), 0, true);
            return;
        }
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = new QFSFlowAggregationInitBean();
        qFSFlowAggregationInitBean.setFeedMusic(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.get());
        qFSFlowAggregationInitBean.setAggregationType(43);
        qFSFlowAggregationInitBean.setEnableReleaseAudioFocus(false);
        com.tencent.biz.qqcircle.launcher.c.H(view.getContext(), qFSFlowAggregationInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x1(Context context) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poiInfo != null) {
            QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
            if (((FeedCloudMeta$StFeed) this.f85017h).poiInfo.gps != null) {
                QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
                qQCircleFeedBase$StFeedListBusiReqData.gpsInfo = ((FeedCloudMeta$StFeed) this.f85017h).poiInfo.gps;
                qCirclePolymerizationBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            }
            qCirclePolymerizationBean.setPolymerizationType(16);
            qCirclePolymerizationBean.setExt1From(1);
            qCirclePolymerizationBean.setPoiInfo(((FeedCloudMeta$StFeed) this.f85017h).poiInfo);
            qCirclePolymerizationBean.setEnableReleaseAudioFocus(false);
            com.tencent.biz.qqcircle.launcher.c.j0(context, qCirclePolymerizationBean);
            return;
        }
        QLog.w("QFSNewContentDetailBodyDescPresenter", 1, "[jumpLbsPage] invalid data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1(Object obj) {
        if (obj instanceof String) {
            com.tencent.biz.qqcircle.launcher.c.g(m0(), (String) obj);
            r1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D1() {
        au.m(new QCircleShareInfo(), (FeedCloudMeta$StFeed) this.f85017h);
        T t16 = this.f85017h;
        if (t16 != 0) {
            K1((FeedCloudMeta$StFeed) t16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(View view) {
        super.N0(view);
        this.I = (LinearLayout) view.findViewById(R.id.f46001te);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f40971ft);
        this.L = linearLayout;
        linearLayout.setOnClickListener(this);
        this.M = (ImageView) view.findViewById(R.id.f40981fu);
        this.N = (TextView) view.findViewById(R.id.f40961fs);
        this.P = (ImageView) view.findViewById(R.id.f40991fv);
        this.L.setOnClickListener(this);
        this.J = (QCircleAsyncTextView) view.findViewById(R.id.f365814y);
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) view.findViewById(R.id.f55602ic);
        this.K = qCircleAsyncTextView;
        qCircleAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_link);
        this.Q = view.findViewById(R.id.f40771f_);
        this.R = view.findViewById(R.id.f39121at);
        this.S = (TextView) view.findViewById(R.id.f40781fa);
        this.T = (LinearLayout) view.findViewById(R.id.f46551uw);
        this.U = (TextView) view.findViewById(R.id.f348910d);
        this.V = (TextView) view.findViewById(R.id.f46531uu);
        this.W = (TextView) view.findViewById(R.id.f365914z);
        this.X = view.findViewById(R.id.f46501ur);
        this.Y = view.findViewById(R.id.f46521ut);
        int a16 = QFSQUIUtilsKt.a(QFSQUIUtilsKt.d(m0(), R.color.qui_common_text_secondary), 0.3f);
        this.X.setBackgroundColor(a16);
        this.Y.setBackgroundColor(a16);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFeedPermissionChangeEvent.class);
        eventClass.add(QCircleFeedJSPermissionChangeEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f40771f_) {
            w1(view);
        } else if (id5 == R.id.f46551uw) {
            x1(view.getContext());
        } else if (id5 == R.id.f40971ft) {
            v1();
        } else if (id5 == R.id.f39121at) {
            A1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null) {
            rFWFeedSelectInfo.getPosition();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedPermissionChangeEvent) {
            u1((QFSFeedPermissionChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFeedJSPermissionChangeEvent) {
            t1((QCircleFeedJSPermissionChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            n1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null) {
            rFWFeedSelectInfo.getPosition();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t1(QCircleFeedJSPermissionChangeEvent qCircleFeedJSPermissionChangeEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCircleFeedJSPermissionChangeEvent.getFeedId())) {
            if (qCircleFeedJSPermissionChangeEvent.getRightFlag() == 0) {
                J1(qCircleFeedJSPermissionChangeEvent.getRightFlag(), (FeedCloudMeta$StFeed) this.f85017h, true);
            }
            cq.f92752a.v((FeedCloudMeta$StFeed) this.f85017h, qCircleFeedJSPermissionChangeEvent.getRightFlag(), qCircleFeedJSPermissionChangeEvent.getDownLoadOper());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u1(QFSFeedPermissionChangeEvent qFSFeedPermissionChangeEvent) {
        if (!TextUtils.equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), qFSFeedPermissionChangeEvent.getFeedId())) {
            return;
        }
        J1(qFSFeedPermissionChangeEvent.getRightFlag(), (FeedCloudMeta$StFeed) this.f85017h, true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSNewContentDetailBodyDescPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        T t16 = this.f85017h;
        if (t16 != 0 && t16 == feedCloudMeta$StFeed) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        F1();
        D1();
        H1();
        G1();
        I1();
        n1();
    }
}
