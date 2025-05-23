package b04;

import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import f04.d;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public IMvpFactory f27651a;

    /* renamed from: b, reason: collision with root package name */
    public d f27652b;

    /* renamed from: d, reason: collision with root package name */
    private IBrowserAnimationListener f27654d;

    /* renamed from: e, reason: collision with root package name */
    private d04.a f27655e;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<Integer, Integer> f27653c = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f27656f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f27657g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f27658h = false;

    public void a(int i3, int i16) {
        this.f27653c.put(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public BrowserAnimation b(RichMediaBaseData richMediaBaseData) {
        IBrowserAnimationListener iBrowserAnimationListener = this.f27654d;
        if (iBrowserAnimationListener != null) {
            return iBrowserAnimationListener.getBrowserAnimation(richMediaBaseData);
        }
        return null;
    }

    public d04.a c() {
        return this.f27655e;
    }

    public void d(IBrowserAnimationListener iBrowserAnimationListener) {
        this.f27654d = iBrowserAnimationListener;
    }

    public void e(d04.a aVar) {
        this.f27655e = aVar;
    }

    public void f(d dVar) {
        this.f27652b = dVar;
    }

    public void g(boolean z16) {
        this.f27656f = z16;
    }

    public void h(boolean z16) {
        this.f27658h = z16;
    }

    public void i(IBrowserLog iBrowserLog) {
        BrowserLogHelper.getInstance().setLogProxy(iBrowserLog);
    }

    public void j(IMvpFactory iMvpFactory) {
        this.f27651a = iMvpFactory;
    }

    public void k(boolean z16) {
        this.f27657g = z16;
    }
}
