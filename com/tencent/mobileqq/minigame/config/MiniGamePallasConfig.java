package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGamePallasConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "enableRecordScreen", "", "getEnableRecordScreen", "()Z", "setEnableRecordScreen", "(Z)V", "fileDownloadType", "", "getFileDownloadType", "()I", "setFileDownloadType", "(I)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePallasConfig implements IConfigData {
    public static final String CONFIG_ID = "105566";
    private boolean enableRecordScreen;
    private int fileDownloadType = 1;

    public final boolean getEnableRecordScreen() {
        return this.enableRecordScreen;
    }

    public final int getFileDownloadType() {
        return this.fileDownloadType;
    }

    public final void setEnableRecordScreen(boolean z16) {
        this.enableRecordScreen = z16;
    }

    public final void setFileDownloadType(int i3) {
        this.fileDownloadType = i3;
    }
}
