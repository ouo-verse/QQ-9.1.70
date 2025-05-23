package com.tencent.qqnt.troop.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler;
import com.tencent.mobileqq.troop.troopgag.data.e;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopGagUtils;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J.\u0010\u0018\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\nH\u0016J\u0012\u0010)\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010*\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010+\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010,\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010-\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010.\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopGagUtils;", "Lcom/tencent/qqnt/troop/ITroopGagUtils;", "", "getMyUin", "", "gagTime", "gagTimeToStringCountDown", "remainingTime", "remainingTimeToStringCountDown", "troopUin", "", "isFirst", "", "notifySelfGagInfoChange", "notifyTroopGagInfoChange", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "notifyGagStatusUI", "Landroidx/lifecycle/LifecycleOwner;", "owner", "forceNet", "Lfs2/a;", "callback", "innerFetchMemberInfo", "getTroopOwnerReportStr", "Lcom/tencent/mobileqq/troop/troopgag/data/d;", "getSelfGagInfo", "Lcom/tencent/mobileqq/troop/troopgag/data/e;", "getTroopGagInfo", "transformGagTimeForSettingUI", "isMySelfSilent", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "onPushTroopGagMsg", "onPushMeGagMsg", "onPushOtherMemberGagMsg", "", "resId", "bSucceed", "showTipsToast", "isAdmin", "isOwner", "clearMySelfGagInfo", "fetchGagListFromNet", "fetchGagListWithMemberInfoFromNet", "fetchGagListFromDB", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopGagUtils implements ITroopGagUtils {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TroopGagUtils INSTANCE;

    @NotNull
    private static final String TAG = "TroopGagUtilsImpl";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new TroopGagUtils();
        }
    }

    TroopGagUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String gagTimeToStringCountDown(long gagTime) {
        long j3;
        long serverTime = NetConnInfoCenter.getServerTime();
        if (gagTime <= serverTime) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "error: gagTimeToStringCountDown gagTime <= currentTimeMs");
            }
            j3 = 0;
        } else {
            j3 = gagTime - serverTime;
        }
        return remainingTimeToStringCountDown(j3);
    }

    private final String getMyUin() {
        String str;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void innerFetchMemberInfo(String troopUin, LifecycleOwner owner, boolean forceNet, final fs2.a callback) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchGagTroopMemberInfo(troopUin, owner, forceNet, TAG, new f() { // from class: com.tencent.qqnt.troop.impl.c
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                TroopGagUtils.innerFetchMemberInfo$lambda$2(fs2.a.this, z16, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerFetchMemberInfo$lambda$2(fs2.a aVar, boolean z16, List troopMemberList) {
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (aVar != null) {
            if (z16) {
                aVar.onResult(troopMemberList);
            } else {
                QLog.e(TAG, 2, "innerFetchMemberInfo: fetchGagTroopMemberInfo error");
                aVar.onResult(new ArrayList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyGagStatusUI(String troopUin, List<? extends TroopMemberInfo> troopMemberList) {
        BusinessHandler businessHandler;
        AppInterface e16 = bg.e();
        com.tencent.mobileqq.troop.troopgag.api.a aVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopGagHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgag.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgag.api.a) businessHandler;
        }
        if (aVar != null) {
            aVar.C(new com.tencent.mobileqq.troop.troopgag.data.a(troopUin, (List<TroopMemberInfo>) troopMemberList));
        }
    }

    private final void notifySelfGagInfoChange(String troopUin, boolean isFirst) {
        BusinessHandler businessHandler;
        AppInterface e16 = bg.e();
        com.tencent.mobileqq.troop.troopgag.api.a aVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopGagHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgag.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgag.api.a) businessHandler;
        }
        if (aVar != null) {
            aVar.C(new com.tencent.mobileqq.troop.troopgag.data.a(troopUin, getSelfGagInfo(troopUin, isFirst)));
        }
    }

    private final void notifyTroopGagInfoChange(String troopUin) {
        BusinessHandler businessHandler;
        AppInterface e16 = bg.e();
        com.tencent.mobileqq.troop.troopgag.api.a aVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopGagHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgag.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgag.api.a) businessHandler;
        }
        if (aVar != null) {
            aVar.C(new com.tencent.mobileqq.troop.troopgag.data.a(troopUin, getTroopGagInfo(troopUin)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPushOtherMemberGagMsg$lambda$0(String troopUin, List gagMemberList) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(gagMemberList, "gagMemberList");
        INSTANCE.notifyGagStatusUI(troopUin, gagMemberList);
    }

    private final String remainingTimeToStringCountDown(long remainingTime) {
        long roundToLong;
        long roundToLong2;
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return "";
        }
        String string = baseApplication.getString(R.string.emx);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026p_gag_time_format_minute)");
        String string2 = baseApplication.getString(R.string.emw);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026oop_gag_time_format_hour)");
        String string3 = baseApplication.getString(R.string.emv);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026roop_gag_time_format_day)");
        String format = HardCodeUtil.qqStr(R.string.ugd);
        if (remainingTime < 60) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(format, "format");
            String format2 = String.format(format, Arrays.copyOf(new Object[]{1, string}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        if (remainingTime <= 3540) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(format, "format");
            String format3 = String.format(format, Arrays.copyOf(new Object[]{Long.valueOf((remainingTime + 57) / 60), string}, 2));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        if (remainingTime <= 84600) {
            roundToLong2 = MathKt__MathJVMKt.roundToLong((((float) remainingTime) * 1.0f) / 3600);
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(format, "format");
            String format4 = String.format(format, Arrays.copyOf(new Object[]{Long.valueOf(roundToLong2), string2}, 2));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            return format4;
        }
        roundToLong = MathKt__MathJVMKt.roundToLong((((float) remainingTime) * 1.0f) / 86400);
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(format, "format");
        String format5 = String.format(format, Arrays.copyOf(new Object[]{Long.valueOf(roundToLong), string3}, 2));
        Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
        return format5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTipsToast$lambda$1(boolean z16, Context context, String text, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(text, "$text");
        if (z16) {
            QQToast.makeText(context, 2, text, 0).show(i3);
        } else {
            QQToast.makeText(context, R.drawable.f160605la, text, 0).show(i3);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void clearMySelfGagInfo(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) troopUin);
            return;
        }
        if (troopUin == null) {
            return;
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null) {
            troopInfoFromCache.dwGagTimeStamp = 0L;
        }
        if (troopInfoFromCache != null) {
            troopInfoFromCache.dwGagTimeStamp_me = 0L;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListFromDB(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, owner, callback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchGagListFromDB: troopUin=" + troopUin);
        }
        innerFetchMemberInfo(troopUin, owner, false, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) troopUin, (Object) owner);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchGagListFromNet: troopUin=" + troopUin);
        }
        if (troopUin == null) {
            return;
        }
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberGapInfo(troopUin, owner, new TroopGagUtils$fetchGagListFromNet$1(troopUin, owner));
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListWithMemberInfoFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, owner, callback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchGagListWithMemberInfoFromNet: troopUin=" + troopUin);
        }
        innerFetchMemberInfo(troopUin, owner, true, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public com.tencent.mobileqq.troop.troopgag.data.d getSelfGagInfo(@Nullable String troopUin, boolean isFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.troopgag.data.d) iPatchRedirector.redirect((short) 3, this, troopUin, Boolean.valueOf(isFirst));
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null && troopUin != null) {
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            long serverTime = NetConnInfoCenter.getServerTime();
            boolean isAdmin = isAdmin(troopUin);
            if (troopInfoFromCache == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "getTroopGagInfo:troopUin=" + troopUin + ", troopInfo is null");
                }
                return new com.tencent.mobileqq.troop.troopgag.data.d(troopUin, false, "", 0L);
            }
            if (troopInfoFromCache.dwGagTimeStamp != 0 && !isAdmin) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "getTroopGagInfo:troopUin=" + troopUin + ", Troop Gag");
                }
                String string = baseApplication.getString(R.string.ei8);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026qb_troop_all_memeber_gag)");
                return new com.tencent.mobileqq.troop.troopgag.data.d(troopUin, true, string, 60L);
            }
            long j3 = troopInfoFromCache.dwGagTimeStamp_me;
            if (j3 != 0) {
                long j16 = 3;
                if (serverTime < j3 + j16) {
                    QLog.d(TAG, 1, "fightgag.getSelfGagInfo:troopUin= " + troopUin + ",dwGagTimeStamp_me = " + j3 + ",lCutTimeStamp  = " + serverTime);
                    String string2 = baseApplication.getString(R.string.f171419ev2);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.qb_troop_self_gag)");
                    long j17 = troopInfoFromCache.dwGagTimeStamp_me;
                    long j18 = j16 + j17;
                    if (isFirst) {
                        j18 = j17 - 30;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(string2, Arrays.copyOf(new Object[]{gagTimeToStringCountDown(j18)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    return new com.tencent.mobileqq.troop.troopgag.data.d(troopUin, true, format, 60L);
                }
            }
            return new com.tencent.mobileqq.troop.troopgag.data.d(troopUin, false, "", 0L);
        }
        QLog.e(TAG, 1, "getSelfGagInfo troopInfo is null. troopUin=" + troopUin);
        return new com.tencent.mobileqq.troop.troopgag.data.d(troopUin, false, "", 0L);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public e getTroopGagInfo(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        }
        long j3 = 0;
        if (BaseApplication.context != null && troopUin != null) {
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                j3 = troopInfoFromCache.dwGagTimeStamp;
            }
            return new e(troopUin, j3);
        }
        QLog.e(TAG, 1, "getSelfGagInfo troopInfo is null");
        return new e(troopUin, 0L);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public String getTroopOwnerReportStr(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        if (troopUin == null) {
            return "";
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        boolean z16 = false;
        if (troopInfoFromCache != null && troopInfoFromCache.isTroopOwner(getMyUin())) {
            z16 = true;
        }
        if (z16) {
            return "1";
        }
        return "2";
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isAdmin(@Nullable String troopUin) {
        TroopInfo troopInfoFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin)).booleanValue();
        }
        if (troopUin == null || (troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin)) == null) {
            return false;
        }
        return troopInfoFromCache.isOwnerOrAdmin();
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isMySelfSilent(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin)).booleanValue();
        }
        return getSelfGagInfo(troopUin, false).f300235b;
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isOwner(@Nullable String troopUin) {
        TroopInfo troopInfoFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopUin)).booleanValue();
        }
        if (troopUin == null || (troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin)) == null) {
            return false;
        }
        return troopInfoFromCache.isOwner();
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushMeGagMsg(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        if (bg.e() != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPushMeGagMsg: ");
            }
            notifySelfGagInfoChange(troopInfo.getTroopUin(), true);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushOtherMemberGagMsg(@NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            fetchGagListFromDB(troopUin, null, new fs2.a() { // from class: com.tencent.qqnt.troop.impl.b
                @Override // fs2.a
                public final void onResult(List list) {
                    TroopGagUtils.onPushOtherMemberGagMsg$lambda$0(troopUin, list);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushTroopGagMsg(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        AppInterface e16 = bg.e();
        if (e16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPushTroopGagMsg: troopUin=" + troopInfo.troopuin);
            }
            e16.getCurrentUin();
            String str = troopInfo.troopuin;
            Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
            notifyTroopGagInfoChange(str);
            notifySelfGagInfoChange(troopInfo.getTroopUin(), true);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void showTipsToast(int resId, final boolean bSucceed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(resId), Boolean.valueOf(bSucceed));
            return;
        }
        final BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return;
        }
        final String string = baseApplication.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        final int dimensionPixelSize = baseApplication.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopGagUtils.showTipsToast$lambda$1(bSucceed, baseApplication, string, dimensionPixelSize);
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public String transformGagTimeForSettingUI(long gagTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, gagTime);
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return "";
        }
        String string = baseApplication.getString(R.string.erf);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qb_troop_mgr_gag_time)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(string, Arrays.copyOf(new Object[]{gagTimeToStringCountDown(gagTime)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
