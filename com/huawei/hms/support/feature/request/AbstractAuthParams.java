package com.huawei.hms.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.api.Api;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class AbstractAuthParams implements Parcelable, Api.ApiOptions.HasOptions {
    protected ArrayList<PermissionInfo> permissionArrayList;
    protected final ArrayList<Scope> scopeArrayList;
    public static final PermissionInfo UID_DYNAMIC_PERMISSION = new PermissionInfo().setPermissionUri(CommonConstant.PERMISSION.UID);
    public static final Scope PROFILE = new Scope("profile");
    public static final Scope EMAIL = new Scope("email");
    public static final Scope OPENID = new Scope("openid");
    public static final Scope SCOPE_GAMES = new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_GAME);

    protected AbstractAuthParams(Set<Scope> set, Set<PermissionInfo> set2) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PermissionInfo jsonToPermission(JSONObject jSONObject) {
        return new PermissionInfo().setPermissionUri(jSONObject.optString(QCircleDaTongConstant.ElementParamValue.PERMISSION, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Scope jsonToScope(JSONObject jSONObject) {
        return new Scope(jSONObject.optString(com.huawei.hms.support.feature.result.CommonConstant.KEY_SCOPE_URI, null));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractAuthParams)) {
            return false;
        }
        AbstractAuthParams abstractAuthParams = (AbstractAuthParams) obj;
        if (isListEquals(this.scopeArrayList, abstractAuthParams.scopeArrayList) && isListEquals(this.permissionArrayList, abstractAuthParams.permissionArrayList)) {
            return true;
        }
        return false;
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.permissionArrayList;
    }

    public List<Scope> getRequestScopeList() {
        return this.scopeArrayList;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.scopeArrayList;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> boolean isListEquals(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        return arrayList.containsAll(arrayList2);
    }

    protected JSONObject permissionToJson(PermissionInfo permissionInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (permissionInfo.getPermission() != null) {
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, permissionInfo.getPermission());
        }
        return jSONObject;
    }

    protected JSONObject scopeToJson(Scope scope) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (scope.getScopeUri() != null) {
            jSONObject.put(com.huawei.hms.support.feature.result.CommonConstant.KEY_SCOPE_URI, scope.getScopeUri());
        }
        return jSONObject;
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.scopeArrayList != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Scope> it = this.scopeArrayList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(scopeToJson(it.next()));
            }
            jSONObject.put("scopeArrayList", jSONArray);
        }
        if (this.permissionArrayList != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<PermissionInfo> it5 = this.permissionArrayList.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(permissionToJson(it5.next()));
            }
            jSONObject.put("permissionArrayList", jSONArray2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.scopeArrayList);
        parcel.writeList(this.permissionArrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2) {
        this.scopeArrayList = arrayList;
        this.permissionArrayList = arrayList2;
    }
}
