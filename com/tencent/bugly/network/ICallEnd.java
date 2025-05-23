package com.tencent.bugly.network;

import java.io.IOException;
import okhttp3.Call;

/* compiled from: P */
/* loaded from: classes5.dex */
interface ICallEnd {
    void onCallEnd(Call call, boolean z16, IOException iOException);
}
