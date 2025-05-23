package com.tencent.mobileqq.msgbackup.controller;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BaseQQAppInterface f251067a;

    /* renamed from: b, reason: collision with root package name */
    private hc1.b f251068b;

    /* renamed from: c, reason: collision with root package name */
    private hc1.c f251069c;

    public f(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        } else {
            this.f251067a = baseQQAppInterface;
        }
    }

    private HashMap<String, String> h(String str) {
        String str2;
        String str3;
        int i3;
        int i16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("uint64_sender_uin")) {
                str2 = "sha3";
                str3 = WidgetCacheLunarData.SHA;
            } else {
                String string = jSONObject.getString("uint64_sender_uin");
                str2 = "sha3";
                StringBuilder sb5 = new StringBuilder();
                str3 = WidgetCacheLunarData.SHA;
                sb5.append("decodeResExtInfo senderUin[");
                sb5.append(string);
                sb5.append("]");
                l("MsgBackupFileProcessor<QFile>", sb5.toString());
                hashMap.put("uint64_sender_uin", string);
            }
            if (jSONObject.has("uint64_receiver_uin")) {
                String string2 = jSONObject.getString("uint64_receiver_uin");
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo recvUin[" + string2 + "]");
                hashMap.put("uint64_receiver_uin", string2);
            }
            if (jSONObject.has("uint32_file_type")) {
                int i17 = jSONObject.getInt("uint32_file_type");
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo peerType[" + i17 + "]");
                hashMap.put("uint32_file_type", String.valueOf(i17));
            }
            if (jSONObject.has("bytes_file_uuid")) {
                String string3 = jSONObject.getString("bytes_file_uuid");
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileUuid[" + string3 + "]");
                hashMap.put("bytes_file_uuid", string3);
            }
            if (jSONObject.has("str_file_name")) {
                String string4 = jSONObject.getString("str_file_name");
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileName[" + string4 + "]");
                hashMap.put("str_file_name", string4);
            }
            if (jSONObject.has("uint64_file_size")) {
                long j3 = jSONObject.getLong("uint64_file_size");
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileSize[" + j3 + "]");
                hashMap.put("uint64_file_size", String.valueOf(j3));
            }
            if (jSONObject.has("md5")) {
                String string5 = jSONObject.getString("md5");
                if (!TextUtils.isEmpty(string5)) {
                    l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo fileMd5[" + string5 + "]");
                    hashMap.put("md5", string5);
                }
            }
            if (jSONObject.has("md510")) {
                String string6 = jSONObject.getString("md510");
                if (!TextUtils.isEmpty(string6)) {
                    l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo file10Md5[" + string6 + "]");
                    hashMap.put("md510", string6);
                }
            }
            String str4 = str3;
            if (jSONObject.has(str4)) {
                String string7 = jSONObject.getString(str4);
                if (!TextUtils.isEmpty(string7)) {
                    l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo sha[" + string7 + "]");
                    hashMap.put(str4, string7);
                }
            }
            String str5 = str2;
            if (jSONObject.has(str5)) {
                String string8 = jSONObject.getString(str5);
                if (!TextUtils.isEmpty(string8)) {
                    l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo sha3[" + string8 + "]");
                    hashMap.put(str5, string8);
                }
            }
            if (jSONObject.has("uint32_img_width") && (i16 = jSONObject.getInt("uint32_img_width")) != 0) {
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo imgWidth[" + i16 + "]");
                hashMap.put("uint32_img_width", String.valueOf(i16));
            }
            if (jSONObject.has("uint32_img_height") && (i3 = jSONObject.getInt("uint32_img_height")) != 0) {
                l("MsgBackupFileProcessor<QFile>", "decodeResExtInfo imgWidth[" + i3 + "]");
                hashMap.put("uint32_img_height", String.valueOf(i3));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private hc1.a i(int i3) {
        hc1.a aVar;
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: chatTYpe[" + i3 + "]");
        if (i3 == 1) {
            if (this.f251068b == null) {
                this.f251068b = new hc1.b(this.f251067a);
            }
            aVar = this.f251068b;
        } else if (i3 == 2) {
            if (this.f251068b == null) {
                this.f251068b = new hc1.b(this.f251067a);
            }
            aVar = this.f251068b;
        } else if (i3 == 3) {
            if (this.f251069c == null) {
                this.f251069c = new hc1.c(this.f251067a);
            }
            aVar = this.f251069c;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
            if (this.f251068b == null) {
                this.f251068b = new hc1.b(this.f251067a);
            }
            return this.f251068b;
        }
        return aVar;
    }

    private hc1.a j(MessageRecord messageRecord) {
        hc1.a aVar;
        hc1.a aVar2 = null;
        if (messageRecord.isMultiMsg) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                if (Integer.parseInt(extInfoFromExtStr) == 3) {
                    if (this.f251069c == null) {
                        this.f251069c = new hc1.c(this.f251067a);
                    }
                    aVar = this.f251069c;
                } else {
                    if (this.f251068b == null) {
                        this.f251068b = new hc1.b(this.f251067a);
                    }
                    aVar = this.f251068b;
                }
                aVar2 = aVar;
            }
        } else if (messageRecord instanceof MessageForFile) {
            if (this.f251068b == null) {
                this.f251068b = new hc1.b(this.f251067a);
            }
            aVar2 = this.f251068b;
        } else if (messageRecord instanceof MessageForTroopFile) {
            if (this.f251069c == null) {
                this.f251069c = new hc1.c(this.f251067a);
            }
            aVar2 = this.f251069c;
        }
        if (aVar2 == null) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
        }
        return aVar2;
    }

    private void l(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, str2);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if ((messageRecord instanceof MessageForTroopFile) || (messageRecord instanceof MessageForFile)) {
            return true;
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
        if (msgBackupResEntity == null) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
            kVar.f251095a = false;
            return kVar;
        }
        if (msgBackupResEntity.msgType != 5) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
            kVar.f251095a = false;
            return kVar;
        }
        String str = h(msgBackupResEntity.extraDataStr).get("uint32_file_type");
        if (TextUtils.isEmpty(str)) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: can not find chatType from extInfo. resInfo[" + msgBackupResEntity.toLogString() + "]");
            kVar.f251095a = false;
            return kVar;
        }
        kVar.f251095a = i(Integer.parseInt(str)).a(messageRecord, msgBackupResEntity);
        return kVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean c(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgBackupResEntity)).booleanValue();
        }
        if (msgBackupResEntity != null && msgBackupResEntity.msgType == 5) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord, (Object) msgBackupResEntity);
        }
        File file = new File(hc1.a.f404728c);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(hc1.a.f404727b);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return i(Integer.parseInt(h(msgBackupResEntity.extraDataStr).get("uint32_file_type"))).e(msgBackupResEntity);
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void f(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupFileProcessor<QFile>", 1, "onImportForFile begin");
        }
        hc1.a j3 = j(messageRecord);
        if (j3 != null) {
            j3.f(messageRecord, list);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void g(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgBackupResEntity);
            return;
        }
        if (k(msgBackupResEntity)) {
            String str = h(msgBackupResEntity.extraDataStr).get("uint32_file_type");
            if (TextUtils.isEmpty(str)) {
                QLog.d("MsgBackupFileProcessor<QFile>", 1, "onImportNormal File: can not find chatType from extInfo. resInfo[" + msgBackupResEntity.toLogString() + "]");
                return;
            }
            try {
                i(Integer.parseInt(str)).g(msgBackupResEntity);
            } catch (NumberFormatException unused) {
                QLog.e("MsgBackupFileProcessor<QFile>", 1, "onImportNormal File: strChatType transform failed");
            }
        }
    }

    protected boolean k(MsgBackupResEntity msgBackupResEntity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgBackupResEntity)).booleanValue();
        }
        if (msgBackupResEntity == null || msgBackupResEntity.msgType != 5 || ((i3 = msgBackupResEntity.msgSubType) != 12 && i3 != 11)) {
            return false;
        }
        return true;
    }
}
