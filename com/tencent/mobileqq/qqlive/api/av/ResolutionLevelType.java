package com.tencent.mobileqq.qqlive.api.av;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "", "code", "", "term", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getTerm", "()Ljava/lang/String;", "BluRay", "UHD", "HD", "Companion", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public enum ResolutionLevelType {
    BluRay(0, "\u84dd\u5149"),
    UHD(1, "\u8d85\u6e05"),
    HD(2, "\u9ad8\u6e05");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_BLU_RAY_HEIGHT = 1080;
    private static final int DEFAULT_UHD_HEIGHT = 720;
    private final int code;

    @NotNull
    private final String term;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType$Companion;", "", "()V", "DEFAULT_BLU_RAY_HEIGHT", "", "DEFAULT_UHD_HEIGHT", "bluRayLevels", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "getByTerm", "term", "", "getSupportResLevels", "isSupportBluRay", "", "getSupportResLevelsForCapture", "context", "Landroid/content/Context;", "hdLevels", "uhdLevels", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<ResolutionLevelType> bluRayLevels() {
            List<ResolutionLevelType> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ResolutionLevelType[]{ResolutionLevelType.BluRay, ResolutionLevelType.UHD, ResolutionLevelType.HD});
            return listOf;
        }

        private final List<ResolutionLevelType> hdLevels() {
            List<ResolutionLevelType> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(ResolutionLevelType.HD);
            return listOf;
        }

        private final List<ResolutionLevelType> uhdLevels() {
            List<ResolutionLevelType> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ResolutionLevelType[]{ResolutionLevelType.UHD, ResolutionLevelType.HD});
            return listOf;
        }

        @Nullable
        public final ResolutionLevelType getByTerm(@NotNull String term) {
            Intrinsics.checkNotNullParameter(term, "term");
            for (ResolutionLevelType resolutionLevelType : ResolutionLevelType.values()) {
                if (Intrinsics.areEqual(resolutionLevelType.getTerm(), term)) {
                    return resolutionLevelType;
                }
            }
            return null;
        }

        @NotNull
        public final List<ResolutionLevelType> getSupportResLevels(boolean isSupportBluRay) {
            if (isSupportBluRay) {
                return bluRayLevels();
            }
            return uhdLevels();
        }

        @NotNull
        public final List<ResolutionLevelType> getSupportResLevelsForCapture(@Nullable Context context) {
            if (context == null) {
                return uhdLevels();
            }
            int i3 = context.getResources().getDisplayMetrics().heightPixels;
            if (i3 >= 1080) {
                return bluRayLevels();
            }
            if (i3 >= 720) {
                return uhdLevels();
            }
            return hdLevels();
        }

        Companion() {
        }
    }

    ResolutionLevelType(int i3, String str) {
        this.code = i3;
        this.term = str;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getTerm() {
        return this.term;
    }
}
