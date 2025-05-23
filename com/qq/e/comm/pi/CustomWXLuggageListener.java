package com.qq.e.comm.pi;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface CustomWXLuggageListener {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface CallBack {
        void onFailed();

        void onSuccess();
    }

    void jumpToWXLuggage(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, CallBack callBack);
}
