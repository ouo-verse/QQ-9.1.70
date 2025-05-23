package com.tencent.icgame.game.live.impl.danmuku;

import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/icgame/game/live/impl/danmuku/b;", "", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "", "b", "Z", "getBg", "()Z", VasProfileTemplatePreloadHelper.BACKGROUND, "<init>", "(Ljava/lang/String;Z)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.icgame.game.live.impl.danmuku.b, reason: from toString */
/* loaded from: classes7.dex */
public final class DanmakuDataBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean bg;

    public DanmakuDataBean(@NotNull String content, boolean z16) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.bg = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public String toString() {
        return "DanmakuDataBean(content=" + this.content + ", bg=" + this.bg + ")";
    }
}
