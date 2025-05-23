package com.tencent.mobileqq.minigame.publicaccount.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameArkView extends RelativeLayout implements IHeaderView, ArkViewImplement.LoadCallback {
    public static final int STATE_VIDEO_ARK_INVISIBLE = 102;
    public static final int STATE_VIDEO_ARK_VISIBLE = 101;
    private static final String TAG = "GameArkView";
    private String appName;
    private ArkView arkView;
    private View arkViewContainer;
    private boolean isPrePause;
    private int mCurArkState;
    private QQGameMsgInfo mGameMsgInfo;
    private WeakReference<LoadGameArkCallback> mLoadCallbackRef;
    private int mPosition;
    private String mPubType;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface LoadGameArkCallback {
        void onLoadFinish(int i3, int i16);
    }

    public GameArkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPrePause = true;
        this.mCurArkState = 101;
        this.mLoadCallbackRef = new WeakReference<>(null);
        LayoutInflater.from(getContext()).inflate(R.layout.dk9, this);
        this.arkViewContainer = findViewById(R.id.rkp);
        this.arkView = (ArkView) findViewById(R.id.rko);
        try {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            float f16 = FontSettingManager.systemMetrics.density;
            if (displayMetrics != null) {
                float min = Math.min(f16, displayMetrics.density);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "min density= " + min);
                }
                this.arkView.setScaleDensity(min);
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 4, "set ark density fail:" + th5.getMessage());
        }
    }

    public void destory() {
        ArkView arkView = this.arkView;
        if (arkView != null) {
            arkView.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public String getAppName() {
        return this.appName;
    }

    public ArkView getArkView() {
        return this.arkView;
    }

    public View getArkViewContainer() {
        return this.arkViewContainer;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void init(MessageRecord messageRecord, Activity activity) {
        MessageForArkApp messageForArkApp;
        ArkView arkView = this.arkView;
        if (arkView == null || (messageForArkApp = (MessageForArkApp) messageRecord) == null) {
            return;
        }
        ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
        String str = arkAppMessage.appName;
        this.appName = str;
        arkView.load(str, arkAppMessage.appView, arkAppMessage.bizSrc, arkAppMessage.appMinVersion, arkAppMessage.metaList, arkAppMessage.config, this);
    }

    public boolean isVisible() {
        return this.mCurArkState == 101;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void onDestory() {
        if (this.arkView != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "GameArkView onDestory");
            }
            this.arkView.onDestroy();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadFailed(int i3, int i16, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onLoadFailed state=" + i3 + "|errCode=" + i16 + "|errMsg=" + str + "|canRetry=" + z16);
        }
        LoadGameArkCallback loadGameArkCallback = this.mLoadCallbackRef.get();
        if (loadGameArkCallback != null) {
            loadGameArkCallback.onLoadFinish(i3, this.mPosition);
        }
        GamePubAccountHelper.r(this.mPubType).setModuleType("76918").setOperId("207984").setExt(2, this.mGameMsgInfo.advId).setGameAppId(this.mGameMsgInfo.gameAppId).setExt(18, this.mGameMsgInfo.arkAppName).setExt(19, i3 + "").setExt(20, i16 + "").setExt(21, str).setExt(22, z16 + "").report();
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadState(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onLoadState state=" + i3);
        }
        LoadGameArkCallback loadGameArkCallback = this.mLoadCallbackRef.get();
        if (loadGameArkCallback != null) {
            loadGameArkCallback.onLoadFinish(i3, this.mPosition);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.view.GameArkView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (GamePubAccountHelper.E(GameArkView.this.appName) && GameArkView.this.isPrePause && GameArkView.this.arkView != null) {
                        GameArkView.this.arkView.onPause();
                    }
                } catch (Throwable th5) {
                    QLog.d(GameArkView.TAG, 4, "-->onLoadState init arkview faile:" + th5.getMessage());
                }
            }
        }, 500L);
        GamePubAccountHelper.r(this.mPubType).setModuleType("76918").setOperId("207984").setExt(2, this.mGameMsgInfo.advId).setGameAppId(this.mGameMsgInfo.gameAppId).setExt(18, this.mGameMsgInfo.arkAppName).setExt(29, i3 + "").report();
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void onPause() {
        if (this.arkView != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "GameArkView onPause");
            }
            this.mCurArkState = 102;
            this.arkView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void onResume() {
        if (this.arkView != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "GameArkView onResume");
            }
            this.mCurArkState = 101;
            this.arkView.onResume();
        }
    }

    public void setLoadCallback(LoadGameArkCallback loadGameArkCallback) {
        this.mLoadCallbackRef = new WeakReference<>(loadGameArkCallback);
    }

    public void setPrePause(boolean z16) {
        this.isPrePause = z16;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void init(QQGameMsgInfo qQGameMsgInfo, Activity activity, int i3, String str) {
        this.mPosition = i3;
        this.mPubType = str;
        ArkView arkView = this.arkView;
        if (arkView != null) {
            this.mGameMsgInfo = qQGameMsgInfo;
            String str2 = qQGameMsgInfo.arkAppName;
            this.appName = str2;
            arkView.load(str2, qQGameMsgInfo.arkAppView, qQGameMsgInfo.arkAppMinVersion, qQGameMsgInfo.arkMetaList, qQGameMsgInfo.arkAppConfig, this);
        }
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
    public void onStop() {
    }
}
