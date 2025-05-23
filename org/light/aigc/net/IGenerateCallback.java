package org.light.aigc.net;

import org.light.aigc.bean.AIGCContentOutput;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface IGenerateCallback {
    void onError(long j3, String str);

    void onSuccess(AIGCContentOutput aIGCContentOutput);
}
