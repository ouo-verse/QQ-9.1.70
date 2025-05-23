package gd0;

import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<ImageView, nd0.b> f401935a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<nd0.b, WeakReference<ImageView>> f401936b = new LinkedHashMap<>(10, 0.75f, true);

    public void a(ImageView imageView, nd0.b bVar) {
        nd0.b put = this.f401935a.put(imageView, bVar);
        if (put != null) {
            this.f401936b.remove(put);
        }
        this.f401936b.put(bVar, new WeakReference<>(imageView));
    }

    public ListIterator<Map.Entry<nd0.b, WeakReference<ImageView>>> b() {
        return new ArrayList(this.f401936b.entrySet()).listIterator(this.f401936b.size());
    }

    public nd0.b c(ImageView imageView) {
        return this.f401935a.get(imageView);
    }

    public nd0.b d(ImageView imageView) {
        nd0.b remove = this.f401935a.remove(imageView);
        if (remove != null) {
            this.f401936b.remove(remove);
        }
        return remove;
    }

    public void e(nd0.b bVar) {
        this.f401936b.remove(bVar);
    }

    public int f() {
        return this.f401936b.size();
    }
}
