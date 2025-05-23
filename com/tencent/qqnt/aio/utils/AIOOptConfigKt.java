package com.tencent.qqnt.aio.utils;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0003\u001a'\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\"\u001b\u0010\u000e\u001a\u00020\t8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u0013\u001a\u00020\u000f8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0017\u001a\u00020\u00028GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u001a\u001a\u00020\u00028GX\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0016\"\u001a\u0010\u001d\u001a\u00020\u00028GX\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0016\"\u001b\u0010\u001f\u001a\u00020\u00028GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u001e\u0010\u0016\"\u001b\u0010!\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b \u0010\u0016\"\u001b\u0010#\u001a\u00020\u00028GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\"\u0010\u0016\"\u001a\u0010%\u001a\u00020\u00028GX\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b$\u0010\u0016\"\u001b\u0010&\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006'"}, d2 = {"", "groupId", "", "d", "T", "Lkotlin/Function0;", "block", "o", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "a", "Lkotlin/Lazy;", "f", "()I", "deviceLevel", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAIODeviceLevelApi;", "b", "g", "()Lcom/tencent/qqnt/aio/assistedchat/adapter/IAIODeviceLevelApi;", "deviceLevelApi", "c", "j", "()Z", "USE_AIOCORE_NEW_POSTER", "Z", "i", "USE_AIOCORE_NEW_MESSENGER", "e", tl.h.F, "USE_AIOCORE_NEW_LIVEDATA", "k", "USE_AIOCORE_RECYCLE_HELPER", DomainData.DOMAIN_NAME, "USE_TRACE_METHOD", "l", "USE_CONCURRENT_INITIALIZATION", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "USE_ITERATIVE_BUILD_VM", "AIO_FILE_VIEW_DEGRADE_TOGGLE", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOOptConfigKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f352246a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f352247b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f352248c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f352249d;

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f352250e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy f352251f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy f352252g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy f352253h;

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f352254i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy f352255j;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47919);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOOptConfigKt$deviceLevel$2.INSTANCE);
        f352246a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOOptConfigKt$deviceLevelApi$2.INSTANCE);
        f352247b = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOOptConfigKt$USE_AIOCORE_NEW_POSTER$2.INSTANCE);
        f352248c = lazy3;
        f352249d = true;
        f352250e = true;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOOptConfigKt$USE_AIOCORE_RECYCLE_HELPER$2.INSTANCE);
        f352251f = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIOOptConfigKt$USE_TRACE_METHOD$2.INSTANCE);
        f352252g = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOOptConfigKt$USE_CONCURRENT_INITIALIZATION$2.INSTANCE);
        f352253h = lazy6;
        f352254i = true;
        lazy7 = LazyKt__LazyJVMKt.lazy(AIOOptConfigKt$AIO_FILE_VIEW_DEGRADE_TOGGLE$2.INSTANCE);
        f352255j = lazy7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static final boolean d(String str) {
        String loadConfigAsString;
        try {
            loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString(str, "");
        } catch (Exception e16) {
            QLog.e("AIOOptConfig", 1, "groupId " + str + " checkFreesiaConfig", e16);
        }
        if (TextUtils.isEmpty(loadConfigAsString)) {
            return false;
        }
        QLog.d("AIOOptConfig", 1, "groupId " + str + " posterConfig = " + loadConfigAsString);
        JSONObject jSONObject = new JSONObject(loadConfigAsString);
        if (jSONObject.optBoolean("isOpenAll", false)) {
            return true;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("deviceLevels");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int optInt = optJSONArray.optInt(i3, -1000);
                if (optInt == 1 && f() == g().getLevelHigh()) {
                    return true;
                }
                if (optInt == 2 && f() == g().getLevelMedium()) {
                    return true;
                }
                if (optInt == 3 && f() == g().getLevelLow()) {
                    return true;
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("whitelist");
        if (optJSONArray2 == null) {
            return false;
        }
        int length2 = optJSONArray2.length();
        for (int i16 = 0; i16 < length2; i16++) {
            if (TextUtils.equals(DeviceInfoMonitor.getModel(), optJSONArray2.optJSONObject(i16).optString("phoneModel"))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e() {
        return ((Boolean) f352255j.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static final int f() {
        return ((Number) f352246a.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static final IAIODeviceLevelApi g() {
        return (IAIODeviceLevelApi) f352247b.getValue();
    }

    @MainThread
    public static final boolean h() {
        return f352250e;
    }

    @MainThread
    public static final boolean i() {
        return f352249d;
    }

    @MainThread
    public static final boolean j() {
        return ((Boolean) f352248c.getValue()).booleanValue();
    }

    @MainThread
    public static final boolean k() {
        return ((Boolean) f352251f.getValue()).booleanValue();
    }

    @MainThread
    public static final boolean l() {
        return ((Boolean) f352253h.getValue()).booleanValue();
    }

    @MainThread
    public static final boolean m() {
        return f352254i;
    }

    public static final boolean n() {
        return ((Boolean) f352252g.getValue()).booleanValue();
    }

    @Nullable
    public static final <T> T o(@Nullable Function0<? extends T> function0) {
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }
}
