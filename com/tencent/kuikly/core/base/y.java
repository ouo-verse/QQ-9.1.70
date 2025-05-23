package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B-\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0011\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/base/y;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "d", "()F", "setPercentageX", "(F)V", "percentageX", "b", "e", "setPercentageY", "percentageY", "c", "setOffsetX", "offsetX", "setOffsetY", "offsetY", "<init>", "(FFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final y f117221f = new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float percentageX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float percentageY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float offsetX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float offsetY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/y$a;", "", "Lcom/tencent/kuikly/core/base/y;", "DEFAULT", "Lcom/tencent/kuikly/core/base/y;", "a", "()Lcom/tencent/kuikly/core/base/y;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.y$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final y a() {
            return y.f117221f;
        }

        Companion() {
        }
    }

    public y(float f16, float f17, float f18, float f19) {
        this.percentageX = f16;
        this.percentageY = f17;
        this.offsetX = f18;
        this.offsetY = f19;
    }

    /* renamed from: b, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* renamed from: c, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* renamed from: d, reason: from getter */
    public final float getPercentageX() {
        return this.percentageX;
    }

    /* renamed from: e, reason: from getter */
    public final float getPercentageY() {
        return this.percentageY;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.percentageX);
        sb5.append(TokenParser.SP);
        sb5.append(this.percentageY);
        return sb5.toString();
    }

    public /* synthetic */ y(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19);
    }
}
