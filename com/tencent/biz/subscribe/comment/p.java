package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p extends a {
    protected WeakReference<Context> C;

    public p(Context context, int i3) {
        super(context, i3);
        this.C = new WeakReference<>(context);
    }

    public boolean O() {
        Context context = this.C.get();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (O()) {
            return;
        }
        super.show();
    }
}
