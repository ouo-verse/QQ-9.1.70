package com.tencent.mobileqq.springhb.util;

import android.os.Parcelable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J,\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J6\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007JU\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J6\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J6\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/springhb/util/a;", "", "", "key", "prefix", "", "ignoreUin", "Lmqq/app/AppRuntime;", "runtime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "defValue", "c", "", "e", "a", h.F, "Landroid/os/Parcelable;", "T", "Ljava/lang/Class;", "clazz", "g", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;ZLmqq/app/AppRuntime;)Landroid/os/Parcelable;", "value", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "p", "o", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f289630a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f289630a = new a();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, MMKV_FILE_NAME)");
        entity = from;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ boolean b(a aVar, String str, boolean z16, String str2, boolean z17, AppRuntime appRuntime, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        boolean z18 = z17;
        if ((i3 & 16) != 0) {
            appRuntime = null;
        }
        return aVar.a(str, z16, str3, z18, appRuntime);
    }

    public static /* synthetic */ int d(a aVar, String str, int i3, String str2, boolean z16, AppRuntime appRuntime, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            appRuntime = null;
        }
        return aVar.c(str, i3, str3, z17, appRuntime);
    }

    public static /* synthetic */ long f(a aVar, String str, long j3, String str2, boolean z16, AppRuntime appRuntime, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            appRuntime = null;
        }
        return aVar.e(str, j3, str3, z17, appRuntime);
    }

    public static /* synthetic */ void j(a aVar, String str, boolean z16, String str2, boolean z17, AppRuntime appRuntime, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        boolean z18 = z17;
        if ((i3 & 16) != 0) {
            appRuntime = null;
        }
        aVar.i(str, z16, str3, z18, appRuntime);
    }

    public static /* synthetic */ void l(a aVar, String str, int i3, String str2, boolean z16, AppRuntime appRuntime, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            appRuntime = null;
        }
        aVar.k(str, i3, str3, z17, appRuntime);
    }

    public static /* synthetic */ void n(a aVar, String str, long j3, String str2, boolean z16, AppRuntime appRuntime, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            appRuntime = null;
        }
        aVar.m(str, j3, str3, z17, appRuntime);
    }

    private final String q(String key, String prefix, boolean ignoreUin, AppRuntime runtime) {
        boolean z16;
        String str;
        if (prefix.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "";
        if (z16) {
            prefix = "";
        }
        if (!ignoreUin) {
            if (runtime == null || (str = runtime.getCurrentAccountUin()) == null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    str = peekAppRuntime.getCurrentAccountUin();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "0";
                }
            }
            str2 = "_" + str;
        }
        return ((Object) prefix) + key + str2;
    }

    public final boolean a(@NotNull String key, boolean defValue, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, key, Boolean.valueOf(defValue), prefix, Boolean.valueOf(ignoreUin), runtime)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return entity.decodeBool(q(key, prefix, ignoreUin, runtime), defValue);
    }

    public final int c(@NotNull String key, int defValue, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, key, Integer.valueOf(defValue), prefix, Boolean.valueOf(ignoreUin), runtime)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return entity.decodeInt(q(key, prefix, ignoreUin, runtime), defValue);
    }

    public final long e(@NotNull String key, long defValue, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, this, key, Long.valueOf(defValue), prefix, Boolean.valueOf(ignoreUin), runtime)).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return entity.decodeLong(q(key, prefix, ignoreUin, runtime), defValue);
    }

    @NotNull
    public final <T extends Parcelable> T g(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defValue, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, this, key, clazz, defValue, prefix, Boolean.valueOf(ignoreUin), runtime);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        T t16 = (T) entity.decodeParcelable(q(key, prefix, ignoreUin, runtime), clazz, defValue);
        Intrinsics.checkNotNullExpressionValue(t16, "entity.decodeParcelable(\u2026untime), clazz, defValue)");
        return t16;
    }

    @NotNull
    public final String h(@NotNull String key, @NotNull String defValue, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, key, defValue, prefix, Boolean.valueOf(ignoreUin), runtime);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String decodeString = entity.decodeString(q(key, prefix, ignoreUin, runtime), defValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(targ\u2026eUin, runtime), defValue)");
        return decodeString;
    }

    public final void i(@NotNull String key, boolean value, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, key, Boolean.valueOf(value), prefix, Boolean.valueOf(ignoreUin), runtime);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        entity.encodeBool(q(key, prefix, ignoreUin, runtime), value);
    }

    public final void k(@NotNull String key, int value, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, key, Integer.valueOf(value), prefix, Boolean.valueOf(ignoreUin), runtime);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        entity.encodeInt(q(key, prefix, ignoreUin, runtime), value);
    }

    public final void m(@NotNull String key, long value, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, key, Long.valueOf(value), prefix, Boolean.valueOf(ignoreUin), runtime);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        entity.encodeLong(q(key, prefix, ignoreUin, runtime), value);
    }

    public final void o(@NotNull String key, @NotNull Parcelable value, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, key, value, prefix, Boolean.valueOf(ignoreUin), runtime);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        entity.encodeParcelable(q(key, prefix, ignoreUin, runtime), value);
    }

    public final void p(@NotNull String key, @NotNull String value, @NotNull String prefix, boolean ignoreUin, @Nullable AppRuntime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, key, value, prefix, Boolean.valueOf(ignoreUin), runtime);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        entity.encodeString(q(key, prefix, ignoreUin, runtime), value);
    }
}
