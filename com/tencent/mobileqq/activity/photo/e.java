package com.tencent.mobileqq.activity.photo;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String[] f184453a;

    /* renamed from: b, reason: collision with root package name */
    PhotoCropActivity f184454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f184455d;

        a(ActionSheet actionSheet) {
            this.f184455d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            e eVar = e.this;
            if (i3 != eVar.f184453a.length) {
                eVar.a(i3);
                e.this.f184454b.Z2();
            }
            this.f184455d.dismiss();
        }
    }

    public e(PhotoCropActivity photoCropActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) photoCropActivity);
        } else {
            this.f184454b = photoCropActivity;
        }
    }

    public void a(int i3) {
        throw null;
    }

    public void b(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr);
        } else {
            this.f184453a = strArr;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String[] strArr = this.f184453a;
        if (strArr != null && strArr.length > 0) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f184454b, null);
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f184453a;
                if (i3 < strArr2.length) {
                    actionSheet.addButton(strArr2[i3], 1);
                    i3++;
                } else {
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new a(actionSheet));
                    actionSheet.show();
                    return;
                }
            }
        }
    }
}
