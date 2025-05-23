package com.tencent.mobileqq.guild.media.thirdapp.container.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001/\u0018\u0000 \u00122\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ4\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u000fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0015J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\fR\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010+R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R0\u00103\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010-\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "code", "", "e", "f", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "g", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, h.F, "j", "k", "l", "", "isVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isForeground", DomainData.DOMAIN_NAME, "isCreated", "o", "webPageId", "url", "p", "a", "Z", "serviceDisConnect", "b", "hasGetAuthCode", "c", "hasGetUserAuth", "d", "hasSendUserAuthCallback", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "mReportTask", "J", "mLastReportTime", "Ljava/util/HashMap;", "mParams", "com/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask$b;", "applicationLifeCallback", "i", "reportEventMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaWebJsReportTask {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean serviceDisConnect;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean hasGetAuthCode;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean hasGetUserAuth;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean hasSendUserAuthCallback;

    /* renamed from: e, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask mReportTask;

    /* renamed from: f, reason: from kotlin metadata */
    private long mLastReportTime = System.currentTimeMillis();

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mParams = new HashMap<>();

    /* renamed from: h */
    @NotNull
    private final b applicationLifeCallback = new b();

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final HashMap<RemoteWebTimeCost, String> reportEventMap;

    public GuildMediaWebJsReportTask() {
        HashMap<RemoteWebTimeCost, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(RemoteWebTimeCost.REMOTE_ACTIVITY_ON_CREATE, "media_web_activity_on_create"), TuplesKt.to(RemoteWebTimeCost.SHOW_PRESENTATION, "media_web_show_presentation"), TuplesKt.to(RemoteWebTimeCost.BEFORE_CREATE_WEB_VIEW, "media_web_before_create_web_view"), TuplesKt.to(RemoteWebTimeCost.CREATE_WEB_VIEW, "media_web_create_web_view"), TuplesKt.to(RemoteWebTimeCost.BEFORE_LOAD_URL, "media_web_before_load_url"));
        this.reportEventMap = hashMapOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(GuildMediaWebJsReportTask guildMediaWebJsReportTask, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = new HashMap();
        }
        guildMediaWebJsReportTask.h(str, hashMap);
    }

    private final int q() {
        if (!this.hasGetAuthCode) {
            return -1;
        }
        if (this.hasGetUserAuth && !this.hasSendUserAuthCallback) {
            return -2;
        }
        if (this.serviceDisConnect) {
            return -3;
        }
        return 0;
    }

    public final void e(long code) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("stage", String.valueOf(code)));
        h("media_web_send_auth_code_callback", hashMapOf);
    }

    public final void f() {
        this.hasGetAuthCode = true;
        i(this, "media_web_get_auth_code", null, 2, null);
    }

    public final void g(@NotNull RemoteWebTimeCost type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String str = this.reportEventMap.get(type);
        if (str == null) {
            return;
        }
        i(this, str, null, 2, null);
    }

    public final void h(@NotNull String eventName, @NotNull HashMap<String, String> extraParams) {
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask duplicate;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "addTaskEvent event: " + eventName);
        if (this.mReportTask == null) {
            logger.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "addTaskEvent ignored. taskKey is empty. return");
            return;
        }
        if (Intrinsics.areEqual(eventName, "media_web_service_disconnection")) {
            this.serviceDisConnect = true;
        }
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        HashMap hashMap = new HashMap();
        hashMap.put("web_process_status", String.valueOf(isProcessRunning));
        hashMap.putAll(extraParams);
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode(eventName);
        } else {
            iPerformanceReportTask = null;
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(this.mParams);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(hashMap);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - this.mLastReportTime);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        this.mLastReportTime = System.currentTimeMillis();
    }

    public final void j(long code) {
        HashMap<String, String> hashMapOf;
        this.hasSendUserAuthCallback = true;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("stage", String.valueOf(code)));
        h("media_web_send_user_auth_callback", hashMapOf);
    }

    public final void k() {
        this.hasGetUserAuth = true;
        i(this, "media_web_get_user_auth", null, 2, null);
    }

    public final void l() {
        HashMap hashMapOf;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask iPerformanceReportTask = null;
        if (this.mReportTask == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("endTask ignored. taskKey is empty. return");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, (String) it.next(), null);
            }
            return;
        }
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        int q16 = q();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("web_process_status", String.valueOf(isProcessRunning)), TuplesKt.to("ret", String.valueOf(q16)));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode("end");
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(this.mParams);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - this.mLastReportTime);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(q16);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "endTask, taskCode[" + q16 + "]hasGetAuthCode[" + this.hasGetAuthCode + "], hasGetUserAuth[" + this.hasGetUserAuth + "], hasSendUserAuthCallback[" + this.hasSendUserAuthCallback + "]");
        GuardManagerCallbackDispatcher.unregisterCallBack(this.applicationLifeCallback);
    }

    public final void m(boolean z16) {
        String str;
        if (z16) {
            str = "media_web_float_window_visible";
        } else {
            str = "media_web_float_window_invisible";
        }
        i(this, str, null, 2, null);
    }

    public final void n(boolean z16) {
        String str;
        if (z16) {
            str = "media_web_qq_foreground";
        } else {
            str = "media_web_qq_background";
        }
        i(this, str, null, 2, null);
    }

    public final void o(boolean isCreated) {
        String str;
        if (isCreated) {
            str = "media_web_app_visible";
        } else {
            str = "media_web_app_invisible";
        }
        i(this, str, null, 2, null);
    }

    public final void p(@NotNull final String webPageId, @NotNull String url) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.mReportTask != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("addTaskEvent ignored. taskKey is not empty. return");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, (String) it.next(), null);
            }
            return;
        }
        GuardManagerCallbackDispatcher.registerCallBack(this.applicationLifeCallback);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guild_id", j.c().r()), TuplesKt.to("channel_id", j.c().e()), TuplesKt.to("url", url), TuplesKt.to(AudienceReportConst.ROOM_ID, webPageId), TuplesKt.to("web_process_status", String.valueOf(QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"))));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask stageCode = Reporters.f231995a.b().a("gpro_quality#event#av_channel_web_js").setStageCode("start");
        this.mReportTask = stageCode;
        if (stageCode != null) {
            stageCode.setExtras(this.mParams);
        }
        IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        this.mLastReportTime = System.currentTimeMillis();
        j.a().d0().x1(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask$startTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String openId) {
                HashMap hashMapOf2;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(openId, "openId");
                if (openId.length() == 0) {
                    return;
                }
                Logger logger2 = Logger.f235387a;
                String str = webPageId;
                logger2.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "[startTask] webPageId " + str + ", getOpenId " + openId);
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("open_id", openId));
                hashMap = GuildMediaWebJsReportTask.this.mParams;
                hashMap.putAll(hashMapOf2);
            }
        });
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "startTask, webPageId=" + webPageId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask$b", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IGuardInterface {
        b() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "onApplicationBackground");
            GuildMediaWebJsReportTask.this.n(false);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "onApplicationForeground");
            GuildMediaWebJsReportTask.this.n(true);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJsReportTask", 1, "[onScreensStateChanged] ");
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }
    }
}
