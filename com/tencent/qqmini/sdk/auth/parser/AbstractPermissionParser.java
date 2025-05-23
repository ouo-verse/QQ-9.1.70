package com.tencent.qqmini.sdk.auth.parser;

import android.util.Log;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
abstract class AbstractPermissionParser implements PermissionParser {
    public static final String TAG = "PermissionParser";
    protected Map<String, PermissionInfo> mScopePermissionMap = new HashMap();
    protected Map<String, PermissionInfo> mSystemPermissionMap = new HashMap();
    protected Map<String, EventInfo> mEventsMap = new HashMap();

    public boolean addEvent(EventInfo eventInfo) {
        Map<String, EventInfo> map;
        if (eventInfo == null || (map = this.mEventsMap) == null) {
            return false;
        }
        if (map.containsKey(eventInfo.name)) {
            Log.w(TAG, "Ignore duplicated event entry " + eventInfo.name);
            return false;
        }
        this.mEventsMap.put(eventInfo.name, eventInfo);
        return true;
    }

    public boolean addPermission(PermissionInfo permissionInfo) {
        if (permissionInfo == null) {
            return false;
        }
        if (permissionInfo.builtIn) {
            if (this.mSystemPermissionMap.containsKey(permissionInfo.f348015id)) {
                Log.w(TAG, "Ignore duplicated system permission entry " + permissionInfo.f348015id);
                return false;
            }
            this.mSystemPermissionMap.put(permissionInfo.f348015id, permissionInfo);
            return true;
        }
        if (this.mScopePermissionMap.containsKey(permissionInfo.f348015id)) {
            Log.w(TAG, "Ignore duplicated scope permission entry " + permissionInfo.f348015id);
            return false;
        }
        this.mScopePermissionMap.put(permissionInfo.f348015id, permissionInfo);
        return true;
    }

    public void clear() {
        Map<String, PermissionInfo> map = this.mSystemPermissionMap;
        if (map != null) {
            map.clear();
        }
        Map<String, PermissionInfo> map2 = this.mScopePermissionMap;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, EventInfo> map3 = this.mEventsMap;
        if (map3 != null) {
            map3.clear();
        }
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, EventInfo> getEventsMap() {
        return this.mEventsMap;
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, PermissionInfo> getScopePermissionMap() {
        return this.mScopePermissionMap;
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, PermissionInfo> getSystemPermissionMap() {
        return this.mSystemPermissionMap;
    }
}
