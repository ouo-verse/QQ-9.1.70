package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes22.dex */
public class PageEventListenerMgr {
    private static final Map<Object, IPageEventListener> LISTENER_MAP = new WeakHashMap();
    private static final String TAG = "PageEventListenerMgr";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifyAfterPageIn(Object obj) {
        IPageEventListener iPageEventListener;
        if (obj != null && (iPageEventListener = LISTENER_MAP.get(obj)) != null) {
            iPageEventListener.afterPageIn(obj);
        }
    }

    public static void setPageEventListener(Object obj, IPageEventListener iPageEventListener) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "setPageEventListener:, page = " + obj + ", listener = " + iPageEventListener);
        }
        if (obj == null) {
            return;
        }
        LISTENER_MAP.put(obj, iPageEventListener);
    }
}
