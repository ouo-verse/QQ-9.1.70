package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFreesia {
    boolean isSwitchOn(String str, boolean z16);

    void isSwitchOnAsync(String str, boolean z16, IFreesiaBoolResCallback iFreesiaBoolResCallback);

    String loadConfigAsString(String str, String str2);

    void loadConfigAsStringAsync(String str, String str2, IFreesiaStringResCallback iFreesiaStringResCallback);

    void loadLargeConfigAsStringAsync(int i3, String str, String str2);
}
