package kz;

import UserGrowth.stDramaFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends jz.a {

    /* renamed from: c, reason: collision with root package name */
    private final String f413467c;

    /* renamed from: d, reason: collision with root package name */
    private String f413468d;

    /* renamed from: e, reason: collision with root package name */
    private int f413469e;

    /* renamed from: f, reason: collision with root package name */
    private int f413470f;

    /* renamed from: g, reason: collision with root package name */
    private String f413471g;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, stDramaFeed> f413472h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f413473i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f413474j;

    public g(String str, String str2, int i3, int i16) {
        this.f413467c = str;
        this.f413468d = str2;
        this.f413469e = i3;
        this.f413470f = i16;
    }

    public String c() {
        return this.f413471g;
    }

    public int d() {
        return this.f413470f;
    }

    public Map<Integer, stDramaFeed> e() {
        return this.f413472h;
    }

    public String f() {
        return this.f413467c;
    }

    public int g() {
        return this.f413469e;
    }

    public String h() {
        return this.f413468d;
    }

    public boolean i() {
        return this.f413473i;
    }

    public boolean j() {
        return this.f413474j;
    }

    public void k(int i3) {
        this.f413470f = i3;
    }

    public void l(Map<Integer, stDramaFeed> map) {
        this.f413472h = map;
    }

    public void m(boolean z16) {
        this.f413473i = z16;
    }

    public void n(boolean z16) {
        this.f413474j = z16;
    }

    public String toString() {
        return "WSDramaFeedsParams{dramaId='" + this.f413467c + "', feedId='" + this.f413468d + "', episodeNum=" + this.f413469e + ", direction=" + this.f413470f + ", attachInfo='" + this.f413471g + "', dramaFeedMap=" + this.f413472h + ", isPreloadData=" + this.f413473i + ", isUpdateNum=" + this.f413474j + '}';
    }
}
