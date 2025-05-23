package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* loaded from: classes26.dex */
public abstract class OverSeaTileProvider extends UrlTileProvider {
    private String mProviderName;
    private int mProviderVersion;

    public OverSeaTileProvider(String str, int i3) {
        this.mProviderName = str;
        this.mProviderVersion = i3;
        if (!TextUtils.isEmpty(str)) {
        } else {
            throw new IllegalArgumentException("\u56fe\u6e90\u540d\u4e0d\u80fd\u4e3a\u7a7a");
        }
    }

    public abstract Bitmap getLogo(boolean z16);

    public final String getProviderName() {
        return this.mProviderName;
    }

    public final int getProviderVersion() {
        return this.mProviderVersion;
    }

    public boolean onDayNightChange(boolean z16) {
        return false;
    }

    public boolean onLanguageChange(Language language) {
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("OverSeaProvider{");
        stringBuffer.append("mProviderName='");
        stringBuffer.append(this.mProviderName);
        stringBuffer.append('\'');
        stringBuffer.append(", mProviderVersion=");
        stringBuffer.append(this.mProviderVersion);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
