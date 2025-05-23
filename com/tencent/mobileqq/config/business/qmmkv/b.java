package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\r\"\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/b;", "Lcom/tencent/mobileqq/config/business/qmmkv/m;", "", "update", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "configKey", "", "b", "Z", "getDefaultValue", "()Z", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "Ljava/lang/Boolean;", "_cachedSwitch", "value", "(Z)V", "<init>", "(Ljava/lang/String;Z)V", "d", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class b implements m {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final k f202803e = new k();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean defaultValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean _cachedSwitch;

    public b(@NotNull String configKey, boolean z16) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        this.configKey = configKey;
        this.defaultValue = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getConfigKey() {
        return this.configKey;
    }

    public final boolean b() {
        if (this._cachedSwitch == null) {
            this._cachedSwitch = f202803e.d(this.configKey, this.defaultValue);
            if (QLog.isColorLevel()) {
                QLog.d("QMMKV_ConfigSwitch", 1, "get switch [" + this.configKey + "]: " + this._cachedSwitch);
            }
        }
        Boolean bool = this._cachedSwitch;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final void c(boolean z16) {
        Boolean bool = this._cachedSwitch;
        if (bool == null || !Intrinsics.areEqual(bool, Boolean.valueOf(z16))) {
            f202803e.e(this.configKey, z16);
            if (QLog.isColorLevel()) {
                QLog.i("QMMKV_ConfigSwitch", 1, "set switch [" + this.configKey + "]: " + z16);
            }
            this._cachedSwitch = Boolean.valueOf(z16);
        }
    }

    @Override // com.tencent.mobileqq.config.business.qmmkv.m
    public void update() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(this.configKey, this.defaultValue);
        if (QLog.isColorLevel()) {
            QLog.d("QMMKV_ConfigSwitch", 1, "update switch [" + this.configKey + "] : " + isSwitchOn);
        }
        c(isSwitchOn);
    }
}
