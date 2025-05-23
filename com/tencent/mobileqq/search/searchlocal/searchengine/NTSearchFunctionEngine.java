package com.tencent.mobileqq.search.searchlocal.searchengine;

import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.search.api.ISearchEngine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import lo2.c;
import on2.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b5B\u0019\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u00101\u001a\u00020\u0019\u00a2\u0006\u0004\b2\u00103J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u00060!R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/searchengine/NTSearchFunctionEngine;", "Lon2/b;", "Llo2/c;", "", "keyword", "", "l", "", "init", "Lpn2/a;", "searchRequest", "a", "Lon2/d;", "listener", "c", "cancel", "pause", "resume", "destroy", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "k", "()Lcom/tencent/common/app/AppInterface;", "mApp", "", "e", "I", "mFromType", "Lcom/tencent/qqnt/search/api/ISearchEngine;", "f", "Lcom/tencent/qqnt/search/api/ISearchEngine;", "searchService", "Lcom/tencent/mobileqq/search/searchlocal/searchengine/NTSearchFunctionEngine$SearchRunnable;", h.F, "Lcom/tencent/mobileqq/search/searchlocal/searchengine/NTSearchFunctionEngine$SearchRunnable;", "mSearchRunnable", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "scope", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "searchId", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "searchReportTask", "D", "searchAsyncReportTask", IProfileCardConst.KEY_FROM_TYPE, "<init>", "(Lcom/tencent/common/app/AppInterface;I)V", "E", "SearchRunnable", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NTSearchFunctionEngine implements on2.b<c> {
    private static final String F = NTSearchFunctionEngine.class.getSimpleName();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchReportTask;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchAsyncReportTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppInterface mApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFromType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISearchEngine searchService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchRunnable mSearchRunnable = new SearchRunnable();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int searchId = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/searchengine/NTSearchFunctionEngine$SearchRunnable;", "Ljava/lang/Runnable;", "", "code", "", "msg", "", "a", TencentLocation.RUN_MODE, "Lpn2/a;", "d", "Lpn2/a;", "getInnerSearchRequest", "()Lpn2/a;", "c", "(Lpn2/a;)V", "innerSearchRequest", "Lon2/d;", "Llo2/c;", "e", "Lon2/d;", "getInnerListener", "()Lon2/d;", "b", "(Lon2/d;)V", "innerListener", "<init>", "(Lcom/tencent/mobileqq/search/searchlocal/searchengine/NTSearchFunctionEngine;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private pn2.a innerSearchRequest;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private d<c> innerListener;

        public SearchRunnable() {
        }

        private final void a(int code, String msg2) {
            IPerformanceReportTask iPerformanceReportTask = NTSearchFunctionEngine.this.searchAsyncReportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.setResultCode(code);
            }
            IPerformanceReportTask iPerformanceReportTask2 = NTSearchFunctionEngine.this.searchAsyncReportTask;
            if (iPerformanceReportTask2 != null) {
                iPerformanceReportTask2.setResultMsg(msg2);
            }
            IPerformanceReportTask iPerformanceReportTask3 = NTSearchFunctionEngine.this.searchAsyncReportTask;
            if (iPerformanceReportTask3 != null) {
                iPerformanceReportTask3.report();
            }
        }

        public final void b(@Nullable d<c> dVar) {
            this.innerListener = dVar;
        }

        public final void c(@Nullable pn2.a aVar) {
            this.innerSearchRequest = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            ArrayList<String> arrayListOf;
            if (this.innerSearchRequest != null && this.innerListener != null) {
                if (NTSearchFunctionEngine.this.getMApp() == null) {
                    QLog.e(NTSearchFunctionEngine.F, 1, "mSearchRunnable.run, app is null.");
                    d<c> dVar = this.innerListener;
                    Intrinsics.checkNotNull(dVar);
                    dVar.onFinish((List<c>) null, 6);
                    a(6, "app is null");
                    return;
                }
                if (NTSearchFunctionEngine.this.searchService == null) {
                    QLog.e(NTSearchFunctionEngine.F, 1, "mSearchRunnable.run, search service is null.");
                    d<c> dVar2 = this.innerListener;
                    Intrinsics.checkNotNull(dVar2);
                    dVar2.onFinish((List<c>) null, 6);
                    a(6, "search service is null");
                    return;
                }
                pn2.a aVar = this.innerSearchRequest;
                Intrinsics.checkNotNull(aVar);
                String keyword = aVar.f426495a;
                NTSearchFunctionEngine nTSearchFunctionEngine = NTSearchFunctionEngine.this;
                ISearchEngine iSearchEngine = nTSearchFunctionEngine.searchService;
                if (iSearchEngine != null) {
                    Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keyword);
                    i3 = iSearchEngine.searchFunction(arrayListOf, 100, null);
                } else {
                    i3 = -1;
                }
                nTSearchFunctionEngine.searchId = i3;
                NTSearchFunctionEngine nTSearchFunctionEngine2 = NTSearchFunctionEngine.this;
                pn2.a aVar2 = this.innerSearchRequest;
                Intrinsics.checkNotNull(aVar2);
                String str = aVar2.f426495a;
                Intrinsics.checkNotNullExpressionValue(str, "innerSearchRequest!!.keyword");
                List<c> l3 = nTSearchFunctionEngine2.l(str);
                d<c> dVar3 = this.innerListener;
                if (dVar3 != null) {
                    dVar3.onFinish(l3, 1);
                }
                a(1, "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e(NTSearchFunctionEngine.F, 2, "mSearchRunnable.run, innerSearchRequest == null or innerListener == null");
            }
        }
    }

    public NTSearchFunctionEngine(@Nullable AppInterface appInterface, int i3) {
        ISearchEngine iSearchEngine;
        this.mApp = appInterface;
        this.mFromType = -1;
        this.mFromType = i3;
        if (appInterface != null) {
            iSearchEngine = (ISearchEngine) appInterface.getRuntimeService(ISearchEngine.class, "");
        } else {
            iSearchEngine = null;
        }
        this.searchService = iSearchEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> l(String keyword) {
        Job launch$default;
        List<c> emptyList;
        ISearchEngine iSearchEngine = this.searchService;
        if (iSearchEngine == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Intrinsics.checkNotNull(iSearchEngine);
        Flow<SearchFunctionResult> searchFunctionResultFlow = iSearchEngine.searchFunctionResultFlow();
        ArrayList arrayList = new ArrayList();
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NTSearchFunctionEngine$getQueryFunctions$job$1(searchFunctionResultFlow, keyword, arrayList, this, null), 3, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new NTSearchFunctionEngine$getQueryFunctions$1(launch$default, null), 1, null);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str, NTSearchFunctionEngine this$0, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(F, 1, "search " + str + " function callback: " + i3 + ", " + errMsg);
        IPerformanceReportTask iPerformanceReportTask = this$0.searchReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(i3);
        }
        IPerformanceReportTask iPerformanceReportTask2 = this$0.searchReportTask;
        if (iPerformanceReportTask2 != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iPerformanceReportTask2.setResultMsg(errMsg);
        }
        IPerformanceReportTask iPerformanceReportTask3 = this$0.searchReportTask;
        if (iPerformanceReportTask3 != null) {
            iPerformanceReportTask3.report();
        }
    }

    @Override // on2.b
    @Nullable
    public List<c> a(@Nullable pn2.a searchRequest) {
        String str;
        boolean z16;
        ArrayList<String> arrayListOf;
        int i3;
        boolean z17;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str != null) {
            String str2 = searchRequest.f426495a;
            Intrinsics.checkNotNullExpressionValue(str2, "searchRequest.keyword");
            int length = str2.length() - 1;
            int i16 = 0;
            boolean z18 = false;
            while (i16 <= length) {
                if (!z18) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) str2.charAt(i3), 32) <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18) {
                    if (!z17) {
                        z18 = true;
                    } else {
                        i16++;
                    }
                } else {
                    if (!z17) {
                        break;
                    }
                    length--;
                }
            }
            if (str2.subSequence(i16, length + 1).toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (this.mApp == null) {
                    QLog.e(F, 1, "search, app is null.");
                    return null;
                }
                if (this.searchService == null) {
                    QLog.e(F, 1, "search service is null.");
                    return null;
                }
                this.searchReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_function_more_cost");
                final String keyword = searchRequest.f426495a;
                ISearchEngine iSearchEngine = this.searchService;
                Intrinsics.checkNotNull(iSearchEngine);
                Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keyword);
                this.searchId = iSearchEngine.searchFunction(arrayListOf, 3, new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.searchengine.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i17, String str3) {
                        NTSearchFunctionEngine.m(keyword, this, i17, str3);
                    }
                });
                return l(keyword);
            }
        }
        return null;
    }

    @Override // on2.b
    public void c(@Nullable pn2.a searchRequest, @Nullable d<c> listener) {
        String str;
        int i3;
        boolean z16;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str != null) {
            String str2 = searchRequest.f426495a;
            Intrinsics.checkNotNullExpressionValue(str2, "searchRequest.keyword");
            boolean z17 = true;
            int length = str2.length() - 1;
            int i16 = 0;
            boolean z18 = false;
            while (i16 <= length) {
                if (!z18) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) str2.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z18) {
                    if (!z16) {
                        z18 = true;
                    } else {
                        i16++;
                    }
                } else if (!z16) {
                    break;
                } else {
                    length--;
                }
            }
            if (str2.subSequence(i16, length + 1).toString().length() != 0) {
                z17 = false;
            }
            if (!z17) {
                this.searchAsyncReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_function_more_cost");
                synchronized (this.mSearchRunnable) {
                    this.mSearchRunnable.c(searchRequest);
                    if (listener != null) {
                        this.mSearchRunnable.b(listener);
                    }
                    ThreadManagerV2.removeJobFromThreadPool(this.mSearchRunnable, 32);
                    ThreadManagerV2.excute(this.mSearchRunnable, 32, null, false);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // on2.b
    public void cancel() {
        Logger logger = Logger.f235387a;
        String TAG = F;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        logger.d().i(TAG, 1, "cancel() searchId=" + this.searchId);
        synchronized (this.mSearchRunnable) {
            ISearchEngine iSearchEngine = this.searchService;
            if (iSearchEngine != null) {
                iSearchEngine.cancelSearchFunction(this.searchId, 2, "cancel");
            }
            this.mSearchRunnable.c(null);
            this.mSearchRunnable.b(null);
            this.searchId = -1;
            ThreadManagerV2.removeJobFromThreadPool(this.mSearchRunnable, 32);
        }
    }

    @Override // on2.b
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final AppInterface getMApp() {
        return this.mApp;
    }

    @Override // on2.b
    public void init() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
