package com.tencent.mobileqq.qzoneplayer.cover.data;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoCoverOpenTrafficText {
    public String mNormalText;
    public String mUnderLineText;

    public VideoCoverOpenTrafficText(String str, String str2) {
        this.mNormalText = str;
        this.mUnderLineText = str2;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mNormalText) && TextUtils.isEmpty(this.mUnderLineText)) ? false : true;
    }

    public String toString() {
        return "normal = " + this.mNormalText + ", underline = " + this.mUnderLineText;
    }
}
