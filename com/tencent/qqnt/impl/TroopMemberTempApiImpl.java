package com.tencent.qqnt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.au;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.qqnt.troopmemberlist.cache.impl.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0017J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u00042\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00130\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/impl/TroopMemberTempApiImpl;", "Lcom/tencent/qqnt/ITroopMemberTempApi;", "()V", "clearNoFriendRemarkCache", "", "deleteTroopMemberCache", "troopUin", "", "memUin", "getNoFriendRemark", "uid", "getTroopMemberInfoSync", "", "memberUin", "from", "getTroopMemberUidSync", "preloadNoFriendRemark", "uin2UidList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TroopMemberTempApiImpl implements ITroopMemberTempApi {
    static IPatchRedirector $redirector_;

    public TroopMemberTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    public void clearNoFriendRemarkCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            au.f362840a.a();
        }
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    public void deleteTroopMemberCache(@Nullable String troopUin, @Nullable String memUin) {
        ITroopMemberCacheService a16;
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memUin);
        } else if (troopUin != null && memUin != null && (a16 = c.a()) != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(memUin);
            a16.remove(troopUin, listOf);
        }
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    @NotNull
    public String getNoFriendRemark(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        return au.f362840a.c(uid);
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    public Object getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, troopUin, memberUin, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return TroopMemberListRepo.INSTANCE.getTroopMemberInfoSync(troopUin, memberUin, null, from);
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    @NotNull
    public String getTroopMemberUidSync(@Nullable String memberUin) {
        ITroopMemberCacheService a16;
        String uidFromUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberUin);
        }
        if (memberUin == null || (a16 = c.a()) == null || (uidFromUin = a16.getUidFromUin(memberUin)) == null) {
            return "";
        }
        return uidFromUin;
    }

    @Override // com.tencent.qqnt.ITroopMemberTempApi
    public void preloadNoFriendRemark(@NotNull ArrayList<Pair<String, String>> uin2UidList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin2UidList);
        } else {
            Intrinsics.checkNotNullParameter(uin2UidList, "uin2UidList");
            au.f362840a.b(uin2UidList);
        }
    }
}
