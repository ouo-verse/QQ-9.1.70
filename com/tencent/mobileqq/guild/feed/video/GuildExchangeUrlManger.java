package com.tencent.mobileqq.guild.feed.video;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.guild.feed.requset.GuildExchangePlayUrlRequest;
import com.tencent.mobileqq.guild.feed.util.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import guild.GuildVideoUrlExchange$GetVideoAdaptRsp;
import guild.GuildVideoUrlExchange$Video;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildExchangeUrlManger {

    /* renamed from: b, reason: collision with root package name */
    private static volatile GuildExchangeUrlManger f223961b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f223962c = w.a("qqguild", "guild_video_level_type", 10).intValue();

    /* renamed from: d, reason: collision with root package name */
    private static final int f223963d = w.a("qqguild", "guild_video_hevc_level_type", 16).intValue();

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f223964e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f223965f;

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<String, GuildVideoUrlExchange$Video> f223966a = new LruCache<>(100);

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes13.dex */
    public @interface ExchangeUrlStatus {
        public static final int STATE_EXCHANGING = -1;
        public static final int STATE_FAILED = 1;
        public static final int STATE_SUCCESS = 0;
        public static final int STATE_UNKNOWN = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<GuildVideoUrlExchange$GetVideoAdaptRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProStVideo f223967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f223968b;

        a(GProStVideo gProStVideo, b bVar) {
            this.f223967a = gProStVideo;
            this.f223968b = bVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, GuildVideoUrlExchange$GetVideoAdaptRsp guildVideoUrlExchange$GetVideoAdaptRsp) {
            if (z16 && j3 == 0 && guildVideoUrlExchange$GetVideoAdaptRsp.videos.size() > 0) {
                GuildVideoUrlExchange$Video guildVideoUrlExchange$Video = guildVideoUrlExchange$GetVideoAdaptRsp.videos.get(0);
                guildVideoUrlExchange$Video.fileID.set(this.f223967a.fileId);
                if (guildVideoUrlExchange$Video.playURL.get().trim().length() > 0) {
                    this.f223967a.playUrl = guildVideoUrlExchange$Video.playURL.get();
                    this.f223968b.b(this.f223967a, false);
                    GuildExchangeUrlManger.this.f223966a.put(this.f223967a.fileId, guildVideoUrlExchange$Video);
                    QLog.i("GuildExchangeUrlManger", 1, String.format("exchangeVideoUrl: success fileId:%s ,videoExchange url %s:", guildVideoUrlExchange$Video.fileID.get(), guildVideoUrlExchange$Video.playURL.get()));
                    return;
                }
                this.f223968b.a(j3, str);
                GProStVideo gProStVideo = this.f223967a;
                QLog.e("GuildExchangeUrlManger", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", gProStVideo.fileId, gProStVideo.playUrl, Long.valueOf(j3), str));
                return;
            }
            this.f223968b.a(j3, str);
            GProStVideo gProStVideo2 = this.f223967a;
            QLog.e("GuildExchangeUrlManger", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", gProStVideo2.fileId, gProStVideo2.playUrl, Long.valueOf(j3), str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(long j3, String str);

        void b(GProStVideo gProStVideo, boolean z16);
    }

    static {
        boolean z16 = true;
        if (w.a("qqguild", "guild_video_enable_rate_bit_pre_select", 1).intValue() <= 0) {
            z16 = false;
        }
        f223964e = z16;
        f223965f = w.a("qqguild", "guild_video_trigger_downgrade_speed", 500).intValue();
    }

    GuildExchangeUrlManger() {
    }

    public static GuildExchangeUrlManger f() {
        if (f223961b == null) {
            synchronized (GuildExchangeUrlManger.class) {
                if (f223961b == null) {
                    f223961b = new GuildExchangeUrlManger();
                }
            }
        }
        return f223961b;
    }

    public boolean b(GProStVideo gProStVideo) {
        GuildVideoUrlExchange$Video guildVideoUrlExchange$Video;
        if (gProStVideo == null || (guildVideoUrlExchange$Video = this.f223966a.get(gProStVideo.fileId)) == null || guildVideoUrlExchange$Video.playURL.get().trim().length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean c(GProStVideo gProStVideo) {
        if (gProStVideo == null) {
            return false;
        }
        return d(gProStVideo.playUrl);
    }

    public boolean d(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getQueryParameter("dis_t") != null) {
                long longValue = Long.valueOf(parse.getQueryParameter("dis_t")).longValue() * 1000;
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                QLog.d("GuildExchangeUrlManger", 2, String.format("intervalTime:%d, disTime: %d, valid time:%d", Long.valueOf(currentTimeMillis), Long.valueOf(longValue), 21300000));
                if (currentTimeMillis > 21300000) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e("GuildExchangeUrlManger", 1, "checkVideoUrlIsNeedChange error:", e16);
            return false;
        }
    }

    public void e(int i3, GProStVideo gProStVideo, b bVar) {
        if (gProStVideo != null && bVar != null) {
            if (RFWFileUtils.isLocalPath(gProStVideo.playUrl)) {
                QLog.d("GuildExchangeUrlManger", 1, "isNativeUrl local url return:");
                bVar.b(gProStVideo, true);
                return;
            }
            if (!c(gProStVideo)) {
                QLog.i("GuildExchangeUrlManger", 1, String.format("exchangeVideoUrl: valid callBack fileId:%s ,videoExchange url:%s", gProStVideo.fileId, gProStVideo.playUrl));
                bVar.b(gProStVideo, true);
                return;
            }
            GuildVideoUrlExchange$Video guildVideoUrlExchange$Video = this.f223966a.get(gProStVideo.fileId);
            if (guildVideoUrlExchange$Video != null && guildVideoUrlExchange$Video.playURL.get().trim().length() > 0) {
                QLog.i("GuildExchangeUrlManger", 1, String.format("exchangeVideoUrl: success hit Video Cache fileId:%s ,videoExchange url %s:", guildVideoUrlExchange$Video.fileID.get(), guildVideoUrlExchange$Video.playURL.get()));
                gProStVideo.playUrl = guildVideoUrlExchange$Video.playURL.get();
                bVar.b(gProStVideo, false);
                return;
            }
            VSNetworkHelper.getInstance().sendRequest(i3, new GuildExchangePlayUrlRequest(gProStVideo), new a(gProStVideo, bVar));
            return;
        }
        QLog.e("GuildExchangeUrlManger", 1, "exchangeVideoUrl video==null or callBack=null");
    }
}
