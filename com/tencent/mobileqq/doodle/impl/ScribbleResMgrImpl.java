package com.tencent.mobileqq.doodle.impl;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ScribbleResMgrImpl implements IScribbleResMgr {
    static IPatchRedirector $redirector_;

    public ScribbleResMgrImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IScribbleResMgr
    public ArrayList<Integer> GetGifVisibleIdList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ScribbleResMgr.L().r((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    @Override // com.tencent.mobileqq.doodle.IScribbleResMgr
    public ArrayList<Integer> GetPaintVisibleIdList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ScribbleResMgr.L().s((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
    }

    @Override // com.tencent.mobileqq.doodle.IScribbleResMgr
    public String GetResIconPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return ScribbleResMgr.t(i3, i16);
    }

    @Override // com.tencent.mobileqq.doodle.IScribbleResMgr
    public String GetResPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return ScribbleResMgr.u(i3, i16);
    }

    @Override // com.tencent.mobileqq.doodle.IScribbleResMgr
    public void StartDownloadRes(int i3, int i16, View view, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), view, bVar);
        } else {
            ScribbleResMgr.L().F((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), i3, i16, view, bVar);
        }
    }
}
