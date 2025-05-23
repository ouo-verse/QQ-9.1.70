package com.tencent.avcore.engine;

import android.content.Context;
import com.tencent.avcore.util.AVNativeEventProcessor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAVAdapter {
    Context getContext();

    AVNativeEventProcessor getNativeEventProcessor();
}
