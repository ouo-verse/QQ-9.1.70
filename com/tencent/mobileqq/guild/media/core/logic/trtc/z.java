package com.tencent.mobileqq.guild.media.core.logic.trtc;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/z;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/f;", "Lcom/tencent/trtc/TRTCCloud;", "trtcCloud", "", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/i;", "observer", DomainData.DOMAIN_NAME, "", "playId", "", "publish", "", "path", "", "startTimeMs", HippyTKDListViewAdapter.X, "p", "H", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setMusicPlayoutVolume", "a", "Lcom/tencent/trtc/TRTCCloud;", "musicTRTCCloud", "b", "Lcom/tencent/mobileqq/guild/media/core/logic/i;", "<init>", "()V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class z implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TRTCCloud musicTRTCCloud;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.core.logic.i observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/trtc/z$b", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "", "id", "errCode", "", "onStart", "", "curPtsMS", "durationMS", "onPlayProgress", "onComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements TXAudioEffectManager.TXMusicPlayObserver {
        b() {
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onComplete(int id5, int errCode) {
            Logger.f235387a.d().i("TRTCBackgroundMusicHelper", 1, "[onComplete] id:" + id5 + ",errCode:" + errCode);
            com.tencent.mobileqq.guild.media.core.logic.i iVar = z.this.observer;
            if (iVar != null) {
                iVar.onComplete(id5, errCode);
            }
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onPlayProgress(int id5, long curPtsMS, long durationMS) {
            com.tencent.mobileqq.guild.media.core.logic.i iVar = z.this.observer;
            if (iVar != null) {
                iVar.onPlayProgress(id5, curPtsMS, durationMS);
            }
        }

        @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
        public void onStart(int id5, int errCode) {
            Logger.f235387a.d().i("TRTCBackgroundMusicHelper", 1, "[onStart] startPlayBackgroundMusic onStart,id:" + id5 + ",errCode:" + errCode);
            com.tencent.mobileqq.guild.media.core.logic.i iVar = z.this.observer;
            if (iVar != null) {
                iVar.onStart(id5, errCode);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void H(int playId) {
        TXAudioEffectManager audioEffectManager;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.pausePlayMusic(playId);
        }
        com.tencent.mobileqq.guild.media.core.logic.i iVar = this.observer;
        if (iVar != null) {
            iVar.onPause(playId);
        }
    }

    public void h(@Nullable TRTCCloud trtcCloud) {
        boolean z16;
        if (trtcCloud == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("TRTCBackgroundMusicHelper", 1, "setTRTCCloud is null " + z16);
        this.musicTRTCCloud = trtcCloud;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void n(@Nullable com.tencent.mobileqq.guild.media.core.logic.i observer) {
        this.observer = observer;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void p(int playId) {
        TXAudioEffectManager audioEffectManager;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.stopPlayMusic(playId);
        }
        com.tencent.mobileqq.guild.media.core.logic.i iVar = this.observer;
        if (iVar != null) {
            iVar.b(playId);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void setMusicPlayoutVolume(int playId, int volume) {
        TXAudioEffectManager audioEffectManager;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager.setMusicPlayoutVolume(playId, volume);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void x(int playId, boolean publish, @Nullable String path, long startTimeMs) {
        TXAudioEffectManager audioEffectManager;
        TXAudioEffectManager audioEffectManager2;
        TRTCCloud tRTCCloud = this.musicTRTCCloud;
        if (tRTCCloud != null && (audioEffectManager2 = tRTCCloud.getAudioEffectManager()) != null) {
            audioEffectManager2.setMusicObserver(playId, new b());
        }
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(playId, path);
        audioMusicParam.startTimeMS = startTimeMs;
        audioMusicParam.publish = publish;
        audioMusicParam.endTimeMS = 0L;
        Logger.f235387a.d().i("TRTCBackgroundMusicHelper", 1, "[startPlayBackgroundMusic] start play local music,path:" + path);
        TRTCCloud tRTCCloud2 = this.musicTRTCCloud;
        if (tRTCCloud2 != null && (audioEffectManager = tRTCCloud2.getAudioEffectManager()) != null) {
            audioEffectManager.startPlayMusic(audioMusicParam);
        }
    }
}
