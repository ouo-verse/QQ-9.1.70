package com.tencent.mobileqq.troop.troopidentity.util;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0007R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/util/b;", "", "", "troopUin", "memberUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GetIdentityListRsp;", "rsp", "", "a", "d", "", "richFlag", "b", "e", "c", "", "Ljava/util/Map;", "cachedIdentityRsp", "I", "cachedRichFlag", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f300417a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, GetIdentityListRsp> cachedIdentityRsp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int cachedRichFlag;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57857);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f300417a = new b();
        cachedIdentityRsp = new LinkedHashMap();
        cachedRichFlag = -1;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String troopUin, @NotNull String memberUin, @Nullable GetIdentityListRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUin, rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        cachedIdentityRsp.put(troopUin + "-" + memberUin, rsp);
    }

    public final void b(int richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, richFlag);
        } else {
            cachedRichFlag = richFlag;
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            cachedIdentityRsp.clear();
            cachedRichFlag = -1;
        }
    }

    @Nullable
    public final GetIdentityListRsp d(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GetIdentityListRsp) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        return cachedIdentityRsp.get(troopUin + "-" + memberUin);
    }

    public final int e(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin, (Object) memberUin)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        int i3 = cachedRichFlag;
        if (i3 == -1) {
            TroopMemberInfo troopMemberFromCache = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCache(troopUin, memberUin, null, "TroopIdentityRespCacheUtil");
            if (troopMemberFromCache == null) {
                return 0;
            }
            return com.tencent.mobileqq.troop.honor.util.a.h(4, troopMemberFromCache.mHonorRichFlag);
        }
        return i3;
    }
}
