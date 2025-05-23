package com.tencent.mobileqq.guild.live.livemanager.gift;

import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001e\u001a\n \u0016*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/gift/LiveGiftDataAdapter;", "Lcom/tencent/mobileqq/guild/gift/module/e;", "", "f", "", "giftId", "", "receiver", "Lcom/tencent/mobileqq/qqgift/data/service/c;", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "c", "", "a", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "getCore", "()Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "avatarApi", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveGiftDataAdapter implements com.tencent.mobileqq.guild.gift.module.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy igpsService;

    public LiveGiftDataAdapter(@NotNull GLiveChannelCore core) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQGuildAvatarApi>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.LiveGiftDataAdapter$avatarApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IQQGuildAvatarApi invoke() {
                return (IQQGuildAvatarApi) ch.R0(IQQGuildAvatarApi.class);
            }
        });
        this.avatarApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.LiveGiftDataAdapter$igpsService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.R0(IGPSService.class);
            }
        });
        this.igpsService = lazy2;
    }

    private final IQQGuildAvatarApi d() {
        return (IQQGuildAvatarApi) this.avatarApi.getValue();
    }

    private final IGPSService e() {
        return (IGPSService) this.igpsService.getValue();
    }

    private final String f() {
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
        long c16 = this.core.p().c();
        if (c16 <= 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "generateSelfSendReqData, selfUid is " + c16 + "!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            return null;
        }
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        cVar.f264860a = c16;
        cVar.f264861b = receiver;
        return cVar;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.e
    @Nullable
    public com.tencent.mobileqq.qqgift.mvvm.business.anim.a c(@NotNull com.tencent.mobileqq.qqgift.data.service.d data) {
        Long longOrNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        String guildId = this.core.s().getGuildId();
        long c16 = this.core.p().c();
        if (c16 > 0) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(f());
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
            String anchorTinyId = this.core.s().getAnchorTinyId();
            if (anchorTinyId != null && anchorTinyId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("generateAfterSelfSendGiftAnimData, receiverTinyId is null!!!");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it5.next(), null);
                }
                return null;
            }
            AppRuntime m3 = ch.m();
            Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
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
            aVar.f264918i = c16;
            aVar.f264920k = data.K;
            aVar.f264919j = e().getGuildUserDisplayName(guildId, longOrNull.toString());
            aVar.f264922m = d().getAvatarUrl(m3, guildId, longOrNull.toString());
            aVar.f264921l = e().getGuildUserDisplayName(guildId, anchorTinyId.toString());
            aVar.f264923n = d().getAvatarUrl(m3, guildId, anchorTinyId);
            return aVar;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        String str = "generateAfterSelfSendGiftAnimData, selfUid is " + c16 + "!!!";
        if (str instanceof String) {
            bVar3.a().add(str);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it6.next(), null);
        }
        return null;
    }
}
