package com.tencent.mobileqq.qqemoticon.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SysEmoApiImpl implements ISysEmoApi {
    static IPatchRedirector $redirector_;

    public SysEmoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public Drawable getEmoDrawable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 1) {
            return QQSysFaceUtil.getFaceDrawable(i16);
        }
        if (i3 == 2) {
            return QQEmojiUtil.getEmojiDrawable(i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public Drawable getEmoDrawableFromEMCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        int localIdFromEMCode = QQSysFaceUtil.getLocalIdFromEMCode(str);
        if (localIdFromEMCode != -1) {
            return QQSysFaceUtil.getFaceDrawable(localIdFromEMCode);
        }
        int localIdFromEMCode2 = QQEmojiUtil.getLocalIdFromEMCode(str);
        if (localIdFromEMCode2 != -1) {
            return QQEmojiUtil.getEmojiDrawable(localIdFromEMCode2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public String getEmoString(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 1) {
            return QQSysFaceUtil.getFaceString(i16);
        }
        if (i3 == 2) {
            return TextUtils.getEmojiString(i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public Drawable getEmojiDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return QQEmojiUtil.getEmojiDrawable(i3);
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public Drawable getSysFaceDrawable(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("SysEmoApiImpl", 4, "getSysFaceDrawable: localId=", Integer.valueOf(i3), " anim=", Boolean.valueOf(z16));
        }
        if (!z16) {
            return QQSysFaceUtil.getFaceDrawable(i3);
        }
        return QQSysFaceUtil.getFaceGifDrawable(i3);
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public boolean isSysFaceStatic(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        return QQSysFaceUtil.isStaticFace(i3);
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
    public boolean isSysFaceValid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        return QQSysFaceUtil.isValidFaceId(i3);
    }
}
