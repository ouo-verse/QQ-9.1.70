package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameCenterLaunchConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "isEnable", "", "()Z", "setEnable", "(Z)V", ZPlanPublishSource.FROM_SCHEME, "", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCenterLaunchConfig implements IConfigData {
    public static final String CONFIG_ID = "101712";
    private boolean isEnable;
    private String scheme = "";

    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: isEnable, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public final void setEnable(boolean z16) {
        this.isEnable = z16;
    }

    public final void setScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheme = str;
    }
}
