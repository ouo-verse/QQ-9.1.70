package com.tencent.mobileqq.guild.home.schedule.viewmodels;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.home.schedule.models.DayGroupItem;
import com.tencent.mobileqq.guild.home.schedule.models.Empty;
import com.tencent.mobileqq.guild.home.schedule.models.ErrorItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleEmptyPlaceholderItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cr;
import com.tencent.mobileqq.qqguildsdk.data.cs;
import com.tencent.mobileqq.qqguildsdk.data.ct;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProModifyScheduleInviteReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cj;
import vh2.ck;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u009c\u00012\u00020\u0001:\u0006\u009d\u0001\u009e\u0001\u009f\u0001B\u001b\u0012\u0006\u00101\u001a\u00020(\u0012\b\b\u0002\u00102\u001a\u00020(\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0002J8\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u000bH\u0002J \u0010\u001f\u001a\u00020\u000b2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002J(\u0010!\u001a\u00020\u000b2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010 \u001a\u00020\tH\u0002J\"\u0010&\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J8\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020+H\u0002J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00190\u0002H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00103\u001a\u00020\u000f2\u0006\u00101\u001a\u00020(2\b\b\u0002\u00102\u001a\u00020(J\u0006\u00104\u001a\u00020\u000fJC\u00109\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u00105\u001a\u00020\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b9\u0010:J\u0016\u0010=\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tJ\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020(H\u0016J\u001e\u0010C\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u0007J\b\u0010D\u001a\u00020\u000fH\u0014J\u000e\u0010G\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020ER\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\"\u00102\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010I\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010R\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR$\u0010U\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bT\u0010Q\u001a\u0004\bU\u0010SR$\u0010Z\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010IR\u0016\u0010^\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010QR \u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0`0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR \u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0`0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010bR \u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010bR \u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010bR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000b0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010bR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010QR\u0016\u0010t\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010QR\u0014\u0010w\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u001e\u0010;\u001a\n x*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u001e\u0010|\u001a\n x*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010zR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR!\u0010\u0085\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00010\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R!\u0010\u008d\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0`0\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R!\u0010\u008f\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001R!\u0010\u0091\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00020\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001R\u001b\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020m0\u0092\u00018F\u00a2\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u008c\u0001R\u001e\u0010\u0099\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00010\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u008c\u0001\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", "target", "", "g2", "Ljava/util/Calendar;", "start", "", "reverse", "Lkotlin/ranges/IntRange;", DownloaderConstant.KEY_RANGE, "", "v2", "dayInMonth", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "t2", "day", "Lkotlin/Pair;", "f2", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/cs;", "Lkotlin/collections/ArrayList;", "scheduleDayItems", "type", "refresh", "d2", "c2", "date", "b2", "", "timeInMillis", "Lvh2/cj;", "cb", "q2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "I2", "M2", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "E2", "H2", "scheduleId", "status", "L2", "guildId", "channelId", "J2", "B2", "locatorType", "locateScheduleId", "Landroid/content/Context;", "ctx", "x2", "(ZJILjava/lang/Long;Landroid/content/Context;)V", "today", "highlight", NowProxyConstants.AccountInfoKey.A2, "account", "onAccountChanged", "startTime", "endTime", "firstPos", "F2", "onCleared", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "calendarMonth", "u2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "D", "i2", "()Ljava/lang/String;", Constants.MMCCID, "(Ljava/lang/String;)V", "<set-?>", "E", "Z", "isForwardEnd", "()Z", UserInfo.SEX_FEMALE, "isBackwardEnd", "G", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", SemanticAttributes.DbSystemValues.H2, "()Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", "baseDate", "H", "cookie", "I", "isTodayAdded", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "J", "Landroidx/lifecycle/MutableLiveData;", "_liveEventFinishLoadFirstPage", "K", "_liveEventRefreshEntries", "L", "_liveScheduleEntries", "M", "_liveCalenderEntries", "N", "_liveCreatePermission", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$a;", "P", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_flowCalendarEntries", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isLoadingScheduleEntries", BdhLogUtil.LogTag.Tag_Req, "isLoadingCalendarEntries", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onServiceObserver", "kotlin.jvm.PlatformType", "T", "Ljava/util/Calendar;", "U", "highlightDay", "Landroid/app/Dialog;", "V", "Landroid/app/Dialog;", "loadDialog", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "W", "Le12/a;", "_guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "p2", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.NUMBER_PARAM_2, "()Landroidx/lifecycle/LiveData;", "liveEventFinishLoadFirstPage", "o2", "liveScheduleEntries", "l2", "liveCalendarEntries", "Lkotlinx/coroutines/flow/Flow;", "j2", "()Lkotlinx/coroutines/flow/Flow;", "flowCalendarEntries", "m2", "liveCreatePermission", "k2", "guildInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "X", "a", "b", "DateLocator", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeScheduleViewModel extends ef1.b {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isForwardEnd;

    /* renamed from: F */
    private boolean isBackwardEnd;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private DateLocator baseDate;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String cookie;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isTodayAdded;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> _liveEventFinishLoadFirstPage;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Long>> _liveEventRefreshEntries;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> _liveScheduleEntries;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.a>> _liveCalenderEntries;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _liveCreatePermission;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<CalendarEntries> _flowCalendarEntries;

    /* renamed from: Q */
    private boolean isLoadingScheduleEntries;

    /* renamed from: R */
    private boolean isLoadingCalendarEntries;

    /* renamed from: S */
    @NotNull
    private final GPServiceObserver onServiceObserver;

    /* renamed from: T, reason: from kotlin metadata */
    private Calendar today;

    /* renamed from: U, reason: from kotlin metadata */
    private Calendar highlightDay;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Dialog loadDialog;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "f", "(I)V", "type", "Ljava/util/Calendar;", "b", "Ljava/util/Calendar;", "()Ljava/util/Calendar;", "d", "(Ljava/util/Calendar;)V", "date", "", "Ljava/lang/Long;", "()Ljava/lang/Long;", "e", "(Ljava/lang/Long;)V", "scheduleId", "<init>", "(ILjava/util/Calendar;Ljava/lang/Long;)V", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class DateLocator {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private int type;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @NotNull
        private Calendar date;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @Nullable
        private Long scheduleId;

        public DateLocator(int i3, @NotNull Calendar date, @Nullable Long l3) {
            Intrinsics.checkNotNullParameter(date, "date");
            this.type = i3;
            this.date = date;
            this.scheduleId = l3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Calendar getDate() {
            return this.date;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Long getScheduleId() {
            return this.scheduleId;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void d(@NotNull Calendar calendar) {
            Intrinsics.checkNotNullParameter(calendar, "<set-?>");
            this.date = calendar;
        }

        public final void e(@Nullable Long l3) {
            this.scheduleId = l3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DateLocator)) {
                return false;
            }
            DateLocator dateLocator = (DateLocator) other;
            if (this.type == dateLocator.type && Intrinsics.areEqual(this.date, dateLocator.date) && Intrinsics.areEqual(this.scheduleId, dateLocator.scheduleId)) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.type = i3;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.type * 31) + this.date.hashCode()) * 31;
            Long l3 = this.scheduleId;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "DateLocator(type=" + this.type + ", date=" + CalendarExKt.b(this.date) + ", scheduleId=" + this.scheduleId + ")";
        }

        public /* synthetic */ DateLocator(int i3, Calendar calendar, Long l3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, calendar, (i16 & 4) != 0 ? null : l3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u001c\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$b;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cs;", "items", "", "from", "", "b", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull List<? extends com.tencent.mobileqq.guild.home.schedule.models.d> items, @NotNull String from) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(from, "from");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "logItems() from: " + from);
            }
            int i3 = 0;
            for (Object obj : items) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, " > " + i3 + " : [" + dVar.getType() + "]" + dVar.getText() + " " + dVar);
                }
                i3 = i16;
            }
        }

        @JvmStatic
        public final void b(@NotNull List<? extends cs> items, @NotNull String from) {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(from, "from");
            Logger logger = Logger.f235387a;
            int i17 = 1;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "logItems() from: " + from);
            }
            int i18 = 0;
            for (Object obj : items) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                cs csVar = (cs) obj;
                py1.a a16 = py1.a.a(csVar.a());
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger2.d();
                    ArrayList<ct> b16 = csVar.b();
                    if (b16 != null) {
                        i16 = b16.size();
                    } else {
                        i16 = 0;
                    }
                    d16.d("Guild.sch.GuildHomeScheduleViewModel", i17, i18 + ": size = " + i16 + ", " + a16.f428062a + "-" + (a16.f428063b + i17) + "-" + a16.f428064c + "-" + a16.d());
                }
                ArrayList<ct> guildScheduleListItems = csVar.b();
                if (guildScheduleListItems != null) {
                    Intrinsics.checkNotNullExpressionValue(guildScheduleListItems, "guildScheduleListItems");
                    int i26 = 0;
                    for (Object obj2 : guildScheduleListItems) {
                        int i27 = i26 + 1;
                        if (i26 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        GuildScheduleInfo a17 = ((ct) obj2).a();
                        Logger logger3 = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            i3 = 1;
                            logger3.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, " > " + i26 + " : [" + a17.getDateMs() + "]" + a17.getScheduleId() + "-" + a17.getTitle() + "/" + a17.getContent());
                        } else {
                            i3 = i17;
                        }
                        i17 = i3;
                        i26 = i27;
                    }
                }
                i17 = i17;
                i18 = i19;
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J2\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\nH\u0014J\"\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0014J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admin", "", "isAdmin", "", "onAdminChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "onChannelPermissionChanged", "", "channelIdList", "onChannelUserPermissionChanged", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "", "result", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProModifyScheduleInviteReq;", "req", "onModifyScheduleInviteStatusNew", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@Nullable String guildId, @Nullable String admin, boolean isAdmin) {
            GuildHomeScheduleViewModel.this.M2();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
            super.onChannelPermissionChanged(guildId, channelIds);
            if (!TextUtils.equals(guildId, GuildHomeScheduleViewModel.this.guildId)) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "onChannelPermissionChanged");
            }
            if (channelIds != null && channelIds.contains(GuildHomeScheduleViewModel.this.getChannelId())) {
                GuildHomeScheduleViewModel.this.M2();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelUserPermissionChanged(@Nullable String guildId, @Nullable List<String> channelIdList) {
            super.onChannelUserPermissionChanged(guildId, channelIdList);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "onChannelUserPermissionChanged");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            super.onGuildInfoUpdated(guildId);
            if (Intrinsics.areEqual(guildId, GuildHomeScheduleViewModel.this.guildId)) {
                GuildHomeScheduleViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx r46) {
            super.onGuildPermissionChanged(guildId, r46);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "onGuildPermissionChanged");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onModifyScheduleInviteStatusNew(int result, @NotNull String errMsg, @NotNull GProModifyScheduleInviteReq req) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(req, "req");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "onModifyScheduleInviteStatusNew: " + result + ", " + errMsg + ", " + req);
            }
            GuildHomeScheduleViewModel.this.L2(req.scheduleId, req.inviteStatus);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$d", "Lvh2/ck;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/cr;", "Lkotlin/collections/ArrayList;", "scheduleDates", "", "onGetSchedulesStatus", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ck {

        /* renamed from: b */
        final /* synthetic */ int f225276b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((cr) t16).a()), Long.valueOf(((cr) t17).a()));
                return compareValues;
            }
        }

        d(int i3) {
            this.f225276b = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        
            r2 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r2);
         */
        @Override // vh2.ck
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onGetSchedulesStatus(int result, @NotNull String errMsg, @Nullable ArrayList<cr> scheduleDates) {
            List emptyList;
            List<cr> sortedWith;
            List mutableList;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (scheduleDates == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = scheduleDates;
            }
            if (!emptyList.isEmpty()) {
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(emptyList, new a());
                List list = (List) GuildHomeScheduleViewModel.this._liveCalenderEntries.getValue();
                if (list != null && mutableList != null) {
                    ListIterator listIterator = mutableList.listIterator(this.f225276b);
                    ListIterator listIterator2 = sortedWith.listIterator();
                    while (listIterator.hasNext() && listIterator2.hasNext()) {
                        int nextIndex = listIterator.nextIndex();
                        Object next = listIterator.next();
                        Calendar item2 = py1.a.b(((cr) listIterator2.next()).a());
                        int i3 = 0;
                        while (listIterator.hasNext() && i3 < 50) {
                            if (next instanceof a.CalendarDay) {
                                int i16 = ((com.tencent.mobileqq.guild.home.schedule.models.a) next).a().get(6);
                                Intrinsics.checkNotNullExpressionValue(item2, "item2");
                                if (i16 == item2.get(6)) {
                                    break;
                                }
                            }
                            nextIndex = listIterator.nextIndex();
                            next = listIterator.next();
                            i3++;
                        }
                        Calendar a16 = ((com.tencent.mobileqq.guild.home.schedule.models.a) next).a();
                        if (next instanceof a.CalendarDay) {
                            int i17 = a16.get(6);
                            Intrinsics.checkNotNullExpressionValue(item2, "item2");
                            if (i17 == item2.get(6)) {
                                Logger logger = Logger.f235387a;
                                GuildHomeScheduleViewModel guildHomeScheduleViewModel = GuildHomeScheduleViewModel.this;
                                Logger.a d16 = logger.d();
                                String b16 = CalendarExKt.b(a16);
                                String b17 = CalendarExKt.b(item2);
                                Calendar today = guildHomeScheduleViewModel.today;
                                Intrinsics.checkNotNullExpressionValue(today, "today");
                                d16.i("Guild.sch.GuildHomeScheduleViewModel", 1, "find index " + nextIndex + MsgSummary.STR_COLON + next + " " + b16 + " " + b17 + " " + CalendarExKt.b(today));
                                a.CalendarDay calendarDay = (a.CalendarDay) next;
                                if ((calendarDay.getState() & 3) != 3) {
                                    if (a16.getTimeInMillis() < GuildHomeScheduleViewModel.this.today.getTimeInMillis()) {
                                        mutableList.set(nextIndex, a.CalendarDay.f(calendarDay, 0L, 0, 0, 0, calendarDay.getState() | 8, 15, null));
                                    } else {
                                        mutableList.set(nextIndex, a.CalendarDay.f(calendarDay, 0L, 0, 0, 0, calendarDay.getState() | 4, 15, null));
                                    }
                                }
                            }
                        }
                        Logger logger2 = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "not find... safeCount=" + i3;
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.sch.GuildHomeScheduleViewModel", 1, (String) it.next(), null);
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
                    Calendar calendar = Calendar.getInstance();
                    Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
                    for (cr crVar : sortedWith) {
                        calendar.setTimeInMillis(crVar.a());
                        Calendar b18 = py1.a.b(crVar.a());
                        String format = simpleDateFormat.format(calendar.getTime());
                        String format2 = simpleDateFormat.format(b18.getTime());
                        Logger logger3 = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger3.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "getSchedulesStatus: resp = " + crVar + ", " + crVar.b() + " " + format + " / " + format2);
                        }
                    }
                    GuildHomeScheduleViewModel.this._liveCalenderEntries.setValue(mutableList);
                }
            }
        }
    }

    public /* synthetic */ GuildHomeScheduleViewModel(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2);
    }

    public static final void C2(GuildHomeScheduleViewModel this$0, int i3, String str, ArrayList scheduleDayItems, String str2) {
        Object obj;
        Object obj2;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> plus;
        List plus2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(scheduleDayItems, "scheduleDayItems");
        companion.b(scheduleDayItems, "loadPrevious()");
        List e26 = e2(this$0, scheduleDayItems, 2, false, 4, null);
        ListIterator listIterator = e26.listIterator(e26.size());
        while (true) {
            obj = null;
            if (listIterator.hasPrevious()) {
                obj2 = listIterator.previous();
                if (((com.tencent.mobileqq.guild.home.schedule.models.d) obj2) instanceof DayGroupItem) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) obj2;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value = this$0._liveScheduleEntries.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((com.tencent.mobileqq.guild.home.schedule.models.d) next) instanceof DayGroupItem) {
                obj = next;
                break;
            }
        }
        com.tencent.mobileqq.guild.home.schedule.models.d dVar2 = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
        if (dVar2 != null && Intrinsics.areEqual(dVar2, dVar)) {
            value = value.subList(1, value.size());
        }
        MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> mutableLiveData = this$0._liveScheduleEntries;
        List list = e26;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> list2 = value;
        plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
        mutableLiveData.setValue(plus);
        MutableSharedFlow<CalendarEntries> mutableSharedFlow = this$0._flowCalendarEntries;
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
        Boolean value2 = this$0.m2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        mutableSharedFlow.tryEmit(new CalendarEntries(plus2, value2.booleanValue(), this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, 0, false, 96, null));
        this$0.isLoadingScheduleEntries = false;
    }

    @JvmStatic
    public static final void D2(@NotNull List<? extends cs> list, @NotNull String str) {
        INSTANCE.b(list, str);
    }

    private final GPServiceObserver E2() {
        return new c();
    }

    private final List<com.tencent.mobileqq.guild.home.schedule.models.d> H2(List<? extends cs> list) {
        List<com.tencent.mobileqq.guild.home.schedule.models.d> list2;
        List listOf;
        Collection listOf2;
        List plus;
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        for (cs csVar : list) {
            py1.a date = py1.a.a(csVar.a());
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new DayGroupItem(csVar));
            List list3 = listOf;
            ArrayList<ct> guildScheduleListItems = csVar.b();
            if (guildScheduleListItems != null) {
                Intrinsics.checkNotNullExpressionValue(guildScheduleListItems, "guildScheduleListItems");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(guildScheduleListItems, 10);
                listOf2 = new ArrayList(collectionSizeOrDefault);
                for (ct ctVar : guildScheduleListItems) {
                    Intrinsics.checkNotNullExpressionValue(date, "date");
                    GuildScheduleInfo a16 = ctVar.a();
                    a16.setDateMs(csVar.a());
                    Intrinsics.checkNotNullExpressionValue(a16, "it.guildScheduleInfo.app\u2026dateMs = dayItem.dateMs }");
                    listOf2.add(new ScheduleInfoItem(date, a16));
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(date, "date");
                Boolean value = this._liveCreatePermission.getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                Intrinsics.checkNotNullExpressionValue(value, "_liveCreatePermission.value ?: false");
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new ScheduleEmptyPlaceholderItem(date, value.booleanValue()));
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) listOf2);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus);
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        return list2;
    }

    public final String I2(int type) {
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    return "Unknown";
                }
                return "TYPE_BACKWARD";
            }
            return "TYPE_FORWARD";
        }
        return "DEFAULT";
    }

    public static /* synthetic */ void K2(GuildHomeScheduleViewModel guildHomeScheduleViewModel, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        guildHomeScheduleViewModel.J2(str, str2);
    }

    public final void L2(long scheduleId, int status) {
        boolean z16;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value = this._liveScheduleEntries.getValue();
        Object obj = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) next;
                if ((dVar instanceof ScheduleInfoItem) && ((ScheduleInfoItem) dVar).getInfo().getScheduleId() == scheduleId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            obj = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
        }
        if (obj instanceof ScheduleInfoItem) {
            ((ScheduleInfoItem) obj).getInfo().updateInviteStatus(status);
        }
    }

    public final void M2() {
        int collectionSizeOrDefault;
        Logger.f235387a.d().i("Guild.sch.GuildHomeScheduleViewModel", 1, "updatePermission");
        boolean m06 = ch.m0(this.guildId);
        this._liveCreatePermission.setValue(Boolean.valueOf(m06));
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value = this._liveScheduleEntries.getValue();
        if (value != null) {
            List<com.tencent.mobileqq.guild.home.schedule.models.d> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            boolean z16 = false;
            for (Object obj : list) {
                if (obj instanceof Empty) {
                    obj = ((Empty) obj).b(m06, m06);
                    z16 = true;
                } else if (obj instanceof ScheduleEmptyPlaceholderItem) {
                    obj = ScheduleEmptyPlaceholderItem.c((ScheduleEmptyPlaceholderItem) obj, null, m06, 1, null);
                }
                arrayList.add(obj);
            }
            if (z16) {
                y2(this, true, this.baseDate.getDate().getTimeInMillis(), this.baseDate.getType(), null, null, 24, null);
            } else {
                this._liveScheduleEntries.setValue(arrayList);
            }
        }
    }

    private final ArrayList<cs> a2(ArrayList<cs> arrayList, long j3) {
        int binarySearch$default;
        final Calendar d16 = CalendarEx.f214714a.d(j3);
        if (!b2(arrayList, d16) && d16.getTimeInMillis() >= this.today.getTimeInMillis()) {
            binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default(arrayList, 0, 0, new Function1<cs, Integer>() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel$addEmptyDayGroupIfNeeded$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Integer invoke(@NotNull cs it) {
                    int sign;
                    Intrinsics.checkNotNullParameter(it, "it");
                    sign = MathKt__MathJVMKt.getSign(it.a() - d16.getTimeInMillis());
                    return Integer.valueOf(sign);
                }
            }, 3, (Object) null);
            if (binarySearch$default < 0) {
                arrayList.add((-binarySearch$default) - 1, new cs.a().d(d16.getTimeInMillis()).c());
            } else {
                s.e("Guild.sch.GuildHomeScheduleViewModel", "should not reach", new IllegalStateException());
            }
        }
        return arrayList;
    }

    private final boolean b2(ArrayList<cs> scheduleDayItems, Calendar date) {
        if ((scheduleDayItems instanceof Collection) && scheduleDayItems.isEmpty()) {
            return false;
        }
        Iterator<T> it = scheduleDayItems.iterator();
        while (it.hasNext()) {
            if (CalendarExKt.e(CalendarEx.f214714a.d(((cs) it.next()).a()), date)) {
                return true;
            }
        }
        return false;
    }

    private final boolean c2(ArrayList<cs> scheduleDayItems) {
        if ((scheduleDayItems instanceof Collection) && scheduleDayItems.isEmpty()) {
            return false;
        }
        Iterator<T> it = scheduleDayItems.iterator();
        while (it.hasNext()) {
            Calendar d16 = CalendarEx.f214714a.d(((cs) it.next()).a());
            Calendar today = this.today;
            Intrinsics.checkNotNullExpressionValue(today, "today");
            if (CalendarExKt.e(d16, today)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0160, code lost:
    
        if (((com.tencent.mobileqq.qqguildsdk.data.cs) r1).a() > r3) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x014c, code lost:
    
        if (r5 > r3) goto L180;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<com.tencent.mobileqq.guild.home.schedule.models.d> d2(ArrayList<cs> scheduleDayItems, int type, boolean refresh) {
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value;
        ScheduleInfoItem scheduleInfoItem;
        Object obj;
        ScheduleInfoItem scheduleInfoItem2;
        ScheduleInfoItem scheduleInfoItem3;
        Object first;
        long a16;
        Object last;
        long a17;
        int binarySearch$default;
        Object first2;
        Object last2;
        py1.a date;
        py1.a date2;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> emptyList;
        List<? extends cs> listOf;
        List<? extends cs> listOf2;
        List<? extends cs> listOf3;
        if (this.isTodayAdded) {
            return H2(scheduleDayItems);
        }
        if (refresh || (value = this._liveScheduleEntries.getValue()) == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        List<com.tencent.mobileqq.guild.home.schedule.models.d> list = value;
        Iterator it = list.iterator();
        while (true) {
            scheduleInfoItem = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.home.schedule.models.d) obj) instanceof ScheduleInfoItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj instanceof ScheduleInfoItem) {
            scheduleInfoItem2 = (ScheduleInfoItem) obj;
        } else {
            scheduleInfoItem2 = null;
        }
        Iterator it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                scheduleInfoItem3 = it5.next();
                if (((com.tencent.mobileqq.guild.home.schedule.models.d) scheduleInfoItem3) instanceof ScheduleInfoItem) {
                    break;
                }
            } else {
                scheduleInfoItem3 = 0;
                break;
            }
        }
        if (scheduleInfoItem3 instanceof ScheduleInfoItem) {
            scheduleInfoItem = scheduleInfoItem3;
        }
        final long timeInMillis = this.today.getTimeInMillis();
        if (scheduleDayItems.isEmpty()) {
            if (value.isEmpty() && this.isBackwardEnd && this.isForwardEnd) {
                this.isTodayAdded = true;
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(new cs.a().d(timeInMillis).c());
                return H2(listOf3);
            }
            if (type == 2 && scheduleInfoItem2 != null && scheduleInfoItem2.getDate().d() > timeInMillis) {
                this.isTodayAdded = true;
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new cs.a().d(timeInMillis).c());
                return H2(listOf2);
            }
            if (type != 1 || scheduleInfoItem == null || scheduleInfoItem.getDate().d() >= timeInMillis) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            this.isTodayAdded = true;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new cs.a().d(timeInMillis).c());
            return H2(listOf);
        }
        if (c2(scheduleDayItems)) {
            this.isTodayAdded = true;
            return H2(scheduleDayItems);
        }
        if (scheduleInfoItem2 == null || (date2 = scheduleInfoItem2.getDate()) == null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) scheduleDayItems);
            a16 = ((cs) first).a();
        } else {
            a16 = date2.d();
        }
        if (scheduleInfoItem == null || (date = scheduleInfoItem.getDate()) == null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) scheduleDayItems);
            a17 = ((cs) last).a();
        } else {
            a17 = date.d();
        }
        Calendar date3 = this.baseDate.getDate();
        Calendar today = this.today;
        Intrinsics.checkNotNullExpressionValue(today, "today");
        if (!CalendarExKt.e(date3, today)) {
            if (type == 1 || type == 0) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) scheduleDayItems);
                if (((cs) first2).a() < timeInMillis) {
                }
            }
            if (type == 2 && a16 < timeInMillis) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) scheduleDayItems);
            }
            return H2(scheduleDayItems);
        }
        this.isTodayAdded = true;
        binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default(scheduleDayItems, 0, 0, new Function1<cs, Integer>() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel$convertResponseToLocalList$index$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull cs it6) {
                int sign;
                Intrinsics.checkNotNullParameter(it6, "it");
                sign = MathKt__MathJVMKt.getSign(it6.a() - timeInMillis);
                return Integer.valueOf(sign);
            }
        }, 3, (Object) null);
        scheduleDayItems.add((-binarySearch$default) - 1, new cs.a().d(timeInMillis).c());
        return H2(scheduleDayItems);
    }

    static /* synthetic */ List e2(GuildHomeScheduleViewModel guildHomeScheduleViewModel, ArrayList arrayList, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return guildHomeScheduleViewModel.d2(arrayList, i3, z16);
    }

    private final Pair<Calendar, Calendar> f2(Calendar day) {
        Object clone = day.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        calendar.setFirstDayOfWeek(1);
        calendar.set(day.get(1), day.get(2), 1);
        Object clone2 = calendar.clone();
        Intrinsics.checkNotNull(clone2, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone2;
        calendar2.set(5, calendar2.getActualMaximum(5));
        return TuplesKt.to(calendar, calendar2);
    }

    private final int g2(List<? extends com.tencent.mobileqq.guild.home.schedule.models.d> items, DateLocator target) {
        boolean z16;
        if (target.getScheduleId() != null || target.getType() == 1) {
            return 0;
        }
        Iterator<? extends com.tencent.mobileqq.guild.home.schedule.models.d> it = items.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.guild.home.schedule.models.d next = it.next();
                if ((next instanceof DayGroupItem) && CalendarExKt.e(CalendarEx.f214714a.d(((DayGroupItem) next).getItem().a()), target.getDate())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "findPosition, not find index, " + target + " -> " + i3);
            }
            return 0;
        }
        return i3;
    }

    public final IGPSService p2() {
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        return (IGPSService) S0;
    }

    private final void q2(int type, final long timeInMillis, final cj cb5) {
        boolean z16;
        int i3;
        Object lastOrNull;
        GuildScheduleInfo info;
        long dateMs;
        long j3;
        String str;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value;
        Object firstOrNull;
        GuildScheduleInfo info2;
        if (this.cookie.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = type;
        }
        if (i3 != 1) {
            if (i3 == 2 && (value = this._liveScheduleEntries.getValue()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : value) {
                    if (obj instanceof ScheduleInfoItem) {
                        arrayList.add(obj);
                    }
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                ScheduleInfoItem scheduleInfoItem = (ScheduleInfoItem) firstOrNull;
                if (scheduleInfoItem != null && (info2 = scheduleInfoItem.getInfo()) != null) {
                    dateMs = info2.getDateMs();
                    j3 = dateMs;
                }
            }
            j3 = timeInMillis;
        } else {
            List<com.tencent.mobileqq.guild.home.schedule.models.d> value2 = this._liveScheduleEntries.getValue();
            if (value2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : value2) {
                    if (obj2 instanceof ScheduleInfoItem) {
                        arrayList2.add(obj2);
                    }
                }
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
                ScheduleInfoItem scheduleInfoItem2 = (ScheduleInfoItem) lastOrNull;
                if (scheduleInfoItem2 != null && (info = scheduleInfoItem2.getInfo()) != null) {
                    dateMs = info.getDateMs();
                    j3 = dateMs;
                }
            }
            j3 = timeInMillis;
        }
        final py1.a a16 = py1.a.a(timeInMillis);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            IGProChannelInfo channelInfo = p2().getChannelInfo(getChannelId());
            String str2 = null;
            if (channelInfo != null) {
                str = channelInfo.getGuildId();
            } else {
                str = null;
            }
            String channelId = getChannelId();
            IGProChannelInfo channelInfo2 = p2().getChannelInfo(getChannelId());
            if (channelInfo2 != null) {
                str2 = channelInfo2.getChannelName();
            }
            String I2 = I2(i3);
            int i16 = a16.f428062a;
            int i17 = a16.f428063b;
            d16.d("Guild.sch.GuildHomeScheduleViewModel", 1, "[innerLoadScheduleList] time = " + j3 + ", " + str + "|" + channelId + "(" + str2 + "), type = " + I2 + ", " + i16 + "/" + i17 + "(" + (i17 + 1) + ")/" + a16.f428064c);
        }
        final int i18 = i3;
        final long j16 = j3;
        p2().getScheduleListNew(this.guildId, this.channelId, i3, j3, this.cookie, new cj() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.c
            @Override // vh2.cj
            public final void onGetScheduleListNew(int i19, String str3, ArrayList arrayList3, String str4) {
                GuildHomeScheduleViewModel.s2(GuildHomeScheduleViewModel.this, i18, timeInMillis, cb5, j16, a16, i19, str3, arrayList3, str4);
            }
        });
    }

    static /* synthetic */ void r2(GuildHomeScheduleViewModel guildHomeScheduleViewModel, int i3, long j3, cj cjVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            j3 = new py1.a().d();
        }
        guildHomeScheduleViewModel.q2(i3, j3, cjVar);
    }

    public static final void s2(GuildHomeScheduleViewModel this$0, int i3, long j3, cj cb5, long j16, py1.a aVar, int i16, String str, ArrayList arrayList, String str2) {
        ArrayList arrayList2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (arrayList == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList;
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        this$0.cookie = str3;
        Logger.a d16 = Logger.f235387a.d();
        int size = arrayList2.size();
        String I2 = this$0.I2(i3);
        int i17 = aVar.f428062a;
        int i18 = aVar.f428063b;
        d16.i("Guild.sch.GuildHomeScheduleViewModel", 1, "[innerLoadScheduleList] ret: " + i16 + ", " + str + ", " + str2 + ", size(" + size + "), time = " + j16 + ", type = " + I2 + ", " + i17 + "/" + i18 + "(" + (i18 + 1) + ")/" + aVar.f428064c);
        if (arrayList2.isEmpty()) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this$0.isBackwardEnd = true;
                    this$0.isForwardEnd = true;
                } else {
                    this$0.isBackwardEnd = true;
                }
            } else {
                this$0.isForwardEnd = true;
            }
        }
        if (i3 == 0) {
            this$0.a2(arrayList2, j3);
        }
        cb5.onGetScheduleListNew(i16, str, arrayList2, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091 A[LOOP:0: B:16:0x0091->B:22:0x00cb, LOOP_START, PHI: r3
  0x0091: PHI (r3v3 int) = (r3v2 int), (r3v4 int) binds: [B:15:0x008f, B:22:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cb A[LOOP:0: B:16:0x0091->B:22:0x00cb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce A[EDGE_INSN: B:23:0x00ce->B:28:0x00ce BREAK  A[LOOP:0: B:16:0x0091->B:22:0x00cb], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<com.tencent.mobileqq.guild.home.schedule.models.a> t2(Calendar dayInMonth) {
        boolean z16;
        int i3;
        Calendar highlightDay;
        int i16;
        int i17;
        Object clone = dayInMonth.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        ArrayList arrayList = new ArrayList();
        Pair<Calendar, Calendar> f26 = f2(calendar);
        Calendar component1 = f26.component1();
        Calendar component2 = f26.component2();
        a.PlaceHolder.Companion companion = a.PlaceHolder.INSTANCE;
        a.PlaceHolder a16 = companion.a(component1);
        a.PlaceHolder a17 = companion.a(component2);
        int i18 = dayInMonth.get(2) + 1;
        Calendar today = this.today;
        Intrinsics.checkNotNullExpressionValue(today, "today");
        boolean z17 = false;
        if (i18 == today.get(2) + 1) {
            int i19 = dayInMonth.get(1);
            Calendar today2 = this.today;
            Intrinsics.checkNotNullExpressionValue(today2, "today");
            if (i19 == today2.get(1)) {
                z16 = true;
                i3 = dayInMonth.get(2) + 1;
                highlightDay = this.highlightDay;
                Intrinsics.checkNotNullExpressionValue(highlightDay, "highlightDay");
                if (i3 == highlightDay.get(2) + 1) {
                    int i26 = dayInMonth.get(1);
                    Calendar highlightDay2 = this.highlightDay;
                    Intrinsics.checkNotNullExpressionValue(highlightDay2, "highlightDay");
                    if (i26 == highlightDay2.get(1)) {
                        z17 = true;
                    }
                }
                arrayList.add(a.CalendarMonth.INSTANCE.a(component1));
                if (a16 != null) {
                    arrayList.add(a16);
                }
                i16 = component1.get(5);
                i17 = component2.get(5);
                if (i16 <= i17) {
                    while (true) {
                        calendar.set(5, i16);
                        a.CalendarDay a18 = a.CalendarDay.INSTANCE.a(calendar);
                        arrayList.add(a18);
                        if (z17) {
                            Calendar highlightDay3 = this.highlightDay;
                            Intrinsics.checkNotNullExpressionValue(highlightDay3, "highlightDay");
                            if (highlightDay3.get(5) == i16) {
                                a18.i(a18.getState() | 3);
                                if (i16 != i17) {
                                    break;
                                }
                                i16++;
                            }
                        }
                        if (z16) {
                            Calendar today3 = this.today;
                            Intrinsics.checkNotNullExpressionValue(today3, "today");
                            if (today3.get(5) == i16) {
                                a18.i(a18.getState() | 1);
                            }
                        }
                        if (i16 != i17) {
                        }
                    }
                }
                if (a17 != null) {
                    arrayList.add(a17);
                }
                return arrayList;
            }
        }
        z16 = false;
        i3 = dayInMonth.get(2) + 1;
        highlightDay = this.highlightDay;
        Intrinsics.checkNotNullExpressionValue(highlightDay, "highlightDay");
        if (i3 == highlightDay.get(2) + 1) {
        }
        arrayList.add(a.CalendarMonth.INSTANCE.a(component1));
        if (a16 != null) {
        }
        i16 = component1.get(5);
        i17 = component2.get(5);
        if (i16 <= i17) {
        }
        if (a17 != null) {
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void v2(Calendar start, boolean reverse, IntRange r95) {
        List<com.tencent.mobileqq.guild.home.schedule.models.a> arrayList;
        Object obj;
        if (this.isLoadingCalendarEntries) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadMoreDays " + start + ", " + reverse + ", " + r95);
        }
        List<com.tencent.mobileqq.guild.home.schedule.models.a> value = this._liveCalenderEntries.getValue();
        if (value == null || arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Calendar today = null;
        if (start != null) {
            obj = start.clone();
        } else {
            obj = null;
        }
        if (obj instanceof Calendar) {
            today = (Calendar) obj;
        }
        if (today == null) {
            today = Calendar.getInstance();
        }
        today.add(2, r95.getFirst());
        ArrayList arrayList2 = new ArrayList();
        int first = r95.getFirst();
        int last = r95.getLast();
        if (first <= last) {
            while (true) {
                Intrinsics.checkNotNullExpressionValue(today, "today");
                arrayList2.addAll(t2(today));
                today.add(2, 1);
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        if (!reverse) {
            arrayList.addAll(arrayList2);
        } else {
            arrayList.addAll(0, arrayList2);
        }
        this._liveCalenderEntries.setValue(arrayList);
        this.isLoadingCalendarEntries = false;
    }

    static /* synthetic */ void w2(GuildHomeScheduleViewModel guildHomeScheduleViewModel, Calendar calendar, boolean z16, IntRange intRange, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            calendar = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            intRange = new IntRange(-12, 12);
        }
        guildHomeScheduleViewModel.v2(calendar, z16, intRange);
    }

    public static /* synthetic */ void y2(GuildHomeScheduleViewModel guildHomeScheduleViewModel, boolean z16, long j3, int i3, Long l3, Context context, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = false;
        }
        if ((i16 & 2) != 0) {
            j3 = new py1.a().d();
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        if ((i16 & 8) != 0) {
            l3 = null;
        }
        if ((i16 & 16) != 0) {
            context = null;
        }
        guildHomeScheduleViewModel.x2(z16, j3, i3, l3, context);
    }

    public static final void z2(GuildHomeScheduleViewModel this$0, boolean z16, int i3, String str, ArrayList scheduleDayItems, String str2) {
        Object obj;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> value;
        com.tencent.mobileqq.guild.home.schedule.models.d dVar;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> plus;
        int i16;
        boolean z17;
        List listOf;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> plus2;
        List listOf2;
        List plus3;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> listOf3;
        List listOf4;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> listOf5;
        List listOf6;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> listOf7;
        List listOf8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(scheduleDayItems, "scheduleDayItems");
        boolean z18 = true;
        List<com.tencent.mobileqq.guild.home.schedule.models.d> d26 = this$0.d2(scheduleDayItems, 1, z16);
        INSTANCE.a(d26, "loadNext()");
        Iterator<T> it = d26.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.home.schedule.models.d) obj) instanceof DayGroupItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.home.schedule.models.d dVar2 = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
        if (z16) {
            value = CollectionsKt__CollectionsKt.emptyList();
        } else if (!z16) {
            value = this$0._liveScheduleEntries.getValue();
            if (value == null) {
                value = CollectionsKt__CollectionsKt.emptyList();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = value.listIterator(value.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                dVar = listIterator.previous();
                if (dVar instanceof DayGroupItem) {
                    break;
                }
            } else {
                dVar = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.home.schedule.models.d dVar3 = dVar;
        if (dVar2 != null && Intrinsics.areEqual(dVar2, dVar3)) {
            d26 = d26.subList(1, d26.size());
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) value, (Iterable) d26);
        Boolean value2 = this$0.m2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        boolean booleanValue = value2.booleanValue();
        if (i3 != 0) {
            if (plus.size() < 3) {
                List<com.tencent.mobileqq.guild.home.schedule.models.d> list = plus;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        } else if (!(!(((com.tencent.mobileqq.guild.home.schedule.models.d) it5.next()) instanceof ScheduleInfoItem))) {
                            z18 = false;
                            break;
                        }
                    }
                }
                if (z18) {
                    MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> mutableLiveData = this$0._liveScheduleEntries;
                    listOf7 = CollectionsKt__CollectionsJVMKt.listOf(new ErrorItem(i3));
                    mutableLiveData.setValue(listOf7);
                    MutableSharedFlow<CalendarEntries> mutableSharedFlow = this$0._flowCalendarEntries;
                    listOf8 = CollectionsKt__CollectionsJVMKt.listOf(new ErrorItem(i3));
                    mutableSharedFlow.tryEmit(new CalendarEntries(listOf8, booleanValue, this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, 0, z16, 32, null));
                }
            }
        } else if (plus.isEmpty()) {
            MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> mutableLiveData2 = this$0._liveScheduleEntries;
            listOf5 = CollectionsKt__CollectionsJVMKt.listOf(new Empty(booleanValue, booleanValue));
            mutableLiveData2.setValue(listOf5);
            MutableSharedFlow<CalendarEntries> mutableSharedFlow2 = this$0._flowCalendarEntries;
            listOf6 = CollectionsKt__CollectionsJVMKt.listOf(new Empty(booleanValue, booleanValue));
            mutableSharedFlow2.tryEmit(new CalendarEntries(listOf6, booleanValue, this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, 0, z16, 32, null));
        } else {
            if (plus.size() < 3) {
                List<com.tencent.mobileqq.guild.home.schedule.models.d> list2 = plus;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it6 = list2.iterator();
                    while (it6.hasNext()) {
                        if (!(!(((com.tencent.mobileqq.guild.home.schedule.models.d) it6.next()) instanceof ScheduleInfoItem))) {
                            z17 = false;
                            break;
                        }
                    }
                }
                z17 = true;
                if (z17) {
                    if (!booleanValue) {
                        MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> mutableLiveData3 = this$0._liveScheduleEntries;
                        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(new Empty(booleanValue, false, 2, null));
                        mutableLiveData3.setValue(listOf3);
                        MutableSharedFlow<CalendarEntries> mutableSharedFlow3 = this$0._flowCalendarEntries;
                        listOf4 = CollectionsKt__CollectionsJVMKt.listOf(new Empty(false, false));
                        mutableSharedFlow3.tryEmit(new CalendarEntries(listOf4, false, this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, 0, z16, 32, null));
                    } else {
                        MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> mutableLiveData4 = this$0._liveScheduleEntries;
                        List<com.tencent.mobileqq.guild.home.schedule.models.d> list3 = plus;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Empty(true, true));
                        plus2 = CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) listOf);
                        mutableLiveData4.setValue(plus2);
                        MutableSharedFlow<CalendarEntries> mutableSharedFlow4 = this$0._flowCalendarEntries;
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new Empty(true, true));
                        plus3 = CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) listOf2);
                        mutableSharedFlow4.tryEmit(new CalendarEntries(plus3, true, this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, 0, z16, 32, null));
                    }
                }
            }
            this$0._liveScheduleEntries.setValue(plus);
            if (z16) {
                i16 = this$0.g2(plus, this$0.baseDate);
            } else {
                i16 = 0;
            }
            this$0._flowCalendarEntries.tryEmit(new CalendarEntries(plus, booleanValue, this$0.isTodayAdded, this$0.isForwardEnd, this$0.isBackwardEnd, i16, z16));
        }
        if (z16) {
            this$0._liveEventFinishLoadFirstPage.setValue(new ef1.a<>(Boolean.TRUE));
        }
        this$0.isLoadingScheduleEntries = false;
        Dialog dialog = this$0.loadDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public final void A2(@NotNull Calendar today, @NotNull Calendar highlight) {
        List<com.tencent.mobileqq.guild.home.schedule.models.a> emptyList;
        Intrinsics.checkNotNullParameter(today, "today");
        Intrinsics.checkNotNullParameter(highlight, "highlight");
        MutableLiveData<List<com.tencent.mobileqq.guild.home.schedule.models.a>> mutableLiveData = this._liveCalenderEntries;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
        Object clone = today.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        this.today = (Calendar) clone;
        this.highlightDay = highlight;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadPickerDate() today: " + CalendarExKt.b(today) + " highlight: " + CalendarExKt.b(highlight));
        }
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadPickerDate() weekdays: " + CalendarEx.f214714a.f());
        }
        w2(this, highlight, false, null, 6, null);
    }

    public final void B2() {
        if (this.isLoadingScheduleEntries) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadPrevious() is loading, wait...");
                return;
            }
            return;
        }
        this.isLoadingScheduleEntries = true;
        r2(this, 2, 0L, new cj() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.b
            @Override // vh2.cj
            public final void onGetScheduleListNew(int i3, String str, ArrayList arrayList, String str2) {
                GuildHomeScheduleViewModel.C2(GuildHomeScheduleViewModel.this, i3, str, arrayList, str2);
            }
        }, 2, null);
    }

    public final void F2(long startTime, long endTime, int firstPos) {
        Logger.f235387a.d().i("Guild.sch.GuildHomeScheduleViewModel", 1, "getSchedulesStatus: " + startTime + " -- " + endTime);
        p2().getSchedulesStatus(this.guildId, this.channelId, startTime, endTime, new d(firstPos));
    }

    public final void G2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void J2(@NotNull String guildId, @NotNull String channelId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        if (channelId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.channelId = channelId;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "updateGuild: " + this.guildId + " -> " + guildId + ", channelId: " + getChannelId() + " -> " + channelId);
        }
        M2();
    }

    @NotNull
    /* renamed from: h2, reason: from getter */
    public final DateLocator getBaseDate() {
        return this.baseDate;
    }

    @NotNull
    /* renamed from: i2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final Flow<CalendarEntries> j2() {
        return this._flowCalendarEntries;
    }

    @NotNull
    public final LiveData<IGProGuildInfo> k2() {
        return this._guildInfo;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.guild.home.schedule.models.a>> l2() {
        return this._liveCalenderEntries;
    }

    @NotNull
    public final LiveData<Boolean> m2() {
        return this._liveCreatePermission;
    }

    @NotNull
    public final LiveData<ef1.a<Boolean>> n2() {
        return this._liveEventFinishLoadFirstPage;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> o2() {
        return this._liveScheduleEntries;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        p2().addObserver(this.onServiceObserver);
    }

    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        p2().deleteObserver(this.onServiceObserver);
    }

    public final void u2(@NotNull a.CalendarMonth calendarMonth) {
        com.tencent.mobileqq.guild.home.schedule.models.a aVar;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(calendarMonth, "calendarMonth");
        List<com.tencent.mobileqq.guild.home.schedule.models.a> value = this._liveCalenderEntries.getValue();
        com.tencent.mobileqq.guild.home.schedule.models.a aVar2 = null;
        if (value != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
            aVar = (com.tencent.mobileqq.guild.home.schedule.models.a) firstOrNull;
        } else {
            aVar = null;
        }
        if (Intrinsics.areEqual(calendarMonth, aVar)) {
            v2(calendarMonth.a(), true, new IntRange(-3, -1));
            return;
        }
        List<com.tencent.mobileqq.guild.home.schedule.models.a> value2 = this._liveCalenderEntries.getValue();
        if (value2 != null) {
            ListIterator<com.tencent.mobileqq.guild.home.schedule.models.a> listIterator = value2.listIterator(value2.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                com.tencent.mobileqq.guild.home.schedule.models.a previous = listIterator.previous();
                if (previous instanceof a.CalendarMonth) {
                    aVar2 = previous;
                    break;
                }
            }
            aVar2 = aVar2;
        }
        if (Intrinsics.areEqual(calendarMonth, aVar2)) {
            w2(this, calendarMonth.a(), false, new IntRange(1, 3), 2, null);
        }
    }

    public final void x2(final boolean refresh, long timeInMillis, int locatorType, @Nullable Long locateScheduleId, @Nullable Context ctx) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadNext(" + refresh + ", " + CalendarEx.f214714a.a(timeInMillis) + ")");
        }
        if (this.isLoadingScheduleEntries) {
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildHomeScheduleViewModel", 1, "loadNext() is loading, wait...");
                return;
            }
            return;
        }
        this.isLoadingScheduleEntries = true;
        if (refresh) {
            this.cookie = "";
            this.isForwardEnd = false;
            this.isBackwardEnd = false;
            this.isTodayAdded = false;
            this.baseDate.f(locatorType);
            this.baseDate.d(CalendarEx.f214714a.d(timeInMillis));
            this.baseDate.e(locateScheduleId);
            if (ctx != null) {
                Dialog showLoadingDialogTipsRight = LoadingUtil.showLoadingDialogTipsRight(ctx, false, true);
                this.loadDialog = showLoadingDialogTipsRight;
                if (showLoadingDialogTipsRight != null) {
                    showLoadingDialogTipsRight.show();
                }
            }
        }
        q2(1, timeInMillis, new cj() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.a
            @Override // vh2.cj
            public final void onGetScheduleListNew(int i3, String str, ArrayList arrayList, String str2) {
                GuildHomeScheduleViewModel.z2(GuildHomeScheduleViewModel.this, refresh, i3, str, arrayList, str2);
            }
        });
    }

    public GuildHomeScheduleViewModel(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.baseDate = new DateLocator(0, calendar, null, 4, null);
        this.cookie = "";
        this._liveEventFinishLoadFirstPage = new MutableLiveData<>();
        this._liveEventRefreshEntries = new MutableLiveData<>();
        this._liveScheduleEntries = new MutableLiveData<>();
        this._liveCalenderEntries = new MutableLiveData<>();
        this._liveCreatePermission = new MutableLiveData<>();
        this._flowCalendarEntries = SharedFlowKt.MutableSharedFlow(0, 100, BufferOverflow.DROP_OLDEST);
        GPServiceObserver E2 = E2();
        this.onServiceObserver = E2;
        this.today = Calendar.getInstance();
        this.highlightDay = Calendar.getInstance();
        e12.a<IGProGuildInfo> aVar = new e12.a<>();
        this._guildInfo = aVar;
        p2().addObserver(E2);
        K2(this, this.guildId, null, 2, null);
        aVar.setValue(ch.L(this.guildId));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000b\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "items", "b", "Z", "isAdmin", "()Z", "isTodayAdded", "d", "e", "isForwardEnd", "isBackwardEnd", "f", "I", "()I", "firstPos", "g", "fromRefresh", "<init>", "(Ljava/util/List;ZZZZIZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CalendarEntries {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @NotNull
        private final List<com.tencent.mobileqq.guild.home.schedule.models.d> items;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final boolean isAdmin;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final boolean isTodayAdded;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final boolean isForwardEnd;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final boolean isBackwardEnd;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final int firstPos;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final boolean fromRefresh;

        /* JADX WARN: Multi-variable type inference failed */
        public CalendarEntries(@NotNull List<? extends com.tencent.mobileqq.guild.home.schedule.models.d> items, boolean z16, boolean z17, boolean z18, boolean z19, int i3, boolean z26) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.isAdmin = z16;
            this.isTodayAdded = z17;
            this.isForwardEnd = z18;
            this.isBackwardEnd = z19;
            this.firstPos = i3;
            this.fromRefresh = z26;
        }

        /* renamed from: a, reason: from getter */
        public final int getFirstPos() {
            return this.firstPos;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFromRefresh() {
            return this.fromRefresh;
        }

        @NotNull
        public final List<com.tencent.mobileqq.guild.home.schedule.models.d> c() {
            return this.items;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsBackwardEnd() {
            return this.isBackwardEnd;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsForwardEnd() {
            return this.isForwardEnd;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CalendarEntries)) {
                return false;
            }
            CalendarEntries calendarEntries = (CalendarEntries) other;
            if (Intrinsics.areEqual(this.items, calendarEntries.items) && this.isAdmin == calendarEntries.isAdmin && this.isTodayAdded == calendarEntries.isTodayAdded && this.isForwardEnd == calendarEntries.isForwardEnd && this.isBackwardEnd == calendarEntries.isBackwardEnd && this.firstPos == calendarEntries.firstPos && this.fromRefresh == calendarEntries.fromRefresh) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.items.hashCode() * 31;
            boolean z16 = this.isAdmin;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isTodayAdded;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.isForwardEnd;
            int i26 = z18;
            if (z18 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z19 = this.isBackwardEnd;
            int i28 = z19;
            if (z19 != 0) {
                i28 = 1;
            }
            int i29 = (((i27 + i28) * 31) + this.firstPos) * 31;
            boolean z26 = this.fromRefresh;
            if (!z26) {
                i3 = z26 ? 1 : 0;
            }
            return i29 + i3;
        }

        @NotNull
        public String toString() {
            return "CalendarEntries(items=" + this.items + ", isAdmin=" + this.isAdmin + ", isTodayAdded=" + this.isTodayAdded + ", isForwardEnd=" + this.isForwardEnd + ", isBackwardEnd=" + this.isBackwardEnd + ", firstPos=" + this.firstPos + ", fromRefresh=" + this.fromRefresh + ")";
        }

        public /* synthetic */ CalendarEntries(List list, boolean z16, boolean z17, boolean z18, boolean z19, int i3, boolean z26, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? false : z17, (i16 & 8) != 0 ? false : z18, (i16 & 16) != 0 ? false : z19, (i16 & 32) != 0 ? 0 : i3, (i16 & 64) == 0 ? z26 : false);
        }
    }
}
