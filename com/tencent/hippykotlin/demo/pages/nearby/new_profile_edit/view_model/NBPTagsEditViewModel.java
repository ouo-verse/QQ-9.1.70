package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model;

import androidx.exifinterface.media.ExifInterface;
import c01.c;
import c45.i;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$updateTagsInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import s35.ad;
import s35.ae;
import s35.l;
import s35.m;
import t35.a;
import t35.b;

/* loaded from: classes31.dex */
public final class NBPTagsEditViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPTagsEditViewModel.class, "selectedTags", "getSelectedTags()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPTagsEditViewModel.class, "state", "getState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_profile_edit/view_model/NBPTagsEditViewModel$TagState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPTagsEditViewModel.class, "selectedMBTI", "getSelectedMBTI()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final int appId;
    public final List<MBTITagAttr> mbtiTags;
    public float pageViewWidth;
    public final ReadWriteProperty selectedMBTI$delegate;
    public TagInfo selectedMBTITag;
    public List<TagInfo> rawTags = new ArrayList();
    public final ReadWriteProperty selectedTags$delegate = c.b();
    public final ReadWriteProperty state$delegate = c.a(TagState.UNKNOWN);
    public List<TagTabObservable> tagTabList = new ArrayList();
    public Map<Integer, OptionalTagViewAttr> allTagsSet = new LinkedHashMap();
    public final Map<String, TagInfo> mbtiTagMap = new LinkedHashMap();

    /* loaded from: classes31.dex */
    public enum TagState {
        UNKNOWN,
        LOADING,
        SUCCESS,
        ERROR
    }

    public NBPTagsEditViewModel(int i3) {
        List<MBTITagAttr> listOf;
        this.appId = i3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MBTITagAttr[]{new MBTITagAttr("E", "\u5916\u5411", "I", "\u5185\u5411", 0), new MBTITagAttr("N", "\u76f4\u89c9", ExifInterface.LATITUDE_SOUTH, "\u5b9e\u611f", 1), new MBTITagAttr(UserInfo.SEX_FEMALE, "\u60c5\u611f", "T", "\u601d\u7ef4", 2), new MBTITagAttr("P", "\u77e5\u89c9", "J", "\u5224\u65ad", 3)});
        this.mbtiTags = listOf;
        this.selectedMBTI$delegate = c.b();
        this.pageViewWidth = 375.0f;
    }

    public final boolean checkMBTICanBeSelected() {
        if (!isMBTITagValid() ? getSelectedTags().size() >= 20 : getSelectedTags().size() > 20) {
            return true;
        }
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().qToast("\u6dfb\u52a0\u592a\u591a\u6807\u7b7e\u5566", QToastMode.Info);
        e dtTAGPageParam = getDtTAGPageParam();
        dtTAGPageParam.v("dt_imp", "em_nearby_kl_overmuch_tag_toast");
        dtTAGPageParam.v("dt_eid", "em_nearby_kl_overmuch_tag_toast");
        dtTAGPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        utils.currentBridgeModule().reportCustomDtEvent("dt_imp", dtTAGPageParam);
        return false;
    }

    public final boolean checkSelectedTags() {
        String str;
        if (getSelectedTags().size() >= 3) {
            return true;
        }
        QQUIModule qQUIModule = (QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u8bf7\u81f3\u5c11\u9009\u62e93\u4e2a\u6807\u7b7e\uff0c\u624d\u80fd\u73a9\u8f6c");
        int i3 = this.appId;
        if (i3 == 1) {
            str = SoLoad.BIZ_TRTC_PARTY_HOUSE;
        } else if (i3 != 2) {
            str = "";
        } else {
            str = "\u9644\u8fd1";
        }
        QQUIModule.openAlertDialog$default(qQUIModule, "", OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str, "\u54e6~"), "", "\u6211\u77e5\u9053\u4e86", new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$checkSelectedTags$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, Boolean bool2) {
                bool.booleanValue();
                bool2.booleanValue();
                e dtTAGPageParam = NBPTagsEditViewModel.this.getDtTAGPageParam();
                dtTAGPageParam.v("dt_clck", "em_nearby_kl_choose_tag_pop");
                dtTAGPageParam.v("dt_eid", "em_nearby_kl_choose_tag_pop");
                dtTAGPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtTAGPageParam);
                return Unit.INSTANCE;
            }
        });
        e dtTAGPageParam = getDtTAGPageParam();
        dtTAGPageParam.v("dt_imp", "em_nearby_kl_choose_tag_pop");
        dtTAGPageParam.v("dt_eid", "em_nearby_kl_choose_tag_pop");
        dtTAGPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dtTAGPageParam);
        return false;
    }

    public final boolean containsMBTITag() {
        Object first;
        if (getSelectedTags().isEmpty()) {
            return false;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) getSelectedTags());
        int i3 = ((TagInfo) first).tag.f435362d;
        return 10000 <= i3 && i3 < 11112;
    }

    public final void fetchAllTags() {
        setState(TagState.LOADING);
        final int i3 = this.appId;
        final Function1<List<? extends b>, Unit> function1 = new Function1<List<? extends b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$fetchAllTags$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends b> list) {
                int collectionSizeOrDefault;
                Object obj;
                List<a> list2;
                List split$default;
                Object first;
                int collectionSizeOrDefault2;
                List<? extends b> list3 = list;
                if (list3 != null) {
                    NBPTagsEditViewModel nBPTagsEditViewModel = NBPTagsEditViewModel.this;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (b bVar : list3) {
                        float f16 = nBPTagsEditViewModel.pageViewWidth;
                        int i16 = bVar.f435368d;
                        String str = bVar.f435369e;
                        List<a> list4 = bVar.f435370f;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                        Iterator<T> it = list4.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new TagInfo((a) it.next()));
                        }
                        arrayList.add(new TagTabObservable(i16, str, arrayList2, bVar.f435371h, f16));
                    }
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        TagTabObservable tagTabObservable = (TagTabObservable) it5.next();
                        if (tagTabObservable.getTagLines() >= 3) {
                            tagTabObservable.getCollapsedTags();
                        } else {
                            tagTabObservable.getTagList().addAll(tagTabObservable.tags);
                        }
                    }
                    nBPTagsEditViewModel.tagTabList.addAll(arrayList);
                    Iterator<T> it6 = list3.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it6.next();
                        if (((b) obj).f435368d == 10000) {
                            break;
                        }
                    }
                    b bVar2 = (b) obj;
                    if (bVar2 != null && (list2 = bVar2.f435370f) != null) {
                        for (a aVar : list2) {
                            split$default = StringsKt__StringsKt.split$default((CharSequence) aVar.f435363e, new String[]{"|"}, false, 0, 6, (Object) null);
                            Map<String, TagInfo> map = nBPTagsEditViewModel.mbtiTagMap;
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
                            map.put(first, new TagInfo(aVar));
                        }
                    }
                    TagInfo tagInfo = nBPTagsEditViewModel.selectedMBTITag;
                    if (tagInfo != null) {
                        a aVar2 = tagInfo.tag;
                        int i17 = aVar2.f435362d;
                        if ((10000 <= i17 && i17 < 11112) && aVar2.f435363e.length() >= 4) {
                            for (int i18 = 0; i18 < 4; i18++) {
                                if (Intrinsics.areEqual(nBPTagsEditViewModel.mbtiTags.get(i18).leftTag, String.valueOf(tagInfo.tag.f435363e.charAt(i18)))) {
                                    nBPTagsEditViewModel.mbtiTags.get(i18).setSelectTag(0);
                                } else {
                                    nBPTagsEditViewModel.mbtiTags.get(i18).setSelectTag(1);
                                }
                            }
                            nBPTagsEditViewModel.getSelectedMBTI().addAll(nBPTagsEditViewModel.mbtiTags);
                        }
                    }
                }
                NBPTagsEditViewModel.this.setState(NBPTagsEditViewModel.TagState.SUCCESS);
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$fetchAllTags$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                NBPTagsEditViewModel.this.setState(NBPTagsEditViewModel.TagState.ERROR);
                return Unit.INSTANCE;
            }
        };
        if (QQKuiklyPlatformApi.Companion.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
            function2.invoke(-1, "network unreachable");
            return;
        }
        l lVar = new l(0);
        Function1<PbResponse<u35.b>, Unit> function12 = new Function1<PbResponse<u35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.repository.NBPNewEditRepository$fetchAllTags$1
            public final /* synthetic */ int $source = 0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<u35.b> pbResponse) {
                PbResponse<u35.b> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchAllTags: appId:");
                m3.append(i3);
                m3.append(", source:");
                m3.append(this.$source);
                m3.append(", proxy retcode:");
                m3.append(pbResponse2.code);
                m3.append(", rsp return code:");
                u35.b bVar = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewEditRepository");
                if (pbResponse2.success && pbResponse2.rsp != null) {
                    try {
                        m mVar = new m(0, null, null, 7, null);
                        u35.b bVar2 = pbResponse2.rsp;
                        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                        List<b> list = ((m) i.b(mVar, bVar2.f438203f.f30291a)).f433252f;
                        if (list.isEmpty()) {
                            function2.invoke(-1, "tag-list is empty");
                        } else {
                            function1.invoke(list);
                        }
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchAllTags decode error: ", th5, KLog.INSTANCE, "NBPNewEditRepository");
                        function2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                    }
                } else {
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchAllTags error:");
                    m16.append(pbResponse2.code);
                    kLog.e("NBPNewEditRepository", m16.toString());
                    function2.invoke(Integer.valueOf(pbResponse2.code), "");
                }
                return Unit.INSTANCE;
            }
        };
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoGetDefaultTag", i3, new c45.a(i.d(lVar))));
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(function12), qQStrangerSsoRequest, null, 6);
    }

    public final e getDtTAGPageParam() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.t("nearby_kl_appid", this.appId);
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_tag_edit");
        e eVar = new e();
        eVar.t("nearby_kl_appid", this.appId);
        Unit unit = Unit.INSTANCE;
        nearbyDTBaseParams.v("cur_pg", eVar);
        return nearbyDTBaseParams;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo>] */
    public final TagInfo getMBTITag() {
        List sortedWith;
        String joinToString$default;
        if (!isMBTITagValid()) {
            return null;
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(getSelectedMBTI(), new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$getMBTITag$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((MBTITagAttr) t16).index), Integer.valueOf(((MBTITagAttr) t17).index));
                return compareValues;
            }
        });
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "", null, null, 0, null, new Function1<MBTITagAttr, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$getMBTITag$tagName$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MBTITagAttr mBTITagAttr) {
                MBTITagAttr mBTITagAttr2 = mBTITagAttr;
                if (mBTITagAttr2.getSelectTag() == 0) {
                    return mBTITagAttr2.leftTag;
                }
                return mBTITagAttr2.rightTag;
            }
        }, 30, null);
        return (TagInfo) this.mbtiTagMap.get(joinToString$default);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<MBTITagAttr> getSelectedMBTI() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedMBTI$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<TagInfo> getSelectedTags() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedTags$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final TagState getState() {
        return (TagState) this.state$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable>, java.util.ArrayList] */
    public final void handleOnSizeChanged(float f16) {
        float f17;
        ?? r06 = this.tagTabList;
        ArrayList arrayList = new ArrayList();
        Iterator it = r06.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((TagTabObservable) next).tagType != 10000) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            TagTabObservable tagTabObservable = (TagTabObservable) it5.next();
            tagTabObservable.pageViewWidth = f16;
            if (!tagTabObservable.tags.isEmpty()) {
                float f18 = tagTabObservable.pageViewWidth - 32.0f;
                tagTabObservable.tagLines$delegate.setValue(tagTabObservable, TagTabObservable.$$delegatedProperties[0], 1);
                float f19 = 0.0f;
                int i3 = 0;
                for (Object obj : tagTabObservable.tags) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    float f26 = ((TagInfo) obj).viewWith;
                    if (f19 + f26 > f18) {
                        tagTabObservable.tagLines$delegate.setValue(tagTabObservable, TagTabObservable.$$delegatedProperties[0], Integer.valueOf(tagTabObservable.getTagLines() + 1));
                        f17 = f26 + 12.0f;
                    } else {
                        f17 = f26 + 12.0f + f19;
                    }
                    f19 = f17;
                    if (i3 == tagTabObservable.tags.size() - 1) {
                        tagTabObservable.collapsedSpaceEnough$delegate.setValue(tagTabObservable, TagTabObservable.$$delegatedProperties[3], Boolean.valueOf(f18 - f19 >= 46.0f));
                    }
                    i3 = i16;
                }
            }
            if (tagTabObservable.getExpanded()) {
                tagTabObservable.getTagList().clear();
                tagTabObservable.getTagList().addAll(tagTabObservable.tags);
            } else {
                tagTabObservable.getCollapsedTags();
            }
        }
    }

    public final boolean hitSelectTagMaxLimit() {
        if (getSelectedTags().size() < 20) {
            return false;
        }
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().qToast("\u6dfb\u52a0\u592a\u591a\u6807\u7b7e\u5566", QToastMode.Info);
        e dtTAGPageParam = getDtTAGPageParam();
        dtTAGPageParam.v("dt_imp", "em_nearby_kl_overmuch_tag_toast");
        dtTAGPageParam.v("dt_eid", "em_nearby_kl_overmuch_tag_toast");
        dtTAGPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        utils.currentBridgeModule().reportCustomDtEvent("dt_imp", dtTAGPageParam);
        return true;
    }

    public final boolean isMBTITagValid() {
        com.tencent.kuikly.core.reactive.collection.c<MBTITagAttr> selectedMBTI = getSelectedMBTI();
        ArrayList arrayList = new ArrayList();
        Iterator<MBTITagAttr> it = selectedMBTI.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MBTITagAttr next = it.next();
            if (next.getSelectTag() != -1) {
                arrayList.add(next);
            }
        }
        return arrayList.size() == 4;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo>, java.lang.Iterable, java.util.ArrayList] */
    public final boolean isTagsModified() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        com.tencent.kuikly.core.reactive.collection.c<TagInfo> selectedTags = getSelectedTags();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTags, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<TagInfo> it = selectedTags.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().tag.f435362d));
        }
        ?? r06 = this.rawTags;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(r06, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = r06.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Integer.valueOf(((TagInfo) it5.next()).tag.f435362d));
        }
        return !Intrinsics.areEqual(arrayList, arrayList2);
    }

    public final void setState(TagState tagState) {
        this.state$delegate.setValue(this, $$delegatedProperties[1], tagState);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagViewAttr>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagViewAttr>] */
    public final void toggleTag(TagInfo tagInfo) {
        if (!getSelectedTags().contains(tagInfo)) {
            getSelectedTags().add(tagInfo);
            OptionalTagViewAttr optionalTagViewAttr = (OptionalTagViewAttr) this.allTagsSet.get(Integer.valueOf(tagInfo.tag.f435362d));
            if (optionalTagViewAttr != null) {
                optionalTagViewAttr.setSelected(true);
            }
            e dtTAGPageParam = getDtTAGPageParam();
            dtTAGPageParam.v("dt_eid", "em_nearby_kl_add_tag");
            dtTAGPageParam.v("nearby_kl_tag_id", String.valueOf(tagInfo.tag.f435362d));
            dtTAGPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtTAGPageParam);
            return;
        }
        getSelectedTags().remove(tagInfo);
        OptionalTagViewAttr optionalTagViewAttr2 = (OptionalTagViewAttr) this.allTagsSet.get(Integer.valueOf(tagInfo.tag.f435362d));
        if (optionalTagViewAttr2 != null) {
            optionalTagViewAttr2.setSelected(false);
        }
        int i3 = tagInfo.tag.f435362d;
        if (10000 <= i3 && i3 < 11112) {
            Iterator<MBTITagAttr> it = getSelectedMBTI().iterator();
            while (it.hasNext()) {
                it.next().setSelectTag(-1);
            }
            getSelectedMBTI().clear();
        }
    }

    public final void updateTagInfo() {
        int collectionSizeOrDefault;
        List distinct;
        List mutableList;
        if (!NearbyProUtilsKt.checkEditAccess(this.appId)) {
            KLog.INSTANCE.e("NBPTagsEditViewModel", "Illegal path, no access to edit");
            return;
        }
        com.tencent.kuikly.core.reactive.collection.c<TagInfo> selectedTags = getSelectedTags();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTags, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<TagInfo> it = selectedTags.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().tag.f435362d));
        }
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        int i3 = this.appId;
        Function1<ae, Unit> function1 = new Function1<ae, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$updateTagInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ae aeVar) {
                ae aeVar2 = aeVar;
                if (aeVar2 != null && aeVar2.f433200d == 0) {
                    com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                    Iterator<TagInfo> it5 = NBPTagsEditViewModel.this.getSelectedTags().iterator();
                    while (it5.hasNext()) {
                        TagInfo next = it5.next();
                        e eVar = new e();
                        eVar.t("tagId", next.tag.f435362d);
                        eVar.v("tagName", next.tag.f435363e);
                        bVar.t(eVar);
                    }
                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                    e eVar2 = new e();
                    eVar2.t("itemId", 9);
                    eVar2.v("value", bVar);
                    Unit unit = Unit.INSTANCE;
                    k.d(kVar, "onNearbyProUserInfoChange", eVar2, false, 4, null);
                    final NBPTagsEditViewModel nBPTagsEditViewModel = NBPTagsEditViewModel.this;
                    TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$updateTagInfo$1.3
                        {
                            super(0);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:10:0x007c, code lost:
                        
                            r2 = kotlin.text.StringsKt__StringsJVMKt.encodeToByteArray(r2);
                         */
                        @Override // kotlin.jvm.functions.Function0
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke() {
                            List shuffled;
                            List take;
                            int collectionSizeOrDefault2;
                            byte[] encodeToByteArray;
                            byte[][] bArr;
                            byte[] encodeToByteArray2;
                            Utils.INSTANCE.currentBridgeModule().qToast("\u6807\u7b7e\u4fee\u6539\u6210\u529f", QToastMode.Success);
                            if (NBPTagsEditViewModel.this.appId == 2) {
                                e eVar3 = new e();
                                NBPTagsEditViewModel nBPTagsEditViewModel2 = NBPTagsEditViewModel.this;
                                com.tencent.kuikly.core.nvi.serialization.json.b bVar2 = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                shuffled = CollectionsKt__CollectionsJVMKt.shuffled(nBPTagsEditViewModel2.getSelectedTags());
                                take = CollectionsKt___CollectionsKt.take(shuffled, 12);
                                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10);
                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                                Iterator it6 = take.iterator();
                                while (it6.hasNext()) {
                                    arrayList2.add(bVar2.t(i.c(((TagInfo) it6.next()).tag)));
                                }
                                Unit unit2 = Unit.INSTANCE;
                                eVar3.v("tagList", bVar2);
                                encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(eVar3.toString());
                                e dtTAGPageParam = NBPTagsEditViewModel.this.getDtTAGPageParam();
                                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                String eVar4 = dtTAGPageParam.toString();
                                if (eVar4 != null && encodeToByteArray2 != null) {
                                    bArr = new byte[][]{encodeToByteArray, encodeToByteArray2};
                                } else {
                                    bArr = new byte[][]{encodeToByteArray};
                                }
                                companion.setSharePenetratePageData(bArr);
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearbypro_guide_tag_publish&modal_mode=1", false, 4);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return Unit.INSTANCE;
            }
        };
        NBPTagsEditViewModel$updateTagInfo$2 nBPTagsEditViewModel$updateTagInfo$2 = NBPTagsEditViewModel$updateTagInfo$2.INSTANCE;
        if (QQKuiklyPlatformApi.Companion.getNetworkType() != QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) distinct);
            ad adVar = new ad(mutableList, 0, 0);
            NBPNewHomeRepository$updateTagsInfo$1 nBPNewHomeRepository$updateTagsInfo$1 = new NBPNewHomeRepository$updateTagsInfo$1(i3, function1, nBPTagsEditViewModel$updateTagInfo$2);
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoUpdateUserTags", i3, new c45.a(i.d(adVar))));
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$updateTagsInfo$1), qQStrangerSsoRequest, null, 6);
            return;
        }
        nBPTagsEditViewModel$updateTagInfo$2.invoke(-1, "network unreachable");
    }
}
