package com.tencent.mobileqq.filebrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.player.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileViewMusicService implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnPreparedListener, a.b {
    static IPatchRedirector $redirector_;
    private static WeakReference<FileViewMusicService> H;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private BroadcastReceiver G;

    /* renamed from: d, reason: collision with root package name */
    String f205918d;

    /* renamed from: e, reason: collision with root package name */
    b f205919e;

    /* renamed from: f, reason: collision with root package name */
    private MediaPlayer f205920f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.filebrowser.player.a f205921h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f205922i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f205923m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileViewMusicService.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                FileViewMusicService.this.m();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void onCompletion();

        void onError(String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            H = null;
        }
    }

    FileViewMusicService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205922i = false;
        this.f205923m = false;
        this.C = false;
        this.D = false;
        this.F = false;
    }

    public static FileViewMusicService c() {
        FileViewMusicService fileViewMusicService;
        WeakReference<FileViewMusicService> weakReference = H;
        if (weakReference != null) {
            fileViewMusicService = weakReference.get();
        } else {
            fileViewMusicService = null;
        }
        if (fileViewMusicService == null) {
            FileViewMusicService fileViewMusicService2 = new FileViewMusicService();
            H = new WeakReference<>(fileViewMusicService2);
            return fileViewMusicService2;
        }
        return fileViewMusicService;
    }

    private void e() {
        if (this.G == null) {
            this.G = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            BaseApplication.getContext().registerReceiver(this.G, intentFilter);
        }
    }

    private void f(String str) {
        this.D = true;
        com.tencent.mobileqq.filebrowser.player.a aVar = new com.tencent.mobileqq.filebrowser.player.a();
        this.f205921h = aVar;
        aVar.p(this);
        this.C = false;
        this.f205923m = false;
        this.E = 0;
        this.F = false;
        this.f205921h.k(str);
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private boolean g(String str) {
        FileInputStream fileInputStream;
        ?? r16 = 0;
        FileInputStream fileInputStream2 = null;
        if (this.f205920f != null) {
            QLog.d("FileViewMusicService<FileAssistant>", 1, "init release music");
            this.f205920f.stop();
            this.f205920f.release();
            this.f205920f = null;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f205920f = reportMediaPlayer;
        reportMediaPlayer.setOnCompletionListener(this);
        this.f205920f.setOnErrorListener(this);
        this.f205920f.setOnPreparedListener(this);
        this.f205920f.setLooping(false);
        this.f205918d = null;
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (IOException e16) {
                e = e16;
            } catch (IllegalArgumentException e17) {
                e = e17;
                fileInputStream = null;
            } catch (IllegalStateException e18) {
                e = e18;
                fileInputStream = null;
            } catch (SecurityException e19) {
                e = e19;
                fileInputStream = null;
            }
            try {
                this.f205920f.setAudioStreamType(3);
                this.f205920f.setDataSource(fileInputStream.getFD());
                this.C = false;
                this.f205923m = false;
                this.E = 0;
                this.F = false;
                e();
                this.f205920f.prepareAsync();
                try {
                    fileInputStream.close();
                } catch (IOException e26) {
                    QLog.d("FileViewMusicService<FileAssistant>", 1, e26, new Object[0]);
                }
                return false;
            } catch (IOException e27) {
                e = e27;
                fileInputStream2 = fileInputStream;
                b bVar = this.f205919e;
                if (bVar != null) {
                    bVar.onError(BaseApplication.getContext().getString(R.string.zzt));
                }
                QLog.e("FileViewMusicService<FileAssistant>", 1, "mediaplay init error[IOException]:", e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e28) {
                        QLog.d("FileViewMusicService<FileAssistant>", 1, e28, new Object[0]);
                    }
                }
                return true;
            } catch (IllegalArgumentException e29) {
                e = e29;
                b bVar2 = this.f205919e;
                if (bVar2 != null) {
                    bVar2.onError(null);
                }
                QLog.e("FileViewMusicService<FileAssistant>", 1, "mediaplay init error[IllegalArgumentException]:", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e36) {
                        QLog.d("FileViewMusicService<FileAssistant>", 1, e36, new Object[0]);
                    }
                }
                return true;
            } catch (IllegalStateException e37) {
                e = e37;
                b bVar3 = this.f205919e;
                if (bVar3 != null) {
                    bVar3.onError(null);
                }
                QLog.e("FileViewMusicService<FileAssistant>", 1, "mediaplay init error[IllegalStateException]:", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e38) {
                        QLog.d("FileViewMusicService<FileAssistant>", 1, e38, new Object[0]);
                    }
                }
                return true;
            } catch (SecurityException e39) {
                e = e39;
                b bVar4 = this.f205919e;
                if (bVar4 != null) {
                    bVar4.onError(null);
                }
                QLog.e("FileViewMusicService<FileAssistant>", 1, "mediaplay init error[SecurityException]:", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e46) {
                        QLog.d("FileViewMusicService<FileAssistant>", 1, e46, new Object[0]);
                    }
                }
                return true;
            }
        } catch (Throwable th6) {
            th = th6;
            r16 = str;
            if (r16 != 0) {
                try {
                    r16.close();
                } catch (IOException e47) {
                    QLog.d("FileViewMusicService<FileAssistant>", 1, e47, new Object[0]);
                }
            }
            throw th;
        }
    }

    private boolean h(String str) {
        String str2;
        if (!M4APlayerConfigKt.a()) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str2 = str.substring(lastIndexOf + 1);
        } else {
            str2 = "";
        }
        return FileReaderHelper.M4A_EXT.equals(str2);
    }

    private boolean i() {
        if (this.D) {
            com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
            if (aVar != null && aVar.l()) {
                return true;
            }
            return false;
        }
        MediaPlayer mediaPlayer = this.f205920f;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    private void n() {
        com.tencent.mobileqq.filebrowser.player.a aVar;
        QLog.d("FileViewMusicService<FileAssistant>", 1, "playMusic");
        if (this.f205923m && this.C) {
            try {
                String str = this.f205918d;
                if (str != null && str.length() != 0) {
                    int requestAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1);
                    QLog.d("FileViewMusicService<FileAssistant>", 1, "playMusic requestAudioFocus result:" + requestAudioFocus);
                    if (requestAudioFocus == 0) {
                        QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
                        return;
                    }
                    QLog.e("FileViewMusicService<FileAssistant>", 1, "playMusic bResumePlay: " + this.f205922i + ", mediaPlayer:" + this.f205920f + " bIsM4AFile:" + this.D);
                    if (this.D && (aVar = this.f205921h) != null && this.f205922i) {
                        aVar.q();
                        return;
                    }
                    MediaPlayer mediaPlayer = this.f205920f;
                    if (mediaPlayer != null && this.f205922i) {
                        mediaPlayer.start();
                        return;
                    }
                    return;
                }
                if (!QLog.isDevelopLevel()) {
                    QLog.e("FileViewMusicService<FileAssistant>", 1, "musci path not init!");
                    return;
                }
                throw new NullPointerException(BaseApplication.getContext().getString(R.string.zzs));
            } catch (Exception e16) {
                QLog.e("FileViewMusicService<FileAssistant>", 1, "musicPathString not init ", e16);
                return;
            }
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "playMusic bPrepared:" + this.f205923m + ", bStarted:" + this.C);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        MediaPlayer mediaPlayer = this.f205920f;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
        if (aVar != null) {
            return aVar.j();
        }
        return 0;
    }

    public void b(String str, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) cVar);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable(str, cVar) { // from class: com.tencent.mobileqq.filebrowser.FileViewMusicService.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f205924d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ c f205925e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.filebrowser.FileViewMusicService$1$a */
                /* loaded from: classes12.dex */
                class a implements MediaPlayer.OnPreparedListener {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MediaPlayer f205926d;

                    a(MediaPlayer mediaPlayer) {
                        this.f205926d = mediaPlayer;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) mediaPlayer);
                        }
                    }

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                            return;
                        }
                        int duration = this.f205926d.getDuration();
                        this.f205926d.stop();
                        this.f205926d.release();
                        AnonymousClass1.this.f205925e.a(duration);
                    }
                }

                {
                    this.f205924d = str;
                    this.f205925e = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FileViewMusicService.this, str, cVar);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:36:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    FileInputStream fileInputStream;
                    Exception e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
                    int i3 = 0;
                    i3 = 0;
                    i3 = 0;
                    i3 = 0;
                    i3 = 0;
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(new File(this.f205924d));
                        } catch (Exception e17) {
                            fileInputStream = null;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileInputStream2 != null) {
                            }
                            throw th;
                        }
                        try {
                            reportMediaPlayer.setAudioStreamType(3);
                            reportMediaPlayer.setDataSource(fileInputStream.getFD());
                            reportMediaPlayer.setOnPreparedListener(new a(reportMediaPlayer));
                            reportMediaPlayer.prepareAsync();
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                Object[] objArr = new Object[0];
                                QLog.d("FileViewMusicService<FileAssistant>", 1, e18, objArr);
                                i3 = objArr;
                            }
                        } catch (Exception e19) {
                            e16 = e19;
                            QLog.d("FileViewMusicService<FileAssistant>", 1, e16, new Object[0]);
                            reportMediaPlayer.stop();
                            reportMediaPlayer.release();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e26) {
                                    Object[] objArr2 = new Object[0];
                                    QLog.d("FileViewMusicService<FileAssistant>", 1, e26, objArr2);
                                    i3 = objArr2;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e27) {
                                QLog.d("FileViewMusicService<FileAssistant>", 1, e27, new Object[i3]);
                            }
                        }
                        throw th;
                    }
                }
            });
        }
    }

    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "init music strPath:" + str);
        if (h(str)) {
            f(str);
        } else if (g(str)) {
            return false;
        }
        this.f205918d = str;
        return true;
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        return k(str, true);
    }

    public boolean k(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        boolean i3 = i();
        if (z16) {
            QLog.d("FileViewMusicService<FileAssistant>", 1, "isPlayThis strPath:" + str + ", musicPathString: " + this.f205918d + ", mediaPlaying:" + i3);
        }
        String str2 = this.f205918d;
        if (str2 == null || !str2.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.D) {
            if (this.f205921h == null) {
                QLog.e("FileViewMusicService<FileAssistant>", 1, "isPlaying m4APlayer null");
                return false;
            }
            QLog.d("FileViewMusicService<FileAssistant>", 1, "isPlaying :" + this.f205921h.l());
            return this.f205921h.l();
        }
        if (this.f205920f == null) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "isPlaying mediaPlayer null");
            return false;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "isPlaying :" + this.f205920f.isPlaying());
        return this.f205920f.isPlaying();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "pause");
        if (this.D) {
            com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
            if (aVar != null && aVar.l()) {
                this.f205921h.m();
            }
        } else {
            MediaPlayer mediaPlayer = this.f205920f;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f205920f.pause();
            }
        }
        this.f205922i = false;
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        int abandonAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this);
        QLog.d("FileViewMusicService<FileAssistant>", 1, "pause abandonAudioFocus result:" + abandonAudioFocus);
        if (abandonAudioFocus == 0) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f205922i) {
            try {
                if (((AudioManager) BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0) {
                    QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
                    return;
                }
                if (this.D) {
                    com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
                    if (aVar != null) {
                        aVar.q();
                        return;
                    }
                    return;
                }
                MediaPlayer mediaPlayer = this.f205920f;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            } catch (Exception e16) {
                QLog.e("FileViewMusicService<FileAssistant>", 1, e16, new Object[0]);
            }
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onAudioFocusChange focusChange:" + i3);
        if (i3 != -3) {
            if ((i3 == -2 || i3 == -1) && i()) {
                m();
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer = this.f205920f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.1f, 0.1f);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.player.a.b
    public void onComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onComplete");
        com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
        if (aVar != null) {
            aVar.o(0.0d);
        }
        b bVar = this.f205919e;
        if (bVar != null) {
            bVar.onCompletion();
        }
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        int abandonAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this);
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onCompletion abandonAudioFocus result:" + abandonAudioFocus);
        if (abandonAudioFocus == 0) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
        }
        this.f205922i = false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaPlayer);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onCompletion");
        this.f205920f.seekTo(0);
        b bVar = this.f205919e;
        if (bVar != null) {
            bVar.onCompletion();
        }
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        int abandonAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this);
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onCompletion abandonAudioFocus result:" + abandonAudioFocus);
        if (abandonAudioFocus == 0) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
        }
        this.f205922i = false;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        QLog.e("FileViewMusicService<FileAssistant>", 1, "what[" + i3 + "],extra[" + i16 + "]");
        b bVar = this.f205919e;
        if (bVar != null) {
            bVar.onError(BaseApplication.getContext().getString(R.string.zzr));
        }
        this.f205920f.release();
        this.f205920f = null;
        this.f205918d = null;
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        int abandonAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this);
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onError abandonAudioFocus result:" + abandonAudioFocus);
        if (abandonAudioFocus == 0) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) mediaPlayer);
            return;
        }
        this.f205923m = true;
        n();
        if (this.f205920f == null || !this.F) {
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onPrepared seekTo:" + this.E);
        this.f205920f.seekTo(this.E);
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "seekToPos progress\uff1a" + i3);
        MediaPlayer mediaPlayer = this.f205920f;
        if (mediaPlayer != null) {
            this.E = i3;
            this.F = true;
            if (this.f205923m) {
                mediaPlayer.seekTo(i3);
            }
        }
        com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
        if (aVar != null) {
            this.E = i3;
            this.F = true;
            if (this.f205923m) {
                aVar.o(i3);
            }
        }
    }

    public void q(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f205919e = bVar;
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f205922i = true;
        this.C = true;
        n();
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "stop");
        if (this.D) {
            com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
            if (aVar != null) {
                aVar.r();
                this.f205921h = null;
            }
        } else {
            MediaPlayer mediaPlayer = this.f205920f;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f205920f.release();
                this.f205920f = null;
            }
        }
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        try {
            if (((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
                QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not abandon audio focus");
            }
        } catch (Exception unused) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "FileViewMusicService get QQAppInterface failed!!!");
        }
        this.f205918d = null;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "tmpPause");
        if (this.D) {
            com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
            if (aVar != null && aVar.l()) {
                this.f205921h.m();
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer = this.f205920f;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f205920f.pause();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.player.a.b
    public void onPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f205923m = true;
        n();
        if (this.f205921h == null || !this.F) {
            return;
        }
        QLog.d("FileViewMusicService<FileAssistant>", 1, "m4a onPrepared seekTo:" + this.E);
        this.f205921h.o((double) this.E);
    }

    @Override // com.tencent.mobileqq.filebrowser.player.a.b
    public void onError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) str);
            return;
        }
        QLog.e("FileViewMusicService<FileAssistant>", 1, "m4aPlayer what[" + i3 + "],extra[" + str + "]");
        b bVar = this.f205919e;
        if (bVar != null) {
            bVar.onError(BaseApplication.getContext().getString(R.string.zzr));
        }
        com.tencent.mobileqq.filebrowser.player.a aVar = this.f205921h;
        if (aVar != null) {
            aVar.r();
            this.f205921h = null;
        }
        this.f205918d = null;
        if (this.G != null) {
            BaseApplication.getContext().unregisterReceiver(this.G);
            this.G = null;
        }
        int abandonAudioFocus = ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this);
        QLog.d("FileViewMusicService<FileAssistant>", 1, "onError abandonAudioFocus result:" + abandonAudioFocus);
        if (abandonAudioFocus == 0) {
            QLog.e("FileViewMusicService<FileAssistant>", 1, "fileviewer mediaplayservice can not get audio focus");
        }
    }
}
