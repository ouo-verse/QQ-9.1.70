package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/views/bs;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getDurationMs", "()I", "durationMs", "", "b", UserInfo.SEX_FEMALE, "getDamping", "()F", "damping", "c", "getVelocity", "velocity", "<init>", "(IFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class bs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int durationMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float damping;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float velocity;

    public bs(int i3, float f16, float f17) {
        this.durationMs = i3;
        this.damping = f16;
        this.velocity = f17;
    }

    public int hashCode() {
        return (((this.durationMs * 31) + Float.floatToIntBits(this.damping)) * 31) + Float.floatToIntBits(this.velocity);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(TokenParser.SP);
        sb5.append(this.durationMs);
        sb5.append(TokenParser.SP);
        sb5.append(this.damping);
        sb5.append(TokenParser.SP);
        sb5.append(this.velocity);
        return sb5.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof bs)) {
            return false;
        }
        bs bsVar = (bs) other;
        return this.durationMs == bsVar.durationMs && Float.compare(this.damping, bsVar.damping) == 0 && Float.compare(this.velocity, bsVar.velocity) == 0;
    }
}
