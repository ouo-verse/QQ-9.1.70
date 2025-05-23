package com.qq.e.comm.plugin.e.a;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends a {
    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Boolean> c(int i3, boolean z16) {
        if (GlobalSetting.isAgreePrivacyStrategy()) {
            return new Pair<>(Boolean.FALSE, null);
        }
        String c16 = d.a().c();
        if (TextUtils.isEmpty(c16)) {
            c16 = d.a().d();
        }
        if (!TextUtils.isEmpty(c16) && c16.contains(String.valueOf(i3))) {
            return new Pair<>(Boolean.TRUE, Boolean.FALSE);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Object> d(int i3, boolean z16) {
        return new Pair<>(Boolean.FALSE, null);
    }
}
