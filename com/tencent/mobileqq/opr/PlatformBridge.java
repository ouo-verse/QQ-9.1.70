package com.tencent.mobileqq.opr;

import android.content.Context;
import androidx.annotation.Keep;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.opr.model.RequestParam;
import com.tencent.mobileqq.opr.model.ThermalPauseTimeConfig;
import com.tencent.mobileqq.opr.utils.Temperature;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.util.Md5UtilKt;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xc2.b;
import xc2.c;
import xc2.d;

@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082 J\u001b\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0082 J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0007J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/opr/PlatformBridge;", "", "()V", "TAG", "", "rootPath", "temperature", "Lcom/tencent/mobileqq/opr/utils/Temperature;", "thermalConfig", "", "Lcom/tencent/mobileqq/opr/model/ThermalPauseTimeConfig;", "getThermalConfig", "()Ljava/util/List;", "setThermalConfig", "(Ljava/util/List;)V", "callbackWithByteArray", "", "callbackHandle", "", "result", "", "callbackWithString", "downloadUrl", "url", "getRootPath", "getThermalPauseTime", "", "init", "context", "Landroid/content/Context;", "md5", "input", "md5File", "filePath", "requestCmd", "param", "Lcom/tencent/mobileqq/opr/model/RequestParam;", "requestFacesEnhance", "lloc", "uin", "unzip", "", "zipFilePath", "folderPath", "uploadFile", "file", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class PlatformBridge {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final PlatformBridge INSTANCE;

    @NotNull
    private static final String TAG = "[opr]QQSRPlatformBridge";

    @NotNull
    private static String rootPath;

    @NativeFieldProxy(getter = false, setter = false)
    @NotNull
    private static final Temperature temperature;

    @NativeFieldProxy(getter = false, setter = false)
    @Nullable
    private static List<ThermalPauseTimeConfig> thermalConfig;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/opr/PlatformBridge$a", "Lxc2/a;", "", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "", "a", "errorMsg", "b", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes16.dex */
    public static final class a implements xc2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f256997a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f256998b;

        a(String str, long j3) {
            this.f256997a = str;
            this.f256998b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            }
        }

        @Override // xc2.a
        public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, filePath, Integer.valueOf(statusCode), rspHeader);
                return;
            }
            OprLogger.d(PlatformBridge.TAG, "downloadUrl success, statusCode:" + statusCode + ", url:" + this.f256997a + ", filePath:" + ((Object) filePath));
            PlatformBridge.INSTANCE.callbackWithString(this.f256998b, filePath);
        }

        @Override // xc2.a
        public void b(@NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            OprLogger.e(PlatformBridge.TAG, "downloadUrl failed, url:" + this.f256997a + ", errorMsg:" + errorMsg);
            PlatformBridge.INSTANCE.callbackWithString(this.f256998b, null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new PlatformBridge();
        rootPath = "";
        temperature = new Temperature();
    }

    PlatformBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void callbackWithByteArray(long callbackHandle, byte[] result);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void callbackWithString(long callbackHandle, String result);

    @JvmStatic
    public static final void downloadUrl(@NotNull String url, long callbackHandle) {
        Intrinsics.checkNotNullParameter(url, "url");
        b bVar = (b) com.tencent.mobileqq.opr.proxy.core.a.f257058a.a(b.class);
        if (bVar == null) {
            OprLogger.e(TAG, "get download proxy failed");
            INSTANCE.callbackWithString(callbackHandle, null);
        } else {
            bVar.a(url, new a(url, callbackHandle));
        }
    }

    @JvmStatic
    @NotNull
    public static final String getRootPath() {
        return rootPath;
    }

    @JvmStatic
    public static final double getThermalPauseTime() {
        Integer d16;
        Object obj;
        boolean z16;
        List<ThermalPauseTimeConfig> list = thermalConfig;
        if (list == null || (d16 = temperature.d()) == null) {
            return 0.0d;
        }
        int intValue = d16.intValue();
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                ThermalPauseTimeConfig thermalPauseTimeConfig = (ThermalPauseTimeConfig) obj;
                boolean z17 = false;
                if (thermalPauseTimeConfig.valid()) {
                    int start = thermalPauseTimeConfig.getStart();
                    if (intValue <= thermalPauseTimeConfig.getEnd() && start <= intValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ThermalPauseTimeConfig thermalPauseTimeConfig2 = (ThermalPauseTimeConfig) obj;
        OprLogger.i(TAG, "[thermal] temperature:" + intValue + " in " + thermalPauseTimeConfig2);
        if (thermalPauseTimeConfig2 == null) {
            return 0.0d;
        }
        return thermalPauseTimeConfig2.getPause();
    }

    @JvmStatic
    @NotNull
    public static final String md5(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return Md5UtilKt.b(input);
    }

    @JvmStatic
    @NotNull
    public static final String md5File(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String a16 = Md5UtilKt.a(filePath);
        if (a16 == null) {
            return "";
        }
        return a16;
    }

    @JvmStatic
    public static final void requestCmd(@NotNull RequestParam param, long callbackHandle) {
        Intrinsics.checkNotNullParameter(param, "param");
        c cVar = (c) com.tencent.mobileqq.opr.proxy.core.a.f257058a.a(c.class);
        if (cVar != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PlatformBridge$requestCmd$1(cVar, param, callbackHandle, null), 3, null);
        } else {
            OprLogger.e(TAG, Intrinsics.stringPlus("requestCmd fail, get request proxy failed. param:", param));
            INSTANCE.callbackWithString(callbackHandle, "");
        }
    }

    @JvmStatic
    public static final void requestFacesEnhance(@NotNull String lloc, @NotNull String uin, final long callbackHandle) {
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(uin, "uin");
        c cVar = (c) com.tencent.mobileqq.opr.proxy.core.a.f257058a.a(c.class);
        if (cVar == null) {
            OprLogger.e(TAG, "requestFacesEnhance get request proxy failed");
        } else {
            cVar.a(lloc, uin, new Function1<String, Unit>(callbackHandle) { // from class: com.tencent.mobileqq.opr.PlatformBridge$requestFacesEnhance$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $callbackHandle;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$callbackHandle = callbackHandle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, callbackHandle);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String result) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                    } else {
                        Intrinsics.checkNotNullParameter(result, "result");
                        PlatformBridge.INSTANCE.callbackWithString(this.$callbackHandle, result);
                    }
                }
            });
        }
    }

    @JvmStatic
    public static final boolean unzip(@NotNull String zipFilePath, @NotNull String folderPath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        return com.tencent.qne.util.a.h(zipFilePath, folderPath);
    }

    @JvmStatic
    public static final void uploadFile(@NotNull String file, final long callbackHandle) {
        Intrinsics.checkNotNullParameter(file, "file");
        d dVar = (d) com.tencent.mobileqq.opr.proxy.core.a.f257058a.a(d.class);
        if (dVar == null) {
            OprLogger.e(TAG, "get upload proxy failed");
            INSTANCE.callbackWithString(callbackHandle, null);
        } else {
            dVar.a(file, new Function3<Integer, String, String, Unit>(callbackHandle) { // from class: com.tencent.mobileqq.opr.PlatformBridge$uploadFile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $callbackHandle;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$callbackHandle = callbackHandle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, callbackHandle);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                    invoke(num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @Nullable String str, @Nullable String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                        return;
                    }
                    OprLogger.d("[opr]QQSRPlatformBridge", "upload finish, errorCode:" + i3 + ", errorMessage:" + ((Object) str) + ", remoteUrl:" + ((Object) str2));
                    PlatformBridge.INSTANCE.callbackWithString(this.$callbackHandle, str2);
                }
            });
        }
    }

    @Nullable
    public final List<ThermalPauseTimeConfig> getThermalConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return thermalConfig;
    }

    @NativeMethodProxy(enabled = false)
    public final void init(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "context.filesDir.absolutePath");
        rootPath = absolutePath;
    }

    public final void setThermalConfig(@Nullable List<ThermalPauseTimeConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            thermalConfig = list;
        }
    }
}
