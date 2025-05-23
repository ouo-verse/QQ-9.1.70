package com.tencent.mobileqq.guild.mainframe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes14.dex */
public class GuildAppReportSourceInfo implements Parcelable, Serializable {
    public static final String SOURCE_INFO_EXTRA_KEY = "GuildAppReportSourceInfo";
    public static final String TAG = "GuildAppReportSourceInfo";
    private static final long serialVersionUID = 362498820763181265L;
    private HashMap<String, String> commonReportSourceMap;
    public ExtraInfo extraInfo;
    private HashMap<String, Params> guildReportParams;
    private boolean startFromGuildTab;

    /* renamed from: d, reason: collision with root package name */
    private static long f227249d = SystemClock.uptimeMillis();
    public static final Parcelable.Creator<GuildAppReportSourceInfo> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildAppReportSourceInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildAppReportSourceInfo createFromParcel(Parcel parcel) {
            return new GuildAppReportSourceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildAppReportSourceInfo[] newArray(int i3) {
            return new GuildAppReportSourceInfo[i3];
        }
    }

    public GuildAppReportSourceInfo() {
        this.commonReportSourceMap = new HashMap<>();
        this.guildReportParams = new HashMap<>();
        this.extraInfo = new ExtraInfo();
        this.startFromGuildTab = false;
    }

    public static GuildAppReportSourceInfo fromActivity(@NonNull Activity activity) {
        return fromIntent(activity.getIntent());
    }

    public static GuildAppReportSourceInfo fromBundle(@NonNull Bundle bundle) {
        return (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
    }

    public static GuildAppReportSourceInfo fromIntent(@NonNull Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            return null;
        }
        return (GuildAppReportSourceInfo) bundleExtra.getParcelable("GuildAppReportSourceInfo");
    }

    public static long getAppStartTime() {
        return f227249d;
    }

    public static String getPginSourceMode(String str) {
        int c16 = (az.c(str, 0) & 65535) + 196608;
        if (c16 == 246611) {
            return QCircleDaTongConstant.ElementParamValue.QRCODE;
        }
        if (c16 == 246610) {
            return MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
        }
        return "others";
    }

    public static void setAppStartTime(long j3) {
        f227249d = j3;
        if (QLog.isDebugVersion()) {
            QLog.d("GuildAppReportSourceInfo", 4, "setAppStartTime ", Long.valueOf(j3));
        }
    }

