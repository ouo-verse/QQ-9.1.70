package com.tencent.mobileqq.filemanager.nt;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTC2CFileTransferMgr;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.TargetFileInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NTC2CFileTransferMgr {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208666a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Long, h> f208667b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Long, g> f208668c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, FileManagerEntity> f208669d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, String> f208670e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f208672d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MsgRecord f208673e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f208674f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ NTFileManageBridger.f f208675h;

        a(List list, MsgRecord msgRecord, ActionSheet actionSheet, NTFileManageBridger.f fVar) {
            this.f208672d = list;
            this.f208673e = msgRecord;
            this.f208674f = actionSheet;
            this.f208675h = fVar;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            for (FileManagerEntity fileManagerEntity : this.f208672d) {
                QLog.i("NTC2CFileTransferMgr", 1, "reSendAioFileMsg resume msgId:" + this.f208673e.getMsgId() + NTC2CFileTransferMgr.this.R(fileManagerEntity));
                NTC2CFileTransferMgr.this.J().getFileManagerEngine().o0(fileManagerEntity.nSessionId);
                NTFileUtils.f(this.f208674f);
            }
            NTFileManageBridger.f fVar = this.f208675h;
            if (fVar != null) {
                fVar.onResult(0, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f208677d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NTFileManageBridger.f f208678e;

        b(ActionSheet actionSheet, NTFileManageBridger.f fVar) {
            this.f208677d = actionSheet;
            this.f208678e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NTFileUtils.f(this.f208677d);
            NTFileManageBridger.f fVar = this.f208678e;
            if (fVar != null) {
                fVar.onResult(-1, " cancel");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NTFileManageBridger.f f208681b;

        c(FileManagerEntity fileManagerEntity, NTFileManageBridger.f fVar) {
            this.f208680a = fileManagerEntity;
            this.f208681b = fVar;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            NTFileManageBridger.f fVar = this.f208681b;
            if (fVar != null) {
                fVar.onResult(-1, "cancel");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            int i3 = this.f208680a.status;
            if (i3 != 3 && i3 != 0) {
                QLog.i("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg. recv sid:" + this.f208680a.nSessionId);
                NTC2CFileTransferMgr.this.J().getFileManagerEngine().t0(this.f208680a);
            } else {
                QLog.i("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg. resume sid:" + this.f208680a.nSessionId);
                NTC2CFileTransferMgr.this.J().getFileManagerEngine().o0(this.f208680a.nSessionId);
            }
            NTFileManageBridger.f fVar = this.f208681b;
            if (fVar != null) {
                fVar.onResult(0, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements IForwardOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208683a;

        d(FileManagerEntity fileManagerEntity) {
            this.f208683a = fileManagerEntity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(FileManagerEntity fileManagerEntity, int i3, String str) {
            NTC2CFileTransferMgr.this.v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
        public void onResult(final int i3, final String str, HashMap<Long, Integer> hashMap) {
            if (i3 != 0) {
                Handler handler = new Handler(Looper.getMainLooper());
                final FileManagerEntity fileManagerEntity = this.f208683a;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTC2CFileTransferMgr.d.this.b(fileManagerEntity, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements IForwardOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208685a;

        e(FileManagerEntity fileManagerEntity) {
            this.f208685a = fileManagerEntity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(FileManagerEntity fileManagerEntity, int i3, String str) {
            NTC2CFileTransferMgr.this.v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
        public void onResult(final int i3, final String str, HashMap<Long, Integer> hashMap) {
            if (i3 != 0) {
                Handler handler = new Handler(Looper.getMainLooper());
                final FileManagerEntity fileManagerEntity = this.f208685a;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTC2CFileTransferMgr.e.this.b(fileManagerEntity, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        int f208687a = 13;

        /* renamed from: b, reason: collision with root package name */
        String f208688b = "";

        /* renamed from: c, reason: collision with root package name */
        String f208689c = "";

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        boolean f208691a = true;

        /* renamed from: b, reason: collision with root package name */
        long f208692b = 0;

        /* renamed from: c, reason: collision with root package name */
        FileManagerEntity f208693c;

        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h {

        /* renamed from: b, reason: collision with root package name */
        FileManagerEntity f208696b;

        /* renamed from: d, reason: collision with root package name */
        NTFileManageBridger.g f208698d;

        /* renamed from: a, reason: collision with root package name */
        boolean f208695a = true;

        /* renamed from: c, reason: collision with root package name */
        int f208697c = 0;

        h() {
        }
    }

    public NTC2CFileTransferMgr(QQAppInterface qQAppInterface) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f208670e = hashMap;
        this.f208666a = qQAppInterface;
        hashMap.put(0, "UploadLocalFile");
        this.f208670e.put(1, "ForwardWeiyunFile");
        this.f208670e.put(2, "ForwardFavFile");
        this.f208670e.put(3, "ForwardFileFromOffline");
        this.f208670e.put(4, "ForwardFileFromTroop");
    }

    private g B0(long j3) {
        g gVar = this.f208668c.get(Long.valueOf(j3));
        if (gVar != null) {
            this.f208668c.remove(Long.valueOf(j3));
            QLog.i("NTC2CFileTransferMgr", 1, "takeOutDownloadTaskContext. dwnTaskId:" + j3 + " cSize:" + this.f208668c.size());
        }
        return gVar;
    }

    private FileManagerEntity E(String str, List<FileManagerEntity> list) {
        String str2;
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (FileManagerEntity fileManagerEntity : list) {
                if (fileManagerEntity != null && (str2 = fileManagerEntity.Uuid) != null && str2.replace("/offline", "").equalsIgnoreCase(str.replace("/offline", ""))) {
                    QLog.i("NTC2CFileTransferMgr", 1, "uuid is compare memory!");
                    return fileManagerEntity;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface J() {
        if (this.f208666a == null) {
            this.f208666a = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return this.f208666a;
    }

    private g K(long j3) {
        return this.f208668c.get(Long.valueOf(j3));
    }

    private f L(long j3, String str, long j16, String str2) {
        f fVar = new f();
        fVar.f208689c = str2;
        if (str2.isEmpty()) {
            fVar.f208689c = "\u4f20\u8f93\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
        }
        int i3 = (int) j16;
        fVar.f208687a = i3;
        if (i3 == 0) {
            fVar.f208687a = (int) j3;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            fVar.f208687a = 2;
            fVar.f208689c = "";
        }
        fVar.f208688b = str;
        return fVar;
    }

    private long M(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.ntChatType == 8) {
            return fileManagerEntity.uniseq;
        }
        return fileManagerEntity.nSessionId;
    }

    private long N(FileTransNotifyInfo fileTransNotifyInfo) {
        Integer num = fileTransNotifyInfo.chatType;
        if (num != null && num.intValue() == 8) {
            return fileTransNotifyInfo.msgElementId;
        }
        return fileTransNotifyInfo.fileModelId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String R(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return "";
        }
        return " ntMId:" + fileManagerEntity.ntMsgId + " ntEId/uniseq:" + fileManagerEntity.uniseq + " sId:" + fileManagerEntity.nSessionId + " peer:" + fileManagerEntity.peerUid + "/" + fileManagerEntity.peerUin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(FileManagerEntity fileManagerEntity, int i3, String str) {
        v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.p
                @Override // java.lang.Runnable
                public final void run() {
                    NTC2CFileTransferMgr.this.S(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit U(FileManagerEntity fileManagerEntity, TargetFileInfo targetFileInfo, Contact contact, FileManagerEntity fileManagerEntity2, Pair pair) {
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        Contact contact2 = new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromTroop sub msg, ids: " + Arrays.toString((long[]) pair.getFirst()) + ", sub msg id : " + targetFileInfo.targetMsgId + ", src: " + contact2 + ", dst: " + contact);
        com.tencent.mobileqq.filebrowser.toogle.a.a((long[]) pair.getFirst(), (long[]) pair.getSecond(), contact2, new ArrayList(Arrays.asList(contact)), new e(fileManagerEntity2));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(FileManagerEntity fileManagerEntity, int i3, String str) {
        v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.c
                @Override // java.lang.Runnable
                public final void run() {
                    NTC2CFileTransferMgr.this.V(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit X(TargetFileInfo targetFileInfo, Contact contact, final FileManagerEntity fileManagerEntity) {
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(targetFileInfo, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NTC2CFileTransferMgr.this.W(fileManagerEntity, i3, str);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(FileManagerEntity fileManagerEntity, int i3, String str) {
        v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.q
                @Override // java.lang.Runnable
                public final void run() {
                    NTC2CFileTransferMgr.this.Y(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a0(TargetFileInfo targetFileInfo, Contact contact, FileManagerEntity fileManagerEntity, Pair pair) {
        CommonFileInfo commonFileInfo = targetFileInfo.commonFileInfo;
        Contact contact2 = new Contact(commonFileInfo.chatType, commonFileInfo.peerUid, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardOffToOffForwardEntity sub msg, ids: " + Arrays.toString((long[]) pair.getFirst()) + ", sub msg id : " + targetFileInfo.targetMsgId + ", src: " + contact2 + ", dst: " + contact);
        com.tencent.mobileqq.filebrowser.toogle.a.a((long[]) pair.getFirst(), (long[]) pair.getSecond(), contact2, new ArrayList(Arrays.asList(contact)), new d(fileManagerEntity));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(FileManagerEntity fileManagerEntity, int i3, String str) {
        v0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.d
                @Override // java.lang.Runnable
                public final void run() {
                    NTC2CFileTransferMgr.this.b0(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d0(TargetFileInfo targetFileInfo, Contact contact, final FileManagerEntity fileManagerEntity) {
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(targetFileInfo, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NTC2CFileTransferMgr.this.c0(fileManagerEntity, i3, str);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(FileManagerEntity fileManagerEntity, String str, boolean z16) {
        int i3 = fileManagerEntity.nFileType;
        if (i3 == 0) {
            fileManagerEntity.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(str));
            if (fileManagerEntity.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                fileManagerEntity.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(str));
            }
            FilePicURLDrawlableHelper.e(fileManagerEntity);
            FilePicURLDrawlableHelper.k(fileManagerEntity);
            FilePicURLDrawlableHelper.d(fileManagerEntity);
        } else if (i3 == 2) {
            FileManagerUtil.createMediThumbnail(fileManagerEntity);
        }
        FileManagerUtil.fixEntityThumbSize(fileManagerEntity);
        if (z16) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "isMyComputer onDownloadSucHandleFileManagerEntity " + fileManagerEntity);
            J().getFileManagerDataCenter().t(fileManagerEntity);
        } else {
            J().getFileManagerDataCenter().f0(fileManagerEntity);
        }
        J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 11, new Object[]{str, "", Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, "", ""}, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(FileManagerEntity fileManagerEntity, int i3, String str) {
        QLog.d("NTC2CFileTransferMgr", 1, "reSendFileToNt result:" + i3 + " errMsg:" + str + R(fileManagerEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(FileManagerEntity fileManagerEntity, int i3, String str) {
        QLog.d("NTC2CFileTransferMgr", 1, "sendLocalFileToNt result:" + i3 + " errMsg:" + str + R(fileManagerEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h0(Contact contact, final FileManagerEntity fileManagerEntity, ArrayList arrayList) {
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, fileManagerEntity.ntMsgId, (ArrayList<MsgElement>) arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NTC2CFileTransferMgr.this.g0(fileManagerEntity, i3, str);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(FileManagerEntity fileManagerEntity, int i3, String str) {
        QLog.d("NTC2CFileTransferMgr", 1, "sendLocalFileToNt result:" + i3 + " errMsg:" + str + R(fileManagerEntity));
    }

    private FileManagerEntity j0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, int i16) {
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        long g16 = NTFileUtils.g(l3);
        long g17 = NTFileUtils.g(l3);
        fileManagerEntity2.uniseq = g17;
        fileManagerEntity2.ntMsgId = g16;
        com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity2, g17, l3);
        fileManagerEntity2.peerUin = str2;
        fileManagerEntity2.peerUid = str3;
        fileManagerEntity2.peerNick = FileManagerUtil.getPeerNick(this.f208666a, str2, null, i3);
        fileManagerEntity2.peerType = i3;
        fileManagerEntity2.selfUin = J().getAccount();
        fileManagerEntity2.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity2.status = 2;
        fileManagerEntity2.msgSeq = FileManagerUtil.genMsgSeq();
        fileManagerEntity2.msgUid = FileManagerUtil.genMsgUid();
        fileManagerEntity2.ntChatType = l3;
        fileManagerEntity2.strThumbPath = fileManagerEntity.strThumbPath;
        if (i16 != 0) {
            com.tencent.mobileqq.activity.aio.forward.b.d().e(fileManagerEntity2.uniseq, fileManagerEntity.uniseq, i16);
        }
        String account = J().getAccount();
        if (str != null && !str.isEmpty()) {
            if (i3 != 1004 && i3 != 1000) {
                if (i3 == 1006) {
                    fileManagerEntity2.tmpSessionFromPhone = str;
                    fileManagerEntity2.tmpSessionToPhone = str2;
                }
            }
            FileManagerUtil.setTempParam(this.f208666a, str, str2, fileManagerEntity2);
            return fileManagerEntity2;
        }
        str = account;
        FileManagerUtil.setTempParam(this.f208666a, str, str2, fileManagerEntity2);
        return fileManagerEntity2;
    }

    private void l0(FileTransNotifyInfo fileTransNotifyInfo, long j3, long j16, long j17) {
        g B0 = B0(N(fileTransNotifyInfo));
        if (B0 == null) {
            return;
        }
        FileManagerEntity fileManagerEntity = B0.f208693c;
        QLog.i("NTC2CFileTransferMgr", 1, "onNTDownloadCancel" + R(fileManagerEntity));
        fileManagerEntity.status = 3;
        J().getFileManagerDataCenter().f0(fileManagerEntity);
        J().getFileManagerNotifyCenter().b(true, 3, null);
    }

    private void n0(FileTransNotifyInfo fileTransNotifyInfo, long j3, long j16, long j17, long j18, String str, long j19, String str2) {
        g B0 = B0(N(fileTransNotifyInfo));
        if (B0 == null) {
            return;
        }
        FileManagerEntity fileManagerEntity = B0.f208693c;
        if (fileManagerEntity.status != 16) {
            fileManagerEntity.status = 0;
        }
        f L = L(j18, str, j19, str2);
        QLog.e("NTC2CFileTransferMgr", 1, "onNTDownloadFail" + R(fileManagerEntity) + " errCode:" + j18 + " errMsg:" + str + " fileError:" + L.f208687a + " errClientTipWording:" + L.f208689c);
        J().getFileManagerDataCenter().f0(fileManagerEntity);
        J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 6, L.f208689c);
    }

    private void o0(FileTransNotifyInfo fileTransNotifyInfo) {
        boolean z16;
        FileManagerEntity fileManagerEntity;
        MsgRecord msgRecord;
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onDownloadSuc fileModelId " + fileTransNotifyInfo.getFileModelId());
        g B0 = B0(N(fileTransNotifyInfo));
        if (fileTransNotifyInfo.getChatType() != null && fileTransNotifyInfo.getChatType().intValue() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (fileTransNotifyInfo.msgRecord != null) {
            fileManagerEntity = J().getFileManagerDataCenter().E(fileTransNotifyInfo.msgElementId, DataLineNTMsgMigrationUtil.d(fileTransNotifyInfo.msgRecord.peerUid), DataLineNTMsgMigrationUtil.i(fileTransNotifyInfo.msgRecord.peerUid));
        } else {
            fileManagerEntity = null;
        }
        int fileType = FileManagerUtil.getFileType(fileTransNotifyInfo.filePath);
        if ((fileType == 0 || fileType == 2) && z16 && (msgRecord = fileTransNotifyInfo.msgRecord) != null && msgRecord.sendType == 0) {
            z0(fileTransNotifyInfo);
        }
        if (z16) {
            q0(fileTransNotifyInfo, fileManagerEntity);
            return;
        }
        if (B0 != null) {
            fileManagerEntity = B0.f208693c;
        }
        if (fileManagerEntity == null) {
            return;
        }
        QLog.i("NTC2CFileTransferMgr", 1, "onNTDownloadSuc." + R(fileManagerEntity) + "filePath:" + fileTransNotifyInfo.getFilePath() + ", code: " + fileManagerEntity.hashCode() + " ,entity: " + fileManagerEntity);
        p0(fileTransNotifyInfo, fileManagerEntity, z16);
    }

    private void p0(FileTransNotifyInfo fileTransNotifyInfo, final FileManagerEntity fileManagerEntity, final boolean z16) {
        final String filePath = fileTransNotifyInfo.getFilePath();
        NTFileUtils.G(filePath);
        FileManagerUtil.getFileSizes(filePath);
        fileManagerEntity.fileName = FileManagerUtil.getFileName(filePath);
        int length = 250 - (filePath.length() - fileManagerEntity.fileName.length());
        if (fileManagerEntity.fileName.getBytes().length > length) {
            fileManagerEntity.fileName = FileManagerUtil.cutLongLongFileName(fileManagerEntity.fileName, length);
        }
        fileManagerEntity.setFilePath(filePath);
        String fileName = FileManagerUtil.getFileName(filePath);
        fileManagerEntity.fileName = fileName;
        fileManagerEntity.nFileType = FileManagerUtil.getFileType(fileName);
        fileManagerEntity.localModifyTime = new VFSFile(filePath).lastModified();
        fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
        fileManagerEntity.status = 1;
        fileManagerEntity.fProgress = 1.0f;
        fileManagerEntity.setCloudType(3);
        int i3 = fileManagerEntity.nFileType;
        if (i3 != 0 && i3 != 2) {
            if (z16) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "isMyComputer onDownloadSucHandleFileManagerEntity " + fileManagerEntity);
                J().getFileManagerDataCenter().t(fileManagerEntity);
            } else {
                J().getFileManagerDataCenter().f0(fileManagerEntity);
            }
            J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 11, new Object[]{filePath, "", Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, "", ""}, 0, null);
            if (fileManagerEntity.nFileType == 5) {
                J().getFileManagerEngine().Q().l(fileManagerEntity);
            }
            return;
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.h
            @Override // java.lang.Runnable
            public final void run() {
                NTC2CFileTransferMgr.this.e0(fileManagerEntity, filePath, z16);
            }
        });
    }

    private void q0(FileTransNotifyInfo fileTransNotifyInfo, FileManagerEntity fileManagerEntity) {
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onMyComputerDownloadSuc notifyInfo" + fileTransNotifyInfo);
        if (fileManagerEntity == null) {
            fileManagerEntity = NTFileUtils.i(this.f208666a, null, fileTransNotifyInfo.getMsgRecord(), fileTransNotifyInfo.getMsgElementId());
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "create a new entity " + fileManagerEntity);
        }
        Map.Entry<String, Integer> next = com.tencent.qqnt.mycomputer.utils.c.f359781a.i(fileTransNotifyInfo.getMsgRecord().getPeerUid()).entrySet().iterator().next();
        fileManagerEntity.peerUin = next.getKey();
        int intValue = next.getValue().intValue();
        fileManagerEntity.peerType = intValue;
        fileManagerEntity.peerNick = com.tencent.mobileqq.filemanager.util.ah.z0(this.f208666a, fileManagerEntity.peerUin, null, intValue);
        fileManagerEntity.status = 1;
        QLog.i(AppConstants.NEW_MY_COMPUTER, 1, "onMyComputerDownloadSuc." + fileManagerEntity.toString() + "filePath:" + fileTransNotifyInfo.getFilePath());
        p0(fileTransNotifyInfo, fileManagerEntity, true);
    }

    private void t0(long j3, long j16) {
        h hVar = this.f208667b.get(Long.valueOf(j16));
        if (hVar != null && !hVar.f208695a) {
            hVar.f208695a = true;
            FileManagerEntity fileManagerEntity = hVar.f208696b;
            this.f208667b.remove(Long.valueOf(j16));
            QLog.i("NTC2CFileTransferMgr", 1, "onNTUploadCancel" + R(fileManagerEntity));
            fileManagerEntity.status = 3;
            J().getFileManagerDataCenter().f0(fileManagerEntity);
            J().getFileManagerNotifyCenter().b(true, 3, null);
            NTFileManageBridger.g gVar = hVar.f208698d;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    private long u(FileManagerEntity fileManagerEntity) {
        long j3;
        int i3 = fileManagerEntity.peerType;
        if (i3 != 6000 && i3 != 6003 && i3 != 6005) {
            j3 = fileManagerEntity.nSessionId;
        } else {
            j3 = fileManagerEntity.uniseq;
        }
        g gVar = new g();
        gVar.f208693c = fileManagerEntity;
        gVar.f208692b = j3;
        this.f208668c.put(Long.valueOf(j3), gVar);
        QLog.i("NTC2CFileTransferMgr", 1, "addDownloadTaskContext. dwnTaskId:" + j3 + R(fileManagerEntity) + " cSize:" + this.f208668c.size());
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(long j3, long j16, long j17, String str, long j18, String str2) {
        h hVar = this.f208667b.get(Long.valueOf(j16));
        if (hVar != null && !hVar.f208695a) {
            hVar.f208695a = true;
            FileManagerEntity fileManagerEntity = hVar.f208696b;
            this.f208667b.remove(Long.valueOf(j16));
            String str3 = this.f208670e.get(Integer.valueOf(hVar.f208697c));
            if (TextUtils.isEmpty(str3)) {
                str3 = "Unknow";
            }
            String str4 = str3;
            f L = L(j17, str, j18, str2);
            QLog.e("NTC2CFileTransferMgr", 1, "on" + str4 + "Fail" + R(fileManagerEntity) + " errCode:" + j17 + " errMsg:" + str + " fileError:" + L.f208687a + " errClientTipWording:" + L.f208689c);
            fileManagerEntity.status = 0;
            int i3 = hVar.f208697c;
            if (i3 == 1) {
                fileManagerEntity.isReaded = false;
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, L.f208687a, L.f208689c);
                J().getFileManagerNotifyCenter().b(false, 33, new Object[]{Integer.valueOf(L.f208687a), L.f208689c, Long.valueOf(fileManagerEntity.nSessionId)});
                return;
            }
            if (i3 == 2) {
                fileManagerEntity.isReaded = false;
                fileManagerEntity.status = 1005;
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, L.f208687a, L.f208689c);
                return;
            }
            if (i3 == 3) {
                fileManagerEntity.isReaded = false;
                fileManagerEntity.status = 0;
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, L.f208687a, L.f208689c);
                return;
            }
            if (i3 == 4) {
                fileManagerEntity.isReaded = false;
                fileManagerEntity.status = 0;
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, L.f208687a, L.f208689c);
                J().getFileManagerNotifyCenter().b(false, 46, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), Integer.valueOf(L.f208687a), L.f208689c});
                return;
            }
            J().getFileManagerDataCenter().f0(fileManagerEntity);
            J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, L.f208687a, L.f208689c);
            NTFileManageBridger.g gVar = hVar.f208698d;
            if (gVar != null) {
                gVar.b((int) j17, str);
            }
        }
    }

    private void w0(FileTransNotifyInfo fileTransNotifyInfo) {
        h hVar = this.f208667b.get(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
        if (hVar != null && !hVar.f208695a) {
            if (fileTransNotifyInfo.getChatType() != null && fileTransNotifyInfo.getChatType().intValue() != 8 && (fileTransNotifyInfo.getFileId() == null || fileTransNotifyInfo.getFileId().isEmpty())) {
                QLog.w("NTC2CFileTransferMgr", 1, "onNTUploadSuc. but no fileId, ntMsgId:" + fileTransNotifyInfo.getMsgId() + " ntElemId:" + fileTransNotifyInfo.getMsgElementId());
                v0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), -2L, "suc but file id is null", 0L, "");
                return;
            }
            hVar.f208695a = true;
            FileManagerEntity fileManagerEntity = hVar.f208696b;
            this.f208667b.remove(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
            String str = this.f208670e.get(Integer.valueOf(hVar.f208697c));
            if (TextUtils.isEmpty(str)) {
                str = "Unknow";
            }
            QLog.i("NTC2CFileTransferMgr", 1, "on" + str + "Suc." + R(fileManagerEntity) + "uuid:" + fileTransNotifyInfo.getFileId() + " subId:" + fileManagerEntity.fileIdCrc);
            fileManagerEntity.bSend = true;
            fileManagerEntity.status = 1;
            fileManagerEntity.fProgress = 1.0f;
            if (fileTransNotifyInfo.getFileId() != null && !fileTransNotifyInfo.getFileId().isEmpty()) {
                fileManagerEntity.Uuid = fileTransNotifyInfo.getFileId();
            }
            if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getMd510m() != null && !fileTransNotifyInfo.getCommonFileInfo().getMd510m().isEmpty()) {
                fileManagerEntity.str10Md5 = fileTransNotifyInfo.getCommonFileInfo().getMd510m();
            }
            if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getMd5() != null && !fileTransNotifyInfo.getCommonFileInfo().getMd5().isEmpty()) {
                fileManagerEntity.strFileMd5 = fileTransNotifyInfo.getCommonFileInfo().getMd5();
            }
            if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getSha() != null && !fileTransNotifyInfo.getCommonFileInfo().getSha().isEmpty()) {
                fileManagerEntity.strFileSHA = fileTransNotifyInfo.getCommonFileInfo().getSha();
            }
            if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getSha3() != null && !fileTransNotifyInfo.getCommonFileInfo().getSha3().isEmpty()) {
                fileManagerEntity.strFileSha3 = fileTransNotifyInfo.getCommonFileInfo().getSha3();
            }
            if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getSubId() != null && !fileTransNotifyInfo.getCommonFileInfo().getSubId().isEmpty()) {
                fileManagerEntity.fileIdCrc = fileTransNotifyInfo.getCommonFileInfo().getSubId();
            }
            int i3 = hVar.f208697c;
            if (i3 == 1) {
                fileManagerEntity.setCloudType(1);
                fileManagerEntity.isReaded = false;
                fileManagerEntity.fProgress = 0.0f;
                fileManagerEntity.bOnceSuccess = true;
                fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                J().getFileManagerDataCenter().c0();
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerNotifyCenter().b(true, 33, new Object[]{fileManagerEntity.Uuid});
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 14, new Object[]{fileManagerEntity.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                J().getFileManagerNotifyCenter().b(true, 3, null);
                FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                J().getFileManagerEngine().n(fileManagerEntity, 7);
                return;
            }
            if (i3 == 2) {
                fileManagerEntity.setCloudType(1);
                fileManagerEntity.isReaded = false;
                fileManagerEntity.fProgress = 0.0f;
                fileManagerEntity.bOnceSuccess = true;
                fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().b(true, 53, new Object[]{fileManagerEntity.Uuid});
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 14, new Object[]{fileManagerEntity.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                J().getFileManagerNotifyCenter().b(true, 3, null);
                FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                J().getFileManagerEngine().n(fileManagerEntity, 7);
                return;
            }
            if (i3 == 3) {
                fileManagerEntity.isReaded = false;
                fileManagerEntity.fProgress = 0.0f;
                fileManagerEntity.setCloudType(1);
                fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                QLog.i("NTC2CFileTransferMgr", 1, "update entity: " + fileManagerEntity.hashCode());
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 14, new Object[]{fileManagerEntity.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                J().getFileManagerEngine().n(fileManagerEntity, 7);
                return;
            }
            if (i3 == 4) {
                fileManagerEntity.isReaded = false;
                fileManagerEntity.fProgress = 0.0f;
                fileManagerEntity.TroopUin = 0L;
                fileManagerEntity.strTroopFileID = null;
                fileManagerEntity.strTroopFilePath = null;
                fileManagerEntity.setCloudType(1);
                fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                J().getFileManagerDataCenter().f0(fileManagerEntity);
                J().getFileManagerDataCenter().c0();
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 14, new Object[]{fileManagerEntity.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                J().getFileManagerNotifyCenter().b(true, 46, new Object[]{Long.valueOf(fileManagerEntity.nSessionId), 0, ""});
                FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                J().getFileManagerEngine().n(fileManagerEntity, 7);
                return;
            }
            QLog.d("NTC2CFileTransferMgr", 1, "onUploadSuc context.sendType is " + hVar.f208697c + "Suc." + R(fileManagerEntity) + "uuid:" + fileTransNotifyInfo.getFileId());
            J().getFileManagerDataCenter().f0(fileManagerEntity);
            J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 14, new Object[]{fileManagerEntity.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, ""}, 0, null);
            NTFileManageBridger.g gVar = hVar.f208698d;
            if (gVar != null) {
                gVar.b(0, "");
            }
        }
    }

    private void z0(final FileTransNotifyInfo fileTransNotifyInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("QQ");
        sb5.append(str);
        File file = new File(sb5.toString(), new File(fileTransNotifyInfo.filePath).getName());
        if (file.exists()) {
            QLog.e("NTC2CFileTransferMgr", 1, "file " + file.getPath() + " exists, do not save again!");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.NTC2CFileTransferMgr.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(com.tencent.mobileqq.filemanager.util.l.a(fileTransNotifyInfo.filePath))) {
                        QLog.e("NTC2CFileTransferMgr", 1, "save " + fileTransNotifyInfo.filePath + " failed!");
                    }
                } catch (Throwable th5) {
                    QLog.e("NTC2CFileTransferMgr", 1, "save " + fileTransNotifyInfo.filePath + " failed!", th5);
                }
            }
        }, 64, null, false);
    }

    public FileManagerEntity A(String str, String str2, int i3, long j3, int i16, String str3, String str4, long j16, int i17, long j17, int i18, com.tencent.mobileqq.troop.data.n nVar) {
        int i19;
        QLog.i("NTC2CFileTransferMgr", 1, "createTroop2OffForward. peerUin:" + str + " peerUid:" + str2 + " srcBuisId:" + i16 + " troopFilePath:" + str3 + " fileName:" + str4 + " fileSize:" + j16);
        String valueOf = String.valueOf(j3);
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        fileManagerEntity.ntChatType = l3;
        long g16 = NTFileUtils.g(l3);
        com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity, g16, l3);
        fileManagerEntity.fileName = str4;
        if (nVar != null && com.tencent.mobileqq.filemanager.util.q.f(nVar.f294939y)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FilePicURLDrawlableHelper.m(nVar.f294939y, options);
            int i26 = options.outHeight;
            if (i26 > 0 && (i19 = options.outWidth) > 0) {
                fileManagerEntity.imgWidth = i19;
                fileManagerEntity.imgHeight = i26;
            }
        }
        long g17 = NTFileUtils.g(l3);
        fileManagerEntity.uniseq = g16;
        fileManagerEntity.ntMsgId = g17;
        if (i3 != 0 && i3 != 6000 && i3 != 6005 && i3 != 6003) {
            if (i3 == 3000) {
                fileManagerEntity.nOpType = 25;
            } else if (QLog.isDevelopLevel()) {
                throw new NullPointerException("\u7fa4\u540c\u4e8b\u4f20\u9012\u7684peerType\u4e0d\u5bf9\uff01");
            }
        } else {
            fileManagerEntity.nOpType = 24;
        }
        fileManagerEntity.bSend = true;
        fileManagerEntity.isReaded = true;
        fileManagerEntity.peerType = i3;
        fileManagerEntity.peerUin = str;
        fileManagerEntity.peerUid = str2;
        fileManagerEntity.peerNick = FileManagerUtil.getPeerNick(this.f208666a, str, null, i3);
        fileManagerEntity.selfUin = valueOf;
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
        fileManagerEntity.forwardTroopFileEntrance = i17;
        com.tencent.mobileqq.troop.data.t H = TroopFileTransferManager.N(j3).H(str3);
        if (H != null) {
            fileManagerEntity.yybApkPackageName = H.B;
            fileManagerEntity.yybApkName = H.C;
            fileManagerEntity.yybApkIconUrl = H.D;
        }
        if (l3 != 8) {
            J().getFileManagerDataCenter().t(fileManagerEntity);
        }
        return fileManagerEntity;
    }

    public void A0(final FileManagerEntity fileManagerEntity, NTFileManageBridger.g gVar) {
        if (fileManagerEntity == null) {
            QLog.i("NTC2CFileTransferMgr", 1, "sendLocalFileToNt entry = null:");
            if (gVar != null) {
                gVar.b(-1, "entry=null");
                return;
            }
            return;
        }
        QLog.i("NTC2CFileTransferMgr", 1, "sendLocalFileToNt strFilePath:" + fileManagerEntity.getFilePath() + " fileSize:" + fileManagerEntity.fileSize + R(fileManagerEntity));
        FileElement fileElement = new FileElement();
        fileElement.setFileName(fileManagerEntity.fileName);
        fileElement.setFilePath(fileManagerEntity.strFilePath);
        fileElement.setFileSize(fileManagerEntity.fileSize);
        fileElement.setPicWidth(Integer.valueOf(fileManagerEntity.imgWidth));
        fileElement.setPicHeight(Integer.valueOf(fileManagerEntity.imgHeight));
        if (fileManagerEntity.isPhotoToMyComputer) {
            fileElement.setSubElementType(1);
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        if (fileManagerEntity.strLargeThumPath != null) {
            hashMap.put(750, fileManagerEntity.strLargeThumPath);
        }
        if (fileManagerEntity.strMiddleThumPath != null) {
            hashMap.put(Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384), fileManagerEntity.strMiddleThumPath);
        }
        if (fileManagerEntity.strThumbPath != null) {
            hashMap.put(128, fileManagerEntity.strThumbPath);
        }
        if (!hashMap.isEmpty()) {
            fileElement.setPicThumbPath(hashMap);
        }
        MsgElement msgElement = new MsgElement();
        msgElement.setElementType(3);
        msgElement.setFileElement(fileElement);
        msgElement.setElementId(fileManagerEntity.uniseq);
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
        final Contact contact = new Contact(l3, fileManagerEntity.peerUid, "");
        final ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(msgElement);
        h hVar = new h();
        hVar.f208695a = false;
        hVar.f208696b = fileManagerEntity;
        hVar.f208698d = gVar;
        this.f208667b.put(Long.valueOf(fileManagerEntity.uniseq), hVar);
        if (l3 == 1 && com.tencent.mobileqq.troop.utils.k.l(MobileQQ.sMobileQQ.peekAppRuntime(), fileManagerEntity.peerUin)) {
            ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).checkAndAddFriend(fileManagerEntity.peerUid, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit h06;
                    h06 = NTC2CFileTransferMgr.this.h0(contact, fileManagerEntity, arrayList);
                    return h06;
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, fileManagerEntity.ntMsgId, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTC2CFileTransferMgr.this.i0(fileManagerEntity, i3, str);
                }
            });
        }
    }

    public void B() {
        this.f208666a = null;
    }

    public void C(Activity activity, FileManagerEntity fileManagerEntity, String str, NTFileManageBridger.f fVar) {
        if (fileManagerEntity == null) {
            QLog.e("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg err. getFileEntityOfNTMsg fail:entity = null");
            if (fVar != null) {
                fVar.onResult(-2, "entity = null");
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.filemanager.util.q.f(fileManagerEntity.getFilePath())) {
            QLog.w("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg suc directly. local file existed");
            fileManagerEntity.status = 1;
            fileManagerEntity.cloudType = 3;
            J().getFileManagerDataCenter().f0(fileManagerEntity);
            J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 11, new Object[]{fileManagerEntity.getFilePath(), "", Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, "", ""}, 0, null);
            J().getFileManagerNotifyCenter().b(true, 3, null);
            if (fVar != null) {
                fVar.onResult(1, "local file existed");
            }
            J().getNTFileManageBridger().M0(fileManagerEntity, 4);
            return;
        }
        QLog.i("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg." + R(fileManagerEntity));
        if (activity != null) {
            kc1.a.c(fileManagerEntity).d(false, activity, new c(fileManagerEntity, fVar));
            return;
        }
        int i3 = fileManagerEntity.status;
        if (i3 != 3 && i3 != 0) {
            QLog.i("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg. recv sid:" + fileManagerEntity.nSessionId);
            J().getFileManagerEngine().t0(fileManagerEntity);
        } else {
            QLog.i("NTC2CFileTransferMgr", 1, "downloadAioNTFileMsg. resume sid:" + fileManagerEntity.nSessionId);
            J().getFileManagerEngine().o0(fileManagerEntity.nSessionId);
        }
        if (fVar != null) {
            fVar.onResult(0, "");
        }
    }

    public void D(FileManagerEntity... fileManagerEntityArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ArrayList<CommonFileInfo> arrayList = new ArrayList<>();
        for (FileManagerEntity fileManagerEntity : fileManagerEntityArr) {
            if (fileManagerEntity != null && fileManagerEntity.Uuid != null) {
                if (TextUtils.isEmpty(fileManagerEntity.peerUid)) {
                    fileManagerEntity.peerUid = FileManagerUtil.checkAndGetUid(fileManagerEntity.peerUid, fileManagerEntity.peerUin, "downloadNTFile");
                }
                com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
                long u16 = u(fileManagerEntity);
                QLog.i("NTC2CFileTransferMgr", 1, "downloadNTFile strFileName:" + fileManagerEntity.fileName + " fileSize:" + fileManagerEntity.fileSize + R(fileManagerEntity) + " dwnTaskId:" + u16 + " ,code: " + fileManagerEntity.hashCode());
                String str6 = fileManagerEntity.fileIdCrc;
                if (str6 == null) {
                    str = "";
                } else {
                    str = str6;
                }
                String str7 = fileManagerEntity.strFileMd5;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                String str8 = fileManagerEntity.str10Md5;
                if (str8 == null) {
                    str3 = "";
                } else {
                    str3 = str8;
                }
                String str9 = fileManagerEntity.strFileSHA;
                if (str9 == null) {
                    str4 = "";
                } else {
                    str4 = str9;
                }
                String str10 = fileManagerEntity.strFileSha3;
                if (str10 == null) {
                    str5 = "";
                } else {
                    str5 = str10;
                }
                long j3 = fileManagerEntity.msgTime / 1000;
                if (j3 == 0) {
                    j3 = com.tencent.mobileqq.service.message.e.K0();
                }
                arrayList.add(new CommonFileInfo(u16, fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, fileManagerEntity.Uuid, str, fileManagerEntity.fileName, fileManagerEntity.fileSize, j3, fileManagerEntity.peerUid, l3, str2, str3, str4, str5, "", "", 0, new HashMap()));
                if (fileManagerEntity.status != 2) {
                    fileManagerEntity.status = 2;
                }
                J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
            } else {
                QLog.e("NTC2CFileTransferMgr", 1, "downloadNTFile entity/entity.Uuid is null");
            }
        }
        ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadFileForFileInfo(arrayList, "");
    }

    public void F(FileManagerEntity fileManagerEntity, String str, String str2, int i3, int i16) {
        if (fileManagerEntity == null) {
            QLog.e("NTC2CFileTransferMgr", 1, "forwardFileFromFav favEntity is null");
            return;
        }
        if (TextUtils.isEmpty(fileManagerEntity.strFavFileId)) {
            QLog.e("NTC2CFileTransferMgr", 1, "forwardFileFromFav strFavFileId is Empty!");
            return;
        }
        String checkAndGetUid = FileManagerUtil.checkAndGetUid(str2, str, "forwardFileFromFav");
        if (TextUtils.isEmpty(checkAndGetUid)) {
            return;
        }
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        final FileManagerEntity j06 = j0(fileManagerEntity, "", str, checkAndGetUid, i3, i16);
        j06.setCloudType(10);
        j06.nOpType = 37;
        j06.strThumbPath = fileManagerEntity.strThumbPath;
        j06.strMiddleThumPath = fileManagerEntity.strMiddleThumPath;
        if (l3 != 8) {
            this.f208666a.getFileManagerDataCenter().t(j06);
        }
        FileManagerUtil.addCloseButtonSessionId(j06.nSessionId);
        h hVar = new h();
        hVar.f208695a = false;
        hVar.f208697c = 2;
        hVar.f208696b = j06;
        this.f208667b.put(Long.valueOf(j06.uniseq), hVar);
        TargetFileInfo u16 = NTFileUtils.u(fileManagerEntity, j06, 41);
        Contact contact = new Contact(l3, str2, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromFav. src->" + R(fileManagerEntity) + " to->" + R(j06) + " filename:" + fileManagerEntity.fileName + " wyId:" + u16.getCommonFileInfo().getUuid());
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(u16, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.l
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i17, String str3) {
                NTC2CFileTransferMgr.this.T(j06, i17, str3);
            }
        });
    }

    public boolean G(final FileManagerEntity fileManagerEntity, long j3, long j16, String str, int i3, int i16, long j17, int i17) {
        int i18;
        QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromTroop." + R(fileManagerEntity) + " toUin:" + j16 + " toUid:" + str);
        String checkAndGetUid = FileManagerUtil.checkAndGetUid(str, String.valueOf(j16), "forwardFileFromTroop");
        if (TextUtils.isEmpty(checkAndGetUid)) {
            return false;
        }
        TroopFileManager F = TroopFileManager.F(this.f208666a, j3);
        if (F == null) {
            QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromTroop. err. troop mgr=null");
            return false;
        }
        int i19 = fileManagerEntity.busId;
        if (i19 != 102 && i19 != 104) {
            com.tencent.mobileqq.troop.data.n A = F.A(fileManagerEntity.strTroopFilePath);
            if (A != null) {
                i19 = A.f294919e;
            } else {
                QLog.w("NTC2CFileTransferMgr", 1, "forwardFileFromTroop. biz id err. force use 102");
                i18 = 102;
                Bundle bundle = new Bundle();
                bundle.putLong("TRANS_PARAM_NT_MSGID", fileManagerEntity.ntMsgId);
                bundle.putLong("TRANS_PARAM_NT_ELEMENTID", fileManagerEntity.uniseq);
                bundle.putLong("TRANS_PARAM_UPLOAD_TIME", fileManagerEntity.srvTime / 1000);
                F.e(fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, i18, bundle);
                int i26 = i18;
                final FileManagerEntity A2 = A(String.valueOf(j16), checkAndGetUid, i3, j3, i18, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, i16, j17, i17, F.A(fileManagerEntity.strTroopFilePath));
                h hVar = new h();
                hVar.f208695a = false;
                hVar.f208697c = 4;
                hVar.f208696b = A2;
                this.f208667b.put(Long.valueOf(A2.uniseq), hVar);
                final TargetFileInfo x16 = NTFileUtils.x(fileManagerEntity, A2, i26);
                com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                final Contact contact = new Contact(com.tencent.nt.adapter.session.c.l(A2.peerType), A2.peerUid, "");
                QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromTroop." + R(A2) + " filename:" + A2.fileName + " srcBusId:" + i26 + " srcEntity.busId:" + fileManagerEntity.busId);
                com.tencent.mobileqq.filebrowser.toogle.a.b(new Function1() { // from class: com.tencent.mobileqq.filemanager.nt.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit U;
                        U = NTC2CFileTransferMgr.this.U(fileManagerEntity, x16, contact, A2, (Pair) obj);
                        return U;
                    }
                }, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit X;
                        X = NTC2CFileTransferMgr.this.X(x16, contact, A2);
                        return X;
                    }
                });
                return true;
            }
        }
        i18 = i19;
        Bundle bundle2 = new Bundle();
        bundle2.putLong("TRANS_PARAM_NT_MSGID", fileManagerEntity.ntMsgId);
        bundle2.putLong("TRANS_PARAM_NT_ELEMENTID", fileManagerEntity.uniseq);
        bundle2.putLong("TRANS_PARAM_UPLOAD_TIME", fileManagerEntity.srvTime / 1000);
        F.e(fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, i18, bundle2);
        int i262 = i18;
        final FileManagerEntity A22 = A(String.valueOf(j16), checkAndGetUid, i3, j3, i18, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, i16, j17, i17, F.A(fileManagerEntity.strTroopFilePath));
        h hVar2 = new h();
        hVar2.f208695a = false;
        hVar2.f208697c = 4;
        hVar2.f208696b = A22;
        this.f208667b.put(Long.valueOf(A22.uniseq), hVar2);
        final TargetFileInfo x162 = NTFileUtils.x(fileManagerEntity, A22, i262);
        com.tencent.nt.adapter.session.c cVar2 = com.tencent.nt.adapter.session.c.f339128a;
        final Contact contact2 = new Contact(com.tencent.nt.adapter.session.c.l(A22.peerType), A22.peerUid, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromTroop." + R(A22) + " filename:" + A22.fileName + " srcBusId:" + i262 + " srcEntity.busId:" + fileManagerEntity.busId);
        com.tencent.mobileqq.filebrowser.toogle.a.b(new Function1() { // from class: com.tencent.mobileqq.filemanager.nt.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U;
                U = NTC2CFileTransferMgr.this.U(fileManagerEntity, x162, contact2, A22, (Pair) obj);
                return U;
            }
        }, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit X;
                X = NTC2CFileTransferMgr.this.X(x162, contact2, A22);
                return X;
            }
        });
        return true;
    }

    public void H(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, int i16) {
        if (fileManagerEntity == null) {
            QLog.e("NTC2CFileTransferMgr", 1, "forwardFileFromWeiYun wyEntity is null");
            return;
        }
        if (TextUtils.isEmpty(fileManagerEntity.WeiYunFileId)) {
            QLog.e("NTC2CFileTransferMgr", 1, "forwardFileFromWeiYun WeiYunFileId is null");
            return;
        }
        String checkAndGetUid = FileManagerUtil.checkAndGetUid(str3, str2, "forwardFileFromWeiYun");
        if (TextUtils.isEmpty(checkAndGetUid)) {
            return;
        }
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        final FileManagerEntity j06 = j0(fileManagerEntity, str, str2, checkAndGetUid, i3, i16);
        j06.setCloudType(2);
        j06.nOpType = 3;
        if (l3 != 8) {
            this.f208666a.getFileManagerDataCenter().t(j06);
        }
        FileManagerUtil.addCloseButtonSessionId(j06.nSessionId);
        h hVar = new h();
        hVar.f208695a = false;
        hVar.f208697c = 1;
        hVar.f208696b = j06;
        this.f208667b.put(Long.valueOf(j06.uniseq), hVar);
        TargetFileInfo z16 = NTFileUtils.z(fileManagerEntity, j06, 40);
        Contact contact = new Contact(l3, str3, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardFileFromWeiYun. src->" + R(fileManagerEntity) + " to->" + R(j06) + " filename:" + fileManagerEntity.fileName + " wyId:" + z16.getCommonFileInfo().getUuid());
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(z16, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i17, String str4) {
                NTC2CFileTransferMgr.this.Z(j06, i17, str4);
            }
        });
    }

    public void I(final FileManagerEntity fileManagerEntity) {
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = 0.0f;
        h hVar = new h();
        hVar.f208695a = false;
        hVar.f208697c = 3;
        hVar.f208696b = fileManagerEntity;
        this.f208667b.put(Long.valueOf(fileManagerEntity.uniseq), hVar);
        final TargetFileInfo v3 = NTFileUtils.v(fileManagerEntity);
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        final Contact contact = new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, "");
        QLog.i("NTC2CFileTransferMgr", 1, "forwardOffToOffForwardEntity." + R(fileManagerEntity) + " filename:" + fileManagerEntity.fileName);
        com.tencent.mobileqq.filebrowser.toogle.a.b(new Function1() { // from class: com.tencent.mobileqq.filemanager.nt.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a06;
                a06 = NTC2CFileTransferMgr.this.a0(v3, contact, fileManagerEntity, (Pair) obj);
                return a06;
            }
        }, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d06;
                d06 = NTC2CFileTransferMgr.this.d0(v3, contact, fileManagerEntity);
                return d06;
            }
        });
    }

    public void O(MsgRecord msgRecord) {
        P(msgRecord, false);
    }

    public void P(MsgRecord msgRecord, boolean z16) {
        if (!NTFileUtils.r(msgRecord) && !z16) {
            return;
        }
        QQAppInterface qQAppInterface = this.f208666a;
        if (qQAppInterface == null) {
            QLog.e("NTC2CFileTransferMgr", 1, "insertNtFileMsgToFMOnRecvMsg err. app = null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (qQAppInterface.getFileManagerProxy() != null) {
            arrayList.addAll(qQAppInterface.getFileManagerProxy().t());
        }
        for (FileManagerEntity fileManagerEntity : NTFileUtils.C(qQAppInterface, null, msgRecord, z16)) {
            FileManagerEntity E = E(fileManagerEntity.Uuid, arrayList);
            if (E != null) {
                if (E.ntMsgId == 0) {
                    E.ntMsgId = fileManagerEntity.ntMsgId;
                    E.uniseq = fileManagerEntity.uniseq;
                    String str = E.peerUin;
                    if (str != null && str == fileManagerEntity.peerUin) {
                        E.peerUid = fileManagerEntity.peerUid;
                    }
                    qQAppInterface.getFileManagerDataCenter().f0(E);
                    qQAppInterface.getFileManagerDataCenter().c0();
                    w(fileManagerEntity);
                }
            } else if (qQAppInterface.getFileManagerDataCenter().E(fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType) == null) {
                if (qQAppInterface.getFileManagerDataCenter() != null) {
                    QLog.i("NTC2CFileTransferMgr", 1, "insertNtFileMsgToFMOnRecvMsg. filename:" + fileManagerEntity.fileName + R(fileManagerEntity));
                    if (msgRecord.chatType == 8) {
                        fileManagerEntity.peerUin = DataLineNTMsgMigrationUtil.d(fileManagerEntity.peerUid);
                        fileManagerEntity.peerType = DataLineNTMsgMigrationUtil.i(fileManagerEntity.peerUid);
                    }
                    if (msgRecord.chatType != 8) {
                        qQAppInterface.getFileManagerDataCenter().t(fileManagerEntity);
                    }
                    this.f208669d.put(Long.valueOf(fileManagerEntity.uniseq), fileManagerEntity);
                    FileManagerUtil.checkFileExisted(fileManagerEntity, qQAppInterface, null);
                    com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                    qQAppInterface.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, com.tencent.nt.adapter.session.c.c(msgRecord.getChatType()), 17, null, 0, null);
                } else {
                    QLog.e("NTC2CFileTransferMgr", 1, "insertNtFileMsgToFMOnRecvMsg error. datacenter is null. filename:" + fileManagerEntity.fileName);
                }
                w(fileManagerEntity);
            }
        }
    }

    public void Q(MsgRecord msgRecord) {
        if (!NTFileUtils.s(msgRecord)) {
            return;
        }
        P(msgRecord, true);
    }

    public FileManagerEntity k0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, boolean z16, long j3, int i16) {
        if (fileManagerEntity == null) {
            QLog.e("NTC2CFileTransferMgr", 1, "newInsertOff2OffFMEntity err. srcEntity=null");
            return null;
        }
        if (TextUtils.isEmpty(fileManagerEntity.peerUid)) {
            fileManagerEntity.peerUid = FileManagerUtil.checkAndGetUid(fileManagerEntity.peerUid, fileManagerEntity.peerUin, "newInsertOff2OffFMEntity src");
        }
        String checkAndGetUid = FileManagerUtil.checkAndGetUid(str3, str2, "newInsertOff2OffFMEntity");
        if (TextUtils.isEmpty(checkAndGetUid)) {
            QLog.e("NTC2CFileTransferMgr", 1, "newInsertOff2OffFMEntity. strRecvUid is Empty!");
        }
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        long g16 = NTFileUtils.g(l3);
        long g17 = NTFileUtils.g(l3);
        fileManagerEntity2.uniseq = g17;
        fileManagerEntity2.ntMsgId = g16;
        fileManagerEntity2.fwSrcPeerUid = fileManagerEntity.peerUid;
        fileManagerEntity2.fwSrcPeerType = fileManagerEntity.peerType;
        fileManagerEntity2.fwSrcNtMsgId = fileManagerEntity.ntMsgId;
        fileManagerEntity2.fwSrcUniseq = fileManagerEntity.uniseq;
        com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity2, g17, l3);
        fileManagerEntity2.nOpType = 7;
        fileManagerEntity2.bSend = true;
        fileManagerEntity2.isReaded = true;
        fileManagerEntity2.peerType = i3;
        fileManagerEntity2.peerUin = str2;
        fileManagerEntity2.peerUid = checkAndGetUid;
        fileManagerEntity2.peerNick = FileManagerUtil.getPeerNick(this.f208666a, str2, null, i3);
        fileManagerEntity2.selfUin = str;
        fileManagerEntity2.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity2.setCloudType(1);
        fileManagerEntity2.status = 2;
        fileManagerEntity2.msgSeq = FileManagerUtil.genMsgSeq();
        fileManagerEntity2.msgUid = FileManagerUtil.genMsgUid();
        fileManagerEntity2.ntChatType = l3;
        String str4 = fileManagerEntity2.fileName;
        if (str4 == null || str4.length() == 0) {
            fileManagerEntity2.fileName = FileManagerUtil.getFileName(fileManagerEntity2.getFilePath());
        }
        ((IForwardOrderManager) QRoute.api(IForwardOrderManager.class)).mapUniSeqId(fileManagerEntity2.uniseq, j3, i16);
        FileManagerUtil.setTempParam(this.f208666a, str, str2, fileManagerEntity2);
        QLog.i("NTC2CFileTransferMgr", 1, "insertOff2OffForwardEntity. src->" + R(fileManagerEntity) + " to->" + R(fileManagerEntity2) + " filename:" + fileManagerEntity.fileName);
        if (z16 && l3 != 8) {
            J().getFileManagerDataCenter().t(fileManagerEntity2);
        } else {
            J().getFileManagerDataCenter().v(fileManagerEntity2);
        }
        return fileManagerEntity2;
    }

    public void m0(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.getTrasferStatus() == 4) {
            o0(fileTransNotifyInfo);
        } else if (fileTransNotifyInfo.getTrasferStatus() == 6) {
            l0(fileTransNotifyInfo, fileTransNotifyInfo.getFileModelId(), fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId());
        } else {
            n0(fileTransNotifyInfo, fileTransNotifyInfo.getFileModelId(), fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), fileTransNotifyInfo.getFileErrCode(), fileTransNotifyInfo.getFileErrMsg(), fileTransNotifyInfo.getFileSrvErrCode(), fileTransNotifyInfo.getClientMsg());
        }
    }

    public void r0(FileTransNotifyInfo fileTransNotifyInfo) {
        FileManagerEntity fileManagerEntity;
        QLog.d("NTC2CFileTransferMgr", 1, "notifyInfo.getFilePath(): " + fileTransNotifyInfo.getFilePath() + " notifyInfo.getTrasferStatus(): " + fileTransNotifyInfo.getTrasferStatus());
        if (fileTransNotifyInfo.getTrasferStatus() != 4 || (fileManagerEntity = this.f208669d.get(Long.valueOf(fileTransNotifyInfo.getMsgElementId()))) == null) {
            return;
        }
        if (fileTransNotifyInfo.getThumbSize() == 750) {
            fileManagerEntity.strLargeThumPath = fileTransNotifyInfo.getFilePath();
        } else if (fileTransNotifyInfo.getThumbSize() == 384) {
            fileManagerEntity.strMiddleThumPath = fileTransNotifyInfo.getFilePath();
        } else if (fileTransNotifyInfo.getThumbSize() == 128 || fileTransNotifyInfo.getThumbSize() == 320) {
            fileManagerEntity.strThumbPath = fileTransNotifyInfo.getFilePath();
        }
        QLog.d("NTC2CFileTransferMgr", 1, "notifyInfo.getFilePath()" + fileTransNotifyInfo.getFilePath());
        FileManagerUtil.fixEntityThumbSize(fileManagerEntity);
        J().getFileManagerDataCenter().f0(fileManagerEntity);
        J().getFileManagerNotifyCenter().b(true, 51, new Object[]{fileManagerEntity, 0});
    }

    public void s0(FileTransNotifyInfo fileTransNotifyInfo) {
        FileManagerEntity fileManagerEntity;
        h hVar = this.f208667b.get(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
        if (hVar != null) {
            fileManagerEntity = hVar.f208696b;
            if (hVar.f208695a) {
                return;
            }
        } else {
            g K = K(N(fileTransNotifyInfo));
            if (K != null) {
                fileManagerEntity = K.f208693c;
            } else {
                fileManagerEntity = null;
            }
        }
        if (fileManagerEntity == null) {
            return;
        }
        if (fileManagerEntity.status != 2) {
            fileManagerEntity.status = 2;
        }
        fileManagerEntity.transSpeed = (int) fileTransNotifyInfo.getFileSpeed();
        fileManagerEntity.fProgress = ((float) fileTransNotifyInfo.getFileProgress()) / ((float) fileManagerEntity.fileSize);
        J().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
    }

    public void u0(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.getTrasferStatus() == 4) {
            w0(fileTransNotifyInfo);
        } else if (fileTransNotifyInfo.getTrasferStatus() == 6) {
            t0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId());
        } else {
            v0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), fileTransNotifyInfo.getFileErrCode(), fileTransNotifyInfo.getFileErrMsg(), fileTransNotifyInfo.getFileSrvErrCode(), fileTransNotifyInfo.getClientMsg());
        }
    }

    public void v(List<FileManagerEntity> list, List<NTFileManageBridger.g> list2) {
        QLog.i("NTC2CFileTransferMgr", 1, "sendLocalFileToNt file count:" + list.size());
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        Contact contact = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            FileManagerEntity fileManagerEntity = list.get(i3);
            NTFileManageBridger.g gVar = list2.get(i3);
            if (fileManagerEntity == null) {
                QLog.i("NTC2CFileTransferMgr", 1, "sendLocalFileToNt entry = null:");
                if (gVar != null) {
                    gVar.b(-1, "entry=null");
                }
            } else {
                FileElement fileElement = new FileElement();
                fileElement.setFileName(fileManagerEntity.fileName);
                fileElement.setFilePath(fileManagerEntity.strFilePath);
                fileElement.setFileSize(fileManagerEntity.fileSize);
                fileElement.setPicWidth(Integer.valueOf(fileManagerEntity.imgWidth));
                fileElement.setPicHeight(Integer.valueOf(fileManagerEntity.imgHeight));
                if (fileManagerEntity.isPhotoToMyComputer) {
                    fileElement.setSubElementType(1);
                }
                HashMap<Integer, String> hashMap = new HashMap<>();
                if (fileManagerEntity.strLargeThumPath != null) {
                    hashMap.put(750, fileManagerEntity.strLargeThumPath);
                }
                if (fileManagerEntity.strMiddleThumPath != null) {
                    hashMap.put(Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384), fileManagerEntity.strMiddleThumPath);
                }
                if (fileManagerEntity.strThumbPath != null) {
                    hashMap.put(128, fileManagerEntity.strThumbPath);
                }
                if (!hashMap.isEmpty()) {
                    fileElement.setPicThumbPath(hashMap);
                }
                MsgElement msgElement = new MsgElement();
                msgElement.setElementType(3);
                msgElement.setFileElement(fileElement);
                msgElement.setElementId(fileManagerEntity.uniseq);
                msgElement.fileElement.fileGroupIndex = Integer.valueOf(i3);
                com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
                Contact contact2 = new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, "");
                arrayList.add(msgElement);
                h hVar = new h();
                hVar.f208695a = false;
                hVar.f208696b = fileManagerEntity;
                hVar.f208698d = gVar;
                this.f208667b.put(Long.valueOf(fileManagerEntity.uniseq), hVar);
                contact = contact2;
            }
        }
        QLog.i("NTC2CFileTransferMgr", 1, "send multi pic element size: " + arrayList.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService().o0(0L, contact, arrayList);
            QLog.d("NTC2CFileTransferMgr", 1, "add local multi msg. " + contact);
        }
    }

    public void x(FileManagerEntity fileManagerEntity) {
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
        if (B0(M(fileManagerEntity)) == null && l3 != 8) {
            QLog.e("NTC2CFileTransferMgr", 1, "cancelDownloadNTFile. but had done" + R(fileManagerEntity));
            return;
        }
        QLog.i("NTC2CFileTransferMgr", 1, "cancelDownloadNTFile." + R(fileManagerEntity));
        ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(fileManagerEntity.ntMsgId, fileManagerEntity.peerUid, l3, fileManagerEntity.uniseq, 1, 0, "", fileManagerEntity.nSessionId, 0, 0));
        fileManagerEntity.status = 3;
        J().getFileManagerDataCenter().f0(fileManagerEntity);
    }

    public void x0(Activity activity, MsgRecord msgRecord, NTFileManageBridger.f fVar) {
        QLog.i("NTC2CFileTransferMgr", 1, "reSendAioFileMsg msgId:" + msgRecord.getMsgId());
        List<FileManagerEntity> k3 = NTFileUtils.k(this.f208666a, null, msgRecord, true);
        if (k3 != null && !k3.isEmpty()) {
            if (activity != null) {
                ActionSheet E = NTFileUtils.E(activity, null);
                E.setOnButtonClickListener(new a(k3, msgRecord, E, fVar));
                E.setOnBottomCancelListener(new b(E, fVar));
                ActionSheetHelper.showActionSheet(activity, E);
                return;
            }
            for (FileManagerEntity fileManagerEntity : k3) {
                QLog.i("NTC2CFileTransferMgr", 1, "reSendAioFileMsg resume msgId:" + msgRecord.getMsgId() + R(fileManagerEntity));
                J().getFileManagerEngine().o0(fileManagerEntity.nSessionId);
            }
            if (fVar != null) {
                fVar.onResult(0, "");
                return;
            }
            return;
        }
        QLog.e("NTC2CFileTransferMgr", 1, "reSendAioFileMsg op fail. nt msg fail to convert to file entity");
        if (fVar != null) {
            fVar.onResult(-2, " no entity");
        }
    }

    public void y(MsgRecord msgRecord) {
        QLog.i("NTC2CFileTransferMgr", 1, "cancelSendAioFileMsg msgId:" + msgRecord.getMsgId());
        List<FileManagerEntity> k3 = NTFileUtils.k(this.f208666a, null, msgRecord, true);
        if (k3 != null && !k3.isEmpty()) {
            for (FileManagerEntity fileManagerEntity : k3) {
                QLog.i("NTC2CFileTransferMgr", 1, "cancelSendAioFileMsg pause:" + msgRecord.getMsgId() + R(fileManagerEntity));
                J().getFileManagerEngine().i0(fileManagerEntity.nSessionId);
            }
            return;
        }
        QLog.e("NTC2CFileTransferMgr", 1, "cancelSendAioFileMsg op fail. nt msg fail to convert to file entity");
    }

    public void y0(final FileManagerEntity fileManagerEntity, NTFileManageBridger.g gVar) {
        if (fileManagerEntity == null) {
            QLog.i("NTC2CFileTransferMgr", 1, "reSendFileToNt entry = null:");
            if (gVar != null) {
                gVar.b(-1, "entry=null");
                return;
            }
            return;
        }
        QLog.i("NTC2CFileTransferMgr", 1, "reSendFileToNt fileName:" + fileManagerEntity.fileName + " fileSize:" + fileManagerEntity.fileSize + R(fileManagerEntity));
        h hVar = new h();
        hVar.f208695a = false;
        hVar.f208696b = fileManagerEntity;
        hVar.f208698d = gVar;
        this.f208667b.put(Long.valueOf(fileManagerEntity.uniseq), hVar);
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, ""), fileManagerEntity.ntMsgId, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NTC2CFileTransferMgr.this.f0(fileManagerEntity, i3, str);
            }
        });
    }

    public void z(FileManagerEntity fileManagerEntity) {
        QLog.i("NTC2CFileTransferMgr", 1, "cancelSendLocalFile." + R(fileManagerEntity));
        h hVar = this.f208667b.get(Long.valueOf(fileManagerEntity.uniseq));
        if (hVar != null && !hVar.f208695a) {
            hVar.f208695a = true;
            FileManagerEntity fileManagerEntity2 = hVar.f208696b;
            this.f208667b.remove(Long.valueOf(fileManagerEntity.uniseq));
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            ((IMsgService) QRoute.api(IMsgService.class)).cancelSendMsg(fileManagerEntity.ntMsgId, fileManagerEntity.peerUid, com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType));
            fileManagerEntity2.status = 3;
            J().getFileManagerDataCenter().f0(fileManagerEntity2);
            J().getFileManagerNotifyCenter().b(true, 3, null);
            return;
        }
        QLog.w("NTC2CFileTransferMgr", 1, "cancelSendLocalFile. but had handle done");
    }

    private void w(FileManagerEntity fileManagerEntity) {
    }
}
