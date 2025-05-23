package com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar;

import c01.c;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.AvatarEditBackgroundData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.AvatarEditHeadActionData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.module.NearbyProfileBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.repository.AvatarEditHeadDressBorderData;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.timer.TimerKt;
import d45.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import s35.h;
import s35.i;
import v35.d;
import v35.e;
import v35.f;
import v35.g;

/* loaded from: classes31.dex */
public final class NearbyProfileAvatarEditViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "headActionDataList", "getHeadActionDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "backgroundDataList", "getBackgroundDataList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "headDressBorderDataList", "getHeadDressBorderDataList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "isBatchRecordFinish", "isBatchRecordFinish()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "curHeadActionData", "getCurHeadActionData()Lcom/tencent/hippykotlin/demo/pages/nearby/base/data/AvatarEditHeadActionData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "curBackgroudData", "getCurBackgroudData()Lcom/tencent/hippykotlin/demo/pages/nearby/base/data/AvatarEditBackgroundData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "curHeadDressBorderData", "getCurHeadDressBorderData()Lcom/tencent/hippykotlin/demo/pages/nearby/profile/edit/avatar/repository/AvatarEditHeadDressBorderData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "isNetworkError", "isNetworkError()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditViewModel.class, "isSettingAvatar", "isSettingAvatar()Z", 0)};
    public final int appId;
    public e avatarHeadConfigRsp;
    public final IPageCallback callBackToPage;
    public String curAppearanceKey;
    public final ReadWriteProperty curBackgroudData$delegate;
    public int curGender;
    public final ReadWriteProperty curHeadActionData$delegate;
    public final ReadWriteProperty curHeadDressBorderData$delegate;
    public String curUin;
    public Set<Integer> failedSet;
    public int initialSelectBgIndex;
    public int initialSelectHeadActionId;
    public int initialSelectHeadActionIndex;
    public final ReadWriteProperty isBatchRecordFinish$delegate;
    public boolean isFirstBatchRecordFinish;
    public final ReadWriteProperty isNetworkError$delegate;
    public boolean isRequestingConfig;
    public final ReadWriteProperty isSettingAvatar$delegate;
    public String md5;
    public final String pagerId;
    public int preRecNum;
    public final ReadWriteProperty headActionDataList$delegate = c.b();
    public final ReadWriteProperty backgroundDataList$delegate = c.a(new ArrayList());
    public final ReadWriteProperty headDressBorderDataList$delegate = c.a(new ArrayList());

    public NearbyProfileAvatarEditViewModel(String str, int i3, IPageCallback iPageCallback) {
        this.pagerId = str;
        this.appId = i3;
        this.callBackToPage = iPageCallback;
        Boolean bool = Boolean.FALSE;
        this.isBatchRecordFinish$delegate = c.a(bool);
        this.curHeadActionData$delegate = c.a(null);
        this.curBackgroudData$delegate = c.a(null);
        this.curHeadDressBorderData$delegate = c.a(null);
        this.isNetworkError$delegate = c.a(bool);
        this.isSettingAvatar$delegate = c.a(bool);
        this.curUin = "";
        this.curGender = 1;
        this.curAppearanceKey = "";
        this.md5 = "";
        this.initialSelectHeadActionId = -1;
        this.initialSelectHeadActionIndex = -1;
        this.initialSelectBgIndex = -1;
        this.failedSet = new LinkedHashSet();
        TimerKt.d(16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel = NearbyProfileAvatarEditViewModel.this;
                com.tencent.kuikly.core.nvi.serialization.json.e zPlanUserInfo = nearbyProfileAvatarEditViewModel.bridgeModule().getZPlanUserInfo();
                if (zPlanUserInfo != null) {
                    nearbyProfileAvatarEditViewModel.curUin = zPlanUserInfo.p("uin");
                    nearbyProfileAvatarEditViewModel.curGender = zPlanUserInfo.j("gender");
                    nearbyProfileAvatarEditViewModel.curAppearanceKey = zPlanUserInfo.p("appearanceKey");
                }
                CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_profile_avatar_edit_md5_key_");
                m3.append(nearbyProfileAvatarEditViewModel.appId);
                nearbyProfileAvatarEditViewModel.md5 = cacheModule.getItem(m3.toString());
                NearbyProfileAvatarEditViewModel.this.requestAvatarHeadConfig();
                return Unit.INSTANCE;
            }
        });
        new NBPNewEditViewModel(i3, 1);
    }

    public static final void access$recordAction(final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel) {
        NearbyProfileBridgeModule bridgeModule = nearbyProfileAvatarEditViewModel.bridgeModule();
        com.tencent.kuikly.core.reactive.collection.c<AvatarEditHeadActionData> headActionDataList = nearbyProfileAvatarEditViewModel.getHeadActionDataList();
        int i3 = nearbyProfileAvatarEditViewModel.preRecNum;
        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$recordAction$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                b l3;
                IPageCallback iPageCallback;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                if (eVar2 != null && (l3 = eVar2.l("headActionDataList")) != null) {
                    NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel2 = NearbyProfileAvatarEditViewModel.this;
                    if (l3.c() != nearbyProfileAvatarEditViewModel2.getHeadActionDataList().size()) {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("recordAction failed, size is not equal, callback size: ");
                        m3.append(l3.c());
                        m3.append(", headActionDataList size: ");
                        m3.append(nearbyProfileAvatarEditViewModel2.getHeadActionDataList().size());
                        kLog.e("NearbyProfileAvatarEditViewModel", m3.toString());
                    } else {
                        int c16 = l3.c();
                        for (int i16 = 0; i16 < c16; i16++) {
                            Object d16 = l3.d(i16);
                            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = (com.tencent.kuikly.core.nvi.serialization.json.e) d16;
                            int j3 = eVar3.j("actionId");
                            String p16 = eVar3.p("avatarNormalPath");
                            AvatarEditHeadActionData avatarEditHeadActionData = nearbyProfileAvatarEditViewModel2.getHeadActionDataList().get(i16);
                            if (j3 == avatarEditHeadActionData.actionId) {
                                if (p16.length() > 0) {
                                    ReadWriteProperty readWriteProperty = avatarEditHeadActionData.avatarNormalPath$delegate;
                                    KProperty<?>[] kPropertyArr = AvatarEditHeadActionData.$$delegatedProperties;
                                    readWriteProperty.setValue(avatarEditHeadActionData, kPropertyArr[0], p16);
                                    avatarEditHeadActionData.isRecordFinish$delegate.setValue(avatarEditHeadActionData, kPropertyArr[2], Boolean.TRUE);
                                    if (((Boolean) avatarEditHeadActionData.isSelected$delegate.getValue(avatarEditHeadActionData, kPropertyArr[1])).booleanValue()) {
                                        nearbyProfileAvatarEditViewModel2.setCurHeadActionData(avatarEditHeadActionData);
                                    }
                                    if (nearbyProfileAvatarEditViewModel2.failedSet.contains(Integer.valueOf(i16))) {
                                        nearbyProfileAvatarEditViewModel2.failedSet.remove(Integer.valueOf(i16));
                                    }
                                }
                            }
                            nearbyProfileAvatarEditViewModel2.failedSet.add(Integer.valueOf(i16));
                        }
                        nearbyProfileAvatarEditViewModel2.isBatchRecordFinish$delegate.setValue(nearbyProfileAvatarEditViewModel2, NearbyProfileAvatarEditViewModel.$$delegatedProperties[3], Boolean.TRUE);
                        if (!nearbyProfileAvatarEditViewModel2.isFirstBatchRecordFinish) {
                            nearbyProfileAvatarEditViewModel2.isFirstBatchRecordFinish = true;
                            if (nearbyProfileAvatarEditViewModel2.initialSelectHeadActionIndex == -1 && nearbyProfileAvatarEditViewModel2.initialSelectHeadActionId != -1) {
                                Utils.INSTANCE.currentBridgeModule().qToast("\u4f7f\u7528\u4e2d\u7684\u5934\u50cf\u4e0b\u67b6\u4e86\uff0c\u6362\u4e00\u4e2a\u5427", QToastMode.Info);
                            }
                            int i17 = nearbyProfileAvatarEditViewModel2.initialSelectBgIndex;
                            if (i17 >= 0 && (iPageCallback = nearbyProfileAvatarEditViewModel2.callBackToPage) != null) {
                                iPageCallback.scrollToSpecifiedBgListIndex(i17);
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        bridgeModule.getClass();
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        b bVar = new b();
        Iterator<AvatarEditHeadActionData> it = headActionDataList.iterator();
        while (it.hasNext()) {
            AvatarEditHeadActionData next = it.next();
            com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar2.v("uin", next.uin);
            eVar2.t("actionId", next.actionId);
            eVar2.v("appearanceKey", next.appearanceKey);
            eVar2.v("defaultUrl", next.defaultUrl);
            v35.b bVar2 = next.boundsClipperInfo;
            if (bVar2 != null) {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                eVar3.v(HippyTKDListViewAdapter.X, Float.valueOf(bVar2.f440925d));
                eVar3.v("y", Float.valueOf(bVar2.f440926e));
                eVar3.v("width", Float.valueOf(bVar2.f440927f));
                eVar3.v("height", Float.valueOf(bVar2.f440928h));
                Unit unit = Unit.INSTANCE;
                eVar2.v("boundsClipperInfo", eVar3);
            }
            bVar.t(eVar2);
        }
        eVar.v("headActionDataList", bVar);
        eVar.t("preRecNum", i3);
        bridgeModule.toNative(true, "recordAction", eVar.toString(), function1, false);
        TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$recordAction$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                List reversed;
                NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel2 = NearbyProfileAvatarEditViewModel.this;
                reversed = CollectionsKt___CollectionsKt.reversed(nearbyProfileAvatarEditViewModel2.failedSet);
                Iterator it5 = reversed.iterator();
                while (it5.hasNext()) {
                    int intValue = ((Number) it5.next()).intValue();
                    if (intValue < nearbyProfileAvatarEditViewModel2.getHeadActionDataList().size()) {
                        nearbyProfileAvatarEditViewModel2.getHeadActionDataList().remove(intValue);
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("removed No.", intValue, " head action success, current headActionDataList size: ");
                        m3.append(nearbyProfileAvatarEditViewModel2.getHeadActionDataList().size());
                        kLog.d("NearbyProfileAvatarEditViewModel", m3.toString());
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final NearbyProfileBridgeModule bridgeModule() {
        return (NearbyProfileBridgeModule) com.tencent.kuikly.core.manager.c.f117352a.k(this.pagerId).acquireModule("NearbyProfileKuiklyModule");
    }

    public final void closePage() {
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }

    public final ArrayList<AvatarEditBackgroundData> getBackgroundDataList() {
        return (ArrayList) this.backgroundDataList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final AvatarEditBackgroundData getCurBackgroudData() {
        return (AvatarEditBackgroundData) this.curBackgroudData$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final AvatarEditHeadActionData getCurHeadActionData() {
        return (AvatarEditHeadActionData) this.curHeadActionData$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final AvatarEditHeadDressBorderData getCurHeadDressBorderData() {
        return (AvatarEditHeadDressBorderData) this.curHeadDressBorderData$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<AvatarEditHeadActionData> getHeadActionDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.headActionDataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isNetworkError() {
        return ((Boolean) this.isNetworkError$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
    }

    public final void requestAvatarHeadConfig() {
        String str;
        if (this.isRequestingConfig) {
            return;
        }
        this.isRequestingConfig = true;
        int i3 = this.appId;
        String str2 = this.md5;
        int i16 = this.curGender;
        final Function1<i, Unit> function1 = new Function1<i, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(i iVar) {
                i iVar2;
                String str3;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar;
                String decodeToString;
                Object first;
                NearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1 nearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1 = this;
                i iVar3 = iVar;
                NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel = NearbyProfileAvatarEditViewModel.this;
                nearbyProfileAvatarEditViewModel.isRequestingConfig = false;
                if ((iVar3 != null ? iVar3.f433243f : null) == null) {
                    KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "requestAvatarHeadConfig failed, rspModel is null");
                } else {
                    String str4 = iVar3.f433244h;
                    if (str4.length() == 0) {
                        iVar2 = iVar3;
                        str3 = "NearbyProfileAvatarEditViewModel";
                    } else {
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e(str4);
                        com.tencent.kuikly.core.nvi.serialization.json.e m3 = eVar2.m("headActionData");
                        if (m3 == null) {
                            iVar2 = iVar3;
                            str3 = "NearbyProfileAvatarEditViewModel";
                            eVar = eVar2;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            b l3 = m3.l("eventTags");
                            if (l3 != null) {
                                int c16 = l3.c();
                                for (int i17 = 0; i17 < c16; i17++) {
                                    arrayList.add(Integer.valueOf(l3.i(i17)));
                                }
                            }
                            iVar2 = iVar3;
                            str3 = "NearbyProfileAvatarEditViewModel";
                            eVar = eVar2;
                            nearbyProfileAvatarEditViewModel.setCurHeadActionData(new AvatarEditHeadActionData(nearbyProfileAvatarEditViewModel.curUin, m3.j("actionId"), m3.p("actionName"), m3.p("defaultUrl"), m3.j("avatarSize"), m3.p("appearanceKey"), m3.h("maskRate"), new v35.b((float) m3.h("boundsClipperInfo_x"), (float) m3.h("boundsClipperInfo_y"), (float) m3.h("boundsClipperInfo_width"), (float) m3.h("boundsClipperInfo_height")), (ArrayList<Integer>) arrayList, m3.p("eventInfo")));
                            AvatarEditHeadActionData curHeadActionData = nearbyProfileAvatarEditViewModel.getCurHeadActionData();
                            Intrinsics.checkNotNull(curHeadActionData);
                            nearbyProfileAvatarEditViewModel.initialSelectHeadActionId = curHeadActionData.actionId;
                        }
                        com.tencent.kuikly.core.nvi.serialization.json.e m16 = eVar.m("backgroudData");
                        if (m16 != null) {
                            nearbyProfileAvatarEditViewModel.setCurBackgroudData(new AvatarEditBackgroundData(m16.j("id"), m16.p("url")));
                        }
                        nearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1 = this;
                    }
                    NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel2 = NearbyProfileAvatarEditViewModel.this;
                    i iVar4 = iVar2;
                    List<r25.c> list = iVar4.f433245i;
                    nearbyProfileAvatarEditViewModel2.getClass();
                    ArrayList arrayList2 = new ArrayList();
                    int i18 = 0;
                    for (Object obj : list) {
                        int i19 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        r25.c cVar = (r25.c) obj;
                        AvatarEditHeadDressBorderData avatarEditHeadDressBorderData = new AvatarEditHeadDressBorderData(cVar.f430601d, cVar.f430602e, cVar.f430603f, cVar.f430604h, cVar.f430605i);
                        boolean z16 = cVar.f430605i == 1;
                        avatarEditHeadDressBorderData.setSelected(z16);
                        if (z16) {
                            nearbyProfileAvatarEditViewModel2.curHeadDressBorderData$delegate.setValue(nearbyProfileAvatarEditViewModel2, NearbyProfileAvatarEditViewModel.$$delegatedProperties[6], avatarEditHeadDressBorderData);
                        }
                        arrayList2.add(avatarEditHeadDressBorderData);
                        i18 = i19;
                    }
                    if (nearbyProfileAvatarEditViewModel2.appId == 1 && arrayList2.size() == 1) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                        nearbyProfileAvatarEditViewModel2.selectHeadDressBorderData((AvatarEditHeadDressBorderData) first);
                    }
                    nearbyProfileAvatarEditViewModel2.headDressBorderDataList$delegate.setValue(nearbyProfileAvatarEditViewModel2, NearbyProfileAvatarEditViewModel.$$delegatedProperties[2], arrayList2);
                    e eVar3 = iVar4.f433243f;
                    Intrinsics.checkNotNull(eVar3);
                    if (!eVar3.f440935d) {
                        KLog.INSTANCE.i(str3, "requestAvatarHeadConfig, do not need update");
                        NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel3 = NearbyProfileAvatarEditViewModel.this;
                        nearbyProfileAvatarEditViewModel3.getClass();
                        CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_profile_avatar_edit_config_cache_key_");
                        m17.append(nearbyProfileAvatarEditViewModel3.appId);
                        byte[] a16 = a.a(cacheModule.getItem(m17.toString()));
                        if (a16 != null) {
                            nearbyProfileAvatarEditViewModel3.avatarHeadConfigRsp = (e) c45.i.b(new e(false, null, null, null, null, 31, null), a16);
                        }
                        NearbyProfileAvatarEditViewModel.access$handleAvatarConfigRspData(NearbyProfileAvatarEditViewModel.this);
                        final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel4 = NearbyProfileAvatarEditViewModel.this;
                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NearbyProfileAvatarEditViewModel.access$recordAction(NearbyProfileAvatarEditViewModel.this);
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel5 = NearbyProfileAvatarEditViewModel.this;
                        nearbyProfileAvatarEditViewModel5.avatarHeadConfigRsp = iVar4.f433243f;
                        NearbyProfileAvatarEditViewModel.access$handleAvatarConfigRspData(nearbyProfileAvatarEditViewModel5);
                        final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel6 = NearbyProfileAvatarEditViewModel.this;
                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NearbyProfileAvatarEditViewModel.access$recordAction(NearbyProfileAvatarEditViewModel.this);
                                return Unit.INSTANCE;
                            }
                        });
                        NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel7 = NearbyProfileAvatarEditViewModel.this;
                        nearbyProfileAvatarEditViewModel7.getClass();
                        e eVar4 = iVar4.f433243f;
                        if (eVar4 != null) {
                            Utils utils = Utils.INSTANCE;
                            CacheModule cacheModule2 = utils.cacheModule("");
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_profile_avatar_edit_md5_key_");
                            m18.append(nearbyProfileAvatarEditViewModel7.appId);
                            String sb5 = m18.toString();
                            e eVar5 = iVar4.f433243f;
                            Intrinsics.checkNotNull(eVar5);
                            cacheModule2.setItem(sb5, eVar5.f440936e);
                            decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(c45.i.d(eVar4)));
                            CacheModule cacheModule3 = utils.cacheModule("");
                            StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_profile_avatar_edit_config_cache_key_");
                            m19.append(nearbyProfileAvatarEditViewModel7.appId);
                            cacheModule3.setItem(m19.toString(), decodeToString);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$requestAvatarHeadConfig$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel = NearbyProfileAvatarEditViewModel.this;
                nearbyProfileAvatarEditViewModel.isRequestingConfig = false;
                nearbyProfileAvatarEditViewModel.isNetworkError$delegate.setValue(nearbyProfileAvatarEditViewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[7], Boolean.TRUE);
                KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestAvatarHeadConfig failed, errorCode: ", num.intValue(), ", errorMsg: ", str3));
                return Unit.INSTANCE;
            }
        };
        m25.b bVar = UserDataManager.INSTANCE.getCommonExtInfo().f416054d;
        if (bVar == null || (str = bVar.f416051d) == null) {
            str = "";
        }
        h hVar = new h(new d(str2, i16, str, 2));
        Function1<PbResponse<u35.b>, Unit> function12 = new Function1<PbResponse<u35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.repository.NearbyProfileAvatarEditRepository$getAvatarHeadConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<u35.b> pbResponse) {
                PbResponse<u35.b> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getAvatarHeadConfig proxy retcode:");
                m3.append(pbResponse2.code);
                m3.append(", rsp return code:");
                u35.b bVar2 = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar2 != null ? Integer.valueOf(bVar2.f438201d) : null, kLog, "NearbyProfileAvatarEditRepository");
                if (pbResponse2.success && pbResponse2.rsp != null) {
                    try {
                        Function1<i, Unit> function13 = function1;
                        i iVar = new i(0, null, null, null, null, 31, null);
                        u35.b bVar3 = pbResponse2.rsp;
                        Intrinsics.checkNotNull(bVar3, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                        function13.invoke(c45.i.b(iVar, bVar3.f438203f.f30291a));
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getAvatarHeadConfig decode error: ", th5, KLog.INSTANCE, "NearbyProfileAvatarEditRepository");
                        function2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                    }
                } else {
                    function2.invoke(Integer.valueOf(pbResponse2.code), "");
                }
                return Unit.INSTANCE;
            }
        };
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoGetAvatarHeadConfig", i3, new c45.a(c45.i.d(hVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    public final void selectHeadDressBorderData(AvatarEditHeadDressBorderData avatarEditHeadDressBorderData) {
        String str = avatarEditHeadDressBorderData.dressId;
        AvatarEditHeadDressBorderData curHeadDressBorderData = getCurHeadDressBorderData();
        if (Intrinsics.areEqual(str, curHeadDressBorderData != null ? curHeadDressBorderData.dressId : null)) {
            return;
        }
        AvatarEditHeadDressBorderData curHeadDressBorderData2 = getCurHeadDressBorderData();
        if (curHeadDressBorderData2 != null) {
            curHeadDressBorderData2.setSelected(false);
        }
        avatarEditHeadDressBorderData.setSelected(true);
        this.curHeadDressBorderData$delegate.setValue(this, $$delegatedProperties[6], avatarEditHeadDressBorderData);
    }

    public final void setCurBackgroudData(AvatarEditBackgroundData avatarEditBackgroundData) {
        this.curBackgroudData$delegate.setValue(this, $$delegatedProperties[5], avatarEditBackgroundData);
    }

    public final void setCurHeadActionData(AvatarEditHeadActionData avatarEditHeadActionData) {
        this.curHeadActionData$delegate.setValue(this, $$delegatedProperties[4], avatarEditHeadActionData);
    }

    public final void setSettingAvatar(boolean z16) {
        this.isSettingAvatar$delegate.setValue(this, $$delegatedProperties[8], Boolean.valueOf(z16));
    }

    public static final void access$handleAvatarConfigRspData(NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel) {
        List<v35.a> list;
        List<g> list2;
        int i3;
        Iterator it;
        int i16;
        AvatarEditHeadActionData avatarEditHeadActionData;
        int i17;
        float f16;
        String str;
        float f17;
        AvatarEditHeadActionData curHeadActionData = nearbyProfileAvatarEditViewModel.getCurHeadActionData();
        int i18 = -1;
        int i19 = curHeadActionData != null ? curHeadActionData.actionId : -1;
        AvatarEditBackgroundData curBackgroudData = nearbyProfileAvatarEditViewModel.getCurBackgroudData();
        int i26 = curBackgroudData != null ? curBackgroudData.f114206id : -1;
        ArrayList arrayList = new ArrayList();
        e eVar = nearbyProfileAvatarEditViewModel.avatarHeadConfigRsp;
        if (eVar != null && (list2 = eVar.f440937f) != null) {
            Iterator it5 = list2.iterator();
            int i27 = 0;
            while (it5.hasNext()) {
                Object next = it5.next();
                int i28 = i27 + 1;
                if (i27 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                g gVar = (g) next;
                String str2 = nearbyProfileAvatarEditViewModel.curUin;
                String str3 = nearbyProfileAvatarEditViewModel.curAppearanceKey;
                int i29 = nearbyProfileAvatarEditViewModel.curGender;
                if (((i29 == 0 && gVar.f440944f == 2) || gVar.f440944f == i29) && (i17 = gVar.f440942d) != i18) {
                    String str4 = gVar.f440943e;
                    String str5 = gVar.f440945h;
                    i3 = i26;
                    double d16 = gVar.f440946i;
                    v35.b bVar = gVar.f440947m;
                    it = it5;
                    float f18 = bVar != null ? bVar.f440925d : 0.0f;
                    if (bVar != null) {
                        i16 = i28;
                        f16 = bVar.f440926e;
                    } else {
                        i16 = i28;
                        f16 = 0.0f;
                    }
                    if (bVar != null) {
                        str = str5;
                        f17 = bVar.f440927f;
                    } else {
                        str = str5;
                        f17 = 0.0f;
                    }
                    v35.b bVar2 = new v35.b(f18, f16, f17, bVar != null ? bVar.f440928h : 0.0f);
                    v35.c cVar = gVar.D;
                    ArrayList arrayList2 = new ArrayList(cVar != null ? (int) cVar.f440929d : 0);
                    v35.c cVar2 = gVar.D;
                    avatarEditHeadActionData = new AvatarEditHeadActionData(str2, i17, str4, str, str3, d16, bVar2, arrayList2, cVar2 != null ? cVar2.f440930e : null, 16);
                } else {
                    i3 = i26;
                    it = it5;
                    i16 = i28;
                    avatarEditHeadActionData = null;
                }
                if (avatarEditHeadActionData != null) {
                    avatarEditHeadActionData.avatarNormalPath$delegate.setValue(avatarEditHeadActionData, AvatarEditHeadActionData.$$delegatedProperties[0], avatarEditHeadActionData.defaultUrl);
                    boolean z16 = avatarEditHeadActionData.actionId == i19;
                    avatarEditHeadActionData.setSelected(z16);
                    if (z16) {
                        nearbyProfileAvatarEditViewModel.initialSelectHeadActionIndex = i27;
                        nearbyProfileAvatarEditViewModel.setCurHeadActionData(avatarEditHeadActionData);
                    }
                    arrayList.add(avatarEditHeadActionData);
                }
                i26 = i3;
                it5 = it;
                i27 = i16;
                i18 = -1;
            }
        }
        int i36 = i26;
        int i37 = nearbyProfileAvatarEditViewModel.initialSelectHeadActionIndex;
        if (i37 > 0) {
            AvatarEditHeadActionData avatarEditHeadActionData2 = (AvatarEditHeadActionData) arrayList.get(i37);
            arrayList.remove(nearbyProfileAvatarEditViewModel.initialSelectHeadActionIndex);
            arrayList.add(0, avatarEditHeadActionData2);
        } else if (i37 == -1) {
            KLog.INSTANCE.i("NearbyProfileAvatarEditViewModel", "curHeadId is not exit, curHeadId: " + i19 + ", use first head action");
            if (!arrayList.isEmpty()) {
                nearbyProfileAvatarEditViewModel.setCurHeadActionData((AvatarEditHeadActionData) arrayList.get(0));
                AvatarEditHeadActionData curHeadActionData2 = nearbyProfileAvatarEditViewModel.getCurHeadActionData();
                if (curHeadActionData2 != null) {
                    curHeadActionData2.setSelected(true);
                }
            }
        }
        nearbyProfileAvatarEditViewModel.getHeadActionDataList().addAll(arrayList);
        ArrayList arrayList3 = new ArrayList();
        e eVar2 = nearbyProfileAvatarEditViewModel.avatarHeadConfigRsp;
        if (eVar2 != null && (list = eVar2.f440938h) != null) {
            int i38 = 0;
            for (Object obj : list) {
                int i39 = i38 + 1;
                if (i38 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                v35.a aVar = (v35.a) obj;
                int i46 = aVar.f440922d;
                AvatarEditBackgroundData avatarEditBackgroundData = new AvatarEditBackgroundData(i46, aVar.f440923e);
                int i47 = i36;
                boolean z17 = i46 == i47;
                avatarEditBackgroundData.setSelected(z17);
                if (z17) {
                    nearbyProfileAvatarEditViewModel.initialSelectBgIndex = i38;
                    nearbyProfileAvatarEditViewModel.setCurBackgroudData(avatarEditBackgroundData);
                }
                arrayList3.add(avatarEditBackgroundData);
                i36 = i47;
                i38 = i39;
            }
        }
        int i48 = i36;
        nearbyProfileAvatarEditViewModel.backgroundDataList$delegate.setValue(nearbyProfileAvatarEditViewModel, $$delegatedProperties[1], arrayList3);
        if (nearbyProfileAvatarEditViewModel.initialSelectBgIndex == -1) {
            KLog.INSTANCE.i("NearbyProfileAvatarEditViewModel", "curBgId is not exit, curBgId: " + i48 + ", use first bg");
            if (!nearbyProfileAvatarEditViewModel.getBackgroundDataList().isEmpty()) {
                nearbyProfileAvatarEditViewModel.setCurBackgroudData(nearbyProfileAvatarEditViewModel.getBackgroundDataList().get(0));
            }
        }
        e eVar3 = nearbyProfileAvatarEditViewModel.avatarHeadConfigRsp;
        f fVar = eVar3 != null ? eVar3.f440939i : null;
        if (fVar != null) {
            nearbyProfileAvatarEditViewModel.preRecNum = fVar.f440940d;
        }
    }
}
