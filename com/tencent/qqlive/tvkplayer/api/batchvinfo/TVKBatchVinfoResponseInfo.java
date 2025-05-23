package com.tencent.qqlive.tvkplayer.api.batchvinfo;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKBatchVinfoResponseInfo {
    private static final int VINFO_TO_STRING_LENGTH_LIMIT = 256;
    private static final String VINFO_TO_STRING_TOO_LONG_POSTFIX = "...[truncated]";
    private final int mEffectiveUrlDurationSec;
    private final String mSelectedDefinition;
    private final String mVid;
    private final String mVinfo;

    public TVKBatchVinfoResponseInfo(String str, String str2, int i3, String str3) {
        this.mVid = str;
        this.mSelectedDefinition = str2;
        this.mEffectiveUrlDurationSec = i3;
        this.mVinfo = str3;
    }

    public int getEffectiveUrlDurationSec() {
        return this.mEffectiveUrlDurationSec;
    }

    public String getSelectedDefinition() {
        return this.mSelectedDefinition;
    }

    public String getVid() {
        return this.mVid;
    }

    public String getVinfo() {
        return this.mVinfo;
    }

    @NonNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[TVKBatchVinfoResponseInfo] vid: ");
        sb5.append(this.mVid);
        sb5.append(", selectedDefinition: ");
        sb5.append(this.mSelectedDefinition);
        sb5.append(", effectiveUrlDurationSec: ");
        sb5.append(this.mEffectiveUrlDurationSec);
        sb5.append(", vinfo: ");
        if (this.mVinfo.length() > 256) {
            str = this.mVinfo.substring(0, 256) + VINFO_TO_STRING_TOO_LONG_POSTFIX;
        } else {
            str = this.mVinfo;
        }
        sb5.append(str);
        return sb5.toString();
    }
}
