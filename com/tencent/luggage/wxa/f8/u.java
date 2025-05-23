package com.tencent.luggage.wxa.f8;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/luggage/wxa/f8/u;", "", "", "a", "I", "b", "()I", "jsonVal", "<init>", "(Ljava/lang/String;II)V", "c", "d", "e", "f", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public enum u {
    NONE(0),
    NORMAL_MIX(1),
    SCREEN_MIX(2),
    HARD_MIX(3);


    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int jsonVal;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/f8/u$a;", "", "", "typeInt", "Lcom/tencent/luggage/wxa/f8/u;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.wxa.f8.u$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final u a(int typeInt) {
            boolean z16;
            for (u uVar : u.values()) {
                if (typeInt == uVar.getJsonVal()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return uVar;
                }
            }
            return null;
        }
    }

    u(int i3) {
        this.jsonVal = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getJsonVal() {
        return this.jsonVal;
    }

    @JvmStatic
    @Nullable
    public static final u a(int i3) {
        return INSTANCE.a(i3);
    }
}
