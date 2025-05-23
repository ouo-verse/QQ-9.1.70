package com.tencent.mobileqq.minigame.ui.controller;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class BaseGameActController {
    private static final String TAG = "BaseGameActController";
    protected GameActivity1 mActivity;
    private ColorNotePlugin.a mAddColorSingListener;
    private IColorNoteController mColorNoteController;
    private String mColorNoteQueryPath;
    private o mColorNoteServiceListener;
    protected MiniAppInfo mMiniAppInfo;
    protected ViewGroup mRootView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseGameActController(GameActivity1 gameActivity1, ViewGroup viewGroup) {
        this.mActivity = gameActivity1;
        this.mRootView = viewGroup;
    }

    public abstract void doOnActivityResult(int i3, int i16, Intent intent);

    public abstract void doOnBackPressed();

    public abstract void doOnConfigurationChanged(Configuration configuration);

    public abstract void doOnCreate(Bundle bundle, Intent intent);

    public void doOnDestroy() {
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
        }
    }

    public abstract boolean doOnKeyDown(int i3, KeyEvent keyEvent);

    public abstract void doOnNewIntent(Intent intent);

    public void doOnPause() {
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    public void doOnResume() {
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }

    public abstract void doOnStart();

    public abstract void doOnStop();

    public abstract void doRefreshMiniBadge(Bundle bundle);

    public IColorNoteController getColorNoteController() {
        return this.mColorNoteController;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    public abstract void hideMiniAIOEntrance();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initColorNote() {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.mColorNoteController = iColorNoteController;
        iColorNoteController.init(this.mActivity, false, true);
        this.mColorNoteController.attachToActivity(this.mActivity);
        this.mColorNoteController.setServiceInfo(new f() { // from class: com.tencent.mobileqq.minigame.ui.controller.BaseGameActController.1
            @Override // com.tencent.mobileqq.colornote.f
            public ColorNote getColorNote() {
                if (BaseGameActController.this.mMiniAppInfo == null) {
                    QLog.e(BaseGameActController.TAG, 1, "getColorNote, miniAppInfo is null!");
                    return null;
                }
                QLog.d(BaseGameActController.TAG, 2, "getColorNote, appId: " + BaseGameActController.this.mMiniAppInfo.appId + ", name: " + BaseGameActController.this.mMiniAppInfo.name + ", colorNoteQueryPath: " + BaseGameActController.this.mColorNoteQueryPath);
                return new ColorNote.a().g(R.attr.theme).i(BaseGameActController.this.mMiniAppInfo.appId + "#@#" + BaseGameActController.this.mMiniAppInfo.verType).d(BaseGameActController.this.mMiniAppInfo.name).h(BaseGameActController.this.mMiniAppInfo.desc).e(BaseGameActController.this.mMiniAppInfo.iconUrl).f(BaseGameActController.this.mColorNoteQueryPath != null ? BaseGameActController.this.mColorNoteQueryPath.getBytes() : null).a();
            }
        });
        this.mColorNoteController.setOnColorNoteAnimFinishListener(new ha1.a() { // from class: com.tencent.mobileqq.minigame.ui.controller.BaseGameActController.2
            @Override // ha1.a
            public void onColorNoteAnimFinish() {
                BaseGameActController.this.doOnBackPressed();
                BaseGameActController.this.mActivity.overridePendingTransition(0, 0);
            }
        });
        this.mColorNoteController.setOnColorNoteCurdListener(new g() { // from class: com.tencent.mobileqq.minigame.ui.controller.BaseGameActController.3
            @Override // com.tencent.mobileqq.colornote.g
            public void onAddColorNote(Bundle bundle, boolean z16) {
                super.onAddColorNote(bundle, z16);
                QLog.e(BaseGameActController.TAG, 1, "[ColorNote exist] serviceType:", Integer.valueOf(bundle.getInt(ColorNote.PARAM_SERVICETYPE)), " subType:", bundle.getString(ColorNote.PARAM_SUBTYPE));
                if (BaseGameActController.this.mAddColorSingListener != null) {
                    BaseGameActController.this.mAddColorSingListener.a(z16);
                    BaseGameActController.this.mAddColorSingListener = null;
                }
                BaseGameActController.this.doOnBackPressed();
            }

            @Override // com.tencent.mobileqq.colornote.g
            public void onDeleteColorNote(int i3, String str, boolean z16) {
                super.onDeleteColorNote(i3, str, z16);
                MiniAppConfig miniAppConfig = BaseGameActController.this.mMiniAppInfo != null ? new MiniAppConfig(MiniSdkLauncher.convert(BaseGameActController.this.mMiniAppInfo)) : null;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    if (miniAppConfig != null) {
                        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
                        return;
                    } else {
                        MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
                        return;
                    }
                }
                if (miniAppConfig != null) {
                    MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "addColorSign", "colorSign_enter", "remove_ColorSign", null);
                } else {
                    MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
                }
            }
        });
        o oVar = new o() { // from class: com.tencent.mobileqq.minigame.ui.controller.BaseGameActController.4
            @Override // com.tencent.mobileqq.colornote.smallscreen.o
            public void onServiceSyncSucc(boolean z16) {
                ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
            }
        };
        this.mColorNoteServiceListener = oVar;
        this.mColorNoteController.setServiceSyncListener(oVar);
    }

    public abstract void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    public void setColorNoteQueryPath(String str) {
        this.mColorNoteQueryPath = str;
    }

    public void setColorSignAddListener(ColorNotePlugin.a aVar) {
        this.mAddColorSingListener = aVar;
    }

    public abstract boolean showMiniAIOEntrance(JSONObject jSONObject);
}
