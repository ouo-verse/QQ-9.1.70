package com.tencent.creatorad.api.impl;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.creatorad.api.ICreatorAd;
import com.tencent.creatorad.data.DataManager;
import com.tencent.creatorad.debug.DemoFragment;
import com.tencent.creatorad.ui.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CreatorAdImpl implements ICreatorAd {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CreatorAdImpl";

    public CreatorAdImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.creatorad.api.ICreatorAd
    public void instanceAd(String str, int i3, ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), viewGroup, layoutParams);
        } else {
            e.e().f(str, i3, viewGroup, layoutParams);
        }
    }

    @Override // com.tencent.creatorad.api.ICreatorAd
    public void notifyBannerParentStatus(ViewGroup viewGroup, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.e().h(viewGroup, i3, i16);
        }
    }

    @Override // com.tencent.creatorad.api.ICreatorAd
    public void preloadAdList(List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, i3);
        } else {
            DataManager.d().c(list, i3);
        }
    }

    @Override // com.tencent.creatorad.api.ICreatorAd
    public void startCreatorAdDemoFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            DemoFragment.start(activity, DemoFragment.class);
        }
    }
}
