package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class v extends EmotionDataSource {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public CustomEmotionRoamingDBManagerBase f205297d;

    public v(QQAppInterface qQAppInterface, u uVar) {
        GenericDeclaration genericDeclaration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) uVar);
            return;
        }
        if (uVar.f205296a instanceof CameraEmoticonInfo) {
            genericDeclaration = ICameraEmotionRoamingDBManagerService.class;
        } else {
            genericDeclaration = IFavroamingDBManagerService.class;
        }
        this.f205297d = (CustomEmotionRoamingDBManagerBase) qQAppInterface.getRuntimeService(genericDeclaration);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public List<p> c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = this.f205297d.syncGetCustomEmotionInfoShowedInPanel();
        ArrayList arrayList = new ArrayList();
        Iterator<EmoticonInfo> it = syncGetCustomEmotionInfoShowedInPanel.iterator();
        while (it.hasNext()) {
            arrayList.add(new u(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
