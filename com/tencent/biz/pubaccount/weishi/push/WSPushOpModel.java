package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushOpModel implements Parcelable {
    public static final Parcelable.Creator<WSPushOpModel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f81333d;

    /* renamed from: e, reason: collision with root package name */
    public String f81334e;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushOpModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushOpModel createFromParcel(Parcel parcel) {
            return new WSPushOpModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushOpModel[] newArray(int i3) {
            return new WSPushOpModel[i3];
        }
    }

    protected WSPushOpModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f81333d);
        parcel.writeString(this.f81334e);
    }

    protected WSPushOpModel(Parcel parcel) {
        this.f81333d = parcel.readInt();
        this.f81334e = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WSPushOpModel a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WSPushOpModel wSPushOpModel = new WSPushOpModel();
        wSPushOpModel.f81334e = jSONObject.optString("op_id");
        wSPushOpModel.f81333d = jSONObject.optInt("op_type");
        return wSPushOpModel;
    }
}
