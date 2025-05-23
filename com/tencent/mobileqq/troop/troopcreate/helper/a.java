package com.tencent.mobileqq.troop.troopcreate.helper;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su3.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "a", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/aio/data/AIOParam;", "f", "Lcom/tencent/aio/data/AIOParam;", "mAIOParam", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", h.F, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "mTroopShareUtility", "<init>", "()V", "i", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class a implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOParam mAIOParam;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ITroopShareUtility mTroopShareUtility;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/helper/a$a;", "", "", "KEY_FROM_WEB_CREATION", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.helper.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        AIOParam aIOParam = this.mAIOParam;
        QBaseActivity qBaseActivity = null;
        if (aIOParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOParam");
            aIOParam = null;
        }
        if (!aIOParam.l().getBoolean("fromWebCreation", false) || !((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).isNewCreateTroopExperiment()) {
            return;
        }
        QLog.d("TroopAIOShareHelper", 1, "showShareActionSheet");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ITroopInfoRepoApi iTroopInfoRepoApi = (ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class);
            AIOParam aIOParam2 = this.mAIOParam;
            if (aIOParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOParam");
                aIOParam2 = null;
            }
            TroopInfo troopInfoFromCache = iTroopInfoRepoApi.getTroopInfoFromCache(c.b(aIOParam2));
            TroopInfoData troopInfoData = new TroopInfoData();
            troopInfoData.updateForTroopInfo(troopInfoFromCache, peekAppRuntime.getCurrentAccountUin());
            troopInfoData.isMember = true;
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            FragmentActivity activity2 = aVar2.c().getActivity();
            if (activity2 instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity2;
            }
            if (qBaseActivity == null) {
                return;
            }
            if (((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard")) {
                TroopSettingShareManager.INSTANCE.a().F(new com.tencent.mobileqq.troop.troopsetting.share.b(qBaseActivity, troopInfoData), "group_idcard");
                return;
            }
            ITroopShareUtility iTroopShareUtility = (ITroopShareUtility) QRoute.api(ITroopShareUtility.class);
            this.mTroopShareUtility = iTroopShareUtility;
            if (iTroopShareUtility != null) {
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                iTroopShareUtility.troopUtils_shareTroopFromAIO(activity, troopInfoData, (AppInterface) peekAppRuntime);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.E1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAIOShareHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{4, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mHelperParam = param;
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mAIOParam = g16;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        ITroopShareUtility iTroopShareUtility;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
            return;
        }
        if (state != 4) {
            if (state == 12 && (iTroopShareUtility = this.mTroopShareUtility) != null && iTroopShareUtility != null) {
                iTroopShareUtility.onDestroy();
                return;
            }
            return;
        }
        a();
    }
}
