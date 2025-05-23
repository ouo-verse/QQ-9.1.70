package com.tencent.mobileqq.search.guildsearch;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchHistoryEntity;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel;", "Landroidx/lifecycle/ViewModel;", "", "e2", "X1", "c2", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "rsp", "U1", "", "newState", "d2", "Z1", "W1", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", "historyData", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "onCleared", "i", "I", "currentState", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_localHistoryLiveData", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", BdhLogUtil.LogTag.Tag_Conn, "_operationHotLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "D", "Landroidx/lifecycle/MediatorLiveData;", "T1", "()Landroidx/lifecycle/MediatorLiveData;", "entryListLiveData", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildSearchEntryViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ListBaseData.OperationHotData> _operationHotLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<ListBaseData>> entryListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<ListBaseData.SearchHistoryData>> _localHistoryLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnifySearchDiscoveryCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "rsp", "", "onResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IUnifySearchDiscoveryCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f283335b;

        b(long j3) {
            this.f283335b = j3;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback
        public void onResult(int errCode, @Nullable String errMsg, @Nullable UfsDisRspBody rsp) {
            Logger logger = Logger.f235387a;
            long j3 = this.f283335b;
            logger.d().d("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "requestSearchDiscoveryByCached code " + errCode + ",cost " + (System.currentTimeMillis() - j3));
            if (n.e(errCode) && rsp != null && GuildSearchEntryViewModel.this._operationHotLiveData.getValue() == 0) {
                GuildSearchEntryViewModel.this.U1(rsp);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnifySearchDiscoveryCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "rsp", "", "onResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements IUnifySearchDiscoveryCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f283336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildSearchEntryViewModel f283337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f283338c;

        c(IPerformanceReportTask iPerformanceReportTask, GuildSearchEntryViewModel guildSearchEntryViewModel, long j3) {
            this.f283336a = iPerformanceReportTask;
            this.f283337b = guildSearchEntryViewModel;
            this.f283338c = j3;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback
        public void onResult(int errCode, @Nullable String errMsg, @Nullable UfsDisRspBody rsp) {
            Logger logger = Logger.f235387a;
            long j3 = this.f283338c;
            logger.d().d("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "requestUnifySearchDiscoveryData code " + errCode + ",cost " + (System.currentTimeMillis() - j3));
            this.f283336a.setResultCode((long) errCode);
            IPerformanceReportTask iPerformanceReportTask = this.f283336a;
            if (errMsg == null) {
                errMsg = "";
            }
            iPerformanceReportTask.setResultMsg(errMsg);
            this.f283336a.report();
            if (n.e(errCode) && rsp != null) {
                this.f283337b.U1(rsp);
            }
        }
    }

    public GuildSearchEntryViewModel() {
        MutableLiveData<List<ListBaseData.SearchHistoryData>> mutableLiveData = new MutableLiveData<>();
        this._localHistoryLiveData = mutableLiveData;
        MutableLiveData<ListBaseData.OperationHotData> mutableLiveData2 = new MutableLiveData<>();
        this._operationHotLiveData = mutableLiveData2;
        MediatorLiveData<List<ListBaseData>> mediatorLiveData = new MediatorLiveData<>();
        final Function1<List<? extends ListBaseData.SearchHistoryData>, Unit> function1 = new Function1<List<? extends ListBaseData.SearchHistoryData>, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.GuildSearchEntryViewModel$entryListLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ListBaseData.SearchHistoryData> list) {
                invoke2((List<ListBaseData.SearchHistoryData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ListBaseData.SearchHistoryData> list) {
                GuildSearchEntryViewModel.this.e2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.search.guildsearch.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSearchEntryViewModel.R1(Function1.this, obj);
            }
        });
        final Function1<ListBaseData.OperationHotData, Unit> function12 = new Function1<ListBaseData.OperationHotData, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.GuildSearchEntryViewModel$entryListLiveData$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ListBaseData.OperationHotData operationHotData) {
                invoke2(operationHotData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ListBaseData.OperationHotData operationHotData) {
                GuildSearchEntryViewModel.this.e2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.search.guildsearch.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSearchEntryViewModel.S1(Function1.this, obj);
            }
        });
        this.entryListLiveData = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(UfsDisRspBody rsp) {
        Object obj;
        boolean z16;
        ArrayList<UfsDisResult> resultItemList = rsp.resultItems;
        Intrinsics.checkNotNullExpressionValue(resultItemList, "resultItemList");
        Iterator<T> it = resultItemList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((UfsDisResult) obj).type == 12) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        UfsDisResult ufsDisResult = (UfsDisResult) obj;
        if (ufsDisResult != null) {
            this._operationHotLiveData.postValue(ListBaseData.OperationHotData.INSTANCE.a(ufsDisResult));
        }
    }

    private final void X1() {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).loadSearchHistory(new Function1<List<SearchHistoryEntity>, Void>() { // from class: com.tencent.mobileqq.search.guildsearch.GuildSearchEntryViewModel$loadHistoryNetSearchRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(List<SearchHistoryEntity> history) {
                int collectionSizeOrDefault;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullExpressionValue(history, "history");
                ArrayList<SearchHistoryEntity> arrayList = new ArrayList();
                Iterator<T> it = history.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((SearchHistoryEntity) next).getType() == 10025) {
                        arrayList.add(next);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (SearchHistoryEntity searchHistoryEntity : arrayList) {
                    arrayList2.add(new ListBaseData.SearchHistoryData(0, searchHistoryEntity.getId(), searchHistoryEntity.getDisplayName(), 0, 9, null));
                }
                Logger.f235387a.d().d("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "loadHistoryNetSearchRecord rs.size= " + arrayList2.size());
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ((ListBaseData.SearchHistoryData) it5.next()).f(arrayList2.size());
                }
                mutableLiveData = GuildSearchEntryViewModel.this._localHistoryLiveData;
                mutableLiveData.postValue(arrayList2);
                return null;
            }
        });
    }

    private final void c2() {
        UfsDisReqBody ufsDisReqBody = new UfsDisReqBody();
        ufsDisReqBody.fromType = 11;
        ufsDisReqBody.business = 128;
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = subVersion.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ufsDisReqBody.version = bytes;
        Logger logger = Logger.f235387a;
        logger.d().d("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "requestUnifySearchDiscoveryData fromType " + ufsDisReqBody.fromType);
        long currentTimeMillis = System.currentTimeMillis();
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.unifySearchDiscoveryInCache(ufsDisReqBody, new b(currentTimeMillis));
            Unit unit = Unit.INSTANCE;
            logger.d().w("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "unifySearchService is null!");
        }
        IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_discovery_nt_request_quality");
        IKernelUnifySearchService c17 = n.c();
        if (c17 != null) {
            c17.unifySearchDiscovery(ufsDisReqBody, new c(a16, this, currentTimeMillis));
            Unit unit2 = Unit.INSTANCE;
            logger.d().w("QQSearch.Local.Guild.GuildSearchEntryViewModel", 1, "unifySearchService is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        List<ListBaseData.SearchHistoryData> value = this._localHistoryLiveData.getValue();
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            List<ListBaseData.SearchHistoryData> list = value;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (value.size() <= 2) {
                    arrayList.addAll(value);
                } else if (this.currentState == 0) {
                    arrayList.addAll(value.subList(0, 2));
                    arrayList.add(new ListBaseData.ShowAllHistoryData(3, 0L, "\u5168\u90e8\u641c\u7d22\u8bb0\u5f55", value.size(), 2, null));
                } else {
                    arrayList.addAll(value.subList(0, Math.min(value.size(), 10)));
                    arrayList.add(new ListBaseData.ShowAllHistoryData(4, 0L, "\u6e05\u7a7a\u5168\u90e8\u641c\u7d22\u8bb0\u5f55", value.size(), 2, null));
                }
            }
        }
        ListBaseData.OperationHotData value2 = this._operationHotLiveData.getValue();
        if (value2 != null) {
            arrayList.add(value2);
        }
        this.entryListLiveData.setValue(arrayList);
    }

    @NotNull
    public final MediatorLiveData<List<ListBaseData>> T1() {
        return this.entryListLiveData;
    }

    public final void W1() {
        X1();
        c2();
    }

    public final void Z1() {
        X1();
    }

    public final void a2() {
        List<ListBaseData.SearchHistoryData> emptyList;
        List<ListBaseData.SearchHistoryData> value = this._localHistoryLiveData.getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).removeHistoryById(((ListBaseData.SearchHistoryData) it.next()).getId());
            }
        }
        MutableLiveData<List<ListBaseData.SearchHistoryData>> mutableLiveData = this._localHistoryLiveData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
    }

    public final void b2(@NotNull ListBaseData.SearchHistoryData historyData) {
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        List<ListBaseData.SearchHistoryData> value = this._localHistoryLiveData.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(value);
            arrayList.remove(historyData);
            this._localHistoryLiveData.setValue(arrayList);
        }
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).removeHistoryById(historyData.getId());
    }

    public final void d2(int newState) {
        this.currentState = newState;
        e2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
    }
}
