package com.tencent.guild.aio.component.slowmode;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.slowmode.GuildSlowModeEvent;
import com.tencent.guild.aio.component.slowmode.GuildSlowModeUIState;
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
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0002AE\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010&\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0/H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H\u0016J\u000e\u00106\u001a\u00020\u00042\u0006\u0010'\u001a\u00020#R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel;", "Lpn0/a;", "Lcom/tencent/guild/aio/component/slowmode/a;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "", "K", "P", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", NodeProps.ENABLED, "D", "u", "Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "J", "M", "H", "G", "Lcom/tencent/guild/aio/component/slowmode/f;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "T", "W", UserInfo.SEX_FEMALE, "isLimited", "L", ViewStickEventHelper.IS_SHOW, "N", "", "channelId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "limitTime", BdhLogUtil.LogTag.Tag_Req, "millisRemain", "v", ExifInterface.LATITUDE_SOUTH, "y", "w", "intent", "Lcom/tencent/mvi/base/route/k;", "l", "", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "B", "O", "f", "Z", "limitedBySlowMode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "currChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "com/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$c;", "mSpeakThresholdUpdateListener", "com/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$b", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$b;", "mAction", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildSlowModeViewModel extends pn0.a<a, GuildSlowModeUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean limitedBySlowMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProChannelInfo currChannelInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver serviceObserver = new d();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mSpeakThresholdUpdateListener = new c();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildSlowModeViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildSpeakThresholdApi.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (Intrinsics.areEqual(guildId, GuildSlowModeViewModel.this.y()) && channelIds.contains(GuildSlowModeViewModel.this.w())) {
                GuildSlowModeViewModel.this.T();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            if (guildIds.contains(GuildSlowModeViewModel.this.y())) {
                GuildSlowModeViewModel.this.T();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(guildId, GuildSlowModeViewModel.this.y())) {
                GuildSlowModeViewModel.this.T();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/guild/aio/component/slowmode/GuildSlowModeViewModel$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "", "expireTime", "onShutUpStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            if (TextUtils.equals(GuildSlowModeViewModel.this.y(), guildId)) {
                GuildSlowModeViewModel.this.T();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            if (TextUtils.equals(GuildSlowModeViewModel.this.w(), channelUin)) {
                GuildSlowModeViewModel.this.T();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.equals(GuildSlowModeViewModel.this.y(), guildId)) {
                GuildSlowModeViewModel.this.T();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            if (TextUtils.equals(GuildSlowModeViewModel.this.y(), guildId)) {
                GuildSlowModeViewModel.this.T();
            }
        }
    }

    private final SlowModeUIData A() {
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
        ISlowModeInfo x16 = x();
        if (x16 == null) {
            return new SlowModeUIData(SlowModeTipType.DEFAULT, 0, 0, 6, null);
        }
        int slowModeCircle = x16.getSlowModeCircle();
        int speakFrequency = x16.getSpeakFrequency();
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

    private final void C(com.tencent.qqnt.msg.data.b limitInfoData) {
        FreqLimitInfo a16;
        Contact b16 = limitInfoData.b();
        if (b16 != null && Intrinsics.areEqual(b16.guildId, y()) && Intrinsics.areEqual(b16.peerUid, w()) && (a16 = limitInfoData.a()) != null) {
            ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).handleSlowModeFreqLimitFromNT(a16, w());
            if (a16.leftCount <= 0) {
                T();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(boolean enabled) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildAioInputMsgIntent.UpdateSendBtnClickable(enabled));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            T();
        }
    }

    private final void F() {
        L(false);
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        N(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean G() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean H() {
        if (G()) {
            return false;
        }
        int a16 = fo0.h.a(y(), w());
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        if (companion.r(a16)) {
            return false;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (!companion.d(a16, com.tencent.guild.aio.util.a.g(g16))) {
            return false;
        }
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        if (companion.x(a16, com.tencent.guild.aio.util.a.g(g17))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void J(com.tencent.qqnt.msg.data.b limitInfoData) {
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

    private final void K() {
        W();
        u();
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.mSpeakThresholdUpdateListener);
        ((IGPSService) bz.c(IGPSService.class, "")).addObserver(this.serviceObserver);
    }

    private final void L(boolean isLimited) {
        D(!isLimited);
        this.limitedBySlowMode = isLimited;
    }

    private final void M() {
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        if (!H()) {
            updateUI(new GuildSlowModeUIState.SlowModeTipVisible(false));
        } else {
            updateUI(new GuildSlowModeUIState.SlowModeTipVisible(true));
            updateUI(new GuildSlowModeUIState.UpdateSlowModeTipText(A()));
        }
    }

    private final void N(boolean isShow) {
        updateUI(new GuildSlowModeUIState.SlowModeTipVisible(isShow));
    }

    private final void P() {
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.mSpeakThresholdUpdateListener);
        ((IGPSService) bz.c(IGPSService.class, "")).deleteObserver(this.serviceObserver);
        F();
    }

    private final void Q() {
        W();
    }

    private final long R(String channelId, long limitTime) {
        long j3;
        long j16 = 1000;
        long serverTime = NetConnInfoCenter.getServerTime() * j16;
        int slowModeLimitCycle = ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).getSlowModeLimitCycle(channelId);
        ISlowModeInfo x16 = x();
        if (x16 != null) {
            if (limitTime != 0 && slowModeLimitCycle != x16.getSlowModeCircle()) {
                j3 = (limitTime - (slowModeLimitCycle * 1000)) + (x16.getSlowModeCircle() * 1000);
            } else {
                j3 = limitTime;
            }
            if ((j3 - serverTime) / j16 > x16.getSlowModeCircle()) {
                j3 = serverTime + (x16.getSlowModeCircle() * 1000);
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

    private final void S(boolean isLimited) {
        this.limitedBySlowMode = isLimited;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.component.slowmode.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildSlowModeViewModel.U(GuildSlowModeViewModel.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(GuildSlowModeViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W();
    }

    private final void W() {
        IGProChannelInfo iGProChannelInfo;
        boolean z16;
        IGPSService c16 = com.tencent.guild.aio.util.h.f112401a.c();
        if (c16 != null) {
            iGProChannelInfo = c16.getChannelInfo(w());
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
            if (!z16 && x() != null && H()) {
                L(false);
                String w3 = w();
                long z17 = z(w3);
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                long R = R(w3, z17);
                if (R > serverTimeMillis) {
                    O(R - serverTimeMillis);
                    return;
                } else {
                    M();
                    return;
                }
            }
        }
        QLog.d("GuildSlowModeViewModel", 2, "channel info:" + this.currChannelInfo);
        F();
    }

    private final void u() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.h(), new GuildSlowModeViewModel$channelFreqLimitInfoUpdate$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    private final long v(long millisRemain) {
        float f16;
        long j3 = 1000;
        float f17 = ((float) (millisRemain / j3)) + 1.0f;
        if (x() != null) {
            if (f17 <= r4.getSlowModeCircle() - 2) {
                f16 = 1.5f;
            } else if (f17 <= r4.getSlowModeCircle() - 1) {
                f16 = 1;
            }
            f17 += f16;
        }
        if (millisRemain % j3 != 0) {
            f17++;
        }
        return f17 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String w() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.b(g16);
    }

    private final ISlowModeInfo x() {
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
    public final String y() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.g(g16);
    }

    private final long z(String channelId) {
        return ((IGuildSlowModeService) bz.b(IGuildSlowModeService.class)).getSlowModeLimitTime(channelId);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            Q();
            return;
        }
        if (intent instanceof a.e) {
            D(((a.e) intent).getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String());
            return;
        }
        if (intent instanceof a.c) {
            M();
        } else if (intent instanceof a.C1182a) {
            C(((a.C1182a) intent).getLimitInfoData());
        } else if (intent instanceof a.d) {
            S(((a.d) intent).getIsLimited());
        }
    }

    public final void O(long millisRemain) {
        boolean z16;
        String str;
        updateUI(GuildSlowModeUIState.CancelTimer.f110321d);
        IGProChannelInfo iGProChannelInfo = this.currChannelInfo;
        if (iGProChannelInfo != null) {
            z16 = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
        } else {
            QLog.e("GuildSlowModeViewModel", 1, "try get isGuildOrChannelManager, but currChannelInfo is null, isAdmin:false");
            z16 = false;
        }
        if (z16) {
            IGProChannelInfo iGProChannelInfo2 = this.currChannelInfo;
            if (iGProChannelInfo2 != null) {
                str = iGProChannelInfo2.getChannelUin();
            } else {
                str = null;
            }
            QLog.w("GuildSlowModeViewModel", 1, "startSlowModeCountDown channelId:" + str + ", isAdmin=true");
            M();
            return;
        }
        if (!H()) {
            F();
            return;
        }
        long v3 = v(millisRemain);
        IGProChannelInfo iGProChannelInfo3 = this.currChannelInfo;
        if (iGProChannelInfo3 != null) {
            QLog.d("GuildSlowModeViewModel", 1, "startSlowModeCountDown channelId=" + iGProChannelInfo3.getChannelUin() + ", channelName=" + iGProChannelInfo3.getChannelName() + ", slowModeKey=" + iGProChannelInfo3.getSlowModeKey() + ", millisRemain=" + millisRemain + ", fixedMillis=" + v3);
        }
        L(true);
        N(true);
        updateUI(new GuildSlowModeUIState.StartTimer(v3));
    }

    @Override // pn0.a
    @NotNull
    public k l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildSlowModeEvent.GetIsInSlowModeLimit) {
            return new e(this.limitedBySlowMode);
        }
        return super.l(intent);
    }

    @Override // pn0.a
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildSlowModeEvent.GetIsInSlowModeLimit.class).getQualifiedName());
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        K();
    }
}
