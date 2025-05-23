package com.tencent.guild.aio.article.input.slowmode;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.component.slowmode.GuildSlowModeUIState;
import com.tencent.guild.aio.component.slowmode.SlowModeTipType;
import com.tencent.guild.aio.component.slowmode.SlowModeUIData;
import com.tencent.guild.aio.component.slowmode.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u0002@D\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u001a\u0010%\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u000e\u00100\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\"R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/component/slowmode/a;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", UserInfo.SEX_FEMALE, "L", "", NodeProps.ENABLED, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "D", "H", "B", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/component/slowmode/f;", "w", "Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;", "t", "y", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isLimited", "G", ViewStickEventHelper.IS_SHOW, "J", "", "channelId", "", "v", "limitTime", "M", "millisRemain", "r", "N", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, HippyTKDListViewAdapter.X, "K", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mMainMsgRecord", "e", "Z", "limitedBySlowMode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "currChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "com/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$c", "i", "Lcom/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$c;", "mSpeakThresholdUpdateListener", "com/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$b;", "mAction", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleSlowModeViewModel extends com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.component.slowmode.a, GuildSlowModeUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mMainMsgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean limitedBySlowMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProChannelInfo currChannelInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver serviceObserver = new d();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mSpeakThresholdUpdateListener = new c();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildArticleSlowModeViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildSpeakThresholdApi.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (Intrinsics.areEqual(guildId, GuildArticleSlowModeViewModel.this.u()) && channelIds.contains(GuildArticleSlowModeViewModel.this.s())) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            if (guildIds.contains(GuildArticleSlowModeViewModel.this.u())) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(guildId, GuildArticleSlowModeViewModel.this.u())) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/guild/aio/article/input/slowmode/GuildArticleSlowModeViewModel$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "", "expireTime", "onShutUpStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            if (TextUtils.equals(GuildArticleSlowModeViewModel.this.u(), guildId)) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            if (TextUtils.equals(GuildArticleSlowModeViewModel.this.s(), channelUin)) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.equals(GuildArticleSlowModeViewModel.this.u(), guildId)) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            if (TextUtils.equals(GuildArticleSlowModeViewModel.this.u(), guildId)) {
                GuildArticleSlowModeViewModel.this.O();
            }
        }
    }

    private final void A() {
        G(false);
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        J(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B() {
        boolean z16;
        MsgRecord msgRecord;
        boolean z17;
        int i3;
        if (C()) {
            return false;
        }
        int a16 = fo0.h.a(u(), s());
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (companion.d(a16, com.tencent.guild.aio.util.a.g(g16))) {
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (!companion.x(a16, com.tencent.guild.aio.util.a.g(g17))) {
                z16 = true;
                msgRecord = this.mMainMsgRecord;
                if (msgRecord == null && (i3 = msgRecord.msgType) != 5 && i3 != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 && z17) {
                    return true;
                }
            }
        }
        z16 = false;
        msgRecord = this.mMainMsgRecord;
        if (msgRecord == null) {
        }
        z17 = false;
        return !z16 ? false : false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void D(com.tencent.qqnt.msg.data.b limitInfoData) {
        String str;
        QLog.d("GuildSlowModeViewModel", 4, limitInfoData);
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Contact b16 = limitInfoData.b();
        String str2 = null;
        if (b16 != null) {
            str = b16.guildId;
        } else {
            str = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (Intrinsics.areEqual(str, com.tencent.guild.aio.util.a.g(it))) {
            Contact b17 = limitInfoData.b();
            if (b17 != null) {
                str2 = b17.peerUid;
            }
            if (Intrinsics.areEqual(str2, com.tencent.guild.aio.util.a.b(it))) {
                updateUI(new GuildSlowModeUIState.GuildFreqLimitInfo(limitInfoData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof GuildArticleMsgListEvent.MainMsgRecordInitCompleted) {
            this.mMainMsgRecord = ((GuildArticleMsgListEvent.MainMsgRecordInitCompleted) intent).getMsgRecord();
            O();
        } else if (intent instanceof GuildArticleMsgListEvent.MainMsgInfoUpdated) {
            this.mMainMsgRecord = ((GuildArticleMsgListEvent.MainMsgInfoUpdated) intent).getMsgRecord();
            O();
        } else if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            O();
        }
    }

    private final void F() {
        O();
        q();
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.mSpeakThresholdUpdateListener);
        ((IGPSService) bz.c(IGPSService.class, "")).addObserver(this.serviceObserver);
    }

    private final void G(boolean isLimited) {
        z(!isLimited);
        this.limitedBySlowMode = isLimited;
    }

    private final void H() {
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        if (!B()) {
            updateUI(new GuildSlowModeUIState.SlowModeTipVisible(false));
        } else {
            updateUI(new GuildSlowModeUIState.SlowModeTipVisible(true));
            updateUI(new GuildSlowModeUIState.UpdateSlowModeTipText(w()));
        }
    }

    private final void J(boolean isShow) {
        updateUI(new GuildSlowModeUIState.SlowModeTipVisible(isShow));
    }

    private final void L() {
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.mSpeakThresholdUpdateListener);
        ((IGPSService) bz.c(IGPSService.class, "")).deleteObserver(this.serviceObserver);
        A();
    }

    private final long M(String channelId, long limitTime) {
        long j3;
        long j16 = 1000;
        long serverTime = NetConnInfoCenter.getServerTime() * j16;
        int slowModeLimitCycle = ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).getSlowModeLimitCycle(channelId);
        ISlowModeInfo t16 = t();
        if (t16 != null) {
            if (limitTime != 0 && slowModeLimitCycle > t16.getSlowModeCircle()) {
                j3 = (limitTime - (slowModeLimitCycle * 1000)) + (t16.getSlowModeCircle() * 1000);
            } else {
                j3 = limitTime;
            }
            if ((j3 - serverTime) / j16 > t16.getSlowModeCircle()) {
                j3 = serverTime + (t16.getSlowModeCircle() * 1000);
            }
        } else {
            j3 = limitTime;
        }
        if (j3 != limitTime) {
            QLog.d("GuildSlowModeViewModel", 1, "updateLimitTime channelId=", channelId, " oldCycle=", Integer.valueOf(slowModeLimitCycle), " oldTime=", Long.valueOf(limitTime), " newTime=", Long.valueOf(j3));
            ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).updateSlowModeLimitTime(channelId, j3);
        }
        return j3;
    }

    private final void N(boolean isLimited) {
        this.limitedBySlowMode = isLimited;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.article.input.slowmode.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleSlowModeViewModel.P(GuildArticleSlowModeViewModel.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(GuildArticleSlowModeViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
    }

    private final void Q() {
        IGProChannelInfo iGProChannelInfo;
        boolean z16;
        IGPSService c16 = com.tencent.guild.aio.util.h.f112401a.c();
        if (c16 != null) {
            iGProChannelInfo = c16.getChannelInfo(s());
        } else {
            iGProChannelInfo = null;
        }
        this.currChannelInfo = iGProChannelInfo;
        if (iGProChannelInfo != null) {
            if (iGProChannelInfo != null && iGProChannelInfo.getSlowModeKey() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && B()) {
                G(false);
                String s16 = s();
                long v3 = v(s16);
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                long M = M(s16, v3);
                if (M > serverTimeMillis) {
                    K(M - serverTimeMillis);
                    return;
                } else {
                    H();
                    return;
                }
            }
        }
        QLog.d("GuildSlowModeViewModel", 2, "channel info:" + this.currChannelInfo);
        A();
    }

    private final void q() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.h(), new GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    private final long r(long millisRemain) {
        float f16;
        long j3 = 1000;
        float f17 = ((float) (millisRemain / j3)) + 1.0f;
        if (millisRemain % j3 != 0) {
            f17++;
        }
        if (t() != null) {
            if (f17 <= r6.getSlowModeCircle() - 2) {
                f16 = 1.5f;
            } else if (f17 <= r6.getSlowModeCircle() - 1) {
                f16 = 1;
            }
            f17 += f16;
        }
        return f17 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String s() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.b(g16);
    }

    private final ISlowModeInfo t() {
        IGProChannelInfo iGProChannelInfo = this.currChannelInfo;
        if (iGProChannelInfo != null) {
            Iterator<ISlowModeInfo> it = iGProChannelInfo.getGProSlowModeInfoList().iterator();
            while (it.hasNext()) {
                ISlowModeInfo next = it.next();
                if (next.getSlowModeKey() == iGProChannelInfo.getSlowModeKey()) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String u() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.g(g16);
    }

    private final long v(String channelId) {
        return ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).getSlowModeLimitTime(channelId);
    }

    private final SlowModeUIData w() {
        boolean z16;
        IGProChannelInfo iGProChannelInfo = this.currChannelInfo;
        if (iGProChannelInfo != null) {
            z16 = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
        } else {
            z16 = false;
        }
        if (z16) {
            return new SlowModeUIData(SlowModeTipType.DEFAULT, 0, 0, 6, null);
        }
        ISlowModeInfo t16 = t();
        if (t16 == null) {
            return new SlowModeUIData(SlowModeTipType.DEFAULT, 0, 0, 6, null);
        }
        int slowModeCircle = t16.getSlowModeCircle();
        int speakFrequency = t16.getSpeakFrequency();
        int i3 = slowModeCircle / 60;
        int i16 = i3 / 60;
        if (i16 > 0) {
            return new SlowModeUIData(SlowModeTipType.DETAIL_HOUR, i16, speakFrequency);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                return new SlowModeUIData(SlowModeTipType.DETAIL_MINUTES, i3, speakFrequency);
            }
            return new SlowModeUIData(SlowModeTipType.DETAIL_MINUTE, 0, speakFrequency, 2, null);
        }
        return new SlowModeUIData(SlowModeTipType.DETAIL_SECONDS, slowModeCircle, speakFrequency);
    }

    private final void y(com.tencent.qqnt.msg.data.b limitInfoData) {
        FreqLimitInfo a16;
        Contact b16 = limitInfoData.b();
        if (b16 != null && Intrinsics.areEqual(b16.guildId, u()) && Intrinsics.areEqual(b16.peerUid, s()) && (a16 = limitInfoData.a()) != null) {
            ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).handleSlowModeFreqLimitFromNT(a16, s());
            if (a16.leftCount <= 0) {
                O();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(boolean enabled) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildAioInputMsgIntent.UpdateSendBtnClickable(enabled));
    }

    public final void K(long millisRemain) {
        boolean z16;
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        IGProChannelInfo iGProChannelInfo = this.currChannelInfo;
        if (iGProChannelInfo != null) {
            z16 = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
            QLog.d("GuildSlowModeViewModel", 2, "guildId:" + iGProChannelInfo.getGuildId() + ", channelId:" + iGProChannelInfo.getChannelUin() + ", isAdmin:" + z16);
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("try get isGuildOrChannelManager, but currChannelInfo is null, isAdmin:");
            z16 = false;
            sb5.append(false);
            QLog.e("GuildSlowModeViewModel", 1, sb5.toString());
        }
        if (z16) {
            H();
            return;
        }
        if (!B()) {
            A();
            return;
        }
        long r16 = r(millisRemain);
        IGProChannelInfo iGProChannelInfo2 = this.currChannelInfo;
        if (iGProChannelInfo2 != null) {
            QLog.d("GuildSlowModeViewModel", 1, "startSlowModeCountDown channelId=" + iGProChannelInfo2.getChannelUin() + ", channelName=" + iGProChannelInfo2.getChannelName() + ", slowModeKey=" + iGProChannelInfo2.getSlowModeKey() + ", millisRemain=" + millisRemain + ", fixedMillis=" + r16);
        }
        G(true);
        J(true);
        updateUI(new GuildSlowModeUIState.StartTimer(r16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        L();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.component.slowmode.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.e) {
            z(((a.e) intent).getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String());
            return;
        }
        if (intent instanceof a.c) {
            H();
        } else if (intent instanceof a.C1182a) {
            y(((a.C1182a) intent).getLimitInfoData());
        } else if (intent instanceof a.d) {
            N(((a.d) intent).getIsLimited());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        F();
    }
}
