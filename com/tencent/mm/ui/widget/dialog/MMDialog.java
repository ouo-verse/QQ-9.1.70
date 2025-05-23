package com.tencent.mm.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.tencent.luggage.wxa.lo.n;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public Runnable f153065a;

    /* renamed from: b, reason: collision with root package name */
    public IOnDialogDismissListener f153066b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f153067c;

    public MMDialog(Context context) {
        super(context);
        this.f153067c = new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMDialog.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.c("MicroMsg.MMDialog", "run on hijack runnable", new Object[0]);
                    MMDialog.this.f153065a.run();
                } catch (Exception e16) {
                    n.b("MicroMsg.MMDialog", "protect : " + e16.getMessage(), new Object[0]);
                }
            }
        };
        d();
    }

    public final void d() {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        try {
            Field declaredField = Dialog.class.getDeclaredField("mDismissAction");
            declaredField.setAccessible(true);
            try {
                Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
            } catch (Exception unused) {
            }
            this.f153065a = (Runnable) declaredField.get(this);
            declaredField.set(this, this.f153067c);
        } catch (IllegalAccessException unused2) {
            n.b("MicroMsg.MMDialog", "hijack fail IllegalAccessException", new Object[0]);
        } catch (NoSuchFieldException unused3) {
            n.b("MicroMsg.MMDialog", "hijack fail NoSuchFieldException", new Object[0]);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            n.a("MicroMsg.MMDialog", e16, "", new Object[0]);
        }
        IOnDialogDismissListener iOnDialogDismissListener = this.f153066b;
        if (iOnDialogDismissListener != null) {
            iOnDialogDismissListener.onDialogDismiss(this);
        }
    }

    public void setiOnDialogDismissListener(IOnDialogDismissListener iOnDialogDismissListener) {
        this.f153066b = iOnDialogDismissListener;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e16) {
            n.a("MicroMsg.MMDialog", e16, "", new Object[0]);
        }
    }

    public MMDialog(Context context, int i3) {
        super(context, i3);
        this.f153067c = new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMDialog.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.c("MicroMsg.MMDialog", "run on hijack runnable", new Object[0]);
                    MMDialog.this.f153065a.run();
                } catch (Exception e16) {
                    n.b("MicroMsg.MMDialog", "protect : " + e16.getMessage(), new Object[0]);
                }
            }
        };
        d();
    }
}
