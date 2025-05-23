package ht3;

import common.config.service.QzoneConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0006\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\b\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"", "secondKey", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "d", "", "e", "", "a", "", "c", "qq-live-common-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    public static final float a(@NotNull String secondKey, float f16) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig("qqlive", secondKey, f16);
    }

    public static final int b(@NotNull String secondKey, int i3) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig("qqlive", secondKey, i3);
    }

    public static final long c(@NotNull String secondKey, long j3) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig("qqlive", secondKey, j3);
    }

    @NotNull
    public static final String d(@NotNull String secondKey, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String config = QzoneConfig.getInstance().getConfig("qqlive", secondKey, defaultValue);
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026 secondKey, defaultValue)");
        return config;
    }

    public static final boolean e(@NotNull String secondKey, boolean z16) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig("qqlive", secondKey, z16);
    }
}
