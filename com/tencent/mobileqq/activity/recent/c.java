package com.tencent.mobileqq.activity.recent;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.argus.node.ArgusNodeCreator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements ArgusNodeCreator<DrawerFrameNode> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawerFrameNode createNode(@NonNull View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DrawerFrameNode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, obj);
        }
        return new DrawerFrameNode(view, (DrawerFrame) obj);
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(@NonNull View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, obj)).booleanValue();
        }
        return obj instanceof DrawerFrame;
    }
}
