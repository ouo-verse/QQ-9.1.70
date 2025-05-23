package com.tencent.qqmini.v8rt.engine;

import java.util.ArrayList;

/* loaded from: classes23.dex */
public class JsEngineProvider extends ArrayList<IJsEngine> {
    public static final String TAG = "JsEngineProvider";
    public static JsEngineProvider sInstance = new JsEngineProvider();

    public static JsEngineProvider getInstance() {
        return sInstance;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(IJsEngine iJsEngine) {
        if (iJsEngine == null) {
            Logger.e(TAG, "null engine");
            return false;
        }
        if (contains(iJsEngine)) {
            Logger.w(TAG, iJsEngine + " already added");
            return false;
        }
        return super.add((JsEngineProvider) iJsEngine);
    }
}
