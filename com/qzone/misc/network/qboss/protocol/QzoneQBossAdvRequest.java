package com.qzone.misc.network.qboss.protocol;

import BOSSStrategyCenter.tAdvAppInfo;
import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import NS_MOBILE_QBOSS_PROTO.SceneExt;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneQBossAdvRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "mobileqboss.get";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f48460a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, ArrayList<tAdvDesc>> f48461b;
    }

    public QzoneQBossAdvRequest(long j3, int i3, boolean z16) {
        super(CMD_STRING, true);
        MobileQbossAdvReq mobileQbossAdvReq = new MobileQbossAdvReq();
        mobileQbossAdvReq.uiUin = j3;
        ArrayList<tAdvAppInfo> arrayList = new ArrayList<>(1);
        tAdvAppInfo tadvappinfo = new tAdvAppInfo();
        tadvappinfo.app_id = i3;
        arrayList.add(tadvappinfo);
        mobileQbossAdvReq.vecReqApp = arrayList;
        mobileQbossAdvReq.iPullAsExposeOper = z16 ? 1 : 0;
        mobileQbossAdvReq.iReqFlag = 1;
        this.req = mobileQbossAdvReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "get";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof MobileQbossAdvRsp)) {
            return null;
        }
        a aVar = new a();
        MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) jceStruct;
        aVar.f48460a = mobileQbossAdvRsp.iRet;
        aVar.f48461b = mobileQbossAdvRsp.mapAdv;
        return aVar;
    }

    public QzoneQBossAdvRequest(long j3, int i3, int i16, boolean z16) {
        super(CMD_STRING, true);
        MobileQbossAdvReq mobileQbossAdvReq = new MobileQbossAdvReq();
        mobileQbossAdvReq.uiUin = j3;
        ArrayList<tAdvAppInfo> arrayList = new ArrayList<>(1);
        tAdvAppInfo tadvappinfo = new tAdvAppInfo();
        tadvappinfo.app_id = i3;
        tadvappinfo.i_need_adv_cnt = i16;
        arrayList.add(tadvappinfo);
        mobileQbossAdvReq.vecReqApp = arrayList;
        mobileQbossAdvReq.iPullAsExposeOper = z16 ? 1 : 0;
        mobileQbossAdvReq.iReqFlag = 1;
        this.req = mobileQbossAdvReq;
    }

    public QzoneQBossAdvRequest(long j3, int i3) {
        super(CMD_STRING, true);
        MobileQbossAdvReq mobileQbossAdvReq = new MobileQbossAdvReq();
        mobileQbossAdvReq.uiUin = j3;
        ArrayList<tAdvAppInfo> arrayList = new ArrayList<>(1);
        tAdvAppInfo tadvappinfo = new tAdvAppInfo();
        tadvappinfo.app_id = i3;
        arrayList.add(tadvappinfo);
        mobileQbossAdvReq.vecReqApp = arrayList;
        this.req = mobileQbossAdvReq;
    }

    public QzoneQBossAdvRequest(long j3, ArrayList<Integer> arrayList) {
        super(CMD_STRING, true);
        MobileQbossAdvReq mobileQbossAdvReq = new MobileQbossAdvReq();
        mobileQbossAdvReq.uiUin = j3;
        ArrayList<tAdvAppInfo> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            tAdvAppInfo tadvappinfo = new tAdvAppInfo();
            tadvappinfo.app_id = intValue;
            arrayList2.add(tadvappinfo);
        }
        mobileQbossAdvReq.vecReqApp = arrayList2;
        this.req = mobileQbossAdvReq;
    }

    public QzoneQBossAdvRequest(long j3, int i3, int i16, Map<String, String> map, boolean z16) {
        super(CMD_STRING, true);
        MobileQbossAdvReq mobileQbossAdvReq = new MobileQbossAdvReq();
        mobileQbossAdvReq.uiUin = j3;
        ArrayList<tAdvAppInfo> arrayList = new ArrayList<>(1);
        tAdvAppInfo tadvappinfo = new tAdvAppInfo();
        tadvappinfo.app_id = i3;
        arrayList.add(tadvappinfo);
        mobileQbossAdvReq.vecReqApp = arrayList;
        mobileQbossAdvReq.iPullAsExposeOper = z16 ? 1 : 0;
        new HashMap().put(Integer.valueOf(i16), new SceneExt(map));
        this.req = mobileQbossAdvReq;
    }
}
