package com.tencent.mobileqq.wink.picker.qcircle.sticker;

import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBackgroundMaskReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBackgroundMaskRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes21.dex */
public class QCircleMakeStickerPreviewServiceHandler extends WinkDataServiceHandler {
    public QCircleMakeStickerPreviewServiceHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void r3(FromServiceMsg fromServiceMsg, Object obj) {
        GetBackgroundMaskRsp getBackgroundMaskRsp = (GetBackgroundMaskRsp) obj;
        if (getBackgroundMaskRsp != null && getBackgroundMaskRsp.Images != null && getBackgroundMaskRsp.Code == 0) {
            notifyUI(2, true, obj);
        } else {
            notifyUI(2, false, obj);
        }
    }

    private boolean s3(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetBackgroundMaskReq getBackgroundMaskReq = new GetBackgroundMaskReq();
        getBackgroundMaskReq.Images = (ArrayList) toServiceMsg.extraData.getSerializable("Images");
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.SODSegmentation");
        uniPacket.put("ShadowBackendSvc.SODSegmentation", getBackgroundMaskReq);
        return true;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.SODSegmentation")) {
            return E2(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.SODSegmentation", new GetBackgroundMaskRsp());
        }
        return super.D2(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.SODSegmentation")) {
            return s3(toServiceMsg, uniPacket);
        }
        return super.F2(toServiceMsg, uniPacket);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return QCircleMakeStickerMediaPreviewFragment.class;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.getServiceCmd().equals("ShadowBackendSvc.SODSegmentation")) {
            r3(fromServiceMsg, obj);
        }
    }

    public void t3(List<String> list) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), "ShadowBackendSvc.SODSegmentation");
        Bundle bundle = toServiceMsg.extraData;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(WinkDataServiceHandler.L2(it.next(), 512));
        }
        bundle.putSerializable("Images", arrayList);
        x53.c.a(toServiceMsg, getClass().getName(), x53.b.class);
    }
}
