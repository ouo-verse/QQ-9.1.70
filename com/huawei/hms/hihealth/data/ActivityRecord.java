package com.huawei.hms.hihealth.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelableSerializer;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacc;
import com.huawei.hms.health.aacu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityRecord implements SafeParcelable {
    private static final int ACTIVITY_SUMMARY_ID = 9;
    private static final int ACTIVITY_TYPE_ID = 6;
    private static final int APP_INFO_ID = 8;
    public static final Parcelable.Creator<ActivityRecord> CREATOR = new aab();
    private static final long DEFAULT_TIME_MILLIS = 0;
    private static final int DESC_ID = 7;
    private static final int DEVICE_INFO_ID = 13;
    private static final int DURATION_TIME_ID = 5;
    private static final String END_TIME_ERROR_MSG = "End time should be later than start time and the value ranges from 1388505600000ms to 4102415999000ms.";
    private static final int END_TIME_ID = 4;

    @Deprecated
    public static final String EXTRA_ACTIVITY_RECORD = "vnd.huawei.hihealth.activityRecord";
    private static final int ID = 2;
    private static final int META_DATA_ID = 12;

    @Deprecated
    public static final String MIME_TYPE_PREFIX = "vnd.huawei.hihealth.mimeType/";
    private static final int NAME_ID = 1;
    private static final int START_TIME_ID = 3;
    private static final String TAG = "ActivityRecord";
    private static final int TIME_ZONE_ID = 10;

    @Nullable
    private final Long activeTime;
    private ActivitySummary activitySummary;
    private final int activityTypeId;

    @Nullable
    private final AppInfo appInfo;
    private final String desc;
    private List<SampleSetDetail> details;

    @Nullable
    private final DeviceInfo deviceInfo;

    @Nullable
    private final Long durationTime;
    private final long endTime;
    private String gzipDetail;

    /* renamed from: id, reason: collision with root package name */
    private final String f37299id;
    private String metadata;

    @Nullable
    private final String name;
    private final long startTime;
    private List<SubDataRelation> subDataRelationList;
    private String timeZone;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private ActivitySummary activitySummary;
        private int activityTypeId;

        @Nullable
        private AppInfo appInfo;
        private String desc;
        private List<SampleSetDetail> details;

        @Nullable
        private DeviceInfo deviceInfo;

        @Nullable
        private Long durationTime;
        private long endTime;
        public String gzipDetail;

        /* renamed from: id, reason: collision with root package name */
        @Nullable
        private String f37300id;
        private String metadata;

        @Nullable
        private String name;
        private long startTime;
        private List<SubDataRelation> subDataRelationList;
        private String timeZone;

        public Builder() {
            this.name = null;
            this.f37300id = null;
            this.startTime = 0L;
            this.endTime = 0L;
            this.desc = "";
            this.activitySummary = null;
            this.subDataRelationList = new ArrayList();
            this.timeZone = null;
            this.metadata = null;
            this.details = new ArrayList();
        }

        public ActivityRecord build() {
            boolean z16;
            Preconditions.checkArgument(aacu.aaba(this.startTime), "Must specify valid start time.");
            long j3 = this.endTime;
            boolean z17 = false;
            if (j3 != 0 && (!aacu.aaba(j3) || this.endTime <= this.startTime)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, ActivityRecord.END_TIME_ERROR_MSG);
            if (this.activityTypeId != 0) {
                z17 = true;
            }
            Preconditions.checkArgument(z17, "Must set activityTypeId value");
            if (this.f37300id == null) {
                String str = this.name;
                if (str == null) {
                    str = "";
                }
                StringBuilder aab = com.huawei.hms.health.aab.aab(str);
                aab.append(this.startTime);
                this.f37300id = aab.toString();
            }
            if (TextUtils.isEmpty(this.timeZone)) {
                this.timeZone = new SimpleDateFormat("Z", Locale.getDefault()).format(new Date());
            }
            return new ActivityRecord(this, null);
        }

        public Builder setActiveTime(long j3, TimeUnit timeUnit) {
            this.durationTime = Long.valueOf(timeUnit.toMillis(j3));
            return this;
        }

        public Builder setActivitySummary(ActivitySummary activitySummary) {
            this.activitySummary = activitySummary;
            return this;
        }

        public Builder setActivityTypeId(String str) {
            this.activityTypeId = aacc.aab(str);
            return this;
        }

        public Builder setAppInfo(AppInfo appInfo) {
            boolean z16;
            if (this.name != null && !aacu.aab(appInfo.getPackageName())) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "ActivityRecord Name Is Illegal!");
            this.appInfo = appInfo;
            return this;
        }

        public Builder setDesc(String str) {
            this.desc = str;
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            boolean z16;
            if (deviceInfo != null && !aacu.aabc(deviceInfo.getDeviceIdentifier())) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "ActivityRecord deviceInfo Is Illegal!");
            this.deviceInfo = deviceInfo;
            return this;
        }

        public Builder setDurationTime(long j3, TimeUnit timeUnit) {
            this.durationTime = Long.valueOf(timeUnit.toMillis(j3));
            return this;
        }

        public Builder setEndTime(long j3, TimeUnit timeUnit) {
            boolean z16;
            long millis = timeUnit.toMillis(j3);
            this.endTime = millis;
            if (millis != 0 && !aacu.aaba(millis)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "End time has to be equal to 0 or the value ranges from 1388505600000ms to 4102415999000ms.");
            return this;
        }

        public Builder setGzipDetail(String str) {
            this.gzipDetail = str;
            return this;
        }

        public Builder setId(String str) {
            this.f37300id = str;
            return this;
        }

        public Builder setMetadata(String str) {
            Preconditions.checkArgument(aacu.aabb(str), "ActivityRecord mataData illegal ");
            this.metadata = str;
            return this;
        }

        public Builder setName(String str) {
            boolean z16;
            if (this.name != null && !aacu.aab(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "ActivityRecord Name Is Illegal!");
            this.name = str;
            return this;
        }

        public Builder setStartTime(long j3, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j3);
            this.startTime = millis;
            Preconditions.checkArgument(aacu.aaba(millis), "Start time has to be greater than 0 and the value ranges from 1388505600000ms to 4102415999000ms.");
            return this;
        }

        public Builder setSubDataRelationList(List<SubDataRelation> list) {
            this.subDataRelationList = list;
            return this;
        }

        public Builder setTimeZone(String str) {
            this.timeZone = str;
            return this;
        }

        public Builder(ActivityRecord activityRecord) {
            this.name = null;
            this.f37300id = null;
            this.startTime = 0L;
            this.endTime = 0L;
            this.desc = "";
            this.activitySummary = null;
            this.subDataRelationList = new ArrayList();
            this.timeZone = null;
            this.metadata = null;
            this.details = new ArrayList();
            this.name = activityRecord.name;
            this.f37300id = activityRecord.f37299id;
            this.startTime = activityRecord.startTime;
            this.endTime = activityRecord.endTime;
            this.durationTime = activityRecord.durationTime;
            this.activityTypeId = activityRecord.activityTypeId;
            this.desc = activityRecord.desc;
            this.appInfo = activityRecord.appInfo;
            this.activitySummary = activityRecord.activitySummary;
            this.timeZone = activityRecord.timeZone;
            this.details = activityRecord.details;
            this.metadata = activityRecord.metadata;
            this.deviceInfo = activityRecord.deviceInfo;
            this.subDataRelationList = activityRecord.subDataRelationList;
            this.gzipDetail = activityRecord.gzipDetail;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<ActivityRecord> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecord createFromParcel(Parcel parcel) {
            aabz.aabb(ActivityRecord.TAG, "ActivityRecord createFromParcel entered");
            return new ActivityRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecord[] newArray(int i3) {
            return new ActivityRecord[i3];
        }
    }

    public ActivityRecord(long j3, long j16, @Nullable String str, String str2, String str3, int i3, @Nullable Long l3, @Nullable AppInfo appInfo, ActivitySummary activitySummary, String str4, List<SampleSetDetail> list, String str5, @Nullable DeviceInfo deviceInfo, List<SubDataRelation> list2, String str6) {
        verifyStartAndEndTime(j3, j16);
        verifyActivityRecord(str, str2, str3);
        this.name = str;
        this.f37299id = str2;
        this.startTime = j3;
        this.endTime = j16;
        this.durationTime = l3;
        this.activityTypeId = i3;
        this.desc = str3;
        this.appInfo = appInfo;
        this.activitySummary = activitySummary;
        this.timeZone = str4;
        this.details = list;
        this.metadata = str5;
        this.activeTime = l3;
        this.deviceInfo = deviceInfo;
        this.subDataRelationList = list2;
        this.gzipDetail = str6;
    }

    private boolean canContinueParceling(boolean z16, boolean z17) {
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private boolean checkCounter(int i3, int i16) {
        if (i16 <= i3) {
            return true;
        }
        return false;
    }

    private boolean continueParcel(Parcel parcel, int i3) {
        if (parcel.dataPosition() < i3) {
            return true;
        }
        return false;
    }

    @Nullable
    @Deprecated
    public static ActivityRecord extract(Intent intent) {
        if (intent != null) {
            SafeParcelable deserializeFromIntentExtra = SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_ACTIVITY_RECORD, CREATOR);
            if (deserializeFromIntentExtra instanceof ActivityRecord) {
                return (ActivityRecord) deserializeFromIntentExtra;
            }
        }
        return null;
    }

    @Deprecated
    public static String getMimeType(String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() == 0) {
            return MIME_TYPE_PREFIX;
        }
        return MIME_TYPE_PREFIX.concat(valueOf);
    }

    private void verifyActivityRecord(@Nullable String str, String str2, String str3) {
        boolean z16;
        Preconditions.checkArgument(aacu.aabc(str2), "ActivityRecordId Length Is Illegal!");
        boolean z17 = false;
        if (str3 != null && !"".equals(str3) && !aacu.aabc(str3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        Preconditions.checkArgument(z16, "Desc Length Is Illegal!");
        if (str == null || aacu.aab(str)) {
            z17 = true;
        }
        Preconditions.checkArgument(z17, "ActivityRecord Name Is Illegal!");
    }

    private void verifyFieldCount(int i3, int i16) {
        if (i16 > i3) {
            aabz.aab(TAG, "Max loop reached, ActivityRecord parcel failed");
        }
    }

    private void verifyStartAndEndTime(long j3, long j16) {
        boolean z16;
        Preconditions.checkState(aacu.aaba(j3), "Must specify valid start time.");
        if (j16 != 0 && (!aacu.aaba(j16) || j16 <= j3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        Preconditions.checkState(z16, "End time should be later than start time.");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ActivityRecord)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ActivityRecord activityRecord = (ActivityRecord) obj;
        if (!Objects.equals(this.name, activityRecord.name) || !Objects.equals(this.f37299id, activityRecord.f37299id) || this.startTime != activityRecord.startTime || this.endTime != activityRecord.endTime || this.activityTypeId != activityRecord.activityTypeId || !Objects.equals(this.desc, activityRecord.desc) || !Objects.equals(this.appInfo, activityRecord.appInfo) || !Objects.equals(this.activitySummary, activityRecord.activitySummary) || !Objects.equals(this.timeZone, activityRecord.timeZone) || !Objects.equals(this.deviceInfo, activityRecord.deviceInfo)) {
            return false;
        }
        return true;
    }

    public Long getActiveTime(TimeUnit timeUnit) {
        long convert;
        Long l3 = this.activeTime;
        if (l3 == null) {
            aabz.aab(TAG, "Active time is not set.");
            convert = 0;
        } else {
            convert = timeUnit.convert(l3.longValue(), TimeUnit.MILLISECONDS);
        }
        return Long.valueOf(convert);
    }

    public ActivitySummary getActivitySummary() {
        return this.activitySummary;
    }

    public String getActivityType() {
        return aacc.aab(this.activityTypeId);
    }

    @Nullable
    public String getAppDetailsUrl() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getDetailsUrl();
        }
        return null;
    }

    @Nullable
    public String getAppDomainName() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getDomainName();
        }
        return null;
    }

    public String getAppId() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getAppId();
        }
        return null;
    }

    @Nullable
    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    @Nullable
    public String getAppVersion() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getVersion();
        }
        return null;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<SampleSetDetail> getDetails() {
        return this.details;
    }

    @Nullable
    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public long getDurationTime(TimeUnit timeUnit) {
        Long l3 = this.durationTime;
        if (l3 == null) {
            aabz.aabc(TAG, "Active time is not set.");
            return 0L;
        }
        return timeUnit.convert(l3.longValue(), TimeUnit.MILLISECONDS);
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.endTime, TimeUnit.MILLISECONDS);
    }

    public String getGzipDetail() {
        return this.gzipDetail;
    }

    public String getId() {
        return this.f37299id;
    }

    public String getMetadata() {
        return this.metadata;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getPackageName() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getPackageName();
        }
        return null;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
    }

    public List<SubDataRelation> getSubDataRelationList() {
        return this.subDataRelationList;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public boolean hasDurationTime() {
        if (this.durationTime != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.endTime), this.f37299id});
    }

    public boolean isKeepGoing() {
        if (this.endTime == 0) {
            return true;
        }
        return false;
    }

    public void setDetails(List<SampleSetDetail> list) {
        this.details = list;
    }

    public void setGzipDetail(String str) {
        this.gzipDetail = str;
    }

    public void setSubDataRelationList(List<SubDataRelation> list) {
        this.subDataRelationList = list;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        AppInfo appInfo = this.appInfo;
        String str5 = "";
        if (appInfo == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        } else {
            str = appInfo.getPackageName();
            str2 = this.appInfo.getDomainName();
            str3 = this.appInfo.getVersion();
            str4 = this.appInfo.getDetailsUrl();
        }
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            str5 = deviceInfo.getDeviceIdentifier();
        }
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("SessionInfo{startTimeMillis = ");
        aab2.append(this.startTime);
        aab2.append(", endTimeMillis = ");
        aab2.append(this.endTime);
        aab2.append(", name = ");
        aab2.append(this.name);
        aab2.append(", id = ");
        aab2.append(this.f37299id);
        aab2.append(", desc = ");
        aab2.append(this.desc);
        aab2.append(", typeId = ");
        aab2.append(this.activityTypeId);
        aab2.append(", activeTimeMillis = ");
        aab2.append(this.durationTime);
        aab2.append(", packageName = ");
        aab2.append(str);
        aab2.append(", activitySummary = ");
        aab2.append(this.activitySummary);
        aab2.append(", timeZone = ");
        aab2.append(this.timeZone);
        aab2.append(", domainName = ");
        aab2.append(str2);
        aab2.append(", version = ");
        aab2.append(str3);
        aab2.append(", url = ");
        aab2.append(str4);
        aab2.append(", deviceId = ");
        aab2.append(str5);
        aab2.append("}");
        return aab2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.startTime);
        SafeParcelWriter.writeLong(parcel, 4, this.endTime);
        SafeParcelWriter.writeLongObject(parcel, 5, this.durationTime, false);
        SafeParcelWriter.writeString(parcel, 6, getActivityType(), false);
        SafeParcelWriter.writeString(parcel, 7, getDesc(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.appInfo, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.activitySummary, i3, false);
        SafeParcelWriter.writeString(parcel, 10, this.timeZone, false);
        SafeParcelWriter.writeString(parcel, 12, this.metadata, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.deviceInfo, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    protected ActivityRecord(Parcel parcel) {
        aabz.aabb(TAG, "ActivityRecord(Parcel parcel) entered");
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j3 = 0;
        ActivitySummary activitySummary = null;
        AppInfo appInfo = null;
        String str = null;
        DeviceInfo deviceInfo = null;
        String str2 = null;
        String str3 = "";
        String str4 = str3;
        String str5 = "unknown";
        int i3 = 0;
        Long l3 = null;
        String str6 = str4;
        long j16 = 0;
        while (true) {
            ActivitySummary activitySummary2 = activitySummary;
            if (!canContinueParceling(checkCounter(validateObjectHeader, i3), continueParcel(parcel, validateObjectHeader))) {
                verifyFieldCount(validateObjectHeader, i3);
                SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
                aabz.aabb(TAG, "appInfoTmp read");
                aabz.aabb(TAG, "activitySummary read");
                aabz.aabb(TAG, "timeZone read");
                aabz.aabb(TAG, "details read");
                this.name = str;
                this.f37299id = str6;
                this.startTime = j16;
                this.endTime = j3;
                this.durationTime = l3;
                this.activityTypeId = aacc.aab(str5);
                this.desc = str3;
                this.appInfo = appInfo;
                this.activitySummary = activitySummary2;
                this.timeZone = str4;
                this.metadata = str2;
                this.activeTime = l3;
                this.deviceInfo = deviceInfo;
                return;
            }
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j16 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    l3 = Long.valueOf(SafeParcelReader.readLong(parcel, readHeader));
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    appInfo = (AppInfo) SafeParcelReader.createParcelable(parcel, readHeader, AppInfo.CREATOR);
                    break;
                case 9:
                    activitySummary = (ActivitySummary) SafeParcelReader.createParcelable(parcel, readHeader, ActivitySummary.CREATOR);
                    continue;
                case 10:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 11:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    deviceInfo = (DeviceInfo) SafeParcelReader.createParcelable(parcel, readHeader, DeviceInfo.CREATOR);
                    break;
            }
            activitySummary = activitySummary2;
            i3++;
        }
    }

    ActivityRecord(Builder builder) {
        this(builder.startTime, builder.endTime, builder.name, builder.f37300id, builder.desc, builder.activityTypeId, builder.durationTime, builder.appInfo, builder.activitySummary, builder.timeZone, builder.details, builder.metadata, builder.deviceInfo, builder.subDataRelationList, builder.gzipDetail);
    }

    /* synthetic */ ActivityRecord(Builder builder, aab aabVar) {
        this(builder);
    }
}
