package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f implements b {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208243a;

    /* renamed from: b, reason: collision with root package name */
    private DataLineMsgRecord f208244b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements j0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.b f208245a;

        a(g.b bVar) {
            this.f208245a = bVar;
        }

        @Override // j0.b
        public void a(j0.a aVar) {
            DataLineHandler dataLineHandler = (DataLineHandler) f.this.f208243a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            long j3 = aVar.f409034a;
            String str = aVar.f409040g;
            String str2 = aVar.f409037d;
            int i3 = aVar.f409038e;
            String k3 = f.this.k(aVar.f409047n, i3);
            if (!TextUtils.isEmpty(k3)) {
                str2 = k3;
            }
            String str3 = aVar.f409041h;
            String str4 = "http://" + str2 + ":" + String.valueOf(i3) + str;
            if (QLog.isColorLevel()) {
                QLog.i("VideoForDataline<QFile>XOXO", 1, "offlineVideo download. downloadUrl:" + str4);
            }
            this.f208245a.b(str4, str3);
            dataLineHandler.OnSessionStart(f.this.f208244b.sessionid);
        }
    }

    public f(QQAppInterface qQAppInterface, DataLineMsgRecord dataLineMsgRecord) {
        this.f208243a = qQAppInterface;
        this.f208244b = dataLineMsgRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        QLog.i("VideoForDataline<QFile>XOXO", 1, "[IPv6-File] dataline offlineVideo download. is config enable IPv6. domain[" + str + "]");
        d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.f208243a, new d.a(str, i3), 1);
        if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
            int size = iPlistForV6Domain.f207644b.size();
            for (int i16 = 0; i16 < size; i16++) {
                d.b bVar = iPlistForV6Domain.f207644b.get(i16);
                if (bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
                    String str2 = bVar.f207641a;
                    QLog.i("VideoForDataline<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv6. hostlist:" + str2);
                    return str2;
                }
            }
            return "";
        }
        QLog.i("VideoForDataline<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String a() {
        return this.f208244b.sessionid + "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public /* synthetic */ void b() {
        com.tencent.mobileqq.filemanager.fileviewer.data.a.a(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String c() {
        return lc1.b.a().getDefaultTmpPath() + com.tencent.securitysdk.utils.c.b(a());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void d(boolean z16) {
        ((DataLineHandler) this.f208243a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.f208244b.sessionid, 0, 0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void e(long j3) {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f208243a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        DataLineMsgRecord dataLineMsgRecord = this.f208244b;
        dataLineHandler.OnSessionProgress(dataLineMsgRecord.sessionid, j3, dataLineMsgRecord.filesize, 0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void f(String str) {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f208243a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        DataLineMsgRecord dataLineMsgRecord = this.f208244b;
        dataLineMsgRecord.path = str;
        dataLineHandler.OnSessionComplete(dataLineMsgRecord.sessionid, 2, 0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        if (TextUtils.isEmpty(this.f208244b.serverPath)) {
            d(true);
            bVar.onError(-6101, BaseApplication.getContext().getResources().getString(R.string.bfo));
            QLog.e("VideoForDataline<QFile>XOXO", 2, "[" + a() + "],[getOnlinePlay]  uuid is null");
            return;
        }
        ((DataLineHandler) this.f208243a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).i4(this.f208244b, new a(bVar));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String getFileName() {
        return this.f208244b.filename;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public long getFileSize() {
        return this.f208244b.filesize;
    }
}
