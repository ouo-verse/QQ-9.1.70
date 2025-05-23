package nd0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import hd0.c;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public nd0.a f419951a;

    /* renamed from: b, reason: collision with root package name */
    public Object f419952b;

    /* renamed from: c, reason: collision with root package name */
    public int f419953c;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<ImageView> f419954d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f419955e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f419956f;

    /* renamed from: g, reason: collision with root package name */
    protected a f419957g;

    /* renamed from: h, reason: collision with root package name */
    protected volatile boolean f419958h = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(b bVar);
    }

    public b(ImageView imageView) {
        this.f419954d = new WeakReference<>(imageView);
    }

    public void a() {
        this.f419958h = true;
        gd0.a.a("Q.qqstory.newImageLoader", HardCodeUtil.qqStr(R.string.tzi), this.f419952b);
    }

    public void b(Drawable drawable) {
        this.f419955e = drawable;
        a aVar = this.f419957g;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public boolean c() {
        return this.f419958h;
    }

    public abstract String d();

    public void e(WeakHashMap<ImageView, Drawable> weakHashMap, boolean z16) {
        ImageView imageView;
        Drawable drawable;
        if (this.f419958h || (imageView = this.f419954d.get()) == null || (drawable = this.f419955e) == null) {
            return;
        }
        if (z16 && this.f419953c == 0) {
            c.b("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.f419952b);
            weakHashMap.put(imageView, this.f419955e);
            return;
        }
        imageView.setImageDrawable(drawable);
        int i3 = nd0.a.D;
        gd0.a.a("Q.qqstory.newImageLoader", "postToUI o= ", imageView.getTag(i3), " and change to: ", this.f419952b.toString(), " view hash:" + imageView.hashCode());
        imageView.setTag(i3, this.f419952b.toString());
    }

    public void f() {
        this.f419955e = null;
        this.f419957g = null;
        this.f419951a = null;
        gd0.a.a("Q.qqstory.newImageLoader", HardCodeUtil.qqStr(R.string.tzj), this.f419952b);
    }

    public abstract void g();

    public void h(a aVar) {
        this.f419957g = aVar;
    }
}
