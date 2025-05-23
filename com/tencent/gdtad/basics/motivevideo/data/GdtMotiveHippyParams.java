package com.tencent.gdtad.basics.motivevideo.data;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: classes6.dex */
public final class GdtMotiveHippyParams implements Serializable {
    private String mCurrentJsBundleVersion;
    private String mTemplateId;

    public String getCurrentJsBundleVersion() {
        return this.mCurrentJsBundleVersion;
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mTemplateId);
    }

    public void setCurrentJsBundleVersion(String str) {
        this.mCurrentJsBundleVersion = str;
    }

    public void setTemplateId(String str) {
        this.mTemplateId = str;
    }

    public String toString() {
        return "GdtHippyParams{, mTemplateId='" + this.mTemplateId + "', mCurrentJsBundleVersion=" + this.mCurrentJsBundleVersion + "'}";
    }
}
