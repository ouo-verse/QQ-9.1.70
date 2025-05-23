package com.tencent.hippykotlin.demo.pages.retain.repo;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ECRetainCacheManager {
    public static boolean isNeedRetain;
    public static final ECRetainCacheManager INSTANCE = new ECRetainCacheManager();
    public static ECRetainInfoModel cacheInfo = new ECRetainInfoModel("", "", 1, new e());
    public static final ArrayList<String> retainIdAry = new ArrayList<>();

    public final ECRetainInfoModel getCacheInfo() {
        ECRetainInfoModel eCRetainInfoModel = cacheInfo;
        return new ECRetainInfoModel(eCRetainInfoModel.retainId, eCRetainInfoModel.spuId, eCRetainInfoModel.type, eCRetainInfoModel.data);
    }

    public final void markRetainShowed(String str) {
        if (str.length() == 0) {
            KLog.INSTANCE.d("Retain", "mark retain showed invalid");
        } else {
            isNeedRetain = false;
            retainIdAry.remove(str);
        }
    }
}
