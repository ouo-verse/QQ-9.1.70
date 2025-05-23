package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/util/QzoneFakeDataUtil;", "", "()V", "buildMasterUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFakeDataUtil {
    public static final int $stable = 0;
    public static final QzoneFakeDataUtil INSTANCE = new QzoneFakeDataUtil();

    QzoneFakeDataUtil() {
    }

    public final CommonUser buildMasterUser() {
        String str;
        String syncToNativeMethod;
        CommonUser commonUser = new CommonUser();
        QZoneComposePlatformModule.Companion companion = QZoneComposePlatformModule.Companion;
        commonUser.setUin(companion.getUin());
        QZoneComposePlatformModule qZoneComposePlatformModule = companion.get();
        String str2 = "";
        if (qZoneComposePlatformModule == null || (str = qZoneComposePlatformModule.syncToNativeMethod("getUid", (e) null, (Function1<? super e, Unit>) null)) == null) {
            str = "";
        }
        commonUser.setUid(str);
        QZoneComposePlatformModule qZoneComposePlatformModule2 = companion.get();
        if (qZoneComposePlatformModule2 != null && (syncToNativeMethod = qZoneComposePlatformModule2.syncToNativeMethod("getNickName", (e) null, (Function1<? super e, Unit>) null)) != null) {
            str2 = syncToNativeMethod;
        }
        commonUser.setNick(str2);
        return commonUser;
    }
}
