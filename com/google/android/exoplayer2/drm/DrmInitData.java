package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DrmInitData[] newArray(int i3) {
            return new DrmInitData[i3];
        }
    };
    private int hashCode;
    public final int schemeDataCount;
    private final SchemeData[] schemeDatas;

    @Nullable
    public final String schemeType;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.SchemeData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SchemeData[] newArray(int i3) {
                return new SchemeData[i3];
            }
        };
        public final byte[] data;
        private int hashCode;
        public final String mimeType;
        public final boolean requiresSecureDecryption;
        private final UUID uuid;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public boolean canReplace(SchemeData schemeData) {
            if (hasData() && !schemeData.hasData() && matches(schemeData.uuid)) {
                return true;
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!this.mimeType.equals(schemeData.mimeType) || !Util.areEqual(this.uuid, schemeData.uuid) || !Arrays.equals(this.data, schemeData.data)) {
                return false;
            }
            return true;
        }

        public boolean hasData() {
            if (this.data != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                this.hashCode = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        public boolean matches(UUID uuid) {
            if (!C.UUID_NIL.equals(this.uuid) && !uuid.equals(this.uuid)) {
                return false;
            }
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.requiresSecureDecryption ? (byte) 1 : (byte) 0);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z16) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid);
            this.mimeType = (String) Assertions.checkNotNull(str);
            this.data = bArr;
            this.requiresSecureDecryption = z16;
        }

        SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.requiresSecureDecryption = parcel.readByte() != 0;
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private static boolean containsSchemeDataWithUuid(ArrayList<SchemeData> arrayList, int i3, UUID uuid) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (arrayList.get(i16).uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static DrmInitData createSessionCreationData(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.schemeType;
            for (SchemeData schemeData : drmInitData.schemeDatas) {
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.schemeType;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.schemeDatas) {
                if (schemeData2.hasData() && !containsSchemeDataWithUuid(arrayList, size, schemeData2.uuid)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    public DrmInitData copyWithSchemeType(@Nullable String str) {
        if (Util.areEqual(this.schemeType, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.schemeDatas);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (Util.areEqual(this.schemeType, drmInitData.schemeType) && Arrays.equals(this.schemeDatas, drmInitData.schemeDatas)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public SchemeData get(UUID uuid) {
        for (SchemeData schemeData : this.schemeDatas) {
            if (schemeData.matches(uuid)) {
                return schemeData;
            }
        }
        return null;
    }

    public int hashCode() {
        int hashCode;
        if (this.hashCode == 0) {
            String str = this.schemeType;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            this.hashCode = (hashCode * 31) + Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    public DrmInitData(String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C.UUID_NIL;
        if (uuid.equals(schemeData.uuid)) {
            return uuid.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public SchemeData get(int i3) {
        return this.schemeDatas[i3];
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    DrmInitData(@Nullable String str, boolean z16, SchemeData... schemeDataArr) {
        this.schemeType = str;
        schemeDataArr = z16 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }

    DrmInitData(Parcel parcel) {
        this.schemeType = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }
}
