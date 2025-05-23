package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "", "height", "targetHeightHint", "", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", AdMetricTag.FALLBACK, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class d implements e.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e.b fallback;

    public d(@Nullable e.b bVar) {
        this.fallback = bVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
    public void a(int height, int targetHeightHint) {
        e.b bVar = this.fallback;
        if (bVar != null) {
            bVar.a(height, targetHeightHint);
        }
    }
}
