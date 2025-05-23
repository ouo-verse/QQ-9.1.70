package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/e;", "", "", "d", "c", "", "a", "g", "e", "b", "f", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f318514a = new e();

    e() {
    }

    public final int a() {
        Integer intOrNull;
        int i3;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_mmkv_clean_filesize", "50"));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 100;
        }
        QLog.d("WinkEditorDraftCleanConfig", 4, "getQCircleCleanThreshold, ret:" + i3);
        return i3;
    }

    public final int b() {
        Integer intOrNull;
        int i3;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_mmkv_clean_filesize", "50"));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 100;
        }
        QLog.d("WinkEditorDraftCleanConfig", 4, "getQZoneCleanThreshold, ret:" + i3);
        return i3;
    }

    public final boolean c() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_open_wink_mmkv_clean", true);
        QLog.d("WinkEditorDraftCleanConfig", 4, "isEnableQCircleClean, ret:" + isSwitchOn);
        return isSwitchOn;
    }

    public final boolean d() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_open_wink_mmkv_instant_delete", true);
        QLog.d("WinkEditorDraftCleanConfig", 4, "isEnableQCircleInstantDelete, ret:" + isSwitchOn);
        return isSwitchOn;
    }

    public final boolean e() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_open_wink_mmkv_clean", false);
        QLog.d("WinkEditorDraftCleanConfig", 4, "isEnableQZoneClean, ret:" + isSwitchOn);
        return isSwitchOn;
    }

    public final boolean f() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_open_wink_mmkv_clean_ignore_business_name", true);
        QLog.d("WinkEditorDraftCleanConfig", 4, "isEnableQZoneCleanIgnoreBusinessName, ret:" + isSwitchOn);
        return isSwitchOn;
    }

    public final boolean g() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_open_wink_mmkv_instant_delete", true);
        QLog.d("WinkEditorDraftCleanConfig", 4, "isEnableQZoneInstantDelete, ret:" + isSwitchOn);
        return isSwitchOn;
    }
}
