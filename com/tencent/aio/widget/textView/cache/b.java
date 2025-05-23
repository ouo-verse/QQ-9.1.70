package com.tencent.aio.widget.textView.cache;

import android.util.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/widget/textView/cache/b;", "Lcom/tencent/aio/widget/textView/creator/c;", "Lcom/tencent/aio/widget/textView/param/b;", "Lcom/tencent/aio/widget/textView/cache/a;", "param", "a", "value", "", "b", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "cache", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements com.tencent.aio.widget.textView.creator.c<com.tencent.aio.widget.textView.param.b, a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final LruCache<com.tencent.aio.widget.textView.param.b, a> cache;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f70000b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7857);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f70000b = new b();
            cache = new LruCache<>(100);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.aio.widget.textView.creator.c
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a get(@NotNull com.tencent.aio.widget.textView.param.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        return cache.get(param);
    }

    @Override // com.tencent.aio.widget.textView.creator.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void put(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull a value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(value, "value");
        cache.put(param, value);
    }
}
