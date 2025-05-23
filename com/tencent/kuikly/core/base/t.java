package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 \u00122\u00020\u0001:\u0001\u0006B%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/base/t;", "", "", "toString", "b", "", "a", UserInfo.SEX_FEMALE, "getAngle", "()F", "angle", "getXAngle", "xAngle", "c", "getYAngle", "yAngle", "<init>", "(FFF)V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final t f117206e = new t(0.0f, 0.0f, 0.0f, 6, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float angle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float xAngle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float yAngle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/t$a;", "", "Lcom/tencent/kuikly/core/base/t;", "DEFAULT", "Lcom/tencent/kuikly/core/base/t;", "a", "()Lcom/tencent/kuikly/core/base/t;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.t$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a() {
            return t.f117206e;
        }

        Companion() {
        }
    }

    public t() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public final String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.xAngle);
        sb5.append(TokenParser.SP);
        sb5.append(this.yAngle);
        return sb5.toString();
    }

    public String toString() {
        return String.valueOf(this.angle);
    }

    public t(float f16, float f17, float f18) {
        this.angle = f16;
        this.xAngle = f17;
        this.yAngle = f18;
    }

    public /* synthetic */ t(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18);
    }
}
