package com.tencent.mobileqq.search.business.contact.viewmodel;

import android.util.Log;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import com.tencent.mobileqq.search.business.contact.i;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.util.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00042\u00020\u0001:\u0005'(\u001b)*B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "", "g", h.F, "", "keyword", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "f", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchContactResult;", "rsp", "onSearchContactResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupChatInfoResult;", "onSearchGroupChatInfoResult", "", "d", "I", "getFromType", "()I", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$c;", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$c;", "c", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$c;", "params", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$b;", "Ljava/util/concurrent/ConcurrentHashMap;", "requestMap", "Lcom/tencent/qqnt/kernel/api/ae;", "()Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "<init>", "(I)V", "a", "b", "SearchType", "ShowRobotType", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContactsSearchRepo implements IKernelSearchListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int fromType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RequestParams params;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, b> requestMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$SearchType;", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes18.dex */
    public @interface SearchType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$ShowRobotType;", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes18.dex */
    public @interface ShowRobotType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR)\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "keyword", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/SearchGroup;", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/SearchGroup;", "c", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/SearchGroup;", "searchGroup", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "executable", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/search/business/contact/viewmodel/SearchGroup;Lkotlin/jvm/functions/Function1;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String keyword;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SearchGroup searchGroup;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<List<ContactsSearchItemData>, Unit> executable;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull String keyword, @NotNull SearchGroup searchGroup, @NotNull Function1<? super List<ContactsSearchItemData>, Unit> executable) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(searchGroup, "searchGroup");
            Intrinsics.checkNotNullParameter(executable, "executable");
            this.keyword = keyword;
            this.searchGroup = searchGroup;
            this.executable = executable;
        }

        @NotNull
        public final Function1<List<ContactsSearchItemData>, Unit> a() {
            return this.executable;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final SearchGroup getSearchGroup() {
            return this.searchGroup;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "c", "(I)V", "robotShowType", "b", "d", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "<init>", "(II)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo$c, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class RequestParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int robotShowType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int searchType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RequestParams() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        /* renamed from: a, reason: from getter */
        public final int getRobotShowType() {
            return this.robotShowType;
        }

        /* renamed from: b, reason: from getter */
        public final int getSearchType() {
            return this.searchType;
        }

        public final void c(int i3) {
            this.robotShowType = i3;
        }

        public final void d(int i3) {
            this.searchType = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestParams)) {
                return false;
            }
            RequestParams requestParams = (RequestParams) other;
            if (this.robotShowType == requestParams.robotShowType && this.searchType == requestParams.searchType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.robotShowType * 31) + this.searchType;
        }

        @NotNull
        public String toString() {
            return "RequestParams(robotShowType=" + this.robotShowType + ", searchType=" + this.searchType + ")";
        }

        public RequestParams(int i3, int i16) {
            this.robotShowType = i3;
            this.searchType = i16;
        }

        public /* synthetic */ RequestParams(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    static final class d implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f283010a;

        d(IPerformanceReportTask iPerformanceReportTask) {
            this.f283010a = iPerformanceReportTask;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String msg2) {
            QLog.d("ContactsSearchRepo", 1, "code: " + i3 + ", msg: " + msg2);
            this.f283010a.setResultCode((long) i3);
            IPerformanceReportTask iPerformanceReportTask = this.f283010a;
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            iPerformanceReportTask.setResultMsg(msg2);
            this.f283010a.report();
            if (n.d(i3)) {
                QLog.e("ContactsSearchRepo", 1, "loadContacts code: " + i3 + ", msg: " + msg2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    static final class e implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f283011a;

        e(IPerformanceReportTask iPerformanceReportTask) {
            this.f283011a = iPerformanceReportTask;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String msg2) {
            this.f283011a.setResultCode(i3);
            IPerformanceReportTask iPerformanceReportTask = this.f283011a;
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            iPerformanceReportTask.setResultMsg(msg2);
            this.f283011a.report();
            QLog.d("ContactsSearchRepo", 1, "loadTroops result code: " + i3 + ", msg: " + msg2);
            if (n.d(i3)) {
                QLog.e("ContactsSearchRepo", 1, "code: " + i3 + ", msg: " + msg2);
            }
        }
    }

    public ContactsSearchRepo(int i3) {
        this.fromType = i3;
        int i16 = 0;
        this.params = new RequestParams(i16, i16, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ae d() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getSearchService();
        }
        return null;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RequestParams getParams() {
        return this.params;
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull Continuation<? super List<ContactsSearchItemData>> continuation) {
        Continuation intercepted;
        ArrayList<String> arrayListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        SearchBuddyInfoParams searchBuddyInfoParams = new SearchBuddyInfoParams();
        searchBuddyInfoParams.searchType = getParams().getSearchType();
        searchBuddyInfoParams.pageLimit = 500;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
        searchBuddyInfoParams.keyWords = arrayListOf;
        searchBuddyInfoParams.robotShowType = getParams().getRobotShowType();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo$loadContacts$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                QLog.e("ContactsSearchRepo", 1, "loadContacts continuation been canceled: " + th5);
                ConcurrentHashMap concurrentHashMap = ContactsSearchRepo.this.requestMap;
                ContactsSearchRepo contactsSearchRepo = ContactsSearchRepo.this;
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    QLog.d("ContactsSearchRepo", 1, "cancel: " + entry.getKey());
                    ae d16 = contactsSearchRepo.d();
                    if (d16 != null) {
                        d16.cancelSearchBuddyChatInfo(((Number) entry.getKey()).intValue(), 1, "canceled");
                    }
                }
                ContactsSearchRepo.this.requestMap.clear();
            }
        });
        QLog.d("ContactsSearchRepo", 1, "loadContacts searchBuddyChatInfoWithParams");
        ae d16 = d();
        if (d16 != null) {
            int searchBuddyChatInfoWithParams = d16.searchBuddyChatInfoWithParams(searchBuddyInfoParams, new d(iPerformanceReportTask));
            QLog.d("ContactsSearchRepo", 1, "search contact id: " + searchBuddyChatInfoWithParams + "\uff0c params " + searchBuddyInfoParams);
            this.requestMap.put(Boxing.boxInt(searchBuddyChatInfoWithParams), new b(str, SearchGroup.CONTACT, new Function1<List<? extends ContactsSearchItemData>, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo$loadContacts$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ContactsSearchItemData> list) {
                    invoke2((List<ContactsSearchItemData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<ContactsSearchItemData> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(it));
                    } else {
                        QLog.d("ContactsSearchRepo", 1, "continuation is not active");
                    }
                }
            }));
        } else {
            QLog.e("ContactsSearchRepo", 1, "req is null");
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull Continuation<? super List<ContactsSearchItemData>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        ArrayList<String> arrayListOf;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo$loadTroops$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                QLog.e("ContactsSearchRepo", 1, " loadTroops continuation been canceled: " + th5);
                ConcurrentHashMap concurrentHashMap = ContactsSearchRepo.this.requestMap;
                ContactsSearchRepo contactsSearchRepo = ContactsSearchRepo.this;
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    QLog.d("ContactsSearchRepo", 1, "cancel: " + entry.getKey());
                    ae d16 = contactsSearchRepo.d();
                    if (d16 != null) {
                        d16.cancelSearchGroupChatInfo(((Number) entry.getKey()).intValue(), 1, "canceled");
                    }
                }
                ContactsSearchRepo.this.requestMap.clear();
            }
        });
        QLog.d("ContactsSearchRepo", 1, "loadTroops searchGroupChatInfo");
        ae d16 = d();
        if (d16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            int searchGroupChatInfo = d16.searchGroupChatInfo(arrayListOf, new SearchGroupChatInfoParams(), 500, new e(iPerformanceReportTask));
            QLog.d("ContactsSearchRepo", 1, "search troop id: " + searchGroupChatInfo + " params:" + getParams());
            this.requestMap.put(Boxing.boxInt(searchGroupChatInfo), new b(str, SearchGroup.TROOP, new Function1<List<? extends ContactsSearchItemData>, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo$loadTroops$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ContactsSearchItemData> list) {
                    invoke2((List<ContactsSearchItemData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<ContactsSearchItemData> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(it));
                    } else {
                        QLog.d("ContactsSearchRepo", 1, "continuation is not active");
                    }
                }
            }));
        } else {
            QLog.e("ContactsSearchRepo", 1, "req is null");
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void g() {
        Unit unit;
        QLog.d("ContactsSearchRepo", 1, "register search callback");
        ae d16 = d();
        if (d16 != null) {
            d16.addKernelSearchListener(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("ContactsSearchRepo", 1, "register service is null");
        }
    }

    public final void h() {
        Unit unit;
        QLog.d("ContactsSearchRepo", 1, "unRegister search callback");
        ae d16 = d();
        if (d16 != null) {
            d16.q0(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("ContactsSearchRepo", 1, "unRegister service is null");
        }
        for (Map.Entry<Integer, b> entry : this.requestMap.entrySet()) {
            QLog.d("ContactsSearchRepo", 1, "cancel search: " + entry);
            ae d17 = d();
            if (d17 != null) {
                d17.cancelSearchGroupChatInfo(entry.getKey().intValue(), 2, "canceled");
            }
        }
        this.requestMap.clear();
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

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d0, code lost:
    
        if (r8 == null) goto L36;
     */
    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSearchContactResult(@Nullable SearchContactResult rsp) {
        Integer num;
        int collectionSizeOrDefault;
        String str;
        Object m476constructorimpl;
        k kVar;
        Long l3;
        Unit unit = null;
        if (rsp != null) {
            num = Integer.valueOf(rsp.searchId);
        } else {
            num = null;
        }
        QLog.d("ContactsSearchRepo", 1, "onSearchContactResult id " + num);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ContactsSearchRepo", "onSearchContactResult = [" + rsp + "]");
        }
        if (rsp == null) {
            QLog.e("ContactsSearchRepo", 1, "result is null");
            return;
        }
        b remove = this.requestMap.remove(Integer.valueOf(rsp.searchId));
        if (remove != null) {
            if (remove.getSearchGroup() != SearchGroup.CONTACT) {
                QLog.w("ContactsSearchRepo", 1, "it.searchGroup  is not contact type");
            }
            ArrayList<SearchContactItem> arrayList = rsp.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.resultItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (SearchContactItem searchContactItem : arrayList) {
                SearchBuddyItem searchBuddyItem = searchContactItem.buddyItem;
                if (searchBuddyItem != null) {
                    str = searchBuddyItem.uid;
                } else {
                    str = null;
                }
                if (str == null) {
                    SearchGroupMemberItem searchGroupMemberItem = searchContactItem.groupMemberItem;
                    if (searchGroupMemberItem != null) {
                        l3 = Long.valueOf(searchGroupMemberItem.uin);
                    } else {
                        l3 = null;
                    }
                    str = String.valueOf(l3);
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "item.buddyItem?.uid ?: i\u2026emberItem?.uin.toString()");
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    SearchBuddyItem buddyItem = searchContactItem.buddyItem;
                    if (buddyItem != null) {
                        Intrinsics.checkNotNullExpressionValue(buddyItem, "buddyItem");
                        String keyword = remove.getKeyword();
                        int i3 = this.fromType;
                        String str2 = searchContactItem.rankInfo;
                        Intrinsics.checkNotNullExpressionValue(str2, "item.rankInfo");
                        kVar = i.h(buddyItem, keyword, i3, str2);
                    }
                    SearchGroupMemberItem groupMemberItem = searchContactItem.groupMemberItem;
                    if (groupMemberItem != null) {
                        Intrinsics.checkNotNullExpressionValue(groupMemberItem, "groupMemberItem");
                        String keyword2 = remove.getKeyword();
                        int i16 = this.fromType;
                        String str3 = searchContactItem.rankInfo;
                        Intrinsics.checkNotNullExpressionValue(str3, "item.rankInfo");
                        kVar = i.j(groupMemberItem, keyword2, i16, str3);
                    } else {
                        kVar = null;
                    }
                    m476constructorimpl = Result.m476constructorimpl(kVar);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    s.f("ContactsSearchRepo", "\u9519\u8bef\u7684\u6570\u636e: " + searchContactItem, m479exceptionOrNullimpl);
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                arrayList2.add(new ContactsSearchItemData(str, (k) m476constructorimpl));
            }
            remove.a().invoke(arrayList2);
            QLog.d("ContactsSearchRepo", 1, "execute for search " + remove.getSearchGroup());
            QLog.d("ContactsSearchRepo", 1, "cancel search buddie: " + rsp.searchId);
            ae d16 = d();
            if (d16 != null) {
                d16.cancelSearchBuddyChatInfo(rsp.searchId, 1, "canceled");
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            QLog.e("ContactsSearchRepo", 1, "cant find " + rsp.searchId);
        }
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
    public void onSearchGroupChatInfoResult(@Nullable SearchGroupChatInfoResult rsp) {
        Integer num;
        int collectionSizeOrDefault;
        Object m476constructorimpl;
        Unit unit = null;
        if (rsp != null) {
            num = Integer.valueOf(rsp.searchId);
        } else {
            num = null;
        }
        QLog.d("ContactsSearchRepo", 1, "onSearchGroupChatInfoResult id " + num);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ContactsSearchRepo", "onSearchGroupChatInfoResult = [" + rsp + "]");
        }
        if (rsp == null) {
            QLog.e("ContactsSearchRepo", 1, "result is null");
            return;
        }
        b remove = this.requestMap.remove(Integer.valueOf(rsp.searchId));
        if (remove != null) {
            ArrayList<SearchGroupItem> arrayList = rsp.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.resultItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (SearchGroupItem item : arrayList) {
                String valueOf = String.valueOf(item.groupCode);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    m476constructorimpl = Result.m476constructorimpl(i.i(item, remove.getKeyword(), this.fromType));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    s.f("ContactsSearchRepo", "\u9519\u8bef\u7684\u6570\u636e: " + item, m479exceptionOrNullimpl);
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                arrayList2.add(new ContactsSearchItemData(valueOf, (k) m476constructorimpl));
            }
            remove.a().invoke(arrayList2);
            QLog.d("ContactsSearchRepo", 1, "execute for search " + remove.getSearchGroup());
            QLog.d("ContactsSearchRepo", 1, "cancel searchGroup: " + rsp.searchId);
            ae d16 = d();
            if (d16 != null) {
                d16.cancelSearchGroupChatInfo(rsp.searchId, 1, "canceled");
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            QLog.e("ContactsSearchRepo", 1, "onSearchGroupChatInfoResult cant find " + rsp.searchId);
        }
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
    public /* synthetic */ void onSearchResult(SearchResult searchResult) {
        bm.m(this, searchResult);
    }
}
