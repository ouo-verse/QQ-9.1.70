package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.core.utils.f;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.d;
import com.tencent.qqmini.v8rt.engine.LibLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8rtSoLoader implements LibLoader {
    public static final String LOG_TAG = "V8rtSoLoader";

    @Override // com.tencent.qqmini.v8rt.engine.LibLoader
    public boolean loadSo() {
        boolean booleanValue = f.a("100141", "use_scriptx", false).booleanValue();
        String miniAppV8rtPath = MiniSDKConst.getMiniAppV8rtPath();
        if (booleanValue) {
            miniAppV8rtPath = MiniSDKConst.getScriptXPath();
        }
        d.c(miniAppV8rtPath);
        System.load(miniAppV8rtPath);
        QMLog.i(LOG_TAG, "v8rt loadSo success useScript " + booleanValue);
        return true;
    }
}
