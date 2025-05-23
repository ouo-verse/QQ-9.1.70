package com.tencent.mobileqq.popanim.impl;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.popanim.IPopOutEmoticonAnim;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutEmoticonReceive;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stickerbubble.StickerBubbleReceiverAnimationRunnable;
import com.tencent.mobileqq.stickerbubble.viewholder.b;

/* loaded from: classes16.dex */
public class PopOutEmoticonAnimImpl implements IPopOutEmoticonAnim {
    static IPatchRedirector $redirector_;

    public PopOutEmoticonAnimImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.popanim.IPopOutEmoticonAnim
    public void playPokeEmoAnimation(@NonNull AppInterface appInterface, int i3, @NonNull ViewGroup viewGroup, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, Integer.valueOf(i3), viewGroup, str);
        } else {
            ThreadManager.getUIHandler().post(new StickerBubbleReceiverAnimationRunnable(appInterface, i3, viewGroup, str));
        }
    }

    @Override // com.tencent.mobileqq.popanim.IPopOutEmoticonAnim
    public void playPopEmoAnimation(ViewGroup viewGroup, PopOutAnimConfig popOutAnimConfig, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, viewGroup, popOutAnimConfig, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            ThreadManager.getUIHandler().post(new PopOutEmoticonReceive(viewGroup, popOutAnimConfig, i3, i16));
        }
    }

    @Override // com.tencent.mobileqq.popanim.IPopOutEmoticonAnim
    public void stopAndCleanPopOutAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            b.f290239a.i();
        }
    }
}
