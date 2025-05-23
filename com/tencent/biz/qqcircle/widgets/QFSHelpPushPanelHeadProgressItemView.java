package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QFSHelpPushPanelItemInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class QFSHelpPushPanelHeadProgressItemView extends QCircleBaseWidgetView<QFSHelpPushPanelItemInfo> implements View.OnClickListener, SimpleEventReceiver {
    private static final int G = cx.a(92.0f);
    private static final float H = cx.a(20.0f);
    private static final float I = cx.a(20.0f);
    private ImageView C;
    private float D;
    private FeedCloudMeta$StUser E;
    private QFSPublishTipsUtils F;

    /* renamed from: d, reason: collision with root package name */
    private TextView f93259d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93260e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93261f;

    /* renamed from: h, reason: collision with root package name */
    private View f93262h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f93263i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f93264m;

    public QFSHelpPushPanelHeadProgressItemView(@NonNull Context context) {
        super(context);
        this.F = new QFSPublishTipsUtils();
        n0(this);
    }

    private void m0() {
        if (this.f93263i != null) {
            Option targetView = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_popup_generalbaoxiang_normal")).setRequestWidth(ImmersiveUtils.dpToPx(34.0f)).setRequestHeight(ImmersiveUtils.dpToPx(34.0f)).setTargetView(this.f93263i);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
        if (this.f93264m != null) {
            Option targetView2 = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_popup_superbaoxiang_normal")).setRequestWidth(ImmersiveUtils.dpToPx(34.0f)).setRequestHeight(ImmersiveUtils.dpToPx(34.0f)).setTargetView(this.f93264m);
            targetView2.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView2);
        }
    }

    private void n0(View view) {
        this.f93259d = (TextView) view.findViewById(R.id.f107156_n);
        this.f93260e = (TextView) view.findViewById(R.id.f107146_m);
        this.f93261f = (TextView) view.findViewById(R.id.f112206na);
        this.f93262h = view.findViewById(R.id.f511727d);
        this.f93263i = (ImageView) view.findViewById(R.id.y6c);
        this.f93264m = (ImageView) view.findViewById(R.id.y9n);
        ImageView imageView = (ImageView) view.findViewById(R.id.y8m);
        this.C = imageView;
        imageView.setOnClickListener(this);
        RFWTypefaceUtil.setNumberTypeface(this.f93260e, false);
        m0();
        this.D = (ImmersiveUtils.pxToDp(ImmersiveUtils.getScreenWidth()) - 16) - 40;
    }

    private void o0(TextView textView, String str, String str2) {
        String replace = str2.replace("%d", str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replace);
        int indexOf = replace.indexOf(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(getContext(), R.color.qvideo_skin_color_text_brand)), indexOf, str.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    private void p0() {
        if (this.C == null) {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[showHelpPushRuleTips] mIvRule should not be null");
        } else {
            RFWSmartPopupWindow.from(getContext()).setAnchor(this.C).setContentView(R.layout.gdc).setPosition(1).setAlignment(2).setOffsetDp(38.0f, 0.0f).show();
        }
    }

    private void q0(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        long j3;
        if (feedCloudMeta$PushBoxViewInfo != null && this.f93261f != null) {
            long j16 = feedCloudMeta$PushBoxViewInfo.total_heat_num.get();
            long j17 = feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get();
            long j18 = feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get();
            if (j16 < j17) {
                j3 = j17 - j16;
            } else if (j16 < j18) {
                j3 = j18 - j16;
            } else {
                j3 = 0;
            }
            if (j16 >= j18) {
                this.f93261f.setText("\u5df2\u5f00\u542f\u5168\u90e8\u5b9d\u7bb1");
                return;
            } else {
                o0(this.f93261f, com.tencent.biz.qqcircle.immersive.utils.r.g(j3, true), com.tencent.biz.qqcircle.utils.h.a(R.string.f194194b9));
                return;
            }
        }
        QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateHeatCountNeed] pushBoxViewInfo should not be null");
    }

    private void r0() {
        if (this.f93263i == null) {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateNormalBoxImg] normalBox should not be null");
            return;
        }
        Option targetView = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_popup_generalbaoxiang_open")).setRequestWidth(ImmersiveUtils.dpToPx(34.0f)).setRequestHeight(ImmersiveUtils.dpToPx(34.0f)).setTargetView(this.f93263i);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    private void s0(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        if (feedCloudMeta$PushBoxViewInfo == null) {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateProgress] pushBoxViewInfo should not be null");
            return;
        }
        long j3 = feedCloudMeta$PushBoxViewInfo.total_heat_num.get();
        long j16 = feedCloudMeta$PushBoxViewInfo.normal_box_heat_num.get();
        if (j3 < j16) {
            float f16 = H;
            int i3 = G;
            float f17 = f16 / i3;
            float f18 = (i3 - I) / i3;
            float f19 = (((float) j3) * 1.0f) / ((float) j16);
            if (f19 >= f17) {
                if (f19 > f18) {
                    f17 = f18;
                } else {
                    f17 = f19;
                }
            }
            w0((int) (f17 * i3));
            return;
        }
        long j17 = feedCloudMeta$PushBoxViewInfo.super_box_heat_num.get();
        float a16 = cx.a(this.D);
        float f26 = (H + (G + 34)) / a16;
        float f27 = (a16 - I) / a16;
        float f28 = (((float) j3) * 1.0f) / ((float) j17);
        if (f28 > 1.0f) {
            f26 = 1.0f;
        } else if (f28 >= f26) {
            if (f28 > f27) {
                f26 = f27;
            } else {
                f26 = f28;
            }
        }
        w0((int) (a16 * f26));
        r0();
        if (f26 == 1.0f) {
            x0();
        }
    }

    private void u0() {
        if (this.f93259d == null) {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateProgressHint] mTvCurProgressHint should not be null");
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.E;
        if (feedCloudMeta$StUser != null && TextUtils.equals(feedCloudMeta$StUser.f398463id.get(), QCirclePluginGlobalInfo.l())) {
            this.f93259d.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909443g));
        } else {
            this.f93259d.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909543h));
        }
    }

    private void v0(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        if (feedCloudMeta$PushBoxViewInfo != null && this.f93260e != null) {
            this.f93260e.setText(com.tencent.biz.qqcircle.immersive.utils.r.g(feedCloudMeta$PushBoxViewInfo.total_heat_num.get(), false));
        } else {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateProgressNum] pushBoxViewInfo should not be null");
        }
    }

    private void w0(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f93262h.getLayoutParams();
        layoutParams.width = i3;
        this.f93262h.setLayoutParams(layoutParams);
    }

    private void x0() {
        if (this.f93264m == null) {
            QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[updateSuperBoxImg] superBox should not be null");
            return;
        }
        Option targetView = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_popup_superbaoxiang_open")).setRequestWidth(ImmersiveUtils.dpToPx(34.0f)).setRequestHeight(ImmersiveUtils.dpToPx(34.0f)).setTargetView(this.f93264m);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gd_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSHelpPushPanelHeadProgressItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSHelpPushPanelItemInfo qFSHelpPushPanelItemInfo, int i3) {
        if (qFSHelpPushPanelItemInfo != null && qFSHelpPushPanelItemInfo.getPushBoxViewInfo() != null) {
            FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = qFSHelpPushPanelItemInfo.getPushBoxViewInfo();
            u0();
            v0(pushBoxViewInfo);
            q0(pushBoxViewInfo);
            s0(pushBoxViewInfo);
            return;
        }
        QLog.e("QFSHelpPushPanelHeadProgressItemView", 1, "[bindData] helpPushPanelItemInfo should not be null");
    }

    public void l0(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() != 4) {
            QLog.d("QFSHelpPushPanelHeadProgressItemView", 1, "[handleHelpPushPanelStateChange] event.getPanelType() = " + qCirclePanelStateEvent.getPanelType());
            return;
        }
        if (!qCirclePanelStateEvent.isShowing()) {
            this.F.j(this.C);
        }
        QLog.d("QFSHelpPushPanelHeadProgressItemView", 1, "[handleHelpPushPanelStateChange] cancelHelpPushRuleTipsRunnable event.isShowing() = " + qCirclePanelStateEvent.isShowing());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y8m) {
            p0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            l0((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    public void setShareUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.E = feedCloudMeta$StUser;
    }
}
