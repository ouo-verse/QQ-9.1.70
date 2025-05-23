package com.tencent.maxvideo.watermark;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WatermarkInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String BG_MUSIC = "bg.mp3";
    public static final int TYPE_DYNAMIC_WATERMARK = 2;
    public static final int TYPE_NONE_WATERMARK = 0;
    public static final int TYPE_STATIC_WATERMARK = 1;
    private static final long serialVersionUID = 1;
    public String mBgMusicPath;
    public String mDesc;
    public String mDir;
    public int mId;
    public String mJsonFilePath;
    public int mType;
    public int mYellowFlag;

    public WatermarkInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean hasBGMusic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.mBgMusicPath);
    }

    public boolean isYellow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.mYellowFlag > 0) {
            return true;
        }
        return false;
    }

    public String toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "{\"materialPath\":\"" + this.mJsonFilePath + "\",\"materialDirPath\":\"" + this.mDir + "\"}";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "WatermarkInfo [mType=" + this.mType + ", mDir=" + this.mDir + ", mJsonFilePath=" + this.mJsonFilePath + ", mDesc=" + this.mDesc + "]";
    }

    public WatermarkInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mType = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
