package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9$MsgBody;

/* loaded from: classes11.dex */
public class PrinterHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f194904a;

    /* renamed from: b, reason: collision with root package name */
    public int f194905b;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f194906c;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f194907d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<PrinterItemMsgRecord> f194908e;

    /* renamed from: f, reason: collision with root package name */
    public List<C2CType0x211_SubC2CType0x9$MsgBody.SupportFileInfo> f194909f;

    /* renamed from: g, reason: collision with root package name */
    HashMap<Long, PrinterItemMsgRecord> f194910g;

    /* renamed from: h, reason: collision with root package name */
    long f194911h;

    /* renamed from: i, reason: collision with root package name */
    public com.dataline.util.i f194912i;

    /* renamed from: j, reason: collision with root package name */
    private k f194913j;

    /* loaded from: classes11.dex */
    class a extends k {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrinterHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void g(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), l3);
                return;
            }
            PrinterHandler.this.k(l3, z16);
            com.dataline.util.i iVar = PrinterHandler.this.f194912i;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void n(Session session, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, session, Boolean.valueOf(z16));
                return;
            }
            PrinterHandler.this.l(2, session, 0.0d, z16);
            com.dataline.util.i iVar = PrinterHandler.this.f194912i;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void o(Session session) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) session);
                return;
            }
            if (session.isFileAssist) {
                return;
            }
            PrinterHandler.this.l(3, session, 0.0d, false);
            com.dataline.util.i iVar = PrinterHandler.this.f194912i;
            if (iVar != null) {
                iVar.f();
                PrinterHandler.this.f194912i.notifyDataSetChanged();
                PrinterActivity printerActivity = PrinterHandler.this.f194912i.f32451h;
                LiteActivity.n3(printerActivity.f32242f0, printerActivity.f32241e0);
                LiteActivity.h4(PrinterHandler.this.f194912i.f32451h.f32241e0);
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void p(Session session, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, session, Float.valueOf(f16));
                return;
            }
            PrinterHandler.this.l(1, session, f16, false);
            com.dataline.util.i iVar = PrinterHandler.this.f194912i;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void q(Session session) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) session);
                return;
            }
            if (session.isFileAssist) {
                return;
            }
            PrinterHandler.this.l(0, session, 0.0d, false);
            com.dataline.util.i iVar = PrinterHandler.this.f194912i;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements FMDialogUtil.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f194919a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f194920b;

        b(Context context, String str) {
            this.f194919a = context;
            this.f194920b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PrinterHandler.this, context, str);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Intent intent = new Intent(this.f194919a, (Class<?>) PrinterActivity.class);
            intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, 55);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.f194920b);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            this.f194919a.startActivity(intent);
            ReportController.o(PrinterHandler.this.f194907d, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
        }
    }

    public PrinterHandler(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194905b = 0;
        this.f194906c = null;
        this.f194907d = null;
        this.f194908e = new ArrayList<>();
        this.f194909f = null;
        this.f194910g = new HashMap<>();
        this.f194911h = 0L;
        this.f194912i = null;
        a aVar = new a();
        this.f194913j = aVar;
        this.f194907d = qQAppInterface;
        qQAppInterface.addObserver(aVar);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.f194908e.size() > 0) {
            while (this.f194908e.size() > 5 && this.f194908e.get(0).status != 2) {
                this.f194908e.remove(0);
            }
            return this.f194908e.size();
        }
        int h16 = h();
        if (this.f194911h == 0) {
            if (this.f194908e.size() > 0) {
                this.f194911h = this.f194908e.get(r2.size() - 1).msgId;
            }
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Printer", 2, "\u521d\u59cb\u5316PrinterItemMsgRecord\u7684msgid\u4e3a" + this.f194911h);
            }
        }
        return h16;
    }

    public String[] b() {
        List<C2CType0x211_SubC2CType0x9$MsgBody.SupportFileInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (((PrinterStatusHandler) this.f194907d.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).H2() && (list = this.f194909f) != null) {
            String[] strArr = new String[list.size()];
            for (int size = this.f194909f.size() - 1; size >= 0; size += -1) {
                strArr[size] = "." + this.f194909f.get(size).str_file_suffix.get();
            }
            return strArr;
        }
        return null;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f194907d.removeObserver(this.f194913j);
        }
    }

    public void d(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (FileManagerUtil.is2GOr3G()) {
            if (FileUtils.getFileSizes(str) > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
                FMDialogUtil.a(context, R.string.b_v, R.string.f170958ba0, new b(context, str));
                return;
            }
            Intent intent = new Intent(context, (Class<?>) PrinterActivity.class);
            intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, 55);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            context.startActivity(intent);
            ReportController.o(this.f194907d, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) PrinterActivity.class);
        intent2.putExtra(com.tencent.mobileqq.utils.d.f307603i, 55);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(str);
        intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList2);
        context.startActivity(intent2);
        ReportController.o(this.f194907d, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
    }

    public void e(PrinterItemMsgRecord printerItemMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) printerItemMsgRecord);
            return;
        }
        this.f194907d.getProxyManager().addMsgQueue(String.valueOf(0), 0, printerItemMsgRecord.getTableName(), printerItemMsgRecord.m172clone(), 0, null);
    }

    public void f(PrinterItemMsgRecord printerItemMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) printerItemMsgRecord);
            return;
        }
        Timer timer = printerItemMsgRecord.mTimer_for_Print;
        if (timer != null) {
            timer.cancel();
            printerItemMsgRecord.mTimer_for_Print = null;
        }
        this.f194908e.remove(printerItemMsgRecord);
        this.f194910g.remove(Long.valueOf(printerItemMsgRecord.uSessionID));
        ReportController.o(this.f194907d, "CliOper", "", "", "0X8004021", "0X8004021", (int) printerItemMsgRecord.uSessionID, -2, "", "", "", "");
        this.f194907d.getProxyManager().addMsgQueue(String.valueOf(0), 0, printerItemMsgRecord.getTableName(), "msgId=?", new String[]{String.valueOf(printerItemMsgRecord.msgId)}, 2, null);
    }

    public void g(DataLineHandler dataLineHandler, msg_comm$Msg msg_comm_msg, C2CType0x211_SubC2CType0x9$MsgBody c2CType0x211_SubC2CType0x9$MsgBody) {
        List<String> list;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, dataLineHandler, msg_comm_msg, c2CType0x211_SubC2CType0x9$MsgBody);
            return;
        }
        int i16 = c2CType0x211_SubC2CType0x9$MsgBody.uint32_CMD.get();
        boolean z16 = true;
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 != 6) {
                    return;
                }
                C2CType0x211_SubC2CType0x9$MsgBody.MsgPrinter msgPrinter = c2CType0x211_SubC2CType0x9$MsgBody.msg_printer.get();
                if (msgPrinter == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.Printer", 2, "\u6536\u5230pc\u7684\u6253\u5370\u673a\u7ed3\u679c, msgPrinter\u4e3a\u7a7a");
                        return;
                    }
                    return;
                } else {
                    C2CType0x211_SubC2CType0x9$MsgBody.HPPrinterStateInfo hPPrinterStateInfo = msgPrinter.hp_printer_state_info.get();
                    dataLineHandler.notifyUI(19, true, new Object[]{Long.valueOf(hPPrinterStateInfo.uint64_printer_din.get()), hPPrinterStateInfo.str_printer_qr_pic_url.get(), hPPrinterStateInfo.str_printer_qr_open_url.get(), hPPrinterStateInfo.str_printer_tip_url.get()});
                    return;
                }
            }
            C2CType0x211_SubC2CType0x9$MsgBody.MsgPrinter msgPrinter2 = c2CType0x211_SubC2CType0x9$MsgBody.msg_printer.get();
            long j3 = 0;
            if (msgPrinter2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("dataline.Printer", 2, "\u6536\u5230pc\u7684\u6253\u5370\u7ed3\u679c, msgPrinter\u4e3a\u7a7a");
                }
                i3 = -1;
            } else {
                i3 = msgPrinter2.uint32_print_result.get();
                List<Long> list2 = msgPrinter2.rpt_uint64_session_id.get();
                if (list2 != null && list2.size() != 0) {
                    j3 = list2.get(0).longValue();
                } else if (QLog.isColorLevel()) {
                    QLog.d("dataline.Printer", 2, "\u6536\u5230pc\u7684\u6253\u5370\u7ed3\u679c, rpt_uint64_session_id\u4e3a\u7a7a. print_result = " + i3);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Printer", 2, "\u6536\u5230pc\u7684\u6253\u5370\u7ed3\u679c, print_result = " + i3 + ", print_id = " + j3);
            }
            new Intent().putExtra("sPrintResult", i3);
            if (i3 != 0) {
                z16 = false;
            }
            dataLineHandler.N3(18, z16, Long.valueOf(j3));
            ReportController.o(this.f194907d, "CliOper", "", "", "0X8004021", "0X8004021", (int) j3, i3, "", "", "", "");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("dataline.Printer", 4, "\u6536\u5230pc\u7684\u6253\u5370\u673a\u5217\u8868");
        }
        PrinterStatusHandler printerStatusHandler = (PrinterStatusHandler) this.f194907d.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
        printerStatusHandler.M2(false);
        C2CType0x211_SubC2CType0x9$MsgBody.MsgPrinter msgPrinter3 = c2CType0x211_SubC2CType0x9$MsgBody.msg_printer.get();
        if (msgPrinter3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Printer", 2, "\u6536\u5230pc\u7684\u6253\u5370\u673a\u5217\u8868, msgPrinter\u4e3a\u7a7a");
                return;
            }
            return;
        }
        this.f194906c = msgPrinter3.rpt_string_printer.get();
        this.f194909f = msgPrinter3.rpt_msg_support_file_info.get();
        if (((RegisterProxySvcPackHandler) this.f194907d.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).P2() != 0 && (list = this.f194906c) != null && list.size() > 0) {
            printerStatusHandler.M2(true);
        }
        dataLineHandler.N3(12, false, null);
        ReportController.o(this.f194907d, "CliOper", "", "", "0X8004022", "0X8004022", 0, 0, "", "", "", "");
    }

    public int h() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        ProxyManager proxyManager = this.f194907d.getProxyManager();
        EntityManager createEntityManager = this.f194907d.getEntityManagerFactory().createEntityManager();
        if (DataLineMsgProxy.A(proxyManager, PrinterItemMsgRecord.sTagleName)) {
            proxyManager.transSaveToDatabase(createEntityManager);
        }
        if (this.f194908e.size() > 0) {
            j3 = this.f194908e.get(0).msgId;
        } else {
            j3 = TTL.MAX_VALUE;
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, PrinterItemMsgRecord.class, "select * from mr_dataline_printer where msgid<? order by msgid desc limit 5", new String[]{String.valueOf(j3)});
        createEntityManager.close();
        if (rawQuery == null) {
            return 0;
        }
        int size = rawQuery.size();
        for (int i3 = 0; i3 < rawQuery.size(); i3++) {
            PrinterItemMsgRecord printerItemMsgRecord = (PrinterItemMsgRecord) rawQuery.get(i3);
            if (printerItemMsgRecord.status < 10) {
                printerItemMsgRecord.status = 11;
            }
            this.f194908e.add(0, printerItemMsgRecord);
        }
        return size;
    }

    public void i(DataLineHandler dataLineHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dataLineHandler);
            return;
        }
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.f194907d.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.P2() == 0 || registerProxySvcPackHandler.R2() != 1) {
            dataLineHandler.N3(12, false, null);
            if (this.f194910g.size() > 0) {
                BaseTimer baseTimer = new BaseTimer();
                baseTimer.schedule(new TimerTask(dataLineHandler, baseTimer) { // from class: com.tencent.mobileqq.app.PrinterHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ DataLineHandler f194914d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Timer f194915e;

                    {
                        this.f194914d = dataLineHandler;
                        this.f194915e = baseTimer;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PrinterHandler.this, dataLineHandler, baseTimer);
                        }
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (PrinterHandler.this.f194910g.size() > 0) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("dataline.Printer", 4, " pc\u4e0b\u7ebf\u4e86");
                            }
                            while (PrinterHandler.this.f194910g.size() > 0) {
                                Iterator<Long> it = PrinterHandler.this.f194910g.keySet().iterator();
                                if (it.hasNext()) {
                                    long longValue = it.next().longValue();
                                    this.f194914d.j3(0, longValue, true);
                                    PrinterHandler.this.k(Long.valueOf(longValue), false);
                                }
                            }
                        }
                        this.f194915e.cancel();
                    }
                }, 5000L);
            }
        }
    }

    public void j(PrinterItemMsgRecord printerItemMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) printerItemMsgRecord);
            return;
        }
        ProxyManager proxyManager = this.f194907d.getProxyManager();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(printerItemMsgRecord.status));
        proxyManager.addMsgQueue(String.valueOf(0), 0, printerItemMsgRecord.getTableName(), contentValues, "msgId=?", new String[]{String.valueOf(printerItemMsgRecord.msgId)}, 1, null);
    }

    public void k(Long l3, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, l3, Boolean.valueOf(z16));
            return;
        }
        PrinterItemMsgRecord printerItemMsgRecord = this.f194910g.get(l3);
        if (printerItemMsgRecord == null) {
            int size = this.f194908e.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (this.f194908e.get(size).uSessionID == l3.longValue()) {
                    printerItemMsgRecord = this.f194908e.get(size);
                    break;
                }
                size--;
            }
        }
        if (printerItemMsgRecord != null) {
            if (z16) {
                i3 = 10;
            } else {
                i3 = 11;
            }
            printerItemMsgRecord.status = i3;
            printerItemMsgRecord.progress = 1.0d;
            Timer timer = printerItemMsgRecord.mTimer_for_Print;
            if (timer != null) {
                timer.cancel();
                printerItemMsgRecord.mTimer_for_Print = null;
            }
            this.f194910g.remove(l3);
            j(printerItemMsgRecord);
        }
    }

    public void l(int i3, Session session, double d16, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), session, Double.valueOf(d16), Boolean.valueOf(z16));
            return;
        }
        if (!DataLineHandler.Q2(session, "printer")) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        long j16 = this.f194911h + 1;
                        this.f194911h = j16;
                        PrinterItemMsgRecord printerItemMsgRecord = new PrinterItemMsgRecord(j16);
                        printerItemMsgRecord.uSessionID = session.uSessionID;
                        if (QLog.isColorLevel()) {
                            QLog.d("dataline.Printer", 2, "\u83b7\u5f97printID=" + printerItemMsgRecord.uSessionID + ", path=" + session.strFilePathSrc);
                        }
                        printerItemMsgRecord.filename = session.strFilePathSrc;
                        printerItemMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
                        this.f194908e.add(printerItemMsgRecord);
                        e(printerItemMsgRecord);
                        this.f194910g.put(Long.valueOf(printerItemMsgRecord.uSessionID), printerItemMsgRecord);
                        return;
                    }
                    return;
                }
                PrinterItemMsgRecord printerItemMsgRecord2 = this.f194910g.get(Long.valueOf(session.uSessionID));
                if (printerItemMsgRecord2 != null) {
                    if (z16) {
                        printerItemMsgRecord2.progress = 0.699999988079071d;
                        printerItemMsgRecord2.status = 2;
                        BaseTimer baseTimer = new BaseTimer();
                        printerItemMsgRecord2.mTimer_for_Print = baseTimer;
                        TimerTask timerTask = new TimerTask(printerItemMsgRecord2.uSessionID, baseTimer) { // from class: com.tencent.mobileqq.app.PrinterHandler.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ long f194916d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Timer f194917e;

                            {
                                this.f194916d = r6;
                                this.f194917e = baseTimer;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, PrinterHandler.this, Long.valueOf(r6), baseTimer);
                                }
                            }

                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (PrinterHandler.this.f194910g.containsKey(Long.valueOf(this.f194916d))) {
                                    ReportController.o(PrinterHandler.this.f194907d, "CliOper", "", "", "0X8004021", "0X8004021", (int) this.f194916d, -1, "", "", "", "");
                                    PrinterHandler.this.k(Long.valueOf(this.f194916d), false);
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("dataline.Printer", 4, "printID=" + this.f194916d + ", \u8d85\u65f6\u5230\u4e86");
                                    }
                                }
                                this.f194917e.cancel();
                            }
                        };
                        long K0 = com.tencent.mobileqq.service.message.e.K0();
                        long j17 = printerItemMsgRecord2.time;
                        if (K0 >= j17) {
                            j3 = K0 - j17;
                        } else {
                            j3 = K0;
                        }
                        long max = Math.max(Math.min(j3, JoinTimeType.THIRTY_MINUTES), 60L);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("dataline.Printer", 4, "printID=" + printerItemMsgRecord2.uSessionID + ", \u5f53\u524d\u65f6\u95f4[" + K0 + "], \u5f00\u59cb\u65f6\u95f4[" + printerItemMsgRecord2.time + "], \u8d85\u65f6\u65f6\u95f4[" + max);
                        }
                        printerItemMsgRecord2.mTimer_for_Print.schedule(timerTask, max * 1000);
                        return;
                    }
                    printerItemMsgRecord2.status = 12;
                    j(printerItemMsgRecord2);
                    return;
                }
                return;
            }
            PrinterItemMsgRecord printerItemMsgRecord3 = this.f194910g.get(Long.valueOf(session.uSessionID));
            if (printerItemMsgRecord3 != null) {
                printerItemMsgRecord3.status = 2;
                printerItemMsgRecord3.progress = (float) (d16 * 0.7d);
                return;
            }
            return;
        }
        PrinterItemMsgRecord printerItemMsgRecord4 = this.f194910g.get(Long.valueOf(session.uSessionID));
        if (printerItemMsgRecord4 != null) {
            printerItemMsgRecord4.status = 2;
            printerItemMsgRecord4.progress = d16 * 0.7d;
        }
    }
}
