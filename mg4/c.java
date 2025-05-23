package mg4;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg4.d;
import org.jetbrains.annotations.NotNull;
import qn4.BlockOptConfig;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    private static volatile c f416744g;

    /* renamed from: b, reason: collision with root package name */
    private IAudienceRoom f416746b;

    /* renamed from: d, reason: collision with root package name */
    private long f416748d;

    /* renamed from: a, reason: collision with root package name */
    private Handler f416745a = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private final cl4.a f416747c = new cl4.a();

    /* renamed from: e, reason: collision with root package name */
    private Map<Long, d> f416749e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, IAudienceRoom> f416750f = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements IResultListener<EndPageRealTimeInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f416751a;

        a(IResultListener iResultListener) {
            this.f416751a = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            this.f416751a.onSuccess(endPageRealTimeInfo);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            this.f416751a.onError(i3, str);
        }
    }

    private boolean d(long j3, IResultListener<EndPageRealTimeInfo> iResultListener) {
        if (j3 > 0 && this.f416746b != null && j3 != i()) {
            l.e("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "audienceExitRoom but not equal!!! ");
            if (iResultListener != null) {
                iResultListener.onError(-1000, "\u6570\u636e\u5f02\u5e38");
                return true;
            }
            return true;
        }
        return false;
    }

    public static c g() {
        if (f416744g == null) {
            synchronized (c.class) {
                if (f416744g == null) {
                    f416744g = new c();
                }
            }
        }
        return f416744g;
    }

    private long i() {
        IAudienceRoom iAudienceRoom = this.f416746b;
        if (iAudienceRoom != null && iAudienceRoom.getRoomInfo() != null) {
            return this.f416746b.getRoomInfo().getRoomId();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(long j3, IAudienceRoom iAudienceRoom) {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "delay destroy roomId " + j3);
        iAudienceRoom.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Runnable runnable, long j3, IResultListener iResultListener, IAudienceRoom iAudienceRoom, int i3, String str) {
        this.f416745a.removeCallbacks(runnable);
        l.h("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "audienceExitRoom_" + j3 + ", onComplete " + i3 + "" + str);
        if (iResultListener != null) {
            pg4.b.n(iAudienceRoom, new a(iResultListener));
        }
        if (!iAudienceRoom.isDestroyed()) {
            iAudienceRoom.destroy();
        }
    }

    private void o() {
        this.f416747c.d();
    }

    private void q() {
        pg4.c.f();
    }

    public void c(long j3, final IResultListener<EndPageRealTimeInfo> iResultListener) {
        final long i3 = i();
        l.h("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "audienceExitRoom_ - toExitRoomId = " + j3 + ", curRoomInfo = " + i3);
        com.tencent.mobileqq.qqlive.sail.c.f272176a.c();
        if (d(j3, iResultListener)) {
            return;
        }
        q();
        o();
        if (this.f416746b == null) {
            if (iResultListener != null) {
                iResultListener.onError(-1001, "\u6570\u636e\u5f02\u5e38");
                return;
            }
            return;
        }
        BlockOptConfig blockOptConfig = new BlockOptConfig();
        final IAudienceRoom iAudienceRoom = this.f416746b;
        final Runnable runnable = new Runnable() { // from class: mg4.a
            @Override // java.lang.Runnable
            public final void run() {
                c.l(i3, iAudienceRoom);
            }
        };
        if (blockOptConfig.getForceDestroyRoom()) {
            this.f416745a.postDelayed(runnable, 2000L);
        }
        this.f416746b.exitRoom(new ExitRoomCallback() { // from class: mg4.b
            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
            public final void onComplete(int i16, String str) {
                c.this.m(runnable, i3, iResultListener, iAudienceRoom, i16, str);
            }
        });
        this.f416750f.remove(Long.valueOf(i3));
        this.f416746b = null;
        pg4.d.b().a();
        ((jg4.a) mm4.b.b(jg4.a.class)).l(i3);
        l.i("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "audienceExitRoom, remotePreloadMap size:" + this.f416750f.size());
    }

    public void e() {
        l.i("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", "clearPreloadMap");
    }

    public IAudienceRoom f(long j3) {
        return this.f416750f.get(Long.valueOf(j3));
    }

    public IAudienceRoom h() {
        return this.f416746b;
    }

    @Nullable
    public d j(long j3) {
        return this.f416749e.get(Long.valueOf(j3));
    }

    @NotNull
    public al4.a k() {
        return this.f416747c;
    }

    public void n(d dVar) {
        this.f416749e.put(Long.valueOf(dVar.f409905a), dVar);
    }

    public void p(long j3, boolean z16) {
        IAudienceRoom remove;
        l.h("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", 1, "remotePreloadMap:" + j3 + " isDestroyPlayer:" + z16 + " mPreloadRoomMap.size:" + this.f416750f.size());
        if (z16 && (remove = this.f416750f.remove(Long.valueOf(j3))) != null) {
            remove.destroy();
        }
        if (j3 == this.f416748d) {
            this.f416748d = 0L;
        }
        this.f416749e.remove(Long.valueOf(j3));
    }
}
