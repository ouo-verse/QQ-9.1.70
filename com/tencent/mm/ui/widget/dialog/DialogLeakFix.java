package com.tencent.mm.ui.widget.dialog;

import android.app.Dialog;
import android.os.Message;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class DialogLeakFix {
    DialogLeakFix() {
    }

    public static void a(Dialog dialog, String str) {
        try {
            Message message = (Message) Reflect.on(dialog).get(str);
            if (message != null) {
                message.recycle();
            }
        } catch (Exception unused) {
        }
        try {
            Reflect.on(dialog).set(str, null);
        } catch (Exception unused2) {
        }
    }

    public static void clearReferencesOnDismiss(Dialog dialog) {
        a(dialog, "mCancelMessage");
        a(dialog, "mDismissMessage");
        a(dialog, "mShowMessage");
        try {
            dialog.setOnCancelListener(null);
        } catch (Exception unused) {
        }
        try {
            dialog.setOnDismissListener(null);
        } catch (Exception unused2) {
        }
        try {
            dialog.setOnShowListener(null);
        } catch (Exception unused3) {
        }
    }
}
