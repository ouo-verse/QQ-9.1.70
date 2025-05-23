package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bz;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4$RspBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyRelevantHandler extends BusinessHandler implements d {

    /* renamed from: f, reason: collision with root package name */
    public static final String f252511f = "com.tencent.mobileqq.nearby.NearbyRelevantHandler";

    /* renamed from: d, reason: collision with root package name */
    protected Set<String> f252512d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f252513e;

    public NearbyRelevantHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f252513e = qQAppInterface;
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        cmd0x9e4$RspBody cmd0x9e4_rspbody = new cmd0x9e4$RspBody();
        if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9e4_rspbody) == 0 && cmd0x9e4_rspbody.rpt_msg_uin_data.has() && cmd0x9e4_rspbody.rpt_msg_uin_data.size() > 0) {
            List<cmd0x9e4$UdcUinData> list = cmd0x9e4_rspbody.rpt_msg_uin_data.get();
            ArrayList arrayList = new ArrayList();
            for (cmd0x9e4$UdcUinData cmd0x9e4_udcuindata : list) {
                FansEntity fansEntity = new FansEntity();
                fansEntity.init(cmd0x9e4_udcuindata);
                arrayList.add(fansEntity);
            }
            notifyUI(5, true, new Object[]{arrayList});
            return;
        }
        notifyUI(5, false, null);
    }

    @Override // com.tencent.mobileqq.nearby.d
    public void Q1(byte b16) {
        bz.m(this, b16);
    }

    @Override // com.tencent.mobileqq.nearby.d
    public void R1(String str, String str2, Object obj) {
        if (QLog.isDevelopLevel()) {
            QLog.i("NearbyChatPie", 4, "notifyAutoInput, [" + str + "," + str2 + "," + obj + "," + System.currentTimeMillis() + "]");
        }
        notifyUI(8, true, new Object[]{str, str2, obj});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.f252512d == null) {
            HashSet hashSet = new HashSet();
            this.f252512d = hashSet;
            hashSet.add("OidbSvc.0x9e4_22");
            this.f252512d.add(ProfileContants.CMD_SET_DETAIL_INFO);
            this.f252512d.add("OidbSvc.0x4ff_41993");
        }
        return this.f252512d;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return j.class;
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String valueOf;
        boolean z16 = false;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("NearbyRelevantHandler", 2, "handle_oidb_0x4ff_41933 ret=" + i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    if (4 <= byteArray.length && ((valueOf = String.valueOf(PkgTools.getLongData(byteArray, 0))) == null || !valueOf.equals(this.f252513e.getAccount()))) {
                        if (QLog.isColorLevel()) {
                            QLog.w(LogTag.DATING, 2, "handle_oidb_0x4ff_41933 uin error");
                            return;
                        }
                        return;
                    }
                    z16 = true;
                }
            }
        }
        notifyUI(12, z16, Boolean.valueOf(toServiceMsg.extraData.getBoolean("freshnews_notify_switch", true)));
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg == null || fromServiceMsg == null || msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0x9e4_22".equals(serviceCmd)) {
            D2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x4ff_41993".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
