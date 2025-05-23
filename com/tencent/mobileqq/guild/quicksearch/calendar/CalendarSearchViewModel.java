package com.tencent.mobileqq.guild.quicksearch.calendar;

import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry;
import com.tencent.mobileqq.qqguildsdk.data.genc.cp;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.di;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001\"\u0018\u0000 R2\u00020\u0001:\u0002STB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\f\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010!\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002J\u000f\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b#\u0010$R\u0016\u0010\u001f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010)R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R&\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010/R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010:R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0E8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010K\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u0011\u0010M\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bL\u0010JR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020+0E8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010G\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel;", "Lef1/b;", "", "onCleared", "Ljava/util/Calendar;", "targetMonth", "Lkotlin/ranges/IntRange;", DownloaderConstant.KEY_RANGE, "p2", "", "isUpDirection", "o2", QQPermissionConstants.Permission.CALENDAR_GROUP, ICustomDataEditor.STRING_PARAM_2, "dayInMonth", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", ICustomDataEditor.NUMBER_PARAM_2, "(Ljava/util/Calendar;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Pair;", "f2", "start", "endCalendar", SemanticAttributes.DbSystemValues.H2, "(Ljava/util/Calendar;Ljava/util/Calendar;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "m2", "", "result", "errMsg", "q2", "guildId", "from", "r2", "com/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel$b", "g2", "()Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel$b;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_calendarFlow", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel$PageState;", "E", "_pageState", UserInfo.SEX_FEMALE, "Ljava/util/Calendar;", "_minStartData", "G", "_maxEndData", "", "H", "Ljava/util/Map;", "monthToDayContentMap", "I", "Z", "isRequesting", "J", "selectedDay", "K", "isFirstLoad", "", "L", "lastErrorTime", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "M", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gproObserver", "Lkotlinx/coroutines/flow/StateFlow;", "i2", "()Lkotlinx/coroutines/flow/StateFlow;", "calendarFlow", "k2", "()Ljava/util/Calendar;", "minStartData", "j2", "maxEndData", "l2", "pageState", "<init>", "(Ljava/lang/String;)V", "N", "a", "PageState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<List<com.tencent.mobileqq.guild.home.schedule.models.a>> _calendarFlow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<PageState> _pageState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Calendar _minStartData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Calendar _maxEndData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<String, List<String>> monthToDayContentMap;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Calendar selectedDay;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFirstLoad;

    /* renamed from: L, reason: from kotlin metadata */
    private long lastErrorTime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gproObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$1", f = "CalendarSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IRuntimeService S0 = ch.S0(IGPSService.class, "QQGuildInSearchTag.CalendarSearchViewModel");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                ((IGPSService) S0).addObserver(CalendarSearchViewModel.this.gproObserver);
                IGProGuildInfo L = ch.L(CalendarSearchViewModel.this.guildId);
                CalendarSearchViewModel calendarSearchViewModel = CalendarSearchViewModel.this;
                CalendarEx calendarEx = CalendarEx.f214714a;
                calendarSearchViewModel._minStartData = calendarEx.d(L.getCreateTime() * 1000);
                Logger logger = Logger.f235387a;
                CalendarSearchViewModel calendarSearchViewModel2 = CalendarSearchViewModel.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("QQGuildInSearchTag.CalendarSearchViewModel", "minStartData: " + CalendarExKt.b(calendarSearchViewModel2.get_minStartData()) + " " + L.getCreateTime());
                }
                CalendarSearchViewModel.this.p2(calendarEx.e(), new IntRange(-3, -1));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel$PageState;", "", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "FAILED", com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PageState {
        LOADING,
        SUCCESS,
        FAILED,
        FINISH
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            CalendarSearchViewModel.this.r2(guildId, "kick");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            CalendarSearchViewModel.this.r2(guildId, "delete");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            CalendarSearchViewModel.this.r2(guildId, "destroy");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            CalendarSearchViewModel.this.r2(guildId, "update");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            CalendarSearchViewModel.this.r2(guildId, "remove");
        }
    }

    public CalendarSearchViewModel(@NotNull String guildId) {
        List emptyList;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._calendarFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._pageState = StateFlowKt.MutableStateFlow(PageState.LOADING);
        CalendarEx calendarEx = CalendarEx.f214714a;
        this._minStartData = calendarEx.c(MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, 1, 1);
        this._maxEndData = calendarEx.e();
        this.monthToDayContentMap = new LinkedHashMap();
        this.selectedDay = calendarEx.e();
        this.isFirstLoad = true;
        this.gproObserver = g2();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final Pair<Calendar, Calendar> f2(Calendar dayInMonth) {
        if (dayInMonth.get(1) < get_minStartData().get(1) || dayInMonth.get(1) > get_maxEndData().get(1)) {
            return null;
        }
        if (dayInMonth.get(1) == get_minStartData().get(1) && dayInMonth.get(2) + 1 < get_minStartData().get(2) + 1) {
            return null;
        }
        if (dayInMonth.get(1) == get_maxEndData().get(1) && dayInMonth.get(2) + 1 > get_maxEndData().get(2) + 1) {
            return null;
        }
        Object clone = dayInMonth.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        calendar.set(5, 1);
        Object clone2 = dayInMonth.clone();
        Intrinsics.checkNotNull(clone2, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone2;
        calendar2.set(5, calendar2.getActualMaximum(5));
        if (calendar.before(get_minStartData())) {
            calendar = get_minStartData();
        }
        if (calendar2.after(get_maxEndData())) {
            calendar2 = get_maxEndData();
        }
        calendar.setFirstDayOfWeek(1);
        calendar2.setFirstDayOfWeek(1);
        Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "createDaysRange: " + CalendarExKt.b(calendar) + " " + CalendarExKt.b(calendar2));
        return TuplesKt.to(calendar, calendar2);
    }

    private final b g2() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0083 A[LOOP:0: B:12:0x0083->B:23:0x00de, LOOP_START, PHI: r11
  0x0083: PHI (r11v5 int) = (r11v2 int), (r11v6 int) binds: [B:11:0x0081, B:23:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h2(Calendar calendar, Calendar calendar2, Continuation<? super List<? extends com.tencent.mobileqq.guild.home.schedule.models.a>> continuation) {
        CalendarSearchViewModel$createMonthRangeCalendars$1 calendarSearchViewModel$createMonthRangeCalendars$1;
        Object coroutine_suspended;
        int i3;
        ArrayList arrayList;
        Calendar calendar3;
        Object m26;
        CalendarSearchViewModel calendarSearchViewModel;
        int i16;
        int i17;
        if (continuation instanceof CalendarSearchViewModel$createMonthRangeCalendars$1) {
            calendarSearchViewModel$createMonthRangeCalendars$1 = (CalendarSearchViewModel$createMonthRangeCalendars$1) continuation;
            int i18 = calendarSearchViewModel$createMonthRangeCalendars$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                calendarSearchViewModel$createMonthRangeCalendars$1.label = i18 - Integer.MIN_VALUE;
                Object obj = calendarSearchViewModel$createMonthRangeCalendars$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = calendarSearchViewModel$createMonthRangeCalendars$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        Calendar calendar4 = (Calendar) calendarSearchViewModel$createMonthRangeCalendars$1.L$4;
                        ?? r122 = (List) calendarSearchViewModel$createMonthRangeCalendars$1.L$3;
                        Calendar calendar5 = (Calendar) calendarSearchViewModel$createMonthRangeCalendars$1.L$2;
                        Calendar calendar6 = (Calendar) calendarSearchViewModel$createMonthRangeCalendars$1.L$1;
                        CalendarSearchViewModel calendarSearchViewModel2 = (CalendarSearchViewModel) calendarSearchViewModel$createMonthRangeCalendars$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        calendar3 = calendar4;
                        calendar = calendar6;
                        arrayList = r122;
                        calendar2 = calendar5;
                        calendarSearchViewModel = calendarSearchViewModel2;
                        m26 = obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    arrayList = new ArrayList();
                    Object clone = calendar.clone();
                    Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
                    calendar3 = (Calendar) clone;
                    calendarSearchViewModel$createMonthRangeCalendars$1.L$0 = this;
                    calendarSearchViewModel$createMonthRangeCalendars$1.L$1 = calendar;
                    calendarSearchViewModel$createMonthRangeCalendars$1.L$2 = calendar2;
                    calendarSearchViewModel$createMonthRangeCalendars$1.L$3 = arrayList;
                    calendarSearchViewModel$createMonthRangeCalendars$1.L$4 = calendar3;
                    calendarSearchViewModel$createMonthRangeCalendars$1.label = 1;
                    m26 = m2(calendar3, calendarSearchViewModel$createMonthRangeCalendars$1);
                    if (m26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    calendarSearchViewModel = this;
                }
                List list = (List) m26;
                i16 = calendar.get(5);
                i17 = calendar2.get(5);
                if (i16 <= i17) {
                    while (true) {
                        calendar3.set(5, i16);
                        a.CalendarDay a16 = a.CalendarDay.INSTANCE.a(calendar3);
                        if (CalendarExKt.e(a16.a(), CalendarEx.f214714a.e())) {
                            a16.i(a16.getState() | 1);
                        }
                        if (CalendarExKt.e(a16.a(), calendarSearchViewModel.selectedDay)) {
                            a16.i(a16.getState() | 2);
                        }
                        if (list.contains(CalendarExKt.c(calendar3))) {
                            a16.i(a16.getState() | 4);
                        } else {
                            a16.i(a16.getState() | 8);
                        }
                        arrayList.add(a16);
                        calendar3.add(5, 1);
                        if (i16 == i17) {
                            break;
                        }
                        i16++;
                    }
                }
                Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "createMonthRangeCalendars: " + arrayList.size());
                return arrayList;
            }
        }
        calendarSearchViewModel$createMonthRangeCalendars$1 = new CalendarSearchViewModel$createMonthRangeCalendars$1(this, continuation);
        Object obj2 = calendarSearchViewModel$createMonthRangeCalendars$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = calendarSearchViewModel$createMonthRangeCalendars$1.label;
        if (i3 == 0) {
        }
        List list2 = (List) m26;
        i16 = calendar.get(5);
        i17 = calendar2.get(5);
        if (i16 <= i17) {
        }
        Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "createMonthRangeCalendars: " + arrayList.size());
        return arrayList;
    }

    private final Object m2(Calendar calendar, Continuation<? super List<String>> continuation) {
        Continuation intercepted;
        ArrayList<String> arrayListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final String g16 = CalendarExKt.g(calendar);
        if (this.monthToDayContentMap.containsKey(g16)) {
            Result.Companion companion = Result.INSTANCE;
            List<String> list = this.monthToDayContentMap.get(g16);
            Intrinsics.checkNotNull(list);
            safeContinuation.resumeWith(Result.m476constructorimpl(list));
        } else {
            final cp cpVar = new cp();
            cpVar.c(MiscKt.l(this.guildId));
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(g16);
            cpVar.d(arrayListOf);
            if (this.isFirstLoad) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CalendarSearchViewModel$getTargetMonthData$2$1(this, null), 3, null);
            }
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).getGuildFeedsValidCalendar(cpVar, new di() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$getTargetMonthData$2$2

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$getTargetMonthData$2$2$2", f = "CalendarSearchViewModel.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$getTargetMonthData$2$2$2, reason: invalid class name */
                /* loaded from: classes14.dex */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $errMsg;
                    final /* synthetic */ int $result;
                    int label;
                    final /* synthetic */ CalendarSearchViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(CalendarSearchViewModel calendarSearchViewModel, int i3, String str, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.this$0 = calendarSearchViewModel;
                        this.$result = i3;
                        this.$errMsg = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$result, this.$errMsg, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        MutableStateFlow mutableStateFlow;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.q2(this.$result, this.$errMsg);
                            mutableStateFlow = this.this$0._pageState;
                            CalendarSearchViewModel.PageState pageState = CalendarSearchViewModel.PageState.FAILED;
                            this.label = 1;
                            if (mutableStateFlow.emit(pageState, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // wh2.di
                public final void a(int i3, String str, @NotNull IGProGuildSearchGetFeedCalendarRsp rsp) {
                    int collectionSizeOrDefault;
                    Map map;
                    boolean z16;
                    List emptyList;
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    if (i3 == 0) {
                        CalendarSearchViewModel.this.isFirstLoad = false;
                        ArrayList<IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry> feedCalendarList = rsp.getFeedCalendarList();
                        Intrinsics.checkNotNullExpressionValue(feedCalendarList, "rsp.feedCalendarList");
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(feedCalendarList, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = feedCalendarList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry) it.next()).getDate());
                        }
                        map = CalendarSearchViewModel.this.monthToDayContentMap;
                        map.put(g16, arrayList);
                        safeContinuation.resumeWith(Result.m476constructorimpl(arrayList));
                        Logger logger = Logger.f235387a;
                        cp cpVar2 = cpVar;
                        if (QLog.isDevelopLevel()) {
                            Log.d("QQGuildInSearchTag.CalendarSearchViewModel", "getGuildFeedsValidCalendar success " + cpVar2 + ", data: " + arrayList.size());
                            return;
                        }
                        return;
                    }
                    Logger logger2 = Logger.f235387a;
                    cp cpVar3 = cpVar;
                    Logger.b bVar = new Logger.b();
                    String str2 = "getGuildFeedsValidCalendar fail, " + cpVar3 + " result: " + i3 + ", errMsg: " + str;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it5 = bVar.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("QQGuildInSearchTag.CalendarSearchViewModel", 1, (String) it5.next(), null);
                    }
                    z16 = CalendarSearchViewModel.this.isFirstLoad;
                    if (z16) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(CalendarSearchViewModel.this), null, null, new AnonymousClass2(CalendarSearchViewModel.this, i3, str, null), 3, null);
                    }
                    Continuation<List<String>> continuation2 = safeContinuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    continuation2.resumeWith(Result.m476constructorimpl(emptyList));
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n2(Calendar calendar, Continuation<? super List<? extends com.tencent.mobileqq.guild.home.schedule.models.a>> continuation) {
        CalendarSearchViewModel$loadMonthCalendarData$1 calendarSearchViewModel$loadMonthCalendarData$1;
        Object coroutine_suspended;
        int i3;
        Calendar calendar2;
        List list;
        List list2;
        List emptyList;
        a.PlaceHolder b16;
        if (continuation instanceof CalendarSearchViewModel$loadMonthCalendarData$1) {
            calendarSearchViewModel$loadMonthCalendarData$1 = (CalendarSearchViewModel$loadMonthCalendarData$1) continuation;
            int i16 = calendarSearchViewModel$loadMonthCalendarData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                calendarSearchViewModel$loadMonthCalendarData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = calendarSearchViewModel$loadMonthCalendarData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = calendarSearchViewModel$loadMonthCalendarData$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list = (List) calendarSearchViewModel$loadMonthCalendarData$1.L$2;
                        list2 = (List) calendarSearchViewModel$loadMonthCalendarData$1.L$1;
                        calendar2 = (Calendar) calendarSearchViewModel$loadMonthCalendarData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Pair<Calendar, Calendar> f26 = f2(calendar);
                    if (f26 == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                    Calendar component1 = f26.component1();
                    Calendar component2 = f26.component2();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a.CalendarMonth.INSTANCE.a(component1));
                    a.PlaceHolder b17 = a.PlaceHolder.INSTANCE.b(component1, true);
                    if (b17 != null) {
                        Boxing.boxBoolean(arrayList.add(b17));
                    }
                    calendarSearchViewModel$loadMonthCalendarData$1.L$0 = component2;
                    calendarSearchViewModel$loadMonthCalendarData$1.L$1 = arrayList;
                    calendarSearchViewModel$loadMonthCalendarData$1.L$2 = arrayList;
                    calendarSearchViewModel$loadMonthCalendarData$1.label = 1;
                    obj = h2(component1, component2, calendarSearchViewModel$loadMonthCalendarData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    calendar2 = component2;
                    list = arrayList;
                    list2 = list;
                }
                list.addAll((Collection) obj);
                b16 = a.PlaceHolder.INSTANCE.b(calendar2, false);
                if (b16 != null) {
                    Boxing.boxBoolean(list2.add(b16));
                }
                Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadMonthCalendarData: " + list2.size());
                return list2;
            }
        }
        calendarSearchViewModel$loadMonthCalendarData$1 = new CalendarSearchViewModel$loadMonthCalendarData$1(this, continuation);
        Object obj2 = calendarSearchViewModel$loadMonthCalendarData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = calendarSearchViewModel$loadMonthCalendarData$1.label;
        if (i3 == 0) {
        }
        list.addAll((Collection) obj2);
        b16 = a.PlaceHolder.INSTANCE.b(calendar2, false);
        if (b16 != null) {
        }
        Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadMonthCalendarData: " + list2.size());
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(int result, String errMsg) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastErrorTime < 250) {
            return;
        }
        SecurityTipHelperKt.F(ch.i(), result, errMsg, null, null, null, 56, null);
        this.lastErrorTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(String guildId, String from) {
        if (Intrinsics.areEqual(this.guildId, guildId) && ch.L(guildId) == null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CalendarSearchViewModel$updateGuildInfoFrom$1(this, from, null), 3, null);
        }
    }

    @NotNull
    public final StateFlow<List<com.tencent.mobileqq.guild.home.schedule.models.a>> i2() {
        return this._calendarFlow;
    }

    @NotNull
    /* renamed from: j2, reason: from getter */
    public final Calendar get_maxEndData() {
        return this._maxEndData;
    }

    @NotNull
    /* renamed from: k2, reason: from getter */
    public final Calendar get_minStartData() {
        return this._minStartData;
    }

    @NotNull
    public final StateFlow<PageState> l2() {
        return this._pageState;
    }

    public final void o2(boolean isUpDirection) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CalendarSearchViewModel$loadMoreCalendarData$1(this, isUpDirection, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        IRuntimeService S0 = ch.S0(IGPSService.class, "QQGuildInSearchTag.CalendarSearchViewModel");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).deleteObserver(this.gproObserver);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQGuildInSearchTag.CalendarSearchViewModel", "onCleared");
        }
    }

    public final void p2(@NotNull Calendar targetMonth, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(targetMonth, "targetMonth");
        Intrinsics.checkNotNullParameter(range, "range");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CalendarSearchViewModel$loadTargetMonth$1(targetMonth, range, this, null), 3, null);
    }

    public final void s2(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CalendarSearchViewModel$updateSelectedDay$1(this, calendar, null), 3, null);
    }
}
