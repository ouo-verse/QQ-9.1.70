package com.tencent.mobileqq.tvideo.presenter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoIntroEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoMidAdPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import tvideo.CoverBaseInfo;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import tvideo.VideoRecommendReason;

/* loaded from: classes19.dex */
public class QFSTVideoBottomInfoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private TextView I;
    private TextView J;
    private LinearLayout K;
    private TextView L;
    private ImageView M;
    private View N;
    private View P;
    private ImageView Q;
    private TextView R;
    private GradientDrawable S;
    private ImageView T;
    private ImageView U;
    private TextView V;
    private int W = -1;
    private int X = -1;
    private boolean Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private Video f304624a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f304625b0;

    private void A1() {
        this.I.setText("");
        this.J.setText("");
        this.L.setText("");
        this.V.setText("");
        this.K.removeAllViews();
        this.Z = 0;
    }

    private void B1(Video video) {
        String str = video.cover_base_info.leading_actor;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("/");
        if (!jy2.g.C(this.f304624a0) && split.length >= 2) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    this.Z += ("#" + str2).length();
                    QLog.d("QFSTVideoBottomInfoPresenter", 4, str + " mActorTextLength = " + this.Z);
                    if (this.Z > 15) {
                        return;
                    }
                    this.K.addView(o1(str2, true));
                }
            }
            return;
        }
        this.K.addView(o1(str, false));
    }

    private boolean C1(Video video) {
        if (this.V == null) {
            return false;
        }
        String str = video.video_base_info.material_title;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SpannableString spannableString = new SpannableString("\u70ed\u8bae  " + str);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff6022")), 0, 2, 33);
        spannableString.setSpan(new StyleSpan(1), 0, 2, 33);
        this.V.setText(spannableString);
        return true;
    }

    private void D1(Video video) {
        this.N.setVisibility(8);
    }

    private void E1(Video video) {
        if (this.T == null) {
            return;
        }
        String str = video.cover_base_info.vertical_pic_url;
        if (!TextUtils.isEmpty(str)) {
            jy2.f.f411169a.j(this.T, str);
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
    }

    private boolean F1(Video video) {
        VideoRecommendReason videoRecommendReason;
        CoverBaseInfo coverBaseInfo = video.cover_base_info;
        if (coverBaseInfo == null || (videoRecommendReason = coverBaseInfo.recommend_reason) == null) {
            return false;
        }
        String str = videoRecommendReason.text;
        String str2 = videoRecommendReason.icon_url;
        String str3 = videoRecommendReason.font_color;
        String str4 = videoRecommendReason.label_color;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.R.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            jy2.f.f411169a.j(this.Q, str2);
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.R.setTextColor(Color.parseColor(str3));
        }
        int parseColor = Color.parseColor(str4);
        GradientDrawable gradientDrawable = this.S;
        if (gradientDrawable == null) {
            this.S = jy2.f.f411169a.g(r0.f(2), parseColor);
        } else {
            gradientDrawable.setColor(parseColor);
        }
        this.P.setBackground(this.S);
        return true;
    }

    private void G1(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video == null) {
            return;
        }
        A1();
        if (video.cover_base_info != null && (videoBaseInfo = video.video_base_info) != null) {
            this.W = videoBaseInfo.material_end_time;
            this.X = videoBaseInfo.material_starting_time;
            if (n1()) {
                if (C1(video)) {
                    this.V.setVisibility(0);
                } else {
                    this.V.setVisibility(8);
                }
            } else {
                this.V.setVisibility(8);
            }
            this.I.setText(video.cover_base_info.title);
            B1(video);
            E1(video);
            r1(video);
            if (!jy2.g.C(this.f304624a0) && !jy2.g.J(this.f304624a0)) {
                this.f304625b0.setVisibility(0);
                jy2.f.f411169a.j(this.U, "https://ugd.gtimg.com/vg/1687664313174_%25E7%259F%25A9%25E5%25BD%25A2.png");
            } else {
                this.f304625b0.setVisibility(8);
            }
        }
    }

    private boolean H1(Video video) {
        if (!TextUtils.isEmpty(video.video_base_info.video_type_name)) {
            this.L.setText(video.video_base_info.video_type_name);
            this.L.setVisibility(0);
            return true;
        }
        this.L.setVisibility(8);
        return false;
    }

    @NonNull
    private String m1(String str, final TextView textView) {
        textView.setPadding(12, 5, 12, 5);
        textView.setBackgroundResource(R.drawable.lyt);
        String str2 = "#" + str;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSTVideoBottomInfoPresenter.this.u1(textView, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = 20;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(12.0f);
        textView.setTag(str);
        return str2;
    }

    private boolean n1() {
        return false;
    }

    private TextView o1(String str, boolean z16) {
        QLog.d("QFSTVideoBottomInfoPresenter", 4, "getActorTextView actor =" + str + "isClickStyle =" + z16);
        TextView textView = new TextView(m0());
        if (z16) {
            str = m1(str, textView);
        } else {
            textView.setPadding(0, 0, 12, 0);
            textView.setTextSize(14.0f);
        }
        if (jy2.g.J(this.f304624a0)) {
            textView.setMaxLines(2);
        } else {
            textView.setMaxLines(1);
        }
        textView.setText(str);
        textView.setTextColor(-1);
        return textView;
    }

    private void p1(final QFSTVideoMidAdPlayEvent qFSTVideoMidAdPlayEvent) {
        pw2.g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSTVideoBottomInfoPresenter.this.v1(qFSTVideoMidAdPlayEvent);
            }
        });
    }

    private void q1(int i3) {
        if (this.V.getVisibility() == 0) {
            if ((this.Y && i3 < this.X) || i3 > this.W) {
                this.V.setVisibility(8);
                this.E.o("tvideo_material_played_transform", Boolean.TRUE);
            }
        }
    }

    private void r1(Video video) {
        boolean z16;
        if (video.cover_base_info.title.length() > 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (F1(video)) {
            this.P.setVisibility(0);
            this.N.setVisibility(8);
            if (z16) {
                this.L.setVisibility(8);
                return;
            } else if (this.R.getText().length() > 5) {
                this.L.setVisibility(8);
                return;
            } else {
                H1(video);
                return;
            }
        }
        this.P.setVisibility(8);
        if (H1(video) && z16) {
            this.N.setVisibility(8);
        } else {
            D1(video);
        }
    }

    private void s1(View view) {
        this.I = (TextView) view.findViewById(R.id.adh);
        this.J = (TextView) view.findViewById(R.id.t_q);
        this.K = (LinearLayout) view.findViewById(R.id.f166084yn0);
        this.M = (ImageView) view.findViewById(R.id.xej);
        this.L = (TextView) view.findViewById(R.id.f11802731);
        this.N = view.findViewById(R.id.xbl);
        this.P = view.findViewById(R.id.f71523od);
        this.Q = (ImageView) view.findViewById(R.id.xeg);
        this.R = (TextView) view.findViewById(R.id.f95635fi);
        this.U = (ImageView) view.findViewById(R.id.xre);
        this.V = (TextView) view.findViewById(R.id.f108666dq);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTVideoBottomInfoPresenter.this.w1(view2);
            }
        };
        ImageView imageView = (ImageView) view.findViewById(R.id.f165956y73);
        this.T = imageView;
        imageView.setOnClickListener(onClickListener);
        this.f304625b0 = view.findViewById(R.id.yor);
        View findViewById = view.findViewById(R.id.tb8);
        findViewById.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(R.id.f165956y73);
        findViewById2.setOnClickListener(onClickListener);
        this.f304625b0.setOnClickListener(onClickListener);
        VideoReport.setElementId(this.f304625b0, "info");
        VideoReport.setElementId(findViewById, "info");
        VideoReport.setElementId(findViewById2, "info");
        view.findViewById(R.id.f75673zl).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTVideoBottomInfoPresenter.x1(view2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean t1(QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return false;
        }
        return TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSVideoFeedPlayEvent.feedId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = new QFSTVideoPageWebViewShowEvent();
        qFSTVideoPageWebViewShowEvent.setWord((String) textView.getTag());
        qFSTVideoPageWebViewShowEvent.setVideoFeed(this.f304624a0);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPageWebViewShowEvent);
        Map<String, Object> i3 = gy2.c.i(this.f304624a0);
        i3.put("tag_name", (String) textView.getTag());
        VideoReport.reportEvent("clck", textView, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(QFSTVideoMidAdPlayEvent qFSTVideoMidAdPlayEvent) {
        boolean isStart = qFSTVideoMidAdPlayEvent.isStart();
        boolean isComplete = qFSTVideoMidAdPlayEvent.isComplete();
        if (isStart) {
            this.V.setVisibility(8);
        } else if (isComplete) {
            if (n1()) {
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!jy2.g.C(this.f304624a0) && !jy2.g.J(this.f304624a0)) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoIntroEvent());
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void z1() {
        LinearLayout linearLayout = this.K;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            this.K.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.QFSTVideoBottomInfoPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i3 = 0; i3 < QFSTVideoBottomInfoPresenter.this.K.getChildCount(); i3++) {
                        View childAt = QFSTVideoBottomInfoPresenter.this.K.getChildAt(i3);
                        Object tag = childAt.getTag();
                        if (tag instanceof String) {
                            VideoReport.setElementExposePolicy(childAt, ExposurePolicy.REPORT_NONE);
                            VideoReport.setElementClickPolicy(childAt, ClickPolicy.REPORT_NONE);
                            VideoReport.setElementId(childAt, "tag");
                            Map<String, Object> i16 = gy2.c.i(QFSTVideoBottomInfoPresenter.this.f304624a0);
                            i16.put("tag_name", tag);
                            VideoReport.reportEvent("imp", childAt, i16);
                        } else {
                            return;
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        s1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoFeedPlayEvent.class);
        arrayList.add(QFSSeekEvent.class);
        arrayList.add(QFSTVideoMidAdPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        this.Y = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            if (E0()) {
                QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = (QFSVideoFeedPlayEvent) simpleBaseEvent;
                if (t1(qFSVideoFeedPlayEvent)) {
                    q1(qFSVideoFeedPlayEvent.progress);
                    return;
                }
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            this.Y = !((QFSSeekEvent) simpleBaseEvent).mIsOnSeek;
        } else if (simpleBaseEvent instanceof QFSTVideoMidAdPlayEvent) {
            p1((QFSTVideoMidAdPlayEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoBottomInfoPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        Video q16 = jy2.g.q(feedCloudMeta$StFeed);
        this.f304624a0 = q16;
        G1(q16);
    }
}
