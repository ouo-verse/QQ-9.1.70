package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.preload.PreloadPrivilegeManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;

/* compiled from: P */
@HippyNativeModule(name = QQHippyBundleModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class QQHippyBundleModule extends QQBaseModule {
    static final String CLASS_NAME = "QQHippyBundleModule";
    private static final String KEY_ERROR_MESSAGE = "errMsg";
    private static final String KEY_RESULT_CODE = "retCode";
    private static final String MESSAGE_NO_PRIVILEGE = "No Privilege";
    private static final String MESSAGE_PARAMS_ERROR = "Parameters error";
    private ArrayList<UpdateKuiklyListener> mUpdateKuiklyListeners;
    private ArrayList<UpdateListener> mUpdateListeners;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class UpdateKuiklyListener implements Function1<ResError, Unit> {
        private volatile WeakReference<QQHippyBundleModule> hippyBundleModule;
        private Promise promise;

        public UpdateKuiklyListener(QQHippyBundleModule qQHippyBundleModule, Promise promise) {
            this.hippyBundleModule = new WeakReference<>(qQHippyBundleModule);
            this.promise = promise;
        }

        public void onDestroy() {
            this.hippyBundleModule = null;
            this.promise = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ResError resError) {
            if (this.hippyBundleModule != null && this.hippyBundleModule.get() != null && this.promise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("errCode", resError.getCode());
                hippyMap.pushString("errMsg", resError.getMessage());
                this.promise.resolve(hippyMap);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class UpdateListener implements IUpdateListener {
        private volatile QQHippyBundleModule hippyBundleModule;
        private Promise promise;

        public UpdateListener(QQHippyBundleModule qQHippyBundleModule, Promise promise) {
            this.hippyBundleModule = qQHippyBundleModule;
            this.promise = promise;
        }

        public void onDestroy() {
            this.hippyBundleModule = null;
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap) {
            if (this.hippyBundleModule == null) {
                return;
            }
            if (i16 == 101) {
                this.hippyBundleModule.onJsUpdateCompleted(str2, 1, null, this.promise);
            } else if (i16 == 1) {
                this.hippyBundleModule.onJsUpdateCompleted(str2, 0, null, this.promise);
            } else {
                this.hippyBundleModule.onJsUpdateCompleted(str2, -1, str, this.promise);
            }
            this.hippyBundleModule = null;
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap) {
            if (this.hippyBundleModule == null) {
                return;
            }
            this.hippyBundleModule.onJsUpdateCompleted(str, 1, null, this.promise);
            this.hippyBundleModule = null;
        }
    }

    public QQHippyBundleModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mUpdateListeners = new ArrayList<>();
        this.mUpdateKuiklyListeners = new ArrayList<>();
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        Iterator<UpdateListener> it = this.mUpdateListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mUpdateListeners.clear();
        Iterator<UpdateKuiklyListener> it5 = this.mUpdateKuiklyListeners.iterator();
        while (it5.hasNext()) {
            it5.next().onDestroy();
        }
        this.mUpdateKuiklyListeners.clear();
    }

    protected void onJsUpdateCompleted(String str, int i3, String str2, Promise promise) {
        if (promise == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", i3);
        if (i3 == 1) {
            hippyMap.pushInt("newVersion", ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str));
        } else if (i3 == -1) {
            hippyMap.pushString("errMsg", str2);
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "preloadHippy")
    public void preloadHippy(HippyMap hippyMap, Promise promise) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(hippyMap);
        HippyMap hippyMap2 = new HippyMap();
        if (openHippyInfo.preloadType != TabPreloadItem.PreloadType.NO_PRELOAD && openHippyInfo.checkData()) {
            if (PreloadPrivilegeManager.getInstance().checkHippyPreload(getBundleName(), openHippyInfo)) {
                hippyMap2.pushInt("retCode", 0);
                HippyAccessHelper.checkAndPreloadHippyPage(openHippyInfo);
            } else {
                hippyMap2.pushInt("retCode", -1);
                hippyMap2.pushString("errMsg", MESSAGE_NO_PRIVILEGE);
            }
        } else {
            hippyMap2.pushInt("retCode", -1);
            hippyMap2.pushString("errMsg", MESSAGE_PARAMS_ERROR);
        }
        if (promise != null) {
            promise.resolve(hippyMap2);
        }
    }

    @HippyMethod(name = "removePreload")
    public void removePreload(HippyMap hippyMap, Promise promise) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(hippyMap);
        openHippyInfo.from = "hippyApiRemove";
        HippyMap hippyMap2 = new HippyMap();
        if (!openHippyInfo.checkData()) {
            hippyMap2.pushInt("retCode", -1);
            hippyMap2.pushString("errMsg", MESSAGE_PARAMS_ERROR);
        } else if (PreloadPrivilegeManager.getInstance().checkHippyPreload(getBundleName(), openHippyInfo)) {
            hippyMap2.pushInt("retCode", 0);
            HippyAccessHelper.checkAndDestroyPreloadHippy(openHippyInfo);
        } else {
            hippyMap2.pushInt("retCode", -1);
            hippyMap2.pushString("errMsg", MESSAGE_NO_PRIVILEGE);
        }
        if (promise != null) {
            promise.resolve(hippyMap2);
        }
    }

    @HippyMethod(name = "updateJsBundle")
    public void updateJsBundle(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UpdateListener updateListener = new UpdateListener(this, promise);
        this.mUpdateListeners.add(updateListener);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(str, "updateApiHippy", updateListener);
    }

    @HippyMethod(name = "updateKuiklyBundle")
    public void updateKuiklyBundle(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UpdateKuiklyListener updateKuiklyListener = new UpdateKuiklyListener(this, promise);
        this.mUpdateKuiklyListeners.add(updateKuiklyListener);
        ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(str, updateKuiklyListener);
    }
}
