package com.tencent.qqmini.sdk.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public class PermissionManager {
    private static final String TAG = "PermissionManager";
    private static final PermissionManager sInstance = new PermissionManager();
    private ParseStateListener mParseStateListener;
    private Boolean mParsed = Boolean.FALSE;
    private Map<String, PermissionInfo> mScopePermissions = new HashMap();
    private Map<String, PermissionInfo> mSystemPermissions = new HashMap();
    private Map<String, EventInfo> mAllEvents = new HashMap();
    private Map<String, String> mScopeEventMap = new HashMap();
    private Map<String, String> mEventScopeMap = new HashMap();

    /* loaded from: classes23.dex */
    public interface ParseStateListener {
        void onParsed();
    }

    PermissionManager() {
    }

    private void doParse(PermissionParser... permissionParserArr) {
        this.mScopePermissions.clear();
        this.mSystemPermissions.clear();
        this.mAllEvents.clear();
        this.mScopeEventMap.clear();
        this.mEventScopeMap.clear();
        for (PermissionParser permissionParser : permissionParserArr) {
            if (permissionParser.parse()) {
                this.mScopePermissions.putAll(permissionParser.getScopePermissionMap());
                this.mSystemPermissions.putAll(permissionParser.getSystemPermissionMap());
                this.mAllEvents.putAll(permissionParser.getEventsMap());
            }
        }
        for (EventInfo eventInfo : this.mAllEvents.values()) {
            for (String str : eventInfo.requestPermissions) {
                if (isScopePermissionValid(str)) {
                    this.mScopeEventMap.put(str, eventInfo.name);
                    this.mEventScopeMap.put(eventInfo.name, str);
                }
            }
        }
        this.mParsed = Boolean.TRUE;
        ParseStateListener parseStateListener = this.mParseStateListener;
        if (parseStateListener != null) {
            parseStateListener.onParsed();
        }
    }

    public static PermissionManager g() {
        return sInstance;
    }

    public List<String> getAllPermissions() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mScopePermissions.keySet());
        arrayList.addAll(this.mSystemPermissions.keySet());
        return arrayList;
    }

    public EventInfo getEvent(String str) {
        return this.mAllEvents.get(str);
    }

    public String getEventByScopePermission(String str) {
        return this.mScopeEventMap.get(str);
    }

    public String getEventRequestSystemPermission(String str) {
        EventInfo event = getEvent(str);
        if (event != null) {
            for (String str2 : event.requestPermissions) {
                if (this.mSystemPermissions.containsKey(str2)) {
                    return str2;
                }
            }
            return null;
        }
        return null;
    }

    public PermissionInfo getScopePermission(String str) {
        return this.mScopePermissions.get(str);
    }

    public String getScopePermissionByEvent(String str) {
        return this.mEventScopeMap.get(str);
    }

    public PermissionInfo getSystemPermission(String str) {
        return this.mSystemPermissions.get(str);
    }

    public boolean isScopePermissionValid(String str) {
        return this.mScopePermissions.containsKey(str);
    }

    public boolean isSystemPermissionValid(String str) {
        return this.mSystemPermissions.containsKey(str);
    }

    public void setParseStateListener(ParseStateListener parseStateListener) {
        this.mParseStateListener = parseStateListener;
    }

    public void startParse(PermissionParser... permissionParserArr) {
        synchronized (this.mParsed) {
            if (!this.mParsed.booleanValue()) {
                doParse(permissionParserArr);
            }
        }
    }

    public void updateScopePermission(String str, PermissionInfo permissionInfo) {
        this.mScopePermissions.put(str, permissionInfo);
    }
}
