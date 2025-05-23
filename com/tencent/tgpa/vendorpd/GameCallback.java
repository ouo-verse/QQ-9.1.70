package com.tencent.tgpa.vendorpd;

import com.tencent.tgpa.vendorpd.GamePredownloader;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface GameCallback extends GamePredownloader.Callback {
    @Override // com.tencent.tgpa.vendorpd.GamePredownloader.Callback
    int getPreDownloadVersionInfo(String str);
}
