package com.tencent.mobileqq.doodle.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.doodle.IDoodlePanelHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes10.dex */
public class DoodlePanelHelperImpl implements IDoodlePanelHelper {
    static IPatchRedirector $redirector_;

    public DoodlePanelHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public BaseDoodleMsgLayout createMsgLayout(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseDoodleMsgLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new DoodleMsgLayout(context, null);
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            PlayLastLogic.d();
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void destroyCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            DoodleResHelper.k().a();
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public BaseDoodlePanel getDoodlePanel(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseDoodlePanel) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return (BaseDoodlePanel) View.inflate(context, R.layout.f167588b8, null);
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public long getMsgID(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, (Object) chatMessage)).longValue();
        }
        return PlayLastLogic.e(chatMessage);
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public long getUniID(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, (Object) chatMessage)).longValue();
        }
        return PlayLastLogic.f(chatMessage);
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public boolean isNewMsgAndNotPlayed(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
        }
        return PlayLastLogic.g().h(j3, j16);
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void playLayout(BaseDoodleMsgLayout baseDoodleMsgLayout, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, baseDoodleMsgLayout, Boolean.valueOf(z16));
        } else {
            PlayLastLogic.g().j(baseDoodleMsgLayout, z16);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void registLayout(long j3, long j16, int i3, BaseDoodleMsgLayout baseDoodleMsgLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), baseDoodleMsgLayout);
        } else {
            PlayLastLogic.g().l(j3, j16, i3, baseDoodleMsgLayout);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void setLastMsgID(List<ChatMessage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            PlayLastLogic.g().o(list);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void setScrollData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
        } else {
            PlayLastLogic.g().p(i3, i16, i17, i18, i19, i26, i27, i28);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodlePanelHelper
    public void setScrollState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            PlayLastLogic.g().q(i3);
        }
    }
}
