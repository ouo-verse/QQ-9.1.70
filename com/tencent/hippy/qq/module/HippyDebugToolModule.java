package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyDebugSoUtil;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = HippyDebugToolModule.CLASSNAME)
/* loaded from: classes7.dex */
public class HippyDebugToolModule extends QQBaseModule {
    static final String CLASSNAME = "DebugTool";

    public HippyDebugToolModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableDebugModule$0() {
        HippyDebugSoUtil.switchToDebugSo(getActivity());
    }

    @HippyMethod(name = "clearAllFontCache")
    public void clearAllFontCache(final Promise promise) {
        final String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
        if (TextUtils.isEmpty(hippyFontRootDir)) {
            promise.reject("success");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.HippyDebugToolModule.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.open.base.c.b(new File(hippyFontRootDir))) {
                        promise.reject("success");
                    } else {
                        promise.reject("fail");
                    }
                }
            }, 64, null, true);
        }
    }

    @HippyMethod(name = "deleteModule")
    public void deleteModule(String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            promise.resolve(Boolean.valueOf(HippyDebugUtil.deleteModule(jSONObject.optString("moduleName"), Integer.parseInt(jSONObject.optString("version")))));
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }

    @HippyMethod(name = "enableDebugModule")
    public void enableDebugModule(String str, Promise promise) {
        boolean z16;
        try {
            if (!TextUtils.isEmpty(str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            HippyDebugUtil.enableDebug(z16);
            HippyDebugUtil.enableDebugModule(str);
            if (z16 && !HippyDebugSoUtil.isUseDebugSo()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        HippyDebugToolModule.this.lambda$enableDebugModule$0();
                    }
                });
            }
            promise.resolve("success");
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }

    @HippyMethod(name = "enableDebugPort")
    public void enableDebugPort(String str, Promise promise) {
        try {
            HippyDebugUtil.enableDebugPort(str);
            promise.resolve("success");
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }

    @HippyMethod(name = "getDebugModule")
    public void getDebugModule(Promise promise) {
        try {
            String hippyBundleName = HippyDebugUtil.getHippyBundleName();
            String hippyServerHost = HippyDebugUtil.getHippyServerHost();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("module", hippyBundleName);
            jSONObject.put("server", hippyServerHost);
            promise.resolve(jSONObject.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }

    @HippyMethod(name = "getLibraryVersions")
    public void getLibraryVersions(Promise promise) {
        try {
            HashMap<String, String> libraryVersions = HippyDebugUtil.getLibraryVersions();
            HippyMap hippyMap = new HippyMap();
            for (Map.Entry<String, String> entry : libraryVersions.entrySet()) {
                hippyMap.pushString(entry.getKey(), entry.getValue());
            }
            promise.resolve(hippyMap);
        } catch (Exception unused) {
            promise.reject("error");
        }
    }

    @HippyMethod(name = "getModuleInfo")
    public void getModuleInfo(String str, Promise promise) {
        try {
            promise.resolve(HippyDebugUtil.getModuleInfo(str).toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }

    @HippyMethod(name = "getModules")
    public void getModules(Promise promise) {
        try {
            promise.resolve(HippyDebugUtil.getHippyModules().toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.reject("error");
        }
    }
}
