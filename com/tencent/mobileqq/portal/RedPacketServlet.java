package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Screen;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x6ff.subcmd0x501$ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501$SubCmd0x501ReqBody;
import tencent.im.new_year_2021.FestivalPack$NewYearEvePackReq;
import tencent.im.new_year_2021.FestivalPack$PkgReq;
import tencent.im.new_year_2021.Pack2021$Pack;
import tencent.im.new_year_2021.Unisso$UniSsoServerReq;
import tencent.im.new_year_2021.Unisso$UniSsoServerReqComm;
import tencent.im.new_year_ranking.PackRanking$PkgReq;
import tencent.im.new_year_ranking.PackRanking$QueryRankingReq;
import tencent.im.new_year_report.PackReport$PkgReq;
import tencent.im.new_year_report.PackReport$Report;
import tencent.im.new_year_report.PackReport$ReportElem;
import tencent.im.new_year_report.PackShareReport$PkgHead;
import tencent.im.new_year_report.PackShareReport$PkgReq;
import tencent.im.new_year_report.PackShareReport$ReportShareReq;

/* loaded from: classes16.dex */
public class RedPacketServlet extends com.tencent.biz.m {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f259337d;

    /* loaded from: classes16.dex */
    public static class BrashReportItem implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public int count;
        public long time;

