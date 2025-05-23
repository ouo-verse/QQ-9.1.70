package com.qzone.reborn.qzmoment.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends a {
    protected WeakReference<Context> C;

    public h(Context context, int i3) {
        super(context, i3);
        this.C = new WeakReference<>(context);
    }

    public boolean O() {
        Context context = this.C.get();
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (O()) {
            return;
        }
        super.show();
    }
}
