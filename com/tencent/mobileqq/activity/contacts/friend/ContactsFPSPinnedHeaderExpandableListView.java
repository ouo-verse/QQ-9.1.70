package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class ContactsFPSPinnedHeaderExpandableListView extends FPSPinnedHeaderExpandableListView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181580i;

    public ContactsFPSPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f181580i = true;
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView
    protected void scrollItemView(int i3, int i16, View view, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), view, Integer.valueOf(i17));
        } else if (this.f181580i) {
            super.scrollItemView(i3, i16, view, i17);
        }
    }

    public void setChildViewCanAction(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (expandableListAdapter instanceof BuddyListAdapter) {
            ((BuddyListAdapter) expandableListAdapter).y(z16);
        }
        this.f181580i = z16;
    }

    public ContactsFPSPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f181580i = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ContactsFPSPinnedHeaderExpandableListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f181580i = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }
}
