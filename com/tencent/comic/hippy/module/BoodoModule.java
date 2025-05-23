package com.tencent.comic.hippy.module;

import android.app.Activity;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.comic.api.hippy.IBoodoModule;
import com.tencent.comic.data.f;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "BoodoModule")
/* loaded from: classes32.dex */
public class BoodoModule extends QQBaseWebIpcModule implements IBoodoModule {
    static final String CLASSNAME = "BoodoModule";
    private static final String TAG = "BoodoModule";
    private BoodoModuleProxy mModuleProxy;

    public BoodoModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        QLog.i("BoodoModule", 1, "BoodoModule init");
    }

    private void checkInitModule() {
        if (this.mModuleProxy == null) {
            this.mModuleProxy = BoodoHippyBirdge.createBoodoModuleImp();
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseWebIpcModule, com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        QLog.d("HippyQQComicModule", 2, "HippyQQComicModule destroy");
        f.f99361r = false;
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    public void doPromiseCallback(Promise promise, int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i3);
            jSONObject.put("message", str);
            doPromiseCallback(promise, jSONObject);
        } catch (JSONException e16) {
            QLog.e("BoodoModule", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_DOWNLOAD_COMIC)
    public void downloadComic(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_DOWNLOAD_COMIC, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    public Activity getCurrentActivity() {
        return getActivity();
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_GET_DOWNLOAD_LIST)
    public void getDownloadList(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_GET_DOWNLOAD_LIST, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    public HippyEngine getHippyEngine() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            return hippyQQEngine.getHippyEngine();
        }
        return null;
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_PAGE_GET_TRACE)
    public void getPageTrace(Promise promise) {
        checkInitModule();
        BoodoModuleProxy boodoModuleProxy = this.mModuleProxy;
        if (boodoModuleProxy != null) {
            boodoModuleProxy.callModule(this, BoodoModuleProxy.METHOD_PAGE_GET_TRACE, null, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = "getReportInfo")
    public void getReportInfo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, "getReportInfo", jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_MAIN_TAB_APPEAR)
    public void mainTabAppear(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        f.f99361r = true;
        QLog.i("BoodoModule", 1, "mainTabAppear has been called");
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_MAIN_TAB_APPEAR, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_MODIFY_DOWNLOAD_STATUS)
    public void modifyDownloadStatus(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_MODIFY_DOWNLOAD_STATUS, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_NOTIFY_WEB_STATUS)
    public void notifyWebStatus(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_NOTIFY_WEB_STATUS, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_OPEN_COMIC_INTRO)
    public void openComicIntro(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_OPEN_COMIC_INTRO, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_OPEN_DOWNLOAD_DETAIL)
    public void openDownloadDetail(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_OPEN_DOWNLOAD_DETAIL, jSONObject, promise);
        }
    }

    @HippyMethod(name = BoodoModuleProxy.METHOD_OPEN_VIDEO_ADV)
    public void openVideoAdv(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_OPEN_VIDEO_ADV, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_PAGE_POP)
    public void popPage() {
        checkInitModule();
        BoodoModuleProxy boodoModuleProxy = this.mModuleProxy;
        if (boodoModuleProxy != null) {
            boodoModuleProxy.callModule(this, BoodoModuleProxy.METHOD_PAGE_POP, null, null);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_PAGE_PUSH)
    public void pushPage(HippyMap hippyMap) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_PAGE_PUSH, jSONObject, null);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = "pushPageStack")
    public void pushPageStack(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, "pushPageStack", jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_QUERY_DOWNLOAD_PROGRESS)
    public void queryDownloadProgress(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_QUERY_DOWNLOAD_PROGRESS, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = "report")
    public void report(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, "report", jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_REPORT_01327)
    public void reportDC01327(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_REPORT_01327, jSONObject, null);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    @HippyMethod(name = BoodoModuleProxy.METHOD_START_READ)
    public void startRead(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        checkInitModule();
        if (this.mModuleProxy != null) {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            this.mModuleProxy.callModule(this, BoodoModuleProxy.METHOD_START_READ, jSONObject, promise);
        }
    }

    @Override // com.tencent.comic.api.hippy.IBoodoModule
    public void doPromiseCallback(Promise promise, JSONObject jSONObject) {
        if (promise == null || !promise.isCallback()) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(jSONObject);
        promise.resolve(hippyMap);
        if (QLog.isColorLevel()) {
            QLog.d("BoodoModule", 1, "doPromiseCallback promise:" + promise.getCallId() + " jsonObject:" + jSONObject);
        }
    }
}
