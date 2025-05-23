package com.tencent.hippy.qq.api;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IUpdateListener {
    void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap);

    void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap);
}
