package com.qzone.reborn.part.publish.common.inputarea;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private QQToast f58570a;

    public abstract String a();

    public abstract int b();

    public abstract void c(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        QQToast qQToast = this.f58570a;
        if (qQToast == null) {
            this.f58570a = QQToast.makeText(BaseApplication.getContext(), 1, str, 0);
        } else {
            qQToast.setToastMsg(str);
        }
        if (this.f58570a.isShowing()) {
            return;
        }
        this.f58570a.show();
    }
}
