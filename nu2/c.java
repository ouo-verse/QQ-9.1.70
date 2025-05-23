package nu2;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import java.lang.ref.WeakReference;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<Context> f421299a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile WeakReference<ViewGroup> f421300b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile kt3.j f421301c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile QAdUserInfo f421302d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile String f421303e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.b f421304f;

    public void c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.b bVar) {
        this.f421304f = bVar;
    }

    public void d(Context context) {
        if (context == null) {
            n.e("QAdBaseFrameAd", "context is null : " + Log.getStackTraceString(new Throwable()));
        }
        this.f421299a = new WeakReference<>(context);
    }

    public void e(String str) {
        this.f421303e = str;
    }

    public void f(ViewGroup viewGroup) {
        this.f421300b = new WeakReference<>(viewGroup);
    }

    public void g(QAdUserInfo qAdUserInfo) {
        this.f421302d = qAdUserInfo;
    }
}
