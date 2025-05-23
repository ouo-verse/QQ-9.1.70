package com.tencent.mobileqq.nearbypro.view;

import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/view/Level;", "", "scale", "", c.f123400v, "(Ljava/lang/String;IFF)V", "getAlpha", "()F", "getScale", "LEVEL_BIG", "LEVEL_MIDDLE", "LEVEL_SMALL", "LEVEL_HIDE", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public enum Level {
    LEVEL_BIG(1.0f, 1.0f),
    LEVEL_MIDDLE(0.92f, 0.8f),
    LEVEL_SMALL(0.86f, 0.5f),
    LEVEL_HIDE(0.5f, 0.0f);

    private final float alpha;
    private final float scale;

    Level(float f16, float f17) {
        this.scale = f16;
        this.alpha = f17;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getScale() {
        return this.scale;
    }
}
