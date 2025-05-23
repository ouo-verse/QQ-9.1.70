package hq3;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b {

    /* compiled from: P */
    /* renamed from: hq3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC10469b {
        void onError(int i3, String str);

        void onSuccess(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f405942a;

        /* renamed from: b, reason: collision with root package name */
        private int f405943b;

        /* renamed from: c, reason: collision with root package name */
        private int f405944c = R.string.f172882rn;

        /* renamed from: d, reason: collision with root package name */
        private String f405945d;

        /* renamed from: e, reason: collision with root package name */
        private int f405946e;

        /* renamed from: f, reason: collision with root package name */
        private int f405947f;

        /* compiled from: P */
        /* renamed from: hq3.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class DialogInterfaceOnClickListenerC10467a implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f405948d;

            DialogInterfaceOnClickListenerC10467a(c cVar) {
                this.f405948d = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 == 1) {
                    this.f405948d.c();
                } else if (i3 == 0) {
                    this.f405948d.b();
                }
            }
        }

        /* compiled from: P */
        /* renamed from: hq3.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class DialogInterfaceOnCancelListenerC10468b implements DialogInterface.OnCancelListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f405950d;

            DialogInterfaceOnCancelListenerC10468b(c cVar) {
                this.f405950d = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f405950d.a();
            }
        }

        public a(Context context, String str, int i3) {
            this.f405942a = context;
            this.f405945d = str;
            this.f405943b = i3;
            if (i3 == 1) {
                this.f405946e = R.string.f172902rp;
            } else {
                this.f405946e = R.string.f172892ro;
            }
            this.f405947f = R.string.cancel;
        }

        public void a(c cVar) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f405942a, 230);
            createCustomDialog.setTitle(this.f405944c);
            createCustomDialog.setMessage(this.f405945d);
            DialogInterfaceOnClickListenerC10467a dialogInterfaceOnClickListenerC10467a = new DialogInterfaceOnClickListenerC10467a(cVar);
            createCustomDialog.setPositiveButton(this.f405946e, dialogInterfaceOnClickListenerC10467a);
            if (this.f405943b == 2) {
                createCustomDialog.setNegativeButton(this.f405947f, dialogInterfaceOnClickListenerC10467a);
            }
            createCustomDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC10468b(cVar));
            createCustomDialog.show();
        }

        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class c {
            public void a() {
                throw null;
            }

            public void c() {
                throw null;
            }

            public void b() {
            }
        }
    }
}
