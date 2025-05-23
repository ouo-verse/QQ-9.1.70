package com.tencent.qqnt.troopmemberlist.cache;

import com.tencent.cache.api.Business;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.qqnt.troopmemberlist.cache.impl.TroopMemberCacheServiceImpl;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/a;", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "get", "", "memberInfos", "", "put", "remove", "", "a", "b", "I", QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, "Lcom/tencent/cache/api/collection/a;", "Lcom/tencent/cache/api/collection/a;", "memberCache", "<init>", "(I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements ITroopMemberCacheService.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxCacheSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cache.api.collection.a<String, TroopMemberInfo> memberCache;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.maxCacheSize = i3;
            this.memberCache = new com.tencent.cache.api.collection.a<>(Business.AIO, "TroopMembers", i3);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int a(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return this.maxCacheSize - this.memberCache.h();
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.maxCacheSize;
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
        return this.memberCache.e(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, memberUin));
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
        for (TroopMemberInfo troopMemberInfo : memberInfos) {
            this.memberCache.f(TroopMemberCacheServiceImpl.INSTANCE.a(troopMemberInfo), troopMemberInfo);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService.c
    public void remove(@NotNull String troopUin, @NotNull List<String> memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Iterator<String> it = memberUin.iterator();
        while (it.hasNext()) {
            this.memberCache.g(TroopMemberCacheServiceImpl.INSTANCE.b(troopUin, it.next()));
        }
    }
}
