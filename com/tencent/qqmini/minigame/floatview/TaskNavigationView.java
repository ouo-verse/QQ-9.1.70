package com.tencent.qqmini.minigame.floatview;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TaskNavigationView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f346390d;

    /* renamed from: e, reason: collision with root package name */
    private Button f346391e;

    /* renamed from: f, reason: collision with root package name */
    private MiniAppInfo f346392f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f346393h;

    public TaskNavigationView(Context context) {
        super(context);
        f();
    }

    private void c() {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.TaskNavigationView.1
            @Override // java.lang.Runnable
            public void run() {
                final MiniAppInfo e16 = TaskNavigationView.e(TaskNavigationView.this.f346392f.launchParam.taskAppId);
                if (e16 == null) {
                    return;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.TaskNavigationView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyPageProxy hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class);
                        if (hippyPageProxy == null) {
                            return;
                        }
                        hippyPageProxy.setRoundDrawable(TaskNavigationView.this.f346390d, e16.iconUrl);
                    }
                });
            }
        });
    }

    private Activity d() {
        WeakReference<Activity> weakReference = this.f346393h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static MiniAppInfo e(String str) {
        byte[] idInfo;
        try {
            MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
            if (miniAppCacheProxy != null && (idInfo = miniAppCacheProxy.getIdInfo(str, "")) != null) {
                INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
                iNTERFACE$StApiAppInfo.mergeFrom(idInfo);
                return MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            }
            return null;
        } catch (Throwable th5) {
            QMLog.e("floatBox.TaskNavigationView", "getCacheAppInfo error,", th5);
            return null;
        }
    }

    private void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_game_back_layout, (ViewGroup) this, true);
        this.f346390d = (ImageView) findViewById(R.id.iv_game_icon);
        Button button = (Button) findViewById(R.id.btn_back_2_game);
        this.f346391e = button;
        button.setOnClickListener(this);
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity d16;
        EventCollector.getInstance().onViewClickedBefore(view);
        MiniAppInfo miniAppInfo = this.f346392f;
        if (miniAppInfo != null && miniAppInfo.launchParam != null && (d16 = d()) != null && view == this.f346391e) {
            LaunchParam launchParam = this.f346392f.launchParam;
            launchParam.isCloseGameBox = true;
            MiniAppLauncher.launchMiniApp(d16, launchParam.taskAppId, launchParam, (ResultReceiver) null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setActivity(Activity activity) {
        this.f346393h = new WeakReference<>(activity);
    }

    public void setAppInfo(MiniAppInfo miniAppInfo) {
        this.f346392f = miniAppInfo;
    }

    public TaskNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }
}
