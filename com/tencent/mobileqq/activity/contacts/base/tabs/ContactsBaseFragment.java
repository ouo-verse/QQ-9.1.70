package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.h;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class ContactsBaseFragment extends BaseFragment implements h.a, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    public static Rect M;
    protected c C;
    protected b D;
    protected QQAppInterface E;
    protected View F;
    public boolean G;
    public boolean H;
    private int I;
    private int J;
    protected BaseActivity K;
    protected boolean L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsBaseFragment.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 8) {
                i3 = 32768;
            }
            super.sendAccessibilityEvent(view, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void b();

        void c(int i3, boolean z16, Object obj);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            M = null;
        }
    }

    public ContactsBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.L = false;
        }
    }

    private void vh(View view, int i3) {
        if (i3 != -1 && view != null) {
            view.setPadding(0, 0, 0, i3);
        }
    }

    protected abstract void Ah();

    public void Bh(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) baseActivity);
        } else {
            this.K = baseActivity;
        }
    }

    public void Ch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.I = i3;
        }
    }

    public void Dh(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bVar);
        } else {
            this.D = bVar;
        }
    }

    public void Eh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public void Fh(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            this.C = cVar;
        }
    }

    public abstract void doOnDestroy();

    public View getScrollableView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.F;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.BaseFragment", 2, "pos:" + th() + " onAttach");
        }
        super.onAttach(activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.BaseFragment", 2, "pos:" + th() + " onCreate");
        }
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @TargetApi(16)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            view = (View) iPatchRedirector.redirect((short) 14, this, layoutInflater, viewGroup, bundle);
        } else {
            StringBuilder sb5 = new StringBuilder();
            if (QLog.isColorLevel()) {
                sb5.append("pos:" + th() + " onCreateView\n");
            }
            this.F = uh(layoutInflater, bundle);
            View scrollableView = getScrollableView();
            if (scrollableView != null) {
                scrollableView.setAccessibilityDelegate(new a());
            }
            if (this.F != null && this.G) {
                if (QLog.isColorLevel()) {
                    sb5.append("onCreateView->doOnResume\n");
                }
                this.G = false;
                rh(true);
            }
            if (sb5.length() > 0) {
                QLog.d("Contacts.BaseFragment", 2, sb5.toString());
            }
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.BaseFragment", 2, "pos:" + th() + " onDestroy");
        }
        super.onDestroy();
        if (this.E != null) {
            Ah();
        }
        this.F = null;
        this.G = false;
        b bVar = this.D;
        if (bVar != null) {
            bVar.a(this.I);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.BaseFragment", 2, "pos:" + th() + " onDestroyView");
        }
        super.onDestroyView();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.BaseFragment", 2, "pos:" + th() + " onDetach");
        }
        super.onDetach();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) absListView, i3);
            return;
        }
        if (absListView == null) {
            return;
        }
        if (i3 != 0) {
            ApngImage.pauseByTag(3);
        }
        if (i3 == 0) {
            ApngImage.playByTag(3);
        }
    }

    protected abstract void ph();

    public abstract void qh(boolean z16);

    public abstract void refresh();

    public abstract void resetData();

    public abstract void rh(boolean z16);

    public void setApp(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        QQAppInterface qQAppInterface2 = this.E;
        if (qQAppInterface2 != null && qQAppInterface != qQAppInterface2) {
            Ah();
        }
        this.E = qQAppInterface;
        ph();
    }

    public int sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.I;
    }

    public int th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.J;
    }

    protected abstract View uh(LayoutInflater layoutInflater, Bundle bundle);

    public void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.E != null) {
            Ah();
        }
    }

    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void yh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.H = z16;
        this.G = z16;
        if (this.F != null) {
            if (z16) {
                rh(true);
            } else {
                qh(true);
            }
        }
    }

    public void zh(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            vh(getScrollableView(), i3);
        }
    }
}
