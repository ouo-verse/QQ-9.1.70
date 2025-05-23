package mo1;

import com.tencent.mobileqq.guild.gift.impl.module.AnimationPlayModule;
import com.tencent.mobileqq.guild.gift.impl.module.h;
import com.tencent.mobileqq.guild.gift.module.f;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.n;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lo1.GuildGiftConfig;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$\u00a8\u0006'"}, d2 = {"Lmo1/c;", "Llo1/c;", "Lcom/tencent/mobileqq/guild/gift/module/n;", "Lmqq/app/AppRuntime;", "appRuntime", "Llo1/b;", DownloadInfo.spKey_Config, "", "a", "destroy", "Lcom/tencent/mobileqq/guild/gift/module/b;", "c", "Lcom/tencent/mobileqq/guild/gift/module/f;", "d", "Lcom/tencent/mobileqq/guild/gift/module/h;", "e", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "originalData", "", "isSelfSend", QZoneJsConstants.METHOD_PLAY, "b", "Lcom/tencent/mobileqq/guild/gift/impl/module/h;", "Lcom/tencent/mobileqq/guild/gift/impl/module/h;", "giftResourceModule", "Lcom/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule;", "Lcom/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule;", "animationPlayModule", "Lcom/tencent/mobileqq/guild/gift/impl/module/c;", "Lcom/tencent/mobileqq/guild/gift/impl/module/c;", "giftPanelModule", "Lmo1/b;", "Lmo1/b;", "eventBus", "Llo1/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements lo1.c, n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h giftResourceModule = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnimationPlayModule animationPlayModule = new AnimationPlayModule();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.gift.impl.module.c giftPanelModule = new com.tencent.mobileqq.guild.gift.impl.module.c();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b eventBus = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildGiftConfig config;

    @Override // lo1.c
    public void a(@NotNull AppRuntime appRuntime, @NotNull GuildGiftConfig config) {
        boolean z16;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(config, "config");
        nh2.c giftSDK = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(config.getSceneId());
        if (giftSDK.isInited()) {
            Logger.f235387a.d().w("IGuildGiftEngine.", 1, "giftSDK isInited, ignore.");
            return;
        }
        this.config = config;
        com.tencent.mobileqq.qqgift.sdk.config.a b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().d(config.getSceneId()).a(config.getSecretKey()).b();
        if (config.getChannelId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channel_id", config.getChannelId()));
            b16.f264980i = hashMapOf;
        }
        giftSDK.c(appRuntime, b16);
        h hVar = this.giftResourceModule;
        Intrinsics.checkNotNullExpressionValue(giftSDK, "giftSDK");
        hVar.m(giftSDK, config, this.eventBus);
        this.animationPlayModule.m(giftSDK, config, this.eventBus);
        this.giftPanelModule.m(giftSDK, config, this.eventBus);
        com.tencent.mobileqq.guild.gift.module.c receivePushModule = config.getReceivePushModule();
        if (receivePushModule != null) {
            receivePushModule.a(this);
        }
        Logger.f235387a.d().i("IGuildGiftEngine.", 1, "GuildMediaGiftEngine " + config.getSceneId() + " init complete.");
    }

    @Override // com.tencent.mobileqq.guild.gift.module.n
    public void b(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull Object originalData, boolean isSelfSend, boolean playAnimation) {
        k<Object> g16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        Logger.f235387a.d().i("IGuildGiftEngine.", 1, "onReceiveGiftPush. playAnimation:" + playAnimation + ", send:" + data);
        if (playAnimation) {
            this.animationPlayModule.r(data);
        }
        GuildGiftConfig guildGiftConfig = this.config;
        if (guildGiftConfig != null && (g16 = guildGiftConfig.g()) != null) {
            g16.I(data, originalData);
        }
    }

    @Override // lo1.c
    @NotNull
    public com.tencent.mobileqq.guild.gift.module.b c() {
        return this.animationPlayModule;
    }

    @Override // lo1.c
    @NotNull
    public f d() {
        return this.giftPanelModule;
    }

    @Override // lo1.c
    public void destroy() {
        Integer num;
        com.tencent.mobileqq.guild.gift.module.c receivePushModule;
        GuildGiftConfig guildGiftConfig = this.config;
        if (guildGiftConfig != null) {
            num = Integer.valueOf(guildGiftConfig.getSceneId());
        } else {
            num = null;
        }
        this.giftResourceModule.j();
        this.animationPlayModule.j();
        this.giftPanelModule.j();
        GuildGiftConfig guildGiftConfig2 = this.config;
        if (guildGiftConfig2 != null && (receivePushModule = guildGiftConfig2.getReceivePushModule()) != null) {
            receivePushModule.destroy();
        }
        if (num != null) {
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).destroySDKImpl(num.intValue());
        }
        this.config = null;
        Logger.f235387a.d().i("IGuildGiftEngine.", 1, "GuildMediaGiftEngine " + num + " destroy complete.");
    }

    @Override // lo1.c
    @NotNull
    public com.tencent.mobileqq.guild.gift.module.h e() {
        return this.giftResourceModule;
    }
}
