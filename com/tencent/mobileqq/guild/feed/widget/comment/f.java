package com.tencent.mobileqq.guild.feed.widget.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f extends b {
    protected WeakReference<Context> C;

    public f(Context context, int i3) {
        super(context, i3);
        this.C = new WeakReference<>(context);
    }

    public boolean N() {
        Context context = this.C.get();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (N()) {
            return;
        }
        super.show();
    }
}
