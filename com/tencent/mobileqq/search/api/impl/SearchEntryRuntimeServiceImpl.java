package com.tencent.mobileqq.search.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.mobileqq.search.business.activatepage.ActivatePageRepo;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J6\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2$\u0010\u001a\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J#\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchEntryRuntimeServiceImpl;", "Lcom/tencent/mobileqq/search/api/ISearchEntryRuntimeService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "list", "updateSearchEntryDataModels", "", "modelType", "getSearchEntryDataModelFromCache", "Lcom/tencent/common/app/AppInterface;", "app", "tabType", "", "modelList", "updateModelListByTab", "getModelListByTab", "from", "Lkotlin/Function1;", "Lkotlin/Triple;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "callback", "requestSearchDiscoveryDataByCache", "", "byCached", "requestSearchDiscoveryData", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo;", "activatePageRepo", "Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo;", "ufsDisRspBody", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "searchEntryDataModelList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "modelListCache", "[I", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchEntryRuntimeServiceImpl implements ISearchEntryRuntimeService {

    @NotNull
    public static final String TAG = "QQSearch.Local.entry.SearchEntryRuntimeService";

    @Nullable
    private ActivatePageRepo activatePageRepo;

    @Nullable
    private UfsDisRspBody ufsDisRspBody;

    @NotNull
    private CopyOnWriteArrayList<SearchEntryDataModel> searchEntryDataModelList = new CopyOnWriteArrayList<>();

    @NotNull
    private int[] modelListCache = new int[0];

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    @NotNull
    public int[] getModelListByTab(@NotNull AppInterface app, int tabType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(app, "app");
        int[] iArr = this.modelListCache;
        if (iArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            int[] d16 = nn2.a.d(app, tabType);
            Intrinsics.checkNotNullExpressionValue(d16, "{\n            SearchEntr\u2026b(app, tabType)\n        }");
            return d16;
        }
        return iArr;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    @Nullable
    public SearchEntryDataModel getSearchEntryDataModelFromCache(int modelType) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.searchEntryDataModelList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SearchEntryDataModel) obj).f283456f == modelType) {
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
        return (SearchEntryDataModel) obj;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        this.activatePageRepo = new ActivatePageRepo();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.activatePageRepo = null;
        this.ufsDisRspBody = null;
        this.searchEntryDataModelList.clear();
        this.modelListCache = new int[0];
    }

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    @Nullable
    public Object requestSearchDiscoveryData(final int i3, boolean z16, @NotNull Continuation<? super UfsDisRspBody> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.d(TAG, 1, "requestSearchDiscoveryData byCached=" + z16 + " from=" + i3 + ": start >>>");
        ActivatePageRepo activatePageRepo = this.activatePageRepo;
        if (activatePageRepo != null) {
            activatePageRepo.b(i3, z16, new Function1<Triple<? extends Integer, ? extends String, ? extends UfsDisRspBody>, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchEntryRuntimeServiceImpl$requestSearchDiscoveryData$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Integer, ? extends String, ? extends UfsDisRspBody> triple) {
                    invoke2((Triple<Integer, String, UfsDisRspBody>) triple);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Triple<Integer, String, UfsDisRspBody> triple) {
                    Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
                    int intValue = triple.component1().intValue();
                    String component2 = triple.component2();
                    UfsDisRspBody component3 = triple.component3();
                    QLog.d(SearchEntryRuntimeServiceImpl.TAG, 1, "requestSearchDiscoveryData from=" + i3 + ": rcv <<<< " + intValue + " " + component2 + " ");
                    if (n.e(intValue)) {
                        this.ufsDisRspBody = component3;
                        safeContinuation.resumeWith(Result.m476constructorimpl(component3));
                        return;
                    }
                    Continuation<UfsDisRspBody> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new ActivatePageRepo.ThrowableWithError(intValue, component2, "errCode is not success " + intValue))));
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new ActivatePageRepo.ThrowableWithError(-1, "not find repo", "not find repo"))));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    public void requestSearchDiscoveryDataByCache(int from, @NotNull Function1<? super Triple<Integer, String, UfsDisRspBody>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UfsDisRspBody ufsDisRspBody = this.ufsDisRspBody;
        if (ufsDisRspBody != null) {
            QLog.d(TAG, 1, "requestSearchDiscoveryDataByCache: from=" + from);
            callback.invoke(new Triple(0, "", ufsDisRspBody));
            return;
        }
        ActivatePageRepo activatePageRepo = this.activatePageRepo;
        if (activatePageRepo != null) {
            activatePageRepo.b(from, true, callback);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    public void updateModelListByTab(@NotNull AppInterface app, int tabType, @Nullable int[] modelList) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (modelList != null) {
            this.modelListCache = modelList;
            Unit unit = Unit.INSTANCE;
            this.modelListCache = new int[0];
        }
        nn2.a.k(app, tabType, modelList);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchEntryRuntimeService
    public void updateSearchEntryDataModels(@NotNull final List<? extends SearchEntryDataModel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchEntryRuntimeServiceImpl$updateSearchEntryDataModels$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                CopyOnWriteArrayList copyOnWriteArrayList3;
                Logger logger = Logger.f235387a;
                SearchEntryRuntimeServiceImpl searchEntryRuntimeServiceImpl = SearchEntryRuntimeServiceImpl.this;
                List<SearchEntryDataModel> list2 = list;
                Logger.a d16 = logger.d();
                copyOnWriteArrayList = searchEntryRuntimeServiceImpl.searchEntryDataModelList;
                d16.i(SearchEntryRuntimeServiceImpl.TAG, 1, "updateSearchEntryDataModels old list size=" + copyOnWriteArrayList.size() + " new list size=" + list2.size());
                copyOnWriteArrayList2 = SearchEntryRuntimeServiceImpl.this.searchEntryDataModelList;
                copyOnWriteArrayList2.clear();
                copyOnWriteArrayList3 = SearchEntryRuntimeServiceImpl.this.searchEntryDataModelList;
                copyOnWriteArrayList3.addAll(list);
            }
        });
    }
}
