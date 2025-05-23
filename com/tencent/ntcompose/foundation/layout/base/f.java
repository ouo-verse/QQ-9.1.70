package com.tencent.ntcompose.foundation.layout.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/f;", "", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "value", "<init>", "(F)V", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    private static final f f339266c;

    /* renamed from: d, reason: collision with root package name */
    private static final f f339267d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/f$a;", "", "", "value", "Lcom/tencent/ntcompose/foundation/layout/base/f;", "a", "MATCH_PARENT", "Lcom/tencent/ntcompose/foundation/layout/base/f;", "b", "()Lcom/tencent/ntcompose/foundation/layout/base/f;", "WRAP_CONTENT", "c", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.foundation.layout.base.f$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(float value) {
            return new f(value);
        }

        public final f b() {
            return f.f339266c;
        }

        public final f c() {
            return f.f339267d;
        }

        Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f339266c = companion.a(1.0f);
        f339267d = companion.a(-1.0f);
    }

    public f(float f16) {
        this.value = f16;
    }

    /* renamed from: c, reason: from getter */
    public final float getValue() {
        return this.value;
    }
}
