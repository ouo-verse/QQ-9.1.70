package com.huawei.hms.support.hwid.request;

import com.huawei.hms.hwid.ap;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import com.huawei.hms.support.feature.request.AbstractAuthParamsHelper;
import java.util.List;

/* loaded from: classes2.dex */
public final class HuaweiIdAuthParamsHelper extends AbstractAuthParamsHelper {
    public HuaweiIdAuthParamsHelper() {
    }

    public HuaweiIdAuthParams createParams() {
        return new HuaweiIdAuthParams(this.signInScopes, this.permissionSet);
    }

    public HuaweiIdAuthParamsHelper setAccessToken() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.LocalPermission.ACCESS_TOKEN);
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public HuaweiIdAuthParamsHelper setAuthorizationCode() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.LocalPermission.SERVICE_AUTH_CODE);
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public HuaweiIdAuthParamsHelper setDialogAuth() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.LocalPermission.SETDIALOGAUTH);
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public HuaweiIdAuthParamsHelper setEmail() {
        return setScope(AbstractAuthParams.EMAIL);
    }

    public HuaweiIdAuthParamsHelper setId() {
        return setScope(AbstractAuthParams.OPENID);
    }

    public HuaweiIdAuthParamsHelper setIdToken() {
        this.permissionSet.add(new PermissionInfo().setPermissionUri(CommonConstant.PERMISSION.IDTOKEN));
        return this;
    }

    public HuaweiIdAuthParamsHelper setIncludeGranted(boolean z16) {
        if (!z16) {
            PermissionInfo permissionInfo = new PermissionInfo();
            permissionInfo.setPermissionUri(CommonConstant.IncludeGranted.NON_INCLUDE_GRANTED);
            this.permissionSet.add(permissionInfo);
        }
        return this;
    }

    public HuaweiIdAuthParamsHelper setMobileNumber() {
        setAccessToken();
        setId();
        return setScope(new Scope(CommonConstant.SCOPE.SCOPE_MOBILE_NUMBER));
    }

    public HuaweiIdAuthParamsHelper setProfile() {
        return setScope(AbstractAuthParams.PROFILE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HuaweiIdAuthParamsHelper setScope(Scope scope) {
        this.signInScopes.add(scope);
        return this;
    }

    public HuaweiIdAuthParamsHelper setScopeList(List<Scope> list) {
        if (ap.b(list).booleanValue()) {
            for (Scope scope : list) {
                if (scope != null && scope.getScopeUri() != null) {
                    this.signInScopes.add(scope);
                }
            }
        }
        return this;
    }

    public HuaweiIdAuthParamsHelper setShippingAddress() {
        setAccessToken();
        setId();
        return setScope(new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS));
    }

    public HuaweiIdAuthParamsHelper setUid() {
        this.permissionSet.add(AbstractAuthParams.UID_DYNAMIC_PERMISSION);
        return this;
    }

    public HuaweiIdAuthParamsHelper(HuaweiIdAuthParams huaweiIdAuthParams) {
        this.signInScopes.addAll(huaweiIdAuthParams.getRequestScopeList());
        this.permissionSet.addAll(huaweiIdAuthParams.getPermissionInfos());
    }
}
