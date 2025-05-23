package com.tencent.mobileqq.search.business.contact;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bl;
import com.tencent.mobileqq.guild.util.ck;
import com.tencent.mobileqq.guild.util.cl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wn2.ContactSearchModelNtBuddy;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u0005:\u0001'B\u0017\u0012\u0006\u0010<\u001a\u00020\u000e\u0012\u0006\u0010?\u001a\u00020\u000e\u00a2\u0006\u0004\bc\u0010dJ\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\fH\u0002J@\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0010j\b\u0012\u0004\u0012\u00020\u0002`\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u001e\u0010\u001c\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J.\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0016J\u001e\u0010*\u001a\u00020\u00182\u0006\u0010&\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,0+2\u0006\u0010&\u001a\u00020%H\u0016J:\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000+\"\u0004\b\u0000\u0010.2\u0006\u0010&\u001a\u00020%2\u001c\u00100\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,\u0012\u0006\u0012\u0004\u0018\u00018\u00000/H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00104\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u000206H\u0016R\u0017\u0010<\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010?\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001a\u0010E\u001a\u00020@8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010FR.\u0010K\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,0I0H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00109R\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u00109R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0010j\b\u0012\u0004\u0012\u00020\u0002`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010_R\u0016\u0010b\u001a\u0004\u0018\u00010`8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010a\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/NtBuddySearchEngine;", "Lon2/b;", "Lcom/tencent/mobileqq/search/model/k;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/mobileqq/search/business/contact/a;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchContactItem;", "it", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "j", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupMemberItem;", "l", "", "searchId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "searchModels", "", "keyword", "", "hasMore", "from", "", DomainData.DOMAIN_NAME, "", "listResult", tl.h.F, "Lcom/tencent/common/app/AppInterface;", "app", "index", "i", "init", "destroy", "pause", "resume", "Lpn2/a;", "searchRequest", "a", "Lon2/d;", "listener", "c", "Ljava/util/concurrent/Future;", "", "o", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "mapFunc", "b", "cancel", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyChatInfoResult;", "result", "onSearchBuddyChatInfoResult", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchContactResult;", "onSearchContactResult", "d", "I", "getFromType", "()I", IProfileCardConst.KEY_FROM_TYPE, "e", "getSearchSource", ForwardRecentActivity.KEY_SEARCH_SOURCE, "Lkotlin/coroutines/CoroutineContext;", "f", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lpn2/a;", "latestSearchRequest", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/util/bl;", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingSearch", "Ljava/util/concurrent/locks/ReentrantLock;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/locks/ReentrantLock;", "pendingSearchLock", BdhLogUtil.LogTag.Tag_Conn, "pendingInfiniteSearchId", "D", "Ljava/util/List;", "infiniteSearchListResult", "E", "Lon2/d;", "infiniteSearchListener", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "searchWithFutureReportTask", "G", "searchAsyncReportTask", "H", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/api/ae;", "()Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "<init>", "(II)V", "J", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NtBuddySearchEngine implements on2.b<com.tencent.mobileqq.search.model.k>, IKernelSearchListener, a<com.tencent.mobileqq.search.model.k>, CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    private int pendingInfiniteSearchId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.search.model.k> infiniteSearchListResult;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private on2.d<com.tencent.mobileqq.search.model.k> infiniteSearchListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchWithFutureReportTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask searchAsyncReportTask;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile int searchId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int fromType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int searchSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pn2.a latestSearchRequest;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext = GuildAIODispatchers.f112358a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, bl<List<com.tencent.mobileqq.search.model.k>>> pendingSearch = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock pendingSearchLock = new ReentrantLock();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.search.model.k> searchModels = new ArrayList<>();

    public NtBuddySearchEngine(int i3, int i16) {
        this.fromType = i3;
        this.searchSource = i16;
    }

    private final void h(List<com.tencent.mobileqq.search.model.k> listResult, String keyword) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        if ((this.searchSource & 256) != 0) {
            i(appInterface, keyword, listResult, 0);
        }
        if ((this.searchSource & 512) != 0) {
            i(appInterface, keyword, listResult, 1);
        }
    }

    private final void i(AppInterface app, String keyword, List<com.tencent.mobileqq.search.model.k> listResult, int index) {
        List<PhoneContact> list;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        IRuntimeService runtimeService = app.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        List<List<PhoneContact>> contactListForDisplay = ((IPhoneContactService) runtimeService).getContactListForDisplay();
        if (contactListForDisplay != null && contactListForDisplay.size() > index && (list = contactListForDisplay.get(index)) != null) {
            Iterator<PhoneContact> it = list.iterator();
            while (it.hasNext()) {
                wn2.m mVar = new wn2.m(app, this.fromType, it.next());
                if (mVar.O(keyword) != Long.MIN_VALUE) {
                    arrayList.add(mVar);
                }
            }
        }
        listResult.addAll(arrayList);
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "appendPhoneContactWithIndex(" + index + ") cost " + (currentTimeMillis2 - currentTimeMillis));
    }

    private final com.tencent.mobileqq.search.model.k j(SearchBuddyItem item) {
        String str;
        boolean z16;
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(this.fromType, 0L);
        pn2.a aVar = this.latestSearchRequest;
        if (aVar != null) {
            str = aVar.f426495a;
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.keyword = str;
        contactSearchModelNtBuddy.m0(item.nickname + "/" + item.remark);
        contactSearchModelNtBuddy.uin = String.valueOf(item.uin);
        List<SearchHitInfo> list = item.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str3 = item.nickname;
        if (str3 == null) {
            str3 = "";
        }
        contactSearchModelNtBuddy.f0(str3);
        List<SearchHitInfo> list2 = item.nicknameHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str4 = item.remark;
        if (str4 != null) {
            str2 = str4;
        }
        contactSearchModelNtBuddy.k0(str2);
        ArrayList<SearchHitInfo> arrayList = item.remarkHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.remarkHits");
        contactSearchModelNtBuddy.l0(arrayList);
        if (contactSearchModelNtBuddy.uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(item.uid);
            Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026).getUinFromUid(item.uid)");
            contactSearchModelNtBuddy.uin = uinFromUid;
            Logger.f235387a.d().i("NtBuddySearchEngine", 1, "createBuddyFrom " + item + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(item.chatType);
        String str5 = item.categoryName;
        Intrinsics.checkNotNullExpressionValue(str5, "item.categoryName");
        contactSearchModelNtBuddy.c0(str5);
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }

    private final com.tencent.mobileqq.search.model.k k(SearchContactItem it) {
        try {
            SearchBuddyItem searchBuddyItem = it.buddyItem;
            if (searchBuddyItem != null) {
                Intrinsics.checkNotNullExpressionValue(searchBuddyItem, "it.buddyItem");
                return j(searchBuddyItem);
            }
            SearchGroupMemberItem searchGroupMemberItem = it.groupMemberItem;
            if (searchGroupMemberItem != null) {
                Intrinsics.checkNotNullExpressionValue(searchGroupMemberItem, "it.groupMemberItem");
                return l(searchGroupMemberItem);
            }
            com.tencent.mobileqq.guild.util.s.f("NtBuddySearchEngine", "\u4e0d\u5b8c\u6574\u7684\u6570\u636e: " + it, new IllegalStateException());
            return null;
        } catch (RuntimeException e16) {
            com.tencent.mobileqq.guild.util.s.f("NtBuddySearchEngine", "\u9519\u8bef\u7684\u6570\u636e: " + it, e16);
            return null;
        }
    }

    private final com.tencent.mobileqq.search.model.k l(SearchGroupMemberItem item) {
        String str;
        boolean z16;
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(this.fromType, 0L);
        pn2.a aVar = this.latestSearchRequest;
        if (aVar != null) {
            str = aVar.f426495a;
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.keyword = str;
        contactSearchModelNtBuddy.m0(item.nick + "/" + item.remark + "/" + item.cardName);
        contactSearchModelNtBuddy.uin = String.valueOf(item.uin);
        List<SearchHitInfo> list = item.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str3 = item.nick;
        if (str3 == null) {
            str3 = "";
        }
        contactSearchModelNtBuddy.f0(str3);
        List<SearchHitInfo> list2 = item.nickHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str4 = item.remark;
        if (str4 != null) {
            str2 = str4;
        }
        contactSearchModelNtBuddy.k0(str2);
        ArrayList<SearchHitInfo> arrayList = item.remarkHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.remarkHits");
        contactSearchModelNtBuddy.l0(arrayList);
        String str5 = item.cardName;
        Intrinsics.checkNotNullExpressionValue(str5, "item.cardName");
        contactSearchModelNtBuddy.a0(str5);
        ArrayList<SearchHitInfo> arrayList2 = item.cardNameHits;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "item.cardNameHits");
        contactSearchModelNtBuddy.b0(arrayList2);
        if (contactSearchModelNtBuddy.uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(item.uid);
            Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026).getUinFromUid(item.uid)");
            contactSearchModelNtBuddy.uin = uinFromUid;
            Logger.f235387a.d().i("NtBuddySearchEngine", 1, "createBuddyFrom " + item + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(2);
        String str6 = item.groupName;
        Intrinsics.checkNotNullExpressionValue(str6, "item.groupName");
        contactSearchModelNtBuddy.c0(str6);
        contactSearchModelNtBuddy.e0(String.valueOf(item.groupCode));
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }

    private final ae m() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getSearchService();
        }
        return null;
    }

    private final void n(int searchId, ArrayList<com.tencent.mobileqq.search.model.k> searchModels, String keyword, boolean hasMore, String from) {
        bl<List<com.tencent.mobileqq.search.model.k>> blVar = this.pendingSearch.get(Integer.valueOf(searchId));
        if (blVar != null) {
            h(searchModels, keyword);
            blVar.complete(searchModels);
            this.pendingSearch.remove(Integer.valueOf(searchId));
            Logger.f235387a.d().i("NtBuddySearchEngine", 1, from + " searchId(" + searchId + ")");
            rn2.a.a("NtBuddySearchEngine", "async result: ", searchModels);
            return;
        }
        if (searchId == this.pendingInfiniteSearchId) {
            List<com.tencent.mobileqq.search.model.k> list = this.infiniteSearchListResult;
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(searchModels);
            if (hasMore) {
                on2.d<com.tencent.mobileqq.search.model.k> dVar = this.infiniteSearchListener;
                if (dVar != null) {
                    dVar.onUpdate(list);
                }
                this.infiniteSearchListResult = list;
                ae m3 = m();
                if (m3 != null) {
                    m3.searchMoreBuddyChatInfo(searchId);
                    return;
                }
                return;
            }
            h(list, keyword);
            on2.d<com.tencent.mobileqq.search.model.k> dVar2 = this.infiniteSearchListener;
            if (dVar2 != null) {
                dVar2.onFinish(list, 1);
            }
            this.infiniteSearchListResult = list;
            rn2.a.a("NtBuddySearchEngine", "details result: ", list);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = from + " searchId(" + searchId + ") can not find future??";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("NtBuddySearchEngine", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(NtBuddySearchEngine this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "searchBuddyChatInfo onResult(" + str + ") " + i3);
        IPerformanceReportTask iPerformanceReportTask = this$0.searchAsyncReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, String str) {
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "searchBuddyChatInfo onResult(" + str + ") " + i3);
    }

    @Override // on2.b
    @NotNull
    public List<com.tencent.mobileqq.search.model.k> a(@NotNull pn2.a searchRequest) {
        Object runBlocking$default;
        List<com.tencent.mobileqq.search.model.k> mutableList;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        this.searchWithFutureReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_personal_more_cost");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new NtBuddySearchEngine$search$list$1(this, searchRequest, null), 1, null);
        Intrinsics.checkNotNullExpressionValue(runBlocking$default, "override fun search(sear\u2026        return list\n    }");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) runBlocking$default);
        IPerformanceReportTask iPerformanceReportTask = this.searchWithFutureReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        return mutableList;
    }

    @Override // com.tencent.mobileqq.search.business.contact.a
    @NotNull
    public <R> Future<R> b(@NotNull pn2.a searchRequest, @NotNull Function1<? super List<? extends com.tencent.mobileqq.search.model.k>, ? extends R> mapFunc) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(mapFunc, "mapFunc");
        Logger logger = Logger.f235387a;
        logger.d().i("NtBuddySearchEngine", 1, "searchAsyncWithMapFunc..... " + searchRequest.f426495a);
        ae m3 = m();
        if (m3 == null) {
            ck ckVar = new ck();
            ckVar.complete(null);
            return ckVar;
        }
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            this.latestSearchRequest = searchRequest;
            String str = searchRequest.f426495a;
            Intrinsics.checkNotNullExpressionValue(str, "searchRequest.keyword");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            this.searchId = m3.searchBuddyChatInfo(arrayListOf, 5, new IOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    NtBuddySearchEngine.q(i3, str2);
                }
            });
            cl clVar = new cl(mapFunc);
            this.pendingSearch.put(Integer.valueOf(this.searchId), clVar);
            logger.d().i("NtBuddySearchEngine", 1, "searchAsyncWithMapFunc..... " + this.searchId + " -> " + clVar);
            return clVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void c(@NotNull pn2.a searchRequest, @NotNull on2.d<com.tencent.mobileqq.search.model.k> listener) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            String str = searchRequest.f426495a;
            if (str == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(str, "searchRequest.keyword ?: return");
            ae m3 = m();
            if (m3 == null) {
                return;
            }
            if (this.pendingInfiniteSearchId != 0) {
                cancel();
            }
            this.searchAsyncReportTask = Reporters.f231995a.c().a("search_local_info_nt_more_request_quality").setStageCode("search_local_info_personal_more_cost");
            this.infiniteSearchListener = listener;
            this.latestSearchRequest = searchRequest;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            this.pendingInfiniteSearchId = m3.searchBuddyChatInfo(arrayListOf, -1, new IOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    NtBuddySearchEngine.p(NtBuddySearchEngine.this, i3, str2);
                }
            });
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void cancel() {
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "cancel() searchId=" + this.searchId + " pendingInfiniteSearchId=" + this.pendingInfiniteSearchId);
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            if (this.searchId != 0) {
                ae m3 = m();
                if (m3 != null) {
                    m3.cancelSearchBuddyChatInfo(this.searchId, 0, "cancel");
                }
                bl<List<com.tencent.mobileqq.search.model.k>> blVar = this.pendingSearch.get(Integer.valueOf(this.searchId));
                if (blVar != null) {
                    blVar.cancel(true);
                }
                this.pendingSearch.remove(Integer.valueOf(this.searchId));
                this.searchId = 0;
            }
            if (this.pendingInfiniteSearchId != 0) {
                ae m16 = m();
                if (m16 != null) {
                    m16.cancelSearchBuddyChatInfo(this.pendingInfiniteSearchId, 0, "cancel");
                }
                this.pendingInfiniteSearchId = 0;
                on2.d<com.tencent.mobileqq.search.model.k> dVar = this.infiniteSearchListener;
                if (dVar != null) {
                    List<com.tencent.mobileqq.search.model.k> list = this.infiniteSearchListResult;
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    dVar.onFinish(list, 0);
                }
                this.infiniteSearchListener = null;
                this.infiniteSearchListResult = null;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // on2.b
    public void destroy() {
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "destroy()");
        ae m3 = m();
        if (m3 != null) {
            m3.q0(this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // on2.b
    public void init() {
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "init()");
        ae m3 = m();
        if (m3 != null) {
            m3.addKernelSearchListener(this);
        }
    }

    @NotNull
    public Future<List<com.tencent.mobileqq.search.model.k>> o(@NotNull pn2.a searchRequest) {
        Intrinsics.checkNotNullParameter(searchRequest, "searchRequest");
        return b(searchRequest, new Function1<List<? extends com.tencent.mobileqq.search.model.k>, List<? extends com.tencent.mobileqq.search.model.k>>() { // from class: com.tencent.mobileqq.search.business.contact.NtBuddySearchEngine$searchAsync$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final List<com.tencent.mobileqq.search.model.k> invoke(@Nullable List<? extends com.tencent.mobileqq.search.model.k> list) {
                return list;
            }
        });
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
    public void onSearchBuddyChatInfoResult(@NotNull SearchBuddyChatInfoResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "onSearchBuddyChatInfoResult() hasMore: " + result.hasMore + ", " + this.searchId + "/" + result.searchId + ", " + result);
        ArrayList<com.tencent.mobileqq.search.model.k> arrayList = new ArrayList<>();
        pn2.a aVar = this.latestSearchRequest;
        if (aVar != null) {
            str = aVar.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        int i3 = result.searchId;
        ArrayList<SearchBuddyItem> arrayList2 = result.resultItems;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "result.resultItems");
        for (SearchBuddyItem it : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(j(it));
        }
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            n(i3, arrayList, str2, result.hasMore, "onSearchBuddyChatInfoResult()");
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
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
    public void onSearchContactResult(@NotNull SearchContactResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.f235387a.d().i("NtBuddySearchEngine", 1, "onSearchContactResult() hasMore: " + result.hasMore + ", " + this.searchId + "/" + result.searchId + ", " + result);
        ArrayList<com.tencent.mobileqq.search.model.k> arrayList = new ArrayList<>();
        pn2.a aVar = this.latestSearchRequest;
        if (aVar != null) {
            str = aVar.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        int i3 = result.searchId;
        ArrayList<SearchContactItem> arrayList2 = result.resultItems;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "result.resultItems");
        for (SearchContactItem it : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.mobileqq.search.model.k k3 = k(it);
            if (k3 != null) {
                arrayList.add(k3);
            }
        }
        ReentrantLock reentrantLock = this.pendingSearchLock;
        reentrantLock.lock();
        try {
            n(i3, arrayList, str2, result.hasMore, "onSearchGroupChatInfoResult()");
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
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
    public /* synthetic */ void onSearchResult(SearchResult searchResult) {
        bm.m(this, searchResult);
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
