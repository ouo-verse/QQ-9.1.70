package com.qq.e.tg.nativ;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
