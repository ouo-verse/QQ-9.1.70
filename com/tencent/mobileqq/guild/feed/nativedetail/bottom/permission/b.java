package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.SpeakPermissionInputHandler;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import el1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001c\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart;", "", "W9", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "C9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "J", "Ljava/lang/String;", "troopUin", "K", "guildId", "L", "channelId", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "M", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "mTroopGagObserver", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/b$b", "N", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/b$b;", "speakInputContextProvider", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends SpeakPermissionPart {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopgag.api.b mTroopGagObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final C7752b speakInputContextProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/b$a", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", "gagStatusInfo", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends com.tencent.mobileqq.troop.troopgag.api.b {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.troopgag.api.b
        protected void a(@NotNull com.tencent.mobileqq.troop.troopgag.data.a gagStatusInfo) {
            Intrinsics.checkNotNullParameter(gagStatusInfo, "gagStatusInfo");
            if (gagStatusInfo.f300223c == 2) {
                b.this.W9();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/b$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "getTroopUin", "troopUin", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7752b implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a {
        C7752b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getChannelId() {
            return b.this.channelId;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public Context getContext() {
            Context context = b.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this@TroopSpeakPermissionPart.context");
            return context;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public i getDelegate() {
            return b.this.F9();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getGuildId() {
            return b.this.guildId;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getTroopUin() {
            return b.this.troopUin;
        }
    }

    public b(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
        this.guildId = "";
        this.channelId = "";
        this.mTroopGagObserver = new a();
        this.speakInputContextProvider = new C7752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
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
            iGProGuildInfo = iGPSService.getGuildInfo(this.guildId);
        }
        if (iGProGuildInfo != null) {
            P9(iGProGuildInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart
    @NotNull
    protected SpeakPermissionType C9(@NotNull IGProGuildInfo guildInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        SpeakPermissionType b16 = new el1.a(new a.Companion.Args(this.guildId, this.channelId)).b(guildInfo);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildPermissionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        ITroopGuildPermissionService iTroopGuildPermissionService = (ITroopGuildPermissionService) runtimeService;
        long serverTime = NetConnInfoCenter.getServerTime();
        long muteSelfTime = iTroopGuildPermissionService.getMuteSelfTime(this.troopUin);
        long muteAllTime = iTroopGuildPermissionService.getMuteAllTime(this.troopUin);
        boolean isAdmin = iTroopGuildPermissionService.isAdmin(this.troopUin);
        boolean z17 = true;
        if (muteAllTime != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (muteSelfTime <= serverTime) {
            z17 = false;
        }
        SpeakPermissionType speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED;
        if (b16 != speakPermissionType && b16 != SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED && b16 != SpeakPermissionType.PERMISSION_TYPE_NORMAL && b16 != SpeakPermissionType.PERMISSION_TYPE_MUTED) {
            return b16;
        }
        if (!z16 || isAdmin) {
            if (z17 && !isAdmin) {
                return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
            }
            return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        }
        return speakPermissionType;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart
    @NotNull
    protected SpeakPermissionInputHandler E9() {
        return new SpeakPermissionInputHandler(this.speakInputContextProvider);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        AppInterface appInterface;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(getPartHost());
        String str = "";
        String string = h16.getString("guild_id", "");
        if (string == null) {
            string = "";
        }
        this.guildId = string;
        String string2 = h16.getString("channel_id", "");
        if (string2 != null) {
            str = string2;
        }
        this.channelId = str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.mTroopGagObserver);
        }
        super.onInitView(rootView);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        AppInterface appInterface;
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.mTroopGagObserver);
        }
    }
}
