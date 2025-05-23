package com.tencent.minibox.business;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.IMiniBoxCallback;
import com.tencent.minibox.business.api.IMiniBoxDataCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.common.thread.ThreadManager;
import com.tencent.minibox.contract.IMiniBoxPluginCallback;
import com.tencent.minibox.contract.IMiniBoxServiceConnection;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.minibox.dynamic.api.IMiniBoxApi;
import com.tencent.minibox.loader.core.PluginVersionManager;
import com.tencent.minibox.proxy.ExecutorProxy;
import com.tencent.minibox.proxy.LogProxy;
import com.tencent.minibox.proxy.MiniBoxProxy;
import com.tencent.minibox.proxy.ProxyRef;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m51.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p51.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\b\u0000\u0018\u0000 K2\u00020\u0001:\u0001AB\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u0017J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u001cJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010 \u001a\u00020\nJ\u0018\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001e\u0010'\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&J\u0010\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u0014\u001a\u00020\u0002J&\u0010.\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020-J\u001e\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u000202J\u000e\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000202J\b\u00106\u001a\u0004\u0018\u00010\"J\u000e\u00108\u001a\u0002072\u0006\u0010%\u001a\u00020\u0002J\u000e\u00109\u001a\u0002072\u0006\u0010%\u001a\u00020\u0002J\u0018\u0010:\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0002J\"\u0010>\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00172\b\u0010<\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010+J\u000e\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0002R\u0016\u0010C\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/minibox/business/MiniBoxEngine;", "", "", "apkPath", "Lcom/tencent/minibox/business/api/IMiniBoxCallback;", "callback", "", HippyTKDListViewAdapter.X, "Lcom/tencent/minibox/dynamic/api/IMiniBoxApi;", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "Lcom/tencent/minibox/proxy/MiniBoxProxy;", "proxy", "u", "v", "E", "w", PushClientConstants.TAG_PKG_NAME, h.F, "y", "", "flag", "", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/minibox/business/api/IMiniBoxDataCallback;", "r", "p", BdhLogUtil.LogTag.Tag_Conn, "checkLaunchSubProcess", "D", "Lcom/tencent/minibox/contract/LaunchAppInfo;", "launchAppInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "packageName", "Lcom/tencent/minibox/business/api/AsyncCallback;", UserInfo.SEX_FEMALE, "Landroid/content/pm/ApplicationInfo;", "o", "versionName", "Landroid/os/Bundle;", "extendBundle", "Lcom/tencent/minibox/contract/IMiniBoxPluginCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Intent;", "intent", "servicePkgName", "Lcom/tencent/minibox/contract/IMiniBoxServiceConnection;", "c", "serviceConnection", "G", DomainData.DOMAIN_NAME, "", "k", "l", "j", "pid", "action", "params", "B", "extendInfo", "d", "a", "Lcom/tencent/minibox/proxy/MiniBoxProxy;", "mProxy", "b", "Landroid/content/Context;", "mContext", "Z", "mHasInit", "<init>", "()V", "e", "MiniBoxBusiness_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class MiniBoxEngine {

    /* renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static MiniBoxEngine f151592d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MiniBoxProxy mProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile Context mContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0011\u001a\u00020\f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/minibox/business/MiniBoxEngine$a;", "", "Landroid/content/Context;", "context", "", "d", "", "isDeleteFile", "", "a", "b", "c", "Lcom/tencent/minibox/business/MiniBoxEngine;", "e", "()Lcom/tencent/minibox/business/MiniBoxEngine;", "instance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "MAPP_ROOT_DIR_NAME", "Ljava/lang/String;", "RECEIVER_ACTION_EXIT", "TAG", "sInstance", "Lcom/tencent/minibox/business/MiniBoxEngine;", "<init>", "MiniBoxBusiness_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.minibox.business.MiniBoxEngine$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final void a(@NotNull Context context, boolean isDeleteFile) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent();
            intent.setAction("com.tencent.minibox.miniboxprocess.exit");
            context.sendBroadcast(intent);
            if (isDeleteFile) {
                a.e(new File(context.getFilesDir(), "minibox/app"));
                a.e(context.getExternalFilesDir("minibox/app"));
            }
            context.getSharedPreferences("minibox_core", 0).edit().clear().apply();
        }

        @JvmStatic
        public final void b(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent();
            intent.setAction("com.tencent.minibox.miniboxprocess.exit");
            context.sendBroadcast(intent);
            n51.a.C.h();
            PluginVersionManager.f151646b.f(context);
        }

        @JvmStatic
        public final void c(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            boolean e16 = c.e(context);
            LogUtils.i("MiniBoxEngine", "clearPluginSafely isRunning:" + e16);
            if (e16) {
                return;
            }
            c.f(context);
            n51.a.C.h();
            PluginVersionManager.f151646b.f(context);
        }

        @JvmStatic
        public final long d(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return a.f(new File(context.getFilesDir(), "minibox/app")) + a.f(context.getExternalFilesDir("minibox/app"));
        }

        @NotNull
        public final MiniBoxEngine e() {
            if (MiniBoxEngine.f151592d == null) {
                synchronized (MiniBoxEngine.class) {
                    if (MiniBoxEngine.f151592d == null) {
                        MiniBoxEngine.f151592d = new MiniBoxEngine(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            MiniBoxEngine miniBoxEngine = MiniBoxEngine.f151592d;
            if (miniBoxEngine == null) {
                Intrinsics.throwNpe();
            }
            return miniBoxEngine;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/minibox/business/MiniBoxEngine$b", "Lcom/tencent/minibox/contract/IMiniBoxPluginCallback$Stub;", "Landroid/os/Bundle;", "bundle", "", "onResult", "MiniBoxBusiness_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes9.dex */
    public static final class b extends IMiniBoxPluginCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMiniBoxCallback f151597d;

        b(IMiniBoxCallback iMiniBoxCallback) {
            this.f151597d = iMiniBoxCallback;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPluginCallback
        public void onResult(@NotNull Bundle bundle) {
            Intrinsics.checkParameterIsNotNull(bundle, "bundle");
            int i3 = bundle.getInt("retCode");
            String string = bundle.getString("retMsg");
            LogUtils.i("MiniBoxEngine", "install result. retCode=" + i3 + ", errMsg=" + string);
            if (i3 == 0) {
                IMiniBoxCallback iMiniBoxCallback = this.f151597d;
                if (iMiniBoxCallback != null) {
                    iMiniBoxCallback.onSuccess();
                    return;
                }
                return;
            }
            IMiniBoxCallback iMiniBoxCallback2 = this.f151597d;
            if (iMiniBoxCallback2 != null) {
                iMiniBoxCallback2.onFail(i3, string);
            }
        }
    }

    MiniBoxEngine() {
    }

    @JvmStatic
    public static final void e(@NotNull Context context, boolean z16) {
        INSTANCE.a(context, z16);
    }

    @JvmStatic
    public static final void f(@NotNull Context context) {
        INSTANCE.b(context);
    }

    @JvmStatic
    public static final void g(@NotNull Context context) {
        INSTANCE.c(context);
    }

    @JvmStatic
    public static final long i(@NotNull Context context) {
        return INSTANCE.d(context);
    }

    @NotNull
    public static final MiniBoxEngine s() {
        return INSTANCE.e();
    }

    private final IMiniBoxApi t() {
        n51.a aVar = n51.a.C;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        MiniBoxProxy miniBoxProxy = this.mProxy;
        if (miniBoxProxy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProxy");
        }
        return aVar.c(context, miniBoxProxy.getUin());
    }

    private final void x(String apkPath, IMiniBoxCallback callback) {
        try {
            if (!new File(apkPath).exists()) {
                LogUtils.e("MiniBoxEngine", "[installAppImpl] \u5b89\u88c5\u5305\u6587\u4ef6\u4e0d\u5b58\u5728");
                if (callback != null) {
                    callback.onFail(-1, "\u5b89\u88c5\u5305\u6587\u4ef6\u4e0d\u5b58\u5728");
                    return;
                }
                return;
            }
            LogUtils.d("MiniBoxEngine", "installAppImpl: begin install path=" + apkPath);
            IMiniBoxApi t16 = t();
            if (t16 == null) {
                if (callback != null) {
                    callback.onFail(-1, "\u8fdb\u7a0b\u542f\u52a8\u5931\u8d25");
                    return;
                }
                return;
            }
            t16.installApp(apkPath, new b(callback));
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "[installAppImpl] exception.", e16);
            if (callback != null) {
                callback.onFail(-1, "\u5b89\u88c5\u5931\u8d25\uff0c\u672a\u77e5\u9519\u8bef");
            }
        }
    }

    private final boolean z() {
        return !this.mHasInit;
    }

    public final void A(@NotNull LaunchAppInfo launchAppInfo, @Nullable IMiniBoxCallback callback) {
        Intrinsics.checkParameterIsNotNull(launchAppInfo, "launchAppInfo");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getInstalledPackages] sdk not init");
            if (callback != null) {
                callback.onFail(-1, "sdk not init.");
                return;
            }
            return;
        }
        try {
            l51.b bVar = l51.b.f413856c;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            bVar.f(context, "startLaunch");
            IMiniBoxApi t16 = t();
            if (t16 == null) {
                if (callback != null) {
                    callback.onFail(-1, "MiniBoxApi is not ready");
                }
            } else if (t16.launchApp(launchAppInfo)) {
                if (callback != null) {
                    callback.onSuccess();
                }
            } else if (callback != null) {
                callback.onFail(-1, "\u542f\u52a8\u5931\u8d25");
            }
        } catch (Exception e16) {
            if (callback != null) {
                callback.onFail(-1, "launchApp Exception:" + e16);
            }
            LogUtils.e("MiniBoxEngine", "launchApp error:", e16);
        }
    }

    public final boolean B(int pid, @Nullable String action, @Nullable Bundle params) {
        try {
            IMiniBoxApi t16 = t();
            if (t16 == null) {
                return false;
            }
            return t16.notifyClient(pid, action, params);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "notifyClient error:", e16);
            return false;
        }
    }

    public final boolean C(@NotNull String pkgName, @Nullable IMiniBoxCallback callback) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getInstalledPackages] sdk not init");
            if (callback != null) {
                callback.onFail(-1, "sdk not init.");
            }
            return false;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            if (callback != null) {
                callback.onFail(-2, "MiniBoxApi is not ready");
            }
            return false;
        }
        try {
            if (t16.preLaunchApp(pkgName)) {
                if (callback != null) {
                    callback.onSuccess();
                    return true;
                }
                return true;
            }
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "preLaunchApp error:", e16);
        }
        if (callback != null) {
            callback.onFail(-3, "preLaunch failed.");
        }
        return false;
    }

    public final void D(@NotNull Context context, boolean checkLaunchSubProcess) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            if (checkLaunchSubProcess) {
                if (c.d(context)) {
                    return;
                }
            } else if (c.e(context)) {
                return;
            }
            n51.a aVar = n51.a.C;
            MiniBoxProxy miniBoxProxy = this.mProxy;
            if (miniBoxProxy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProxy");
            }
            if (!aVar.a(context, miniBoxProxy.getUin())) {
                return;
            }
            String str = null;
            Bundle call = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".p00miniboxstub"), "_minibox_sdk_pre_launch_", (String) null, new Bundle());
            if (call != null) {
                num = Integer.valueOf(call.getInt("retCode", -2));
            } else {
                num = null;
            }
            if (call != null) {
                str = call.getString("retMsg");
            }
            LogUtils.i("MiniBoxEngine", "preLaunchProcess: errCode:" + num + " errMsg:" + str);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "preLaunchProcess: exception, e=" + e16.getMessage());
        }
    }

    public final void E() {
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[preload] sdk not init");
            return;
        }
        n51.a aVar = n51.a.C;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        MiniBoxProxy miniBoxProxy = this.mProxy;
        if (miniBoxProxy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProxy");
        }
        aVar.f(context, miniBoxProxy.getUin());
    }

    public final void F(@NotNull String packageName, @Nullable AsyncCallback<String> callback) {
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        if (z()) {
            if (callback != null) {
                callback.onResult("sdk not init.");
            }
            LogUtils.i("MiniBoxEngine", "stopApp: not init, return.");
            return;
        }
        try {
            if (n51.a.C.e()) {
                IMiniBoxApi t16 = t();
                if (t16 == null) {
                    if (callback != null) {
                        callback.onResult("api get null");
                        return;
                    }
                    return;
                }
                t16.stopApp(packageName, new MiniBoxEngine$stopApp$1(callback));
                return;
            }
            if (callback != null) {
                callback.onResult("api not valid.");
            }
            LogUtils.i("MiniBoxEngine", "stopApp: api is invalid. packageName=" + packageName);
        } catch (Exception e16) {
            if (callback != null) {
                callback.onResult(e16.getMessage());
            }
            LogUtils.e("MiniBoxEngine", "stopApp: failed.", e16);
        }
    }

    public final void G(@NotNull IMiniBoxServiceConnection serviceConnection) {
        Intrinsics.checkParameterIsNotNull(serviceConnection, "serviceConnection");
        LogUtils.d("MiniBoxEngine", "unbindService serviceConnection:" + serviceConnection);
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[unbindService] sdk not init");
            return;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            LogUtils.e("MiniBoxEngine", "[unbindService] api == null");
            return;
        }
        try {
            t16.unbindService(serviceConnection);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "[unbindService] e:", e16);
        }
    }

    public final void c(@NotNull Intent intent, @NotNull String servicePkgName, @NotNull IMiniBoxServiceConnection callback) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(servicePkgName, "servicePkgName");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LogUtils.d("MiniBoxEngine", "bindService intent:" + intent);
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[bindService] sdk not init");
            callback.onConnectFailed(-1);
            return;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            callback.onConnectFailed(-2);
            LogUtils.e("MiniBoxEngine", "[bindService] api == null");
            return;
        }
        try {
            t16.bindService(intent, servicePkgName, callback);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "[bindService] e:", e16);
            callback.onConnectFailed(-4);
        }
    }

    public final void d(@NotNull String extendInfo) {
        Intrinsics.checkParameterIsNotNull(extendInfo, "extendInfo");
        try {
            IMiniBoxApi t16 = t();
            if (t16 != null) {
                t16.checkAvailable(extendInfo);
            }
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "checkAvailable", e16);
        }
    }

    public final boolean h(@NotNull String pkgName) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[deleteApp] sdk not init");
            return false;
        }
        try {
            IMiniBoxApi t16 = t();
            if (t16 == null) {
                return false;
            }
            return t16.deletePackage(pkgName, 0);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "deleteApp error:", e16);
            return false;
        }
    }

    @Nullable
    public final String j(@NotNull Context context, @NotNull String packageName) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        String c16 = h51.b.c(context, packageName);
        LogUtils.i("MiniBoxEngine", "getApkPath packageName:" + packageName + " apkPath:" + c16);
        return c16;
    }

    public final long k(@NotNull String packageName) {
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            return 0L;
        }
        try {
            return t16.getAppDataStorageSpace(packageName);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "getAppDataStorageSpace error:", e16);
            return 0L;
        }
    }

    public final long l(@NotNull String packageName) {
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            return 0L;
        }
        try {
            return t16.getAppExternalStorageSpace(packageName);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "getAppExternalStorageSpace error:", e16);
            return 0L;
        }
    }

    public final void m(@NotNull String pkgName, @NotNull String versionName, @NotNull Bundle extendBundle, @NotNull IMiniBoxPluginCallback callback) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        Intrinsics.checkParameterIsNotNull(versionName, "versionName");
        Intrinsics.checkParameterIsNotNull(extendBundle, "extendBundle");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LogUtils.d("MiniBoxEngine", "getAppExtraInfo pkgName:" + pkgName + " versionName:" + versionName + " extendBundle:" + extendBundle);
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getAppExtraInfo] sdk not init");
            Bundle bundle = new Bundle();
            bundle.putInt("code", -1);
            callback.onResult(bundle);
            return;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("code", -2);
            callback.onResult(bundle2);
            return;
        }
        try {
            t16.getAppExtraInfo(pkgName, versionName, extendBundle, callback);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "[getAppExtraInfo] e:", e16);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("code", -4);
            callback.onResult(bundle3);
        }
    }

    @Nullable
    public final LaunchAppInfo n() {
        IMiniBoxApi t16 = t();
        if (t16 != null) {
            return t16.getAppInfo();
        }
        return null;
    }

    @Nullable
    public final ApplicationInfo o(@NotNull String pkgName) {
        PackageInfo packageInfo;
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        try {
            IMiniBoxApi t16 = t();
            if (t16 == null || (packageInfo = t16.getPackageInfo(pkgName, 0)) == null) {
                return null;
            }
            return packageInfo.applicationInfo;
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "getApplicationInfo error:", e16);
            return null;
        }
    }

    @Nullable
    public final MiniBoxAppInfo p(@NotNull String pkgName) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getInstalledPackages] sdk not init");
            return null;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = t16.getPackageInfo(pkgName, 0);
            if (packageInfo == null) {
                return null;
            }
            MiniBoxAppInfo.Companion companion = MiniBoxAppInfo.INSTANCE;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            return companion.createFromPackageInfo(context, packageInfo);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "getPackageInfo error:", e16);
            return null;
        }
    }

    @NotNull
    public final List<MiniBoxAppInfo> q(int flag) {
        List<MiniBoxAppInfo> emptyList;
        List<MiniBoxAppInfo> emptyList2;
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getInstalledPackages] sdk not init");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        IMiniBoxApi t16 = t();
        if (t16 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        try {
            List<PackageInfo> installedPackages = t16.getInstalledPackages(flag);
            if (installedPackages != null) {
                for (PackageInfo it : installedPackages) {
                    MiniBoxAppInfo.Companion companion = MiniBoxAppInfo.INSTANCE;
                    Context context = this.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    }
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    arrayList.add(companion.createFromPackageInfo(context, it));
                }
                return arrayList;
            }
            return arrayList;
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngine", "getInstalledPackages error:", e16);
            return arrayList;
        }
    }

    public final void r(int flag, @NotNull IMiniBoxDataCallback<List<MiniBoxAppInfo>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[getInstalledPackages] sdk not init");
            callback.onFail(-1, "MiniBox SDK not init");
            return;
        }
        try {
            IMiniBoxApi t16 = t();
            if (t16 != null) {
                ArrayList arrayList = new ArrayList();
                List<PackageInfo> installedPackages = t16.getInstalledPackages(flag);
                if (installedPackages != null) {
                    for (PackageInfo it : installedPackages) {
                        MiniBoxAppInfo.Companion companion = MiniBoxAppInfo.INSTANCE;
                        Context context = this.mContext;
                        if (context == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        }
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        arrayList.add(companion.createFromPackageInfo(context, it));
                    }
                }
                callback.onSuccess(arrayList);
                return;
            }
            callback.onFail(-2, "MiniBox API not init");
        } catch (Exception e16) {
            LogUtils.e("MiniBoxSDK", "getInstalledPackagesAsync: exception, e=" + e16.getMessage());
            callback.onFail(-3, "MiniBox API Exception:" + e16);
        }
    }

    public final synchronized void u(@NotNull Context context, @NotNull MiniBoxProxy proxy) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            LogUtils.e("MiniBoxEngine", "\u4e0d\u652f\u6301\u7684\u7cfb\u7edf\u7248\u672c\u3002SDK_INT=" + i3);
            return;
        }
        LogUtils.i("MiniBoxEngine", "init. mHasInit=" + this.mHasInit);
        if (this.mHasInit) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        this.mContext = applicationContext;
        l51.a.b(PluginVersionManager.f151646b.i(context));
        v(proxy);
        this.mHasInit = true;
    }

    public final void v(@NotNull MiniBoxProxy proxy) {
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        this.mProxy = proxy;
        ProxyRef.init(proxy);
        LogProxy logProxy = proxy.getLogProxy();
        if (logProxy != null) {
            LogUtils.injectImpl(logProxy);
        }
        ExecutorProxy executorProxy = proxy.getExecutorProxy();
        if (executorProxy != null) {
            ThreadManager.get().setExecutorProxy(executorProxy);
        }
    }

    public final void w(@NotNull String apkPath, @Nullable IMiniBoxCallback callback) {
        Intrinsics.checkParameterIsNotNull(apkPath, "apkPath");
        if (z()) {
            if (callback != null) {
                callback.onFail(-1, "sdk not init.");
            }
            LogUtils.e("MiniBoxEngine", "[installApp] sdk not init");
            return;
        }
        x(apkPath, callback);
    }

    public final boolean y(@NotNull String pkgName) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        if (z()) {
            LogUtils.e("MiniBoxEngine", "[isAppInstalled] sdk not init");
            return false;
        }
        if (p(pkgName) == null) {
            return false;
        }
        return true;
    }

    public /* synthetic */ MiniBoxEngine(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
