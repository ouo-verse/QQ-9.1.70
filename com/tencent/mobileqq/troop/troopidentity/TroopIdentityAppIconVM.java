package com.tencent.mobileqq.troop.troopidentity;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtilKt;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u00014\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020$0(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "", "", "R1", "Landroid/os/Bundle;", "bundle", "", "init", "", "isSet", "U1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getLogTag", "i", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "memberUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "P1", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "setAppIconInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;)V", "appIconInfo", "D", "Z", "tmpNewAppSwitch", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "E", "Landroidx/lifecycle/MutableLiveData;", "_uiState", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "uiStateLiveData", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "G", "Lkotlin/Lazy;", "Q1", "()Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "dtReporter", "com/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM$b", "H", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM$b;", "gameSwitchObserver", "<init>", "()V", "I", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityAppIconVM extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GroupIdentityAppTag appIconInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean tmpNewAppSwitch;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> _uiState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> uiStateLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy dtReporter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b gameSwitchObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String memberUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppIconVM$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM$b", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "uin", "errCode", "", "errInfo", "", "onModifyMemberGameCardSwitch", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityAppIconVM.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onModifyMemberGameCardSwitch(boolean isSuccess, long uin, long errCode, @NotNull String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin), Long.valueOf(errCode), errInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(errInfo, "errInfo");
            QLog.i("TroopIdentityAppIconVM", 1, "[onModifyMemberGameCardSwitch] isSuccess = " + isSuccess + " uin = " + uin + " errCode = " + errCode + " newAppSwitch = " + TroopIdentityAppIconVM.this.tmpNewAppSwitch);
            if (Intrinsics.areEqual(TroopIdentityAppIconVM.this.S1(), String.valueOf(uin)) && isSuccess) {
                GroupIdentityAppTag P1 = TroopIdentityAppIconVM.this.P1();
                if (P1 != null) {
                    TroopIdentityAppIconVM troopIdentityAppIconVM = TroopIdentityAppIconVM.this;
                    P1.status = troopIdentityAppIconVM.tmpNewAppSwitch;
                    troopIdentityAppIconVM._uiState.postValue(new c.a(troopIdentityAppIconVM.tmpNewAppSwitch, P1));
                }
                com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c identityDataFromCacheOrFetchAsync = ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getIdentityDataFromCacheOrFetchAsync(TroopIdentityAppIconVM.this.S1(), TroopIdentityAppIconVM.this.memberUin);
                TroopIdentityAppIconVM troopIdentityAppIconVM2 = TroopIdentityAppIconVM.this;
                ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).sendAppIconBindDataUpdateEvent(troopIdentityAppIconVM2.S1(), troopIdentityAppIconVM2.memberUin, identityDataFromCacheOrFetchAsync);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityAppIconVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.memberUin = "";
        MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> mutableLiveData = new MutableLiveData<>();
        this._uiState = mutableLiveData;
        this.uiStateLiveData = mutableLiveData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.troopidentity.util.a>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppIconVM$dtReporter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopIdentityAppIconVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.troopidentity.util.a invoke() {
                Map R1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                R1 = TroopIdentityAppIconVM.this.R1();
                return new com.tencent.mobileqq.troop.troopidentity.util.a("pg_group_app_identity", R1);
            }
        });
        this.dtReporter = lazy;
        this.gameSwitchObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> R1() {
        String str;
        AppRuntime peekAppRuntime;
        String str2 = this.memberUin;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        return com.tencent.mobileqq.troop.troopidentity.util.a.INSTANCE.a(this.troopUin, Intrinsics.areEqual(str2, str));
    }

    @Nullable
    public final GroupIdentityAppTag P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GroupIdentityAppTag) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appIconInfo;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopidentity.util.a Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (com.tencent.mobileqq.troop.troopidentity.util.a) this.dtReporter.getValue();
    }

    @NotNull
    public final String S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.uiStateLiveData;
    }

    public final void U1(boolean isSet) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isSet);
            return;
        }
        int i3 = 0;
        com.tencent.mobileqq.troop.troopgame.api.a aVar = null;
        if (TroopIdentityHonorUtil.h(TroopIdentityHonorUtil.f300410a, false, 1, null)) {
            return;
        }
        this.tmpNewAppSwitch = isSet;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(TroopGameHandler.class.getName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
        }
        if (aVar == null) {
            return;
        }
        String str = this.troopUin;
        if (!isSet) {
            i3 = 64;
        }
        aVar.R0(str, 64, i3);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "TroopIdentityAppIconVM";
    }

    public final void init(@NotNull Bundle bundle) {
        GroupIdentityAppTag groupIdentityAppTag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AppConstants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        String string2 = bundle.getString("member_uin", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(TroopId\u2026nFragment.MEMBER_UIN, \"\")");
        this.memberUin = string2;
        Serializable serializable = bundle.getSerializable("identity_app_icon_info");
        AppInterface appInterface = null;
        if (serializable instanceof GroupIdentityAppTag) {
            groupIdentityAppTag = (GroupIdentityAppTag) serializable;
        } else {
            groupIdentityAppTag = null;
        }
        this.appIconInfo = groupIdentityAppTag;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.gameSwitchObserver);
        }
        QLog.i("TroopIdentityAppIconVM", 1, "[init] troopUin = " + this.troopUin + " memberUin = " + this.memberUin + " appIconInfo = " + TroopIdentityHonorUtilKt.b(this.appIconInfo));
    }

    public final void onDestroy() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.gameSwitchObserver);
        }
    }
}
