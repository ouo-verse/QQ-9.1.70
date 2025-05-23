package com.tencent.mobileqq.troop.troopgag;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.state.data.SquareJSConst;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgag/a;", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "", "groupCode", "", h.F, "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor$Strategy;", "b", "c", "fromNet", "isSuccess", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "e", "uin", "g", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements ITroopMemberInfoUpdateProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, Boolean> f300214b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, Boolean> f300215c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgag/a$a;", "", "", "TAG", "Ljava/lang/String;", "", "", "troopAdminHadUpdate", "Ljava/util/Map;", "troopOwnerHadUpdate", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopgag.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        f300214b = new LinkedHashMap();
        f300215c = new LinkedHashMap();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean h(String groupCode) {
        long j3;
        long serverTime = NetConnInfoCenter.getServerTime();
        TroopInfo troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(groupCode);
        if (troopInfoFromCache != null) {
            j3 = troopInfoFromCache.dwGagTimeStamp;
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoGagInfoUpdateProcessor", 2, "checkGagTime: curTimeStamp=" + serverTime + ", troopGagTime=" + j3);
        }
        if (j3 > 0 && j3 > serverTime) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean a(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return ITroopMemberInfoUpdateProcessor.a.c(this, str);
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    @NotNull
    public ITroopMemberInfoUpdateProcessor.Strategy b(@NotNull String groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITroopMemberInfoUpdateProcessor.Strategy) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupCode);
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Map<String, Boolean> map = f300214b;
        Boolean bool = map.get(groupCode);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return ITroopMemberInfoUpdateProcessor.Strategy.NONE;
        }
        boolean h16 = h(groupCode);
        if (!h16) {
            map.put(groupCode, bool2);
        }
        if (h16) {
            return ITroopMemberInfoUpdateProcessor.Strategy.NET;
        }
        return ITroopMemberInfoUpdateProcessor.Strategy.NONE;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean c(@NotNull String groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) groupCode)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Map<String, Boolean> map = f300215c;
        Boolean bool = map.get(groupCode);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return false;
        }
        boolean h16 = h(groupCode);
        if (!h16) {
            map.put(groupCode, bool2);
        }
        return h16;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void d(@NotNull String str, boolean z16, @NotNull List<? extends TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), list);
        } else {
            ITroopMemberInfoUpdateProcessor.a.f(this, str, z16, list);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void e(@NotNull String groupCode, boolean fromNet, boolean isSuccess, @NotNull List<String> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, groupCode, Boolean.valueOf(fromNet), Boolean.valueOf(isSuccess), uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (isSuccess && fromNet) {
            f300214b.put(groupCode, Boolean.TRUE);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            ITroopMemberInfoUpdateProcessor.a.a(this, str);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void g(@NotNull String groupCode, boolean isSuccess, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, groupCode, Boolean.valueOf(isSuccess), uin);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        if (isSuccess) {
            f300215c.put(groupCode, Boolean.TRUE);
        }
    }
}
