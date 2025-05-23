package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISystemAndEmojiSenderService;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SystemAndEmojiSenderServiceImpl implements ISystemAndEmojiSenderService {
    static IPatchRedirector $redirector_;

    public SystemAndEmojiSenderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.ISystemAndEmojiSenderService
    public void send(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, systemAndEmojiEmoticonInfo, appRuntime, context, editText, parcelable);
        } else {
            SystemAndEmojiEmoticonInfoSender.send(systemAndEmojiEmoticonInfo, appRuntime, context, editText, parcelable);
        }
    }
}
