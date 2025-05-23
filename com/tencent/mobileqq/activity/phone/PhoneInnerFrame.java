package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class PhoneInnerFrame extends InnerFrame {
    static IPatchRedirector $redirector_;
    private PhoneMatchView C;
    private com.tencent.mobileqq.phonecontact.observer.b D;
    boolean E;
    private int F;
    private BaseActivityView.e G;

    /* renamed from: h, reason: collision with root package name */
    private ContactListView f183893h;

    /* renamed from: i, reason: collision with root package name */
    private BaseActivityView f183894i;

    /* renamed from: m, reason: collision with root package name */
    private PhoneLaunchView f183895m;

    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            PhoneInnerFrame phoneInnerFrame = PhoneInnerFrame.this;
            if (phoneInnerFrame.E) {
                phoneInnerFrame.q().getApp().unRegistObserver(this);
                PhoneInnerFrame.this.v();
            }
        }
    }

    public PhoneInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.F = 0;
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    private void s(Intent intent) {
        if (this.f183895m == null) {
            this.f183895m = new PhoneLaunchView(e(), this.F);
        }
        w(intent, this.f183895m);
    }

    private void t() {
        if (this.f183893h == null) {
            this.f183893h = new ContactListView(getContext(), this.F);
        }
        w(null, this.f183893h);
    }

    private void u(Intent intent) {
        if (this.C == null) {
            this.C = new PhoneMatchView(e(), this.F);
        }
        w(intent, this.C);
    }

    private void w(Intent intent, BaseActivityView baseActivityView) {
        BaseActivityView baseActivityView2 = this.f183894i;
        if (baseActivityView2 != baseActivityView) {
            if (baseActivityView2 != null) {
                if (this.E) {
                    baseActivityView2.i();
                }
                this.f183894i.onStop();
            }
            this.f183894i = baseActivityView;
            baseActivityView.h(intent, this);
            this.f183894i.onStart();
            if (this.E) {
                this.f183894i.j();
            }
            setContentView(this.f183894i);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.i(i3, i16, intent);
        BaseActivityView baseActivityView = this.f183894i;
        if (baseActivityView != null) {
            baseActivityView.g(i3, i16, intent);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        BaseActivityView baseActivityView = this.f183894i;
        if (baseActivityView != null) {
            baseActivityView.i();
        }
        ContactListView contactListView = this.f183893h;
        if (contactListView != null) {
            contactListView.i();
        }
        this.E = false;
        super.k();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        BaseActivityView baseActivityView = this.f183894i;
        if (baseActivityView != null) {
            baseActivityView.j();
        }
        this.E = true;
        super.l();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        if (bundle != null) {
            this.F = bundle.getInt("key_req_type");
        }
        v();
        if (this.D == null) {
            this.D = new a();
            q().getApp().registObserver(this.D);
        }
    }

    protected BaseActivityView.e n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BaseActivityView.e) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return null;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            g().i(0);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f183893h = null;
        this.C = null;
        this.f183895m = null;
        this.f183894i = null;
        super.onDestroy();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        BaseActivityView baseActivityView = this.f183894i;
        if (baseActivityView != null) {
            baseActivityView.onStop();
            this.f183894i = null;
            removeAllViews();
        }
        if (this.D != null) {
            q().getApp().unRegistObserver(this.D);
            this.D = null;
        }
        ContactListView contactListView = this.f183893h;
        if (contactListView != null) {
            contactListView.onDestroy();
            this.f183893h = null;
        }
        PhoneLaunchView phoneLaunchView = this.f183895m;
        if (phoneLaunchView != null) {
            phoneLaunchView.onDestroy();
            this.f183895m = null;
        }
        PhoneMatchView phoneMatchView = this.C;
        if (phoneMatchView != null) {
            phoneMatchView.onDestroy();
            this.C = null;
        }
        super.onStop();
    }

    public ForwardBaseOption p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ForwardBaseOption) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ContactListView contactListView = this.f183893h;
        if (contactListView != null) {
            return contactListView.f183808n0;
        }
        return null;
    }

    public final BaseActivityView.e q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (BaseActivityView.e) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.G == null) {
            this.G = n();
        }
        return this.G;
    }

    public void r(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e().overridePendingTransition(i3, i16);
        }
    }

    void v() {
        IPhoneContactService iPhoneContactService = (IPhoneContactService) q().getApp().getRuntimeService(IPhoneContactService.class, "");
        switch (iPhoneContactService.getSelfBindState()) {
            case 0:
            case 7:
            case 8:
            case 9:
                t();
                return;
            case 1:
            case 2:
            case 3:
                if (this.F == 2) {
                    t();
                    return;
                } else {
                    s(null);
                    return;
                }
            case 4:
            case 5:
                s(null);
                return;
            case 6:
                if (!iPhoneContactService.isAutoUploadContacts() && this.F != 2) {
                    u(null);
                    return;
                } else {
                    t();
                    return;
                }
            default:
                t();
                return;
        }
    }

    public void x(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, i3);
            return;
        }
        String className = intent.getComponent().getClassName();
        if (className.equals(ContactListView.class.getName())) {
            t();
            return;
        }
        if (className.equals(PhoneLaunchActivity.class.getName())) {
            s(intent);
        } else if (className.equals(PhoneMatchView.class.getName())) {
            u(null);
        } else {
            e().startActivityForResult(intent, i3);
        }
    }

    public PhoneInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.F = 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public PhoneInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.F = 0;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }
}
