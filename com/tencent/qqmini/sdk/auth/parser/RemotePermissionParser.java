package com.tencent.qqmini.sdk.auth.parser;

import android.content.Context;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import java.util.Map;

/* loaded from: classes23.dex */
public class RemotePermissionParser implements PermissionParser {
    public RemotePermissionParser(Context context) {
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, EventInfo> getEventsMap() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, PermissionInfo> getScopePermissionMap() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public Map<String, PermissionInfo> getSystemPermissionMap() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public boolean parse() {
        return false;
    }
}
