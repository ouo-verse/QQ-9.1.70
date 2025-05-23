package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.beans.QCircleTopicRankItemInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSTagChallengeSelectEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTopicChallengeBannerClickEvent;
import com.tencent.biz.qqcircle.immersive.views.QCircleTopicFeedItemView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSCoverImageView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagChallenge;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTopicFeedItemView extends QCircleBaseWidgetView<QCircleTopicRankItemInfo> {
    public static final String M = "com.tencent.biz.qqcircle.immersive.views.QCircleTopicFeedItemView";
    private QFSCoverImageView C;
    private QFSCoverImageView D;
    private int E;
    private List<QFSCoverImageView> F;
    private LinearLayout G;
    private ImageView H;
    private Typeface I;
    private s70.b J;
    volatile QQAnimationDrawable K;
    final AnimationDrawableFactory.CreateResultListener L;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f90296d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f90297e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90298f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90299h;

    /* renamed from: i, reason: collision with root package name */
    private Button f90300i;

    /* renamed from: m, reason: collision with root package name */
    private QFSCoverImageView f90301m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements AnimationDrawableFactory.CreateResultListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QCircleTopicFeedItemView.this.C0();
        }

        @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
        public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
            if (z16 && qQAnimationDrawable != null) {
                qQAnimationDrawable.setOneShot(false);
                QCircleTopicFeedItemView.this.K = qQAnimationDrawable;
                QCircleTopicFeedItemView.this.K.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(QCircleTopicFeedItemView.this.getContext(), R.color.qui_common_text_primary), PorterDuff.Mode.SRC_IN));
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleTopicFeedItemView.a.this.b();
                    }
                });
                return;
            }
            QLog.e(QCircleTopicFeedItemView.M, 1, "fetch playing AnimDrawable fail!");
        }
    }

    public QCircleTopicFeedItemView(@NonNull Context context) {
        super(context);
        this.L = new a();
        w0(this);
        this.J = (s70.b) getViewModel(s70.b.class);
        this.I = Typeface.createFromAsset(getContext().getAssets(), "qvideodigit" + File.separator + "qvideo-digit-BoldItalic.ttf");
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleTopicRankItemInfo qCircleTopicRankItemInfo, QFSCoverImageView qFSCoverImageView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        x0(feedCloudMeta$StFeed, qCircleTopicRankItemInfo.getTagInfo());
        v0(qFSCoverImageView, qCircleTopicRankItemInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void B0() {
        AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_icon_music_wave_animation"));
        defaultBuilder.setFrameDuration(41);
        defaultBuilder.setCreateTimeOut(TTL.MAX_VALUE);
        q50.a.a(hashCode(), defaultBuilder.build(), this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        if (this.K == null) {
            QLog.e(M, 1, " playing AnimDrawable  is null");
        } else {
            this.H.setImageDrawable(this.K);
            this.K.start();
        }
    }

    private void q0(final QCircleTopicRankItemInfo qCircleTopicRankItemInfo, int i3) {
        List<FeedCloudMeta$StFeed> feeds = qCircleTopicRankItemInfo.getFeeds();
        if (feeds == null) {
            return;
        }
        int min = Math.min(feeds.size(), 3);
        for (int i16 = 0; i16 < min; i16++) {
            final FeedCloudMeta$StFeed feedCloudMeta$StFeed = feeds.get(i16);
            final QFSCoverImageView qFSCoverImageView = this.F.get(i16);
            qFSCoverImageView.setCorner(cx.a(4.0f));
            Option obtain = Option.obtain();
            obtain.setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setRequestWidth(u0()).setRequestHeight((int) (u0() / qFSCoverImageView.b())).setTargetView(qFSCoverImageView).setPredecode(true);
            QCircleFeedPicLoader.g().loadImage(obtain);
            qFSCoverImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleTopicFeedItemView.this.A0(feedCloudMeta$StFeed, qCircleTopicRankItemInfo, qFSCoverImageView, view);
                }
            });
            p0(qFSCoverImageView, QCircleDaTongConstant.ElementId.EM_XSJ_RANKING_TOPIC, qCircleTopicRankItemInfo, i3);
        }
    }

    private void r0(QCircleTopicRankItemInfo qCircleTopicRankItemInfo) {
        String string;
        if (qCircleTopicRankItemInfo.getTagInfo() == null) {
            this.f90299h.setText(getResources().getString(R.string.f185353oc));
            return;
        }
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = qCircleTopicRankItemInfo.getTagInfo().get();
        if (feedCloudMeta$StTagInfo != null) {
            FeedCloudMeta$StTagChallenge feedCloudMeta$StTagChallenge = feedCloudMeta$StTagInfo.get().tagChallengeData.get();
            TextView textView = this.f90299h;
            if (feedCloudMeta$StTagChallenge.subTitle.get() != null) {
                string = feedCloudMeta$StTagChallenge.subTitle.get();
            } else {
                string = getResources().getString(R.string.f185353oc);
            }
            textView.setText(string);
        }
    }

    private void s0(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f90296d.setVisibility(8);
                    this.f90297e.setVisibility(0);
                    this.f90297e.setText(String.valueOf(i3 + 1));
                    this.f90297e.setTypeface(this.I);
                    return;
                }
                this.f90296d.setVisibility(0);
                this.f90297e.setVisibility(8);
                this.f90296d.setImageDrawable(getResources().getDrawable(R.drawable.ot9));
                return;
            }
            this.f90296d.setVisibility(0);
            this.f90297e.setVisibility(8);
            this.f90296d.setImageDrawable(getResources().getDrawable(R.drawable.ot8));
            return;
        }
        this.f90296d.setVisibility(0);
        this.f90297e.setVisibility(8);
        this.f90296d.setImageDrawable(getResources().getDrawable(R.drawable.ot7));
    }

    private int u0() {
        int i3 = this.E;
        if (i3 != 0) {
            return i3;
        }
        int screenWidth = (DisplayUtil.getScreenWidth() - DisplayUtil.dip2px(getContext(), 44.0f)) / 3;
        this.E = screenWidth;
        return screenWidth;
    }

    private void w0(View view) {
        this.f90296d = (ImageView) view.findViewById(R.id.f70463li);
        this.f90297e = (TextView) view.findViewById(R.id.f70483lk);
        this.f90298f = (TextView) view.findViewById(R.id.juh);
        this.f90299h = (TextView) view.findViewById(R.id.ya6);
        this.f90300i = (Button) view.findViewById(R.id.yag);
        this.f90301m = (QFSCoverImageView) view.findViewById(R.id.f100275s2);
        this.C = (QFSCoverImageView) view.findViewById(R.id.f100285s3);
        this.D = (QFSCoverImageView) view.findViewById(R.id.f100295s4);
        if (this.F == null) {
            this.F = new ArrayList();
        }
        this.F.add(this.f90301m);
        this.F.add(this.C);
        this.F.add(this.D);
        this.G = (LinearLayout) view.findViewById(R.id.f55822iy);
        this.H = (ImageView) view.findViewById(R.id.f55812ix);
    }

    private void x0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        QCircleTagChallengeInfo qCircleTagChallengeInfo = new QCircleTagChallengeInfo();
        qCircleTagChallengeInfo.mTagId = feedCloudMeta$StTagInfo.tagId.get();
        SimpleEventBus.getInstance().dispatchEvent(new QFSTagChallengeSelectEvent(qCircleTagChallengeInfo, feedCloudMeta$StFeed));
        SimpleEventBus.getInstance().dispatchEvent(new QFSTopicChallengeBannerClickEvent());
        QCircleTagChallengeInfo qCircleTagChallengeInfo2 = new QCircleTagChallengeInfo();
        qCircleTagChallengeInfo2.mTagId = feedCloudMeta$StTagInfo.tagId.get();
        this.J.Q1().setValue(qCircleTagChallengeInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(QCircleTopicRankItemInfo qCircleTopicRankItemInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (qCircleTopicRankItemInfo.getFeeds() != null && qCircleTopicRankItemInfo.getFeeds().size() > 0) {
            x0(qCircleTopicRankItemInfo.getFeeds().get(0), qCircleTopicRankItemInfo.getTagInfo());
            v0(this.f90298f, qCircleTopicRankItemInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(QCircleTopicRankItemInfo qCircleTopicRankItemInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c40.d.i(getContext(), qCircleTopicRankItemInfo.getTopicName());
        v0(this.f90300i, qCircleTopicRankItemInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gtb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return M;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(final QCircleTopicRankItemInfo qCircleTopicRankItemInfo, int i3) {
        int i16;
        if (qCircleTopicRankItemInfo == null) {
            return;
        }
        s0(i3);
        q0(qCircleTopicRankItemInfo, i3);
        r0(qCircleTopicRankItemInfo);
        this.f90298f.setText(qCircleTopicRankItemInfo.getTopicName());
        this.f90298f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleTopicFeedItemView.this.y0(qCircleTopicRankItemInfo, view);
            }
        });
        this.f90300i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleTopicFeedItemView.this.z0(qCircleTopicRankItemInfo, view);
            }
        });
        boolean isIsPlaying = qCircleTopicRankItemInfo.isIsPlaying();
        LinearLayout linearLayout = this.G;
        int i17 = 0;
        if (isIsPlaying) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        linearLayout.setVisibility(i16);
        TextView textView = this.f90299h;
        if (isIsPlaying) {
            i17 = 8;
        }
        textView.setVisibility(i17);
        qCircleTopicRankItemInfo.setIsPlaying(isIsPlaying);
        p0(this, QCircleDaTongConstant.ElementId.EM_XSJ_RANKING_TOPIC, qCircleTopicRankItemInfo, i3);
        p0(this.f90300i, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON, qCircleTopicRankItemInfo, i3);
        p0(this.f90298f, QCircleDaTongConstant.ElementId.EM_XSJ_RANKING_TOPIC, qCircleTopicRankItemInfo, i3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.E = 0;
    }

    public void p0(View view, String str, QCircleTopicRankItemInfo qCircleTopicRankItemInfo, int i3) {
        String str2;
        try {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
            if (qCircleTopicRankItemInfo != null) {
                str2 = qCircleTopicRankItemInfo.getTopicName();
            } else {
                str2 = "";
            }
            buildElementParams.put("xsj_topic_name", str2);
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_CHALLENGE_RANKING_PAGE);
            VideoReport.setElementId(view, str);
            VideoReport.setElementReuseIdentifier(view, str + "_" + i3);
            VideoReport.setElementParams(view, buildElementParams);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(M, 1, e16.getMessage());
        }
    }

    public void v0(View view, QCircleTopicRankItemInfo qCircleTopicRankItemInfo) {
        try {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_topic_name", qCircleTopicRankItemInfo.getTopicName());
            buildElementParams.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(M, 1, e16.getMessage());
        }
    }
}
