package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import rx.functions.Action0;

/* loaded from: classes12.dex */
public class MusicFilePresenter extends FileBrowserPresenterBase implements FileViewMusicService.b, e.f {
    static IPatchRedirector $redirector_;
    private final MusicFileBrowserView G;
    protected FileViewMusicService H;
    private Timer I;
    private boolean J;
    private final b.c K;
    private boolean L;

    /* loaded from: classes12.dex */
    class a implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7520a implements Action0 {
            static IPatchRedirector $redirector_;

            C7520a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // rx.functions.Action0
            public void call() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    MusicFilePresenter.this.a0();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        /* loaded from: classes12.dex */
        class b implements Action0 {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // rx.functions.Action0
            public void call() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    MusicFilePresenter.this.Z();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1) {
                    QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_GAIN");
                    if (!MusicFilePresenter.this.J) {
                        MusicFilePresenter.this.d0(new C7520a());
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_LOSS");
            if (MusicFilePresenter.this.J) {
                MusicFilePresenter.this.d0(new b());
            }
        }
    }

    /* loaded from: classes12.dex */
    class b implements SeekBar.OnSeekBarChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            FileViewMusicService fileViewMusicService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (z16 && (fileViewMusicService = MusicFilePresenter.this.H) != null) {
                fileViewMusicService.p(i3);
                MusicFilePresenter.this.b0(i3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                MusicFilePresenter.this.L = false;
                MusicFilePresenter musicFilePresenter = MusicFilePresenter.this;
                FileViewMusicService fileViewMusicService = musicFilePresenter.H;
                if (fileViewMusicService != null && !fileViewMusicService.j(musicFilePresenter.f205964e.getFilePath())) {
                    MusicFilePresenter.this.H.t();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                MusicFilePresenter.this.L = true;
                FileViewMusicService fileViewMusicService = MusicFilePresenter.this.H;
                if (fileViewMusicService != null) {
                    fileViewMusicService.o();
                }
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) seekBar);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (MusicFilePresenter.this.J) {
                MusicFilePresenter.this.Z();
            } else {
                MusicFilePresenter.this.a0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements FileViewMusicService.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                MusicFilePresenter.this.X(i3);
            }
        }
    }

    public MusicFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.J = false;
        this.K = new a();
        this.L = true;
        MusicFileBrowserView musicFileBrowserView = new MusicFileBrowserView(activity);
        this.G = musicFileBrowserView;
        P(musicFileBrowserView);
    }

    private void W() {
        if (this.H == null) {
            this.H = FileViewMusicService.c();
        }
        this.H.b(this.f205964e.getFilePath(), new d());
        if (this.H.j(this.f205964e.getFilePath())) {
            this.H.q(this);
        }
        e0(Y());
    }

    private boolean Y() {
        FileViewMusicService fileViewMusicService = this.H;
        if (fileViewMusicService == null || !fileViewMusicService.j(this.f205964e.getFilePath()) || !this.H.l()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic");
        FileManagerReporter.addData("0X8004BE1");
        FileViewMusicService fileViewMusicService = this.H;
        if (fileViewMusicService == null) {
            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
        } else if (fileViewMusicService.j(this.f205964e.getFilePath())) {
            this.H.m();
            e0(false);
            com.tencent.mobileqq.mediafocus.b.i().d(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        QLog.d("FileBrowserPresenter<FileAssistant>", 1, "playMusic");
        FileManagerReporter.addData("0X8004BE0");
        FileViewMusicService fileViewMusicService = this.H;
        if (fileViewMusicService == null) {
            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
            return;
        }
        if (!fileViewMusicService.j(this.f205964e.getFilePath())) {
            this.H.q(this);
            if (!this.H.d(this.f205964e.getFilePath())) {
                return;
            }
        }
        this.H.r();
        e0(true);
        com.tencent.mobileqq.mediafocus.b.i().l(1, this.K);
    }

    private void c0() {
        this.G.v(this.f205964e.getFileName());
        this.G.u(com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()));
        this.G.s();
        C();
        W();
        this.G.y(true);
        if (this.H.j(this.f205964e.getFilePath())) {
            b0(this.H.a());
        } else {
            this.G.t(ae.d(0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(Action0 action0) {
        Activity activity = this.f205965f;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(action0) { // from class: com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Action0 f205980d;

            {
                this.f205980d = action0;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this, (Object) action0);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f205980d.call();
                }
            }
        });
    }

    private void e0(boolean z16) {
        this.J = z16;
        if (z16) {
            int a16 = this.H.a();
            b0(a16);
            this.G.z(a16);
            f0();
        } else {
            g0();
        }
        this.G.x(this.J);
    }

    private void f0() {
        QLog.d("FileBrowserPresenter<FileAssistant>", 1, "startPlayTimer");
        g0();
        BaseTimer baseTimer = new BaseTimer();
        this.I = baseTimer;
        baseTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicFilePresenter.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    MusicFilePresenter.this.f205965f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.7.1
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
                            MusicFilePresenter musicFilePresenter = MusicFilePresenter.this;
                            FileViewMusicService fileViewMusicService = musicFilePresenter.H;
                            if (fileViewMusicService != null && fileViewMusicService.k(musicFilePresenter.f205964e.getFilePath(), false)) {
                                int a16 = MusicFilePresenter.this.H.a();
                                MusicFilePresenter.this.b0(a16);
                                MusicFilePresenter.this.G.z(a16);
                            }
                        }
                    });
                }
            }
        }, 0L, 1000L);
    }

    private void g0() {
        Timer timer = this.I;
        if (timer != null) {
            timer.cancel();
            this.I = null;
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.C();
        if (this.f205963d.O() == 2) {
            this.G.o(false);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
        }
        c0();
        this.G.z(0);
        this.G.A(new b());
        this.G.w(new c());
        this.f205963d.P(this);
    }

    public void X(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f205965f.runOnUiThread(new Runnable(ae.d(i3), i3) { // from class: com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f205978d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f205979e;

                {
                    this.f205978d = r6;
                    this.f205979e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MusicFilePresenter.this, r6, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MusicFilePresenter.this.G.C(this.f205978d);
                        MusicFilePresenter.this.G.B(this.f205979e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            G(f16);
        }
    }

    public void b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.G.t(ae.d(i3));
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.G.o(true);
        this.G.q(false);
        C();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.G.o(true);
        this.G.q(false);
        C();
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.A();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.G.o(false);
        this.G.q(true);
        G(this.f205963d.F());
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.G.o(true);
        this.G.q(false);
        C();
    }

    @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.b
    public void onCompletion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.G.t(ae.d(0L));
        this.G.z(0);
        e0(false);
    }

    @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.b
    public void onError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        Context context = this.f205966h;
        QQToast.makeText(context, 0, context.getString(R.string.bea), 1).show(this.f205966h.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        this.G.t(ae.d(0L));
        this.G.z(0);
        e0(false);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void t() {
        FileViewMusicService fileViewMusicService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.t();
        FileViewMusicService fileViewMusicService2 = this.H;
        if (fileViewMusicService2 != null) {
            fileViewMusicService2.q(null);
        }
        g0();
        if (this.J && (fileViewMusicService = this.H) != null && fileViewMusicService.j(this.f205964e.getFilePath())) {
            this.H.s();
        }
        com.tencent.mobileqq.mediafocus.b.i().e(this.K);
        this.H = null;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.u();
            g0();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.v();
            c0();
        }
    }
}
