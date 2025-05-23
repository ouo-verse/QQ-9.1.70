package com.qzone.reborn.feedx.presenter.ad;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.UiThreadUtil;

/* loaded from: classes37.dex */
public class QZoneAdFeedBrokenWindowPresenter extends vg.a {
    private View F;
    private ImageView G;
    private LinearLayout H;
    private TextView I;
    private ImageView J;
    private volatile String K;
    private volatile Drawable L;
    private volatile int M = 0;

    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneAdFeedBrokenWindowPresenter.this.O();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        D(new cf.a(1005));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.L != null) {
            this.L.setCallback(null);
        }
        this.L = com.qzone.adapter.feedcomponent.i.H().K(this.K, false);
        if (this.L != null) {
            this.L.setCallback(this.G);
            QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "startBrokenWindowDrawable setBrokenWindowDrawable");
            this.G.setImageDrawable(this.L);
            return;
        }
        QLog.e("QZoneAdFeedBrokenWindowPresenter", 1, "startBrokenWindowDrawable setBrokenWindowDrawable is null");
    }

    private void Q(BusinessFeedData businessFeedData) {
        if (this.G == null) {
            return;
        }
        if (businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().extendInfo != null && businessFeedData.getRecommAction().extendInfo.containsKey(24)) {
            this.K = businessFeedData.getRecommAction().extendInfo.get(24);
            QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "updateBrokenWindowDrawable BrokenWindowDrawableUrl:" + this.K);
            return;
        }
        this.F.setVisibility(8);
        this.K = "";
    }

    private void R(final int i3) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                int e16 = ar.e(49.0f);
                int i16 = i3;
                ((FrameLayout.LayoutParams) QZoneAdFeedBrokenWindowPresenter.this.G.getLayoutParams()).height = i16 > 0 ? i16 + (e16 * 2) : 0;
                QZoneAdFeedBrokenWindowPresenter.this.G.requestLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final boolean z16) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    QZoneAdFeedBrokenWindowPresenter.this.S(z16);
                }
            });
            return;
        }
        if (this.J.getVisibility() == 8) {
            this.J.setVisibility(0);
        }
        if (z16) {
            this.J.setImageResource(R.drawable.qui_voice_mute);
        } else {
            this.J.setImageResource(R.drawable.qui_voice_low);
        }
        this.J.setColorFilter(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final int i3) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.8
                @Override // java.lang.Runnable
                public void run() {
                    QZoneAdFeedBrokenWindowPresenter.this.T(i3);
                }
            });
            return;
        }
        LinearLayout linearLayout = this.H;
        if (linearLayout == null || this.I == null) {
            return;
        }
        linearLayout.setVisibility(0);
        this.I.setVisibility(0);
        this.I.setText(nh.c.d(i3));
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (this.G == null) {
            return;
        }
        BusinessFeedData businessFeedData2 = this.f441565h;
        if (((businessFeedData2 == null || !businessFeedData2.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h)) != 31) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            Q(businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedBrokenWindowPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmr;
    }

    @Override // vg.a
    public void t(cf.b bVar) {
        int r16;
        super.t(bVar);
        if (bVar == null || this.G == null) {
            return;
        }
        switch (bVar.f30765a) {
            case 1001:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_PLAY");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneAdFeedBrokenWindowPresenter.this.G == null) {
                            return;
                        }
                        QZoneAdFeedBrokenWindowPresenter.this.P();
                        QZoneAdFeedBrokenWindowPresenter.this.G.setVisibility(0);
                    }
                });
                break;
            case 1002:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_STOP");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneAdFeedBrokenWindowPresenter.this.G == null) {
                            return;
                        }
                        QZoneAdFeedBrokenWindowPresenter.this.G.setImageDrawable(null);
                        QZoneAdFeedBrokenWindowPresenter.this.G.setVisibility(8);
                    }
                });
                break;
            case 1003:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_TIME_MUTE_LAYOUT_SHOW");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneAdFeedBrokenWindowPresenter.this.H != null) {
                            QZoneAdFeedBrokenWindowPresenter.this.H.setVisibility(0);
                        }
                    }
                });
                break;
            case 1004:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_TIME_MUTE_LAYOUT_HIDE");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneAdFeedBrokenWindowPresenter.this.H != null) {
                            QZoneAdFeedBrokenWindowPresenter.this.H.setVisibility(8);
                        }
                        QZoneAdFeedBrokenWindowPresenter.this.L = null;
                    }
                });
                break;
            case 1006:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_MUTE_TRUE");
                S(true);
                break;
            case 1007:
                QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_QZONE_AD_FEED_VIDEO_MUTE_FALSE");
                S(false);
                break;
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.I(bVar.f30766b, "event_key_qzone_ad_feed_video_view_height") && this.M != (r16 = qZoneAdFeedUtils.r(bVar.f30766b, "event_key_qzone_ad_feed_video_view_height"))) {
            R(r16);
            this.M = r16;
        }
        if (qZoneAdFeedUtils.I(bVar.f30766b, "event_key_qzone_ad_feed_video_update_remain_time")) {
            int r17 = qZoneAdFeedUtils.r(bVar.f30766b, "event_key_qzone_ad_feed_video_update_remain_time");
            QLog.d("QZoneAdFeedBrokenWindowPresenter", 1, "handleBroadcastMessage EVENT_KEY_QZONE_AD_FEED_VIDEO_UPDATE_TIME: " + r17);
            T(r17);
        }
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        if (view == null) {
            QLog.e("QZoneAdFeedBrokenWindowPresenter", 1, "[onInitView] error, containerView is null");
            return;
        }
        this.F = view;
        this.G = (ImageView) view.findViewById(R.id.mvl);
        this.H = (LinearLayout) view.findViewById(R.id.m_y);
        this.I = (TextView) view.findViewById(R.id.nks);
        this.J = (ImageView) view.findViewById(R.id.f162750ln3);
        this.H.setOnClickListener(new a());
    }
}
