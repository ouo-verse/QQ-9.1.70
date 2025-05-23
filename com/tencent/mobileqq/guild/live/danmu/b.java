package com.tencent.mobileqq.guild.live.danmu;

import iq1.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/b;", "Lcom/tencent/common/danmaku/inject/d;", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", "", "danmakuType", "Lcom/tencent/common/danmaku/data/a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements com.tencent.common.danmaku.inject.d {
    @Override // com.tencent.common.danmaku.inject.d
    @NotNull
    public com.tencent.common.danmaku.data.a<?, ?> a(@NotNull com.tencent.common.danmaku.inject.b danmakuContext, int danmakuType) {
        Intrinsics.checkNotNullParameter(danmakuContext, "danmakuContext");
        if (danmakuType != 1) {
            if (danmakuType != 2) {
                if (danmakuType != 3) {
                    if (danmakuType != 4) {
                        return new f(danmakuContext);
                    }
                    return new iq1.b(danmakuContext);
                }
                return new iq1.d(danmakuContext);
            }
            return new iq1.c(danmakuContext);
        }
        return new f(danmakuContext);
    }
}
