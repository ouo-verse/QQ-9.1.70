package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import java.util.HashMap;
import r30.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHalfScreenInitBean extends QCircleInitBean {
    private String mH5Url;
    private float mHeightRatio;

    public String getH5Url() {
        return this.mH5Url;
    }

    public float getHeightRatio() {
        return this.mHeightRatio;
    }

    public boolean isHalf() {
        String str;
        HashMap<String, String> hashMap = this.mSchemeAttrs;
        if (hashMap != null) {
            str = hashMap.get(QCircleSchemeAttr.WebView.OPEN_TYPE);
        } else {
            str = null;
        }
        return TextUtils.equals(str, "half");
    }

    public boolean isKuiklyHalf() {
        if (!TextUtils.isEmpty(this.mH5Url) && isHalf()) {
            return c.f430661a.h(this.mH5Url);
        }
        return false;
    }

    public boolean isWebViewHalf() {
        if (!TextUtils.isEmpty(this.mH5Url) && isHalf()) {
            return !c.f430661a.h(this.mH5Url);
        }
        return false;
    }

    public void setH5Url(String str) {
        this.mH5Url = str;
    }

    public void setHeightRatio(float f16) {
        this.mHeightRatio = f16;
    }
}
