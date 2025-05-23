package com.tencent.mobileqq.comment;

import android.content.Intent;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.comment.b;
import com.tencent.mobileqq.comment.c;
import com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$Comment;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$GetBarrageListReqBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$GetBarrageListRspBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$ReqBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends MSFServlet {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(b.a aVar, oidb_0xdea$GetBarrageListRspBody oidb_0xdea_getbarragelistrspbody) {
        int i3 = oidb_0xdea_getbarragelistrspbody.int32_ret_code.get();
        String str = oidb_0xdea_getbarragelistrspbody.str_err_msg.get();
        String str2 = oidb_0xdea_getbarragelistrspbody.str_wording.get();
        boolean z16 = oidb_0xdea_getbarragelistrspbody.bool_is_end.get();
        int i16 = oidb_0xdea_getbarragelistrspbody.uint32_total_count.get();
        int i17 = oidb_0xdea_getbarragelistrspbody.uint32_next_start_index.get();
        List<oidb_0xdea$Comment> list = oidb_0xdea_getbarragelistrspbody.rpt_comment_list.get();
        List<Long> list2 = oidb_0xdea_getbarragelistrspbody.rpt_recall_del_seq_list.get();
        int i18 = oidb_0xdea_getbarragelistrspbody.uint32_last_update_time.get();
        int i19 = oidb_0xdea_getbarragelistrspbody.uint32_time_interval.get();
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "handleDanmuRspPack barrInfo:" + ("lastUpdateTime:" + i18 + ", intervalTime:" + i19 + ", retCode:" + i3 + ", errInfo:" + str + ", errInfoShow:" + str2 + ", isFinish:" + z16 + ", totalCount:" + i16 + ", nextStartIdx:" + i17 + ", danmuItemListSize:" + list.size() + ", recallDeleteList:" + list2.toString()));
        }
        aVar.d(((IDanmakuDecode) QRoute.api(IDanmakuDecode.class)).decodeCommentList(list, aVar.f201747b.f201736b, b.f().f201744c, b.f().f201745d)).j(list2).h(i18).g(i19).i(i17).f(z16).n();
    }

    private oidb_0xdea$GetBarrageListRspBody b(FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length != 0) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            byte[] bArr = new byte[r8.getInt() - 4];
            ByteBuffer.wrap(wupBuffer).get(bArr);
            try {
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                if (QLog.isColorLevel()) {
                    QLog.d("DanmuDataHolder", 2, "parseDanmuRspBody, errorStr:" + (" oidbHeader: " + i3 + " errorStr: " + str));
                }
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                try {
                    oidb_0xdea$RspBody oidb_0xdea_rspbody = new oidb_0xdea$RspBody();
                    oidb_0xdea_rspbody.mergeFrom(byteArray);
                    return oidb_0xdea_rspbody.get_barrage_list_rsp.get();
                } catch (Exception e16) {
                    QLog.d("DanmuDataHolder", 1, "parseDanmuRspBody, e: " + e16);
                    return null;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.d("DanmuDataHolder", 1, "parseDanmuRspBody: mergeFrom:" + e17);
            }
        }
        return null;
    }

    public static void c(boolean z16, int i3, int i16, boolean z17, String str) {
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        String str3 = "1";
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("eventSuccess", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(i3));
        hashMap.put("mediaType", String.valueOf(i16));
        if (!z17) {
            str3 = "0";
        }
        hashMap.put("rspValid", str3);
        hashMap.put("errInfo", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), StatisticCollector.DANMAKU_REQUEST_MONITOR, z16, 0L, 0L, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b.a aVar) {
        boolean z16;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DanmuDataHolder", 2, "request called, reqHolder null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "request called, param:" + aVar.m());
        }
        oidb_0xdea$GetBarrageListReqBody oidb_0xdea_getbarragelistreqbody = new oidb_0xdea$GetBarrageListReqBody();
        oidb_0xdea_getbarragelistreqbody.uint64_group_code.set(aVar.f201747b.f201736b);
        oidb_0xdea_getbarragelistreqbody.uint64_barrage_seq.set(aVar.f201747b.f201735a);
        oidb_0xdea_getbarragelistreqbody.uint32_last_update_time.set(aVar.f201749d);
        oidb_0xdea_getbarragelistreqbody.uint32_start_index.set(aVar.f201757l);
        oidb_0xdea_getbarragelistreqbody.uint32_barrage_count.set(aVar.f201758m);
        int i3 = aVar.f201747b.f201737c;
        if (i3 != 101 && i3 != 103) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            oidb_0xdea_getbarragelistreqbody.uint32_video_start_time.set(aVar.f201755j);
            oidb_0xdea_getbarragelistreqbody.uint32_video_end_time.set(aVar.f201756k);
        } else {
            oidb_0xdea_getbarragelistreqbody.uint32_video_start_time.set(0);
            oidb_0xdea_getbarragelistreqbody.uint32_video_end_time.set(0);
        }
        oidb_0xdea_getbarragelistreqbody.terminal.set(0);
        switch (aVar.f201747b.f201737c) {
            case 100:
                oidb_0xdea_getbarragelistreqbody.entrance.set(1);
                break;
            case 101:
                oidb_0xdea_getbarragelistreqbody.entrance.set(2);
                break;
            case 102:
                oidb_0xdea_getbarragelistreqbody.entrance.set(3);
                break;
            case 103:
                oidb_0xdea_getbarragelistreqbody.entrance.set(4);
                break;
        }
        oidb_0xdea$ReqBody oidb_0xdea_reqbody = new oidb_0xdea$ReqBody();
        oidb_0xdea_reqbody.get_barrage_list_req.set(oidb_0xdea_getbarragelistreqbody);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApp(), d.class);
        newIntent.putExtra("KEY_SEND_DATA", oidb_0xdea_reqbody.toByteArray());
        newIntent.putExtra("KEY_GROUP_UIN", aVar.f201747b.f201736b);
        newIntent.putExtra("KEY_TOPIC_UIN", aVar.f201747b.f201735a);
        waitAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        String str;
        Collection collection;
        oidb_0xdea$GetBarrageListRspBody b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "onReceive:" + fromServiceMsg);
        }
        int resultCode = fromServiceMsg.getResultCode();
        long longExtra = intent.getLongExtra("KEY_TOPIC_UIN", 0L);
        long longExtra2 = intent.getLongExtra("KEY_GROUP_UIN", 0L);
        boolean z17 = true;
        boolean z18 = false;
        if (longExtra != 0 && longExtra2 != 0) {
            b.a c16 = b.f().c(b.f().d(longExtra2, longExtra));
            if (c16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("DanmuDataHolder", 2, "onReceive, holder null");
                }
                if (resultCode != 1000) {
                    z17 = false;
                }
                c(z17, resultCode, -1, false, "onReceive, holder null");
                return;
            }
            if (fromServiceMsg.isSuccess() && (b16 = b(fromServiceMsg)) != null) {
                a(c16, b16);
                z16 = true;
            } else {
                z16 = false;
            }
            if (resultCode == 1000) {
                z18 = true;
            }
            int i3 = c16.f201747b.f201737c;
            if (z16) {
                str = "DanmuRsp Valid";
            } else {
                str = "DanmuRsp Null";
            }
            c(z18, resultCode, i3, z16, str);
            if (z16) {
                c.InterfaceC7462c interfaceC7462c = c16.f201746a;
                a aVar = c16.f201747b;
                boolean z19 = c16.f201748c;
                int i16 = c16.f201750e;
                if (aVar.f201738d) {
                    collection = c16.f201753h;
                } else {
                    collection = c16.f201754i;
                }
                interfaceC7462c.onDanmuPullResult(aVar, true, z19, i16, (ArrayList) collection, c16.f201751f);
                c16.f201747b.f201738d = true;
            } else {
                c16.f201746a.onDanmuPullResult(c16.f201747b, false, c16.f201748c, c16.f201750e, null, null);
            }
            if (z16 && !c16.f201748c) {
                if (QLog.isColorLevel()) {
                    QLog.i("DanmuDataHolder", 2, "onReceive, \u6ca1\u6709\u7ed3\u675f\uff0c\u63a5\u529b\u62c9\u53d6");
                }
                d(c16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "onReceive, topicUin:0, groupUin:0");
        }
        if (resultCode != 1000) {
            z17 = false;
        }
        c(z17, resultCode, -1, false, "onReceive, topicUin:0, groupUin:0");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("KEY_SEND_DATA");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3562);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(byteArrayExtra));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        packet.setSSOCommand("OidbSvc.0xdea");
        packet.putSendData(bArr);
    }
}
