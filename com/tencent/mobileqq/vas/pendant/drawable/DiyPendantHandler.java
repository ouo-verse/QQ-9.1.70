package com.tencent.mobileqq.vas.pendant.drawable;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyAddonPbInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyAddonUser;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
public class DiyPendantHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f310469d;

    public DiyPendantHandler(AppInterface appInterface) {
        super(appInterface);
        this.f310469d = appInterface;
    }

    public void D2(List<Long> list, BusinessObserver businessObserver) {
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("DiyPendantHandler", 2, "try fetchDiyPendants: " + TextUtils.join(",", list));
            }
            DiyAddonPbInfo.AddonReqComm addonReqComm = new DiyAddonPbInfo.AddonReqComm();
            addonReqComm.platform.set(109L);
            addonReqComm.osver.set(Build.VERSION.RELEASE);
            addonReqComm.mqqver.set(AppSetting.f99551k);
            DiyAddonPbInfo.AddonGetDiyInfoReq addonGetDiyInfoReq = new DiyAddonPbInfo.AddonGetDiyInfoReq();
            addonGetDiyInfoReq.uin.set(list);
            DiyAddonPbInfo.ReadAddonReq readAddonReq = new DiyAddonPbInfo.ReadAddonReq();
            readAddonReq.cmd.set(1);
            readAddonReq.comm.set(addonReqComm);
            readAddonReq.packetseq.set(System.currentTimeMillis());
            readAddonReq.reqcmd0x01.set(addonGetDiyInfoReq);
            ToServiceMsg createToServiceMsg = super.createToServiceMsg("ReadDiyAddonInfo.1", businessObserver);
            createToServiceMsg.putWupBuffer(readAddonReq.toByteArray());
            super.sendPbReq(createToServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        DiyAddonPbInfo.ReadAddonRsp readAddonRsp;
        if (fromServiceMsg.getServiceCmd().equals("ReadDiyAddonInfo.1")) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            String valueOf = String.valueOf(toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR));
            if (QLog.isColorLevel()) {
                QLog.d("DiyPendantHandler", 2, "key_seq=" + valueOf + " isSuccess=" + isSuccess + " resultCode=" + fromServiceMsg.getResultCode());
            }
            if (isSuccess) {
                try {
                    readAddonRsp = new DiyAddonPbInfo.ReadAddonRsp().mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.e("DiyPendantHandler", 1, "fetch diy pendant info on response err", e16);
                    readAddonRsp = null;
                }
                if (readAddonRsp != null) {
                    if (readAddonRsp.ret.get() != 0) {
                        QLog.d("DiyPendantHandler", 1, "fetch diy pendant info \u56de\u5305 sso \u6210\u529f \uff0cserver \u5931\u8d25\uff0cret = " + readAddonRsp.ret.get());
                        super.notifyUI(toServiceMsg, 1, false, (Object) null);
                        return;
                    }
                    if (readAddonRsp.rspcmd0x01.has() && readAddonRsp.rspcmd0x01.userdiyinfo.has()) {
                        List<DiyAddonUser.UserDiyInfo> list = readAddonRsp.rspcmd0x01.userdiyinfo.get();
                        ArrayList arrayList = new ArrayList();
                        if (list != null) {
                            for (DiyAddonUser.UserDiyInfo userDiyInfo : list) {
                                if (userDiyInfo.uin.has() && userDiyInfo.curid.has()) {
                                    DiyPendantEntity diyPendantEntity = new DiyPendantEntity();
                                    diyPendantEntity.uinAndDiyId = userDiyInfo.uin.get() + "_" + userDiyInfo.curid.get();
                                    diyPendantEntity.diyId = userDiyInfo.curid.get();
                                    diyPendantEntity.borderId = userDiyInfo.frameid.get();
                                    diyPendantEntity.updateTs = userDiyInfo.updatets.get();
                                    diyPendantEntity.setStickerInfoList(userDiyInfo.stickerinfo.get());
                                    arrayList.add(diyPendantEntity);
                                }
                            }
                        }
                        VasDiyPendantFetcher.n().notifyLoadFinish(this.f310469d, true, arrayList);
                        super.notifyUI(toServiceMsg, 1, true, (Object) arrayList);
                        return;
                    }
                    super.notifyUI(toServiceMsg, 1, false, (Object) null);
                    return;
                }
                super.notifyUI(toServiceMsg, 1, false, (Object) null);
                return;
            }
            super.notifyUI(toServiceMsg, 1, false, (Object) null);
            if (QLog.isColorLevel()) {
                QLog.d("DiyPendantHandler", 2, "DiyText isSuccess is false sso\u901a\u9053  \u5f02\u5e38");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiyPendantHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
        }
    }
}
