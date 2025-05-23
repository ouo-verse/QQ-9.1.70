package com.tencent.mobileqq.guild.media.core.logic.gift;

import com.tencent.mobileqq.guild.gift.module.n;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u001c\u0018\u0000 \t2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftReceivePushModule;", "Lcom/tencent/mobileqq/guild/gift/module/c;", "", "tinyId", "", h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "data", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "e", "Lcom/tencent/mobileqq/guild/gift/module/n;", "listener", "", "a", "destroy", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "()Lcom/tencent/mobileqq/guild/media/core/f;", "core", "b", "Lcom/tencent/mobileqq/guild/gift/module/n;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "c", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "com/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftReceivePushModule$b", "d", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftReceivePushModule$b;", "observer", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaGiftReceivePushModule implements com.tencent.mobileqq.guild.gift.module.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gpsService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftReceivePushModule$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "eventdata", "", "onPushSendGiftEventNotify", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushSendGiftEventNotify(@Nullable String guildId, @Nullable String channelId, @Nullable IGProSendGiftEventData eventdata) {
            if (channelId != null && eventdata != null && MediaGiftReceivePushModule.this.getCore().K(channelId)) {
                boolean z16 = true;
                if (!eventdata.getGiftInfo().getComboOver()) {
                    boolean h16 = MediaGiftReceivePushModule.this.h(eventdata.getSenderMember().getTinyId());
                    n nVar = MediaGiftReceivePushModule.this.listener;
                    if (nVar != null) {
                        com.tencent.mobileqq.qqgift.mvvm.business.anim.a e16 = MediaGiftReceivePushModule.this.e(eventdata);
                        if (h16 || eventdata.getGiftInfo().getEffectLevel() != 1) {
                            z16 = false;
                        }
                        nVar.b(e16, eventdata, h16, z16);
                        return;
                    }
                    return;
                }
                Logger.f235387a.d().i("QGMC.Core.MediaGiftReceivePushModule", 1, "onPushSendGiftEventNotify, is combo over, ignore.");
            }
        }
    }

    public MediaGiftReceivePushModule(@NotNull f core) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftReceivePushModule$gpsService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGPSService invoke() {
                IRuntimeService runtimeService = MediaGiftReceivePushModule.this.getCore().getQQAppInterface().getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
                return (IGPSService) runtimeService;
            }
        });
        this.gpsService = lazy;
        this.observer = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a e(IGProSendGiftEventData data) {
        boolean z16;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        boolean z17 = true;
        aVar.f264931v = true;
        aVar.f264910a = data.getGiftInfo().getGiftId();
        aVar.f264913d = data.getGiftInfo().getGiftName();
        aVar.f264914e = data.getGiftInfo().getMaterialId();
        aVar.f264924o = data.getGiftInfo().getEffectLevel();
        aVar.f264912c = data.getGiftInfo().getGiftPrice();
        aVar.f264915f = data.getGiftInfo().getGiftNum();
        aVar.f264911b = data.getGiftInfo().getGiftType();
        aVar.f264925p = data.getGiftInfo().getComboSeq();
        aVar.f264926q = data.getGiftInfo().getAllComboCnt();
        aVar.f264918i = data.getSenderMember().getTinyId();
        IGProUser senderMember = data.getSenderMember();
        String memberName = senderMember.getMemberName();
        if (memberName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            memberName = senderMember.getNickName();
        }
        aVar.f264919j = memberName;
        aVar.f264922m = g().getFullAvatarUrl(new cw(String.valueOf(aVar.f264918i), data.getSenderMember().getAvatarMeta()), 3);
        aVar.f264920k = data.getReceiverMember().getTinyId();
        IGProUser receiverMember = data.getReceiverMember();
        String memberName2 = receiverMember.getMemberName();
        if (memberName2.length() != 0) {
            z17 = false;
        }
        if (z17) {
            memberName2 = receiverMember.getNickName();
        }
        aVar.f264921l = memberName2;
        aVar.f264923n = g().getFullAvatarUrl(new cw(String.valueOf(aVar.f264920k), data.getReceiverMember().getAvatarMeta()), 3);
        return aVar;
    }

    private final IGPSService g() {
        return (IGPSService) this.gpsService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(long tinyId) {
        return Intrinsics.areEqual(ch.f(), String.valueOf(tinyId));
    }

    @Override // com.tencent.mobileqq.guild.gift.module.c
    public void a(@NotNull n listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        g().addObserver(this.observer);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.c
    public void destroy() {
        g().deleteObserver(this.observer);
        this.listener = null;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final f getCore() {
        return this.core;
    }
}
