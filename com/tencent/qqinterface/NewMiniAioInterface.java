package com.tencent.qqinterface;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface NewMiniAioInterface {
    void onBackground();

    void onCreate(Context context, String str, String str2, long j3, int i3);

    void onDestroy();

    void onForeground();

    void setPoint(int i3, int i16);
}
