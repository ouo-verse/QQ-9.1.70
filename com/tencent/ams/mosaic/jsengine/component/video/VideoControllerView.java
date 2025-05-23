package com.tencent.ams.mosaic.jsengine.component.video;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.ams.mosaic.jsengine.component.video.a;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoControllerView extends FrameLayout implements com.tencent.ams.mosaic.jsengine.component.video.a {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private a.InterfaceC0694a K;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f71372d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f71373e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f71374f;

    /* renamed from: h, reason: collision with root package name */
    private SeekBar f71375h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f71376i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f71377m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (VideoControllerView.this.K != null) {
                VideoControllerView.this.K.onPlayClick(VideoControllerView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f71379d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
            } else {
                this.f71379d = -1;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.f71379d = i3;
            if (z16 && VideoControllerView.this.K != null) {
                VideoControllerView.this.K.onProgressSeeking(i3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) seekBar);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "onStartTrackingTouch");
            if (VideoControllerView.this.K != null) {
                VideoControllerView.this.K.onStartProgressSeek(VideoControllerView.this);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) seekBar);
            } else {
                com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "onStopTrackingTouch mProgress:" + this.f71379d);
                if (VideoControllerView.this.K != null && this.f71379d >= 0) {
                    VideoControllerView.this.K.onStopProgressSeek(VideoControllerView.this, this.f71379d);
                }
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (VideoControllerView.this.K != null) {
                VideoControllerView.this.K.onFullScreenClick(VideoControllerView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (VideoControllerView.this.K != null) {
                VideoControllerView.this.K.onMuteClick(VideoControllerView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public VideoControllerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        d(context);
        c(context);
        i();
    }

    private void c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) MosaicUtils.j(40.0f));
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setPadding((int) MosaicUtils.j(12.0f), 0, (int) MosaicUtils.j(12.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Integer.MIN_VALUE, 0}));
        int j3 = (int) MosaicUtils.j(32.0f);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(j3, j3);
        layoutParams2.rightMargin = (int) MosaicUtils.j(8.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setOnClickListener(new a());
        linearLayout.addView(imageView);
        this.f71373e = imageView;
        TextView textView = new TextView(context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-1);
        linearLayout.addView(textView);
        this.f71374f = textView;
        SeekBar seekBar = new SeekBar(context);
        int j16 = (int) MosaicUtils.j(10.0f);
        seekBar.setPadding(j16, 0, j16, 0);
        seekBar.setThumbOffset(j16 / 2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, (int) MosaicUtils.j(22.0f));
        layoutParams3.weight = 1.0f;
        f(seekBar);
        int i3 = Build.VERSION.SDK_INT;
        g(seekBar, -1);
        seekBar.setLayoutParams(layoutParams3);
        if (i3 >= 29) {
            seekBar.setMaxHeight((int) MosaicUtils.j(2.0f));
            seekBar.setMinHeight((int) MosaicUtils.j(2.0f));
        }
        seekBar.setOnSeekBarChangeListener(new b());
        linearLayout.addView(seekBar);
        this.f71375h = seekBar;
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView2.setTextSize(1, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        this.f71376i = textView2;
        ImageView imageView2 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(j3, j3);
        layoutParams4.rightMargin = (int) MosaicUtils.j(8.0f);
        layoutParams4.leftMargin = (int) MosaicUtils.j(8.0f);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setOnClickListener(new c());
        linearLayout.addView(imageView2);
        this.f71377m = imageView2;
        ImageView imageView3 = new ImageView(context);
        imageView3.setLayoutParams(new FrameLayout.LayoutParams(j3, j3));
        imageView3.setOnClickListener(new d());
        linearLayout.addView(imageView3);
        this.C = imageView3;
        this.f71372d = linearLayout;
        addView(linearLayout);
    }

    private void d(Context context) {
        int j3 = (int) MosaicUtils.j(40.0f);
        ImageView imageView = new ImageView(context);
        int j16 = (int) MosaicUtils.j(10.0f);
        imageView.setPadding(j16, j16, j16, j16);
        imageView.setImageBitmap(MosaicUtils.c(getContext(), "images/ic_ad_back.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j3, j3);
        layoutParams.leftMargin = (int) MosaicUtils.j(10.0f);
        layoutParams.topMargin = ((int) MosaicUtils.j(10.0f)) + com.tencent.ams.mosaic.utils.h.a(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.component.video.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoControllerView.this.e(view);
            }
        });
        imageView.setVisibility(8);
        this.D = imageView;
        addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a.InterfaceC0694a interfaceC0694a = this.K;
        if (interfaceC0694a != null) {
            interfaceC0694a.onBackClick(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void f(SeekBar seekBar) {
        com.tencent.ams.mosaic.utils.f.e("VideoControllerView", "setSeekBarColor");
        try {
            seekBar.getProgressDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("VideoControllerView", "setSeekBarColor", th5);
        }
    }

    @RequiresApi(api = 16)
    private void g(SeekBar seekBar, int i3) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-1);
            int j3 = (int) MosaicUtils.j(12.0f);
            gradientDrawable.setSize(j3, j3);
            seekBar.setThumb(gradientDrawable);
            seekBar.invalidate();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("VideoControllerView", "setSeekBarThumbColor", th5);
        }
    }

    private void h() {
        int i3;
        SeekBar seekBar;
        if (this.F >= 0 && (i3 = this.G) > 0 && (seekBar = this.f71375h) != null) {
            seekBar.setMax(i3);
            int min = Math.min(this.F, this.G);
            this.F = min;
            this.f71375h.setProgress(min);
        }
    }

    private void i() {
        setPaused(this.E);
        setCurrentTime(this.F);
        setTotalTime(this.G);
        setFullScreen(this.H, this.I);
        setMute(this.J);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void onVideoSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            i();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setControllerViewListener(a.InterfaceC0694a interfaceC0694a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) interfaceC0694a);
        } else {
            this.K = interfaceC0694a;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setCurrentTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        this.F = i3;
        TextView textView = this.f71374f;
        if (textView != null) {
            textView.setText(MosaicUtils.S(i3 / 1000));
        }
        h();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setFullScreen(boolean z16, boolean z17) {
        float j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "setFullScreen: " + z16);
        this.H = z16;
        this.I = z17;
        ImageView imageView = this.f71377m;
        if (imageView != null) {
            if (z16) {
                str = "images/ic_small_screen.png";
            } else {
                str = "images/ic_full_screen.png";
            }
            imageView.setImageBitmap(MosaicUtils.c(getContext(), str));
        }
        ViewGroup viewGroup = this.f71372d;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (z16) {
                if (z17) {
                    j3 = MosaicUtils.j(64.0f);
                } else {
                    j3 = MosaicUtils.j(12.0f);
                }
                int i16 = (int) j3;
                this.f71372d.setPadding(i16, 0, i16, (int) MosaicUtils.j(34.0f));
                layoutParams.height = (int) MosaicUtils.j(74.0f);
            } else {
                this.f71372d.setPadding((int) MosaicUtils.j(12.0f), 0, (int) MosaicUtils.j(12.0f), 0);
                layoutParams.height = (int) MosaicUtils.j(40.0f);
            }
            this.f71372d.setLayoutParams(layoutParams);
        }
        ImageView imageView2 = this.D;
        if (imageView2 != null) {
            if (!z16) {
                i3 = 8;
            }
            imageView2.setVisibility(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setMute(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "setMute: " + z16);
        this.J = z16;
        ImageView imageView = this.C;
        if (imageView != null) {
            if (z16) {
                str = "images/ic_mute.png";
            } else {
                str = "images/ic_un_mute.png";
            }
            imageView.setImageBitmap(MosaicUtils.c(getContext(), str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setPaused(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "setPaused: " + z16);
        this.E = z16;
        ImageView imageView = this.f71373e;
        if (imageView != null) {
            if (z16) {
                str = "images/ic_play.png";
            } else {
                str = "images/ic_pause.png";
            }
            imageView.setImageBitmap(MosaicUtils.c(getContext(), str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a
    public void setTotalTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("VideoControllerView", "setTotalTime: " + i3);
        this.G = i3;
        TextView textView = this.f71376i;
        if (textView != null) {
            textView.setText(MosaicUtils.S(i3 / 1000));
        }
        h();
    }
}
