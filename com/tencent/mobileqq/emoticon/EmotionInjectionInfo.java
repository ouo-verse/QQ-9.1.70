package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionInjectionInfo {
    static IPatchRedirector $redirector_;
    public int columnNum;
    public IEmotionPanelBuilder emotionPanelBuilder;
    public IEmotionTabCreateListener emotionTabListener;
    public int emotionType;
    public int iconColorResId;
    public int iconResId;
    public AbsEmoticonPanelLifecycleObserver lifecycleObserver;

    public EmotionInjectionInfo(int i3, int i16, int i17, IEmotionPanelBuilder iEmotionPanelBuilder) {
        this(i3, i16, i17, iEmotionPanelBuilder, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iEmotionPanelBuilder);
    }

    public void setEmotionPanelLifecycleObserver(AbsEmoticonPanelLifecycleObserver absEmoticonPanelLifecycleObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) absEmoticonPanelLifecycleObserver);
        } else {
            this.lifecycleObserver = absEmoticonPanelLifecycleObserver;
        }
    }

    public void setEmotionTabCreateListener(IEmotionTabCreateListener iEmotionTabCreateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iEmotionTabCreateListener);
        } else {
            this.emotionTabListener = iEmotionTabCreateListener;
        }
    }

    public EmotionInjectionInfo(int i3, int i16, int i17, IEmotionPanelBuilder iEmotionPanelBuilder, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iEmotionPanelBuilder, Integer.valueOf(i18));
            return;
        }
        this.emotionType = i3;
        this.columnNum = i16;
        this.iconResId = i17;
        this.emotionPanelBuilder = iEmotionPanelBuilder;
        this.iconColorResId = i18;
    }
}
