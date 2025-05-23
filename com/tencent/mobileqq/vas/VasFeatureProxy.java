package com.tencent.mobileqq.vas;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/VasFeatureProxy;", "", "name", "", "(Ljava/lang/String;)V", "flag", "", "getName", "()Ljava/lang/String;", "change", "", "enable", "", "isEnable", "isNotEnable", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFeatureProxy {
    private int flag;

    @NotNull
    private final String name;

    public VasFeatureProxy(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final void change(boolean enable) {
        int i3;
        VipNtMMKV.INSTANCE.getFeature().encodeBool(this.name, enable);
        if (enable) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        this.flag = i3;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean isEnable() {
        int i3;
        if (this.flag == 0) {
            if (VipNtMMKV.INSTANCE.getFeature().decodeBool(this.name, true)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.flag = i3;
        }
        if (this.flag == 1) {
            return true;
        }
        return false;
    }

    public final boolean isNotEnable() {
        return !isEnable();
    }
}
