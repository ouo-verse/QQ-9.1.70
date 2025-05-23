package com.tencent.biz.pubaccount.weishi.push;

import UserGrowth.stAnnexation;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushOpDialogModel implements Parcelable {
    public static final Parcelable.Creator<WSPushOpDialogModel> CREATOR = new a();
    public stPopWindowsConfig mStPopWindowsConfig;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushOpDialogModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushOpDialogModel createFromParcel(Parcel parcel) {
            return new WSPushOpDialogModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushOpDialogModel[] newArray(int i3) {
            return new WSPushOpDialogModel[i3];
        }
    }

    public WSPushOpDialogModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeSerializable(this.mStPopWindowsConfig);
    }

    protected WSPushOpDialogModel(Parcel parcel) {
        this.mStPopWindowsConfig = (stPopWindowsConfig) parcel.readSerializable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WSPushOpDialogModel parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WSPushOpDialogModel wSPushOpDialogModel = new WSPushOpDialogModel();
        stPopWindowsConfig stpopwindowsconfig = new stPopWindowsConfig();
        stpopwindowsconfig.windowsid = jSONObject.optInt("windows_id");
        stpopwindowsconfig.type = jSONObject.optInt("type");
        stpopwindowsconfig.title = jSONObject.optString("title");
        stpopwindowsconfig.text = jSONObject.optString("text");
        stpopwindowsconfig.remark = jSONObject.optString("remark");
        stpopwindowsconfig.bg_img_url = jSONObject.optString("bg_img_url");
        stpopwindowsconfig.scene = jSONObject.optInt("scene");
        stpopwindowsconfig.h5url = jSONObject.optString("h5_url");
        stpopwindowsconfig.schema_url = jSONObject.optString("scheme_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("button");
        if (optJSONObject != null) {
            stPopWindowsButton stpopwindowsbutton = new stPopWindowsButton();
            stpopwindowsbutton.title = optJSONObject.optString("title");
            stpopwindowsconfig.jp_button = stpopwindowsbutton;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("annexation");
        if (optJSONObject2 != null) {
            stAnnexation stannexation = new stAnnexation();
            stannexation.money = optJSONObject2.optInt(WidgetCacheConstellationData.MONEY);
            stpopwindowsconfig.annexation = stannexation;
        }
        wSPushOpDialogModel.mStPopWindowsConfig = stpopwindowsconfig;
        return wSPushOpDialogModel;
    }
}
