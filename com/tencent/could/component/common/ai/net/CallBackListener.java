package com.tencent.could.component.common.ai.net;

import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface CallBackListener {
    void cleanListener();

    void onFailed(String str);

    void onSuccess(InputStream inputStream, boolean z16);
}
