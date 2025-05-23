package com.tencent.richmediabrowser.model.video;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoData extends RichMediaBaseData {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public Drawable coverDrawable;
    public String coverUrl;
    public int errorCode;
    public String errorDescription;
    public boolean isAutoPlay = false;
    public boolean isMutePlay = false;
    public VideoPlayParam videoPlayParam;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            VideoData videoData = new VideoData();
            videoData.readFromParcel(parcel);
            return videoData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 2;
    }
}
