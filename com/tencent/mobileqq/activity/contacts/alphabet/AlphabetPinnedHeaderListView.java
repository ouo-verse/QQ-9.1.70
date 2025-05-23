package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.PinnedDividerListView;

/* loaded from: classes10.dex */
public class AlphabetPinnedHeaderListView extends PinnedDividerListView {
    static IPatchRedirector $redirector_;
    private boolean E;

    public AlphabetPinnedHeaderListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.E = true;
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public void setChildViewCanAction(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        PinnedDividerListView.a b06 = b0();
        if (b06 instanceof AlphabetFriendAdapter) {
            ((AlphabetFriendAdapter) b06).u(z16);
        }
        this.E = z16;
    }

    public AlphabetPinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.E = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public AlphabetPinnedHeaderListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.E = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }
}
