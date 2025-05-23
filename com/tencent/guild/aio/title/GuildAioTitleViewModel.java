package com.tencent.guild.aio.title;

import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.title.GuildAioTitleGuildNameTextUIState;
import com.tencent.guild.aio.title.GuildAioTitleMsgIntent;
import com.tencent.guild.aio.title.GuildAioTitleMultiSelectUIState;
import com.tencent.guild.aio.title.GuildAioTitleTextUIState;
import com.tencent.guild.aio.title.b;
import com.tencent.guild.aio.title.c;
import com.tencent.guild.aio.title.d;
import com.tencent.guild.aio.usecase.channel.title.ChannelNameMviResult;
import com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildStateType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tl.h;
import vh2.bv;
import zp0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0003EHS\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0007H\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+H\u0002J\b\u00100\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u000203H\u0002R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0016\u0010O\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "D", "Lcom/tencent/guild/aio/util/ex/ContainerType;", "containerType", "", "w", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "K", UserInfo.SEX_FEMALE, "errorCode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityInfo", "", "M", "security", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "B", "Lcom/tencent/guild/aio/title/c$k;", "J", "L", "H", "Lcom/tencent/guild/aio/title/c$c;", "u", "Lcom/tencent/guild/aio/title/c$f;", "v", "Lcom/tencent/guild/aio/title/c$h;", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Lar0/a;", "response", "N", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "Lcom/tencent/mvi/base/route/k;", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isMultiSelectMode", "O", "", HippyTKDListViewAdapter.X, "Luq0/b;", "d", "Luq0/b;", "channelAvatarUseCase", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "e", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "channelNameUseCase", "Lvq0/b;", "f", "Lvq0/b;", "channelNoticeUseCase", "Lcom/tencent/aio/data/AIOContact;", h.F, "Lcom/tencent/aio/data/AIOContact;", "contact", "com/tencent/guild/aio/title/GuildAioTitleViewModel$d", "Lcom/tencent/guild/aio/title/GuildAioTitleViewModel$d;", "mAction", "com/tencent/guild/aio/title/GuildAioTitleViewModel$e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/title/GuildAioTitleViewModel$e;", "mActionR", "", "titleTextViewclickTime", "Z", "needHideGuest", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "com/tencent/guild/aio/title/GuildAioTitleViewModel$unreadMsgCntObs$1", "Lcom/tencent/guild/aio/title/GuildAioTitleViewModel$unreadMsgCntObs$1;", "unreadMsgCntObs", "<init>", "()V", "G", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioTitleViewModel extends com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> implements LifecycleObserver {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long titleTextViewclickTime;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean needHideGuest;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIOContact contact;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final uq0.b channelAvatarUseCase = new uq0.b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelNameUseCase channelNameUseCase = new ChannelNameUseCase();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vq0.b channelNoticeUseCase = new vq0.b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction = new d();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mActionR = new e();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver = new c();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildAioTitleViewModel$unreadMsgCntObs$1 unreadMsgCntObs = new com.tencent.qqnt.kernel.invorker.d() { // from class: com.tencent.guild.aio.title.GuildAioTitleViewModel$unreadMsgCntObs$1
        @Override // com.tencent.qqnt.kernel.invorker.d
        public void O0(int listType, int unreadCnt, @Nullable List<RecentContactInfo> changedList) {
            BuildersKt__Builders_commonKt.launch$default(GuildAioTitleViewModel.this.vmScope(), Dispatchers.getMain(), null, new GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1(GuildAioTitleViewModel.this, listType, unreadCnt, null), 2, null);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleViewModel$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "channelId", "", "fromScene", "", "a", "CLICK_THRESHOLD", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.title.GuildAioTitleViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentActivity activity, @NotNull String channelId, int fromScene) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            JSONArray jSONArray = new JSONArray();
            GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(channelId, fromScene);
            GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
            List<GuildMsgItem> g16 = companion.a().g(dVar);
            List<b.a> c16 = companion.a().c(dVar);
            int size = g16.size() + c16.size();
            zp0.b bVar = zp0.b.f452962a;
            bVar.h(jSONArray, g16);
            bVar.i(jSONArray, c16);
            IGuildUtilApi iGuildUtilApi = (IGuildUtilApi) QRoute.api(IGuildUtilApi.class);
            Intent intent = activity.getIntent();
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            iGuildUtilApi.fillJubaoIntent(intent, channelId, size, jSONArray2);
            activity.setResult(-1, activity.getIntent());
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                intent2.putExtra("jubao_result_ok", true);
            }
            companion.a().n(dVar, false);
            QLog.i("GuildAioTitleViewModel", 1, "handleJubaoFinishClick jsonArray: " + jSONArray);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112327a;

        static {
            int[] iArr = new int[ContainerType.values().length];
            try {
                iArr[ContainerType.CHAT_FRAGMENT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContainerType.MF_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContainerType.STAND_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f112327a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/title/GuildAioTitleViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "channelUin", "onChannelInfoUpdated", "guildId", "onChannelListUpdated", "onGuildInfoUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()));
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GuildAioTitleViewModel", 1, "onAddGuildWithInfo guildId: " + str + " curGuildId: " + com.tencent.guild.aio.util.a.g(g16));
            GuildAioTitleViewModel.this.O(GuildMultiMsgManager.INSTANCE.a().i(dVar));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            super.onChannelInfoUpdated(channelUin);
            if (channelUin != null) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                    IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
                    AIOContact aIOContact = GuildAioTitleViewModel.this.contact;
                    if (aIOContact == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contact");
                        aIOContact = null;
                    }
                    String channelName = iGuildChannelApi.getChannelName(aIOContact);
                    boolean z16 = true;
                    QLog.i("GuildAioTitleViewModel", 1, "onChannelInfoUpdated channelUin: " + channelUin);
                    if (channelName != null && channelName.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        GuildAioTitleViewModel.this.updateUI(new GuildAioTitleTextUIState.a().b(channelName).getState());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            super.onChannelListUpdated(guildId);
            if (guildId != null) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                    IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
                    AIOContact aIOContact = GuildAioTitleViewModel.this.contact;
                    if (aIOContact == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contact");
                        aIOContact = null;
                    }
                    String channelName = iGuildChannelApi.getChannelName(aIOContact);
                    boolean z16 = true;
                    QLog.i("GuildAioTitleViewModel", 1, "onChannelListUpdated guildId: " + guildId + " curChannelName: " + channelName);
                    if (channelName != null && channelName.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        GuildAioTitleViewModel.this.updateUI(new GuildAioTitleTextUIState.a().b(channelName).getState());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onGuildInfoUpdated(guildId);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) && com.tencent.guild.aio.util.ex.a.n((com.tencent.aio.api.runtime.a) GuildAioTitleViewModel.this.getMContext())) {
                String x16 = GuildAioTitleViewModel.this.x();
                boolean z16 = true;
                QLog.i("GuildAioTitleViewModel", 1, "onGuildInfoUpdated guildId: " + guildId + " guildName: " + x16);
                if (x16 != null && x16.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    GuildStateType iconState = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getGuildAioSubTitleIconState(guildId);
                    GuildAioTitleViewModel guildAioTitleViewModel = GuildAioTitleViewModel.this;
                    GuildAioTitleGuildNameTextUIState.a aVar = new GuildAioTitleGuildNameTextUIState.a();
                    Intrinsics.checkNotNullExpressionValue(iconState, "iconState");
                    guildAioTitleViewModel.updateUI(aVar.d(iconState).c(x16).b(GuildAioTitleViewModel.this.needHideGuest).getState());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/title/GuildAioTitleViewModel$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildAioTitleViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/title/GuildAioTitleViewModel$e", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements com.tencent.mvi.base.route.b {
        e() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildAioTitleViewModel.this.I(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        if (!com.tencent.guild.aio.util.ex.a.o((com.tencent.aio.api.runtime.a) getMContext())) {
            updateUI(new GuildAioTitleUnreadMsgCntUIState());
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildAioTitleViewModel_updateUnreadCnt", null, null, null, new GuildAioTitleViewModel$getUnreadMsgCnt$1(this, null), 14, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B() {
        if (com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            updateUI(new GuildAioTitleBackBtnUIState(false));
            return;
        }
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
        boolean i3 = companion.a().i(dVar);
        if (i3) {
            companion.a().n(dVar, false);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioTitleViewModel", false));
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildAioTitleViewModel", false, 2, null));
        updateUI(new GuildAioTitleBackBtnUIState(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        if (com.tencent.guild.aio.util.ex.a.c((com.tencent.aio.api.runtime.a) getMContext()) == ContainerType.MF_TYPE) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).setCenterPanelInOrOut(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), 0, true);
            return;
        }
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        iQQGuildRouterApi.openGuildChannelDetailFragment(appInterface, activity, g17, com.tencent.guild.aio.util.a.b(g18), w(com.tencent.guild.aio.util.ex.a.c((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            O(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        AppInterface appInterface;
        com.tencent.guild.aio.util.k kVar = com.tencent.guild.aio.util.k.f112410a;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        final JumpGuildParam a16 = kVar.a(g16);
        if (!TextUtils.isEmpty(a16.getJoinInfoParam().getJoinSignature()) && !TextUtils.isEmpty(a16.guildId)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IQQGuildService.class, "");
            }
            IQQGuildService iQQGuildService = (IQQGuildService) iRuntimeService;
            if (iQQGuildService != null) {
                iQQGuildService.addGuild(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), a16, "GuildAioTitleViewModel", new bv() { // from class: com.tencent.guild.aio.title.e
                    @Override // vh2.bv
                    public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                        GuildAioTitleViewModel.G(JumpGuildParam.this, this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("GuildAioTitleViewModel", 1, "join Guild arg error! guildId = ", a16.guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(JumpGuildParam jumpGuildParam, GuildAioTitleViewModel this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "$jumpGuildParam");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GuildAioTitleViewModel", 1, "join guild. guildId = ", jumpGuildParam.guildId, " code=", Integer.valueOf(i3), " msg=", str);
        if (!this$0.M(i3, iGProSecurityResult)) {
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).handleJoinGuildError(((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getActivity(), i3, str, iGProSecurityResult);
            return;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, channelId));
        QLog.i("GuildAioTitleViewModel", 1, "[handleIntent] permissions = " + guildPermissionsChange.getPermissions());
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(guildPermissionsChange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity == null) {
            return;
        }
        int d16 = com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext());
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        INSTANCE.a(activity, com.tencent.guild.aio.util.a.b(g16), d16);
        updateUI(new GuildAioTitleBackBtnUIState(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent i3) {
        if (i3 instanceof GuildAioTitleMsgIntent.GetTitleHeightMsgIntent) {
            return new b.a(z());
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(c.k intent) {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioDefaultTitleViewBinder", intent.getIsMultiple()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProGuildInfo iGProGuildInfo;
        AppInterface appInterface2;
        IRuntimeService iRuntimeService2;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
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
            iGProGuildInfo = iGPSService.getGuildInfo(g17);
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            QLog.e("GuildAioTitleViewModel", 1, "getGuildInfo null\uff01guildId = ", g17);
            return;
        }
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g18);
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService2 = null;
        }
        IGPSService iGPSService2 = (IGPSService) iRuntimeService2;
        if (iGPSService2 != null) {
            iGProChannelInfo = iGPSService2.getChannelInfo(b16);
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openChannelSharePanel(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), iGProGuildInfo, iGProChannelInfo, GuildSharePageSource.CHANNEL_DETAIL_TEXT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        Intent intent;
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        if (System.currentTimeMillis() - this.titleTextViewclickTime < 500) {
            return;
        }
        this.titleTextViewclickTime = System.currentTimeMillis();
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            QRouteApi api = QRoute.api(IQQGuildRouterApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQGuildRouterApi::class.java)");
            IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) api;
            joinInfoParam = iQQGuildRouterApi.getJoinParamFromInAioIntent(intent);
            guildAppReportSourceInfo = iQQGuildRouterApi.getReportSourceInfoFromInAioIntent(intent);
        } else {
            guildAppReportSourceInfo = null;
            joinInfoParam = null;
        }
        if (joinInfoParam == null || !joinInfoParam.isValid()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("join param is not valid");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildAioTitleViewModel", 1, (String) it.next(), null);
            }
            joinInfoParam = (JumpGuildParam.JoinInfoParam) ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getParcelable("GuildAppReportSourceInfo");
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo2 = guildAppReportSourceInfo;
        JumpGuildParam.JoinInfoParam joinInfoParam2 = joinInfoParam;
        IQQGuildRouterApi iQQGuildRouterApi2 = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        FragmentActivity activity2 = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        iQQGuildRouterApi2.openStandaloneFacadeDialog(activity2, g17, com.tencent.guild.aio.util.a.b(g18), joinInfoParam2, guildAppReportSourceInfo2);
    }

    private final boolean M(int errorCode, IGProSecurityResult securityInfo) {
        if (s(securityInfo) && (errorCode == 0 || errorCode == 22004)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildAioTitleUIState N(ar0.a response) {
        if (response instanceof ChannelNameMviResult) {
            return new GuildAioTitleTextUIState.a().b(((ChannelNameMviResult) response).getName()).getState();
        }
        return new GuildAioTitleTextUIState.a().c(false).getState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void O(boolean isMultiSelectMode) {
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOContact aIOContact = this.contact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            aIOContact = null;
        }
        String j3 = aIOContact.j();
        AIOContact aIOContact3 = this.contact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
        } else {
            aIOContact2 = aIOContact3;
        }
        updateUI(new GuildAioTitleMultiSelectUIState.a().e(isMultiSelectMode).c(iGuildChannelApi.isSelfGuest(j3, aIOContact2.f())).d(this.needHideGuest).b(com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())).getState());
    }

    private final boolean s(IGProSecurityResult security) {
        if (security != null && security.get$actionCode() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        O(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
    }

    private final void u(c.TitleBarAvatarIntent intent) {
        uq0.b bVar = this.channelAvatarUseCase;
        AIOContact aIOContact = this.contact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            aIOContact = null;
        }
        bVar.c(new uq0.a(aIOContact, intent.getView()));
    }

    private final void v(c.f intent) {
        ChannelNameUseCase channelNameUseCase = this.channelNameUseCase;
        AIOContact aIOContact = this.contact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            aIOContact = null;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelNameUseCase.e(new com.tencent.guild.aio.usecase.channel.title.a(aIOContact)), new GuildAioTitleViewModel$getChannelTitle$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String x() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProGuildInfo iGProGuildInfo;
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
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            iGProGuildInfo = iGPSService.getGuildInfo(com.tencent.guild.aio.util.a.g(g16));
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            QLog.e("GuildAioTitleViewModel", 1, "getGuildInfo null");
        }
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildName();
        }
        if (str != null) {
            str2 = str;
        }
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        QLog.i("GuildAioTitleViewModel", 1, "getGuildName guildId:" + com.tencent.guild.aio.util.a.g(g17));
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(c.h intent) {
        if (!com.tencent.guild.aio.util.ex.a.n((com.tencent.aio.api.runtime.a) getMContext())) {
            updateUI(new GuildAioTitleGuildNameTextUIState());
            return;
        }
        GuildStateType stateType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getGuildAioSubTitleIconState(com.tencent.guild.aio.util.ex.a.f((com.tencent.aio.api.runtime.a) getMContext()));
        GuildAioTitleGuildNameTextUIState.a aVar = new GuildAioTitleGuildNameTextUIState.a();
        Intrinsics.checkNotNullExpressionValue(stateType, "stateType");
        updateUI(aVar.d(stateType).c(x()).b(this.needHideGuest).getState());
    }

    private final int z() {
        return fetchVBState(new d.b()).b().getInt("guild_aio_title_height");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.title.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.TitleBarAvatarIntent) {
            u((c.TitleBarAvatarIntent) intent);
            return;
        }
        if (intent instanceof c.f) {
            v((c.f) intent);
            return;
        }
        if (intent instanceof c.k) {
            J((c.k) intent);
            return;
        }
        if (intent instanceof c.e) {
            t();
            return;
        }
        if (intent instanceof c.l) {
            B();
            return;
        }
        if (intent instanceof c.a) {
            F();
            return;
        }
        if (intent instanceof c.b) {
            K();
            return;
        }
        if (intent instanceof c.d) {
            C();
            return;
        }
        if (intent instanceof c.h) {
            y((c.h) intent);
            return;
        }
        if (intent instanceof c.m) {
            L();
        } else if (intent instanceof c.g) {
            A();
        } else if (intent instanceof c.i) {
            H();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildAioTitleMsgIntent.GetTitleHeightMsgIntent.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
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
            iGPSService.deleteObserver(this.gpServiceObserver);
        }
        if (com.tencent.guild.aio.util.ex.a.o((com.tencent.aio.api.runtime.a) getMContext())) {
            ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).removeExpandRecentContactListener(this.unreadMsgCntObs);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("GuildAioTitleViewModel", 1, "===aio onPause ========= ");
    }

    public final int w(@NotNull ContainerType containerType) {
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        int i3 = b.f112327a[containerType.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 3;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().j(Reflection.getOrCreateKotlinClass(GuildAioTitleMsgIntent.GetTitleHeightMsgIntent.class).getQualifiedName(), this.mActionR);
        this.contact = context.g().r().c();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        this.needHideGuest = context.g().l().getBoolean("needHideGuestStatus", false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpServiceObserver);
        }
        if (com.tencent.guild.aio.util.ex.a.o((com.tencent.aio.api.runtime.a) getMContext())) {
            ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).addExpandRecentContactListener(this.unreadMsgCntObs);
        }
        GuildAioTitleCheckLoadDataUIState guildAioTitleCheckLoadDataUIState = new GuildAioTitleCheckLoadDataUIState();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        guildAioTitleCheckLoadDataUIState.a(com.tencent.guild.aio.util.a.b(g16));
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        guildAioTitleCheckLoadDataUIState.b(com.tencent.guild.aio.util.a.e(g17));
        updateUI(guildAioTitleCheckLoadDataUIState);
    }
}
