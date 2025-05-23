package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameController implements IGameController {
    public static final int CLOUD_COMMAND_CREATE = 1;
    public static final int CLOUD_COMMAND_DESTROY = 2;
    public static final int CLOUD_COMMAND_MAP_MODE_KEYCODE = 2;
    public static final int CLOUD_COMMAND_MAP_MODE_NATIVE = 1;
    public static final int DEVICE_MAP_TYPE_DEFAULT = 1;
    public static final int DEVICE_MAP_TYPE_INIT = 4;
    public static final int DEVICE_MAP_TYPE_MAP = 3;
    public static final int DEVICE_MAP_TYPE_NEW = 2;
    public static final int DEVICE_MAP_TYPE_NONE = 0;
    private String m_name = null;
    private int m_id = -1;
    private int m_type = 0;
    private int m_androidDeviceId = -1;
    private int m_onlineState = -1;
    private int m_productId = 0;
    private int m_vendorId = 0;
    private int m_deviceMapIndex = -1;
    private boolean m_isCreatedCloudDevice = false;
    private int m_deviceMapIndexType = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CloudCommand {
        public int m_cmd;
        public int m_deviceId;
        public int m_deviceType;
        public int m_mapMode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CloudCommand(int i3, int i16, int i17, int i18) {
            this.m_cmd = i3;
            this.m_deviceType = i16;
            this.m_deviceId = i17;
            this.m_mapMode = i18;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getAndroidDeviceId() {
        return this.m_androidDeviceId;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getDeviceMapIndex() {
        return this.m_deviceMapIndex;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getDeviceMapIndexType() {
        return this.m_deviceMapIndexType;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getDeviceType() {
        return this.m_type;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getId() {
        return this.m_id;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public String getName() {
        return this.m_name;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getOnlineState() {
        return this.m_onlineState;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getProductId() {
        return this.m_productId;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public int getVendorId() {
        return this.m_vendorId;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGameController
    public boolean isCreatedCloudDevice() {
        return this.m_isCreatedCloudDevice;
    }

    public void setAndroidDeviceId(int i3) {
        this.m_androidDeviceId = i3;
    }

    public void setCreatedCloudDevice(boolean z16) {
        this.m_isCreatedCloudDevice = z16;
    }

    public void setDeviceMapIndex(int i3) {
        this.m_deviceMapIndex = i3;
    }

    public void setDeviceMapIndexType(int i3) {
        this.m_deviceMapIndexType = i3;
    }

    public void setId(int i3) {
        this.m_id = i3;
    }

    public void setName(String str) {
        this.m_name = str;
    }

    public void setOnlineState(int i3) {
        this.m_onlineState = i3;
    }

    public void setProductId(int i3) {
        this.m_productId = i3;
    }

    public void setType(int i3) {
        this.m_type = i3;
    }

    public void setVendorId(int i3) {
        this.m_vendorId = i3;
    }
}
