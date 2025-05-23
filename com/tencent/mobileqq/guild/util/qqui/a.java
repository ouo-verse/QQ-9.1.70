package com.tencent.mobileqq.guild.util.qqui;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.util.qqui.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class DialogInterfaceOnClickListenerC7912a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f235596d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f235597e;

        DialogInterfaceOnClickListenerC7912a(d dVar, QQCustomDialog qQCustomDialog) {
            this.f235596d = dVar;
            this.f235597e = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f235596d.onCancelClick();
            this.f235597e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f235598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f235599e;

        b(d dVar, QQCustomDialog qQCustomDialog) {
            this.f235598d = dVar;
            this.f235599e = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f235598d.k();
            this.f235599e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f235600a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f235601b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f235602c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f235603d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f235604e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f235605f = HardCodeUtil.qqStr(R.string.f171151ok);

        /* renamed from: g, reason: collision with root package name */
        public String f235606g = HardCodeUtil.qqStr(R.string.cancel);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void k();

        void onCancelClick();
    }

    public static QQCustomDialog a(Context context, c cVar, d dVar) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, null, cVar.f235600a, null, null);
        createCustomDialog.setNegativeButton(cVar.f235606g, cVar.f235601b, new DialogInterfaceOnClickListenerC7912a(dVar, createCustomDialog));
        createCustomDialog.setPositiveButton(cVar.f235605f, cVar.f235601b, new b(dVar, createCustomDialog));
        int i3 = cVar.f235602c;
        if (i3 != 0) {
            createCustomDialog.setMessageTextColor(i3);
        }
        int i16 = cVar.f235603d;
        if (i16 != 0) {
            createCustomDialog.setBackground(i16);
        }
        if (cVar.f235604e != 0) {
            createCustomDialog.getDialogDivider().setBackgroundColor(cVar.f235604e);
        }
        createCustomDialog.show();
        return createCustomDialog;
    }
}
