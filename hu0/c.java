package hu0;

import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: o, reason: collision with root package name */
    private static c f406275o;

    /* renamed from: a, reason: collision with root package name */
    private int f406276a = 60000;

    /* renamed from: b, reason: collision with root package name */
    private long f406277b = 2000;

    /* renamed from: c, reason: collision with root package name */
    private int f406278c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private int f406279d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private int f406280e = 15000;

    /* renamed from: f, reason: collision with root package name */
    private int f406281f = 6000;

    /* renamed from: g, reason: collision with root package name */
    private int f406282g = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f406283h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    private int f406284i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f406285j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f406286k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f406287l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f406288m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f406289n = false;

    c() {
    }

    public static c b() {
        if (f406275o == null) {
            synchronized (c.class) {
                if (f406275o == null) {
                    f406275o = new c();
                }
            }
        }
        return f406275o;
    }

    private void c() {
        JSONObject jSONObject = new JSONObject();
        IcgSvrPlayerConfig icgSvrPlayerConfig = (IcgSvrPlayerConfig) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_SUPER_PLAYER_NORMAL_CONFIG, IcgSvrPlayerConfig.class, new IcgSvrPlayerConfig());
        QLog.i("ICGamePlayerConfigHelper", 1, "parseConfig: " + jSONObject);
        this.f406276a = icgSvrPlayerConfig.getBufferPacketMaxTotalDuration();
        this.f406277b = (long) icgSvrPlayerConfig.getMinBufferDuration();
        this.f406278c = icgSvrPlayerConfig.getMinBufferingTime();
        this.f406279d = icgSvrPlayerConfig.getMaxBufferingTime();
        this.f406280e = icgSvrPlayerConfig.getBufferingTimeout();
        this.f406281f = icgSvrPlayerConfig.getBufferPacketMinTotalDuration();
        this.f406282g = icgSvrPlayerConfig.getReduceLiveLatencyAction();
        this.f406283h = icgSvrPlayerConfig.getReduceLatencySpeedUpRate();
        this.f406284i = icgSvrPlayerConfig.getMaxPreloadDuration();
        this.f406285j = icgSvrPlayerConfig.getUpdateDownloadInfoDuration();
        this.f406286k = icgSvrPlayerConfig.getEnableOpenPlayerAllLog();
        IcgSvrPlayerQuicConfig icgSvrPlayerQuicConfig = (IcgSvrPlayerQuicConfig) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_SUPER_PLAYER_QUIC_CONFIG, IcgSvrPlayerQuicConfig.class, new IcgSvrPlayerQuicConfig());
        this.f406289n = icgSvrPlayerQuicConfig.getIsEnableDownloadProxy();
        this.f406287l = icgSvrPlayerQuicConfig.getIsSupportQuicFLv();
        this.f406288m = icgSvrPlayerQuicConfig.getEnableQuicPlaintext();
        QLog.i("ICGamePlayerConfigHelper", 1, "bufferPacketMaxTotalDuration: " + this.f406276a + " minBufferingTime:" + this.f406278c + " maxBufferingTime:" + this.f406279d + " bufferingTimeout:" + this.f406280e + " bufferPacketMinTotalDuration:" + this.f406281f + " reduceLiveLatencyAction:" + this.f406282g + " reduceLatencySpeedUpRate:" + this.f406283h + " isEnableDownloadProxy:" + this.f406289n + " isSupportQuicFLv:" + this.f406287l + " enableQuicPlaintext:" + this.f406288m + " enableOpenPlayerAllLog:" + this.f406286k + " updateDownloadInfoDuration:" + this.f406285j);
    }

    public void a(AudienceRoomConfig audienceRoomConfig) {
        PlayerConfig playerConfig;
        if (audienceRoomConfig != null && (playerConfig = audienceRoomConfig.playerConfig) != null) {
            c();
            playerConfig.minBufferDuration = this.f406277b;
            playerConfig.bufferingPacketDurationMin = this.f406281f;
            playerConfig.maxBufferDuration = this.f406276a;
            playerConfig.minBufferingTime = this.f406278c;
            playerConfig.maxBufferingTime = this.f406279d;
            playerConfig.bufferingTimeOut = this.f406280e;
            int i3 = this.f406282g;
            AudienceRoomConfig.LiveLatencyStrategy liveLatencyStrategy = AudienceRoomConfig.LiveLatencyStrategy.SPEED_UP;
            if (i3 == liveLatencyStrategy.action) {
                playerConfig.latencyStrategy = liveLatencyStrategy;
            } else {
                AudienceRoomConfig.LiveLatencyStrategy liveLatencyStrategy2 = AudienceRoomConfig.LiveLatencyStrategy.SKIP_FRAME;
                if (i3 == liveLatencyStrategy2.action) {
                    playerConfig.latencyStrategy = liveLatencyStrategy2;
                } else {
                    playerConfig.latencyStrategy = AudienceRoomConfig.LiveLatencyStrategy.NONE;
                }
            }
            playerConfig.speedUpRate = this.f406283h;
            audienceRoomConfig.maxPlayPreloadDuration = this.f406284i;
            playerConfig.isEnableDownloadProxy = this.f406289n;
            playerConfig.isSupportQuicFLv = this.f406287l;
            playerConfig.enableQuicPlaintext = this.f406288m;
            playerConfig.enableOpenPlayerAllLog = this.f406286k;
            playerConfig.updateDownloadInfoDuration = this.f406285j;
            QLog.i("ICGamePlayerConfigHelper", 1, "fill PlayerConfig minBufferDuration:" + playerConfig.minBufferDuration + " mode:" + playerConfig.latencyStrategy + " speed:" + playerConfig.speedUpRate + " preloadDuration:" + this.f406284i + " isEnableDownloadProxy:" + this.f406289n + " isSupportQuicFLv:" + this.f406287l + " enableQuicPlaintext:" + this.f406288m + " enableOpenPlayerAllLog:" + this.f406286k + " updateDownloadInfoDuration:" + this.f406285j);
        }
    }
}
