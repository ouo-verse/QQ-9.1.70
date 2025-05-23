package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IVasEmojiManager {
    public static final String TAG = "VasEmojiManager";

    void complete(String str, int i3);

    ConcurrentHashMap<String, Bundle> getParamMap();

    void onProgress(String str, long j3, long j16);
}
