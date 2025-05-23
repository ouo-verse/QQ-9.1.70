package com.tencent.gamematrix.gmcg.sdk.impl;

import android.hardware.usb.UsbDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgSessionCfg;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.GmCgTVPlaySessionListener;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayTextureView;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayView;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgTVPlaySessionViewHolder;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GamepadController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.GamepadPerfInfo;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapListener;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes6.dex */
public class CGTVPlaySessionImpl extends CGPlaySessionImpl implements ITVPlaySession {
    private static final int SDK_TO_VIRTUAL_JOYSTICK_PAGE_DESTROY = 13;
    private static final int SDK_TO_VIRTUAL_JOYSTICK_QUALITY_CONFIGS = 15;
    private static final int SDK_TO_VIRTUAL_JOYSTICK_QUALITY_SET = 16;
    private static final int SDK_TO_VIRTUAL_JOYSTICK_RELEASE = 12;
    private static final int SDK_TO_VIRTUAL_JOYSTICK_STOP = 11;
    private static final int SDK_TO_VIRTUAL_JOYSTICK_VIP_LEVEL = 14;
    public static final String TEST_VIRTUAL_GAMEPAD_URL = "https://test2.guyu.qq.com/api/qrcode";
    public static final String VIRTUAL_GAMEPAD_URL = "https://m.gamematrix.qq.com/api/qrcode";
    private GamepadController mGamepadController;
    private GmCgTVPlaySessionListener mGmCgTVPlaySessionListener;
    private boolean mVirtualGamepadConnected = false;
    private boolean mIsSendQualityCfg = false;
    private List<IGamepadController.StreamQualityCfg> mStreamQualityConfigs = null;
    private int mCurrentQualityEnabledId = -1;

    public CGTVPlaySessionImpl() {
        this.mGameConfigInfo = new GmCgGameConfigInfo();
        this.mPlaySessionViewHolder = new GmCgTVPlaySessionViewHolder();
    }

