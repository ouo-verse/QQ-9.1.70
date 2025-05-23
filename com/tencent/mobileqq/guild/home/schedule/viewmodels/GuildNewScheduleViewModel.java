package com.tencent.mobileqq.guild.home.schedule.viewmodels;

import android.content.Context;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.schedule.create.m;
import com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView;
import com.tencent.mobileqq.guild.schedule.create.timepicker.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCheckFeedAbstractInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ae;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qqguildsdk.data.genc.dp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eb;
import com.tencent.mobileqq.qqguildsdk.data.genc.ec;
import com.tencent.mobileqq.qqguildsdk.data.genc.u;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.be;
import wh2.br;
import wh2.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0001UB\u000f\u0012\u0006\u0010 \u001a\u00020\u000e\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J>\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0002R\u0014\u0010 \u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0!8\u0006\u00a2\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0006\u00a2\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0006\u00a2\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0006\u00a2\u0006\f\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0006\u00a2\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b8\u0010%R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110!8\u0006\u00a2\u0006\f\n\u0004\b:\u0010#\u001a\u0004\b;\u0010%R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0006\u00a2\u0006\f\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildNewScheduleViewModel;", "Lef1/b;", "", "d2", "", "mGuildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bd;", "p2", "Landroid/content/Context;", "context", "defaultTime", "q2", "v2", ICustomDataEditor.STRING_PARAM_2, "", "title", "desc", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eb;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/dp;", "jumpAddress", "channelId", "", "isSelectChannel", "scheduleChannelId", "b2", "url", "submit", "X1", "i2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "o2", "()Landroidx/lifecycle/MutableLiveData;", "scheduleStartTimeMs", "E", ICustomDataEditor.NUMBER_PARAM_2, "scheduleEndTimeMs", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProScheduleInfo;", UserInfo.SEX_FEMALE, "r2", "isSuccessScheduleInfo", "G", "g2", "abstractInfo", "H", "f2", "abstractError", "I", "k2", "checkStatus", "J", "l2", "checkSuccessSubmit", "K", "m2", "hotChannelInfo", "L", SemanticAttributes.DbSystemValues.H2, "addressOpenState", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "M", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "getChannel", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "setChannel", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;)V", WadlProxyConsts.CHANNEL, "Lcom/tencent/mobileqq/guild/schedule/create/timepicker/b;", "N", "Lcom/tencent/mobileqq/guild/schedule/create/timepicker/b;", "startTimePicker", "P", "endTimePicker", "Lcom/tencent/mobileqq/guild/schedule/create/timepicker/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/schedule/create/timepicker/a;", "adapter", "<init>", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNewScheduleViewModel extends ef1.b {

    /* renamed from: R */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> scheduleStartTimeMs;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> scheduleEndTimeMs;

    /* renamed from: F */
    @NotNull
    private final MutableLiveData<IGProScheduleInfo> isSuccessScheduleInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> abstractInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> abstractError;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> checkStatus;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> checkSuccessSubmit;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<eb> hotChannelInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> addressOpenState;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private IGProChannel com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.schedule.create.timepicker.b startTimePicker;

    /* renamed from: P, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.schedule.create.timepicker.b endTimePicker;

    /* renamed from: Q */
    private com.tencent.mobileqq.guild.schedule.create.timepicker.a adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildNewScheduleViewModel$1", f = "GuildNewScheduleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildNewScheduleViewModel$1 */
    /* loaded from: classes13.dex */
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
                GuildNewScheduleViewModel.this.i2();
                GuildNewScheduleViewModel.this.d2();
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildNewScheduleViewModel$a;", "", "", "HIDDEN_POST_CHANNEL", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildNewScheduleViewModel$a */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public GuildNewScheduleViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.scheduleStartTimeMs = new MutableLiveData<>();
        this.scheduleEndTimeMs = new MutableLiveData<>();
        this.isSuccessScheduleInfo = new MutableLiveData<>();
        this.abstractInfo = new MutableLiveData<>();
        this.abstractError = new MutableLiveData<>();
        this.checkStatus = new MutableLiveData<>();
        this.checkSuccessSubmit = new MutableLiveData<>();
        this.hotChannelInfo = new MutableLiveData<>();
        this.addressOpenState = new MutableLiveData<>();
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.sch.GuildNewScheduleViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    public static /* synthetic */ void Z1(GuildNewScheduleViewModel guildNewScheduleViewModel, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildNewScheduleViewModel.X1(str, z16);
    }

    public static final void a2(GuildNewScheduleViewModel this$0, boolean z16, String url, int i3, String str, IGProCheckFeedAbstractInfoRsp iGProCheckFeedAbstractInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        if (i3 == 0) {
            MutableLiveData<Boolean> mutableLiveData = this$0.checkStatus;
            Boolean bool = Boolean.TRUE;
            mutableLiveData.setValue(bool);
            this$0.abstractInfo.setValue(iGProCheckFeedAbstractInfoRsp.getAbstractInfo());
            if (z16) {
                this$0.checkSuccessSubmit.setValue(bool);
            }
        } else {
            String str2 = "\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u94fe\u63a5";
            this$0.abstractError.setValue("\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u94fe\u63a5");
            this$0.checkStatus.setValue(Boolean.FALSE);
            if (str != null) {
                str2 = str;
            }
            aa.e(str2);
        }
        Logger.f235387a.d().d("Guild.sch.GuildNewScheduleViewModel", 1, "checkFeedAbstractInfo " + i3 + " " + str + " " + url + " ");
    }

    public static final void c2(GuildNewScheduleViewModel this$0, String scheduleChannelId, long j3, int i3, String str, IGProScheduleInfo iGProScheduleInfo) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scheduleChannelId, "$scheduleChannelId");
        if (i3 == 0) {
            aa.h("\u65e5\u7a0b\u521b\u5efa\u6210\u529f!");
            this$0.isSuccessScheduleInfo.setValue(iGProScheduleInfo);
        } else {
            aa.e(str);
        }
        Logger.a d16 = Logger.f235387a.d();
        String str2 = this$0.guildId;
        if (iGProScheduleInfo != null) {
            l3 = Long.valueOf(iGProScheduleInfo.getScheduleId());
        } else {
            l3 = null;
        }
        d16.d("Guild.sch.GuildNewScheduleViewModel", 1, "createScheduleV2 " + i3 + " " + str + " " + str2 + " - " + scheduleChannelId + " " + j3 + " - " + l3);
    }

    public final void d2() {
        ArrayList<Integer> arrayListOf;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        long j3 = StringUtils.toLong(this.guildId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(18);
        iGPSService.fetchSpecifiedTypeChannelsOpenState(j3, arrayListOf, 0, new be() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.g
            @Override // wh2.be
            public final void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
                GuildNewScheduleViewModel.e2(GuildNewScheduleViewModel.this, i3, str, iGProChannelOpenStateResultInfo);
            }
        });
    }

    public static final void e2(GuildNewScheduleViewModel this$0, int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
        boolean z16;
        int collectionSizeOrDefault;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IGProSwitchInfo> switchInfoList = iGProChannelOpenStateResultInfo.getSwitchInfoList();
        Intrinsics.checkNotNullExpressionValue(switchInfoList, "stateResultInfo.switchInfoList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = switchInfoList.iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((IGProSwitchInfo) next).getSwitchType() == 18) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Integer.valueOf(((IGProSwitchInfo) it5.next()).getSwitchState()));
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        Integer num = (Integer) firstOrNull;
        if (num == null || num.intValue() != 2) {
            z16 = true;
        }
        Logger.f235387a.d().d("Guild.sch.GuildNewScheduleViewModel", 1, "fetchSpecifiedTypeChannelsOpenState " + i3 + " " + str + " " + this$0.guildId + "  isEnable " + z16);
        this$0.addressOpenState.setValue(Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j2(GuildNewScheduleViewModel this$0, long j3, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Guild.sch.GuildNewScheduleViewModel", 2, "getCategoryChannelInfoListV2 infoList " + arrayList.size());
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<IGProChannel> channelInfoList = ((IGProCategoryChannelInfoList) it.next()).getChannelInfoList();
                IGProChannel iGProChannel = null;
                if (channelInfoList != null) {
                    Iterator<T> it5 = channelInfoList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next = it5.next();
                        IGProChannel iGProChannel2 = (IGProChannel) next;
                        if (iGProChannel2.getHiddenPostChannel() == 1 && iGProChannel2.getChannelType() == 7) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            iGProChannel = next;
                            break;
                        }
                    }
                    iGProChannel = iGProChannel;
                }
                if (iGProChannel != null) {
                    this$0.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String = iGProChannel;
                    eb ebVar = new eb();
                    ebVar.g(iGProChannel.getChannelId());
                    ebVar.l(iGProChannel.getChannelType());
                    ebVar.i(j3);
                    ebVar.h("\u4e3b\u9875");
                    ebVar.k(false);
                    ebVar.j(true);
                    this$0.hotChannelInfo.setValue(ebVar);
                    return;
                }
            }
        }
    }

    private final bd p2(long mGuildId) {
        bd bdVar = new bd();
        bdVar.k(mGuildId);
        bdVar.h(false);
        bdVar.i(true);
        bdVar.j(false);
        return bdVar;
    }

    public static final void t2(GuildNewScheduleViewModel this$0, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this$0.endTimePicker;
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar = null;
        }
        long g16 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.g(bVar, i3, i16, i17);
        if (this$0.scheduleStartTimeMs.getValue() != null) {
            Long value = this$0.scheduleStartTimeMs.getValue();
            Intrinsics.checkNotNull(value);
            if (g16 < value.longValue()) {
                aa.g("\u65e5\u7a0b\u7ed3\u675f\u65f6\u95f4\u5c0f\u4e8e\u5f00\u59cb\u65f6\u95f4, \u8bf7\u91cd\u65b0\u9009\u62e9!");
                return;
            }
        }
        this$0.scheduleEndTimeMs.setValue(Long.valueOf(g16));
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar3 = this$0.endTimePicker;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
        } else {
            bVar2 = bVar3;
        }
        bVar2.m();
    }

    public static final void u2(GuildNewScheduleViewModel this$0, int i3, int i16) {
        Long value;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this$0.endTimePicker;
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar = null;
        }
        GuildScheduleIphonePickerView.h n3 = bVar.n();
        Intrinsics.checkNotNullExpressionValue(n3, "endTimePicker.adapter");
        if (!(n3 instanceof com.tencent.mobileqq.guild.schedule.create.timepicker.a) || (value = this$0.scheduleStartTimeMs.getValue()) == null) {
            return;
        }
        long longValue = value.longValue();
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar3 = this$0.endTimePicker;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar3 = null;
        }
        if (bVar3.o() <= longValue) {
            com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar4 = this$0.endTimePicker;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            } else {
                bVar2 = bVar4;
            }
            com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(bVar2, (com.tencent.mobileqq.guild.schedule.create.timepicker.a) n3, longValue + 60000);
        }
    }

    public static final void w2(GuildNewScheduleViewModel this$0, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this$0.startTimePicker;
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimePicker");
            bVar = null;
        }
        long g16 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.g(bVar, i3, i16, i17);
        if (!m.g(g16)) {
            aa.g("\u65e5\u7a0b\u5f00\u59cb\u65f6\u95f4\u4e0d\u80fd\u5c0f\u4e8e\u5f53\u524d\u65f6\u95f4");
            return;
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar3 = this$0.startTimePicker;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimePicker");
        } else {
            bVar2 = bVar3;
        }
        bVar2.m();
        this$0.scheduleStartTimeMs.setValue(Long.valueOf(g16));
        if (this$0.scheduleEndTimeMs.getValue() != null) {
            Long value = this$0.scheduleEndTimeMs.getValue();
            Intrinsics.checkNotNull(value);
            if (m.f(g16, value.longValue()) != 0) {
                this$0.scheduleEndTimeMs.setValue(Long.valueOf(g16 + 3600000));
            }
        }
    }

    public final void X1(@NotNull final String url, final boolean submit) {
        Intrinsics.checkNotNullParameter(url, "url");
        u uVar = new u();
        uVar.b(url);
        ((IGPSService) ch.R0(IGPSService.class)).checkFeedAbstractInfo(uVar, new wh2.i() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.i
            @Override // wh2.i
            public final void a(int i3, String str, IGProCheckFeedAbstractInfoRsp iGProCheckFeedAbstractInfoRsp) {
                GuildNewScheduleViewModel.a2(GuildNewScheduleViewModel.this, submit, url, i3, str, iGProCheckFeedAbstractInfoRsp);
            }
        });
    }

    public final void b2(@NotNull String title, @NotNull String desc, @NotNull eb channelInfo, @NotNull dp jumpAddress, final long channelId, boolean isSelectChannel, @NotNull final String scheduleChannelId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(jumpAddress, "jumpAddress");
        Intrinsics.checkNotNullParameter(scheduleChannelId, "scheduleChannelId");
        if (channelId == 0 && this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String != null && isSelectChannel) {
            channelInfo = new eb();
            IGProChannel iGProChannel = this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String;
            Intrinsics.checkNotNull(iGProChannel);
            channelInfo.g(iGProChannel.getChannelId());
            IGProChannel iGProChannel2 = this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String;
            Intrinsics.checkNotNull(iGProChannel2);
            channelInfo.l(iGProChannel2.getChannelType());
            channelInfo.i(Long.parseLong(this.guildId));
            channelInfo.h("\u4e3b\u9875");
            channelInfo.k(false);
            channelInfo.j(true);
        }
        ec ecVar = new ec();
        ecVar.v(title);
        ecVar.q(desc);
        Long value = this.scheduleStartTimeMs.getValue();
        Intrinsics.checkNotNull(value);
        ecVar.u(value.longValue());
        Long value2 = this.scheduleEndTimeMs.getValue();
        Intrinsics.checkNotNull(value2);
        ecVar.r(value2.longValue());
        if (isSelectChannel) {
            ecVar.p(channelInfo);
        } else {
            ecVar.s(jumpAddress);
        }
        ae aeVar = new ae();
        aeVar.j(Long.parseLong(this.guildId));
        aeVar.i(StringUtils.toLong(scheduleChannelId));
        aeVar.k(ecVar);
        aeVar.h(11);
        aeVar.g(0);
        ((IGPSService) ch.R0(IGPSService.class)).createScheduleV2(aeVar, new q() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.h
            @Override // wh2.q
            public final void a(int i3, String str, IGProScheduleInfo iGProScheduleInfo) {
                GuildNewScheduleViewModel.c2(GuildNewScheduleViewModel.this, scheduleChannelId, channelId, i3, str, iGProScheduleInfo);
            }
        });
    }

    @NotNull
    public final MutableLiveData<String> f2() {
        return this.abstractError;
    }

    @NotNull
    public final MutableLiveData<String> g2() {
        return this.abstractInfo;
    }

    @NotNull
    public final MutableLiveData<Boolean> h2() {
        return this.addressOpenState;
    }

    public final void i2() {
        final long j3 = StringUtils.toLong(this.guildId);
        bd p26 = p2(j3);
        if (p26 == null) {
            return;
        }
        ((IGPSService) ch.R0(IGPSService.class)).getCategoryChannelInfoListV2(p26, new br() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.d
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                GuildNewScheduleViewModel.j2(GuildNewScheduleViewModel.this, j3, arrayList);
            }
        });
    }

    @NotNull
    public final MutableLiveData<Boolean> k2() {
        return this.checkStatus;
    }

    @NotNull
    public final MutableLiveData<Boolean> l2() {
        return this.checkSuccessSubmit;
    }

    @NotNull
    public final MutableLiveData<eb> m2() {
        return this.hotChannelInfo;
    }

    @NotNull
    public final MutableLiveData<Long> n2() {
        return this.scheduleEndTimeMs;
    }

    @NotNull
    public final MutableLiveData<Long> o2() {
        return this.scheduleStartTimeMs;
    }

    public final void q2(@NotNull Context context, long defaultTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Pair<Long, Long> a16 = m.a(defaultTime);
        Long l3 = (Long) a16.first;
        Long l16 = (Long) a16.second;
        this.scheduleStartTimeMs.setValue(l3);
        this.scheduleEndTimeMs.setValue(l16);
        com.tencent.mobileqq.guild.schedule.create.timepicker.a aVar = new com.tencent.mobileqq.guild.schedule.create.timepicker.a(serverTimeMillis);
        this.adapter = aVar;
        this.startTimePicker = new com.tencent.mobileqq.guild.schedule.create.timepicker.b(context, aVar);
        com.tencent.mobileqq.guild.schedule.create.timepicker.a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar2 = null;
        }
        this.endTimePicker = new com.tencent.mobileqq.guild.schedule.create.timepicker.b(context, aVar2);
    }

    @NotNull
    public final MutableLiveData<IGProScheduleInfo> r2() {
        return this.isSuccessScheduleInfo;
    }

    public final void s2(@NotNull Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.adapter == null) {
            q2(context, j3);
        }
        Long value = this.scheduleEndTimeMs.getValue();
        if (value == null) {
            value = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this.endTimePicker;
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar = null;
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(bVar, aVar, value.longValue());
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar3 = this.endTimePicker;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar3 = null;
        }
        bVar3.p(new b.c() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.e
            @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.c
            public final void a(int i3, int i16, int i17) {
                GuildNewScheduleViewModel.t2(GuildNewScheduleViewModel.this, i3, i16, i17);
            }
        });
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar4 = this.endTimePicker;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
            bVar4 = null;
        }
        bVar4.r(new b.e() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.f
            @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.e
            public final void onItemSelected(int i3, int i16) {
                GuildNewScheduleViewModel.u2(GuildNewScheduleViewModel.this, i3, i16);
            }
        });
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar5 = this.endTimePicker;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimePicker");
        } else {
            bVar2 = bVar5;
        }
        bVar2.t();
    }

    public final void v2(@NotNull Context context, long defaultTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.adapter == null) {
            q2(context, defaultTime);
        }
        Long value = this.scheduleStartTimeMs.getValue();
        if (value == null) {
            value = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this.startTimePicker;
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimePicker");
            bVar = null;
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(bVar, aVar, value.longValue());
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar3 = this.startTimePicker;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimePicker");
            bVar3 = null;
        }
        bVar3.p(new b.c() { // from class: com.tencent.mobileqq.guild.home.schedule.viewmodels.j
            @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.c
            public final void a(int i3, int i16, int i17) {
                GuildNewScheduleViewModel.w2(GuildNewScheduleViewModel.this, i3, i16, i17);
            }
        });
        com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar4 = this.startTimePicker;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimePicker");
        } else {
            bVar2 = bVar4;
        }
        bVar2.t();
    }
}
