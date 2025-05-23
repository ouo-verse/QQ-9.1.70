package com.tencent.mobileqq.vastrash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ColorRingPlayer implements View.OnClickListener {
    ViewGroup E;
    ImageView F;
    ImageView G;
    Button H;
    ImageView I;
    ProgressBar J;
    TextView K;
    TextView L;
    TextView M;
    TextView N;
    ProgressBar P;

    /* renamed from: h, reason: collision with root package name */
    int f312384h;

    /* renamed from: i, reason: collision with root package name */
    QQBrowserActivity f312385i;

    /* renamed from: m, reason: collision with root package name */
    Handler f312386m;

    /* renamed from: d, reason: collision with root package name */
    g f312381d = new g();

    /* renamed from: e, reason: collision with root package name */
    Object f312382e = new Object();

    /* renamed from: f, reason: collision with root package name */
    MediaPlayer f312383f = null;
    boolean C = true;
    boolean D = false;
    ag Q = null;
    AudioManager.OnAudioFocusChangeListener R = new b();
    t S = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements MediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AudioManager f312394d;

        a(AudioManager audioManager) {
            this.f312394d = audioManager;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            ColorRingPlayer colorRingPlayer;
            synchronized (ColorRingPlayer.this.f312382e) {
                mediaPlayer.release();
                colorRingPlayer = ColorRingPlayer.this;
                colorRingPlayer.f312383f = null;
            }
            colorRingPlayer.f312384h = 0;
            colorRingPlayer.J.setProgress(0);
            ColorRingPlayer colorRingPlayer2 = ColorRingPlayer.this;
            colorRingPlayer2.I.setImageDrawable(colorRingPlayer2.f312385i.getResources().getDrawable(R.drawable.fn5));
            this.f312394d.abandonAudioFocus(ColorRingPlayer.this.R);
            synchronized (ColorRingPlayer.this.f312381d) {
                ColorRingPlayer.this.f312381d.f312403a = 6;
            }
        }
    }

    /* loaded from: classes20.dex */
    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (i3 == -2) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorRingPlayer", 2, "transient focus loss.");
                }
                synchronized (ColorRingPlayer.this.f312381d) {
                    ColorRingPlayer colorRingPlayer = ColorRingPlayer.this;
                    if (colorRingPlayer.f312381d.f312403a == 4) {
                        colorRingPlayer.b();
                    }
                }
                return;
            }
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorRingPlayer", 2, "gained focus");
                }
                ColorRingPlayer colorRingPlayer2 = ColorRingPlayer.this;
                if (colorRingPlayer2.D) {
                    colorRingPlayer2.c();
                    ColorRingPlayer.this.D = false;
                    return;
                }
                return;
            }
            if (i3 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorRingPlayer", 2, "Audio focus Loss");
                }
                ColorRingPlayer.this.f();
                synchronized (ColorRingPlayer.this.f312381d) {
                    ColorRingPlayer.this.f312381d.f312403a = 6;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c extends QQCustomDialog {
        c(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f312398d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f312399e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f312400f;

        e(long j3, int i3, String str) {
            this.f312398d = j3;
            this.f312399e = i3;
            this.f312400f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ColorRingPlayer.this.d(this.f312398d, this.f312399e, this.f312400f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public int f312403a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f312404b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f312405c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f312406d = "";

        g() {
        }
    }

    public ColorRingPlayer(QQBrowserActivity qQBrowserActivity, ViewGroup viewGroup) {
        this.E = viewGroup;
        this.f312385i = qQBrowserActivity;
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.S);
        this.F = (ImageView) viewGroup.findViewById(R.id.bat);
        this.H = (Button) viewGroup.findViewById(R.id.f163917c5);
        this.I = (ImageView) viewGroup.findViewById(R.id.baz);
        this.J = (ProgressBar) viewGroup.findViewById(R.id.g1f);
        this.L = (TextView) viewGroup.findViewById(R.id.b2d);
        this.M = (TextView) viewGroup.findViewById(R.id.b2c);
        this.N = (TextView) viewGroup.findViewById(R.id.b2_);
        this.G = (ImageView) viewGroup.findViewById(R.id.g1u);
        this.P = (ProgressBar) viewGroup.findViewById(R.id.iqe);
        this.K = (TextView) viewGroup.findViewById(R.id.isr);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f312386m = new Handler();
    }

    void a(long j3, String str) {
        if ("colorring".equals(str)) {
            this.K.setText(R.string.a4i);
        } else if ("comering".equals(str)) {
            this.K.setText(R.string.a7h);
        }
        this.I.setTag(str);
        this.H.setTag(str);
        if (j3 == 0) {
            e(j3, 0);
            if (j(j3, str)) {
                this.H.setText(this.f312385i.getResources().getString(R.string.a4e));
                this.H.setEnabled(false);
            } else {
                if (str.equals("colorring")) {
                    this.H.setText(this.f312385i.getResources().getString(R.string.hf8));
                } else if (str.equals("comering")) {
                    this.H.setText(this.f312385i.getResources().getString(R.string.hf_));
                }
                this.H.setEnabled(true);
            }
            this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162103fn4));
            this.F.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162101fn2));
            this.G.setVisibility(8);
            this.M.setText(this.f312385i.getResources().getString(R.string.aj5));
            this.L.setText("");
            return;
        }
        if (j(j3, str)) {
            this.H.setEnabled(false);
        }
        if (!new File(h.e(j3, 3)).exists()) {
            this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162102fn3));
            this.I.setVisibility(0);
            if (str.equals("colorring")) {
                this.H.setText(this.f312385i.getResources().getString(R.string.hf8));
            } else if (str.equals("comering")) {
                this.H.setText(this.f312385i.getResources().getString(R.string.hf_));
            }
            this.H.setEnabled(true);
            r(j3, 3, str);
        } else {
            e(j3, 0);
            if (j(j3, str)) {
                this.H.setEnabled(false);
                this.H.setText(this.f312385i.getResources().getString(R.string.a4e));
            } else {
                if (str.equals("colorring")) {
                    this.H.setText(this.f312385i.getResources().getString(R.string.hf8));
                } else if (str.equals("comering")) {
                    this.H.setText(this.f312385i.getResources().getString(R.string.hf_));
                }
                this.H.setEnabled(true);
            }
        }
        if (!new File(h.e(j3, 1)).exists()) {
            this.F.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162100fn1));
            r(j3, 1, str);
        } else if (h.d(j3) != null) {
            this.F.setImageBitmap(h.d(j3));
        }
        if (!new File(h.e(j3, 2)).exists()) {
            this.M.setText("");
            this.L.setText("");
            r(j3, 2, str);
            return;
        }
        i(h.c(j3));
    }

    void b() {
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f312383f.pause();
                this.f312384h = this.f312383f.getCurrentPosition();
                this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.fn5));
            }
        }
        this.f312381d.f312403a = 5;
    }

    void c() {
        long j3;
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            if (mediaPlayer == null) {
                synchronized (this.f312381d) {
                    j3 = this.f312381d.f312404b;
                }
                e(j3, this.f312384h);
            } else {
                mediaPlayer.seekTo(this.f312384h);
                this.f312383f.start();
            }
            t();
            this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162103fn4));
        }
        synchronized (this.f312381d) {
            this.f312381d.f312403a = 4;
        }
    }

    void d(long j3, int i3, String str) {
        Bitmap bitmap;
        Bundle bundle = new Bundle();
        bundle.putLong("id", j3);
        bundle.putInt("resourceType", i3);
        bundle.putString("colorType", str);
        o(com.tencent.mobileqq.emosm.a.a("startDownloadColorRing", "", this.S.key, bundle));
        synchronized (this.f312381d) {
            this.f312381d.f312403a = 1;
        }
        this.G.setVisibility(0);
        if (this.Q == null) {
            try {
                bitmap = BitmapFactory.decodeResource(this.f312385i.getResources(), R.drawable.nox);
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
            }
            this.Q = new ag(bitmap, (int) (this.f312385i.getResources().getDisplayMetrics().density * 12.0f));
            Rect rect = new Rect();
            rect.set(0, 0, this.f312385i.getResources().getDimensionPixelSize(R.dimen.f158502hd), this.f312385i.getResources().getDimensionPixelSize(R.dimen.f158501hc));
            this.Q.setBounds(rect);
        }
        this.G.setImageDrawable(this.Q);
        this.Q.setLevel(0);
        this.Q.invalidateSelf();
        this.J.setProgress(0);
        this.H.setText(this.f312385i.getResources().getString(R.string.a4f));
        this.I.setVisibility(8);
    }

    void e(long j3, int i3) {
        AssetFileDescriptor assetFileDescriptor;
        if (QLog.isColorLevel()) {
            QLog.d("ColorRingPlayer", 2, "doStartPlay, id=" + j3);
        }
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            assetFileDescriptor = null;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f312383f = null;
            }
        }
        this.f312383f = new ReportMediaPlayer();
        try {
            try {
                synchronized (this.f312381d) {
                    this.f312381d.f312403a = 4;
                }
                if (j3 == 0) {
                    AssetFileDescriptor openRawResourceFd = this.f312385i.getResources().openRawResourceFd(R.raw.f169426x);
                    try {
                        if (openRawResourceFd == null) {
                            synchronized (this.f312382e) {
                                this.f312383f.release();
                                this.f312383f = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorRingPlayer", 2, "afd = null.");
                            }
                            if (openRawResourceFd != null) {
                                try {
                                    openRawResourceFd.close();
                                    return;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        }
                        this.f312383f.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                        openRawResourceFd.close();
                    } catch (IOException e17) {
                        e = e17;
                        assetFileDescriptor = openRawResourceFd;
                        e.printStackTrace();
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                                return;
                            } catch (Exception e18) {
                                e18.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        assetFileDescriptor = openRawResourceFd;
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    this.f312383f.setDataSource(h.e(j3, 3));
                }
                this.f312383f.prepare();
                AudioManager audioManager = (AudioManager) this.f312385i.getSystemService("audio");
                if (audioManager.requestAudioFocus(this.R, 3, 1) == 1) {
                    this.f312383f.seekTo(i3);
                    this.f312383f.start();
                    t();
                    this.N.setText(g(this.f312383f.getDuration() / 1000));
                    this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162103fn4));
                    this.I.setVisibility(0);
                    this.f312383f.setOnCompletionListener(new a(audioManager));
                    n("0X8004A23", "0X8004A23", j3, 0);
                    return;
                }
                synchronized (this.f312382e) {
                    this.f312383f.release();
                    this.f312383f = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ColorRingPlayer", 2, "Failed to get audio focus.");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    void f() {
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f312383f.release();
                this.f312383f = null;
            }
        }
        this.J.setProgress(0);
    }

    String g(int i3) {
        String str;
        if (i3 > 3599) {
            return "";
        }
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i17 >= 10) {
            str = "" + i17;
        } else {
            str = "0" + i17;
        }
        String str2 = str + ":";
        if (i16 >= 10) {
            return str2 + i16;
        }
        return str2 + "0" + i16;
    }

    public void h(String str) {
        MediaPlayer mediaPlayer = this.f312383f;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f312384h = this.f312383f.getCurrentPosition();
            this.f312383f.stop();
            this.f312383f.release();
            this.f312383f = null;
            this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.fn5));
            synchronized (this.f312381d) {
                this.f312381d.f312403a = 6;
            }
            this.D = false;
        }
        ViewGroup viewGroup = this.E;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
    }

    void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorRingPlayer", 2, "initColorRingDetail, detail is null");
            }
        } else {
            try {
                this.L.setText(jSONObject.getString("singer"));
                this.M.setText(jSONObject.getString("name"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    boolean j(long j3, String str) {
        BrowserAppInterface browserAppInterface = (BrowserAppInterface) this.f312385i.getAppRuntime();
        EntityManager createEntityManager = browserAppInterface.getEntityManagerFactory(null).createEntityManager();
        ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ExtensionInfo.class, browserAppInterface.getAccount());
        createEntityManager.close();
        if (extensionInfo == null) {
            return false;
        }
        if ("colorring".equals(str) && extensionInfo.colorRingId == j3) {
            return true;
        }
        if (!"comering".equals(str) || extensionInfo.commingRingId != j3) {
            return false;
        }
        return true;
    }

    public void k() {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.S);
        AudioManager audioManager = (AudioManager) this.f312385i.getSystemService("audio");
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.R);
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f312383f = null;
            }
        }
    }

    public void l() {
        synchronized (this.f312382e) {
            MediaPlayer mediaPlayer = this.f312383f;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f312384h = this.f312383f.getCurrentPosition();
                this.f312383f.stop();
                this.f312383f.release();
                this.f312383f = null;
                this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.fn5));
                synchronized (this.f312381d) {
                    this.f312381d.f312403a = 6;
                }
                this.D = true;
            }
        }
        this.C = false;
    }

    public void m() {
        this.C = true;
    }

    void n(final String str, final String str2, final long j3, final int i3) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.vastrash.ColorRingPlayer.8
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("subAction", str);
                bundle.putString("actionName", str2);
                bundle.putLong("id", j3);
                bundle.putInt("result", i3);
                ColorRingPlayer.this.o(com.tencent.mobileqq.emosm.a.a("reportColorRing", "", ColorRingPlayer.this.S.key, bundle));
            }
        });
    }

    void o(Bundle bundle) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            QQToast.makeText(this.f312385i.getApplicationContext(), HardCodeUtil.qqStr(R.string.ksl), 0).show();
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = (String) view.getTag();
        if (str == null) {
            str = "colorring";
        }
        int id5 = view.getId();
        if (id5 == R.id.baz) {
            synchronized (this.f312381d) {
                g gVar = this.f312381d;
                int i3 = gVar.f312403a;
                if (i3 == 4) {
                    b();
                } else if (i3 == 5) {
                    c();
                } else if (i3 == 6) {
                    e(gVar.f312404b, 0);
                } else if (i3 == 1) {
                    u(gVar.f312404b);
                    this.f312381d.f312403a = 2;
                } else if (i3 == 2) {
                    r(gVar.f312404b, 3, str);
                } else if (i3 == 0) {
                    r(gVar.f312404b, 3, str);
                } else if (i3 == 3) {
                    e(gVar.f312404b, 0);
                }
            }
        } else if (id5 == R.id.f163917c5) {
            synchronized (this.f312381d) {
                g gVar2 = this.f312381d;
                int i16 = gVar2.f312403a;
                if (i16 == 1) {
                    u(gVar2.f312404b);
                } else if (i16 == 2) {
                    r(gVar2.f312404b, 3, str);
                } else if (i16 == 0) {
                    r(gVar2.f312404b, 3, str);
                } else if (i16 >= 3) {
                    WebViewFragment currentWebViewFragment = this.f312385i.getCurrentWebViewFragment();
                    if (currentWebViewFragment != null) {
                        currentWebViewFragment.getWebView().callJs(this.f312381d.f312406d, "{'result':0,'message':'OK'}");
                    }
                    this.P.setVisibility(0);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(long j3, String str, int i3, String str2) {
        int i16;
        int i17;
        synchronized (this.f312381d) {
            if (this.f312381d.f312404b == j3) {
                if (i3 == 0) {
                    this.H.setText(this.f312385i.getResources().getString(R.string.a4e));
                    this.H.setEnabled(false);
                    if (str.equals("colorring")) {
                        if (i3 == 0) {
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        n("0X8004A24", "0X8004A24", j3, i17);
                    } else if (str.equals("comering")) {
                        if (i3 == 0) {
                            i16 = 0;
                        } else {
                            i16 = 1;
                        }
                        n("0X8005003", "0X8005003", j3, i16);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("id", j3);
                    bundle.putString("colorType", str);
                    o(com.tencent.mobileqq.emosm.a.a("colorRingSetup", "", this.S.key, bundle));
                } else if (QLog.isColorLevel()) {
                    QLog.d("ColorRingPlayer", 2, "setup failure.");
                }
            }
        }
        this.P.setVisibility(8);
    }

    public void q() {
        ViewGroup viewGroup = this.E;
        if (viewGroup != null && viewGroup.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
    }

    void r(long j3, int i3, String str) {
        if (i3 != 3) {
            Bundle bundle = new Bundle();
            bundle.putLong("id", j3);
            bundle.putInt("resourceType", i3);
            bundle.putString("colorType", str);
            o(com.tencent.mobileqq.emosm.a.a("startDownloadColorRing", "", this.S.key, bundle));
            return;
        }
        if (AppNetConnInfo.isMobileConn()) {
            c cVar = new c(this.f312385i.getActivity(), R.style.qZoneInputDialog);
            cVar.setContentView(R.layout.f167856jn);
            cVar.setTitle(HardCodeUtil.qqStr(R.string.ksm));
            cVar.setMessage(R.string.i0a);
            cVar.setCanceledOnTouchOutside(false);
            cVar.setNegativeButton(R.string.cancel, new d());
            cVar.setPositiveButton(R.string.f171151ok, new e(j3, i3, str));
            cVar.show();
            return;
        }
        d(j3, i3, str);
    }

    public void s(long j3, String str, String str2) {
        g gVar = this.f312381d;
        if (gVar.f312404b == j3 && gVar.f312405c.equals(str)) {
            if (this.f312381d.f312403a == 6) {
                e(j3, 0);
                return;
            }
            return;
        }
        g gVar2 = this.f312381d;
        if (gVar2.f312403a == 1) {
            u(gVar2.f312404b);
        }
        f();
        g gVar3 = this.f312381d;
        gVar3.f312404b = j3;
        gVar3.f312405c = str;
        gVar3.f312406d = str2;
        gVar3.f312403a = 0;
        this.P.setVisibility(8);
        a(j3, str);
    }

    void t() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vastrash.ColorRingPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                while (true) {
                    synchronized (ColorRingPlayer.this.f312382e) {
                        try {
                            try {
                                MediaPlayer mediaPlayer = ColorRingPlayer.this.f312383f;
                                if (mediaPlayer != null) {
                                    z16 = mediaPlayer.isPlaying();
                                } else {
                                    z16 = false;
                                }
                                MediaPlayer mediaPlayer2 = ColorRingPlayer.this.f312383f;
                                if (mediaPlayer2 == null || !z16) {
                                    break;
                                }
                                final int duration = mediaPlayer2.getDuration();
                                final int currentPosition = ColorRingPlayer.this.f312383f.getCurrentPosition();
                                ColorRingPlayer.this.f312386m.post(new Runnable() { // from class: com.tencent.mobileqq.vastrash.ColorRingPlayer.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean z17 = false;
                                        try {
                                            MediaPlayer mediaPlayer3 = ColorRingPlayer.this.f312383f;
                                            if (mediaPlayer3 != null) {
                                                z17 = mediaPlayer3.isPlaying();
                                            }
                                        } catch (IllegalStateException unused) {
                                            ColorRingPlayer colorRingPlayer = ColorRingPlayer.this;
                                            colorRingPlayer.f312383f = null;
                                            colorRingPlayer.f312383f = new ReportMediaPlayer();
                                        }
                                        ColorRingPlayer colorRingPlayer2 = ColorRingPlayer.this;
                                        if (colorRingPlayer2.f312383f != null && z17) {
                                            colorRingPlayer2.J.setProgress((currentPosition * 100) / duration);
                                        }
                                    }
                                });
                            } catch (IllegalStateException unused) {
                                ColorRingPlayer colorRingPlayer = ColorRingPlayer.this;
                                colorRingPlayer.f312383f = null;
                                colorRingPlayer.f312383f = new ReportMediaPlayer();
                            }
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    try {
                        LockMethodProxy.sleep(50L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }, 8, null, true);
    }

    void u(long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("id", j3);
        bundle.putInt("resourceType", 3);
        o(com.tencent.mobileqq.emosm.a.a("stopDownloadColorRing", "", this.S.key, bundle));
        synchronized (this.f312381d) {
            this.f312381d.f312403a = 2;
        }
        this.I.setImageDrawable(this.f312385i.getResources().getDrawable(R.drawable.f162102fn3));
        this.I.setVisibility(0);
        this.H.setText(this.f312385i.getResources().getString(R.string.a4g));
        this.G.setVisibility(4);
    }

    /* loaded from: classes20.dex */
    class f extends t {
        f() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
            ag agVar;
            ColorRingPlayer colorRingPlayer;
            if (bundle.getInt("srcType") != 5) {
                return;
            }
            String string = bundle.getString("status");
            long j3 = bundle.getLong("id");
            int i3 = bundle.getInt("progress");
            boolean z16 = bundle.getBoolean("result");
            int i16 = bundle.getInt("resourceType");
            String string2 = bundle.getString("colorType");
            if (QLog.isColorLevel()) {
                QLog.d("ColorRingPlayer", 2, "onPushMsg," + j3 + "," + i16 + "," + string + "," + i3 + "," + z16);
            }
            synchronized (ColorRingPlayer.this.f312381d) {
                if (ColorRingPlayer.this.f312381d.f312404b != j3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorRingPlayer", 2, "curId=" + ColorRingPlayer.this.f312381d.f312404b + ", pushId=" + j3);
                    }
                    return;
                }
                if (!"onStart".equals(string)) {
                    if ("onDone".equals(string)) {
                        if (z16) {
                            if (i16 == 3) {
                                if ("colorring".equals(string2)) {
                                    ColorRingPlayer colorRingPlayer2 = ColorRingPlayer.this;
                                    colorRingPlayer2.H.setText(colorRingPlayer2.f312385i.getResources().getString(R.string.hf8));
                                } else if ("comering".equals(string2)) {
                                    ColorRingPlayer colorRingPlayer3 = ColorRingPlayer.this;
                                    colorRingPlayer3.H.setText(colorRingPlayer3.f312385i.getResources().getString(R.string.hf_));
                                }
                                ColorRingPlayer colorRingPlayer4 = ColorRingPlayer.this;
                                colorRingPlayer4.I.setImageDrawable(colorRingPlayer4.f312385i.getResources().getDrawable(R.drawable.fn5));
                                ColorRingPlayer.this.I.setVisibility(0);
                                ColorRingPlayer.this.G.setVisibility(8);
                                synchronized (ColorRingPlayer.this.f312381d) {
                                    colorRingPlayer = ColorRingPlayer.this;
                                    colorRingPlayer.f312381d.f312403a = 3;
                                }
                                if (colorRingPlayer.C) {
                                    colorRingPlayer.e(j3, 0);
                                    return;
                                }
                                return;
                            }
                            if (i16 == 2) {
                                ColorRingPlayer.this.i(h.c(j3));
                                return;
                            } else {
                                if (i16 == 1 && h.d(j3) != null) {
                                    ColorRingPlayer.this.F.setImageBitmap(h.d(j3));
                                    return;
                                }
                                return;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("ColorRingPlayer", 2, "onDone, failure," + j3 + "," + i16);
                        }
                        if (i16 == 3) {
                            ColorRingPlayer colorRingPlayer5 = ColorRingPlayer.this;
                            colorRingPlayer5.H.setText(colorRingPlayer5.f312385i.getResources().getString(R.string.a4g));
                            ColorRingPlayer colorRingPlayer6 = ColorRingPlayer.this;
                            colorRingPlayer6.I.setImageDrawable(colorRingPlayer6.f312385i.getResources().getDrawable(R.drawable.f162102fn3));
                            ColorRingPlayer.this.I.setVisibility(0);
                            ColorRingPlayer.this.G.setVisibility(8);
                            synchronized (ColorRingPlayer.this.f312381d) {
                                ColorRingPlayer.this.f312381d.f312403a = 0;
                            }
                            return;
                        }
                        return;
                    }
                    if ("onProgress".equals(string) && i16 == 3 && (agVar = ColorRingPlayer.this.Q) != null) {
                        agVar.setLevel(i3 * 100);
                        ColorRingPlayer.this.Q.invalidateSelf();
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
