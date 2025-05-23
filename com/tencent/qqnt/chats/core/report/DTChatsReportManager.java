package com.tencent.qqnt.chats.core.report;

import android.util.ArrayMap;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.i;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GuildAbstractType;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionScene;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 X2\u00020\u0001:\u0002WRB2\u0012\u0007\u0010\u0084\u0001\u001a\u00020l\u0012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0085\u0001\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\b\b\u0002\u0010E\u001a\u00020\n\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J2\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002JN\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J<\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J(\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020$H\u0002J8\u0010(\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\n2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0002J\"\u0010+\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\bH\u0002J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\"\u0010/\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010*\u001a\u00020\bH\u0002J\u0018\u00100\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0018\u00103\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u00102\u001a\u000201H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J\u0018\u00105\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\nH\u0002J\u0018\u00106\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0018\u00107\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0018\u00108\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0018\u00109\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J \u0010<\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0;2\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J(\u0010=\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0;2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J*\u0010@\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020 2\b\b\u0002\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0002JA\u0010F\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010\u00022\b\u0010E\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\rH\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010K\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\nH\u0016J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0016J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0016J\u001e\u0010Q\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0NH\u0016J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0016J\u0018\u0010T\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\nH\u0016J\b\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\nH\u0016J\u0010\u0010X\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\nH\u0016J\b\u0010Y\u001a\u00020\u0005H\u0016J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nH\u0016J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020\u0005H\u0016J\b\u0010`\u001a\u00020\u0005H\u0016J\u0018\u0010c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010b\u001a\u00020aH\u0016J \u0010f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u0002H\u0016J(\u0010i\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0016J(\u0010j\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0016R\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020l0k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010mR\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010=R\"\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010pR\"\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010pR\u0016\u0010t\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010sR\u0016\u0010u\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010sR\u0016\u0010x\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010wR \u0010{\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010zR\u0016\u0010~\u001a\u00020|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bT\u0010\u0082\u0001\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager;", "Lcom/tencent/qqnt/chats/api/b;", "", "section", "Lkotlin/Function0;", "", "task", "A0", "", "id", "", "index", "doExpoAction", "", "extra", "C0", "Lkotlin/Function2;", "", "tryAntiExpo", "E0", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "newMap", "oldMap", "B0", "a0", "ev", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "clearSingle", "m0", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "x0", "Lcom/tencent/qqnt/chats/core/report/data/a;", "bizMap", "b0", "event", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/a;", "h0", "bizIndex", "otherParam", "o0", "type", "expoTime", "s0", "w0", "Lcom/tencent/qqnt/chats/core/report/data/c;", "markData", "v0", "u0", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$UnreadClearOption;", "clearOption", "p0", "y0", "z0", "i0", "g0", "l0", "k0", "j0", "", "f0", "Z", "objExtra", "onlyForKernel", "q0", "e0", "d0", "page", "refPageId", "pageStp", "r", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "u", ReportConstant.COSTREPORT_PREFIX, "clickId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "", "Lcom/tencent/qqnt/chats/api/b$c;", "marks", DomainData.DOMAIN_NAME, "b", "clickPos", "l", "c", "count", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "p", h.F, "d", "Lcom/tencent/qqnt/chats/api/b$d;", "v", "onClear", "g", "Lcom/tencent/qqnt/chats/biz/bean/c;", "revealItem", "o", "uin", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "k", "objectType", QCircleLpReportDc010001.KEY_SUBTYPE, "t", "f", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "Ljava/lang/ref/WeakReference;", "listOpProvider", "curPageExpo", "Ljava/util/Map;", "itemExpoMap", "itemExpoTimeMap", "I", "firstItemPos", "lastItemPos", "Lcom/tencent/qqnt/chats/core/report/data/b;", "Lcom/tencent/qqnt/chats/core/report/data/b;", "pageBizExtra", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "itemBizMap", "Lcom/tencent/qqnt/chats/core/report/b;", "Lcom/tencent/qqnt/chats/core/report/b;", "pageParamsBuilder", "J", "pageInTime", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "itemBindRunnable", "opProvider", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;", "chatsPageType", "<init>", "(Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;Ljava/lang/String;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DTChatsReportManager implements com.tencent.qqnt.chats.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<b> listOpProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean curPageExpo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b> itemExpoMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, Long> itemExpoTimeMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int firstItemPos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int lastItemPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.report.data.b pageBizExtra;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayMap<Long, com.tencent.qqnt.chats.core.report.data.a> itemBizMap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.report.b pageParamsBuilder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long pageInTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable itemBindRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$a;", "", "", "RUN_DELAY", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.report.DTChatsReportManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH&J\u001c\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "last", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "Lkotlin/Pair;", "c", "Lkotlin/Function1;", "", "op", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a(@NotNull Function1<? super Integer, Unit> op5);

        @Nullable
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> b(int first, int last);

        @Nullable
        Pair<Integer, Integer> c();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354857a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41134);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LiteBusinessType.values().length];
            try {
                iArr[LiteBusinessType.KLIGHTRINGREVEAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiteBusinessType.KREVEAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f354857a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DTChatsReportManager(@NotNull b opProvider, @NotNull DTChatsConst.PageType chatsPageType, @NotNull String refPageId, int i3) {
        Intrinsics.checkNotNullParameter(opProvider, "opProvider");
        Intrinsics.checkNotNullParameter(chatsPageType, "chatsPageType");
        Intrinsics.checkNotNullParameter(refPageId, "refPageId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, opProvider, chatsPageType, refPageId, Integer.valueOf(i3));
            return;
        }
        this.listOpProvider = new WeakReference<>(opProvider);
        this.itemExpoMap = new LinkedHashMap();
        this.itemExpoTimeMap = new LinkedHashMap();
        this.firstItemPos = -1;
        this.lastItemPos = -1;
        this.pageBizExtra = new com.tencent.qqnt.chats.core.report.data.b();
        this.itemBizMap = new ArrayMap<>();
        this.pageParamsBuilder = new com.tencent.qqnt.chats.core.report.b();
        this.pageInTime = -1L;
        this.itemBindRunnable = new Runnable() { // from class: com.tencent.qqnt.chats.core.report.c
            @Override // java.lang.Runnable
            public final void run() {
                DTChatsReportManager.c0(DTChatsReportManager.this);
            }
        };
        this.pageParamsBuilder.g(DTChatsConst.m.f354839a.a()).i(refPageId).h(i3).f(chatsPageType);
        b bVar = this.listOpProvider.get();
        if (bVar != null) {
            bVar.a(new Function1<Integer, Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager.1
                static IPatchRedirector $redirector_;

                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16) {
                    b bVar2;
                    Pair<Integer, Integer> c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                        return;
                    }
                    if (i16 != 0 || (bVar2 = (b) DTChatsReportManager.this.listOpProvider.get()) == null || (c16 = bVar2.c()) == null) {
                        return;
                    }
                    DTChatsReportManager.this.firstItemPos = c16.getFirst().intValue();
                    DTChatsReportManager.this.lastItemPos = c16.getSecond().intValue();
                    DTChatsReportManager dTChatsReportManager = DTChatsReportManager.this;
                    dTChatsReportManager.A0("onScrollIdle", new Function0<Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager.1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                DTChatsReportManager.this.a0();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(final String section, final Function0<Unit> task) {
        DTReportThreadHelper.f354858a.a(this, new Function0<Unit>(section, task) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$runTraceAndPost$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $section;
            final /* synthetic */ Function0<Unit> $task;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$section = section;
                this.$task = task;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) section, (Object) task);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.qqnt.chats.utils.h.f355549a.e("DTChatsReport-" + this.$section, true, this.$task);
            }
        });
    }

    private final Map<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b> B0(Map<Long, ? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> newMap, Map<Long, ? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> oldMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, ? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> entry : newMap.entrySet()) {
            if (!oldMap.containsKey(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final void C0(long id5, int index, Function0<Unit> doExpoAction, Object extra) {
        com.tencent.qqnt.chats.core.report.data.a aVar = this.itemBizMap.get(Long.valueOf(id5));
        if (aVar == null) {
            aVar = new com.tencent.qqnt.chats.core.report.data.a();
            this.itemBizMap.put(Long.valueOf(id5), aVar);
        }
        aVar.f(index);
        aVar.h(index, extra);
        if (this.curPageExpo && this.itemExpoMap.containsKey(Long.valueOf(id5)) && !aVar.d(index)) {
            doExpoAction.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void D0(DTChatsReportManager dTChatsReportManager, long j3, int i3, Function0 function0, Object obj, int i16, Object obj2) {
        if ((i16 & 8) != 0) {
            obj = null;
        }
        dTChatsReportManager.C0(j3, i3, function0, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(long id5, int index, Function2<? super Long, Object, Boolean> tryAntiExpo, Function0<Unit> doExpoAction, Object extra) {
        boolean z16;
        com.tencent.qqnt.chats.core.report.data.a aVar = this.itemBizMap.get(Long.valueOf(id5));
        if (aVar == null) {
            aVar = new com.tencent.qqnt.chats.core.report.data.a();
            this.itemBizMap.put(Long.valueOf(id5), aVar);
        }
        if (aVar.d(index)) {
            z16 = tryAntiExpo.invoke(Long.valueOf(aVar.a(index)), aVar.b(index)).booleanValue();
        } else {
            z16 = true;
        }
        if (z16) {
            aVar.f(index);
            aVar.h(index, extra);
            if (this.curPageExpo && this.itemExpoMap.containsKey(Long.valueOf(id5)) && !aVar.d(index)) {
                doExpoAction.invoke();
            }
        }
    }

    private final void Z(Map<String, Object> map, String str, com.tencent.qqnt.chats.core.adapter.itemdata.b bVar) {
        Long l3;
        if (Intrinsics.areEqual(str, "qq_imp_end") && (l3 = this.itemExpoTimeMap.get(Long.valueOf(bVar.id()))) != null) {
            map.put("qq_element_lvtm", Long.valueOf(System.currentTimeMillis() - l3.longValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        b bVar;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> b16;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b> mutableMap;
        if (this.curPageExpo && (bVar = this.listOpProvider.get()) != null && (b16 = bVar.b(this.firstItemPos, this.lastItemPos)) != null) {
            com.tencent.qqnt.chats.core.utils.a.f355091a.c(b16, this.pageParamsBuilder.d());
            Map<Long, ? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> map = this.itemExpoMap;
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> list = b16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((com.tencent.qqnt.chats.core.adapter.itemdata.b) obj).id()), obj);
            }
            mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
            Map<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b> B0 = B0(mutableMap, map);
            Map<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b> B02 = B0(map, mutableMap);
            if (!B0.isEmpty() || !B02.isEmpty()) {
                this.itemExpoMap = mutableMap;
                Iterator<Map.Entry<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b>> it = B02.entrySet().iterator();
                while (it.hasNext()) {
                    n0(this, "qq_imp_end", it.next().getValue(), false, 4, null);
                }
                Iterator<Map.Entry<Long, com.tencent.qqnt.chats.core.adapter.itemdata.b>> it5 = B0.entrySet().iterator();
                while (it5.hasNext()) {
                    n0(this, "qq_imp", it5.next().getValue(), false, 4, null);
                }
            }
        }
    }

    private final void b0(com.tencent.qqnt.chats.core.report.data.a bizMap, String ev5, g item, long id5) {
        if (bizMap.c(1)) {
            u0(ev5, item);
        }
        if (bizMap.c(0)) {
            w0(ev5, item);
        }
        if (bizMap.c(3)) {
            r0(this, ev5, item, bizMap, false, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final DTChatsReportManager this$0) {
        Pair<Integer, Integer> c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listOpProvider.get();
        if (bVar != null && (c16 = bVar.c()) != null) {
            this$0.firstItemPos = c16.getFirst().intValue();
            this$0.lastItemPos = c16.getSecond().intValue();
            this$0.A0("itemBindRunnable", new Function0<Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$itemBindRunnable$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        DTChatsReportManager.this.a0();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(g item) {
        boolean z16;
        String k3 = item.k();
        if (k3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("DTChatsReport", 2, "DTChatsReportManager liteActionButtonClickForKernel return\uff0cpeerUid is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DTChatsReport", 2, "DTChatsReportManager liteActionButtonClickForKernel success\uff1a[peerUid: " + k3 + "]");
        }
        IKernelLiteBusinessService liteBusinessService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
        if (liteBusinessService != null) {
            liteBusinessService.clickLiteAction(k3, LiteActionScene.KMSGLIST.ordinal());
        }
    }

    private final void e0(g item) {
        boolean z16;
        String k3 = item.k();
        if (k3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("DTChatsReport", 2, "DTChatsReportManager liteActionButtonExposeForKernel return\uff0cpeerUid is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DTChatsReport", 2, "DTChatsReportManager liteActionButtonExposeForKernel success\uff1a[peerUid: " + k3 + "]");
        }
        IKernelLiteBusinessService liteBusinessService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
        if (liteBusinessService != null) {
            liteBusinessService.exposeLiteAction(k3, LiteActionScene.KMSGLIST.ordinal());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Map<String, Object> map, g gVar) {
        Long l3;
        if (gVar.n() != 2) {
            l3 = "";
        } else {
            l3 = Long.valueOf(gVar.l());
        }
        map.put("group_id", l3);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, Long.valueOf(gVar.l()));
        a aVar = a.f354861a;
        map.put("message_session_type", Integer.valueOf(aVar.a(gVar.n(), gVar.I()).ordinal()));
        map.put("is_mark", Integer.valueOf(aVar.f(gVar.x()).ordinal()));
        map.put("channel_id", ex3.a.f(gVar.s()));
        map.put("sub_channel_id", ex3.a.b(gVar.s()));
        map.put("other_session_id", "");
        map.put("session_subtype", "");
        map.put("is_dynamic_mark", Integer.valueOf(aVar.h(gVar)));
        map.put("is_set_top", Integer.valueOf(aVar.e(gVar.H())));
        if (gVar.n() == 2 || gVar.n() == 7) {
            map.put("red_word_type", gVar.v().e());
        }
        if (gVar.n() == 2) {
            map.put("flame_type", Boolean.valueOf(((ITroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITroopApi.class)).hasTroopFlame(String.valueOf(gVar.l()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String event, g item) {
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        a16.put("qq_eid", DTChatsConst.a.f354827a.a());
        String str = item.s().peerName;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerName");
        a16.put("nickname", str);
        a16.put("abstract_number", Long.valueOf(item.x().b()));
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(String event, com.tencent.qqnt.chats.core.adapter.itemdata.a item) {
        if (!(item.f().getTag(DTChatsConst.f354825a.a()) instanceof String)) {
            return;
        }
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        a16.put("qq_eid", DTChatsConst.o.f354841a.a());
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(String event, g item) {
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        f0(a16, item);
        ((IOnlineStatusChatsHelper) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IOnlineStatusChatsHelper.class)).addDTReportParams(event, item, a16);
        a16.put("qq_eid", DTChatsConst.c.f354829b.a());
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String event, g item) {
        Integer intOrNull;
        String str;
        int i3;
        String str2 = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "item.originData.peerUid");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        if (intOrNull != null && intOrNull.intValue() == 101) {
            str = "em_sgrp_account_change_notice";
        } else if (intOrNull != null && intOrNull.intValue() == 102) {
            str = "em_sgrp_private_msg_notice";
        } else if (intOrNull != null && intOrNull.intValue() == 103) {
            str = "em_sgrp_system_notice";
        } else {
            str = "em_sgrp_interaction_notice_entry";
        }
        a16.put("qq_eid", str);
        if (item.x().b() > 0) {
            int c16 = item.x().c();
            i3 = 2;
            if (c16 != 1) {
                if (c16 != 2) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
            }
        } else {
            i3 = 0;
        }
        a16.put("sgrp_red_tips_type", Integer.valueOf(i3));
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String event, g item) {
        int i3;
        GuildAbstractType guildAbstractType;
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        a16.put("qq_eid", DTChatsConst.f.f354832a.a());
        a16.put("sgrp_channel_id", ex3.a.f(item.s()));
        String feedId = item.s().guildContactInfo.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "item.originData.guildContactInfo.getFeedId()");
        a16.put("sgrp_feed_id", feedId);
        int i16 = 0;
        if (item.x().b() > 0) {
            int c16 = item.x().c();
            i3 = 2;
            if (c16 != 1) {
                if (c16 != 2) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
            }
        } else {
            i3 = 0;
        }
        a16.put("sgrp_red_tips_type", Integer.valueOf(i3));
        GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        if (guildContactInfo != null && (guildAbstractType = guildContactInfo.grayAbstractType) != null) {
            i16 = guildAbstractType.reportType;
        }
        a16.put("sgrp_state", Integer.valueOf(i16));
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(String event, g item) {
        int i3;
        int i16;
        GuildAbstractType guildAbstractType;
        GuildAbstractType guildAbstractType2;
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        Z(a16, event, item);
        a16.put("qq_eid", DTChatsConst.g.f354833a.a());
        a16.put("sgrp_channel_id", ex3.a.f(item.s()));
        a16.put("sgrp_user_type", Integer.valueOf(com.tencent.qqnt.chats.biz.guild.e.c(item.v())));
        String feedId = item.s().guildContactInfo.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "item.originData.guildContactInfo.getFeedId()");
        a16.put("sgrp_feed_id", feedId);
        int i17 = 0;
        if (item.x().b() > 0) {
            int c16 = item.x().c();
            i3 = 2;
            if (c16 != 1) {
                if (c16 != 2) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
            }
        } else {
            i3 = 0;
        }
        a16.put("sgrp_red_tips_type", Integer.valueOf(i3));
        a16.put("sgrp_red_msg_type", a.f354861a.g(item));
        GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        if (guildContactInfo != null && (guildAbstractType2 = guildContactInfo.grayAbstractType) != null) {
            i16 = guildAbstractType2.reportType;
        } else {
            i16 = 0;
        }
        a16.put("sgrp_state", Integer.valueOf(i16));
        GuildContactInfo guildContactInfo2 = item.s().guildContactInfo;
        if (guildContactInfo2 != null && (guildAbstractType = guildContactInfo2.redAbstractType) != null) {
            i17 = guildAbstractType.reportType;
        }
        a16.put("sgrp_red_msg_state", Integer.valueOf(i17));
        VideoReport.reportEvent(event, a16);
    }

    private final void m0(String ev5, com.tencent.qqnt.chats.core.adapter.itemdata.b item, boolean clearSingle) {
        com.tencent.qqnt.chats.core.report.data.a aVar;
        long id5 = item.id();
        if (Intrinsics.areEqual(ev5, "qq_imp_end") && !this.itemExpoTimeMap.containsKey(Long.valueOf(id5))) {
            return;
        }
        if (item instanceof g) {
            g gVar = (g) item;
            if (gVar.n() == 131) {
                g0(ev5, gVar);
            } else if (gVar.n() == 16) {
                l0(ev5, gVar);
            } else if (gVar.n() == 60) {
                k0(ev5, gVar);
            } else if (gVar.n() == 62) {
                j0(ev5, gVar);
            } else if (gVar.n() == 104) {
                ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).reportChatItemImplEvent(ev5, gVar, clearSingle);
            }
            x0(ev5, gVar);
            if (Intrinsics.areEqual(ev5, "qq_imp_end") && clearSingle) {
                aVar = this.itemBizMap.remove(Long.valueOf(id5));
            } else {
                aVar = this.itemBizMap.get(Long.valueOf(id5));
            }
            com.tencent.qqnt.chats.core.report.data.a aVar2 = aVar;
            if (aVar2 != null) {
                b0(aVar2, ev5, gVar, id5);
            }
        } else if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.a) {
            h0(ev5, (com.tencent.qqnt.chats.core.adapter.itemdata.a) item);
        } else if (!(item instanceof i)) {
            boolean z16 = item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.c;
        }
        if (Intrinsics.areEqual(ev5, "qq_imp")) {
            this.itemExpoMap.put(Long.valueOf(id5), item);
            this.itemExpoTimeMap.put(Long.valueOf(id5), Long.valueOf(System.currentTimeMillis()));
        }
        if (Intrinsics.areEqual(ev5, "qq_imp_end") && clearSingle) {
            this.itemExpoMap.remove(Long.valueOf(id5));
            this.itemExpoTimeMap.remove(Long.valueOf(id5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n0(DTChatsReportManager dTChatsReportManager, String str, com.tencent.qqnt.chats.core.adapter.itemdata.b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        dTChatsReportManager.m0(str, bVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String event, g item, int bizIndex, Map<String, ? extends Object> otherParam) {
        com.tencent.qqnt.chats.core.report.data.a aVar = this.itemBizMap.get(Long.valueOf(item.id()));
        if (aVar == null) {
            return;
        }
        if (Intrinsics.areEqual(event, "qq_imp")) {
            aVar.g(bizIndex);
        }
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        if (Intrinsics.areEqual(event, "qq_imp_end")) {
            a16.put("qq_element_lvtm", Long.valueOf(aVar.a(bizIndex)));
            aVar.e(bizIndex);
        }
        if (otherParam != null) {
            a16.putAll(otherParam);
        }
        VideoReport.reportEvent(event, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(g item, DTChatsConst.UnreadClearOption clearOption) {
        if (item.x().b() < 0) {
            return;
        }
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        f0(a16, item);
        a16.put("qq_eid", DTChatsConst.e.f354831b.a());
        a16.put("elimination_mode", Integer.valueOf(clearOption.ordinal()));
        a16.put("is_ste_top", Integer.valueOf(a.f354861a.e(item.H())));
        VideoReport.reportEvent("qq_clck", a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String ev5, g item, com.tencent.qqnt.chats.core.report.data.a objExtra, boolean onlyForKernel) {
        Object[] objArr;
        Integer num;
        int i3;
        Integer num2;
        int i16;
        int hashCode = ev5.hashCode();
        if (hashCode != -952580819) {
            if (hashCode != 534585680) {
                if (hashCode == 1173692105 && ev5.equals("qq_imp_end")) {
                    return;
                }
            } else if (ev5.equals("qq_clck")) {
                d0(item);
            }
        } else if (ev5.equals("qq_imp")) {
            e0(item);
        }
        if (onlyForKernel) {
            return;
        }
        Object b16 = objExtra.b(3);
        Integer num3 = null;
        if (b16 instanceof Object[]) {
            objArr = (Object[]) b16;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            return;
        }
        int i17 = 0;
        boolean z16 = item.q().getBoolean("is_lite_action_first_imp", false);
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        a16.put("qq_eid", DTChatsConst.i.f354835a.a());
        Object obj = objArr[0];
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        a16.put("object_type", Integer.valueOf(i3));
        Object obj2 = objArr[1];
        if (obj2 instanceof Integer) {
            num2 = (Integer) obj2;
        } else {
            num2 = null;
        }
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = 0;
        }
        a16.put("light_interaction_type", Integer.valueOf(i16));
        Object obj3 = objArr[2];
        if (obj3 instanceof Integer) {
            num3 = (Integer) obj3;
        }
        if (num3 != null) {
            i17 = num3.intValue();
        }
        a16.put("sub_light_interaction_type", Integer.valueOf(i17));
        a16.put("touin", Long.valueOf(item.l()));
        a16.put("qq_ele_is_first_imp", Integer.valueOf(z16 ? 1 : 0));
        VideoReport.reportEvent(ev5, a16);
        item.q().remove("is_lite_action_first_imp");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r0(DTChatsReportManager dTChatsReportManager, String str, g gVar, com.tencent.qqnt.chats.core.report.data.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        dTChatsReportManager.q0(str, gVar, aVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(String ev5, int type, long expoTime) {
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        a16.put("qq_eid", DTChatsConst.l.f354838a.a());
        if (Intrinsics.areEqual(ev5, "qq_imp_end")) {
            a16.put("qq_element_lvtm", Long.valueOf(System.currentTimeMillis() - expoTime));
        }
        a16.put("smallear_business_type", Integer.valueOf(type));
        VideoReport.reportEvent(ev5, a16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t0(DTChatsReportManager dTChatsReportManager, String str, int i3, long j3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            j3 = 0;
        }
        dTChatsReportManager.s0(str, i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(String event, g item) {
        com.tencent.qqnt.chats.core.report.data.a aVar = this.itemBizMap.get(Long.valueOf(item.id()));
        if (aVar == null) {
            return;
        }
        if (Intrinsics.areEqual(event, "qq_imp")) {
            aVar.g(1);
        }
        for (com.tencent.qqnt.chats.core.adapter.menu.a aVar2 : item.a()) {
            Map<String, Object> a16 = this.pageParamsBuilder.a();
            if (Intrinsics.areEqual(event, "qq_imp_end")) {
                a16.put("qq_element_lvtm", Long.valueOf(aVar.a(1)));
            }
            f0(a16, item);
            a16.put("qq_eid", DTChatsConst.d.f354830b.a());
            a16.put("menu_action_item", Integer.valueOf(a.f354861a.d(aVar2.c())));
            VideoReport.reportEvent(event, a16);
        }
        if (Intrinsics.areEqual(event, "qq_imp_end")) {
            aVar.e(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(String event, com.tencent.qqnt.chats.core.report.data.c markData, long expoTime) {
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        a16.put("qq_eid", DTChatsConst.h.f354834a.a());
        a16.put("interact_type", markData.c());
        a16.put("interact_sub_level", markData.b());
        a16.put("interact_level", markData.a());
        if (Intrinsics.areEqual(event, "qq_imp_end")) {
            a16.put("qq_element_lvtm", Long.valueOf(expoTime));
        }
        VideoReport.reportEvent(event, a16);
    }

    private final void w0(String ev5, g item) {
        com.tencent.qqnt.chats.core.report.data.c cVar;
        com.tencent.qqnt.chats.core.report.data.a aVar = this.itemBizMap.get(Long.valueOf(item.id()));
        if (aVar == null) {
            return;
        }
        Object b16 = aVar.b(0);
        if (b16 instanceof com.tencent.qqnt.chats.core.report.data.c) {
            cVar = (com.tencent.qqnt.chats.core.report.data.c) b16;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            return;
        }
        v0(ev5, cVar, aVar.a(0));
    }

    private final void x0(String ev5, final g item) {
        boolean z16;
        if (Intrinsics.areEqual(ev5, "qq_imp_end")) {
            return;
        }
        Map<LiteBusinessType, Object> i3 = item.i();
        if (i3 != null && !i3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Iterator<T> it = i3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int i16 = c.f354857a[((LiteBusinessType) entry.getKey()).ordinal()];
            final com.tencent.qqnt.chats.biz.bean.b bVar = null;
            final com.tencent.qqnt.chats.biz.bean.c cVar = null;
            if (i16 != 1) {
                if (i16 == 2 && !((IOnlineStatusChatsHelper) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IOnlineStatusChatsHelper.class)).canOnlineStatusRevealShow(item)) {
                    Object value = entry.getValue();
                    if (value instanceof com.tencent.qqnt.chats.biz.bean.b) {
                        bVar = (com.tencent.qqnt.chats.biz.bean.b) value;
                    }
                    if (bVar == null) {
                        return;
                    } else {
                        A0("onRevealShow", new Function0<Unit>(bVar) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$reportRevealEvent$1$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ com.tencent.qqnt.chats.biz.bean.b $revealItem;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$revealItem = bVar;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) bVar);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                boolean z17;
                                b bVar2;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                z17 = DTChatsReportManager.this.curPageExpo;
                                if (z17) {
                                    QLog.d("LiteReveal.DTChatsReportManager", 1, "reportRevealEvent revealItem:" + this.$revealItem);
                                    bVar2 = DTChatsReportManager.this.pageParamsBuilder;
                                    Map<String, Object> a16 = bVar2.a();
                                    com.tencent.qqnt.chats.biz.bean.b bVar3 = this.$revealItem;
                                    a16.put("qq_eid", DTChatsConst.j.f354836a.a());
                                    a16.put("business_type", Long.valueOf(bVar3.a()));
                                    a16.put("qq_ele_is_first_imp", bVar3.b() ? "1" : "0");
                                    VideoReport.reportEvent("qq_imp", a16);
                                }
                            }
                        });
                    }
                }
            } else {
                Object value2 = entry.getValue();
                if (value2 instanceof com.tencent.qqnt.chats.biz.bean.c) {
                    cVar = (com.tencent.qqnt.chats.biz.bean.c) value2;
                }
                if (cVar == null) {
                    return;
                } else {
                    A0("onQCircleRingRevealShow", new Function0<Unit>(cVar, item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$reportRevealEvent$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ g $item;
                        final /* synthetic */ com.tencent.qqnt.chats.biz.bean.c $revealItem;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$revealItem = cVar;
                            this.$item = item;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, DTChatsReportManager.this, cVar, item);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            boolean z17;
                            b bVar2;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            z17 = DTChatsReportManager.this.curPageExpo;
                            if (z17) {
                                QLog.d("LiteReveal.DTChatsReportManager", 4, "reportRevealEvent revealItem:" + this.$revealItem);
                                bVar2 = DTChatsReportManager.this.pageParamsBuilder;
                                Map<String, Object> a16 = bVar2.a();
                                g gVar = this.$item;
                                com.tencent.qqnt.chats.biz.bean.c cVar2 = this.$revealItem;
                                a16.put("qq_eid", DTChatsConst.k.f354837a.a());
                                a16.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, Long.valueOf(gVar.l()));
                                a16.put("buss_id", cVar2.d());
                                VideoReport.reportEvent("qq_imp", a16);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        a16.put("qq_eid", DTChatsConst.n.f354840a.a());
        VideoReport.reportEvent("qq_clck", a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(String ev5, int type) {
        if (type < 0) {
            return;
        }
        Map<String, Object> a16 = this.pageParamsBuilder.a();
        a16.put("qq_eid", DTChatsConst.p.f354842a.a());
        if (Intrinsics.areEqual(ev5, "qq_imp_end")) {
            a16.put("qq_element_lvtm", Long.valueOf(System.currentTimeMillis() - this.pageInTime));
        }
        VideoReport.reportEvent(ev5, a16);
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void a(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, count);
        } else {
            this.pageBizExtra.j(count);
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void b(@NotNull final g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onItemUnreadRemoved", new Function0<Unit>(item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onItemUnreadRemoved$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ g $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) item);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DTChatsReportManager.this.p0(this.$item, DTChatsConst.UnreadClearOption.DRAG);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            A0("onFixItemClick", new Function0<Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onFixItemClick$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DTChatsReportManager.this.y0();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void d(final int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, type);
        } else {
            A0("onLittleEarClick", new Function0<Unit>(type) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onLittleEarClick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $type;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$type = type;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, type);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DTChatsReportManager.this.s0("qq_clck", this.$type, 0L);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (this.curPageExpo && this.pageBizExtra.e() >= 0) {
            A0("onTabUnreadLocate", new Function0<Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onTabUnreadLocate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    bVar = DTChatsReportManager.this.pageParamsBuilder;
                    Map<String, Object> a16 = bVar.a();
                    a16.put("qq_eid", DTChatsConst.r.f354844a.a());
                    VideoReport.reportEvent("qq_clck", a16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void f(@NotNull final g item, final int objectType, final int type, final int subType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, item, Integer.valueOf(objectType), Integer.valueOf(type), Integer.valueOf(subType));
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onLIAButtonShow", new Function0<Unit>(item, objectType, type, subType) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onLIAButtonShow$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ g $item;
                final /* synthetic */ int $objectType;
                final /* synthetic */ int $subType;
                final /* synthetic */ int $type;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$objectType = objectType;
                    this.$type = type;
                    this.$subType = subType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DTChatsReportManager.this, item, Integer.valueOf(objectType), Integer.valueOf(type), Integer.valueOf(subType));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayMap arrayMap;
                    ArrayMap arrayMap2;
                    boolean z16;
                    boolean z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    arrayMap = DTChatsReportManager.this.itemBizMap;
                    com.tencent.qqnt.chats.core.report.data.a aVar = (com.tencent.qqnt.chats.core.report.data.a) arrayMap.get(Long.valueOf(this.$item.m()));
                    if (aVar != null) {
                        if (aVar.c(3)) {
                            Object b16 = aVar.b(3);
                            Object[] objArr = b16 instanceof Object[] ? (Object[]) b16 : null;
                            if (objArr != null && Intrinsics.areEqual(objArr[0], Integer.valueOf(this.$objectType)) && Intrinsics.areEqual(objArr[1], Integer.valueOf(this.$type))) {
                                z17 = DTChatsReportManager.this.curPageExpo;
                                if (z17) {
                                    DTChatsReportManager.this.q0("qq_imp", this.$item, aVar, true);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        aVar = new com.tencent.qqnt.chats.core.report.data.a();
                        arrayMap2 = DTChatsReportManager.this.itemBizMap;
                        arrayMap2.put(Long.valueOf(this.$item.m()), aVar);
                    }
                    com.tencent.qqnt.chats.core.report.data.a aVar2 = aVar;
                    aVar2.f(3);
                    aVar2.h(3, new Integer[]{Integer.valueOf(this.$objectType), Integer.valueOf(this.$type), Integer.valueOf(this.$subType)});
                    z16 = DTChatsReportManager.this.curPageExpo;
                    if (z16) {
                        DTChatsReportManager.r0(DTChatsReportManager.this, "qq_imp", this.$item, aVar2, false, 8, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DTChatsReport", 2, "[onItemBind] curPageExpo=" + this.curPageExpo);
        }
        if (!this.curPageExpo) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.itemBindRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.itemBindRunnable, 100L);
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void h(final int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, type);
        } else {
            if (type < 0) {
                return;
            }
            A0("onLittleEarHide", new Function0<Unit>(type) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onLittleEarHide$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $type;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$type = type;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, type);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.qqnt.chats.core.report.data.b bVar;
                    com.tencent.qqnt.chats.core.report.data.b bVar2;
                    com.tencent.qqnt.chats.core.report.data.b bVar3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DTChatsReportManager dTChatsReportManager = DTChatsReportManager.this;
                    int i3 = this.$type;
                    bVar = dTChatsReportManager.pageBizExtra;
                    dTChatsReportManager.s0("qq_imp_end", i3, bVar.c());
                    bVar2 = DTChatsReportManager.this.pageBizExtra;
                    bVar2.h(0L);
                    bVar3 = DTChatsReportManager.this.pageBizExtra;
                    bVar3.i(-1);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void i(@NotNull final g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onMenuOpen", new Function0<Unit>(item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onMenuOpen$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ g $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) item);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DTChatsReportManager.D0(DTChatsReportManager.this, this.$item.id(), 1, new Function0<Unit>(this.$item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onMenuOpen$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ g $item;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$item = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) r5);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    DTChatsReportManager.this.u0("qq_imp", this.$item);
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, null, 8, null);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void j(@NotNull final g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onMenuClose", new Function0<Unit>(item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onMenuClose$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ g $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) item);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DTChatsReportManager.this.u0("qq_imp_end", this.$item);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void k(@NotNull g item, @NotNull final String uin, @NotNull final String businessID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, item, uin, businessID);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        A0("onQCircleRingRevealClick", new Function0<Unit>(businessID, this, uin) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onQCircleRingRevealClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $businessID;
            final /* synthetic */ String $uin;
            final /* synthetic */ DTChatsReportManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$businessID = businessID;
                this.this$0 = this;
                this.$uin = uin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, businessID, this, uin);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("LiteReveal.DTChatsReportManager", 1, "reportQCircleRingRevealClick businessID=" + this.$businessID);
                bVar = this.this$0.pageParamsBuilder;
                Map<String, Object> a16 = bVar.a();
                String str = this.$uin;
                String str2 = this.$businessID;
                a16.put("qq_eid", DTChatsConst.k.f354837a.a());
                a16.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, str);
                a16.put("buss_id", str2);
                VideoReport.reportEvent("qq_clck", a16);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void l(@NotNull String type, final int clickPos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) type, clickPos);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            A0("onBannerItemClick", new Function0<Unit>(clickPos) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onBannerItemClick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $clickPos;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$clickPos = clickPos;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, clickPos);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    bVar = DTChatsReportManager.this.pageParamsBuilder;
                    Map<String, Object> a16 = bVar.a();
                    int i3 = this.$clickPos;
                    a16.put("qq_eid", DTChatsConst.o.f354841a.a());
                    a16.put("click_pos", Integer.valueOf(i3));
                    VideoReport.reportEvent("qq_clck", a16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void m(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, count);
        } else {
            if (count <= 0) {
                return;
            }
            A0("onTabUnreadRemoved", new Function0<Unit>() { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onTabUnreadRemoved$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    bVar = DTChatsReportManager.this.pageParamsBuilder;
                    Map<String, Object> a16 = bVar.a();
                    a16.put("qq_eid", DTChatsConst.q.f354843a.a());
                    VideoReport.reportEvent("qq_clck", a16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void n(@NotNull final g item, @NotNull final List<b.c> marks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) item, (Object) marks);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(marks, "marks");
        A0("onItemMarkBind", new Function0<Unit>(marks, this, item) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onItemMarkBind$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ g $item;
            final /* synthetic */ List<b.c> $marks;
            final /* synthetic */ DTChatsReportManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$marks = marks;
                this.this$0 = this;
                this.$item = item;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, marks, this, item);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.qqnt.chats.core.report.data.c c16 = a.f354861a.c(this.$marks);
                    this.this$0.E0(this.$item.id(), 0, new Function2<Long, Object, Boolean>(this.this$0) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onItemMarkBind$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ DTChatsReportManager this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.this$0 = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.chats.core.report.data.c.this, (Object) r5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Boolean invoke(Long l3, Object obj) {
                            return invoke(l3.longValue(), obj);
                        }

                        @NotNull
                        public final Boolean invoke(long j3, @Nullable Object obj) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return (Boolean) iPatchRedirector3.redirect((short) 2, this, Long.valueOf(j3), obj);
                            }
                            com.tencent.qqnt.chats.core.report.data.c cVar = obj instanceof com.tencent.qqnt.chats.core.report.data.c ? (com.tencent.qqnt.chats.core.report.data.c) obj : null;
                            if (cVar != null && !Intrinsics.areEqual(cVar, com.tencent.qqnt.chats.core.report.data.c.this)) {
                                this.this$0.v0("qq_imp_end", cVar, j3);
                            }
                            return Boolean.valueOf(Intrinsics.areEqual(cVar, com.tencent.qqnt.chats.core.report.data.c.this) && com.tencent.qqnt.chats.core.report.data.c.this != null);
                        }
                    }, new Function0<Unit>(c16) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onItemMarkBind$1.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.qqnt.chats.core.report.data.c $new;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$new = c16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, (Object) c16);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            DTChatsReportManager dTChatsReportManager = DTChatsReportManager.this;
                            com.tencent.qqnt.chats.core.report.data.c cVar = this.$new;
                            Intrinsics.checkNotNull(cVar);
                            dTChatsReportManager.v0("qq_imp", cVar, 0L);
                        }
                    }, c16);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void o(@NotNull final g item, @NotNull final com.tencent.qqnt.chats.biz.bean.c revealItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) item, (Object) revealItem);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(revealItem, "revealItem");
        if (!this.curPageExpo) {
            return;
        }
        A0("onQCircleRingRevealShow", new Function0<Unit>(item, revealItem) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onQCircleRingRevealShow$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ g $item;
            final /* synthetic */ com.tencent.qqnt.chats.biz.bean.c $revealItem;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$item = item;
                this.$revealItem = revealItem;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DTChatsReportManager.this, item, revealItem);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayMap arrayMap;
                ArrayMap arrayMap2;
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                arrayMap = DTChatsReportManager.this.itemBizMap;
                com.tencent.qqnt.chats.core.report.data.a aVar = (com.tencent.qqnt.chats.core.report.data.a) arrayMap.get(Long.valueOf(this.$item.m()));
                if (aVar != null) {
                    if (aVar.c(5)) {
                        Object b16 = aVar.b(5);
                        Object[] objArr = b16 instanceof Object[] ? (Object[]) b16 : null;
                        if (objArr != null && Intrinsics.areEqual(objArr[0], Long.valueOf(this.$item.l())) && Intrinsics.areEqual(objArr[1], this.$revealItem.d()) && Intrinsics.areEqual(objArr[2], Boolean.TRUE) && !this.$revealItem.c()) {
                            objArr[2] = Boolean.FALSE;
                            aVar.h(5, objArr);
                            return;
                        }
                    }
                } else {
                    aVar = new com.tencent.qqnt.chats.core.report.data.a();
                    arrayMap2 = DTChatsReportManager.this.itemBizMap;
                    arrayMap2.put(Long.valueOf(this.$item.m()), aVar);
                }
                aVar.f(5);
                aVar.h(5, new Object[]{Long.valueOf(this.$item.l()), this.$revealItem.d(), Boolean.valueOf(this.$revealItem.c())});
                QLog.d("LiteReveal.DTChatsReportManager", 1, "reportQCircleRingRevealAction businessID=" + this.$revealItem.d());
                bVar = DTChatsReportManager.this.pageParamsBuilder;
                Map<String, Object> a16 = bVar.a();
                g gVar = this.$item;
                com.tencent.qqnt.chats.biz.bean.c cVar = this.$revealItem;
                a16.put("qq_eid", DTChatsConst.k.f354837a.a());
                a16.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, Long.valueOf(gVar.l()));
                a16.put("buss_id", cVar.d());
                VideoReport.reportEvent("qq_imp", a16);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void onClear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.listOpProvider.clear();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.itemBindRunnable);
        DTReportThreadHelper.f354858a.d(this);
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void p(final int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, type);
        } else if (this.curPageExpo && type != this.pageBizExtra.d()) {
            A0("onLittleEarShow", new Function0<Unit>(type) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onLittleEarShow$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $type;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$type = type;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTChatsReportManager.this, type);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.qqnt.chats.core.report.data.b bVar;
                    com.tencent.qqnt.chats.core.report.data.b bVar2;
                    com.tencent.qqnt.chats.core.report.data.b bVar3;
                    com.tencent.qqnt.chats.core.report.data.b bVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    bVar = DTChatsReportManager.this.pageBizExtra;
                    int d16 = bVar.d();
                    bVar2 = DTChatsReportManager.this.pageBizExtra;
                    long c16 = bVar2.c();
                    bVar3 = DTChatsReportManager.this.pageBizExtra;
                    bVar3.i(this.$type);
                    bVar4 = DTChatsReportManager.this.pageBizExtra;
                    bVar4.h(System.currentTimeMillis());
                    if (d16 != -1 && c16 > 0) {
                        DTChatsReportManager.this.s0("qq_imp_end", d16, c16);
                    }
                    DTChatsReportManager.t0(DTChatsReportManager.this, "qq_imp", this.$type, 0L, 4, null);
                }
            });
        } else {
            this.pageBizExtra.i(type);
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void q(@NotNull final g item, final int clickId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) item, clickId);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onMenuClick", new Function0<Unit>(item, clickId) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onMenuClick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $clickId;
                final /* synthetic */ g $item;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$clickId = clickId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DTChatsReportManager.this, item, Integer.valueOf(clickId));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DTChatsReportManager dTChatsReportManager = DTChatsReportManager.this;
                    g gVar = this.$item;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    DTChatsReportManager dTChatsReportManager2 = DTChatsReportManager.this;
                    g gVar2 = this.$item;
                    int i3 = this.$clickId;
                    dTChatsReportManager2.f0(linkedHashMap, gVar2);
                    linkedHashMap.put("qq_eid", DTChatsConst.d.f354830b.a());
                    linkedHashMap.put("menu_action_item", Integer.valueOf(a.f354861a.d(i3)));
                    Unit unit = Unit.INSTANCE;
                    dTChatsReportManager.o0("qq_clck", gVar, 1, linkedHashMap);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void r(@NotNull Object page, @Nullable String refPageId, @Nullable Integer pageStp, @Nullable Map<String, ? extends Object> extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, page, refPageId, pageStp, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(page, "page");
        if (QLog.isColorLevel()) {
            QLog.d("DTChatsReport", 2, "[onPgIn] curPageExpo=" + this.curPageExpo);
        }
        if (this.curPageExpo) {
            return;
        }
        this.pageInTime = System.currentTimeMillis();
        this.curPageExpo = true;
        this.pageParamsBuilder.e();
        A0("DTChatsReport-onPgIn", new DTChatsReportManager$onPgIn$1(refPageId, pageStp, this, page));
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void s(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.curPageExpo) {
            return;
        }
        A0("onItemClick", new Function0<Unit>(this) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onItemClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DTChatsReportManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.chats.core.adapter.itemdata.b.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = com.tencent.qqnt.chats.core.adapter.itemdata.b.this;
                if (bVar instanceof g) {
                    if (((g) bVar).n() == 131) {
                        this.this$0.g0("qq_clck", (g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this);
                        return;
                    }
                    if (((g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this).n() == 16) {
                        this.this$0.l0("qq_clck", (g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this);
                        return;
                    }
                    if (((g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this).n() == 60) {
                        this.this$0.k0("qq_clck", (g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this);
                        return;
                    } else if (((g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this).n() == 62) {
                        this.this$0.j0("qq_clck", (g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this);
                        return;
                    } else {
                        this.this$0.i0("qq_clck", (g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this);
                        return;
                    }
                }
                if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.a) {
                    this.this$0.h0("qq_clck", (com.tencent.qqnt.chats.core.adapter.itemdata.a) bVar);
                } else {
                    if (bVar instanceof i) {
                        return;
                    }
                    boolean z16 = bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.c;
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void t(@NotNull final g item, final int objectType, final int type, final int subType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, item, Integer.valueOf(objectType), Integer.valueOf(type), Integer.valueOf(subType));
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            A0("onLIAButtonClick", new Function0<Unit>(this, objectType, type, subType) { // from class: com.tencent.qqnt.chats.core.report.DTChatsReportManager$onLIAButtonClick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $objectType;
                final /* synthetic */ int $subType;
                final /* synthetic */ int $type;
                final /* synthetic */ DTChatsReportManager this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    this.$objectType = objectType;
                    this.$type = type;
                    this.$subType = subType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, g.this, this, Integer.valueOf(objectType), Integer.valueOf(type), Integer.valueOf(subType));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b bVar;
                    ArrayMap arrayMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z16 = g.this.q().getBoolean("is_lite_action_first_click", false);
                    bVar = this.this$0.pageParamsBuilder;
                    Map<String, Object> a16 = bVar.a();
                    int i3 = this.$objectType;
                    int i16 = this.$type;
                    int i17 = this.$subType;
                    g gVar = g.this;
                    a16.put("qq_eid", DTChatsConst.i.f354835a.a());
                    a16.put("object_type", Integer.valueOf(i3));
                    a16.put("light_interaction_type", Integer.valueOf(i16));
                    a16.put("sub_light_interaction_type", Integer.valueOf(i17));
                    a16.put("touin", Long.valueOf(gVar.l()));
                    a16.put("qq_ele_is_first_imp", Integer.valueOf(z16 ? 1 : 0));
                    VideoReport.reportEvent("qq_clck", a16);
                    this.this$0.d0(g.this);
                    g.this.q().remove("is_lite_action_first_click");
                    arrayMap = this.this$0.itemBizMap;
                    com.tencent.qqnt.chats.core.report.data.a aVar = (com.tencent.qqnt.chats.core.report.data.a) arrayMap.get(Long.valueOf(g.this.m()));
                    if (aVar != null) {
                        aVar.e(3);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.b
    public void u(@NotNull Object page) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, page);
            return;
        }
        Intrinsics.checkNotNullParameter(page, "page");
        if (QLog.isColorLevel()) {
            QLog.d("DTChatsReport", 2, "[onPgOut] curPageExpo=" + this.curPageExpo);
        }
        if (!this.curPageExpo) {
            return;
        }
        this.curPageExpo = false;
        A0("onPgOut", new DTChatsReportManager$onPgOut$1(this, page));
    }

    @Override // com.tencent.qqnt.chats.api.b
    @NotNull
    public b.d v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (b.d) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return new b.d(this.pageParamsBuilder.b(), this.pageParamsBuilder.c());
    }

    public /* synthetic */ DTChatsReportManager(b bVar, DTChatsConst.PageType pageType, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i16 & 2) != 0 ? DTChatsConst.PageType.OTHER : pageType, (i16 & 4) != 0 ? PageUtils.VR_PAGE_NONE : str, (i16 & 8) != 0 ? 1 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bVar, pageType, str, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
