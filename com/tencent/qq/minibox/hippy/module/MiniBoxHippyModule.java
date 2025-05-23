package com.tencent.qq.minibox.hippy.module;

import android.app.Activity;
import android.content.Intent;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityBehind;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor;
import com.tencent.qq.minibox.ui.FloatingPanelFragment;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.xaction.log.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us3.g;

/* compiled from: P */
@HippyNativeModule(name = MiniBoxHippyModule.TAG)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u0015\u001a\u00020\u0007H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qq/minibox/hippy/module/MiniBoxHippyModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "", "getPid", "()Ljava/lang/Integer;", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "callbackPidError", "Lcom/tencent/mtt/hippy/common/HippyMap;", "params", "isAppInstalled", "downloadAndInstallApp", "exitVirtualGame", "restartMcClient", "getMcVideoResolution", "setMcVideoResolution", "getMcUserInfo", "openPermissions", "exitHippy", "callMc", "destroy", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "hippyEngineContext", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxHippyModule extends QQBaseModule {
    private static final int EXIT_FROM_SIDE_PANEL = 0;

    @NotNull
    private static final String KEY_APP_ID = "appId";

    @NotNull
    public static final String KEY_CODE = "code";

    @NotNull
    public static final String KEY_ERROR_MESSAGE = "errorMsg";

    @NotNull
    public static final String KEY_FROM = "from";

    @NotNull
    private static final String KEY_IS_ASYNC = "isAsync";

    @NotNull
    private static final String KEY_METHOD_NAME = "methodName";

    @NotNull
    private static final String KEY_METHOD_PARAMS = "methodParams";

    @NotNull
    private static final String KEY_MINIBOX_PID = "minibox_pid";

    @NotNull
    private static final String KEY_PACKAGE_NAME = "packageName";

    @NotNull
    public static final String KEY_RESULT = "result";

    @NotNull
    public static final String TAG = "MiniBoxHippyModule";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniBoxHippyModule(@NotNull HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        Intrinsics.checkNotNullParameter(hippyEngineContext, "hippyEngineContext");
    }

    private final void callbackPidError(Promise promise) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("result", -1);
            hippyMap.pushString("errorMsg", "get pid error");
            promise.resolve(hippyMap);
        }
    }

    private final Integer getPid() {
        Integer num;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra(KEY_MINIBOX_PID, 0));
        } else {
            num = null;
        }
        if (num == null || num.intValue() == 0) {
            return null;
        }
        return num;
    }

    @HippyMethod(name = "callMc")
    public final void callMc(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        boolean z16;
        b.a(TAG, 2, "callMc params: " + params);
        Unit unit = null;
        if (params != null) {
            str = params.getString(KEY_METHOD_NAME);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        String string = params.getString(KEY_METHOD_PARAMS);
        boolean z17 = params.getBoolean(KEY_IS_ASYNC);
        Integer pid = getPid();
        if (pid != null) {
            g.f439986a.a(pid.intValue(), str, string, z17, promise);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            callbackPidError(promise);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        MiniBoxHostEventProcessor.f344586a.i();
    }

    @HippyMethod(name = "launchAppInstall")
    public final void downloadAndInstallApp(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        String string;
        b.a(TAG, 4, "downloadAndInstallApp params:" + params);
        if (params != null) {
            str = params.getString(VirtualAppProxy.KEY_GAME_ID);
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 == null || (string = params.getString("packageName")) == null) {
            return;
        }
        g.f439986a.c(str2, string, params.getString("appName"), params.getInt("versionCode"), params.getString("iconUrl"), params.getString("apkUrl"));
    }

    @HippyMethod(name = "exitHippy")
    public final void exitHippy(@Nullable HippyMap params, @Nullable Promise promise) {
        b.a(TAG, 2, "exitHippy params: " + params);
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @HippyMethod(name = "exitVirtualGame")
    public final void exitVirtualGame(@Nullable HippyMap params, @Nullable Promise promise) {
        Integer num;
        QPublicTransFragmentActivityBehind qPublicTransFragmentActivityBehind;
        QPublicBaseFragment qPublicBaseFragment;
        b.a(TAG, 4, "exitVirtualGame params:" + params);
        Unit unit = null;
        FloatingPanelFragment floatingPanelFragment = null;
        if (params != null) {
            num = Integer.valueOf(params.getInt("from"));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            Activity activity = getActivity();
            if (activity instanceof QPublicTransFragmentActivityBehind) {
                qPublicTransFragmentActivityBehind = (QPublicTransFragmentActivityBehind) activity;
            } else {
                qPublicTransFragmentActivityBehind = null;
            }
            if (qPublicTransFragmentActivityBehind != null) {
                qPublicBaseFragment = qPublicTransFragmentActivityBehind.getFragment();
            } else {
                qPublicBaseFragment = null;
            }
            if (qPublicBaseFragment instanceof FloatingPanelFragment) {
                floatingPanelFragment = (FloatingPanelFragment) qPublicBaseFragment;
            }
            if (floatingPanelFragment != null) {
                floatingPanelFragment.sh(3);
                return;
            }
            return;
        }
        Integer pid = getPid();
        if (pid != null) {
            g.f439986a.d(pid.intValue());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            callbackPidError(promise);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    @HippyMethod(name = "getMcUserInfo")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getMcUserInfo(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        boolean z16;
        boolean isBlank;
        b.a(TAG, 4, "getMcUserInfo params:" + params);
        Unit unit = null;
        if (params != null) {
            str = params.getString("appId");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    b.a(TAG, 1, "getMcUserInfo appId: " + str);
                    return;
                }
                Integer pid = getPid();
                if (pid != null) {
                    try {
                        g.f439986a.e(pid.intValue(), str, promise);
                    } catch (Throwable th5) {
                        b.c(TAG, 1, "getMcUserInfo tr:", th5);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    callbackPidError(promise);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @HippyMethod(name = "getMcVideoResolution")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getMcVideoResolution(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        boolean z16;
        boolean isBlank;
        b.a(TAG, 4, "getMcVideoResolution params:" + params);
        Unit unit = null;
        if (params != null) {
            str = params.getString("appId");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    b.a(TAG, 1, "getMcVideoResolution appId: " + str);
                    return;
                }
                try {
                    Integer pid = getPid();
                    if (pid != null) {
                        g.f439986a.f(pid.intValue(), str, promise);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        callbackPidError(promise);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    b.c(TAG, 1, "getMcVideoResolution tr:", th5);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @HippyMethod(name = "isAppInstalled")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void isAppInstalled(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        boolean z16;
        boolean isBlank;
        b.a(TAG, 4, "isAppInstalled params:" + params);
        if (params != null) {
            str = params.getString("packageName");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    if (promise != null) {
                        promise.reject("package name is null or empty.");
                        return;
                    }
                    return;
                } else {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushBoolean("isInstalled", PackageUtil.isAppInstalled(getHippyQQEngine().getActivity(), str));
                    if (promise != null) {
                        promise.resolve(hippyMap);
                        return;
                    }
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    @HippyMethod(name = "openPermissions")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void openPermissions(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        boolean z16;
        boolean isBlank;
        b.a(TAG, 4, "openPermissions params:" + params);
        if (params != null) {
            str = params.getString("permissions");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    b.a(TAG, 1, "openPermissions permissions: " + str);
                    return;
                }
                Activity activity = getActivity();
                if (activity != null) {
                    g.f439986a.g(activity, str);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @HippyMethod(name = "restartMcClient")
    public final void restartMcClient(@Nullable HippyMap params, @Nullable Promise promise) {
        Unit unit;
        b.a(TAG, 4, "restartMcClient params:" + params);
        if (params != null) {
            params.getString("appId");
        }
        Integer pid = getPid();
        if (pid != null) {
            g.f439986a.h(pid.intValue(), getActivity(), promise);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callbackPidError(promise);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r5 != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    @HippyMethod(name = "setMcVideoResolution")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setMcVideoResolution(@Nullable HippyMap params, @Nullable Promise promise) {
        String str;
        String str2;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        b.a(TAG, 4, "setMcVideoResolution params:" + params);
        Unit unit = null;
        if (params != null) {
            str = params.getString("appId");
        } else {
            str = null;
        }
        if (params != null) {
            str2 = params.getString("pName");
        } else {
            str2 = null;
        }
        boolean z17 = false;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (str2 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                    }
                    z17 = true;
                    if (!z17) {
                        try {
                            Integer pid = getPid();
                            if (pid != null) {
                                g.f439986a.i(pid.intValue(), str, str2, promise);
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                callbackPidError(promise);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            b.c(TAG, 1, "setMcVideoResolution tr:", th5);
                            return;
                        }
                    }
                }
                b.a(TAG, 1, "setMcVideoResolution appId: " + str + ", pName:" + str2);
            }
        }
        z16 = true;
        if (!z16) {
        }
        b.a(TAG, 1, "setMcVideoResolution appId: " + str + ", pName:" + str2);
    }
}
