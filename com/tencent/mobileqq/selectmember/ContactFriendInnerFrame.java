package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.widget.TabBarView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ContactFriendInnerFrame extends SelectMemberInnerFrame implements TabBarView.d {
    static IPatchRedirector $redirector_;
    private TabBarView D;
    private FrameLayout E;
    public TroopDiscussionBaseV F;
    private TroopDiscussionBaseV G;
    private TroopDiscussionBaseV H;

    public ContactFriendInnerFrame(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void r() {
        if (this.H == null) {
            FriendTabView friendTabView = new FriendTabView(this.f285782h);
            this.H = friendTabView;
            friendTabView.b(null);
        }
        t(this.H);
    }

    private void s() {
        if (this.G == null) {
            PhoneContactTabView phoneContactTabView = new PhoneContactTabView(this.f285782h, this);
            this.G = phoneContactTabView;
            phoneContactTabView.b(null);
        }
        t(this.G);
    }

    private void t(TroopDiscussionBaseV troopDiscussionBaseV) {
        QBaseActivity qBaseActivity = (QBaseActivity) e();
        TroopDiscussionBaseV troopDiscussionBaseV2 = this.F;
        if (troopDiscussionBaseV2 != troopDiscussionBaseV) {
            if (troopDiscussionBaseV2 != null) {
                if (qBaseActivity.isResume()) {
                    this.F.c();
                }
                this.F.onStop();
            }
            this.F = troopDiscussionBaseV;
            if (troopDiscussionBaseV != null) {
                troopDiscussionBaseV.e(null);
                if (qBaseActivity.isResume()) {
                    this.F.d();
                }
                this.E.removeAllViews();
                this.E.addView(this.F);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.TabBarView.d
    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (i16 != 0) {
                if (i16 == 1) {
                    r();
                    return;
                }
                return;
            }
            s();
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.i(i3, i16, intent);
        if (i3 == 100 && i16 == -1) {
            ((PhoneContactTabView) this.G).p();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        Activity e16 = e();
        setContentView(R.layout.acx);
        TabBarView tabBarView = (TabBarView) findViewById(R.id.j_a);
        this.D = tabBarView;
        tabBarView.setOnTabChangeListener(this);
        this.D.c(0, e16.getString(R.string.a9o));
        this.D.o(0).setContentDescription(HardCodeUtil.qqStr(R.string.l18) + e16.getString(R.string.a9o));
        this.D.c(1, e16.getString(R.string.a9p));
        this.D.o(1).setContentDescription(e16.getString(R.string.a9p));
        this.E = (FrameLayout) findViewById(R.id.dm6);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(false, selectMemberActivity.getString(R.string.f173096hd0), this.f285782h.mTitleString);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), kVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "-1";
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TroopDiscussionBaseV troopDiscussionBaseV = this.H;
        if (troopDiscussionBaseV != null) {
            troopDiscussionBaseV.onDestroy();
        }
        TroopDiscussionBaseV troopDiscussionBaseV2 = this.G;
        if (troopDiscussionBaseV2 != null) {
            troopDiscussionBaseV2.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        TroopDiscussionBaseV troopDiscussionBaseV = this.F;
        if (troopDiscussionBaseV instanceof FriendTabView) {
            ((FriendTabView) troopDiscussionBaseV).g();
        } else if (troopDiscussionBaseV instanceof PhoneContactTabView) {
            ((PhoneContactTabView) troopDiscussionBaseV).m();
        }
    }

    public ContactFriendInnerFrame(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ContactFriendInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
