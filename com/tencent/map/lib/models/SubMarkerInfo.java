package com.tencent.map.lib.models;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class SubMarkerInfo {
    private int mIconHeight;
    private String mIconName;
    private int mIconWidth;
    private boolean mInteractive = false;
    private boolean mIsAvoidAnnotation = false;
    private boolean mAvoidOtherMarker = false;

    public SubMarkerInfo avoidAnnotation(boolean z16) {
        this.mIsAvoidAnnotation = z16;
        return this;
    }

    public SubMarkerInfo avoidOtherMarker(boolean z16) {
        this.mAvoidOtherMarker = z16;
        return this;
    }

    public SubMarkerInfo iconHeight(int i3) {
        this.mIconHeight = i3;
        return this;
    }

    public SubMarkerInfo iconName(String str) {
        this.mIconName = str;
        return this;
    }

    public SubMarkerInfo iconWidth(int i3) {
        this.mIconWidth = i3;
        return this;
    }

    public SubMarkerInfo interactive(boolean z16) {
        this.mInteractive = z16;
        return this;
    }

    public String toString() {
        return "SubMarkerInfo{mIconName='" + this.mIconName + "', mIconWidth=" + this.mIconWidth + ", mIconHeight=" + this.mIconHeight + ", mInteractive=" + this.mInteractive + ", mIsAvoidAnnotation=" + this.mIsAvoidAnnotation + ", mAvoidOtherMarker=" + this.mAvoidOtherMarker + '}';
    }
}
