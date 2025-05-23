package com.tencent.mobileqq.friend.phone;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.QUITokenResUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

@ArgusTag(testConfigKey = "argus_contact", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes33.dex */
public class PhoneContactFragment extends ContactsBaseFragment implements od2.a, nb2.a {
    protected View N;
    protected XListView P;
    protected b Q;
    protected FrameLayout R;
    protected PhoneContactStatusCheckView T;
    protected a S = new a();
    protected boolean U = false;
    protected Handler V = new WeakReferenceHandler(Looper.getMainLooper(), null);
    private Runnable W = new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneContactFragment", 2, "reset data for ui");
            }
            PhoneContactFragment phoneContactFragment = PhoneContactFragment.this;
            PhoneContactStatusCheckView phoneContactStatusCheckView = phoneContactFragment.T;
            if (phoneContactStatusCheckView != null) {
                phoneContactStatusCheckView.b(((ContactsBaseFragment) phoneContactFragment).E);
            }
            PhoneContactFragment phoneContactFragment2 = PhoneContactFragment.this;
            if (phoneContactFragment2.P != null) {
                if (phoneContactFragment2.Q == null) {
                    BaseActivity baseActivity = ((ContactsBaseFragment) PhoneContactFragment.this).K;
                    QQAppInterface qQAppInterface = ((ContactsBaseFragment) PhoneContactFragment.this).E;
                    PhoneContactFragment phoneContactFragment3 = PhoneContactFragment.this;
                    phoneContactFragment2.Q = new b(baseActivity, qQAppInterface, phoneContactFragment3.P, 1, true, phoneContactFragment3);
                    PhoneContactFragment phoneContactFragment4 = PhoneContactFragment.this;
                    phoneContactFragment4.P.setAdapter((ListAdapter) phoneContactFragment4.Q);
                }
                PhoneContactFragment phoneContactFragment5 = PhoneContactFragment.this;
                phoneContactFragment5.Q.h(((ContactsBaseFragment) phoneContactFragment5).E);
                PhoneContactFragment.this.Q.notifyDataSetChanged();
            }
        }
    };
    private Runnable X = new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactFragment.3
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.i("PhoneContactFragment", 2, "reset data");
            }
            PhoneContactFragment phoneContactFragment = PhoneContactFragment.this;
            PhoneContactStatusCheckView phoneContactStatusCheckView = phoneContactFragment.T;
            if (phoneContactStatusCheckView != null) {
                phoneContactStatusCheckView.a(((ContactsBaseFragment) phoneContactFragment).E);
            }
            PhoneContactFragment phoneContactFragment2 = PhoneContactFragment.this;
            phoneContactFragment2.V.removeCallbacks(phoneContactFragment2.W);
            PhoneContactFragment phoneContactFragment3 = PhoneContactFragment.this;
            phoneContactFragment3.V.postDelayed(phoneContactFragment3.W, 500L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class a extends com.tencent.mobileqq.phonecontact.observer.b {
        a() {
        }

        private void a(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneContactFragment", 2, String.format("refreshResult [%s]", Boolean.valueOf(z16)));
            }
            PhoneContactFragment phoneContactFragment = PhoneContactFragment.this;
            if (phoneContactFragment.U) {
                if (((ContactsBaseFragment) phoneContactFragment).C != null) {
                    ((ContactsBaseFragment) PhoneContactFragment.this).C.c(PhoneContactFragment.this.th(), z16, null);
                }
                if (z16) {
                    PhoneContactFragment.this.resetData();
                }
                PhoneContactFragment.this.U = false;
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onHideContact(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneContactFragment", 2, String.format("onHideContact [%s]", Boolean.valueOf(z16)));
            }
            PhoneContactFragment.this.resetData();
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneContactFragment", 2, String.format("onQueryBindState [%s, %s]", Boolean.valueOf(z16), Boolean.valueOf(z17)));
            }
            a(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null) {
            ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
            this.E.unRegistObserver(this.S);
            ((INewFriendService) this.E.getRuntimeService(INewFriendService.class, "")).removeListener(this);
        }
        XListView xListView = this.P;
        if (xListView != null) {
            xListView.setAdapter((ListAdapter) null);
        }
        b bVar = this.Q;
        if (bVar != null) {
            bVar.i();
            this.Q.destroy();
            this.Q = null;
        }
    }

    @Override // od2.a
    public void B7(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onUIBitsChanged " + j3);
        }
        resetData();
    }

    @Override // od2.a
    public void L1(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onUpdateContactList " + i3);
        }
        resetData();
    }

    public boolean Qh() {
        PhoneContactStatusCheckView phoneContactStatusCheckView = this.T;
        return phoneContactStatusCheckView != null && phoneContactStatusCheckView.getVisibility() == 0;
    }

    @Override // od2.a
    public void Ug(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onBindStateChanged " + i3);
        }
        resetData();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "doOnDestroy");
        }
        Ah();
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onRecommendCountChanged " + z16 + " " + i3);
        }
        resetData();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        return this.P;
    }

    @Override // nb2.a
    public void onContactCountChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onContactCountChanged");
        }
        resetData();
    }

    @Override // nb2.a
    public void onMayKnowStatesChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "onMayKnowStatesChanged");
        }
        resetData();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface == null || !this.H) {
            return;
        }
        ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
        this.E.registObserver(this.S);
        ((INewFriendService) this.E.getRuntimeService(INewFriendService.class, "")).addListener(this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "doOnPause:" + z16);
        }
        if (z16) {
            Ah();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "refresh");
        }
        resetData();
        ((IPhoneContactService) this.E.getRuntimeService(IPhoneContactService.class, "")).checkUpdateBindStateAndListIgnoreBindState(true, false, 16);
        this.U = true;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "reset data  mIsTabSelected:" + this.H);
        }
        if (this.H) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.X);
            ThreadManager.getSubThreadHandler().postDelayed(this.X, 500L);
        } else {
            b bVar = this.Q;
            if (bVar != null) {
                bVar.h(this.E);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactFragment", 2, "doOnResume:" + z16);
        }
        if (this.P == null) {
            return;
        }
        if (z16) {
            ph();
        }
        if (this.Q == null) {
            b bVar = new b(this.K, this.E, this.P, 1, true, this);
            this.Q = bVar;
            this.P.setAdapter((ListAdapter) bVar);
        }
        this.T.c();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactFragment.1
            @Override // java.lang.Runnable
            public void run() {
                PhoneContactFragment phoneContactFragment = PhoneContactFragment.this;
                phoneContactFragment.T.a(((ContactsBaseFragment) phoneContactFragment).E);
                PhoneContactFragment.this.V.post(new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PhoneContactFragment phoneContactFragment2 = PhoneContactFragment.this;
                        phoneContactFragment2.T.b(((ContactsBaseFragment) phoneContactFragment2).E);
                        b bVar2 = PhoneContactFragment.this.Q;
                        if (bVar2 != null) {
                            bVar2.notifyDataSetChanged();
                        }
                    }
                });
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        View view = this.N;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.f167812i8, (ViewGroup) null, false);
            this.N = inflate;
            this.P = (XListView) inflate.findViewById(R.id.fmq);
            this.R = new FrameLayout(this.N.getContext());
            this.R.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.P.addHeaderView(this.R);
            PhoneContactStatusCheckView phoneContactStatusCheckView = new PhoneContactStatusCheckView(this.N.getContext());
            this.T = phoneContactStatusCheckView;
            phoneContactStatusCheckView.setOrientation(1);
            this.T.setGravity(17);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159249yi);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
            layoutParams.gravity = 17;
            Rect rect = ContactsBaseFragment.M;
            if (rect != null) {
                layoutParams.height = Math.max(dimensionPixelSize, rect.bottom - rect.top);
            }
            this.T.setLayoutParams(layoutParams);
            this.R.addView(this.T, layoutParams);
            this.P.setSelector(new ColorDrawable(0));
            this.P.setNeedCheckSpringback(true);
            this.P.setCacheColorHint(0);
            this.P.setDivider(null);
            this.P.setOverScrollMode(0);
            this.P.mForContacts = true;
            this.T.setVisibility(8);
            this.T.setPhoneContactFragment(this);
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.N);
            }
        }
        return this.N;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void zh(boolean z16, int i3) {
        super.zh(z16, i3);
        if (this.T != null) {
            int i16 = 0;
            if (QUITokenResUtil.useQUIToken()) {
                this.N.findViewById(R.id.root).setBackgroundColor(0);
            } else {
                View findViewById = this.N.findViewById(R.id.root);
                if (QQTheme.isNowSimpleUI()) {
                    i16 = QQTheme.isNowThemeIsNight() ? -16777216 : -1;
                }
                findViewById.setBackgroundColor(i16);
            }
            this.T.f(z16);
        }
    }

    @Override // od2.a
    public void T2(int i3) {
    }

    @Override // nb2.a
    public void onUnreadChanged(int i3) {
    }
}
