package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaLbsAreaList {
    public long startShootTime;
    public MediaLbsArea albumLbs = new MediaLbsArea();
    public String startDescription = "";
    public String endDescription = "";
    public ArrayList<MediaLbsArea> lbsAreas = new ArrayList<>();

    public MediaLbsArea getAlbumLbs() {
        return this.albumLbs;
    }

    public String getEndDescription() {
        return this.endDescription;
    }

    public ArrayList<MediaLbsArea> getLbsAreas() {
        return this.lbsAreas;
    }

    public String getStartDescription() {
        return this.startDescription;
    }

    public long getStartShootTime() {
        return this.startShootTime;
    }
}
