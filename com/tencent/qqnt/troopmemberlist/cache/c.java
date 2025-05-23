package com.tencent.qqnt.troopmemberlist.cache;

import androidx.collection.LruCache;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R,\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/c;", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "get", "", "memberInfos", "", "put", "remove", "", "a", "b", "Lcom/tencent/cache/api/collection/a;", "Landroidx/collection/LruCache;", "Lcom/tencent/cache/api/collection/a;", "memberCache", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements ITroopMemberCacheService.c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cache.api.collection.a<String, LruCache<String, TroopMemberInfo>> memberCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/c$a;", "", "", "MAX_MEMBER_SIZE_PER_TROOP", "I", "MAX_TROOP_SIZE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.cache.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.memberCache = new com.tencent.cache.api.collection.a<>(Business.AIO, "TroopMembers", 12);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int a(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        LruCache<String, TroopMemberInfo> e16 = this.memberCache.e(troopUin);
        if (e16 == null) {
            return 48;
        }
        return 48 - e16.size();
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    @Nullable
    public TroopMemberInfo get(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        LruCache<String, TroopMemberInfo> e16 = this.memberCache.e(troopUin);
        if (e16 != null) {
            return e16.get(memberUin);
        }
        return null;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public void put(@NotNull String troopUin, @NotNull List<? extends TroopMemberInfo> memberInfos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberInfos);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberInfos, "memberInfos");
        LruCache<String, TroopMemberInfo> e16 = this.memberCache.e(troopUin);
        if (e16 == null) {
            e16 = new LruCache<>(48);
        }
        for (TroopMemberInfo troopMemberInfo : memberInfos) {
            e16.put(troopMemberInfo.memberuin, troopMemberInfo);
        }
        this.memberCache.f(troopUin, e16);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public void remove(@NotNull String troopUin, @NotNull List<String> memberUin) {
        LruCache<String, TroopMemberInfo> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        for (String str : memberUin) {
            if (get(troopUin, str) != null && (e16 = this.memberCache.e(troopUin)) != null) {
                e16.remove(str);
            }
        }
    }
}
