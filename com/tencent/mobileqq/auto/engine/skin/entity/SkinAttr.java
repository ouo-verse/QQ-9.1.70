package com.tencent.mobileqq.auto.engine.skin.entity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class SkinAttr {
    static IPatchRedirector $redirector_ = null;
    public static final int EMPTY_VALUE_REF_ID = 0;
    protected static final String RES_TYPE_NAME_COLOR = "color";
    protected static final String RES_TYPE_NAME_DRAWABLE = "drawable";
    private static final String TAG;
    protected String attrName;
    protected int attrValueRefId;
    protected String attrValueRefName;
    protected String attrValueTypeName;
    protected Context context;
    private String mBusinessTag;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        TAG = "SKIN" + SkinAttr.class.getSimpleName();
    }

    public SkinAttr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mBusinessTag = str;
        }
    }

    public void apply(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            applyInner(view);
        }
    }

    protected abstract boolean applyInner(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (isColorAttr()) {
            return SkinManager.g(this.mBusinessTag).getColor(this.context, this.attrValueRefId, this.attrValueRefName);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ColorStateList getColorStateList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (isColorAttr()) {
            return SkinManager.g(this.mBusinessTag).getColorStateList(this.context, this.attrValueRefId, this.attrValueRefName);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (isDrawableAttr()) {
            return SkinManager.g(this.mBusinessTag).getDrawable(this.context, this.attrValueRefId, this.attrValueRefName);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isColorAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return "color".equals(this.attrValueTypeName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDrawableAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return RES_TYPE_NAME_DRAWABLE.equals(this.attrValueTypeName);
    }

    public void setBaseValue(Context context, String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2, str3, Integer.valueOf(i3));
            return;
        }
        this.attrName = str;
        this.attrValueRefName = str2;
        this.attrValueTypeName = str3;
        this.attrValueRefId = i3;
        this.context = context;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "SkinAttr \n[\nattrName=" + this.attrName + ", \nattrValueRefId=" + this.attrValueRefId + ", \nattrValueRefName=" + this.attrValueRefName + ", \nattrValueTypeName=" + this.attrValueTypeName + "\n]";
    }
}
