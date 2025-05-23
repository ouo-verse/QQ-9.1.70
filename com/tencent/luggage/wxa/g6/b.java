package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends WeUIProgresssDialog {

    /* renamed from: e, reason: collision with root package name */
    public final View f126462e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f126463f;

    /* renamed from: g, reason: collision with root package name */
    public final MMProgressLoading f126464g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f126466b;

        public a(int i3) {
            this.f126466b = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.setProgress(this.f126466b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.ayj);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.i8g, null);
        this.f126462e = inflate;
        View findViewById = inflate.findViewById(R.id.f125627mk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026.wxa_progress_dialog_msg)");
        this.f126463f = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f125637ml);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026_dialog_progress_loading)");
        this.f126464g = (MMProgressLoading) findViewById2;
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.luggage.wxa.lo.f.a(getContext(), getWindow());
        setContentView(this.f126462e);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f126463f.setText(charSequence);
    }

    @Override // android.app.ProgressDialog
    public void setProgress(int i3) {
        if (!c0.b()) {
            this.f126462e.post(new a(i3));
            return;
        }
        this.f126464g.setVisibility(0);
        this.f126462e.findViewById(R.id.f125617mj).setVisibility(8);
        this.f126464g.setProgress(i3);
    }
}
