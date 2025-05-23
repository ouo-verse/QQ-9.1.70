package com.tencent.av.ui.funchat.record;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    public static int a(String str, int i3) {
        QLog.i("QavRecordUtils", 1, "parseMaxRecordTime " + str + ", def=" + i3);
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        int lastIndexOf = str.lastIndexOf("#");
        if (lastIndexOf >= 0 && lastIndexOf != str.length() - 1) {
            try {
                return Integer.parseInt(str.substring(lastIndexOf + 1));
            } catch (Throwable unused) {
            }
        }
        return i3;
    }
}
