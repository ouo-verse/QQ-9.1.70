package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends ActionSheet {
    private InterfaceC8324a C;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public interface InterfaceC8324a {
        void onBackPressed();
    }

    protected a(Context context, boolean z16, boolean z17) {
        super(context, z16, z17);
    }

    public static a n0(Context context) {
        a aVar = new a(context, true, false);
        if (Build.VERSION.SDK_INT != 23) {
            aVar.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return aVar;
    }

    public void o0(InterfaceC8324a interfaceC8324a) {
        this.C = interfaceC8324a;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        InterfaceC8324a interfaceC8324a = this.C;
        if (interfaceC8324a != null) {
            interfaceC8324a.onBackPressed();
        }
    }
}
