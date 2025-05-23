package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.state.mmkv.SKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "ALWAYS_PRELOAD", "RED_POINT_PRELOAD", "ACTIVE_USER_PRELOAD", "NEVER_PRELOAD", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public enum PreloadEngineOption {
    ALWAYS_PRELOAD("always"),
    RED_POINT_PRELOAD(SKey.DetailMe.KEY_TITLE_RED_POINT_SP),
    ACTIVE_USER_PRELOAD("active_user"),
    NEVER_PRELOAD("never");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String desc;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption$a;", "", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.qflutter.PreloadEngineOption$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PreloadEngineOption a(@NotNull String engine) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            int hashCode = engine.hashCode();
            if (hashCode != -1414557169) {
                if (hashCode != -1051289244) {
                    if (hashCode == 1421475938 && engine.equals(SKey.DetailMe.KEY_TITLE_RED_POINT_SP)) {
                        return PreloadEngineOption.RED_POINT_PRELOAD;
                    }
                } else if (engine.equals("active_user")) {
                    return PreloadEngineOption.ACTIVE_USER_PRELOAD;
                }
            } else if (engine.equals("always")) {
                return PreloadEngineOption.ALWAYS_PRELOAD;
            }
            return PreloadEngineOption.NEVER_PRELOAD;
        }

        Companion() {
        }
    }

    PreloadEngineOption(String str) {
        this.desc = str;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }
}
