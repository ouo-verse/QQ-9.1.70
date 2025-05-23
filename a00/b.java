package a00;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends a<ArrayList<stSimpleMetaFeed>> {

    /* renamed from: c, reason: collision with root package name */
    private boolean f25305c;

    /* renamed from: d, reason: collision with root package name */
    private String f25306d;

    /* renamed from: e, reason: collision with root package name */
    protected int f25307e = 0;

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    public b() {
        this.f25303a = new ArrayList();
        this.f25304b = new StringBuilder();
    }

    private boolean f(stSimpleMetaFeed stsimplemetafeed) {
        return (TextUtils.isEmpty(this.f25306d) && d() == 0) || TextUtils.equals(this.f25306d, stsimplemetafeed.poster_id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int d() {
        return ((ArrayList) this.f25303a).size();
    }

    public int e() {
        return this.f25307e;
    }

    public boolean g() {
        return this.f25305c;
    }

    public void h(int i3) {
        this.f25307e = i3;
    }

    public void i(boolean z16) {
        this.f25305c = z16;
        if (z16) {
            WeiShiCacheManager.O().n(b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null || !f(stsimplemetafeed)) {
            return false;
        }
        this.f25306d = stsimplemetafeed.poster_id;
        this.f25304b.append(stsimplemetafeed.f25129id);
        ((ArrayList) this.f25303a).add(stsimplemetafeed);
        return true;
    }
}
