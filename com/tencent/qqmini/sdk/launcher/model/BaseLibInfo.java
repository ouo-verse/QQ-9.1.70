package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BaseLibInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<BaseLibInfo> CREATOR = new Parcelable.Creator<BaseLibInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.BaseLibInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseLibInfo createFromParcel(Parcel parcel) {
            BaseLibInfo baseLibInfo = new BaseLibInfo();
            try {
                return new BaseLibInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
            } catch (Throwable th5) {
                QMLog.e("BaseLibInfo", "BaseLibInfo createFromParcel exception!", th5);
                return baseLibInfo;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseLibInfo[] newArray(int i3) {
            return new BaseLibInfo[i3];
        }
    };
    public static final String KEY_1 = "key1";
    public static final String KEY_2 = "key2";
    public static final String KEY_3 = "key3";
    public static final String KEY_4 = "key4";
    public static final String KEY_5 = "key5";
    public static final String LOG_TAG = "BaseLibInfo";

    @JsonORM.Column(key = "key4")
    public String baseLibDesc;

    @JsonORM.Column(key = "key2")
    public String baseLibKey;

    @JsonORM.Column(key = "key5")
    public int baseLibType;

    @JsonORM.Column(key = "key1")
    public String baseLibUrl;

    @JsonORM.Column(key = "key3")
    public String baseLibVersion;

    public BaseLibInfo() {
    }

    public static BaseLibInfo fromJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return (BaseLibInfo) JsonORM.parseFrom(jSONObject, BaseLibInfo.class);
            } catch (Exception e16) {
                QMLog.e("BaseLibInfo", "BaseLibInfo create from json failed ", e16);
            }
        }
        return null;
    }

    public static String getKey(int i3) {
        return "BaseLibInfo_" + i3;
    }

    public static boolean needUpdateVersion(String str, String str2) {
        QMLog.e("BaseLibInfo", "needUpdateVersion requireVersion:" + str + ",currentVer:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i3 = 0;
        for (int i16 = 0; i16 < min; i16++) {
            i3 = split[i16].length() - split2[i16].length();
            if (i3 != 0 || (i3 = split[i16].compareTo(split2[i16])) != 0) {
                break;
            }
        }
        if (i3 == 0) {
            i3 = split.length - split2.length;
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key1", this.baseLibUrl);
            jSONObject.put("key2", this.baseLibKey);
            jSONObject.put("key3", this.baseLibVersion);
            jSONObject.put("key4", this.baseLibDesc);
            jSONObject.put("key5", this.baseLibType);
        } catch (Exception e16) {
            QMLog.e("BaseLibInfo", "BaseLibInfo convert to json failed ", e16);
        }
        return jSONObject;
    }

    public String toString() {
        return "BaseLibInfo{baseLibUrl='" + this.baseLibUrl + "', baseLibKey='" + this.baseLibKey + "', baseLibVersion='" + this.baseLibVersion + "', baseLibDesc='" + this.baseLibDesc + "', baseLibType='" + this.baseLibType + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.baseLibUrl);
        parcel.writeString(this.baseLibKey);
        parcel.writeString(this.baseLibVersion);
        parcel.writeString(this.baseLibDesc);
        parcel.writeInt(this.baseLibType);
    }

    public BaseLibInfo(String str, String str2, String str3) {
        this(str, str2, str3, null, -1);
    }

    public String getKey() {
        return "BaseLibInfo_" + this.baseLibType;
    }

    public BaseLibInfo(String str, String str2) {
        this(str, null, str2, null, -1);
    }

    public BaseLibInfo(String str, String str2, String str3, String str4, int i3) {
        this.baseLibUrl = str;
        this.baseLibKey = str2;
        this.baseLibVersion = str3;
        this.baseLibDesc = str4;
        this.baseLibType = i3;
    }
}
