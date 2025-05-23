package kotlin.reflect.jvm.internal.impl.platform;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public abstract class SimplePlatform {

    @NotNull
    private final String platformName;

    @NotNull
    private final TargetPlatformVersion targetPlatformVersion;

    @NotNull
    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    @NotNull
    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }

    @NotNull
    public String toString() {
        boolean z16;
        String targetName = getTargetName();
        if (targetName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.platformName + " (" + targetName + ')';
        }
        return this.platformName;
    }
}
