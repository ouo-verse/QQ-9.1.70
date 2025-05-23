package com.tencent.mobileqq.auto.engine.lib;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IASEngineDelegate {
    boolean enter(String str, String str2, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2);

    String getPluginVerSion(String str);

    boolean isOnThirdTab(String str);

    boolean setForceNative(String str, boolean z16);
}
