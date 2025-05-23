package com.tencent.qqnt.kernel.invorker;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.BusinessType;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResultGroup;
import com.tencent.qqnt.kernel.nativeinterface.SearchResultItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchStranger;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KSearchInvorkService;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchResultGroup;", "", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ReportConstant.COSTREPORT_PREFIX, "r", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "listener", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KSearchInvorkService extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IKernelSearchListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/kernel/invorker/KSearchInvorkService$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchResult;", "searchResult", "", "onSearchResult", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KSearchInvorkService.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchAtMeChatsResult(SearchAtMeChatsResult searchAtMeChatsResult) {
            bm.a(this, searchAtMeChatsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchAtMeMsgsResult(SearchAtMeMsgsResult searchAtMeMsgsResult) {
            bm.b(this, searchAtMeMsgsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchBuddyChatInfoResult(SearchBuddyChatInfoResult searchBuddyChatInfoResult) {
            bm.c(this, searchBuddyChatInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchCacheResult(String str, String str2, ArrayList arrayList) {
            bm.d(this, str, str2, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchChatsKeywordsResult(SearchChatsKeywordsResult searchChatsKeywordsResult) {
            bm.e(this, searchChatsKeywordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchContactResult(SearchContactResult searchContactResult) {
            bm.f(this, searchContactResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchFileKeywordsResult(SearchFileKeywordsResult searchFileKeywordsResult) {
            bm.g(this, searchFileKeywordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchFunctionResult(SearchFunctionResult searchFunctionResult) {
            bm.h(this, searchFunctionResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupChatInfoResult(SearchGroupChatInfoResult searchGroupChatInfoResult) {
            bm.i(this, searchGroupChatInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupResult(SearchGroupResult searchGroupResult) {
            bm.j(this, searchGroupResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchLocalInfoResult(SearchLocalInfoResult searchLocalInfoResult) {
            bm.k(this, searchLocalInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchMsgKeywordsResult(SearchMsgKeywordsResult searchMsgKeywordsResult) {
            bm.l(this, searchMsgKeywordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchResult(@NotNull SearchResult searchResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) searchResult);
                return;
            }
            Intrinsics.checkNotNullParameter(searchResult, "searchResult");
            ArrayList<SearchResultGroup> arrayList = searchResult.resultGroup;
            Intrinsics.checkNotNullExpressionValue(arrayList, "searchResult.resultGroup");
            for (SearchResultGroup searchResultGroup : arrayList) {
            }
            KSearchInvorkService kSearchInvorkService = KSearchInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            ArrayList<SearchResultGroup> arrayList2 = searchResult.resultGroup;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "searchResult.resultGroup");
            kSearchInvorkService.t("onSearchResult", aVar.b(TuplesKt.to("searchResult", kSearchInvorkService.B(arrayList2))));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSearchInvorkService(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super("\u641c\u7d22", ae.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
        }
    }

    private final List<String> A(SearchResultGroup searchResultGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SearchResultItem> resultItem = searchResultGroup.resultItem;
        Intrinsics.checkNotNullExpressionValue(resultItem, "resultItem");
        Iterator<T> it = resultItem.iterator();
        while (it.hasNext()) {
            arrayList.add("SearchResultItem(" + ((SearchResultItem) it.next()).extension + ")\n");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> B(ArrayList<SearchResultGroup> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("SearchResultGroup List ---- size(" + arrayList.size() + ")\n");
        for (SearchResultGroup searchResultGroup : arrayList) {
            arrayList2.add(searchResultGroup.groupName + " ---- totalCount(" + searchResultGroup.totalCount + ")\n");
            arrayList2.addAll(A(searchResultGroup));
        }
        return arrayList2;
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.listener = new a();
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.ISearchService");
        ae aeVar = (ae) p16;
        IKernelSearchListener iKernelSearchListener = this.listener;
        if (iKernelSearchListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelSearchListener = null;
        }
        aeVar.addKernelSearchListener(iKernelSearchListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f("searchStranger", "\u641c\u7d22\u964c\u751f\u4eba", "\u8f93\u5165\u5173\u952e\u5b57", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KSearchInvorkService$initMethodInfos$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KSearchInvorkService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                    return invoke2(list, (List<String>) list2);
                }

                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final g.a invoke2(@NotNull List<? extends Object> list, @NotNull List<String> cmds) {
                    ArrayList arrayListOf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (g.a) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list, (Object) cmds);
                    }
                    Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(cmds, "cmds");
                    ArrayList arrayList = new ArrayList();
                    SearchStranger searchStranger = new SearchStranger(cmds.get(0), cmds.get(1), null, null, null, Boolean.TRUE);
                    BusinessType businessType = BusinessType.ANDROIDQQ_128;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1001L);
                    SearchParams searchParams = new SearchParams(businessType, 20, arrayListOf, null);
                    arrayList.add(1L);
                    arrayList.add(searchStranger);
                    arrayList.add(searchParams);
                    arrayList.add(KSearchInvorkService.this);
                    return g.INSTANCE.a(arrayList);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.ISearchService");
        ae aeVar = (ae) p16;
        IKernelSearchListener iKernelSearchListener = this.listener;
        if (iKernelSearchListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelSearchListener = null;
        }
        aeVar.q0(iKernelSearchListener);
    }
}
