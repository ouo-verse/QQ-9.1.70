package com.tencent.mobileqq.msgbackup.controller;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f251070a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22101);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f251070a = "MsgBackup_MsgBackupMultiMsgProcessor";
        }
    }

    public g(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static String i(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        if (msgBackupResEntity != null && !TextUtils.isEmpty(msgBackupResEntity.extraDataStr)) {
            try {
                return com.tencent.mobileqq.msgbackup.util.f.v(new JSONObject(msgBackupResEntity.extraDataStr).optString("uuid"));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord instanceof ChatMessage) {
            return ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).isMultiMsg((ChatMessage) messageRecord);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public k b(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (k) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord, (Object) msgBackupResEntity);
        }
        k kVar = new k();
        kVar.f251096b = e(messageRecord, msgBackupResEntity);
        kVar.f251095a = true;
        return kVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean c(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgBackupResEntity)).booleanValue();
        }
        if (msgBackupResEntity.msgType == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void d(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public String e(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageRecord, (Object) msgBackupResEntity);
        }
        if (msgBackupResEntity != null && !TextUtils.isEmpty(msgBackupResEntity.extraDataStr)) {
            try {
                return com.tencent.mobileqq.msgbackup.util.f.v(new JSONObject(msgBackupResEntity.extraDataStr).optString("uuid"));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void f(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void g(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgBackupResEntity);
            return;
        }
        if (msgBackupResEntity.msgType == 4) {
            String i3 = i(null, msgBackupResEntity);
            if (QLog.isDevelopLevel()) {
                QLog.d(f251070a, 2, "multimsg_tempFilPath = %s", i3);
            }
            if (new File(i3).exists()) {
                QLog.d(f251070a, 1, "multimsg tempFile to realFile");
                h(msgBackupResEntity, i3);
            }
        }
    }

    public void h(MsgBackupResEntity msgBackupResEntity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgBackupResEntity, (Object) str);
            return;
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.d(f251070a, 1, "MultiMsg kernelMsgService null");
            return;
        }
        String dataMigrationGetResourceLocalDestinyPath = e16.dataMigrationGetResourceLocalDestinyPath(new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr));
        if (dataMigrationGetResourceLocalDestinyPath != null && !TextUtils.isEmpty(dataMigrationGetResourceLocalDestinyPath)) {
            QLog.d(f251070a, 1, "MultiMsg absolutePath is " + dataMigrationGetResourceLocalDestinyPath);
            j(str, dataMigrationGetResourceLocalDestinyPath);
            return;
        }
        QLog.d(f251070a, 1, "MsgBackupMultiMsg MultiMsgFilePath is null or empty");
    }

    protected void j(String str, String str2) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int quickMove = FileUtils.quickMove(str, str2);
            File file = new File(str2);
            String str3 = f251070a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MultiMsg restore,quickMove: ");
            sb5.append(str);
            sb5.append(" to ");
            sb5.append(str2);
            sb5.append(" status:");
            sb5.append(quickMove);
            sb5.append(" size:");
            if (file.exists()) {
                obj = Long.valueOf(file.length());
            } else {
                obj = "-1";
            }
            sb5.append(obj);
            QLog.d(str3, 1, sb5.toString());
            return;
        }
        QLog.d(f251070a, 1, "MultiMsg importFile null error ");
    }
}
