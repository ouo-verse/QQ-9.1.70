package com.tencent.mobileqq.zootopia.helper;

import android.app.Activity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J-\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/helper/e;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "a", "", "requestCode", "", "", "permissions", "", "rantResults", "", "b", "(I[Ljava/lang/String;[I)Z", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Ljava/util/concurrent/ConcurrentHashMap;", "permissionMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Pair<String, String>, QQPermission> permissionMap = new ConcurrentHashMap<>();

    public final QQPermission a(Activity activity, BusinessConfig config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        Pair<String, String> pair = new Pair<>(config.getBusinessId(), config.getBusinessScene());
        QQPermission qQPermission = this.permissionMap.get(pair);
        if (qQPermission != null) {
            return qQPermission;
        }
        QQPermission qQPermission2 = QQPermissionFactory.getQQPermission(activity, config);
        if (qQPermission2 == null) {
            return null;
        }
        this.permissionMap.put(pair, qQPermission2);
        return qQPermission2;
    }

    public final boolean b(int requestCode, String[] permissions, int[] rantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(rantResults, "rantResults");
        if (this.permissionMap.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<Pair<String, String>, QQPermission>> it = this.permissionMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onRequestPermissionResult(requestCode, permissions, rantResults);
        }
        return true;
    }
}
