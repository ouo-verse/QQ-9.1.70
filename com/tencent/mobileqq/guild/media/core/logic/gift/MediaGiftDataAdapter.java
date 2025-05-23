package com.tencent.mobileqq.guild.media.core.logic.gift;

import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010$\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftDataAdapter;", "Lcom/tencent/mobileqq/guild/gift/module/e;", "", "g", "", "giftId", "", "receiver", "Lcom/tencent/mobileqq/qqgift/data/service/c;", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "c", "", "a", "Lmqq/app/AppRuntime;", "Lmqq/app/AppRuntime;", "d", "()Lmqq/app/AppRuntime;", "appRuntime", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "avatarApi", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "f", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "<init>", "(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaGiftDataAdapter implements com.tencent.mobileqq.guild.gift.module.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy igpsService;

    public MediaGiftDataAdapter(@NotNull AppRuntime appRuntime, @NotNull String guildId, @NotNull String channelId) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.appRuntime = appRuntime;
        this.guildId = guildId;
        this.channelId = channelId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQGuildAvatarApi>() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftDataAdapter$avatarApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQGuildAvatarApi invoke() {
                return (IQQGuildAvatarApi) MediaGiftDataAdapter.this.getAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "");
            }
        });
        this.avatarApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftDataAdapter$igpsService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.R0(IGPSService.class);
            }
        });
        this.igpsService = lazy2;
    }

    private final IQQGuildAvatarApi e() {
        return (IQQGuildAvatarApi) this.avatarApi.getValue();
    }

    private final IGPSService f() {
        return (IGPSService) this.igpsService.getValue();
    }

    private final String g() {
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        return f16;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.e
    public boolean a(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.f264924o == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.e
    @Nullable
    public com.tencent.mobileqq.qqgift.data.service.c b(int giftId, long receiver) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(g());
        if (longOrNull == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("generateSelfSendReqData, selfTinyId is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            return null;
        }
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        cVar.f264860a = longOrNull.longValue();
        cVar.f264861b = receiver;
        ConcurrentHashMap<String, String> extData = cVar.f264870k;
        Intrinsics.checkNotNullExpressionValue(extData, "extData");
        extData.put("channelID", this.channelId);
        ConcurrentHashMap<String, String> extData2 = cVar.f264870k;
        Intrinsics.checkNotNullExpressionValue(extData2, "extData");
        extData2.put("guildID", this.guildId);
        return cVar;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.e
    @Nullable
    public com.tencent.mobileqq.qqgift.mvvm.business.anim.a c(@NotNull com.tencent.mobileqq.qqgift.data.service.d data) {
        Long longOrNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(g());
        String str = null;
        boolean z17 = true;
        if (longOrNull == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("generateAfterSelfSendGiftAnimData, selfTinyId is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            return null;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar.f264931v = true;
        aVar.f264910a = data.f264874d;
        aVar.f264913d = data.f264876e;
        aVar.f264914e = data.C;
        aVar.f264924o = data.f264883i;
        aVar.f264912c = data.f264878f;
        aVar.f264915f = data.D;
        aVar.f264911b = data.f264881h;
        aVar.f264925p = data.H;
        aVar.f264926q = data.J;
        aVar.f264918i = longOrNull.longValue();
        aVar.f264920k = data.K;
        String str2 = j.c().getSelfUserInfo().f228094b;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = f().getGuildUserDisplayNameInternal(this.guildId, longOrNull.toString());
        }
        aVar.f264919j = str2;
        aVar.f264922m = e().getAvatarUrl(this.appRuntime, this.guildId, longOrNull.toString());
        p g16 = j.c().getUserInfoList().g(String.valueOf(aVar.f264920k));
        if (g16 != null) {
            str = g16.f228094b;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MediaChannel.getDataHub(\u2026r.toString())?.name ?: \"\"");
        }
        if (str.length() != 0) {
            z17 = false;
        }
        if (z17) {
            str = f().getGuildUserDisplayNameInternal(this.guildId, String.valueOf(aVar.f264920k));
            Intrinsics.checkNotNullExpressionValue(str, "igpsService.getGuildUser\u2026dId, receiver.toString())");
        }
        aVar.f264921l = str;
        aVar.f264923n = e().getAvatarUrl(this.appRuntime, this.guildId, String.valueOf(aVar.f264920k));
        return aVar;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final AppRuntime getAppRuntime() {
        return this.appRuntime;
    }
}
