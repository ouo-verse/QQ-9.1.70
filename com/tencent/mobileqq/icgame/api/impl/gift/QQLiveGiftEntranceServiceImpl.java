package com.tencent.mobileqq.icgame.api.impl.gift;

import com.tencent.icgame.trpc.yes.common.LiveBusConfigCenterClass$BoolConfig;
import com.tencent.icgame.trpc.yes.common.LiveBusConfigCenterClass$DynamicConfigReq;
import com.tencent.icgame.trpc.yes.common.LiveBusConfigCenterClass$DynamicConfigRsp;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.icgame.sso.c;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveGiftEntranceServiceImpl implements IQQLiveGiftEntranceService {
    protected static final String NEED_SHOW_GIFT_ICON_CMD = "trpc.qlive.config_center_svr.ConfigCenterSvr";
    protected static final String NEED_SHOW_GIFT_ICON_SUB_CMD = "DynamicConfig";
    private static final String TAG = "ICGameGiftEntranceServiceImpl";
    private IQQLiveSDK sdkImpl;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acquireSwitchByType(LiveBusConfigCenterClass$DynamicConfigRsp liveBusConfigCenterClass$DynamicConfigRsp, int i3) {
        for (LiveBusConfigCenterClass$BoolConfig liveBusConfigCenterClass$BoolConfig : liveBusConfigCenterClass$DynamicConfigRsp.bool_config.get()) {
            if (liveBusConfigCenterClass$BoolConfig.type.get() == i3) {
                return liveBusConfigCenterClass$BoolConfig.flag.get();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftEntranceService
    public void needShowGiftIcon(final long j3, final OnQueryGiftIconCallback onQueryGiftIconCallback) {
        c cVar = (c) this.sdkImpl.getExtModule("sso_module");
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
            }
        } else {
            LiveBusConfigCenterClass$DynamicConfigReq liveBusConfigCenterClass$DynamicConfigReq = new LiveBusConfigCenterClass$DynamicConfigReq();
            liveBusConfigCenterClass$DynamicConfigReq.room_id.set(j3);
            cVar.f(NEED_SHOW_GIFT_ICON_CMD, NEED_SHOW_GIFT_ICON_SUB_CMD, liveBusConfigCenterClass$DynamicConfigReq.toByteArray(), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.gift.QQLiveGiftEntranceServiceImpl.1
                @Override // com.tencent.mobileqq.icgame.sso.g
                public void onReceive(int i3, boolean z16, i iVar) {
                    boolean z17;
                    if (z16) {
                        if (iVar != null && iVar.e() != null) {
                            try {
                                LiveBusConfigCenterClass$DynamicConfigRsp liveBusConfigCenterClass$DynamicConfigRsp = new LiveBusConfigCenterClass$DynamicConfigRsp();
                                liveBusConfigCenterClass$DynamicConfigRsp.mergeFrom(iVar.e());
                                if (!QQLiveGiftEntranceServiceImpl.this.acquireSwitchByType(liveBusConfigCenterClass$DynamicConfigRsp, 5)) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                QLog.i(QQLiveGiftEntranceServiceImpl.TAG, 1, "gift config roomId:" + j3 + ", canShow:" + z17);
                                onQueryGiftIconCallback.onSuccess(z17, false);
                                return;
                            } catch (InvalidProtocolBufferMicroException e16) {
                                QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon onReceive e:" + e16.getMessage());
                                return;
                            }
                        }
                        QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon data error, data:" + iVar);
                        onQueryGiftIconCallback.onFailed(-1, "data is null");
                        return;
                    }
                    QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon onReceive error");
                    onQueryGiftIconCallback.onFailed(-1, "query needShowGiftIcon fail");
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
