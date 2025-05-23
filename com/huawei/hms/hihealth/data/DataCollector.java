package com.huawei.hms.hihealth.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacu;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataCollector implements SafeParcelable {
    private static final int APPPACKAGENAMEID = 1;
    public static final Parcelable.Creator<DataCollector> CREATOR = new aab();
    private static final int DATATYPEID = 7;
    public static final int DATA_TYPE_CLEAN = 2;
    public static final int DATA_TYPE_CONVERTED = 3;
    public static final int DATA_TYPE_DERIVED = 1;
    public static final int DATA_TYPE_INIT = -1;
    public static final int DATA_TYPE_MERGED = 4;
    public static final int DATA_TYPE_POLYMERIZED = 5;
    public static final int DATA_TYPE_RAW = 0;
    private static final int DEVICEID = 6;
    private static final int EXPECTED_BUFFER_DATA = 1024;
    public static final String EXTRA_DATA_SOURCE = "vnd.huawei.hihealth.data_collector";
    public static final int HEALTH_DATA_QUALITY_BLOOD_GLUCOSE_ISO151972003 = 8;
    public static final int HEALTH_DATA_QUALITY_BLOOD_GLUCOSE_ISO151972013 = 9;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_AAMI = 3;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_BHS_A_A = 4;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_BHS_A_B = 5;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_BHS_B_A = 6;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_BHS_B_B = 7;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_ESH2002 = 1;
    public static final int HEALTH_DATA_QUALITY_BLOOD_PRESSURE_ESH2010 = 2;
    private static final int ISLOCLALISEDID = 8;
    private static final int NAMEID = 2;
    private static final int STREAMIDENTIFIERID = 4;
    private static final int STREAMNAMEID = 3;
    private static final String TAG = "DataCollector";
    private static final int TYPEID = 5;
    private String appId;
    private String dataCollectorName;
    private int dataGenerateType;
    private String dataStreamId;
    private String dataStreamName;
    private DataType dataType;

    @Deprecated
    private String deviceId;
    private DeviceInfo deviceInfo;
    private boolean isLocalized;
    private String packageName;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private String appId;
        private String dataCollectorName;
        private DataType dataType;

        @Deprecated
        private String deviceId;
        private DeviceInfo deviceInfo;
        private String packageName = "";
        private String dataStreamName = "";
        private int dataGenerateType = -1;
        private boolean isLocalized = false;

        public DataCollector build() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28 = false;
            if (this.dataType != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "DataType Is Null, Must Init It.");
            Preconditions.checkState(!this.dataType.equals(DataType.DT_UNUSED_DATA_TYPE), "unused data type");
            if (this.dataGenerateType >= 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            Preconditions.checkState(z17, "Data Generate Type Not Init!");
            if (!"".equals(this.dataStreamName) && !aacu.aaba(this.dataStreamName)) {
                z18 = false;
            } else {
                z18 = true;
            }
            Preconditions.checkArgument(z18, "DataStreamName Length Is Illegal!");
            if (!"".equals(this.packageName) && !aacu.aaba(this.packageName)) {
                z19 = false;
            } else {
                z19 = true;
            }
            Preconditions.checkArgument(z19, "PackageName Length Is Illegal!");
            String str = this.dataCollectorName;
            if (str != null && !aacu.aaba(str)) {
                z26 = false;
            } else {
                z26 = true;
            }
            Preconditions.checkArgument(z26, "DataCollectorName Length Is Illegal!");
            String str2 = this.deviceId;
            if (str2 != null && !aacu.aabc(str2)) {
                z27 = false;
            } else {
                z27 = true;
            }
            Preconditions.checkArgument(z27, "DeviceId Length Is Illegal!");
            if (this.isLocalized) {
                if (this.deviceInfo != null) {
                    z28 = true;
                }
                Preconditions.checkState(z28, "DataCollector: Local device mast set the right deviceinfo");
            }
            DataCollector dataCollector = new DataCollector((aab) null);
            dataCollector.packageName = this.packageName;
            dataCollector.dataCollectorName = this.dataCollectorName;
            dataCollector.dataStreamName = this.dataStreamName;
            dataCollector.dataGenerateType = this.dataGenerateType;
            dataCollector.dataType = this.dataType;
            dataCollector.deviceInfo = this.deviceInfo;
            dataCollector.dataStreamId = dataCollector.encodeDataStreamIdentifier();
            dataCollector.isLocalized = this.isLocalized;
            dataCollector.deviceId = this.deviceId;
            dataCollector.appId = this.appId;
            return dataCollector;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setDataCollectorName(String str) {
            boolean z16;
            if (str != null && !aacu.aaba(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "DataCollectorName Length Is Illegal!");
            this.dataCollectorName = str;
            return this;
        }

        public Builder setDataGenerateType(int i3) {
            this.dataGenerateType = i3;
            return this;
        }

        public Builder setDataStreamName(String str) {
            boolean z16;
            if (!"".equals(str) && !aacu.aaba(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "DataStreamName Length Is Illegal!");
            this.dataStreamName = str;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.dataType = dataType;
            return this;
        }

        @Deprecated
        public Builder setDeviceId(String str) {
            boolean z16;
            if (str != null && !aacu.aabc(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "DeviceId Length Is Illegal!");
            this.deviceId = str;
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        public Builder setLocalized(boolean z16) {
            this.isLocalized = z16;
            return this;
        }

        public Builder setPackageName(Context context) {
            this.packageName = context.getPackageName();
            return this;
        }

        public final Builder setQualityMetrics(int... iArr) {
            throw new IllegalArgumentException("set qualityMetrics failed! This method is deprecated!");
        }

        public Builder setDataType(String str) {
            this.dataType = new DataType(str);
            return this;
        }

        public Builder setPackageName(String str) {
            Preconditions.checkArgument("".equals(str) || aacu.aaba(str), "PackageName Length Is Illegal!");
            this.packageName = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aab implements Parcelable.Creator<DataCollector> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public DataCollector createFromParcel(Parcel parcel) {
            return new DataCollector(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DataCollector[] newArray(int i3) {
            return new DataCollector[i3];
        }
    }

    DataCollector() {
        this.isLocalized = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encodeDataStreamIdentifier() {
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append(getTypeString());
        sb5.append(":");
        sb5.append(this.dataType.getName());
        if (this.packageName != null) {
            sb5.append(":");
            sb5.append(this.packageName);
        }
        if (this.deviceInfo != null) {
            sb5.append(":");
            sb5.append(this.deviceInfo.getDeviceIdentifier());
        }
        String str = this.dataStreamName;
        if (str != null && !str.isEmpty()) {
            sb5.append(":");
            sb5.append(this.dataStreamName);
        }
        return sb5.toString();
    }

    public static DataCollector extract(Intent intent) {
        return null;
    }

    public static String getStandardByType(int i3) {
        switch (i3) {
            case 1:
                return "blood_pressure_esh2002";
            case 2:
                return "blood_pressure_esh2010";
            case 3:
                return "blood_pressure_aami";
            case 4:
                return "blood_pressure_bhs_a_a";
            case 5:
                return "blood_pressure_bhs_a_b";
            case 6:
                return "blood_pressure_bhs_b_a";
            case 7:
                return "blood_pressure_bhs_b_b";
            case 8:
                return "blood_glucose_iso151972003";
            case 9:
                return "blood_glucose_iso151972013";
            default:
                return "unknown";
        }
    }

    private String getTypeString() {
        int i3 = this.dataGenerateType;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "derived";
                        }
                        return "polymerized";
                    }
                    return "merged";
                }
                return "converted";
            }
            return "cleaned";
        }
        return "raw";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataCollector)) {
            return false;
        }
        return this.dataStreamId.equals(((DataCollector) obj).dataStreamId);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDataCollectorName() {
        return this.dataCollectorName;
    }

    public int getDataGenerateType() {
        return this.dataGenerateType;
    }

    public String getDataStreamId() {
        return this.dataStreamId;
    }

    public String getDataStreamName() {
        return this.dataStreamName;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    @Deprecated
    public String getDeviceId() {
        return this.deviceId;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int[] getQualityMetrics() {
        throw new IllegalArgumentException("get qualityMetrics failed! This method is deprecated!");
    }

    public int hashCode() {
        return (this.packageName + this.dataStreamId + this.dataCollectorName).hashCode();
    }

    public boolean isLocalized() {
        return this.isLocalized;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("DataCollector{");
        sb5.append(getTypeString());
        if (this.dataCollectorName != null) {
            sb5.append(":");
            sb5.append(this.dataCollectorName);
        }
        if (this.packageName != null) {
            sb5.append(":");
            sb5.append(this.packageName);
        }
        if (this.deviceInfo != null) {
            sb5.append(":");
            sb5.append(this.deviceInfo);
        }
        if (this.dataStreamName != null) {
            sb5.append(":");
            sb5.append(this.dataStreamName);
        }
        sb5.append(":");
        sb5.append(this.dataType);
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getPackageName(), false);
        SafeParcelWriter.writeString(parcel, 2, getDataCollectorName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDataStreamName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDataStreamId(), false);
        SafeParcelWriter.writeInt(parcel, 5, getDataGenerateType());
        SafeParcelWriter.writeParcelable(parcel, 6, getDeviceInfo(), i3, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getDataType(), i3, false);
        SafeParcelWriter.writeBoolean(parcel, 8, isLocalized());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    protected DataCollector(Parcel parcel) {
        int i3;
        int i16 = 0;
        this.isLocalized = false;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (true) {
            i3 = i16 + 1;
            if (i16 <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                switch (SafeParcelReader.getFieldId(readHeader)) {
                    case 1:
                        this.packageName = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 2:
                        this.dataCollectorName = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 3:
                        this.dataStreamName = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 4:
                        this.dataStreamId = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 5:
                        this.dataGenerateType = SafeParcelReader.readInt(parcel, readHeader);
                        break;
                    case 6:
                        this.deviceInfo = (DeviceInfo) SafeParcelReader.createParcelable(parcel, readHeader, DeviceInfo.CREATOR);
                        break;
                    case 7:
                        this.dataType = (DataType) SafeParcelReader.createParcelable(parcel, readHeader, DataType.CREATOR);
                        break;
                    case 8:
                        this.isLocalized = SafeParcelReader.readBoolean(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
                i16 = i3;
            }
        }
        if (i3 > validateObjectHeader) {
            aabz.aab(TAG, "Max loop reached, dataCollector parcel failed");
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
    }

    /* synthetic */ DataCollector(aab aabVar) {
        this();
    }
}
