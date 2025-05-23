package com.qzone.homepage.diy.protocol;

import FACADE_DIY.BatchGetFacadeReq;
import FACADE_DIY.BatchGetFacadeRsp;
import FACADE_DIY.GetFacadeReqExt;
import FACADE_DIY.UserFacadeInfo;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDIYRequest extends AbsCompatRequest<a> {
    private static final String CMD_DIY_REQUEST = "FacadeDIY.BatchGetFacade";
    public static final String KEY_DIY_REQ = "BatchGetFacade";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Map<Long, UserFacadeInfo> f47532a;
    }

    public QzoneDIYRequest(ArrayList<Long> arrayList, Map<Long, GetFacadeReqExt> map) {
        super(CMD_DIY_REQUEST, true);
        BatchGetFacadeReq batchGetFacadeReq = new BatchGetFacadeReq();
        batchGetFacadeReq.uins = arrayList;
        batchGetFacadeReq.qua = QZoneHelper.getQUA();
        batchGetFacadeReq.ext = map;
        batchGetFacadeReq.loginUin = LoginData.getInstance().getUin();
        this.req = batchGetFacadeReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return KEY_DIY_REQ;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof BatchGetFacadeRsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f47532a = ((BatchGetFacadeRsp) jceStruct).info;
        return aVar;
    }
}
