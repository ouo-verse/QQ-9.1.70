package com.tencent.mobileqq.wink.picker.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes21.dex */
public class WinkLocalVideoPreviewView extends WinkBasePreviewVideoView implements SimpleEventReceiver {
    private TextView C;
    private TextView D;
    private SeekBar E;
    private BaseVideoView F;
    private SimpleDateFormat G;
    private Context H;
    private View.OnClickListener I;
    private SeekBar.OnSeekBarChangeListener J;
    private View.OnTouchListener K;
    private ColorDrawable L;
    private LinearLayout M;
    private int N;
    private boolean P;
    private final RFWMediaFocusManager Q;

    /* renamed from: f, reason: collision with root package name */
    private LocalMediaInfo f324725f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f324726h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f324727i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f324728m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (WinkLocalVideoPreviewView.this.F != null && WinkLocalVideoPreviewView.this.f324725f != null && WinkLocalVideoPreviewView.this.D != null && z16) {
                WinkLocalVideoPreviewView.this.F.seekTo((int) ((i3 / seekBar.getMax()) * ((float) WinkLocalVideoPreviewView.this.f324725f.mDuration)));
                WinkLocalVideoPreviewView.this.N = i3;
                WinkLocalVideoPreviewView.this.D.setText(WinkLocalVideoPreviewView.this.q((int) ((r0 / seekBar.getMax()) * ((float) WinkLocalVideoPreviewView.this.f324725f.mDuration))));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (WinkLocalVideoPreviewView.this.M != null) {
                WinkLocalVideoPreviewView.this.M.setVisibility(0);
            }
            WinkLocalVideoPreviewView.this.p(4);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (WinkLocalVideoPreviewView.this.M != null) {
                WinkLocalVideoPreviewView.this.M.setVisibility(8);
            }
            WinkLocalVideoPreviewView.this.p(1);
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public WinkLocalVideoPreviewView(Context context, com.tencent.mobileqq.wink.picker.core.view.c cVar, boolean z16) {
        super(context, cVar);
        this.G = null;
        this.L = new ColorDrawable(570425344);
        this.N = -1;
        this.P = true;
        this.H = context;
        this.Q = RFWMediaFocusManager.createMediaFocusManager(Constants.Business.QQ_CIRCLE_WINK_PREVIEW);
        View.inflate(context, R.layout.i8d, this);
        this.f324726h = (FrameLayout) findViewById(R.id.kt9);
        this.f324727i = (ImageView) findViewById(R.id.f1178772m);
        this.D = (TextView) findViewById(R.id.f1178872n);
        this.f324728m = (ImageView) findViewById(R.id.f1178972o);
        this.C = (TextView) findViewById(R.id.f1179372s);
        this.E = (SeekBar) findViewById(R.id.f1179172q);
        p(1);
        this.E.setOnSeekBarChangeListener(r());
        this.E.setOnTouchListener(t());
        this.E.setBackgroundDrawable(null);
        this.M = (LinearLayout) findViewById(R.id.f1179072p);
        BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.H, 153L, null, this.f324727i);
        this.F = baseVideoView;
        baseVideoView.setFocusable(true);
        this.F.setOnClickListener(s());
        this.f324726h.addView(this.F, -1, -1);
        this.P = z16;
    }

    private void A() {
        RFWMediaFocusManager rFWMediaFocusManager = this.Q;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    private void B() {
        C();
        SeekBar seekBar = this.E;
        if (seekBar != null) {
            seekBar.setProgress(0);
        }
        ImageView imageView = this.f324728m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(q(0L));
        }
    }

    private void C() {
        BaseVideoView w3 = w();
        if (w3.mIsPlayVideo) {
            w3.resume();
        } else {
            w3.play();
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        int dpToPx = ImmersiveUtils.dpToPx(20.0f);
        this.E.setPadding(0, dpToPx, 0, dpToPx);
        this.E.getLayoutParams().height = (dpToPx * 2) + ImmersiveUtils.dpToPx(i3);
        this.E.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q(long j3) {
        if (this.G == null) {
            this.G = new SimpleDateFormat("mm:ss");
        }
        return this.G.format(Long.valueOf(j3));
    }

    private SeekBar.OnSeekBarChangeListener r() {
        if (this.J == null) {
            this.J = new b();
        }
        return this.J;
    }

    private View.OnClickListener s() {
        if (this.I == null) {
            this.I = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkLocalVideoPreviewView.this.y(view);
                }
            };
        }
        return this.I;
    }

    private View.OnTouchListener t() {
        if (this.K == null) {
            this.K = new c();
        }
        return this.K;
    }

    private URLDrawable.URLDrawableOptions u(LocalMediaInfo localMediaInfo) {
        int screenWidth = ImmersiveUtils.getScreenWidth();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = screenWidth;
        obtain.mRequestHeight = (int) ((screenWidth / localMediaInfo.mediaWidth) * localMediaInfo.mediaHeight);
        ColorDrawable colorDrawable = this.L;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        return obtain;
    }

