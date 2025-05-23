package com.huawei.hms.support.account.result;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.feature.result.AbstractAuthAccount;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AuthAccount extends AbstractAuthAccount {
    public static final Parcelable.Creator<AuthAccount> CREATOR = new Parcelable.Creator<AuthAccount>() { // from class: com.huawei.hms.support.account.result.AuthAccount.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthAccount createFromParcel(Parcel parcel) {
            return new AuthAccount(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthAccount[] newArray(int i3) {
            return new AuthAccount[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private int f37511a;

    AuthAccount(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, Set<Scope> set, String str7, String str8, String str9, int i17) {
        this.openId = str;
        this.uid = str2;
        this.photoUriString = str4;
        this.displayName = str3;
        this.accessToken = str5;
        this.serviceCountryCode = str6;
        this.gender = i16;
        this.status = i3;
        this.serverAuthCode = str7;
        this.grantedScopes = set;
        this.unionId = str8;
        this.countryCode = str9;
        this.carrierId = i17;
    }

    public static AuthAccount build(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, Set<Scope> set, String str7, String str8, String str9, int i17) {
        return new AuthAccount(str, str2, str3, str4, str5, str6, i3, i16, set, str7, str8, str9, i17);
    }

    public static AuthAccount createDefault() {
        return build(null, null, null, null, null, null, 0, -1, new HashSet(), null, null, null, 0);
    }

    public static AuthAccount fromJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            return fromJson(new JSONObject(str));
        }
        throw new JSONException("invalid json format");
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthAccount)) {
            return false;
        }
        return getAuthorizedScopes().equals(((AuthAccount) obj).getAuthorizedScopes());
    }

    public Account getAccount(Context context) {
        if (TextUtils.isEmpty(this.email)) {
            return null;
        }
        return new Account(this.email, HMSPackageManager.getInstance(context).getHMSPackageName());
    }

    public int getAccountFlag() {
        return this.f37511a;
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public void parserJson(JSONObject jSONObject) throws JSONException {
        super.parserJson(jSONObject);
        this.f37511a = jSONObject.optInt(CommonConstant.KEY_ACCOUNT_FLAG, 0);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f37511a = parcel.readInt();
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public /* bridge */ /* synthetic */ AbstractAuthAccount requestExtraScopes(List list) {
        return requestExtraScopes((List<Scope>) list);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getUid() != null) {
            jSONObject.put("uid", getUid());
        }
        if (getOpenId() != null) {
            jSONObject.put("openId", getOpenId());
        }
        if (getDisplayName() != null) {
            jSONObject.put(CommonConstant.KEY_DISPLAY_NAME, getDisplayName());
        }
        if (getAvatarUriString() != null) {
            jSONObject.put(CommonConstant.KEY_PHOTO_URI, getAvatarUriString());
        }
        if (getAccessToken() != null) {
            jSONObject.put(CommonConstant.KEY_ACCESS_TOKEN, getAccessToken());
        }
        jSONObject.put("status", getStatus());
        jSONObject.put("gender", getGender());
        if (getAuthorizationCode() != null) {
            jSONObject.put(CommonConstant.KEY_SERVER_AUTH_CODE, getAuthorizationCode());
        }
        if (getServiceCountryCode() != null) {
            jSONObject.put(CommonConstant.KEY_SERVICE_COUNTRY_CODE, getServiceCountryCode());
        }
        if (getCountryCode() != null) {
            jSONObject.put("countryCode", getCountryCode());
        }
        if (getUnionId() != null) {
            jSONObject.put(CommonConstant.KEY_UNION_ID, getUnionId());
        }
        if (getEmail() != null) {
            jSONObject.put("email", getEmail());
        }
        if (getIdToken() != null) {
            jSONObject.put(CommonConstant.KEY_ID_TOKEN, getIdToken());
        }
        jSONObject.put(CommonConstant.KEY_EXPIRATION_TIME_SECS, getExpirationTimeSecs());
        if (getGivenName() != null) {
            jSONObject.put(CommonConstant.KEY_GIVEN_NAME, getGivenName());
        }
        if (getFamilyName() != null) {
            jSONObject.put(CommonConstant.KEY_FAMILY_NAME, getFamilyName());
        }
        if (getAgeRange() != null) {
            jSONObject.put(CommonConstant.KEY_AGE_RANGE, getAgeRange());
        }
        jSONObject.put(CommonConstant.KEY_HOME_ZONE, getHomeZone());
        jSONObject.put(CommonConstant.KEY_ACCOUNT_FLAG, getAccountFlag());
        jSONObject.put(CommonConstant.KEY_CARRIER_ID, getCarrierId());
        return jsonPutOpt(jsonPutScopes(jSONObject));
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public String toString() {
        return "{uid: " + this.uid + ",displayName: " + this.displayName + ",photoUriString: " + this.photoUriString + ",status: " + this.status + ",gender: " + this.gender + ",serviceCountryCode: " + this.serviceCountryCode + ",countryCode: " + this.countryCode + CommonConstant.KEY_ACCOUNT_FLAG + this.f37511a + '}';
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f37511a);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public AuthAccount requestExtraScopes(List<Scope> list) {
        if (ap.b(list).booleanValue()) {
            this.extensionScopes.addAll(list);
        }
        return this;
    }

    public static AuthAccount fromJson(JSONObject jSONObject) throws JSONException {
        AuthAccount authAccount = new AuthAccount();
        authAccount.parserJson(jSONObject);
        return authAccount;
    }

    protected AuthAccount(Parcel parcel) {
        readFromParcel(parcel);
    }

    public AuthAccount() {
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
        this.f37511a = 0;
    }
}
