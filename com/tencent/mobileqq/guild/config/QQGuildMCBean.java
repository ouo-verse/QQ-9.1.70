package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.config.GuildDiscoverBannerConfBean;
import com.tencent.mobileqq.guild.config.GuildSearchConfBean;
import com.tencent.mobileqq.guild.config.TroopJoinGuildBean;
import com.tencent.mobileqq.guild.config.g;
import com.tencent.mobileqq.guild.config.k;
import com.tencent.mobileqq.guild.config.l;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.live.config.GuildLiveReadyTipsConfBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import f12.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0005.\u001fSH\u0006B\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R.\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b\u0006\u00106\"\u0004\b7\u00108R\u0017\u0010?\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010D\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b\u0015\u0010CR\u0017\u0010J\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010O\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\b\u001d\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCBean;", "Lcom/tencent/freesia/IConfigData;", "", "content", "l", "Lcom/tencent/mobileqq/guild/config/i;", "d", "Lcom/tencent/mobileqq/guild/config/i;", "e", "()Lcom/tencent/mobileqq/guild/config/i;", "setGuildDiscoverBannerConfBean", "(Lcom/tencent/mobileqq/guild/config/i;)V", "guildDiscoverBannerConfBean", "Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;", "Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;", "j", "()Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;", "setLiveReadyTipsConfBean", "(Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;)V", "liveReadyTipsConfBean", "Lcom/tencent/mobileqq/guild/config/ab;", "f", "Lcom/tencent/mobileqq/guild/config/ab;", "k", "()Lcom/tencent/mobileqq/guild/config/ab;", "setTroopJumpGuildBean", "(Lcom/tencent/mobileqq/guild/config/ab;)V", "troopJumpGuildBean", "Lcom/tencent/mobileqq/guild/config/g;", tl.h.F, "Lcom/tencent/mobileqq/guild/config/g;", "b", "()Lcom/tencent/mobileqq/guild/config/g;", "setCanGameLiveGuild", "(Lcom/tencent/mobileqq/guild/config/g;)V", "canGameLiveGuild", "Lf12/k;", "i", "Lf12/k;", "()Lf12/k;", "setGuildTjgPerfManageConfig", "(Lf12/k;)V", "guildTjgPerfManageConfig", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setBeanData", "(Ljava/util/Map;)V", "beanData", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$GuildConfigBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$GuildConfigBean;", "()Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$GuildConfigBean;", "setGuildConfigBean", "(Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$GuildConfigBean;)V", "guildConfigBean", "Lcom/tencent/mobileqq/guild/config/l;", "D", "Lcom/tencent/mobileqq/guild/config/l;", "g", "()Lcom/tencent/mobileqq/guild/config/l;", "guildMainWebConfBean", "Lcom/tencent/mobileqq/guild/config/k;", "E", "Lcom/tencent/mobileqq/guild/config/k;", "()Lcom/tencent/mobileqq/guild/config/k;", "guildInviteFriendsConfBean", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "c", "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "guildAISearchBean", "Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "G", "Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "()Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "guildSearchBean", "<init>", "()V", "H", "GuildConfigBean", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class QQGuildMCBean implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildDiscoverBannerConfBean guildDiscoverBannerConfBean = new GuildDiscoverBannerConfBean();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildLiveReadyTipsConfBean liveReadyTipsConfBean = new GuildLiveReadyTipsConfBean();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopJoinGuildBean troopJumpGuildBean = new TroopJoinGuildBean();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g canGameLiveGuild = new g();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f12.k guildTjgPerfManageConfig = new f12.k();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> beanData = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private GuildConfigBean guildConfigBean = new GuildConfigBean();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final l guildMainWebConfBean = new l();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final k guildInviteFriendsConfBean = new k();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildAISearchConfBean guildAISearchBean = new GuildAISearchConfBean();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildSearchConfBean guildSearchBean = new GuildSearchConfBean();

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R2\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R2\u00100\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00103\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u001b\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u0010\u001fR\"\u0010C\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\"\u001a\u0004\bF\u0010$\"\u0004\bG\u0010&R2\u0010H\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010+\u001a\u0004\bI\u0010-\"\u0004\bJ\u0010/\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$GuildConfigBean;", "", "Lorg/json/JSONObject;", "getKaraokeGuildConfig", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$b;", "globalGuildConfig", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$b;", "getGlobalGuildConfig", "()Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$b;", "setGlobalGuildConfig", "(Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$b;)V", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$c;", "guildRobotInline", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$c;", "getGuildRobotInline", "()Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$c;", "setGuildRobotInline", "(Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$c;)V", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$d;", "robotSlashCmd", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$d;", "getRobotSlashCmd", "()Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$d;", "setRobotSlashCmd", "(Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$d;)V", "", "robotHintProbability", "D", "getRobotHintProbability", "()D", "setRobotHintProbability", "(D)V", "", "showRobotButtonInAddPanel", "Z", "getShowRobotButtonInAddPanel", "()Z", "setShowRobotButtonInAddPanel", "(Z)V", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enableRobotRedDotVersion", "Ljava/util/HashSet;", "getEnableRobotRedDotVersion", "()Ljava/util/HashSet;", "setEnableRobotRedDotVersion", "(Ljava/util/HashSet;)V", "showRobotCommandGuildList", "getShowRobotCommandGuildList", "setShowRobotCommandGuildList", "useFadeInOut", "getUseFadeInOut", "setUseFadeInOut", "", "switchInAdvance", "J", "getSwitchInAdvance", "()J", "setSwitchInAdvance", "(J)V", "volumeFadeDur", "getVolumeFadeDur", "setVolumeFadeDur", "bgmPublishScale", "getBgmPublishScale", "setBgmPublishScale", "obbFadeDelay", "getObbFadeDelay", "setObbFadeDelay", "isScheduleFullOpen", "setScheduleFullOpen", "scheduleGuildList", "getScheduleGuildList", "setScheduleGuildList", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GuildConfigBean {
        private boolean isScheduleFullOpen;

        @SerializedName("robotInputHintProbability")
        private double robotHintProbability;
        private boolean showRobotButtonInAddPanel;

        @NotNull
        private b globalGuildConfig = new b();

        @NotNull
        private c guildRobotInline = new c();

        @NotNull
        private d robotSlashCmd = new d();

        @NotNull
        private HashSet<String> enableRobotRedDotVersion = new HashSet<>();

        @SerializedName("QQGProShowCommandGuildList")
        @NotNull
        private HashSet<String> showRobotCommandGuildList = new HashSet<>();
        private boolean useFadeInOut = true;
        private long switchInAdvance = 700;
        private long volumeFadeDur = 700;
        private double bgmPublishScale = 1.4d;
        private long obbFadeDelay = 800;

        @NotNull
        private HashSet<String> scheduleGuildList = new HashSet<>();

        public final double getBgmPublishScale() {
            return this.bgmPublishScale;
        }

        @NotNull
        public final HashSet<String> getEnableRobotRedDotVersion() {
            return this.enableRobotRedDotVersion;
        }

        @NotNull
        public final b getGlobalGuildConfig() {
            return this.globalGuildConfig;
        }

        @NotNull
        public final c getGuildRobotInline() {
            return this.guildRobotInline;
        }

        @NotNull
        public final JSONObject getKaraokeGuildConfig() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("useFadeInOut", this.useFadeInOut);
            jSONObject.put("switchInAdvance", this.switchInAdvance);
            jSONObject.put("volumeFadeDur", this.volumeFadeDur);
            jSONObject.put("bgmPublishScale", this.bgmPublishScale);
            jSONObject.put("obbFadeDelay", this.obbFadeDelay);
            return jSONObject;
        }

        public final long getObbFadeDelay() {
            return this.obbFadeDelay;
        }

        public final double getRobotHintProbability() {
            return this.robotHintProbability;
        }

        @NotNull
        public final d getRobotSlashCmd() {
            return this.robotSlashCmd;
        }

        @NotNull
        public final HashSet<String> getScheduleGuildList() {
            return this.scheduleGuildList;
        }

        public final boolean getShowRobotButtonInAddPanel() {
            return this.showRobotButtonInAddPanel;
        }

        @NotNull
        public final HashSet<String> getShowRobotCommandGuildList() {
            return this.showRobotCommandGuildList;
        }

        public final long getSwitchInAdvance() {
            return this.switchInAdvance;
        }

        public final boolean getUseFadeInOut() {
            return this.useFadeInOut;
        }

        public final long getVolumeFadeDur() {
            return this.volumeFadeDur;
        }

        /* renamed from: isScheduleFullOpen, reason: from getter */
        public final boolean getIsScheduleFullOpen() {
            return this.isScheduleFullOpen;
        }

        public final void setBgmPublishScale(double d16) {
            this.bgmPublishScale = d16;
        }

        public final void setEnableRobotRedDotVersion(@NotNull HashSet<String> hashSet) {
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            this.enableRobotRedDotVersion = hashSet;
        }

        public final void setGlobalGuildConfig(@NotNull b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.globalGuildConfig = bVar;
        }

        public final void setGuildRobotInline(@NotNull c cVar) {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.guildRobotInline = cVar;
        }

        public final void setObbFadeDelay(long j3) {
            this.obbFadeDelay = j3;
        }

        public final void setRobotHintProbability(double d16) {
            this.robotHintProbability = d16;
        }

        public final void setRobotSlashCmd(@NotNull d dVar) {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.robotSlashCmd = dVar;
        }

        public final void setScheduleFullOpen(boolean z16) {
            this.isScheduleFullOpen = z16;
        }

        public final void setScheduleGuildList(@NotNull HashSet<String> hashSet) {
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            this.scheduleGuildList = hashSet;
        }

        public final void setShowRobotButtonInAddPanel(boolean z16) {
            this.showRobotButtonInAddPanel = z16;
        }

        public final void setShowRobotCommandGuildList(@NotNull HashSet<String> hashSet) {
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            this.showRobotCommandGuildList = hashSet;
        }

        public final void setSwitchInAdvance(long j3) {
            this.switchInAdvance = j3;
        }

        public final void setUseFadeInOut(boolean z16) {
            this.useFadeInOut = z16;
        }

        public final void setVolumeFadeDur(long j3) {
            this.volumeFadeDur = j3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$b;", "", "", "guildOpenCreateIntroUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setGuildOpenCreateIntroUrl", "(Ljava/lang/String;)V", "a", "setGuildCreateUrl", "guildCreateUrl", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        @SerializedName("guild_open_create_url")
        @NotNull
        private String guildOpenCreateIntroUrl = "https://qun.qq.com/h5/group-create?_wv=16777216&_cwv=1";

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String guildCreateUrl = "https://qun.qq.com/qqweb/qunpro/create?_wv=3&_wwv=132";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildCreateUrl() {
            return this.guildCreateUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildOpenCreateIntroUrl() {
            return this.guildOpenCreateIntroUrl;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$c;", "", "", "enableRobotInline", "I", "a", "()I", "setEnableRobotInline", "(I)V", "", "robotInlineCacheDuration", "J", "b", "()J", "setRobotInlineCacheDuration", "(J)V", "robotInlineRequestTimeout", "c", "setRobotInlineRequestTimeout", "robotInlineTypeTimeout", "d", "setRobotInlineTypeTimeout", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c {

        @SerializedName("isInlineBotOpen")
        private int enableRobotInline;

        @SerializedName("cacheDuration")
        private long robotInlineCacheDuration;

        @SerializedName("requestTimeout")
        private int robotInlineRequestTimeout;

        @SerializedName("typeTimeout")
        private int robotInlineTypeTimeout;

        /* renamed from: a, reason: from getter */
        public final int getEnableRobotInline() {
            return this.enableRobotInline;
        }

        /* renamed from: b, reason: from getter */
        public final long getRobotInlineCacheDuration() {
            return this.robotInlineCacheDuration;
        }

        /* renamed from: c, reason: from getter */
        public final int getRobotInlineRequestTimeout() {
            return this.robotInlineRequestTimeout;
        }

        /* renamed from: d, reason: from getter */
        public final int getRobotInlineTypeTimeout() {
            return this.robotInlineTypeTimeout;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0013\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCBean$d;", "", "", "a", "I", "e", "()I", "setSupportSlash", "(I)V", "isSupportSlash", "b", "d", "setRobotSlashCmdCacheDuration", "robotSlashCmdCacheDuration", "c", "setRobotSlashCmdCacheCapacity", "robotSlashCmdCacheCapacity", "setRobotCmdSortRobotLimit", "robotCmdSortRobotLimit", "setRobotCmdSortGuildLimit", "robotCmdSortGuildLimit", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int isSupportSlash = 1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int robotSlashCmdCacheDuration = 300000;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int robotSlashCmdCacheCapacity = 20;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int robotCmdSortRobotLimit = 3;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int robotCmdSortGuildLimit = 10;

        /* renamed from: a, reason: from getter */
        public final int getRobotCmdSortGuildLimit() {
            return this.robotCmdSortGuildLimit;
        }

        /* renamed from: b, reason: from getter */
        public final int getRobotCmdSortRobotLimit() {
            return this.robotCmdSortRobotLimit;
        }

        /* renamed from: c, reason: from getter */
        public final int getRobotSlashCmdCacheCapacity() {
            return this.robotSlashCmdCacheCapacity;
        }

        /* renamed from: d, reason: from getter */
        public final int getRobotSlashCmdCacheDuration() {
            return this.robotSlashCmdCacheDuration;
        }

        /* renamed from: e, reason: from getter */
        public final int getIsSupportSlash() {
            return this.isSupportSlash;
        }
    }

    @NotNull
    public final Map<String, String> a() {
        return this.beanData;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final g getCanGameLiveGuild() {
        return this.canGameLiveGuild;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildAISearchConfBean getGuildAISearchBean() {
        return this.guildAISearchBean;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GuildConfigBean getGuildConfigBean() {
        return this.guildConfigBean;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GuildDiscoverBannerConfBean getGuildDiscoverBannerConfBean() {
        return this.guildDiscoverBannerConfBean;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final k getGuildInviteFriendsConfBean() {
        return this.guildInviteFriendsConfBean;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final l getGuildMainWebConfBean() {
        return this.guildMainWebConfBean;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final GuildSearchConfBean getGuildSearchBean() {
        return this.guildSearchBean;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final f12.k getGuildTjgPerfManageConfig() {
        return this.guildTjgPerfManageConfig;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final GuildLiveReadyTipsConfBean getLiveReadyTipsConfBean() {
        return this.liveReadyTipsConfBean;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final TroopJoinGuildBean getTroopJumpGuildBean() {
        return this.troopJumpGuildBean;
    }

    @NotNull
    public final QQGuildMCBean l(@Nullable String content) {
        boolean z16;
        QQGuildMCBean qQGuildMCBean = new QQGuildMCBean();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new QQGuildMCBean();
        }
        JSONObject jSONObject = new JSONObject(content);
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildMCParser.QQGuildMCBean", 2, "content parse jsonObj= ", jSONObject);
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str.toString());
            if (QLog.isColorLevel()) {
                QLog.d("QQGuildMCParser.QQGuildMCBean", 2, "content parse json key-value = ", str + "--" + opt);
            }
            if (opt != null) {
                qQGuildMCBean.beanData.put(str, opt.toString());
            }
        }
        try {
            Object fromJson = new Gson().fromJson(content, (Class<Object>) GuildConfigBean.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(content,\u2026ldConfigBean::class.java)");
            qQGuildMCBean.guildConfigBean = (GuildConfigBean) fromJson;
        } catch (Exception e16) {
            QLog.d("QQGuildMCParser.QQGuildMCBean", 2, "json\u8f6cGuildConfigBean\u5f02\u5e38", e16.getMessage());
        }
        GuildDiscoverBannerConfBean.Companion companion = GuildDiscoverBannerConfBean.INSTANCE;
        if (companion.a(jSONObject)) {
            companion.b(qQGuildMCBean.guildDiscoverBannerConfBean, jSONObject);
        }
        GuildLiveReadyTipsConfBean.Companion companion2 = GuildLiveReadyTipsConfBean.INSTANCE;
        if (companion2.a(jSONObject)) {
            companion2.c(qQGuildMCBean.liveReadyTipsConfBean, jSONObject);
        }
        k.Companion companion3 = f12.k.INSTANCE;
        if (companion3.e(jSONObject)) {
            companion3.f(qQGuildMCBean.guildTjgPerfManageConfig, jSONObject);
        }
        TroopJoinGuildBean.Companion companion4 = TroopJoinGuildBean.INSTANCE;
        if (companion4.a(jSONObject)) {
            companion4.b(qQGuildMCBean.troopJumpGuildBean, jSONObject);
        }
        ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).parseConfig(jSONObject);
        g.Companion companion5 = g.INSTANCE;
        if (companion5.c(jSONObject)) {
            companion5.d(qQGuildMCBean.canGameLiveGuild, jSONObject);
        }
        l.Companion companion6 = l.INSTANCE;
        if (companion6.a(jSONObject)) {
            companion6.b(qQGuildMCBean.guildMainWebConfBean, jSONObject);
        }
        k.Companion companion7 = k.INSTANCE;
        if (companion7.a(jSONObject)) {
            companion7.b(qQGuildMCBean.guildInviteFriendsConfBean, jSONObject);
        }
        GuildAISearchConfBean.Companion companion8 = GuildAISearchConfBean.INSTANCE;
        if (companion8.b(jSONObject)) {
            companion8.c(qQGuildMCBean.guildAISearchBean, jSONObject);
        }
        GuildSearchConfBean.Companion companion9 = GuildSearchConfBean.INSTANCE;
        if (companion9.b(jSONObject)) {
            companion9.c(qQGuildMCBean.guildSearchBean, jSONObject);
        }
        return qQGuildMCBean;
    }
}
