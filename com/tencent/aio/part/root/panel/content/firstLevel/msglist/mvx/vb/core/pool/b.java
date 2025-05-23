package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool;

import com.tencent.aio.api.AIORecyclePoolFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J3\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00030\u0006H\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/pool/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/pool/a;", "Lcom/tencent/aio/api/AIORecyclePoolFactory$a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/pool/AIORecyclePool;", "key", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "creator", "b", "", "a", "Ljava/util/Map;", "caches", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements a<AIORecyclePoolFactory.a, AIORecyclePool> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<AIORecyclePoolFactory.a, AIORecyclePool> caches;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f69634b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f69634b = new b();
            caches = new LinkedHashMap();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public AIORecyclePool b(@NotNull AIORecyclePoolFactory.a key, @NotNull Function1<? super AIORecyclePoolFactory.a, AIORecyclePool> creator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIORecyclePool) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) creator);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Map<AIORecyclePoolFactory.a, AIORecyclePool> map = caches;
        if (map.get(key) == null) {
            map.put(key, creator.invoke(key));
        }
        AIORecyclePool aIORecyclePool = map.get(key);
        Intrinsics.checkNotNull(aIORecyclePool);
        return aIORecyclePool;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.a
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AIORecyclePool a(@NotNull AIORecyclePoolFactory.a key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIORecyclePool) iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Map<AIORecyclePoolFactory.a, AIORecyclePool> map = caches;
        AIORecyclePool remove = map.remove(key);
        com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("RecyclePoolManager", "remove " + remove + " curSize " + map.size());
        return remove;
    }
}