    private void clearPlayState() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.unregisterKeyMapListener();
            this.mGamepadController.clearGamepadControllerState();
        }
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.unregisterTVPlaySessionInputListener();
        }
    }

    public static CGTVPlaySessionImpl create(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        CGTVPlaySessionImpl cGTVPlaySessionImpl = new CGTVPlaySessionImpl();
        cGTVPlaySessionImpl.mAllocatorCfg = gmCgAllocatorCfg;
        cGTVPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGTVPlaySessionImpl.mDeviceReadyToUse = null;
        cGTVPlaySessionImpl.mCgGameId = gmCgAllocatorCfg.pCgGameId;
        WebRTCSDK.enableSeiExtension(true);
        cGTVPlaySessionImpl.init(gmCgPlayView);
        return cGTVPlaySessionImpl;
    }

    @Deprecated
    public static CGTVPlaySessionImpl createFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        CGTVPlaySessionImpl cGTVPlaySessionImpl = new CGTVPlaySessionImpl();
        cGTVPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGTVPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGTVPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        cGTVPlaySessionImpl.init(gmCgPlayView);
        return cGTVPlaySessionImpl;
    }

    private void initInternal() {
        this.mGamepadController = new GamepadController(this.mContext.getApplicationContext(), this);
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null) {
            tVInputManager.registerTVPlaySessionInputListener(new ITVInputListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGTVPlaySessionImpl.1
                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public boolean isGamepad(int i3) {
                    return true;
                }

                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public boolean isTvController(int i3) {
                    return true;
                }

                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public void onInputDeviceChanged(int i3, int i16, IGameController iGameController) {
                    String str;
                    if (CGTVPlaySessionImpl.this.mSessionMonitor != null && i3 == 2) {
                        if (iGameController != null) {
                            str = iGameController.getName();
                            CGTVPlaySessionImpl.this.mSessionMonitor.reportTVGamepadStatus("Gamepad", i16, str);
                        } else {
                            str = null;
                        }
                        CGLog.i("gamepad changed state = " + i16 + " name = " + str);
                    }
                    if (CGTVPlaySessionImpl.this.mGmCgTVPlaySessionListener != null && iGameController != null) {
                        CGLog.i("gamepad changed state = " + i16 + " ProductId = " + iGameController.getProductId());
                        CGTVPlaySessionImpl.this.mGmCgTVPlaySessionListener.onDeviceChange(i16, iGameController.getProductId());
                    }
                }

                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public void onInputEventNotify(int i3, int i16, int i17) {
                    Toast.makeText(CGTVPlaySessionImpl.this.mContext, TVInputManager.getInstance().getInputEventMessage(i3, i16, i17), 0).show();
                }

                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public void onGamepadPerfUpdate(GamepadPerfInfo gamepadPerfInfo) {
                }

                @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener
                public void onUsbDevicePermissionResult(UsbDevice usbDevice, boolean z16) {
                }
            });
        }
    }

    private void sendStreamQualityConfigs() {
        try {
            if (this.mStreamQualityConfigs != null && this.mWebRTCSdk != null) {
                String json = new Gson().toJson(this.mStreamQualityConfigs);
                if (json != null) {
                    CGLog.i("vgamepad config is = " + json);
                    this.mWebRTCSdk.sendVirtualGamepadEvent(15, json);
                } else {
                    CGLog.i("vgamepad config is null");
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public int getConfigValue(int i3) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.getConfigValue(i3);
        }
        return -1;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public int getGameType() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.getGameType();
        }
        return 1;
    }

    public WebRTCSDK getWebRTCSdk() {
        return this.mWebRTCSdk;
    }

    protected void init(GmCgPlayView gmCgPlayView) {
        super.init(gmCgPlayView, null);
        initInternal();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl
    protected void initPlayView(GmCgPlayView gmCgPlayView, FrameLayout frameLayout) {
        if (frameLayout != null) {
            GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
            this.mPlaySessionViewHolder = new GmCgTVPlaySessionViewHolder(frameLayout, gmCgSessionCfg.pUseCustomLoadingView, gmCgSessionCfg.pEnableExtraInfoOverlay, gmCgSessionCfg.pExtraInfoOverlayRightOrLeft, gmCgSessionCfg.pExtraInfoOverLayBottomOrTop);
        } else if (gmCgPlayView != null) {
            this.mPlaySessionViewHolder = new GmCgTVPlaySessionViewHolder(gmCgPlayView);
        } else {
            throw new IllegalArgumentException("no play view or container view");
        }
        this.mContext = this.mPlaySessionViewHolder.getContext();
        this.mPlaySessionViewHolder.setPlayScreenOrientation(this.mSessionCfg.pGameScreenOrientation);
        this.mPlaySessionViewHolder.onBaseInfoUpdate(CGGlbConfig.getUserId(), this.mCgGameId);
        WebRTCSDK.enableHidSensor(true);
        WebRTCSDK.setSkipRender(true);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean isSupportMonitorConfig() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.isSupportMonitorConfig();
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean isSupportTGPAConfig() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.isSupportTGPAConfig();
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl
    protected boolean isTv() {
        return true;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void loadGameSceneForSDKScene(int i3, boolean z16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.loadGameSceneFromSDKScene(i3, z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean loadGameSceneFromMonitor(int i3, String str, boolean z16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.loadGameSceneFromMonitor(i3, str, z16);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean loadGameSceneFromTGPA(String str) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.loadGameSceneFromTGPA(str);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean loadKeyMapConfig(String str, String str2) {
        if (this.mGamepadController != null) {
            this.mGamepadController.pullAndLoadConfig(this.mContext, str, CGServerProvider.get().urlOfGetTVGameConfig(str, str2));
            return true;
        }
        return true;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onClientConnectionMsgData(int i3, int i16, String str, String str2, int i17) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.sendClientConnectionMessage(i3, i16, str, str2, i17);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventDataChannelConnected(String str) {
        super.onEventDataChannelConnected(str);
        GmCgTVPlaySessionListener gmCgTVPlaySessionListener = this.mGmCgTVPlaySessionListener;
        if (gmCgTVPlaySessionListener != null) {
            gmCgTVPlaySessionListener.onDataChannelConnected();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventFinishInput() {
        super.onEventFinishInput();
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onStartInput(false);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventStartInput() {
        super.onEventStartInput();
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onStartInput(true);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void onFirstFrameRendered() {
        Vector<IGameController> gameControllers;
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onFirstFrameRendered(this.mPlaySessionViewHolder.getPlayRenderView());
        }
        if (this.mSessionMonitor != null) {
            TVInputManager tVInputManager = TVInputManager.getInstance();
            String str = null;
            if (tVInputManager != null && (gameControllers = tVInputManager.getGameControllers(1)) != null) {
                Iterator<IGameController> it = gameControllers.iterator();
                while (it.hasNext()) {
                    IGameController next = it.next();
                    if (next != null && (next.getDeviceType() == 2 || next.getDeviceType() == 4)) {
                        if (str == null) {
                            str = next.getName();
                        } else {
                            str = (str + "__") + next.getName();
                        }
                    }
                }
            }
            reportTVGamepadStatus("Gamepad", 0, str);
            CGLog.i("gamepad changed state = 0 name = " + str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.onGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl
    protected void onImeInputEventHide() {
        CGLog.i("tv onImeInputEventHide");
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onStartInput(false);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.onKeyDown(i3, keyEvent);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.onKeyUp(i3, keyEvent);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void onLoginView(boolean z16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.setInLoginView(!z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onVirtualGamepadMsgData(int i3, int i16, String str) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.sendVirtualGamepadMessage(i3, i16, str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void registerKeyMapListener(IKeyMapListener iKeyMapListener) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.registerKeyMapListener(iKeyMapListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void releasePlay() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendVirtualGamepadEvent(12, 0);
        }
        super.releasePlay();
        clearPlayState();
        TVInputManager.getInstance().resetGameConfigState();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession
    public void reportTVGamepadStatus(String str, int i3, String str2) {
        if (this.mSessionMonitor != null) {
            CGLog.i("reportstatus=" + str + " errorCode=" + i3 + " msg=" + str);
            this.mSessionMonitor.reportTVGamepadStatus(str, i3, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void requestVirtualGamepad() {
        if (this.mGamepadController != null) {
            if (CGServerProvider.getServerType() == 1) {
                this.mGamepadController.setVirtualGamepadUrl(TEST_VIRTUAL_GAMEPAD_URL);
            } else {
                this.mGamepadController.setVirtualGamepadUrl(VIRTUAL_GAMEPAD_URL);
            }
            GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
            if (gmCgDeviceInfo != null) {
                this.mGamepadController.setServerUrl(gmCgDeviceInfo.getWebrtcUrl());
            }
        }
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendVirtualGamepadRequest();
        }
    }

    public void setGmCgTVPlaySessionListener(GmCgTVPlaySessionListener gmCgTVPlaySessionListener) {
        this.mGmCgTVPlaySessionListener = gmCgTVPlaySessionListener;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setKeyTrackMenuEnabled(boolean z16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.setKeyTracMenukEnabled(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public GmCgGameStreamQualityCfg setPlayStreamQuality(int i3) {
        List<IGamepadController.StreamQualityCfg> list = this.mStreamQualityConfigs;
        if (list != null) {
            for (IGamepadController.StreamQualityCfg streamQualityCfg : list) {
                if (streamQualityCfg.pId == i3) {
                    streamQualityCfg.pIsSelected = true;
                } else {
                    streamQualityCfg.pIsSelected = false;
                }
            }
        }
        return super.setPlayStreamQuality(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setPlayStreamQualityToVGamepad(int i3) {
        CGLog.i("vgamepad set quality = " + i3);
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendVirtualGamepadEvent(16, i3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void startPlay() {
        CGGlbConfig.forceHwDec(true);
        super.startPlay();
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.checkAndOpenMFGamepad();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void stopPlay() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendVirtualGamepadEvent(11, 0);
        }
        super.stopPlay();
        clearPlayState();
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.closeMFGamepad();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void unregisterKeyMapListener() {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.unregisterKeyMapListener();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean updateStreamQualityCfgsToVGamepad(int i3, List<IGamepadController.StreamQualityCfg> list) {
        this.mCurrentQualityEnabledId = i3;
        this.mStreamQualityConfigs = list;
        if (this.mVirtualGamepadConnected) {
            sendStreamQualityConfigs();
            return true;
        }
        return true;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void updateWebRTCSDK(WebRTCSDK webRTCSDK) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.setWebRTCSDK(webRTCSDK);
        }
    }

    protected void init(GmCgPlayTextureView gmCgPlayTextureView) {
        super.initForTextureView(gmCgPlayTextureView, null);
        initInternal();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onVirtualGamepadMsgData(int i3, int i16, int i17, int i18) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.sendVirtualGamepadMessage(i3, i16, i17, i18);
        }
        if (2 == i3) {
            this.mVirtualGamepadConnected = true;
            sendStreamQualityConfigs();
        } else if (4 == i3) {
            this.mVirtualGamepadConnected = false;
        } else if (7 == i3) {
            this.mVirtualGamepadConnected = false;
        }
    }

    @Deprecated
    public static CGTVPlaySessionImpl createFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayTextureView gmCgPlayTextureView) {
        CGTVPlaySessionImpl cGTVPlaySessionImpl = new CGTVPlaySessionImpl();
        cGTVPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGTVPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGTVPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        cGTVPlaySessionImpl.init(gmCgPlayTextureView);
        return cGTVPlaySessionImpl;
    }

    public static CGTVPlaySessionImpl create(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayTextureView gmCgPlayTextureView) {
        CGTVPlaySessionImpl cGTVPlaySessionImpl = new CGTVPlaySessionImpl();
        cGTVPlaySessionImpl.mAllocatorCfg = gmCgAllocatorCfg;
        cGTVPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGTVPlaySessionImpl.mDeviceReadyToUse = null;
        cGTVPlaySessionImpl.mCgGameId = gmCgAllocatorCfg.pCgGameId;
        cGTVPlaySessionImpl.init(gmCgPlayTextureView);
        return cGTVPlaySessionImpl;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void requestDoubleVirtualGamepad() {
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl, com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setKeyMapViewVisibility(boolean z16) {
    }
}
