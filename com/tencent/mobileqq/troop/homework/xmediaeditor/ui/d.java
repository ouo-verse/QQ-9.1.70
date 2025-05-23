package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d<VH extends RecyclerView.ViewHolder, D extends com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> extends a<VH, D> {
    static IPatchRedirector $redirector_;

    public d(XMediaEditor xMediaEditor) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor);
        }
    }

    public abstract void m(D d16);
}
