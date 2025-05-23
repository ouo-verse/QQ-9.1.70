package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class f implements b {
    @Override // com.vivo.push.util.o
    public final List<String> a(Context context) {
        k.a("findAllCoreClientPush");
        List<ResolveInfo> list = null;
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            u.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        } catch (Exception unused) {
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ResolveInfo resolveInfo = list.get(i3);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            u.d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }
}
