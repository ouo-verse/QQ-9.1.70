package com.qwallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class r extends a {
    public r(Context context, Intent intent) {
        super(context, intent);
    }

    public static boolean o() {
        return QLog.isColorLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        t.a().c(-1, null, true);
    }

    @Nullable
    public Activity p() {
        Context context = this.f41629a;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }
}
