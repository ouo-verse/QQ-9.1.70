package o60;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements Observer<w> {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<InterfaceC10889a> f422156d;

    /* compiled from: P */
    /* renamed from: o60.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC10889a {
        void b1(w wVar);
    }

    public a(InterfaceC10889a interfaceC10889a) {
        this.f422156d = new WeakReference<>(interfaceC10889a);
    }

    public void a(w wVar) {
        if (TextUtils.isEmpty(wVar.L())) {
            return;
        }
        w20.a.j().observerGlobalState(wVar, this);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w20.a.j().observerGlobalState(w.class, str, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onChanged(w wVar) {
        if (this.f422156d.get() != null) {
            this.f422156d.get().b1(wVar);
        }
    }
}
