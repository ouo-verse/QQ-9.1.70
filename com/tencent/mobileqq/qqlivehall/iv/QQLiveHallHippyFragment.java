package com.tencent.mobileqq.qqlivehall.iv;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qqlive.huya.j;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi;
import com.tencent.mobileqq.qqlivehall.iv.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategyApi;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u001f\u001a\u00020\u0011H\u0014R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/QQLiveHallHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "", "getFrom", "", "isPreload", "isPredraw", "Lorg/json/JSONObject;", "jsInitData", "doBussinessInitData", "", "getLayoutResId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "msg", "onLoadHippyError", "onLoadHippySuccess", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "<init>", "()V", "Companion", "a", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveHallHippyFragment extends CommonHippyFragment {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_DEVICE_INFO = "deviceinfo";

    @NotNull
    private static final String KEY_ENV = "env";

    @NotNull
    private static final String KEY_SUPPORT_HUYA = "supportHuya";
    private static final int STATUS_CODE_SUCCESS = 0;

    @NotNull
    private static final String TAG = "Audience|QQLiveHallHippyFragment";

    @NotNull
    private final IAegisLogApi aegisLogger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/QQLiveHallHippyFragment$a;", "", "", "KEY_DEVICE_INFO", "Ljava/lang/String;", "KEY_ENV", "KEY_SUPPORT_HUYA", "", "STATUS_CODE_SUCCESS", "I", "TAG", "<init>", "()V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlivehall.iv.QQLiveHallHippyFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveHallHippyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    private final String getFrom() {
        String string = getParameters().getString("from");
        if (string == null) {
            return "0";
        }
        return string;
    }

    private final boolean isPredraw() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            return hippyQQPreloadEngine.isPredraw();
        }
        return false;
    }

    private final boolean isPreload() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            return hippyQQPreloadEngine.isPreloaded();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new i());
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    @NotNull
    public JSONObject doBussinessInitData(@Nullable JSONObject jsInitData) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsInitData);
        }
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        try {
            QRouteApi api = QRoute.api(IQQLiveCookieStrategyApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQLiveCookieStrategyApi::class.java)");
            for (Map.Entry<String, String> entry : IQQLiveCookieStrategyApi.DefaultImpls.getCookieStrategy$default((IQQLiveCookieStrategyApi) api, null, 1, null).buildSync().entrySet()) {
                doBussinessInitData.put(entry.getKey(), entry.getValue());
            }
            if (((IQQIvLiveHallApi) QRoute.api(IQQIvLiveHallApi.class)).isTestEnv(getContext())) {
                i16 = 1;
            }
            doBussinessInitData.put("env", i16);
            doBussinessInitData.put(KEY_DEVICE_INFO, ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo());
            j jVar = (j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102401");
            if (jVar != null && jVar.b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            doBussinessInitData.put(KEY_SUPPORT_HUYA, i3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return doBussinessInitData;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment
    protected int getLayoutResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.h_r;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        Context baseContext = activity.getBaseContext();
        Resources resources = baseContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "baseContext.resources");
        a aVar = new a(resources);
        com.tencent.mobileqq.qqlivehall.iv.common.a.b(baseContext, baseContext.getClass().getName(), "mResources", aVar);
        com.tencent.mobileqq.qqlivehall.iv.common.a.b(activity, ContextThemeWrapper.class.getName(), "mResources", aVar);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View onCreateView;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 7, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            FragmentActivity activity = getActivity();
            if (activity != null && (viewGroup = this.mRootView) != null) {
                viewGroup.setBackgroundColor(ContextCompat.getColor(activity, R.color.f157819ce0));
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(int statusCode, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, statusCode, (Object) msg2);
            return;
        }
        super.onLoadHippyError(statusCode, msg2);
        this.aegisLogger.e(TAG, 1, "onLoadHippyError:statusCode=" + statusCode + ",msg=" + msg2);
        b bVar = b.f274104a;
        String from = getFrom();
        if (msg2 == null) {
            msg2 = "";
        }
        bVar.d(new b.C8415b(from, statusCode, msg2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onLoadHippySuccess();
        this.aegisLogger.i(TAG, 1, "onLoadHippySuccess:isPreload=" + isPreload() + ",isPredraw=" + isPredraw());
        b.f274104a.d(new b.C8415b(getFrom(), 0, ""));
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
