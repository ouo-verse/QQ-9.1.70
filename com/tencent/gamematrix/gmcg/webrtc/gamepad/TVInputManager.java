package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GameController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.GamepadPerfInfo;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputListener;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDeviceManage;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDGamepadPerf;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDInputEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDKeyEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDDeviceManageListener;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TVInputManager implements ITVInputManager, IHIDDeviceManageListener, InputManagerCompat.InputDeviceListener {
    public static final int CONFIG_INIT_INDEX_BEGINT = 0;
    public static final int DEVICE_GAMEPAD = 1;
    private static final int DEVICE_MAP_INDEX_FLAG_RESET = -1;
    public static final int DEVICE_TV_CONTROLLER = 2;
    public static final int GAMEPAD_INDEX_BEGIN = 3;
    public static final int GAMEPAD_INDEX_END = 16;
    private static final int GAME_CONTROLLER_MAX_SIZE = 32;
    public static final int TV_CONTROLLER_INDEX_BEGIN = 19;
    public static final int TV_CONTROLLER_INDEX_END = 32;
    public static final int TV_INPUT_SOURCE = 513;
    private static volatile TVInputManager sTVInputManager;
    private Set<ITVInputListener> mAppClientInputLisenerSet;
    private CloudGameDeviceContainer mCloudGameDeviceContainer;
    private final Lock mDeviceLock;
    private SparseArray<GameController> mGameControllerIds;
    private GamepadController mGamepadController;
    private HIDDeviceManage mHIDDeviceManage;
    private boolean mHasSearchInputDevices;
    private InputManagerCompat mInputManager;
    private TVBoxInfo mTVBoxInformation;
    private ITVInputListener mTVPlaySessionInputLisener;
    private boolean mEnableClientConfig = false;
    private boolean mIsMFGamepadConnected = false;
    private String mHidEventMessage = "unknown";
    private int mMapMapIndex = 0;
    private boolean mRequireResetGameConfigState = true;
    private int[] mCloudMapIndexArray = new int[32];

    public TVInputManager(Context context) {
        resetGameConfig();
        this.mGameControllerIds = new SparseArray<>();
        this.mCloudGameDeviceContainer = new CloudGameDeviceContainer();
        this.mHasSearchInputDevices = false;
        this.mDeviceLock = new ReentrantLock();
        if (this.mHIDDeviceManage == null) {
            this.mHIDDeviceManage = new HIDDeviceManage(context);
        }
        this.mInputManager = InputManagerCompat.Factory.getInputManager(context);
        this.mTVBoxInformation = new TVBoxInfo();
        init();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d9, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean addDeviceMapIndex(GameController gameController) {
        int i3;
        int i16;
        int i17;
        boolean z16 = false;
        if (gameController == null) {
            return false;
        }
        int androidDeviceId = gameController.getAndroidDeviceId();
        int vendorId = gameController.getVendorId();
        int productId = gameController.getProductId();
        int deviceType = gameController.getDeviceType();
        String name = gameController.getName();
        if (!isValidDevice(vendorId, productId, name)) {
            CGLog.i("[inputdevice] invalid device id=" + androidDeviceId + " vendorId=" + vendorId + " productId=" + productId + " name=" + name);
            return false;
        }
        if (this.mCloudMapIndexArray == null) {
            return false;
        }
        if (deviceType != 2 && deviceType != 4) {
            if (deviceType == 3) {
                i16 = 19;
                i3 = 32;
            } else {
                i16 = 0;
                i3 = 0;
            }
        } else {
            i3 = 16;
            i16 = 3;
        }
        int i18 = i16;
        while (true) {
            if (i18 >= i3) {
                break;
            }
            int i19 = this.mCloudMapIndexArray[i18];
            if (i19 != -1) {
                CGLog.i("[inputdevice] map index[" + i18 + "]=" + i19);
                if (i19 == gameController.getId()) {
                    break;
                }
                i18++;
            } else {
                int i26 = (i18 - i16) + 1;
                int createCloudDeviceMaxSize = GlobalConfig.getInstance().getCreateCloudDeviceMaxSize(deviceType);
                if (i26 < createCloudDeviceMaxSize) {
                    CGLog.i("[inputdevice] add mapping index[" + i18 + "]=" + gameController.getId());
                    this.mCloudMapIndexArray[i18] = gameController.getId();
                    gameController.setDeviceMapIndex(i18);
                    gameController.setDeviceMapIndexType(2);
                } else if (i26 >= createCloudDeviceMaxSize && createCloudDeviceMaxSize > 0) {
                    int i27 = this.mMapMapIndex;
                    this.mMapMapIndex = i27 + 1;
                    int i28 = i27 % createCloudDeviceMaxSize;
                    gameController.setDeviceMapIndex(i28);
                    gameController.setDeviceMapIndexType(3);
                    CGLog.i("[inputdevice] map to map index ids[" + i18 + "]=" + gameController.getId() + " mapIndex=" + i28);
                } else {
                    int[] initCloudDeviceIds = GlobalConfig.getInstance().getInitCloudDeviceIds();
                    if (initCloudDeviceIds != null && initCloudDeviceIds.length >= 1 && (i17 = initCloudDeviceIds[0]) >= 0 && i17 < i3) {
                        this.mCloudMapIndexArray[i17] = gameController.getId();
                        gameController.setDeviceMapIndex(i17);
                        gameController.setDeviceMapIndexType(4);
                    } else {
                        gameController.setDeviceMapIndex(0);
                        gameController.setDeviceMapIndexType(1);
                        CGLog.i("[inputdevice] map index ids[" + i18 + "]=" + i19 + " index=" + gameController.getDeviceMapIndex());
                    }
                }
            }
        }
        CGLog.i("[inputdevice] add mapping index is complete. deviceType=" + deviceType + " index=" + gameController.getDeviceMapIndex() + " mapType=" + gameController.getDeviceMapIndexType());
        return z16;
    }

    private GameController addGameController(int i3) {
        int i16;
        int deviceProductId = InputUtils.getDeviceProductId(i3);
        int deviceVendorId = InputUtils.getDeviceVendorId(i3);
        String deviceName = InputUtils.getDeviceName(i3);
        if (i3 != -1 && i3 != 0) {
            GameController gameControllerByDeviceId = getGameControllerByDeviceId(i3);
            if (gameControllerByDeviceId != null) {
                return gameControllerByDeviceId;
            }
            int deviceType = getDeviceType(i3);
            CloudGameDeviceContainer cloudGameDeviceContainer = this.mCloudGameDeviceContainer;
            if (cloudGameDeviceContainer != null) {
                i16 = cloudGameDeviceContainer.addGlobalDeviceId(deviceType, i3);
            } else {
                i16 = 0;
            }
            if (i16 == 0) {
                return null;
            }
            GameController gameController = new GameController();
            gameController.setId(i16);
            gameController.setAndroidDeviceId(i3);
            gameController.setProductId(deviceProductId);
            gameController.setVendorId(deviceVendorId);
            gameController.setType(deviceType);
            gameController.setName(deviceName);
            CGLog.i("[inputdevice] add game controller globalId=" + i16 + " deviceType=" + deviceType + " deviceId=" + i3 + " name=" + deviceName + " productId=" + deviceProductId + " vendorId=" + deviceVendorId);
            SparseArray<GameController> sparseArray = this.mGameControllerIds;
            if (sparseArray != null) {
                sparseArray.put(i16, gameController);
            }
            return gameController;
        }
        CGLog.i("[inputdevice] pass device id=" + i3 + " name=" + deviceName + " productId=" + deviceProductId + " vendorId=" + deviceVendorId);
        return null;
    }

    private boolean createGameControllerToCloud(GameController gameController) {
        if (gameController == null) {
            return false;
        }
        boolean addDeviceMapIndex = addDeviceMapIndex(gameController);
        if (addDeviceMapIndex && gameController.getDeviceMapIndexType() == 2) {
            GameController.CloudCommand cloudCommand = new GameController.CloudCommand(1, 1, gameController.getDeviceMapIndex(), 1);
            if (this.mGamepadController != null) {
                CGLog.i("[inputdevice] send command to create game controller: name=" + gameController.getName() + " type=" + gameController.getDeviceType() + " index=" + gameController.getDeviceMapIndex());
                gameController.setCreatedCloudDevice(true);
                return this.mGamepadController.sendGameControlCommandToCloud(cloudCommand);
            }
            return addDeviceMapIndex;
        }
        CGLog.i("[inputdevice] add index res=" + addDeviceMapIndex + " mapType=" + gameController.getDeviceMapIndexType());
        return false;
    }

    public static TVInputManager createInstance(Context context) {
        if (sTVInputManager == null) {
            synchronized (TVInputManager.class) {
                if (sTVInputManager == null) {
                    sTVInputManager = new TVInputManager(context);
                }
            }
        }
        return sTVInputManager;
    }

    private void destroyAllCloudGameController() {
        if (this.mGameControllerIds != null) {
            for (int i3 = 0; i3 < this.mGameControllerIds.size(); i3++) {
                GameController valueAt = this.mGameControllerIds.valueAt(i3);
                if (valueAt != null && valueAt.isCreatedCloudDevice()) {
                    destroyCloudGameController(valueAt);
                }
            }
        }
    }

    private boolean destroyCloudGameController(GameController gameController) {
        if (gameController == null || this.mCloudGameDeviceContainer == null) {
            return false;
        }
        int deviceMapIndex = gameController.getDeviceMapIndex();
        CloudGameDevice globalGameDevice = this.mCloudGameDeviceContainer.getGlobalGameDevice(gameController.getId());
        if (gameController.getDeviceMapIndexType() == 2 && globalGameDevice != null && globalGameDevice.getDeviceIdSize() == 1) {
            GameController.CloudCommand cloudCommand = new GameController.CloudCommand(2, 1, deviceMapIndex, 1);
            if (this.mGamepadController == null || !gameController.isCreatedCloudDevice()) {
                return false;
            }
            CGLog.i("[inputdevice] send command to destroy game controller: name=" + gameController.getName() + " type=" + gameController.getDeviceType() + " index=" + gameController.getDeviceMapIndex());
            gameController.setCreatedCloudDevice(false);
            return this.mGamepadController.sendGameControlCommandToCloud(cloudCommand);
        }
        CGLog.i("[inputdevice] no device created dynamically name=" + gameController.getName());
        return false;
    }

    private void enumInputDevices() {
        int i3 = 0;
        try {
            if (this.mHasSearchInputDevices) {
                SparseArray<GameController> sparseArray = this.mGameControllerIds;
                if (sparseArray != null) {
                    i3 = sparseArray.size();
                }
                Log.d("inputdevice", "already search!! device count=" + i3);
                return;
            }
            try {
                this.mDeviceLock.lock();
                int[] inputDeviceIds = this.mInputManager.getInputDeviceIds();
                if (inputDeviceIds != null) {
                    Log.d("inputdevice", "enum all input device count=" + inputDeviceIds.length);
                    int length = inputDeviceIds.length;
                    while (i3 < length) {
                        addGameController(inputDeviceIds[i3]);
                        i3++;
                    }
                } else {
                    Log.d("inputdevice", "enum all input devices count=0 !!");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.mDeviceLock.unlock();
            this.mHasSearchInputDevices = true;
        } catch (Throwable th5) {
            this.mDeviceLock.unlock();
            throw th5;
        }
    }

    public static TVInputManager getInstance() {
        return sTVInputManager;
    }

    private void handleDeviceAdd(int i3) {
        GameController addGameController = addGameController(i3);
        if (addGameController != null) {
            CGLog.i("[inputdevice] device added name=" + addGameController.getName() + " deviceId=" + i3);
            if (GlobalConfig.getInstance().isCreateCloudDevice()) {
                createGameControllerToCloud(addGameController);
            }
            int deviceType = addGameController.getDeviceType();
            ITVInputListener iTVInputListener = this.mTVPlaySessionInputLisener;
            if (iTVInputListener != null) {
                iTVInputListener.onInputDeviceChanged(deviceType, 1, addGameController);
            }
            handleKeyMapLayoutUpdate(deviceType, 1, i3, addGameController);
            return;
        }
        CGLog.i("[inputdevice] device added controller is null");
    }

    private void handleDeviceRemove(int i3, int i16) {
        GameController gameControllerByDeviceId = getGameControllerByDeviceId(i16);
        if (gameControllerByDeviceId != null) {
            CGLog.i("[inputdevice] device removed name=" + gameControllerByDeviceId.getName() + " deviceId=" + i16);
            int deviceType = gameControllerByDeviceId.getDeviceType();
            GamepadController gamepadController = this.mGamepadController;
            if (gamepadController != null) {
                gamepadController.stopJoystickTouchRun(1);
                this.mGamepadController.stopJoystickTouchRun(2);
            }
            if (GlobalConfig.getInstance().isCreateCloudDevice()) {
                destroyCloudGameController(gameControllerByDeviceId);
            }
            removeGameControllerByDeviceId(i16);
            ITVInputListener iTVInputListener = this.mTVPlaySessionInputLisener;
            if (iTVInputListener != null) {
                iTVInputListener.onInputDeviceChanged(deviceType, i3, gameControllerByDeviceId);
            }
            handleKeyMapLayoutUpdate(deviceType, i3, i16, gameControllerByDeviceId);
            return;
        }
        CGLog.i("[inputdevice] device removed controller is null");
    }

    private void handleKeyMapLayoutUpdate(int i3, int i16, int i17, GameController gameController) {
        if (i3 != 0) {
            Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
            if (set != null) {
                for (ITVInputListener iTVInputListener : set) {
                    if (iTVInputListener != null) {
                        iTVInputListener.onInputDeviceChanged(i3, i16, gameController);
                    }
                }
            }
            if (this.mGamepadController != null && InputUtils.isMFGamepadDevice(InputUtils.getDeviceVendorId(i17), InputUtils.getDeviceProductId(i17))) {
                this.mGamepadController.onMFGampadDeviceChanged(i3, i16, i17);
            }
        }
    }

    private void init() {
        InputManagerCompat inputManagerCompat = this.mInputManager;
        if (inputManagerCompat != null) {
            inputManagerCompat.registerInputDeviceListener(this, null);
        }
        enumInputDevices();
    }

    private boolean isValidDevice(int i3, int i16, String str) {
        if (i16 == 0 && i3 == 0 && GlobalConfig.getInstance().isPassProduct0Vendor0()) {
            return false;
        }
        if ((i16 == 1 && i3 == 1 && GlobalConfig.getInstance().isPassProduct1Vendor1()) || GlobalConfig.getInstance().getPassDeviceConfig(i3, i16, str) != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGamepadPerfUpdate$1(GamepadPerfInfo gamepadPerfInfo) {
        Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
        if (set != null) {
            for (ITVInputListener iTVInputListener : set) {
                if (iTVInputListener != null) {
                    iTVInputListener.onGamepadPerfUpdate(gamepadPerfInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHIDEventNotify$0(int i3, int i16, int i17) {
        Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
        if (set != null) {
            for (ITVInputListener iTVInputListener : set) {
                if (iTVInputListener != null) {
                    iTVInputListener.onInputEventNotify(i3, i16, i17);
                }
            }
        }
        ITVInputListener iTVInputListener2 = this.mTVPlaySessionInputLisener;
        if (iTVInputListener2 != null) {
            iTVInputListener2.onInputEventNotify(i3, i16, i17);
        }
    }

    private boolean removeDeviceMapIndex(GameController gameController, int i3) {
        CloudGameDeviceContainer cloudGameDeviceContainer;
        if (gameController == null) {
            return false;
        }
        int deviceType = gameController.getDeviceType();
        int deviceMapIndex = gameController.getDeviceMapIndex();
        if (gameController.getDeviceMapIndexType() != 2) {
            gameController.setDeviceMapIndex(-1);
            gameController.setDeviceMapIndexType(0);
            return true;
        }
        if (deviceType != 2 && deviceType != 4) {
            if (deviceType == 3 && (deviceMapIndex < 19 || deviceMapIndex >= 32)) {
                return false;
            }
        } else if (deviceMapIndex < 3 || deviceMapIndex >= 16) {
            return false;
        }
        int[] iArr = this.mCloudMapIndexArray;
        if (iArr == null || (cloudGameDeviceContainer = this.mCloudGameDeviceContainer) == null) {
            return false;
        }
        int i16 = iArr[deviceMapIndex];
        CloudGameDevice globalGameDevice = cloudGameDeviceContainer.getGlobalGameDevice(i16);
        CGLog.i("[inputdevice] remove mapping index ids[" + deviceMapIndex + "]=" + i16 + " ids size=" + globalGameDevice.getDeviceIdSize());
        globalGameDevice.removeDeviceId(i3);
        if (globalGameDevice.getDeviceIdSize() != 0) {
            return false;
        }
        CGLog.i("[inputdevice] remove mapping index ids[" + deviceMapIndex + "]=" + i16);
        this.mCloudMapIndexArray[deviceMapIndex] = 0;
        gameController.setDeviceMapIndex(-1);
        return true;
    }

    private void removeGameControllerByDeviceId(int i3) {
        GameController gameControllerByDeviceId = getGameControllerByDeviceId(i3);
        if (gameControllerByDeviceId != null) {
            removeDeviceMapIndex(gameControllerByDeviceId, i3);
            if (gameControllerByDeviceId.getDeviceMapIndex() == -1) {
                CloudGameDeviceContainer cloudGameDeviceContainer = this.mCloudGameDeviceContainer;
                if (cloudGameDeviceContainer != null) {
                    cloudGameDeviceContainer.removeGlobalDeviceId(gameControllerByDeviceId.getId(), i3);
                }
                SparseArray<GameController> sparseArray = this.mGameControllerIds;
                if (sparseArray != null) {
                    sparseArray.remove(gameControllerByDeviceId.getId());
                    return;
                }
                return;
            }
            return;
        }
        CGLog.i("[inputdevice] controller is null object ");
    }

    private void uninit() {
        InputManagerCompat inputManagerCompat = this.mInputManager;
        if (inputManagerCompat != null) {
            inputManagerCompat.unregisterInputDeviceListener(this);
        }
    }

    public void asynQueryGamepadOnlineState(int i3) {
        this.mHIDDeviceManage.asynQueryGamepadOnlineState(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public int checkAndOpenMFGamepad() {
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null) {
            hIDDeviceManage.registerTVInputManagerListener(this);
            if (!this.mHIDDeviceManage.registerUsbBroadcast()) {
                CGLog.e("hid mamager init failed!!");
            }
        }
        UsbDevice mFGamepadUsbDevice = this.mHIDDeviceManage.getMFGamepadUsbDevice();
        if (mFGamepadUsbDevice != null) {
            if (!this.mHIDDeviceManage.hasUsbPermission(mFGamepadUsbDevice)) {
                this.mHIDDeviceManage.requestUsbPermission(mFGamepadUsbDevice);
            } else {
                openMFGamepad();
            }
        } else {
            GlobalConfig.IsOpenMFGamepad = false;
        }
        return 0;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void closeMFGamepad() {
        if (this.mIsMFGamepadConnected) {
            this.mHIDDeviceManage.closeMFGamepad();
            Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
            if (set != null) {
                for (ITVInputListener iTVInputListener : set) {
                    if (iTVInputListener != null) {
                        iTVInputListener.onInputDeviceChanged(4, 2, null);
                    }
                }
            }
            HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.Closed;
            this.mIsMFGamepadConnected = false;
        }
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null) {
            hIDDeviceManage.unregisterTVInputManagerListener();
            this.mHIDDeviceManage.unregisterUsbBroadcast();
        }
    }

    public int createDeviceToCloudForConnected() {
        int i3;
        Exception e16;
        enumInputDevices();
        int i16 = 0;
        try {
            try {
                this.mDeviceLock.lock();
                if (this.mGameControllerIds != null) {
                    i3 = 0;
                    while (i16 < this.mGameControllerIds.size()) {
                        try {
                            GameController valueAt = this.mGameControllerIds.valueAt(i16);
                            if (valueAt != null && GlobalConfig.getInstance().isCreateCloudDevice() && createGameControllerToCloud(valueAt)) {
                                i3++;
                            }
                            i16++;
                        } catch (Exception e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            this.mDeviceLock.unlock();
                            return i3;
                        }
                    }
                    i16 = i3;
                }
                return i16;
            } finally {
                this.mDeviceLock.unlock();
            }
        } catch (Exception e18) {
            i3 = 0;
            e16 = e18;
        }
    }

    public int getDeviceType(int i3) {
        List<InputDevice.MotionRange> motionRanges;
        boolean z16;
        Set<ITVInputListener> set;
        boolean z17 = true;
        if (this.mEnableClientConfig && (set = this.mAppClientInputLisenerSet) != null) {
            boolean z18 = false;
            boolean z19 = false;
            for (ITVInputListener iTVInputListener : set) {
                if (iTVInputListener != null) {
                    if (iTVInputListener.isTvController(i3)) {
                        z18 = true;
                    } else if (iTVInputListener.isGamepad(i3)) {
                        z19 = true;
                    }
                }
            }
            if (z18) {
                return 3;
            }
            if (z19) {
                if (InputUtils.isMFGamepadDevice(InputUtils.getDeviceVendorId(i3), InputUtils.getDeviceProductId(i3))) {
                    return 4;
                }
                return 2;
            }
        }
        InputDevice device = InputDevice.getDevice(i3);
        if (device == null) {
            return 0;
        }
        int sources = device.getSources();
        if (((sources & 16) == 16 || (sources & 1025) == 1025) && (motionRanges = device.getMotionRanges()) != null) {
            for (InputDevice.MotionRange motionRange : motionRanges) {
                if (motionRange != null && (motionRange.getSource() & 16) != 0 && motionRange.getAxis() <= 16) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!InputUtils.isMFGamepadDevice(device.getVendorId(), device.getProductId())) {
            z17 = false;
        }
        if (z16) {
            if (z17) {
                return 4;
            }
            return 2;
        }
        if (!z17 && (sources & 513) == 513) {
            return 3;
        }
        return 0;
    }

    public GameController getGameControllerByDeviceId(int i3) {
        CloudGameDeviceContainer cloudGameDeviceContainer = this.mCloudGameDeviceContainer;
        if (cloudGameDeviceContainer == null) {
            return null;
        }
        return getGameControllerById(cloudGameDeviceContainer.findGlobalDeviceId(i3));
    }

    public GameController getGameControllerById(int i3) {
        SparseArray<GameController> sparseArray = this.mGameControllerIds;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public Vector<IGameController> getGameControllers(int i3) {
        enumInputDevices();
        Vector<IGameController> vector = new Vector<>();
        try {
            try {
                this.mDeviceLock.lock();
                if (this.mGameControllerIds != null) {
                    for (int i16 = 0; i16 < this.mGameControllerIds.size(); i16++) {
                        GameController valueAt = this.mGameControllerIds.valueAt(i16);
                        if (valueAt != null) {
                            int deviceType = valueAt.getDeviceType();
                            if (i3 == 5) {
                                if (deviceType == 2 || deviceType == 4) {
                                    vector.add(valueAt);
                                }
                            } else if (i3 == 1) {
                                vector.add(valueAt);
                            } else if (deviceType == i3) {
                                vector.add(valueAt);
                            }
                        } else {
                            Log.d("inputdevice", "m is null. deviceType=" + i3);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return vector;
        } finally {
            this.mDeviceLock.unlock();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public String getInputEventMessage(int i3, int i16, int i17) {
        return InputUtils.makeInputEventMessage(i3, i16, i17, this.mHidEventMessage);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int handleHidKeyEvent(HIDKeyEvent hIDKeyEvent) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.handleHidKeyEvent(hIDKeyEvent);
        }
        return 0;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public boolean hasInputDeviceConnected(int i3) {
        if (this.mIsMFGamepadConnected) {
            return true;
        }
        Vector<IGameController> gameControllers = getGameControllers(i3);
        if (gameControllers != null && gameControllers.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public boolean hasMFGamepadConnected() {
        enumInputDevices();
        if (this.mGameControllerIds == null) {
            return false;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < this.mGameControllerIds.size(); i3++) {
            GameController valueAt = this.mGameControllerIds.valueAt(i3);
            if (valueAt != null && valueAt.getDeviceType() == 4) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public boolean isOnlyMFGamepadConnected() {
        GameController valueAt;
        enumInputDevices();
        SparseArray<GameController> sparseArray = this.mGameControllerIds;
        if (sparseArray == null || sparseArray.size() != 1 || (valueAt = this.mGameControllerIds.valueAt(0)) == null || valueAt.getDeviceType() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void onGamepadOnlineNotification(int i3, int i16) {
        Log.d("gamepad", "reportMFGameadIsOnline: deviceId = " + i3 + " isOnline = " + i16);
        GameController gameControllerByDeviceId = getGameControllerByDeviceId(i3);
        if (gameControllerByDeviceId != null) {
            gameControllerByDeviceId.setOnlineState(i16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDDeviceManageListener
    public void onGamepadPerfUpdate(final GamepadPerfInfo gamepadPerfInfo) {
        CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.l
            @Override // java.lang.Runnable
            public final void run() {
                TVInputManager.this.lambda$onGamepadPerfUpdate$1(gamepadPerfInfo);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public void onGamepadTouchMapRelDirection(int i3, int i16, int i17) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onGamepadTouchMapRelDirection(i3, i16, i17);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public void onGamepadTouchMapRelOffset(int i3, int i16, int i17) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onGamepadTouchMapRelOffset(i3, i16, i17);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDDeviceManageListener
    public void onHIDEventNotify(final int i3, final int i16, final int i17, String str) {
        this.mHidEventMessage = str;
        CGBaseHelper.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.k
            @Override // java.lang.Runnable
            public final void run() {
                TVInputManager.this.lambda$onHIDEventNotify$0(i3, i16, i17);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat.InputDeviceListener
    public void onInputDeviceAdded(int i3) {
        CGLog.i("inputdevice add id=" + i3);
        try {
            try {
                this.mDeviceLock.lock();
                handleDeviceAdd(i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.mDeviceLock.unlock();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat.InputDeviceListener
    public void onInputDeviceChanged(int i3) {
        CGLog.i("inputdevice changed id=" + i3);
        try {
            try {
                this.mDeviceLock.lock();
                handleDeviceRemove(3, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.mDeviceLock.unlock();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.inputmanagercompat.InputManagerCompat.InputDeviceListener
    public void onInputDeviceRemoved(int i3) {
        CGLog.i("inputdevice removed id=" + i3);
        try {
            try {
                this.mDeviceLock.lock();
                handleDeviceRemove(2, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.mDeviceLock.unlock();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDDeviceManageListener
    public void onInputEvent(HIDInputEvent hIDInputEvent) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.onInputEvent(hIDInputEvent);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int onKeyJoyState(int i3, int i16, float f16, float f17) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.onKeyJoyState(i3, i16, f16, f17);
        }
        return 0;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public int onKeyJoyUp(int i3, int i16) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            return gamepadController.onKeyJoyUp(i3, i16);
        }
        return 0;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDDeviceManageListener
    public void onUsbDevicePermissionResult(UsbDevice usbDevice, boolean z16) {
        Log.d("usbdevice", "onUsbDevicePermissionResult permGranted=" + z16);
        Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
        if (set != null) {
            for (ITVInputListener iTVInputListener : set) {
                if (iTVInputListener != null) {
                    Log.d("usbdevice", "listener permGranted=" + z16);
                    iTVInputListener.onUsbDevicePermissionResult(usbDevice, z16);
                }
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public boolean openMFGamepad() {
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null) {
            hIDDeviceManage.registerTVInputManagerListener(this);
            if (!this.mHIDDeviceManage.registerUsbBroadcast()) {
                CGLog.e("hid mamager init failed!!");
            }
        }
        if (this.mIsMFGamepadConnected) {
            return true;
        }
        if (this.mHIDDeviceManage.openMFGamepad()) {
            this.mIsMFGamepadConnected = true;
            Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
            if (set == null) {
                return true;
            }
            for (ITVInputListener iTVInputListener : set) {
                if (iTVInputListener != null) {
                    iTVInputListener.onInputDeviceChanged(4, 1, null);
                }
            }
            HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.Opened;
            return true;
        }
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.OpenFailed;
        reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.OpenFailed.getErrorCode(), ITVPlaySession.GamepadReportStatus.OpenFailed.getStatus());
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void registerAppClientInputListener(ITVInputListener iTVInputListener) {
        if (this.mAppClientInputLisenerSet == null) {
            this.mAppClientInputLisenerSet = new HashSet();
        }
        this.mAppClientInputLisenerSet.add(iTVInputListener);
    }

    public void registerTVPlaySessionInputListener(ITVInputListener iTVInputListener) {
        this.mTVPlaySessionInputLisener = iTVInputListener;
    }

    public void releaseInputManager() {
        uninit();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadHidEvent
    public void reportGamepadStatus(String str, int i3, String str2) {
        GamepadController gamepadController = this.mGamepadController;
        if (gamepadController != null) {
            gamepadController.reportGamepadStatus(str, i3, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void requestUsbPermission(UsbDevice usbDevice) {
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null) {
            hIDDeviceManage.requestUsbPermission(usbDevice);
        }
    }

    public void resetGameConfig() {
        if (!this.mRequireResetGameConfigState) {
            CGLog.i("[globalconfig] config has been reset!.");
            return;
        }
        this.mRequireResetGameConfigState = false;
        CloudGameDeviceContainer cloudGameDeviceContainer = this.mCloudGameDeviceContainer;
        if (cloudGameDeviceContainer != null) {
            cloudGameDeviceContainer.reset();
        }
        SparseArray<GameController> sparseArray = this.mGameControllerIds;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.mHasSearchInputDevices = false;
        if (this.mCloudMapIndexArray != null) {
            for (int i3 = 0; i3 < 32; i3++) {
                this.mCloudMapIndexArray[i3] = -1;
            }
        }
        GlobalConfig.resetGlobalConfig();
        CGLog.i("[globalconfig] reset config has been completed.");
    }

    public void resetGameConfigState() {
        this.mRequireResetGameConfigState = true;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void setClientConfig(boolean z16) {
        this.mEnableClientConfig = z16;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void setGamepadController(GamepadController gamepadController) {
        this.mGamepadController = gamepadController;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager
    public void unregisterAppClientInputListener(ITVInputListener iTVInputListener) {
        Set<ITVInputListener> set = this.mAppClientInputLisenerSet;
        if (set != null) {
            set.remove(iTVInputListener);
        }
    }

    public void unregisterTVPlaySessionInputListener() {
        this.mTVPlaySessionInputLisener = null;
    }
}
