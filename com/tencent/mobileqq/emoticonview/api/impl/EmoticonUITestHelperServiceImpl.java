package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emosm.cameraemotionroaming.c;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonUITestHelperServiceImpl implements IEmoticonUITestHelperService {
    static IPatchRedirector $redirector_;

    public EmoticonUITestHelperServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService
    public IFavoriteEmoticonInfo createFavoriteEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IFavoriteEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new FavoriteEmoticonInfo();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService
    public IHotPicSearchEmoticonInfo createHotPicSearchEmoticonInfo(int i3, int i16, String str, EmotionSearchItem emotionSearchItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IHotPicSearchEmoticonInfo) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, emotionSearchItem);
        }
        return new HotPicSearchEmoticonInfo(i3, i16, str, emotionSearchItem);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService
    public IPicEmoticonInfo createPicEmoticonInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IPicEmoticonInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return new PicEmoticonInfo(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService
    public c getCameraEmoSendControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.emosm.cameraemotionroaming.b.b();
    }
}
