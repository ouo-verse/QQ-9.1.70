package com.tencent.qqnt.avatar.cache;

import android.util.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/e;", "Lcom/tencent/qqnt/avatar/cache/d;", "Lcom/tencent/qqnt/avatar/layer/a;", "", "key", "c", "resource", "", "highPriority", "", "d", "b", "", "level", "e", "Lcom/tencent/qqnt/avatar/cache/e$a;", "Lcom/tencent/qqnt/avatar/cache/e$a;", "highPriorityMemoryCache", "lowPriorityMemoryCache", "<init>", "()V", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e implements d<com.tencent.qqnt.avatar.layer.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f352705a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a highPriorityMemoryCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a lowPriorityMemoryCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/e$a;", "Landroid/util/LruCache;", "", "Lcom/tencent/qqnt/avatar/layer/a;", "key", "value", "", "a", "maxSize", "<init>", "(I)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends LruCache<String, com.tencent.qqnt.avatar.layer.a> {
        static IPatchRedirector $redirector_;

        public a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(@NotNull String key, @NotNull com.tencent.qqnt.avatar.layer.a value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) value)).intValue();
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return com.tencent.qqnt.avatar.meta.c.b(value.d());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f352705a = new e();
        highPriorityMemoryCache = new a(8388608);
        lowPriorityMemoryCache = new a(8388608);
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            highPriorityMemoryCache.evictAll();
            lowPriorityMemoryCache.evictAll();
        }
    }

    @Nullable
    public com.tencent.qqnt.avatar.layer.a c(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.layer.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        com.tencent.qqnt.avatar.layer.a aVar = highPriorityMemoryCache.get(key);
        if (aVar == null) {
            return lowPriorityMemoryCache.get(key);
        }
        return aVar;
    }

    @Override // com.tencent.qqnt.avatar.cache.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull String key, @NotNull com.tencent.qqnt.avatar.layer.a resource, boolean highPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, key, resource, Boolean.valueOf(highPriority));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (highPriority) {
            highPriorityMemoryCache.put(key, resource);
        } else {
            lowPriorityMemoryCache.put(key, resource);
        }
    }

    public final void e(int level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, level);
            return;
        }
        if (level >= 15) {
            com.tencent.qqnt.avatar.util.d.f352991a.e("ResourceCache", "onTrimMemory level=" + level);
        }
        if (level >= 40) {
            b();
        } else if (level >= 15) {
            lowPriorityMemoryCache.evictAll();
        }
    }
}
