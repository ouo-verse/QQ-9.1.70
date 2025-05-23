package com.tencent.superplayer.config;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class RequestRootGroup {
    public static final int APP_ID_KUAIBAO = 570303;
    public static final int APP_ID_MOBILE_QQ = 170303;
    public static final int APP_ID_QQBROWSER = 160303;
    public static final int SCENE_ID_KV = 104;
    private static SparseArray<String> sRequestMap;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sRequestMap = sparseArray;
        sparseArray.put(APP_ID_MOBILE_QQ, MimeHelper.MIME_TYPE_MOBILEQQ);
        sRequestMap.put(APP_ID_KUAIBAO, "kuaibao");
        sRequestMap.put(APP_ID_QQBROWSER, "qqbrowser");
    }

    RequestRootGroup() {
    }

    public static String getRequestRootGroup() {
        return sRequestMap.get(SuperPlayerSDKMgr.getPlatform(), "default");
    }

    public static boolean needRequest() {
        if (sRequestMap.get(SuperPlayerSDKMgr.getPlatform(), null) != null) {
            return true;
        }
        return false;
    }
}
