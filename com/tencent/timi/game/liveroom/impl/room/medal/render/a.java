package com.tencent.timi.game.liveroom.impl.room.medal.render;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0014\u0010\u000b\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/a;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/j;", "Lsr4/g;", "data", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "", "callback", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends j<sr4.g> {
    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public sr4.g c(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Object a16 = renderData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_info_svr.user_medal.nano.MedalInfoNew");
        return (sr4.g) a16;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull sr4.g data, @NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @NotNull c.a<?, CharSequence> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("DefaultMedalRender", 1, "render " + data.f434387c);
        callback.a(renderData, "");
    }
}
