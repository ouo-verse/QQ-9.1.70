package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.util.Base64;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.search.util.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetNetSugWordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetSugInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetSugWordsReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetSugWordsRsp;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/l;", "", "", "b", "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTabInfo;", "tabInfo", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/l$b;", "extensionData", "", "sugWordScene", "", "Lrp2/c$b;", "c", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTabInfo;Lcom/tencent/mobileqq/search/searchdetail/searchbox/l$b;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "b", "userSource", "<init>", "(II)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.searchbox.l$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class ExtensionDataForSearchSuggests {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int querySource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int userSource;

        public ExtensionDataForSearchSuggests(int i3, int i16) {
            this.querySource = i3;
            this.userSource = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getQuerySource() {
            return this.querySource;
        }

        /* renamed from: b, reason: from getter */
        public final int getUserSource() {
            return this.userSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExtensionDataForSearchSuggests)) {
                return false;
            }
            ExtensionDataForSearchSuggests extensionDataForSearchSuggests = (ExtensionDataForSearchSuggests) other;
            if (this.querySource == extensionDataForSearchSuggests.querySource && this.userSource == extensionDataForSearchSuggests.userSource) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.querySource * 31) + this.userSource;
        }

        @NotNull
        public String toString() {
            return "ExtensionDataForSearchSuggests(querySource=" + this.querySource + ", userSource=" + this.userSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNetSugWordsRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    static final class c implements IGetNetSugWordsCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f284622a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f284623b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f284624c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<c.SearchSuggestKeywordData>> f284625d;

        /* JADX WARN: Multi-variable type inference failed */
        c(IPerformanceReportTask iPerformanceReportTask, long j3, String str, CancellableContinuation<? super List<c.SearchSuggestKeywordData>> cancellableContinuation) {
            this.f284622a = iPerformanceReportTask;
            this.f284623b = j3;
            this.f284624c = str;
            this.f284625d = cancellableContinuation;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetNetSugWordsCallback
        public final void onResult(int i3, String errMsg, SearchNetSugWordsRsp searchNetSugWordsRsp) {
            List emptyList;
            int collectionSizeOrDefault;
            this.f284622a.setResultCode(i3);
            IPerformanceReportTask iPerformanceReportTask = this.f284622a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iPerformanceReportTask.setResultMsg(errMsg);
            this.f284622a.report();
            ak.d("0x9195_1", System.currentTimeMillis() - this.f284623b, i3, this.f284624c, false, 16, null);
            QLog.d("QQSearch.NetDetail.SearchBoxRepository", 2, "getNetSugWords errCode=" + i3 + " " + errMsg);
            if (com.tencent.mobileqq.search.util.n.e(i3)) {
                ArrayList<SearchNetSugInfo> arrayList = searchNetSugWordsRsp.netSugInfos;
                Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.netSugInfos");
                String str = this.f284624c;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                int i16 = 0;
                for (Object obj : arrayList) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    SearchNetSugInfo searchNetSugInfo = (SearchNetSugInfo) obj;
                    String str2 = searchNetSugInfo.sugWord;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.sugWord");
                    int i18 = searchNetSugInfo.sugWordType;
                    String str3 = searchNetSugInfo.stringExtension;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.stringExtension");
                    arrayList2.add(new c.SearchSuggestKeywordData(i16, str2, i18, str, str3));
                    i16 = i17;
                }
                QLog.d("QQSearch.NetDetail.SearchBoxRepository", 4, "getNetSugWords list=" + arrayList2);
                this.f284625d.resumeWith(Result.m476constructorimpl(arrayList2));
                return;
            }
            CancellableContinuation<List<c.SearchSuggestKeywordData>> cancellableContinuation = this.f284625d;
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuation.resumeWith(Result.m476constructorimpl(emptyList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(this.toByteArray(), Base64.NO_WRAP)");
        return encodeToString;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull SearchTabInfo searchTabInfo, @NotNull ExtensionDataForSearchSuggests extensionDataForSearchSuggests, int i3, @NotNull Continuation<? super List<c.SearchSuggestKeywordData>> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        SearchNetSugWordsReq searchNetSugWordsReq = new SearchNetSugWordsReq();
        searchNetSugWordsReq.keyWord = str;
        searchNetSugWordsReq.sugWordScene = i3;
        searchNetSugWordsReq.tab = searchTabInfo;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, extensionDataForSearchSuggests.getQuerySource());
        jSONObject.put("userSource", extensionDataForSearchSuggests.getUserSource());
        Unit unit2 = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
        byte[] bytes = b(jSONObject2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        searchNetSugWordsReq.bytesExtension = bytes;
        IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_result_sug_words_request_quality");
        a16.setExtra("keyWord", str);
        a16.setExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, Boxing.boxInt(extensionDataForSearchSuggests.getQuerySource()));
        a16.setExtra("userSource", Boxing.boxInt(extensionDataForSearchSuggests.getUserSource()));
        long currentTimeMillis = System.currentTimeMillis();
        IKernelUnifySearchService c16 = com.tencent.mobileqq.search.util.n.c();
        if (c16 != null) {
            c16.getNetSugWords(searchNetSugWordsReq, new c(a16, currentTimeMillis, str, cancellableContinuationImpl));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("QQSearch.NetDetail.SearchBoxRepository", 1, "search service is null", (Throwable) null);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable("search service is null"))));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
