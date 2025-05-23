package com.tencent.mobileqq.search.searchdetail.filter;

import android.content.Context;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010\u0011\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J>\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J>\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J2\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR<\u0010(\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/SearchPlacePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "K0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "backgroundColor", "M0", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/d;", "provinces", "selection", "Lkotlin/Function2;", "Landroid/view/View;", "", "pickerItemCreatedCallback", "L0", "Lcom/tencent/mobileqq/search/searchdetail/filter/a;", "cities", "I0", "Lcom/tencent/mobileqq/search/searchdetail/filter/b;", "districts", "J0", "data", "setData", "d", "Landroidx/recyclerview/widget/RecyclerView;", "provinceRecyclerView", "e", "cityRecyclerView", "f", "districtRecyclerView", "Lkotlin/Function3;", tl.h.F, "Lkotlin/jvm/functions/Function3;", "H0", "()Lkotlin/jvm/functions/Function3;", "setOnPlaceSelectedCallback", "(Lkotlin/jvm/functions/Function3;)V", "onPlaceSelectedCallback", "i", "I", "selectedProvinceIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selectedCityIndex", BdhLogUtil.LogTag.Tag_Conn, "selectedDistrictIndex", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchPlacePickerView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedDistrictIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView provinceRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView cityRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView districtRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function3<? super Integer, ? super Integer, ? super Integer, Unit> onPlaceSelectedCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selectedProvinceIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int selectedCityIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPlacePickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.provinceRecyclerView = new RecyclerView(context);
        this.cityRecyclerView = new RecyclerView(context);
        this.districtRecyclerView = new RecyclerView(context);
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(final List<CityFilter> cities, int selection, final Function2<? super View, ? super String, Unit> pickerItemCreatedCallback) {
        int collectionSizeOrDefault;
        List<DistrictFilter> emptyList;
        RecyclerView recyclerView = this.cityRecyclerView;
        List<CityFilter> list = cities;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CityFilter) it.next()).getName());
        }
        g gVar = new g(arrayList, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.filter.SearchPlacePickerView$setupCityAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public final void invoke(int i3, @NotNull String str) {
                Function3<Integer, Integer, Integer, Unit> H0;
                int i16;
                int i17;
                int i18;
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                SearchPlacePickerView.this.selectedCityIndex = i3;
                List<DistrictFilter> a16 = cities.get(i3).a();
                SearchPlacePickerView.this.J0(a16, 0, pickerItemCreatedCallback);
                if (a16.size() != 1 || (H0 = SearchPlacePickerView.this.H0()) == null) {
                    return;
                }
                SearchPlacePickerView searchPlacePickerView = SearchPlacePickerView.this;
                i16 = searchPlacePickerView.selectedProvinceIndex;
                Integer valueOf = Integer.valueOf(i16);
                i17 = searchPlacePickerView.selectedCityIndex;
                Integer valueOf2 = Integer.valueOf(i17);
                i18 = searchPlacePickerView.selectedDistrictIndex;
                H0.invoke(valueOf, valueOf2, Integer.valueOf(i18));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }
        });
        gVar.q0(selection);
        this.selectedCityIndex = selection;
        if (selection >= cities.size()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = cities.get(selection).a();
        }
        gVar.p0(pickerItemCreatedCallback);
        J0(emptyList, 0, pickerItemCreatedCallback);
        recyclerView.setAdapter(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(List<DistrictFilter> districts, int selection, Function2<? super View, ? super String, Unit> pickerItemCreatedCallback) {
        int collectionSizeOrDefault;
        RecyclerView recyclerView = this.districtRecyclerView;
        List<DistrictFilter> list = districts;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((DistrictFilter) it.next()).getName());
        }
        g gVar = new g(arrayList, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.filter.SearchPlacePickerView$setupDistrictAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(int i3, @NotNull String str) {
                int i16;
                int i17;
                int i18;
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                SearchPlacePickerView.this.selectedDistrictIndex = i3;
                Function3<Integer, Integer, Integer, Unit> H0 = SearchPlacePickerView.this.H0();
                if (H0 != null) {
                    SearchPlacePickerView searchPlacePickerView = SearchPlacePickerView.this;
                    i16 = searchPlacePickerView.selectedProvinceIndex;
                    Integer valueOf = Integer.valueOf(i16);
                    i17 = searchPlacePickerView.selectedCityIndex;
                    Integer valueOf2 = Integer.valueOf(i17);
                    i18 = searchPlacePickerView.selectedDistrictIndex;
                    H0.invoke(valueOf, valueOf2, Integer.valueOf(i18));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }
        });
        gVar.q0(selection);
        this.selectedDistrictIndex = selection;
        gVar.p0(pickerItemCreatedCallback);
        recyclerView.setAdapter(gVar);
    }

    private final void K0() {
        M0(this.provinceRecyclerView, getContext().getColor(R.color.qui_common_bg_bottom_standard));
        M0(this.cityRecyclerView, getContext().getColor(R.color.qui_common_bg_bottom_light));
        M0(this.districtRecyclerView, getContext().getColor(R.color.qui_common_bg_bottom_standard));
        addView(this.provinceRecyclerView, new ConstraintLayout.LayoutParams(0, -1));
        addView(this.cityRecyclerView, new ConstraintLayout.LayoutParams(0, -1));
        addView(this.districtRecyclerView, new ConstraintLayout.LayoutParams(0, -1));
        com.tencent.mobileqq.search.util.l.f(this, 3, 0, 0, 0, false, 28, null);
    }

    private final void L0(final List<ProvinceFilter> provinces, int selection, final Function2<? super View, ? super String, Unit> pickerItemCreatedCallback) {
        int collectionSizeOrDefault;
        List<CityFilter> emptyList;
        RecyclerView recyclerView = this.provinceRecyclerView;
        List<ProvinceFilter> list = provinces;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProvinceFilter) it.next()).getName());
        }
        g gVar = new g(arrayList, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.filter.SearchPlacePickerView$setupProvinceAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public final void invoke(int i3, @NotNull String str) {
                Function3<Integer, Integer, Integer, Unit> H0;
                int i16;
                int i17;
                int i18;
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                SearchPlacePickerView.this.selectedProvinceIndex = i3;
                List<CityFilter> a16 = provinces.get(i3).a();
                SearchPlacePickerView.this.I0(a16, 0, pickerItemCreatedCallback);
                if (a16.size() != 1 || (H0 = SearchPlacePickerView.this.H0()) == null) {
                    return;
                }
                SearchPlacePickerView searchPlacePickerView = SearchPlacePickerView.this;
                i16 = searchPlacePickerView.selectedProvinceIndex;
                Integer valueOf = Integer.valueOf(i16);
                i17 = searchPlacePickerView.selectedCityIndex;
                Integer valueOf2 = Integer.valueOf(i17);
                i18 = searchPlacePickerView.selectedDistrictIndex;
                H0.invoke(valueOf, valueOf2, Integer.valueOf(i18));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }
        });
        gVar.o0(true);
        gVar.n0(true);
        gVar.q0(selection);
        this.selectedProvinceIndex = selection;
        if (selection >= provinces.size()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = provinces.get(selection).a();
        }
        gVar.p0(pickerItemCreatedCallback);
        I0(emptyList, 0, pickerItemCreatedCallback);
        recyclerView.setAdapter(gVar);
    }

    private final void M0(RecyclerView recyclerView, @ColorInt int backgroundColor) {
        recyclerView.setId(View.generateViewId());
        recyclerView.setHasFixedSize(true);
        recyclerView.setBackgroundColor(backgroundColor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setData$default(SearchPlacePickerView searchPlacePickerView, List list, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        searchPlacePickerView.setData(list, function2);
    }

    @Nullable
    public final Function3<Integer, Integer, Integer, Unit> H0() {
        return this.onPlaceSelectedCallback;
    }

    public final void setData(@NotNull List<ProvinceFilter> data, @Nullable Function2<? super View, ? super String, Unit> pickerItemCreatedCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        L0(data, 0, pickerItemCreatedCallback);
    }

    public final void setOnPlaceSelectedCallback(@Nullable Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        this.onPlaceSelectedCallback = function3;
    }
}
