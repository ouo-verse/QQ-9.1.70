package com.tencent.mobileqq.search.business.contact;

import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGameItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupMemberProfileItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoType;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QzoneIPCModule;
import do2.GroupSearchModelNtTroopResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wn2.ContactSearchModelNtBuddy;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f3\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001_\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003NzOB\u000f\u0012\u0006\u0010T\u001a\u00020\u0015\u00a2\u0006\u0004\bx\u0010yJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002JH\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0002JS\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J$\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\fH\u0002J,\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010$\u001a\u00020\u0015H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\fH\u0002J\u001a\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002J,\u00101\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\nH\u0002J,\u00103\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010.\u001a\u0002022\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\nH\u0002J(\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\bH\u0002J\u0018\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010@\u001a\u00020\b2\u0006\u0010>\u001a\u00020=2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0015H\u0002J\"\u0010D\u001a\u00020\b2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010H\u001a\u00020\b2\u0006\u0010A\u001a\u00020\n2\b\b\u0002\u0010F\u001a\u00020E2\b\b\u0002\u0010G\u001a\u00020\nH\u0002J\b\u0010I\u001a\u00020\bH\u0016J\b\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\bH\u0016J\b\u0010L\u001a\u00020\bH\u0016J\b\u0010M\u001a\u00020\bH\u0016J\u001a\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010O\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0012\u0010P\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000104H\u0016R\u0017\u0010T\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bX\u0010\u0017R$\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060[R\u00020\u00000Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010hR\u001e\u0010m\u001a\f\u0012\b\u0012\u00060kR\u00020\u00000j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010lR\u001b\u0010s\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020u0t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010v\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine;", "", "Lcom/tencent/mobileqq/search/model/x;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lpn2/a;", "searchRequest", "Lon2/d;", "listener", "", "B", "", "keyword", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/api/ae;", "service", "Lkotlin/Function1;", "updateFun", "Lkotlin/Function0;", "onCompleteFun", "D", "", "reqId", "I", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBuddyItem;", "buddyItems", "", "Lwn2/k;", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupItem;", "troopItems", "Lwn2/l;", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "chatSummaryList", "queryId", "Lcom/tencent/mobileqq/search/model/y;", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFunctionItem;", "functionItems", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchContactItem;", "it", "Lcom/tencent/mobileqq/search/model/k;", "t", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "rankInfo", "recallReason", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupMemberItem;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "result", "searchId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "Ldo2/n;", VipFunCallConstants.KEY_GROUP, DomainData.DOMAIN_NAME, "Lcom/tencent/common/app/AppInterface;", "app", "index", "o", "stage", "key", "value", UserInfo.SEX_FEMALE, "", QzoneIPCModule.RESULT_CODE, "resultMsg", "G", "init", "cancel", "pause", "resume", "destroy", "a", "c", "onSearchLocalInfoResult", "d", "y", "()I", IProfileCardConst.KEY_FROM_TYPE, "e", "Lcom/tencent/qqnt/kernel/api/ae;", "searchNtService", "f", ForwardRecentActivity.KEY_SEARCH_SOURCE, "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$a;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "reqCollectJobMap", "com/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$d", "i", "Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$d;", "exceptionHandler", "Lkotlin/coroutines/CoroutineContext;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$c;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "resultFlow", "", "E", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "isBanSearchInStudyMode", "", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Ljava/util/Map;", "perfStageReportTaskMap", "<init>", "(I)V", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NtGroupLocalInfoSearchEngine implements on2.b, IKernelSearchListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<c> resultFlow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy isBanSearchInStudyMode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Map<String, IPerformanceReportTask> perfStageReportTaskMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int fromType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ae searchNtService = com.tencent.mobileqq.search.util.n.b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int searchSource = 100860733;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, a> reqCollectJobMap = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d exceptionHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$a;", "", "", "msg", "", "a", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "getCollectJob", "()Lkotlinx/coroutines/Job;", "setCollectJob", "(Lkotlinx/coroutines/Job;)V", "collectJob", "b", "getOverTimeJob", "setOverTimeJob", "overTimeJob", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/Job;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Job collectJob;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Job overTimeJob;

        public a(@Nullable Job job, @Nullable Job job2) {
            this.collectJob = job;
            this.overTimeJob = job2;
        }

        public final void a(@NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Job job = this.collectJob;
            if (job != null) {
                JobKt__JobKt.cancel$default(job, "cancelJob(collectJob)___  " + msg2, null, 2, null);
            }
            Job job2 = this.overTimeJob;
            if (job2 != null) {
                JobKt__JobKt.cancel$default(job2, "cancelJob(overTimeJob)___  " + msg2, null, 2, null);
            }
        }

        public /* synthetic */ a(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, Job job, Job job2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : job, (i3 & 2) != 0 ? null : job2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$d", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements CoroutineExceptionHandler {
        d() {
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <R> R fold(R r16, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineExceptionHandler.DefaultImpls.fold(this, r16, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        @Nullable
        public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
            return (E) CoroutineExceptionHandler.DefaultImpls.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element
        @NotNull
        public CoroutineContext.Key<?> getKey() {
            return CoroutineExceptionHandler.INSTANCE;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(exception, "exception");
            if (QLog.isColorLevel()) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
                QLog.e("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "coroutineException:  " + exception + " \n   " + stackTraceToString);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        @NotNull
        public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
            return CoroutineExceptionHandler.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        @NotNull
        public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
            return CoroutineExceptionHandler.DefaultImpls.plus(this, coroutineContext);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements FlowCollector<c> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f282895e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f282896f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0 f282897h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f282898i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Function1 f282899m;

        public e(String str, int i3, Function0 function0, a aVar, Function1 function1) {
            this.f282895e = str;
            this.f282896f = i3;
            this.f282897h = function0;
            this.f282898i = aVar;
            this.f282899m = function1;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(c cVar, @NotNull Continuation<? super Unit> continuation) {
            Integer num;
            c cVar2 = cVar;
            SearchLocalInfoResult result = cVar2.getResult();
            Logger logger = Logger.f235387a;
            String str = null;
            if (QLog.isDevelopLevel()) {
                int i3 = this.f282896f;
                if (result != null) {
                    num = Boxing.boxInt(result.f359215id);
                } else {
                    num = null;
                }
                Log.d("QQSearch.Local.NtGroupLocalInfoSearchEngine", "collect reqId:" + i3 + " result.id:" + num + " isComplete:" + cVar2.getIsComplete());
            }
            List q16 = NtGroupLocalInfoSearchEngine.this.q(this.f282895e, result, this.f282896f);
            if (cVar2.getIsComplete()) {
                Function0 function0 = this.f282897h;
                if (function0 != null) {
                    function0.invoke();
                }
                a aVar = this.f282898i;
                if (aVar != null) {
                    aVar.a("collect jobCancelNow(complete) reqId:" + this.f282896f);
                }
                ae aeVar = NtGroupLocalInfoSearchEngine.this.searchNtService;
                if (aeVar != null) {
                    aeVar.cancelSearchLocalInfo(this.f282896f, 1, null);
                }
                NtGroupLocalInfoSearchEngine.this.reqCollectJobMap.remove(Boxing.boxInt(this.f282896f));
                NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine = NtGroupLocalInfoSearchEngine.this;
                if (result != null) {
                    str = result.recallReason;
                }
                ntGroupLocalInfoSearchEngine.F("search_local_info_finish", "recall_reason", str);
                NtGroupLocalInfoSearchEngine.this.G("search_local_info_finish", cVar2.getError(), cVar2.getMessage());
            } else {
                Function1 function1 = this.f282899m;
                if (function1 != null) {
                    function1.invoke(q16);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public NtGroupLocalInfoSearchEngine(int i3) {
        Lazy lazy;
        this.fromType = i3;
        d dVar = new d();
        this.exceptionHandler = dVar;
        CoroutineContext plus = Dispatchers.getDefault().plus(dVar).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        this.coroutineContext = plus;
        this.scope = CoroutineScopeKt.CoroutineScope(plus);
        this.resultFlow = SharedFlowKt.MutableSharedFlow$default(3, 7, null, 4, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$isBanSearchInStudyMode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode());
            }
        });
        this.isBanSearchInStudyMode = lazy;
        this.perfStageReportTaskMap = new LinkedHashMap();
    }

    private final boolean A() {
        return ((Boolean) this.isBanSearchInStudyMode.getValue()).booleanValue();
    }

    private final void B(pn2.a searchRequest, on2.d<x> listener) {
        String str;
        Job launch$default;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        ae aeVar = this.searchNtService;
        if (aeVar != null) {
            p();
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1(this, aeVar, str, null), 2, null);
            if (launch$default != null) {
                Logger.f235387a.d().w("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "queryLocalInfoAsync but service is null!");
            }
        }
    }

    private final List<x> C(String keyword) {
        ArrayList arrayList = new ArrayList();
        ae aeVar = this.searchNtService;
        if (aeVar != null && ((List) BuildersKt.runBlocking(this.coroutineContext, new NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1(this, aeVar, keyword, arrayList, null))) != null) {
            Logger.f235387a.d().w("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "queryLocalInfoSync but service is null!");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
    public final void D(ae service, String keyword, Function1<? super List<? extends x>, Unit> updateFun, Function0<Unit> onCompleteFun) {
        Job launch$default;
        z();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int searchLocalInfo = service.searchLocalInfo(keyword, SearchLocalBusinessType.KSEARCHLOCALBUSINESSTYPEMQQALL, new IOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NtGroupLocalInfoSearchEngine.E(NtGroupLocalInfoSearchEngine.this, objectRef, i3, str);
            }
        });
        objectRef.element = Integer.valueOf(searchLocalInfo);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new NtGroupLocalInfoSearchEngine$queryLocalInfoV2$reqJob$1(this, keyword, searchLocalInfo, updateFun, onCompleteFun, null), 2, null);
        this.reqCollectJobMap.put(Integer.valueOf(searchLocalInfo), new a(this, launch$default, null, 2, null));
        SearchUtils.W0("all_result", "active_local", keyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void E(NtGroupLocalInfoSearchEngine this$0, Ref.ObjectRef req, int i3, String errorMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "$req");
        Logger.f235387a.d().i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "queryLocalInfo___  result:" + i3 + "     errorMsg:" + errorMsg);
        MutableSharedFlow<c> mutableSharedFlow = this$0.resultFlow;
        Integer num = (Integer) req.element;
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        mutableSharedFlow.tryEmit(new c(this$0, num, null, true, i3, errorMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String stage, String key, Object value) {
        IPerformanceReportTask iPerformanceReportTask = this.perfStageReportTaskMap.get(stage);
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtra(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String stage, long resultCode, String resultMsg) {
        IPerformanceReportTask iPerformanceReportTask = this.perfStageReportTaskMap.get(stage);
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(resultCode);
            iPerformanceReportTask.setResultMsg(resultMsg);
            iPerformanceReportTask.report();
        }
    }

    static /* synthetic */ void H(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, String str, long j3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        ntGroupLocalInfoSearchEngine.G(str, j3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(String str, final int i3, Function1<? super List<? extends x>, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        a aVar = this.reqCollectJobMap.get(Boxing.boxInt(i3));
        final MutableSharedFlow<c> mutableSharedFlow = this.resultFlow;
        Object collect = new Flow<c>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$startCollectQueryInfoV2$$inlined$filter$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$startCollectQueryInfoV2$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes18.dex */
            public static final class AnonymousClass2 implements FlowCollector<NtGroupLocalInfoSearchEngine.c> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f282883d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f282884e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$startCollectQueryInfoV2$$inlined$filter$1$2", f = "NtGroupLocalInfoSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$startCollectQueryInfoV2$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, int i3) {
                    this.f282883d = flowCollector;
                    this.f282884e = i3;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(NtGroupLocalInfoSearchEngine.c cVar, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean z16;
                    Integer num;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f282883d;
                                NtGroupLocalInfoSearchEngine.c cVar2 = cVar;
                                SearchLocalInfoResult result = cVar2.getResult();
                                Logger logger = Logger.f235387a;
                                if (QLog.isDevelopLevel()) {
                                    int i17 = this.f282884e;
                                    if (result != null) {
                                        num = Boxing.boxInt(result.f359215id);
                                    } else {
                                        num = null;
                                    }
                                    Log.d("QQSearch.Local.NtGroupLocalInfoSearchEngine", "startCollectQueryInfoV2   filter   reqId:" + i17 + "   result.id:" + num);
                                }
                                if (result != null || cVar2.getIsComplete()) {
                                    Integer searchId = cVar2.getSearchId();
                                    int i18 = this.f282884e;
                                    if (searchId != null && searchId.intValue() == i18) {
                                        z16 = true;
                                        if (z16) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(cVar, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                z16 = false;
                                if (z16) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super NtGroupLocalInfoSearchEngine.c> flowCollector, @NotNull Continuation continuation2) {
                Object coroutine_suspended2;
                Object collect2 = Flow.this.collect(new AnonymousClass2(flowCollector, i3), continuation2);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect2 == coroutine_suspended2) {
                    return collect2;
                }
                return Unit.INSTANCE;
            }
        }.collect(new e(str, i3, function0, aVar, function1), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(do2.n group, String keyword) {
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
            o(appInterface, keyword, group, 0);
        }
        if ((this.searchSource & 512) != 0) {
            o(appInterface, keyword, group, 1);
        }
    }

    private final void o(AppInterface app, String keyword, do2.n group, int index) {
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
        group.o().addAll(arrayList);
        group.u(group.t() + arrayList.size());
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("QQSearch.Local.NtGroupLocalInfoSearchEngine", 2, "appendPhoneContactWithIndex(" + index + ") cost " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (!this.reqCollectJobMap.isEmpty()) {
            for (Map.Entry<Integer, a> entry : this.reqCollectJobMap.entrySet()) {
                ae aeVar = this.searchNtService;
                if (aeVar != null) {
                    aeVar.cancelSearchLocalInfo(entry.getKey().intValue(), 1, null);
                }
                entry.getValue().a("search manually cancel");
            }
            this.reqCollectJobMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<x> q(String keyword, SearchLocalInfoResult result, int searchId) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        ArrayList<SearchGameItem> arrayList;
        ArrayList<SearchFileItem> arrayList2;
        ArrayList<SearchGroupItem> arrayList3;
        ArrayList<SearchFunctionItem> arrayList4;
        ArrayList<SearchChatSummaryItem> arrayList5;
        String str;
        List mutableList;
        ArrayList<SearchContactItem> arrayList6;
        ArrayList<SearchBuddyItem> arrayList7;
        SearchLocalInfoType searchLocalInfoType;
        String str2;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        ArrayList<SearchFunctionItem> arrayList8;
        ArrayList<SearchGameItem> arrayList9;
        ArrayList<SearchFileItem> arrayList10;
        ArrayList<SearchChatSummaryItem> arrayList11;
        ArrayList<SearchGroupItem> arrayList12;
        ArrayList<SearchContactItem> arrayList13;
        ArrayList<SearchBuddyItem> arrayList14;
        ArrayList arrayList15 = new ArrayList();
        String str3 = null;
        if (QLog.isDevelopLevel()) {
            if (result != null) {
                searchLocalInfoType = result.type;
            } else {
                searchLocalInfoType = null;
            }
            if (result != null) {
                str2 = result.recallReason;
            } else {
                str2 = null;
            }
            if (result != null && (arrayList14 = result.buddyList) != null) {
                num = Integer.valueOf(arrayList14.size());
            } else {
                num = null;
            }
            if (result != null && (arrayList13 = result.contactList) != null) {
                num2 = Integer.valueOf(arrayList13.size());
            } else {
                num2 = null;
            }
            if (result != null && (arrayList12 = result.groupInfos) != null) {
                num3 = Integer.valueOf(arrayList12.size());
            } else {
                num3 = null;
            }
            if (result != null && (arrayList11 = result.chatsSummary) != null) {
                num4 = Integer.valueOf(arrayList11.size());
            } else {
                num4 = null;
            }
            if (result != null && (arrayList10 = result.fileInfos) != null) {
                num5 = Integer.valueOf(arrayList10.size());
            } else {
                num5 = null;
            }
            if (result != null && (arrayList9 = result.gameInfos) != null) {
                num6 = Integer.valueOf(arrayList9.size());
            } else {
                num6 = null;
            }
            if (result != null && (arrayList8 = result.functions) != null) {
                num7 = Integer.valueOf(arrayList8.size());
            } else {
                num7 = null;
            }
            QLog.i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 2, "convertSearchLocalInfoResultToSearchModel__   type:" + searchLocalInfoType + "  recallReason: " + str2 + ", buddyList.size:" + num + "   contactList.size:" + num2 + "   groupInfos.size:" + num3 + "   chatsSummary.size:" + num4 + "   fileInfos.size:" + num5 + "   gameInfos.size:" + num6 + "   functions.size:" + num7 + "   ");
        }
        ArrayList arrayList16 = new ArrayList();
        boolean z26 = false;
        if (result != null && (arrayList7 = result.buddyList) != null && (!arrayList7.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<SearchBuddyItem> arrayList17 = result.buddyList;
            Intrinsics.checkNotNullExpressionValue(arrayList17, "result.buddyList");
            arrayList16.addAll(u(keyword, arrayList17));
        }
        if (result != null && (arrayList6 = result.contactList) != null && (!arrayList6.isEmpty())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ArrayList<SearchContactItem> arrayList18 = result.contactList;
            Intrinsics.checkNotNullExpressionValue(arrayList18, "result.contactList");
            ArrayList arrayList19 = new ArrayList();
            for (SearchContactItem it : arrayList18) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                com.tencent.mobileqq.search.model.k t16 = t(keyword, it);
                if (t16 != null) {
                    arrayList19.add(t16);
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList19);
            arrayList16.addAll(mutableList);
        }
        if (!arrayList16.isEmpty()) {
            int i3 = this.fromType;
            if (result != null) {
                str = result.recallReason;
            } else {
                str = null;
            }
            arrayList15.add(new do2.n(i3, arrayList16, keyword, str));
            if (result != null) {
                str3 = result.recallReason;
            }
            F("search_local_info_personal_cost", "recall_reason", str3);
            H(this, "search_local_info_personal_cost", 0L, null, 6, null);
        }
        if (result != null && (arrayList5 = result.chatsSummary) != null && (!arrayList5.isEmpty())) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            ArrayList<SearchChatSummaryItem> arrayList20 = result.chatsSummary;
            Intrinsics.checkNotNullExpressionValue(arrayList20, "result.chatsSummary");
            List<y> v3 = v(keyword, arrayList20, searchId);
            String str4 = result.recallReason;
            Intrinsics.checkNotNullExpressionValue(str4, "result.recallReason");
            arrayList15.add(new vn2.a(v3, keyword, str4));
            F("search_local_info_chat_cost", "recall_reason", result.recallReason);
            H(this, "search_local_info_chat_cost", 0L, null, 6, null);
        }
        if (result != null && (arrayList4 = result.functions) != null && (!arrayList4.isEmpty())) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19 && !A()) {
            ArrayList<SearchFunctionItem> arrayList21 = result.functions;
            Intrinsics.checkNotNullExpressionValue(arrayList21, "result.functions");
            arrayList15.add(new do2.g(w(keyword, arrayList21), keyword, this.fromType));
            F("search_local_info_function_cost", "recall_reason", result.recallReason);
            H(this, "search_local_info_function_cost", 0L, null, 6, null);
        }
        if (result != null && (arrayList3 = result.groupInfos) != null && (!arrayList3.isEmpty())) {
            z26 = true;
        }
        if (z26) {
            int i16 = this.fromType;
            ArrayList<SearchGroupItem> arrayList22 = result.groupInfos;
            Intrinsics.checkNotNullExpressionValue(arrayList22, "result.groupInfos");
            arrayList15.add(new GroupSearchModelNtTroopResult(i16, x(keyword, arrayList22), keyword, result.recallReason));
            F("search_local_info_group_cost", "recall_reason", result.recallReason);
            H(this, "search_local_info_group_cost", 0L, null, 6, null);
        }
        if (result != null && (arrayList2 = result.fileInfos) != null) {
            arrayList2.isEmpty();
        }
        if (result != null && (arrayList = result.gameInfos) != null) {
            arrayList.isEmpty();
        }
        return arrayList15;
    }

    private final com.tencent.mobileqq.search.model.k r(String keyword, SearchBuddyItem item, String rankInfo, String recallReason) {
        boolean z16;
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(this.fromType, 0L);
        contactSearchModelNtBuddy.keyword = keyword;
        contactSearchModelNtBuddy.m0(item.nickname + "/" + item.remark);
        contactSearchModelNtBuddy.uin = String.valueOf(item.uin);
        List<SearchHitInfo> list = item.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str = item.nickname;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.f0(str);
        List<SearchHitInfo> list2 = item.nicknameHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str3 = item.remark;
        if (str3 != null) {
            str2 = str3;
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
            Logger.f235387a.d().i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createBuddyFrom " + item + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(item.chatType);
        String str4 = item.categoryName;
        Intrinsics.checkNotNullExpressionValue(str4, "item.categoryName");
        contactSearchModelNtBuddy.c0(str4);
        contactSearchModelNtBuddy.i0(rankInfo);
        contactSearchModelNtBuddy.j0(recallReason);
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }

    private final com.tencent.mobileqq.search.model.k s(String keyword, SearchGroupMemberItem item, String rankInfo, String recallReason) {
        boolean z16;
        ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(this.fromType, 0L);
        contactSearchModelNtBuddy.keyword = keyword;
        contactSearchModelNtBuddy.m0(item.nick + "/" + item.remark + "/" + item.cardName);
        contactSearchModelNtBuddy.uin = String.valueOf(item.uin);
        List<SearchHitInfo> list = item.uinHits;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.n0(list);
        String str = item.nick;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        contactSearchModelNtBuddy.f0(str);
        List<SearchHitInfo> list2 = item.nickHits;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        contactSearchModelNtBuddy.g0(list2);
        String str3 = item.remark;
        if (str3 != null) {
            str2 = str3;
        }
        contactSearchModelNtBuddy.k0(str2);
        ArrayList<SearchHitInfo> arrayList = item.remarkHits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.remarkHits");
        contactSearchModelNtBuddy.l0(arrayList);
        String str4 = item.cardName;
        Intrinsics.checkNotNullExpressionValue(str4, "item.cardName");
        contactSearchModelNtBuddy.a0(str4);
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
            Logger.f235387a.d().i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createBuddyFrom " + item + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
        }
        contactSearchModelNtBuddy.d0(2);
        String str5 = item.groupName;
        Intrinsics.checkNotNullExpressionValue(str5, "item.groupName");
        contactSearchModelNtBuddy.c0(str5);
        contactSearchModelNtBuddy.e0(String.valueOf(item.groupCode));
        contactSearchModelNtBuddy.i0(rankInfo);
        contactSearchModelNtBuddy.j0(recallReason);
        contactSearchModelNtBuddy.R();
        return contactSearchModelNtBuddy;
    }

    private final com.tencent.mobileqq.search.model.k t(String keyword, SearchContactItem it) {
        try {
            QLog.i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createBuddyFromContact, recallReason: " + ag.b(it.recallReason, 0, 1, null));
            SearchBuddyItem searchBuddyItem = it.buddyItem;
            if (searchBuddyItem != null) {
                Intrinsics.checkNotNullExpressionValue(searchBuddyItem, "it.buddyItem");
                String str = it.rankInfo;
                Intrinsics.checkNotNullExpressionValue(str, "it.rankInfo");
                String str2 = it.recallReason;
                Intrinsics.checkNotNullExpressionValue(str2, "it.recallReason");
                return r(keyword, searchBuddyItem, str, str2);
            }
            SearchGroupMemberItem searchGroupMemberItem = it.groupMemberItem;
            if (searchGroupMemberItem != null) {
                Intrinsics.checkNotNullExpressionValue(searchGroupMemberItem, "it.groupMemberItem");
                String str3 = it.rankInfo;
                Intrinsics.checkNotNullExpressionValue(str3, "it.rankInfo");
                String str4 = it.recallReason;
                Intrinsics.checkNotNullExpressionValue(str4, "it.recallReason");
                return s(keyword, searchGroupMemberItem, str3, str4);
            }
            com.tencent.mobileqq.guild.util.s.f("QQSearch.Local.NtGroupLocalInfoSearchEngine", "\u4e0d\u5b8c\u6574\u7684\u6570\u636e: " + it, new IllegalStateException());
            return null;
        } catch (RuntimeException e16) {
            com.tencent.mobileqq.guild.util.s.f("QQSearch.Local.NtGroupLocalInfoSearchEngine", "\u9519\u8bef\u7684\u6570\u636e: " + it, e16);
            return null;
        }
    }

    private final List<ContactSearchModelNtBuddy> u(String keyword, List<SearchBuddyItem> buddyItems) {
        int collectionSizeOrDefault;
        List<ContactSearchModelNtBuddy> mutableList;
        boolean z16;
        List<SearchBuddyItem> list = buddyItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SearchBuddyItem searchBuddyItem : list) {
            ContactSearchModelNtBuddy contactSearchModelNtBuddy = new ContactSearchModelNtBuddy(this.fromType, 0L);
            contactSearchModelNtBuddy.keyword = keyword;
            contactSearchModelNtBuddy.m0(searchBuddyItem.nickname + "/" + searchBuddyItem.remark);
            contactSearchModelNtBuddy.uin = String.valueOf(searchBuddyItem.uin);
            List<SearchHitInfo> list2 = searchBuddyItem.uinHits;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(list2, "item.uinHits ?: emptyList()");
            }
            contactSearchModelNtBuddy.n0(list2);
            String str = searchBuddyItem.nickname;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "item.nickname ?: \"\"");
            }
            contactSearchModelNtBuddy.f0(str);
            List<SearchHitInfo> list3 = searchBuddyItem.nicknameHits;
            if (list3 == null) {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(list3, "item.nicknameHits ?: emptyList()");
            }
            contactSearchModelNtBuddy.g0(list3);
            String str3 = searchBuddyItem.remark;
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "item.remark ?: \"\"");
                str2 = str3;
            }
            contactSearchModelNtBuddy.k0(str2);
            ArrayList<SearchHitInfo> arrayList2 = searchBuddyItem.remarkHits;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "item.remarkHits");
            contactSearchModelNtBuddy.l0(arrayList2);
            if (contactSearchModelNtBuddy.uin.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(searchBuddyItem.uid);
                Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026).getUinFromUid(item.uid)");
                contactSearchModelNtBuddy.uin = uinFromUid;
                Logger.f235387a.d().i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createBuddyFrom " + searchBuddyItem + ", uin \u5f02\u5e38! \u515c\u5e95 " + contactSearchModelNtBuddy.uin);
            }
            contactSearchModelNtBuddy.d0(searchBuddyItem.chatType);
            String str4 = searchBuddyItem.categoryName;
            Intrinsics.checkNotNullExpressionValue(str4, "item.categoryName");
            contactSearchModelNtBuddy.c0(str4);
            contactSearchModelNtBuddy.R();
            arrayList.add(contactSearchModelNtBuddy);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    private final List<y> v(String keyword, List<SearchChatSummaryItem> chatSummaryList, int queryId) {
        int collectionSizeOrDefault;
        List<y> mutableList;
        String str;
        y bVar;
        List<SearchChatSummaryItem> list = chatSummaryList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SearchChatSummaryItem searchChatSummaryItem : list) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createChatSummaryList, recallReason: " + ag.b(searchChatSummaryItem.recallReason, 0, 1, null) + ", realKeywords: " + ag.b(searchChatSummaryItem.realKeywords, 0, 1, null), null);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            if (!Intrinsics.areEqual(searchChatSummaryItem.recallReason, "normal")) {
                str = searchChatSummaryItem.realKeywords;
            } else {
                str = keyword;
            }
            ArrayList<String> splitSearchKeyword = ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).splitSearchKeyword(str);
            if (!splitSearchKeyword.contains(keyword)) {
                splitSearchKeyword.add(keyword);
            }
            if (!splitSearchKeyword.contains(str)) {
                splitSearchKeyword.add(str);
            }
            if (searchChatSummaryItem.chatType == 105) {
                bVar = new vn2.c(appInterface, keyword, null, splitSearchKeyword, null, searchChatSummaryItem, queryId);
            } else {
                String str2 = searchChatSummaryItem.recallReason;
                Intrinsics.checkNotNullExpressionValue(str2, "item.recallReason");
                bVar = new vn2.b(appInterface, keyword, str, splitSearchKeyword, null, searchChatSummaryItem, queryId, str2);
            }
            arrayList.add(bVar);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    private final List<y> w(String keyword, List<SearchFunctionItem> functionItems) {
        int collectionSizeOrDefault;
        List<y> mutableList;
        List<SearchFunctionItem> list = functionItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SearchFunctionItem searchFunctionItem : list) {
            lo2.c cVar = new lo2.c(keyword, String.valueOf(searchFunctionItem.fid), searchFunctionItem.name, searchFunctionItem.headUrl, searchFunctionItem.androidJumpUrl, "", VasBusiness.QWALLET, null, this.fromType);
            cVar.S(7);
            arrayList.add(cVar);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    private final List<ContactSearchModelNtTroop> x(String keyword, List<SearchGroupItem> troopItems) {
        int collectionSizeOrDefault;
        List<ContactSearchModelNtTroop> mutableList;
        Serializable[] serializableArr;
        List<SearchGroupItem> list = troopItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SearchGroupItem searchGroupItem : list) {
            QLog.i("QQSearch.Local.NtGroupLocalInfoSearchEngine", 1, "createTroopList, recallReason: " + searchGroupItem.recallReason);
            ContactSearchModelNtTroop contactSearchModelNtTroop = new ContactSearchModelNtTroop(this.fromType, 0L);
            contactSearchModelNtTroop.keyword = keyword;
            String str = searchGroupItem.groupInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str, "item.groupInfo.groupName");
            contactSearchModelNtTroop.title = str;
            contactSearchModelNtTroop.Z(String.valueOf(searchGroupItem.groupInfo.groupCode));
            String str2 = searchGroupItem.groupInfo.remarkName;
            Intrinsics.checkNotNullExpressionValue(str2, "item.groupInfo.remarkName");
            contactSearchModelNtTroop.i0(str2);
            ArrayList<SearchHitInfo> arrayList2 = searchGroupItem.groupInfo.remarkNameHits;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "item.groupInfo.remarkNameHits");
            contactSearchModelNtTroop.j0(arrayList2);
            String str3 = searchGroupItem.groupInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str3, "item.groupInfo.groupName");
            contactSearchModelNtTroop.b0(str3);
            ArrayList<SearchHitInfo> arrayList3 = searchGroupItem.groupInfo.groupNameHits;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "item.groupInfo.groupNameHits");
            contactSearchModelNtTroop.c0(arrayList3);
            ArrayList<SearchHitInfo> arrayList4 = searchGroupItem.groupInfo.groupCodeHits;
            Intrinsics.checkNotNullExpressionValue(arrayList4, "item.groupInfo.groupCodeHits");
            contactSearchModelNtTroop.a0(arrayList4);
            contactSearchModelNtTroop.Y(searchGroupItem.groupInfo.isConf);
            contactSearchModelNtTroop.e0(searchGroupItem.groupInfo.noCodeFingerOpenFlag);
            contactSearchModelNtTroop.d0(searchGroupItem.groupInfo.memberCount);
            ArrayList<SearchGroupMemberProfileItem> arrayList5 = searchGroupItem.memberProfile;
            Intrinsics.checkNotNullExpressionValue(arrayList5, "item.memberProfile");
            for (SearchGroupMemberProfileItem searchGroupMemberProfileItem : arrayList5) {
                Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.remarkHits, "profile.remarkHits");
                if (!r6.isEmpty()) {
                    serializableArr = new Serializable[]{searchGroupMemberProfileItem.remark, searchGroupMemberProfileItem.remarkHits, 3};
                } else {
                    Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.cardNameHits, "profile.cardNameHits");
                    if (!r6.isEmpty()) {
                        serializableArr = new Serializable[]{searchGroupMemberProfileItem.cardName, searchGroupMemberProfileItem.cardNameHits, 1};
                    } else {
                        Intrinsics.checkNotNullExpressionValue(searchGroupMemberProfileItem.nickHits, "profile.nickHits");
                        if (!r6.isEmpty()) {
                            serializableArr = new Serializable[]{searchGroupMemberProfileItem.nick, searchGroupMemberProfileItem.nickHits, 2};
                        } else {
                            serializableArr = new Serializable[]{String.valueOf(searchGroupMemberProfileItem.uin), searchGroupMemberProfileItem.uinHits, 4};
                        }
                    }
                }
                Serializable serializable = serializableArr[0];
                Serializable serializable2 = serializableArr[1];
                Serializable serializable3 = serializableArr[2];
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.String");
                Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo> }");
                Intrinsics.checkNotNull(serializable3, "null cannot be cast to non-null type kotlin.Int");
                contactSearchModelNtTroop.R((String) serializable, (ArrayList) serializable2, ((Integer) serializable3).intValue());
            }
            String str4 = searchGroupItem.rankInfo;
            Intrinsics.checkNotNullExpressionValue(str4, "item.rankInfo");
            contactSearchModelNtTroop.f0(str4);
            String str5 = searchGroupItem.recallReason;
            Intrinsics.checkNotNullExpressionValue(str5, "item.recallReason");
            contactSearchModelNtTroop.g0(str5);
            contactSearchModelNtTroop.S();
            arrayList.add(contactSearchModelNtTroop);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    private final void z() {
        this.perfStageReportTaskMap.clear();
        IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_local_info_nt_request_quality");
        IPerformanceReportTask stageCode = a16.duplicate(new String[0]).setStageCode("search_local_info_personal_cost");
        IPerformanceReportTask stageCode2 = a16.duplicate(new String[0]).setStageCode("search_local_info_group_cost");
        IPerformanceReportTask stageCode3 = a16.duplicate(new String[0]).setStageCode("search_local_info_chat_cost");
        IPerformanceReportTask stageCode4 = a16.duplicate(new String[0]).setStageCode("search_local_info_function_cost");
        IPerformanceReportTask stageCode5 = a16.duplicate(new String[0]).setStageCode("search_local_info_finish");
        this.perfStageReportTaskMap.put("search_local_info_personal_cost", stageCode);
        this.perfStageReportTaskMap.put("search_local_info_group_cost", stageCode2);
        this.perfStageReportTaskMap.put("search_local_info_chat_cost", stageCode3);
        this.perfStageReportTaskMap.put("search_local_info_function_cost", stageCode4);
        this.perfStageReportTaskMap.put("search_local_info_finish", stageCode5);
    }

    @Override // on2.b
    @Nullable
    public List<x> a(@Nullable pn2.a searchRequest) {
        String str;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return C(str);
    }

    @Override // on2.b
    public void c(@Nullable pn2.a searchRequest, @Nullable on2.d<x> listener) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.Local.NtGroupLocalInfoSearchEngine", "start search async");
        }
        if (searchRequest != null && (bundle4 = searchRequest.f426496b) != null) {
            bundle4.putBoolean("bSearchNet", true);
        }
        if (searchRequest != null && (bundle3 = searchRequest.f426496b) != null) {
            bundle3.putInt("iNumber", 11);
        }
        if (searchRequest != null && (bundle2 = searchRequest.f426496b) != null) {
            bundle2.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
        }
        if (searchRequest != null && (bundle = searchRequest.f426496b) != null) {
            bundle.putBoolean("searchTroopMember", false);
        }
        B(searchRequest, listener);
    }

    @Override // on2.b
    public void cancel() {
        p();
    }

    @Override // on2.b
    public void destroy() {
        cancel();
        ae aeVar = this.searchNtService;
        if (aeVar != null) {
            aeVar.q0(this);
        }
    }

    @Override // on2.b
    public void init() {
        ae aeVar = this.searchNtService;
        if (aeVar != null) {
            aeVar.addKernelSearchListener(this);
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
    public void onSearchLocalInfoResult(@Nullable SearchLocalInfoResult result) {
        Integer num;
        bm.k(this, result);
        MutableSharedFlow<c> mutableSharedFlow = this.resultFlow;
        if (result != null) {
            num = Integer.valueOf(result.f359215id);
        } else {
            num = null;
        }
        mutableSharedFlow.tryEmit(new c(this, num, result, false, 0, null, 24, null));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchMsgKeywordsResult(SearchMsgKeywordsResult searchMsgKeywordsResult) {
        bm.l(this, searchMsgKeywordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
    public /* synthetic */ void onSearchResult(SearchResult searchResult) {
        bm.m(this, searchResult);
    }

    /* renamed from: y, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine$c;", "", "", "a", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "searchId", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "result", "", "Z", "e", "()Z", "isComplete", "I", "()I", "error", "", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/NtGroupLocalInfoSearchEngine;Ljava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;ZILjava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Integer searchId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final SearchLocalInfoResult result;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isComplete;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int error;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String message;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ NtGroupLocalInfoSearchEngine f282893f;

        public c(@Nullable NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, @Nullable Integer num, SearchLocalInfoResult searchLocalInfoResult, boolean z16, @NotNull int i3, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f282893f = ntGroupLocalInfoSearchEngine;
            this.searchId = num;
            this.result = searchLocalInfoResult;
            this.isComplete = z16;
            this.error = i3;
            this.message = message;
        }

        /* renamed from: a, reason: from getter */
        public final int getError() {
            return this.error;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final SearchLocalInfoResult getResult() {
            return this.result;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final Integer getSearchId() {
            return this.searchId;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public /* synthetic */ c(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, Integer num, SearchLocalInfoResult searchLocalInfoResult, boolean z16, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(ntGroupLocalInfoSearchEngine, num, searchLocalInfoResult, z16, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? "" : str);
        }
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
