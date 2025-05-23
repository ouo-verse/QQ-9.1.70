package com.tencent.mobileqq.vas.social.config;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.MusicChangeListener;
import com.tencent.state.square.api.SongInfo;
import friendlist.GetOnlineInfoResp;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.statsvc.song.StatSvcStatSong$SongInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J,\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/l;", "Lcom/tencent/mobileqq/app/ar;", "Lcom/tencent/state/square/api/ISquareMusicService;", "Lcom/tencent/mobileqq/music/g;", "", "songMid", "", "a", "Lcom/tencent/state/square/api/MusicChangeListener;", "listener", "addMusicChangeListener", "Lcom/tencent/state/square/api/SongInfo;", "getCurrentPlayingSong", "getLastPlayMusicMid", "init", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "removeMusicChangeListener", "getToken", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "onPlayStateChanged", "Lcom/tencent/mobileqq/music/SongInfo;", "newSong", "onPlaySongChanged", "", "isSuccess", "", "type", "uinOrMobileStr", "Lfriendlist/GetOnlineInfoResp;", "resp", "onGetOnlineInfoByUinOrMobile", "d", "Ljava/lang/String;", "lastPlayMusicMid", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "musicListener", "<init>", "()V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l extends ar implements ISquareMusicService, com.tencent.mobileqq.music.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String lastPlayMusicMid = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<MusicChangeListener> musicListener = new CopyOnWriteArrayList<>();

    private final void a(String songMid) {
        Iterator<T> it = this.musicListener.iterator();
        while (it.hasNext()) {
            ((MusicChangeListener) it.next()).onMusicPlayStateChange(songMid);
        }
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void addMusicChangeListener(MusicChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.musicListener.add(listener);
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public SongInfo getCurrentPlayingSong() {
        if (((IQQPlayer) QRoute.api(IQQPlayer.class)).isPlaying()) {
            return m.a(((IQQPlayer) QRoute.api(IQQPlayer.class)).getCurrentSong());
        }
        return null;
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public String getLastPlayMusicMid() {
        return this.lastPlayMusicMid;
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void init() {
        QQPlayerService.R(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.addObserver(this);
        }
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void onDestroy() {
        QQPlayerService.S0(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.removeObserver(this);
        }
        this.musicListener.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.ar
    public void onGetOnlineInfoByUinOrMobile(boolean isSuccess, long type, String uinOrMobileStr, GetOnlineInfoResp resp) {
        byte[] bArr;
        QLog.d("VasSquareMusicService", 4, "onGetOnlineInfoByUinOrMobile uinOrMobileStr:" + uinOrMobileStr + " resp:" + resp);
        if (uinOrMobileStr == null) {
            return;
        }
        SongInfo songInfo = null;
        if (resp != null) {
            try {
                bArr = resp.vecMusicInfo;
            } catch (Exception e16) {
                QLog.d("VasSquareMusicService", 1, "parseFriendMusicInfo fail", e16);
            }
        } else {
            bArr = null;
        }
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                StatSvcStatSong$SongInfo statSvcStatSong$SongInfo = new StatSvcStatSong$SongInfo();
                statSvcStatSong$SongInfo.mergeFrom(bArr);
                songInfo = new SongInfo(statSvcStatSong$SongInfo.bytes_song_id.get().toStringUtf8(), statSvcStatSong$SongInfo.bytes_song_name.get().toStringUtf8(), statSvcStatSong$SongInfo.bytes_singer_name.get().toStringUtf8());
            }
        }
        Iterator<T> it = this.musicListener.iterator();
        while (it.hasNext()) {
            ((MusicChangeListener) it.next()).onMusicInfoChange(uinOrMobileStr, songInfo);
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlayStateChanged(int playState) {
        QLog.d("VasSquareMusicService", 4, "onPlayStateChanged playState:" + playState);
        a(this.lastPlayMusicMid);
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void removeMusicChangeListener(MusicChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.musicListener.remove(listener);
    }

    @Override // com.tencent.mobileqq.music.g
    public String getToken() {
        String Y = QQPlayerService.Y(9, "VasSquareMusicService");
        Intrinsics.checkNotNullExpressionValue(Y, "generateToken(com.tencen\u2026R_TYPE_ZPLAN_SQUARE, TAG)");
        return Y;
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlaySongChanged(com.tencent.mobileqq.music.SongInfo newSong) {
        QLog.d("VasSquareMusicService", 4, "onPlaySongChanged newSong:" + (newSong != null ? newSong.f251871i : null));
        a(this.lastPlayMusicMid);
        String str = newSong != null ? newSong.f251868e : null;
        if (str == null) {
            str = "";
        }
        this.lastPlayMusicMid = str;
    }
}
