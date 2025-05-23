package com.tencent.ntcompose.animation;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ntcompose/animation/f;", "Lcom/tencent/ntcompose/animation/h;", "", "other", "", "equals", "", "hashCode", "", "a", UserInfo.SEX_FEMALE, "b", "c", "d", "<init>", "(FFFF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements h {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public f(float f16, float f17, float f18, float f19) {
        this.a = f16;
        this.b = f17;
        this.c = f18;
        this.d = f19;
    }

    public boolean equals(Object other) {
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (!(this.a == fVar.a)) {
            return false;
        }
        if (!(this.b == fVar.b)) {
            return false;
        }
        if (this.c == fVar.c) {
            return (this.d > fVar.d ? 1 : (this.d == fVar.d ? 0 : -1)) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }
}
