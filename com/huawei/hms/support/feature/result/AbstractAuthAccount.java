package com.huawei.hms.support.feature.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractAuthAccount implements Parcelable {
    protected String accessToken;
    protected String ageRange;
    protected int carrierId;
    protected String countryCode;
    protected String displayName;
    protected String email;
    protected long expirationTimeSecs;
    protected Set<Scope> extensionScopes;
    protected String familyName;
    protected int gender;
    protected String givenName;
    protected Set<Scope> grantedScopes;
    protected int homeZone;
    protected String idToken;
    protected String openId;
    protected String photoUriString;
    protected String serverAuthCode;
    protected String serviceCountryCode;
    protected int status;
    protected String uid;
    protected String unionId;

    protected AbstractAuthAccount(Parcel parcel) {
        this.extensionScopes = new HashSet();
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractAuthAccount)) {
            return false;
        }
        return getAuthorizedScopes().equals(((AbstractAuthAccount) obj).getAuthorizedScopes());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAgeRange() {
        return this.ageRange;
    }

    public String getAuthorizationCode() {
        return this.serverAuthCode;
    }

    public Set<Scope> getAuthorizedScopes() {
        return this.grantedScopes;
    }

    public Uri getAvatarUri() {
        String str = this.photoUriString;
        if (str == null) {
            str = "";
        }
        return Uri.parse(str);
    }

    public String getAvatarUriString() {
        return this.photoUriString;
    }

    public int getCarrierId() {
        return this.carrierId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public long getExpirationTimeSecs() {
        return this.expirationTimeSecs;
    }

    public Set<Scope> getExtensionScopes() {
        return this.extensionScopes;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getGender() {
        return this.gender;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public int getHomeZone() {
        return this.homeZone;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.grantedScopes);
        hashSet.addAll(this.extensionScopes);
        return hashSet;
    }

    public String getServiceCountryCode() {
        return this.serviceCountryCode;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUnionId() {
        return this.unionId;
    }

    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    public boolean isExpired() {
        if (this.expirationTimeSecs <= 300 || System.currentTimeMillis() / 1000 < this.expirationTimeSecs - 300) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject jsonPutOpt(JSONObject jSONObject) throws JSONException {
        if (getExtensionScopes() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : getExtensionScopes()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(CommonConstant.KEY_SCOPE_URI, scope.getScopeUri());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.putOpt(CommonConstant.KEY_EXTENSION_SCOPES, jSONArray);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject jsonPutScopes(JSONObject jSONObject) throws JSONException {
        if (getAuthorizedScopes() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : getAuthorizedScopes()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(CommonConstant.KEY_SCOPE_URI, scope.getScopeUri());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put(CommonConstant.KEY_GRANTED_SCOPES, jSONArray);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        this.uid = jSONObject.optString("uid", null);
        this.openId = jSONObject.optString("openId", null);
        this.displayName = jSONObject.optString(CommonConstant.KEY_DISPLAY_NAME, null);
        this.photoUriString = jSONObject.optString(CommonConstant.KEY_PHOTO_URI, null);
        this.accessToken = jSONObject.optString(CommonConstant.KEY_ACCESS_TOKEN, null);
        this.status = jSONObject.optInt("status", -1);
        this.gender = jSONObject.optInt("gender", -1);
        this.serverAuthCode = jSONObject.optString(CommonConstant.KEY_SERVER_AUTH_CODE, null);
        this.serviceCountryCode = jSONObject.optString(CommonConstant.KEY_SERVICE_COUNTRY_CODE, null);
        this.countryCode = jSONObject.optString("countryCode", null);
        if (jSONObject.toString().contains(CommonConstant.KEY_GRANTED_SCOPES)) {
            jSONArray = jSONObject.getJSONArray(CommonConstant.KEY_GRANTED_SCOPES);
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.getJSONObject(i3).optString(CommonConstant.KEY_SCOPE_URI, null);
                if (optString != null) {
                    hashSet.add(new Scope(optString));
                }
            }
            this.grantedScopes = hashSet;
        }
        this.unionId = jSONObject.optString(CommonConstant.KEY_UNION_ID, null);
        this.email = jSONObject.optString("email", null);
        this.idToken = jSONObject.optString(CommonConstant.KEY_ID_TOKEN, null);
        this.expirationTimeSecs = 0L;
        if (jSONObject.toString().contains(CommonConstant.KEY_EXPIRATION_TIME_SECS)) {
            try {
                this.expirationTimeSecs = Long.parseLong(jSONObject.getString(CommonConstant.KEY_EXPIRATION_TIME_SECS));
            } catch (NumberFormatException unused) {
                as.d("[AccountSDK]AbstractAuthAccount", "NumberFormatException", true);
            }
        }
        this.givenName = jSONObject.optString(CommonConstant.KEY_GIVEN_NAME, null);
        this.familyName = jSONObject.optString(CommonConstant.KEY_FAMILY_NAME, null);
        this.ageRange = jSONObject.optString(CommonConstant.KEY_AGE_RANGE, null);
        this.homeZone = jSONObject.optInt(CommonConstant.KEY_HOME_ZONE, 0);
        this.carrierId = jSONObject.optInt(CommonConstant.KEY_CARRIER_ID, 0);
    }

    public void readFromParcel(Parcel parcel) {
        this.uid = parcel.readString();
        this.openId = parcel.readString();
        this.displayName = parcel.readString();
        this.photoUriString = parcel.readString();
        this.accessToken = parcel.readString();
        this.status = parcel.readInt();
        this.gender = parcel.readInt();
        this.serverAuthCode = parcel.readString();
        this.serviceCountryCode = parcel.readString();
        this.countryCode = parcel.readString();
        this.grantedScopes = new HashSet(parcel.readArrayList(Scope.class.getClassLoader()));
        this.unionId = parcel.readString();
        this.email = parcel.readString();
        this.idToken = parcel.readString();
        this.expirationTimeSecs = parcel.readLong();
        this.givenName = parcel.readString();
        this.familyName = parcel.readString();
        this.ageRange = parcel.readString();
        this.homeZone = parcel.readInt();
        this.carrierId = parcel.readInt();
    }

    public AbstractAuthAccount requestExtraScopes(List<Scope> list) {
        if (ap.b(list).booleanValue()) {
            this.extensionScopes.addAll(list);
        }
        return this;
    }

    public void setAgeRange(String str) {
        this.ageRange = str;
    }

    public void setAvatarUriString(String str) {
        this.photoUriString = str;
    }

    public void setCarrierId(int i3) {
        this.carrierId = i3;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setExpirationTimeSecs(long j3) {
        this.expirationTimeSecs = j3;
    }

    public void setExtensionScopes(Set<Scope> set) {
        this.extensionScopes = set;
    }

    public void setFamilyName(String str) {
        this.familyName = str;
    }

    public void setGivenName(String str) {
        this.givenName = str;
    }

    public void setHomeZone(int i3) {
        this.homeZone = i3;
    }

    public void setIdToken(String str) {
        this.idToken = str;
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getUid() != null) {
            jSONObject.put("uid", getUid());
        }
        if (getOpenId() != null) {
            jSONObject.put("openId", getOpenId());
        }
        if (getAvatarUriString() != null) {
            jSONObject.put(CommonConstant.KEY_PHOTO_URI, getAvatarUriString());
        }
        if (getAccessToken() != null) {
            jSONObject.put(CommonConstant.KEY_ACCESS_TOKEN, getAccessToken());
        }
        if (getDisplayName() != null) {
            jSONObject.put(CommonConstant.KEY_DISPLAY_NAME, getDisplayName());
        }
        jSONObject.put("status", getStatus());
        jSONObject.put("gender", getGender());
        if (getCountryCode() != null) {
            jSONObject.put("countryCode", getCountryCode());
        }
        if (getUnionId() != null) {
            jSONObject.put(CommonConstant.KEY_UNION_ID, getUnionId());
        }
        if (getEmail() != null) {
            jSONObject.put("email", getEmail());
        }
        if (getAuthorizationCode() != null) {
            jSONObject.put(CommonConstant.KEY_SERVER_AUTH_CODE, getAuthorizationCode());
        }
        if (getServiceCountryCode() != null) {
            jSONObject.put(CommonConstant.KEY_SERVICE_COUNTRY_CODE, getServiceCountryCode());
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
        jSONObject.put(CommonConstant.KEY_CARRIER_ID, getCarrierId());
        return jsonPutOpt(jsonPutScopes(jSONObject));
    }

    public String toString() {
        return "{uid: " + this.uid + ",displayName: " + this.displayName + ",photoUriString: " + this.photoUriString + ",status: " + this.status + ",gender: " + this.gender + ",serviceCountryCode: " + this.serviceCountryCode + ",countryCode: " + this.countryCode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uid);
        parcel.writeString(this.openId);
        parcel.writeString(this.displayName);
        parcel.writeString(this.photoUriString);
        parcel.writeString(this.accessToken);
        parcel.writeInt(this.status);
        parcel.writeInt(this.gender);
        parcel.writeString(this.serverAuthCode);
        parcel.writeString(this.serviceCountryCode);
        parcel.writeString(this.countryCode);
        parcel.writeList(new ArrayList(this.grantedScopes));
        parcel.writeString(this.unionId);
        parcel.writeString(this.email);
        parcel.writeString(this.idToken);
        parcel.writeLong(this.expirationTimeSecs);
        parcel.writeString(this.givenName);
        parcel.writeString(this.familyName);
        parcel.writeString(this.ageRange);
        parcel.writeInt(this.homeZone);
        parcel.writeInt(this.carrierId);
    }

    public AbstractAuthAccount() {
        this.extensionScopes = new HashSet();
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
    }
}
