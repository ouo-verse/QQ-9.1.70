package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSectionViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$requestWithCmd$1;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusAgeRange;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCity;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCrowdOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPortraitOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusProfileOption;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryInterestTagsRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusTag;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverViewModel.class, "hasSelectCustomOption", "getHasSelectCustomOption()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverViewModel.class, "uploadUrlList", "getUploadUrlList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverViewModel.class, "uploadLoading", "getUploadLoading()Z", 0)};
    public final ArrayList<QPlusAgeRange> ageRangeItemValue;
    public final Lazy ageReceiverSectionViewModel$delegate;
    public final Lazy cityReceiverSectionViewModel$delegate;
    public final Lazy crowdReceiverSectionViewModel$delegate;
    public final ReadWriteProperty hasSelectCustomOption$delegate;
    public final Lazy interestReceiverSectionViewModel$delegate;
    public boolean isRequestingGroupInfo;
    public boolean isRequestingInterestInfo;
    public final Lazy sexReceiverSectionViewModel$delegate;
    public final ReadWriteProperty uploadLoading$delegate;
    public final ReadWriteProperty uploadUrlList$delegate;
    public final String uploadingNotificationName;
    public ArrayList<QPlusTag> selectedTags = new ArrayList<>();
    public ArrayList<QPlusCity> selectedCity = new ArrayList<>();
    public ArrayList<String> selectedCityNames = new ArrayList<>();
    public int sexType = 1;
    public ArrayList<QPlusAgeRange> ageRange = new ArrayList<>();
    public QPlusCrowdOption crowdOption = new QPlusCrowdOption();
    public ArrayList<QPPromoteReceiverPortraitListItem> selectedGroupList = new ArrayList<>();
    public ArrayList<QPPromoteReceiverPortraitListItem> selectedCreatorList = new ArrayList<>();

    public QPPromoteReceiverViewModel() {
        k notifyModule;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        ArrayList<QPlusAgeRange> arrayListOf;
        Boolean bool = Boolean.FALSE;
        this.hasSelectCustomOption$delegate = c.a(bool);
        this.uploadUrlList$delegate = c.b();
        this.uploadingNotificationName = "QPlusUploadingNotification";
        this.uploadLoading$delegate = c.a(bool);
        notifyModule = Utils.INSTANCE.notifyModule("");
        k.b(notifyModule, "QPlusUploadingNotification", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                qPPromoteReceiverViewModel.uploadLoading$delegate.setValue(qPPromoteReceiverViewModel, QPPromoteReceiverViewModel.$$delegatedProperties[2], Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }, 2, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$sexReceiverSectionViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                ArrayList arrayListOf2;
                ArrayList arrayListOf3;
                QPPromoteReceiverItem qPPromoteReceiverItem;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$sexReceiverSectionViewModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem2, Function1<? super Boolean, ? extends Unit> function1) {
                        Object first;
                        function1.invoke(Boolean.TRUE);
                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                        com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverItem> selectItems = qPPromoteReceiverSectionViewModel.getSelectItems();
                        KProperty<Object>[] kPropertyArr = QPPromoteReceiverViewModel.$$delegatedProperties;
                        qPPromoteReceiverViewModel2.getClass();
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) selectItems);
                        qPPromoteReceiverViewModel2.sexType = ((QPPromoteReceiverItem) first).getLabelValue();
                        return Unit.INSTANCE;
                    }
                };
                qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem(IProfileCardConst.NAME_NO_LIMIT, 1, 0, true, true, (Function3) function3, 64));
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("\u7537", "\u5973");
                arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(2, 3);
                int i3 = 0;
                for (int size = arrayListOf2.size(); i3 < size; size = size) {
                    qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem((String) arrayListOf2.get(i3), ((Number) arrayListOf3.get(i3)).intValue(), 0, true, false, (Function3) function3, 64));
                    i3++;
                }
                ArrayList<QPPromoteReceiverItem> arrayList = new ArrayList<>();
                if (qPPromoteReceiverViewModel.sexType > 1) {
                    Iterator<QPPromoteReceiverItem> it = qPPromoteReceiverSectionViewModel.items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            qPPromoteReceiverItem = null;
                            break;
                        }
                        qPPromoteReceiverItem = it.next();
                        if (qPPromoteReceiverItem.getLabelValue() == qPPromoteReceiverViewModel.sexType) {
                            break;
                        }
                    }
                    QPPromoteReceiverItem qPPromoteReceiverItem2 = qPPromoteReceiverItem;
                    if (qPPromoteReceiverItem2 != null) {
                        arrayList.add(qPPromoteReceiverItem2);
                    }
                }
                qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayList);
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.sexReceiverSectionViewModel$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$ageReceiverSectionViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                ArrayList arrayListOf2;
                QPPromoteReceiverItem qPPromoteReceiverItem;
                QPlusAgeRange qPlusAgeRange;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$ageReceiverSectionViewModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem2, Function1<? super Boolean, ? extends Unit> function1) {
                        function1.invoke(Boolean.TRUE);
                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                        com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverItem> selectItems = qPPromoteReceiverSectionViewModel.getSelectItems();
                        qPPromoteReceiverViewModel2.ageRange.clear();
                        Iterator<QPPromoteReceiverItem> it = selectItems.iterator();
                        boolean z16 = false;
                        while (it.hasNext()) {
                            QPPromoteReceiverItem next = it.next();
                            if (next.getLabelValue() == 0) {
                                z16 = true;
                            } else if (next.labelIndex < qPPromoteReceiverViewModel2.ageRangeItemValue.size()) {
                                qPPromoteReceiverViewModel2.ageRange.add(qPPromoteReceiverViewModel2.ageRangeItemValue.get(next.labelIndex));
                            }
                        }
                        if (z16) {
                            qPPromoteReceiverViewModel2.ageRange.clear();
                        }
                        return Unit.INSTANCE;
                    }
                };
                qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem(IProfileCardConst.NAME_NO_LIMIT, 0, 0, true, true, (Function3) function3, 64));
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("18~24\u5c81", "25~29\u5c81", "30~39\u5c81", "40~49\u5c81", "50\u5c81\u4ee5\u4e0a");
                int size = arrayListOf2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem((String) arrayListOf2.get(i3), 1, i3, false, false, (Function3) function3, 64));
                }
                ArrayList<QPPromoteReceiverItem> arrayList = new ArrayList<>();
                if (!qPPromoteReceiverViewModel.ageRange.isEmpty()) {
                    int i16 = 0;
                    for (Object obj : qPPromoteReceiverViewModel.ageRangeItemValue) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        QPlusAgeRange qPlusAgeRange2 = (QPlusAgeRange) obj;
                        Iterator<QPlusAgeRange> it = qPPromoteReceiverViewModel.ageRange.iterator();
                        while (true) {
                            qPPromoteReceiverItem = null;
                            if (!it.hasNext()) {
                                qPlusAgeRange = null;
                                break;
                            }
                            qPlusAgeRange = it.next();
                            QPlusAgeRange qPlusAgeRange3 = qPlusAgeRange;
                            if (qPlusAgeRange3.f114256to == qPlusAgeRange2.f114256to && qPlusAgeRange3.from == qPlusAgeRange2.from) {
                                break;
                            }
                        }
                        if (qPlusAgeRange != null) {
                            Iterator<QPPromoteReceiverItem> it5 = qPPromoteReceiverSectionViewModel.items.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                QPPromoteReceiverItem next = it5.next();
                                QPPromoteReceiverItem qPPromoteReceiverItem2 = next;
                                if (qPPromoteReceiverItem2.labelIndex == i16 && qPPromoteReceiverItem2.getLabelValue() != 0) {
                                    qPPromoteReceiverItem = next;
                                    break;
                                }
                            }
                            QPPromoteReceiverItem qPPromoteReceiverItem3 = qPPromoteReceiverItem;
                            if (qPPromoteReceiverItem3 != null) {
                                arrayList.add(qPPromoteReceiverItem3);
                            }
                        }
                        i16 = i17;
                    }
                }
                qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayList);
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.ageReceiverSectionViewModel$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$cityReceiverSectionViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                String str;
                ArrayList<QPPromoteReceiverItem> arrayListOf2;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$cityReceiverSectionViewModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit> function1) {
                        final QPPromoteReceiverItem qPPromoteReceiverItem2 = qPPromoteReceiverItem;
                        final Function1<? super Boolean, ? extends Unit> function12 = function1;
                        if (qPPromoteReceiverItem2.getLabelValue() > 0) {
                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                            final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel3 = qPPromoteReceiverSectionViewModel;
                            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$cityReceiverSectionViewModel$2$1$callBackBlock$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool2) {
                                    if (!bool2.booleanValue()) {
                                        function12.invoke(Boolean.FALSE);
                                    } else {
                                        if (qPPromoteReceiverSectionViewModel3.hasSelectItem(qPPromoteReceiverItem2)) {
                                            function12.invoke(Boolean.FALSE);
                                        } else {
                                            function12.invoke(Boolean.TRUE);
                                        }
                                        qPPromoteReceiverSectionViewModel3.setDescLabel(QPPromoteReceiverViewModel.access$generatePromoteCityDesc(qPPromoteReceiverViewModel2));
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            KProperty<Object>[] kPropertyArr = QPPromoteReceiverViewModel.$$delegatedProperties;
                            qPPromoteReceiverViewModel2.getClass();
                            b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
                            e eVar = new e();
                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                            Iterator<QPlusCity> it = qPPromoteReceiverViewModel2.selectedCity.iterator();
                            while (it.hasNext()) {
                                bVar.t(it.next().encode());
                            }
                            Unit unit = Unit.INSTANCE;
                            eVar.v("selectedCityJSONArray", bVar);
                            IPagerIdKtxKt.openPageForResult$default(g16, "mqqapi://kuikly/open?target=52&page_name=qplus_receiver_city_page&modal_mode=1&src_type=internal&version=1&bundle_name=new_qecommerce", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteSelectCityClk$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(e eVar2) {
                                    e eVar3 = eVar2;
                                    if (eVar3 != null) {
                                        Function1<Boolean, Unit> function14 = function13;
                                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = qPPromoteReceiverViewModel2;
                                        if (!eVar3.f("has_custom_select_city")) {
                                            function14.invoke(Boolean.FALSE);
                                        } else {
                                            com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar3.l("city_result");
                                            if (l3 != null) {
                                                qPPromoteReceiverViewModel3.selectedCity.clear();
                                                qPPromoteReceiverViewModel3.selectedCityNames.clear();
                                                int c16 = l3.c();
                                                for (int i3 = 0; i3 < c16; i3++) {
                                                    e l16 = l3.l(i3);
                                                    if (l16 != null) {
                                                        String p16 = l16.p("name");
                                                        e m3 = l16.m("city");
                                                        QPlusCity qPlusCity = m3 != null ? new QPlusCity(m3.k("city_code", 0), m3.k("city_level", 0)) : null;
                                                        if (qPlusCity != null) {
                                                            qPPromoteReceiverViewModel3.selectedCity.add(qPlusCity);
                                                            qPPromoteReceiverViewModel3.selectedCityNames.add(p16);
                                                        }
                                                    }
                                                }
                                                function14.invoke(Boolean.TRUE);
                                            } else {
                                                function14.invoke(Boolean.FALSE);
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, 2);
                        } else {
                            QPPromoteReceiverViewModel.this.selectedCity.clear();
                            QPPromoteReceiverViewModel.this.selectedCityNames.clear();
                            qPPromoteReceiverSectionViewModel.setDescLabel("");
                            function12.invoke(Boolean.TRUE);
                        }
                        return Unit.INSTANCE;
                    }
                };
                qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem(IProfileCardConst.NAME_NO_LIMIT, 0, 0, true, true, (Function3) function3, 64));
                QPPromoteReceiverItem qPPromoteReceiverItem = new QPPromoteReceiverItem("\u5730\u533a", 1, 0, true, false, (Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit>) function3, true);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem);
                if (!qPPromoteReceiverViewModel.selectedCity.isEmpty()) {
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(qPPromoteReceiverItem);
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayListOf2);
                    str = QPPromoteReceiverViewModel.access$generatePromoteCityDesc(qPPromoteReceiverViewModel);
                } else {
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(null);
                    str = "";
                }
                qPPromoteReceiverSectionViewModel.setDescLabel(str);
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.cityReceiverSectionViewModel$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$interestReceiverSectionViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                String str;
                ArrayList<QPPromoteReceiverItem> arrayListOf2;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$interestReceiverSectionViewModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit> function1) {
                        final QPPromoteReceiverItem qPPromoteReceiverItem2 = qPPromoteReceiverItem;
                        final Function1<? super Boolean, ? extends Unit> function12 = function1;
                        if (qPPromoteReceiverItem2.getLabelValue() > 0) {
                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                            final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel3 = qPPromoteReceiverSectionViewModel;
                            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$interestReceiverSectionViewModel$2$1$callBackBlock$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool2) {
                                    if (!bool2.booleanValue()) {
                                        function12.invoke(Boolean.FALSE);
                                    } else {
                                        if (qPPromoteReceiverSectionViewModel3.hasSelectItem(qPPromoteReceiverItem2)) {
                                            function12.invoke(Boolean.FALSE);
                                        } else {
                                            function12.invoke(Boolean.TRUE);
                                        }
                                        qPPromoteReceiverSectionViewModel3.setDescLabel(QPPromoteReceiverViewModel.access$generatePromoteInterestDesc(qPPromoteReceiverViewModel2));
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            if (qPPromoteReceiverViewModel2.isRequestingInterestInfo) {
                                Utils.INSTANCE.currentBridgeModule().toast("\u8bf7\u6c42\u5174\u8da3\u6570\u636e\u4e2d...");
                            } else {
                                qPPromoteReceiverViewModel2.isRequestingInterestInfo = true;
                                QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
                                final Function1<QPlusQueryInterestTagsRsp, Unit> function14 = new Function1<QPlusQueryInterestTagsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteInterestClk$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPlusQueryInterestTagsRsp qPlusQueryInterestTagsRsp) {
                                        QPPromoteReceiverViewModel.this.isRequestingInterestInfo = false;
                                        b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
                                        e eVar = new e();
                                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                                        eVar.v("tagsRsp", qPlusQueryInterestTagsRsp.encode());
                                        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                        Iterator<QPlusTag> it = qPPromoteReceiverViewModel3.selectedTags.iterator();
                                        while (it.hasNext()) {
                                            bVar.t(it.next().encode());
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        eVar.v("selectedTags", bVar);
                                        final Function1<Boolean, Unit> function15 = function13;
                                        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = QPPromoteReceiverViewModel.this;
                                        IPagerIdKtxKt.openPageForResult$default(g16, "mqqapi://kuikly/open?target=52&page_name=qplus_receiver_interest_page&modal_mode=1&version=1&src_type=internal&bundle_name=new_qecommerce", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteInterestClk$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(e eVar2) {
                                                e eVar3 = eVar2;
                                                if (eVar3 != null) {
                                                    Function1<Boolean, Unit> function16 = function15;
                                                    QPPromoteReceiverViewModel qPPromoteReceiverViewModel5 = qPPromoteReceiverViewModel4;
                                                    com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar3.l("selectedTags");
                                                    if (l3 != null) {
                                                        qPPromoteReceiverViewModel5.selectedTags.clear();
                                                        int c16 = l3.c();
                                                        for (int i3 = 0; i3 < c16; i3++) {
                                                            e l16 = l3.l(i3);
                                                            if (l16 != null) {
                                                                qPPromoteReceiverViewModel5.selectedTags.add(new QPlusTag(l16.q("tag_name", "")));
                                                            }
                                                        }
                                                        function16.invoke(Boolean.TRUE);
                                                    } else {
                                                        function16.invoke(Boolean.FALSE);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, 2);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteInterestClk$2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Integer num, String str2) {
                                        num.intValue();
                                        QPPromoteReceiverViewModel.this.isRequestingInterestInfo = false;
                                        Utils.INSTANCE.currentBridgeModule().toast("\u7f51\u8def\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                                        return Unit.INSTANCE;
                                    }
                                };
                                QPlusQueryInterestTagsRsp qPlusQueryInterestTagsRsp = new QPlusQueryInterestTagsRsp(null);
                                Function2<QPlusQueryInterestTagsRsp, String, Unit> function22 = new Function2<QPlusQueryInterestTagsRsp, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqPromoteInterestTags$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(QPlusQueryInterestTagsRsp qPlusQueryInterestTagsRsp2, String str2) {
                                        function14.invoke(qPlusQueryInterestTagsRsp2);
                                        return Unit.INSTANCE;
                                    }
                                };
                                Function2<Integer, String, Unit> function23 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqPromoteInterestTags$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Integer num, String str2) {
                                        int intValue = num.intValue();
                                        function2.invoke(Integer.valueOf(intValue), str2);
                                        return Unit.INSTANCE;
                                    }
                                };
                                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                e eVar = new e();
                                QPlusTrafficRepository$requestWithCmd$1 qPlusTrafficRepository$requestWithCmd$1 = new QPlusTrafficRepository$requestWithCmd$1(function23, qPlusQueryInterestTagsRsp, function22);
                                int i3 = BridgeModule.$r8$clinit;
                                currentBridgeModule.ssoRequest("trpc.ecom.qplus_deliver_access_svr.QplusAccessSvr/QueryInterestTags", eVar, false, qPlusTrafficRepository$requestWithCmd$1);
                            }
                        } else {
                            QPPromoteReceiverViewModel.this.selectedTags.clear();
                            qPPromoteReceiverSectionViewModel.setDescLabel("");
                            function12.invoke(Boolean.TRUE);
                        }
                        return Unit.INSTANCE;
                    }
                };
                qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem(IProfileCardConst.NAME_NO_LIMIT, 0, 0, true, true, (Function3) function3, 64));
                QPPromoteReceiverItem qPPromoteReceiverItem = new QPPromoteReceiverItem("\u5174\u8da3", 1, 0, true, false, (Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit>) function3, true);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem);
                if (!qPPromoteReceiverViewModel.selectedTags.isEmpty()) {
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(qPPromoteReceiverItem);
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayListOf2);
                    str = QPPromoteReceiverViewModel.access$generatePromoteInterestDesc(qPPromoteReceiverViewModel);
                } else {
                    qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(null);
                    str = "";
                }
                qPPromoteReceiverSectionViewModel.setDescLabel(str);
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.interestReceiverSectionViewModel$delegate = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverSectionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$crowdReceiverSectionViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverSectionViewModel invoke() {
                String str;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = new QPPromoteReceiverSectionViewModel();
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit> function3 = new Function3<QPPromoteReceiverSectionViewModel, QPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$crowdReceiverSectionViewModel$2$1$callBackBlock$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2, QPPromoteReceiverItem qPPromoteReceiverItem, Function1<? super Boolean, ? extends Unit> function1) {
                        final QPPromoteReceiverItem qPPromoteReceiverItem2 = qPPromoteReceiverItem;
                        final Function1<? super Boolean, ? extends Unit> function12 = function1;
                        int labelValue = qPPromoteReceiverItem2.getLabelValue();
                        if (labelValue == 1) {
                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                            final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel3 = qPPromoteReceiverSectionViewModel;
                            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$crowdReceiverSectionViewModel$2$1$callBackBlock$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool2) {
                                    if (!bool2.booleanValue()) {
                                        function12.invoke(Boolean.FALSE);
                                    } else {
                                        if (qPPromoteReceiverSectionViewModel3.hasSelectItem(qPPromoteReceiverItem2)) {
                                            function12.invoke(Boolean.FALSE);
                                        } else {
                                            function12.invoke(Boolean.TRUE);
                                        }
                                        qPPromoteReceiverSectionViewModel3.setDescLabel(QPPromoteReceiverViewModel.access$generatePromoteGroupPortraitDesc(qPPromoteReceiverViewModel2));
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            if (qPPromoteReceiverViewModel2.isRequestingGroupInfo) {
                                Utils.INSTANCE.currentBridgeModule().toast("\u8bf7\u6c42\u7fa4\u6570\u636e\u4e2d...");
                            } else {
                                qPPromoteReceiverViewModel2.isRequestingGroupInfo = true;
                                Utils.INSTANCE.currentBridgeModule().callNativeMethod("getFullGroupListInfo", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteGroupPortraitClk$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar) {
                                        e eVar2 = eVar;
                                        QPPromoteReceiverViewModel.this.isRequestingGroupInfo = false;
                                        if (eVar2 == null) {
                                            Utils.INSTANCE.currentBridgeModule().toast("\u83b7\u53d6\u7fa4\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                                        } else {
                                            b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
                                            e eVar3 = new e();
                                            QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                                            com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar2.l("groupList");
                                            if (l3 != null) {
                                                eVar3.v("allGroupList", l3);
                                            }
                                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                            Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverViewModel3.selectedGroupList.iterator();
                                            while (it.hasNext()) {
                                                bVar.t(it.next().encode());
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            eVar3.v("selectedGroupList", bVar);
                                            final Function1<Boolean, Unit> function14 = function13;
                                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = QPPromoteReceiverViewModel.this;
                                            IPagerIdKtxKt.openPageForResult$default(g16, "mqqapi://kuikly/open?target=52&page_name=qplus_traffic_promote_group&src_type=internal&version=1&bundle_name=new_qecommerce", eVar3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteGroupPortraitClk$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(e eVar4) {
                                                    e eVar5 = eVar4;
                                                    if (eVar5 != null) {
                                                        Function1<Boolean, Unit> function15 = function14;
                                                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel5 = qPPromoteReceiverViewModel4;
                                                        com.tencent.kuikly.core.nvi.serialization.json.b l16 = eVar5.l("selectedGroupList");
                                                        if (l16 != null) {
                                                            qPPromoteReceiverViewModel5.selectedGroupList.clear();
                                                            ArrayList arrayList = new ArrayList();
                                                            int c16 = l16.c();
                                                            for (int i3 = 0; i3 < c16; i3++) {
                                                                e l17 = l16.l(i3);
                                                                if (l17 != null) {
                                                                    QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem = new QPPromoteReceiverPortraitListItem(l17.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(l17.p("name")), l17.p("icon"), l17.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), l17.f("isBlueV"), l17.f("isBigV"));
                                                                    qPPromoteReceiverViewModel5.selectedGroupList.add(qPPromoteReceiverPortraitListItem);
                                                                    arrayList.add(Long.valueOf(Long.parseLong(qPPromoteReceiverPortraitListItem.uin)));
                                                                }
                                                            }
                                                            qPPromoteReceiverViewModel5.crowdOption = new QPlusCrowdOption(arrayList, qPPromoteReceiverViewModel5.crowdOption.creatorIds);
                                                            function15.invoke(Boolean.TRUE);
                                                        } else {
                                                            function15.invoke(Boolean.FALSE);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }, 2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        } else if (labelValue != 2) {
                            qPPromoteReceiverSectionViewModel.setDescLabel("");
                            qPPromoteReceiverSectionViewModel.setSubDescLabel("");
                            QPPromoteReceiverViewModel.this.selectedGroupList.clear();
                            QPPromoteReceiverViewModel.this.selectedCreatorList.clear();
                            ArrayList<Long> arrayList = QPPromoteReceiverViewModel.this.crowdOption.creatorIds;
                            if (arrayList != null) {
                                arrayList.clear();
                            }
                            ArrayList<Long> arrayList2 = QPPromoteReceiverViewModel.this.crowdOption.qqGroupIds;
                            if (arrayList2 != null) {
                                arrayList2.clear();
                            }
                            function12.invoke(Boolean.TRUE);
                        } else {
                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                            final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel4 = qPPromoteReceiverSectionViewModel;
                            final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$crowdReceiverSectionViewModel$2$1$callBackBlock$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool2) {
                                    if (!bool2.booleanValue()) {
                                        function12.invoke(Boolean.FALSE);
                                    } else {
                                        if (qPPromoteReceiverSectionViewModel4.hasSelectItem(qPPromoteReceiverItem2)) {
                                            function12.invoke(Boolean.FALSE);
                                        } else {
                                            function12.invoke(Boolean.TRUE);
                                        }
                                        qPPromoteReceiverSectionViewModel4.setSubDescLabel(QPPromoteReceiverViewModel.access$generatePromoteCreatorPortraitDesc(qPPromoteReceiverViewModel3));
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            KProperty<Object>[] kPropertyArr = QPPromoteReceiverViewModel.$$delegatedProperties;
                            qPPromoteReceiverViewModel3.getClass();
                            b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
                            e eVar = new e();
                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                            Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverViewModel3.selectedCreatorList.iterator();
                            while (it.hasNext()) {
                                bVar.t(it.next().encode());
                            }
                            Unit unit = Unit.INSTANCE;
                            eVar.v("selectedCreatorList", bVar);
                            IPagerIdKtxKt.openPageForResult$default(g16, "mqqapi://kuikly/open?target=52&page_name=qplus_promote_creator_portrait&src_type=internal&version=1&bundle_name=new_qecommerce", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel$handlePromoteCreatorPortraitClk$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(e eVar2) {
                                    e eVar3 = eVar2;
                                    if (eVar3 != null) {
                                        Function1<Boolean, Unit> function15 = function14;
                                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = qPPromoteReceiverViewModel3;
                                        com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar3.l("selectedCreatorList");
                                        if (l3 != null) {
                                            qPPromoteReceiverViewModel4.selectedCreatorList.clear();
                                            ArrayList arrayList3 = new ArrayList();
                                            int c16 = l3.c();
                                            for (int i3 = 0; i3 < c16; i3++) {
                                                e l16 = l3.l(i3);
                                                if (l16 != null) {
                                                    QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem = new QPPromoteReceiverPortraitListItem(l16.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(l16.p("name")), l16.p("icon"), l16.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), l16.f("isBlueV"), l16.f("isBigV"));
                                                    qPPromoteReceiverViewModel4.selectedCreatorList.add(qPPromoteReceiverPortraitListItem);
                                                    arrayList3.add(Long.valueOf(Long.parseLong(qPPromoteReceiverPortraitListItem.uin)));
                                                }
                                            }
                                            qPPromoteReceiverViewModel4.crowdOption = new QPlusCrowdOption(qPPromoteReceiverViewModel4.crowdOption.qqGroupIds, arrayList3);
                                            function15.invoke(Boolean.TRUE);
                                        } else {
                                            function15.invoke(Boolean.FALSE);
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, 2);
                        }
                        return Unit.INSTANCE;
                    }
                };
                qPPromoteReceiverSectionViewModel.hasQuestionIcon$delegate.setValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[3], Boolean.TRUE);
                qPPromoteReceiverSectionViewModel.alertInfo = new KTVAlertInfo("\u4eba\u7fa4\u753b\u50cf", "\u7cfb\u7edf\u5c06\u5206\u6790\u6307\u5b9a\u7fa4\u4f53\u5c5e\u6027\uff0c\u5c06\u4f5c\u54c1\u63a8\u8350\u7ed9\u7c7b\u4f3c\u4eba\u7fa4\u3002");
                qPPromoteReceiverSectionViewModel.items.add(new QPPromoteReceiverItem(IProfileCardConst.NAME_NO_LIMIT, 0, 0, true, true, (Function3) function3, 64));
                QPPromoteReceiverItem qPPromoteReceiverItem = new QPPromoteReceiverItem("\u7fa4\u753b\u50cf", 1, 1, false, false, (Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit>) function3, true);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem);
                QPPromoteReceiverItem qPPromoteReceiverItem2 = new QPPromoteReceiverItem("\u7c89\u4e1d\u753b\u50cf", 2, 2, false, false, (Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit>) function3, true);
                qPPromoteReceiverSectionViewModel.items.add(qPPromoteReceiverItem2);
                ArrayList<QPPromoteReceiverItem> arrayList = new ArrayList<>();
                String str2 = "";
                if (!(!qPPromoteReceiverViewModel.selectedGroupList.isEmpty())) {
                    str = "";
                } else {
                    arrayList.add(qPPromoteReceiverItem);
                    str = QPPromoteReceiverViewModel.access$generatePromoteGroupPortraitDesc(qPPromoteReceiverViewModel);
                }
                qPPromoteReceiverSectionViewModel.setDescLabel(str);
                if (!qPPromoteReceiverViewModel.selectedCreatorList.isEmpty()) {
                    arrayList.add(qPPromoteReceiverItem2);
                    str2 = QPPromoteReceiverViewModel.access$generatePromoteCreatorPortraitDesc(qPPromoteReceiverViewModel);
                }
                qPPromoteReceiverSectionViewModel.setSubDescLabel(str2);
                qPPromoteReceiverSectionViewModel.updateItemsOnFirstCreated(arrayList);
                return qPPromoteReceiverSectionViewModel;
            }
        });
        this.crowdReceiverSectionViewModel$delegate = lazy5;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusAgeRange(18, 24), new QPlusAgeRange(25, 29), new QPlusAgeRange(30, 39), new QPlusAgeRange(40, 49), new QPlusAgeRange(50, 99));
        this.ageRangeItemValue = arrayListOf;
    }

    public static final String access$generatePromoteCityDesc(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        int lastIndex;
        if (qPPromoteReceiverViewModel.selectedCityNames.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("\u5df2\u9009\u62e9\"");
        Iterator<String> it = qPPromoteReceiverViewModel.selectedCityNames.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("\u3001");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        Intrinsics.checkNotNullExpressionValue(sb5.deleteCharAt(lastIndex), "this.deleteCharAt(index)");
        sb5.append("\"");
        return sb5.toString();
    }

    public static final String access$generatePromoteCreatorPortraitDesc(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        int lastIndex;
        if (qPPromoteReceiverViewModel.selectedCreatorList.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("\u5df2\u9009\u62e9\"");
        Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverViewModel.selectedCreatorList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().name);
            sb5.append("\u3001");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        Intrinsics.checkNotNullExpressionValue(sb5.deleteCharAt(lastIndex), "this.deleteCharAt(index)");
        sb5.append("\"");
        return sb5.toString();
    }

    public static final String access$generatePromoteGroupPortraitDesc(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        int lastIndex;
        if (qPPromoteReceiverViewModel.selectedGroupList.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("\u5df2\u9009\u62e9\"");
        Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverViewModel.selectedGroupList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().name);
            sb5.append("\u3001");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        Intrinsics.checkNotNullExpressionValue(sb5.deleteCharAt(lastIndex), "this.deleteCharAt(index)");
        sb5.append("\"");
        return sb5.toString();
    }

    public static final String access$generatePromoteInterestDesc(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        int lastIndex;
        if (qPPromoteReceiverViewModel.selectedTags.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("\u5df2\u9009\u62e9\"");
        Iterator<QPlusTag> it = qPPromoteReceiverViewModel.selectedTags.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().tagName);
            sb5.append("\u3001");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        Intrinsics.checkNotNullExpressionValue(sb5.deleteCharAt(lastIndex), "this.deleteCharAt(index)");
        sb5.append("\"");
        return sb5.toString();
    }

    public final boolean getHasSelectCustomOption() {
        return ((Boolean) this.hasSelectCustomOption$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getUploadUrlList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.uploadUrlList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b5, code lost:
    
        if ((r3 != null && (r3.isEmpty() ^ true)) != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void closePage(boolean z16) {
        boolean z17;
        ArrayList<Long> arrayList;
        ArrayList<Long> arrayList2;
        if (z16) {
            b k3 = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u());
            QPlusPortraitOption qPlusPortraitOption = new QPlusPortraitOption(null);
            int i3 = 1;
            if (!getUploadUrlList().isEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(getUploadUrlList());
                qPlusPortraitOption = new QPlusPortraitOption(arrayList3);
            }
            int i16 = this.sexType;
            ArrayList<QPlusAgeRange> arrayList4 = this.ageRange;
            ArrayList<QPlusCity> arrayList5 = this.selectedCity;
            ArrayList<QPlusTag> arrayList6 = this.selectedTags;
            QPlusCrowdOption qPlusCrowdOption = this.crowdOption;
            QPlusProfileOption qPlusProfileOption = new QPlusProfileOption(i16, arrayList4, arrayList5, arrayList6, qPlusCrowdOption, qPlusPortraitOption);
            if (getHasSelectCustomOption()) {
                if (i16 <= 1) {
                    z17 = false;
                    if (!(arrayList4 != null && (arrayList4.isEmpty() ^ true))) {
                        if (!(arrayList5 != null && (arrayList5.isEmpty() ^ true))) {
                            if (!(arrayList6 != null && (arrayList6.isEmpty() ^ true))) {
                                if (!((qPlusCrowdOption == null || (arrayList2 = qPlusCrowdOption.qqGroupIds) == null || !(arrayList2.isEmpty() ^ true)) ? false : true)) {
                                    if (!((qPlusCrowdOption == null || (arrayList = qPlusCrowdOption.creatorIds) == null || !(arrayList.isEmpty() ^ true)) ? false : true)) {
                                        ArrayList<String> arrayList7 = qPlusPortraitOption.portraitUrl;
                                    }
                                }
                            }
                        }
                    }
                }
                z17 = true;
                if (z17) {
                    i3 = 2;
                }
            }
            e eVar = new e();
            if (i3 == 2) {
                eVar.v("audience_str", "\u81ea\u5b9a\u4e49\u4eba\u7fa4");
                e eVar2 = new e();
                eVar2.t("audience_type", i3);
                eVar2.v("profile_option", qPlusProfileOption.encode());
                eVar.v("audience", eVar2);
                e eVar3 = new e();
                com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                Iterator<QPPromoteReceiverPortraitListItem> it = this.selectedGroupList.iterator();
                while (it.hasNext()) {
                    bVar.t(it.next().encode());
                }
                Unit unit = Unit.INSTANCE;
                com.tencent.kuikly.core.nvi.serialization.json.b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar3, "groups", bVar);
                Iterator<QPPromoteReceiverPortraitListItem> it5 = this.selectedCreatorList.iterator();
                while (it5.hasNext()) {
                    m3.t(it5.next().encode());
                }
                Unit unit2 = Unit.INSTANCE;
                com.tencent.kuikly.core.nvi.serialization.json.b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar3, "creators", m3);
                Iterator<String> it6 = this.selectedCityNames.iterator();
                while (it6.hasNext()) {
                    m16.t(it6.next());
                }
                Unit unit3 = Unit.INSTANCE;
                eVar3.v("cityNames", m16);
                eVar.v("extraInfo", eVar3);
            } else {
                eVar.v("audience_str", "\u667a\u80fd\u4f18\u9009");
            }
            IPagerIdKtxKt.callbackResult(k3, eVar);
        }
        BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
    }

    public final void onSelectItem(int i3) {
        this.hasSelectCustomOption$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(i3 != 1));
    }
}
