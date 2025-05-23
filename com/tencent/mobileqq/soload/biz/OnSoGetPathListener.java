package com.tencent.mobileqq.soload.biz;

/* loaded from: classes18.dex */
public interface OnSoGetPathListener {
    public static final int RES_FAIL = 1;
    public static final int RES_FAIL_MD5_NOT_MATCH = 2;
    public static final int RES_SUCC = 0;

    void onResult(int i3, String str, String str2, String str3, boolean z16, int i16);
}
