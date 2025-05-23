package kotlin.reflect.jvm.internal.impl.load.java;

import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum ReportLevel {
    IGNORE(TagValue.IGNORE),
    WARN("warn"),
    STRICT("strict");


    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final String description;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    ReportLevel(String str) {
        this.description = str;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        if (this == IGNORE) {
            return true;
        }
        return false;
    }

    public final boolean isWarning() {
        if (this == WARN) {
            return true;
        }
        return false;
    }
}
