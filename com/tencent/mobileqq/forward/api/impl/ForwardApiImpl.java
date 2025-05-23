package com.tencent.mobileqq.forward.api.impl;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardApiImpl implements IForwardApi {
    static IPatchRedirector $redirector_;

    public ForwardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String KEY_DIRECT_SHOW_UIN() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "key_direct_show_uin";
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String KEY_DIRECT_SHOW_UIN_TYPE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "key_direct_show_uin_type";
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String KEY_REQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public int REQ_DIRECT_SHOW_DIALOG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String SELECTION_MODE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ForwardRecentActivity.SELECTION_MODE;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public int SELECTION_MODE_MULTI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public int SEND_ASK_ANONYMOUSLY_ARK_MSG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 46;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public Class getForwardRecentActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ForwardRecentActivity.class;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public Class getForwardRecentTranslucentActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return ForwardRecentTranslucentActivity.class;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String keyDirectShowMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "direct_show_msg";
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String keyForwardTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return ForwardRecentActivity.KEY_FORWARD_TITLE;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String keyIsShowRecentChatList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return ForwardRecentActivity.KEY_IS_SHOW_RECENT_CHAT_LIST;
    }

    @Override // com.tencent.mobileqq.forward.api.IForwardApi
    public String keyIsShowRecentForwardList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return ForwardRecentActivity.KEY_IS_SHOW_RECENT_FORWARD_LIST;
    }
}
