package com.tencent.mobileqq.guild.media.thirdapp.container.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.ba;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.hitrate.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001,\u0018\u0000 \u00062\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007JH\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162$\b\u0002\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0019R\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/a;", "", "", "isMiniApp", "", "j", "i", "", "l", "k", h.F, "", "retCode", "g", "o", DomainData.DOMAIN_NAME, "url", "loadResCost", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "f", AdMetricTag.EVENT_NAME, "", "costTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "d", "a", "J", "webViewLoadStartTime", "b", "getAuthCodeStartTime", "c", "pullAuthPanelStartTime", "Z", "isX5CorePreload", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "e", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "mReportTask", "mLastReportTime", "Ljava/util/HashMap;", "mParams", "com/tencent/mobileqq/guild/media/thirdapp/container/report/a$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/a$b;", "appPageLoadReportEvent", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long webViewLoadStartTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long getAuthCodeStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long pullAuthPanelStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isX5CorePreload;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask mReportTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mLastReportTime = System.currentTimeMillis();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mParams = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b appPageLoadReportEvent = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/report/a$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ba;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<ba> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ba event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("GuildMediaThirdAppLoadReportTask", 1, "[ThirdAppPageLoadReportEvent.onEventReceive] " + event.getDomReadyTime() + ", " + event.getDomReadyTime() + ", " + event.getPageLoadedTime());
            long webViewFinishTime = event.getWebViewFinishTime();
            long domReadyTime = event.getDomReadyTime();
            long pageLoadedTime = event.getPageLoadedTime();
            boolean isMiniApp = event.getIsMiniApp();
            if (webViewFinishTime <= 0 && domReadyTime <= 0 && pageLoadedTime <= 0) {
                return;
            }
            a.e(a.this, "guild_lobby_h5_did_ready", 0L, webViewFinishTime - r9.webViewLoadStartTime, null, 8, null);
            a aVar = a.this;
            a.e(aVar, aVar.j(isMiniApp), 0L, domReadyTime - a.this.webViewLoadStartTime, null, 8, null);
            a aVar2 = a.this;
            a.e(aVar2, aVar2.i(isMiniApp), 0L, pageLoadedTime - a.this.webViewLoadStartTime, null, 8, null);
        }
    }

    public static /* synthetic */ void e(a aVar, String str, long j3, double d16, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i3 & 4) != 0) {
            d16 = 0.0d;
        }
        double d17 = d16;
        if ((i3 & 8) != 0) {
            hashMap = new HashMap();
        }
        aVar.d(str, j16, d17, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(boolean isMiniApp) {
        if (isMiniApp) {
            return "guild_lobby_mini_app_compete_rendering";
        }
        return "guild_lobby_h5_compete_rendering";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(boolean isMiniApp) {
        if (isMiniApp) {
            return "guild_lobby_mini_app_start_rendering";
        }
        return "guild_lobby_h5_start_rendering";
    }

    public final void d(@NotNull String eventName, long retCode, double costTime, @NotNull HashMap<String, String> extraParams) {
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        IPerformanceReportTask timeCost;
        IPerformanceReportTask extras;
        IPerformanceReportTask extras2;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (costTime <= 0.0d) {
            QLog.e("GuildMediaThirdAppLoadReportTask", 1, "addTaskEvent costTime invalid, eventName: " + eventName + ", " + costTime);
            return;
        }
        IGProLobbyAppInfo thirdAppInfo = j.a().d0().getThirdAppInfo();
        IGProLobbyStateInfo lobbyRoomInfo = j.a().d0().getLobbyRoomInfo();
        if (thirdAppInfo != null && lobbyRoomInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("app", "group_pro_open");
            hashMap.put("server", "lobbies");
            if (!extraParams.isEmpty()) {
                hashMap.putAll(extraParams);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(hashMap);
            hashMap2.put("tags.guild_id", j.a().getGuildID());
            hashMap2.put("tags.channel_id", j.a().E());
            String str = j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "getDataHub().selfUserInfo.id");
            hashMap2.put("tags.uin", str);
            hashMap2.put("tags.lobby_id", String.valueOf(lobbyRoomInfo.getLobbyId()));
            HashMap hashMap3 = new HashMap();
            hashMap3.putAll(hashMap);
            String appId = thirdAppInfo.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "thirdAppInfo.appId");
            hashMap3.put("tags.app_id", appId);
            hashMap3.put("tags.app_version", MediaChannelUtils.f228046a.g());
            HashMap hashMap4 = new HashMap();
            hashMap4.putAll(hashMap);
            hashMap4.put("tags.ret_code", String.valueOf(retCode));
            hashMap2.putAll(hashMap3);
            hashMap2.putAll(hashMap4);
            IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
            if (iPerformanceReportTask != null && (duplicate = iPerformanceReportTask.duplicate(new String[0])) != null && (stageCode = duplicate.setStageCode(eventName)) != null && (timeCost = stageCode.setTimeCost(System.currentTimeMillis() - this.mLastReportTime)) != null && (extras = timeCost.setExtras(this.mParams)) != null && (extras2 = extras.setExtras(hashMap2)) != null) {
                extras2.report();
            }
            this.mLastReportTime = System.currentTimeMillis();
            QLog.d("GuildMediaThirdAppLoadReportTask", 1, "addTaskEvent, eventName: " + eventName + ", " + hashMap2);
            return;
        }
        QLog.d("GuildMediaThirdAppLoadReportTask", 1, "thirdAppInfo or lobbyInfo is empty");
    }

    public final void f() {
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        IPerformanceReportTask timeCost;
        if (this.mReportTask == null) {
            QLog.e("GuildMediaThirdAppLoadReportTask", 1, "endTask ignored. taskKey is empty. return");
            return;
        }
        j.d().j(ba.class, this.appPageLoadReportEvent);
        IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
        if (iPerformanceReportTask != null && (duplicate = iPerformanceReportTask.duplicate(new String[0])) != null && (stageCode = duplicate.setStageCode("end")) != null && (timeCost = stageCode.setTimeCost(System.currentTimeMillis() - this.mLastReportTime)) != null) {
            timeCost.report();
        }
        QLog.d("GuildMediaThirdAppLoadReportTask", 1, "endTask");
    }

    public final void g(long retCode) {
        e(this, "guild_lobby_get_auth_code", retCode, System.currentTimeMillis() - this.getAuthCodeStartTime, null, 8, null);
    }

    public final void h() {
        this.getAuthCodeStartTime = System.currentTimeMillis();
    }

    public final void k() {
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.webViewLoadStartTime;
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.isX5CorePreload) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("tags.x5_core_loaded", str);
        d("guild_lobby_pull_up_webview", 0L, currentTimeMillis, hashMap);
    }

    public final void l() {
        this.webViewLoadStartTime = System.currentTimeMillis();
        this.isX5CorePreload = d.e("com.tencent.mobileqq:tool");
    }

    public final void m(@NotNull String url, long loadResCost) {
        boolean isBlank;
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(url, "url");
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (!isBlank && loadResCost > 0 && loadResCost < 60000) {
            Logger.f235387a.d().d("GuildMediaThirdAppLoadReportTask", 1, "notifyOfflineResCompleted " + url + ", loadResCost " + loadResCost);
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("tags.h5_offline_url", url));
            d("media_guild_web_use_offline", 0L, (double) loadResCost, hashMapOf);
        }
    }

    public final void n(long retCode) {
        e(this, "guild_lobby_pull_up_user_auth_panel", retCode, System.currentTimeMillis() - this.pullAuthPanelStartTime, null, 8, null);
    }

    public final void o() {
        this.pullAuthPanelStartTime = System.currentTimeMillis();
    }

    public final void p() {
        if (this.mReportTask != null) {
            QLog.e("GuildMediaThirdAppLoadReportTask", 1, "startTask ignored. taskKey is not empty. return");
            return;
        }
        j.d().V(ba.class, this.appPageLoadReportEvent);
        IPerformanceReportTask stageCode = Reporters.f231995a.b().a("gpro_quality#event#av_channel_third_app_load").setStageCode("start");
        this.mReportTask = stageCode;
        if (stageCode != null) {
            stageCode.report();
        }
        this.mLastReportTime = System.currentTimeMillis();
        QLog.d("GuildMediaThirdAppLoadReportTask", 1, "startTask");
    }
}
