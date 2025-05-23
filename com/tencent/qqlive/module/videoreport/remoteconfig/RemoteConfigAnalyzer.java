package com.tencent.qqlive.module.videoreport.remoteconfig;

import android.support.annotation.Nullable;
import com.google.gson.Gson;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RemoteConfigAnalyzer {
    private static final String TAG = "RemoteConfigAnalyzer";

    @Nullable
    public static <T> T analyze(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
