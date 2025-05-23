package mz;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements lz.a {

    /* renamed from: a, reason: collision with root package name */
    private final stDrama f417826a;

    /* renamed from: b, reason: collision with root package name */
    private stDramaFeed f417827b;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f417828c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f417829d;

    public d(stDrama stdrama) {
        this.f417826a = stdrama;
    }

    public int a() {
        stDramaFeed stdramafeed = this.f417827b;
        if (stdramafeed != null) {
            return stdramafeed.num;
        }
        return 0;
    }

    public int b() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f417826a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null || this.f417827b == null) {
            return 0;
        }
        return stdramainfo.curPublishedFeedNum;
    }

    public int c() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f417826a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null || this.f417827b == null) {
            return 0;
        }
        return stdramainfo.curWatchedFeedNum;
    }

    public String d() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f417826a;
        if (stdrama != null && (stdramainfo = stdrama.dramaInfo) != null) {
            return stdramainfo.f25116id;
        }
        return "";
    }

    public stDrama e() {
        return this.f417826a;
    }

    public String f() {
        stSimpleMetaFeed stsimplemetafeed;
        stDramaFeed stdramafeed = this.f417827b;
        if (stdramafeed != null && (stsimplemetafeed = stdramafeed.feed) != null) {
            return stsimplemetafeed.f25129id;
        }
        return "";
    }

    public List<String> g() {
        return this.f417828c;
    }

    public stDramaFeed h() {
        return this.f417827b;
    }

    public stSimpleMetaFeed i() {
        stDramaFeed stdramafeed = this.f417827b;
        if (stdramafeed != null) {
            return stdramafeed.feed;
        }
        return null;
    }

    @Override // lz.a
    public boolean isChecked() {
        return this.f417829d;
    }

    public String j() {
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        stDramaFeed stdramafeed = this.f417827b;
        if (stdramafeed != null && (stsimplemetafeed = stdramafeed.feed) != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            return stsimplemetaperson.f25130id;
        }
        return "";
    }

    public boolean k() {
        stDramaInfo stdramainfo;
        stDramaFeed stdramafeed;
        stDrama stdrama = this.f417826a;
        return (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null || (stdramafeed = this.f417827b) == null || stdramainfo.curPublishedFeedNum != stdramafeed.num) ? false : true;
    }

    public void l(List<String> list) {
        this.f417828c = list;
    }

    public void m(stDramaFeed stdramafeed) {
        this.f417827b = stdramafeed;
    }

    public void n(stSimpleMetaFeed stsimplemetafeed) {
        stDramaFeed stdramafeed = this.f417827b;
        if (stdramafeed != null) {
            stdramafeed.feed = stsimplemetafeed;
        }
    }

    @Override // lz.a
    public void setChecked(boolean z16) {
        this.f417829d = z16;
    }
}
