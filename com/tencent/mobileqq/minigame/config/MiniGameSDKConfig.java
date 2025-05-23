package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameSDKConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "firstGameFixDuration", "", "getFirstGameFixDuration", "()I", "setFirstGameFixDuration", "(I)V", "secondGameFixDuration", "getSecondGameFixDuration", "setSecondGameFixDuration", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameSDKConfig implements IConfigData {
    public static final String CONFIG_ID = "100660";
    public static final int DEFAULT_FIRST_DURATION = 60;
    public static final int DEFAULT_SECOND_DURATION = 30;
    private int firstGameFixDuration = 60;
    private int secondGameFixDuration = 30;

    public final int getFirstGameFixDuration() {
        return this.firstGameFixDuration;
    }

    public final int getSecondGameFixDuration() {
        return this.secondGameFixDuration;
    }

    public final void setFirstGameFixDuration(int i3) {
        this.firstGameFixDuration = i3;
    }

    public final void setSecondGameFixDuration(int i3) {
        this.secondGameFixDuration = i3;
    }
}
