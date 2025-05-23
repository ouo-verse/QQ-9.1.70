package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar$body$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPHomePageMatchFriendViewModel extends NBPHomePageBaseViewModel {
    public int appId;

    public NBPHomePageMatchFriendViewModel(boolean z16) {
        super(z16);
        this.appId = 1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void addFriend(Function0<Unit> function0, Function0<Unit> function02) {
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        String str = this.accountId;
        String str2 = getSelfBaseInfo().nick;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.sourceId;
        companion.getClass();
        e eVar = new e();
        eVar.v("openId", str);
        eVar.v("sourceId", str3);
        eVar.v("nick", str2);
        Unit unit = Unit.INSTANCE;
        companion.asyncToNativeMethod("enterAddMatchFriendPage", eVar, (Function1<? super e, Unit>) null);
        ((NBPBottomBar$body$1.AnonymousClass3.AnonymousClass1.C33803.C33811.C33821) function0).invoke();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final int getAccountType() {
        return 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final UserSelfBaseInfo getSelfBaseInfo() {
        if (this.isSelf) {
            int i3 = this.appId;
            af userInfo = getUserInfo();
            String str = userInfo != null ? userInfo.f433205d : null;
            af userInfo2 = getUserInfo();
            String str2 = userInfo2 != null ? userInfo2.f433209f : null;
            af userInfo3 = getUserInfo();
            return new UserSelfBaseInfo(i3, str, str2, userInfo3 != null ? userInfo3.E : null);
        }
        return QQNearbyModule.Companion.getInstance().getMatchFriendBaseInfo();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void openAio(e eVar, int i3) {
        String q16 = eVar.q("trace_id", "");
        String q17 = eVar.q("source_id", "");
        int k3 = eVar.k("from_id", 0);
        String q18 = eVar.q("feed_id", "");
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        String str = this.accountId;
        companion.getClass();
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder a16 = j.a("enterMatchFriendAIO=", str, ", sourceId: ", q17, ", feedId: ");
        a16.append(q18);
        kLog.i("feed_detail_page", a16.toString());
        e eVar2 = new e();
        eVar2.v("openId", str);
        eVar2.v("traceId", q16);
        eVar2.v("sourceId", q17);
        eVar2.t("fromId", k3);
        eVar2.t("tacitInvite", i3);
        eVar2.v("feedId", q18);
        Unit unit = Unit.INSTANCE;
        companion.asyncToNativeMethod("enterMatchFriendAIO", eVar2, (Function1<? super e, Unit>) null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("openAio: sourceId=");
        sb5.append(q17);
        sb5.append(", fromId=");
        sb5.append(k3);
        sb5.append(", feedId=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(sb5, q18, kLog, "NBPHomePageMatchFriendViewModel");
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel
    public final void openMyTacit() {
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(Utils.INSTANCE.notifyModule(""), "JIEBAN_OPEN_MY_PROFILE_EVENT", false, 4, null);
    }
}
