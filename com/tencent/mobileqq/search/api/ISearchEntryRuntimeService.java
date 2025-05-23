package com.tencent.mobileqq.search.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H&J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072$\u0010\u0013\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0004\u0012\u00020\u00120\u0014H&J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchEntryRuntimeService;", "Lmqq/app/api/IRuntimeService;", "getModelListByTab", "", "app", "Lcom/tencent/common/app/AppInterface;", "tabType", "", "getSearchEntryDataModelFromCache", "Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "modelType", "requestSearchDiscoveryData", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "from", "byCached", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSearchDiscoveryDataByCache", "", "callback", "Lkotlin/Function1;", "Lkotlin/Triple;", "", "updateModelListByTab", "modelList", "updateSearchEntryDataModels", "list", "", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public interface ISearchEntryRuntimeService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        public static /* synthetic */ Object a(ISearchEntryRuntimeService iSearchEntryRuntimeService, int i3, boolean z16, Continuation continuation, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z16 = false;
                }
                return iSearchEntryRuntimeService.requestSearchDiscoveryData(i3, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestSearchDiscoveryData");
        }
    }

    @NotNull
    int[] getModelListByTab(@NotNull AppInterface app, int tabType);

    @Nullable
    SearchEntryDataModel getSearchEntryDataModelFromCache(int modelType);

    @Nullable
    Object requestSearchDiscoveryData(int i3, boolean z16, @NotNull Continuation<? super UfsDisRspBody> continuation);

    void requestSearchDiscoveryDataByCache(int from, @NotNull Function1<? super Triple<Integer, String, UfsDisRspBody>, Unit> callback);

    void updateModelListByTab(@NotNull AppInterface app, int tabType, @Nullable int[] modelList);

    void updateSearchEntryDataModels(@NotNull List<? extends SearchEntryDataModel> list);
}
