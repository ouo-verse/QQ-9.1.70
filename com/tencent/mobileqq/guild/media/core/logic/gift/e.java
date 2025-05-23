package com.tencent.mobileqq.guild.media.core.logic.gift;

import com.tencent.guild.aio.util.z;
import com.tencent.mobileqq.guild.util.bw;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u000e\u0010\tR*\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/e;", "", "", "value", "b", "J", "c", "()J", "k", "(J)V", "beforeReceiveFreeGiftTime", "d", "l", "beforeTodayReceiveFreeGiftTime", "j", "beforeReceiveChargeGiftTime", "e", "a", "i", "beforeLiveReceiveChargeGiftTime", "", "g", "()Z", "isFirstReceiveFreeGift", "f", "isFirstReceiveChargeGift", "isFirstLiveReceiveChargeGift", h.F, "isTodayFirstReceiveFreeGift", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f228473a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long beforeReceiveFreeGiftTime = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long beforeTodayReceiveFreeGiftTime = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long beforeReceiveChargeGiftTime = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long beforeLiveReceiveChargeGiftTime = -1;

    e() {
    }

    public final long a() {
        return bw.L().decodeLong("mmkv_key_guild_live_receive_pay_gift_time", beforeLiveReceiveChargeGiftTime);
    }

    public final long b() {
        return bw.L().decodeLong("mmkv_key_guild_receive_charge_gift_time", beforeReceiveChargeGiftTime);
    }

    public final long c() {
        return bw.L().decodeLong("mmkv_key_guild_receive_free_gift_time", beforeReceiveFreeGiftTime);
    }

    public final long d() {
        return bw.L().decodeLong("mmkv_key_guild_today_receive_free_gift_time", beforeTodayReceiveFreeGiftTime);
    }

    public final boolean e() {
        if (a() == -1) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (b() == -1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (c() == -1) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        long j3 = 1000;
        return !z.f112475a.a(d() / j3, System.currentTimeMillis() / j3);
    }

    public final void i(long j3) {
        beforeLiveReceiveChargeGiftTime = j3;
        bw.L().encodeLong("mmkv_key_guild_live_receive_pay_gift_time", j3);
    }

    public final void j(long j3) {
        beforeReceiveChargeGiftTime = j3;
        bw.L().encodeLong("mmkv_key_guild_receive_charge_gift_time", j3);
    }

    public final void k(long j3) {
        beforeReceiveFreeGiftTime = j3;
        bw.L().encodeLong("mmkv_key_guild_receive_free_gift_time", j3);
    }

    public final void l(long j3) {
        beforeTodayReceiveFreeGiftTime = j3;
        bw.L().encodeLong("mmkv_key_guild_today_receive_free_gift_time", j3);
    }
}
