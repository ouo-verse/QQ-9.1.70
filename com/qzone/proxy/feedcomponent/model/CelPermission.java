package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_permission;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class CelPermission implements SmartParcelable {

    @NeedParcel
    public String permission_info;

    @NeedParcel
    public int permission_mask;

    @NeedParcel
    public String status_info;

    public static CelPermission create(l lVar) {
        if (lVar == null || lVar.f50388y == null) {
            return null;
        }
        CelPermission celPermission = new CelPermission();
        cell_permission cell_permissionVar = lVar.f50388y;
        celPermission.permission_info = cell_permissionVar.permission_info;
        celPermission.permission_mask = cell_permissionVar.permission_mask;
        celPermission.status_info = cell_permissionVar.status_info;
        return celPermission;
    }
}
