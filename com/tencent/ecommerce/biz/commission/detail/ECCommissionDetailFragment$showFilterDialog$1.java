package com.tencent.ecommerce.biz.commission.detail;

import com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog;
import com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0002JX\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000426\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J2\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\"\u0010\u001b\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J:\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"com/tencent/ecommerce/biz/commission/detail/ECCommissionDetailFragment$showFilterDialog$1", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$ClickActionHandler;", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog;", "dialog", "", VasWebReport.WEB_CORE_DATA_FLAGS, "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "optionData", "Lkotlin/Function1;", "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$a;", "", "refreshAction", "e", "startTime", "endTime", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "callback", "g", "d", "", "timeMillis", "f", "resetBtnClick", "confirmBtnClick", "filterOptionBtnClick", "", "a", "Ljava/util/List;", "filterData", "", "b", "Ljava/util/Map;", "selectedOptionMap", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionDetailFragment$showFilterDialog$1 implements ECCommonFilterDialog.ClickActionHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<ECCommonFilterDialog.FilterItem> filterData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, List<ECCommonFilterDialog.FilterOptionItem>> selectedOptionMap;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ECCommissionDetailFragment f101439c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f101440d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/commission/detail/ECCommissionDetailFragment$showFilterDialog$1$a", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "", "startTimeMillis", "endTimeMillis", "", "onConfirmTimeSelected", "onCancel", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements ECCustomDatePicker.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECCommonFilterDialog f101442b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f101443c;

        a(ECCommonFilterDialog eCCommonFilterDialog, Function2 function2) {
            this.f101442b = eCCommonFilterDialog;
            this.f101443c = function2;
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onCancel() {
            this.f101442b.show();
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onConfirmTimeSelected(long startTimeMillis, long endTimeMillis) {
            this.f101442b.show();
            this.f101443c.invoke(ECCommissionDetailFragment$showFilterDialog$1.this.f(startTimeMillis), ECCommissionDetailFragment$showFilterDialog$1.this.f(endTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECCommissionDetailFragment$showFilterDialog$1(ECCommissionDetailFragment eCCommissionDetailFragment, List list) {
        int collectionSizeOrDefault;
        List<ECCommonFilterDialog.FilterItem> mutableList;
        ECCommissionDetailViewModel Qh;
        List mutableList2;
        List mutableList3;
        this.f101439c = eCCommissionDetailFragment;
        this.f101440d = list;
        List<ECCommonFilterDialog.FilterItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ECCommonFilterDialog.FilterItem filterItem : list2) {
            mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) filterItem.c());
            arrayList.add(ECCommonFilterDialog.FilterItem.b(filterItem, null, null, mutableList3, 3, null));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        this.filterData = mutableList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Qh = this.f101439c.Qh();
        Map<String, List<ECCommonFilterDialog.FilterOptionItem>> value = Qh.U1().getValue();
        if (value != null) {
            for (Map.Entry<String, List<ECCommonFilterDialog.FilterOptionItem>> entry : value.entrySet()) {
                String key = entry.getKey();
                mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) entry.getValue());
                linkedHashMap.put(key, mutableList2);
            }
        }
        Unit unit = Unit.INSTANCE;
        this.selectedOptionMap = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        if (calendar.get(2) >= 9) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(calendar.get(1));
            sb5.append('.');
            sb5.append(calendar.get(2) + 1);
            return sb5.toString();
        }
        return calendar.get(1) + ".0" + (calendar.get(2) + 1);
    }

    private final void g(ECCommonFilterDialog dialog, String startTime, String endTime, Function2<? super String, ? super String, Unit> callback) {
        dialog.hide();
        ECCustomDatePicker eCCustomDatePicker = new ECCustomDatePicker(this.f101439c.requireContext(), new a(dialog, callback), 10L, System.currentTimeMillis(), false, null, 32, null);
        eCCustomDatePicker.o(false);
        eCCustomDatePicker.p(false);
        eCCustomDatePicker.n(false);
        eCCustomDatePicker.s(System.currentTimeMillis());
    }

    @Override // com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog.ClickActionHandler
    public void confirmBtnClick() {
        ECCommissionDetailViewModel Qh;
        Qh = this.f101439c.Qh();
        Qh.X1(this.filterData, this.selectedOptionMap);
    }

    @Override // com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog.ClickActionHandler
    public void filterOptionBtnClick(ECCommonFilterDialog dialog, String filterType, ECCommonFilterDialog.FilterOptionItem optionData, Function1<? super List<ECCommonFilterDialog.FilterItem>, Unit> refreshAction) {
        if (Intrinsics.areEqual(filterType, "time")) {
            e(dialog, filterType, optionData, refreshAction);
        } else {
            d(filterType, optionData, refreshAction);
        }
    }

    @Override // com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog.ClickActionHandler
    public void resetBtnClick(Function1<? super List<ECCommonFilterDialog.FilterItem>, Unit> refreshAction) {
        ECCommissionDetailViewModel Qh;
        ECCommissionDetailViewModel Qh2;
        int collectionSizeOrDefault;
        List mutableList;
        this.selectedOptionMap.clear();
        Qh = this.f101439c.Qh();
        refreshAction.invoke(Qh.Q1());
        this.filterData.clear();
        List<ECCommonFilterDialog.FilterItem> list = this.filterData;
        Qh2 = this.f101439c.Qh();
        List<ECCommonFilterDialog.FilterItem> Q1 = Qh2.Q1();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(Q1, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ECCommonFilterDialog.FilterItem filterItem : Q1) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) filterItem.c());
            arrayList.add(ECCommonFilterDialog.FilterItem.b(filterItem, null, null, mutableList, 3, null));
        }
        list.addAll(arrayList);
    }

    private final void e(ECCommonFilterDialog dialog, final String filterType, final ECCommonFilterDialog.FilterOptionItem optionData, final Function1<? super List<ECCommonFilterDialog.FilterItem>, Unit> refreshAction) {
        List<ECCommonFilterDialog.FilterOptionItem> mutableListOf;
        List<ECCommonFilterDialog.FilterOptionItem> list;
        if (!optionData.selected || optionData.optionType == 1) {
            for (final ECCommonFilterDialog.FilterItem filterItem : this.filterData) {
                if (Intrinsics.areEqual(filterItem.filterType, filterType)) {
                    Iterator<ECCommonFilterDialog.FilterOptionItem> it = filterItem.c().iterator();
                    final int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        ECCommonFilterDialog.FilterOptionItem next = it.next();
                        if (Intrinsics.areEqual(next.value, optionData.value) && Intrinsics.areEqual(next.text, optionData.text) && next.optionType == optionData.optionType) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 == 0 && (list = this.selectedOptionMap.get(filterType)) != null) {
                        list.clear();
                    }
                    Iterator<ECCommonFilterDialog.FilterOptionItem> it5 = filterItem.c().iterator();
                    int i16 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            i16 = -1;
                            break;
                        } else if (it5.next().selected) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (optionData.optionType == 1) {
                        final int i17 = i16;
                        g(dialog, optionData.start, optionData.end, new Function2<String, String, Unit>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionDetailFragment$showFilterDialog$1$dealTimeSelected$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                                invoke2(str, str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String str, String str2) {
                                Map map;
                                List mutableListOf2;
                                List list2;
                                filterItem.c().set(i17, ECCommonFilterDialog.FilterOptionItem.b(filterItem.c().get(i17), false, null, null, 0, null, null, 62, null));
                                ECCommonFilterDialog.FilterOptionItem b16 = ECCommonFilterDialog.FilterOptionItem.b(optionData, true, null, str + '-' + str2, 0, str, str2, 10, null);
                                filterItem.c().set(i3, b16);
                                map = ECCommissionDetailFragment$showFilterDialog$1.this.selectedOptionMap;
                                String str3 = filterType;
                                mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(b16);
                                map.put(str3, mutableListOf2);
                                Function1 function1 = refreshAction;
                                list2 = ECCommissionDetailFragment$showFilterDialog$1.this.filterData;
                                function1.invoke(list2);
                            }
                        });
                        return;
                    }
                    filterItem.c().set(i16, ECCommonFilterDialog.FilterOptionItem.b(filterItem.c().get(i16), false, null, null, 0, null, null, 62, null));
                    ECCommonFilterDialog.FilterOptionItem b16 = ECCommonFilterDialog.FilterOptionItem.b(optionData, true, null, null, 0, null, null, 62, null);
                    filterItem.c().set(i3, b16);
                    Map<String, List<ECCommonFilterDialog.FilterOptionItem>> map = this.selectedOptionMap;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(b16);
                    map.put(filterType, mutableListOf);
                    refreshAction.invoke(this.filterData);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    private final void d(String filterType, ECCommonFilterDialog.FilterOptionItem optionData, Function1<? super List<ECCommonFilterDialog.FilterItem>, Unit> refreshAction) {
        int i3;
        int i16;
        int collectionSizeOrDefault;
        for (ECCommonFilterDialog.FilterItem filterItem : this.filterData) {
            if (Intrinsics.areEqual(filterItem.filterType, filterType)) {
                int i17 = 0;
                if (Intrinsics.areEqual(filterItem.c().get(0).value, optionData.value)) {
                    List<ECCommonFilterDialog.FilterOptionItem> list = this.selectedOptionMap.get(filterType);
                    if (list != null) {
                        list.clear();
                    }
                    List<ECCommonFilterDialog.FilterOptionItem> c16 = filterItem.c();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = c16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ECCommonFilterDialog.FilterOptionItem.b((ECCommonFilterDialog.FilterOptionItem) it.next(), false, null, null, 0, null, null, 62, null));
                    }
                    filterItem.c().clear();
                    filterItem.c().addAll(arrayList);
                    filterItem.c().set(0, ECCommonFilterDialog.FilterOptionItem.b(optionData, true, null, null, 0, null, null, 62, null));
                    refreshAction.invoke(this.filterData);
                    return;
                }
                Iterator<ECCommonFilterDialog.FilterOptionItem> it5 = filterItem.c().iterator();
                int i18 = 0;
                while (true) {
                    i3 = -1;
                    if (!it5.hasNext()) {
                        i16 = -1;
                        break;
                    }
                    ECCommonFilterDialog.FilterOptionItem next = it5.next();
                    if (Intrinsics.areEqual(next.value, optionData.value) && Intrinsics.areEqual(next.text, optionData.text) && next.optionType == optionData.optionType) {
                        i16 = i18;
                        break;
                    }
                    i18++;
                }
                if (optionData.selected) {
                    List<ECCommonFilterDialog.FilterOptionItem> list2 = this.selectedOptionMap.get(filterType);
                    Intrinsics.checkNotNull(list2);
                    List<ECCommonFilterDialog.FilterOptionItem> list3 = list2;
                    if (list3.size() == 1 && Intrinsics.areEqual(list3.get(0).value, optionData.value)) {
                        return;
                    }
                    Iterator<ECCommonFilterDialog.FilterOptionItem> it6 = list3.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        if (Intrinsics.areEqual(it6.next().value, optionData.value)) {
                            i3 = i17;
                            break;
                        }
                        i17++;
                    }
                    list3.remove(i3);
                    filterItem.c().set(i16, ECCommonFilterDialog.FilterOptionItem.b(optionData, false, null, null, 0, null, null, 62, null));
                    refreshAction.invoke(this.filterData);
                    return;
                }
                List<ECCommonFilterDialog.FilterOptionItem> list4 = this.selectedOptionMap.get(filterType);
                if (list4 == null) {
                    list4 = new ArrayList<>();
                }
                list4.add(optionData);
                this.selectedOptionMap.put(filterType, list4);
                filterItem.c().set(i16, ECCommonFilterDialog.FilterOptionItem.b(optionData, true, null, null, 0, null, null, 62, null));
                filterItem.c().set(0, ECCommonFilterDialog.FilterOptionItem.b(filterItem.c().get(0), false, null, null, 0, null, null, 62, null));
                refreshAction.invoke(this.filterData);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
