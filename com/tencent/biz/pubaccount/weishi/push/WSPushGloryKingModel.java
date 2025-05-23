package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushGloryKingModel implements Parcelable {
    public static final Parcelable.Creator<WSPushGloryKingModel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f81331d;

    /* renamed from: e, reason: collision with root package name */
    public String f81332e;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushGloryKingModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushGloryKingModel createFromParcel(Parcel parcel) {
            return new WSPushGloryKingModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushGloryKingModel[] newArray(int i3) {
            return new WSPushGloryKingModel[i3];
        }
    }

    protected WSPushGloryKingModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f81331d);
        parcel.writeString(this.f81332e);
    }

    protected WSPushGloryKingModel(Parcel parcel) {
        this.f81331d = parcel.readInt();
        this.f81332e = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WSPushGloryKingModel a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WSPushGloryKingModel wSPushGloryKingModel = new WSPushGloryKingModel();
        wSPushGloryKingModel.f81331d = jSONObject.optInt("material_type");
        wSPushGloryKingModel.f81332e = jSONObject.optString("attach");
        return wSPushGloryKingModel;
    }
}
