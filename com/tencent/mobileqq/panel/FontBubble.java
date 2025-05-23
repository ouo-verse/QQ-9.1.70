package com.tencent.mobileqq.panel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FontBubble implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int PRICE_SIX = 600;
    public static final int PRICE_THREE = 300;
    public static final int TYPE_ACTIVITY = 6;
    public static final int TYPE_CHARGE = 2;
    public static final int TYPE_FREE = 1;
    public static final int TYPE_FREE0 = 0;
    public static final int TYPE_SVIP = 5;
    public static final int TYPE_VIP = 4;
    public static final int TYPE_YEAR_SVIP = 22;
    public static final int TYPE_YEAR_VIP = 21;
    public String btn;
    public int bubbleId;
    public int engine;
    public int feeType;
    public int fontId;
    public boolean isQualified;
    public String itemBgColor;

    /* renamed from: msg, reason: collision with root package name */
    public String f257110msg;
    public String name;
    public int panelType;
    public String payUrl;
    public String picUrl;
    public int price;
    public String title;
    public int viewType;

    public FontBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.engine = 1;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FontBubble{viewType=" + this.viewType + ", panelType=" + this.panelType + ", fontId=" + this.fontId + ", bubbleId=" + this.bubbleId + ", itemBgColor=" + this.itemBgColor + ", engine=" + this.engine + ", feeType=" + this.feeType + ", isQualified=" + this.isQualified + ", price=" + this.price + ", name='" + this.name + "', msg='" + this.f257110msg + "'}";
    }
}
