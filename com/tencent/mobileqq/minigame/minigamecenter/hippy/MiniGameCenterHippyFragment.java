package com.tencent.mobileqq.minigame.minigamecenter.hippy;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.minigame.minigamecenter.utils.MiniBoxSystemInstallHelper;
import com.tencent.mobileqq.minigame.minigamecenter.utils.MiniGameCenterHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.event.MiniBoxAppBackgroundEvent;
import com.tencent.util.AbiUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e`\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minigame/minigamecenter/hippy/MiniGameCenterHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/qq/minibox/event/MiniBoxAppBackgroundEvent;", "()V", "mAdData", "Lorg/json/JSONObject;", "systemInstallHelper", "Lcom/tencent/mobileqq/minigame/minigamecenter/utils/MiniBoxSystemInstallHelper;", "doBussinessInitData", "jsInitData", "generateAdJSONObject", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "init", "", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDestroyView", "onLoadHippySuccess", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", MiniGameKuiklyModule.METHOD_PRELOAD_MINI_GAME, "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCenterHippyFragment extends CommonHippyFragment implements SimpleEventReceiver<MiniBoxAppBackgroundEvent> {
    public static final String EXTRA_KEY_AD = "ad";
    public static final String EXTRA_KEY_AD_TRACE_INFO = "traceinfo";
    public static final String EXTRA_KEY_APP_INFO_BUFFER = "buffer";
    private static final String EXTRA_KEY_IS_ARM64 = "isArm64";
    private static final String TAG = "MiniGameCenterHippyFragment";
    private JSONObject mAdData;
    private MiniBoxSystemInstallHelper systemInstallHelper;

    private final JSONObject generateAdJSONObject() {
        JSONObject jSONObject = this.mAdData;
        if (jSONObject != null) {
            Intrinsics.checkNotNull(jSONObject);
            return jSONObject;
        }
        HashMap hashMap = new HashMap();
        String appInfoBuffer = MiniGameCenterHelper.getAppInfoBuffer();
        Intrinsics.checkNotNullExpressionValue(appInfoBuffer, "getAppInfoBuffer()");
        hashMap.put("buffer", appInfoBuffer);
        String appInfoTraceInfo = MiniGameCenterHelper.getAppInfoTraceInfo();
        Intrinsics.checkNotNullExpressionValue(appInfoTraceInfo, "getAppInfoTraceInfo()");
        hashMap.put(EXTRA_KEY_AD_TRACE_INFO, appInfoTraceInfo);
        MiniGameCenterHelper.clearCacheData();
        JSONObject wrapHashMap = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, hashMap);
        this.mAdData = wrapHashMap;
        Intrinsics.checkNotNull(wrapHashMap);
        return wrapHashMap;
    }

    private final void init() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.systemInstallHelper = new MiniBoxSystemInstallHelper(activity);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void preloadMiniGame() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCenterHippyFragment.preloadMiniGame$lambda$3();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadMiniGame$lambda$3() {
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        iMiniAppService.preloadMiniApp();
        iMiniAppService.preloadMiniGame();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public JSONObject doBussinessInitData(JSONObject jsInitData) {
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        try {
            doBussinessInitData.put("ad", generateAdJSONObject());
            doBussinessInitData.put(EXTRA_KEY_IS_ARM64, AbiUtil.isArm64Runtime(requireContext()));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "init Data failed,  exception : " + th5);
        }
        return doBussinessInitData;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preloadMiniGame();
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iMiniBoxLauncher.init(requireContext);
        init();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        MiniBoxSystemInstallHelper miniBoxSystemInstallHelper = this.systemInstallHelper;
        if (miniBoxSystemInstallHelper != null) {
            miniBoxSystemInstallHelper.destory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        super.onLoadHippySuccess();
        try {
            JSONObject generateAdJSONObject = generateAdJSONObject();
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("ad", generateAdJSONObject.toString());
            sendHippyNativeEvent("BusinessInfoChange", hippyMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "js event transfer ad Data failed,  exception : " + th5);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        MiniBoxSystemInstallHelper miniBoxSystemInstallHelper;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof MiniBoxAppBackgroundEvent) {
            MiniBoxAppBackgroundEvent miniBoxAppBackgroundEvent = (MiniBoxAppBackgroundEvent) event;
            QLog.d(TAG, 4, "-->onReceiveEvent event:" + miniBoxAppBackgroundEvent.getAppId());
            if (getQBaseActivity() == null) {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            } else {
                if (getContext() == null || (miniBoxSystemInstallHelper = this.systemInstallHelper) == null) {
                    return;
                }
                miniBoxSystemInstallHelper.start(miniBoxAppBackgroundEvent.getAppId());
            }
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<MiniBoxAppBackgroundEvent>> getEventClass() {
        ArrayList<Class<MiniBoxAppBackgroundEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MiniBoxAppBackgroundEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
