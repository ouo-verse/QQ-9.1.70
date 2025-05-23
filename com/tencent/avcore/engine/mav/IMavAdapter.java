package com.tencent.avcore.engine.mav;

import com.tencent.avcore.engine.IAVAdapter;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMavAdapter extends IAVAdapter {
    byte[] getConfigInfoFromFile();

    String getSharpConfigPayloadFromFile();

    int getSharpConfigVersionFromFile();

    void onReceiveAudio(byte[] bArr, int i3, int i16, int i17, int i18);
}