    private VideoPlayParam v(LocalMediaInfo localMediaInfo) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mVideoFormat = 104;
        videoPlayParam.mIsLocal = true;
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mSceneId = 159;
        videoPlayParam.mVideoPath = localMediaInfo.path;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mCallback = new a(localMediaInfo);
        return videoPlayParam;
    }

    private BaseVideoView w() {
        if (this.F == null) {
            BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.H, 159L, null, null);
            this.F = baseVideoView;
            baseVideoView.setFocusable(true);
            this.F.setOnClickListener(s());
            LocalMediaInfo localMediaInfo = this.f324725f;
            if (localMediaInfo != null) {
                this.F.setVideoParam(v(localMediaInfo));
            }
            this.f324726h.addView(this.F, -1, -1);
        }
        return this.F;
    }

    private void x(@NotNull RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        BaseVideoView baseVideoView;
        if (TextUtils.equals(Constants.Business.QQ_CIRCLE_WINK_PREVIEW, rFWMediaFocusChangeEvent.getConflictBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict() && (baseVideoView = this.F) != null && baseVideoView.isPlaying()) {
            this.F.pause();
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        BaseVideoView baseVideoView = this.F;
        if (baseVideoView != null) {
            if (baseVideoView.isPlaying()) {
                this.F.pause();
                A();
                this.f324728m.setVisibility(0);
            } else if (TextUtils.isEmpty(this.f324725f.missionID)) {
                C();
                this.f324727i.setVisibility(8);
                this.f324728m.setVisibility(8);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(QQWinkConstants.MISSION_ID, this.f324725f.missionID);
                bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
                com.tencent.mobileqq.wink.f.B(this.H, bundle);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void z() {
        RFWMediaFocusManager rFWMediaFocusManager = this.Q;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaFocus();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.WinkBasePreviewVideoView
    public void b(boolean z16) {
        w53.b.f("WinkLocalVideoPreviewView", String.format("[pauseVideoPlayer] isPause=%s, mVideoView=%s", Boolean.valueOf(z16), this.F));
        if (z16) {
            BaseVideoView baseVideoView = this.F;
            if (baseVideoView != null) {
                baseVideoView.pause();
                A();
                return;
            }
            return;
        }
        C();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.WinkBasePreviewVideoView
    public boolean c() {
        w53.b.f("WinkLocalVideoPreviewView", "[releaseVideoPlayer] mVideoView=" + this.F);
        BaseVideoView baseVideoView = this.F;
        if (baseVideoView == null) {
            return false;
        }
        baseVideoView.pause();
        this.F.releasePlayer(false);
        FrameLayout frameLayout = this.f324726h;
        if (frameLayout != null) {
            frameLayout.removeView(this.F);
        }
        this.F = null;
        A();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    public void o(LocalMediaInfo localMediaInfo) {
        this.f324725f = localMediaInfo;
        w().setVideoParam(v(localMediaInfo));
        if (!TextUtils.isEmpty(localMediaInfo.missionID) && FileUtils.fileExists(localMediaInfo.thumbnailPath)) {
            this.f324727i.setImageDrawable(URLDrawable.getFileDrawable(localMediaInfo.thumbnailPath, u(localMediaInfo)));
        } else {
            this.f324727i.setImageDrawable(URLDrawable.getDrawable(QAlbumUtil.generateAlbumVideoThumbURL(localMediaInfo.path, null), u(localMediaInfo)));
        }
        this.C.setText(q(localMediaInfo.mDuration));
        this.f324728m.setVisibility(0);
        this.E.setProgress(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w53.b.f("WinkLocalVideoPreviewView", "[onAttachedToWindow] mVideoView=" + this.F);
        if (this.P) {
            B();
        }
        com.tencent.mobileqq.wink.picker.core.view.c cVar = a().get();
        if (cVar != null) {
            cVar.a(this);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            x((RFWMediaFocusChangeEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements VideoPlayerCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f324729d;

        a(LocalMediaInfo localMediaInfo) {
            this.f324729d = localMediaInfo;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            int max;
            if (WinkLocalVideoPreviewView.this.E != null && (max = (int) (WinkLocalVideoPreviewView.this.E.getMax() * (((float) j16) / ((float) this.f324729d.mDuration)))) >= WinkLocalVideoPreviewView.this.N) {
                WinkLocalVideoPreviewView.this.E.setProgress(max);
                WinkLocalVideoPreviewView.this.N = -1;
            }
            if (WinkLocalVideoPreviewView.this.D != null) {
                WinkLocalVideoPreviewView.this.D.setText(WinkLocalVideoPreviewView.this.q(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            if (i3 == 4) {
                WinkLocalVideoPreviewView.this.f324728m.setVisibility(8);
                if (WinkLocalVideoPreviewView.this.F != null) {
                    WinkLocalVideoPreviewView.this.F.setContentDescription("\u6682\u505c");
                }
            } else if (i3 == 6 || i3 == 9) {
                WinkLocalVideoPreviewView.this.f324728m.setVisibility(0);
                if (WinkLocalVideoPreviewView.this.F != null) {
                    WinkLocalVideoPreviewView.this.F.setContentDescription("\u64ad\u653e");
                }
            }
            com.tencent.mobileqq.wink.picker.core.view.c cVar = WinkLocalVideoPreviewView.this.a().get();
            if (cVar != null) {
                cVar.onStateChange(j3, i3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        }
    }
}