    public void addReportItem(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.commonReportSourceMap.put(str, str2);
        }
    }

    public void addReportItems(Map<String, String> map) {
        this.commonReportSourceMap.putAll(map);
    }

    public GuildAppReportSourceInfo copy() {
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.commonReportSourceMap.putAll(this.commonReportSourceMap);
        guildAppReportSourceInfo.guildReportParams.putAll(this.guildReportParams);
        guildAppReportSourceInfo.startFromGuildTab = this.startFromGuildTab;
        if (this.extraInfo.discoveryExtra != null) {
            guildAppReportSourceInfo.extraInfo.discoveryExtra = new GuildDiscoveryExtra(this.extraInfo.discoveryExtra);
        }
        return guildAppReportSourceInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, Object> getGuildReportParams(String str) {
        Params params = this.guildReportParams.get(str);
        if (params != null) {
            return params.dtExtraParamsFromDiscoverSearch;
        }
        return new HashMap();
    }

    public String getPageInSourceName() {
        String str = this.commonReportSourceMap.get("sgrp_stream_pgin_source_name");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public Map<String, String> getReportInfoMap() {
        return Collections.unmodifiableMap(this.commonReportSourceMap);
    }

    public boolean getStartFromGuildTab() {
        return this.startFromGuildTab;
    }

    public boolean reportItemsIsEmpty() {
        if (this.commonReportSourceMap.isEmpty() && this.guildReportParams.isEmpty()) {
            return true;
        }
        return false;
    }

    public void saveTo(@NonNull Intent intent) {
        GuildJumpDebugUtils.a("GuildAppReportSourceInfo", "saveTo: before intent = ", intent);
        Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
            intent.putExtra(AppConstants.Key.GUILD_EXTRA, bundleExtra);
        }
        bundleExtra.putParcelable("GuildAppReportSourceInfo", this);
        GuildJumpDebugUtils.a("GuildAppReportSourceInfo", "saveTo: after put intent = ", intent);
    }

    public void setGuildReportParam(String str, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (this.guildReportParams.containsKey(str)) {
                Params params = this.guildReportParams.get(str);
                if (params != null) {
                    params.getDtExtraParamsFromDiscoverSearch().putAll(map);
                    return;
                } else {
                    this.guildReportParams.put(str, new Params(map));
                    return;
                }
            }
            this.guildReportParams.put(str, new Params(map));
            return;
        }
        this.guildReportParams.remove(str);
    }

    public void setReportInfoMap(Map<String, String> map) {
        this.commonReportSourceMap.clear();
        this.commonReportSourceMap.putAll(map);
        if (QLog.isColorLevel()) {
            QLog.d("GuildAppReportSourceInfo", 2, "setReportInfoMap size=" + this.commonReportSourceMap.size());
        }
    }

    public void setStartFromGuildTab(boolean z16) {
        this.startFromGuildTab = z16;
    }

    public String toString() {
        return "GuildAppReportSourceInfo{hashcode=" + hashCode() + " startFromGuildTab=" + this.startFromGuildTab + " sourceMap=" + this.commonReportSourceMap + " mGuildReportParams=" + this.guildReportParams + " extraInfo=" + this.extraInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.commonReportSourceMap);
        parcel.writeMap(this.guildReportParams);
        parcel.writeInt(this.startFromGuildTab ? 1 : 0);
        parcel.writeParcelable(this.extraInfo, i3);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class Params implements Parcelable, Serializable {
        public static final Parcelable.Creator<Params> CREATOR = new a();
        private Map<String, Object> dtExtraParamsFromDiscoverSearch;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<Params> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Params createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Params[] newArray(int i3) {
                return new Params[i3];
            }
        }

        public Params(Map<String, Object> map) {
            new HashMap();
            this.dtExtraParamsFromDiscoverSearch = map;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Map<String, Object> getDtExtraParamsFromDiscoverSearch() {
            return this.dtExtraParamsFromDiscoverSearch;
        }

        public String toString() {
            return "Params{dtExtraParamsFromDiscoverSearch=" + this.dtExtraParamsFromDiscoverSearch + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeMap(this.dtExtraParamsFromDiscoverSearch);
        }

        protected Params(Parcel parcel) {
            this.dtExtraParamsFromDiscoverSearch = new HashMap();
            this.dtExtraParamsFromDiscoverSearch = parcel.readHashMap(Params.class.getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class ExtraInfo implements Parcelable, Serializable {
        public static final Parcelable.Creator<ExtraInfo> CREATOR = new a();
        private static final long serialVersionUID = 362498820763181018L;
        public int channelOpenSourceForOnlineReport;
        public GuildDiscoveryExtra discoveryExtra;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<ExtraInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ExtraInfo createFromParcel(Parcel parcel) {
                return new ExtraInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ExtraInfo[] newArray(int i3) {
                return new ExtraInfo[i3];
            }
        }

        protected ExtraInfo(Parcel parcel) {
            this.discoveryExtra = null;
            this.channelOpenSourceForOnlineReport = 0;
            this.channelOpenSourceForOnlineReport = parcel.readInt();
            this.discoveryExtra = (GuildDiscoveryExtra) parcel.readParcelable(GuildDiscoveryExtra.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "ExtraInfo{discoveryExtra=" + this.discoveryExtra + " channelJumpSourceForOnlineReport=" + this.channelOpenSourceForOnlineReport + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.channelOpenSourceForOnlineReport);
            parcel.writeParcelable(this.discoveryExtra, i3);
        }

        public ExtraInfo() {
            this.discoveryExtra = null;
            this.channelOpenSourceForOnlineReport = 0;
        }
    }

    public GuildAppReportSourceInfo(String str, String str2) {
        this.commonReportSourceMap = new HashMap<>();
        this.guildReportParams = new HashMap<>();
        this.extraInfo = new ExtraInfo();
        this.startFromGuildTab = false;
        addReportItem("sgrp_stream_pgin_into_source", str2);
    }

    public void saveTo(@NonNull Bundle bundle) {
        bundle.putParcelable("GuildAppReportSourceInfo", this);
    }

    protected GuildAppReportSourceInfo(Parcel parcel) {
        this.commonReportSourceMap = new HashMap<>();
        this.guildReportParams = new HashMap<>();
        this.extraInfo = new ExtraInfo();
        this.startFromGuildTab = false;
        this.commonReportSourceMap = parcel.readHashMap(GuildAppReportSourceInfo.class.getClassLoader());
        this.guildReportParams = parcel.readHashMap(GuildAppReportSourceInfo.class.getClassLoader());
        this.startFromGuildTab = parcel.readInt() == 1;
        this.extraInfo = (ExtraInfo) parcel.readParcelable(ExtraInfo.class.getClassLoader());
    }
}
