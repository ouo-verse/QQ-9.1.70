package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends SimpleFilePresenter implements e.d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC7521a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC7521a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.f205963d.c();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f206002d;

        b(String str) {
            this.f206002d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a aVar = a.this;
                aVar.f205963d.a0(aVar.f205966h, this.f206002d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
        } else {
            b0(new SimpleFileBrowserView(activity));
        }
    }

    private void d0(int i3, String str, String str2) {
        if (i3 != 0 && i3 != 4 && !TextUtils.isEmpty(str)) {
            this.H.v(BaseApplication.getContext().getString(R.string.beq), false);
            if (!TextUtils.isEmpty(str2)) {
                this.H.H(str, 0, new b(str2));
            } else {
                this.H.H(str, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.C();
        if (this.f205963d.O() == 2) {
            this.H.e(this.f205966h.getString(R.string.bem), new ViewOnClickListenerC7521a());
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
        }
        this.H.v(this.f205966h.getString(R.string.beq), true);
        this.H.N(false);
        d0(this.f205964e.g(), this.f205964e.f(), this.f205964e.i());
        this.H.A(R.drawable.e98);
        this.H.z(this.f205964e.e());
        this.f205963d.l(this);
    }

    @Override // com.tencent.mobileqq.filebrowser.e.d
    public void h(int i3, String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, bundle);
        } else {
            d0(i3, str, str2);
        }
    }
}
