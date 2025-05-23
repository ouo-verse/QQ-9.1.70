package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00020 j\b\u0012\u0004\u0012\u00020\u0002`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ac;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/l;", "", "id", "", "H", ReportConstant.COSTREPORT_PREFIX, "p", "Lcom/tencent/trtc/TRTCCloud;", "trtcCloud", HippyTKDListViewAdapter.X, "", "path", "loopCount", "", "startTime", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/u;", "observer", "v", "J", "t", "g", "targetTime", "G", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "D", "u", BdhLogUtil.LogTag.Tag_Conn, tl.h.F, "a", "Lcom/tencent/trtc/TRTCCloud;", "musicTRTCCloud", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "playingMusicIdSet", "<init>", "()V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ac implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TRTCCloud musicTRTCCloud;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<Integer> playingMusicIdSet = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/trtc/ac$b", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "", "id", "errCode", "", "onStart", "", "currentProgressMs", "durationMs", "onPlayProgress", "onComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements TXAudioEffectManager.TXMusicPlayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f228540a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ac f228541b;

        b(u uVar, ac acVar) {
            this.f228540a = uVar;
            this.f228541b = acVar;
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onComplete(int id5, int errCode) {
            QLog.d("TRTCOpenMusicHelper", 1, "music play complete: " + id5 + ", " + errCode);
            this.f228540a.onComplete(this.f228541b.s(id5), errCode);
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onPlayProgress(int id5, long currentProgressMs, long durationMs) {
            this.f228540a.onPlayProgress(this.f228541b.s(id5), currentProgressMs, durationMs);
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onStart(int id5, int errCode) {
            QLog.d("TRTCOpenMusicHelper", 1, "music play start: " + id5 + ", " + errCode);
            this.f228540a.onStart(this.f228541b.s(id5), errCode);
        }
    }

    private final void H(int id5) {
        TXAudioEffectManager audioEffectManager;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.stopPlayMusic(id5);
        }
    }

    private final int p(int id5) {
        return id5 + 65280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(int id5) {
        return id5 - 65280;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public long C(@Nullable String path) {
        Long l3;
        TXAudioEffectManager audioEffectManager;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            l3 = Long.valueOf(audioEffectManager.getMusicDurationInMS(path));
        } else {
            l3 = null;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "getOpenMusicCurrentProgress: " + path + ", " + l3);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int D(int id5, int volume) {
        TXAudioEffectManager audioEffectManager;
        int p16 = p(id5);
        if (!this.playingMusicIdSet.contains(Integer.valueOf(p16))) {
            QLog.e("TRTCOpenMusicHelper", 1, "setOpenMusicVolume: id not exist, " + p16);
            return -10001;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "setOpenMusicVolume: " + p16 + ", " + volume);
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.setMusicPlayoutVolume(p16, volume);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int G(int id5, int targetTime) {
        TXAudioEffectManager audioEffectManager;
        int p16 = p(id5);
        if (!this.playingMusicIdSet.contains(Integer.valueOf(p16))) {
            QLog.e("TRTCOpenMusicHelper", 1, "setOpenMusicProgress: id not exist, " + p16);
            return -10001;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "setOpenMusicProgress: " + p16 + ", " + targetTime);
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.seekMusicToPosInMS(p16, targetTime);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int J(int id5) {
        int p16 = p(id5);
        if (!this.playingMusicIdSet.contains(Integer.valueOf(p16))) {
            QLog.e("TRTCOpenMusicHelper", 1, "stopOpenMusic: id not exist, " + p16);
            return -10001;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "stopOpenMusic: " + p16);
        H(p16);
        this.playingMusicIdSet.remove(Integer.valueOf(p16));
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int g(int id5) {
        TXAudioEffectManager audioEffectManager;
        int p16 = p(id5);
        if (!this.playingMusicIdSet.contains(Integer.valueOf(p16))) {
            QLog.e("TRTCOpenMusicHelper", 1, "resumeOpenMusic: id not exist, " + p16);
            return -10001;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "resumeOpenMusic: " + p16);
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.resumePlayMusic(p16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public void h() {
        QLog.d("TRTCOpenMusicHelper", 1, "stopPlayAllOpenMusic: " + this.playingMusicIdSet.size());
        Iterator<Integer> it = this.playingMusicIdSet.iterator();
        while (it.hasNext()) {
            Integer id5 = it.next();
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            H(id5.intValue());
        }
        this.playingMusicIdSet.clear();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int t(int id5) {
        TXAudioEffectManager audioEffectManager;
        int p16 = p(id5);
        if (!this.playingMusicIdSet.contains(Integer.valueOf(p16))) {
            QLog.e("TRTCOpenMusicHelper", 1, "pauseOpenMusic: id not exist, " + p16);
            return -10001;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "pauseOpenMusic: " + p16);
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.pausePlayMusic(p16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public long u(int id5) {
        Long l3;
        TXAudioEffectManager audioEffectManager;
        int p16 = p(id5);
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            l3 = Long.valueOf(audioEffectManager.getMusicCurrentPosInMS(p16));
        } else {
            l3 = null;
        }
        QLog.d("TRTCOpenMusicHelper", 1, "getOpenMusicCurrentProgress: " + p16 + ", " + l3);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int v(int id5, @Nullable String path, int loopCount, long startTime, @Nullable u observer) {
        if (this.musicTRTCCloud == null) {
            QLog.e("TRTCOpenMusicHelper", 1, "startPlayOpenMusic: trtcCloud is null");
            return -1;
        }
        if (id5 >= 0 && !TextUtils.isEmpty(path)) {
            int p16 = p(id5);
            this.playingMusicIdSet.add(Integer.valueOf(p16));
            if (observer != null) {
                TRTCCloud tRTCCloud = this.musicTRTCCloud;
                Intrinsics.checkNotNull(tRTCCloud);
                tRTCCloud.getAudioEffectManager().setMusicObserver(p16, new b(observer, this));
            }
            TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(p16, path);
            audioMusicParam.startTimeMS = startTime;
            audioMusicParam.loopCount = loopCount;
            QLog.d("TRTCOpenMusicHelper", 1, "startOpenMusic: " + audioMusicParam);
            TRTCCloud tRTCCloud2 = this.musicTRTCCloud;
            Intrinsics.checkNotNull(tRTCCloud2);
            tRTCCloud2.getAudioEffectManager().startPlayMusic(audioMusicParam);
            return 0;
        }
        QLog.e("TRTCOpenMusicHelper", 1, "startPlayOpenMusic: param is invalid, " + id5 + ", " + path);
        return -10002;
    }

    public void x(@Nullable TRTCCloud trtcCloud) {
        boolean z16;
        Logger.a d16 = Logger.f235387a.d();
        if (trtcCloud == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("TRTCOpenMusicHelper", 1, "[setOpenTRTCCloud] trtcCloud is null " + z16);
        this.musicTRTCCloud = trtcCloud;
    }
}
