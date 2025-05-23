package com.tencent.qqmini.sdk.auth;

import java.util.Map;

/* loaded from: classes23.dex */
public interface PermissionParser {
    Map<String, EventInfo> getEventsMap();

    Map<String, PermissionInfo> getScopePermissionMap();

    Map<String, PermissionInfo> getSystemPermissionMap();

    boolean parse();
}
