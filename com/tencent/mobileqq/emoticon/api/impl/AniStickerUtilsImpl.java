package com.tencent.mobileqq.emoticon.api.impl;

import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.emoticon.api.IAniStickerUtils;
import com.tencent.mobileqq.emoticonview.AniStickerPreGuideView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerUtilsImpl implements IAniStickerUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_SHOW_ANI_STICKER_PRE_GUIDE = "key_show_anisticker_pre_guide";

    public AniStickerUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAniStickerUtils
    public boolean checkIsNeedShowAniStickerPreGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int intValue = getAniStickerPreGuideShowNumInner().intValue();
        if (QLog.isColorLevel()) {
            QLog.d("timweiliu_emolog", 2, "checkIsNeedShowAniStickerPreGuide, showNum = " + intValue);
        }
        if (intValue < 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAniStickerUtils
    public PopupWindow createAniStickerPreGuideView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PopupWindow) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        AniStickerPreGuideView createAniStickerPreGuideViewInner = createAniStickerPreGuideViewInner(context);
        createAniStickerPreGuideViewInner.initUI();
        return createAniStickerPreGuideViewInner;
    }

    @NotNull
    protected AniStickerPreGuideView createAniStickerPreGuideViewInner(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AniStickerPreGuideView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return new AniStickerPreGuideView(context);
    }

    protected Integer getAniStickerPreGuideShowNumInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Integer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (Integer) com.tencent.mobileqq.core.util.b.a(KEY_SHOW_ANI_STICKER_PRE_GUIDE, 0);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAniStickerUtils
    public i getAniStickerPreGuideViewSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (i) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new i(ViewUtils.dpToPx(200.0f), ViewUtils.dpToPx(42.0f));
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAniStickerUtils
    public void notifyAniStickerPreGuideShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int intValue = getAniStickerPreGuideShowNumInner().intValue() + 1;
        if (QLog.isColorLevel()) {
            QLog.d("timweiliu_emolog", 2, "notifyAniStickerPreGuideShow, showNum = " + intValue);
        }
        com.tencent.mobileqq.core.util.b.d(KEY_SHOW_ANI_STICKER_PRE_GUIDE, Integer.valueOf(intValue));
    }
}
