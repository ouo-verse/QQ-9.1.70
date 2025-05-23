package com.tencent.mobileqq.minigame.publicaccount.hippy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0004J\u0010\u0010)\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001fH\u0004J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00102\u001a\u00020#H\u0016J\u001a\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0014J\b\u00105\u001a\u00020#H\u0014J\b\u00106\u001a\u00020#H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0005X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyBaseFragment;", "Lcom/tencent/hippy/qq/fragment/BaseHippyFragment;", "Landroid/os/Handler$Callback;", "()V", "hippyContainer", "Landroid/view/ViewGroup;", "getHippyContainer", "()Landroid/view/ViewGroup;", "setHippyContainer", "(Landroid/view/ViewGroup;)V", "mProgressBarWrapper", "Lcom/tencent/hippy/qq/fragment/HippyProgressBarWrapper;", "mStartTime", "", "getMStartTime", "()J", "setMStartTime", "(J)V", "mTimeoutHandler", "Landroid/os/Handler;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "getRootView", "setRootView", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "getFromValue", "", "getLayoutResId", "", "handleMessage", "", "msg", "Landroid/os/Message;", "initProgressBar", "", "initViews", "initWindowStyleAndAnimation", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "isNightTheme", "notifyHippyThemeChange", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "onDestroyView", "onLoadHippyError", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "onLoadHippySuccess", "reportTimeOut", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class MiniGamePAHippyBaseFragment extends BaseHippyFragment implements Handler.Callback {
    public static final String FROM_DEFAULT = "other";
    public static final String FROM_MESSAGE = "message";
    public static final String KEY_ARK_MODEL = "arkModel";
    public static final String KEY_FROM = "from";
    public static final String KEY_PRE_DRAW = "isPredraw";
    public static final String KEY_THEME = "isNightMode";
    public static final String KEY_THEME_CHANGE = "themeChange";
    public static final long LOAD_HIPPY_TIME_OUT = 9000;
    private static final int MSG_TIME_OUT = 1;
    public static final String TAG = "MiniGamePAHippyBaseFragment";
    protected ViewGroup hippyContainer;
    private long mStartTime;
    protected ViewGroup rootView;
    private final HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
    private final Handler mTimeoutHandler = new Handler(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    public static final void doBussinessInitData$lambda$1$lambda$0(Ref.ObjectRef arkModels, CountDownLatch lock, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(arkModels, "$arkModels");
        Intrinsics.checkNotNullParameter(lock, "$lock");
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.code == 0) {
            z16 = true;
        }
        if (z16) {
            arkModels.element = eIPCResult.data.getString(MiniGamePublicAccountIPCModule.KEY_MSG_JSON_STRING);
        }
        lock.countDown();
    }

    private final String getFromValue() {
        if (Intrinsics.areEqual("aio", getParameters().getString("from"))) {
            return "message";
        }
        return "other";
    }

    private final void reportTimeOut() {
        if (this.mHippyQQEngine == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ret", 0);
        String lastStepName = getLastStepName();
        Intrinsics.checkNotNullExpressionValue(lastStepName, "lastStepName");
        hashMap.put("errMsg", lastStepName);
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        hashMap.put("isPreload", Boolean.valueOf(hippyQQPreloadEngine != null ? hippyQQPreloadEngine.isPreloaded() : false));
        String string = getParameters().getString("from");
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullExpressionValue(string, "parameters.getString(Ope\u2026nfo.EXTRA_KEY_FROM) ?: \"\"");
        hashMap.put("from", string);
        HippyReporter.getInstance().reportHippyLoadResult(6, this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), hashMap, generateStepCosts(), null);
    }

    protected final ViewGroup getHippyContainer() {
        ViewGroup viewGroup = this.hippyContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
        return null;
    }

    public abstract int getLayoutResId();

    protected final long getMStartTime() {
        return this.mStartTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewGroup getRootView() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!(msg2.what == 1)) {
            return false;
        }
        QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
        if (!isFragmentDestroyed()) {
            gotoErrorUrl();
        }
        if (this.mHippyQQEngine != null) {
            reportTimeOut();
        }
        return true;
    }

    public void initProgressBar() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        boolean z16 = false;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isNeedShowLoading()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.mProgressBarWrapper.initProgressBar(getRootView());
        this.mProgressBarWrapper.startProgressBar();
    }

    public void initViews() {
        View findViewById = getRootView().findViewById(R.id.x_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.hippy_container)");
        setHippyContainer((ViewGroup) findViewById);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setFlags(16777216, 16777216);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyHippyThemeChange(boolean isNightTheme) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean(KEY_THEME, isNightTheme);
        Unit unit = Unit.INSTANCE;
        sendHippyNativeEvent(KEY_THEME_CHANGE, hippyMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "MiniGame hippy Fragment init!");
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        this.mStartTime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        View inflate = getLayoutInflater().inflate(getLayoutResId(), (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        setRootView((ViewGroup) inflate);
        initViews();
        loadHippy(getHippyContainer());
        initProgressBar();
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !hippyQQPreloadEngine.isPredraw()) {
            z16 = true;
        }
        if (z16) {
            this.mTimeoutHandler.sendEmptyMessageDelayed(1, LOAD_HIPPY_TIME_OUT);
        }
        return getRootView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mTimeoutHandler.removeMessages(1);
        super.onDestroyView();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected void onLoadHippyError(int statusCode, String msg2) {
        this.mTimeoutHandler.removeMessages(1);
        this.mProgressBarWrapper.hideProgressBar();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected void onLoadHippySuccess() {
        this.mTimeoutHandler.removeMessages(1);
        this.mProgressBarWrapper.hideProgressBar();
        notifyHippyThemeChange(isNightTheme());
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    protected final void setHippyContainer(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.hippyContainer = viewGroup;
    }

    protected final void setMStartTime(long j3) {
        this.mStartTime = j3;
    }

    protected final void setRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.rootView = viewGroup;
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    protected JSONObject doBussinessInitData(JSONObject jsInitData) {
        int indexOf$default;
        boolean contains$default;
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String string = getParameters().getString("url");
            boolean z16 = false;
            if (string != null) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, "#params=", 0, false, 6, (Object) null);
                String substring = string.substring(indexOf$default + 7 + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(substring, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) new String(decode, Charsets.UTF_8), (CharSequence) "extraNeedArkModel=1", false, 2, (Object) null);
                if (contains$default) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_PUBLIC_MSG, null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.c
                        @Override // eipc.EIPCResultCallback
                        public final void onCallback(EIPCResult eIPCResult) {
                            MiniGamePAHippyBaseFragment.doBussinessInitData$lambda$1$lambda$0(Ref.ObjectRef.this, countDownLatch, eIPCResult);
                        }
                    });
                    countDownLatch.await(1L, TimeUnit.SECONDS);
                }
            }
            Serializable serializable = getParameters().getSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP);
            SerializableMap serializableMap = serializable instanceof SerializableMap ? (SerializableMap) serializable : null;
            JSONObject wrapHashMap = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(jsInitData, serializableMap != null ? serializableMap.getMap() : null);
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
            if (hippyQQPreloadEngine != null && hippyQQPreloadEngine.isPredraw()) {
                z16 = true;
            }
            wrapHashMap.put("isPredraw", z16);
            wrapHashMap.put(KEY_THEME, isNightTheme());
            wrapHashMap.put("from", getFromValue());
            if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
                wrapHashMap.put(KEY_ARK_MODEL, objectRef.element);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doBussinessInitData jsonObject=" + wrapHashMap);
            }
            return wrapHashMap;
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, "doBussinessInitData:" + th5);
            return jsInitData;
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isNightTheme() {
        return ThemeUtil.isNowThemeIsNight(null, false, null);
    }
}
