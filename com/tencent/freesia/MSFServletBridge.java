package com.tencent.freesia;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface MSFServletBridge {
    boolean isNetworkAvailable();

    void report(@NonNull String str, int i3, int i16, @NonNull SsoReportReq ssoReportReq, boolean z16);

    void send(@NonNull String str, @NonNull String str2, @NonNull GetConfigReq getConfigReq, boolean z16, int i3, int i16);
}
