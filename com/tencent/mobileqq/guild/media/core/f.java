package com.tencent.mobileqq.guild.media.core;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.media.core.logic.ad;
import com.tencent.mobileqq.guild.media.core.logic.bh;
import com.tencent.mobileqq.guild.media.core.logic.bi;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020!H&J\b\u0010$\u001a\u00020#H&J\b\u0010&\u001a\u00020%H&J\b\u0010(\u001a\u00020'H&J\b\u0010*\u001a\u00020)H&J\b\u0010+\u001a\u00020\tH&J\u0018\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H&J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u000200H&\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/e;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getQQAppInterface", "Landroid/content/Context;", "getAppContext", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "", "q0", "Lcom/tencent/mobileqq/guild/media/core/n;", "o0", "Lcom/tencent/mobileqq/guild/media/core/l;", "v0", "Lcom/tencent/mobileqq/guild/media/core/notify/p;", "r0", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getSelfUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "D0", "Lcom/tencent/mobileqq/guild/media/core/data/l;", "A0", "Lcom/tencent/mobileqq/guild/media/core/data/a;", "w0", "Lcom/tencent/mobileqq/guild/media/core/logic/p;", "z0", "Lcom/tencent/mobileqq/guild/media/core/logic/b;", "t0", "Lcom/tencent/mobileqq/guild/media/core/logic/g;", "x0", "Lcom/tencent/mobileqq/guild/media/core/logic/a;", "m0", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "y0", "Lcom/tencent/mobileqq/guild/media/core/logic/bi;", "p0", "Lcom/tencent/mobileqq/guild/media/core/logic/n;", "K0", "Lcom/tencent/mobileqq/guild/media/core/logic/bh;", "u0", "Lcom/tencent/mobileqq/guild/media/core/logic/ad;", "B0", "n0", "", "guildId", "channelId", "C0", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "enterChannelParamsForTRTCRoom", "s0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface f extends e, g {
    @NotNull
    com.tencent.mobileqq.guild.media.core.data.l A0();

    @NotNull
    ad B0();

    void C0(@NotNull String guildId, @NotNull String channelId);

    @NotNull
    com.tencent.mobileqq.guild.media.core.data.r D0();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.n K0();

    @NotNull
    Context getAppContext();

    @NotNull
    CoroutineScope getCoroutineScope();

    @NotNull
    BaseQQAppInterface getQQAppInterface();

    @NotNull
    com.tencent.mobileqq.guild.media.core.data.f getSelfUserInfo();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.a m0();

    void n0();

    @NotNull
    n o0();

    @NotNull
    bi p0();

    void q0();

    @NotNull
    /* renamed from: r0 */
    com.tencent.mobileqq.guild.media.core.notify.p getEventBus();

    void s0(@NotNull com.tencent.mobileqq.guild.media.core.logic.j enterChannelParamsForTRTCRoom);

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.b t0();

    @NotNull
    bh u0();

    @NotNull
    l v0();

    @NotNull
    com.tencent.mobileqq.guild.media.core.data.a w0();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.g x0();

    @NotNull
    ITRTCAudioRoom y0();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.p z0();
}
