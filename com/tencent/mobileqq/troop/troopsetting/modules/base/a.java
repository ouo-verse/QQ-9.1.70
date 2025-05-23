package com.tencent.mobileqq.troop.troopsetting.modules.base;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0016\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0018\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u000e\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/a;", "", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "", "ntTroopName", "b", "a", "c", "d", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301141a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301141a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable TroopInfoData troopInfoData, @NotNull String ntTroopName) {
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.kh8);
        if (troopInfoData != null && troopInfoData.hasSetNewTroopName) {
            return c(troopInfoData, ntTroopName);
        }
        Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
        return fallbackName;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(@Nullable TroopInfoData troopInfoData, @NotNull String ntTroopName) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.khr);
        if (troopInfoData == null) {
            Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
            return fallbackName;
        }
        String str = troopInfoData.remark;
        boolean z19 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str2 = troopInfoData.remark;
            Intrinsics.checkNotNullExpressionValue(str2, "this.remark");
            return str2;
        }
        if (ntTroopName.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ntTroopName = troopInfoData.troopName;
        }
        if (ntTroopName != null) {
            if (ntTroopName.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                ntTroopName = troopInfoData.newTroopName;
            }
            if (ntTroopName != null) {
                if (ntTroopName.length() == 0) {
                    z19 = true;
                }
                if (z19) {
                    ntTroopName = fallbackName;
                }
                if (ntTroopName != null) {
                    Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
                    return fallbackName;
                }
                return ntTroopName;
            }
        }
        ntTroopName = null;
        if (ntTroopName != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String c(@Nullable TroopInfoData troopInfoData, @NotNull String ntTroopName) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        String fallbackName = HardCodeUtil.qqStr(R.string.kh8);
        if (troopInfoData == null) {
            Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
            return fallbackName;
        }
        boolean z18 = true;
        if (ntTroopName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ntTroopName = troopInfoData.troopName;
        }
        if (ntTroopName != null) {
            if (ntTroopName.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                ntTroopName = troopInfoData.newTroopName;
            }
            if (ntTroopName != null) {
                if (ntTroopName.length() != 0) {
                    z18 = false;
                }
                if (z18) {
                    ntTroopName = fallbackName;
                }
                if (ntTroopName != null) {
                    Intrinsics.checkNotNullExpressionValue(fallbackName, "fallbackName");
                    return fallbackName;
                }
                return ntTroopName;
            }
        }
        ntTroopName = null;
        if (ntTroopName != null) {
        }
    }

    @JvmStatic
    @NotNull
    public static final String d(@Nullable TroopInfoData troopInfoData) {
        boolean z16;
        String str = "";
        if (troopInfoData == null) {
            return "";
        }
        String str2 = troopInfoData.troopUin;
        if (str2 != null) {
            str = str2;
        }
        String troopName = troopInfoData.troopName;
        if (troopName != null && troopName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return str;
        }
        Intrinsics.checkNotNullExpressionValue(troopName, "troopName");
        return troopName;
    }
}
