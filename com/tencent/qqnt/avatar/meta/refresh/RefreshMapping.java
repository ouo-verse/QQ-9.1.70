package com.tencent.qqnt.avatar.meta.refresh;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.d;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R&\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/refresh/RefreshMapping;", "", "", "avatarType", "", "id", "c", "Lcom/tencent/qqnt/avatar/meta/refresh/bean/a;", "refreshInfo", "", "b", "e", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/ConcurrentHashMap;", "refreshMap", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class RefreshMapping {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RefreshMapping f352936a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a>> refreshMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352936a = new RefreshMapping();
            refreshMap = new ConcurrentHashMap<>();
        }
    }

    RefreshMapping() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(int avatarType, String id5) {
        return avatarType + "_" + id5;
    }

    public final void b(int avatarType, @Nullable String id5, @NotNull com.tencent.qqnt.avatar.meta.refresh.bean.a refreshInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(avatarType), id5, refreshInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        String c16 = c(avatarType, id5);
        ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a>> concurrentHashMap = refreshMap;
        CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a> copyOnWriteArraySet = concurrentHashMap.get(c16);
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(refreshInfo);
            return;
        }
        CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet2.add(refreshInfo);
        concurrentHashMap.put(c16, copyOnWriteArraySet2);
    }

    @Nullable
    public final Set<com.tencent.qqnt.avatar.meta.refresh.bean.a> d(int avatarType, @Nullable String id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this, avatarType, (Object) id5);
        }
        final String c16 = c(avatarType, id5);
        ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a>> concurrentHashMap = refreshMap;
        if (concurrentHashMap.contains(c16)) {
            d.f352991a.a("RefreshMapping", new Function0<String>(c16) { // from class: com.tencent.qqnt.avatar.meta.refresh.RefreshMapping$getRefreshListMapping$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $key;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    ConcurrentHashMap concurrentHashMap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String str = this.$key;
                    concurrentHashMap2 = RefreshMapping.refreshMap;
                    CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap2.get(this.$key);
                    return "getRefreshListMapping " + str + " " + (copyOnWriteArraySet != null ? Integer.valueOf(copyOnWriteArraySet.size()) : null);
                }
            });
        }
        return concurrentHashMap.get(c16);
    }

    public final void e(int avatarType, @Nullable String id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, avatarType, (Object) id5);
            return;
        }
        final String c16 = c(avatarType, id5);
        ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.qqnt.avatar.meta.refresh.bean.a>> concurrentHashMap = refreshMap;
        if (concurrentHashMap.contains(c16)) {
            d.f352991a.a("RefreshMapping", new Function0<String>(c16) { // from class: com.tencent.qqnt.avatar.meta.refresh.RefreshMapping$removeRefreshListMapping$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $key;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "removeRefreshListMapping " + this.$key;
                }
            });
        }
        concurrentHashMap.remove(c16);
    }
}
