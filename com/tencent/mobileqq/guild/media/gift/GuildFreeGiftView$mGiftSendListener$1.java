package com.tencent.mobileqq.guild.media.gift;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$mGiftSendListener$1", "Lcom/tencent/mobileqq/guild/gift/module/k;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "isFromPack", "", HippyTKDListViewAdapter.X, "originalData", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFreeGiftView$mGiftSendListener$1 implements com.tencent.mobileqq.guild.gift.module.k<IGProSendGiftEventData> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ GuildFreeGiftView f228916d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFreeGiftView$mGiftSendListener$1(GuildFreeGiftView guildFreeGiftView) {
        this.f228916d = guildFreeGiftView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        com.tencent.mobileqq.guild.media.core.j.a().H().c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        MediaChannelFreeGiftTaskHelper.b0(com.tencent.mobileqq.guild.media.core.j.a().H(), null, 1, null);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull IGProSendGiftEventData originalData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void o() {
        k.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void s(int i3, @Nullable String str) {
        k.a.b(this, i3, str);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack) {
        String joinToString$default;
        int coerceAtMost;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<Long> f16 = com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().f();
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        int i3 = data.f264910a;
        int i16 = data.f264915f;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(f16, ",", null, null, 0, null, new Function1<Long, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$mGiftSendListener$1$onSelfSendGift$1$1
            @NotNull
            public final CharSequence invoke(long j3) {
                return String.valueOf(j3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Long l3) {
                return invoke(l3.longValue());
            }
        }, 30, null);
        d16.i("GuildFreeGiftView", 1, "[onSelfSendGift] giftId: " + i3 + ", giftCount: " + i16 + ", isFromPack:" + isFromPack + ", freeGiftId: " + joinToString$default);
        if (isFromPack && f16.contains(Long.valueOf(data.f264910a))) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(9, com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftAccountBalance() - data.f264915f);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, coerceAtMost);
            this.f228916d.J(Integer.valueOf(coerceAtLeast));
            this.f228916d.mLastNum = coerceAtLeast;
            if (com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().i()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFreeGiftView$mGiftSendListener$1.c();
                    }
                }, 1000L);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFreeGiftView$mGiftSendListener$1.d();
                    }
                }, 1000L);
                return;
            }
        }
        logger.d().i("GuildFreeGiftView", 1, "[onSelfSendGift] giftId[" + data.f264910a + "] is not free. ignored");
    }
}
