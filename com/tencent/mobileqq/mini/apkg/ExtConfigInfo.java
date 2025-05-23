package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE$StExtConfigInfo;
import NS_MINI_USERAUTH.MiniUserAuth$StApiScopeConfig;
import NS_MINI_USERAUTH.MiniUserAuth$StApiScopeEntry;
import NS_MINI_USERAUTH.MiniUserAuth$StUserAuthScope;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ExtConfigInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ExtConfigInfo> CREATOR = new Parcelable.Creator<ExtConfigInfo>() { // from class: com.tencent.mobileqq.mini.apkg.ExtConfigInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtConfigInfo createFromParcel(Parcel parcel) {
            return new ExtConfigInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtConfigInfo[] newArray(int i3) {
            return new ExtConfigInfo[i3];
        }
    };
    private static final String TAG = "ExtConfigInfo";
    public ArrayList<ApiScopeEntry> apiScopeEntries;
    public String configKey;
    public String configVersion;
    public ArrayList<UserAuthScope> userAuthScopes;

    public ExtConfigInfo() {
        this.userAuthScopes = new ArrayList<>();
        this.apiScopeEntries = new ArrayList<>();
    }

    public static ExtConfigInfo from(INTERFACE$StExtConfigInfo iNTERFACE$StExtConfigInfo) {
        ExtConfigInfo extConfigInfo = new ExtConfigInfo();
        if (iNTERFACE$StExtConfigInfo == null) {
            return extConfigInfo;
        }
        extConfigInfo.configKey = iNTERFACE$StExtConfigInfo.configKey.get();
        extConfigInfo.configVersion = iNTERFACE$StExtConfigInfo.configVersion.get();
        MiniUserAuth$StApiScopeConfig miniUserAuth$StApiScopeConfig = new MiniUserAuth$StApiScopeConfig();
        try {
            miniUserAuth$StApiScopeConfig.mergeFrom(iNTERFACE$StExtConfigInfo.dataBuf.get().toByteArray());
            extConfigInfo.userAuthScopes = new ArrayList<>();
            List<MiniUserAuth$StUserAuthScope> list = miniUserAuth$StApiScopeConfig.scopeList.get();
            if (list != null) {
                Iterator<MiniUserAuth$StUserAuthScope> it = list.iterator();
                while (it.hasNext()) {
                    extConfigInfo.userAuthScopes.add(UserAuthScope.from(it.next()));
                }
            }
            List<MiniUserAuth$StApiScopeEntry> list2 = miniUserAuth$StApiScopeConfig.apiToScope.get();
            if (list2 != null) {
                Iterator<MiniUserAuth$StApiScopeEntry> it5 = list2.iterator();
                while (it5.hasNext()) {
                    extConfigInfo.apiScopeEntries.add(ApiScopeEntry.from(it5.next()));
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "merge from error", e16);
        }
        return extConfigInfo;
    }

    public static ExtConfigInfo fromJson(JSONObject jSONObject) {
        ExtConfigInfo extConfigInfo = new ExtConfigInfo();
        if (jSONObject != null) {
            extConfigInfo.configKey = jSONObject.optString("configKey");
            extConfigInfo.configVersion = jSONObject.optString("configVersion");
            JSONArray optJSONArray = jSONObject.optJSONArray("userAuthScopes");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    extConfigInfo.userAuthScopes.add(UserAuthScope.fromJson(optJSONArray.optJSONObject(i3)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("apiScopeEntries");
            if (optJSONArray2 != null) {
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    extConfigInfo.apiScopeEntries.add(ApiScopeEntry.fromJson(optJSONArray2.optJSONObject(i16)));
                }
            }
        }
        return extConfigInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("configKey", this.configKey);
            jSONObject.put("configVersion", this.configVersion);
            JSONArray jSONArray = new JSONArray();
            Iterator<UserAuthScope> it = this.userAuthScopes.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().toJson());
            }
            jSONObject.put("userAuthScopes", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<ApiScopeEntry> it5 = this.apiScopeEntries.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next().toJson());
            }
            jSONObject.put("apiScopeEntries", jSONArray2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "toJson error", e16);
        }
        return jSONObject;
    }

    public INTERFACE$StExtConfigInfo toProto() {
        INTERFACE$StExtConfigInfo iNTERFACE$StExtConfigInfo = new INTERFACE$StExtConfigInfo();
        iNTERFACE$StExtConfigInfo.configKey.set(this.configKey);
        iNTERFACE$StExtConfigInfo.configVersion.set(this.configVersion);
        return iNTERFACE$StExtConfigInfo;
    }

    public String toString() {
        return "ExtConfigInfo{configKey='" + this.configKey + "', configVersion='" + this.configVersion + "', userAuthScopes=" + this.userAuthScopes + ", apiScopeEntries=" + this.apiScopeEntries + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.configKey);
        parcel.writeString(this.configVersion);
        parcel.writeTypedList(this.userAuthScopes);
        parcel.writeTypedList(this.apiScopeEntries);
    }

    protected ExtConfigInfo(Parcel parcel) {
        this.userAuthScopes = new ArrayList<>();
        this.apiScopeEntries = new ArrayList<>();
        this.configKey = parcel.readString();
        this.configVersion = parcel.readString();
        this.userAuthScopes = parcel.createTypedArrayList(UserAuthScope.CREATOR);
        this.apiScopeEntries = parcel.createTypedArrayList(ApiScopeEntry.CREATOR);
    }
}
