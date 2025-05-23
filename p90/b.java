package p90;

import android.app.Activity;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final b f425797b = new b();

    /* renamed from: a, reason: collision with root package name */
    private a f425798a;

    b() {
    }

    public static b a() {
        return f425797b;
    }

    public RFWLayoutPreLoader b() {
        if (this.f425798a == null) {
            this.f425798a = new a();
        }
        return RFWLayoutPreLoaderFactory.getLayoutLoader(this.f425798a);
    }

    public void c(Activity activity) {
        RFWLayoutPreLoader b16 = b();
        b16.preloadView(activity, R.layout.grf, 1);
        b16.preloadView(activity, R.layout.grw, 1);
        b16.preloadView(activity, R.layout.gsk, 2);
        b16.preloadView(activity, R.layout.gri, 1);
        b16.preloadView(activity, R.layout.gr8, 1);
        b16.preloadView(activity, R.layout.gs7, 1);
        b16.preloadView(activity, R.layout.gsm, 1);
        b16.preloadView(activity, R.layout.gs6, 1);
        b16.preloadView(activity, R.layout.gr5, 3);
        b16.preloadView(activity, R.layout.grh, 3);
        b16.preloadView(activity, R.layout.gqv, 7);
    }
}
