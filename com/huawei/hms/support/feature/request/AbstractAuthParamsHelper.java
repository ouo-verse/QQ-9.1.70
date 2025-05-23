package com.huawei.hms.support.feature.request;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class AbstractAuthParamsHelper {
    protected Set<Scope> signInScopes = new HashSet();
    protected Set<PermissionInfo> permissionSet = new HashSet();

    public AbstractAuthParamsHelper() {
    }

    public AbstractAuthParamsHelper(AbstractAuthParams abstractAuthParams) {
        this.signInScopes.addAll(abstractAuthParams.getRequestScopeList());
        this.permissionSet.addAll(abstractAuthParams.getPermissionInfos());
    }
}
