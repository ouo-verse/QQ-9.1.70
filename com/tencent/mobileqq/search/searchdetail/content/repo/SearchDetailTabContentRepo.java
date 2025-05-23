package com.tencent.mobileqq.search.searchdetail.content.repo;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchExpressionTemplateItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchGameTemplateItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchPlayletTemplateItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateBannerItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateDoubleColumnListItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateHorizontalListItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNoResultItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTopicHeaderItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateVerticalListItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchVerticalDetailTemplateItem;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.j;
import com.tencent.mobileqq.search.searchdetail.function.NetSearchFunctionItem;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ae;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.search.util.ak;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.ISearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchChannelConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchRecommendGuide;
import com.tencent.qqnt.kernel.nativeinterface.SearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.SearchRspBody;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabContent;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.util.AppSetting;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\bj\u0010kJf\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J^\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J0\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010H\u0002JV\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\"\u0010+\u001a\u0004\u0018\u00010\u001a2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0016\u00100\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150.H\u0002JC\u00107\u001a\u00020\u00152\u0006\u00102\u001a\u0002012\u0006\u0010,\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00102\b\u00106\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b7\u00108JM\u0010=\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010,\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00102\b\u0010<\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b=\u0010>Jf\u0010A\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016JV\u0010B\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010E\u001a\u0004\u0018\u00010\u001a2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u00102\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010GR\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010HR\u0016\u00103\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010HR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\"\u0010X\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010\\\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010S\u001a\u0004\bZ\u0010U\"\u0004\b[\u0010WR\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010SR\u0016\u0010`\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010SR\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010SR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010SR\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010HR\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010S\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/SearchDetailTabContentRepo;", "Lkn2/c;", "Landroid/content/Context;", "context", "", "keyword", "", "disableCorrectionQuery", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChannelConditonFilter;", "channelConditionFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "groupConditionFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "miniAppConditonFilter", "source", "searchId", "", "pageNum", "pageMode", "Lkn2/b;", "callback", "", "y", "keyWord", "v", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "result", HippyTKDListViewAdapter.X, "list", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchRspBody;", "rspBody", "isFirstReq", "t", "miniAppConditionFilter", "isFirstPage", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReqBody;", "r", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", ReportConstant.COSTREPORT_PREFIX, QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Function0;", "block", "B", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "tabInfo", "userSource", "perSearchId", "parentType", "sessionId", "D", "(Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "tabName", "", "tabMask", "pageSessionId", "a", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Landroid/app/Activity;", "withLBS", "b", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTabContent;", "tabContent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTabInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTabInfo;", "I", "", "d", "[B", "sessionInfo", "e", "busiSessionInfo", "f", "Z", "isEnd", "g", "Ljava/lang/String;", "getFunctionCardInfo", "()Ljava/lang/String;", "E", "(Ljava/lang/String;)V", "functionCardInfo", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, UserInfo.SEX_FEMALE, "lbsInfo", "i", "traceIdForFirstScreenData", "j", "currentTraceId", "k", "currentSearchId", "Ljava/util/concurrent/atomic/AtomicInteger;", "l", "Ljava/util/concurrent/atomic/AtomicInteger;", "dataSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailTabContentRepo implements kn2.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int querySource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int userSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int parentType;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SearchTabInfo tabInfo = new SearchTabInfo();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] sessionInfo = new byte[0];

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] busiSessionInfo = new byte[0];

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String functionCardInfo = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lbsInfo = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceIdForFirstScreenData = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile String currentTraceId = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentSearchId = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger dataSeq = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String perSearchId = "";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageSessionId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/repo/SearchDetailTabContentRepo$b", "Lcom/tencent/mobileqq/search/util/g;", "", "errorCode", "", "lbsJsonInfo", "", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.search.util.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f284045b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f284046c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f284047d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SearchChannelConditonFilter f284048e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SearchGroupConditonFilter f284049f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ SearchMiniAppConditonFilter f284050g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f284051h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f284052i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f284053j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f284054k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ kn2.b f284055l;

        b(long j3, String str, boolean z16, SearchChannelConditonFilter searchChannelConditonFilter, SearchGroupConditonFilter searchGroupConditonFilter, SearchMiniAppConditonFilter searchMiniAppConditonFilter, String str2, String str3, int i3, int i16, kn2.b bVar) {
            this.f284045b = j3;
            this.f284046c = str;
            this.f284047d = z16;
            this.f284048e = searchChannelConditonFilter;
            this.f284049f = searchGroupConditonFilter;
            this.f284050g = searchMiniAppConditonFilter;
            this.f284051h = str2;
            this.f284052i = str3;
            this.f284053j = i3;
            this.f284054k = i16;
            this.f284055l = bVar;
        }

        @Override // com.tencent.mobileqq.search.util.g
        public void a(int errorCode, @NotNull String lbsJsonInfo) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(lbsJsonInfo, "lbsJsonInfo");
            isBlank = StringsKt__StringsJVMKt.isBlank(lbsJsonInfo);
            if (!isBlank) {
                SearchDetailTabContentRepo.this.F(lbsJsonInfo);
            }
            com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.b(SearchDetailTabContentRepo.this.tabInfo.tabMask);
            long uptimeMillis = SystemClock.uptimeMillis() - this.f284045b;
            Logger logger = Logger.f235387a;
            SearchDetailTabContentRepo searchDetailTabContentRepo = SearchDetailTabContentRepo.this;
            String str = this.f284051h;
            String str2 = this.f284046c;
            logger.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "startSearch with lbs timeCost=" + uptimeMillis + " lbs=" + searchDetailTabContentRepo.getLbsInfo() + " source=" + str + " keyword=" + ag.b(str2, 0, 1, null) + " tabInfo=" + searchDetailTabContentRepo.tabInfo);
            SearchDetailTabContentRepo.this.v(this.f284046c, this.f284047d, this.f284048e, this.f284049f, this.f284050g, this.f284051h, this.f284052i, this.f284053j, this.f284054k, this.f284055l);
        }
    }

    private final void A(String keyword, int querySource) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        linkedHashMap.put("pageId", "pg_qq_network_search_result_level2_page");
        String str = this.tabInfo.tabName;
        Intrinsics.checkNotNullExpressionValue(str, "tabInfo.tabName");
        linkedHashMap.put("tab_name", str);
        linkedHashMap.put("tab_mask", String.valueOf(this.tabInfo.tabMask));
        linkedHashMap.put("query_source", String.valueOf(querySource));
        linkedHashMap.put("user_source", String.valueOf(this.userSource));
        linkedHashMap.put("search_query_text", keyword);
        linkedHashMap.put("search_trace_id", this.currentTraceId);
        linkedHashMap.put("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        linkedHashMap.put("xsj_eid", "em_bas_search_request");
        linkedHashMap.put("eid", "em_bas_search_request");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", linkedHashMap);
    }

    private final void B(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.g
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDetailTabContentRepo.C(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(IPerformanceReportTask reportTask, final SearchDetailTabContentRepo this$0, String keyWord, int i3, final kn2.b callback, final String source, final long j3, final int i16, final String errorMsg, final SearchRspBody searchRspBody) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(keyWord, "$keyWord");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(source, "$source");
        reportTask.setResultCode(i16);
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        reportTask.setResultMsg(errorMsg);
        reportTask.report();
        if (!n.d(i16) && searchRspBody != null && !n.d(searchRspBody.resultCode)) {
            final List u16 = u(this$0, keyWord, searchRspBody, false, i3, 4, null);
            this$0.B(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo$startLoadMore$3$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    long currentTimeMillis = System.currentTimeMillis() - j3;
                    Logger logger = Logger.f235387a;
                    SearchDetailTabContentRepo searchDetailTabContentRepo = this$0;
                    String str = source;
                    SearchRspBody searchRspBody2 = searchRspBody;
                    List<com.tencent.mobileqq.search.searchdetail.a> list = u16;
                    logger.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "loadMore finish timeCost=" + currentTimeMillis + ",  tabInfo=" + searchDetailTabContentRepo.tabInfo + " source=" + str + " traceId=" + searchRspBody2.getClientTraceId() + " isEnd=" + searchRspBody2.isEnd + " rsp list size=" + searchRspBody2.tabContentResult.resultItems.size() + " result size=" + list.size());
                    if (QLog.isDebugVersion()) {
                        SearchDetailTabContentRepo searchDetailTabContentRepo2 = this$0;
                        List<com.tencent.mobileqq.search.searchdetail.a> list2 = u16;
                        logger.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "search finish. tabInfo=" + searchDetailTabContentRepo2.tabInfo + " " + list2);
                    }
                    SearchDetailTabContentRepo searchDetailTabContentRepo3 = this$0;
                    byte[] bArr = searchRspBody.sessionInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr, "rsp.sessionInfo");
                    searchDetailTabContentRepo3.sessionInfo = bArr;
                    SearchDetailTabContentRepo searchDetailTabContentRepo4 = this$0;
                    byte[] bArr2 = searchRspBody.busiSessionInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.busiSessionInfo");
                    searchDetailTabContentRepo4.busiSessionInfo = bArr2;
                    kn2.b bVar = callback;
                    List<com.tencent.mobileqq.search.searchdetail.a> list3 = u16;
                    SearchRspBody searchRspBody3 = searchRspBody;
                    boolean z16 = searchRspBody3.isEnd == 1;
                    SearchEmptyPageExtraInfo searchEmptyPageExtraInfo = searchRspBody3.tabContentResult.emptyPageExtraInfo;
                    Intrinsics.checkNotNullExpressionValue(searchEmptyPageExtraInfo, "rsp.tabContentResult.emptyPageExtraInfo");
                    SearchFloatButton searchFloatButton = searchRspBody.tabContentResult.floatButton;
                    Intrinsics.checkNotNullExpressionValue(searchFloatButton, "rsp.tabContentResult.floatButton");
                    ArrayList<SearchMiniAppConditonFilter> arrayList = searchRspBody.miniAppConditionFilters;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.miniAppConditionFilters");
                    byte[] bArr3 = searchRspBody.bytesExtension;
                    if (bArr3 == null) {
                        bArr3 = new byte[0];
                    }
                    bVar.onSuccess(list3, z16, searchEmptyPageExtraInfo, searchFloatButton, arrayList, new String(bArr3, Charsets.UTF_8));
                }
            });
        } else {
            this$0.B(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo$startLoadMore$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Logger logger = Logger.f235387a;
                    SearchDetailTabContentRepo searchDetailTabContentRepo = this$0;
                    String str = source;
                    int i17 = i16;
                    String str2 = errorMsg;
                    SearchRspBody searchRspBody2 = searchRspBody;
                    Logger.b bVar = new Logger.b();
                    String str3 = "loadMore finish tabInfo=" + searchDetailTabContentRepo.tabInfo + " source=" + str + " error=" + i17 + "_" + str2 + " rsp=" + (searchRspBody2 != null ? Integer.valueOf(searchRspBody2.resultCode) : null);
                    if (str3 instanceof String) {
                        bVar.a().add(str3);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it.next(), null);
                    }
                    kn2.b bVar2 = kn2.b.this;
                    int i18 = i16;
                    String errorMsg2 = errorMsg;
                    Intrinsics.checkNotNullExpressionValue(errorMsg2, "errorMsg");
                    bVar2.onFailed(i18, errorMsg2);
                }
            });
        }
    }

    private final void p(List<com.tencent.mobileqq.search.searchdetail.a> list) {
        boolean z16;
        NetSearchFunctionItem b16;
        if (this.functionCardInfo.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (b16 = NetSearchFunctionItem.INSTANCE.b(this.functionCardInfo)) != null) {
            b16.getLayoutInfo().marginTop = ViewUtils.dpToPx(3.0f);
            b16.getLayoutInfo().topCorner = ViewUtils.dpToPx(3.0f);
            b16.getLayoutInfo().bottomCorner = ViewUtils.dpToPx(3.0f);
            list.add(b16);
        }
    }

    private final SearchReqBody r(String keyWord, boolean disableCorrectionQuery, SearchChannelConditonFilter channelConditionFilter, SearchGroupConditonFilter groupConditionFilter, SearchMiniAppConditonFilter miniAppConditionFilter, boolean isFirstPage, String searchId, int pageNum, int pageMode) {
        boolean isBlank;
        String str = this.lbsInfo;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 2);
        SearchReqBody searchReqBody = new SearchReqBody();
        searchReqBody.keyWord = keyWord;
        searchReqBody.tabs = this.tabInfo;
        searchReqBody.version = AppSetting.getSubVersion();
        r rVar = r.f284572a;
        searchReqBody.deviceInfo = rVar.i();
        isBlank = StringsKt__StringsJVMKt.isBlank(this.pageSessionId);
        if (isBlank) {
            s.e("QQSearch.NetDetail.SearchDetailTabContentRepo", "pageSessionId is blank tabMask=" + this.tabInfo.tabMask, new RuntimeException("pageSessionId is blank"));
        }
        byte[] bytes2 = r.k(rVar, this.querySource, this.userSource, this.currentTraceId, null, searchId, j.z(this.parentType, this.perSearchId, keyWord), pageNum, pageMode, this.pageSessionId, true, 8, null).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        searchReqBody.bytesExtension = bytes2;
        searchReqBody.sessionInfo = this.sessionInfo;
        searchReqBody.firstPage = isFirstPage;
        searchReqBody.disableCorrectionQuery = disableCorrectionQuery;
        searchReqBody.usePbSerialization = true;
        searchReqBody.busiSessionInfo = this.busiSessionInfo;
        searchReqBody.lbs = encodeToString;
        if (channelConditionFilter != null) {
            searchReqBody.channelConditionFilter = channelConditionFilter;
        }
        if (groupConditionFilter != null) {
            searchReqBody.groupConditionFilter = groupConditionFilter;
        }
        if (miniAppConditionFilter != null) {
            searchReqBody.miniAppConditionFilter = miniAppConditionFilter;
        }
        return searchReqBody;
    }

    private final com.tencent.mobileqq.search.searchdetail.a s(CommonInfo commonInfo, SearchTemplate searchTemplate, String keyword) {
        switch (searchTemplate.getTemplateId()) {
            case 1:
                return new NetSearchGameTemplateItem(commonInfo, searchTemplate);
            case 2:
                return new NetSearchTemplateHorizontalListItem(commonInfo, searchTemplate);
            case 3:
                return new NetSearchTemplateVerticalListItem(commonInfo, searchTemplate);
            case 4:
                return new NetSearchTemplateBannerItem(commonInfo, searchTemplate);
            case 5:
                if (searchTemplate.nineBoxGrid != null) {
                    return new NetSearchTemplateNineBoxGridItem(commonInfo, searchTemplate);
                }
                QLog.e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "#createTemplateItem: unknown nine box data:" + searchTemplate);
                return null;
            case 6:
                return new NetSearchTemplateTitleItem(commonInfo, searchTemplate);
            case 7:
            case 11:
            default:
                QLog.e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "#createTemplateItem: unknown template id:" + searchTemplate.getTemplateId());
                return null;
            case 8:
                return new NetSearchTemplateDoubleColumnListItem(commonInfo, searchTemplate);
            case 9:
                NetSearchVerticalDetailTemplateItem netSearchVerticalDetailTemplateItem = new NetSearchVerticalDetailTemplateItem(commonInfo, searchTemplate);
                netSearchVerticalDetailTemplateItem.P(NetSearchVerticalDetailTemplateItem.INSTANCE.a(keyword));
                return netSearchVerticalDetailTemplateItem;
            case 10:
                return new NetSearchPlayletTemplateItem(commonInfo, searchTemplate);
            case 12:
                return new NetSearchExpressionTemplateItem(commonInfo, searchTemplate);
            case 13:
                return new NetSearchTemplateTopicHeaderItem(commonInfo, searchTemplate);
            case 14:
                return new com.tencent.mobileqq.search.searchdetail.content.template.model.f(commonInfo, searchTemplate);
            case 15:
                return new NetSearchFeedCollectionItem(commonInfo, searchTemplate, keyword);
            case 16:
                return new NetSearchHunYuanItem(commonInfo, searchTemplate, keyword, this.userSource);
            case 17:
                return new NetSearchTemplateNoResultItem(commonInfo, searchTemplate);
            case 18:
                return new com.tencent.mobileqq.search.tux.d(commonInfo, searchTemplate, keyword);
            case 19:
                return new com.tencent.mobileqq.search.searchdetail.content.wxminapp.b(commonInfo, searchTemplate);
        }
    }

    private final List<com.tencent.mobileqq.search.searchdetail.a> t(String keyWord, SearchRspBody rspBody, boolean isFirstReq, int pageMode) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (n.e(rspBody.resultCode)) {
            int i3 = 0;
            if (isFirstReq) {
                String str = rspBody.correctionQuery;
                Intrinsics.checkNotNullExpressionValue(str, "rspBody.correctionQuery");
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    String str2 = rspBody.correctionQuery;
                    Intrinsics.checkNotNullExpressionValue(str2, "rspBody.correctionQuery");
                    arrayList.add(new com.tencent.mobileqq.search.searchdetail.content.model.b(keyWord, str2));
                }
            }
            if (isFirstReq) {
                p(arrayList);
            }
            ArrayList<SearchTabContent> arrayList2 = rspBody.tabContentResult.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rspBody.tabContentResult.resultItems");
            for (Object obj : arrayList2) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SearchTabContent searchTabContent = (SearchTabContent) obj;
                Intrinsics.checkNotNullExpressionValue(searchTabContent, "searchTabContent");
                com.tencent.mobileqq.search.searchdetail.a q16 = q(searchTabContent, keyWord);
                if (q16 != null) {
                    arrayList.add(q16);
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    static /* synthetic */ List u(SearchDetailTabContentRepo searchDetailTabContentRepo, String str, SearchRspBody searchRspBody, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return searchDetailTabContentRepo.t(str, searchRspBody, z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(final String keyWord, boolean disableCorrectionQuery, SearchChannelConditonFilter channelConditionFilter, SearchGroupConditonFilter groupConditionFilter, SearchMiniAppConditonFilter miniAppConditonFilter, String source, String searchId, int pageNum, final int pageMode, final kn2.b callback) {
        boolean z16 = false;
        this.sessionInfo = new byte[0];
        this.busiSessionInfo = new byte[0];
        this.isEnd = false;
        this.currentTraceId = r.f284572a.f();
        this.currentSearchId = "";
        SearchReqBody r16 = r(keyWord, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, miniAppConditonFilter, true, "", pageNum, pageMode);
        final long currentTimeMillis = System.currentTimeMillis();
        String b16 = af.b(r16.keyWord, 0, 2, null);
        Logger.a d16 = Logger.f235387a.d();
        long j3 = r16.tabs.tabMask;
        String str = this.currentSearchId;
        if (this.sessionInfo.length == 0) {
            z16 = true;
        }
        d16.i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "startSearch source=" + source + " pageNum=" + pageNum + " keyWord=" + b16 + " tabMask=" + j3 + " searchId=" + str + " sessionInfoEmpty=" + z16);
        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.e(this.tabInfo.tabMask);
        A(keyWord, this.querySource);
        final IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_result_content_request_quality");
        a16.setExtra("tabName", this.tabInfo.tabName);
        a16.setExtra("searchReqTraceId", this.currentTraceId);
        a16.setExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, Integer.valueOf(this.querySource));
        a16.setExtra("keyWord", keyWord);
        a16.setExtra("isFirstPageReq", Boolean.TRUE);
        final long currentTimeMillis2 = System.currentTimeMillis();
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.search(r16, new ISearchCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISearchCallback
                public final void onResult(int i3, String str2, SearchRspBody searchRspBody) {
                    SearchDetailTabContentRepo.w(IPerformanceReportTask.this, currentTimeMillis2, keyWord, this, pageMode, callback, currentTimeMillis, i3, str2, searchRspBody);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(IPerformanceReportTask reportTask, long j3, String keyWord, final SearchDetailTabContentRepo this$0, int i3, final kn2.b callback, final long j16, final int i16, final String errorMsg, final SearchRspBody rsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(keyWord, "$keyWord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        reportTask.setResultCode(i16);
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        reportTask.setResultMsg(errorMsg);
        reportTask.report();
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (rsp != null && rsp.isExactSearch) {
            z16 = true;
        } else {
            z16 = false;
        }
        ak.c("0x90a5_3", currentTimeMillis, i16, keyWord, z16);
        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.a(this$0.tabInfo.tabMask);
        if (!n.d(i16) && !n.d(rsp.resultCode)) {
            this$0.traceIdForFirstScreenData = this$0.currentTraceId;
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            final List<com.tencent.mobileqq.search.searchdetail.a> t16 = this$0.t(keyWord, rsp, true, i3);
            this$0.B(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo$doStartSearch$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    boolean isBlank;
                    String x16;
                    SearchDetailTabContentRepo searchDetailTabContentRepo = SearchDetailTabContentRepo.this;
                    byte[] bArr = rsp.sessionInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr, "rsp.sessionInfo");
                    searchDetailTabContentRepo.sessionInfo = bArr;
                    SearchDetailTabContentRepo searchDetailTabContentRepo2 = SearchDetailTabContentRepo.this;
                    byte[] bArr2 = rsp.busiSessionInfo;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.busiSessionInfo");
                    searchDetailTabContentRepo2.busiSessionInfo = bArr2;
                    isBlank = StringsKt__StringsJVMKt.isBlank(SearchDetailTabContentRepo.this.currentSearchId);
                    if (isBlank && ((int) SearchDetailTabContentRepo.this.tabInfo.tabMask) != 1) {
                        SearchDetailTabContentRepo searchDetailTabContentRepo3 = SearchDetailTabContentRepo.this;
                        x16 = searchDetailTabContentRepo3.x(t16);
                        searchDetailTabContentRepo3.currentSearchId = x16;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - j16;
                    Logger logger = Logger.f235387a;
                    SearchDetailTabContentRepo searchDetailTabContentRepo4 = SearchDetailTabContentRepo.this;
                    SearchRspBody searchRspBody = rsp;
                    List<com.tencent.mobileqq.search.searchdetail.a> list = t16;
                    logger.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "search finish. tabInfo=" + searchDetailTabContentRepo4.tabInfo + " timeCost=" + currentTimeMillis2 + ", isEnd=" + searchRspBody.isEnd + " currentSearchId=" + searchDetailTabContentRepo4.currentSearchId + " rsp list size=" + searchRspBody.tabContentResult.resultItems.size() + " result size=" + list.size());
                    if (QLog.isDebugVersion()) {
                        SearchDetailTabContentRepo searchDetailTabContentRepo5 = SearchDetailTabContentRepo.this;
                        List<com.tencent.mobileqq.search.searchdetail.a> list2 = t16;
                        logger.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "search finish. tabInfo=" + searchDetailTabContentRepo5.tabInfo + " " + list2);
                    }
                    kn2.b bVar = callback;
                    List<com.tencent.mobileqq.search.searchdetail.a> list3 = t16;
                    SearchRspBody searchRspBody2 = rsp;
                    boolean z17 = searchRspBody2.isEnd == 1;
                    SearchEmptyPageExtraInfo searchEmptyPageExtraInfo = searchRspBody2.tabContentResult.emptyPageExtraInfo;
                    Intrinsics.checkNotNullExpressionValue(searchEmptyPageExtraInfo, "rsp.tabContentResult.emptyPageExtraInfo");
                    SearchFloatButton searchFloatButton = rsp.tabContentResult.floatButton;
                    Intrinsics.checkNotNullExpressionValue(searchFloatButton, "rsp.tabContentResult.floatButton");
                    ArrayList<SearchMiniAppConditonFilter> arrayList = rsp.miniAppConditionFilters;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.miniAppConditionFilters");
                    byte[] bArr3 = rsp.bytesExtension;
                    if (bArr3 == null) {
                        bArr3 = new byte[0];
                    }
                    bVar.onSuccess(list3, z17, searchEmptyPageExtraInfo, searchFloatButton, arrayList, new String(bArr3, Charsets.UTF_8));
                }
            });
            return;
        }
        this$0.B(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo$doStartSearch$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Logger logger = Logger.f235387a;
                SearchDetailTabContentRepo searchDetailTabContentRepo = this$0;
                SearchRspBody searchRspBody = rsp;
                int i17 = i16;
                String str = errorMsg;
                Logger.b bVar = new Logger.b();
                String str2 = "search finish tabInfo=" + searchDetailTabContentRepo.tabInfo + "  rsp.resultCode:" + searchRspBody.resultCode + "  error:" + i17 + "_" + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it.next(), null);
                }
                kn2.b bVar2 = kn2.b.this;
                int i18 = i16;
                String errorMsg2 = errorMsg;
                Intrinsics.checkNotNullExpressionValue(errorMsg2, "errorMsg");
                bVar2.onFailed(i18, errorMsg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x(List<com.tencent.mobileqq.search.searchdetail.a> result) {
        String searchId;
        int i3 = 0;
        for (Object obj : result) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.search.searchdetail.a aVar = (com.tencent.mobileqq.search.searchdetail.a) obj;
            if (aVar instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
                qp2.a backEndReportInfo = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) aVar).getBackEndReportInfo();
                if (backEndReportInfo == null || (searchId = backEndReportInfo.getSearchId()) == null) {
                    return "";
                }
                return searchId;
            }
            i3 = i16;
        }
        return "";
    }

    private final void y(Context context, String keyword, boolean disableCorrectionQuery, SearchChannelConditonFilter channelConditionFilter, SearchGroupConditonFilter groupConditionFilter, SearchMiniAppConditonFilter miniAppConditonFilter, String source, String searchId, int pageNum, int pageMode, kn2.b callback) {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "getLBSThenRequestData source=" + source + " keyword=" + ag.b(keyword, 0, 1, null) + " tabInfo=" + this.tabInfo);
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.f(this.tabInfo.tabMask);
        ae.f284991a.d(context, new b(uptimeMillis, keyword, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, miniAppConditonFilter, source, searchId, pageNum, pageMode, callback));
    }

    public final void D(@NotNull SearchDetailTabListViewModel.TabInfo tabInfo, int querySource, int userSource, @Nullable String perSearchId, @Nullable Integer parentType, @Nullable String sessionId) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        a(tabInfo.getTabName(), tabInfo.getTabMask(), querySource, userSource, perSearchId, parentType, sessionId);
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.functionCardInfo = str;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lbsInfo = str;
    }

    @Override // kn2.c
    public void a(@NotNull String tabName, long tabMask, int querySource, int userSource, @Nullable String perSearchId, @Nullable Integer parentType, @Nullable String pageSessionId) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        StringBuilder sb5 = new StringBuilder("setData tabMask=" + tabMask + " querySource=" + querySource + " userSource=" + userSource);
        SearchTabInfo searchTabInfo = this.tabInfo;
        searchTabInfo.tabName = tabName;
        searchTabInfo.tabMask = tabMask;
        this.userSource = userSource;
        this.querySource = querySource;
        if (perSearchId != null) {
            this.perSearchId = perSearchId;
            sb5.append(" perSearchId=" + perSearchId);
        }
        if (parentType == null) {
            this.parentType = com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.b(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.f284375a, querySource, null, 2, null);
        } else {
            this.parentType = parentType.intValue();
        }
        if (pageSessionId != null) {
            this.pageSessionId = pageSessionId;
        }
        sb5.append(" parentType=" + parentType);
        sb5.append(" pageSessionId=" + this.pageSessionId);
        af afVar = af.f284993a;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        QLog.i("QS.QQSearch.NetDetail.SearchDetailTabContentRepo", 1, sb6, null);
    }

    @Override // kn2.c
    public void b(@NotNull Activity context, @NotNull String keyword, boolean withLBS, boolean disableCorrectionQuery, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @Nullable SearchMiniAppConditonFilter miniAppConditionFilter, @NotNull String source, int pageNum, int pageMode, @NotNull kn2.b callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!AppNetConnInfo.isNetSupport()) {
            Logger.f235387a.d().w("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "startSearch source=" + source + " no net keyword=" + ag.b(keyword, 0, 1, null) + " tabInfo=" + this.tabInfo);
            callback.onFailed(-1, "no net");
            return;
        }
        if (withLBS) {
            y(context, keyword, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, miniAppConditionFilter, source, this.currentSearchId, pageNum, pageMode, callback);
            return;
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "loadData no lbs permission. send request without lbs source=" + source + " keyword=" + ag.b(keyword, 0, 1, null) + " tabInfo=" + this.tabInfo);
        v(keyword, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, miniAppConditionFilter, source, this.currentSearchId, pageNum, pageMode, callback);
    }

    @Override // kn2.c
    public void c(@NotNull final String keyWord, boolean disableCorrectionQuery, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @Nullable SearchMiniAppConditonFilter miniAppConditionFilter, @NotNull final String source, int pageNum, final int pageMode, @NotNull final kn2.b callback) {
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!AppNetConnInfo.isNetSupport()) {
            Logger.f235387a.d().w("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "startLoadMore source=" + source + " no net");
            callback.onFailed(-1, "no net");
            return;
        }
        this.currentTraceId = r.f284572a.f();
        final IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_result_content_request_quality");
        a16.setExtra("tabName", this.tabInfo.tabName);
        a16.setExtra("searchReqTraceId", this.currentTraceId);
        a16.setExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, Integer.valueOf(this.querySource));
        a16.setExtra("keyWord", keyWord);
        a16.setExtra("isFirstPageReq", Boolean.FALSE);
        final long currentTimeMillis = System.currentTimeMillis();
        SearchReqBody r16 = r(keyWord, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, miniAppConditionFilter, false, this.currentSearchId, pageNum, pageMode);
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, "startLoadMore source=" + source + " querySource=" + this.querySource + " " + com.tencent.mobileqq.search.searchdetail.content.model.h.f283924a.b(r16));
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.search(r16, new ISearchCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.repo.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISearchCallback
                public final void onResult(int i3, String str, SearchRspBody searchRspBody) {
                    SearchDetailTabContentRepo.G(IPerformanceReportTask.this, this, keyWord, pageMode, callback, source, currentTimeMillis, i3, str, searchRspBody);
                }
            });
        }
    }

    @Nullable
    public final com.tencent.mobileqq.search.searchdetail.a q(@NotNull SearchTabContent tabContent, @NotNull String keyword) {
        boolean isBlank;
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(tabContent, "tabContent");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        String str2 = tabContent.f359216id;
        Intrinsics.checkNotNullExpressionValue(str2, "tabContent.id");
        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
        if (isBlank) {
            str = System.currentTimeMillis() + "_" + this.dataSeq.getAndIncrement();
        } else {
            str = tabContent.f359216id + "_" + this.dataSeq.getAndIncrement();
        }
        String str3 = tabContent.name;
        Intrinsics.checkNotNullExpressionValue(str3, "tabContent.name");
        String valueOf = String.valueOf(tabContent.tabContentMask);
        int i3 = tabContent.layoutId;
        String str4 = tabContent.layoutContent;
        Intrinsics.checkNotNullExpressionValue(str4, "tabContent.layoutContent");
        byte[] bArr = tabContent.bytesExtension;
        Intrinsics.checkNotNullExpressionValue(bArr, "tabContent.bytesExtension");
        CommonInfo commonInfo = new CommonInfo(str, str3, valueOf, i3, str4, "", bArr, tabContent.bizId, this.currentTraceId, false, false, 1536, null);
        int i16 = tabContent.layoutId;
        if (i16 != 14) {
            if (i16 != 15) {
                if (i16 != 18) {
                    return null;
                }
                SearchTemplate searchTemplate = tabContent.templateItem;
                if (searchTemplate == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str5 = "error item " + tabContent;
                    if (str5 instanceof String) {
                        bVar.a().add(str5);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it.next(), null);
                    }
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(searchTemplate, "tabContent.templateItem");
                return s(commonInfo, searchTemplate, keyword);
            }
            if (tabContent.getRecommendGuide() == null) {
                String str6 = tabContent.layoutContent;
                Intrinsics.checkNotNullExpressionValue(str6, "tabContent.layoutContent");
                if (str6.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str7 = "error item " + tabContent;
                    if (str7 instanceof String) {
                        bVar2.a().add(str7);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it5.next(), null);
                    }
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(tabContent.layoutContent);
                    SearchRecommendGuide searchRecommendGuide = new SearchRecommendGuide();
                    searchRecommendGuide.text = jSONObject.optString("text");
                    com.tencent.mobileqq.search.searchdetail.content.model.d dVar = new com.tencent.mobileqq.search.searchdetail.content.model.d(commonInfo, searchRecommendGuide);
                    byte[] bArr2 = tabContent.bytesExtension;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "tabContent.bytesExtension");
                    dVar.s(bArr2);
                    return dVar;
                } catch (Exception unused) {
                    Logger logger3 = Logger.f235387a;
                    Logger.b bVar3 = new Logger.b();
                    String str8 = "exception item " + tabContent;
                    if (str8 instanceof String) {
                        bVar3.a().add(str8);
                    }
                    Iterator<T> it6 = bVar3.a().iterator();
                    while (it6.hasNext()) {
                        Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it6.next(), null);
                    }
                    return null;
                }
            }
            SearchRecommendGuide recommendGuide = tabContent.getRecommendGuide();
            Intrinsics.checkNotNullExpressionValue(recommendGuide, "tabContent.getRecommendGuide()");
            com.tencent.mobileqq.search.searchdetail.content.model.d dVar2 = new com.tencent.mobileqq.search.searchdetail.content.model.d(commonInfo, recommendGuide);
            byte[] bArr3 = tabContent.bytesExtension;
            Intrinsics.checkNotNullExpressionValue(bArr3, "tabContent.bytesExtension");
            dVar2.s(bArr3);
            return dVar2;
        }
        if (tabContent.getEmptyCard() == null) {
            Logger logger4 = Logger.f235387a;
            Logger.b bVar4 = new Logger.b();
            String str9 = "error item " + tabContent;
            if (str9 instanceof String) {
                bVar4.a().add(str9);
            }
            Iterator<T> it7 = bVar4.a().iterator();
            while (it7.hasNext()) {
                Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentRepo", 1, (String) it7.next(), null);
            }
            return null;
        }
        SearchRecommendGuide emptyCard = tabContent.getEmptyCard();
        Intrinsics.checkNotNullExpressionValue(emptyCard, "tabContent.getEmptyCard()");
        com.tencent.mobileqq.search.searchdetail.content.model.c cVar = new com.tencent.mobileqq.search.searchdetail.content.model.c(commonInfo, emptyCard);
        byte[] bArr4 = tabContent.bytesExtension;
        Intrinsics.checkNotNullExpressionValue(bArr4, "tabContent.bytesExtension");
        cVar.s(bArr4);
        return cVar;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getLbsInfo() {
        return this.lbsInfo;
    }
}
