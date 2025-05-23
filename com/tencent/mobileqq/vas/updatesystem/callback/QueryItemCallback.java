package com.tencent.mobileqq.vas.updatesystem.callback;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface QueryItemCallback {
    public static final int EXISTS = 0;
    public static final int MISSING = 1;
    public static final int TIMEOUT = 2;

    void onQueryItemVer(int i3, String str, String str2);
}
