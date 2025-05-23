package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BlessActivity extends BlessTypeActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    private String f180490g0;

    /* renamed from: h0, reason: collision with root package name */
    private AudioManager f180491h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f180492i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f180493j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f180494k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f180495l0;

    /* renamed from: m0, reason: collision with root package name */
    private QQVideoView f180496m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f180497n0;

    /* renamed from: o0, reason: collision with root package name */
    private ImageView f180498o0;

    /* renamed from: p0, reason: collision with root package name */
    private View f180499p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f180500q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f180501r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f180502s0;

    /* renamed from: t0, reason: collision with root package name */
    private BroadcastReceiver f180503t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f180504u0;

    /* renamed from: v0, reason: collision with root package name */
    private Handler f180505v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f180506w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f180507x0;

    /* renamed from: y0, reason: collision with root package name */
    private ImageView f180508y0;

    /* renamed from: z0, reason: collision with root package name */
    AnimationDrawable2 f180509z0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class AnimationDrawable2 extends AnimationDrawable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f180513d;

        /* renamed from: e, reason: collision with root package name */
        private g f180514e;

        public AnimationDrawable2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            } else {
                this.f180513d = false;
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                stop();
                this.f180513d = false;
            }
        }

        public void f(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            } else {
                this.f180514e = gVar;
            }
        }

        @Override // android.graphics.drawable.DrawableContainer
        public boolean selectDrawable(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            boolean selectDrawable = super.selectDrawable(i3);
            if (i3 != 0 && i3 == getNumberOfFrames() - 1 && !this.f180513d) {
                this.f180513d = true;
                g gVar = this.f180514e;
                if (gVar != null) {
                    gVar.onAnimationFinished();
                }
            }
            return selectDrawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction())) {
                BlessActivity.this.f180504u0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f180516d;

        b(RelativeLayout relativeLayout) {
            this.f180516d = relativeLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this, (Object) relativeLayout);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f180516d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            BlessActivity.this.f180501r0 = this.f180516d.getHeight();
            BlessActivity.this.f180502s0 = this.f180516d.getWidth();
            BlessActivity.this.W2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements g {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.bless.BlessActivity.g
        public void onAnimationFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (BlessActivity.this.f180507x0 < BlessActivity.this.f180578c0.M()) {
                BlessActivity.this.f180509z0.e();
                BlessActivity.this.f180509z0.start();
                BlessActivity.this.f180507x0++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(BlessActivity.this.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
                BlessActivity.this.Y2(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(BlessActivity.this.f180490g0, 2, "videoview onCompletion");
            }
            BlessActivity.this.Y2(true);
            ReportController.o(BlessActivity.this.app, "CliOper", "", "", "0X800632E", "0X800632E", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements MediaPlayer.OnErrorListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d(BlessActivity.this.f180490g0, 2, "videoview onError what=" + i3 + ", extra=" + i16);
            }
            BlessActivity.this.Y2(true);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface g {
        void onAnimationFinished();
    }

    public BlessActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180490g0 = "BlessActivity";
        this.f180491h0 = null;
        this.f180492i0 = false;
        this.f180493j0 = false;
        this.f180494k0 = false;
        this.f180495l0 = null;
        this.f180496m0 = null;
        this.f180497n0 = null;
        this.f180498o0 = null;
        this.f180499p0 = null;
        this.f180500q0 = -1;
        this.f180503t0 = null;
        this.f180504u0 = false;
        this.f180505v0 = new Handler();
        this.f180506w0 = false;
        this.f180507x0 = 0;
        this.f180508y0 = null;
    }

    private void U2() {
        if (this.f180503t0 == null) {
            this.f180503t0 = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        try {
            registerReceiver(this.f180503t0, intentFilter);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        Throwable th5;
        Exception exc;
        FileInputStream fileInputStream = null;
        try {
            try {
                String N = this.f180578c0.N();
                String P = this.f180578c0.P();
                if (TextUtils.isEmpty(P)) {
                    return;
                }
                File file = new File(N);
                if (!new File(P).exists() && file.exists()) {
                    FileUtils.uncompressZip(file.getPath(), P, false);
                }
                FileInputStream fileInputStream2 = new FileInputStream(N);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream2, this.f180508y0.getLayoutParams().width, this.f180508y0.getLayoutParams().height);
                    int M = this.f180578c0.M();
                    if (M == -1) {
                        this.f180508y0.postDelayed(new Runnable(com.tencent.mobileqq.util.j.d(P + "1.png", options)) { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.3
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f180510d;

                            {
                                this.f180510d = r5;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    BlessActivity.this.f180508y0.setImageBitmap(this.f180510d);
                                    BlessActivity.this.f180508y0.setVisibility(0);
                                }
                            }
                        }, 200L);
                        try {
                            fileInputStream2.close();
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(this.f180490g0, 2, "InputStream close excep!", e16);
                                return;
                            }
                            return;
                        }
                    }
                    File file2 = new File(P);
                    if (!file2.isDirectory()) {
                        try {
                            fileInputStream2.close();
                            return;
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e(this.f180490g0, 2, "InputStream close excep!", e17);
                                return;
                            }
                            return;
                        }
                    }
                    int length = file2.list().length;
                    int L = this.f180578c0.L();
                    this.f180509z0 = new AnimationDrawable2();
                    int i3 = 0;
                    while (i3 < length) {
                        i3++;
                        this.f180509z0.addFrame(new BitmapDrawable(getResources(), com.tencent.mobileqq.util.j.d(P + i3 + ".png", options)), L / length);
                    }
                    if (M == 0) {
                        this.f180509z0.setOneShot(false);
                    } else {
                        this.f180509z0.setOneShot(true);
                        this.f180509z0.f(new c());
                    }
                    this.f180508y0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.5
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            BlessActivity.this.f180508y0.setBackgroundDrawable(BlessActivity.this.f180509z0);
                            BlessActivity.this.f180508y0.setVisibility(0);
                            BlessActivity.this.f180509z0.start();
                            BlessActivity.this.f180507x0++;
                        }
                    }, 200L);
                    try {
                        fileInputStream2.close();
                    } catch (Exception e18) {
                        exc = e18;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.e(this.f180490g0, 2, "InputStream close excep!", exc);
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileInputStream = fileInputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.e(this.f180490g0, 2, "setPtvAnimation, ", e);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e26) {
                            exc = e26;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e(this.f180490g0, 2, "InputStream close excep!", exc);
                        }
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            throw th5;
                        } catch (Exception e27) {
                            if (QLog.isColorLevel()) {
                                QLog.e(this.f180490g0, 2, "InputStream close excep!", e27);
                                throw th5;
                            }
                            throw th5;
                        }
                    }
                    throw th5;
                }
            } catch (Exception e28) {
                e = e28;
            }
        } catch (Throwable th7) {
            th5 = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0174: MOVE (r6 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:373), block:B:40:0x0174 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W2() {
        AudioManager audioManager;
        FileInputStream fileInputStream;
        InputStream inputStream;
        if (this.f180494k0) {
            return;
        }
        this.f180494k0 = true;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root);
        if (this.f180496m0 == null) {
            this.f180496m0 = (QQVideoView) findViewById(R.id.kvq);
        }
        if (this.f180491h0 == null) {
            this.f180491h0 = (AudioManager) getSystemService("audio");
        }
        this.f180496m0.setVideoPath(this.f180495l0);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = this.f180502s0;
        int i16 = (int) ((700 * (i3 / 900)) + 0.5f);
        if (i16 % 2 == 1) {
            i16++;
        }
        this.f180493j0 = true;
        U2();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById(R.id.enq).getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        ImageView imageView = (ImageView) findViewById(R.id.kvn);
        this.f180498o0 = imageView;
        imageView.setVisibility(0);
        InputStream inputStream2 = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                fileInputStream = new FileInputStream(this.f180497n0);
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream, i3, i16);
                Bitmap d16 = com.tencent.mobileqq.util.j.d(this.f180497n0, options);
                if (d16 != null) {
                    this.f180498o0.setImageBitmap(d16);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f180498o0.getLayoutParams();
                layoutParams2.width = i3;
                layoutParams2.height = i16;
                this.f180498o0.bringToFront();
                fileInputStream.close();
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e(this.f180490g0, 2, "decode mVideoCoverPath error = " + e.getMessage());
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                findViewById(R.id.title).bringToFront();
                this.f180496m0.setDimension(i3, i16);
                ((RelativeLayout.LayoutParams) this.f180496m0.getLayoutParams()).setMargins(0, 0, 0, 0);
                View view = new View(this);
                this.f180499p0 = view;
                relativeLayout.addView(view);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f180499p0.getLayoutParams();
                layoutParams3.addRule(11);
                layoutParams3.addRule(10);
                layoutParams3.setMargins(0, (int) ((displayMetrics.density * 31.0f) + 0.5f), 0, 0);
                float f16 = displayMetrics.density;
                layoutParams3.width = (int) ((f16 * 60.0f) + 0.5f);
                layoutParams3.height = (int) ((f16 * 60.0f) + 0.5f);
                this.f180499p0.bringToFront();
                this.f180499p0.setOnClickListener(new d());
                audioManager = this.f180491h0;
                if (audioManager != null) {
                }
                this.f180496m0.setVisibility(0);
                this.f180496m0.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
                        }
                    }

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(BlessActivity.this.f180490g0, 2, "videoview onPrepared");
                        }
                        if (BlessActivity.this.f180496m0 != null) {
                            BlessActivity.this.f180496m0.start();
                        }
                        BlessActivity.this.f180505v0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.7.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(BlessActivity.this.f180490g0, 2, "videoview bring to top");
                                }
                                if (BlessActivity.this.f180498o0 != null) {
                                    BlessActivity.this.f180498o0.setVisibility(8);
                                }
                                if (BlessActivity.this.f180496m0 != null) {
                                    BlessActivity.this.f180496m0.bringToFront();
                                }
                                BlessActivity.this.findViewById(R.id.ivTitleName).bringToFront();
                                BlessActivity.this.findViewById(R.id.title).bringToFront();
                            }
                        }, 800L);
                        if (QLog.isColorLevel()) {
                            QLog.d(BlessActivity.this.f180490g0, 2, "videoview onPrepared");
                        }
                        ReportController.o(BlessActivity.this.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
                    }
                });
                this.f180496m0.setOnCompletionListener(new e());
                this.f180496m0.setOnErrorListener(new f());
            }
            findViewById(R.id.title).bringToFront();
            this.f180496m0.setDimension(i3, i16);
            ((RelativeLayout.LayoutParams) this.f180496m0.getLayoutParams()).setMargins(0, 0, 0, 0);
            View view2 = new View(this);
            this.f180499p0 = view2;
            relativeLayout.addView(view2);
            RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) this.f180499p0.getLayoutParams();
            layoutParams32.addRule(11);
            layoutParams32.addRule(10);
            layoutParams32.setMargins(0, (int) ((displayMetrics.density * 31.0f) + 0.5f), 0, 0);
            float f162 = displayMetrics.density;
            layoutParams32.width = (int) ((f162 * 60.0f) + 0.5f);
            layoutParams32.height = (int) ((f162 * 60.0f) + 0.5f);
            this.f180499p0.bringToFront();
            this.f180499p0.setOnClickListener(new d());
            audioManager = this.f180491h0;
            if (audioManager != null) {
                audioManager.requestAudioFocus(null, 3, 1);
            }
            this.f180496m0.setVisibility(0);
            this.f180496m0.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
                    }
                }

                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(BlessActivity.this.f180490g0, 2, "videoview onPrepared");
                    }
                    if (BlessActivity.this.f180496m0 != null) {
                        BlessActivity.this.f180496m0.start();
                    }
                    BlessActivity.this.f180505v0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.7.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(BlessActivity.this.f180490g0, 2, "videoview bring to top");
                            }
                            if (BlessActivity.this.f180498o0 != null) {
                                BlessActivity.this.f180498o0.setVisibility(8);
                            }
                            if (BlessActivity.this.f180496m0 != null) {
                                BlessActivity.this.f180496m0.bringToFront();
                            }
                            BlessActivity.this.findViewById(R.id.ivTitleName).bringToFront();
                            BlessActivity.this.findViewById(R.id.title).bringToFront();
                        }
                    }, 800L);
                    if (QLog.isColorLevel()) {
                        QLog.d(BlessActivity.this.f180490g0, 2, "videoview onPrepared");
                    }
                    ReportController.o(BlessActivity.this.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
                }
            });
            this.f180496m0.setOnCompletionListener(new e());
            this.f180496m0.setOnErrorListener(new f());
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f180490g0, 2, "stopPlayingStarVideo mNeedShowStarVideo=" + this.f180492i0 + ", mIsPlayingStarVideo=" + this.f180493j0);
        }
        if (this.f180492i0) {
            this.f180493j0 = false;
            if (z16) {
                View findViewById = findViewById(R.id.enq);
                findViewById.setVisibility(0);
                findViewById.bringToFront();
                findViewById(R.id.du8).bringToFront();
                findViewById(R.id.title).bringToFront();
            }
            View view = this.f180499p0;
            if (view != null) {
                view.setClickable(false);
                this.f180499p0.setVisibility(8);
            }
            ImageView imageView = this.f180498o0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            QQVideoView qQVideoView = this.f180496m0;
            if (qQVideoView != null) {
                if (qQVideoView.isPlaying()) {
                    this.f180496m0.stopPlayback();
                }
                this.f180496m0 = null;
            }
            AudioManager audioManager = this.f180491h0;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f167674du);
        if (this.f180578c0.y0()) {
            this.f180495l0 = this.f180578c0.V();
            String W = this.f180578c0.W();
            this.f180497n0 = W;
            if (this.f180495l0 != null && W != null) {
                this.f180492i0 = true;
            }
        }
        this.f180579d0 = 0.6933333f;
        this.f180580e0 = 1;
        initUi();
        this.f180578c0.M0(false);
        this.f180506w0 = getIntent().getBooleanExtra("PARAM_IS_FROM_SEARCH", false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f180578c0.s();
        BroadcastReceiver broadcastReceiver = this.f180503t0;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        AnimationDrawable2 animationDrawable2 = this.f180509z0;
        if (animationDrawable2 != null && animationDrawable2.isRunning()) {
            this.f180509z0.stop();
        }
        this.f180503t0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f180490g0, 2, "doOnPause");
        }
        if (this.f180492i0 && this.f180493j0) {
            if (this.f180504u0) {
                Y2(true);
            } else {
                QQVideoView qQVideoView = this.f180496m0;
                if (qQVideoView != null) {
                    qQVideoView.pause();
                    this.f180500q0 = this.f180496m0.getCurrentPosition();
                }
            }
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        QQVideoView qQVideoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnResume();
        int i3 = this.f180500q0;
        if (i3 != -1 && (qQVideoView = this.f180496m0) != null) {
            qQVideoView.seekTo(i3);
            this.f180496m0.start();
            this.f180500q0 = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r10.f180490g0, 2, "InputStream close excep!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initUi() {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.dyl);
        String K = this.f180578c0.K();
        FileInputStream fileInputStream2 = null;
        if (K != null) {
            try {
                fileInputStream = new FileInputStream(K);
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream, imageView.getLayoutParams().width, imageView.getLayoutParams().height);
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f180490g0, 2, "target center size: " + imageView.getLayoutParams().width + " * " + imageView.getLayoutParams().height);
                    }
                    Bitmap d16 = com.tencent.mobileqq.util.j.d(K, options);
                    if (d16 != null) {
                        imageView.setImageBitmap(d16);
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                            if (QLog.isColorLevel()) {
                                QLog.e(this.f180490g0, 2, "InputStream close excep!");
                            }
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                if (QLog.isColorLevel()) {
                    QLog.e(this.f180490g0, 2, "center not exist");
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                if (this.f180492i0) {
                }
                if (!this.f180578c0.O().booleanValue()) {
                }
            }
        }
        if (this.f180492i0) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root);
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b(relativeLayout));
        }
        if (!this.f180578c0.O().booleanValue()) {
            this.f180508y0 = (ImageView) findViewById(R.id.aj5);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlessActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        BlessActivity.this.V2();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 10, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f180490g0, 2, "onBackEvent");
        }
        Y2(false);
        if (!this.f180506w0) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.setFlags(67108864);
            startActivity(aliasIntent);
        }
        finish();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if ((id5 == R.id.aks || id5 == R.id.f164675aj4) && this.f180492i0) {
                Y2(true);
            }
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
