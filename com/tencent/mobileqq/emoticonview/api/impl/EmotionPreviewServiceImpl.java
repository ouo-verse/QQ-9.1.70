package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.PreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EmotionPreviewServiceImpl implements IEmotionPreviewService {
    static IPatchRedirector $redirector_;

    public EmotionPreviewServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService
    public IPreviewThumbAdapter createPreviewThumbAdapter(Context context, IPreviewThumbAdapter.IThumbItemClickListener iThumbItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPreviewThumbAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iThumbItemClickListener);
        }
        return new PreviewThumbAdapter(context, iThumbItemClickListener);
    }
}
