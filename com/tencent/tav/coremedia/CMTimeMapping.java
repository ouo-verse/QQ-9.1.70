package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMTimeMapping {

    @NonNull
    private CMTimeRange source;

    @NonNull
    private CMTimeRange target;

    public CMTimeMapping(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        this.source = cMTimeRange.m260clone();
        this.target = cMTimeRange2.m260clone();
    }

    @NonNull
    public CMTimeRange getSource() {
        return this.source;
    }

    @NonNull
    public CMTimeRange getTarget() {
        return this.target;
    }

    public void setSource(@NonNull CMTimeRange cMTimeRange) {
        Utils.checkNotNull(cMTimeRange);
        this.source = cMTimeRange.m260clone();
    }

    public void setTarget(@NonNull CMTimeRange cMTimeRange) {
        Utils.checkNotNull(cMTimeRange);
        this.target = cMTimeRange.m260clone();
    }

    public String toString() {
        return "CMTimeMapping{source=" + this.source.toSimpleString() + ", target=" + this.target.toSimpleString() + '}';
    }
}
