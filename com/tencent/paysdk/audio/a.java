package com.tencent.paysdk.audio;

import android.media.MediaPlayer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.util.FileUtil;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/paysdk/audio/a;", "Lcom/tencent/paysdk/api/b;", "", h.F, "e", "", Constants.AUDIO_FILE_PATH, "i", "audioUrl", "j", "", "f", "g", "msg", "l", "b", "a", "k", "Ljava/lang/String;", "mCachePath", "Landroid/media/MediaPlayer;", "Landroid/media/MediaPlayer;", "mMediaPlayer", "c", "mAudioUrl", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "mLastJob", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class a implements com.tencent.paysdk.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final a f341990e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mCachePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MediaPlayer mMediaPlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mAudioUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Job mLastJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/paysdk/audio/a$a;", "", "Lcom/tencent/paysdk/audio/a;", "a", "", "TAG", "Ljava/lang/String;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/paysdk/audio/a;", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.paysdk.audio.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @JvmStatic
        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return a.f341990e;
            }
            return (a) iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class b implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final b f341996d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(com.heytap.mcssdk.a.b.B);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f341996d = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaPlayer);
                return;
            }
            com.tencent.paysdk.log.c.b("AudioHelperImpl", "onCompletion");
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class c implements MediaPlayer.OnErrorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final c f341997d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12337);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f341997d = new c();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            com.tencent.paysdk.log.c.a("AudioHelperImpl", "onError what=" + i3 + " extra=" + i16);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/paysdk/audio/a$d", "Lcom/tencent/paysdk/util/FileUtil$a;", "Ljava/io/File;", "file", "", "a", "", "errCode", "", "errMsg", "onFailed", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class d implements FileUtil.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.paysdk.util.FileUtil.a
        public void a(@Nullable File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
                return;
            }
            if (file != null && file.exists()) {
                com.tencent.paysdk.log.c.b("AudioHelperImpl", "downloadFile suc playLocalAudioFile path=" + file.getPath());
                a aVar = a.this;
                String path = file.getPath();
                Intrinsics.checkNotNull(path);
                aVar.i(path);
                return;
            }
            com.tencent.paysdk.log.c.a("AudioHelperImpl", "downloadFile suc but file not exist!");
        }

        @Override // com.tencent.paysdk.util.FileUtil.a
        public void onFailed(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, errCode, (Object) errMsg);
                return;
            }
            com.tencent.paysdk.log.c.a("AudioHelperImpl", "downloadFile onFailed! errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            f341990e = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    private final void e() {
        com.tencent.paysdk.log.c.b("AudioHelperImpl", "try cancel last job=" + this.mLastJob);
        Job job = this.mLastJob;
        if (job != null) {
            JobKt__JobKt.cancel$default(job, "cancelLastJob", null, 2, null);
        }
    }

    private final boolean f(String audioFilePath) {
        return FileUtil.INSTANCE.d(audioFilePath);
    }

    private final void g() {
        boolean z16;
        String str = this.mCachePath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            l("setAudioTipsCachePath first!");
        } else if (!new File(this.mCachePath).isDirectory()) {
            l(this.mCachePath + " not directory!");
        }
    }

    private final void h() {
        e();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
            } catch (Exception e16) {
                com.tencent.paysdk.log.c.a("AudioHelperImpl", "checkStopLastPlay err=" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String audioFilePath) {
        this.mMediaPlayer = new ReportMediaPlayer();
        if (!FileUtil.INSTANCE.d(audioFilePath)) {
            com.tencent.paysdk.log.c.a("AudioHelperImpl", "playLocalAudioFile but file not exist!");
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setDataSource(audioFilePath);
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(b.f341996d);
            mediaPlayer.setOnErrorListener(c.f341997d);
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    private final void j(String audioUrl, String audioFilePath) {
        this.mLastJob = FileUtil.INSTANCE.b(audioUrl, audioFilePath, new d());
    }

    private final void l(String msg2) {
        com.tencent.paysdk.log.c.a("AudioHelperImpl", msg2);
        throw new Exception(msg2);
    }

    @Override // com.tencent.paysdk.api.b
    public void a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        g();
        h();
        String str = this.mAudioUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.paysdk.log.c.a("AudioHelperImpl", "audioUrl null!");
            return;
        }
        FileUtil.Companion companion = FileUtil.INSTANCE;
        String str2 = this.mAudioUrl;
        Intrinsics.checkNotNull(str2);
        String str3 = this.mCachePath + '/' + companion.c(str2);
        if (!f(str3)) {
            String str4 = this.mAudioUrl;
            if (str4 != null) {
                com.tencent.paysdk.log.c.b("AudioHelperImpl", "file not exist start download audioUrl=" + this.mAudioUrl);
                j(str4, str3);
                return;
            }
            return;
        }
        com.tencent.paysdk.log.c.b("AudioHelperImpl", "file exist, direct play=" + str3);
        i(str3);
    }

    @Override // com.tencent.paysdk.api.b
    public void b(@Nullable String audioUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) audioUrl);
            return;
        }
        com.tencent.paysdk.log.c.b("AudioHelperImpl", "updateAudioUrl " + audioUrl);
        this.mAudioUrl = audioUrl;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            h();
        }
    }
}
