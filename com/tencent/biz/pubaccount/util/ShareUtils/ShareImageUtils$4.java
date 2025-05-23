package com.tencent.biz.pubaccount.util.ShareUtils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes4.dex */
class ShareImageUtils$4 implements Runnable {
    ShareImageUtils$4() {
    }

    @Override // java.lang.Runnable
    public void run() {
        QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.cwi), 0).show();
    }
}
