package com.xiaomi.push;

import com.xiaomi.push.bw;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bs extends bw.d {
    protected String F;

    public bs(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.F = str3;
    }

    public static bs m(String str) {
        return new bs(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
