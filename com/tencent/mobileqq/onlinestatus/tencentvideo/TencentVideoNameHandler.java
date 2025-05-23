package com.tencent.mobileqq.onlinestatus.tencentvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.HashSet;
import java.util.Set;
import tencent.im.onlinestatus.OnlineStatusTencentVideoNameInfo$GetVideoReq;
import tencent.im.onlinestatus.OnlineStatusTencentVideoNameInfo$GetVideoRsp;
import tencent.im.onlinestatus.OnlineStatusTencentVideoNameInfo$VideoInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TencentVideoNameHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f256290d;

    /* renamed from: e, reason: collision with root package name */
    private y.f f256291e;

    protected TencentVideoNameHandler(AppInterface appInterface) {
        super(appInterface);
        this.f256290d = appInterface;
    }

    private void F2(ToServiceMsg toServiceMsg, OnlineStatusTencentVideoNameInfo$VideoInfo onlineStatusTencentVideoNameInfo$VideoInfo) {
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        c A = bs.A(toServiceMsg.getUin(), "TencentVideoNameHandler");
        if (A == null) {
            QLog.e("TencentVideoNameHandler", 1, "setVideoNameToFriend ntOnlineStatusSimpleInfo is null");
        } else {
            A.e1(onlineStatusTencentVideoNameInfo$VideoInfo.name.get());
            iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(A, "TencentVideoNameHandler", (hx3.c<a>) null);
        }
    }

    public void D2(int i3, String str, String str2) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str2, "trpc.qqmedia.tencent_video_proxy.TvProxy.SsoGetVideo");
        OnlineStatusTencentVideoNameInfo$GetVideoReq onlineStatusTencentVideoNameInfo$GetVideoReq = new OnlineStatusTencentVideoNameInfo$GetVideoReq();
        onlineStatusTencentVideoNameInfo$GetVideoReq.cid.set(str);
        toServiceMsg.putWupBuffer(onlineStatusTencentVideoNameInfo$GetVideoReq.toByteArray());
        toServiceMsg.addAttribute("get_tencent_name_type", Integer.valueOf(i3));
        sendPbReq(toServiceMsg);
    }

    public void E2(y.f fVar) {
        this.f256291e = fVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.qqmedia.tencent_video_proxy.TvProxy.SsoGetVideo");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushPBCommandList() {
        return new HashSet<String>() { // from class: com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler.1
            {
                add("trpc.qqmedia.tencent_video_proxy.TvProxy.SsoGetVideo");
            }
        };
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        y.f fVar;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            try {
                OnlineStatusTencentVideoNameInfo$GetVideoRsp onlineStatusTencentVideoNameInfo$GetVideoRsp = new OnlineStatusTencentVideoNameInfo$GetVideoRsp();
                onlineStatusTencentVideoNameInfo$GetVideoRsp.mergeFrom((byte[]) obj);
                int i3 = onlineStatusTencentVideoNameInfo$GetVideoRsp.ret_code.get();
                String str = onlineStatusTencentVideoNameInfo$GetVideoRsp.ret_msg.get();
                if (i3 != 0) {
                    QLog.d("TencentVideoNameHandler", 1, "1: " + i3, " 2: " + str);
                    return;
                }
                OnlineStatusTencentVideoNameInfo$VideoInfo onlineStatusTencentVideoNameInfo$VideoInfo = onlineStatusTencentVideoNameInfo$GetVideoRsp.video_info.get();
                String str2 = onlineStatusTencentVideoNameInfo$VideoInfo.name.get();
                int intValue = ((Integer) toServiceMsg.getAttribute("get_tencent_name_type", -1)).intValue();
                if (intValue != 1) {
                    if (intValue == 2 && (fVar = this.f256291e) != null) {
                        fVar.a(str2);
                    }
                } else {
                    F2(toServiceMsg, onlineStatusTencentVideoNameInfo$VideoInfo);
                }
                QLog.d("TencentVideoNameHandler", 1, "1: " + i3, " 2: " + str);
                return;
            } catch (Exception e16) {
                QLog.e("TencentVideoNameHandler", 1, "receive: " + e16);
                return;
            }
        }
        QLog.d("TencentVideoNameHandler", 1, "req: " + toServiceMsg + " rsp: " + fromServiceMsg + " data: " + obj);
    }
}
