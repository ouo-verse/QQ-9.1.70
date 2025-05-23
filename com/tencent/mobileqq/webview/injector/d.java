package com.tencent.mobileqq.webview.injector;

import android.content.Context;
import android.content.DialogInterface;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d implements com.tencent.mobileqq.webview.swift.injector.e {

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f313967d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f313968e;

        b(Context context, String str) {
            this.f313967d = context;
            this.f313968e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((ClipboardManager) this.f313967d.getSystemService("clipboard")).setText(this.f313968e);
            Toast.makeText(this.f313967d.getApplicationContext(), R.string.f214345sn, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.e
    public void a(Context context, String str, int i3) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setContentView(R.layout.f167857jo);
        createCustomDialog.getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
        createCustomDialog.setTitle(i3);
        createCustomDialog.setMessage(str);
        createCustomDialog.getMessageTextView().setMaxLines(20);
        createCustomDialog.getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
        createCustomDialog.setPositiveButton("Close", new a());
        createCustomDialog.setNegativeButton("Copy", new b(context, str));
        createCustomDialog.show();
    }
}
