package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i3) {
        return new DialogRedirectImpl(intent, activity, i3);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        try {
            try {
                redirect();
            } catch (Throwable unused) {
                HMSLog.e("DialogRedirect", "Failed to start resolution intent");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    protected abstract void redirect();
}
