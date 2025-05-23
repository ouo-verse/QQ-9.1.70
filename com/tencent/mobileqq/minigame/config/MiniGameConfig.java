package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "isNotchEnable", "", "()Z", "setNotchEnable", "(Z)V", "paHippyScheme", "", "getPaHippyScheme", "()Ljava/lang/String;", "setPaHippyScheme", "(Ljava/lang/String;)V", "paKuiklyScheme", "getPaKuiklyScheme", "setPaKuiklyScheme", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameConfig implements IConfigData {
    public static final String CONFIG_ID = "mini_game_config";
    private boolean isNotchEnable;
    private String paHippyScheme = "";
    private String paKuiklyScheme = "";

    public final String getPaHippyScheme() {
        return this.paHippyScheme;
    }

    public final String getPaKuiklyScheme() {
        return this.paKuiklyScheme;
    }

    /* renamed from: isNotchEnable, reason: from getter */
    public final boolean getIsNotchEnable() {
        return this.isNotchEnable;
    }

    public final void setNotchEnable(boolean z16) {
        this.isNotchEnable = z16;
    }

    public final void setPaHippyScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paHippyScheme = str;
    }

    public final void setPaKuiklyScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paKuiklyScheme = str;
    }
}
