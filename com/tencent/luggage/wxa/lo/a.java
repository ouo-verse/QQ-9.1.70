package com.tencent.luggage.wxa.lo;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog;
import com.tencent.mm.ui.widget.dialog.MMProgressDialog;
import com.tencent.mm.ui.widget.dialog.WeToast;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public static MMAlertDialog.Builder f133700a;

    /* renamed from: b, reason: collision with root package name */
    public static MMHalfBottomDialog.Builder f133701b;

    /* renamed from: c, reason: collision with root package name */
    public static MMProgressDialog.Builder f133702c;

    /* renamed from: d, reason: collision with root package name */
    public static WeToast.Builder f133703d;

    public static void a(MMAlertDialog.Builder builder) {
        f133700a = builder;
    }

    public static void a(MMHalfBottomDialog.Builder builder) {
        f133701b = builder;
    }

    public static void a(MMProgressDialog.Builder builder) {
        f133702c = builder;
    }

    public static void a(WeToast.Builder builder) {
        f133703d = builder;
    }
}
