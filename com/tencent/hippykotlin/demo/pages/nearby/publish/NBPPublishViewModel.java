package com.tencent.hippykotlin.demo.pages.nearby.publish;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetMapThemeListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetStatusPanelRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.Img2txtRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishCategoryData;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishStatusData;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyMapThemeRepo$fetchMapThemeList$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.AITechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.module.NearbyProfileBridgeModule;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qzone.util.WnsError;
import e35.a;
import e35.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import n25.l;
import n25.m;
import n35.w;
import o25.f;
import p35.af;
import p35.ah;
import q25.g;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPPublishViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "topicList", "getTopicList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "selectTopicList", "getSelectTopicList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, IQWalletPreferenceApi.KEY_THEME_LIST, "getThemeList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "selectThemeList", "getSelectThemeList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "statusCategoryList", "getStatusCategoryList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "statusCategoryIndex", "getStatusCategoryIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "selectStatus", "getSelectStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/base/repo/NBPPublishStatusData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "poiInfo", "getPoiInfo()Lkuikly/com/tencent/trpcprotocol/lplan/common/feed/StPoiInfoV2;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "photoPath", "getPhotoPath()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "content", "getContent()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "isPublishing", "isPublishing()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "showAvatarStatusPanel", "getShowAvatarStatusPanel()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "isRequestImg2txt", "isRequestImg2txt()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishViewModel.class, "img2txtContentList", "getImg2txtContentList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final AITechReporter aiReporter;
    public final NBPLatLng cameraPosTarget;
    public final ReadWriteProperty img2txtContentList$delegate;
    public Map<String, w> img2txtUploadCache;
    public final String initialThemeId;
    public final List<String> initialTopicIds;
    public boolean isEnterDetailPage;
    public final ReadWriteProperty isPublishing$delegate;
    public final ReadWriteProperty isRequestImg2txt$delegate;
    public f lastAISelectTheme;
    public f lastManualSelectTheme;
    public final PageLoadTechReporter pageLoadReporter;
    public final String pagerId;
    public e qqmcConfig;
    public final ReadWriteProperty showAvatarStatusPanel$delegate;
    public final String source;
    public final Map<AIDetectPhotoTag, NBPPublishStatusData> tagMapStatus;
    public final Map<String, List<NBPPublishStatusData>> themeMapStatus;
    public final ReadWriteProperty topicList$delegate = c.a(new ArrayList());
    public final ReadWriteProperty selectTopicList$delegate = c.a(new ArrayList());
    public final ReadWriteProperty themeList$delegate = c.b();
    public final ReadWriteProperty selectThemeList$delegate = c.b();
    public final ReadWriteProperty statusCategoryList$delegate = c.a(new ArrayList());
    public final ReadWriteProperty statusCategoryIndex$delegate = c.a(0);
    public final ReadWriteProperty selectStatus$delegate = c.a(null);
    public final ReadWriteProperty poiInfo$delegate = c.a(null);
    public final ReadWriteProperty photoPath$delegate = c.a("");
    public final ReadWriteProperty content$delegate = c.a("");

    public static final boolean access$checkIsShowCategoryTitleRedDot(NBPPublishViewModel nBPPublishViewModel, String str, String str2) {
        nBPPublishViewModel.getClass();
        if (!(str.length() == 0)) {
            if ((str2.length() == 0) || !Intrinsics.areEqual(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public final void appendContent(String str) {
        this.content$delegate.setValue(this, $$delegatedProperties[9], getContent() + str);
    }

    public final NBPPublishBridgeModule bridgeModule() {
        return (NBPPublishBridgeModule) com.tencent.kuikly.core.manager.c.f117352a.k(this.pagerId).acquireModule("NBPPublishKuiklyModule");
    }

    public final boolean canPublish() {
        String str;
        boolean z16;
        if (getPoiInfo() == null) {
            str = "\u8bf7\u586b\u5199\u4f4d\u7f6e\u4fe1\u606f";
            z16 = false;
        } else {
            str = "";
            z16 = true;
        }
        if (!getSelectTopicList().isEmpty()) {
            if (getPhotoPath().length() == 0) {
                e eVar = new e();
                eVar.v("nearby_dynamic_publish_entrance", this.source);
                eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_pic_prompt_toast_imp", eVar);
                str = "\u8bdd\u9898\u5185\u5bb9\u9700\u8981\u6dfb\u52a0\u56fe\u7247\u624d\u53ef\u4ee5\u53d1\u5e03\u54e6\uff5e";
                z16 = false;
            }
        }
        if (str.length() > 0) {
            Utils.INSTANCE.currentBridgeModule().qToast(str, QToastMode.Warning);
        }
        return z16;
    }

    public final void closePage() {
        NBPLatLng nBPLatLng;
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
        if (Intrinsics.areEqual(this.source, "0") && (nBPLatLng = this.cameraPosTarget) != null) {
            QQNearbyModule.Companion companion2 = QQNearbyModule.Companion;
            QQNearbyModule.Companion.scrollToPositionOnMap$default(nBPLatLng.latitude, nBPLatLng.longitude);
        }
        if (!Intrinsics.areEqual(this.source, "0") || this.isEnterDetailPage) {
            return;
        }
        k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        e eVar = new e();
        eVar.w("nearbyData", false);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "update_map_concise_action", eVar, false, 4, null);
    }

    public final String getContent() {
        return (String) this.content$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final float getContentHeight() {
        return ((NearbyProUtilsKt.getPageViewWidthOptimized(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData()) - 64.0f) - 32.0f) + 12.0f + 84.0f + 40.0f;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getImg2txtContentList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.img2txtContentList$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final String getPhotoPath() {
        return (String) this.photoPath$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final n25.k getPoiInfo() {
        return (n25.k) this.poiInfo$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final e getQQMCConfig() {
        String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("102543", "{}");
        KLog.INSTANCE.i("NBPPublishViewModel", "getQQMCConfig: 102543: " + stringFromQQCommonConfig);
        try {
            return new e(stringFromQQCommonConfig);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final NBPPublishStatusData getSelectStatus() {
        return (NBPPublishStatusData) this.selectStatus$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<f> getSelectThemeList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectThemeList$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final ArrayList<m> getSelectTopicList() {
        return (ArrayList) this.selectTopicList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean getShowAvatarStatusPanel() {
        return ((Boolean) this.showAvatarStatusPanel$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public final int getStatusCategoryIndex() {
        return ((Number) this.statusCategoryIndex$delegate.getValue(this, $$delegatedProperties[5])).intValue();
    }

    public final ArrayList<NBPPublishCategoryData> getStatusCategoryList() {
        return (ArrayList) this.statusCategoryList$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<f> getThemeList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.themeList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final boolean hasPublishInfo() {
        CharSequence trim;
        if (getPhotoPath().length() > 0) {
            return true;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) getContent());
        return trim.toString().length() > 0;
    }

    public final boolean isDetectPhotoTagEnabled() {
        if (!PageDataExtKt.isPublic(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData())) {
            return true;
        }
        e eVar = this.qqmcConfig;
        return eVar != null && eVar.j("detectPhotoTag") == 1;
    }

    public final boolean isRequestImg2txt() {
        return ((Boolean) this.isRequestImg2txt$delegate.getValue(this, $$delegatedProperties[12])).booleanValue();
    }

    public final void processPhoto(String str) {
        this.photoPath$delegate.setValue(this, $$delegatedProperties[8], str);
        if (isDetectPhotoTagEnabled()) {
            if (str.length() > 0) {
                final Function2<f, AIDetectPhotoTag, Unit> function2 = new Function2<f, AIDetectPhotoTag, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$processPhoto$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(f fVar, AIDetectPhotoTag aIDetectPhotoTag) {
                        f fVar2 = fVar;
                        AIDetectPhotoTag aIDetectPhotoTag2 = aIDetectPhotoTag;
                        if (fVar2 != null) {
                            NBPPublishViewModel.selectMapTheme$default(NBPPublishViewModel.this, fVar2, aIDetectPhotoTag2, false, 4);
                        } else {
                            NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                            NBPPublishViewModel.selectMapTheme$default(nBPPublishViewModel, nBPPublishViewModel.lastManualSelectTheme, aIDetectPhotoTag2, false, 4);
                        }
                        return Unit.INSTANCE;
                    }
                };
                KLog.INSTANCE.i("NBPPublishViewModel", "detectPhotoTag start");
                final long currentTimeStamp = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
                NBPPublishBridgeModule bridgeModule = bridgeModule();
                Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$detectPhotoTag$1

                    /* loaded from: classes31.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[AIDetectPhotoTag.values().length];
                            try {
                                iArr[0] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[1] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[2] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            try {
                                iArr[3] = 4;
                            } catch (NoSuchFieldError unused4) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
                    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8  */
                    /* JADX WARN: Removed duplicated region for block: B:75:0x01ec  */
                    /* JADX WARN: Removed duplicated region for block: B:79:0x01cb  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x0173  */
                    /* JADX WARN: Removed duplicated region for block: B:84:0x009e  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(Object obj) {
                        AIDetectPhotoTag aIDetectPhotoTag;
                        Function2<f, AIDetectPhotoTag, Unit> function22;
                        IntRange until;
                        int collectionSizeOrDefault;
                        double d16;
                        Iterable withIndex;
                        Iterator it;
                        Object next;
                        ArrayList arrayList;
                        IndexedValue indexedValue;
                        AIDetectPhotoTag aIDetectPhotoTag2;
                        String joinToString$default;
                        AIDetectPhotoTag aIDetectPhotoTag3;
                        f fVar;
                        T t16;
                        f fVar2;
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        if (obj != null && (obj instanceof String)) {
                            KLog.INSTANCE.i("NBPPublishViewModel", "detectPhotoTag response data");
                            b l3 = new e((String) obj).l("output");
                            if (l3 != null) {
                                NBPPublishViewModel nBPPublishViewModel = this;
                                long j3 = currentTimeStamp;
                                until = RangesKt___RangesKt.until(0, l3.c());
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                Iterator<Integer> it5 = until.iterator();
                                while (it5.hasNext()) {
                                    arrayList2.add(Double.valueOf(l3.g(((IntIterator) it5).nextInt())));
                                }
                                e eVar = nBPPublishViewModel.qqmcConfig;
                                if (eVar != null) {
                                    Double valueOf = Double.valueOf(eVar.h("threshold"));
                                    if (!(valueOf.doubleValue() > 0.0d)) {
                                        valueOf = null;
                                    }
                                    if (valueOf != null) {
                                        d16 = valueOf.doubleValue();
                                        withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList2);
                                        it = withIndex.iterator();
                                        if (it.hasNext()) {
                                            arrayList = arrayList2;
                                            next = null;
                                        } else {
                                            next = it.next();
                                            if (it.hasNext()) {
                                                double doubleValue = ((Number) ((IndexedValue) next).getValue()).doubleValue();
                                                while (true) {
                                                    Object next2 = it.next();
                                                    arrayList = arrayList2;
                                                    double doubleValue2 = ((Number) ((IndexedValue) next2).getValue()).doubleValue();
                                                    if (Double.compare(doubleValue, doubleValue2) < 0) {
                                                        doubleValue = doubleValue2;
                                                        next = next2;
                                                    }
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    arrayList2 = arrayList;
                                                }
                                            } else {
                                                arrayList = arrayList2;
                                            }
                                        }
                                        indexedValue = (IndexedValue) next;
                                        if (indexedValue == null) {
                                            int index = indexedValue.getIndex();
                                            double doubleValue3 = ((Number) indexedValue.getValue()).doubleValue();
                                            AIDetectPhotoTag[] values = AIDetectPhotoTag.values();
                                            int length = values.length;
                                            int i3 = 0;
                                            while (true) {
                                                if (i3 >= length) {
                                                    aIDetectPhotoTag3 = null;
                                                    break;
                                                }
                                                aIDetectPhotoTag3 = values[i3];
                                                if (aIDetectPhotoTag3.ordinal() == index) {
                                                    break;
                                                }
                                                i3++;
                                            }
                                            if (aIDetectPhotoTag3 == null) {
                                                aIDetectPhotoTag3 = AIDetectPhotoTag.Other;
                                            }
                                            if (doubleValue3 >= d16) {
                                                int i16 = WhenMappings.$EnumSwitchMapping$0[aIDetectPhotoTag3.ordinal()];
                                                if (i16 == 1 || i16 == 2) {
                                                    Iterator<f> it6 = nBPPublishViewModel.getThemeList().iterator();
                                                    while (true) {
                                                        if (!it6.hasNext()) {
                                                            fVar = null;
                                                            break;
                                                        }
                                                        fVar = it6.next();
                                                        if (Intrinsics.areEqual(fVar.f421850e, "\u840c\u5ba0\u51fa\u6ca1\u5730\u56fe")) {
                                                            break;
                                                        }
                                                    }
                                                    t16 = fVar;
                                                } else if (i16 == 3 || i16 == 4) {
                                                    Iterator<f> it7 = nBPPublishViewModel.getThemeList().iterator();
                                                    while (true) {
                                                        if (!it7.hasNext()) {
                                                            fVar2 = null;
                                                            break;
                                                        }
                                                        fVar2 = it7.next();
                                                        if (Intrinsics.areEqual(fVar2.f421850e, "\u77e5\u98df\u5206\u5b50\u5730\u56fe")) {
                                                            break;
                                                        }
                                                    }
                                                    t16 = fVar2;
                                                } else {
                                                    t16 = 0;
                                                }
                                                objectRef.element = t16;
                                            }
                                            aIDetectPhotoTag2 = aIDetectPhotoTag3;
                                        } else {
                                            aIDetectPhotoTag2 = null;
                                        }
                                        long currentTimeStamp2 = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - j3;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("detectPhotoTag cost time: ");
                                        sb5.append(currentTimeStamp2);
                                        sb5.append(", threshold: ");
                                        sb5.append(d16);
                                        sb5.append(", output: ");
                                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
                                        sb5.append(joinToString$default);
                                        sb5.append(", theme: ");
                                        f fVar3 = (f) objectRef.element;
                                        sb5.append(fVar3 == null ? fVar3.f421850e : null);
                                        KLog.INSTANCE.i("NBPPublishViewModel", sb5.toString());
                                        aIDetectPhotoTag = aIDetectPhotoTag2;
                                        function22 = function2;
                                        if (function22 != null) {
                                            function22.invoke(objectRef.element, aIDetectPhotoTag);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                d16 = 0.6d;
                                withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList2);
                                it = withIndex.iterator();
                                if (it.hasNext()) {
                                }
                                indexedValue = (IndexedValue) next;
                                if (indexedValue == null) {
                                }
                                long currentTimeStamp22 = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - j3;
                                StringBuilder sb52 = new StringBuilder();
                                sb52.append("detectPhotoTag cost time: ");
                                sb52.append(currentTimeStamp22);
                                sb52.append(", threshold: ");
                                sb52.append(d16);
                                sb52.append(", output: ");
                                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
                                sb52.append(joinToString$default);
                                sb52.append(", theme: ");
                                f fVar32 = (f) objectRef.element;
                                sb52.append(fVar32 == null ? fVar32.f421850e : null);
                                KLog.INSTANCE.i("NBPPublishViewModel", sb52.toString());
                                aIDetectPhotoTag = aIDetectPhotoTag2;
                                function22 = function2;
                                if (function22 != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        } else {
                            KLog.INSTANCE.i("NBPPublishViewModel", "detectPhotoTag response empty");
                        }
                        aIDetectPhotoTag = null;
                        function22 = function2;
                        if (function22 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                };
                bridgeModule.getClass();
                bridgeModule.asyncToNativeMethod("detectPhotoTag", new Object[]{str}, function1);
                return;
            }
            selectMapTheme$default(this, this.lastManualSelectTheme, null, false, 6);
        }
    }

    public final void requestStatuePanel(final Function1<? super Boolean, Unit> function1) {
        final e zPlanUserInfo = ((NearbyProfileBridgeModule) com.tencent.kuikly.core.manager.c.f117352a.k(this.pagerId).acquireModule("NearbyProfileKuiklyModule")).getZPlanUserInfo();
        final int j3 = zPlanUserInfo != null ? zPlanUserInfo.j("gender") : 0;
        final Function1<e35.e, Unit> function12 = new Function1<e35.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$requestStatuePanel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:88:0x0187  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(e35.e eVar) {
                String str;
                int collectionSizeOrDefault;
                Object first;
                Object firstOrNull;
                String str2;
                String str3;
                q25.f fVar;
                Iterator it;
                int i3;
                boolean z16;
                String str4;
                String str5;
                List<q25.f> list;
                Object firstOrNull2;
                boolean z17;
                NBPPublishViewModel$requestStatuePanel$1 nBPPublishViewModel$requestStatuePanel$1 = this;
                e35.e eVar2 = eVar;
                NBPPublishViewModel.this.pageLoadReporter.report();
                if (eVar2 == null) {
                    KLog.INSTANCE.e("NBPPublishViewModel", "requestStatuePanel failed, rspModel is null");
                    Function1<Boolean, Unit> function13 = function1;
                    if (function13 != null) {
                        function13.invoke(Boolean.FALSE);
                    }
                } else {
                    boolean areEqual = Intrinsics.areEqual(QQNearbyModule.Companion.getInstance().syncToNativeMethod("enableFilamentDetail", (e) null, (Function1<? super e, Unit>) null), "1");
                    NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                    e eVar3 = zPlanUserInfo;
                    String str6 = "";
                    if (eVar3 == null || (str = eVar3.p("appearanceKey")) == null) {
                        str = "";
                    }
                    List<a> list2 = eVar2.f395559d;
                    NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                    int i16 = j3;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        a aVar = (a) it5.next();
                        List<i> list3 = aVar.f395549f;
                        if (areEqual) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : list3) {
                                List<e35.f> list4 = ((i) obj).f395572e;
                                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                                    Iterator<T> it6 = list4.iterator();
                                    while (it6.hasNext()) {
                                        if (!((e35.f) it6.next()).f395567i.isEmpty()) {
                                            z17 = true;
                                            break;
                                        }
                                    }
                                }
                                z17 = false;
                                if (z17) {
                                    arrayList2.add(obj);
                                }
                            }
                            list3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it7 = list3.iterator();
                        while (it7.hasNext()) {
                            i iVar = (i) it7.next();
                            g gVar = iVar.f395571d;
                            if (gVar != null) {
                                boolean z18 = areEqual;
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) iVar.f395572e);
                                e35.f fVar2 = (e35.f) firstOrNull;
                                if (fVar2 == null || (list = fVar2.f395567i) == null) {
                                    str2 = str;
                                    str3 = str6;
                                    fVar = null;
                                } else {
                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                    fVar = (q25.f) firstOrNull2;
                                    str2 = str;
                                    str3 = str6;
                                }
                                long j16 = userSelfInfo.tid;
                                NBPUserSelfInfo nBPUserSelfInfo = userSelfInfo;
                                boolean z19 = i16 == 1;
                                int i17 = gVar.f428258e;
                                Iterator it8 = it5;
                                int i18 = i17 == 0 ? gVar.f428257d : i17;
                                int i19 = gVar.f428257d;
                                int i26 = i16;
                                String str7 = gVar.f428260h;
                                if (fVar != null) {
                                    it = it7;
                                    i3 = fVar.f428251d;
                                } else {
                                    it = it7;
                                    i3 = 0;
                                }
                                String str8 = gVar.f428259f;
                                String str9 = gVar.E;
                                ArrayList arrayList5 = arrayList;
                                String str10 = eVar2.f395560e;
                                String str11 = str10.length() == 0 ? str2 : str10;
                                e35.b bVar = iVar.f395573f;
                                arrayList3.add(new NBPPublishStatusData(j16, z19, i18, i19, i17, str7, i3, str8, str9, fVar, str11, (bVar == null || (str5 = bVar.f395552e) == null) ? str3 : str5));
                                e35.b bVar2 = iVar.f395573f;
                                if (bVar2 != null && (str4 = bVar2.f395552e) != null) {
                                    if (str4.length() > 0) {
                                        z16 = true;
                                        if (z16) {
                                            arrayList4.add(Integer.valueOf(gVar.f428257d));
                                        }
                                        areEqual = z18;
                                        str6 = str3;
                                        str = str2;
                                        userSelfInfo = nBPUserSelfInfo;
                                        it5 = it8;
                                        i16 = i26;
                                        it7 = it;
                                        arrayList = arrayList5;
                                    }
                                }
                                z16 = false;
                                if (z16) {
                                }
                                areEqual = z18;
                                str6 = str3;
                                str = str2;
                                userSelfInfo = nBPUserSelfInfo;
                                it5 = it8;
                                i16 = i26;
                                it7 = it;
                                arrayList = arrayList5;
                            } else {
                                arrayList3.add(new NBPPublishStatusData(0, 0, null, 4095));
                                areEqual = areEqual;
                                str = str;
                                userSelfInfo = userSelfInfo;
                            }
                        }
                        boolean z26 = areEqual;
                        NBPUserSelfInfo nBPUserSelfInfo2 = userSelfInfo;
                        String str12 = str;
                        String str13 = str6;
                        Iterator it9 = it5;
                        int i27 = i16;
                        ArrayList arrayList6 = arrayList;
                        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList4);
                        String obj2 = arrayList4.isEmpty() ? str13 : arrayList4.toString();
                        NBPPublishCategoryData nBPPublishCategoryData = new NBPPublishCategoryData(aVar.f395547d, aVar.f395548e, arrayList3, obj2);
                        String str14 = aVar.f395547d;
                        nBPPublishCategoryData.hasRedDot$delegate.setValue(nBPPublishCategoryData, NBPPublishCategoryData.$$delegatedProperties[0], Boolean.valueOf(NBPPublishViewModel.access$checkIsShowCategoryTitleRedDot(nBPPublishViewModel, obj2, ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).getItem("ACTION_PANEL_RED_DOT_STATUS_ID_LIST_STR_CACHE_KEY" + str14))));
                        arrayList6.add(nBPPublishCategoryData);
                        arrayList = arrayList6;
                        areEqual = z26;
                        str6 = str13;
                        str = str12;
                        userSelfInfo = nBPUserSelfInfo2;
                        it5 = it9;
                        i16 = i27;
                        nBPPublishViewModel$requestStatuePanel$1 = this;
                    }
                    NBPPublishViewModel$requestStatuePanel$1 nBPPublishViewModel$requestStatuePanel$12 = nBPPublishViewModel$requestStatuePanel$1;
                    NBPPublishViewModel nBPPublishViewModel2 = NBPPublishViewModel.this;
                    nBPPublishViewModel2.statusCategoryList$delegate.setValue(nBPPublishViewModel2, NBPPublishViewModel.$$delegatedProperties[4], new ArrayList(arrayList));
                    if (!NBPPublishViewModel.this.getStatusCategoryList().isEmpty()) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) NBPPublishViewModel.this.getStatusCategoryList());
                        NBPPublishViewModel.this.saveTitleRedDotStatusIdListStr((NBPPublishCategoryData) first);
                    }
                    Function1<Boolean, Unit> function14 = function1;
                    if (function14 != null) {
                        function14.invoke(Boolean.TRUE);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$requestStatuePanel$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                String str2 = str;
                Function1<Boolean, Unit> function13 = function1;
                if (function13 != null) {
                    function13.invoke(Boolean.FALSE);
                }
                KLog.INSTANCE.e("NBPPublishViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestStatuePanel failed, errorCode: ", intValue, ", errorMsg: ", str2));
                return Unit.INSTANCE;
            }
        };
        GetStatusPanelRequest getStatusPanelRequest = new GetStatusPanelRequest(j3);
        Function1<PbResponse<e35.e>, Unit> function13 = new Function1<PbResponse<e35.e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishRepository$requestStatusPanel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<e35.e> pbResponse) {
                PbResponse<e35.e> pbResponse2 = pbResponse;
                if (pbResponse2.success) {
                    function12.invoke(pbResponse2.rsp);
                } else {
                    function2.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.status_panel_svr.StatusPanelSvr.SsoGetStatusPanel");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getStatusPanelRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function13), 6);
    }

    public final void requestThemeList() {
        Function2<Boolean, v25.i, Unit> function2 = new Function2<Boolean, v25.i, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$requestThemeList$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, v25.i iVar) {
                List mutableList;
                Object obj;
                v25.i iVar2 = iVar;
                if (bool.booleanValue()) {
                    NBPPublishViewModel.this.getThemeList().clear();
                    List<f> list = iVar2.f440858e;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (true ^ ((f) next).H) {
                            arrayList.add(next);
                        }
                    }
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                    String str = NBPPublishViewModel.this.initialThemeId;
                    if (str != null) {
                        if (!(str.length() > 0)) {
                            str = null;
                        }
                        if (str != null) {
                            NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                            Iterator it5 = mutableList.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it5.next();
                                if (Intrinsics.areEqual(((f) obj).f421849d, str)) {
                                    break;
                                }
                            }
                            f fVar = (f) obj;
                            if (fVar != null) {
                                NBPPublishViewModel.selectMapTheme$default(nBPPublishViewModel, fVar, null, false, 6);
                                mutableList.remove(fVar);
                                mutableList.add(0, fVar);
                            }
                        }
                    }
                    NBPPublishViewModel.this.getThemeList().addAll(mutableList);
                } else {
                    KLog.INSTANCE.e("NBPPublishViewModel", "requestThemeList false");
                }
                return Unit.INSTANCE;
            }
        };
        KLog.INSTANCE.i("NearbyMapThemeRepo", "start fetch map themes");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        NearbyProUtilsKt.getCachedMapThemeList();
        GetMapThemeListRequest getMapThemeListRequest = new GetMapThemeListRequest(true);
        NearbyMapThemeRepo$fetchMapThemeList$1 nearbyMapThemeRepo$fetchMapThemeList$1 = new NearbyMapThemeRepo$fetchMapThemeList$1(booleanRef, function2);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetMapThemeList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getMapThemeListRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nearbyMapThemeRepo$fetchMapThemeList$1), 6);
    }

    public final void saveTitleRedDotStatusIdListStr(NBPPublishCategoryData nBPPublishCategoryData) {
        ReadWriteProperty readWriteProperty = nBPPublishCategoryData.hasRedDot$delegate;
        KProperty<?>[] kPropertyArr = NBPPublishCategoryData.$$delegatedProperties;
        if (((Boolean) readWriteProperty.getValue(nBPPublishCategoryData, kPropertyArr[0])).booleanValue()) {
            if (nBPPublishCategoryData.redDotStatusIdListStr.length() == 0) {
                return;
            }
            nBPPublishCategoryData.hasRedDot$delegate.setValue(nBPPublishCategoryData, kPropertyArr[0], Boolean.FALSE);
            String str = nBPPublishCategoryData.f114208id;
            String str2 = nBPPublishCategoryData.redDotStatusIdListStr;
            ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).setItem("ACTION_PANEL_RED_DOT_STATUS_ID_LIST_STR_CACHE_KEY" + str, str2);
        }
    }

    public final void setPoiInfo(n25.k kVar) {
        this.poiInfo$delegate.setValue(this, $$delegatedProperties[7], kVar);
    }

    public final void setRequestImg2txt(boolean z16) {
        this.isRequestImg2txt$delegate.setValue(this, $$delegatedProperties[12], Boolean.valueOf(z16));
    }

    public final void setShowAvatarStatusPanel(boolean z16) {
        this.showAvatarStatusPanel$delegate.setValue(this, $$delegatedProperties[11], Boolean.valueOf(z16));
    }

    public final boolean tryRetentionOrClose() {
        boolean hasPublishInfo = hasPublishInfo();
        if (hasPublishInfo) {
            ((QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("\u786e\u5b9a\u9000\u51fa\u7f16\u8f91\u5417\uff1f", "\u9000\u51fa\u540e\u5185\u5bb9\u5c06\u4e0d\u518d\u4fdd\u7559\u3002", "\u53d6\u6d88", "\u786e\u8ba4", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$tryRetentionOrClose$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    boolean booleanValue = bool.booleanValue();
                    bool2.booleanValue();
                    if (booleanValue) {
                        NBPPublishViewModel.this.closePage();
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            closePage();
        }
        return hasPublishInfo;
    }

    public static final void access$closePage(NBPPublishViewModel nBPPublishViewModel, l lVar) {
        ArrayList arrayListOf;
        n25.i iVar;
        n25.i iVar2;
        if (Intrinsics.areEqual(nBPPublishViewModel.source, "0")) {
            QQNearbyModule.Companion companion = QQNearbyModule.Companion;
            n25.k poiInfo = nBPPublishViewModel.getPoiInfo();
            double d16 = 0.0d;
            double d17 = (poiInfo == null || (iVar2 = poiInfo.C) == null) ? 0.0d : iVar2.f418079d / 1000000;
            n25.k poiInfo2 = nBPPublishViewModel.getPoiInfo();
            if (poiInfo2 != null && (iVar = poiInfo2.C) != null) {
                d16 = iVar.f418080e / 1000000;
            }
            QQNearbyModule.Companion.scrollToPositionOnMap$default(d17, d16);
            nBPPublishViewModel.isEnterDetailPage = true;
            NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
            long j3 = userSelfInfo.tid;
            String str = userSelfInfo.avatarUrl;
            String str2 = userSelfInfo.nickName;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new r25.b(1001, new r25.c(userSelfInfo.avatarDressBorderUrl, 23), 2));
            NBPJumpUtil.jumpSquareFeedList$default(new p(j3, null, str2, str, arrayListOf, WnsError.WNS_CODE_LOGIN_A2_EXPIRED), lVar, null, "2", true, null, null, null, 224);
            return;
        }
        QQNearbyModule.openFeedShare$default(QQNearbyModule.Companion.getInstance(), 2, 1, lVar, null, true, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$closePage$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                boolean booleanValue = bool.booleanValue();
                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("openFeedShare result: ", booleanValue, KLog.INSTANCE, "NBPPublishViewModel");
                if (!booleanValue) {
                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                }
                return Unit.INSTANCE;
            }
        }, 8);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, n35.w>] */
    public final void convertImageToText(boolean z16) {
        if (z16) {
            getImg2txtContentList().clear();
        }
        final String photoPath = getPhotoPath();
        if (photoPath.length() > 0) {
            setRequestImg2txt(true);
            final long currentTimeStamp = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
            final Function2<List<? extends String>, String, Unit> function2 = new Function2<List<? extends String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$convertImageToText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(List<? extends String> list, String str) {
                    List<? extends String> list2 = list;
                    String str2 = str;
                    if (str2 != null) {
                        KLog.INSTANCE.e("NBPPublishViewModel", str2);
                    }
                    if (list2 != null) {
                        com.tencent.kuikly.core.reactive.collection.c<String> img2txtContentList = NBPPublishViewModel.this.getImg2txtContentList();
                        NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list2) {
                            if (!nBPPublishViewModel.getImg2txtContentList().contains((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        img2txtContentList.addAll(0, arrayList);
                        long currentTimeStamp2 = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - currentTimeStamp;
                        KLog.INSTANCE.i("NBPPublishViewModel", "img2txt cost time: " + currentTimeStamp2 + ", size: " + list2.size());
                    }
                    NBPPublishViewModel.this.setRequestImg2txt(false);
                    return Unit.INSTANCE;
                }
            };
            final Function1<w, Unit> function1 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$sendImg2txtRequest$requestAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(w wVar) {
                    List listOf;
                    Map mapOf;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(wVar);
                    ah poiInfo = NearbyProUtilsKt.toPoiInfo(NBPPublishViewModel.this.getPoiInfo());
                    final NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                    final String str = photoPath;
                    final Function2<List<String>, String, Unit> function22 = function2;
                    final Function1<i25.b, Unit> function12 = new Function1<i25.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$sendImg2txtRequest$requestAction$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(i25.b bVar) {
                            i25.b bVar2 = bVar;
                            if (!Intrinsics.areEqual(NBPPublishViewModel.this.getPhotoPath(), str)) {
                                Function2<List<String>, String, Unit> function23 = function22;
                                if (function23 != null) {
                                    function23.invoke(null, "[requestImg2txt rsp]isn't current photoPath");
                                }
                            } else if (bVar2 == null) {
                                Function2<List<String>, String, Unit> function24 = function22;
                                if (function24 != null) {
                                    function24.invoke(null, "[requestImg2txt rsp]rspModel is null");
                                }
                            } else if (bVar2.f407128e.length() == 0) {
                                Function2<List<String>, String, Unit> function25 = function22;
                                if (function25 != null) {
                                    function25.invoke(null, "[requestImg2txt rsp]text is empty");
                                }
                            } else {
                                b bVar3 = new b(bVar2.f407128e);
                                ArrayList arrayList = new ArrayList();
                                int c16 = bVar3.c();
                                for (int i3 = 0; i3 < c16; i3++) {
                                    String o16 = bVar3.o(i3);
                                    if (o16 != null) {
                                        if ((o16.length() > 0) && !arrayList.contains(o16)) {
                                            arrayList.add(o16);
                                        }
                                    }
                                }
                                Function2<List<String>, String, Unit> function26 = function22;
                                if (function26 != null) {
                                    function26.invoke(arrayList, null);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    final NBPPublishViewModel nBPPublishViewModel2 = NBPPublishViewModel.this;
                    final String str2 = photoPath;
                    final Function2<List<String>, String, Unit> function23 = function2;
                    final Function2<Integer, String, Unit> function24 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$sendImg2txtRequest$requestAction$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Integer num, String str3) {
                            int intValue = num.intValue();
                            String str4 = str3;
                            if (!Intrinsics.areEqual(NBPPublishViewModel.this.getPhotoPath(), str2)) {
                                Function2<List<String>, String, Unit> function25 = function23;
                                if (function25 != null) {
                                    function25.invoke(null, "[requestImg2txt err]isn't current photoPath:" + intValue + '-' + str4);
                                }
                            } else {
                                Function2<List<String>, String, Unit> function26 = function23;
                                if (function26 != null) {
                                    function26.invoke(null, "[requestImg2txt err]" + intValue + '-' + str4);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("contentCount", String.valueOf(2)));
                    Img2txtRequest img2txtRequest = new Img2txtRequest(listOf, poiInfo, mapOf);
                    Function1<PbResponse<i25.b>, Unit> function13 = new Function1<PbResponse<i25.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishRepository$requestImg2txt$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<i25.b> pbResponse) {
                            PbResponse<i25.b> pbResponse2 = pbResponse;
                            if (pbResponse2.success) {
                                function12.invoke(pbResponse2.rsp);
                            } else {
                                function24.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.kuolie.assisted_chat.MultiModalChatService.SsoPicGenText");
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(img2txtRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function13), 6);
                    return Unit.INSTANCE;
                }
            };
            if (this.img2txtUploadCache.containsKey(photoPath)) {
                w wVar = (w) this.img2txtUploadCache.get(photoPath);
                Intrinsics.checkNotNull(wVar);
                function1.invoke(wVar);
                return;
            }
            QQNearbyModule.Companion.getInstance().uploadImage(photoPath, new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$sendImg2txtRequest$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(byte[] bArr) {
                    byte[] bArr2 = bArr;
                    if (bArr2 == null) {
                        Function2<List<String>, String, Unit> function22 = function2;
                        if (function22 != null) {
                            function22.invoke(null, "[sendImg2txtRequest]upload photo failed, photoUploadResult is null");
                        }
                    } else {
                        w wVar2 = (w) c45.i.b(new w(null, null, 3, null), bArr2);
                        this.img2txtUploadCache.put(photoPath, wVar2);
                        function1.invoke(wVar2);
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        setRequestImg2txt(false);
    }

    public NBPPublishViewModel(String str, String str2, List<String> list, NBPLatLng nBPLatLng, x25.m mVar, String str3) {
        Map<AIDetectPhotoTag, NBPPublishStatusData> mapOf;
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        Map<String, List<NBPPublishStatusData>> mapOf2;
        ah ahVar;
        ah ahVar2;
        af afVar;
        ah ahVar3;
        af afVar2;
        n25.k poiInfo;
        n25.i iVar;
        this.pagerId = str;
        this.source = str2;
        this.initialTopicIds = list;
        this.cameraPosTarget = nBPLatLng;
        this.initialThemeId = str3;
        Boolean bool = Boolean.FALSE;
        this.isPublishing$delegate = c.a(bool);
        this.showAvatarStatusPanel$delegate = c.a(bool);
        PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter((String) null, 3);
        this.pageLoadReporter = pageLoadTechReporter;
        this.aiReporter = new AITechReporter();
        this.isRequestImg2txt$delegate = c.a(bool);
        this.img2txtUploadCache = new LinkedHashMap();
        this.img2txtContentList$delegate = c.b();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(AIDetectPhotoTag.Cat, new NBPPublishStatusData(11, FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD, "\u5728\u5438\u732b", 3943)), TuplesKt.to(AIDetectPhotoTag.Dog, new NBPPublishStatusData(11, 1723, "\u5728\u905b\u72d7", 3943)));
        this.tagMapStatus = mapOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishStatusData[]{new NBPPublishStatusData(11, 1060, "\u65e0\u804a", 3943), new NBPPublishStatusData(11, 1058, "\u5f00\u5fc3", 3943), new NBPPublishStatusData(11, 1056, "\u5174\u594b", 3943), new NBPPublishStatusData(11, 0, "\u5e73\u9759", 3943)});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishStatusData[]{new NBPPublishStatusData(11, 1019, "\u5403\u996d\u4e2d", 3943), new NBPPublishStatusData(11, 2010, "\u9732\u8425\u4e2d", 3943)});
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishStatusData[]{new NBPPublishStatusData(11, 1300, "\u6478\u9c7c\u4e2d", 3943), new NBPPublishStatusData(11, 1018, "\u5b66\u4e60\u4e2d", 3943)});
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPPublishStatusData[]{new NBPPublishStatusData(11, 1723, "\u5728\u905b\u72d7", 3943), new NBPPublishStatusData(11, FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD, "\u5728\u5438\u732b", 3943)});
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(null, listOf), TuplesKt.to("jxto4qjms0", listOf2), TuplesKt.to("m1sbtb6rff", listOf3), TuplesKt.to("vny46ata6a", listOf4));
        this.themeMapStatus = mapOf2;
        pageLoadTechReporter.reset();
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        NBPLatLng selfPosition = userDataManager.getSelfPosition();
        double d16 = 1000000;
        long latitude = (long) (selfPosition.getLatitude() * d16);
        long longitude = (long) (selfPosition.getLongitude() * d16);
        NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
        setPoiInfo(new n25.k((String) null, userSelfInfo.getLocationName(), 0, (String) null, userSelfInfo.getLocationAddress(), 0, new n25.i(latitude, longitude, 12), 0, 0, (String) null, userSelfInfo.getLocationCountry(), userSelfInfo.getLocationProvince(), userSelfInfo.getLocationCity(), 0, 0, (String) null, userSelfInfo.getLocationDistrict(), (String) null, (String) null, userSelfInfo.getLocationName(), 1500077));
        if (Intrinsics.areEqual(str2, "0") && (poiInfo = getPoiInfo()) != null && (iVar = poiInfo.C) != null) {
            QQNearbyModule.Companion companion = QQNearbyModule.Companion;
            QQNearbyModule.Companion.scrollToPositionOnMap$default(iVar.f418079d / d16, iVar.f418080e / d16);
        }
        if (Intrinsics.areEqual(str2, "5")) {
            long j3 = 0;
            long j16 = (mVar == null || (ahVar3 = mVar.f447113d) == null || (afVar2 = ahVar3.C) == null) ? 0L : afVar2.f425135d;
            if (mVar != null && (ahVar2 = mVar.f447113d) != null && (afVar = ahVar2.C) != null) {
                j3 = afVar.f425136e;
            }
            long j17 = j3;
            KLog kLog = KLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("from middle page, lat=");
            sb5.append(j16);
            sb5.append(", lon=");
            kLog.i("NBPPublishViewModel", GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(sb5, j17, '}'));
            setPoiInfo((mVar == null || (ahVar = mVar.f447113d) == null) ? null : new n25.k((String) null, ahVar.f425144e, 0, (String) null, ahVar.f425147i, 0, new n25.i(j16, j17, 12), 0, 0, (String) null, ahVar.G, ahVar.H, ahVar.I, 0, 0, (String) null, ahVar.M, (String) null, (String) null, ahVar.Q, 1500077));
        }
        requestStatuePanel(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool2) {
                Object firstOrNull;
                if (bool2.booleanValue()) {
                    NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nBPPublishViewModel.getSelectThemeList());
                    NBPPublishViewModel.selectMapTheme$default(nBPPublishViewModel, (f) firstOrNull, null, false, 6);
                }
                return Unit.INSTANCE;
            }
        });
        requestThemeList();
        this.qqmcConfig = getQQMCConfig();
    }

    public static void selectMapTheme$default(NBPPublishViewModel nBPPublishViewModel, f fVar, AIDetectPhotoTag aIDetectPhotoTag, boolean z16, int i3) {
        NBPPublishStatusData nBPPublishStatusData;
        Object obj;
        Object random;
        if ((i3 & 2) != 0) {
            aIDetectPhotoTag = null;
        }
        int i16 = 0;
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if (z16) {
            nBPPublishViewModel.lastManualSelectTheme = fVar;
        }
        com.tencent.kuikly.core.reactive.collection.c<f> selectThemeList = nBPPublishViewModel.getSelectThemeList();
        selectThemeList.clear();
        if (fVar != null) {
            selectThemeList.add(fVar);
        }
        if (aIDetectPhotoTag != null) {
            nBPPublishViewModel.lastAISelectTheme = fVar;
            nBPPublishStatusData = nBPPublishViewModel.tagMapStatus.get(aIDetectPhotoTag);
        } else {
            nBPPublishStatusData = null;
        }
        if (nBPPublishStatusData == null) {
            List<NBPPublishStatusData> list = nBPPublishViewModel.themeMapStatus.get(fVar != null ? fVar.f421849d : null);
            if (list != null) {
                random = CollectionsKt___CollectionsKt.random(list, Random.INSTANCE);
                nBPPublishStatusData = (NBPPublishStatusData) random;
            } else {
                nBPPublishStatusData = null;
            }
        }
        if (nBPPublishStatusData != null) {
            Iterator<NBPPublishCategoryData> it = nBPPublishViewModel.getStatusCategoryList().iterator();
            int i17 = 0;
            NBPPublishStatusData nBPPublishStatusData2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i18 = i17 + 1;
                Iterator<T> it5 = it.next().statusList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it5.next();
                    NBPPublishStatusData nBPPublishStatusData3 = (NBPPublishStatusData) obj;
                    if (nBPPublishStatusData.statusId == nBPPublishStatusData3.statusId && nBPPublishStatusData.richStatusId == nBPPublishStatusData3.richStatusId) {
                        break;
                    }
                }
                NBPPublishStatusData nBPPublishStatusData4 = (NBPPublishStatusData) obj;
                if (nBPPublishStatusData4 != null) {
                    i16 = i17;
                    nBPPublishStatusData2 = nBPPublishStatusData4;
                    break;
                } else {
                    i17 = i18;
                    nBPPublishStatusData2 = nBPPublishStatusData4;
                }
            }
            ReadWriteProperty readWriteProperty = nBPPublishViewModel.statusCategoryIndex$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(nBPPublishViewModel, kPropertyArr[5], Integer.valueOf(i16));
            nBPPublishViewModel.selectStatus$delegate.setValue(nBPPublishViewModel, kPropertyArr[6], nBPPublishStatusData2);
        }
    }
}
