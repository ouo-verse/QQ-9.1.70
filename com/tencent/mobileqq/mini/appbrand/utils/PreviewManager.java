package com.tencent.mobileqq.mini.appbrand.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes33.dex */
public class PreviewManager {
    private static PreviewManager instance;
    private final Set<String> previewAppIds;
    private final Map<String, MiniAppInfo> previewAppInfos;

    PreviewManager() {
        HashSet hashSet = new HashSet();
        this.previewAppIds = hashSet;
        this.previewAppInfos = new HashMap();
        hashSet.add(MiniConst.MetaRoomConst.META_ROOM_MINI_APP_ID);
    }

    public static PreviewManager getInstance() {
        if (instance == null) {
            instance = new PreviewManager();
        }
        return instance;
    }

    public boolean containsAppId(String str) {
        return !TextUtils.isEmpty(str) && this.previewAppIds.contains(str);
    }

    public MiniAppInfo getPreviewInfo(MiniAppInfo miniAppInfo) {
        return (miniAppInfo == null || !this.previewAppInfos.containsKey(miniAppInfo.appId)) ? miniAppInfo : this.previewAppInfos.get(miniAppInfo.appId);
    }

    public boolean recordAppInfo(MiniAppInfo miniAppInfo, LaunchParam launchParam) {
        int i3;
        if (miniAppInfo == null || !this.previewAppIds.contains(miniAppInfo.appId) || launchParam == null || !((i3 = launchParam.scene) == 1012 || i3 == 1011)) {
            return false;
        }
        this.previewAppInfos.put(miniAppInfo.appId, miniAppInfo);
        return true;
    }
}
