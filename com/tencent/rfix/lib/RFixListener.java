package com.tencent.rfix.lib;

import androidx.annotation.Keep;
import com.tencent.rfix.lib.event.ConfigEvent;
import com.tencent.rfix.lib.event.DownloadEvent;
import com.tencent.rfix.lib.event.InstallEvent;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public interface RFixListener {
    void onConfig(boolean z16, int i3, ConfigEvent configEvent);

    void onDownload(boolean z16, int i3, DownloadEvent downloadEvent);

    void onInstall(boolean z16, int i3, InstallEvent installEvent);
}
