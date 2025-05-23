package com.tencent.qq.minibox.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.IMiniBoxCallback;
import com.tencent.minibox.business.api.IMiniBoxDataCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.minibox.contract.LaunchExtInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.api.impl.MiniBoxLauncherImpl;
import com.tencent.qq.minibox.debug.MiniBoxDebugFragment;
import com.tencent.qq.minibox.proxy.n;
import com.tencent.qq.minibox.ui.MiniBoxAppLoadingFragment;
import com.tencent.qq.minibox.ui.MiniBoxAppManagerFragment;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$IsVMAppBlockedRsp;
import com.tencent.util.AbiUtil;
import com.vivo.push.PushClientConstants;
import fs3.MiniBoxInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us3.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u001e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016Jo\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f2U\u0010(\u001aQ\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0006\u0018\u00010!j\u0004\u0018\u0001`'H\u0016J\b\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\f\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0004H\u0016JX\u00103\u001a\u00020\u00062N\u0010(\u001aJ\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001f\u0018\u000100\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00060/j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f00`2H\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u00020\u0015H\u0016Jg\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00152U\u0010(\u001aQ\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0006\u0018\u00010!j\u0004\u0018\u0001`'H\u0016Jg\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00152U\u0010(\u001aQ\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0006\u0018\u00010!j\u0004\u0018\u0001`'H\u0016J\u0010\u0010:\u001a\u0002092\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u0002092\u0006\u00104\u001a\u00020\u0015H\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/qq/minibox/api/impl/MiniBoxLauncherImpl;", "Lcom/tencent/qq/minibox/api/IMiniBoxLauncher;", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "miniAppDataInfo", "", "from", "", "startMiniBoxAppLoadingPage", "Landroid/content/Context;", "context", "miniBoxAppDataInfo", "Lqs3/d;", "ssoResponse", "doStartVirtualApp", "", "isLocalBlocked", "doStartPageByState", "cacheAppInfo", "preload", "init", "onApplicationCreate", "", "dataJson", "Landroid/content/Intent;", "intent", "startMiniBoxManagerPage", "startVirtualApp", "appId", "packageName", "appVersion", "launchVirtualApp", "Lfs3/a;", "miniBoxInfo", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "Lcom/tencent/qq/minibox/constants/MiniBoxCallback;", "callback", "getMiniBoxInstallApp", "isMiniBoxAppInstall", "Ljava/lang/Class;", "getMiniBoxDebugFragmentClass", "result", "reportHippyEntryStatus", "Lkotlin/Function2;", "", "data", "Lcom/tencent/qq/minibox/constants/MiniBoxDataCallback;", "getMiniBoxInstallList", PushClientConstants.TAG_PKG_NAME, "getCacheMiniBoxAppInfo", "apkPath", "installVirtualApp", "uninstallVirtualApp", "", "getAllCacheSize", "getAppCacheSize", "preLaunchProcess", "Lcom/tencent/qq/minibox/proxy/n;", "miniboxProxy", "Lcom/tencent/qq/minibox/proxy/n;", "<init>", "()V", "Companion", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxLauncherImpl implements IMiniBoxLauncher {

    @NotNull
    private static final String TAG = "MiniBoxLauncherImpl";

    @NotNull
    private final n miniboxProxy = new n();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxLauncherImpl$b", "Lcom/tencent/minibox/business/api/IMiniBoxDataCallback;", "", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "data", "", "a", "", "errorCode", "", "errorMessage", "onFail", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IMiniBoxDataCallback<List<? extends MiniBoxAppInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, List<MiniBoxInfo>, Unit> f344495a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super List<MiniBoxInfo>, Unit> function2) {
            this.f344495a = function2;
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable List<MiniBoxAppInfo> data) {
            int collectionSizeOrDefault;
            if (data != null) {
                Function2<Boolean, List<MiniBoxInfo>, Unit> function2 = this.f344495a;
                List<MiniBoxAppInfo> list = data;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (MiniBoxAppInfo miniBoxAppInfo : list) {
                    arrayList.add(new MiniBoxInfo(miniBoxAppInfo.getAppName(), miniBoxAppInfo.getPkgName(), miniBoxAppInfo.getVersionCode(), miniBoxAppInfo.getVersionName(), miniBoxAppInfo.getIconFilePath(), null, false, false, null, null, 0, null, 4064, null));
                }
                function2.invoke(Boolean.TRUE, arrayList);
            }
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
        public void onFail(int errorCode, @Nullable String errorMessage) {
            QLog.e(MiniBoxLauncherImpl.TAG, 1, "getMiniBoxInstallList errorCode:" + errorCode + " errorMessage:" + errorMessage);
            this.f344495a.invoke(Boolean.FALSE, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxLauncherImpl$c", "Lcom/tencent/minibox/business/api/IMiniBoxCallback;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements IMiniBoxCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f344496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniBoxLauncherImpl f344497b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3, MiniBoxLauncherImpl miniBoxLauncherImpl) {
            this.f344496a = function3;
            this.f344497b = miniBoxLauncherImpl;
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onFail(int errorCode, @Nullable String errorMsg) {
            Function3<Boolean, Integer, String, Unit> function3 = this.f344496a;
            if (function3 != null) {
                function3.invoke(Boolean.FALSE, Integer.valueOf(errorCode), errorMsg);
            }
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onSuccess() {
            Function3<Boolean, Integer, String, Unit> function3 = this.f344496a;
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, 0, null);
            }
            this.f344497b.cacheAppInfo();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxLauncherImpl$d", "Lcom/tencent/minibox/business/api/IMiniBoxCallback;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements IMiniBoxCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f344498a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f344499b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniBoxInfo f344500c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f344501d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3, String str, MiniBoxInfo miniBoxInfo, long j3) {
            this.f344498a = function3;
            this.f344499b = str;
            this.f344500c = miniBoxInfo;
            this.f344501d = j3;
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onFail(int errorCode, @Nullable String errorMsg) {
            this.f344498a.invoke(Boolean.FALSE, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxCallback
        public void onSuccess() {
            this.f344498a.invoke(Boolean.TRUE, 0, "");
            gs3.c.o(this.f344499b, String.valueOf(this.f344500c.getVersionCode()), this.f344501d);
            MiniBoxLiveAlive.c().d();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxLauncherImpl$e", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements qs3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f344503e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ VirtualAppInfo f344504f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f344505h;

        e(Context context, VirtualAppInfo virtualAppInfo, int i3) {
            this.f344503e = context;
            this.f344504f = virtualAppInfo;
            this.f344505h = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MiniBoxLauncherImpl this$0, Context context, VirtualAppInfo miniBoxAppDataInfo, qs3.d ssoResponse, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(miniBoxAppDataInfo, "$miniBoxAppDataInfo");
            Intrinsics.checkNotNullParameter(ssoResponse, "$ssoResponse");
            this$0.doStartVirtualApp(context, miniBoxAppDataInfo, ssoResponse, i3);
        }

        @Override // qs3.a
        public void q7(@NotNull final qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                MiniBoxLauncherImpl.this.doStartVirtualApp(this.f344503e, this.f344504f, ssoResponse, this.f344505h);
                return;
            }
            final MiniBoxLauncherImpl miniBoxLauncherImpl = MiniBoxLauncherImpl.this;
            final Context context = this.f344503e;
            final VirtualAppInfo virtualAppInfo = this.f344504f;
            final int i3 = this.f344505h;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxLauncherImpl.e.b(MiniBoxLauncherImpl.this, context, virtualAppInfo, ssoResponse, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheAppInfo() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxLauncherImpl.cacheAppInfo$lambda$10();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cacheAppInfo$lambda$10() {
        List<MiniBoxAppInfo> installedApps = MiniBoxSDK.getInstalledApps();
        if (installedApps != null) {
            Iterator<T> it = installedApps.iterator();
            while (it.hasNext()) {
                us3.h.f439987a.a((MiniBoxAppInfo) it.next());
            }
        }
    }

    private final void doStartPageByState(final Context context, boolean isLocalBlocked, VirtualAppInfo miniBoxAppDataInfo, int from) {
        QLog.i(TAG, 2, "[doStartPageByState] " + miniBoxAppDataInfo);
        if (miniBoxAppDataInfo.getIsBlocked()) {
            p.d(p.f440002a, miniBoxAppDataInfo.getAppId(), false, AbiUtil.isArm64Runtime(context), isLocalBlocked, 0, 16, null);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxLauncherImpl.doStartPageByState$lambda$8(context);
                }
            });
        } else {
            p.d(p.f440002a, miniBoxAppDataInfo.getAppId(), true, AbiUtil.isArm64Runtime(context), isLocalBlocked, 0, 16, null);
            startMiniBoxAppLoadingPage(miniBoxAppDataInfo, from);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doStartPageByState$lambda$8(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, R.string.f166872be, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doStartVirtualApp(final Context context, VirtualAppInfo miniBoxAppDataInfo, qs3.d ssoResponse, int from) {
        boolean z16;
        if (ssoResponse.c()) {
            VMBasicInfo$IsVMAppBlockedRsp vMBasicInfo$IsVMAppBlockedRsp = new VMBasicInfo$IsVMAppBlockedRsp();
            vMBasicInfo$IsVMAppBlockedRsp.mergeFrom(ssoResponse.getData());
            boolean z17 = vMBasicInfo$IsVMAppBlockedRsp.is_blocked.get();
            String md5 = vMBasicInfo$IsVMAppBlockedRsp.MD5.get();
            gs3.c cVar = gs3.c.f403270a;
            String appId = miniBoxAppDataInfo.getAppId();
            Intrinsics.checkNotNull(appId);
            boolean i3 = cVar.i(context, appId);
            if (!z17 && !i3) {
                z16 = false;
            } else {
                z16 = true;
            }
            miniBoxAppDataInfo.B(z16);
            Intrinsics.checkNotNullExpressionValue(md5, "md5");
            miniBoxAppDataInfo.M(md5);
            QLog.i(TAG, 1, "[doStartVirtualApp] isBlocked=" + z17 + " md5=" + md5 + ",isLocalBlocked=" + i3 + ", appId=" + miniBoxAppDataInfo.getAppId());
            if (TextUtils.isEmpty(md5)) {
                p.d(p.f440002a, miniBoxAppDataInfo.getAppId(), false, AbiUtil.isArm64Runtime(context), false, 0, 16, null);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniBoxLauncherImpl.doStartVirtualApp$lambda$4(context);
                    }
                });
                return;
            } else {
                doStartPageByState(context, i3, miniBoxAppDataInfo, from);
                return;
            }
        }
        p.f440002a.c(miniBoxAppDataInfo.getAppId(), false, AbiUtil.isArm64Runtime(context), false, ssoResponse.getRetCode());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxLauncherImpl.doStartVirtualApp$lambda$5(context);
            }
        });
        QLog.e(TAG, 1, "[requestAppBlockState] errorCode=" + ssoResponse.getRetCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doStartVirtualApp$lambda$4(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "\u5c0f\u6e38\u620f\u914d\u7f6e\u51fa\u9519", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doStartVirtualApp$lambda$5(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, R.string.f166952bm, 0).show();
    }

    private final void startMiniBoxAppLoadingPage(VirtualAppInfo miniAppDataInfo, int from) {
        Intent intent = new Intent();
        intent.setExtrasClassLoader(VirtualAppInfo.class.getClassLoader());
        intent.putExtra("virtualAppData", miniAppDataInfo);
        intent.putExtra("minibox_from", from);
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(BaseApplication.getContext(), intent, QPublicFragmentActivity.class, MiniBoxAppLoadingFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMiniBoxManagerPage$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, R.string.f166862bd, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVirtualApp$lambda$1(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, R.string.f166862bd, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uninstallVirtualApp$lambda$11(Function3 function3, String pkgName, Boolean it) {
        Intrinsics.checkNotNullParameter(pkgName, "$pkgName");
        if (function3 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function3.invoke(it, 0, "");
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            us3.h.f439987a.f(pkgName);
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public long getAllCacheSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MiniBoxSDK.getAllCacheSize(context);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public long getAppCacheSize(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        return MiniBoxSDK.getAppStorageSpace(pkgName);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    @Nullable
    public MiniBoxInfo getCacheMiniBoxAppInfo(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        us3.h hVar = us3.h.f439987a;
        MiniBoxAppInfo c16 = hVar.c(pkgName);
        if (c16 != null && hVar.d(c16)) {
            return new MiniBoxInfo(c16.getAppName(), c16.getPkgName(), c16.getVersionCode(), c16.getVersionName(), c16.getIconFilePath(), null, false, false, null, null, 0, null, 4064, null);
        }
        return null;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    @NotNull
    public Class<?> getMiniBoxDebugFragmentClass() {
        return MiniBoxDebugFragment.class;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    @NotNull
    public String getMiniBoxInstallApp() {
        JSONArray jSONArray = new JSONArray();
        List<MiniBoxAppInfo> installedApps = MiniBoxSDK.getInstalledApps();
        if (installedApps != null) {
            try {
                for (MiniBoxAppInfo miniBoxAppInfo : installedApps) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("packageName", miniBoxAppInfo.getPkgName());
                    jSONObject.put("versionCode", miniBoxAppInfo.getVersionCode());
                    jSONArray.mo162put(jSONObject);
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[getMiniBoxInstallApp error] msg:" + e16.getMessage());
            }
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "installAppJson.toString()");
        return jSONArray2;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void getMiniBoxInstallList(@NotNull Function2<? super Boolean, ? super List<MiniBoxInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniBoxSDK.getInstalledApps(new b(callback));
        Unit unit = Unit.INSTANCE;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxFeatureSwitchEnable()) {
            return;
        }
        MiniBoxSDK.init(context.getApplicationContext(), this.miniboxProxy);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void installVirtualApp(@NotNull String apkPath, @Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(apkPath, "apkPath");
        MiniBoxSDK.installApp(apkPath, new c(callback, this));
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public boolean isMiniBoxAppInstall(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return MiniBoxSDK.isAppInstalled(packageName);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void launchVirtualApp(@Nullable Context context, @Nullable String appId, @Nullable String packageName, @Nullable String appVersion) {
        LaunchAppInfo launchAppInfo = new LaunchAppInfo();
        launchAppInfo.setAppId(appId);
        launchAppInfo.setAppVersion(appVersion);
        launchAppInfo.setPackageName(packageName);
        MiniBoxSDK.launchApp(launchAppInfo);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void onApplicationCreate() {
        MiniBoxSDK.onMiniBoxProcessInit(MobileQQ.sMobileQQ, this.miniboxProxy);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void preLaunchProcess(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MiniBoxSDK.preLaunchProcess(context, false);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void preload() {
        if (!((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxFeatureSwitchEnable()) {
            return;
        }
        MiniBoxSDK.preload();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void reportHippyEntryStatus(int result) {
        p.f440002a.a(result);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void startMiniBoxManagerPage(@NotNull final Context context, @NotNull String dataJson, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        if (!((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxFeatureSwitchEnable()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxLauncherImpl.startMiniBoxManagerPage$lambda$0(context);
                }
            });
            QLog.w(TAG, 1, "startMiniBoxManagerPage: switch close");
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.addFlags(268435456);
        intent.putExtra("recommendData", us3.f.f439985a.c(dataJson));
        QPublicFragmentActivity.b.b(BaseApplication.getContext(), intent, QPublicFragmentActivity.class, MiniBoxAppManagerFragment.class);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void startVirtualApp(@NotNull final Context context, @NotNull VirtualAppInfo miniBoxAppDataInfo, int from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(miniBoxAppDataInfo, "miniBoxAppDataInfo");
        QLog.i(TAG, 2, "[startVirtualApp] appId=" + miniBoxAppDataInfo.getAppId() + ",versionCode=" + miniBoxAppDataInfo.getVersionCode());
        p pVar = p.f440002a;
        pVar.b(from);
        if (!((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxFeatureSwitchEnable()) {
            pVar.g(miniBoxAppDataInfo.getAppId(), false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniBoxLauncherImpl.startVirtualApp$lambda$1(context);
                }
            });
            QLog.w(TAG, 1, "startVirtualApp: switch close");
        } else if (!TextUtils.isEmpty(miniBoxAppDataInfo.getAppId()) && !TextUtils.isEmpty(miniBoxAppDataInfo.getVersionCode())) {
            pVar.g(miniBoxAppDataInfo.getAppId(), true);
            gs3.c cVar = gs3.c.f403270a;
            String appId = miniBoxAppDataInfo.getAppId();
            Intrinsics.checkNotNull(appId);
            String versionCode = miniBoxAppDataInfo.getVersionCode();
            Intrinsics.checkNotNull(versionCode);
            cVar.q(appId, versionCode, new e(context, miniBoxAppDataInfo, from));
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void uninstallVirtualApp(@NotNull final String pkgName, @Nullable final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        MiniBoxSDK.unInstallApp(pkgName, new AsyncCallback() { // from class: com.tencent.qq.minibox.api.impl.f
            @Override // com.tencent.minibox.business.api.AsyncCallback
            public final void onResult(Object obj) {
                MiniBoxLauncherImpl.uninstallVirtualApp$lambda$11(Function3.this, pkgName, (Boolean) obj);
            }
        });
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxLauncher
    public void launchVirtualApp(@NotNull String appId, @NotNull MiniBoxInfo miniBoxInfo, @Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(miniBoxInfo, "miniBoxInfo");
        long currentTimeMillis = System.currentTimeMillis();
        d dVar = callback == null ? null : new d(callback, appId, miniBoxInfo, currentTimeMillis);
        LaunchAppInfo launchAppInfo = new LaunchAppInfo();
        launchAppInfo.setAppId(appId);
        launchAppInfo.setAppVersion(String.valueOf(miniBoxInfo.getVersionCode()));
        launchAppInfo.setPackageName(miniBoxInfo.getPkgName());
        launchAppInfo.setLoadingIconPath(miniBoxInfo.getLoadingIconPath());
        launchAppInfo.setLandscape(miniBoxInfo.getIsLandScape());
        launchAppInfo.setNeedShowLoading(miniBoxInfo.getNeedLoading());
        launchAppInfo.setIntent(miniBoxInfo.getIntent());
        launchAppInfo.setExtendBundle(miniBoxInfo.getExtendBundle());
        launchAppInfo.setLaunchTime(currentTimeMillis);
        launchAppInfo.setLaunch(new LaunchExtInfo(miniBoxInfo.getLaunchScene(), miniBoxInfo.getLaunchVia(), null));
        MiniBoxSDK.launchApp(launchAppInfo, dVar);
    }
}
