package com.tencent.mobileqq.leba.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u00ee\u0001\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00028\u000026\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\n2K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u000e26\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\nH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u001b\u001a\u00020\u001a2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u001aJ\u0018\u0010\u001d\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001aJ$\u0010\u001f\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u001eJ\u0018\u0010 \u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001eJ\"\u0010!\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0018\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0002\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/leba/utils/LebaMmkvUtils;", "", "", "key", "", "k", "T", "Lmqq/app/AppRuntime;", "app", "defValue", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readMmkv", "Lkotlin/Function3;", "Landroid/content/SharedPreferences;", "sp", "getSpValue", "writeMmkv", "b", "(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "d", "f", "", "c", "value", h.F, "", "e", "i", "g", "j", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaMmkvUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LebaMmkvUtils f240764a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f240764a = new LebaMmkvUtils();
        }
    }

    LebaMmkvUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [T, java.lang.Object] */
    private final <T> T b(AppRuntime app, String key, T defValue, Function2<? super String, ? super T, ? extends T> readMmkv, Function3<? super SharedPreferences, ? super String, ? super T, ? extends T> getSpValue, Function2<? super String, ? super T, Unit> writeMmkv) {
        boolean z16;
        if (app != null && key != null) {
            MMKVOptionEntity d16 = d();
            String m3 = m(app, key);
            if (d16.containsKey(m3)) {
                T invoke = readMmkv.invoke(m3, defValue);
                QLog.i("LebaMmkvUtils", 4, "doGetValue read mmkv[" + m3 + "]: " + invoke);
                return invoke;
            }
            T invoke2 = getSpValue.invoke(f(app), key, defValue);
            if (invoke2 != 0) {
                QLog.i("LebaMmkvUtils", 4, "doGetValue read sp[" + key + "]: " + invoke2);
                writeMmkv.invoke(key, invoke2);
                return invoke2;
            }
            QLog.e("LebaMmkvUtils", 1, "doGetValue read sp return null. key= " + key);
            return defValue;
        }
        boolean z17 = false;
        if (app == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (key == null) {
            z17 = true;
        }
        QLog.e("LebaMmkvUtils", 1, "doGetValue app null? " + z16 + ", key null? " + z17);
        return defValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntity d() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r3 != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SharedPreferences f(AppRuntime app) {
        boolean z16;
        String account = app.getAccount();
        if (account != null) {
            if (account.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        QLog.e("LebaMmkvUtils", 1, "getSp name is null or empty");
        account = "noLogin";
        SharedPreferences sharedPreferences = app.getApplication().getSharedPreferences(account, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "app.application.getShare\u2026xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }

    @JvmStatic
    public static final void k(@Nullable String key) {
        if (key != null) {
            LebaMmkvUtils lebaMmkvUtils = f240764a;
            lebaMmkvUtils.d().removeKey(lebaMmkvUtils.l(key));
        }
    }

    private final String l(String key) {
        return m(MobileQQ.sMobileQQ.peekAppRuntime(), key);
    }

    private final String m(AppRuntime app, String key) {
        String str;
        boolean z16;
        if (app != null) {
            str = app.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (app == null) {
                z17 = true;
            }
            QLog.e("LebaMmkvUtils", 1, "wrapMmkvKey account = (" + str + "), app null? " + z17);
        }
        return "leba_" + str + "_" + key;
    }

    public final boolean c(@Nullable AppRuntime app, @Nullable String key, boolean defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, app, key, Boolean.valueOf(defValue))).booleanValue();
        }
        return ((Boolean) b(app, key, Boolean.valueOf(defValue), LebaMmkvUtils$getBoolean$1.INSTANCE, LebaMmkvUtils$getBoolean$2.INSTANCE, LebaMmkvUtils$getBoolean$3.INSTANCE)).booleanValue();
    }

    public final int e(@Nullable AppRuntime app, @Nullable String key, int defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, app, key, Integer.valueOf(defValue))).intValue();
        }
        return ((Number) b(app, key, Integer.valueOf(defValue), LebaMmkvUtils$getInt$1.INSTANCE, LebaMmkvUtils$getInt$2.INSTANCE, LebaMmkvUtils$getInt$3.INSTANCE)).intValue();
    }

    @NotNull
    public final String g(@Nullable AppRuntime app, @Nullable String key, @NotNull String defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, app, key, defValue);
        }
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return (String) b(app, key, defValue, LebaMmkvUtils$getString$1.INSTANCE, LebaMmkvUtils$getString$2.INSTANCE, LebaMmkvUtils$getString$3.INSTANCE);
    }

    public final void h(@Nullable String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, key, Boolean.valueOf(value));
        } else if (key != null) {
            LebaMmkvUtils lebaMmkvUtils = f240764a;
            lebaMmkvUtils.d().encodeBool(lebaMmkvUtils.l(key), value);
        }
    }

    public final void i(@Nullable String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, value);
        } else if (key != null) {
            LebaMmkvUtils lebaMmkvUtils = f240764a;
            lebaMmkvUtils.d().encodeInt(lebaMmkvUtils.l(key), value);
        }
    }

    public final void j(@Nullable String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        if (key != null) {
            LebaMmkvUtils lebaMmkvUtils = f240764a;
            lebaMmkvUtils.d().encodeString(lebaMmkvUtils.l(key), value);
        }
    }
}
