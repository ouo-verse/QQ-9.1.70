package com.tencent.timi.game.liveroom.impl.room.batchgift.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "", "", "a", "J", "c", "()J", "giftSubId", "b", "giftNum", "", "Ljava/lang/String;", "()Ljava/lang/String;", "giftDesc", "", "d", "Z", "()Z", "isEffect", "<init>", "(JJLjava/lang/String;Z)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long giftSubId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long giftNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String giftDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isEffect;

    public a(long j3, long j16, @NotNull String giftDesc, boolean z16) {
        Intrinsics.checkNotNullParameter(giftDesc, "giftDesc");
        this.giftSubId = j3;
        this.giftNum = j16;
        this.giftDesc = giftDesc;
        this.isEffect = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGiftDesc() {
        return this.giftDesc;
    }

    /* renamed from: b, reason: from getter */
    public final long getGiftNum() {
        return this.giftNum;
    }

    /* renamed from: c, reason: from getter */
    public final long getGiftSubId() {
        return this.giftSubId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsEffect() {
        return this.isEffect;
    }
}
