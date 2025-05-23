package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.adapter.b;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopDiscussionDiscussion extends TroopDiscussionBaseV implements b.d {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.selectmember.adapter.b C;

    /* renamed from: m, reason: collision with root package name */
    private XListView f285853m;

    public TroopDiscussionDiscussion(SelectMemberActivity selectMemberActivity) {
        super(selectMemberActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectMemberActivity);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.b.d
    public void a(DiscussionInfo discussionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) discussionInfo);
        } else if (discussionInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString("group_uin", discussionInfo.uin);
            bundle.putString("group_name", discussionInfo.discussionName);
            this.f285851h.j(7, bundle);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        f(R.layout.byn);
        XListView xListView = (XListView) findViewById(R.id.f167137l64);
        this.f285853m = xListView;
        xListView.setSelector(R.color.ajr);
        com.tencent.mobileqq.selectmember.adapter.b bVar = new com.tencent.mobileqq.selectmember.adapter.b(this.f285848d, this, this.f285853m, this.f285850f, false);
        this.C = bVar;
        bVar.f(true);
        this.f285853m.setAdapter((ListAdapter) this.C);
        this.C.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void e(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            this.C.c();
        }
    }
}
