package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/f;", "Lcom/tencent/mobileqq/config/business/qmmkv/a;", "", "update", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final f f202810f = new f();

    f() {
        super("mmkv_cache_config_9020", 0);
    }

    @Override // com.tencent.mobileqq.config.business.qmmkv.m
    public void update() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(getConfigKey(), "");
        if (loadAsString != null && loadAsString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            d(getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String());
            return;
        }
        int i3 = getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String();
        try {
            i3 = new JSONObject(loadAsString).optInt("maxSize", 0);
        } catch (Exception e16) {
            QLog.w("QMMKV_ConfigIntValue", 1, "MMKVCacheCountMix [" + getConfigKey() + "] parse exception:" + e16.getMessage(), e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QMMKV_ConfigIntValue", 1, "MMKVCacheCountMix [" + getConfigKey() + "] update value: " + i3 + " config:" + loadAsString);
        }
        d(i3);
    }
}
