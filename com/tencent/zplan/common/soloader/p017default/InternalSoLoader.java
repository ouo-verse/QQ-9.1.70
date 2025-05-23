package com.tencent.zplan.common.soloader.p017default;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.zplan.common.soloader.a;
import com.tencent.zplan.common.soloader.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0002\r\u000eB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/common/soloader/default/InternalSoLoader;", "Lcom/tencent/zplan/common/soloader/b;", "", "soNickname", "Lcom/tencent/zplan/common/soloader/a;", "load", "", "getPriority", "()I", "priority", "<init>", "()V", "e", "a", "b", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class InternalSoLoader implements b {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy f385271d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/common/soloader/default/InternalSoLoader$a;", "", "Lcom/tencent/zplan/common/soloader/default/InternalSoLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/zplan/common/soloader/default/InternalSoLoader;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.common.soloader.default.InternalSoLoader$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final InternalSoLoader a() {
            return (InternalSoLoader) InternalSoLoader.f385271d.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/common/soloader/default/InternalSoLoader$b;", "Lcom/tencent/zplan/common/soloader/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getSoNickName", "()Ljava/lang/String;", "soNickName", "<init>", "(Ljava/lang/String;)V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.common.soloader.default.InternalSoLoader$b, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class InternalSoItem implements a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String soNickName;

        public InternalSoItem(@NotNull String soNickName) {
            Intrinsics.checkNotNullParameter(soNickName, "soNickName");
            this.soNickName = soNickName;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (!(other instanceof InternalSoItem) || !Intrinsics.areEqual(this.soNickName, ((InternalSoItem) other).soNickName)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public int hashCode() {
            String str = this.soNickName;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "InternalSoItem(soNickName=" + this.soNickName + ")";
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InternalSoLoader>() { // from class: com.tencent.zplan.common.soloader.default.InternalSoLoader$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InternalSoLoader invoke() {
                return new InternalSoLoader();
            }
        });
        f385271d = lazy;
    }

    @Override // com.tencent.zplan.common.soloader.b
    public int getPriority() {
        return 100;
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return b.a.a(this, other);
    }

    @Override // com.tencent.zplan.common.soloader.b
    @NotNull
    public a load(@NotNull String soNickname) {
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        System.loadLibrary(soNickname);
        return new InternalSoItem(soNickname);
    }

    @Override // com.tencent.zplan.common.soloader.b
    @Nullable
    public a prepare(@NotNull String soNickname) {
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        return b.a.b(this, soNickname);
    }
}
