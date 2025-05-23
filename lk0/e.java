package lk0;

import android.annotation.SuppressLint;
import android.view.View;
import com.tencent.ecommerce.richtext.ui.dom.style.o;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f414936a = new AtomicInteger(1);

    @SuppressLint({"NewApi"})
    public static int a() {
        return View.generateViewId();
    }

    public static float b(b bVar) {
        float j3 = bVar.j();
        o m3 = bVar.m();
        o e16 = bVar.e();
        float a16 = m3.a(0);
        if (!com.tencent.ecommerce.richtext.ui.dom.style.f.a(a16)) {
            j3 -= a16;
        }
        float a17 = m3.a(2);
        if (!com.tencent.ecommerce.richtext.ui.dom.style.f.a(a17)) {
            j3 -= a17;
        }
        float a18 = e16.a(0);
        if (!com.tencent.ecommerce.richtext.ui.dom.style.f.a(a18)) {
            j3 -= a18;
        }
        float a19 = e16.a(2);
        if (!com.tencent.ecommerce.richtext.ui.dom.style.f.a(a19)) {
            return j3 - a19;
        }
        return j3;
    }
}
