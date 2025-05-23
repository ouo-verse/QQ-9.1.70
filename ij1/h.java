package ij1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThumbnail;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedAbstract;

/* compiled from: P */
/* loaded from: classes13.dex */
public class h extends b<GProTopFeed> {
    public String C;
    public String D;
    public int E;
    public long F;
    public long G;
    public long H;
    public GProStChannelSign I;
    public long J;
    public long K;
    public boolean L;
    public int M;
    public int N;
    public String P;
    public int Q;
    public long R;

    /* renamed from: h, reason: collision with root package name */
    public String f407814h;

    /* renamed from: i, reason: collision with root package name */
    public String f407815i;

    /* renamed from: m, reason: collision with root package name */
    public long f407816m;

    public h(GProTopFeed gProTopFeed) {
        super(gProTopFeed);
        this.f407814h = "";
        this.f407815i = "";
        this.f407816m = 0L;
        this.C = "";
        this.D = "";
        this.E = -1;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = new GProStChannelSign();
        this.J = 0L;
        this.K = -1L;
        this.L = false;
        this.M = 1;
        this.N = 0;
        this.P = "";
        this.Q = 0;
        this.R = 0L;
    }

    public boolean h() {
        if (this.K == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h i() {
        T t16 = this.f407799e;
        this.f407814h = ((GProTopFeed) t16).feedId;
        this.f407815i = ((GProTopFeed) t16).userId;
        this.f407816m = ((GProTopFeed) t16).createTime;
        GProTopFeedAbstract gProTopFeedAbstract = ((GProTopFeed) t16).feedAbstract;
        this.C = gProTopFeedAbstract.title;
        GProThumbnail gProThumbnail = gProTopFeedAbstract.thumbnail;
        this.D = gProThumbnail.url;
        this.E = gProThumbnail.type;
        this.F = ((GProTopFeed) t16).topTimestamp;
        this.G = ((GProTopFeed) t16).operatorTinyid;
        GProStChannelSign gProStChannelSign = ((GProTopFeed) t16).channelSign;
        this.I = gProStChannelSign;
        this.J = gProStChannelSign.channelId;
        this.H = gProStChannelSign.guildId;
        this.K = ((GProTopFeed) t16).readTime;
        this.L = ((GProTopFeed) t16).needNotify;
        this.M = ((GProTopFeed) t16).label.f359316id;
        this.N = ((GProTopFeed) t16).label.color;
        this.P = ((GProTopFeed) t16).label.text;
        this.Q = ((GProTopFeed) t16).cardType;
        this.R = ((GProTopFeed) t16).cardInfo.getScheduleId();
        return this;
    }

    public String toString() {
        return "GuildGproFeedTopData{feedId='" + this.f407814h + "', userId='" + this.f407815i + "', createTime=" + this.f407816m + ", title='" + this.C + "', thumbUrl='" + this.D + "', thumbType=" + this.E + ", timestamp=" + this.F + ", operatorTinyId=" + this.G + '}';
    }
}
