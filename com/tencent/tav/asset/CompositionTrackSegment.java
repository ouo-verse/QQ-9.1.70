package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTimeRange;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CompositionTrackSegment extends AssetTrackSegment {
    private HashMap<String, Object> extraInfo;
    private String sourcePath;
    private int sourceTrackID;
    private int sourceType;
    private URL url;

    public CompositionTrackSegment(String str, int i3, CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, int i16) {
        super(cMTimeRange, cMTimeRange2);
        this.sourcePath = str;
        this.sourceType = i16;
        this.sourceTrackID = i3;
        this.empty = false;
    }

    public HashMap<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public int getSourceTrackID() {
        return this.sourceTrackID;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setExtraInfo(HashMap<String, Object> hashMap) {
        this.extraInfo = hashMap;
    }

    public String toString() {
        return "CompositionTrackSegment{sourcePath='" + this.sourcePath + "', sourceTrackID=" + this.sourceTrackID + ", timeMapping=" + this.timeMapping + '}';
    }

    public void updateTargetTimeRange(CMTimeRange cMTimeRange) {
        this.scaleDuration = cMTimeRange.getDuration().m259clone();
        this.timeRange = cMTimeRange.m260clone();
        this.timeMapping.setTarget(cMTimeRange);
    }

    public CompositionTrackSegment(CMTimeRange cMTimeRange) {
        super(cMTimeRange, cMTimeRange);
        this.empty = true;
    }
}
