package com.tencent.guildlive.aio.input;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$UpdateLiveSpeakSwitch;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fo0.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b*\u000236\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM;", "Lpn0/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "D", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "guildId", "channelId", "", "J", "", "permissions", "G", "K", "y", "P", "L", "from", "N", "H", "M", "O", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", UserInfo.SEX_FEMALE, "f", "Z", "selfBannedSpeak", tl.h.F, "I", "selfBannedSpeakIndex", "Lcom/tencent/mobileqq/guild/api/IGuildLiveChannelApi;", "i", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/guild/api/IGuildLiveChannelApi;", "liveChannelApi", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "com/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$c", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$c;", "mSpeakThresholdUpdateListener", "com/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$receiver$1", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$receiver$1;", "receiver", "<init>", "()V", "E", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioInputContainerVM extends pn0.a<fo0.c, InputUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mSpeakThresholdUpdateListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildLiveAioInputContainerVM$receiver$1 receiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean selfBannedSpeak;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int selfBannedSpeakIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveChannelApi;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0014J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J8\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u001cH\u0014\u00a8\u0006\u001e"}, d2 = {"com/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "channelId", "roomId", "action", "onSelfBannedSpeakChange", "", "expireTime", "onShutUpStateChanged", "result", "errMsg", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "onUserProfileInfoUpdate", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(g17, str)) {
                GuildLiveAioInputContainerVM.this.N("onAddGuildWithInfo");
                ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).e().h(new MsgIntent() { // from class: com.tencent.guildlive.aio.input.GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent
                    @Override // com.tencent.mvi.base.route.i
                    public /* synthetic */ String eventName() {
                        return com.tencent.mvi.base.route.h.a(this);
                    }

                    @Override // com.tencent.mvi.base.route.MsgIntent
                    public boolean isSticky() {
                        return MsgIntent.a.a(this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildLiveAioInputContainerVM.this.N("onAdminChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                GuildLiveAioInputContainerVM.this.N("onChannelInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildLiveAioInputContainerVM.this.N("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildLiveAioInputContainerVM.this.N("onGuildInfoUpdated");
                GuildLiveAioInputContainerVM.this.H();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onSelfBannedSpeakChange(@NotNull String guildId, @NotNull String channelId, @NotNull String roomId, int action) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                AIOParam g17 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g17), channelId)) {
                    GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "[onSelfBannedSpeakChange] action = " + action);
                    GuildLiveAioInputContainerVM guildLiveAioInputContainerVM = GuildLiveAioInputContainerVM.this;
                    boolean z16 = true;
                    guildLiveAioInputContainerVM.selfBannedSpeakIndex = guildLiveAioInputContainerVM.selfBannedSpeakIndex + 1;
                    GuildLiveAioInputContainerVM guildLiveAioInputContainerVM2 = GuildLiveAioInputContainerVM.this;
                    if (action != 1) {
                        z16 = false;
                    }
                    guildLiveAioInputContainerVM2.selfBannedSpeak = z16;
                    GuildLiveAioInputContainerVM.this.N("onSelfBannedSpeakChange");
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "[onShutUpStateChanged]  expireTime = " + expireTime);
                GuildLiveAioInputContainerVM.this.N("onShutUpStateChanged");
                GuildLiveAioInputContainerVM.this.H();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            String str;
            super.onUserProfileInfoUpdate(result, errMsg, guildId, tinyId, info);
            IGPSService d16 = at.d();
            if (d16 != null) {
                str = d16.getSelfTinyId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(tinyId, str)) {
                GuildLiveAioInputContainerVM guildLiveAioInputContainerVM = GuildLiveAioInputContainerVM.this;
                if (guildLiveAioInputContainerVM.J(guildLiveAioInputContainerVM.B(), GuildLiveAioInputContainerVM.this.A())) {
                    boolean z16 = false;
                    if (info != null && info.a() == 2) {
                        z16 = true;
                    }
                    if (z16) {
                        GuildLiveAioInputContainerVM.this.N("visitor faceAuthStatus success");
                        GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "onUserProfileInfoUpdate: tinyId " + tinyId + ", " + guildId);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guildlive/aio/input/GuildLiveAioInputContainerVM$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildSpeakThresholdApi.a {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                return;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (channelIds.contains(com.tencent.guild.aio.util.a.b(g17))) {
                GuildLiveAioInputContainerVM.this.N("onSpeakThresholdUpdate withChannel");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (guildIds.contains(com.tencent.guild.aio.util.a.g(g16))) {
                GuildLiveAioInputContainerVM.this.N("onSpeakThresholdUpdate guildIds");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveAioInputContainerVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildLiveAioInputContainerVM.this.N("onSpeakThresholdUpdate guildId");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVM$receiver$1] */
    public GuildLiveAioInputContainerVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildLiveChannelApi>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVM$liveChannelApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildLiveChannelApi invoke() {
                return (IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class);
            }
        });
        this.liveChannelApi = lazy;
        this.mGPServiceObserver = new b();
        this.mSpeakThresholdUpdateListener = new c();
        this.receiver = new BroadcastReceiver() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVM$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                GuildLiveAioInputContainerVM.this.D();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String A() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.b(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String B() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return com.tencent.guild.aio.util.a.g(g16);
    }

    private final IGuildLiveChannelApi C() {
        return (IGuildLiveChannelApi) this.liveChannelApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppInterface appInterface2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService2 = (IGPSService) iRuntimeService2;
        if (iGPSService2 != null) {
            iGPSService2.addObserver(this.mGPServiceObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(int permissions) {
        boolean K = K();
        GuildLiveLogUtil.Companion companion = GuildLiveLogUtil.INSTANCE;
        companion.e("LiveAioInputContainerVM", "[handlePermissionsChange] permissions = " + permissions + ", isLiveSpeakClose = " + yr0.a.f() + ", selfBannedSpeak = " + this.selfBannedSpeak + ", hostBannedAudience:" + K);
        if (yr0.a.f()) {
            permissions = 0;
        } else {
            GuildSpeakLimitStatus.Companion companion2 = GuildSpeakLimitStatus.INSTANCE;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (companion2.f(permissions, com.tencent.guild.aio.util.a.g(g16))) {
                boolean B = companion2.B(permissions);
                if (K && !B && !C().isSelfLiving()) {
                    permissions |= 16;
                } else if (this.selfBannedSpeak && !B) {
                    permissions = permissions | 16 | 32;
                }
            } else {
                companion.e("LiveAioInputContainerVM", "[handlePermissionsChange] canISpeakInLive false!");
            }
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildPermissionsChangeWrapperMsgIntent(permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void H() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("LiveAioInputContainerVM", false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J(String guildId, String channelId) {
        return ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).isGuest(guildId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean K() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        long j3;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            iGProChannelInfo = iGPSService.getChannelInfo(com.tencent.guild.aio.util.a.b(g16));
        }
        if (iGProChannelInfo != null) {
            j3 = iGProChannelInfo.getLiveRoomId();
        } else {
            j3 = 0;
        }
        boolean isAnchorInPlayListShow = C().isAnchorInPlayListShow();
        if (j3 <= 0) {
            return false;
        }
        if (iGProChannelInfo != null && iGProChannelInfo.getBannedSpeak() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || isAnchorInPlayListShow) {
            return false;
        }
        return true;
    }

    private final void L() {
        P();
        N("onLiveSpeakSwitchChange");
    }

    private final void M() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.addObserver(this.mGPServiceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.mSpeakThresholdUpdateListener);
        BaseApplication context = BaseApplication.getContext();
        if (context != null && context.getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            MobileQQ.sMobileQQ.registerReceiver(this.receiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N(String from) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(a16);
        GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "[senGuildPermissionChangeIntent] permissions = " + a16 + " from:" + from);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(guildPermissionsChange);
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        if (companion.C(a16) || companion.H(a16) || K()) {
            H();
        }
    }

    private final void O() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.mSpeakThresholdUpdateListener);
        MobileQQ.sMobileQQ.unregisterReceiver(this.receiver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P() {
        IGuildLiveChannelApi C = C();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        yr0.a.r(C.isLiveSpeakClose(com.tencent.guild.aio.util.a.g(g16)));
    }

    private final void Q() {
        QLog.i("LiveAioInputContainerVM", 1, "updatePermissionConfig");
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildLiveAioInputContainerVM$updatePermissionConfig$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str2 = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        }
        if (str != null) {
            str2 = str;
        }
        final int i3 = this.selfBannedSpeakIndex;
        if (iGPSService != null) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            iGPSService.checkUserBannedSpeakInChannel(g17, com.tencent.guild.aio.util.a.b(g18), str2, new vh2.f() { // from class: com.tencent.guildlive.aio.input.a
                @Override // vh2.f
                public final void a(int i16, String str3, int i17) {
                    GuildLiveAioInputContainerVM.z(i3, this, i16, str3, i17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, GuildLiveAioInputContainerVM this$0, int i16, String str, int i17) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "[checkUserBannedSpeakInChannel] result = " + i16 + ", errMsg = " + str + ", bannedSpeak = " + i17);
        if (i3 == this$0.selfBannedSpeakIndex) {
            if (i17 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.selfBannedSpeak = z16;
            this$0.N("[onSelfBannedSpeakChange] action = checkUserBannedSpeakInChannel");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.InputBarHeightChangeIntent) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildInputBarHeightChangEvent(((c.InputBarHeightChangeIntent) intent).getHeight()));
            return;
        }
        if (intent instanceof c.a) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18)));
            GuildLiveLogUtil.INSTANCE.e("LiveAioInputContainerVM", "[handleIntent] permissions = " + guildPermissionsChange.getPermissions());
            j(guildPermissionsChange);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            updateUI(new GuildLiveAioInputUIState.VideoScreenChange(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("LiveAioInputContainerVM", false, 2, null));
        } else if (intent instanceof GuildLiveOuterMsgIntent$UpdateLiveSpeakSwitch) {
            L();
        } else if (intent instanceof GuildPermissionsChange) {
            G(((GuildPermissionsChange) intent).getPermissions());
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$UpdateLiveSpeakSwitch.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildPermissionsChange.class).getQualifiedName()});
        return listOf;
    }

    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        O();
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        P();
        M();
        if (J(B(), A())) {
            Q();
        }
        N("onCreate");
        y();
    }
}
