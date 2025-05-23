package com.tencent.icgame.common.api.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.icgame.common.api.IQQLiveHEVCAbility;
import com.tencent.mobileqq.util.cu;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import ut0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/icgame/common/api/impl/QQLiveHEVCAbilityImpl;", "Lcom/tencent/icgame/common/api/IQQLiveHEVCAbility;", "", "getDeviceType", "Landroid/content/Context;", "context", "", "isOnPadDevices", "", "getModel", "hevcDecodeSupportLevel", "getDeviceInfo", "hevcSupportLevel", "I", "Ljava/lang/ThreadLocal;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilderLocal", "Ljava/lang/ThreadLocal;", "<init>", "()V", "Companion", "a", "ic-game-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveHEVCAbilityImpl implements IQQLiveHEVCAbility {
    private static final int DEVICE_TYPE_ANDROID_PAD = 3;
    private static final int DEVICE_TYPE_ANDROID_PHONE = 1;

    @NotNull
    private static final String TAG = "ICGameHEVCAbilityImpl";
    private int hevcSupportLevel = -1;

    @NotNull
    private final ThreadLocal<StringBuilder> stringBuilderLocal = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/icgame/common/api/impl/QQLiveHEVCAbilityImpl$b", "Ljava/lang/ThreadLocal;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "a", "ic-game-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ThreadLocal<StringBuilder> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    private final int getDeviceType() {
        if (isOnPadDevices(Foreground.getTopActivity())) {
            return 3;
        }
        return 1;
    }

    private final String getModel() {
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            model = cu.d("ro.product.marketname");
        }
        Intrinsics.checkNotNullExpressionValue(model, "model");
        return model;
    }

    private final boolean isOnPadDevices(Context context) {
        if (context == null) {
            return false;
        }
        if (!a.d(context) && !a.g(context) && !a.h(context)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.icgame.common.api.IQQLiveHEVCAbility
    @NotNull
    public String getDeviceInfo() {
        String str;
        StringBuilder sb5 = this.stringBuilderLocal.get();
        if (sb5 != null) {
            sb5.setLength(0);
            sb5.append("a=");
            sb5.append(Build.VERSION.SDK_INT);
            sb5.append("&m=");
            sb5.append(getModel());
            sb5.append("&liveH265=");
            sb5.append(getHevcSupportLevel());
            sb5.append("&qua=");
            sb5.append(QUA.getQUA3());
            sb5.append("&devicetype=");
            sb5.append(getDeviceType());
            str = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(str, "it.toString()");
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getDeviceInfo] deviceInfo=" + ((Object) str));
        }
        return str;
    }

    @Override // com.tencent.icgame.common.api.IQQLiveHEVCAbility
    /* renamed from: hevcDecodeSupportLevel, reason: from getter */
    public int getHevcSupportLevel() {
        return this.hevcSupportLevel;
    }
}
