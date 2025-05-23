package com.huawei.hms.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AccountAuthParams extends AbstractAuthParams {

    /* renamed from: a, reason: collision with root package name */
    private String f37504a;

    /* renamed from: b, reason: collision with root package name */
    private int f37505b;
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM = new AccountAuthParamsHelper().setId().setProfile().createParams();
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM_GAME = new AccountAuthParamsHelper().setScope(AbstractAuthParams.SCOPE_GAMES).createParams();
    public static final Parcelable.Creator<AccountAuthParams> CREATOR = new Parcelable.Creator<AccountAuthParams>() { // from class: com.huawei.hms.support.account.request.AccountAuthParams.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountAuthParams createFromParcel(Parcel parcel) {
            return new AccountAuthParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountAuthParams[] newArray(int i3) {
            return new AccountAuthParams[i3];
        }
    };

    public static AccountAuthParams fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return fromJsonObject(new JSONObject(str));
    }

    public static AccountAuthParams fromJsonObject(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("scopeArrayList");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(AbstractAuthParams.jsonToScope(jSONArray.getJSONObject(i3)));
            }
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("permissionArrayList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray2 != null) {
            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                arrayList2.add(AbstractAuthParams.jsonToPermission(jSONArray2.getJSONObject(i16)));
            }
        }
        String optString = jSONObject.optString(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS);
        AccountAuthParams accountAuthParams = new AccountAuthParams((ArrayList<Scope>) arrayList, (ArrayList<PermissionInfo>) arrayList2);
        accountAuthParams.setSignInParams(optString);
        return accountAuthParams;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountAuthParams)) {
            return false;
        }
        AccountAuthParams accountAuthParams = (AccountAuthParams) obj;
        if (isListEquals(this.scopeArrayList, accountAuthParams.scopeArrayList) && isListEquals(this.permissionArrayList, accountAuthParams.permissionArrayList)) {
            return true;
        }
        return false;
    }

    public int getIdTokenSignAlg() {
        return this.f37505b;
    }

    public String getSignInParams() {
        return this.f37504a;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public int hashCode() {
        int hashCode;
        ArrayList<Scope> arrayList = this.scopeArrayList;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = (hashCode + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.permissionArrayList;
        if (arrayList2 != null) {
            i3 = arrayList2.hashCode();
        }
        return i16 + i3;
    }

    public void setIdTokenSignAlg(int i3) {
        this.f37505b = i3;
    }

    public void setSignInParams(String str) {
        this.f37504a = str;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS, this.f37504a);
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AccountAuthParams(Set<Scope> set, Set<PermissionInfo> set2) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AccountAuthParams(Set<Scope> set, Set<PermissionInfo> set2, String str) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
        this.f37504a = str;
    }

    protected AccountAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2) {
        super(arrayList, arrayList2);
        this.f37504a = "";
    }

    protected AccountAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str) {
        super(arrayList, arrayList2);
        this.f37504a = str;
    }

    AccountAuthParams(Parcel parcel) {
        super((ArrayList<Scope>) parcel.createTypedArrayList(Scope.CREATOR), (ArrayList<PermissionInfo>) parcel.createTypedArrayList(PermissionInfo.CREATOR));
        this.f37504a = "";
        this.f37504a = parcel.readString();
    }
}
