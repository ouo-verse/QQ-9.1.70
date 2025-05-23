package com.tencent.util;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u00f2\u0001\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u0002H\u000626\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00060\f2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00060\u001026\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00140\fH\u0002\u00a2\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u001bJ*\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u001dJ(\u0010\u001e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0004H\u0002J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0017J\u001e\u0010#\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001bJ\u001e\u0010$\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001dJ\u001e\u0010%\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\"\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/util/CommonMmkvAdaptUtils;", "", "()V", "TAG", "", "doGetValue", "T", "oldSpName", "key", "mmkvPrefix", "defValue", "readMmkv", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getSpValue", "Lkotlin/Function3;", "Landroid/content/SharedPreferences;", "sp", "writeMmkv", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "getBoolean", "", "getEntity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getInt", "", "getLong", "", "getString", "logC", "msg", "putBoolean", "value", "putInt", "putLong", "putString", "wrapMmkvKey", "app", "Lmqq/app/AppRuntime;", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CommonMmkvAdaptUtils {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final CommonMmkvAdaptUtils INSTANCE;

    @NotNull
    public static final String TAG = "CommonMmkvAdaptUtils";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34706);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new CommonMmkvAdaptUtils();
        }
    }

    CommonMmkvAdaptUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
    private final <T> T doGetValue(String oldSpName, String key, String mmkvPrefix, T defValue, Function2<? super String, ? super T, ? extends T> readMmkv, Function3<? super SharedPreferences, ? super String, ? super T, ? extends T> getSpValue, Function2<? super String, ? super T, Unit> writeMmkv) {
        boolean z16;
        String wrapMmkvKey = wrapMmkvKey(mmkvPrefix, key);
        if (oldSpName != null && oldSpName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !getEntity().containsKey(wrapMmkvKey)) {
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(oldSpName, 4);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sMobileQQ.getSharedPrefe\u2026ntext.MODE_MULTI_PROCESS)");
            T invoke = getSpValue.invoke(sharedPreferences, key, defValue);
            if (invoke != 0) {
                INSTANCE.logC("doGetValue read sp[" + key + "]: " + invoke);
                writeMmkv.invoke(key, invoke);
                return invoke;
            }
            QLog.e(TAG, 1, "doGetValue read sp return null. key= " + key);
            return defValue;
        }
        T invoke2 = readMmkv.invoke(wrapMmkvKey, defValue);
        logC("doGetValue read mmkv[" + wrapMmkvKey + "]: " + invoke2);
        return invoke2;
    }

    public static /* synthetic */ boolean getBoolean$default(CommonMmkvAdaptUtils commonMmkvAdaptUtils, String str, String str2, String str3, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return commonMmkvAdaptUtils.getBoolean(str, str2, str3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntity getEntity() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from;
    }

    public static /* synthetic */ int getInt$default(CommonMmkvAdaptUtils commonMmkvAdaptUtils, String str, String str2, String str3, int i3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        return commonMmkvAdaptUtils.getInt(str, str2, str3, i3);
    }

    public static /* synthetic */ long getLong$default(CommonMmkvAdaptUtils commonMmkvAdaptUtils, String str, String str2, String str3, long j3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            j3 = 0;
        }
        return commonMmkvAdaptUtils.getLong(str, str2, str3, j3);
    }

    private final void logC(String msg2) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, msg2);
        }
    }

    private final String wrapMmkvKey(AppRuntime app, String key, String mmkvPrefix) {
        String account = app != null ? app.getAccount() : null;
        if (account == null) {
            account = "";
        }
        if (account.length() == 0) {
            QLog.e(TAG, 1, "wrapMmkvKey account = (" + account + ")");
        }
        return mmkvPrefix + "_" + account + "_" + key;
    }

    public final boolean getBoolean(@Nullable String oldSpName, @NotNull String key, @NotNull final String mmkvPrefix, boolean defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, oldSpName, key, mmkvPrefix, Boolean.valueOf(defValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        return ((Boolean) doGetValue(oldSpName, key, mmkvPrefix, Boolean.valueOf(defValue), CommonMmkvAdaptUtils$getBoolean$1.INSTANCE, CommonMmkvAdaptUtils$getBoolean$2.INSTANCE, new Function2<String, Boolean, Unit>(mmkvPrefix) { // from class: com.tencent.util.CommonMmkvAdaptUtils$getBoolean$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $mmkvPrefix;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$mmkvPrefix = mmkvPrefix;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mmkvPrefix);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String k3, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, k3, Boolean.valueOf(z16));
                } else {
                    Intrinsics.checkNotNullParameter(k3, "k");
                    CommonMmkvAdaptUtils.INSTANCE.putBoolean(k3, this.$mmkvPrefix, z16);
                }
            }
        })).booleanValue();
    }

    public final int getInt(@Nullable String oldSpName, @NotNull String key, @NotNull final String mmkvPrefix, int defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, oldSpName, key, mmkvPrefix, Integer.valueOf(defValue))).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        return ((Number) doGetValue(oldSpName, key, mmkvPrefix, Integer.valueOf(defValue), CommonMmkvAdaptUtils$getInt$1.INSTANCE, CommonMmkvAdaptUtils$getInt$2.INSTANCE, new Function2<String, Integer, Unit>(mmkvPrefix) { // from class: com.tencent.util.CommonMmkvAdaptUtils$getInt$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $mmkvPrefix;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$mmkvPrefix = mmkvPrefix;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mmkvPrefix);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String k3, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) k3, i3);
                } else {
                    Intrinsics.checkNotNullParameter(k3, "k");
                    CommonMmkvAdaptUtils.INSTANCE.putInt(k3, this.$mmkvPrefix, i3);
                }
            }
        })).intValue();
    }

    public final long getLong(@Nullable String oldSpName, @NotNull String key, @NotNull final String mmkvPrefix, long defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, oldSpName, key, mmkvPrefix, Long.valueOf(defValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        return ((Number) doGetValue(oldSpName, key, mmkvPrefix, Long.valueOf(defValue), CommonMmkvAdaptUtils$getLong$1.INSTANCE, CommonMmkvAdaptUtils$getLong$2.INSTANCE, new Function2<String, Long, Unit>(mmkvPrefix) { // from class: com.tencent.util.CommonMmkvAdaptUtils$getLong$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $mmkvPrefix;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$mmkvPrefix = mmkvPrefix;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mmkvPrefix);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Long l3) {
                invoke(str, l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String k3, long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, k3, Long.valueOf(j3));
                } else {
                    Intrinsics.checkNotNullParameter(k3, "k");
                    CommonMmkvAdaptUtils.INSTANCE.putLong(k3, this.$mmkvPrefix, j3);
                }
            }
        })).longValue();
    }

    @NotNull
    public final String getString(@Nullable String oldSpName, @NotNull String key, @NotNull final String mmkvPrefix, @NotNull String defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, oldSpName, key, mmkvPrefix, defValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return (String) doGetValue(oldSpName, key, mmkvPrefix, defValue, CommonMmkvAdaptUtils$getString$1.INSTANCE, CommonMmkvAdaptUtils$getString$2.INSTANCE, new Function2<String, String, Unit>(mmkvPrefix) { // from class: com.tencent.util.CommonMmkvAdaptUtils$getString$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $mmkvPrefix;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$mmkvPrefix = mmkvPrefix;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mmkvPrefix);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String k3, @NotNull String value) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) k3, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(k3, "k");
                Intrinsics.checkNotNullParameter(value, "value");
                CommonMmkvAdaptUtils.INSTANCE.putString(k3, value, this.$mmkvPrefix);
            }
        });
    }

    public final void putBoolean(@NotNull String key, @NotNull String mmkvPrefix, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, key, mmkvPrefix, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        getEntity().encodeBool(wrapMmkvKey(key, mmkvPrefix), value);
    }

    public final void putInt(@NotNull String key, @NotNull String mmkvPrefix, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, key, mmkvPrefix, Integer.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        getEntity().encodeInt(wrapMmkvKey(key, mmkvPrefix), value);
    }

    public final void putLong(@NotNull String key, @NotNull String mmkvPrefix, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, key, mmkvPrefix, Long.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        getEntity().encodeLong(wrapMmkvKey(key, mmkvPrefix), value);
    }

    public final void putString(@NotNull String key, @NotNull String mmkvPrefix, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, key, mmkvPrefix, value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mmkvPrefix, "mmkvPrefix");
        Intrinsics.checkNotNullParameter(value, "value");
        getEntity().encodeString(wrapMmkvKey(key, mmkvPrefix), value);
    }

    private final String wrapMmkvKey(String key, String mmkvPrefix) {
        return wrapMmkvKey(MobileQQ.sMobileQQ.peekAppRuntime(), key, mmkvPrefix);
    }
}
