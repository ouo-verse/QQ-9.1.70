package com.tencent.mobileqq.filemanager.util;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements w {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f209373a;

    public b(QQAppInterface qQAppInterface) {
        this.f209373a = qQAppInterface;
    }

    @Override // com.tencent.mobileqq.filemanager.util.w
    public String a(String str, int i3, String str2, int i16, String str3, String str4, long j3, long j16, long j17, int i17) {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.util.w
    public long b(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, long j16, int i18) {
        com.tencent.mobileqq.troop.data.n nVar;
        TroopFileManager F = TroopFileManager.F(this.f209373a, Long.parseLong(str2));
        if (F != null) {
            F.e(str3, str4, j3, i16, null);
        }
        long j17 = 0;
        String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData("", 0L, 0, true);
        try {
            j17 = Long.parseLong(str2);
        } catch (Exception unused) {
        }
        try {
            nVar = TroopFileManager.F(this.f209373a, j17).A(str3);
        } catch (Exception unused2) {
            nVar = null;
            return f(str, i3, str2, i16, str3, str4, j17, j3, i17, j16, i18, makeTransFileProtocolData, nVar);
        }
        return f(str, i3, str2, i16, str3, str4, j17, j3, i17, j16, i18, makeTransFileProtocolData, nVar);
    }

    @Override // com.tencent.mobileqq.filemanager.util.w
    public long c(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17) {
        return b(str, i3, str2, i16, str3, str4, str5, j3, i17, 0L, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e2  */
    @Override // com.tencent.mobileqq.filemanager.util.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(boolean z16, long j3, int i3, String str, String str2, String str3, String str4) {
        String str5;
        FileManagerEntity fileManagerEntity;
        int i16;
        int i17;
        boolean z17;
        int i18;
        String str6;
        boolean z18;
        String str7;
        String str8;
        String p16;
        b bVar = this;
        if (QLog.isColorLevel()) {
            QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult bSuccess[" + z16 + "],nSessionId[" + j3 + "],retCode[" + i3 + "],retMsg[" + str + "],uuid[" + str2 + "],troopUin[" + str3 + "],strNewPath[" + str4 + "]");
        }
        FileManagerEntity M = bVar.f209373a.getFileManagerDataCenter().M(j3);
        if (M == null) {
            QLog.e("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult,but entity is null SessionId[" + j3 + "]");
            return;
        }
        int i19 = M.nOpType;
        if (i19 == 24) {
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
            }
        } else if (i19 == 25) {
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult operation Error![" + M.nOpType + "]");
        }
        if (!z16) {
            str5 = "";
            fileManagerEntity = M;
            i16 = 1;
            i17 = 0;
        } else if (TextUtils.isEmpty(str4)) {
            i17 = 0;
            str5 = "";
            fileManagerEntity = M;
            i16 = 1;
        } else {
            M.status = 1;
            M.setCloudType(1);
            M.Uuid = str4;
            M.TroopUin = 0L;
            M.strTroopFileID = null;
            M.strTroopFilePath = null;
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "onResult bSuccess[true],peerType[" + M.peerType + "],peerUin[" + M.peerUin + "],uuid[" + M.Uuid + "]");
            }
            if (M.peerType != 3000) {
                str5 = "";
                fileManagerEntity = M;
                i16 = 1;
                bVar.f209373a.getFileManagerNotifyCenter().a(fileManagerEntity, 63, str5);
                str8 = null;
                bVar.f209373a.getFileTransferHandler().i1(fileManagerEntity.peerUin, fileManagerEntity, null);
                if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0) {
                    p16 = bVar.f209373a.getFileManagerEngine().m(fileManagerEntity, 5);
                } else {
                    if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 2) {
                        p16 = bVar.f209373a.getFileManagerEngine().p(fileManagerEntity);
                    }
                    p16 = str8;
                }
                if (p16 != null) {
                }
            } else {
                bVar.f209373a.getFileManagerNotifyCenter().a(M, 64, "");
                str5 = "";
                fileManagerEntity = M;
                i16 = 1;
                bVar.f209373a.getFileTransferHandler().k1(M.nSessionId, M.peerUin, bVar.f209373a.getCurrentAccountUin(), M.fileName, M.fileSize, str4, M.uniseq, M.msgUid, null);
                if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0) {
                    bVar = this;
                    p16 = bVar.f209373a.getFileManagerEngine().m(fileManagerEntity, 5);
                } else {
                    bVar = this;
                    if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 2) {
                        p16 = bVar.f209373a.getFileManagerEngine().o(fileManagerEntity);
                    } else {
                        str8 = null;
                        p16 = str8;
                    }
                }
                if (p16 != null) {
                    fileManagerEntity.strLargeThumPath = p16;
                }
            }
            if (i3 == 0) {
                if (!TextUtils.isEmpty(str)) {
                    d.i(str);
                } else {
                    d.i(BaseApplication.getContext().getString(R.string.b_t));
                }
                z17 = false;
            } else {
                z17 = z16;
            }
            i18 = fileManagerEntity.peerType;
            if (i18 != 0) {
                QQAppInterface qQAppInterface = bVar.f209373a;
                String str9 = fileManagerEntity.forwardTroopFileEntrance + str5;
                if (z17 == i16) {
                    str7 = "1";
                } else {
                    str7 = "2";
                }
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_files", "", TransactionActivity.PREF_NAME_TRANSFER, "Clk_fri", 0, 0, str3, str9, str7, fileManagerEntity.peerUin);
            } else if (i18 == 3000) {
                QQAppInterface qQAppInterface2 = bVar.f209373a;
                String str10 = fileManagerEntity.forwardTroopFileEntrance + str5;
                if (z17 == i16) {
                    str6 = "1";
                } else {
                    str6 = "2";
                }
                ReportController.o(qQAppInterface2, "P_CliOper", "Grp_files", "", TransactionActivity.PREF_NAME_TRANSFER, "Clk_talk", 0, 0, str3, str10, str6, "");
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = bVar.f209373a.getFileManagerNotifyCenter();
            if (fileManagerEntity.status != i16) {
                z18 = i16;
            } else {
                z18 = 0;
            }
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(fileManagerEntity.nSessionId);
            objArr[i16] = Integer.valueOf(i3);
            objArr[2] = str;
            fileManagerNotifyCenter.b(z18, 46, objArr);
        }
        fileManagerEntity.status = i17;
        if (TextUtils.isEmpty(str4) == i16) {
            QLog.e("C2CProcessCallBack<FileAssistant>", i16, "!!!!!!!\uff01\uff01\uff01new uuid is null!!!!!!!");
        }
        if (i3 == 0) {
        }
        i18 = fileManagerEntity.peerType;
        if (i18 != 0) {
        }
        FileManagerNotifyCenter fileManagerNotifyCenter2 = bVar.f209373a.getFileManagerNotifyCenter();
        if (fileManagerEntity.status != i16) {
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = Long.valueOf(fileManagerEntity.nSessionId);
        objArr2[i16] = Integer.valueOf(i3);
        objArr2[2] = str;
        fileManagerNotifyCenter2.b(z18, 46, objArr2);
    }

    public long f(String str, int i3, String str2, int i16, String str3, String str4, long j3, long j16, int i17, long j17, int i18, String str5, com.tencent.mobileqq.troop.data.n nVar) {
        int i19;
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.fileName = str4;
        if (nVar != null && q.f(nVar.f294939y)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FilePicURLDrawlableHelper.m(nVar.f294939y, options);
            int i26 = options.outHeight;
            if (i26 > 0 && (i19 = options.outWidth) > 0) {
                fileManagerEntity.imgWidth = i19;
                fileManagerEntity.imgHeight = i26;
            }
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "[" + fileManagerEntity.nSessionId + "]entity forward from troop no size, get and use thumb size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
            }
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(d16.uniseq, j17, i18);
        long j18 = d16.uniseq;
        fileManagerEntity.uniseq = j18;
        if (i3 == 0) {
            fileManagerEntity.nOpType = 24;
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + fileManagerEntity.nSessionId + "],[troopToOffline]");
            }
        } else if (i3 == 3000) {
            fileManagerEntity.nOpType = 25;
            if (QLog.isColorLevel()) {
                QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + fileManagerEntity.nSessionId + "],[troopToDisc]");
            }
        } else if (QLog.isDevelopLevel()) {
            throw new NullPointerException("\u7fa4\u540c\u4e8b\u4f20\u9012\u7684peerType\u4e0d\u5bf9\uff01");
        }
        fileManagerEntity.bSend = true;
        fileManagerEntity.isReaded = true;
        fileManagerEntity.peerType = i3;
        fileManagerEntity.peerUin = str;
        fileManagerEntity.peerNick = FileManagerUtil.getPeerNick(this.f209373a, str, null, i3);
        fileManagerEntity.selfUin = str2;
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity.setCloudType(4);
        fileManagerEntity.status = 2;
        fileManagerEntity.msgSeq = FileManagerUtil.genMsgSeq();
        fileManagerEntity.msgUid = FileManagerUtil.genMsgUid();
        fileManagerEntity.fileSize = j16;
        fileManagerEntity.TroopUin = j3;
        fileManagerEntity.busId = i16;
        fileManagerEntity.strTroopFilePath = str3;
        if (nVar != null) {
            fileManagerEntity.strTroopFileID = nVar.f294915a.toString();
            fileManagerEntity.lastTime = nVar.f294923i;
        }
        fileManagerEntity.TroopUin = j3;
        fileManagerEntity.forwardTroopFileEntrance = i17;
        return h(fileManagerEntity, j3, str3, str, j16, i3, str5, j18);
    }

    public void g(FileManagerEntity fileManagerEntity, long j3, String str) {
        com.tencent.mobileqq.troop.data.t H;
        TroopFileTransferManager N = TroopFileTransferManager.N(j3);
        if (N != null && (H = N.H(str)) != null) {
            fileManagerEntity.yybApkPackageName = H.B;
            fileManagerEntity.yybApkName = H.C;
            fileManagerEntity.yybApkIconUrl = H.D;
        }
    }

    public long h(FileManagerEntity fileManagerEntity, long j3, String str, String str2, long j16, int i3, String str3, long j17) {
        g(fileManagerEntity, j3, str);
        this.f209373a.getFileManagerDataCenter().p(str2, this.f209373a.getCurrentAccountUin(), true, "", j16, true, i3, str3, fileManagerEntity.msgSeq, j17, fileManagerEntity.msgUid, -1L, com.tencent.mobileqq.service.message.e.K0());
        this.f209373a.getFileManagerDataCenter().t(fileManagerEntity);
        return fileManagerEntity.nSessionId;
    }

    @Override // com.tencent.mobileqq.filemanager.util.w
    public void d(boolean z16, String str, long j3, int i3, String str2, String str3, String str4) {
    }
}
