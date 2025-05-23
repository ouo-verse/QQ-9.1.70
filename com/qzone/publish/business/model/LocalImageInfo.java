package com.qzone.publish.business.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.LbsDataV2;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LocalImageInfo implements SmartParcelable {
    private static final String TAG = "LocalImageInfo";

    @NeedParcel
    protected long mCapturedDate;

    @NeedParcel
    protected CharSequence mDescription;

    @NeedParcel
    protected HashMap<String, Object> mExtraData;
    protected LbsDataV2.GpsInfo mGpsInfo;

    @NeedParcel
    protected long mModifiedDate;

    @NeedParcel
    protected String mName;

    @NeedParcel
    protected String mPath;

    @NeedParcel
    protected long mSize;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class InvalidImageException extends Exception {
        public InvalidImageException(String str) {
            super(str);
        }
    }

    public LocalImageInfo() {
    }

    private boolean compare(LocalImageInfo localImageInfo) {
        String str;
        String str2;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str3 = this.mPath;
        String str4 = localImageInfo.mPath;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.mName) == (str2 = localImageInfo.mName) || (str != null && str.equals(str2))) && (((charSequence = this.mDescription) == (charSequence2 = localImageInfo.mDescription) || (charSequence != null && charSequence.equals(charSequence2))) && this.mSize == localImageInfo.mSize && this.mModifiedDate == localImageInfo.mModifiedDate);
    }

    public long getDate() {
        return this.mModifiedDate;
    }

    public String getDescription() {
        CharSequence charSequence = this.mDescription;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public HashMap<String, Object> getExtraData() {
        if (this.mExtraData == null) {
            this.mExtraData = new HashMap<>();
        }
        return this.mExtraData;
    }

    public LbsDataV2.GpsInfo getGpsInfo() {
        return this.mGpsInfo;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public int hashCode() {
        String str = this.mPath;
        int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        CharSequence charSequence = this.mDescription;
        int hashCode3 = charSequence != null ? charSequence.hashCode() : 0;
        long j3 = this.mSize;
        int i3 = (((hashCode2 + hashCode3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.mModifiedDate;
        return i3 + ((int) (j16 ^ (j16 >>> 32)));
    }

    public void setDate(long j3) {
        this.mModifiedDate = j3;
    }

    public void setDescription(CharSequence charSequence) {
        this.mDescription = charSequence;
    }

    public void setExtraData(HashMap<String, Object> hashMap) {
        this.mExtraData = hashMap;
    }

    public void setGpsInfo(LbsDataV2.GpsInfo gpsInfo) {
        this.mGpsInfo = gpsInfo;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setSize(long j3) {
        this.mSize = j3;
    }

    public LocalImageInfo(String str) throws InvalidImageException {
        if (!TextUtils.isEmpty(str) && str.startsWith("file:///")) {
            str = str.replaceFirst("file://", "");
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            this.mPath = file.getAbsolutePath();
            this.mName = file.getName();
            this.mSize = file.length();
            this.mModifiedDate = file.lastModified();
            return;
        }
        throw new InvalidImageException("image file not exist!");
    }

    public static LocalImageInfo create(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() != 0) {
            try {
            } catch (InvalidImageException unused) {
                return null;
            }
        }
        return new LocalImageInfo(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LocalImageInfo)) {
            return false;
        }
        return compare((LocalImageInfo) obj);
    }
}
