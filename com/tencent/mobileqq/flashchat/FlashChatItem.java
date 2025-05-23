package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FlashChatItem implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int FREETYPE_FREE = 1;
    public static final int FREETYPE_SVIP = 5;
    public static final int FREETYPE_VIP = 4;
    public static final int ID_NORMAL = -100001;
    public static final int ID_RANDOM = -100000;
    public static FlashChatItem sDefaultItem;
    public String appName;
    public String color;
    public int feedType;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    public int f209775id;
    public String mainView;
    public String name;
    public int tabType;
    public String ver;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sDefaultItem = new FlashChatItem(ID_RANDOM, HardCodeUtil.qqStr(R.string.ml8));
        }
    }

    public FlashChatItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.color = "#02A7E3";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "FlashChatItem{id=" + this.f209775id + ", appName='" + this.appName + "', feedType=" + this.feedType + ", name='" + this.name + "', iconUrl='" + this.iconUrl + "', mainView='" + this.mainView + "', ver='" + this.ver + "'}";
    }

    public FlashChatItem(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        this.color = "#02A7E3";
        this.f209775id = i3;
        this.name = str;
    }
}
