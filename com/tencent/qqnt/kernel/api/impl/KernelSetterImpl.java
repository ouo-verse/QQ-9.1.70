package com.tencent.qqnt.kernel.api.impl;

import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqnt.beacon.NTBeaconReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.IKernelSetter;
import com.tencent.qqnt.kernel.api.IServletAPI;
import com.tencent.qqnt.kernel.api.impl.KernelSetterImpl;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.msf.c;
import com.tencent.qqnt.kernel.nativeinterface.AppSetting;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;
import com.tencent.qqnt.kernel.nativeinterface.CopyImgWithDelGPSResult;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;
import com.tencent.qqnt.kernel.nativeinterface.DeviceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine;
import com.tencent.qqnt.kernel.nativeinterface.InitGlobalPathConfig;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import com.tencent.qqnt.kernel.nativeinterface.OpentelemetryTracePlan;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaImgSize;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.qqnt.kernel.nativeinterface.WrapperEngineGlobalConfig;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0007J\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/KernelSetterImpl;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/kernel/api/IKernelSetter;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "getService", "Lcom/tencent/qqnt/kernel/api/u;", "listener", "", "createSession", "initInject", "ensureInject", "getAccountCallback", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "onAfterSyncMsg", "Ljava/lang/Class;", "Lmqq/app/MSFServlet;", "getPushMsgServlet", "setServletKernelInit", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "getNetInfoHandler", "", "p0", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "Lmqq/util/WeakReference;", "mAppRef", "Lmqq/util/WeakReference;", "<init>", "()V", "Companion", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KernelSetterImpl implements IAccountCallback, IKernelSetter, INetInfoHandler {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int LOCALE_ID_ENGLISH = 1033;
    private static final int LOCALE_ID_SIMPLIFIED_CHINESE = 2052;

    @NotNull
    private static final String LOCALE_LANGUAGE_CHINESE_PREFIX = "zh";

    @NotNull
    private static final String SUB_TAG_SDK = "SDK_LOG";
    private static IQQNTWrapperEngine engineHolder;
    private static boolean isLaunching;

    @NotNull
    private static final Lazy<Handler> mHandler$delegate;

    @Nullable
    private static com.tencent.mobileqq.inject.b sAppSetting;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_AppSetting.yml", version = 1)
    @NotNull
    private static ArrayList<Class<com.tencent.mobileqq.inject.b>> sAppSettingList;

    @Nullable
    private static dx3.c sInitialModule;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_InitialModule.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<dx3.c>> sInitialModuleList;

    @NotNull
    private static final AtomicInteger sdkSeq;

    @Nullable
    private static com.tencent.qqnt.kernel.api.u sessionListener;

    @Nullable
    private WeakReference<AppRuntime> mAppRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J!\u0010\u000b\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\"\u00020\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u000e\u001a\u00020\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/KernelSetterImpl$a;", "", "", tl.h.F, "", "g", "i", "", "e", "", "msg", "j", "([Ljava/lang/Object;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceInfo;", "d", "Ldx3/c;", "sInitialModule", "Ldx3/c;", "c", "()Ldx3/c;", "setSInitialModule", "(Ldx3/c;)V", "Lcom/tencent/mobileqq/inject/b;", "sAppSetting", "Lcom/tencent/mobileqq/inject/b;", "b", "()Lcom/tencent/mobileqq/inject/b;", "setSAppSetting", "(Lcom/tencent/mobileqq/inject/b;)V", "LOCALE_ID_ENGLISH", "I", "LOCALE_ID_SIMPLIFIED_CHINESE", "", "LOCALE_LANGUAGE_CHINESE_PREFIX", "Ljava/lang/String;", "SUB_TAG_SDK", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperEngine;", "engineHolder", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperEngine;", "isLaunching", "Z", "Ljava/util/concurrent/atomic/AtomicInteger;", "sdkSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/tencent/qqnt/kernel/api/u;", "sessionListener", "Lcom/tencent/qqnt/kernel/api/u;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.KernelSetterImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u009b\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001c\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u001c\u0010#\u001a\u00020\"2\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u000f\u0010(\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b*\u0010)JT\u00102\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u00182&\u00100\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`/2\u0006\u00101\u001a\u00020\u0018H\u0016J^\u00104\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u00182&\u00100\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`/2\u0006\u00101\u001a\u00020\u0018H\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0018H\u0016J(\u0010;\u001a\u00020\f2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001072\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J8\u0010>\u001a\u00020\f2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001072\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u0001072\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016JB\u0010B\u001a\u00020\f2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`/2\b\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u000eH\u0016JB\u0010D\u001a\u00020\f2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`/2\b\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010C\u001a\u00020<H\u0016J\u0010\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u0004H\u0016J\u001a\u0010K\u001a\u00020J2\u0006\u0010G\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J\b\u0010L\u001a\u00020\fH\u0016Jh\u0010V\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010O2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010S\u001a\u0004\u0018\u00010\u00022&\u0010T\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020O\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020O\u0018\u0001`/2\u0006\u0010U\u001a\u00020\u0004H\u0016J\u0012\u0010Z\u001a\u00020Y2\b\u0010X\u001a\u0004\u0018\u00010WH\u0016\u00a8\u0006["}, d2 = {"com/tencent/qqnt/kernel/api/impl/KernelSetterImpl$a$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IGlobalAdapter;", "", "filePath", "", TagName.FILE_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaImgSize;", "getRichMediaImgSize", "Lcom/tencent/qqnt/kernel/nativeinterface/AppSetting;", "getAppSetting", "level", "msg", "", "onLog", "", "onGetSrvCalTime", "()Ljava/lang/Long;", "errMsg", "onShowErrUITips", "path", "fixPicImgType", "(Ljava/lang/String;)Ljava/lang/Integer;", "srcPath", "dstPath", "", "generatePicAioThumb", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "thumbSize", "generateThumb", "(Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/Boolean;", "Lcom/tencent/qqnt/kernel/nativeinterface/OpentelemetryTracePlan;", "onGetMqqOpentelemetryTraceReportPlan", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceCodecFormatInfo;", "getDeviceCodecFormatInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceInfo;", "getDeviceInfo", "getActiveIPStackType", "()Ljava/lang/Integer;", "getMSFUsedIpProtocolType", "uid", "eventCode", "isSuc", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "isRealTime", "onDataReport", com.heytap.mcssdk.a.a.f36102l, "onDataReportWithAppKey", "isOK", "onInstallFinished", "Ljava/util/ArrayList;", "names", "pubPolicy", "grapPolicy", "onRegisterCountInstruments", "", "boundarys", "onRegisterValueInstruments", "label", "name", "count", "onReportCountIndicators", "value", "onReportValueIndicators", "generalFlag", "onUpdateGeneralFlag", CustomImageProps.QUALITY, "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeInfo;", "transcodeInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeResult;", "avifTranscodeJpgAndGenAIOThumb", "onGetOfflineMsg", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "ssoCmd", "", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "transInfoMap", "cmdType", "onSendSSORequest", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseRsp;", "onParseMarkdown", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.kernel.api.impl.KernelSetterImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes24.dex */
        public static final class C9636a implements IGlobalAdapter {
            static IPatchRedirector $redirector_;

            C9636a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb(int quality, @Nullable AvifTranscodeInfo transcodeInfo) {
                AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                    return (AvifTranscodeResult) iPatchRedirector.redirect((short) 24, (Object) this, quality, (Object) transcodeInfo);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (avifTranscodeJpgAndGenAIOThumb = c16.avifTranscodeJpgAndGenAIOThumb(quality, transcodeInfo)) == null) {
                    return new AvifTranscodeResult();
                }
                return avifTranscodeJpgAndGenAIOThumb;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public /* synthetic */ CopyImgWithDelGPSResult copyImgWithDelGPS(String str, String str2) {
                return com.tencent.qqnt.kernel.nativeinterface.r.b(this, str, str2);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Integer fixPicImgType(@Nullable String path) {
                int i3;
                Integer fixPicImgType;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) path);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null && (fixPicImgType = c16.fixPicImgType(path)) != null) {
                    i3 = fixPicImgType.intValue();
                } else {
                    i3 = -1;
                }
                return Integer.valueOf(i3);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Boolean generatePicAioThumb(@Nullable String srcPath, @Nullable String dstPath) {
                boolean z16;
                Boolean generatePicAioThumb;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return (Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) srcPath, (Object) dstPath);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null && (generatePicAioThumb = c16.generatePicAioThumb(srcPath, dstPath)) != null) {
                    z16 = generatePicAioThumb.booleanValue();
                } else {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Boolean generateThumb(@Nullable String srcPath, @Nullable String dstPath, int thumbSize, int fileType) {
                Boolean generateThumb;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z16 = true;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return (Boolean) iPatchRedirector.redirect((short) 9, this, srcPath, dstPath, Integer.valueOf(thumbSize), Integer.valueOf(fileType));
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null && (generateThumb = c16.generateThumb(srcPath, dstPath, thumbSize, fileType)) != null) {
                    z16 = generateThumb.booleanValue();
                }
                return Boolean.valueOf(z16);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Integer getActiveIPStackType() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return (Integer) iPatchRedirector.redirect((short) 14, (Object) this);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    i3 = c16.b();
                } else {
                    i3 = 3;
                }
                return Integer.valueOf(i3);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public AppSetting getAppSetting() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (AppSetting) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                boolean isColorLevel = QLog.isColorLevel();
                Companion companion = KernelSetterImpl.INSTANCE;
                com.tencent.mobileqq.inject.b b16 = companion.b();
                boolean z18 = false;
                if (b16 != null) {
                    z16 = b16.isDebugVersion();
                } else {
                    z16 = false;
                }
                com.tencent.mobileqq.inject.b b17 = companion.b();
                if (b17 != null) {
                    z17 = b17.isPublicVersion();
                } else {
                    z17 = true;
                }
                com.tencent.mobileqq.inject.b b18 = companion.b();
                if (b18 != null) {
                    z18 = b18.isGrayVersion();
                }
                return new AppSetting(isColorLevel, z16, z17, z18);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public DeviceCodecFormatInfo getDeviceCodecFormatInfo() {
                DeviceCodecFormatInfo deviceCodecFormatInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return (DeviceCodecFormatInfo) iPatchRedirector.redirect((short) 12, (Object) this);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (deviceCodecFormatInfo = c16.getDeviceCodecFormatInfo()) == null) {
                    return new DeviceCodecFormatInfo();
                }
                return deviceCodecFormatInfo;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public DeviceInfo getDeviceInfo() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return (DeviceInfo) iPatchRedirector.redirect((short) 13, (Object) this);
                }
                try {
                    return KernelSetterImpl.INSTANCE.d();
                } catch (Throwable th5) {
                    QLog.d("KernelSetterImpl", 1, "getDeviceInfo error: ", th5);
                    return new DeviceInfo();
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Integer getMSFUsedIpProtocolType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return (Integer) iPatchRedirector.redirect((short) 15, (Object) this);
                }
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                int decodeInt = from.decodeInt("mmkv_key_server_ip_address_type", 0);
                QLog.d(KernelSetterImpl.SUB_TAG_SDK, 1, "serverIpType=" + decodeInt);
                return Integer.valueOf(decodeInt);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public RichMediaImgSize getRichMediaImgSize(@Nullable String filePath, int fileType) {
                RichMediaImgSize richMediaImgSize;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (RichMediaImgSize) iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath, fileType);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (richMediaImgSize = c16.getRichMediaImgSize(filePath, fileType)) == null) {
                    return new RichMediaImgSize(ViewUtils.dip2px(32.0f), ViewUtils.dip2px(32.0f));
                }
                return richMediaImgSize;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath) {
                IOperateResult onCompressVideo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return (IOperateResult) iPatchRedirector.redirect((short) 11, (Object) this, (Object) srcVideoPath, (Object) dstVideoPath);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (onCompressVideo = c16.onCompressVideo(srcVideoPath, dstVideoPath)) == null) {
                    return new IOperateResult(-1, "");
                }
                return onCompressVideo;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onDataReport(@Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    iPatchRedirector.redirect((short) 16, this, uid, eventCode, Boolean.valueOf(isSuc), params, Boolean.valueOf(isRealTime));
                    return;
                }
                NTBeaconReport.j(uid, eventCode, isSuc, params, isRealTime);
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onDataReport(uid, eventCode, isSuc, params, isRealTime);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onDataReportWithAppKey(@Nullable String appKey, @Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    iPatchRedirector.redirect((short) 17, this, appKey, uid, eventCode, Boolean.valueOf(isSuc), params, Boolean.valueOf(isRealTime));
                    return;
                }
                NTBeaconReport.l(appKey, uid, eventCode, isSuc, params, isRealTime);
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onDataReportWithAppKey(appKey, uid, eventCode, isSuc, params, isRealTime);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan() {
                OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return (OpentelemetryTracePlan) iPatchRedirector.redirect((short) 10, (Object) this);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (onGetMqqOpentelemetryTraceReportPlan = c16.onGetMqqOpentelemetryTraceReportPlan()) == null) {
                    return new OpentelemetryTracePlan();
                }
                return onGetMqqOpentelemetryTraceReportPlan;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onGetOfflineMsg() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                    iPatchRedirector.redirect((short) 25, (Object) this);
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onGetOfflineMsg();
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public Long onGetSrvCalTime() {
                long serverTimeMillis;
                Long onGetSrvCalTime;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Long) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null && (onGetSrvCalTime = c16.onGetSrvCalTime()) != null) {
                    serverTimeMillis = onGetSrvCalTime.longValue();
                } else {
                    serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                }
                return Long.valueOf(serverTimeMillis);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onInstallFinished(boolean isOK) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    iPatchRedirector.redirect((short) 18, (Object) this, isOK);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onLog(int level, @NotNull String msg2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, level, (Object) msg2);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (level != 0) {
                    if (level != 1) {
                        if (level != 2) {
                            if (level != 3) {
                                if (level != 4) {
                                    KLog.f359087a.h(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                                } else {
                                    KLog.f359087a.f(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                                }
                            } else {
                                KLog.f359087a.k(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                            }
                        } else {
                            KLog.f359087a.h(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                        }
                    } else if (QLog.isColorLevel()) {
                        KLog.f359087a.d(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                    }
                } else if (QLog.isColorLevel()) {
                    KLog.f359087a.d(KernelSetterImpl.SUB_TAG_SDK, new Object[]{msg2}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onLog(level, msg2);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            @NotNull
            public MarkdownParseRsp onParseMarkdown(@Nullable MarkdownParseReq req) {
                MarkdownParseRsp onParseMarkdown;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                    return (MarkdownParseRsp) iPatchRedirector.redirect((short) 27, (Object) this, (Object) req);
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 == null || (onParseMarkdown = c16.onParseMarkdown(req)) == null) {
                    return new MarkdownParseRsp();
                }
                return onParseMarkdown;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onRegisterCountInstruments(@Nullable ArrayList<String> names, int pubPolicy, int grapPolicy) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                    iPatchRedirector.redirect((short) 19, this, names, Integer.valueOf(pubPolicy), Integer.valueOf(grapPolicy));
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onRegisterCountInstruments(names, pubPolicy, grapPolicy);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onRegisterValueInstruments(@Nullable ArrayList<String> names, @Nullable ArrayList<Double> boundarys, int pubPolicy, int grapPolicy) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    iPatchRedirector.redirect((short) 20, this, names, boundarys, Integer.valueOf(pubPolicy), Integer.valueOf(grapPolicy));
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onRegisterValueInstruments(names, boundarys, pubPolicy, grapPolicy);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onReportCountIndicators(@Nullable HashMap<String, String> label, @Nullable String name, long count) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                    iPatchRedirector.redirect((short) 21, this, label, name, Long.valueOf(count));
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onReportCountIndicators(label, name, count);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onReportValueIndicators(@Nullable HashMap<String, String> label, @Nullable String name, double value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                    iPatchRedirector.redirect((short) 22, this, label, name, Double.valueOf(value));
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onReportValueIndicators(label, name, value);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onSendSSORequest(long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap, int cmdType) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                    iPatchRedirector.redirect((short) 26, this, Long.valueOf(requestId), ssoCmd, pbBuffer, param, traceInfo, transInfoMap, Integer.valueOf(cmdType));
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (transInfoMap != null) {
                    for (Map.Entry<String, byte[]> entry : transInfoMap.entrySet()) {
                        hashMap.put(entry.getKey(), new String(entry.getValue(), Charsets.UTF_8));
                    }
                }
                c.Companion companion = com.tencent.qqnt.kernel.msf.c.INSTANCE;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                IQQNTWrapperEngine k3 = com.tencent.qqnt.kernel.nativeinterface.ci.k();
                Intrinsics.checkNotNullExpressionValue(k3, "get()");
                companion.a(peekAppRuntime, k3, requestId, ssoCmd, pbBuffer, param, traceInfo, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onShowErrUITips(@NotNull String errMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) errMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                KLog.f359087a.f(KernelSetterImpl.SUB_TAG_SDK, new Object[]{errMsg}, Integer.valueOf(KernelSetterImpl.sdkSeq.incrementAndGet()));
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onShowErrUITips(errMsg);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGlobalAdapter
            public void onUpdateGeneralFlag(int generalFlag) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                    iPatchRedirector.redirect((short) 23, (Object) this, generalFlag);
                    return;
                }
                dx3.c c16 = KernelSetterImpl.INSTANCE.c();
                if (c16 != null) {
                    c16.onUpdateGeneralFlag(generalFlag);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return;
            }
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(boolean z16, int i3) {
            int i16;
            QLog.w(KernelSetterImpl.SUB_TAG_SDK, 1, "setLogLevel, isColor :" + z16 + ", QLog.isColorLevel(): " + QLog.isColorLevel() + ", setColorLevelChangeListener: " + i3);
            if (QLog.isColorLevel()) {
                i16 = 0;
            } else {
                i16 = 2;
            }
            QLog.w(KernelSetterImpl.SUB_TAG_SDK, 1, "kernel setLogLevel:" + i16);
            com.tencent.qqnt.kernel.nativeinterface.ci.k().setLogLevel(i16);
        }

        private final boolean g() {
            Object systemService = BaseApplication.context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (SystemMethodProxy.getStreamVolume(audioManager, 3) != 0 && audioManager.getRingerMode() != 0) {
                return false;
            }
            return true;
        }

        private final int h() {
            boolean startsWith$default;
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(language, "zh", false, 2, null);
            if (startsWith$default) {
                return 2052;
            }
            return 1033;
        }

        private final int i() {
            return BaseApplication.getContext().getThirdPushType();
        }

        @Nullable
        public final com.tencent.mobileqq.inject.b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return KernelSetterImpl.sAppSetting;
            }
            return (com.tencent.mobileqq.inject.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Nullable
        public final dx3.c c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return KernelSetterImpl.sInitialModule;
            }
            return (dx3.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final DeviceInfo d() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (DeviceInfo) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            DeviceInfo deviceInfo = new DeviceInfo();
            Companion companion = KernelSetterImpl.INSTANCE;
            dx3.c c16 = companion.c();
            String str3 = "";
            if (c16 == null || (str = c16.getGuid()) == null) {
                str = "";
            }
            deviceInfo.guid = str;
            dx3.c c17 = companion.c();
            if (c17 == null || (str2 = c17.a()) == null) {
                str2 = "";
            }
            deviceInfo.buildVer = str2;
            deviceInfo.localId = companion.h();
            String str4 = Build.DEVICE;
            if (str4 == null) {
                str4 = "";
            }
            deviceInfo.devType = str4;
            String model = DeviceInfoMonitor.getModel();
            if (model == null) {
                model = "";
            }
            deviceInfo.devName = model;
            String romName = ROMUtil.getRomName();
            if (romName == null) {
                romName = "";
            }
            deviceInfo.vendorName = romName;
            String str5 = Build.VERSION.RELEASE;
            if (str5 == null) {
                str5 = "";
            }
            deviceInfo.osVer = str5;
            String romVersion = ROMUtil.getRomVersion();
            if (romVersion != null) {
                str3 = romVersion;
            }
            deviceInfo.vendorOsName = str3;
            deviceInfo.setMute = companion.g();
            deviceInfo.vendorType = companion.i();
            QLog.i(KernelSetterImpl.SUB_TAG_SDK, 1, "KernelSetterImpl, guid=" + deviceInfo.guid + ", buildVer=" + deviceInfo.buildVer + ", devType=" + deviceInfo.devType + ", devName=" + deviceInfo.devName + ", vendorName=" + deviceInfo.vendorName + ", osVer=" + deviceInfo.osVer + ", vendorOsName=" + deviceInfo.vendorOsName);
            return deviceInfo;
        }

        public final void e() {
            int i3;
            WrapperEngineGlobalConfig wrapperEngineGlobalConfig;
            int lastIndexOf$default;
            int lastIndexOf$default2;
            int lastIndexOf$default3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            QLog.w(KernelSetterImpl.SUB_TAG_SDK, 1, "IQQNTWrapperEngine.get().setLogLevel:" + i3 + ", useXlog=" + QLog.isUseXlog());
            com.tencent.qqnt.kernel.nativeinterface.ci.k().setLogLevel(i3);
            QLog.setColorLevelChangeListener(new QLog.ColorLevelChangeListener() { // from class: com.tencent.qqnt.kernel.api.impl.ir
                @Override // com.tencent.qphone.base.util.QLog.ColorLevelChangeListener
                public final void colorLevelChange(boolean z16, int i16) {
                    KernelSetterImpl.Companion.f(z16, i16);
                }
            });
            dx3.c c16 = c();
            if (c16 == null || (wrapperEngineGlobalConfig = c16.d()) == null) {
                wrapperEngineGlobalConfig = new WrapperEngineGlobalConfig();
                wrapperEngineGlobalConfig.useXlog = QLog.isUseXlog();
                String it = MobileQQ.sMobileQQ.getFilesDir().getPath();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it, "/", 0, false, 6, (Object) null);
                String substring = it.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String it5 = MobileQQ.sMobileQQ.getFilesDir().getPath();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it5, "/", 0, false, 6, (Object) null);
                String substring2 = it5.substring(0, lastIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String it6 = MobileQQ.sMobileQQ.getFilesDir().getPath();
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                lastIndexOf$default3 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it6, "/", 0, false, 6, (Object) null);
                String substring3 = it6.substring(0, lastIndexOf$default3);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                wrapperEngineGlobalConfig.globalPathConfig = new InitGlobalPathConfig("", substring + "/databases/", substring2 + "/Tencent/QQfile_recv/", substring3 + "/.runtimetmp/", "");
            }
            com.tencent.qqnt.kernel.nativeinterface.ci.k().initWithMobileConfig(wrapperEngineGlobalConfig, new C9636a());
        }

        public final void j(@NotNull Object... msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                Toast.makeText(mobileQQ, com.tencent.qqnt.kernel.internel.a.f359089a.b(Arrays.copyOf(msg2, msg2.length)), 1).show();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Handler> lazy;
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        sdkSeq = new AtomicInteger(0);
        lazy = LazyKt__LazyJVMKt.lazy(KernelSetterImpl$Companion$mHandler$2.INSTANCE);
        mHandler$delegate = lazy;
        ArrayList<Class<dx3.c>> arrayList = new ArrayList<>();
        sInitialModuleList = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.o.class);
        ArrayList<Class<com.tencent.mobileqq.inject.b>> arrayList2 = new ArrayList<>();
        sAppSettingList = arrayList2;
        arrayList2.add(com.tencent.mobileqq.injector.d.class);
        sAppSettingList.add(com.tencent.mobileqq.injector.d.class);
        isLaunching = true;
        try {
            if (arrayList.size() > 0) {
                sInitialModule = arrayList.get(0).newInstance();
            }
            if (sAppSettingList.size() > 0) {
                sAppSetting = sAppSettingList.get(0).newInstance();
            }
            dx3.c cVar = sInitialModule;
            if (cVar != null && cVar.c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                KLog.i(KLog.f359087a, SUB_TAG_SDK, new Object[]{"use InitialModule load so."}, null, 4, null);
                dx3.c cVar2 = sInitialModule;
                Intrinsics.checkNotNull(cVar2);
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                cVar2.loadNativeLibrary(sMobileQQ, "basic_share", 0, false);
                dx3.c cVar3 = sInitialModule;
                Intrinsics.checkNotNull(cVar3);
                MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
                cVar3.loadNativeLibrary(sMobileQQ2, "djinni_support_lib", 0, false);
                dx3.c cVar4 = sInitialModule;
                Intrinsics.checkNotNull(cVar4);
                MobileQQ sMobileQQ3 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ3, "sMobileQQ");
                cVar4.loadNativeLibrary(sMobileQQ3, "module_service", 0, false);
                dx3.c cVar5 = sInitialModule;
                Intrinsics.checkNotNull(cVar5);
                MobileQQ sMobileQQ4 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ4, "sMobileQQ");
                cVar5.loadNativeLibrary(sMobileQQ4, "djinni_interface_core_public", 0, false);
                dx3.c cVar6 = sInitialModule;
                Intrinsics.checkNotNull(cVar6);
                MobileQQ sMobileQQ5 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ5, "sMobileQQ");
                cVar6.loadNativeLibrary(sMobileQQ5, StartupSessionConstant.KGPROMODULENAME, 0, false);
                dx3.c cVar7 = sInitialModule;
                Intrinsics.checkNotNull(cVar7);
                MobileQQ sMobileQQ6 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ6, "sMobileQQ");
                cVar7.loadNativeLibrary(sMobileQQ6, "kernel", 0, false);
                dx3.c cVar8 = sInitialModule;
                Intrinsics.checkNotNull(cVar8);
                MobileQQ sMobileQQ7 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ7, "sMobileQQ");
                cVar8.loadNativeLibrary(sMobileQQ7, "startup", 0, false);
                com.tencent.qqnt.kernel.api.a.f357229a = true;
            } else {
                KLog.i(KLog.f359087a, SUB_TAG_SDK, new Object[]{"use default SoLoadUtil load so."}, null, 4, null);
                System.loadLibrary("basic_share");
                System.loadLibrary("djinni_support_lib");
                System.loadLibrary("module_service");
                System.loadLibrary("djinni_interface_core_public");
                System.loadLibrary(StartupSessionConstant.KGPROMODULENAME);
                System.loadLibrary("kernel");
                System.loadLibrary("startup");
            }
            companion.e();
            IQQNTWrapperEngine k3 = com.tencent.qqnt.kernel.nativeinterface.ci.k();
            Intrinsics.checkNotNullExpressionValue(k3, "get()");
            engineHolder = k3;
        } catch (UnsatisfiedLinkError e16) {
            KLog.g(KLog.f359087a, SUB_TAG_SDK, new Object[]{e16}, null, 4, null);
            QLog.flushLog(true);
            System.exit(-1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public KernelSetterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void createSession(com.tencent.qqnt.kernel.api.u listener) {
        AppRuntime appRuntime;
        isLaunching = true;
        WeakReference<AppRuntime> weakReference = this.mAppRef;
        if (weakReference != null) {
            appRuntime = weakReference.get();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null) {
            ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).start(listener);
        }
    }

    private final IKernelService getService() {
        AppRuntime appRuntime;
        WeakReference<AppRuntime> weakReference = this.mAppRef;
        if (weakReference != null && (appRuntime = weakReference.get()) != null) {
            return (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "");
        }
        return null;
    }

    public final void ensureInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (sAppSetting == null || sInitialModule == null) {
            initInject();
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    @NotNull
    public IAccountCallback getAccountCallback(@NotNull com.tencent.qqnt.kernel.api.u listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IAccountCallback) iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        sessionListener = listener;
        return this;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    @NotNull
    public INetInfoHandler getNetInfoHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (INetInfoHandler) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    @NotNull
    public Class<? extends MSFServlet> getPushMsgServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return ((IServletAPI) QRoute.api(IServletAPI.class)).getPushMsgServlet();
    }

    @QAutoInitMethod
    public final void initInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newRuntime);
            return;
        }
        ensureInject();
        com.tencent.qqnt.kernel.api.u uVar = sessionListener;
        Intrinsics.checkNotNull(uVar);
        onAccountChanged(newRuntime, uVar);
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    public void onAfterSyncMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            isLaunching = false;
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) reason);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KNOTREACHABLE);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(@Nullable String p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) p06);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KREACHABLEVIAWIFI);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(@Nullable String p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) p06);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KREACHABLEVIA4G);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(@Nullable String p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) p06);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KREACHABLEVIAWIFI);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(@Nullable String p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) p06);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KREACHABLEVIA4G);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        IKernelService service = getService();
        if (service != null) {
            service.setOnNetworkChanged(NetStatusType.KNOTREACHABLE);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    public void setServletKernelInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ((IServletAPI) QRoute.api(IServletAPI.class)).setServletKernelInit();
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelSetter
    public void onAccountChanged(@Nullable AppRuntime newRuntime, @NotNull com.tencent.qqnt.kernel.api.u listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newRuntime, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (newRuntime == null || !Intrinsics.areEqual(newRuntime.getApplicationContext().getPackageName(), newRuntime.getApplication().getQQProcessName())) {
            return;
        }
        this.mAppRef = new WeakReference<>(newRuntime);
        dx3.c cVar = sInitialModule;
        if (cVar != null) {
            cVar.onAccountChanged(newRuntime);
        }
        createSession(listener);
    }
}
