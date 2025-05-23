package com.tencent.mobileqq.guild.mainframe;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildFeedReportSourceInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<GuildFeedReportSourceInfo> CREATOR = new a();
    public static final String FEED_SOURCE_INFO_EXTRA_KEY = "GuildFeedReportSourceInfo";
    public static final String TAG = "GuildFeedReportSourceInfo";
    private HashMap<String, String> commonReportSourceMap;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildFeedReportSourceInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildFeedReportSourceInfo createFromParcel(Parcel parcel) {
            return new GuildFeedReportSourceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildFeedReportSourceInfo[] newArray(int i3) {
            return new GuildFeedReportSourceInfo[i3];
        }
    }

    public GuildFeedReportSourceInfo() {
        this.commonReportSourceMap = new HashMap<>();
    }

    public void addReportItem(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.commonReportSourceMap.put(str, str2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getReportInfoMap() {
        return Collections.unmodifiableMap(this.commonReportSourceMap);
    }

    public void setReportInfoMap(Map<String, String> map) {
        this.commonReportSourceMap.clear();
        this.commonReportSourceMap.putAll(map);
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedReportSourceInfo", 2, "setReportInfoMap size=" + this.commonReportSourceMap.size());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.commonReportSourceMap);
    }

    protected GuildFeedReportSourceInfo(Parcel parcel) {
        this.commonReportSourceMap = new HashMap<>();
        this.commonReportSourceMap = parcel.readHashMap(GuildFeedReportSourceInfo.class.getClassLoader());
    }
}
