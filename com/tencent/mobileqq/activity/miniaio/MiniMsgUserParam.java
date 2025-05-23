package com.tencent.mobileqq.activity.miniaio;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class MiniMsgUserParam {
    static IPatchRedirector $redirector_;
    public int accessType;
    public MiniMsgUser.IMiniMsgActionCallback actionCallback;
    public Intent backConversationIntent;
    public int businessName;
    public int colorType;
    public int contentIconResId;
    public int entryType;
    public View entryView;
    public int filterMsgType;
    public boolean isNeedBackConversation;
    public boolean isNeedFullScreen;
    public int positionX;
    public int positionY;
    public int requestCode;
    public IMiniMsgUnreadCallback unreadCallback;
    public TextView unreadView;

    public MiniMsgUserParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isNeedBackConversation = true;
        }
    }
}
