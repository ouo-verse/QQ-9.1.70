package com.tencent.zplan.device.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/device/config/DeviceLevel;", "", "", "level", "I", "getLevel", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "HIGH", "LOW", "zplan-device-config_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public enum DeviceLevel {
    UNKNOWN(0),
    HIGH(1),
    LOW(2);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int level;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/device/config/DeviceLevel$a;", "", "", "value", "Lcom/tencent/zplan/device/config/DeviceLevel;", "a", "<init>", "()V", "zplan-device-config_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.device.config.DeviceLevel$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final DeviceLevel a(int value) {
            DeviceLevel deviceLevel;
            boolean z16;
            DeviceLevel[] values = DeviceLevel.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    deviceLevel = values[i3];
                    if (deviceLevel.getLevel() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    deviceLevel = null;
                    break;
                }
            }
            if (deviceLevel == null) {
                return DeviceLevel.UNKNOWN;
            }
            return deviceLevel;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    DeviceLevel(int i3) {
        this.level = i3;
    }

    public final int getLevel() {
        return this.level;
    }
}
