package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/ar;", "", "a", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/ar$a;", "", "", "owner", "time", "key", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "b", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.ar$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final UnitedProxy a(@NotNull String owner, @NotNull String time, @NotNull String key) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(key, "key");
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || (ReportInfo.INSTANCE.isHit() && Random.INSTANCE.nextInt(0, 100) == 50)) {
                VasNtCommonReporter.getHistoryFeature("toggle-long").setValue2(owner).setValue3(time).setValue4(key).reportEveryDay(key);
            }
            return new UnitedProxy(key);
        }

        @JvmStatic
        @NotNull
        public final UnitedProxy b(@NotNull String owner, @NotNull String time, @NotNull String key) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(key, "key");
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || (ReportInfo.INSTANCE.isHit() && Random.INSTANCE.nextInt(0, 100) == 50)) {
                VasNtCommonReporter.getHistoryFeature("toggle-normal").setValue2(owner).setValue3(time).setValue4(key).reportEveryDay(key);
            }
            return new UnitedProxy(key);
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final UnitedProxy a(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        return INSTANCE.a(str, str2, str3);
    }

    @JvmStatic
    @NotNull
    public static final UnitedProxy b(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        return INSTANCE.b(str, str2, str3);
    }
}
