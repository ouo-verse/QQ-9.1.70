package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_permission;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class CellPermissionInfo implements SmartParcelable {

    @NeedParcel
    public Map<Integer, String> map_permission_msg;

    @NeedParcel
    public int permission_mask;

    @NeedParcel
    public int permission_source;

    @NeedParcel
    public int permission_visit;

    @NeedParcel
    public String permission_info = "";

    @NeedParcel
    public String status_info = "";

    @NeedParcel
    public String permission_tips = "";

    @NeedParcel
    public String permission_jumpurl = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellPermissionInfo {\n");
        if (!TextUtils.isEmpty(this.permission_info)) {
            sb5.append("permission_info: ");
            sb5.append(this.permission_info);
            sb5.append("\n");
        }
        sb5.append("permission_mask: ");
        sb5.append(this.permission_mask);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.status_info)) {
            sb5.append("status_info: ");
            sb5.append(this.status_info);
            sb5.append("\n");
        }
        sb5.append("permission_visit: ");
        sb5.append(this.permission_visit);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.permission_tips)) {
            sb5.append("permission_tips: ");
            sb5.append(this.permission_tips);
            sb5.append("\n");
        }
        sb5.append("permission_jumpurl: ");
        sb5.append(this.permission_jumpurl);
        sb5.append("\n");
        sb5.append("permission_source: ");
        sb5.append(this.permission_source);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellPermissionInfo create(l lVar) {
        if (lVar == null || lVar.f50388y == null) {
            return null;
        }
        CellPermissionInfo cellPermissionInfo = new CellPermissionInfo();
        cell_permission cell_permissionVar = lVar.f50388y;
        cellPermissionInfo.permission_info = cell_permissionVar.permission_info;
        cellPermissionInfo.permission_mask = cell_permissionVar.permission_mask;
        cellPermissionInfo.status_info = cell_permissionVar.status_info;
        cellPermissionInfo.permission_visit = cell_permissionVar.permission_visit;
        cellPermissionInfo.permission_tips = cell_permissionVar.permission_tips;
        cellPermissionInfo.permission_jumpurl = cell_permissionVar.permission_jumpurl;
        cellPermissionInfo.permission_source = cell_permissionVar.permission_source;
        Map<Integer, String> map = cell_permissionVar.map_permission_msg;
        if (map != null && map.size() > 0) {
            cellPermissionInfo.map_permission_msg = new HashMap();
            for (Map.Entry<Integer, String> entry : lVar.f50388y.map_permission_msg.entrySet()) {
                cellPermissionInfo.map_permission_msg.put(entry.getKey(), entry.getValue());
            }
        }
        return cellPermissionInfo;
    }
}
