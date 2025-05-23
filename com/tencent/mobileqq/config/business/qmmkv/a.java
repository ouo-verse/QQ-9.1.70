package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\n\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/a;", "Lcom/tencent/mobileqq/config/business/qmmkv/m;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "configKey", "", "b", "I", "()I", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "Ljava/lang/Integer;", "_cachedValue", "value", "d", "(I)V", "<init>", "(Ljava/lang/String;I)V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class a implements m {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final l f202798e = new l();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int defaultValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer _cachedValue;

    public a(@NotNull String configKey, int i3) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        this.configKey = configKey;
        this.defaultValue = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getConfigKey() {
        return this.configKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public final int c() {
        if (this._cachedValue == null) {
            this._cachedValue = f202798e.d(this.configKey, this.defaultValue);
            if (QLog.isColorLevel()) {
                QLog.d("QMMKV_ConfigIntValue", 1, "get value [" + this.configKey + "]: " + this._cachedValue);
            }
        }
        Integer num = this._cachedValue;
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }

    public final void d(int i3) {
        Integer num = this._cachedValue;
        if (num == null || num == null || num.intValue() != i3) {
            f202798e.e(this.configKey, i3);
            if (QLog.isColorLevel()) {
                QLog.i("QMMKV_ConfigIntValue", 1, "set value [" + this.configKey + "]: " + i3);
            }
            this._cachedValue = Integer.valueOf(i3);
        }
    }
}
