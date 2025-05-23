package com.tencent.biz.qqcircle.widgets.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends a {
    protected WeakReference<Context> D;

    public e(Context context) {
        super(context);
        this.D = new WeakReference<>(context);
    }

    public long P() {
        WeakReference<Context> weakReference = this.D;
        if (weakReference != null && weakReference.get() != null) {
            return this.D.get().hashCode();
        }
        return 0L;
    }

    public boolean Q() {
        Context context = this.D.get();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.a, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (Q()) {
            return;
        }
        super.show();
    }

    public e(Context context, int i3) {
        super(context, i3);
        this.D = new WeakReference<>(context);
    }
}
