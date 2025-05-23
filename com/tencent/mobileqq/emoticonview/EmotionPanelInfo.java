package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EmotionPanelInfo {
    static IPatchRedirector $redirector_;
    public int columnNum;
    public EmoticonPackage emotionPkg;
    public int type;

    public EmotionPanelInfo(int i3, int i16, EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), emoticonPackage);
            return;
        }
        this.type = i3;
        this.columnNum = i16;
        this.emotionPkg = emoticonPackage;
    }

    public boolean equals(Object obj) {
        EmoticonPackage emoticonPackage;
        EmoticonPackage emoticonPackage2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmotionPanelInfo)) {
            return false;
        }
        EmotionPanelInfo emotionPanelInfo = (EmotionPanelInfo) obj;
        if (this.type == emotionPanelInfo.type && this.columnNum == emotionPanelInfo.columnNum && (((emoticonPackage = this.emotionPkg) == null && emotionPanelInfo.emotionPkg == null) || (emoticonPackage != null && (emoticonPackage2 = emotionPanelInfo.emotionPkg) != null && (str = emoticonPackage.epId) != null && str.equals(emoticonPackage2.epId)))) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        EmoticonPackage emoticonPackage = this.emotionPkg;
        if (emoticonPackage != null) {
            str = emoticonPackage.epId;
        } else {
            str = "";
        }
        return "EmotionPanelInfo [type=" + this.type + ", columnNum=" + this.columnNum + ", epid=" + str + "]";
    }
}
