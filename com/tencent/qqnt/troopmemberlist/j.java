package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.state.data.SquareJSConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/j;", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "", "groupCode", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor$Strategy;", "b", "", "fromNet", "isSuccess", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "e", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class j implements ITroopMemberInfoUpdateProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.j$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean a(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return ITroopMemberInfoUpdateProcessor.a.c(this, str);
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    @NotNull
    public ITroopMemberInfoUpdateProcessor.Strategy b(@NotNull String groupCode) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITroopMemberInfoUpdateProcessor.Strategy) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupCode);
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(groupCode);
        if (troopInfoFromCache != null) {
            str = troopInfoFromCache.Administrator;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return ITroopMemberInfoUpdateProcessor.Strategy.DB;
        }
        return ITroopMemberInfoUpdateProcessor.Strategy.NONE;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean c(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return ITroopMemberInfoUpdateProcessor.a.d(this, str);
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void d(@NotNull String str, boolean z16, @NotNull List<? extends TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), list);
        } else {
            ITroopMemberInfoUpdateProcessor.a.f(this, str, z16, list);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void e(@NotNull String groupCode, boolean fromNet, boolean isSuccess, @NotNull List<String> uinList) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupCode, Boolean.valueOf(fromNet), Boolean.valueOf(isSuccess), uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (!uinList.isEmpty()) {
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(groupCode);
            StringBuilder sb5 = new StringBuilder();
            Iterator<T> it = uinList.iterator();
            while (it.hasNext()) {
                sb5.append((String) it.next());
                sb5.append("|");
            }
            sb5.deleteCharAt(sb5.length() - 1);
            if (troopInfoFromCache != null) {
                troopInfoFromCache.Administrator = sb5.toString();
            }
            if (QLog.isColorLevel()) {
                if (troopInfoFromCache != null) {
                    str = troopInfoFromCache.Administrator;
                } else {
                    str = null;
                }
                QLog.d("TroopInfoAdminUpdateProcessor", 2, "onUpdateTroopAdminUin: admins=" + str);
            }
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            ITroopMemberInfoUpdateProcessor.a.a(this, str);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void g(@NotNull String str, boolean z16, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), str2);
        } else {
            ITroopMemberInfoUpdateProcessor.a.g(this, str, z16, str2);
        }
    }
}
