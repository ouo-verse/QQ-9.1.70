package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qqshop_report$SQQSHPCliLogInfo;
import tencent.im.oidb.qqshop.qqshop_report$SQQSHPCliLogReq;
import tencent.im.oidb.qqshop.qqshop_richmsg$SQQSHPFolderAdMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg$SQQSHPRichMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg$SQQSHPRichMsgReq;
import tencent.im.oidb.qqshop.qqshop_richmsg$SQQSHPRichMsgRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcshopReportHandler extends BusinessHandler {

    /* renamed from: h, reason: collision with root package name */
    static String f79591h;

    /* renamed from: i, reason: collision with root package name */
    static final String f79592i = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f79593d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f79594e;

    /* renamed from: f, reason: collision with root package name */
    public bs f79595f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends bs {
        a() {
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onMessageRecordAdded(List<MessageRecord> list) {
            boolean z16;
            super.onMessageRecordAdded(list);
            EcshopReportHandler ecshopReportHandler = (EcshopReportHandler) EcshopReportHandler.this.f79594e.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) EcshopReportHandler.this.f79594e.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (ecshopReportHandler != null && ecShopAssistantManager != null) {
                for (MessageRecord messageRecord : new ArrayList(list)) {
                    if (!"2".equals(messageRecord.getExtInfoFromExtStr("inter_num")) && (messageRecord.istroop != 1008 || !ServiceAccountFolderManager.j(EcshopReportHandler.this.f79593d, messageRecord.senderuin))) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16 || ecShopAssistantManager.o(messageRecord.senderuin)) {
                        if (z16) {
                            ecshopReportHandler.K2(messageRecord);
                        }
                        ecshopReportHandler.F2(messageRecord);
                    }
                }
            }
        }
    }

    public EcshopReportHandler(AppInterface appInterface) {
        super(appInterface);
        this.f79595f = new a();
        this.f79594e = appInterface;
        if (appInterface instanceof QQAppInterface) {
            this.f79593d = (QQAppInterface) appInterface;
        }
    }

    public void F2(MessageRecord messageRecord) {
        QLog.d("EcshopReportHandler", 1, "doArrivalReport " + messageRecord);
        try {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
            QLog.i("EcshopReportHandler", 1, "doArrivalReport hasAdver: " + messageRecord.getExtInfoFromExtStr("is_AdArrive_Msg"));
            if (messageRecord instanceof MessageForArkApp) {
                H2(134243862, messageRecord.senderuin, extInfoFromExtStr, null, null, 0L, false);
            } else {
                H2(134243856, messageRecord.senderuin, extInfoFromExtStr, null, null, 0L, false);
            }
        } catch (Throwable th5) {
            QLog.e("EcshopReportHandler", 1, "doArrivalReport occur an error: " + th5);
        }
    }

    public void G2(boolean z16, MessageRecord messageRecord, int i3, String str) {
        try {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
            if (z16) {
                H2(134243864, messageRecord.senderuin, extInfoFromExtStr, str, null, i3, false);
            } else {
                H2(134243858, messageRecord.senderuin, extInfoFromExtStr, str, null, i3, false);
            }
        } catch (Throwable unused) {
        }
    }

    public void H2(int i3, String str, String str2, String str3, String str4, long j3, boolean z16) {
        J2(i3, str, str2, str3, str4, j3, 0L, 0L, 0L, z16);
    }

    public void I2(int i3, String str, String str2, String str3, String str4, String str5, long j3, long j16, long j17, long j18, boolean z16) {
        long j19;
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("real time report:[");
        sb5.append(Integer.toHexString(i3));
        sb5.append(",");
        sb5.append(str);
        sb5.append(",");
        String str6 = str2;
        sb5.append(str6);
        sb5.append(",");
        String str7 = str3;
        sb5.append(str7);
        sb5.append(",");
        String str8 = str4;
        sb5.append(str8);
        sb5.append(",");
        String str9 = str5;
        sb5.append(str9);
        sb5.append(",");
        sb5.append(j3);
        sb5.append(",");
        sb5.append(z16);
        sb5.append("]");
        QLog.i("EcshopReportHandler", 2, sb5.toString());
        try {
            i16 = NetworkUtil.getSystemNetwork(this.f79593d.getApp().getApplicationContext());
            j19 = Long.parseLong(str);
        } catch (Exception e16) {
            QLog.e("EcshopReportHandler", 2, "doReport error:", e16);
            j19 = 0;
            i16 = 0;
        }
        QQAppInterface qQAppInterface = this.f79593d;
        String currentAccountUin = qQAppInterface == null ? "" : qQAppInterface.getCurrentAccountUin();
        qqshop_report$SQQSHPCliLogReq qqshop_report_sqqshpclilogreq = new qqshop_report$SQQSHPCliLogReq();
        qqshop_report$SQQSHPCliLogInfo qqshop_report_sqqshpcliloginfo = new qqshop_report$SQQSHPCliLogInfo();
        qqshop_report_sqqshpcliloginfo.puin.set(j19);
        qqshop_report_sqqshpcliloginfo.network.set(i16);
        qqshop_report_sqqshpcliloginfo.cnt.set(1);
        PBStringField pBStringField = qqshop_report_sqqshpcliloginfo.strp1;
        if (TextUtils.isEmpty(str2)) {
            str6 = "";
        }
        pBStringField.set(str6);
        PBStringField pBStringField2 = qqshop_report_sqqshpcliloginfo.strp2;
        if (TextUtils.isEmpty(str3)) {
            str7 = "";
        }
        pBStringField2.set(str7);
        PBStringField pBStringField3 = qqshop_report_sqqshpcliloginfo.strp3;
        if (TextUtils.isEmpty(str4)) {
            str8 = "";
        }
        pBStringField3.set(str8);
        PBStringField pBStringField4 = qqshop_report_sqqshpcliloginfo.strp4;
        if (TextUtils.isEmpty(str5)) {
            str9 = "";
        }
        pBStringField4.set(str9);
        qqshop_report_sqqshpcliloginfo.tvalue.set(i3);
        qqshop_report_sqqshpcliloginfo.uintp1.set(j3);
        qqshop_report_sqqshpcliloginfo.uintp2.set(j16);
        qqshop_report_sqqshpcliloginfo.uintp3.set(j17);
        qqshop_report_sqqshpcliloginfo.uintp4.set(j18);
        if (z16) {
            if (f79591h == null) {
                f79591h = QQDeviceInfo.getMAC(IQWalletHelper.BUSINISS_ID);
            }
            if (!TextUtils.isEmpty(f79591h)) {
                qqshop_report_sqqshpcliloginfo.wifimac.set(f79591h);
            }
        }
        qqshop_report_sqqshpclilogreq.logs.add(qqshop_report_sqqshpcliloginfo);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "SQQShopCliLog.RtReport");
        toServiceMsg.putWupBuffer(qqshop_report_sqqshpclilogreq.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    public void J2(int i3, String str, String str2, String str3, String str4, long j3, long j16, long j17, long j18, boolean z16) {
        I2(i3, str, str2, str3, str4, null, j3, j16, j17, j18, z16);
    }

    public void K2(MessageRecord messageRecord) {
        QQAppInterface qQAppInterface;
        if (messageRecord != null && (qQAppInterface = this.f79593d) != null) {
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            qqshop_richmsg$SQQSHPRichMsgReq qqshop_richmsg_sqqshprichmsgreq = new qqshop_richmsg$SQQSHPRichMsgReq();
            ArrayList arrayList = new ArrayList();
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
            qqshop_richmsg$SQQSHPRichMsg qqshop_richmsg_sqqshprichmsg = new qqshop_richmsg$SQQSHPRichMsg();
            qqshop_richmsg_sqqshprichmsg.msg_id.set(Long.parseLong(extInfoFromExtStr));
            qqshop_richmsg_sqqshprichmsg.puin.set(Long.parseLong(messageRecord.senderuin));
            qqshop_richmsg_sqqshprichmsg.sendtime.set(messageRecord.time);
            arrayList.add(qqshop_richmsg_sqqshprichmsg);
            QLog.i("EcshopReportHandler", 2, "get rich msg:" + extInfoFromExtStr + "," + messageRecord.senderuin + "," + messageRecord.time);
            EcShopData f16 = ecShopAssistantManager.f(messageRecord.senderuin);
            f16.mLastMsgTime = messageRecord.time;
            Message lastMessage = this.f79593d.getMessageFacade().getLastMessage(f16.mUin, 1008);
            if (lastMessage != null) {
                long j3 = lastMessage.time;
                if (j3 > f16.mLastMsgTime) {
                    f16.mLastMsgTime = j3;
                }
            }
            f16.msgId = extInfoFromExtStr;
            f16.mImgInfo = "";
            ecShopAssistantManager.q(f16);
            if (arrayList.isEmpty()) {
                return;
            }
            qqshop_richmsg_sqqshprichmsgreq.rich_msgs.addAll(arrayList);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f79593d.getCurrentAccountUin(), "SQQShopMsgSvc.GetRichMsgInfo");
            toServiceMsg.putWupBuffer(qqshop_richmsg_sqqshprichmsgreq.toByteArray());
            super.sendPbReq(toServiceMsg);
        }
    }

    public void L2() {
        File file = new File(f79592i);
        if (file.exists() && file.isFile()) {
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                JSONArray optJSONArray = jSONObject.optJSONArray(WadlReportBuilder.KEY_REPORT_LIST);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("gtk_list");
                ArrayList arrayList = new ArrayList();
                EcShopAssistantManager.V = new ArrayList();
                boolean z16 = true;
                if (jSONObject.optInt("aio_auto_play", 1) != 1) {
                    z16 = false;
                }
                EcShopAssistantManager.X = z16;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(String.valueOf(optJSONArray.getLong(i3)));
                    }
                }
                EcShopAssistantManager.U = arrayList;
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        EcShopAssistantManager.V.add(String.valueOf(optJSONArray2.getLong(i16)));
                    }
                }
            } catch (Exception e16) {
                QLog.e("EcshopReportHandler", 2, e16, new Object[0]);
            }
        }
        if (EcShopAssistantManager.U == null) {
            EcShopAssistantManager.U = new ArrayList();
        }
        if (EcShopAssistantManager.V == null) {
            EcShopAssistantManager.V = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.biz.pubaccount.ecshopassit.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        QLog.i("EcshopReportHandler", 2, "on receive:" + toServiceMsg.getServiceCmd());
        if ("SQQShopMsgSvc.GetRichMsgInfo".equals(toServiceMsg.getServiceCmd()) && this.f79593d != null && obj != null) {
            qqshop_richmsg$SQQSHPRichMsgRsp qqshop_richmsg_sqqshprichmsgrsp = new qqshop_richmsg$SQQSHPRichMsgRsp();
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) this.f79593d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            List<EcShopData> g16 = ecShopAssistantManager.g();
            try {
                qqshop_richmsg_sqqshprichmsgrsp.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                QLog.e("EcshopReportHandler", 2, "merge exception:" + e16);
            }
            List<qqshop_richmsg$SQQSHPRichMsg> list = qqshop_richmsg_sqqshprichmsgrsp.rich_msgs.get();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                qqshop_richmsg$SQQSHPRichMsg qqshop_richmsg_sqqshprichmsg = list.get(i3);
                if (qqshop_richmsg_sqqshprichmsg.img_url.has() && qqshop_richmsg_sqqshprichmsg.msg_id.has() && qqshop_richmsg_sqqshprichmsg.puin.has()) {
                    String valueOf = String.valueOf(qqshop_richmsg_sqqshprichmsg.msg_id.get());
                    String valueOf2 = String.valueOf(qqshop_richmsg_sqqshprichmsg.puin.get());
                    List<String> list2 = qqshop_richmsg_sqqshprichmsg.img_url.get();
                    StringBuilder sb5 = new StringBuilder();
                    Iterator<String> it = list2.iterator();
                    while (it.hasNext()) {
                        sb5.append(it.next());
                        sb5.append(",");
                    }
                    QLog.i("EcshopReportHandler", 2, "recv rich msg:" + valueOf + "," + valueOf2 + "," + list2.toString());
                    Iterator<EcShopData> it5 = g16.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            EcShopData next = it5.next();
                            if (valueOf.equals(next.msgId) && valueOf2.equals(next.mUin)) {
                                next.mImgInfo = sb5.substring(0, sb5.length() - 1).toString();
                                ecShopAssistantManager.q(next);
                                break;
                            }
                        }
                    }
                }
            }
            if (size > 0) {
                super.notifyUI(6, true, null);
            }
            if (qqshop_richmsg_sqqshprichmsgrsp.ad_msgs.has()) {
                qqshop_richmsg$SQQSHPFolderAdMsg qqshop_richmsg_sqqshpfolderadmsg = qqshop_richmsg_sqqshprichmsgrsp.ad_msgs.get(0);
                String currentAccountUin = this.f79593d.getCurrentAccountUin();
                if (qqshop_richmsg_sqqshpfolderadmsg == null) {
                    return;
                }
                List<String> list3 = qqshop_richmsg_sqqshpfolderadmsg.pic_url.get();
                if (!TextUtils.isEmpty(currentAccountUin) && list3 != null && !list3.isEmpty()) {
                    SharedPreferences sharedPreferences = this.f79593d.getApp().getSharedPreferences("ecshop_sp" + currentAccountUin, 0);
                    long j3 = sharedPreferences.getLong("ad_puin", 0L);
                    EcShopAssistantManager.W = String.valueOf(j3);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (j3 != 0) {
                        ecShopAssistantManager.p(String.valueOf(j3));
                    }
                    edit.putBoolean("is_ad_added", false);
                    edit.putInt("ad_start", qqshop_richmsg_sqqshpfolderadmsg.begin_time.get());
                    edit.putInt("ad_end", qqshop_richmsg_sqqshpfolderadmsg.end_time.get());
                    edit.putLong("ad_id", qqshop_richmsg_sqqshpfolderadmsg.ad_id.get());
                    edit.putLong("ad_puin", qqshop_richmsg_sqqshpfolderadmsg.puin.get());
                    edit.putString("ad_icon_url", qqshop_richmsg_sqqshpfolderadmsg.ad_url.get());
                    edit.putString(QAdVrReport.ElementID.AD_TITLE, qqshop_richmsg_sqqshpfolderadmsg.title.get());
                    edit.putString("ad_nick", qqshop_richmsg_sqqshpfolderadmsg.name.get());
                    edit.putString("ad_url", qqshop_richmsg_sqqshpfolderadmsg.ad_content_url.get());
                    if (qqshop_richmsg_sqqshpfolderadmsg.verify_flag.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    edit.putBoolean("ad_cert", z16);
                    StringBuilder sb6 = new StringBuilder();
                    Iterator<String> it6 = list3.iterator();
                    while (it6.hasNext()) {
                        sb6.append(it6.next());
                        sb6.append(",");
                    }
                    String str = sb6.substring(0, sb6.length() - 1).toString();
                    QLog.i("EcshopReportHandler", 2, "v_flag" + qqshop_richmsg_sqqshpfolderadmsg.verify_flag.get() + ",puin:" + qqshop_richmsg_sqqshpfolderadmsg.puin.get() + ",ad pics:" + str);
                    edit.putString("ad_pics", str);
                    edit.commit();
                    H2(134246435, null, null, null, null, qqshop_richmsg_sqqshpfolderadmsg.ad_id.get(), false);
                }
            }
        }
    }
}
