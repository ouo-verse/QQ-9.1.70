package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
/* loaded from: classes23.dex */
public class OrientationJsPlugin extends BaseJsPlugin {
    public static final String EVENT_ORIENTATION_CHANGE = "onDeviceOrientationChange";
    private static final String TAG = "OrientationJsPlugin";
    private String lastOrientation;
    private OrientationEventListener mOrientationListener;

    /* loaded from: classes23.dex */
    public class GameOrientationListener extends OrientationEventListener {
        public GameOrientationListener(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            String str;
            if (i3 == -1) {
                return;
            }
            if (i3 <= 350 && i3 >= 10) {
                if (i3 > 80 && i3 < 100) {
                    str = "landscapeReverse";
                } else if (i3 > 170 && i3 < 190) {
                    str = null;
                } else if (i3 > 260 && i3 < 280) {
                    str = "landscape";
                } else {
                    return;
                }
            } else {
                str = "portrait";
            }
            if (str != null && !str.equals(OrientationJsPlugin.this.lastOrientation)) {
                OrientationJsPlugin.this.lastOrientation = str;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", str);
                } catch (JSONException e16) {
                    QMLog.e(OrientationJsPlugin.TAG, "OrientationChange call back error:" + e16.toString());
                }
                OrientationJsPlugin.this.sendSubscribeEvent(OrientationJsPlugin.EVENT_ORIENTATION_CHANGE, jSONObject.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOrientationListener(Activity activity) {
        if (activity == null) {
            return;
        }
        GameOrientationListener gameOrientationListener = new GameOrientationListener(activity, 3);
        this.mOrientationListener = gameOrientationListener;
        if (gameOrientationListener.canDetectOrientation()) {
            QMLog.i(TAG, "can detect orientation, start listening Orientation change");
            this.mOrientationListener.enable();
        } else {
            QMLog.i(TAG, "can not detect orientation");
            this.mOrientationListener.disable();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        ThreadManager.runComputationTask(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.OrientationJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OrientationJsPlugin orientationJsPlugin = OrientationJsPlugin.this;
                    orientationJsPlugin.initOrientationListener(((BaseJsPlugin) orientationJsPlugin).mMiniAppContext.getAttachedActivity());
                } catch (Exception e16) {
                    QMLog.e(OrientationJsPlugin.TAG, "initOrientationListener failed.", e16);
                }
            }
        });
    }
}
