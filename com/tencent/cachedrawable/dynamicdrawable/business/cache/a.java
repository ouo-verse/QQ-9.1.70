package com.tencent.cachedrawable.dynamicdrawable.business.cache;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/b;", "", "c", "", "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "a", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/b;", "getSInstance", "()Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/b;", "setSInstance", "(Lcom/tencent/cachedrawable/dynamicdrawable/business/cache/b;)V", "sInstance", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98855a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/DynamicDrawable/Inject_DynamicCacheManager.yml", version = 1)
    @Nullable
    private static b sInstance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f98857c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f98857c = arrayList;
        arrayList.add(u03.a.class);
        a aVar = new a();
        f98855a = aVar;
        aVar.c();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.cache.b
    public void a(@NotNull String key, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, (Object) frameAnimData);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(frameAnimData, "frameAnimData");
        b bVar = sInstance;
        if (bVar != null) {
            bVar.a(key, frameAnimData);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.cache.b
    @Nullable
    public com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        b bVar = sInstance;
        if (bVar == null) {
            return null;
        }
        return bVar.b(key);
    }

    @QAutoInitMethod
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sInstance = (b) com.tencent.mobileqq.qroute.utils.b.a(f98857c);
        }
    }
}
