package com.qq.e.comm.pi;

import android.util.Pair;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface WXLuggageListener {
    boolean handleIntent();

    Pair<Boolean, String> initDynamicPkg();

    Object initWxLuggageSDK();
}
