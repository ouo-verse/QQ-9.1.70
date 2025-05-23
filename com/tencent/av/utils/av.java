package com.tencent.av.utils;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class av {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f77060a = 2131378128;

        /* renamed from: b, reason: collision with root package name */
        public static final int f77061b = 2131385725;

        /* renamed from: c, reason: collision with root package name */
        public static final int f77062c = 2131365922;

        /* renamed from: d, reason: collision with root package name */
        public static final int f77063d = 2131385750;
    }

    public static int a(View view, int i3) {
        Object tag = view.getTag(i3);
        if (tag == null) {
            return Integer.MAX_VALUE;
        }
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        b("getInt", i3, tag);
        return Integer.MAX_VALUE;
    }

    static void b(String str, int i3, Object obj) {
        if (!e.j()) {
            return;
        }
        String str2 = str + HardCodeUtil.qqStr(R.string.tzh) + i3 + "], object[" + obj.getClass().getSimpleName() + "]";
        QLog.w("TagIndex", 1, str2, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        throw new ClassCastException(str2);
    }
}
