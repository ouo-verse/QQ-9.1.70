package com.tencent.pts.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes22.dex */
public class PTSActivity extends Activity {
    static IPatchRedirector $redirector_ = null;
    public static final String ANIMATION_JS_KEY = "com.tencent.pts.core.AnimationJs";
    public static final String BIND_DATA_JS_KEY = "com.tencent.pts.core.BindDataJs";
    public static final String FRAME_TREE_JSON_KEY = "com.tencent.pts.core.FrameTreeJson";
    public static final String PAGE_JS_KEY = "com.tencent.pts.core.PageJs";
    public static final String PAGE_NAME_KEY = "com.tencent.pts.core.PageName";
    public static final String TAG = "PTSActivity";
    public static final String[] parameters;
    PTSAppInstance mPTSAppInstance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            parameters = new String[]{PAGE_NAME_KEY, FRAME_TREE_JSON_KEY, PAGE_JS_KEY, BIND_DATA_JS_KEY, ANIMATION_JS_KEY};
            System.loadLibrary("ptslite");
        }
    }

    public PTSActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getParameter(String str) {
        if (getIntent() == null) {
            return "";
        }
        return getIntent().getStringExtra(str);
    }

    private boolean isParametersAvailable() {
        for (String str : parameters) {
            if (TextUtils.isEmpty(getParameter(str))) {
                PTSLog.e(TAG, "[isParametersAvailable], key = " + str + ", is null.");
                return false;
            }
        }
        return true;
    }

    public static void startNewPage(Context context, Bundle bundle) {
        if (context != null && bundle != null) {
            Intent intent = new Intent(context, (Class<?>) PTSActivity.class);
            for (String str : parameters) {
                intent.putExtra(str, bundle.getString(str, ""));
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (!isParametersAvailable()) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        setContentView(linearLayout);
        PTSAppInstance build = new PTSAppInstance.Builder().withContext(this).withRootView(linearLayout).withRootNodeType(0).withPTSJSBridge(PTSJSBridgeManager.getInstance().getJSBridge(this, getParameter(BIND_DATA_JS_KEY), getParameter(ANIMATION_JS_KEY))).withPageName(getParameter(PAGE_NAME_KEY)).withFrameTreeJson(getParameter(FRAME_TREE_JSON_KEY)).withPageJs(getParameter(PAGE_JS_KEY)).build();
        this.mPTSAppInstance = build;
        build.onCreate();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        this.mPTSAppInstance.onDestroy();
        PTSJSBridgeManager.getInstance().destroyJSBridge(this);
    }

    @Override // android.app.Activity
    protected void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onPause();
            this.mPTSAppInstance.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onResume();
            this.mPTSAppInstance.onResume();
        }
    }
}
