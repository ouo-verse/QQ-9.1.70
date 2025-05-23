package com.tencent.mobileqq.profilecard.bussiness.musicbox;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes16.dex */
public class ElegantProfileMusicBoxComponent extends ProfileMusicBoxComponent {
    static IPatchRedirector $redirector_ = null;
    private static final int TITLE_HEIGHT = 48;

    public ElegantProfileMusicBoxComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent
    public boolean makeOrRefreshMusicBox(Card card) {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) card)).booleanValue();
        }
        boolean makeOrRefreshMusicBox = super.makeOrRefreshMusicBox(card);
        VIEW view = this.mViewContainer;
        if (view != 0 && (findViewById = ((View) view).findViewById(R.id.f164866b64)) != null) {
            findViewById.getLayoutParams().height = ViewUtils.dpToPx(48.0f);
        }
        return makeOrRefreshMusicBox;
    }
}
