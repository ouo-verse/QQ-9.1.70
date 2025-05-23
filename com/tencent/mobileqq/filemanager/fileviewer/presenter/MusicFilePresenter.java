package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes12.dex */
public class MusicFilePresenter extends FileBrowserPresenterBase implements FileViewMusicService.b, FileBrowserModelBase.f {
    private String F;
    private Timer G;
    private boolean H;
    protected MusicFileViewer I;
    protected FileViewMusicService J;
    private boolean K;
    private b.c L;

    /* loaded from: classes12.dex */
    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            FileViewMusicService fileViewMusicService;
            if (z16 && (fileViewMusicService = MusicFilePresenter.this.J) != null) {
                fileViewMusicService.p(i3);
                MusicFilePresenter.this.f0(i3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MusicFilePresenter.this.K = false;
            MusicFilePresenter musicFilePresenter = MusicFilePresenter.this;
            FileViewMusicService fileViewMusicService = musicFilePresenter.J;
            if (fileViewMusicService != null && !fileViewMusicService.j(musicFilePresenter.F)) {
                MusicFilePresenter.this.J.t();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            MusicFilePresenter.this.K = true;
            FileViewMusicService fileViewMusicService = MusicFilePresenter.this.J;
            if (fileViewMusicService != null) {
                fileViewMusicService.o();
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MusicFilePresenter.this.H) {
                MusicFilePresenter.this.d0();
            } else {
                MusicFilePresenter.this.e0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements FileViewMusicService.c {
        c() {
        }

        @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.c
        public void a(int i3) {
            MusicFilePresenter.this.b0(i3);
        }
    }

    /* loaded from: classes12.dex */
    class d implements b.c {
        d() {
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1) {
                    QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_GAIN");
                    if (!MusicFilePresenter.this.H) {
                        MusicFilePresenter.this.e0();
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_LOSS");
            if (MusicFilePresenter.this.H) {
                MusicFilePresenter.this.d0();
            }
        }
    }

    public MusicFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.H = false;
        this.K = true;
        this.L = new d();
        MusicFileViewer musicFileViewer = new MusicFileViewer(activity);
        this.I = musicFileViewer;
        S(musicFileViewer);
    }

    private boolean c0() {
        FileViewMusicService fileViewMusicService = this.J;
        if (fileViewMusicService == null || !fileViewMusicService.j(this.F) || !this.J.l()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        FileManagerReporter.addData("0X8004BE1");
        FileViewMusicService fileViewMusicService = this.J;
        if (fileViewMusicService == null) {
            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
        } else if (fileViewMusicService.j(this.F)) {
            this.J.m();
            i0(false);
            com.tencent.mobileqq.mediafocus.b.i().d(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        FileManagerReporter.addData("0X8004BE0");
        FileViewMusicService fileViewMusicService = this.J;
        if (fileViewMusicService == null) {
            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
            return;
        }
        if (!fileViewMusicService.j(this.F)) {
            this.J.q(this);
            if (!this.J.d(this.F)) {
                return;
            }
        }
        this.J.r();
        i0(true);
        com.tencent.mobileqq.mediafocus.b.i().l(1, this.L);
    }

    private void g0() {
        this.I.t(this.f208460e.L());
        this.I.s(q.g(this.f208460e.Q()));
        this.I.q();
        I();
        this.F = this.f208460e.N();
        a0();
        this.I.w(true);
        if (this.J.j(this.F)) {
            f0(this.J.a());
        } else {
            this.I.r(QFileUtils.x(0L));
        }
    }

    private void i0(boolean z16) {
        this.H = z16;
        if (z16) {
            int a16 = this.J.a();
            f0(a16);
            this.I.x(a16);
            j0();
        } else {
            k0();
        }
        this.I.v(this.H);
    }

    private void j0() {
        k0();
        BaseTimer baseTimer = new BaseTimer();
        this.G = baseTimer;
        baseTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MusicFilePresenter.this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MusicFilePresenter musicFilePresenter = MusicFilePresenter.this;
                        FileViewMusicService fileViewMusicService = musicFilePresenter.J;
                        if (fileViewMusicService != null && fileViewMusicService.k(musicFilePresenter.F, false)) {
                            int a16 = MusicFilePresenter.this.J.a();
                            MusicFilePresenter.this.f0(a16);
                            MusicFilePresenter.this.I.x(a16);
                        }
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void k0() {
        Timer timer = this.G;
        if (timer != null) {
            timer.cancel();
            this.G = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        this.f208461f.setRequestedOrientation(1);
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void I() {
        super.I();
        if (this.f208460e.T() == 2) {
            this.I.n(false);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
        }
        g0();
        this.I.x(0);
        this.I.y(new a());
        this.I.u(new b());
        this.f208460e.O0(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        J(f16);
    }

    public void a0() {
        this.F = this.f208460e.N();
        if (this.J == null) {
            this.J = FileViewMusicService.c();
        }
        this.J.b(this.F, new c());
        if (this.J.j(this.F)) {
            this.J.q(this);
        }
        if (this.f208460e.s0()) {
            e0();
        }
        i0(c0());
    }

    public void b0(final int i3) {
        final String x16 = QFileUtils.x(i3);
        this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                MusicFilePresenter.this.I.A(x16);
                MusicFilePresenter.this.I.z(i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        this.I.n(true);
        this.I.o(false);
        I();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        this.I.n(true);
        this.I.o(false);
        I();
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.h2();
        }
    }

    public void f0(int i3) {
        this.I.r(QFileUtils.x(i3));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
        this.I.n(false);
        this.I.o(true);
        J(this.f208460e.S());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
        this.I.n(true);
        this.I.o(false);
        I();
    }

    @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.b
    public void onCompletion() {
        this.I.r(QFileUtils.x(0L));
        this.I.x(0);
        i0(false);
    }

    @Override // com.tencent.mobileqq.filebrowser.FileViewMusicService.b
    public void onError(String str) {
        Activity activity = this.f208461f;
        QQToast.makeText(activity, 0, activity.getString(R.string.bea), 1).show(this.f208461f.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        this.I.r(QFileUtils.x(0L));
        this.I.x(0);
        i0(false);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void x() {
        FileViewMusicService fileViewMusicService;
        super.x();
        FileViewMusicService fileViewMusicService2 = this.J;
        if (fileViewMusicService2 != null) {
            fileViewMusicService2.q(null);
        }
        k0();
        if (this.H && (fileViewMusicService = this.J) != null && fileViewMusicService.j(this.F)) {
            this.J.s();
        }
        com.tencent.mobileqq.mediafocus.b.i().e(this.L);
        this.J = null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void y() {
        super.y();
        k0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void z() {
        super.z();
        g0();
    }
}
