package com.tencent.mobileqq.guild.live.livemanager.gift;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.gift.module.n;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR0\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R#\u00106\u001a\n 2*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/gift/LiveGiftReceivePushModule;", "Lcom/tencent/mobileqq/guild/gift/module/c;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "giftMessage", "", DomainData.DOMAIN_NAME, "", "senderTinyId", "receiverTinyId", "data", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "g", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;)Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "tinyId", "", "default", "j", "i", "uid", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/gift/module/n;", "listener", "a", "destroy", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "getCore", "()Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "handleJobs", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "atomicSeq", "d", "Lcom/tencent/mobileqq/guild/gift/module/n;", "Lmqq/app/AppRuntime;", "e", "Lkotlin/Lazy;", tl.h.F, "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "f", "k", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "giftMessageObserver", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveGiftReceivePushModule implements com.tencent.mobileqq.guild.gift.module.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, com.tencent.mobileqq.qcoroutine.api.coroutine.b> handleJobs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger atomicSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy igpsService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<GiftMessage> giftMessageObserver;

    public LiveGiftReceivePushModule(@NotNull GLiveChannelCore core) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.handleJobs = new HashMap<>();
        this.atomicSeq = new AtomicInteger();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.LiveGiftReceivePushModule$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AppRuntime invoke() {
                return ch.m();
            }
        });
        this.appRuntime = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.LiveGiftReceivePushModule$igpsService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.R0(IGPSService.class);
            }
        });
        this.igpsService = lazy2;
        this.giftMessageObserver = new Observer() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftReceivePushModule.l(LiveGiftReceivePushModule.this, (GiftMessage) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a g(Long senderTinyId, Long receiverTinyId, GiftMessage data) {
        boolean z16;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        boolean z17 = true;
        aVar.f264931v = true;
        aVar.f264910a = data.giftID;
        aVar.f264913d = data.giftName;
        aVar.f264914e = data.materialID;
        aVar.f264924o = data.effectLevel;
        aVar.f264912c = data.giftPrice;
        aVar.f264915f = data.giftNum;
        aVar.f264911b = data.giftType;
        aVar.f264925p = data.comboSeq;
        aVar.f264926q = data.allComboCnt;
        aVar.f264918i = data.sender;
        aVar.f264919j = data.senderNick;
        aVar.f264922m = data.senderHead;
        aVar.f264920k = data.receiver;
        aVar.f264921l = data.receiverNick;
        aVar.f264923n = data.receiverHead;
        if (senderTinyId != null) {
            long longValue = senderTinyId.longValue();
            String str = aVar.f264919j;
            Intrinsics.checkNotNullExpressionValue(str, "animData.senderNick");
            aVar.f264919j = j(longValue, str);
            String i3 = i(longValue);
            if (i3 != null && i3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                aVar.f264922m = i3;
            }
        }
        if (receiverTinyId != null) {
            long longValue2 = receiverTinyId.longValue();
            String str2 = aVar.f264921l;
            Intrinsics.checkNotNullExpressionValue(str2, "animData.recNick");
            aVar.f264921l = j(longValue2, str2);
            String i16 = i(longValue2);
            if (i16 != null && i16.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                aVar.f264923n = i16;
            }
        }
        return aVar;
    }

    private final AppRuntime h() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final String i(long tinyId) {
        return ((IQQGuildAvatarApi) ch.R0(IQQGuildAvatarApi.class)).getAvatarUrl(h(), this.core.s().getGuildId(), String.valueOf(tinyId));
    }

    private final String j(long tinyId, String r56) {
        String guildUserDisplayName = k().getGuildUserDisplayName(this.core.s().getGuildId(), String.valueOf(tinyId), r56);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "igpsService.getGuildUser\u2026(),\n        default\n    )");
        return guildUserDisplayName;
    }

    private final IGPSService k() {
        return (IGPSService) this.igpsService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LiveGiftReceivePushModule this$0, GiftMessage giftMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (giftMessage != null) {
            this$0.n(giftMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(long uid) {
        if (this.core.p().c() == uid) {
            return true;
        }
        return false;
    }

    private final void n(GiftMessage giftMessage) {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16;
        boolean z16 = true;
        Logger.f235387a.d().i("QGL.LiveGiftReceivePushModule", 1, "receiveGiftMessage, " + giftMessage);
        if (giftMessage.comboOver) {
            return;
        }
        int andIncrement = this.atomicSeq.getAndIncrement();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null && (e16 = CorountineFunKt.e(f16, "receiveGiftMessage", null, null, Boolean.TRUE, new LiveGiftReceivePushModule$receiveGiftMessage$job$1(giftMessage, this, andIncrement, null), 6, null)) != null) {
            Job a16 = e16.a();
            if (a16 == null || !a16.isActive()) {
                z16 = false;
            }
            if (z16) {
                if (QLog.isDevelopLevel()) {
                    Log.d("QGL.LiveGiftReceivePushModule", "receiveGiftMessage, add job " + e16);
                }
                this.handleJobs.put(Integer.valueOf(andIncrement), e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.c
    public void a(@NotNull n listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.core.t().i().observeForever(this.giftMessageObserver);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.c
    public void destroy() {
        this.core.t().i().removeObserver(this.giftMessageObserver);
        Collection<com.tencent.mobileqq.qcoroutine.api.coroutine.b> values = this.handleJobs.values();
        Intrinsics.checkNotNullExpressionValue(values, "handleJobs.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job a16 = ((com.tencent.mobileqq.qcoroutine.api.coroutine.b) it.next()).a();
            if (a16 != null) {
                Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
            }
        }
        this.handleJobs.clear();
    }
}
