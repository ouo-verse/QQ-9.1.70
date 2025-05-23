package com.tencent.zplan.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/common/model/AppTheme;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "DAY", "NIGHT", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public enum AppTheme {
    DAY,
    NIGHT;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/common/model/AppTheme$a;", "", "Lcom/tencent/zplan/common/model/AppTheme;", "", "b", "a", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.common.model.AppTheme$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final AppTheme a(int i3) {
            AppTheme appTheme = AppTheme.DAY;
            if (i3 != appTheme.ordinal()) {
                appTheme = AppTheme.NIGHT;
                if (i3 != appTheme.ordinal()) {
                    throw new IllegalArgumentException("can not convert fom Int: " + i3 + " to AppTheme");
                }
            }
            return appTheme;
        }

        public final int b(@NotNull AppTheme toInt) {
            Intrinsics.checkNotNullParameter(toInt, "$this$toInt");
            return toInt.ordinal();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
