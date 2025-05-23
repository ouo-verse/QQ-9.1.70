package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0003J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0003J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0014\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0003J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u000602R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u001f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b6\u0010/\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "", "start", "end", "", "g2", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "newEntity", "", "X1", "d2", "musicEntity", SemanticAttributes.DbSystemValues.H2, "e2", "source", "f2", "Landroid/media/MediaPlayer;", "Z1", "", "updateInterval", "c2", "W1", "b2", "onCleared", "O1", "P1", "position", "N1", "musicInfoWrapper", "Q1", "", "newValue", "R1", "Landroid/media/AudioManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/media/AudioManager;", "getAm", "()Landroid/media/AudioManager;", "am", "D", "Landroid/media/MediaPlayer;", "mediaPlayer", "E", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "curMusicEntity", "Ljava/util/Timer;", UserInfo.SEX_FEMALE, "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$b;", "G", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$b;", "playInterval", "H", "MAX_VOLUME", "<init>", "(Landroid/media/AudioManager;)V", "I", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicPlayerViewModel extends a {
    private static final String J = MusicPlayerViewModel.class.getSimpleName();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AudioManager am;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MediaPlayer mediaPlayer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MusicInfoWrapper curMusicEntity;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Timer timer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b playInterval;

    /* renamed from: H, reason: from kotlin metadata */
    private final float MAX_VOLUME;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$b;", "", "", "c", "", "a", "I", "b", "()I", "e", "(I)V", "start", "d", "end", "<init>", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel;II)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int end;

        public b(int i3, int i16) {
            this.start = i3;
            this.end = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public final void c() {
            this.start = 0;
            this.end = 15000;
        }

        public final void d(int i3) {
            this.end = i3;
        }

        public final void e(int i3) {
            this.start = i3;
        }

        public /* synthetic */ b(MusicPlayerViewModel musicPlayerViewModel, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 15000 : i16);
        }
    }

    public MusicPlayerViewModel(@NotNull AudioManager am5) {
        Intrinsics.checkNotNullParameter(am5, "am");
        this.am = am5;
        this.playInterval = new b(this, 0, 0, 3, null);
        this.MAX_VOLUME = 1.0f;
    }

    private final void W1() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    private final boolean X1(MusicInfoWrapper newEntity) {
        String str;
        boolean z16;
        boolean z17;
        String localPath = newEntity.getLocalPath();
        MusicInfoWrapper musicInfoWrapper = this.curMusicEntity;
        if (musicInfoWrapper != null) {
            str = musicInfoWrapper.getLocalPath();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(localPath, str)) {
            return false;
        }
        MusicInfoWrapper musicInfoWrapper2 = this.curMusicEntity;
        if (musicInfoWrapper2 != null && newEntity.getStartTime() == musicInfoWrapper2.getStartTime()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        MusicInfoWrapper musicInfoWrapper3 = this.curMusicEntity;
        if (musicInfoWrapper3 != null && newEntity.getDurationMs() == musicInfoWrapper3.getDurationMs()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    private final MediaPlayer Z1() {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        reportMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.e
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                MusicPlayerViewModel.a2(mediaPlayer);
            }
        });
        return reportMediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(MediaPlayer mediaPlayer) {
        Log.i(J, "media player prepared");
    }

    private final void b2() {
        e2();
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
    }

    private final void c2(long updateInterval) {
        BaseTimer baseTimer = new BaseTimer();
        this.timer = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel$scheduleProgressUpdate$1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
            
                r0 = r1.mediaPlayer;
             */
            @Override // java.util.TimerTask, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                MediaPlayer mediaPlayer;
                MusicPlayerViewModel.b bVar;
                MediaPlayer mediaPlayer2;
                MusicPlayerViewModel.b bVar2;
                try {
                    mediaPlayer = MusicPlayerViewModel.this.mediaPlayer;
                    if (mediaPlayer != null) {
                        MusicPlayerViewModel musicPlayerViewModel = MusicPlayerViewModel.this;
                        if (mediaPlayer.isPlaying()) {
                            int currentPosition = mediaPlayer.getCurrentPosition();
                            musicPlayerViewModel.M1().postValue(Integer.valueOf(currentPosition));
                            bVar = musicPlayerViewModel.playInterval;
                            int end = bVar.getEnd();
                            boolean z16 = false;
                            if (1 <= end && end <= currentPosition) {
                                z16 = true;
                            }
                            if (z16 && mediaPlayer2 != null) {
                                bVar2 = musicPlayerViewModel.playInterval;
                                mediaPlayer2.seekTo(bVar2.getStart());
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }, 0L, updateInterval);
    }

    @RequiresApi(21)
    private final void d2() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.seekTo(this.playInterval.getStart());
            }
            c2(100L);
        } catch (IllegalStateException unused) {
        }
    }

    private final void e2() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } catch (Exception unused) {
        }
        W1();
    }

    @RequiresApi(21)
    private final boolean f2(MusicInfoWrapper source) {
        try {
            if (source == null) {
                b2();
                return false;
            }
            if (this.mediaPlayer == null) {
                this.mediaPlayer = Z1();
            }
            AudioAttributes build = new AudioAttributes.Builder().build();
            int generateAudioSessionId = this.am.generateAudioSessionId();
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setAudioAttributes(build);
                mediaPlayer.setAudioSessionId(generateAudioSessionId);
                mediaPlayer.setDataSource(source.getLocalPath());
                mediaPlayer.setLooping(true);
                mediaPlayer.prepare();
                mediaPlayer.seekTo(source.getStartTime());
            }
            return true;
        } catch (Exception e16) {
            Log.e(J, e16.toString());
            return false;
        }
    }

    private final void g2(int start, int end) {
        try {
            this.playInterval.e(start);
            this.playInterval.d(end);
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(start);
            }
        } catch (IllegalStateException unused) {
        }
    }

    @RequiresApi(21)
    private final void h2(MusicInfoWrapper musicEntity) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        this.playInterval.c();
        if (!f2(musicEntity)) {
            return;
        }
        g2(musicEntity.getStartTime(), musicEntity.getStartTime() + musicEntity.getDurationMs());
        d2();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.a
    public void N1(int position) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(position);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.a
    public void O1() {
        if (f2(this.curMusicEntity)) {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            c2(100L);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.a
    public void P1() {
        b2();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.a
    public void Q1(@NotNull MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(musicInfoWrapper, "musicInfoWrapper");
        if (!X1(musicInfoWrapper)) {
            this.curMusicEntity = musicInfoWrapper;
            h2(musicInfoWrapper);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.a
    public void R1(float newValue) {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(newValue, this.MAX_VOLUME);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(coerceAtMost, coerceAtMost);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        b2();
    }
}
