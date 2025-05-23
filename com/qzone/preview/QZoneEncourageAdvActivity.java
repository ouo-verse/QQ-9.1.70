package com.qzone.preview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneAdvService;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.SystemTools;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.av.utils.ba;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.CircleProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneEncourageAdvActivity extends BaseFragment implements View.OnClickListener {

    /* renamed from: v0, reason: collision with root package name */
    public static boolean f49645v0 = true;

    /* renamed from: w0, reason: collision with root package name */
    private static String f49646w0;

    /* renamed from: x0, reason: collision with root package name */
    private static String f49647x0;
    private View C;
    private VideoPlayInfo D;
    private View N;
    private View P;
    private int Q;
    private int R;
    private ProgressBar S;
    private g U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private AsyncImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private AsyncImageView f49648a0;

    /* renamed from: b0, reason: collision with root package name */
    private AsyncImageView f49649b0;

    /* renamed from: c0, reason: collision with root package name */
    private AsyncImageView f49650c0;

    /* renamed from: d0, reason: collision with root package name */
    private AsyncImageView f49651d0;

    /* renamed from: h0, reason: collision with root package name */
    private QZoneEncourageAdvVideo f49655h0;

    /* renamed from: i0, reason: collision with root package name */
    private QZoneAdvService f49656i0;

    /* renamed from: j0, reason: collision with root package name */
    private BusinessFeedData f49657j0;

    /* renamed from: k0, reason: collision with root package name */
    private PictureItem f49658k0;

    /* renamed from: p0, reason: collision with root package name */
    private Drawable f49663p0;
    private boolean E = true;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private int M = 0;
    private long T = 6000;

    /* renamed from: e0, reason: collision with root package name */
    private String f49652e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    private boolean f49653f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f49654g0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f49659l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f49660m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f49661n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    private BaseVideoManager.VideoPlayInfoListener f49662o0 = new c();

    /* renamed from: q0, reason: collision with root package name */
    private AsyncImageable.AsyncImageListener f49664q0 = new d();

    /* renamed from: r0, reason: collision with root package name */
    private AsyncImageable.AsyncImageListener f49665r0 = new e();

    /* renamed from: s0, reason: collision with root package name */
    private final int f49666s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    private final int f49667t0 = 1;

    /* renamed from: u0, reason: collision with root package name */
    private Handler f49668u0 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends ImageProcessor {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return new CircleProcessor().process(new SpecifiedSizeCropByPivotProcessor(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()).process(drawable));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements BaseVideoManager.VideoPlayInfoListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
            QZoneEncourageAdvActivity.this.I = true;
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-3);
            QLog.i("ljh", 4, "3 onVideoPlayComplete --- ");
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (QZoneEncourageAdvActivity.this.F) {
                QZoneEncourageAdvActivity.this.F = false;
                QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-8);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
            QLog.i("ljh", 4, "1 onVideoPlayStart --- height = " + QZoneEncourageAdvActivity.this.f49655h0.getMeasuredHeight());
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-2);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
            QLog.i("ljh", 4, "4 onVideoPlayStop --- ");
            if (QZoneEncourageAdvActivity.this.I || QZoneEncourageAdvActivity.this.F) {
                return;
            }
            QLog.i("ljh", 4, "video play error --- ");
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-4);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
            QLog.i("ljh", 4, "5 onVideoPlayError --- ");
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-4);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            QLog.i("ljh", 4, "2 onVideoPlayPause --- ");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AsyncImageable.AsyncImageListener {
        d() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-4);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            QLog.i("ljh", 4, "onImageLoaded, setPlayingUI() ");
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-2);
            QZoneEncourageAdvActivity.this.Xh();
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g extends CountDownTimer {
        public g(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Message obtain = Message.obtain();
            obtain.obj = Boolean.TRUE;
            obtain.what = -7;
            QZoneEncourageAdvActivity.this.f49668u0.sendMessage(obtain);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            QZoneEncourageAdvActivity.this.T = j3;
            QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-6);
        }
    }

    private void Lh() {
        this.N.setVisibility(0);
        this.S.setVisibility(8);
    }

    private void Nh() {
        if (this.J) {
            return;
        }
        AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "QZoneEncourageAdvActivity::exposure", "");
        this.J = true;
        GdtFeedUtilForQZone.B(this.f49657j0, GdtFeedUtilForQZone.d(0, 7), this.f49657j0.getFeedCommInfo().isInstalled, null, false);
    }

    private void Oh() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("gdt_adv_activity_factory_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    f49647x0 = jSONObject.optString("factoryId");
                    f49646w0 = jSONObject.optString("appid");
                    this.f49652e0 = jSONObject.optString("callback");
                    if (jSONObject.has("screen")) {
                        this.M = jSONObject.optInt("screen") == 1 ? 0 : 1;
                    }
                } catch (JSONException e16) {
                    QLog.e("ljh", 4, "e = " + e16);
                    e16.printStackTrace();
                }
            }
            QLog.i("ljh", 4, "factoryId = " + f49647x0 + ", appid = " + f49646w0 + ", screen = " + this.M + ", s = " + stringExtra);
        }
    }

    private void Ph() {
        int screenWidth = ba.getScreenWidth(getApplicationContext());
        int screenHeight = ba.getScreenHeight(getApplicationContext());
        if (screenWidth > 0 && screenHeight > 0) {
            this.Q = screenWidth;
            this.R = screenHeight;
        } else if (this.M == 0) {
            this.Q = 1920;
            this.R = 1080;
        } else {
            this.Q = 1080;
            this.R = 1920;
        }
        int i3 = this.M;
        if ((i3 == 0 && this.Q < this.R) || (i3 == 1 && this.Q > this.R)) {
            int i16 = this.Q;
            this.Q = this.R;
            this.R = i16;
        }
        QZLog.i("ljh", 4, "getScreenSize\uff0c screenWidth = " + this.Q + ", screenHeight = " + this.R);
    }

    private boolean Qh() {
        if (f49645v0) {
            return this.I;
        }
        return this.f49660m0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        if (this.f49654g0) {
            return;
        }
        this.f49653f0 = true;
        Wh();
    }

    private void Sh() {
        int i3;
        int i16;
        Ph();
        if (f49645v0) {
            VideoPlayInfo videoPlayInfo = this.D;
            i3 = videoPlayInfo.width;
            i16 = videoPlayInfo.height;
            QZLog.i("ljh", 4, "isVideoAdv, width = " + i3 + ", height = " + i16);
        } else {
            i3 = this.f49658k0.getCurrentUrl().width;
            i16 = this.f49658k0.getCurrentUrl().height;
            QZLog.i("ljh", 4, "isImageAdv, width = " + i3 + ", height = " + i16);
        }
        if (i3 <= 0 || i16 <= 0) {
            i3 = this.Q;
            i16 = this.R;
        }
        if (this.M == 0) {
            float f16 = i3 / i16;
            int i17 = (int) (this.R * 0.133d);
            QLog.i("ljh", 4, "screenWidth = " + this.Q + ", screenHeight = " + this.R + ", rate = " + f16 + ", videoHeight = " + ((int) (this.Q * f16)));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams.topMargin = i17;
            int e16 = (this.R - (i17 * 2)) - ar.e(50.0f);
            layoutParams.height = e16;
            layoutParams.width = (int) (((float) e16) * f16);
            layoutParams.addRule(14);
            this.N.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.addRule(14);
            this.P.setLayoutParams(layoutParams2);
            QLog.i("ljh", 4, "rate = " + f16 + ", margin = " + i17 + ", lpAdInfoView.width = " + layoutParams2.width + ", lpAdInfoView.height = " + layoutParams2.height);
            return;
        }
        float f17 = i16 / i3;
        int i18 = (int) (this.Q * f17);
        QLog.i("ljh", 4, "screenWidth = " + this.Q + ", screenHeight = " + this.R + ", rate = " + f17 + ", videoHeight = " + i18);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        layoutParams3.topMargin = ((this.R - i18) - ar.e(50.0f)) / 2;
        layoutParams3.width = this.Q;
        layoutParams3.height = i18;
        this.N.setLayoutParams(layoutParams3);
        QLog.i("ljh", 4, "videoHeight = " + i18 + ", screenHeight = " + this.R + ", lpRootPlayView.topMargin = " + layoutParams3.topMargin);
    }

    private void Th() {
        if (f49645v0) {
            this.f49655h0.setVisibility(0);
            this.f49651d0.setVisibility(8);
            this.f49655h0.setVideoPlayInofCallBack(this.f49662o0);
            this.f49651d0.setInternalAsyncImageListener(this.f49665r0);
            return;
        }
        this.f49655h0.setVisibility(8);
        this.f49651d0.setVisibility(0);
        this.f49651d0.setInternalAsyncImageListener(this.f49664q0);
    }

    private void Uh(int i3) {
        Intent intent = new Intent("QZONE.ACTION_NOTIFY_ADV_PLAY");
        intent.putExtra("ret", i3);
        intent.putExtra("callback", this.f49652e0);
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        QZLog.i("ljh", 4, "call to to factory, state = " + i3 + ", intent = " + intent);
    }

    private void Vh(QZoneResult qZoneResult) {
        SmartParcelable data;
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        if (this.f49653f0) {
            QZLog.i("ljh", 4, "response time out ... ");
            return;
        }
        this.f49654g0 = true;
        if (qZoneResult != null && qZoneResult.getSucceed() && qZoneResult.getData() != null) {
            Parcelable parcelable = ((Bundle) qZoneResult.getData()).getParcelable("qzone_encourage_adv_bundle_id");
            if ((parcelable instanceof ParcelableWrapper) && (data = ((ParcelableWrapper) parcelable).getData()) != null && (data instanceof BusinessFeedData)) {
                BusinessFeedData businessFeedData = (BusinessFeedData) data;
                this.f49657j0 = businessFeedData;
                CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
                if (feedCommInfo != null && !feedCommInfo.isVideoAdv() && this.f49657j0.getPictureInfo() != null) {
                    ArrayList<PictureItem> arrayList = this.f49657j0.getPictureInfo().pics;
                    if (arrayList != null && arrayList.size() > 0 && (pictureUrl = (pictureItem = arrayList.get(0)).bigUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
                        this.f49659l0 = true;
                        this.f49658k0 = pictureItem;
                        f49645v0 = false;
                    }
                } else {
                    BusinessFeedData businessFeedData2 = this.f49657j0;
                    VideoPlayInfo b16 = com.qzone.proxy.feedcomponent.ui.c.b(businessFeedData2, businessFeedData2.getVideoInfo());
                    this.D = b16;
                    if (b16 != null) {
                        b16.videoPlayScene = "8";
                        b16.isCircle = false;
                        this.T = Math.min(b16.validVideoTime, PeakConstants.SHORT_VIDEO_DURATION_UPPER_BOUND);
                        QZLog.i("ljh", 4, "mVideoPlayInfo.validVideoTime = " + this.D.validVideoTime + ", millisToPlay = " + this.T);
                        this.f49659l0 = true;
                        f49645v0 = true;
                    }
                }
            }
        }
        Wh();
    }

    private void Wh() {
        QZLog.i("ljh", 4, "playResouce, bResouceLoadedOk = " + this.f49659l0 + ", isVideoAdv = " + f49645v0);
        Lh();
        if (!this.f49659l0) {
            this.f49668u0.sendEmptyMessage(-4);
            return;
        }
        if (this.E) {
            this.E = false;
            Th();
            Sh();
        }
        if (f49645v0) {
            this.f49655h0.setVideoPlayInfo(this.D);
            this.f49655h0.post(new Runnable() { // from class: com.qzone.preview.QZoneEncourageAdvActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    QZLog.i("ljh", 4, "begin to play video ... ");
                    QZoneEncourageAdvActivity.this.f49655h0.c();
                }
            });
            com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl = this.D.coverUrl;
            if (pictureUrl == null || TextUtils.isEmpty(pictureUrl.url)) {
                return;
            }
            QZLog.i("ljh", 4, "coverUrl = " + pictureUrl.url);
            this.f49651d0.setAsyncImage(pictureUrl.url);
            return;
        }
        String str = this.f49658k0.bigUrl.url;
        QZLog.i("ljh", 4, "image url = " + str);
        this.f49651d0.setAsyncImage(str);
        startTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        if (this.f49661n0) {
            return;
        }
        this.f49661n0 = true;
        ThreadManagerV2.post(new Runnable() { // from class: com.qzone.preview.QZoneEncourageAdvActivity.6
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                Drawable drawable = QZoneEncourageAdvActivity.this.f49651d0.getDrawable();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("drawable != null ---  ");
                sb5.append(drawable != null);
                sb5.append(", drawable instanceof BitmapDrawable --- ");
                sb5.append(drawable instanceof BitmapDrawable);
                QZLog.i("ljh", 4, sb5.toString());
                if (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                    return;
                }
                try {
                    QZoneEncourageAdvActivity.this.f49663p0 = new BitmapDrawable(QZoneEncourageAdvActivity.this.Mh(bitmap, ar.d(30.0f), false));
                    QZoneEncourageAdvActivity.this.f49668u0.sendEmptyMessage(-5);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("ljh", 4, "e = " + e16.getMessage());
                }
            }
        }, 10, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh() {
        QLog.i("ljh", 4, "setPlayFailUI()");
        Uh(1);
        this.V.setVisibility(8);
        gi();
        this.W.setVisibility(0);
        this.X.setVisibility(8);
        this.Z.setVisibility(0);
        this.f49648a0.setVisibility(8);
        this.N.setVisibility(8);
        this.C.setBackgroundColor(-16777216);
        if (f49645v0) {
            this.f49655h0.post(new Runnable() { // from class: com.qzone.preview.QZoneEncourageAdvActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneEncourageAdvActivity.this.f49655h0.setVisibility(8);
                }
            });
        }
        if (this.M == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.N.setLayoutParams(layoutParams);
            this.P.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        if (this.L) {
            return;
        }
        this.L = true;
        Nh();
        QLog.i("ljh", 4, "setPlayingUI()");
        if (f49645v0) {
            ci();
            this.f49655h0.setVisibility(0);
            this.f49648a0.setVisibility(0);
        } else {
            this.f49655h0.setVisibility(8);
            this.f49648a0.setVisibility(8);
        }
        this.P.setVisibility(0);
        startTimer();
        this.W.setVisibility(8);
        this.X.setVisibility(8);
        this.Z.setVisibility(8);
        this.V.setVisibility(0);
        BusinessFeedData businessFeedData = this.f49657j0;
        if (businessFeedData != null) {
            if (businessFeedData.getUser() != null && !TextUtils.isEmpty(this.f49657j0.getUser().logo)) {
                String str = this.f49657j0.getUser().logo;
                QLog.i("ljh", 4, "logo = " + str);
                this.f49649b0.setAsyncImageProcessor(new b());
                this.f49649b0.setAsyncImage(str);
            }
            if (this.f49657j0.getCellSummaryV2() != null) {
                String str2 = this.f49657j0.getCellSummaryV2().summary;
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f49657j0.getCellSummaryV2().displayStr;
                }
                QLog.i("ljh", 4, "desc = " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.Y.setTextColor(Color.parseColor("#CCFFFFFF"));
                this.Y.setText(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi() {
        QZLog.i("ljh", 4, "setReplayVideoUI, isSoundOn = " + this.H);
        startTimer();
        if (this.H) {
            di();
        } else {
            ci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei() {
        StringBuilder sb5 = new StringBuilder();
        if (this.V != null) {
            sb5.setLength(0);
            long j3 = this.T / 1000;
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewADV", "  \u5e7f\u544a");
            sb5.append(j3);
            sb5.append(config);
            try {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb5.toString());
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-1), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
                this.V.setText(spannableStringBuilder);
            } catch (Exception e16) {
                QLog.i("ljh", 4, "e = " + e16);
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(Message message) {
        String config;
        this.V.setVisibility(8);
        this.X.setVisibility(0);
        this.Z.setVisibility(0);
        BusinessFeedData businessFeedData = this.f49657j0;
        if (businessFeedData == null) {
            return;
        }
        String feedTypeStr = businessFeedData.getFeedTypeStr();
        if (this.f49657j0.getRecommAction() != null && !TextUtils.isEmpty(this.f49657j0.getRecommAction().buttonText)) {
            this.X.setText(this.f49657j0.getRecommAction().buttonText);
            CellOperationInfo operationInfoV2 = this.f49657j0.getOperationInfoV2();
            if (!TextUtils.isEmpty(feedTypeStr) && operationInfoV2 != null && "app".equalsIgnoreCase(feedTypeStr) && SystemTools.a(BaseApplication.getContext(), operationInfoV2.appid)) {
                if (this.f49657j0.getRecommAction() != null && !TextUtils.isEmpty(this.f49657j0.getRecommAction().installed_buttontxt)) {
                    config = this.f49657j0.getRecommAction().installed_buttontxt;
                } else {
                    config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewOpen", "\u6253\u5f00");
                }
                this.X.setText(config);
            }
        } else if (!TextUtils.isEmpty(feedTypeStr) && "app".equalsIgnoreCase(feedTypeStr)) {
            this.X.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewADVToDownload", "\u53bb\u4e0b\u8f7d"));
        } else {
            this.X.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewADVLookUp", "\u53bb\u770b\u770b"));
        }
        Object obj = message.obj;
        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            Uh(0);
        }
    }

    private void gi() {
        g gVar = this.U;
        if (gVar != null) {
            gVar.cancel();
            this.U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi() {
        Drawable drawable = this.f49663p0;
        if (drawable != null) {
            this.C.setBackgroundDrawable(drawable);
            this.f49650c0.setVisibility(0);
            this.f49650c0.setBackgroundColor(Color.parseColor("#D9000000"));
        }
    }

    private void initService() {
        this.f49656i0 = QZoneAdvService.c();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("gamebar_appid", "" + f49646w0);
        hashMap.put("gamebar_developerid", "" + f49647x0);
        this.f49656i0.b(getActivity(), hashMap, getHandler());
    }

    private void initUI() {
        int i3 = this.M;
        if (i3 == 0 || i3 == 1) {
            getOutActivity().setRequestedOrientation(this.M);
        }
        this.S = (ProgressBar) findViewById(R.id.g1f);
        this.N = findViewById(R.id.kwn);
        this.P = findViewById(R.id.f163979f7);
        showProgress();
        this.V = (TextView) this.C.findViewById(R.id.f163992fy);
        this.Y = (TextView) this.C.findViewById(R.id.f163974ef);
        this.X = (TextView) this.C.findViewById(R.id.js7);
        this.W = (TextView) this.C.findViewById(R.id.c27);
        this.W.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewADVFailHint", "\u5c0f\u7f16\u6b63\u5728\u52aa\u529b\u5bfb\u627e\u8d44\u6e90\uff0c\u665a\u70b9\u518d\u6765\u8bd5\u8bd5\uff1f"));
        this.Z = (AsyncImageView) this.C.findViewById(R.id.close);
        this.f49649b0 = (AsyncImageView) this.C.findViewById(R.id.f163976f4);
        this.f49650c0 = (AsyncImageView) this.C.findViewById(R.id.cp7);
        this.f49648a0 = (AsyncImageView) this.C.findViewById(R.id.iyz);
        this.f49651d0 = (AsyncImageView) findViewById(R.id.f164049ih);
        this.f49655h0 = (QZoneEncourageAdvVideo) this.C.findViewById(R.id.f164050ii);
        this.Z.setDefaultImage(R.drawable.bve);
        this.Z.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_close.png");
        this.f49648a0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_sound_off.png");
        new AsyncImageView(getActivity()).setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_sound_on.png");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#B3000000"));
        gradientDrawable.setCornerRadius(550.0f);
        this.V.setBackgroundDrawable(gradientDrawable);
        this.C.setBackgroundColor(Color.parseColor("#000000"));
        this.Z.setOnClickListener(this);
        this.f49648a0.setOnClickListener(this);
        this.X.setOnClickListener(this);
        float f16 = AreaConst.dp14_5;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(-16725252);
        this.X.setBackgroundDrawable(shapeDrawable);
        a aVar = new a();
        this.N.setOnTouchListener(aVar);
        this.f49655h0.setOnTouchListener(aVar);
        this.C.setOnTouchListener(aVar);
        this.P.setOnTouchListener(aVar);
    }

    private void showProgress() {
        this.N.setVisibility(4);
        this.P.setVisibility(4);
        this.S.setVisibility(0);
    }

    private void startTimer() {
        g gVar = this.U;
        if (gVar != null) {
            gVar.cancel();
        }
        g gVar2 = new g(this.T, 1000L);
        this.U = gVar2;
        gVar2.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.close) {
            finish();
        } else if (id5 == R.id.iyz) {
            if (this.f49655h0.b()) {
                ci();
            } else {
                di();
            }
        } else if (id5 == R.id.js7) {
            getIntent().putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            getIntent().putExtra(LaunchParam.KEY_REF_ID, "biz_src_webgames");
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "QZoneEncourageAdvActivity::to_download", "");
            GdtFeedUtilForQZone.A(new AdClickData.Builder().setContext(this).setFeedData(this.f49657j0).setView(this.X).setAreaId(8).create());
            if (f49645v0 && !this.K) {
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("ljh", 4, "newConfig.orientation = " + configuration.orientation);
        if (this.M == 2) {
            QLog.i("ljh", 4, "onConfigurationChanged, initUIByOrizontation ... ");
            Sh();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f49668u0.removeCallbacksAndMessages(null);
        QLog.i("ljh", 4, "QZoneEncourageAdvActivity onDestroy ... \n\n\n");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null || unpack.what != 1000152) {
            return;
        }
        Vh(unpack);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.G = true;
        if (!Qh()) {
            gi();
            this.F = true;
            if (this.f49659l0 && f49645v0) {
                this.f49655h0.onPause();
            }
        }
        QLog.i("ljh", 4, "onPause ...");
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.G && !Qh()) {
            this.G = false;
            Wh();
        }
        QLog.i("ljh", 4, "onResume ...");
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.i("ljh", 4, "\n\n\nQZoneEncourageAdvActivity oncreate ...");
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        Oh();
        initUI();
        initService();
        this.f49668u0.sendEmptyMessageDelayed(-1, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        QLog.i("ljh", 4, "setPlayOverUI()");
        if (this.I || !f49645v0) {
            this.f49648a0.setVisibility(8);
        }
        if (f49645v0) {
            if (this.K) {
                this.f49655h0.setVisibility(8);
                this.f49651d0.setVisibility(0);
            } else {
                this.f49655h0.setVisibility(0);
            }
        }
        this.f49660m0 = true;
        this.W.setVisibility(8);
        Message obtain = Message.obtain();
        obtain.obj = Boolean.FALSE;
        obtain.what = -7;
        this.f49668u0.sendMessage(obtain);
    }

    private void ci() {
        this.H = false;
        this.f49655h0.setSoundOn(false);
        this.f49648a0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_sound_off.png");
    }

    private void di() {
        this.H = true;
        this.f49655h0.setSoundOn(true);
        this.f49648a0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_gdt_sound_on.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean onBackPress() {
        QLog.i("ljh", 4, "onBackPress ... ");
        if (this.S.getVisibility() == 0) {
            Uh(1);
            return super.onBackPress();
        }
        if (this.Z.getVisibility() == 0) {
            return super.onBackPress();
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            switch (message.what) {
                case -8:
                    QZoneEncourageAdvActivity.this.bi();
                    return;
                case -7:
                    QZoneEncourageAdvActivity.this.fi(message);
                    return;
                case -6:
                    QZoneEncourageAdvActivity.this.ei();
                    return;
                case -5:
                    QZoneEncourageAdvActivity.this.hi();
                    return;
                case -4:
                    QZoneEncourageAdvActivity.this.Yh();
                    return;
                case -3:
                    QZoneEncourageAdvActivity.this.Zh();
                    return;
                case -2:
                    QZoneEncourageAdvActivity.this.ai();
                    return;
                case -1:
                    QZoneEncourageAdvActivity.this.Rh();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bhl, viewGroup, false);
        this.C = inflate;
        return inflate;
    }

    public Bitmap Mh(Bitmap bitmap, int i3, boolean z16) {
        int i16;
        int i17;
        Bitmap createBitmap;
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        int i18 = i3;
        if (bitmap2 == null) {
            return null;
        }
        if (!z16) {
            bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i19 = this.R;
        int i26 = this.Q;
        int i27 = (int) ((width * i19) / i26);
        if (i27 > height) {
            i17 = (int) ((height * i26) / i19);
            i16 = height;
        } else {
            i16 = i27;
            i17 = width;
        }
        if (i17 == width) {
            createBitmap = Bitmap.createBitmap(bitmap2, 0, (height - i16) / 2, i17, i16);
        } else {
            createBitmap = Bitmap.createBitmap(bitmap2, (width - i17) / 2, 0, i17, i16);
        }
        QLog.i("ljh", 4, "bitmapWidth = " + width + ", bitmapHeight = " + height + ", width = " + i17 + ", height = " + i16);
        if (i18 < 1) {
            return null;
        }
        int width2 = createBitmap.getWidth();
        int height2 = createBitmap.getHeight();
        int i28 = width2 * height2;
        int[] iArr2 = new int[i28];
        createBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i29 = width2 - 1;
        int i36 = height2 - 1;
        int i37 = i18 + i18 + 1;
        int[] iArr3 = new int[i28];
        int[] iArr4 = new int[i28];
        int[] iArr5 = new int[i28];
        int[] iArr6 = new int[Math.max(width2, height2)];
        int i38 = (i37 + 1) >> 1;
        int i39 = i38 * i38;
        int i46 = i39 * 256;
        int[] iArr7 = new int[i46];
        for (int i47 = 0; i47 < i46; i47++) {
            iArr7[i47] = i47 / i39;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i37, 3);
        int i48 = i18 + 1;
        int i49 = 0;
        int i56 = 0;
        int i57 = 0;
        while (i49 < height2) {
            Bitmap bitmap3 = createBitmap;
            int i58 = height2;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i75 = 0;
            int i76 = 0;
            int i77 = -i18;
            int i78 = 0;
            while (i77 <= i18) {
                int i79 = i36;
                int[] iArr9 = iArr6;
                int i85 = iArr2[i56 + Math.min(i29, Math.max(i77, 0))];
                int[] iArr10 = iArr8[i77 + i18];
                iArr10[0] = (i85 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr10[1] = (i85 & 65280) >> 8;
                iArr10[2] = i85 & 255;
                int abs = i48 - Math.abs(i77);
                int i86 = iArr10[0];
                i78 += i86 * abs;
                int i87 = iArr10[1];
                i59 += i87 * abs;
                int i88 = iArr10[2];
                i65 += abs * i88;
                if (i77 > 0) {
                    i69 += i86;
                    i75 += i87;
                    i76 += i88;
                } else {
                    i66 += i86;
                    i67 += i87;
                    i68 += i88;
                }
                i77++;
                i36 = i79;
                iArr6 = iArr9;
            }
            int i89 = i36;
            int[] iArr11 = iArr6;
            int i95 = i78;
            int i96 = i18;
            int i97 = 0;
            while (i97 < width2) {
                iArr3[i56] = iArr7[i95];
                iArr4[i56] = iArr7[i59];
                iArr5[i56] = iArr7[i65];
                int i98 = i95 - i66;
                int i99 = i59 - i67;
                int i100 = i65 - i68;
                int[] iArr12 = iArr8[((i96 - i18) + i37) % i37];
                int i101 = i66 - iArr12[0];
                int i102 = i67 - iArr12[1];
                int i103 = i68 - iArr12[2];
                if (i49 == 0) {
                    iArr = iArr7;
                    iArr11[i97] = Math.min(i97 + i18 + 1, i29);
                } else {
                    iArr = iArr7;
                }
                int i104 = iArr2[i57 + iArr11[i97]];
                int i105 = (i104 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr12[0] = i105;
                int i106 = (i104 & 65280) >> 8;
                iArr12[1] = i106;
                int i107 = i104 & 255;
                iArr12[2] = i107;
                int i108 = i69 + i105;
                int i109 = i75 + i106;
                int i110 = i76 + i107;
                i95 = i98 + i108;
                i59 = i99 + i109;
                i65 = i100 + i110;
                i96 = (i96 + 1) % i37;
                int[] iArr13 = iArr8[i96 % i37];
                int i111 = iArr13[0];
                i66 = i101 + i111;
                int i112 = iArr13[1];
                i67 = i102 + i112;
                int i113 = iArr13[2];
                i68 = i103 + i113;
                i69 = i108 - i111;
                i75 = i109 - i112;
                i76 = i110 - i113;
                i56++;
                i97++;
                iArr7 = iArr;
            }
            i57 += width2;
            i49++;
            createBitmap = bitmap3;
            height2 = i58;
            i36 = i89;
            iArr6 = iArr11;
        }
        Bitmap bitmap4 = createBitmap;
        int i114 = height2;
        int[] iArr14 = iArr7;
        int i115 = i36;
        int[] iArr15 = iArr6;
        int i116 = 0;
        while (i116 < width2) {
            int i117 = -i18;
            int[] iArr16 = iArr2;
            int i118 = i117 * width2;
            int i119 = i37;
            int i120 = 0;
            int i121 = 0;
            int i122 = 0;
            int i123 = 0;
            int i124 = 0;
            int i125 = 0;
            int i126 = 0;
            int i127 = 0;
            int i128 = i117;
            int i129 = 0;
            while (i128 <= i18) {
                int i130 = width2;
                int max = Math.max(0, i118) + i116;
                int[] iArr17 = iArr8[i128 + i18];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i48 - Math.abs(i128);
                i129 += iArr3[max] * abs2;
                i120 += iArr4[max] * abs2;
                i121 += iArr5[max] * abs2;
                if (i128 > 0) {
                    i125 += iArr17[0];
                    i126 += iArr17[1];
                    i127 += iArr17[2];
                } else {
                    i122 += iArr17[0];
                    i123 += iArr17[1];
                    i124 += iArr17[2];
                }
                int i131 = i115;
                if (i128 < i131) {
                    i118 += i130;
                }
                i128++;
                i115 = i131;
                width2 = i130;
            }
            int i132 = width2;
            int i133 = i115;
            int i134 = i116;
            int i135 = i18;
            int i136 = i129;
            int i137 = i114;
            int i138 = 0;
            while (i138 < i137) {
                iArr16[i134] = (iArr16[i134] & (-16777216)) | (iArr14[i136] << 16) | (iArr14[i120] << 8) | iArr14[i121];
                int i139 = i136 - i122;
                int i140 = i120 - i123;
                int i141 = i121 - i124;
                int[] iArr18 = iArr8[((i135 - i18) + i119) % i119];
                int i142 = i122 - iArr18[0];
                int i143 = i123 - iArr18[1];
                int i144 = i124 - iArr18[2];
                if (i116 == 0) {
                    iArr15[i138] = Math.min(i138 + i48, i133) * i132;
                }
                int i145 = iArr15[i138] + i116;
                int i146 = iArr3[i145];
                iArr18[0] = i146;
                int i147 = iArr4[i145];
                iArr18[1] = i147;
                int i148 = iArr5[i145];
                iArr18[2] = i148;
                int i149 = i125 + i146;
                int i150 = i126 + i147;
                int i151 = i127 + i148;
                i136 = i139 + i149;
                i120 = i140 + i150;
                i121 = i141 + i151;
                i135 = (i135 + 1) % i119;
                int[] iArr19 = iArr8[i135];
                int i152 = iArr19[0];
                i122 = i142 + i152;
                int i153 = iArr19[1];
                i123 = i143 + i153;
                int i154 = iArr19[2];
                i124 = i144 + i154;
                i125 = i149 - i152;
                i126 = i150 - i153;
                i127 = i151 - i154;
                i134 += i132;
                i138++;
                i18 = i3;
            }
            i116++;
            i18 = i3;
            i115 = i133;
            i114 = i137;
            i37 = i119;
            iArr2 = iArr16;
            width2 = i132;
        }
        int i155 = width2;
        bitmap4.setPixels(iArr2, 0, i155, 0, 0, i155, i114);
        return bitmap4;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements AsyncImageable.AsyncImageListener {
        e() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            QZoneEncourageAdvActivity.this.K = true;
            QZoneEncourageAdvActivity.this.Xh();
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }
}