        public BrashReportItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73659);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f259337d = 0;
        }
    }

    public RedPacketServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(AppRuntime appRuntime, int i3, int i16, int i17, byte[] bArr, byte[] bArr2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("RedPacketServlet", 2, "getConfig, " + i3 + ", " + i16 + ", " + i17 + ", " + bArr + ", " + bArr2);
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), RedPacketServlet.class);
        newIntent.putExtra("k_cmd", 2);
        newIntent.putExtra("k_offset", i16);
        newIntent.putExtra("k_id", i17);
        newIntent.putExtra("k_version", i3);
        newIntent.putExtra("k_cookie", bArr);
        newIntent.putExtra("k_buff", bArr2);
        if (i16 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        newIntent.putExtra("k_new_page", z16);
        appRuntime.startServlet(newIntent);
    }

    public static void b(int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.d("RedPacketServlet", 2, "requestResult, reqType " + i17 + ", reqNumber " + i16);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), RedPacketServlet.class);
        newIntent.putExtra("k_cmd", 8);
        newIntent.putExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, peekAppRuntime.getAccount());
        newIntent.putExtra("k_type", i3);
        newIntent.putExtra("k_count", i16);
        newIntent.putExtra("key_seq", i18);
        newIntent.putExtra("k_r_type", i17);
        peekAppRuntime.startServlet(newIntent);
    }

    private byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private void d(Pack2021$Pack pack2021$Pack, Bundle bundle) {
        String str;
        int e16 = e(pack2021$Pack.state);
        int e17 = e(pack2021$Pack.money);
        int e18 = e(pack2021$Pack.type);
        int e19 = e(pack2021$Pack.promotion_id);
        int e26 = e(pack2021$Pack.business_id);
        int e27 = e(pack2021$Pack.ctime);
        int e28 = e(pack2021$Pack.mtime);
        Long f16 = f(pack2021$Pack.uin);
        Long f17 = f(pack2021$Pack.send_uin);
        String str2 = "";
        if (!pack2021$Pack.pack_id.has()) {
            str = "";
        } else {
            str = pack2021$Pack.pack_id.get().toStringUtf8();
        }
        if (pack2021$Pack.signature.has()) {
            str2 = pack2021$Pack.signature.get().toStringUtf8();
        }
        String g16 = g(pack2021$Pack.req_id);
        String g17 = g(pack2021$Pack.url);
        String str3 = str2;
        String g18 = g(pack2021$Pack.wishing);
        String g19 = g(pack2021$Pack.order);
        String g26 = g(pack2021$Pack.business_name);
        String g27 = g(pack2021$Pack.business_logo);
        String g28 = g(pack2021$Pack.business_video);
        String g29 = g(pack2021$Pack.business_cover);
        String g36 = g(pack2021$Pack.business_video_cover);
        String g37 = g(pack2021$Pack.business_name_pic);
        bundle.putInt("key_promotion_id", e19);
        bundle.putInt("k_state", e16);
        bundle.putInt("key_award_type", e18);
        bundle.putInt("k_money", e17);
        bundle.putInt("key_business_id", e26);
        bundle.putInt("k_c_time", e27);
        bundle.putInt("key_mtime", e28);
        bundle.putLong(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, f16.longValue());
        bundle.putLong("key_send_uin", f17.longValue());
        bundle.putString("k_pack_id", str);
        bundle.putString("key_url", g17);
        bundle.putString("key_req_id", g16);
        bundle.putString("key_order", g19);
        bundle.putString("key_signature", str3);
        bundle.putString("key_wishing", g18);
        bundle.putString("key_business_name", g26);
        bundle.putString("key_business_video", g28);
        bundle.putString("key_business_cover", g29);
        bundle.putString("key_business_logo", g27);
        bundle.putString("key_business_video_cover", g36);
        bundle.putString("key_business_name_pic", g37);
        if (QLog.isColorLevel()) {
            QLog.d("RedPacketServlet", 2, "parsePackData pack_id = " + str + "\nbusiness_id = " + e26 + "\nstate = " + e16 + "\nmoney = " + e17 + "\nmtime = " + e28 + "\nawardType = " + e18 + "\nwishing = " + g18 + "\norder = " + g19 + "\nsignature = " + str3 + "\nreq_id = " + g16 + "\npromotion_id = " + e19 + "\nsend_uin = " + f17 + "\nuin = " + f16 + "\nctime = " + e27 + "\npackUrl = " + g17 + "\nbusiness_name = " + g26 + "\nbusiness_logo = " + g27 + "\nbusiness_cover = " + g29 + "\nbusiness_video = " + g28 + "\nbusiness_video_cover = " + g36 + "\n", "business_name_pic = " + g37);
        }
    }

    private int e(PBUInt32Field pBUInt32Field) {
        if (pBUInt32Field.has()) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    private Long f(PBUInt64Field pBUInt64Field) {
        if (pBUInt64Field.has()) {
            return Long.valueOf(pBUInt64Field.get());
        }
        return 0L;
    }

    private String g(PBStringField pBStringField) {
        if (pBStringField.has()) {
            return pBStringField.get();
        }
        return "";
    }

    public static void h(int i3, ArrayList<BrashReportItem> arrayList, boolean z16, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("RedPacketServlet", 2, "reportBrashCount, " + bundle);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), RedPacketServlet.class);
        newIntent.putExtra("k_cmd", 7);
        newIntent.putExtra("k_id", i3);
        newIntent.putExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, peekAppRuntime.getAccount());
        newIntent.putExtra("k_b_ing", z16);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("k_b_list", arrayList);
        bundle2.putAll(bundle);
        newIntent.putExtras(bundle2);
        peekAppRuntime.startServlet(newIntent);
    }

    private void i(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i26 >= 2 && NetworkUtil.isNetworkAvailable(BaseApplicationImpl.sApplication)) {
            if (QLog.isColorLevel()) {
                QLog.d("RedPacketServlet", 2, "reportConfig, " + i3 + ", " + i16 + ", " + i17 + ", " + i18 + ", " + i19);
            }
            NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
            newIntent.putExtra("k_cmd", 4);
            newIntent.putExtra("k_type", i3);
            newIntent.putExtra("k_version", i16);
            newIntent.putExtra("k_id", i17);
            newIntent.putExtra("k_opt", i18);
            newIntent.putExtra("k_code", i19);
            getAppRuntime().startServlet(newIntent);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    public void onReceive(android.content.Intent r33, com.tencent.qphone.base.remote.FromServiceMsg r34) {
        /*
            Method dump skipped, instructions count: 2034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.portal.RedPacketServlet.onReceive(android.content.Intent, com.tencent.qphone.base.remote.FromServiceMsg):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0063. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x057f A[ADDED_TO_REGION] */
    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSend(Intent intent, Packet packet) {
        int i3;
        String str;
        String str2;
        int i16;
        byte[] b16;
        String str3;
        byte[] bArr;
        String str4;
        ArrayList arrayList;
        long j3;
        int i17;
        byte[] b17;
        String str5;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra("k_cmd", -1);
        int intExtra2 = intent.getIntExtra("k_retry", 0);
        boolean booleanExtra = intent.getBooleanExtra("k_new_page", false);
        String str6 = "k_sso_data";
        String str7 = "k_sso_id";
        if (intExtra2 != 0 && !booleanExtra) {
            str4 = intent.getStringExtra("k_sso_id");
            bArr = intent.getByteArrayExtra("k_sso_data");
            intent.putExtra("k_new_page", false);
            i16 = intExtra;
            i3 = intExtra2;
        } else {
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra != 4) {
                        switch (intExtra) {
                            case 7:
                                i3 = intExtra2;
                                Unisso$UniSsoServerReq unisso$UniSsoServerReq = new Unisso$UniSsoServerReq();
                                PackReport$PkgReq packReport$PkgReq = new PackReport$PkgReq();
                                packReport$PkgReq.promotion_id.set(intent.getIntExtra("k_id", -1));
                                packReport$PkgReq.uin.set(Long.valueOf(intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN)).longValue());
                                long longExtra = intent.getLongExtra("key_seq", -1L);
                                if (longExtra == -1) {
                                    longExtra = NetConnInfoCenter.getServerTimeMillis();
                                    intent.putExtra("key_seq", longExtra);
                                }
                                packReport$PkgReq.seq.set(longExtra);
                                Bundle extras = intent.getExtras();
                                if (extras == null || (arrayList = (ArrayList) extras.getSerializable("k_b_list")) == null) {
                                    return;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                PackReport$Report packReport$Report = new PackReport$Report();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    BrashReportItem brashReportItem = (BrashReportItem) it.next();
                                    PackReport$ReportElem packReport$ReportElem = new PackReport$ReportElem();
                                    packReport$ReportElem.count.set(brashReportItem.count);
                                    packReport$ReportElem.timestamp.set(brashReportItem.time);
                                    packReport$Report.elems.add(packReport$ReportElem);
                                    it = it;
                                    str7 = str7;
                                    str6 = str6;
                                }
                                str = str6;
                                str2 = str7;
                                PBUInt64Field pBUInt64Field = packReport$Report.f435963id;
                                if (intent.getBooleanExtra("k_b_ing", false)) {
                                    j3 = 200;
                                } else {
                                    j3 = 100;
                                }
                                pBUInt64Field.set(j3);
                                arrayList2.add(packReport$Report);
                                if (extras.containsKey("k_e_ctr")) {
                                    PackReport$Report packReport$Report2 = new PackReport$Report();
                                    packReport$Report2.f435963id.set(300L);
                                    PackReport$ReportElem packReport$ReportElem2 = new PackReport$ReportElem();
                                    i16 = intExtra;
                                    packReport$ReportElem2.count.set(extras.getInt("k_e_ctr"));
                                    packReport$ReportElem2.timestamp.set(extras.getLong("k_s_time"));
                                    packReport$Report2.elems.add(packReport$ReportElem2);
                                    arrayList2.add(packReport$Report2);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("RedPacketServlet", 2, "onSend, report EMPTY_COUNTER , elem.count = " + packReport$ReportElem2.count.get());
                                    }
                                } else {
                                    i16 = intExtra;
                                }
                                if (extras.containsKey("k_h_ctr")) {
                                    PackReport$Report packReport$Report3 = new PackReport$Report();
                                    packReport$Report3.f435963id.set(400L);
                                    PackReport$ReportElem packReport$ReportElem3 = new PackReport$ReportElem();
                                    packReport$ReportElem3.count.set(extras.getInt("k_h_ctr"));
                                    packReport$ReportElem3.timestamp.set(extras.getLong("k_s_time"));
                                    packReport$Report3.elems.add(packReport$ReportElem3);
                                    arrayList2.add(packReport$Report3);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("RedPacketServlet", 2, "onSend, report HIT_COUNTER , elem.count = " + packReport$ReportElem3.count.get());
                                    }
                                }
                                if (extras.containsKey("k_c_ctr")) {
                                    PackReport$Report packReport$Report4 = new PackReport$Report();
                                    packReport$Report4.f435963id.set(500L);
                                    PackReport$ReportElem packReport$ReportElem4 = new PackReport$ReportElem();
                                    packReport$ReportElem4.count.set(extras.getInt("k_c_ctr"));
                                    packReport$ReportElem4.timestamp.set(extras.getLong("k_s_time"));
                                    packReport$Report4.elems.add(packReport$ReportElem4);
                                    arrayList2.add(packReport$Report4);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("RedPacketServlet", 2, "onSend, report reportContinuous , elem.count = " + packReport$ReportElem4.count.get());
                                    }
                                }
                                packReport$PkgReq.report.set(arrayList2);
                                unisso$UniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(packReport$PkgReq.toByteArray()));
                                b16 = fh.b(unisso$UniSsoServerReq.toByteArray());
                                intent.putExtra("k_retry", 2);
                                str3 = "NewYearReport.pack_report";
                                break;
                                break;
                            case 8:
                                i3 = intExtra2;
                                i17 = intExtra;
                                Unisso$UniSsoServerReq unisso$UniSsoServerReq2 = new Unisso$UniSsoServerReq();
                                PackRanking$PkgReq packRanking$PkgReq = new PackRanking$PkgReq();
                                packRanking$PkgReq.uin.set(Long.valueOf(intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN)).longValue());
                                packRanking$PkgReq.cmdtype.set(1);
                                PackRanking$QueryRankingReq packRanking$QueryRankingReq = new PackRanking$QueryRankingReq();
                                packRanking$QueryRankingReq.flag.set(intent.getIntExtra("k_type", 3));
                                packRanking$QueryRankingReq.num.set(intent.getIntExtra("k_count", 200));
                                packRanking$PkgReq.query_ranking.set(packRanking$QueryRankingReq);
                                unisso$UniSsoServerReq2.reqdata.set(ByteStringMicro.copyFrom(packRanking$PkgReq.toByteArray()));
                                b17 = fh.b(unisso$UniSsoServerReq2.toByteArray());
                                intent.putExtra("k_retry", 2);
                                str5 = "NewYearReport.pack_ranking";
                                bArr = b17;
                                str4 = str5;
                                str = "k_sso_data";
                                str2 = "k_sso_id";
                                i16 = i17;
                                if (str4 != null && !booleanExtra) {
                                    intent.putExtra(str2, str4);
                                    intent.putExtra(str, bArr);
                                    break;
                                }
                                break;
                            case 9:
                                Bundle extras2 = intent.getExtras();
                                if (extras2 == null) {
                                    return;
                                }
                                Unisso$UniSsoServerReq unisso$UniSsoServerReq3 = new Unisso$UniSsoServerReq();
                                PackShareReport$PkgReq packShareReport$PkgReq = new PackShareReport$PkgReq();
                                PackShareReport$PkgHead packShareReport$PkgHead = new PackShareReport$PkgHead();
                                i3 = intExtra2;
                                packShareReport$PkgHead.cmdtype.set(1);
                                i17 = intExtra;
                                packShareReport$PkgHead.uin.set(Long.valueOf(intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN)).longValue());
                                long longExtra2 = intent.getLongExtra("key_seq", -1L);
                                if (longExtra2 == -1) {
                                    j16 = NetConnInfoCenter.getServerTimeMillis();
                                    intent.putExtra("key_seq", j16);
                                } else {
                                    j16 = longExtra2;
                                }
                                packShareReport$PkgHead.seq.set(j16);
                                PackShareReport$ReportShareReq packShareReport$ReportShareReq = new PackShareReport$ReportShareReq();
                                packShareReport$ReportShareReq.promotion_id.set(extras2.getInt("k_id", -1));
                                packShareReport$ReportShareReq.share_channel.set(extras2.getInt("k_s_channel", -1));
                                packShareReport$ReportShareReq.share_type.set(extras2.getInt("k_s_type", -1));
                                packShareReport$ReportShareReq.swipe_count.set(extras2.getInt("key_totalcnt", -1));
                                packShareReport$ReportShareReq.combo_count.set(extras2.getInt("key_combocnt", -1));
                                packShareReport$ReportShareReq.win_money_count.set(extras2.getInt("k_money", -1));
                                packShareReport$ReportShareReq.win_goods_count.set(extras2.getInt("key_goodscnt", -1));
                                packShareReport$ReportShareReq.share_error.set(extras2.getInt("key_errorCode", -1));
                                packShareReport$PkgReq.report_share.set(packShareReport$ReportShareReq);
                                packShareReport$PkgReq.head.set(packShareReport$PkgHead);
                                unisso$UniSsoServerReq3.reqdata.set(ByteStringMicro.copyFrom(packShareReport$PkgReq.toByteArray()));
                                b17 = fh.b(unisso$UniSsoServerReq3.toByteArray());
                                intent.putExtra("k_retry", 2);
                                str5 = "NewYearReport.pack_share";
                                bArr = b17;
                                str4 = str5;
                                str = "k_sso_data";
                                str2 = "k_sso_id";
                                i16 = i17;
                                if (str4 != null) {
                                    intent.putExtra(str2, str4);
                                    intent.putExtra(str, bArr);
                                    break;
                                }
                                break;
                            case 10:
                                if (intent.getExtras() == null) {
                                    return;
                                }
                                subcmd0x501$SubCmd0x501ReqBody subcmd0x501_subcmd0x501reqbody = new subcmd0x501$SubCmd0x501ReqBody();
                                subcmd0x501_subcmd0x501reqbody.uint64_uin.set(Long.valueOf(intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN)).longValue());
                                subcmd0x501_subcmd0x501reqbody.uint32_idc_id.set(0);
                                subcmd0x501_subcmd0x501reqbody.uint32_appid.set(16);
                                subcmd0x501_subcmd0x501reqbody.uint32_login_sig_type.set(1);
                                subcmd0x501_subcmd0x501reqbody.uint32_request_flag.set(4);
                                subcmd0x501$ReqBody subcmd0x501_reqbody = new subcmd0x501$ReqBody();
                                subcmd0x501_reqbody.msg_subcmd_0x501_req_body.set(subcmd0x501_subcmd0x501reqbody);
                                byte[] b18 = fh.b(subcmd0x501_reqbody.toByteArray());
                                intent.putExtra("k_retry", 2);
                                bArr = b18;
                                str4 = NearbyPeoplePicUpHandler.CMD_GET_IP_LIST;
                                i3 = intExtra2;
                                str = "k_sso_data";
                                str2 = "k_sso_id";
                                i16 = intExtra;
                                if (str4 != null) {
                                }
                                break;
                            default:
                                str4 = null;
                                bArr = null;
                                i3 = intExtra2;
                                str = "k_sso_data";
                                str2 = "k_sso_id";
                                i16 = intExtra;
                                if (str4 != null) {
                                }
                                break;
                        }
                    } else {
                        i3 = intExtra2;
                        str = "k_sso_data";
                        str2 = "k_sso_id";
                        i16 = intExtra;
                        ConfigurationService$ReqReportConfig configurationService$ReqReportConfig = new ConfigurationService$ReqReportConfig();
                        ConfigurationService$ReportConfig configurationService$ReportConfig = new ConfigurationService$ReportConfig();
                        configurationService$ReportConfig.type.set(intent.getIntExtra("k_type", -1));
                        configurationService$ReportConfig.task_id.set(intent.getIntExtra("k_id", -1));
                        configurationService$ReportConfig.version.set(intent.getIntExtra("k_version", -1));
                        configurationService$ReportConfig.report_type.set(intent.getIntExtra("k_opt", -1));
                        configurationService$ReportConfig.result.set(intent.getIntExtra("k_code", -1));
                        configurationService$ReqReportConfig.config_list.add(configurationService$ReportConfig);
                        b16 = fh.b(configurationService$ReqReportConfig.toByteArray());
                        intent.putExtra("k_retry", 2);
                        str3 = "ConfigurationService.ReqReportConfig";
                    }
                } else {
                    i3 = intExtra2;
                    str = "k_sso_data";
                    str2 = "k_sso_id";
                    i16 = intExtra;
                    int intExtra3 = intent.getIntExtra("k_id", 0);
                    int intExtra4 = intent.getIntExtra("k_offset", 0);
                    int intExtra5 = intent.getIntExtra("k_version", 0);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("k_cookie");
                    ConfigurationService$ReqGetConfigByPage configurationService$ReqGetConfigByPage = new ConfigurationService$ReqGetConfigByPage();
                    ConfigurationService$PageReqInfo configurationService$PageReqInfo = new ConfigurationService$PageReqInfo();
                    configurationService$PageReqInfo.task_id.set(intExtra3);
                    configurationService$PageReqInfo.offset.set(intExtra4);
                    configurationService$PageReqInfo.version.set(intExtra5);
                    if (byteArrayExtra != null) {
                        configurationService$PageReqInfo.cookies.set(ByteStringMicro.copyFrom(byteArrayExtra));
                    }
                    configurationService$ReqGetConfigByPage.page_info.set(configurationService$PageReqInfo);
                    ConfigurationService$DeviceInfo configurationService$DeviceInfo = new ConfigurationService$DeviceInfo();
                    ConfigurationService$Screen configurationService$Screen = new ConfigurationService$Screen();
                    configurationService$Screen.setHasFlag(true);
                    configurationService$Screen.model.set("");
                    configurationService$Screen.width.set((int) ah.x());
                    configurationService$Screen.height.set((int) ah.w());
                    configurationService$Screen.dpi.set(ah.v());
                    configurationService$Screen.multi_touch.set(ah.q0());
                    configurationService$DeviceInfo.setHasFlag(true);
                    configurationService$DeviceInfo.screen = configurationService$Screen;
                    configurationService$ReqGetConfigByPage.device_info.set(configurationService$DeviceInfo);
                    configurationService$ReqGetConfigByPage.type.set(1004);
                    b16 = fh.b(configurationService$ReqGetConfigByPage.toByteArray());
                    str3 = "ConfigurationService.ReqGetConfigByPage";
                }
            } else {
                i3 = intExtra2;
                str = "k_sso_data";
                str2 = "k_sso_id";
                i16 = intExtra;
                Unisso$UniSsoServerReq unisso$UniSsoServerReq4 = new Unisso$UniSsoServerReq();
                FestivalPack$PkgReq festivalPack$PkgReq = new FestivalPack$PkgReq();
                int intExtra6 = intent.getIntExtra("k_condition", 0);
                int intExtra7 = intent.getIntExtra("k_id", 0);
                if (QLog.isColorLevel()) {
                    QLog.d("RedPacketServlet", 2, "onSend CMD_RESULT promotionID = " + intExtra7 + ",condition = " + intExtra6);
                }
                FestivalPack$NewYearEvePackReq festivalPack$NewYearEvePackReq = new FestivalPack$NewYearEvePackReq();
                festivalPack$NewYearEvePackReq.promotion_id.set(intExtra7);
                festivalPack$NewYearEvePackReq.action.set(1);
                festivalPack$NewYearEvePackReq.condition.set(intExtra6);
                festivalPack$PkgReq.cmdtype.set(1);
                festivalPack$PkgReq.from_id.set(1);
                festivalPack$PkgReq.get_eve_pack.set(festivalPack$NewYearEvePackReq);
                Unisso$UniSsoServerReqComm unisso$UniSsoServerReqComm = new Unisso$UniSsoServerReqComm();
                unisso$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
                unisso$UniSsoServerReqComm.platform.set(109L);
                unisso$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                unisso$UniSsoServerReq4.comm.set(unisso$UniSsoServerReqComm);
                unisso$UniSsoServerReq4.reqdata.set(ByteStringMicro.copyFrom(festivalPack$PkgReq.toByteArray()));
                b16 = fh.b(unisso$UniSsoServerReq4.toByteArray());
                intent.putExtra("k_retry", 2);
                str3 = "NY2021Lottery.shua";
            }
            bArr = b16;
            str4 = str3;
            if (str4 != null) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RedPacketServlet", 2, "onSend, " + i16 + ", " + i3 + ", " + booleanExtra + ", " + str4 + ", " + bArr);
        }
        if (str4 != null && bArr != null) {
            packet.setSSOCommand(str4);
            packet.putSendData(bArr);
        }
    }
}
