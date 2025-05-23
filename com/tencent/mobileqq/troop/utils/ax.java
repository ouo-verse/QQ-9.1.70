package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ax {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f302091a;

    /* renamed from: b, reason: collision with root package name */
    private static HashSet<Integer> f302092b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f302093d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object[] f302094e;

        a(c cVar, Object[] objArr) {
            this.f302093d = cVar;
            this.f302094e = objArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) objArr);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            c cVar = this.f302093d;
            if (cVar != null) {
                cVar.a(this.f302094e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(Object... objArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f302091a = false;
        HashSet<Integer> hashSet = new HashSet<>();
        f302092b = hashSet;
        hashSet.add(1);
        f302092b.add(2);
        f302092b.add(10);
        f302092b.add(12);
        f302092b.add(22);
        f302092b.add(13);
    }

    public static boolean a() {
        return f302091a;
    }

    public static void b(boolean z16) {
        f302091a = z16;
    }

    public static void c(Context context, c cVar, Object... objArr) {
        if (context == null) {
            return;
        }
        DialogUtil.createCustomDialog(context, context.getString(R.string.f235377bh), context.getString(R.string.f235367bg), (String) null, R.string.cancel, R.string.ctx, new a(cVar, objArr), new b()).show();
    }
}
