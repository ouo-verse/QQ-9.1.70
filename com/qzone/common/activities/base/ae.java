package com.qzone.common.activities.base;

import android.text.TextUtils;
import com.qzone.util.ToastUtil;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.annotation.Singleton;

/* compiled from: P */
@Singleton
@Named("BaseFragmentToastImp")
/* loaded from: classes39.dex */
public class ae implements d5.ae {
    @Inject
    public ae() {
    }

    @Override // d5.ae
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.r(str);
    }

    @Override // d5.ae
    public void b(int i3) {
        ToastUtil.n(i3);
    }

    @Override // d5.ae
    public void c(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.s(str, i3);
    }

    @Override // d5.ae
    public void toast(int i3, int i16) {
        ToastUtil.o(i3, i16);
    }
}
