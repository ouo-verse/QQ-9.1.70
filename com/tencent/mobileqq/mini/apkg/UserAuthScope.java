package com.tencent.mobileqq.mini.apkg;

import NS_MINI_USERAUTH.MiniUserAuth$StUserAuthScope;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UserAuthScope implements Parcelable, Serializable {
    public static final int AUTH_TYPE_ASK_EVERY_TIME = 1;
    public static final int AUTH_TYPE_ASK_ONLY_ONCE = 0;
    public static final Parcelable.Creator<UserAuthScope> CREATOR = new Parcelable.Creator<UserAuthScope>() { // from class: com.tencent.mobileqq.mini.apkg.UserAuthScope.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAuthScope createFromParcel(Parcel parcel) {
            return new UserAuthScope(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAuthScope[] newArray(int i3) {
            return new UserAuthScope[i3];
        }
    };
    public int authType;
    public String desc;
    public String scope;
    public String settingPageTitle;

    public UserAuthScope() {
    }

    public static UserAuthScope from(MiniUserAuth$StUserAuthScope miniUserAuth$StUserAuthScope) {
        UserAuthScope userAuthScope = new UserAuthScope();
        if (miniUserAuth$StUserAuthScope == null) {
            return userAuthScope;
        }
        userAuthScope.scope = miniUserAuth$StUserAuthScope.scope.get();
        userAuthScope.authType = miniUserAuth$StUserAuthScope.authType.get();
        userAuthScope.desc = miniUserAuth$StUserAuthScope.desc.get();
        userAuthScope.settingPageTitle = miniUserAuth$StUserAuthScope.settingPageTitle.get();
        return userAuthScope;
    }

    public static UserAuthScope fromJson(JSONObject jSONObject) {
        UserAuthScope userAuthScope = new UserAuthScope();
        if (jSONObject != null) {
            userAuthScope.scope = jSONObject.optString("scope");
            userAuthScope.authType = jSONObject.optInt("authType");
            userAuthScope.desc = jSONObject.optString("desc");
            userAuthScope.settingPageTitle = jSONObject.optString("settingPageTitle");
        }
        return userAuthScope;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", this.scope);
            jSONObject.put("authType", this.authType);
            jSONObject.put("desc", this.desc);
            jSONObject.put("settingPageTitle", this.settingPageTitle);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "UserAuthScope{scope='" + this.scope + "', authType=" + this.authType + ", desc='" + this.desc + "', settingPageTitle='" + this.settingPageTitle + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.scope);
        parcel.writeInt(this.authType);
        parcel.writeString(this.desc);
        parcel.writeString(this.settingPageTitle);
    }

    protected UserAuthScope(Parcel parcel) {
        this.scope = parcel.readString();
        this.authType = parcel.readInt();
        this.desc = parcel.readString();
        this.settingPageTitle = parcel.readString();
    }
}
