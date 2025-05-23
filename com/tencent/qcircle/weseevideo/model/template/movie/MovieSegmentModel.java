package com.tencent.qcircle.weseevideo.model.template.movie;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieSegmentModel {
    private ArrayList<VideoResourceModel> videoResourceModels = new ArrayList<>();
    private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
    private CMTime minDuration = CMTime.CMTimeZero;

    public boolean equals(Object obj) {
        CMTimeRange cMTimeRange;
        CMTime cMTime;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovieSegmentModel movieSegmentModel = (MovieSegmentModel) obj;
        ArrayList<VideoResourceModel> arrayList = this.videoResourceModels;
        ArrayList<VideoResourceModel> arrayList2 = movieSegmentModel.videoResourceModels;
        if ((arrayList == arrayList2 || (arrayList != null && arrayList.equals(arrayList2))) && (cMTimeRange = this.timeRange) != null && cMTimeRange.equals(movieSegmentModel.timeRange) && (cMTime = this.minDuration) != null && cMTime.equalsTo(movieSegmentModel.minDuration)) {
            return true;
        }
        return false;
    }

    public CMTime getMinDuration() {
        return this.minDuration;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @NonNull
    public ArrayList<VideoResourceModel> getVideoResourceModels() {
        return this.videoResourceModels;
    }

    public void setMinDuration(CMTime cMTime) {
        this.minDuration = cMTime;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setVideoResourceModels(@NonNull ArrayList<VideoResourceModel> arrayList) {
        this.videoResourceModels = arrayList;
    }

    public String toString() {
        return "MovieSegmentModel{videoResourceModels=" + this.videoResourceModels + ", timeRange=" + this.timeRange + ", minDuration=" + this.minDuration + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MovieSegmentModel m238clone() {
        MovieSegmentModel movieSegmentModel = new MovieSegmentModel();
        ArrayList<VideoResourceModel> arrayList = new ArrayList<>();
        Iterator<VideoResourceModel> it = this.videoResourceModels.iterator();
        while (it.hasNext()) {
            VideoResourceModel next = it.next();
            if (next != null) {
                arrayList.add(next.clone());
            }
        }
        movieSegmentModel.setVideoResourceModels(arrayList);
        movieSegmentModel.setTimeRange(this.timeRange.m260clone());
        movieSegmentModel.setMinDuration(this.minDuration.m259clone());
        return movieSegmentModel;
    }
}
