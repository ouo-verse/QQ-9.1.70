package com.tencent.mobileqq.troop.troopcard.utils;

import android.content.Context;
import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/d;", "Lcom/tencent/mobileqq/utils/ax;", "", UserInfo.SEX_FEMALE, "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.utils.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r0 != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void F() {
        boolean z16;
        String str;
        TroopInfo findTroopInfo;
        String f16;
        long j3;
        Long longOrNull;
        boolean isBlank;
        boolean isBlank2;
        String str2 = this.f307441f.get("troop_uin");
        boolean z17 = false;
        if (str2 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    str2 = this.f307441f.get("group_id");
                }
                str = str2;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                }
                z17 = true;
                if (!z17 || (findTroopInfo = ((ITroopInfoService) this.f307436a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str)) == null) {
                    return;
                }
                Bundle c16 = aq.c(str, 3, findTroopInfo.troopLat, findTroopInfo.troopLon, 0, findTroopInfo.strLocation);
                Intrinsics.checkNotNullExpressionValue(c16, "getTroopProfileExtra(\n  \u20260, troopInfo.strLocation)");
                c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, findTroopInfo.troopTypeExt);
                c16.putInt("PARAM_EXIT_ANIMATION", 2);
                f16 = f("nid");
                if (f16 == null && longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = -1;
                }
                c16.putLong("nid", j3);
                ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this.f307437b, c16);
            }
        }
        z16 = true;
        if (z16) {
        }
        str = str2;
        if (str != null) {
        }
        z17 = true;
        if (!z17) {
            return;
        }
        Bundle c162 = aq.c(str, 3, findTroopInfo.troopLat, findTroopInfo.troopLon, 0, findTroopInfo.strLocation);
        Intrinsics.checkNotNullExpressionValue(c162, "getTroopProfileExtra(\n  \u20260, troopInfo.strLocation)");
        c162.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, findTroopInfo.troopTypeExt);
        c162.putInt("PARAM_EXIT_ANIMATION", 2);
        f16 = f("nid");
        if (f16 == null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(f16);
        }
        j3 = -1;
        c162.putLong("nid", j3);
        ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this.f307437b, c162);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("TroopInfoActivityJumpAction", 1, "[doAction] attrs = " + this.f307441f);
        F();
        return true;
    }
}
