package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDynamicCoverController implements View.OnLongClickListener, IObserver.main {
    private static String E = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_QZONE_Dynamic_Cover_URL, QzoneConfig.QZONE_Dynamic_Cover_URL_VALUE);
    private static int F = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_QZONE_Dynamic_Cover_ANIMATE_TIME, 25);
    private boolean C = false;
    private ZipFrameLoadedListener D = new ZipFrameLoadedListener() { // from class: com.qzone.cover.ui.QzoneDynamicCoverController.1
        @Override // cooperation.qzone.zipanimate.ZipFrameLoadedListener
        public void onLoaded(int i3, Drawable drawable) {
            if (drawable == null || QzoneDynamicCoverController.this.f46750f == null) {
                return;
            }
            final int intrinsicHeight = drawable.getIntrinsicHeight();
            final int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return;
            }
            QzoneDynamicCoverController.this.f46749e.post(new Runnable() { // from class: com.qzone.cover.ui.QzoneDynamicCoverController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) QzoneDynamicCoverController.this.f46750f.getLayoutParams();
                    layoutParams.width = (int) (intrinsicWidth * QzoneDynamicCoverController.this.f46751h);
                    layoutParams.height = (int) (intrinsicHeight * QzoneDynamicCoverController.this.f46751h);
                    layoutParams.topMargin = (Math.abs(CoverEnv.getCoverFriendPaddingTop()) + ((ar.l() + CoverEnv.getCoverFriendPaddingTop()) / 2)) - (layoutParams.height / 2);
                    QzoneDynamicCoverController.this.f46750f.setLayoutParams(layoutParams);
                }
            });
            if (QzoneDynamicCoverController.this.C) {
                return;
            }
            QzoneDynamicCoverController.this.C = true;
            if (QzoneDynamicCoverController.this.f46753m <= 0) {
                QzoneDynamicCoverController.this.f46753m = 3500L;
            }
            QzoneDynamicCoverController.this.f46749e.postDelayed(new Runnable() { // from class: com.qzone.cover.ui.QzoneDynamicCoverController.1.2
                @Override // java.lang.Runnable
                public void run() {
                    QzoneDynamicCoverController.this.j();
                }
            }, QzoneDynamicCoverController.this.f46753m);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private Drawable f46748d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f46749e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f46750f;

    /* renamed from: h, reason: collision with root package name */
    private float f46751h;

    /* renamed from: i, reason: collision with root package name */
    private Context f46752i;

    /* renamed from: m, reason: collision with root package name */
    private long f46753m;

    public QzoneDynamicCoverController(View view, Context context, ImageView imageView) {
        this.f46752i = context;
        if (view == null) {
            return;
        }
        this.f46750f = imageView;
        imageView.setOnLongClickListener(this);
        this.f46750f.setVisibility(8);
        this.f46749e = new Handler(Looper.getMainLooper());
        this.f46751h = ar.l() / 720.0f;
        EventCenter.getInstance().addUIObserver(this, "Cover", 1);
    }

    private Drawable h(String str, int i3, boolean z16) {
        if (this.f46748d != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f46748d);
        }
        this.f46748d = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.f46748d, str, i3);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.f46748d);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f46748d, z16);
        if (z16) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).loadAndShowFirstFrame(this.f46748d);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.f46748d, this.f46751h);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setDrawableLoadedListener(this.f46748d, this.D);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f46748d);
        return this.f46748d;
    }

    public void i() {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(302, 7, 13), false, false);
        Intent intent = new Intent(this.f46752i, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", E);
        intent.putExtra("fromQZone", true);
        Context context = this.f46752i;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, -1);
        }
    }

    public void j() {
        if (this.f46748d != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46748d);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f46748d);
            this.f46750f.setVisibility(8);
        }
        EventCenter.getInstance().removeObserver(this);
    }

    public void k() {
        if (this.f46748d != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46748d);
        }
    }

    public void l() {
        if (this.f46748d == null || this.f46750f.getVisibility() != 0) {
            return;
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.f46748d);
    }

    public void m(String str) {
        if (this.f46750f == null || TextUtils.isEmpty(str)) {
            return;
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(302, 7, 14), false, false);
        this.f46750f.setImageDrawable(h(str, F, true));
        this.f46750f.setVisibility(0);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QbossAdvDesc qbossAdvDesc;
        j.e("QzoneDynamicCoverController", 4, "onEventUIThread type = " + event.what);
        if ("Cover".equals(event.source.getName()) && event.what == 1 && (qbossAdvDesc = (QbossAdvDesc) event.params) != null) {
            String str = qbossAdvDesc.res_data;
            if (!TextUtils.isEmpty(str)) {
                try {
                    String string = new JSONObject(str).getString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                    this.f46753m = r0.getInt("duration");
                    m(string);
                    return;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    j.d("QzoneDynamicCoverController", " qboss json parse error ", e16);
                    return;
                }
            }
            j.c("QzoneDynamicCoverController", " resData = null ");
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        i();
        j();
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }
}
