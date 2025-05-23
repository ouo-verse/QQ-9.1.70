package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.qphone.base.util.QLog;
import uq4.b;
import uq4.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveGiftEntranceServiceImpl implements IQQLiveGiftEntranceService {
    static IPatchRedirector $redirector_ = null;
    protected static final String NEED_SHOW_GIFT_ICON_CMD = "trpc.qlive.config_center_svr.ConfigCenterSvr";
    protected static final String NEED_SHOW_GIFT_ICON_SUB_CMD = "DynamicConfig";
    private static final String TAG = "QQLiveGiftEntranceServiceImpl";
    private IQQLiveSDK sdkImpl;

    public QQLiveGiftEntranceServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acquireSwitchByType(c cVar, int i3) {
        for (uq4.a aVar : cVar.f439826a) {
            if (aVar.f439822a == i3) {
                return aVar.f439823b;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdkImpl = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService
    public void needShowGiftIcon(long j3, OnQueryGiftIconCallback onQueryGiftIconCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), onQueryGiftIconCallback);
            return;
        }
        com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module");
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 4, "get IQQLiveRoomPushService null");
            }
        } else {
            b bVar = new b();
            bVar.f439824a = j3;
            cVar.f(NEED_SHOW_GIFT_ICON_CMD, NEED_SHOW_GIFT_ICON_SUB_CMD, MessageNano.toByteArray(bVar), new f(onQueryGiftIconCallback, j3) { // from class: com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftEntranceServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ OnQueryGiftIconCallback val$callback;
                final /* synthetic */ long val$roomId;

                {
                    this.val$callback = onQueryGiftIconCallback;
                    this.val$roomId = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQLiveGiftEntranceServiceImpl.this, onQueryGiftIconCallback, Long.valueOf(j3));
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int i3, boolean z16, h hVar) {
                    boolean z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                        return;
                    }
                    if (z16) {
                        if (hVar != null && hVar.e() != null) {
                            try {
                                c cVar2 = new c();
                                c.c(hVar.e());
                                if (!QQLiveGiftEntranceServiceImpl.this.acquireSwitchByType(cVar2, 5)) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                QLog.i(QQLiveGiftEntranceServiceImpl.TAG, 1, "gift config roomId:" + this.val$roomId + ", canShow:" + z17);
                                this.val$callback.onSuccess(z17, false);
                                return;
                            } catch (InvalidProtocolBufferNanoException e16) {
                                QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon onReceive e:" + e16.getMessage());
                                return;
                            }
                        }
                        QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon data error, data:" + hVar);
                        this.val$callback.onFailed(-1, "data is null");
                        return;
                    }
                    QLog.e(QQLiveGiftEntranceServiceImpl.TAG, 1, "needShowGiftIcon onReceive error");
                    this.val$callback.onFailed(-1, "query needShowGiftIcon fail");
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
