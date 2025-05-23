package oz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public stDrama f424527a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f424528b;

    public c(stDrama stdrama) {
        this.f424527a = stdrama;
    }

    public String a() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f424527a;
        if (stdrama != null && (stdramainfo = stdrama.dramaInfo) != null) {
            return stdramainfo.f25116id;
        }
        return "";
    }

    public String b() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f424527a;
        if (stdrama != null && (stdramainfo = stdrama.dramaInfo) != null) {
            return stdramainfo.curWatchedFeedID;
        }
        return "";
    }

    public int c() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f424527a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null) {
            return 0;
        }
        return stdramainfo.curPublishedFeedNum;
    }

    public int d() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f424527a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null) {
            return 0;
        }
        return stdramainfo.curWatchedFeedNum;
    }

    public boolean e() {
        return this.f424528b;
    }

    public boolean f() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.f424527a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null) {
            return false;
        }
        return stdramainfo.isPublishCompleted;
    }

    public void g(boolean z16) {
        this.f424528b = z16;
    }
}
