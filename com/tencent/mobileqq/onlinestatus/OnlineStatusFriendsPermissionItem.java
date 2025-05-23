package com.tencent.mobileqq.onlinestatus;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class OnlineStatusFriendsPermissionItem implements Serializable {
    public static final String TAG = "OnlineStatusPermissionItem";
    public boolean allHasPermission;
    public List<Long> permissionUins;

    public OnlineStatusFriendsPermissionItem(boolean z16, List<Long> list) {
        this.allHasPermission = true;
        this.permissionUins = new ArrayList(0);
        list = list == null ? new ArrayList<>() : list;
        this.allHasPermission = z16;
        this.permissionUins = list;
    }

    @NonNull
    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" allHasPermission=");
        sb5.append(this.allHasPermission);
        sb5.append(" permissionUins");
        List<Long> list = this.permissionUins;
        if (list == null) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        return sb5.toString();
    }
}
