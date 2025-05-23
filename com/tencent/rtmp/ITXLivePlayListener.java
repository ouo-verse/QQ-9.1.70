package com.tencent.rtmp;

import android.os.Bundle;

/* loaded from: classes25.dex */
public interface ITXLivePlayListener {
    void onNetStatus(Bundle bundle);

    void onPlayEvent(int i3, Bundle bundle);
}
