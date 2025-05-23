package com.tencent.qqinterface;

import android.content.Context;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface MiniAioInterface {
    void onBackground();

    void onCreate(Context context, Bundle bundle);

    void onDestroy();

    void onForeground();

    void showEntry(boolean z16);
}
