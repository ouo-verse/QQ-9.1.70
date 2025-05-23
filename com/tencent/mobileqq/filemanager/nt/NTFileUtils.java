package com.tencent.mobileqq.filemanager.nt;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.TargetFileInfo;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NTFileUtils {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f208714a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.nt.NTFileUtils$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f208715d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208716e;

        AnonymousClass1(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
            this.f208715d = qQAppInterface;
            this.f208716e = fileManagerEntity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Object obj) {
            try {
                QLog.i("NTFileUtils", 1, "[addTencentDocFile2DocsList] result:" + obj);
            } catch (Throwable th5) {
                QLog.e("NTFileUtils", 1, "addTencentDocFile2DocsList failed", th5);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FileManagerEntity fileManagerEntity;
            if (this.f208715d != null && (fileManagerEntity = this.f208716e) != null && fileManagerEntity.peerUin != null && fileManagerEntity.Uuid != null) {
                ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("group_code=" + this.f208716e.peerUin + "&url=" + this.f208716e.Uuid + "&copy=1&xsrf=tencentdocs", this.f208715d.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/group_online_docs/doc_add", ITeamWorkHandler.DOCS_DOMAIN, "TOK=tencentdocs", null, false, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filemanager.nt.bd
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        NTFileUtils.AnonymousClass1.b(obj);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        FileManagerEntity f208717a;

        /* renamed from: b, reason: collision with root package name */
        FileElement f208718b;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f208719a;

        /* renamed from: c, reason: collision with root package name */
        public long f208721c;

        /* renamed from: d, reason: collision with root package name */
        public int f208722d;

        /* renamed from: e, reason: collision with root package name */
        public int f208723e;

        /* renamed from: f, reason: collision with root package name */
        public long f208724f;

        /* renamed from: g, reason: collision with root package name */
        public long f208725g;

        /* renamed from: b, reason: collision with root package name */
        public String f208720b = "";

        /* renamed from: h, reason: collision with root package name */
        public String f208726h = "";

        public String toString() {
            return "[Id:" + this.f208719a + " peerUid:" + this.f208720b + " peerUin:" + this.f208721c + " chatType:" + this.f208722d + " sendType:" + this.f208723e + " msgSeq:" + this.f208724f + " msgTime:" + this.f208725g + "]";
        }
    }

    @Nullable
    private static FileManagerEntity A(QQAppInterface qQAppInterface, MsgRecord msgRecord, long j3, ArkElement arkElement) {
        boolean z16;
        JSONObject jSONObject;
        String str;
        if (qQAppInterface != null && msgRecord != null && arkElement != null && j3 != 0) {
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
            String valueOf = String.valueOf(msgRecord.getPeerUin());
            FileManagerEntity fileManagerEntity = new FileManagerEntity();
            fileManagerEntity.nSessionId = g(msgRecord.getChatType());
            fileManagerEntity.uniseq = j3;
            fileManagerEntity.ntMsgId = msgRecord.getMsgId();
            fileManagerEntity.peerUin = valueOf;
            fileManagerEntity.peerUid = msgRecord.getPeerUid();
            fileManagerEntity.peerType = c16;
            fileManagerEntity.peerNick = com.tencent.mobileqq.filemanager.util.ah.z0(qQAppInterface, fileManagerEntity.peerUin, null, c16);
            fileManagerEntity.selfUin = qQAppInterface.getCurrentUin();
            fileManagerEntity.isReaded = true;
            fileManagerEntity.msgSeq = msgRecord.getMsgSeq();
            fileManagerEntity.srvTime = msgRecord.getMsgTime() * 1000;
            if (msgRecord.getSendType() != 1 && msgRecord.getSendType() != 2 && msgRecord.getSendType() != 4 && msgRecord.getSendType() != 5) {
                z16 = false;
            } else {
                z16 = true;
            }
            fileManagerEntity.bSend = z16;
            fileManagerEntity.nFileType = 13;
            String bytesData = arkElement.getBytesData();
            if (bytesData == null) {
                return null;
            }
            fileManagerEntity.bombData = bytesData.getBytes();
            try {
                jSONObject = new JSONObject(bytesData);
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                    if (jSONObject2.has("miniapp")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("miniapp");
                        if (jSONObject3.length() != 0) {
                            fileManagerEntity.fileName = jSONObject3.getString("title");
                            fileManagerEntity.strThumbPath = jSONObject3.getString("preview");
                            fileManagerEntity.Uuid = URLDecoder.decode(jSONObject3.getString("doc_url"), StandardCharsets.UTF_8.name());
                        }
                    } else if (jSONObject2.has("detail_1")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("detail_1");
                        if (jSONObject4.length() != 0) {
                            fileManagerEntity.fileName = jSONObject4.getString("desc");
                            fileManagerEntity.strThumbPath = jSONObject4.getString("preview");
                            fileManagerEntity.Uuid = jSONObject4.getString("qqdocurl");
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (jSONObject != null) {
                    }
                    return null;
                }
            } catch (Exception e17) {
                e = e17;
                jSONObject = null;
            }
            if (jSONObject != null || (str = fileManagerEntity.Uuid) == null || str.isEmpty()) {
                return null;
            }
            if (msgRecord.getSendType() != 0 && msgRecord.getSendType() != 2) {
                if (msgRecord.getSendType() == 1) {
                    fileManagerEntity.nOpType = 0;
                } else if (msgRecord.getSendType() == 4) {
                    fileManagerEntity.nOpType = 0;
                } else if (msgRecord.getSendType() == 5) {
                    fileManagerEntity.nOpType = 0;
                } else {
                    fileManagerEntity.nOpType = -1;
                }
            } else {
                fileManagerEntity.nOpType = 1;
            }
            if (msgRecord.getChatType() == 1) {
                fileManagerEntity.setCloudType(1);
            } else if (msgRecord.getChatType() == 2) {
                fileManagerEntity.setCloudType(4);
                fileManagerEntity.busId = 102;
                fileManagerEntity.TroopUin = msgRecord.getPeerUin();
            } else if (msgRecord.getChatType() == 8) {
                fileManagerEntity.setCloudType(6);
            } else {
                fileManagerEntity.setCloudType(-1);
            }
            fileManagerEntity.bDelInFM = false;
            return fileManagerEntity;
        }
        QLog.e("NTFileUtils", 1, "ntTextElement2TencentDocFileEntity fail, param err");
        return null;
    }

    private static FileManagerEntity B(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, long j3, FileElement fileElement) {
        String str;
        String str2;
        int i3;
        int i16;
        boolean z16;
        int i17;
        String str3;
        long j16;
        if (qQAppInterface != null && msgRecord != null && fileElement != null) {
            long j17 = 0;
            if (j3 != 0) {
                long msgId = msgRecord.getMsgId();
                com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
                long peerUin = msgRecord.getPeerUin();
                if (peerUin == 0) {
                    peerUin = c(msgRecord);
                }
                String valueOf = String.valueOf(peerUin);
                String peerUid = msgRecord.getPeerUid();
                int sendType = msgRecord.getSendType();
                int chatType = msgRecord.getChatType();
                long msgSeq = msgRecord.getMsgSeq();
                long msgTime = msgRecord.getMsgTime();
                if (bVar != null) {
                    QLog.w("NTFileUtils", 1, "ntFileElement2FileEntity. is file with root msg:" + bVar.toString());
                    long j18 = bVar.f208719a;
                    c16 = com.tencent.nt.adapter.session.c.c(bVar.f208722d);
                    peerUin = bVar.f208721c;
                    if (peerUin == 0) {
                        peerUin = d(bVar);
                    }
                    String valueOf2 = String.valueOf(peerUin);
                    String str4 = bVar.f208720b;
                    i3 = bVar.f208723e;
                    int i18 = bVar.f208722d;
                    long j19 = bVar.f208724f;
                    if (j19 != 0) {
                        msgSeq = j19;
                    }
                    long j26 = bVar.f208725g;
                    if (j26 != 0) {
                        msgTime = j26;
                    }
                    j17 = msgRecord.getMsgId();
                    i16 = i18;
                    str = valueOf2;
                    str2 = str4;
                    msgId = j18;
                } else {
                    str = valueOf;
                    str2 = peerUid;
                    i3 = sendType;
                    i16 = chatType;
                }
                long j27 = j17;
                long j28 = peerUin;
                long j29 = msgSeq;
                long j36 = msgTime;
                StringBuilder sb5 = new StringBuilder();
                int i19 = i16;
                sb5.append("ntFileElement2FileEntity msgId:");
                sb5.append(msgId);
                sb5.append(" peerUid:");
                sb5.append(str2);
                sb5.append(" peerUin:");
                sb5.append(str);
                sb5.append(" peerUinType:");
                sb5.append(c16);
                sb5.append(" uuid:");
                sb5.append(fileElement.getFileUuid());
                sb5.append(" sendType:");
                sb5.append(i3);
                sb5.append(" msgSeq:");
                sb5.append(j29);
                sb5.append(" msgTime:");
                sb5.append(j36);
                sb5.append("], fileElement.getFileSubId(): ");
                sb5.append(fileElement.getFileSubId());
                QLog.i("NTFileUtils", 1, sb5.toString());
                FileManagerEntity fileManagerEntity = new FileManagerEntity();
                int i26 = i3;
                fileManagerEntity.nSessionId = g(msgRecord.chatType);
                fileManagerEntity.uniseq = j3;
                fileManagerEntity.ntMsgId = msgId;
                fileManagerEntity.ntSubMsgID = j27;
                fileManagerEntity.ntChatType = i19;
                fileManagerEntity.peerUin = str;
                fileManagerEntity.peerUid = str2;
                fileManagerEntity.peerType = c16;
                fileManagerEntity.peerNick = com.tencent.mobileqq.filemanager.util.ah.z0(qQAppInterface, str, null, c16);
                fileManagerEntity.selfUin = qQAppInterface.getCurrentUin();
                fileManagerEntity.isReaded = true;
                fileManagerEntity.fileName = fileElement.getFileName();
                fileManagerEntity.fileSize = fileElement.getFileSize();
                fileManagerEntity.nFileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
                fileManagerEntity.strFilePath = fileElement.getFilePath();
                fileManagerEntity.zipFilePath = fileElement.getFilePath();
                fileManagerEntity.strFileMd5 = fileElement.getFileMd5();
                fileManagerEntity.str10Md5 = fileElement.getFile10MMd5();
                fileManagerEntity.strFileSHA = fileElement.getFileSha();
                fileManagerEntity.strFileSha3 = fileElement.getFileSha3();
                fileManagerEntity.Uuid = fileElement.getFileUuid();
                fileManagerEntity.fileIdCrc = fileElement.getFileSubId();
                int intValue = fileElement.getTransferStatus().intValue();
                if (intValue != 3 && intValue != 2) {
                    if (intValue == 5) {
                        fileManagerEntity.status = 0;
                    } else if (intValue == 4) {
                        fileManagerEntity.status = 1;
                    } else if (intValue == 6) {
                        fileManagerEntity.status = 3;
                    } else {
                        fileManagerEntity.status = -1;
                    }
                } else {
                    fileManagerEntity.status = 2;
                }
                if (fileElement.getInvalidState().intValue() != 0) {
                    fileManagerEntity.status = 16;
                }
                fileManagerEntity.lastTime = fileElement.getExpireTime().longValue();
                fileManagerEntity.imgHeight = fileElement.getPicHeight().intValue();
                fileManagerEntity.imgWidth = fileElement.getPicWidth().intValue();
                HashMap<Integer, String> picThumbPath = fileElement.getPicThumbPath();
                if (picThumbPath != null) {
                    fileManagerEntity.strThumbPath = picThumbPath.get(128);
                    fileManagerEntity.strMiddleThumPath = picThumbPath.get(Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384));
                    fileManagerEntity.strLargeThumPath = picThumbPath.get(750);
                }
                fileManagerEntity.msgSeq = j29;
                fileManagerEntity.srvTime = j36 * 1000;
                if (i26 != 1 && i26 != 2 && i26 != 4 && i26 != 5) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                fileManagerEntity.bSend = z16;
                if (i26 != 0 && i26 != 2) {
                    if (i26 == 1) {
                        if (msgRecord.sendStatus == 2) {
                            fileManagerEntity.nOpType = 1;
                            i17 = 1;
                        } else {
                            fileManagerEntity.nOpType = 0;
                        }
                    } else if (i26 == 4) {
                        fileManagerEntity.nOpType = 0;
                    } else if (i26 == 5) {
                        fileManagerEntity.nOpType = 0;
                    } else {
                        fileManagerEntity.nOpType = -1;
                    }
                    i17 = 1;
                } else {
                    i17 = 1;
                    fileManagerEntity.nOpType = 1;
                }
                if (p(i19)) {
                    fileManagerEntity.setCloudType(i17);
                    str3 = "NTFileUtils";
                } else if (i19 != 2) {
                    str3 = "NTFileUtils";
                    fileManagerEntity.setCloudType(-1);
                } else {
                    fileManagerEntity.setCloudType(4);
                    fileManagerEntity.strTroopFilePath = fileElement.getFileUuid();
                    fileManagerEntity.strTroopFileSha1 = fileElement.getFileSha();
                    fileManagerEntity.busId = 102;
                    if (fileElement.getFileBizId() == null || fileElement.getFileBizId().intValue() == 0) {
                        str3 = "NTFileUtils";
                        QLog.e(str3, 1, "NTFileElement2FileEntity. fileElement.bizid err use 102");
                        j16 = j28;
                    } else {
                        fileManagerEntity.busId = fileElement.getFileBizId().intValue();
                        j16 = j28;
                        str3 = "NTFileUtils";
                    }
                    fileManagerEntity.TroopUin = j16;
                }
                if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                    fileManagerEntity.setCloudType(3);
                }
                QLog.d(str3, 1, "ntFileElement2FileEntity. fileMsgRecord.status: " + fileManagerEntity.status + ", fileMsgRecord.chatType: " + i19 + ", fileMsgRecord.msgSeq: " + j29 + ", fileManagerEntity.cloudType: " + fileManagerEntity.cloudType + ",fileElement: " + fileElement);
                return fileManagerEntity;
            }
        }
        QLog.e("NTFileUtils", 1, "NTFileElement2FileEntity fail, param err");
        return null;
    }

    public static List<FileManagerEntity> C(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, boolean z16) {
        FileManagerEntity fileManagerEntity;
        if (qQAppInterface != null && (r(msgRecord) || z16)) {
            ArrayList arrayList = new ArrayList();
            Iterator<MsgElement> it = msgRecord.getElements().iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.getElementType() == 3 && next.getFileElement() != null) {
                    fileManagerEntity = B(qQAppInterface, bVar, msgRecord, next.getElementId(), next.getFileElement());
                } else if (z16 && next.getArkElement() != null) {
                    fileManagerEntity = A(qQAppInterface, msgRecord, next.getElementId(), next.getArkElement());
                    b(qQAppInterface, fileManagerEntity, msgRecord);
                } else {
                    fileManagerEntity = null;
                }
                if (fileManagerEntity != null) {
                    arrayList.add(fileManagerEntity);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static ActionSheet D(Activity activity, ActionSheet.OnButtonClickListener onButtonClickListener, View.OnClickListener onClickListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(activity, R.string.h2a), 0, 0, 2));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(activity, arrayList, onButtonClickListener);
        if (createActionSheet != null) {
            createActionSheet.addCancelButton(R.string.cancel);
            createActionSheet.setOnBottomCancelListener(onClickListener);
            ActionSheetHelper.showActionSheet(activity, createActionSheet);
        }
        return createActionSheet;
    }

    public static ActionSheet E(Activity activity, ActionSheet.OnButtonClickListener onButtonClickListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(activity, R.string.h2a), 0, 0, 2));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(activity, arrayList, onButtonClickListener);
        if (createActionSheet != null) {
            createActionSheet.addCancelButton(R.string.cancel);
        }
        return createActionSheet;
    }

    public static void F(FileManagerEntity fileManagerEntity, int i3) {
        if (p(i3)) {
            fileManagerEntity.setCloudType(1);
        } else if (i3 == 2) {
            fileManagerEntity.setCloudType(4);
        } else {
            fileManagerEntity.setCloudType(-1);
        }
        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
            fileManagerEntity.setCloudType(3);
        }
        fileManagerEntity.ntChatType = i3;
    }

    public static void G(String str) {
        PosixFilePermission posixFilePermission;
        PosixFilePermission posixFilePermission2;
        PosixFilePermission posixFilePermission3;
        PosixFilePermission posixFilePermission4;
        PosixFilePermission posixFilePermission5;
        PosixFilePermission posixFilePermission6;
        PosixFilePermission posixFilePermission7;
        Path path;
        if (Build.VERSION.SDK_INT < 26) {
            QLog.i("FilePermission", 1, "ver less O");
            return;
        }
        HashSet hashSet = new HashSet();
        posixFilePermission = PosixFilePermission.OWNER_WRITE;
        hashSet.add(posixFilePermission);
        posixFilePermission2 = PosixFilePermission.OWNER_READ;
        hashSet.add(posixFilePermission2);
        posixFilePermission3 = PosixFilePermission.OWNER_EXECUTE;
        hashSet.add(posixFilePermission3);
        posixFilePermission4 = PosixFilePermission.GROUP_READ;
        hashSet.add(posixFilePermission4);
        posixFilePermission5 = PosixFilePermission.GROUP_WRITE;
        hashSet.add(posixFilePermission5);
        posixFilePermission6 = PosixFilePermission.OTHERS_READ;
        hashSet.add(posixFilePermission6);
        posixFilePermission7 = PosixFilePermission.OTHERS_WRITE;
        hashSet.add(posixFilePermission7);
        try {
            path = Paths.get(str, new String[0]);
            QLog.i("FilePermission", 1, "set:" + str + " perimission");
            Files.setPosixFilePermissions(path, hashSet);
        } catch (Throwable th5) {
            QLog.i("FilePermission", 1, "set file throwable");
            th5.printStackTrace();
        }
    }

    public static void b(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, MsgRecord msgRecord) {
        if (!Objects.equals(String.valueOf(msgRecord.senderUin), qQAppInterface.getCurrentUin())) {
            return;
        }
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(qQAppInterface, fileManagerEntity);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.bc
            @Override // java.lang.Runnable
            public final void run() {
                ThreadManagerV2.executeOnNetWorkThread(anonymousClass1);
            }
        }, 128, null, true);
    }

    private static long c(MsgRecord msgRecord) {
        long j3 = 0;
        if (msgRecord == null) {
            return 0L;
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (msgRecord.getChatType() != 2 && msgRecord.getChatType() != 3) {
            if (msgRecord.getChatType() == 8) {
                j3 = Long.parseLong(DataLineNTMsgMigrationUtil.d(msgRecord.getPeerUid()));
            } else if (msgRecord.getChatType() != 4) {
                j3 = Long.valueOf(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(msgRecord.getPeerUid())).longValue();
            }
            return j3;
        }
        j3 = Long.valueOf(msgRecord.getPeerUid()).longValue();
        return j3;
    }

    private static long d(b bVar) {
        int i3;
        long j3 = 0;
        try {
            i3 = bVar.f208722d;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                j3 = Long.valueOf(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(bVar.f208720b)).longValue();
            }
            return j3;
        }
        j3 = Long.valueOf(bVar.f208720b).longValue();
        return j3;
    }

    public static ForwardFileInfo e(QQAppInterface qQAppInterface, MsgRecord msgRecord, long j3) {
        FileElement fileElement;
        HashMap<Integer, String> hashMap;
        a h16 = h(qQAppInterface, null, msgRecord, j3);
        if (h16 != null && (fileElement = h16.f208718b) != null) {
            FileManagerEntity fileManagerEntity = h16.f208717a;
            if (p(msgRecord.getChatType())) {
                ForwardFileInfo U = ForwardFileOption.U(fileManagerEntity);
                if (TextUtils.isEmpty(U.l())) {
                    U.C(fileElement.filePath);
                }
                if (TextUtils.isEmpty(U.p())) {
                    U.C(fileElement.filePath);
                    HashMap<Integer, String> hashMap2 = fileElement.picThumbPath;
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        U.G(fileElement.picThumbPath.values().iterator().next());
                    }
                }
                return U;
            }
            if (msgRecord.getChatType() == 2) {
                ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                if (fileManagerEntity != null) {
                    FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
                    fileManagerEntity2.copyFrom(fileManagerEntity);
                    fileManagerEntity2.nSessionId = g(msgRecord.chatType);
                    fileManagerEntity2.status = 2;
                    qQAppInterface.getFileManagerDataCenter().v(fileManagerEntity2);
                    com.tencent.mobileqq.troop.data.t n3 = TroopFileUtils.n(qQAppInterface, fileManagerEntity2);
                    forwardFileInfo.E(fileManagerEntity2.nSessionId);
                    if (!TextUtils.isEmpty(fileManagerEntity2.getFilePath())) {
                        forwardFileInfo.C(fileManagerEntity2.getFilePath());
                    } else if (!TextUtils.isEmpty(n3.f294978l)) {
                        forwardFileInfo.C(n3.f294978l);
                    }
                    if (!com.tencent.mobileqq.filemanager.util.q.f(forwardFileInfo.l())) {
                        forwardFileInfo.C(null);
                    }
                    forwardFileInfo.y(n3.f294987u);
                    forwardFileInfo.z(n3.f294976j);
                    forwardFileInfo.B(fileManagerEntity2.TroopUin);
                    String str = n3.f294981o;
                    if (TextUtils.isEmpty(str)) {
                        str = n3.f294980n;
                    }
                    if (TextUtils.isEmpty(str) && (hashMap = fileElement.picThumbPath) != null && !hashMap.isEmpty()) {
                        str = fileElement.picThumbPath.values().iterator().next();
                    }
                    forwardFileInfo.G(str);
                    if (fileManagerEntity2.isZipInnerFile) {
                        forwardFileInfo.N(10000);
                        forwardFileInfo.w(3);
                    } else {
                        UUID uuid = n3.f294967a;
                        if (uuid != null) {
                            forwardFileInfo.M(uuid.toString());
                        }
                        forwardFileInfo.N(10006);
                        forwardFileInfo.w(4);
                    }
                } else {
                    forwardFileInfo.y(fileElement.getFileName());
                    forwardFileInfo.z(fileElement.getFileSize());
                    forwardFileInfo.C(fileElement.getFilePath());
                    forwardFileInfo.B(msgRecord.getPeerUin());
                    HashMap<Integer, String> picThumbPath = fileElement.getPicThumbPath();
                    String str2 = picThumbPath.get(750);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = picThumbPath.get(Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384));
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = picThumbPath.get(128);
                    }
                    forwardFileInfo.G(str2);
                    forwardFileInfo.N(10006);
                    forwardFileInfo.w(4);
                }
                return forwardFileInfo;
            }
        }
        return null;
    }

    public static void f(ActionSheet actionSheet) {
        if (actionSheet != null && actionSheet.isShowing()) {
            actionSheet.dismiss();
        }
    }

    public static long g(int i3) {
        com.tencent.qqnt.kernel.api.w msgService;
        Long j06;
        IKernelService a16 = new com.tencent.mobileqq.injector.q().a();
        if (a16 != null && (msgService = a16.getMsgService()) != null && (j06 = msgService.j0(i3)) != null && j06.longValue() > 0) {
            return j06.longValue();
        }
        return FileManagerUtil.genSessionId().longValue();
    }

    public static a h(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, long j3) {
        FileElement l3 = l(msgRecord, j3);
        if (l3 != null) {
            a aVar = new a();
            aVar.f208718b = l3;
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
            long peerUin = msgRecord.getPeerUin();
            if (peerUin == 0) {
                peerUin = c(msgRecord);
            }
            String valueOf = String.valueOf(peerUin);
            if (bVar != null) {
                c16 = com.tencent.nt.adapter.session.c.c(bVar.f208722d);
                long j16 = bVar.f208721c;
                if (j16 == 0) {
                    j16 = d(bVar);
                }
                valueOf = String.valueOf(j16);
            }
            FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(j3, valueOf, c16);
            aVar.f208717a = E;
            if (E == null) {
                FileManagerEntity B = B(qQAppInterface, bVar, msgRecord, j3, l3);
                aVar.f208717a = B;
                if (B != null) {
                    qQAppInterface.getFileManagerProxy().x(aVar.f208717a);
                    return aVar;
                }
                return aVar;
            }
            return aVar;
        }
        return null;
    }

    public static FileManagerEntity i(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, long j3) {
        int i3;
        FileManagerEntity fileManagerEntity;
        long j16;
        com.tencent.mobileqq.troop.data.n A;
        FileElement l3 = l(msgRecord, j3);
        if (l3 != null) {
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
            long peerUin = msgRecord.getPeerUin();
            if (peerUin == 0) {
                peerUin = c(msgRecord);
            }
            String valueOf = String.valueOf(peerUin);
            if (bVar != null) {
                c16 = com.tencent.nt.adapter.session.c.c(bVar.f208722d);
                peerUin = bVar.f208721c;
                if (peerUin == 0) {
                    peerUin = d(bVar);
                }
                valueOf = String.valueOf(peerUin);
            }
            j16 = peerUin;
            if (msgRecord.chatType == 8) {
                if (PeerUid.DATALINE_PC_UID.equals(msgRecord.peerUid)) {
                    valueOf = AppConstants.DATALINE_PC_UIN;
                    c16 = 6000;
                } else if (PeerUid.DATALINE_PAD_UID.equals(msgRecord.peerUid)) {
                    valueOf = AppConstants.DATALINE_IPAD_UIN;
                    c16 = 6003;
                }
            }
            i3 = c16;
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().E(j3, valueOf, i3);
            if (fileManagerEntity == null) {
                fileManagerEntity = B(qQAppInterface, bVar, msgRecord, j3, l3);
                if (fileManagerEntity != null) {
                    qQAppInterface.getFileManagerProxy().x(fileManagerEntity);
                }
            } else {
                int i16 = msgRecord.chatType;
                if (i16 == 8 && fileManagerEntity.ntChatType != i16) {
                    F(fileManagerEntity, 8);
                }
            }
        } else {
            i3 = 0;
            fileManagerEntity = null;
            j16 = 0;
        }
        if (fileManagerEntity != null && i3 == 1 && j16 != 0 && (A = TroopFileManager.F(qQAppInterface, j16).A(l3.getFileUuid())) != null) {
            if (TextUtils.isEmpty(fileManagerEntity.getFilePath()) && FileUtils.fileExists(A.f294934t)) {
                fileManagerEntity.setFilePath(A.f294934t);
                fileManagerEntity.setCloudType(3);
            }
            long j17 = A.f294918d;
            if (j17 > 0) {
                fileManagerEntity.fProgress = ((float) A.f294932r) / ((float) j17);
            }
        }
        return fileManagerEntity;
    }

    public static FileManagerEntity j(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, FileElement fileElement, long j3) {
        int i3;
        FileManagerEntity fileManagerEntity;
        long j16;
        com.tencent.mobileqq.troop.data.n A;
        if (fileElement != null) {
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
            long peerUin = msgRecord.getPeerUin();
            if (peerUin == 0) {
                peerUin = c(msgRecord);
            }
            String valueOf = String.valueOf(peerUin);
            if (bVar != null) {
                c16 = com.tencent.nt.adapter.session.c.c(bVar.f208722d);
                peerUin = bVar.f208721c;
                if (peerUin == 0) {
                    peerUin = d(bVar);
                }
                valueOf = String.valueOf(peerUin);
            }
            i3 = c16;
            j16 = peerUin;
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().E(j3, valueOf, i3);
            if (fileManagerEntity == null && (fileManagerEntity = B(qQAppInterface, bVar, msgRecord, j3, fileElement)) != null) {
                qQAppInterface.getFileManagerProxy().x(fileManagerEntity);
            }
        } else {
            i3 = 0;
            fileManagerEntity = null;
            j16 = 0;
        }
        if (fileManagerEntity != null && i3 == 1 && j16 != 0 && (A = TroopFileManager.F(qQAppInterface, j16).A(fileElement.getFileUuid())) != null) {
            if (TextUtils.isEmpty(fileManagerEntity.getFilePath()) && FileUtils.fileExists(A.f294934t)) {
                fileManagerEntity.setFilePath(A.f294934t);
                fileManagerEntity.setCloudType(3);
            }
            long j17 = A.f294918d;
            if (j17 > 0) {
                fileManagerEntity.fProgress = ((float) A.f294932r) / ((float) j17);
            }
        }
        return fileManagerEntity;
    }

    public static List<FileManagerEntity> k(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, boolean z16) {
        FileManagerEntity B;
        if (qQAppInterface != null && r(msgRecord)) {
            ArrayList arrayList = new ArrayList();
            Iterator<MsgElement> it = msgRecord.getElements().iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.getElementType() == 3) {
                    long elementId = next.getElementId();
                    FileElement fileElement = next.getFileElement();
                    if (fileElement != null) {
                        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                        int c16 = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
                        long peerUin = msgRecord.getPeerUin();
                        if (peerUin == 0) {
                            peerUin = c(msgRecord);
                        }
                        String valueOf = String.valueOf(peerUin);
                        if (bVar != null) {
                            c16 = com.tencent.nt.adapter.session.c.c(bVar.f208722d);
                            long j3 = bVar.f208721c;
                            if (j3 == 0) {
                                j3 = d(bVar);
                            }
                            valueOf = String.valueOf(j3);
                        }
                        FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(elementId, valueOf, c16);
                        if (E != null) {
                            arrayList.add(E);
                        } else if (!z16 && (B = B(qQAppInterface, bVar, msgRecord, elementId, fileElement)) != null) {
                            qQAppInterface.getFileManagerProxy().x(B);
                            arrayList.add(B);
                        }
                    }
                }
            }
            return arrayList;
        }
        QLog.e("NTFileUtils", 1, "getFileEntityOfNTMsg fail, app=null/isValidNTFileMsg");
        return null;
    }

    public static FileElement l(MsgRecord msgRecord, long j3) {
        if (!r(msgRecord)) {
            QLog.e("NTFileUtils", 1, "getNTFileElement err. not is nt file msg, msgId:" + msgRecord.getMsgId());
            return null;
        }
        if (j3 == 0) {
            QLog.e("NTFileUtils", 1, "getNTFileElement err. fileElemId=0");
            return null;
        }
        Iterator<MsgElement> it = msgRecord.getElements().iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.getElementType() == 3) {
                long elementId = next.getElementId();
                FileElement fileElement = next.getFileElement();
                if (fileElement == null) {
                    QLog.w("NTFileUtils", 1, "getNTFileElement err. file elem is null");
                } else if (elementId == j3) {
                    return fileElement;
                }
            }
        }
        return null;
    }

    public static TroopFileTransferManager.Item m(QQAppInterface qQAppInterface, b bVar, MsgRecord msgRecord, long j3) {
        int i3;
        if (qQAppInterface != null && r(msgRecord)) {
            if (msgRecord.getChatType() != 2) {
                QLog.e("NTFileUtils", 1, "getTroopFileItemOfNTMsg fail, chat type error");
                return null;
            }
            FileElement l3 = l(msgRecord, j3);
            if (l3 == null) {
                QLog.e("NTFileUtils", 1, "getTroopFileItemOfNTMsg fail, fileElement is null");
                return null;
            }
            try {
                TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(msgRecord.getPeerUid()).longValue());
                if (O == null) {
                    return null;
                }
                if (l3.getFileBizId() != null && l3.getFileBizId().intValue() != 0) {
                    i3 = l3.getFileBizId().intValue();
                } else {
                    QLog.e("NTFileUtils", 1, "getTroopFileItemOfNTMsg. fileElement.bizid err use 102");
                    i3 = 102;
                }
                int i16 = i3;
                Bundle bundle = new Bundle();
                long msgId = msgRecord.getMsgId();
                if (bVar != null) {
                    msgId = bVar.f208719a;
                }
                bundle.putLong("TRANS_PARAM_NT_MSGID", msgId);
                bundle.putLong("TRANS_PARAM_NT_ELEMENTID", j3);
                return O.P(l3.getFileUuid(), l3.getFileName(), l3.getFileSize(), i16, bundle);
            } catch (Exception unused) {
                return null;
            }
        }
        QLog.e("NTFileUtils", 1, "getTroopFileItemOfNTMsg fail, app=null/isValidNTFileMsg");
        return null;
    }

    public static String n(QQAppInterface qQAppInterface, String str, String str2) {
        long j3;
        if (qQAppInterface == null) {
            QLog.e("NTFileUtils", 1, "getTroopFilePathFromTransMgrByFileId err. app = null");
            return null;
        }
        try {
            j3 = Long.valueOf(str).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 == 0) {
            QLog.e("NTFileUtils", 1, "getTroopFilePathFromTransMgrByFileId err. troopCode = 0");
            return null;
        }
        TroopFileManager F = TroopFileManager.F(qQAppInterface, j3);
        if (F == null) {
            QLog.e("NTFileUtils", 1, "getTroopFilePathFromTransMgrByFileId err. fm=null,troopCode=" + j3);
            return null;
        }
        com.tencent.mobileqq.troop.data.n A = F.A(str2);
        if (A == null) {
            QLog.e("NTFileUtils", 1, "getTroopFilePathFromTransMgrByFileId err. info=null,troopCode=" + j3);
            return null;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        if (O == null) {
            QLog.e("NTFileUtils", 1, "getTroopFilePathFromTransMgrByFileId err. udMgr=null,troopCode=" + j3);
            return null;
        }
        TroopFileTransferManager.Item J = O.J(A.f294915a);
        if (J == null) {
            return null;
        }
        return J.LocalFile;
    }

    public static boolean o(int i3) {
        if (i3 != 0 && i3 != 1000 && i3 != 1004 && i3 != 1024 && i3 != 1025 && i3 != 6000 && i3 != 6005 && i3 != 6003) {
            return false;
        }
        return true;
    }

    public static boolean p(int i3) {
        if (i3 == 1 || i3 == 100 || i3 == 101 || i3 == 102 || i3 == 103 || i3 == 115 || i3 == 8) {
            return true;
        }
        return false;
    }

    public static boolean q(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean r(MsgRecord msgRecord) {
        if (msgRecord == null || msgRecord.getMsgType() != 3 || msgRecord.getElements().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean s(MsgRecord msgRecord) {
        MsgElement msgElement;
        String bytesData;
        if (msgRecord.getMsgType() != 11) {
            return false;
        }
        ArrayList<MsgElement> elements = msgRecord.getElements();
        if (!elements.isEmpty() && (msgElement = elements.get(0)) != null && msgElement.getElementType() == 10 && (bytesData = msgElement.getArkElement().getBytesData()) != null) {
            String str = null;
            try {
                str = URLDecoder.decode(URLDecoder.decode(bytesData, StandardCharsets.UTF_8.name()), StandardCharsets.UTF_8.name()).replaceAll("\\\\/", "/").replaceAll("\n", "");
                int indexOf = str.indexOf("https://docs.qq.com/");
                if (indexOf >= 0) {
                    str = str.substring(indexOf);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (com.tencent.mobileqq.filemanager.data.e.g(str)) {
                return true;
            }
        }
        return false;
    }

    public static TargetFileInfo u(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = fileManagerEntity2.fileName;
        if (str8 == null) {
            str = "";
        } else {
            str = str8;
        }
        String str9 = fileManagerEntity2.strFileMd5;
        if (str9 == null) {
            str2 = "";
        } else {
            str2 = str9;
        }
        String str10 = fileManagerEntity2.str10Md5;
        if (str10 == null) {
            str3 = "";
        } else {
            str3 = str10;
        }
        String str11 = fileManagerEntity2.strFileSHA;
        if (str11 == null) {
            str4 = "";
        } else {
            str4 = str11;
        }
        String str12 = fileManagerEntity2.strFileSha3;
        if (str12 == null) {
            str5 = "";
        } else {
            str5 = str12;
        }
        String str13 = fileManagerEntity2.strFavId;
        if (str13 == null) {
            str6 = "";
        } else {
            str6 = str13;
        }
        String str14 = fileManagerEntity2.strFavFileId;
        String substring = str14.substring(0, str14.indexOf(47));
        if (substring == null) {
            str7 = "";
        } else {
            str7 = substring;
        }
        String substring2 = str14.substring(str14.indexOf(47));
        if (substring2 == null) {
            substring2 = "";
        }
        return new TargetFileInfo(fileManagerEntity2.ntMsgId, fileManagerEntity2.uniseq, new CommonFileInfo(fileManagerEntity2.nSessionId, 0L, 0L, substring2, "", str, fileManagerEntity2.fileSize, 0L, "", i3, str2, str3, str4, str5, str7, str6, 0, new HashMap()));
    }

    public static TargetFileInfo v(FileManagerEntity fileManagerEntity) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = fileManagerEntity.fileName;
        if (str9 == null) {
            str = "";
        } else {
            str = str9;
        }
        String str10 = fileManagerEntity.strFileMd5;
        if (str10 == null) {
            str2 = "";
        } else {
            str2 = str10;
        }
        String str11 = fileManagerEntity.str10Md5;
        if (str11 == null) {
            str3 = "";
        } else {
            str3 = str11;
        }
        String str12 = fileManagerEntity.strFileSHA;
        if (str12 == null) {
            str4 = "";
        } else {
            str4 = str12;
        }
        String str13 = fileManagerEntity.strFileSha3;
        if (str13 == null) {
            str5 = "";
        } else {
            str5 = str13;
        }
        String str14 = fileManagerEntity.Uuid;
        if (str14 == null) {
            str6 = "";
        } else {
            str6 = str14;
        }
        String str15 = fileManagerEntity.fileIdCrc;
        if (str15 == null) {
            str7 = "";
        } else {
            str7 = str15;
        }
        String str16 = fileManagerEntity.fwSrcPeerUid;
        if (str16 == null) {
            str8 = "";
        } else {
            str8 = str16;
        }
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.fwSrcPeerType);
        long j3 = fileManagerEntity.msgTime / 1000;
        if (j3 == 0) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        }
        return new TargetFileInfo(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, new CommonFileInfo(fileManagerEntity.nSessionId, fileManagerEntity.fwSrcNtMsgId, fileManagerEntity.fwSrcUniseq, str6, str7, str, fileManagerEntity.fileSize, j3, str8, l3, str2, str3, str4, str5, "", "", 0, new HashMap()));
    }

    public static TargetFileInfo w(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = fileManagerEntity.fileName;
        if (str9 == null) {
            str = "";
        } else {
            str = str9;
        }
        String str10 = fileManagerEntity.strFileMd5;
        if (str10 == null) {
            str2 = "";
        } else {
            str2 = str10;
        }
        String str11 = fileManagerEntity.str10Md5;
        if (str11 == null) {
            str3 = "";
        } else {
            str3 = str11;
        }
        String str12 = fileManagerEntity.strFileSHA;
        if (str12 == null) {
            str4 = "";
        } else {
            str4 = str12;
        }
        String str13 = fileManagerEntity.strFileSha3;
        if (str13 == null) {
            str5 = "";
        } else {
            str5 = str13;
        }
        String str14 = fileManagerEntity.Uuid;
        if (str14 == null) {
            str6 = "";
        } else {
            str6 = str14;
        }
        String str15 = fileManagerEntity.fileIdCrc;
        if (str15 == null) {
            str7 = "";
        } else {
            str7 = str15;
        }
        String str16 = fileManagerEntity.peerUid;
        if (str16 == null) {
            str8 = "";
        } else {
            str8 = str16;
        }
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
        long j3 = fileManagerEntity.msgTime / 1000;
        if (j3 == 0) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        }
        return new TargetFileInfo(fileManagerEntity2.ntMsgId, fileManagerEntity2.uniseq, new CommonFileInfo(fileManagerEntity2.nSessionId, fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, str6, str7, str, fileManagerEntity2.fileSize, j3, str8, l3, str2, str3, str4, str5, "", "", 0, new HashMap()));
    }

    public static TargetFileInfo x(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = fileManagerEntity2.fileName;
        if (str8 == null) {
            str = "";
        } else {
            str = str8;
        }
        String str9 = fileManagerEntity2.strFileMd5;
        if (str9 == null) {
            str2 = "";
        } else {
            str2 = str9;
        }
        String str10 = fileManagerEntity2.str10Md5;
        if (str10 == null) {
            str3 = "";
        } else {
            str3 = str10;
        }
        String str11 = fileManagerEntity2.strFileSHA;
        if (str11 == null) {
            str4 = "";
        } else {
            str4 = str11;
        }
        String str12 = fileManagerEntity2.strFileSha3;
        if (str12 == null) {
            str5 = "";
        } else {
            str5 = str12;
        }
        String str13 = fileManagerEntity2.strTroopFilePath;
        if (str13 == null) {
            str6 = "";
        } else {
            str6 = str13;
        }
        String str14 = fileManagerEntity.peerUin;
        if (str14 == null) {
            str7 = "";
        } else {
            str7 = str14;
        }
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
        long j3 = fileManagerEntity.msgTime / 1000;
        if (j3 == 0) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        }
        return new TargetFileInfo(fileManagerEntity2.ntMsgId, fileManagerEntity2.uniseq, new CommonFileInfo(fileManagerEntity2.nSessionId, fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, str6, "", str, fileManagerEntity2.fileSize, j3, str7, l3, str2, str3, str4, str5, "", "", Integer.valueOf(i3), new HashMap()));
    }

    public static TargetFileInfo y(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = fileManagerEntity2.fileName;
        if (str8 == null) {
            str = "";
        } else {
            str = str8;
        }
        String str9 = fileManagerEntity2.strFileMd5;
        if (str9 == null) {
            str2 = "";
        } else {
            str2 = str9;
        }
        String str10 = fileManagerEntity2.str10Md5;
        if (str10 == null) {
            str3 = "";
        } else {
            str3 = str10;
        }
        String str11 = fileManagerEntity2.strFileSHA;
        if (str11 == null) {
            str4 = "";
        } else {
            str4 = str11;
        }
        String str12 = fileManagerEntity2.strFileSha3;
        if (str12 == null) {
            str5 = "";
        } else {
            str5 = str12;
        }
        String str13 = fileManagerEntity2.strTroopFilePath;
        if (str13 == null) {
            str6 = "";
        } else {
            str6 = str13;
        }
        String str14 = fileManagerEntity.peerUin;
        if (str14 == null) {
            str7 = "";
        } else {
            str7 = str14;
        }
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
        long j3 = fileManagerEntity.msgTime / 1000;
        if (j3 == 0) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        }
        return new TargetFileInfo(fileManagerEntity2.ntMsgId, fileManagerEntity2.uniseq, new CommonFileInfo(fileManagerEntity2.nSessionId, fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, str6, "", str, fileManagerEntity2.fileSize, j3, str7, l3, str2, str3, str4, str5, "", "", Integer.valueOf(i3), new HashMap()));
    }

    public static TargetFileInfo z(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = fileManagerEntity2.fileName;
        if (str8 == null) {
            str = "";
        } else {
            str = str8;
        }
        String str9 = fileManagerEntity2.strFileMd5;
        if (str9 == null) {
            str2 = "";
        } else {
            str2 = str9;
        }
        String str10 = fileManagerEntity2.str10Md5;
        if (str10 == null) {
            str3 = "";
        } else {
            str3 = str10;
        }
        String str11 = fileManagerEntity2.strFileSHA;
        if (str11 == null) {
            str4 = "";
        } else {
            str4 = str11;
        }
        String str12 = fileManagerEntity2.strFileSha3;
        if (str12 == null) {
            str5 = "";
        } else {
            str5 = str12;
        }
        String str13 = fileManagerEntity2.WeiYunDirKey;
        if (str13 == null) {
            str6 = "";
        } else {
            str6 = str13;
        }
        String str14 = fileManagerEntity2.WeiYunFileId;
        if (str14 == null) {
            str7 = "";
        } else {
            str7 = str14;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(750, fileManagerEntity2.strThumbPath);
        return new TargetFileInfo(fileManagerEntity2.ntMsgId, fileManagerEntity2.uniseq, new CommonFileInfo(fileManagerEntity2.nSessionId, 0L, 0L, str7, "", str, fileManagerEntity2.fileSize, 0L, "", i3, str2, str3, str4, str5, str6, "", 0, hashMap));
    }
}
