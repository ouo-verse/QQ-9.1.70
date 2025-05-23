package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private FMObserver f208070a = null;

    /* renamed from: b, reason: collision with root package name */
    private bs f208071b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends bs {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f208072d;

        a(QQAppInterface qQAppInterface) {
            this.f208072d = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSendResult(boolean z16, String str, long j3, MessageHandlerConstants.MsgSendCostParams msgSendCostParams) {
            if (z16 && h.k(str)) {
                QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult isSuccess[" + z16 + "], uin[" + str + "], uniseq[" + j3 + "]");
                MessageRecord P = this.f208072d.getMessageFacade().P(str, msgSendCostParams.mUinType, j3);
                if (P == null) {
                    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult not find msg");
                    return;
                }
                if (P instanceof MessageForLongTextMsg) {
                    ((DataLineHandler) this.f208072d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).u4(P.f203106msg);
                    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success longTextMsg");
                } else if (P instanceof MessageForText) {
                    ((DataLineHandler) this.f208072d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).X2(new QQText(P.f203106msg, 45, 32, 0).toPlainText(true), 0);
                    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success TextMsg");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends FMObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f208074e;

        b(QQAppInterface qQAppInterface) {
            this.f208074e = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, j16 + " transfer end, isSucc:" + z16);
            if (!z16) {
                return;
            }
            String g16 = h.g(this.f208074e);
            if (g16 == null) {
                QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, j16 + " transfer end, datalineUin is null");
                return;
            }
            if (!g16.equalsIgnoreCase(str)) {
                QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, j16 + " transfer end, is not datalineUin");
                return;
            }
            FileManagerEntity D = this.f208074e.getFileManagerDataCenter().D(j16);
            if (!f.this.f(D)) {
                QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, j16 + " transfer end, is not send to old dataline");
                return;
            }
            this.f208074e.getFileManagerEngine().F(D);
            QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, j16 + " transfer end, forward to old dataline");
        }
    }

    public f(QQAppInterface qQAppInterface) {
        d(qQAppInterface);
    }

    private void c(QQAppInterface qQAppInterface) {
        if (this.f208070a != null) {
            QLog.w("FileResultWatchForObserver<FileAssistant>NDL", 1, "FileResultWatchForObserver may be inited");
        } else {
            this.f208070a = new b(qQAppInterface);
            qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f208070a);
        }
    }

    private void d(QQAppInterface qQAppInterface) {
        c(qQAppInterface);
        e(qQAppInterface);
    }

    private void e(QQAppInterface qQAppInterface) {
        if (this.f208071b != null) {
            QLog.w("FileResultWatchForObserver<FileAssistant>NDL", 1, "TextMsgSendResultObserver may be inited");
            return;
        }
        a aVar = new a(qQAppInterface);
        this.f208071b = aVar;
        qQAppInterface.addDefaultObservers(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, "entity is null!");
            return false;
        }
        QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, "entity:" + fileManagerEntity.nSessionId + ", opType:" + fileManagerEntity.nOpType);
        int i3 = fileManagerEntity.nOpType;
        if (i3 == 0 || i3 == 3 || i3 == 7 || i3 == 21 || i3 == 24 || i3 == 37) {
            return true;
        }
        if (i3 != 51 || TextUtils.isEmpty(fileManagerEntity.Uuid)) {
            return false;
        }
        QLog.e("FileResultWatchForObserver<FileAssistant>NDL", 1, "entity:" + fileManagerEntity.nSessionId + ", has uuid, Send to old dataline!");
        return true;
    }

    public void b(QQAppInterface qQAppInterface) {
        if (this.f208070a != null) {
            qQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.f208070a);
            this.f208070a = null;
        }
        bs bsVar = this.f208071b;
        if (bsVar != null) {
            qQAppInterface.removeObserver(bsVar);
            this.f208071b = null;
        }
    }
}
