package com.tencent.mobileqq.troop.troopsquare.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopsquare.aio.helper.TroopSquareAIOHelper;
import com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi;
import com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareHomeFragment;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSquareRedpointInfoCallback;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/api/impl/TroopSquareApiImpl;", "Lcom/tencent/mobileqq/troop/troopsquare/api/ITroopSquareApi;", "", "troopClass", "", "isTroopClassHitConfig", "troopUin", "isSwitchOn", "Lcom/tencent/aio/main/businesshelper/h;", "createAIOHelper", "ext", "", "openSquarePage", "", "groupCode", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSquareRedpointInfoRsp;", "callback", "getGroupSquareRedpoint", "Ljava/lang/Class;", "getParserClass", "()Ljava/lang/Class;", "parserClass", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareApiImpl implements ITroopSquareApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopSquare.TroopSquareApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/api/impl/TroopSquareApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.api.impl.TroopSquareApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGroupSquareRedpoint$lambda$1(Function1 callback, int i3, String str, GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0 && getGroupSquareRedpointInfoRsp != null) {
            callback.invoke(getGroupSquareRedpointInfoRsp);
            return;
        }
        QLog.e(TAG, 1, "getGroupSquareRedpointInfo failed: errCode=" + i3 + " errMsg=" + str + " result=" + getGroupSquareRedpointInfoRsp);
    }

    private final boolean isTroopClassHitConfig(String troopClass) {
        return com.tencent.mobileqq.troop.troopsquare.common.a.INSTANCE.a().a().contains(troopClass);
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi
    @NotNull
    public h createAIOHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (h) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new TroopSquareAIOHelper();
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi
    public void getGroupSquareRedpoint(long groupCode, @NotNull final Function1<? super GetGroupSquareRedpointInfoRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(groupCode), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.e(TAG, 1, "getGroupSquareRedpointInfo failed: network invalid");
                callback.invoke(null);
            }
            s i3 = bg.i(null, 1, null);
            if (i3 == null) {
                QLog.e(TAG, 1, "getGroupSquareRedpointInfo failed: service == null");
                callback.invoke(null);
            }
            GetGroupSquareRedpointInfoReq getGroupSquareRedpointInfoReq = new GetGroupSquareRedpointInfoReq();
            getGroupSquareRedpointInfoReq.groupCode = groupCode;
            if (i3 != null) {
                i3.getGroupSquareRedpointInfo(getGroupSquareRedpointInfoReq, false, new IGetGroupSquareRedpointInfoCallback() { // from class: com.tencent.mobileqq.troop.troopsquare.api.impl.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSquareRedpointInfoCallback
                    public final void onResult(int i16, String str, GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
                        TroopSquareApiImpl.getGroupSquareRedpoint$lambda$1(Function1.this, i16, str, getGroupSquareRedpointInfoRsp);
                    }
                });
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getGroupSquareRedpointInfo exception: e=" + th5);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi
    @NotNull
    public Class<?> getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopsquare.topic.a.class;
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi
    public boolean isSwitchOn(@NotNull String troopUin) {
        Integer num;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null || troopInfoFromCache.isExited()) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102762", false);
        GroupExt groupExt = troopInfoFromCache.groupExt;
        Integer num2 = null;
        if (groupExt != null) {
            num = Integer.valueOf(groupExt.groupSquareSwitch);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            z16 = isTroopClassHitConfig(String.valueOf(troopInfoFromCache.dwGroupClassExt));
        } else if (num != null && num.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GroupExt groupExt2 = troopInfoFromCache.groupExt;
        if (groupExt2 != null) {
            num2 = Integer.valueOf(groupExt2.groupSquareSwitch);
        }
        QLog.i(TAG, 1, "isSwitchOn, " + troopUin + " mainSwitchOn:" + isSwitchOn + ", switchState:" + num2 + " childSwitchOn:" + z16);
        if (!isSwitchOn || !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi
    public void openSquarePage(@NotNull String troopUin, @NotNull String ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) ext);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(ext, "ext");
        TroopSquareHomeFragment.Companion companion = TroopSquareHomeFragment.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.a(context, troopUin, ext);
    }
}
