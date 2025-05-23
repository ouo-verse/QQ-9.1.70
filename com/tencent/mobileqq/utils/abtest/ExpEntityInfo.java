package com.tencent.mobileqq.utils.abtest;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tab.exp.sdk.impl.k;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ExpEntityInfo implements Parcelable {
    public static final Parcelable.Creator<ExpEntityInfo> CREATOR = new a();
    private static final String DEFAULT_VALUE = "";
    private boolean isExpOnline;
    protected String mAssignment;
    protected String mExpAppId;
    protected String mExpGrayId;
    protected String mExpName;
    protected Map<String, String> mExpParams;
    protected String mLayerName;
    private int manageTypeId;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<ExpEntityInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpEntityInfo createFromParcel(Parcel parcel) {
            return new ExpEntityInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExpEntityInfo[] newArray(int i3) {
            return new ExpEntityInfo[i3];
        }
    }

    protected ExpEntityInfo(Parcel parcel) {
        this.manageTypeId = 0;
        this.isExpOnline = true;
        this.mLayerName = "";
        this.mExpName = "";
        this.mExpAppId = "";
        this.mAssignment = "";
        this.mExpGrayId = "";
        this.mExpParams = new HashMap();
        this.mExpAppId = parcel.readString();
        this.mExpName = parcel.readString();
        this.mAssignment = parcel.readString();
        this.mLayerName = parcel.readString();
        this.mExpGrayId = parcel.readString();
        this.manageTypeId = parcel.readInt();
        this.isExpOnline = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAssignment() {
        return this.mAssignment;
    }

    public String getExpName() {
        return this.mExpName;
    }

    public String getGrayId() {
        return this.mExpGrayId;
    }

    public Map<String, String> getTabParams() {
        return this.mExpParams;
    }

    public boolean isContrast() {
        return isContrast(getExpName() + "_A");
    }

    public boolean isExpHit(String str) {
        if (!TextUtils.isEmpty(str) && !isExpInvalid()) {
            return str.equalsIgnoreCase(getAssignment());
        }
        return false;
    }

    public boolean isExpInvalid() {
        if (!TextUtils.isEmpty(this.mExpAppId) && !TextUtils.isEmpty(this.mExpName) && !TextUtils.isEmpty(this.mAssignment)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isExpOnline() {
        if (!isExpInvalid() && this.isExpOnline) {
            return true;
        }
        return false;
    }

    public boolean isExperiment() {
        return isExperiment(getExpName() + "_B");
    }

    public void reportExpExposure() {
        if (isExpInvalid()) {
            ABTestUtil.log("ExpEntityInfo", "reportExpExposure when entity invalid");
        } else {
            ABTestController.getInstance().reportExposure(this.mExpAppId, new k.b().k(this.mExpName).g(this.mAssignment).j(this.mExpGrayId).m(this.mLayerName).l(this.mExpParams).h());
        }
    }

    public void setDefault() {
        this.mAssignment = "";
        this.mLayerName = "";
        this.mExpGrayId = "-1";
        this.isExpOnline = false;
    }

    protected void setManageTypeId(int i3) {
        this.manageTypeId = i3;
    }

    protected void setRomaExpEntity(k kVar) {
        if (kVar != null) {
            this.mExpName = kVar.d();
            this.mAssignment = kVar.a();
            this.mLayerName = kVar.f();
            this.mExpGrayId = kVar.c();
            this.mExpParams = kVar.e();
        }
    }

    public String toStr() {
        return "ExpEntityInfo{manageTypeId=" + this.manageTypeId + ", isExpOnline=" + this.isExpOnline + ", mLayerName='" + this.mLayerName + "', mExpName='" + this.mExpName + "', mExpAppId='" + this.mExpAppId + "', mAssignment='" + this.mAssignment + "', mExpGrayId='" + this.mExpGrayId + "', mExpParams=" + this.mExpParams + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mExpAppId);
        parcel.writeString(this.mExpName);
        parcel.writeString(this.mAssignment);
        parcel.writeString(this.mLayerName);
        parcel.writeString(this.mExpGrayId);
        parcel.writeInt(this.manageTypeId);
        parcel.writeByte(this.isExpOnline ? (byte) 1 : (byte) 0);
    }

    public boolean isContrast(String str) {
        if (TextUtils.isEmpty(str) || isExpInvalid()) {
            return false;
        }
        return str.equalsIgnoreCase(getAssignment());
    }

    public boolean isExperiment(String str) {
        if (TextUtils.isEmpty(str) || isExpInvalid()) {
            return false;
        }
        return str.equalsIgnoreCase(getAssignment());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ExpEntityInfo(@NonNull String str, String str2, String str3, int i3) {
        this.manageTypeId = 0;
        this.isExpOnline = true;
        this.mLayerName = "";
        this.mExpName = "";
        this.mExpAppId = "";
        this.mAssignment = "";
        this.mExpGrayId = "";
        this.mExpParams = new HashMap();
        this.mExpAppId = str;
        this.mExpName = str2;
        this.mAssignment = TextUtils.isEmpty(str3) ? "" : str3;
        this.isExpOnline = true;
        this.manageTypeId = i3;
    }

    @Deprecated
    public void reportExposure(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ExpEntityInfo(@NonNull String str, @NonNull k kVar) {
        this.manageTypeId = 0;
        this.isExpOnline = true;
        this.mLayerName = "";
        this.mExpName = "";
        this.mExpAppId = "";
        this.mAssignment = "";
        this.mExpGrayId = "";
        this.mExpParams = new HashMap();
        this.mExpName = kVar.d();
        this.mAssignment = kVar.a();
        this.mLayerName = kVar.f();
        this.mExpGrayId = kVar.c();
        this.mExpParams = kVar.e();
        this.mExpAppId = str;
        this.manageTypeId = 0;
        this.isExpOnline = true;
    }

    @Deprecated
    public void reportEvent(int i3, String str) {
    }
}
