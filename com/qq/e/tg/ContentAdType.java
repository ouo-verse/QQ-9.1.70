package com.qq.e.tg;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if ("ad".equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
