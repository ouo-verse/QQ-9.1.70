package com.tencent.tmassistantbase.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.r;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DownloadSDKConfigManager {
    private static final String TAG = "DownloadSDKConfigManager";

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.tmdownloader.f.a.a.a().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.tmdownloader.f.a.a.a().f();
        }
    }

    public static boolean canGotoNewAppListPage() {
        NewQqCenterConfig b16 = com.tencent.tmdownloader.f.b.b.a().b();
        if (b16 == null) {
            r.a(TAG, "[canGotoNewDetailPage] cfg is empty!");
            return true;
        }
        if (b16.entranceSwitch != 1) {
            return true;
        }
        return false;
    }

    public static boolean canGotoNewDetailPage(String str) {
        NewQqCenterConfig b16 = com.tencent.tmdownloader.f.b.b.a().b();
        if (b16 != null && b16.enterOldViaList != null && !TextUtils.isEmpty(str)) {
            int i3 = b16.detailSwitch;
            if (i3 != 0 && i3 == 1) {
                Iterator<String> it = b16.enterOldViaList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && str.startsWith(next)) {
                        return false;
                    }
                }
            }
            return true;
        }
        r.a(TAG, "[canGotoNewDetailPage] cfg is empty!");
        return true;
    }

    public static String getPageUrl(String str) {
        NewQqCenterConfig b16 = com.tencent.tmdownloader.f.b.b.a().b();
        if (b16 != null && b16.appNewsUrlMap != null && !TextUtils.isEmpty(str)) {
            return b16.appNewsUrlMap.get(str);
        }
        r.a(TAG, "[getPageUrl] cfg is empty!");
        return "";
    }

    public static boolean isDownloadUrlBlocked(Context context, String str) {
        System.currentTimeMillis();
        e.a().post(new a());
        List<String> a16 = com.tencent.tmdownloader.f.b.b.a().a(context);
        if (!TextUtils.isEmpty(str) && a16 != null && a16.size() != 0) {
            Iterator<String> it = a16.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void refreshNewAppCenterConfig() {
        e.a().post(new b());
    }
}
