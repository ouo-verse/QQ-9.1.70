package com.tencent.mobileqq.troop.troopsetting.modules.base;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0016\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\t\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\n\u0010\u000b\u001a\u00020\n*\u00020\u0002J\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f*\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/b;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "d", "", "ntTroopName", "c", "b", "e", "", "f", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f301142a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f301142a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String b(@Nullable TroopInfo troopInfo, @NotNull String ntTroopName) {
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.kh8);
        if (troopInfo != null && troopInfo.hasSetTroopName()) {
            return e(troopInfo, ntTroopName);
        }
        Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
        return fallbackName;
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable TroopInfo troopInfo, @NotNull String ntTroopName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.khr);
        if (troopInfo == null) {
            Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
            return fallbackName;
        }
        String troopDisplayName = troopInfo.getTroopDisplayName();
        if (troopDisplayName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return troopDisplayName;
        }
        return ntTroopName;
    }

    @JvmStatic
    @NotNull
    public static final TroopSearchWay d(@NotNull TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(troopInfo, "<this>");
        TroopSearchWay troopSearchWay = TroopSearchWay.PRIVATE;
        boolean z16 = troopInfo.mCanSearchByKeywords;
        if (z16 || troopInfo.mCanSearchByTroopUin) {
            boolean z17 = troopInfo.mCanSearchByTroopUin;
            if (z17 && z16) {
                return TroopSearchWay.PUBLIC_UIN_AND_KEYWORD;
            }
            if (z17) {
                return TroopSearchWay.PUBLIC_UIN;
            }
            return troopSearchWay;
        }
        return troopSearchWay;
    }

    @JvmStatic
    @NotNull
    public static final String e(@Nullable TroopInfo troopInfo, @NotNull String ntTroopName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.kh8);
        if (troopInfo == null) {
            Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
            return fallbackName;
        }
        if (ntTroopName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
            return fallbackName;
        }
        return ntTroopName;
    }

    @NotNull
    public final List<String> a(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
        }
        Intrinsics.checkNotNullParameter(troopInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        List<String> tags = TroopInfo.getTags(troopInfo.mTags);
        if (tags == null) {
            tags = CollectionsKt__CollectionsKt.emptyList();
        }
        for (String tag : tags) {
            Intrinsics.checkNotNullExpressionValue(tag, "tag");
            arrayList.add(tag);
        }
        return arrayList;
    }

    public final boolean f(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopInfo, "<this>");
        if (troopInfo.checkFlagExt4(3) && !troopInfo.checkFreezeReason(2) && !troopInfo.isQidianPrivateTroop()) {
            return true;
        }
        return false;
    }
}
