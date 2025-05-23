package hu0;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomBase;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.IResultListener;
import fu0.EnterRoomConfig;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    private static volatile f f406297g;

    /* renamed from: b, reason: collision with root package name */
    private long f406299b;

    /* renamed from: c, reason: collision with root package name */
    private ILiveAudienceTPPlayerRoom f406300c;

    /* renamed from: a, reason: collision with root package name */
    private Handler f406298a = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private lu0.b f406301d = new lu0.b();

    /* renamed from: e, reason: collision with root package name */
    private ex0.a f406302e = new ex0.a();

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, ILiveAudienceTPPlayerRoom> f406303f = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements b32.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILiveAudienceTPPlayerRoom f406304a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f406305b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f406306c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IResultListener f406307d;

        a(ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom, long j3, long j16, IResultListener iResultListener) {
            this.f406304a = iLiveAudienceTPPlayerRoom;
            this.f406305b = j3;
            this.f406306c = j16;
            this.f406307d = iResultListener;
        }

        @Override // b32.c
        public void onFailed(int i3, String str) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f406306c;
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "enterRoom fail roomId - " + this.f406305b + " code " + i3 + " msg " + str + ",costTime=" + elapsedRealtime);
            mu0.c.b().f(Boolean.FALSE);
            f.this.f406301d.i(this.f406305b, i3, str, elapsedRealtime);
            IResultListener iResultListener = this.f406307d;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }

        @Override // b32.c
        public void onSuccess(LiveInfo liveInfo) {
            ku0.a.a(liveInfo, this.f406304a.getAudienceRoomConfig().playerConfig.format);
            if (!f.this.j(liveInfo, this.f406305b)) {
                f.this.z();
                f.this.G(this.f406304a, this.f406305b, liveInfo, SystemClock.elapsedRealtime() - this.f406306c);
                IResultListener iResultListener = this.f406307d;
                if (iResultListener != null) {
                    iResultListener.onSuccess(liveInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements IResultListener<EndPageRealTimeInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f406309a;

        b(IResultListener iResultListener) {
            this.f406309a = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            this.f406309a.onSuccess(endPageRealTimeInfo);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            this.f406309a.onError(i3, str);
        }
    }

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(long j3, IAudienceRoom iAudienceRoom) {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a("ICGameTgLiveAudienceRoomManager", "delay destroy roomId " + j3);
        iAudienceRoom.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Runnable runnable, IResultListener iResultListener, long j3, IAudienceRoom iAudienceRoom, int i3, String str) {
        this.f406298a.removeCallbacks(runnable);
        y(iResultListener, j3, iAudienceRoom, i3, str);
    }

    private void C(long j3) {
        ((fu0.b) qx0.a.b(fu0.b.class)).onEnterRoom(j3);
    }

    private void D() {
        this.f406302e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom, long j3, LiveInfo liveInfo, long j16) {
        mu0.c.b().f(Boolean.TRUE);
        if (liveInfo != null && liveInfo.roomInfo != null) {
            mu0.c.b().i(liveInfo.roomInfo.roomLogo);
        }
        this.f406301d.h(iLiveAudienceTPPlayerRoom, j3, liveInfo, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(LiveInfo liveInfo, long j3) {
        LiveVideoStatus liveVideoStatus;
        LiveWatchMediaInfo liveWatchMediaInfo;
        if (liveInfo != null && (liveWatchMediaInfo = liveInfo.watchMediaInfo) != null) {
            liveVideoStatus = liveWatchMediaInfo.mVideoStatus;
        } else {
            liveVideoStatus = null;
        }
        if (liveInfo != null && liveInfo.roomInfo != null && liveInfo.anchorInfo != null) {
            QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceEnterRoom success, roomId - " + j3 + " - roomName=" + liveInfo.roomInfo.roomName + " - anchorUid=" + LogUtil.wrapLogUin(String.valueOf(liveInfo.anchorInfo.uid)) + " - bizId=" + liveInfo.anchorInfo.businessUid + " - name=" + liveInfo.anchorInfo.nickName + " - mediaVideoStatus=" + liveVideoStatus);
        } else {
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "enterRoom success, roomId - " + j3 + ", liveVideoStatus - " + liveVideoStatus + " - " + liveInfo);
        }
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406300c;
        if (iLiveAudienceTPPlayerRoom == null) {
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "enterRoom mLiveAudienceRoom == null, ignore callback.");
            return true;
        }
        BaseRoomInfo roomInfo = iLiveAudienceTPPlayerRoom.getRoomInfo();
        if (roomInfo != null && roomInfo.getRoomId() != j3) {
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "enterRoom mLiveAudienceRoom not equal,  cur = " + roomInfo.getRoomId() + ", original = " + j3);
            return true;
        }
        return false;
    }

    private boolean k(long j3, IResultListener<EndPageRealTimeInfo> iResultListener) {
        if (j3 > 0 && this.f406300c != null && j3 != w()) {
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "audienceExitRoom but not equal!!! ");
            if (iResultListener != null) {
                iResultListener.onError(-1000, "\u6570\u636e\u5f02\u5e38");
            }
            return true;
        }
        return false;
    }

    private boolean l(IResultListener<LiveInfo> iResultListener, long j3) {
        if (this.f406300c == null) {
            return false;
        }
        QLog.e("ICGameTgLiveAudienceRoomManager", 1, "audienceEnterRoom, AudienceRoom had created, please check it, old = " + w());
        if (w() == j3) {
            if (iResultListener != null) {
                iResultListener.onSuccess(this.f406300c.getRoomLiveInfo());
            }
            return true;
        }
        h(0L, null);
        return false;
    }

    private boolean m(IResultListener<LiveInfo> iResultListener) {
        if (!mu0.a.k().o()) {
            QLog.d("ICGameTgLiveAudienceRoomManager", 1, "audienceEnterRoom, live sdk not init suc.");
            if (iResultListener != null) {
                iResultListener.onError(-1001, "\u4e1a\u52a1\u5c1a\u672a\u521d\u59cb\u5316");
            }
            return true;
        }
        return false;
    }

    @NonNull
    private ILiveAudienceTPPlayerRoom n(long j3, IcgRoomPlayerConfig icgRoomPlayerConfig, EnterRoomConfig enterRoomConfig) {
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = (ILiveAudienceTPPlayerRoom) v().createAudienceRoom(q(icgRoomPlayerConfig, enterRoomConfig));
        iLiveAudienceTPPlayerRoom.preloadService(j3, ILiveRoomBase.ServiceType.DATA);
        this.f406301d.c(iLiveAudienceTPPlayerRoom, icgRoomPlayerConfig, j3);
        return iLiveAudienceTPPlayerRoom;
    }

    private EnterRoomInfo o(EnterRoomConfig enterRoomConfig) {
        return this.f406301d.g(enterRoomConfig);
    }

    private AudienceRoomConfig q(IcgRoomPlayerConfig icgRoomPlayerConfig, EnterRoomConfig enterRoomConfig) {
        return this.f406301d.k(icgRoomPlayerConfig, enterRoomConfig);
    }

    public static f s() {
        if (f406297g == null) {
            synchronized (f.class) {
                if (f406297g == null) {
                    f406297g = new f();
                }
            }
        }
        return f406297g;
    }

    private ILiveAudienceTPPlayerRoom u(EnterRoomConfig enterRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig, long j3) {
        ILiveAudienceTPPlayerRoom remove = this.f406303f.remove(Long.valueOf(j3));
        if (remove != null) {
            return remove;
        }
        return n(enterRoomConfig.getRoomId(), icgRoomPlayerConfig, enterRoomConfig);
    }

    private IQQLiveSDK v() {
        return mu0.a.k().l();
    }

    private long w() {
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406300c;
        if (iLiveAudienceTPPlayerRoom != null && iLiveAudienceTPPlayerRoom.getRoomInfo() != null) {
            return this.f406300c.getRoomInfo().getRoomId();
        }
        return -1L;
    }

    private static void y(IResultListener<EndPageRealTimeInfo> iResultListener, long j3, IAudienceRoom iAudienceRoom, int i3, String str) {
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceExitRoom_" + j3 + ", onComplete " + i3 + "" + str);
        if (iResultListener == null) {
            return;
        }
        mu0.a.m(iAudienceRoom, new b(iResultListener));
        if (!iAudienceRoom.isDestroyed()) {
            iAudienceRoom.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406300c;
        if (iLiveAudienceTPPlayerRoom == null) {
            QLog.e("ICGameTgLiveAudienceRoomManager", 1, "initTimiPushService failed, liveRoom is null!");
        } else {
            this.f406302e.e(iLiveAudienceTPPlayerRoom);
        }
    }

    public void E(long j3, boolean z16) {
        ILiveAudienceTPPlayerRoom remove;
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "remotePreloadMap:" + j3 + " destroyPlayer:" + z16 + " mPreloadRoomMap.size:" + this.f406303f.size());
        if (z16 && (remove = this.f406303f.remove(Long.valueOf(j3))) != null) {
            remove.destroy();
            this.f406301d.b(remove, j3);
        }
        if (j3 == this.f406299b) {
            this.f406299b = 0L;
        }
    }

    public void F(long j3) {
        this.f406299b = j3;
    }

    public void g(EnterRoomConfig enterRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig, IResultListener<LiveInfo> iResultListener) {
        long roomId = enterRoomConfig.getRoomId();
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceEnterRoom - " + roomId);
        if (m(iResultListener) || l(iResultListener, roomId)) {
            return;
        }
        ILiveAudienceTPPlayerRoom u16 = u(enterRoomConfig, icgRoomPlayerConfig, roomId);
        this.f406300c = u16;
        this.f406301d.f(u16, icgRoomPlayerConfig);
        C(roomId);
        mu0.b.e(this.f406300c);
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceEnterRoom start, roomId - " + roomId);
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406300c;
        iLiveAudienceTPPlayerRoom.enterRoom(o(enterRoomConfig), new EnterRoomReqConfig(true), enterRoomConfig.getAutoPlay(), new a(iLiveAudienceTPPlayerRoom, roomId, SystemClock.elapsedRealtime(), iResultListener));
    }

    public void h(long j3, final IResultListener<EndPageRealTimeInfo> iResultListener) {
        final long w3 = w();
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceExitRoom_ - toExitRoomId = " + j3 + ", curRoomInfo = " + w3);
        if (k(j3, iResultListener)) {
            return;
        }
        mu0.b.f();
        D();
        final ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406300c;
        if (iLiveAudienceTPPlayerRoom == null && iResultListener != null) {
            iResultListener.onError(-1001, "\u6570\u636e\u5f02\u5e38");
            return;
        }
        final Runnable runnable = new Runnable() { // from class: hu0.d
            @Override // java.lang.Runnable
            public final void run() {
                f.A(w3, iLiveAudienceTPPlayerRoom);
            }
        };
        this.f406298a.postDelayed(runnable, 2000L);
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom2 = this.f406300c;
        if (iLiveAudienceTPPlayerRoom2 != null) {
            iLiveAudienceTPPlayerRoom2.exitRoom(new ExitRoomCallback() { // from class: hu0.e
                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
                public final void onComplete(int i3, String str) {
                    f.this.B(runnable, iResultListener, w3, iLiveAudienceTPPlayerRoom, i3, str);
                }
            });
        }
        this.f406303f.remove(Long.valueOf(w3));
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom3 = this.f406300c;
        this.f406300c = null;
        mu0.c.b().a();
        ((fu0.b) qx0.a.b(fu0.b.class)).l(w3);
        this.f406301d.j(iLiveAudienceTPPlayerRoom3, w3);
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audienceExitRoom, remotePreloadMap size:" + this.f406303f.size());
    }

    public IAudienceRoom i(IcgRoomPlayerConfig icgRoomPlayerConfig) {
        QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audiencePreloadRoom, roomId - " + icgRoomPlayerConfig.roomId + ", previewStreamUrl - " + icgRoomPlayerConfig.superPlayerParams.url);
        if (!mu0.a.k().o()) {
            QLog.i("ICGameTgLiveAudienceRoomManager", 1, "audiencePreloadRoom, live sdk not init suc.");
            return null;
        }
        this.f406301d.o(icgRoomPlayerConfig);
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f406303f.get(Long.valueOf(icgRoomPlayerConfig.roomId));
        if (iLiveAudienceTPPlayerRoom != null) {
            iLiveAudienceTPPlayerRoom.reset();
        } else {
            iLiveAudienceTPPlayerRoom = n(icgRoomPlayerConfig.roomId, icgRoomPlayerConfig, null);
            this.f406303f.put(Long.valueOf(icgRoomPlayerConfig.roomId), iLiveAudienceTPPlayerRoom);
        }
        this.f406301d.e(iLiveAudienceTPPlayerRoom, icgRoomPlayerConfig, icgRoomPlayerConfig.roomId);
        return iLiveAudienceTPPlayerRoom;
    }

    public IAudienceRoom p(long j3) {
        return this.f406303f.get(Long.valueOf(j3));
    }

    public IAudienceRoom r() {
        return this.f406300c;
    }

    public long t() {
        return this.f406299b;
    }

    @NonNull
    public cx0.a x() {
        return this.f406302e;
    }
}
