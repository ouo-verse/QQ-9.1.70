package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BaseOCRTextSearchFragment extends QBaseFragment {
    static IPatchRedirector $redirector_;
    public b C;
    public View.OnTouchListener D;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseOCRTextSearchFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            BaseOCRTextSearchFragment.this.C.b(view);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(boolean z16);

        void b(View view);

        Activity getActivity();
    }

    public BaseOCRTextSearchFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.D = new a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        if (activity instanceof OCRTextSearchActivity) {
            this.C = ((OCRTextSearchActivity) activity).f254796s0;
        }
    }
}
