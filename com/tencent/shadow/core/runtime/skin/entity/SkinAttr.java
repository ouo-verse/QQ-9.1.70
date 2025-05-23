package com.tencent.shadow.core.runtime.skin.entity;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.shadow.core.runtime.skin.loader.SkinResLoader;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SkinAttr {
    public static final int EMPTY_VALUE_REF_ID = 0;
    protected static final String RES_TYPE_NAME_COLOR = "color";
    protected static final String RES_TYPE_NAME_DRAWABLE = "drawable";
    private static final String TAG = "SKIN" + SkinAttr.class.getSimpleName();
    protected String attrName;
    protected int attrValueRefId;
    protected String attrValueRefName;
    protected String attrValueTypeName;

    public void apply(View view) {
        applyInner(view);
    }

    protected abstract boolean applyInner(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getColor() {
        if (isColorAttr()) {
            return SkinResLoader.getColor(this.attrValueRefId, this.attrValueRefName);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ColorStateList getColorStateList() {
        if (isColorAttr()) {
            return SkinResLoader.getColorStateList(this.attrValueRefId, this.attrValueRefName);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable() {
        if (isDrawableAttr()) {
            return SkinResLoader.getDrawable(this.attrValueRefId, this.attrValueRefName);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isColorAttr() {
        return "color".equals(this.attrValueTypeName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDrawableAttr() {
        return RES_TYPE_NAME_DRAWABLE.equals(this.attrValueTypeName);
    }

    public void setBaseValue(String str, String str2, String str3, int i3) {
        this.attrName = str;
        this.attrValueRefName = str2;
        this.attrValueTypeName = str3;
        this.attrValueRefId = i3;
    }

    public String toString() {
        return "SkinAttr \n[\nattrName=" + this.attrName + ", \nattrValueRefId=" + this.attrValueRefId + ", \nattrValueRefName=" + this.attrValueRefName + ", \nattrValueTypeName=" + this.attrValueTypeName + "\n]";
    }
}
