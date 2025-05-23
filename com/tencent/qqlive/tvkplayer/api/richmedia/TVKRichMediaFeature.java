package com.tencent.qqlive.tvkplayer.api.richmedia;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaFeature {

    @NonNull
    private final String mFeatureType;
    protected boolean mActivated = false;
    protected boolean mInternal = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public TVKRichMediaFeature(@NonNull String str) {
        this.mFeatureType = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.mFeatureType.equals(((TVKRichMediaFeature) obj).mFeatureType);
        }
        return false;
    }

    @NonNull
    public String getFeatureType() {
        return this.mFeatureType;
    }

    public int hashCode() {
        return this.mFeatureType.hashCode();
    }

    public boolean isActivated() {
        return this.mActivated;
    }

    public boolean isInternal() {
        return this.mInternal;
    }
}
