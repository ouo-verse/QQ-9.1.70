package com.tencent.luggage.wxa.g6;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends Dialog implements k {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements DialogInterface.OnKeyListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f126554a = new a();

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            boolean z16;
            if (i3 != 4) {
                return false;
            }
            if (keyEvent != null && keyEvent.getRepeatCount() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z16) {
        super.setCanceledOnTouchOutside(z16);
        if (!z16) {
            setOnKeyListener(a.f126554a);
        }
    }

    public /* synthetic */ m(Context context, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? R.style.a0a : i3);
    }
}
