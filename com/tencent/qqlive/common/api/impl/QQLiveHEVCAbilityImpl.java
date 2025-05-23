package com.tencent.qqlive.common.api.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbilityKt;
import com.tencent.qqlive.common.screen.a;
import cooperation.qzone.QUA;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0017j\u0002`\u00180\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqlive/common/api/impl/QQLiveHEVCAbilityImpl;", "Lcom/tencent/qqlive/common/api/IQQLiveHEVCAbility;", "", "getDeviceType", "Landroid/content/Context;", "context", "", "isOnPadDevices", "", "getModel", "configList", "check", "source", "isInConfigList", "getAccountPostfix", "hevcDecodeSupportLevel", "isHevcEncodeEnable", "getDeviceInfo", "hevcHasDetected", "Z", "hevcSupportLevel", "I", "Ljava/lang/ThreadLocal;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilderLocal", "Ljava/lang/ThreadLocal;", "<init>", "()V", "Companion", "a", "qq-live-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQLiveHEVCAbilityImpl implements IQQLiveHEVCAbility {
    private static final int DEVICE_TYPE_ANDROID_PAD = 3;
    private static final int DEVICE_TYPE_ANDROID_PHONE = 1;

    @NotNull
    private static final String RFW_IS_DETECT_HEVC = "key_sp_is_detect_hevc";

    @NotNull
    private static final String RFW_IS_SUPPORT_HEVC = "key_sp_is_support_hevc";

    @NotNull
    private static final String TAG = "QQLiveHEVCAbilityImpl";
    private boolean hevcHasDetected;
    private int hevcSupportLevel = -1;

    @NotNull
    private final ThreadLocal<StringBuilder> stringBuilderLocal = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqlive/common/api/impl/QQLiveHEVCAbilityImpl$b", "Ljava/lang/ThreadLocal;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "a", "qq-live-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
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

    private final String getAccountPostfix() {
        char last;
        try {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
            last = StringsKt___StringsKt.last(account);
            return String.valueOf(last);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[getAccountPostfix] error ", e16);
            return "";
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

    private final boolean isInConfigList(String configList, String check, int source) {
        List<String> split$default;
        boolean equals;
        QLog.i(TAG, 1, "[isInConfigList] configList=" + configList + ", check=" + check + ", source=" + source);
        if (!Intrinsics.areEqual(configList, "all")) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) configList, new String[]{";"}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                equals = StringsKt__StringsJVMKt.equals(str, check, true);
                if (equals) {
                    QLog.i(TAG, 1, "[isInConfigList] hit config list, check=" + str);
                    return true;
                }
            }
            return false;
        }
        return true;
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

    @Override // com.tencent.qqlive.common.api.IQQLiveHEVCAbility
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
            sb5.append(hevcDecodeSupportLevel());
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

    @Override // com.tencent.qqlive.common.api.IQQLiveHEVCAbility
    public int hevcDecodeSupportLevel() {
        boolean isBlank;
        Integer intOrNull;
        if (this.hevcHasDetected) {
            return this.hevcSupportLevel;
        }
        int i3 = -1;
        if (isInConfigList(ht3.a.d("hevc_decode_model_blacklist", ""), getModel(), 0)) {
            this.hevcHasDetected = true;
            this.hevcSupportLevel = -1;
            return -1;
        }
        if (isInConfigList(ht3.a.d("hevc_decode_uin_blacklist_postfix", ""), getAccountPostfix(), 4)) {
            this.hevcHasDetected = true;
            this.hevcSupportLevel = -1;
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        boolean decodeBool = from.decodeBool(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_HAS_DETECTED, false);
        this.hevcHasDetected = decodeBool;
        if (decodeBool) {
            int decodeInt = from.decodeInt(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_SUPPORT_LEVEL, -1);
            this.hevcSupportLevel = decodeInt;
            QLog.i(TAG, 1, "[hevcSupportLevel] use qqlive detect, " + decodeInt);
        } else {
            String decodeString = from.decodeString(RFW_IS_DETECT_HEVC, "");
            Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(RFW_IS_DETECT_HEVC, \"\")");
            isBlank = StringsKt__StringsJVMKt.isBlank(decodeString);
            if (!isBlank) {
                String qcircleDetectLevel = from.decodeString(RFW_IS_SUPPORT_HEVC, "");
                QLog.i(TAG, 1, "[hevcSupportLevel] use qcircle detect, " + qcircleDetectLevel);
                Intrinsics.checkNotNullExpressionValue(qcircleDetectLevel, "qcircleDetectLevel");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(qcircleDetectLevel);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                }
                this.hevcSupportLevel = i3;
                this.hevcHasDetected = true;
            }
        }
        if (QLog.isColorLevel()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.d(TAG, 2, "[hevcSupportLevel] hevcSupportLevel=" + this.hevcSupportLevel + ", cost=" + currentTimeMillis2);
        }
        return this.hevcSupportLevel;
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveHEVCAbility
    public boolean isHevcEncodeEnable() {
        if (isInConfigList(ht3.a.d("hevc_encode_model_whitelist", ""), getModel(), 1)) {
            return true;
        }
        String d16 = ht3.a.d("hevc_encode_uin_whitelist", "");
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account == null) {
            account = HippyReporter.RemoveEngineReason.INVALID;
        }
        if (isInConfigList(d16, account, 2)) {
            return true;
        }
        if (!isInConfigList(ht3.a.d("hevc_encode_model_blacklist", ""), getModel(), 3) && !isInConfigList(ht3.a.d("hevc_encode_uin_blacklist_postfix", ""), getAccountPostfix(), 5)) {
            return true;
        }
        return false;
    }
}
