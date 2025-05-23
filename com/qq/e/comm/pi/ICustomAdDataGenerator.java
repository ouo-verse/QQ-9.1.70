package com.qq.e.comm.pi;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ICustomAdDataGenerator {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LoadADCallback {
        void onADLoadErr(int i3);

        void onADLoadSucc(String str);
    }

    boolean loadAD(String str, Map<String, String> map, LoadADCallback loadADCallback);
}
