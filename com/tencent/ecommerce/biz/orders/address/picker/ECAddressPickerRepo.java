package com.tencent.ecommerce.biz.orders.address.picker;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictType;
import com.tencent.ecommerce.biz.orders.address.picker.model.b;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001b\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerRepo;", "Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "parentAddressInfo", "", "d", "c", "", "", "pinyinList", "b", "requestProvinceDistrictList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parentDistrictAddressInfo", "requestDistrictList", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Ljava/util/Map;", "addressCache", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "nation", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressPickerRepo implements IECAddressPickerRepo {

    /* renamed from: d, reason: collision with root package name */
    private static final List<Integer> f103092d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<DistrictAddressInfo, List<DistrictAddressInfo>> addressCache = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final DistrictAddressInfo nation = new DistrictAddressInfo(DistrictType.Nation, CountrySelectView.NAME_CHINA, -1, null, 8, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MINI_APP_PANEL), 120000, 310000, 500000, 810000, 820000});
        f103092d = listOf;
    }

    public ECAddressPickerRepo(Context context) {
        this.context = context;
    }

    private final boolean c(DistrictAddressInfo districtAddressInfo) {
        return String.valueOf(districtAddressInfo.getId()).length() <= 6;
    }

    private final boolean d(DistrictAddressInfo parentAddressInfo) {
        boolean endsWith$default;
        if (parentAddressInfo.type == DistrictType.Province && f103092d.contains(Integer.valueOf(parentAddressInfo.getId()))) {
            return false;
        }
        if (parentAddressInfo.type != DistrictType.City) {
            return true;
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(String.valueOf(parentAddressInfo.getId()), "00", false, 2, null);
        return endsWith$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.address.picker.IECAddressPickerRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object requestDistrictList(final DistrictAddressInfo districtAddressInfo, Continuation<? super List<DistrictAddressInfo>> continuation) {
        ECAddressPickerRepo$requestDistrictList$1 eCAddressPickerRepo$requestDistrictList$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        ECAddressPickerRepo eCAddressPickerRepo;
        List<DistrictAddressInfo> listOf;
        List emptyList;
        List<DistrictAddressInfo> list;
        if (continuation instanceof ECAddressPickerRepo$requestDistrictList$1) {
            eCAddressPickerRepo$requestDistrictList$1 = (ECAddressPickerRepo$requestDistrictList$1) continuation;
            int i16 = eCAddressPickerRepo$requestDistrictList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCAddressPickerRepo$requestDistrictList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCAddressPickerRepo$requestDistrictList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCAddressPickerRepo$requestDistrictList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!c(districtAddressInfo)) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                    List<DistrictAddressInfo> list2 = this.addressCache.get(districtAddressInfo);
                    if (list2 != null) {
                        return list2;
                    }
                    if (!d(districtAddressInfo)) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(DistrictAddressInfo.b(districtAddressInfo, b.a(districtAddressInfo.type), null, 0, null, 14, null));
                        this.addressCache.put(districtAddressInfo, listOf);
                        return listOf;
                    }
                    eCAddressPickerRepo$requestDistrictList$1.L$0 = this;
                    eCAddressPickerRepo$requestDistrictList$1.L$1 = districtAddressInfo;
                    eCAddressPickerRepo$requestDistrictList$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(eCAddressPickerRepo$requestDistrictList$1);
                    final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    final long currentTimeMillis = System.currentTimeMillis();
                    QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocationService().requestDistrictList(this.context, districtAddressInfo.getId(), new Function3<Integer, String, List<? extends DistrictResultObject.DistrictResult>, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerRepo$requestDistrictList$$inlined$suspendCoroutine$lambda$1

                        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "com/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerRepo$requestDistrictList$list$1$1$$special$$inlined$sortedBy$1"}, k = 3, mv = {1, 4, 1})
                        /* loaded from: classes31.dex */
                        public static final class a<T> implements Comparator<T> {
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t16, T t17) {
                                int compareValues;
                                compareValues = ComparisonsKt__ComparisonsKt.compareValues(((DistrictAddressInfo) t16).getPingYin(), ((DistrictAddressInfo) t17).getPingYin());
                                return compareValues;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, List<? extends DistrictResultObject.DistrictResult> list3) {
                            invoke(num.intValue(), str, (List<DistrictResultObject.DistrictResult>) list3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i17, String str, List<DistrictResultObject.DistrictResult> list3) {
                            List emptyList2;
                            int collectionSizeOrDefault;
                            List sortedWith;
                            String b16;
                            com.tencent.ecommerce.base.network.service.b.f100859b.b("ecom.map_sdk", "ecom.map_sdk/district_request_children", currentTimeMillis, new ECRemoteResponse(currentTimeMillis, i17, str, null, 0, null, null, 120, null));
                            if (i17 == 0 && list3 != null) {
                                List<DistrictResultObject.DistrictResult> list4 = list3;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                for (DistrictResultObject.DistrictResult districtResult : list4) {
                                    DistrictType a16 = b.a(districtAddressInfo.type);
                                    String str2 = districtResult.fullname;
                                    int i18 = districtResult.f118545id;
                                    b16 = this.b(districtResult.pinyin);
                                    arrayList.add(new DistrictAddressInfo(a16, str2, i18, b16));
                                }
                                sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
                                safeContinuation.resumeWith(Result.m476constructorimpl(sortedWith));
                                return;
                            }
                            if (i17 == 0) {
                                Continuation continuation2 = safeContinuation;
                                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                continuation2.resumeWith(Result.m476constructorimpl(emptyList2));
                                return;
                            }
                            cg0.a.a("ECAddressPickerRepo", "requestDistrictList", "id=" + districtAddressInfo.getId() + ", errCode = " + i17 + " , errMsg = " + str);
                            safeContinuation.resumeWith(Result.m476constructorimpl(null));
                        }
                    });
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(eCAddressPickerRepo$requestDistrictList$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCAddressPickerRepo = this;
                } else if (i3 == 1) {
                    districtAddressInfo = (DistrictAddressInfo) eCAddressPickerRepo$requestDistrictList$1.L$1;
                    eCAddressPickerRepo = (ECAddressPickerRepo) eCAddressPickerRepo$requestDistrictList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) obj;
                if (list != null) {
                    eCAddressPickerRepo.addressCache.put(districtAddressInfo, list);
                }
                return list;
            }
        }
        eCAddressPickerRepo$requestDistrictList$1 = new ECAddressPickerRepo$requestDistrictList$1(this, continuation);
        Object obj2 = eCAddressPickerRepo$requestDistrictList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCAddressPickerRepo$requestDistrictList$1.label;
        if (i3 != 0) {
        }
        list = (List) obj2;
        if (list != null) {
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.address.picker.IECAddressPickerRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object requestProvinceDistrictList(Continuation<? super List<DistrictAddressInfo>> continuation) {
        ECAddressPickerRepo$requestProvinceDistrictList$1 eCAddressPickerRepo$requestProvinceDistrictList$1;
        Object coroutine_suspended;
        int i3;
        ECAddressPickerRepo eCAddressPickerRepo;
        List<DistrictAddressInfo> list;
        if (continuation instanceof ECAddressPickerRepo$requestProvinceDistrictList$1) {
            eCAddressPickerRepo$requestProvinceDistrictList$1 = (ECAddressPickerRepo$requestProvinceDistrictList$1) continuation;
            int i16 = eCAddressPickerRepo$requestProvinceDistrictList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCAddressPickerRepo$requestProvinceDistrictList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCAddressPickerRepo$requestProvinceDistrictList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCAddressPickerRepo$requestProvinceDistrictList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<DistrictAddressInfo> list2 = this.addressCache.get(this.nation);
                    if (list2 != null) {
                        return list2;
                    }
                    DistrictAddressInfo districtAddressInfo = this.nation;
                    eCAddressPickerRepo$requestProvinceDistrictList$1.L$0 = this;
                    eCAddressPickerRepo$requestProvinceDistrictList$1.label = 1;
                    obj = requestDistrictList(districtAddressInfo, eCAddressPickerRepo$requestProvinceDistrictList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCAddressPickerRepo = this;
                } else if (i3 == 1) {
                    eCAddressPickerRepo = (ECAddressPickerRepo) eCAddressPickerRepo$requestProvinceDistrictList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) obj;
                if (list != null) {
                    eCAddressPickerRepo.addressCache.put(eCAddressPickerRepo.nation, list);
                }
                return list;
            }
        }
        eCAddressPickerRepo$requestProvinceDistrictList$1 = new ECAddressPickerRepo$requestProvinceDistrictList$1(this, continuation);
        Object obj2 = eCAddressPickerRepo$requestProvinceDistrictList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCAddressPickerRepo$requestProvinceDistrictList$1.label;
        if (i3 != 0) {
        }
        list = (List) obj2;
        if (list != null) {
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(List<String> pinyinList) {
        String capitalize;
        List<String> list = pinyinList;
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : pinyinList) {
            StringBuilder sb6 = new StringBuilder();
            capitalize = StringsKt__StringsJVMKt.capitalize(str, Locale.ROOT);
            sb6.append(capitalize);
            sb6.append(TokenParser.SP);
            sb5.append(sb6.toString());
        }
        return sb5.toString();
    }
}
