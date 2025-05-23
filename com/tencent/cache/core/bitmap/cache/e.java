package com.tencent.cache.core.bitmap.cache;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e<K, V> implements View.OnAttachStateChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final c<K, V> f98678d;

    public e(@NotNull c<K, V> imageCache) {
        Intrinsics.checkNotNullParameter(imageCache, "imageCache");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) imageCache);
        } else {
            this.f98678d = imageCache;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v3) {
        b c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag(R.id.f924457w);
        if (tag != null && (c16 = this.f98678d.c(tag)) != null) {
            a aVar = a.f98656b;
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            c16.f98662d = aVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v3) {
        b c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        v3.removeOnAttachStateChangeListener(this);
        Object tag = v3.getTag(R.id.f924457w);
        if (tag != null && (c16 = this.f98678d.c(tag)) != null) {
            Iterator<SoftReference<View>> it = c16.f98661c.iterator();
            while (it.hasNext()) {
                SoftReference<View> next = it.next();
                if (next.get() == null || next.get() == v3) {
                    it.remove();
                }
            }
            if (c16.f98661c.isEmpty()) {
                a aVar = a.f98657c;
                Intrinsics.checkNotNullParameter(aVar, "<set-?>");
                c16.f98662d = aVar;
            }
        }
    }
}
