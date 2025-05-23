package com.tencent.mobileqq.minigame.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes33.dex */
public class KuiklyPreloadUtil {
    private static final String TAG = "KuiklyPreloadUtil";
    private static HashMap<String, Boolean> sPreloadMap = new HashMap<>();

    public static void preloadAsync(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.utils.KuiklyPreloadUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KuiklyPreloadUtil.preloadFromJumpUrl(str);
                } catch (Exception e16) {
                    QLog.e(KuiklyPreloadUtil.TAG, 1, "preloadAsync ", e16);
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void preloadFromJumpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("bundle_name");
            String queryParameter2 = parse.getQueryParameter("page_name");
            if (TextUtils.isEmpty(queryParameter)) {
                QLog.i(TAG, 1, "preloadFromJumpUrl jumpLink:" + str + " but bundleName is empty");
                return;
            }
            if (sPreloadMap.containsKey(queryParameter)) {
                return;
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                boolean isDexPageExist = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).isDexPageExist(queryParameter, queryParameter2);
                QLog.d(TAG, 1, "preloadFromJumpUrl jumpLink:" + str + " isExist:" + isDexPageExist);
                if (isDexPageExist) {
                    return;
                }
            }
            QLog.i(TAG, 1, "preloadFromJumpUrl start preload jumpLink:" + str);
            sPreloadMap.put(queryParameter, Boolean.TRUE);
            QLog.d(TAG, 1, "preloadFromJumpUrl bundleName:$bundleName");
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(queryParameter, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.minigame.utils.KuiklyPreloadUtil.2
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(ResError resError) {
                    QLog.d(KuiklyPreloadUtil.TAG, 1, "preloadFromJumpUrl code: " + resError.getCode() + " message: " + resError.getMessage());
                    return null;
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "preloadFromJumpUrl ", e16);
        }
    }
}
