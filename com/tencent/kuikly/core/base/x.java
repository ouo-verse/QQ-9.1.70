package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/x;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "horizontalSkewAngle", "b", "verticalSkewAngle", "<init>", "(FF)V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final x f117217d = new x(0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float horizontalSkewAngle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float verticalSkewAngle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/x$a;", "", "Lcom/tencent/kuikly/core/base/x;", "DEFAULT", "Lcom/tencent/kuikly/core/base/x;", "a", "()Lcom/tencent/kuikly/core/base/x;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.x$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x a() {
            return x.f117217d;
        }

        Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.horizontalSkewAngle);
        sb5.append(TokenParser.SP);
        sb5.append(this.verticalSkewAngle);
        return sb5.toString();
    }

    public x(float f16, float f17) {
        this.horizontalSkewAngle = f16;
        this.verticalSkewAngle = f17;
    }

    public /* synthetic */ x(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17);
    }
}
