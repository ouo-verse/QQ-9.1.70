package com.tencent.qqmini.v8rt.engine;

import android.text.TextUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsRuntimeLoader {
    public static final String[] BASIC_JS = {"console.js", "timer.js"};
    static final String CLEAN_GLOBAL = "(function () {\nvar tt = global.__ttObjdec__;\n  if (tt && tt.Triton == undefined) {\n    tt.Triton = Triton;//\u5b58\u5230__ttObjdec__\u4e2d\u53bb\uff0c\u4fdd\u8bc1JSSDK\u53ef\u4ee5\u4f7f\u7528\u5b83\n    try {\n      Triton = undefined;//\u5c06\u5176\u4ece\u5168\u5c40\u4f5c\u7528\u57df\u5e72\u6389\uff0c\u4f7f\u5f97\u4e1a\u52a1\u4ee3\u7801\u4e0d\u80fd\u8bbf\u95ee\n    } catch (error) {\n    }\n  }\n})();";
    public static final String CODE_CACHE_SUFFIX = ".cc";
    static final String GLOBAL_CONFIG = "self = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = self.__ttObjdec__ || {};\nself.wx = self.wx || {};\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {}\n__wxConfig.env.USER_DATA_PATH = \"wxfile://usr\";\n__wxConfig.platform = \"android\";\nwx.env = __wxConfig.env;\n";
    public static final String LOG_TAG = "JsRuntimeLoader";
    private static final String __FILESYSTEM_PREFIX__ = "wxfile://";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cleanGlobal(V8JsContext v8JsContext) {
        if (!TextUtils.isEmpty(CLEAN_GLOBAL)) {
            v8JsContext.evaluateJsSync(CLEAN_GLOBAL);
            Logger.i(LOG_TAG, "cleanGlobalEnv " + v8JsContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean initDefaultContext(EnginePathProvider enginePathProvider, V8JsContext v8JsContext) {
        injectGlobalConfig(v8JsContext);
        injectBasicJsForContext(enginePathProvider, v8JsContext);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void injectBasicJs(EnginePathProvider enginePathProvider, String[] strArr, V8JsContext v8JsContext) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            String str2 = enginePathProvider.getEngineJSDir() + File.separator + str;
            Logger.i(LOG_TAG, "inject " + str2 + "," + v8JsContext + ",ccstat:" + Engine.loadScriptPathWithCodeCache(v8JsContext.getV8JsRuntime().getId(), v8JsContext.getContextId(), str2, "engine_base_" + str, str2 + CODE_CACHE_SUFFIX));
        }
    }

    private static void injectBasicJsForContext(EnginePathProvider enginePathProvider, V8JsContext v8JsContext) {
        injectBasicJs(enginePathProvider, BASIC_JS, v8JsContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void injectGlobalConfig(V8JsContext v8JsContext) {
        if (!TextUtils.isEmpty(GLOBAL_CONFIG)) {
            v8JsContext.evaluateJsSync(GLOBAL_CONFIG);
            Logger.i(LOG_TAG, "injectGlobalConfig " + v8JsContext);
        }
    }
}
