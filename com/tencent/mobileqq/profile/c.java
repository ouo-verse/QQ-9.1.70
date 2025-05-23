package com.tencent.mobileqq.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends com.tencent.mobileqq.picbrowser.b {
    static IPatchRedirector $redirector_;
    FriendProfilePicBrowserActivity Q;

    public c(FriendProfilePicBrowserActivity friendProfilePicBrowserActivity, com.tencent.common.galleryactivity.e eVar) {
        super(friendProfilePicBrowserActivity, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) friendProfilePicBrowserActivity, (Object) eVar);
        } else {
            this.Q = friendProfilePicBrowserActivity;
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.common.galleryactivity.c
    public void E(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            return;
        }
        super.E(viewGroup);
        PicBrowserGalleryAdapter picBrowserGalleryAdapter = this.K;
        if (picBrowserGalleryAdapter != null) {
            picBrowserGalleryAdapter.j(this.Q);
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.b
    protected void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        FriendProfilePicBrowserActivity friendProfilePicBrowserActivity = this.Q;
        if (friendProfilePicBrowserActivity != null) {
            friendProfilePicBrowserActivity.showActionSheet();
        }
    }

    public int R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        com.tencent.mobileqq.picbrowser.c cVar = this.M;
        if (cVar != null) {
            return cVar.getSelectedIndex();
        }
        return -1;
    }

    public PicInfo S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PicInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.M.b() != null) {
            return this.M.b().f258907e;
        }
        return null;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        PicBrowserGalleryAdapter picBrowserGalleryAdapter = this.K;
        if (picBrowserGalleryAdapter != null) {
            picBrowserGalleryAdapter.j(null);
        }
        this.Q = null;
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.h
    public void onExitAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onExitAnimationStart();
        FriendProfilePicBrowserActivity friendProfilePicBrowserActivity = this.Q;
        if (friendProfilePicBrowserActivity != null) {
            friendProfilePicBrowserActivity.c3();
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.b, com.tencent.common.galleryactivity.c
    protected RelativeLayout s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (RelativeLayout) LayoutInflater.from(this.F).inflate(R.layout.b0w, (ViewGroup) null);
    }
}
