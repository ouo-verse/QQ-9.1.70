package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.widget.TabBarView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopDiscussionListInnerFrame extends SelectMemberInnerFrame implements TabBarView.d {
    static IPatchRedirector $redirector_;
    private Bundle D;
    private TabBarView E;
    private FrameLayout F;
    private TroopDiscussionBaseV G;
    private TroopDiscussionBaseV H;
    private TroopDiscussionBaseV I;

    public TroopDiscussionListInnerFrame(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void t(TroopDiscussionBaseV troopDiscussionBaseV) {
        QBaseActivity qBaseActivity = (QBaseActivity) e();
        TroopDiscussionBaseV troopDiscussionBaseV2 = this.G;
        if (troopDiscussionBaseV2 != troopDiscussionBaseV) {
            if (troopDiscussionBaseV2 != null) {
                if (qBaseActivity.isResume()) {
                    this.G.c();
                }
                this.G.onStop();
            }
            this.G = troopDiscussionBaseV;
            if (troopDiscussionBaseV != null) {
                troopDiscussionBaseV.e(null);
                if (qBaseActivity.isResume()) {
                    this.G.d();
                }
                this.F.removeAllViews();
                this.F.addView(this.G);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.TabBarView.d
    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
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
        this.D = bundle;
        TabBarView tabBarView = (TabBarView) findViewById(R.id.j_a);
        this.E = tabBarView;
        tabBarView.setOnTabChangeListener(this);
        this.E.c(0, e16.getString(R.string.a_6));
        this.E.o(0).setContentDescription(HardCodeUtil.qqStr(R.string.udl) + e16.getString(R.string.a_6));
        if (!this.f285782h.mDonotNeedDiscussion) {
            this.E.c(1, e16.getString(R.string.a_3));
            this.E.o(1).setContentDescription(e16.getString(R.string.a_3));
        }
        this.E.setVisibility(8);
        this.F = (FrameLayout) findViewById(R.id.dm6);
        this.E.setSelectedTab(0, false);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mOnlySelectTroopOrDiscussionMember) {
            selectMemberActivity.setupTitleBar(false, selectMemberActivity.getString(R.string.f173096hd0), this.f285782h.getString(R.string.hds));
        } else {
            selectMemberActivity.setupTitleBar(true, "", selectMemberActivity.getString(R.string.hds));
        }
        if (this.f285782h.mSelectedAndSearchBar.E()) {
            this.f285782h.mSelectedAndSearchBar.v();
            this.f285782h.quitSearchState();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), kVar);
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        return iSearchViewCreator.createNTContactSearchFragment(-1, 2097176, null, selectMemberActivity.mUinsToHide, false, 0, -1L, selectMemberActivity, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "-1";
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        TroopDiscussionBaseV troopDiscussionBaseV = this.H;
        if (troopDiscussionBaseV != null) {
            troopDiscussionBaseV.onDestroy();
        }
        TroopDiscussionBaseV troopDiscussionBaseV2 = this.I;
        if (troopDiscussionBaseV2 != null) {
            troopDiscussionBaseV2.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.I == null) {
            TroopDiscussionDiscussion troopDiscussionDiscussion = new TroopDiscussionDiscussion(this.f285782h);
            this.I = troopDiscussionDiscussion;
            troopDiscussionDiscussion.b(this.D);
        }
        t(this.I);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.H == null) {
            TroopDiscussionTroop troopDiscussionTroop = new TroopDiscussionTroop(this.f285782h);
            this.H = troopDiscussionTroop;
            troopDiscussionTroop.b(this.D);
        }
        t(this.H);
    }

    public TroopDiscussionListInnerFrame(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TroopDiscussionListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
