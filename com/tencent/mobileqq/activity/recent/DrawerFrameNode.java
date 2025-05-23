package com.tencent.mobileqq.activity.recent;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.argus.node.ArgusNode;

/* compiled from: P */
@Keep
/* loaded from: classes10.dex */
public class DrawerFrameNode extends ArgusNode<DrawerFrame> {
    static IPatchRedirector $redirector_;

    public DrawerFrameNode(@NonNull View view, DrawerFrame drawerFrame) {
        super(view, drawerFrame);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) drawerFrame);
        }
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        DrawerFrame drawerFrame = getContainerWrf().get();
        View view = getNodeViewWrf().get();
        if (drawerFrame != null && view != null) {
            if (drawerFrame.q()) {
                return view.equals(drawerFrame.h());
            }
            return view.equals(drawerFrame.g());
        }
        return false;
    }
}
