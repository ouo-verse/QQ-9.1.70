package com.tencent.rtmp;

import android.os.Bundle;

/* loaded from: classes25.dex */
public interface ITXLivePushListener {
    void onNetStatus(Bundle bundle);

    void onPushEvent(int i3, Bundle bundle);
}
