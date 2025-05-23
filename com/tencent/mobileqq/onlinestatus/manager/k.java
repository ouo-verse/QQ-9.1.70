package com.tencent.mobileqq.onlinestatus.manager;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.api.IOnlineMusicStatusApi;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.an;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.e;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.api.IQQPlayerServiceApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.im.statsvc.song.StatSvcStatSong$SongInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k implements e, Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private Handler f255964d;

    /* renamed from: e, reason: collision with root package name */
    public int f255965e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<String, com.tencent.mobileqq.lyric.data.b> f255966f = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public CopyOnWriteArrayList f255967h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, WeakReference<e.a>> f255968i = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private b f255969m = null;
    private com.tencent.mobileqq.music.g C = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b extends av {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<k> f255971d;

        public b(k kVar) {
            this.f255971d = new WeakReference<>(kVar);
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void d(boolean z16, Bundle bundle) {
            k kVar;
            if (z16 && bundle != null) {
                String string = bundle.getString(IOnlineStatusService.SONG_ID);
                if (!TextUtils.isEmpty(string) && (kVar = this.f255971d.get()) != null) {
                    kVar.y(string);
                }
            }
        }
    }

    public k() {
        D(null);
        G();
    }

    private static String A() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUin();
    }

    public static boolean C() {
        return MobileQQ.sMobileQQ.getSharedPreferences("online_music_status", 0).getBoolean("has_set_online_music", false);
    }

    @Deprecated
    public static void F(Friends friends, byte[] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    StatSvcStatSong$SongInfo statSvcStatSong$SongInfo = new StatSvcStatSong$SongInfo();
                    statSvcStatSong$SongInfo.mergeFrom(bArr);
                    friends.songId = statSvcStatSong$SongInfo.bytes_song_id.get().toStringUtf8();
                    AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if (((k) ((IOnlineStatusManagerService) waitAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(e.class)).f255967h.contains(friends.songId)) {
                        H(friends);
                        QLog.d("OnlineMusicStatusManager", 1, "update onlineSongState from ", str, " safeHit true");
                        return;
                    }
                    friends.songName = statSvcStatSong$SongInfo.bytes_song_name.get().toStringUtf8();
                    friends.singerName = statSvcStatSong$SongInfo.bytes_singer_name.get().toStringUtf8();
                    friends.songEndTime = statSvcStatSong$SongInfo.uint64_end_time.get();
                    friends.songSourceType = statSvcStatSong$SongInfo.uint32_source_type.get();
                    friends.songPauseRemainTime = statSvcStatSong$SongInfo.uint32_pause_remaining_time.get();
                    friends.songDuration = statSvcStatSong$SongInfo.uint32_song_play_time.get();
                    if (TextUtils.equals(waitAppRuntime.getCurrentUin(), friends.uin)) {
                        QLog.d("OnlineMusicStatusManager", 1, "update onlineSongState from ", str, ", uin:", StringUtil.getSimpleUinForPrint(friends.uin), " songId:", friends.songId, " songName:", friends.songName, " songEndTime:", Long.valueOf(friends.songEndTime), " source:", Integer.valueOf(friends.songSourceType), " pauseRemain:", Integer.valueOf(friends.songPauseRemainTime), " duration:", Integer.valueOf(friends.songDuration), " remainTime:", Long.valueOf(friends.songEndTime - System.currentTimeMillis()));
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineMusicStatusManager", 2, "update onlineSongState from ", str, ", uin:", StringUtil.getSimpleUinForPrint(friends.uin), " songId:", friends.songId, " songName:", friends.songName, " songEndTime:", Long.valueOf(friends.songEndTime), " source:", Integer.valueOf(friends.songSourceType), " pauseRemain:", Integer.valueOf(friends.songPauseRemainTime), " duration:", Integer.valueOf(friends.songDuration), " remainTime:", Long.valueOf(friends.songEndTime - System.currentTimeMillis()));
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.d("OnlineMusicStatusManager", 1, "parseFriendMusicInfo fail", e16);
                return;
            }
        }
        if (TextUtils.equals(A(), friends.uin)) {
            QLog.d("OnlineMusicStatusManager", 1, "parseFriendMusicInfo empty vecMusicInfo");
        }
        H(friends);
    }

    private void G() {
        this.f255969m = new b(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(this.f255969m);
        }
    }

    @Deprecated
    public static void H(Friends friends) {
        friends.songId = "";
        friends.songName = "";
        friends.singerName = "";
        friends.songEndTime = 0L;
        friends.songSourceType = 0;
        friends.songPauseRemainTime = 0;
        friends.songDuration = 0;
    }

    private static void J(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        ((OnlineStatusHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(OnlineStatusHandler.class.getName())).I2(cVar);
    }

    public static void K() {
        MobileQQ.sMobileQQ.getSharedPreferences("online_music_status", 0).edit().putBoolean("has_set_online_music", true).apply();
    }

    public static String z(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, TextView textView, int i3) {
        String format;
        Resources resources = appRuntime.getApp().getResources();
        if (!TextUtils.isEmpty(cVar.Z()) && System.currentTimeMillis() < cVar.N()) {
            if (!TextUtils.isEmpty(cVar.G())) {
                format = String.format(resources.getString(R.string.f197194jc), cVar.Z(), cVar.G());
            } else {
                format = String.format(resources.getString(R.string.f197204jd), cVar.Z());
            }
            if (textView instanceof OnlineStatusLyricView) {
                J(cVar);
                ((OnlineStatusLyricView) textView).setFriendSession(cVar, format);
            } else if (i3 != 1 && textView != null) {
                format = bs.n(textView.getPaint(), format, ViewUtils.dip2px(200.0f));
            }
            if (i3 == 1 && textView == null) {
                J(cVar);
            }
            ReportController.o(null, "dc00898", "", "", "0X800AC92", "0X800AC92", cVar.b0(), 0, "", "0", "0", "");
            return format;
        }
        return resources.getString(R.string.f197214je);
    }

    public void B(long j3, long j16) {
        QLog.d("OnlineMusicStatusManager", 1, "handleOnlineStatusChanged, ", Long.valueOf(j3), "->", Long.valueOf(j16));
        if (j3 == 1028 && j16 != 1028) {
            this.f255964d.sendEmptyMessage(1);
            return;
        }
        if (j3 != 1028 && j16 == 1028) {
            if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isListeningTogether()) {
                QLog.d("OnlineMusicStatusManager", 1, "handleOnlineStatusChanged isListeningTogether");
                this.f255964d.removeMessages(1);
                this.f255964d.sendEmptyMessageDelayed(2, 3000L);
            } else if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isQQPlayServicePlaying()) {
                QLog.d("OnlineMusicStatusManager", 1, "handleOnlineStatusChanged isQQPlayServicePlaying");
                this.f255964d.removeMessages(1);
                this.f255964d.sendEmptyMessageDelayed(3, 3000L);
            }
        }
    }

    public void D(Handler handler) {
        if (handler != null) {
            this.f255964d = handler;
        } else {
            this.f255964d = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        }
    }

    public void E(Activity activity, String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            String format = String.format("https://i.y.qq.com/v8/playsong.html?songmid=%s&ADTAG=hz_sq_sqzt&channelId=2005001004", str);
            Intent intent = new Intent();
            intent.putExtra("url", format);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            ReportController.o(null, "dc00898", "", "", "0X800ABB2", "0X800ABB2", 0, 0, "", "0", "0", "");
            return;
        }
        QLog.d("OnlineMusicStatusManager", 1, "openH5 fail");
    }

    public void I(Activity activity, String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            String format = String.format("https://i.y.qq.com/v8/playsong.html?_mylisten=1&songmid=%s&ADTAG=hz_sq_sqzt&channelId=2005001004", str);
            Intent intent = new Intent();
            intent.putExtra("url", format);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        QLog.d("OnlineMusicStatusManager", 1, "openH5 fail");
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public com.tencent.mobileqq.music.g getCallback() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public int getSourceType() {
        return this.f255965e;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public void h(int i3) {
        this.f255965e = i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        boolean z17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.d("OnlineMusicStatusManager", 1, "app is null handleMessage what: " + message.what + " arg1: " + message.arg1);
            return false;
        }
        QLog.d("OnlineMusicStatusManager", 1, "handleMessage what: " + message.what + " arg1: " + message.arg1);
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(OnlineStatusHandler.class.getName());
                    IOnlineMusicStatusApi iOnlineMusicStatusApi = (IOnlineMusicStatusApi) QRoute.api(IOnlineMusicStatusApi.class);
                    if (message.arg1 == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    an buildFromSongInfo = iOnlineMusicStatusApi.buildFromSongInfo(z17);
                    onlineStatusHandler.Z2(buildFromSongInfo);
                    if (buildFromSongInfo != null) {
                        this.f255964d.sendEmptyMessageDelayed(1, buildFromSongInfo.f255415f);
                    }
                }
            } else {
                OnlineStatusHandler onlineStatusHandler2 = (OnlineStatusHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(OnlineStatusHandler.class.getName());
                IOnlineMusicStatusApi iOnlineMusicStatusApi2 = (IOnlineMusicStatusApi) QRoute.api(IOnlineMusicStatusApi.class);
                if (message.arg1 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                an buildFromMusicInfo = iOnlineMusicStatusApi2.buildFromMusicInfo(z16);
                onlineStatusHandler2.Z2(buildFromMusicInfo);
                if (buildFromMusicInfo != null) {
                    this.f255964d.sendEmptyMessageDelayed(1, buildFromMusicInfo.f255415f);
                }
            }
        } else {
            ((OnlineStatusHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(OnlineStatusHandler.class.getName())).Z2(null);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public com.tencent.mobileqq.lyric.data.b j(String str) {
        return this.f255966f.get(str);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        this.f255968i.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        b bVar = this.f255969m;
        if (bVar != null && (peekAppRuntime instanceof AppInterface)) {
            ((AppInterface) peekAppRuntime).removeObserver(bVar);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public void p(int i3) {
        QLog.d("OnlineMusicStatusManager", 1, "onPlayTogetherStateChanged state: " + i3);
        if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStatePlaying(i3)) {
            this.f255964d.removeCallbacksAndMessages(null);
            this.f255964d.sendEmptyMessageDelayed(2, 3000L);
            return;
        }
        if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStateCompletion(i3)) {
            this.f255964d.sendEmptyMessageDelayed(1, 3000L);
            return;
        }
        if (!((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStateError(i3) && !((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStateStop(i3)) {
            if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStatePause(i3)) {
                this.f255964d.removeCallbacksAndMessages(null);
                this.f255964d.sendMessage(this.f255964d.obtainMessage(2, 1, 0));
                return;
            }
            return;
        }
        this.f255964d.removeCallbacksAndMessages(null);
        this.f255964d.sendEmptyMessage(1);
        if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStateStop(i3)) {
            this.f255965e = 0;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public void q(e.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f255968i.remove(Integer.valueOf(aVar.hashCode()));
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e
    public void t(e.a aVar) {
        if (aVar == null) {
            return;
        }
        int hashCode = aVar.hashCode();
        if (this.f255968i.containsKey(Integer.valueOf(hashCode))) {
            return;
        }
        this.f255968i.put(Integer.valueOf(hashCode), new WeakReference<>(aVar));
    }

    protected void y(String str) {
        QLog.d("OnlineMusicStatusManager", 1, "dispatchGetLyric songId: " + str);
        Iterator<WeakReference<e.a>> it = this.f255968i.values().iterator();
        while (it.hasNext()) {
            e.a aVar = it.next().get();
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements com.tencent.mobileqq.music.g {
        a() {
        }

        @Override // com.tencent.mobileqq.music.g
        public String getToken() {
            return k.class.getName();
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlayStateChanged(int i3) {
            String qQPlayerServiceToken = ((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).getQQPlayerServiceToken();
            QLog.d("OnlineMusicStatusManager", 1, "onPlayStateChanged, playState:", Integer.valueOf(i3), " token:", qQPlayerServiceToken);
            if (qQPlayerServiceToken != null) {
                if (qQPlayerServiceToken.startsWith("music_gene_") || qQPlayerServiceToken.startsWith("aio_")) {
                    QLog.d("OnlineMusicStatusManager", 1, "onPlayStateChanged is valid token");
                    if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isPlayStatePlaying(i3)) {
                        k.this.f255964d.removeMessages(1);
                        k.this.f255964d.sendEmptyMessageDelayed(3, 3000L);
                        return;
                    }
                    if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isPlayStateCompletion(i3)) {
                        k.this.f255964d.sendEmptyMessageDelayed(1, 3000L);
                        return;
                    }
                    if (!((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isPlayStateStop(i3) && !((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isPlayStateError(i3)) {
                        if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isPlayStatePause(i3)) {
                            k.this.f255964d.removeCallbacksAndMessages(null);
                            k.this.f255964d.sendMessage(k.this.f255964d.obtainMessage(3, 1, 0));
                            return;
                        }
                        return;
                    }
                    k.this.f255964d.removeCallbacksAndMessages(null);
                    k.this.f255964d.sendEmptyMessage(1);
                    if (((IQQPlayerServiceApi) QRoute.api(IQQPlayerServiceApi.class)).isStateStop(i3)) {
                        k.this.f255965e = 0;
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlaySongChanged(SongInfo songInfo) {
        }
    }
}
