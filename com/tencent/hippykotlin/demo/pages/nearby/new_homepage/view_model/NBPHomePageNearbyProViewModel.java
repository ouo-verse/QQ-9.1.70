package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$requestOpenID$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import f35.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPHomePageNearbyProViewModel extends NBPHomePageBaseViewModel {
    public int appId;

    public NBPHomePageNearbyProViewModel(boolean z16) {
        super(z16);
        this.appId = 2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void addFriend(final Function0<Unit> function0, final Function0<Unit> function02) {
        String str = this.accountId;
        Function1<d, Unit> function1 = new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageNearbyProViewModel$addFriend$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(d dVar) {
                d dVar2 = dVar;
                Function0<Unit> function03 = function0;
                if (function03 != null) {
                    function03.invoke();
                }
                if (dVar2 == null) {
                    KLog.INSTANCE.e("NBPHomePageNearbyProViewModel", "requestOpenID failed, rspModel is null");
                } else if (dVar2.f397794f) {
                    Utils.INSTANCE.currentBridgeModule().qToast("\u5bf9\u65b9\u5df2\u7ecf\u662f\u597d\u53cb", QToastMode.Info);
                } else {
                    QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                    String str2 = dVar2.f397793e;
                    String str3 = this.getSelfBaseInfo().nick;
                    if (str3 == null) {
                        str3 = "";
                    }
                    companion.enterAddFriendPage(str2, str3);
                }
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageNearbyProViewModel$addFriend$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                String str3 = str2;
                Function0<Unit> function03 = function02;
                if (function03 != null) {
                    function03.invoke();
                }
                KLog.INSTANCE.e("NBPHomePageNearbyProViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestOpenID failed, errorCode: ", intValue, ", errorMsg: ", str3));
                Utils.INSTANCE.currentBridgeModule().qToast("\u6dfb\u52a0\u597d\u53cb\u5931\u8d25", QToastMode.Warning);
                return Unit.INSTANCE;
            }
        };
        NBPNewHomeRepository.GetOpenIDRequest getOpenIDRequest = new NBPNewHomeRepository.GetOpenIDRequest(Long.parseLong(str));
        NBPNewHomeRepository$requestOpenID$1 nBPNewHomeRepository$requestOpenID$1 = new NBPNewHomeRepository$requestOpenID$1(function1, function2);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoGetOpenId");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getOpenIDRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPNewHomeRepository$requestOpenID$1), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final UserSelfBaseInfo getSelfBaseInfo() {
        int i3 = this.appId;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        return new UserSelfBaseInfo(i3, String.valueOf(userDataManager.getUserSelfInfo().tid), userDataManager.getUserSelfInfo().nickName, userDataManager.getUserSelfInfo().avatarUrl);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void openAio(e eVar, int i3) {
        String str;
        String str2;
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        String str3 = this.accountId;
        af userInfo = getUserInfo();
        if (userInfo == null || (str = userInfo.f433209f) == null) {
            str = "0";
        }
        af userInfo2 = getUserInfo();
        if (userInfo2 == null || (str2 = userInfo2.f433204c0) == null) {
            str2 = "0";
        }
        companion.openGreetingPage(str3, str, str2, 20, i3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void openMyTacit() {
        NBPJumpUtil.jumpPersonaPage$default(this.appId, String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid), true, true, HomepageSource.TACIT_WRITE, null, 32);
    }
}
