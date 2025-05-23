package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCirclePushInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QFSSlidBottomView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPushRocketProgressPart extends u implements View.OnClickListener {
    private static final float Y = com.tencent.biz.qqcircle.utils.cx.a(20.0f);
    private static final float Z = com.tencent.biz.qqcircle.utils.cx.a(20.0f);

    /* renamed from: a0, reason: collision with root package name */
    private static final float f87525a0 = com.tencent.biz.qqcircle.utils.cx.a(80.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final float f87526b0 = com.tencent.biz.qqcircle.utils.cx.a(20.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final float f87527c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final float f87528d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final float f87529e0;
    private HorizontalScrollView C;
    private View D;
    private View E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ProgressBar N;
    private TextView P;
    private View Q;
    private Button R;
    private View S;
    private QCirclePushInfo T;
    private FeedCloudMeta$StFeed U;
    private String V;
    private String W;
    private boolean X = false;

    /* renamed from: d, reason: collision with root package name */
    private View f87530d;

    /* renamed from: e, reason: collision with root package name */
    private QFSSlidBottomView f87531e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f87532f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87533h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f87534i;

    /* renamed from: m, reason: collision with root package name */
    private View f87535m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends CharacterStyle {
        b() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            RFWTypefaceUtil.setNumberTypeface((Paint) textPaint, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f87545d;

        c(View view) {
            this.f87545d = view;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS) {
                this.f87545d.setBackground(new BitmapDrawable(option.getResultBitMap()));
            }
        }
    }

    static {
        float a16 = com.tencent.biz.qqcircle.utils.cx.a(32.0f);
        f87527c0 = a16;
        f87528d0 = com.tencent.biz.qqcircle.utils.cx.a(20.0f) + a16;
        f87529e0 = com.tencent.biz.qqcircle.utils.cx.a(80.0f);
    }

    private void H9(String str, View view) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void I9() {
        FeedCloudMeta$StPushList f16;
        QCirclePushInfo qCirclePushInfo;
        if (this.U != null && (f16 = QCirclePushInfoManager.e().f(this.U.f398449id.get())) != null && f16.pushBoxViewInfo.get() != null && (qCirclePushInfo = this.T) != null && qCirclePushInfo.mPushBoxViewInfo.get() != null) {
            FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo = this.T.mPushBoxViewInfo.get();
            this.f87534i.setText(feedCloudMeta$PushBoxViewInfo.push_time.get());
            this.V = feedCloudMeta$PushBoxViewInfo.rules_jump_url.get();
            this.W = feedCloudMeta$PushBoxViewInfo.task_center_jump_url.get();
            ca(this.f87533h, String.valueOf(f16.hasClickCount.get()), com.tencent.biz.qqcircle.utils.h.a(R.string.f194174b7));
            aa(feedCloudMeta$PushBoxViewInfo);
            T9(feedCloudMeta$PushBoxViewInfo.boxType.get(), (int) feedCloudMeta$PushBoxViewInfo.loading.get(), f16.hasClickCount.get());
            M9();
        }
    }

    private void J9(String str, View view, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementParams(this.R, buildElementParams);
    }

    private void K9() {
        boolean z16;
        QCirclePushInfo qCirclePushInfo = this.T;
        if (qCirclePushInfo != null && qCirclePushInfo.mPushBoxViewInfo != null) {
            if ((System.currentTimeMillis() / 1000) - this.T.mPushBoxViewInfo.push_timestamp.get() < 59) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.X = z16;
            if (!z16) {
                QCircleToast.j(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1921746s), 0);
            } else {
                if (this.U == null) {
                    return;
                }
                db0.d dVar = new db0.d();
                dVar.c(ua0.c.c(this.U).setToUin(this.U.poster.f398463id.get()).setPosition(this.T.mFeedPos).setPageId(getPageId()));
                QCirclePushInfoManager.e().m(this.U, dVar, 2);
            }
        }
    }

    private void L9() {
        QFSSlidBottomView qFSSlidBottomView = this.f87531e;
        if (qFSSlidBottomView == null) {
            return;
        }
        qFSSlidBottomView.d();
    }

    private void M9() {
        boolean z16;
        QCirclePushInfo qCirclePushInfo = this.T;
        if (qCirclePushInfo != null && qCirclePushInfo.mPushBoxViewInfo != null) {
            if ((System.currentTimeMillis() / 1000) - this.T.mPushBoxViewInfo.push_timestamp.get() < 59) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.X = z16;
            if (z16) {
                this.R.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_primary));
            } else {
                this.R.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_secondary));
            }
        }
    }

    private void N9(QCirclePushInfo qCirclePushInfo) {
        e30.b bVar;
        O9();
        if (qCirclePushInfo != null && (bVar = qCirclePushInfo.mFeedBlockData) != null && bVar.g() != null) {
            this.T = qCirclePushInfo;
            this.U = qCirclePushInfo.mFeedBlockData.g();
            ha();
        }
    }

    private void O9() {
        ViewStub viewStub;
        if (this.f87532f != null || (viewStub = (ViewStub) getPartRootView().findViewById(R.id.f511927f)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f87530d = inflate;
        this.f87532f = (LinearLayout) inflate.findViewById(R.id.f166091ed3);
        this.f87531e = (QFSSlidBottomView) this.f87530d.findViewById(R.id.f86324rc);
        this.f87533h = (TextView) this.f87530d.findViewById(R.id.f110206hw);
        this.f87534i = (TextView) this.f87530d.findViewById(R.id.f167040k71);
        this.f87535m = this.f87530d.findViewById(R.id.yqi);
        this.C = (HorizontalScrollView) this.f87530d.findViewById(R.id.f165711xb3);
        this.D = this.f87530d.findViewById(R.id.ypl);
        this.F = (TextView) this.f87530d.findViewById(R.id.f109616ga);
        this.G = (TextView) this.f87530d.findViewById(R.id.f109606g_);
        this.H = (TextView) this.f87530d.findViewById(R.id.f109586g8);
        this.E = this.f87530d.findViewById(R.id.yqv);
        this.I = (TextView) this.f87530d.findViewById(R.id.f111716lz);
        this.J = (TextView) this.f87530d.findViewById(R.id.f111706ly);
        this.K = (TextView) this.f87530d.findViewById(R.id.f111686lw);
        this.L = (TextView) this.f87530d.findViewById(R.id.f109596g9);
        this.M = (TextView) this.f87530d.findViewById(R.id.f111696lx);
        this.N = (ProgressBar) this.f87530d.findViewById(R.id.f511727d);
        this.P = (TextView) this.f87530d.findViewById(R.id.f112126n3);
        this.S = this.f87530d.findViewById(R.id.yqj);
        RFWTypefaceUtil.setNumberTypeface(this.P, false);
        RFWTypefaceUtil.setNumberTypeface(this.L, false);
        RFWTypefaceUtil.setNumberTypeface(this.M, false);
        this.Q = this.f87530d.findViewById(R.id.ak9);
        Button button = (Button) this.f87530d.findViewById(R.id.f164654td3);
        this.R = button;
        button.setText(String.format("%s%s", com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), com.tencent.biz.qqcircle.utils.h.a(R.string.f194224bb)));
        this.f87535m.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.f87530d.setVisibility(8);
        initSlideView();
        P9();
    }

    private void P9() {
        this.C.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final boolean z16 = true;
                if (motionEvent.getAction() == 1) {
                    if (QFSPushRocketProgressPart.this.C.getScrollX() <= (QFSPushRocketProgressPart.this.C.getChildAt(0).getRight() - ImmersiveUtils.getScreenWidth()) / 2) {
                        z16 = false;
                    }
                    QFSPushRocketProgressPart.this.C.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPushRocketProgressPart.this.W9(z16);
                        }
                    });
                }
                return false;
            }
        });
    }

    private void Q9() {
        if (TextUtils.isEmpty(this.V)) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.V);
    }

    private void R9() {
        if (TextUtils.isEmpty(this.V)) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.W);
    }

    private void S9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.U;
        if (feedCloudMeta$StFeed != null && this.T != null) {
            final QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c(feedCloudMeta$StFeed);
            QCirclePushInfo qCirclePushInfo = this.T;
            c16.feedBlockData = qCirclePushInfo.mFeedBlockData;
            c16.extraTypeInfo.mDataPosition = qCirclePushInfo.mFeedPos;
            c16.mReportBean = getReportBean();
            c16.source = 3;
            c16.shareStyleType = 1;
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart.7
                @Override // java.lang.Runnable
                public void run() {
                    QFSPushRocketProgressPart.this.broadcastMessage("share_action_show_share_sheet", c16);
                }
            }, 500L);
        }
    }

    private void T9(int i3, int i16, int i17) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BOX_PROGRESS_WINDOW);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_NEXT_BOX_TYPE, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_BOX_PROGRESS, Integer.valueOf(i16));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PERSONAL_PUSH_NUM, Integer.valueOf(i17));
        VideoReport.setElementId(this.f87530d, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BOX_PROGRESS_WINDOW);
        VideoReport.setElementExposePolicy(this.f87530d, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f87530d, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", this.f87530d, buildElementParams);
    }

    private void U9() {
        X9(false, false);
    }

    private void V9() {
        U9();
        this.P.setText((CharSequence) null);
        this.N.setProgress(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(boolean z16) {
        X9(z16, true);
    }

    private void X9(boolean z16, boolean z17) {
        float f16;
        int i3;
        if (!z17) {
            this.C.setSmoothScrollingEnabled(false);
        }
        View view = this.D;
        float f17 = 0.3f;
        if (z16) {
            f16 = 0.3f;
        } else {
            f16 = 1.0f;
        }
        view.setAlpha(f16);
        View view2 = this.E;
        if (z16) {
            f17 = 1.0f;
        }
        view2.setAlpha(f17);
        HorizontalScrollView horizontalScrollView = this.C;
        if (z16) {
            i3 = 66;
        } else {
            i3 = 17;
        }
        horizontalScrollView.fullScroll(i3);
        this.C.setSmoothScrollingEnabled(true);
    }

    private void Y9(View view, int i3, int i16, String str) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl(str)).setRequestWidth(i3).setRequestHeight(i16).setEnableAutoDeleteLocalCache(false), new c(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9(boolean z16) {
        if (getActivity() instanceof QCircleTransFragmentActivity) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), z16);
    }

    private void aa(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        int dimension = (int) getContext().getResources().getDimension(R.dimen.d4d);
        int dimension2 = (int) getContext().getResources().getDimension(R.dimen.d4_);
        int dimension3 = (int) getContext().getResources().getDimension(R.dimen.d4c);
        int dimension4 = (int) getContext().getResources().getDimension(R.dimen.d4a);
        if (feedCloudMeta$PushBoxViewInfo.total_heat_num.get() >= feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get()) {
            Y9(this.D, dimension, dimension2, "qvideo_skin_popup_bg_ordinarybox_opened");
            Y9(this.L, dimension3, dimension4, "qvideo_skin_popup_progress_point_done");
            this.L.setText((CharSequence) null);
            this.H.setVisibility(0);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.P.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.clh));
            ca(this.H, com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.normal_box_draw_count.get(), true), com.tencent.biz.qqcircle.utils.h.a(R.string.f194164b6));
            X9(true, false);
        } else {
            Y9(this.D, dimension, dimension2, "qvideo_skin_popup_bg_ordinarybox_unopened");
            Y9(this.L, dimension3, dimension4, "qvideo_skin_popup_progress_point_blue");
            this.L.setText(com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get(), true));
            this.H.setVisibility(8);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.P.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_brand));
            ca(this.F, com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get() - feedCloudMeta$PushBoxViewInfo.total_heat_num.get(), true), com.tencent.biz.qqcircle.utils.h.a(R.string.f194194b9));
        }
        if (feedCloudMeta$PushBoxViewInfo.total_heat_num.get() >= feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get()) {
            Y9(this.E, dimension, dimension2, "qvideo_skin_popup_bg_seniorbox_opened");
            Y9(this.M, dimension3, dimension4, "qvideo_skin_popup_progress_point_done");
            this.M.setText((CharSequence) null);
            this.K.setVisibility(0);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            ca(this.K, com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.super_box_draw_count.get(), true), com.tencent.biz.qqcircle.utils.h.a(R.string.f194164b6));
        } else {
            Y9(this.E, dimension, dimension2, "qvideo_skin_popup_bg_seniorbox_unopened");
            Y9(this.M, dimension3, dimension4, "qvideo_skin_popup_progress_point_orange");
            this.M.setText(com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get(), true));
            this.K.setVisibility(8);
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            ca(this.I, com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get() - feedCloudMeta$PushBoxViewInfo.total_heat_num.get(), true), com.tencent.biz.qqcircle.utils.h.a(R.string.f194194b9));
        }
        ba(feedCloudMeta$PushBoxViewInfo);
    }

    private void ba(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        long j3 = feedCloudMeta$PushBoxViewInfo.total_heat_num.get();
        long j16 = feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get();
        float f16 = 1.0f;
        if (j3 < j16) {
            this.N.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.l9_));
            float dimension = getContext().getResources().getDimension(R.dimen.d4b);
            float f17 = Y / dimension;
            float f18 = (dimension - Z) / dimension;
            float f19 = (((float) j3) * 1.0f) / ((float) j16);
            if (f19 >= f17) {
                if (f19 > f18) {
                    f17 = f18;
                } else {
                    f17 = f19;
                }
            }
            float f26 = f17 * dimension;
            ia((int) f26);
            float f27 = f87525a0;
            if (f26 > f27) {
                this.N.setProgress((int) (((f26 - f27) / f26) * 100.0f));
                return;
            }
            return;
        }
        this.N.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.l9a));
        long j17 = feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get();
        float dimension2 = getContext().getResources().getDimension(R.dimen.d4i);
        float dimension3 = getContext().getResources().getDimension(R.dimen.d4b) + getContext().getResources().getDimension(R.dimen.d4c);
        float f28 = (f87526b0 + dimension3) / dimension2;
        float f29 = (dimension2 - f87528d0) / dimension2;
        float f36 = (((float) j3) * 1.0f) / ((float) j17);
        if (f36 <= 1.0f) {
            if (f36 < f28) {
                f16 = f28;
            } else if (f36 > f29) {
                f16 = f29;
            } else {
                f16 = f36;
            }
        }
        float f37 = f16 * dimension2;
        ia((int) f37);
        float f38 = f87527c0;
        if (f37 > dimension2 - f38) {
            dimension3 = (f37 - f87529e0) - (f38 - (dimension2 - f37));
        } else {
            float f39 = f87529e0;
            if (f37 > f39 + dimension3) {
                dimension3 = f37 - f39;
            }
        }
        this.N.setProgress((int) ((dimension3 / f37) * 100.0f));
    }

    private void ca(TextView textView, String str, String str2) {
        String replace = str2.replace("%d", str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replace);
        int indexOf = replace.indexOf(str);
        spannableStringBuilder.setSpan(new b(), indexOf, str.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        ga();
        ea();
    }

    private void ea() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart.3

            /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart$3$a */
            /* loaded from: classes4.dex */
            class a implements ValueAnimator.AnimatorUpdateListener {
                a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSPushRocketProgressPart.this.P.setText(com.tencent.biz.qqcircle.immersive.utils.r.g(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) QFSPushRocketProgressPart.this.T.mPushBoxViewInfo.total_heat_num.get()), false));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(250L);
                duration.addUpdateListener(new a());
                duration.start();
            }
        }, 0L);
    }

    private void ga() {
        final int progress = this.N.getProgress();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart.4

            /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart$4$a */
            /* loaded from: classes4.dex */
            class a implements ValueAnimator.AnimatorUpdateListener {
                a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSPushRocketProgressPart.this.N.setProgress(progress + ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f)));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                duration.setInterpolator(new lc0.a(0.33f, 1.0f, 0.68f, 1.0f));
                duration.addUpdateListener(new a());
                duration.start();
            }
        }, 50L);
    }

    private void ha() {
        V9();
        I9();
        this.f87530d.setVisibility(0);
        this.f87531e.j(this.f87532f);
    }

    private void ia(int i3) {
        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
        layoutParams.width = i3;
        this.N.setLayoutParams(layoutParams);
    }

    private void initSlideView() {
        this.f87531e.c(new a());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPushRocketProgressPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("open_push_progress_panel".equals(str) && (obj instanceof QCirclePushInfo)) {
            N9((QCirclePushInfo) obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        View view = this.f87530d;
        if (view != null && view.getVisibility() == 0) {
            L9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ak9) {
            H9(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BOX_PROGRESS_WINDOW_SHARE_BUTTON, this.Q);
            L9();
            S9();
        } else if (id5 == R.id.yqi) {
            H9(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_MODULE_EXPLAIN_BUTTON, this.f87535m);
            Q9();
        } else if (id5 == R.id.yqj) {
            H9(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BOX_PROGRESS_CHECK_BUTTON, this.S);
            R9();
            L9();
        } else if (id5 == R.id.ypl) {
            W9(false);
        } else if (id5 == R.id.yqv) {
            W9(true);
        } else if (id5 == R.id.f164654td3) {
            HashMap hashMap = new HashMap();
            if (this.X) {
                str = "normal";
            } else {
                str = "disable";
            }
            hashMap.put("xsj_status", str);
            J9(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BOX_PROGRESS_WINDOW_CANCEL_ROCKET, this.R, hashMap);
            K9();
            L9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QFSSlidBottomView qFSSlidBottomView = this.f87531e;
        if (qFSSlidBottomView != null && qFSSlidBottomView.getVisibility() == 0) {
            this.f87531e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QCircleSlidBottomView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void a() {
            QFSPushRocketProgressPart.this.da();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onConfigurationChanged() {
            com.tencent.biz.qqcircle.utils.ad.a(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            String str;
            QFSPushRocketProgressPart.this.Z9(true);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSPushRocketProgressPart.this.getContext()));
            if (QFSPushRocketProgressPart.this.f87530d != null) {
                QFSPushRocketProgressPart.this.f87530d.setVisibility(8);
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (QFSPushRocketProgressPart.this.U == null) {
                str = "";
            } else {
                str = QFSPushRocketProgressPart.this.U.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(2, str, false));
            if (QFSPushRocketProgressPart.this.getActivity() != null) {
                QUIImmersiveHelper.s(QFSPushRocketProgressPart.this.getActivity().getParent(), false, true);
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onScrollChanged(int i3, int i16, int i17, int i18) {
            com.tencent.biz.qqcircle.utils.ad.b(this, i3, i16, i17, i18);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            String str;
            QFSPushRocketProgressPart.this.Z9(false);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSPushRocketProgressPart.this.getContext()));
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (QFSPushRocketProgressPart.this.U == null) {
                str = "";
            } else {
                str = QFSPushRocketProgressPart.this.U.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(2, str, true));
            if (QFSPushRocketProgressPart.this.getActivity() != null) {
                QUIImmersiveHelper.s(QFSPushRocketProgressPart.this.getActivity().getParent(), false, true);
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }
    }
}
