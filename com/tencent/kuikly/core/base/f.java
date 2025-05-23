package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/base/f;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "topLeftCornerRadius", "b", "d", "topRightCornerRadius", "bottomLeftCornerRadius", "bottomRightCornerRadius", "<init>", "(FFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float topLeftCornerRadius;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float topRightCornerRadius;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float bottomLeftCornerRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float bottomRightCornerRadius;

    public f(float f16, float f17, float f18, float f19) {
        this.topLeftCornerRadius = f16;
        this.topRightCornerRadius = f17;
        this.bottomLeftCornerRadius = f18;
        this.bottomRightCornerRadius = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: b, reason: from getter */
    public final float getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: c, reason: from getter */
    public final float getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: d, reason: from getter */
    public final float getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.topLeftCornerRadius);
        sb5.append(',');
        sb5.append(this.topRightCornerRadius);
        sb5.append(',');
        sb5.append(this.bottomLeftCornerRadius);
        sb5.append(',');
        sb5.append(this.bottomRightCornerRadius);
        return sb5.toString();
    }
}
