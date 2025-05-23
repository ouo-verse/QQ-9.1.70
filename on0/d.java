package on0;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.title.GuildArticleTitleEvent;
import com.tencent.guild.aio.article.title.userinfo.GuildArticleTitleUserInfoUIState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import on0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\b\u0007*\u0002\u001d$\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lon0/d;", "Lcom/tencent/aio/base/mvvm/b;", "Lon0/a;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "p", "", "visibility", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "o", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "t", "r", "u", ReportConstant.COSTREPORT_PREFIX, "intent", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "on0/d$b", "d", "Lon0/d$b;", "mAction", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mMainMsgRecord", "on0/d$a", "f", "Lon0/d$a;", "gpsObserver", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.b<on0.a, GuildArticleTitleUserInfoUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mMainMsgRecord;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a gpsObserver = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"on0/d$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            AppInterface appInterface;
            try {
                MsgRecord msgRecord = d.this.mMainMsgRecord;
                if (msgRecord != null) {
                    d dVar = d.this;
                    if (Intrinsics.areEqual(msgRecord.guildId, guildId) && Intrinsics.areEqual(msgRecord.senderUid, tinyId)) {
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
                            dVar.t(iGPSService, msgRecord);
                        }
                    }
                }
            } catch (Exception unused) {
                QLog.e(FrameworkVM.TAG, 1, "onMemberTopRoleChanged error! guildId = " + guildId + " tinyId = " + tinyId);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            AppInterface appInterface;
            try {
                MsgRecord msgRecord = d.this.mMainMsgRecord;
                if (msgRecord != null) {
                    d dVar = d.this;
                    if (Intrinsics.areEqual(msgRecord.senderUid, tinyId)) {
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
                            dVar.t(iGPSService, msgRecord);
                        }
                    }
                }
            } catch (Exception unused) {
                QLog.e(FrameworkVM.TAG, 1, "onUserDisplayNameUpdate error! tinyId = " + tinyId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"on0/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgRecordInitCompleted) {
            GuildArticleMsgListEvent.MainMsgRecordInitCompleted mainMsgRecordInitCompleted = (GuildArticleMsgListEvent.MainMsgRecordInitCompleted) i3;
            o(mainMsgRecordInitCompleted.getIsSuccess(), mainMsgRecordInitCompleted.getMsgRecord());
        } else if (i3 instanceof GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent) {
            q(((GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent) i3).getVisibility());
        }
    }

    private final void o(boolean isSuccess, MsgRecord msgRecord) {
        AppInterface appInterface;
        if (isSuccess && msgRecord != null) {
            this.mMainMsgRecord = msgRecord;
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
                t(iGPSService, msgRecord);
                r(msgRecord);
                u(msgRecord);
                s(iGPSService, msgRecord);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null) {
            IGuildUtilApi iGuildUtilApi = (IGuildUtilApi) QRoute.api(IGuildUtilApi.class);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            iGuildUtilApi.openNormalUrl(context, ig1.a.b(g17, com.tencent.guild.aio.util.a.b(g18)));
        }
    }

    private final void q(int visibility) {
        updateUI(new GuildArticleTitleUserInfoUIState.LayoutVisibilityUIState(visibility));
    }

    private final void r(MsgRecord msgRecord) {
        String str = msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
        String str2 = msgRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.guildId");
        updateUI(new GuildArticleTitleUserInfoUIState.UserAvatarUIState(str, str2));
    }

    private final void s(IGPSService service, MsgRecord msgRecord) {
        IGProClientIdentityInfo guildMemberClientIdentity;
        IGProGuildInfo guildInfo = service.getGuildInfo(msgRecord.guildId);
        if (guildInfo != null && (guildMemberClientIdentity = service.getGuildMemberClientIdentity(msgRecord.guildId, guildInfo.getClientId(), msgRecord.senderUid)) != null) {
            updateUI(new GuildArticleTitleUserInfoUIState.UserIdentityIdUIState(guildMemberClientIdentity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(IGPSService service, MsgRecord msgRecord) {
        String guildUserDisplayName = service.getGuildUserDisplayName(msgRecord.guildId, msgRecord.senderUid);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "service.getGuildUserDisp\u2026dId, msgRecord.senderUid)");
        updateUI(new GuildArticleTitleUserInfoUIState.UserNickNameUIState(guildUserDisplayName, h.j(h.f112401a, new GuildMsgItem(msgRecord), 0L, 2, null)));
    }

    private final void u(MsgRecord msgRecord) {
        updateUI(new GuildArticleTitleUserInfoUIState.UserPublishTimeUIState(msgRecord.msgTime));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull on0.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10928a) {
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent.class).getQualifiedName(), this.mAction);
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
            iGPSService.deleteObserver(this.gpsObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent.class).getQualifiedName(), this.mAction);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpsObserver);
        }
    }
}
