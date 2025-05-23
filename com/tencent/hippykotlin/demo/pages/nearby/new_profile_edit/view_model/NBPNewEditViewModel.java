package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model;

import c01.c;
import c45.i;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.repository.NBPNewEditRepository$setUserInfo$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import s35.af;
import s35.d;
import s35.u;
import s35.v;
import u35.a;

/* loaded from: classes31.dex */
public final class NBPNewEditViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewEditViewModel.class, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "getTags()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewEditViewModel.class, "editStatus", "getEditStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/new_profile_edit/view_model/EditStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewEditViewModel.class, "likesOnlySelf", "getLikesOnlySelf()Z", 0)};
    public final int appId;
    public int completedTacitCount;
    public int day;
    public int gender;
    public boolean isRequesting;
    public final int itemId;
    public int month;
    public int year;
    public String nickname = "";
    public String declaration = "";
    public String avatar = "";
    public String constellation = "";
    public final ReadWriteProperty tags$delegate = c.b();
    public final ReadWriteProperty editStatus$delegate = c.a(EditStatus.PREV);
    public final ReadWriteProperty likesOnlySelf$delegate = c.a(Boolean.FALSE);

    public NBPNewEditViewModel(int i3, int i16) {
        this.appId = i3;
        this.itemId = i16;
    }

    public final EditStatus getEditStatus() {
        return (EditStatus) this.editStatus$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<TagInfo> getTags() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tags$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void save(final af afVar, final Function1<? super Boolean, Unit> function1) {
        CharSequence trim;
        boolean z16;
        List listOf;
        List mutableList;
        CharSequence trim2;
        if (!NearbyProUtilsKt.checkEditAccess(this.appId)) {
            KLog.INSTANCE.e("NBPNewEditViewModel", "Illegal path, no access to edit");
            return;
        }
        int i3 = this.itemId;
        if (i3 != 2) {
            if (i3 == 6) {
                trim2 = StringsKt__StringsKt.trim((CharSequence) afVar.F);
                if (trim2.toString().length() == 0) {
                    Utils.INSTANCE.currentBridgeModule().qToast("\u5ba3\u8a00\u4e0d\u80fd\u4e3a\u7a7a", QToastMode.Warning);
                    z16 = false;
                }
            }
            z16 = true;
        } else {
            trim = StringsKt__StringsKt.trim((CharSequence) afVar.f433209f);
            if (trim.toString().length() == 0) {
                Utils.INSTANCE.currentBridgeModule().qToast("\u6635\u79f0\u4e0d\u80fd\u4e3a\u7a7a", QToastMode.Warning);
                z16 = false;
            }
            z16 = true;
        }
        if (z16) {
            if (QQKuiklyPlatformApi.Companion.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            if (this.isRequesting) {
                return;
            }
            this.isRequesting = true;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(this.itemId));
            int i16 = this.appId;
            Function1<v, Unit> function12 = new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel$save$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    String str;
                    v vVar2 = vVar;
                    NBPNewEditViewModel.this.isRequesting = false;
                    if (vVar2 != null && vVar2.f433276d != 0) {
                        Utils.INSTANCE.currentBridgeModule().qToast(vVar2.f433277e, QToastMode.Info);
                    } else {
                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                        StringBuilder sb5 = new StringBuilder();
                        int i17 = NBPNewEditViewModel.this.itemId;
                        Object obj = "";
                        boolean z17 = true;
                        if (i17 == 1) {
                            str = "\u5934\u50cf";
                        } else if (i17 == 2) {
                            str = "\u6635\u79f0";
                        } else if (i17 == 3) {
                            str = "\u661f\u5ea7";
                        } else if (i17 == 6) {
                            str = "\u5ba3\u8a00";
                        } else if (i17 != 7) {
                            str = "";
                        } else {
                            str = "\u6027\u522b";
                        }
                        currentBridgeModule.qToast(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, str, "\u4fee\u6539\u6210\u529f"), QToastMode.Success);
                        Function1<Boolean, Unit> function13 = function1;
                        if (function13 != null) {
                            function13.invoke(Boolean.TRUE);
                        }
                        if (NBPNewEditViewModel.this.appId == 2) {
                            UserDataManager userDataManager = UserDataManager.INSTANCE;
                            NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
                            String str2 = afVar.f433209f;
                            if (Intrinsics.areEqual(userSelfInfo.nickName, str2)) {
                                z17 = false;
                            } else {
                                userSelfInfo.nickName = str2;
                            }
                            if (z17) {
                                userDataManager.saveUserSelfInfo();
                            }
                        }
                        NBPNewEditViewModel nBPNewEditViewModel = NBPNewEditViewModel.this;
                        af afVar2 = afVar;
                        int i18 = nBPNewEditViewModel.itemId;
                        if (i18 == 2) {
                            obj = afVar2.f433209f;
                        } else if (i18 == 3) {
                            obj = afVar2.f433214i;
                        } else if (i18 == 6) {
                            obj = afVar2.F;
                        } else if (i18 == 7) {
                            obj = Integer.valueOf(afVar2.f433218m);
                        }
                        e eVar = new e();
                        eVar.t("itemId", nBPNewEditViewModel.itemId);
                        eVar.v("value", obj);
                        if (nBPNewEditViewModel.itemId == 3) {
                            d dVar = afVar2.C;
                            eVar.t("year", dVar != null ? dVar.f433229d : 0);
                            d dVar2 = afVar2.C;
                            eVar.t("month", dVar2 != null ? dVar2.f433230e : 0);
                            d dVar3 = afVar2.C;
                            eVar.t("day", dVar3 != null ? dVar3.f433231f : 0);
                        }
                        k.d((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "onNearbyProUserInfoChange", eVar, false, 4, null);
                    }
                    return Unit.INSTANCE;
                }
            };
            Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel$save$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str) {
                    num.intValue();
                    String str2 = str;
                    NBPNewEditViewModel.this.isRequesting = false;
                    if (str2.length() > 0) {
                        Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Warning);
                    } else {
                        Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                    }
                    Function1<Boolean, Unit> function13 = function1;
                    if (function13 != null) {
                        function13.invoke(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
            u uVar = new u(mutableList, afVar, 0);
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(new NBPNewEditRepository$setUserInfo$1(i16, function12, function2)), new QQStrangerSsoRequest(new a("QQStranger.UserInfo", "SsoSetUserInfo", i16, new c45.a(i.d(uVar)))), null, 6);
        }
    }

    public final void setEditStatus(EditStatus editStatus) {
        this.editStatus$delegate.setValue(this, $$delegatedProperties[1], editStatus);
    }
}
