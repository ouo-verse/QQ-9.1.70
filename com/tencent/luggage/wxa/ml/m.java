package com.tencent.luggage.wxa.ml;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface m extends DialogInterface {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a extends m, DialogInterface {
        void setCancelable(boolean z16);

        void setCanceledOnTouchOutside(boolean z16);

        void setMessage(CharSequence charSequence);

        void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

        void setTitle(CharSequence charSequence);
    }

    void a(r rVar);

    boolean a();

    void b(int i3);

    boolean b();

    boolean c();

    View getContentView();

    int getPosition();

    void onCancel();

    void onShown();
}
