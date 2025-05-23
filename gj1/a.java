package gj1;

import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.richframework.preload.activity.PredictLayoutLoadStrategy;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f402161d;

    /* renamed from: a, reason: collision with root package name */
    private RFWLayoutLoaderStrategy f402162a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f402163b = true;

    /* renamed from: c, reason: collision with root package name */
    private RFWLayoutPreLoader f402164c;

    a() {
        f();
    }

    public static a a() {
        if (f402161d == null) {
            synchronized (a.class) {
                if (f402161d == null) {
                    f402161d = new a();
                }
            }
        }
        return f402161d;
    }

    public boolean b() {
        return this.f402163b;
    }

    public RFWLayoutLoaderStrategy c() {
        if (this.f402162a == null) {
            this.f402162a = new hn1.a();
        }
        return this.f402162a;
    }

    public RFWLayoutPreLoader d() {
        if (this.f402164c == null) {
            this.f402164c = RFWLayoutPreLoaderFactory.getLayoutLoader(c());
        }
        return this.f402164c;
    }

    public RFWLayoutPreLoader e() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(new PredictLayoutLoadStrategy());
    }

    private void f() {
    }
}
