package com.tencent.mobileqq.teamwork.spread;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;
import mqq.manager.Manager;
import ta1.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DataLineMessageSpreadManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f292363d;

    /* renamed from: e, reason: collision with root package name */
    private ConfigSettingForDataLine f292364e;

    /* renamed from: f, reason: collision with root package name */
    private b f292365f = null;

    /* renamed from: h, reason: collision with root package name */
    private int f292366h = -1;

    /* renamed from: i, reason: collision with root package name */
    private List<MessageRecord> f292367i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    long f292368m = 0;

    public DataLineMessageSpreadManager(QQAppInterface qQAppInterface) {
        this.f292363d = qQAppInterface;
        this.f292364e = new ConfigSettingForDataLine(qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(DataLineMsgRecord dataLineMsgRecord) {
        int i3 = this.f292364e.i();
        int c16 = TencentDocDataLineTipsConfigProcessor.a().c();
        if (c16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("DataLineMessageSpreadManager", 1, "config is max: 0, return");
            }
            return false;
        }
        if (i3 <= c16) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DataLineMessageSpreadManager", 1, "file count over[" + i3 + "], return");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final DataLineMsgRecord dataLineMsgRecord, final String str, final String str2, final String str3, final g.b bVar) {
        if (!this.f292364e.q()) {
            if (QLog.isColorLevel()) {
                QLog.i("DataLineMessageSpreadManager", 1, "last insert time less");
                return;
            }
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("DataLineMessageSpreadManager", 1, "insertGaryTips:" + str + " link:" + str2);
        }
        this.f292364e.s(dataLineMsgRecord);
        new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2
            @Override // java.lang.Runnable
            public void run() {
                g.b bVar2;
                DataLineMsgRecord d16 = DataLineMessageSpreadManager.this.f292363d.getMessageFacade().t1(DataLineMessageSpreadManager.this.f292366h).d(dataLineMsgRecord.sessionid);
                if (d16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DataLineMessageSpreadManager", 1, "cant find cache msg,uniseq:" + dataLineMsgRecord.uniseq);
                    }
                    d16 = dataLineMsgRecord;
                }
                DataLineMsgRecord dataLineMsgRecord2 = d16;
                HashMap hashMap = new HashMap();
                String str4 = str;
                if (str4.contains("%s") && (bVar2 = bVar) != null) {
                    try {
                        String str5 = str;
                        String str6 = bVar2.f435674a;
                        str4 = String.format(str5, str6, str6);
                        hashMap.put("tim_aio_file_tips", str4);
                        hashMap.put("tim_aio_file_link", String.format(str2, bVar.f435674a));
                    } catch (Exception e16) {
                        QLog.e("DataLineMessageSpreadManager", 2, e16.toString());
                    }
                } else {
                    hashMap.put("tim_aio_file_tips", str);
                    hashMap.put("tim_aio_file_link", str2);
                }
                hashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(dataLineMsgRecord.sessionid));
                hashMap.put("tim_aio_tips_type", str3);
                g.b bVar3 = bVar;
                if (bVar3 != null) {
                    hashMap.put("tim_aio_tips_template_id", String.valueOf(bVar3.f435675b));
                    hashMap.put("tim_aio_tips_template_type", String.valueOf(bVar.f435676c));
                    hashMap.put("tim_aio_tips_keyword", String.valueOf(bVar.f435674a));
                    hashMap.put("tim_aio_tips_type", String.valueOf(bVar.f435676c));
                }
                DataLineHandler dataLineHandler = (DataLineHandler) DataLineMessageSpreadManager.this.f292363d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                Long u36 = dataLineHandler.u3(0, DataLineMessageSpreadManager.this.f292366h);
                DataLineMsgRecord dataLineMsgRecord3 = new DataLineMsgRecord();
                dataLineMsgRecord3.msgId = u36.longValue();
                dataLineMsgRecord3.sessionid = u36.longValue();
                dataLineMsgRecord3.msgtype = MessageRecord.MSG_TYPE_GRAY_DATALINE_TIM_TIPS;
                dataLineMsgRecord3.time = com.tencent.mobileqq.service.message.e.K0();
                dataLineMsgRecord3.selfuin = DataLineMessageSpreadManager.this.f292363d.getCurrentAccountUin();
                dataLineMsgRecord3.frienduin = dataLineMsgRecord2.frienduin;
                dataLineMsgRecord3.senderuin = DataLineMessageSpreadManager.this.f292363d.getCurrentAccountUin();
                dataLineMsgRecord3.f203106msg = str4;
                dataLineMsgRecord3.isread = true;
                dataLineMsgRecord3.issend = 0;
                long j3 = dataLineMsgRecord2.shmsgseq;
                dataLineMsgRecord3.msgseq = j3;
                dataLineMsgRecord3.shmsgseq = j3;
                dataLineMsgRecord3.msgUid = dataLineMsgRecord2.msgUid;
                dataLineMsgRecord3.time = com.tencent.mobileqq.service.message.e.K0();
                if (hashMap.size() > 0) {
                    for (String str7 : hashMap.keySet()) {
                        dataLineMsgRecord3.saveExtInfoToExtStr(str7, (String) hashMap.get(str7));
                    }
                }
                dataLineMsgRecord3.extraflag |= -32769;
                ReportController.o(DataLineMessageSpreadManager.this.f292363d, "dc00898", "", "", "0X80098F7", "0X80098F7", 0, 0, "", "", "", "");
                DataLineMessageSpreadManager.this.f292363d.getDataLineMsgProxy(DataLineMessageSpreadManager.this.f292366h).h(dataLineMsgRecord3);
                dataLineHandler.N3(11, true, null);
            }
        }, 1000L);
    }

    public void i(MessageRecord messageRecord, int i3) {
        this.f292366h = i3;
        if (messageRecord == null) {
            QLog.e("DataLineMessageSpreadManager", 1, FileManagerUtil.printStack());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DataLineMessageSpreadManager", 1, "send file:" + messageRecord.msgUid);
        }
        ThreadManager.getUIHandler().postDelayed(new TimerTask() { // from class: com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                synchronized (DataLineMessageSpreadManager.this) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - DataLineMessageSpreadManager.this.f292368m;
                    if (j3 >= 950) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + DataLineMessageSpreadManager.this.f292368m + "],now[" + currentTimeMillis + "], dur[" + j3 + "],timeOut start check!");
                        }
                        for (int size = DataLineMessageSpreadManager.this.f292367i.size() - 1; size >= 0; size--) {
                            DataLineMessageSpreadManager.this.k((DataLineMsgRecord) ((MessageRecord) DataLineMessageSpreadManager.this.f292367i.get(size)));
                        }
                        DataLineMessageSpreadManager dataLineMessageSpreadManager = DataLineMessageSpreadManager.this;
                        dataLineMessageSpreadManager.f292368m = 0L;
                        dataLineMessageSpreadManager.f292367i.clear();
                    } else if (QLog.isColorLevel()) {
                        QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + DataLineMessageSpreadManager.this.f292368m + "],now[" + currentTimeMillis + "], dur[" + j3 + "]");
                    }
                }
            }
        }, 1000L);
        synchronized (this) {
            this.f292367i.add(messageRecord);
            this.f292368m = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + this.f292368m + "],lstCache size[" + this.f292367i.size() + "]");
            }
        }
    }

    public void k(final DataLineMsgRecord dataLineMsgRecord) {
        if (QLog.isDebugVersion()) {
            QLog.i("DataLineMessageSpreadManager", 4, "ready to post to SubThread Process\uff0c msgUid[" + dataLineMsgRecord.msgUid + "], hashCode:" + dataLineMsgRecord.hashCode());
            if (dataLineMsgRecord.msgUid == 0) {
                FileManagerUtil.printStack();
            }
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (QLog.isDebugVersion()) {
                    QLog.i("DataLineMessageSpreadManager", 1, "SubThread Process Start");
                }
                if (!DataLineMessageSpreadManager.this.j(dataLineMsgRecord)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DataLineMessageSpreadManager", 1, "config return false!");
                        return;
                    }
                    return;
                }
                if (dataLineMsgRecord.msgtype == -2005) {
                    if (QLog.isDebugVersion()) {
                        QLog.i("DataLineMessageSpreadManager", 1, "message is MessageForFile");
                    }
                    DataLineMessageSpreadManager dataLineMessageSpreadManager = DataLineMessageSpreadManager.this;
                    dataLineMessageSpreadManager.f292365f = new c(dataLineMessageSpreadManager.f292363d, dataLineMsgRecord, DataLineMessageSpreadManager.this.f292364e);
                    if (!DataLineMessageSpreadManager.this.f292365f.b()) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DataLineMessageSpreadManager", 1, "file[" + DataLineMessageSpreadManager.this.f292365f.a() + "] is not support!");
                            return;
                        }
                        return;
                    }
                    String a16 = DataLineMessageSpreadManager.this.f292365f.a();
                    if (QLog.isColorLevel()) {
                        QLog.i("DataLineMessageSpreadManager", 1, "recv new File name is :" + a16);
                    }
                    String[] m3 = DataLineMessageSpreadManager.this.f292364e.m(DataLineMessageSpreadManager.this.f292365f);
                    String str = "";
                    if (m3.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                        if (QLog.isDebugVersion()) {
                            StringBuilder sb5 = new StringBuilder();
                            for (String str2 : m3) {
                                sb5.append(str2);
                                sb5.append(",");
                            }
                            if (sb5.length() > 0) {
                                sb5.deleteCharAt(sb5.length() - 1);
                            }
                            QLog.i("DataLineMessageSpreadManager", 1, "getConfig keyWords:" + sb5.toString());
                        }
                        int length = m3.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            String str3 = m3[i3];
                            if (a16.contains(str3)) {
                                z16 = true;
                                str = str3;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DataLineMessageSpreadManager", 1, "keyWord[" + str + "] find!");
                        }
                        String l3 = DataLineMessageSpreadManager.this.f292364e.l(DataLineMessageSpreadManager.this.f292365f);
                        String k3 = DataLineMessageSpreadManager.this.f292364e.k(DataLineMessageSpreadManager.this.f292365f);
                        if (TextUtils.isEmpty(l3) && QLog.isColorLevel()) {
                            QLog.i("DataLineMessageSpreadManager", 1, "tips is null! return, tips[" + l3 + "], link[" + k3 + "]");
                        }
                        String str4 = l3 + "\u3002" + k3;
                        if (DataLineMessageSpreadManager.this.f292365f instanceof c) {
                            DataLineMessageSpreadManager.this.l(dataLineMsgRecord, str4, k3, "keyword", null);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("DataLineMessageSpreadManager", 1, "keyWords not find!");
                        return;
                    }
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.i("DataLineMessageSpreadManager", 1, "message is unknown");
                }
            }
        });
    }

    public void m(DataLineMsgRecord dataLineMsgRecord, Context context) {
        long j3;
        try {
            j3 = Long.parseLong(dataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq"));
        } catch (Exception e16) {
            QLog.e("DataLineMessageSpreadManager", 1, e16.toString());
            j3 = 0;
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        DataLineMsgRecord d16 = this.f292363d.getMessageFacade().t1(devTypeBySeId).d(j3);
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("DataLineMessageSpreadManager", 1, "garyTips not find fileMsg");
                return;
            }
            return;
        }
        ReportController.o(this.f292363d, "dc00898", "", "", "0X80098F8", "0X80098F8", 0, 0, "", "", "", "");
        FileManagerEntity trans2Entity = d16.trans2Entity();
        if (trans2Entity == null) {
            QLog.e("DataLineMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + j3 + "]");
            return;
        }
        u.d(trans2Entity, context, this.f292363d, 6, devTypeBySeId);
    }

    public void n(ta1.g gVar) {
        this.f292364e.t(gVar);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
