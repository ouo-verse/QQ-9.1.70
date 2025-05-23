package com.tencent.mobileqq.filemanager.nt;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.nt.cc;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import com.tencent.widget.ActionSheet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes12.dex */
public class cc {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208871a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Long, e> f208872b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Long, c> f208873c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<UUID, Long> f208874d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    protected ActionSheet f208875e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, String> f208876f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements IForwardOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208877a;

        a(FileManagerEntity fileManagerEntity) {
            this.f208877a = fileManagerEntity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(FileManagerEntity fileManagerEntity, int i3, String str) {
            cc.this.s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
        public void onResult(final int i3, final String str, HashMap<Long, Integer> hashMap) {
            if (i3 != 0) {
                Handler handler = new Handler(Looper.getMainLooper());
                final FileManagerEntity fileManagerEntity = this.f208877a;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.cb
                    @Override // java.lang.Runnable
                    public final void run() {
                        cc.a.this.b(fileManagerEntity, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements IForwardOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208879a;

        b(FileManagerEntity fileManagerEntity) {
            this.f208879a = fileManagerEntity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(FileManagerEntity fileManagerEntity, int i3, String str) {
            cc.this.s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
        public void onResult(final int i3, final String str, HashMap<Long, Integer> hashMap) {
            if (i3 != 0) {
                Handler handler = new Handler(Looper.getMainLooper());
                final FileManagerEntity fileManagerEntity = this.f208879a;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.cd
                    @Override // java.lang.Runnable
                    public final void run() {
                        cc.b.this.b(fileManagerEntity, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        long f208881a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f208882b = 0;

        /* renamed from: c, reason: collision with root package name */
        NTFileManageBridger.e f208883c;

        /* renamed from: d, reason: collision with root package name */
        TroopFileTransferManager.Item f208884d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f208885e;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        int f208887a = 1;

        /* renamed from: b, reason: collision with root package name */
        String f208888b = "";

        /* renamed from: c, reason: collision with root package name */
        String f208889c = "";

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        boolean f208891a = true;

        /* renamed from: b, reason: collision with root package name */
        int f208892b = 0;

        /* renamed from: c, reason: collision with root package name */
        long f208893c = 0;

        /* renamed from: d, reason: collision with root package name */
        NTFileManageBridger.g f208894d;

        /* renamed from: e, reason: collision with root package name */
        TroopFileTransferManager.Item f208895e;

        e() {
        }
    }

    public cc(QQAppInterface qQAppInterface) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f208876f = hashMap;
        this.f208871a = qQAppInterface;
        hashMap.put(0, "UploadLocalFile");
        this.f208876f.put(1, "ForwardWeiyunFile");
        this.f208876f.put(2, "ForwardFavFile");
        this.f208876f.put(3, "ForwardFileFromOffline");
        this.f208876f.put(4, "ForwardFileFromTroop");
    }

    private c J(long j3) {
        return this.f208873c.get(Long.valueOf(j3));
    }

    private long K(UUID uuid) {
        if (this.f208874d.containsKey(uuid)) {
            return this.f208874d.get(uuid).longValue();
        }
        return 0L;
    }

    private d L(long j3, String str, long j16, String str2) {
        d dVar = new d();
        dVar.f208889c = str2;
        if (str2.isEmpty()) {
            dVar.f208889c = "\u4f20\u8f93\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
        }
        int i3 = (int) j16;
        dVar.f208887a = i3;
        if (i3 == 0) {
            dVar.f208887a = (int) j3;
        }
        dVar.f208888b = str;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            dVar.f208887a = 106;
            dVar.f208889c = "";
        }
        return dVar;
    }

    private String M(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return "";
        }
        return " ntMId:" + fileManagerEntity.ntMsgId + " ntEId/uniseq:" + fileManagerEntity.uniseq + " sId:" + fileManagerEntity.nSessionId + " peer:" + fileManagerEntity.peerUid + "/" + fileManagerEntity.peerUin;
    }

    private String N(TroopFileTransferManager.Item item) {
        if (item == null) {
            return "";
        }
        return " ntMId:" + item.ntMsgId + " ntEId:" + item.ntElementId + " id:" + item.idStr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(NTFileManageBridger.f fVar, int i3) {
        if (fVar != null) {
            if (i3 == 0) {
                i3 = 0;
            }
            fVar.onResult(i3, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(NTFileManageBridger.f fVar, int i3) {
        if (fVar != null) {
            if (i3 == 0) {
                i3 = 0;
            }
            fVar.onResult(i3, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(NTFileManageBridger.f fVar, int i3) {
        if (fVar != null) {
            if (i3 == 0) {
                i3 = 0;
            }
            fVar.onResult(i3, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(FileManagerEntity fileManagerEntity, int i3, String str) {
        s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ca
                @Override // java.lang.Runnable
                public final void run() {
                    cc.this.R(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit T(FileManagerEntity fileManagerEntity, TargetFileInfo targetFileInfo, Contact contact, Pair pair) {
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        Contact contact2 = new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, "");
        QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromOff sub msg, ids: " + Arrays.toString((long[]) pair.getFirst()) + ", sub msg id : " + targetFileInfo.targetMsgId + ", src: " + contact2 + ", dst: " + contact);
        com.tencent.mobileqq.filebrowser.toogle.a.a((long[]) pair.getFirst(), (long[]) pair.getSecond(), contact2, new ArrayList(Arrays.asList(contact)), new a(fileManagerEntity));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(FileManagerEntity fileManagerEntity, int i3, String str) {
        s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.bi
                @Override // java.lang.Runnable
                public final void run() {
                    cc.this.U(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit W(TargetFileInfo targetFileInfo, Contact contact, final FileManagerEntity fileManagerEntity) {
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(targetFileInfo, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.bf
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                cc.this.V(fileManagerEntity, i3, str);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit X(FileManagerEntity fileManagerEntity, TargetFileInfo targetFileInfo, Contact contact, Pair pair) {
        com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
        Contact contact2 = new Contact(com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType), fileManagerEntity.peerUid, "");
        QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile sub msg, ids: " + Arrays.toString((long[]) pair.getFirst()) + ", sub msg id : " + targetFileInfo.targetMsgId + ", src: " + contact2 + ", dst: " + contact);
        com.tencent.mobileqq.filebrowser.toogle.a.a((long[]) pair.getFirst(), (long[]) pair.getSecond(), contact2, new ArrayList(Arrays.asList(contact)), new b(fileManagerEntity));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(FileManagerEntity fileManagerEntity, int i3, String str) {
        s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.bg
                @Override // java.lang.Runnable
                public final void run() {
                    cc.this.Y(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a0(TargetFileInfo targetFileInfo, Contact contact, final FileManagerEntity fileManagerEntity) {
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(targetFileInfo, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.bw
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                cc.this.Z(fileManagerEntity, i3, str);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(FileManagerEntity fileManagerEntity, int i3, String str) {
        s0(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(final FileManagerEntity fileManagerEntity, final int i3, final String str) {
        if (i3 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.bh
                @Override // java.lang.Runnable
                public final void run() {
                    cc.this.b0(fileManagerEntity, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(long j3, e eVar, String str, String str2) {
        com.tencent.mobileqq.troop.data.t info = eVar.f208895e.getInfo(j3);
        TroopFileTransferManager.Item item = eVar.f208895e;
        y(j3, info, item.ntMsgId, item.ntElementId, str, str2, item.Sha3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(NTFileManageBridger.f fVar, int i3) {
        if (fVar != null) {
            if (i3 == 0) {
                i3 = 0;
            }
            fVar.onResult(i3, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(MsgRecord msgRecord, TroopFileTransferManager.Item item, long j3, Activity activity, final NTFileManageBridger.f fVar, View view, int i3) {
        QLog.i("NTTroopFileTransferMgr", 1, "reSendAioFileMsg resume msgId:" + msgRecord.getMsgId() + N(item));
        new TroopFileItemOperation(j3, this.f208871a, activity).z(item.Id, new TroopFileItemOperation.j() { // from class: com.tencent.mobileqq.filemanager.nt.bj
            @Override // com.tencent.mobileqq.troop.data.TroopFileItemOperation.j
            public final void onResult(int i16) {
                cc.e0(NTFileManageBridger.f.this, i16);
            }
        });
        NTFileUtils.f(this.f208875e);
        this.f208875e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(NTFileManageBridger.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        NTFileUtils.f(this.f208875e);
        this.f208875e = null;
        if (fVar != null) {
            fVar.onResult(-1, " cancel");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(TroopFileTransferManager.Item item, int i3, String str) {
        s0(item.ntMsgId, item.ntElementId, i3, str, 0L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(final TroopFileTransferManager.Item item, final int i3, final String str) {
        QLog.e("NTTroopFileTransferMgr", 1, "reSendFileToNt result:" + i3 + " errMsg:" + str + N(item));
        if (i3 == 4) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.bq
                @Override // java.lang.Runnable
                public final void run() {
                    cc.this.h0(item, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(TroopFileTransferManager.Item item, int i3, String str) {
        QLog.i("NTTroopFileTransferMgr", 1, "sendLocalFileToNt result:" + i3 + " errMsg:" + str + N(item));
    }

    private void k0(long j3, long j16, long j17, int i3, boolean z16) {
        int i16;
        NTFileManageBridger.e eVar;
        c x06 = x0(j3);
        if (x06 == null) {
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "onNTDownloadCancel" + N(x06.f208884d));
        TroopFileTransferManager.Item item = x06.f208884d;
        item.Pausing = 1;
        if (i3 == 1) {
            item.W2MPause = 2;
        } else if (i3 == 2) {
            item.Pausing = -1;
        } else if (i3 == 3) {
            item.Pausing = -1;
            i16 = 10;
            com.tencent.mobileqq.troop.filemanager.b.e(item.troopuin, item, i16);
            if (!z16 && (eVar = x06.f208883c) != null) {
                eVar.a();
                return;
            }
        }
        i16 = 9;
        com.tencent.mobileqq.troop.filemanager.b.e(item.troopuin, item, i16);
        if (!z16) {
        }
    }

    private void m0(long j3, long j16, long j17, long j18, String str, long j19, String str2) {
        c x06 = x0(j3);
        if (x06 == null) {
            return;
        }
        d L = L(j18, str, j19, str2);
        QLog.e("NTTroopFileTransferMgr", 1, "onNTDownloadFail" + N(x06.f208884d) + " errCode:" + j18 + " errMsg:" + str + " svrReturnCode:" + j19 + " clientWording:" + str2 + " fileError:" + L.f208887a + " errClientTipWording:" + L.f208889c);
        TroopFileTransferManager.Item item = x06.f208884d;
        TroopFileError.b bVar = new TroopFileError.b(item.FileName, item.troopuin, 10, L.f208887a, L.f208889c);
        TroopFileTransferManager.Item item2 = x06.f208884d;
        com.tencent.mobileqq.troop.filemanager.b.g(item2.troopuin, item2, 10, bVar);
        NTFileManageBridger.e eVar = x06.f208883c;
        if (eVar != null) {
            eVar.b((int) j18, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n0(FileTransNotifyInfo fileTransNotifyInfo) {
        long j3;
        long j16;
        long j17;
        NTFileManageBridger.e eVar;
        QQAppInterface qQAppInterface;
        c x06 = x0(fileTransNotifyInfo.getFileModelId());
        if (x06 == null) {
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "onNTDownloadSuc." + N(x06.f208884d) + "filePath:" + fileTransNotifyInfo.getFilePath());
        TroopFileTransferManager.Item item = x06.f208884d;
        long j18 = item.troopuin;
        item.LocalFile = fileTransNotifyInfo.getFilePath();
        NTFileUtils.G(fileTransNotifyInfo.getFilePath());
        int fileType = FileManagerUtil.getFileType(com.tencent.mobileqq.filemanager.util.q.j(x06.f208884d.FileName));
        if ((fileType == 2 || fileType == 0) && !com.tencent.mobileqq.filemanager.util.q.p(x06.f208884d.getThumbnailFile(j18, 383))) {
            x06.f208884d.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        com.tencent.mobileqq.troop.filemanager.b.e(j18, x06.f208884d, 11);
        String bytes2HexStr = HexUtil.bytes2HexStr(x06.f208884d.Md5);
        String bytes2HexStr2 = HexUtil.bytes2HexStr(x06.f208884d.Sha);
        TroopFileTransferManager.Item item2 = x06.f208884d;
        long j19 = item2.ntMsgId;
        long j26 = item2.ntElementId;
        Bundle bundle = x06.f208885e;
        if (bundle != null) {
            long j27 = bundle.getLong("TRANS_PARAM_NT_MSGID");
            j3 = j18;
            long j28 = x06.f208885e.getLong("TRANS_PARAM_NT_ELEMENTID");
            if ((j27 != 0 && j19 != 0 && j27 != j19) || (j28 != 0 && j26 != 0 && j28 != j26)) {
                QLog.w("NTTroopFileTransferMgr", 1, "onDownloadSuc nt msgid/elemId is not match. item.msgid:" + j19 + " item.elemid:" + j26 + " reqNtMsgId:" + j27 + " reqNtElementId:" + j28 + " dwnTaskId:" + x06.f208882b);
                j17 = j28;
                j16 = j27;
                long j29 = j3;
                y(j29, x06.f208884d.getInfo(j29), j16, j17, bytes2HexStr, bytes2HexStr2, x06.f208884d.Sha3, false);
                eVar = x06.f208883c;
                if (eVar != null) {
                    eVar.b(0, "");
                }
                if (5 != FileManagerUtil.getFileType(x06.f208884d.FileName) && (qQAppInterface = this.f208871a) != null) {
                    MMApkFileSafeChecker Q = qQAppInterface.getFileManagerEngine().Q();
                    TroopFileTransferManager.Item item3 = x06.f208884d;
                    Q.k(item3.troopuin, item3);
                    return;
                }
            }
        } else {
            j3 = j18;
        }
        j16 = j19;
        j17 = j26;
        long j292 = j3;
        y(j292, x06.f208884d.getInfo(j292), j16, j17, bytes2HexStr, bytes2HexStr2, x06.f208884d.Sha3, false);
        eVar = x06.f208883c;
        if (eVar != null) {
        }
        if (5 != FileManagerUtil.getFileType(x06.f208884d.FileName)) {
        }
    }

    private void q0(long j3, long j16) {
        e eVar = this.f208872b.get(Long.valueOf(j16));
        if (eVar != null && !eVar.f208891a) {
            eVar.f208891a = true;
            this.f208872b.remove(Long.valueOf(j16));
            long j17 = eVar.f208895e.troopuin;
            QLog.i("NTTroopFileTransferMgr", 1, "onUploadCancel" + N(eVar.f208895e));
            com.tencent.mobileqq.troop.filemanager.b.e(j17, eVar.f208895e, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(long j3, long j16, long j17, String str, long j18, String str2) {
        e eVar = this.f208872b.get(Long.valueOf(j16));
        if (eVar != null && !eVar.f208891a) {
            com.tencent.mobileqq.filemanager.uftwrapper.a.c(eVar.f208895e, j16, j17, str);
            eVar.f208891a = true;
            this.f208872b.remove(Long.valueOf(j16));
            d L = L(j17, str, j18, str2);
            String str3 = this.f208876f.get(Integer.valueOf(eVar.f208892b));
            if (TextUtils.isEmpty(str3)) {
                str3 = "Unknow";
            }
            QLog.e("NTTroopFileTransferMgr", 1, "on" + str3 + "Fail." + N(eVar.f208895e) + " errCode:" + j17 + " errMsg:" + str + " svrReturnCode:" + j18 + " clientWording:" + str2 + " fileError:" + L.f208887a + " errClientTipWording:" + L.f208889c);
            TroopFileTransferManager.Item item = eVar.f208895e;
            long j19 = item.troopuin;
            int i3 = eVar.f208892b;
            if (i3 == 1) {
                TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, j19);
                if (O != null) {
                    O.F(eVar.f208895e.Id, L.f208887a, null, L.f208889c);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                TroopFileTransferManager O2 = TroopFileTransferManager.O(this.f208871a, j19);
                if (O2 != null) {
                    O2.F(eVar.f208895e.Id, L.f208887a, null, L.f208889c);
                    return;
                }
                return;
            }
            if (i3 == 3) {
                TroopFileTransferManager O3 = TroopFileTransferManager.O(this.f208871a, j19);
                if (O3 != null) {
                    O3.E(eVar.f208893c, eVar.f208895e.Id, null, L.f208887a, null, L.f208889c);
                    return;
                }
                return;
            }
            if (i3 == 4) {
                TroopFileTransferManager O4 = TroopFileTransferManager.O(this.f208871a, j19);
                if (O4 != null) {
                    O4.E(eVar.f208893c, eVar.f208895e.Id, null, L.f208887a, null, L.f208889c);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.troop.filemanager.b.g(j19, eVar.f208895e, 3, new TroopFileError.b(item.FileName, j19, 3, L.f208887a, L.f208889c));
            NTFileManageBridger.g gVar = eVar.f208894d;
            if (gVar != null) {
                gVar.b((int) j17, str);
                return;
            }
            return;
        }
        com.tencent.mobileqq.filemanager.uftwrapper.a.c(null, j16, j17, str);
    }

    private void t0(FileTransNotifyInfo fileTransNotifyInfo) {
        final String str;
        final String str2;
        String str3;
        final e eVar = this.f208872b.get(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
        if (eVar != null && !eVar.f208891a) {
            if (fileTransNotifyInfo.getFileId() != null && !fileTransNotifyInfo.getFileId().isEmpty()) {
                com.tencent.mobileqq.filemanager.uftwrapper.a.c(eVar.f208895e, 0L, 0L, "");
                eVar.f208891a = true;
                this.f208872b.remove(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
                String str4 = this.f208876f.get(Integer.valueOf(eVar.f208892b));
                if (TextUtils.isEmpty(str4)) {
                    str4 = "Unknow";
                }
                QLog.i("NTTroopFileTransferMgr", 1, "on" + str4 + "Success." + N(eVar.f208895e));
                TroopFileTransferManager.Item item = eVar.f208895e;
                final long j3 = item.troopuin;
                item.ProgressValue = item.ProgressTotal;
                if (fileTransNotifyInfo.getFileId() != null && !fileTransNotifyInfo.getFileId().isEmpty()) {
                    eVar.f208895e.FilePath = fileTransNotifyInfo.getFileId();
                }
                if (fileTransNotifyInfo.getCommonFileInfo() == null || fileTransNotifyInfo.getCommonFileInfo().getMd5() == null || fileTransNotifyInfo.getCommonFileInfo().getMd5().isEmpty()) {
                    str = "";
                } else {
                    String md5 = fileTransNotifyInfo.getCommonFileInfo().getMd5();
                    eVar.f208895e.Md5 = HexUtil.hexStr2Bytes(md5);
                    str = md5;
                }
                if (fileTransNotifyInfo.getCommonFileInfo() == null || fileTransNotifyInfo.getCommonFileInfo().getSha() == null || fileTransNotifyInfo.getCommonFileInfo().getSha().isEmpty()) {
                    str2 = "";
                } else {
                    String sha = fileTransNotifyInfo.getCommonFileInfo().getSha();
                    eVar.f208895e.Sha = HexUtil.hexStr2Bytes(sha);
                    str2 = sha;
                }
                if (fileTransNotifyInfo.getCommonFileInfo() == null || fileTransNotifyInfo.getCommonFileInfo().getSha3() == null || fileTransNotifyInfo.getCommonFileInfo().getSha3().isEmpty()) {
                    str3 = "";
                } else {
                    str3 = fileTransNotifyInfo.getCommonFileInfo().getSha3();
                    eVar.f208895e.Sha3 = str3;
                }
                if (fileTransNotifyInfo.getCommonFileInfo() != null && fileTransNotifyInfo.getCommonFileInfo().getBizType() != null && fileTransNotifyInfo.getCommonFileInfo().getBizType().intValue() != 0) {
                    eVar.f208895e.BusId = fileTransNotifyInfo.getCommonFileInfo().getBizType().intValue();
                } else {
                    eVar.f208895e.BusId = 102;
                    QLog.e("NTTroopFileTransferMgr", 1, "onUploadSuc.biz id err use 102");
                }
                int i3 = eVar.f208892b;
                if (i3 == 1) {
                    TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, eVar.f208895e.troopuin);
                    if (O != null) {
                        O.F(eVar.f208895e.Id, 0, fileTransNotifyInfo.getFileId(), null);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    FileManagerEntity D = this.f208871a.getFileManagerDataCenter().D(eVar.f208893c);
                    if (D != null) {
                        TroopFileTransferManager.Item item2 = eVar.f208895e;
                        D.strTroopFilePath = item2.FilePath;
                        D.cloudType = 4;
                        D.busId = item2.BusId;
                        D.strFileMd5 = str;
                        D.strFileSHA = str2;
                        D.strFileSha3 = str3;
                    }
                    TroopFileTransferManager O2 = TroopFileTransferManager.O(this.f208871a, eVar.f208895e.troopuin);
                    if (O2 != null) {
                        O2.E(eVar.f208893c, eVar.f208895e.Id, null, 0, fileTransNotifyInfo.getFileId(), "");
                        return;
                    }
                    return;
                }
                if (i3 == 3) {
                    FileManagerEntity D2 = this.f208871a.getFileManagerDataCenter().D(eVar.f208893c);
                    if (D2 != null) {
                        D2.strTroopFilePath = eVar.f208895e.FilePath;
                    }
                    TroopFileTransferManager O3 = TroopFileTransferManager.O(this.f208871a, eVar.f208895e.troopuin);
                    if (O3 != null) {
                        O3.E(eVar.f208893c, eVar.f208895e.Id, null, 0, fileTransNotifyInfo.getFileId(), "");
                        return;
                    }
                    return;
                }
                if (i3 == 4) {
                    FileManagerEntity D3 = this.f208871a.getFileManagerDataCenter().D(eVar.f208893c);
                    if (D3 != null) {
                        D3.strTroopFilePath = eVar.f208895e.FilePath;
                    }
                    TroopFileTransferManager O4 = TroopFileTransferManager.O(this.f208871a, eVar.f208895e.troopuin);
                    if (O4 != null) {
                        O4.E(eVar.f208893c, eVar.f208895e.Id, null, 0, fileTransNotifyInfo.getFileId(), "");
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.troop.filemanager.b.e(j3, eVar.f208895e, 6);
                ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.br
                    @Override // java.lang.Runnable
                    public final void run() {
                        cc.this.d0(j3, eVar, str, str2);
                    }
                });
                NTFileManageBridger.g gVar = eVar.f208894d;
                if (gVar != null) {
                    gVar.b(0, "");
                    return;
                }
                return;
            }
            QLog.w("NTTroopFileTransferMgr", 1, "onNTUploadSuc. but no fileId, ntMsgId:" + fileTransNotifyInfo.getMsgId() + " ntElemId:" + fileTransNotifyInfo.getMsgElementId());
            s0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), -2L, "suc but troop file id is null", 0L, "");
        }
    }

    private long x(TroopFileTransferManager.Item item, Bundle bundle, NTFileManageBridger.e eVar) {
        long g16 = NTFileUtils.g(2);
        c cVar = new c();
        cVar.f208884d = item;
        cVar.f208882b = g16;
        cVar.f208885e = bundle;
        cVar.f208883c = eVar;
        this.f208873c.put(Long.valueOf(g16), cVar);
        this.f208874d.put(item.Id, Long.valueOf(g16));
        QLog.i("NTTroopFileTransferMgr", 1, "addDownloadTaskContext. dwnTaskId:" + g16 + N(item) + " cSize:" + this.f208873c.size());
        return g16;
    }

    private c x0(long j3) {
        c cVar = this.f208873c.get(Long.valueOf(j3));
        if (cVar != null) {
            this.f208873c.remove(Long.valueOf(j3));
            this.f208874d.remove(cVar.f208884d.Id);
            QLog.i("NTTroopFileTransferMgr", 1, "takeOutDownloadTaskContext. dwnTaskId:" + j3 + " cSize:" + this.f208873c.size());
        }
        return cVar;
    }

    public void A(MsgRecord msgRecord) {
        QLog.i("NTTroopFileTransferMgr", 1, "cancelSendAioFileMsg msgId:" + msgRecord.getMsgId());
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, Long.valueOf(msgRecord.getPeerUid()).longValue());
        TroopFileTransferManager.Item K = O.K(msgRecord.getMsgId());
        if (K == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "cancelSendAioFileMsg item is null");
            return;
        }
        int i3 = K.Status;
        if (i3 != 0 && i3 != 1) {
            QLog.e("NTTroopFileTransferMgr", 1, "cancelSendAioFileMsg status:" + K.Status + " is error");
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "cancelSendAioFileMsg pause:" + msgRecord.getMsgId() + N(K));
        O.D0(K.Id);
    }

    public void B(TroopFileTransferManager.Item item) {
        QLog.i("NTTroopFileTransferMgr", 1, "cancelSendLocalFile." + N(item));
        e eVar = this.f208872b.get(Long.valueOf(item.ntElementId));
        if (eVar != null && !eVar.f208891a) {
            eVar.f208891a = true;
            this.f208872b.remove(Long.valueOf(item.ntElementId));
            ((IMsgService) QRoute.api(IMsgService.class)).cancelSendMsg(item.ntMsgId, String.valueOf(item.troopuin), 2);
            TroopFileTransferManager.Item item2 = eVar.f208895e;
            com.tencent.mobileqq.troop.filemanager.b.e(item2.troopuin, item2, 2);
            return;
        }
        QLog.w("NTTroopFileTransferMgr", 1, "cancelSendLocalFile. but had handle done");
    }

    public void C() {
        this.f208871a = null;
    }

    public void D(Activity activity, NTFileUtils.b bVar, MsgRecord msgRecord, long j3, String str, final NTFileManageBridger.f fVar) {
        long j16;
        long j17;
        int i3;
        String str2;
        String str3;
        String peerUid = msgRecord.getPeerUid();
        if (bVar != null) {
            peerUid = bVar.f208720b;
            j16 = bVar.f208719a;
        } else {
            j16 = 0;
        }
        try {
            j17 = Long.valueOf(peerUid).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            j17 = 0;
        }
        if (j17 == 0) {
            QLog.e("NTTroopFileTransferMgr", 1, "downloadAioFileMsg error troopCode = 0. rootMsgId:" + j16 + " msgId:" + msgRecord.getMsgId() + " fileElemId:" + j3);
            if (fVar != null) {
                fVar.onResult(-2, "troopCode = 0");
                return;
            }
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "downloadAioFileMsg. rootMsgId:" + j16 + " msgId:" + msgRecord.getMsgId() + " fileElemId:" + j3 + " troopCode:" + j17);
        FileElement l3 = NTFileUtils.l(msgRecord, j3);
        if (l3 == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "downloadAioFileMsg error. fileElement = null");
            if (fVar != null) {
                fVar.onResult(-2, "fileElement = null");
                return;
            }
            return;
        }
        if (l3.getFileBizId() != null && l3.getFileBizId().intValue() != 0) {
            i3 = l3.getFileBizId().intValue();
        } else {
            QLog.e("NTTroopFileTransferMgr", 1, "downloadAioFileMsg. fileElement.bizid err use 102");
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
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", msgRecord.getMsgTime());
        TroopFileItemOperation troopFileItemOperation = new TroopFileItemOperation(j17, this.f208871a, activity);
        if (l3.getTransferStatus().intValue() != 6 && l3.getTransferStatus().intValue() != 5) {
            if (!FileUtils.fileExistsAndNotEmpty(l3.getFilePath())) {
                QLog.i("NTTroopFileTransferMgr", 1, "downloadAioNTFileMsg. download");
                troopFileItemOperation.C(l3.getFileUuid(), l3.getFileName(), l3.getFileSize(), i16, bundle, new TroopFileItemOperation.j() { // from class: com.tencent.mobileqq.filemanager.nt.bm
                    @Override // com.tencent.mobileqq.troop.data.TroopFileItemOperation.j
                    public final void onResult(int i17) {
                        cc.Q(NTFileManageBridger.f.this, i17);
                    }
                });
                return;
            } else {
                if (fVar != null) {
                    fVar.onResult(0, "");
                    return;
                }
                return;
            }
        }
        TroopFileManager F = TroopFileManager.F(this.f208871a, j17);
        com.tencent.mobileqq.troop.data.n A = F.A(l3.getFileUuid());
        if (A == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "downloadAioFileMsg resume error. info = null");
            if (fVar != null) {
                fVar.onResult(-2, "resume download fail. info=null");
                return;
            }
            return;
        }
        if (A.f294915a != null) {
            TroopFileTransferManager.O(this.f208871a, j17).t(A.f294915a, msgRecord.getMsgId(), j3, bundle);
            F.o(A, msgRecord.getMsgId(), j3);
            F.o(F.B(A.f294915a), msgRecord.getMsgId(), j3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadAioNTFileMsg. resume id:");
            UUID uuid = A.f294915a;
            if (uuid == null) {
                str3 = "";
            } else {
                str3 = uuid.toString();
            }
            sb5.append(str3);
            sb5.append(" msgid:");
            sb5.append(A.G);
            sb5.append(" ntElementId:");
            sb5.append(A.H);
            QLog.i("NTTroopFileTransferMgr", 1, sb5.toString());
            troopFileItemOperation.w(A.f294915a, bundle, new TroopFileItemOperation.j() { // from class: com.tencent.mobileqq.filemanager.nt.bk
                @Override // com.tencent.mobileqq.troop.data.TroopFileItemOperation.j
                public final void onResult(int i17) {
                    cc.O(NTFileManageBridger.f.this, i17);
                }
            });
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("downloadAioNTFileMsg. download id:");
        UUID uuid2 = A.f294915a;
        if (uuid2 == null) {
            str2 = "";
        } else {
            str2 = uuid2.toString();
        }
        sb6.append(str2);
        sb6.append(" msgid:");
        sb6.append(A.G);
        sb6.append(" ntElementId:");
        sb6.append(A.H);
        QLog.i("NTTroopFileTransferMgr", 1, sb6.toString());
        troopFileItemOperation.C(l3.getFileUuid(), l3.getFileName(), l3.getFileSize(), i16, bundle, new TroopFileItemOperation.j() { // from class: com.tencent.mobileqq.filemanager.nt.bl
            @Override // com.tencent.mobileqq.troop.data.TroopFileItemOperation.j
            public final void onResult(int i17) {
                cc.P(NTFileManageBridger.f.this, i17);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(TroopFileTransferManager.Item item, Bundle bundle, NTFileManageBridger.e eVar) {
        String str;
        String str2;
        String str3;
        ArrayList<CommonFileInfo> arrayList;
        long j3;
        if (item != null && item.FilePath != null) {
            long x16 = x(item, bundle, eVar);
            QLog.i("NTTroopFileTransferMgr", 1, "downloadNTFile strFileName:" + item.FileName + " fileSize:" + item.ProgressTotal + N(item) + " dwnTaskId:" + x16);
            ArrayList<CommonFileInfo> arrayList2 = new ArrayList<>();
            String bytes2HexStr = HexUtil.bytes2HexStr(item.Md5);
            if (bytes2HexStr == null) {
                str = "";
            } else {
                str = bytes2HexStr;
            }
            String bytes2HexStr2 = HexUtil.bytes2HexStr(item.Sha);
            if (bytes2HexStr2 == null) {
                str2 = "";
            } else {
                str2 = bytes2HexStr2;
            }
            String str4 = item.Sha3;
            if (str4 == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            long j16 = item.UploadTime;
            if (j16 == 0) {
                j16 = com.tencent.mobileqq.service.message.e.K0();
            }
            long j17 = j16;
            long j18 = item.ntMsgId;
            long j19 = item.ntElementId;
            if (bundle != null) {
                long j26 = bundle.getLong("TRANS_PARAM_NT_MSGID");
                arrayList = arrayList2;
                j3 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
                if ((j26 != 0 && j18 != 0 && j26 != j18) || (j3 != 0 && j19 != 0 && j3 != j19)) {
                    QLog.w("NTTroopFileTransferMgr", 1, "downloadNTFile nt msgid/elemId is not match. item.msgid:" + j18 + " item.elemid:" + j19 + " reqNtMsgId:" + j26 + " reqNtElementId:" + j3 + " dwnTaskId:" + x16);
                    j18 = j26;
                    long j27 = j3;
                    ArrayList<CommonFileInfo> arrayList3 = arrayList;
                    arrayList3.add(new CommonFileInfo(x16, j18, j27, item.FilePath, "", item.FileName, item.ProgressTotal, j17, String.valueOf(item.troopuin), 2, str, "", str2, str3, "", "", Integer.valueOf(item.BusId), new HashMap()));
                    ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadFileForFileInfo(arrayList3, "");
                    if (item.Status != 8) {
                        com.tencent.mobileqq.troop.filemanager.b.e(item.troopuin, item, 8);
                    }
                    com.tencent.mobileqq.troop.filemanager.b.h(item.troopuin, item);
                    return;
                }
            } else {
                arrayList = arrayList2;
            }
            j3 = j19;
            long j272 = j3;
            ArrayList<CommonFileInfo> arrayList32 = arrayList;
            arrayList32.add(new CommonFileInfo(x16, j18, j272, item.FilePath, "", item.FileName, item.ProgressTotal, j17, String.valueOf(item.troopuin), 2, str, "", str2, str3, "", "", Integer.valueOf(item.BusId), new HashMap()));
            ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadFileForFileInfo(arrayList32, "");
            if (item.Status != 8) {
            }
            com.tencent.mobileqq.troop.filemanager.b.h(item.troopuin, item);
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "downloadFile item/item.FilePath err!!");
        if (eVar != null) {
            eVar.b(-1, "item/item.FilePath err!!");
        }
    }

    public void F(final FileManagerEntity fileManagerEntity, String str, int i3) {
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, Long.valueOf(str).longValue());
        if (O == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromFav troop mgr is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        if (TextUtils.isEmpty(fileManagerEntity.strFavFileId)) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromFav strFavFileId is Empty!");
            return;
        }
        fileManagerEntity.ntMsgId = NTFileUtils.g(2);
        fileManagerEntity.uniseq = NTFileUtils.g(2);
        int abs = Math.abs(new Random().nextInt());
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", fileManagerEntity.ntMsgId);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", fileManagerEntity.uniseq);
        com.tencent.mobileqq.troop.data.t q06 = O.q0(fileManagerEntity, 102, abs, Long.parseLong(this.f208871a.getCurrentUin()), bundle);
        if (q06 == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromFav TroopFileStatusInfo is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        TroopFileTransferManager.Item J = O.J(q06.f294967a);
        if (J == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromFav item is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        fileManagerEntity.strTroopFileUuid = q06.f294967a.toString();
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = 0.0f;
        fileManagerEntity.TroopUin = q06.f294971e;
        e eVar = new e();
        eVar.f208891a = false;
        eVar.f208895e = J;
        eVar.f208893c = fileManagerEntity.nSessionId;
        eVar.f208892b = 2;
        this.f208872b.put(Long.valueOf(J.ntElementId), eVar);
        TargetFileInfo u16 = NTFileUtils.u(fileManagerEntity, fileManagerEntity, 41);
        Contact contact = new Contact(2, str, "");
        QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromFav. src->" + M(fileManagerEntity) + " to->" + N(eVar.f208895e) + " filename:" + fileManagerEntity.fileName);
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(u16, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.be
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str2) {
                cc.this.S(fileManagerEntity, i16, str2);
            }
        });
    }

    public void G(final FileManagerEntity fileManagerEntity, String str, long j3, int i3) {
        final FileManagerEntity g16 = this.f208871a.getFileManagerEngine().g(fileManagerEntity, str, 1);
        g16.ntMsgId = NTFileUtils.g(2);
        if (com.tencent.mobileqq.filemanager.util.j.f209387a.d()) {
            g16.uniseq = NTFileUtils.g(2);
        } else {
            g16.uniseq = g16.nSessionId;
        }
        int i16 = g16.busId;
        if (i16 != 102 && i16 != 104) {
            g16.busId = 102;
        }
        try {
            long parseLong = Long.parseLong(str);
            g16.TroopUin = parseLong;
            g16.status = 2;
            g16.fProgress = 0.0f;
            g16.fwSrcPeerUid = fileManagerEntity.peerUid;
            g16.fwSrcPeerType = fileManagerEntity.peerType;
            g16.fwSrcNtMsgId = fileManagerEntity.ntMsgId;
            g16.fwSrcUniseq = fileManagerEntity.uniseq;
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, parseLong);
            if (O == null) {
                QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromOffline troop mgr is null. fileName:" + fileManagerEntity.fileName);
                return;
            }
            int abs = Math.abs(new Random().nextInt());
            Bundle bundle = new Bundle();
            bundle.putLong("TRANS_PARAM_NT_MSGID", g16.ntMsgId);
            bundle.putLong("TRANS_PARAM_NT_ELEMENTID", g16.uniseq);
            bundle.putLong("TRANS_PARAM_UPLOAD_TIME", g16.srvTime / 1000);
            com.tencent.mobileqq.troop.data.t r06 = O.r0("", g16.fileName, null, g16.fileSize, 3, abs, parseLong, g16.nSessionId, g16, bundle);
            if (r06 == null) {
                QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromOffline TroopFileStatusInfo is null. fileName:" + fileManagerEntity.fileName);
                return;
            }
            TroopFileTransferManager.Item J = O.J(r06.f294967a);
            if (J == null) {
                QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromOffline item is null. fileName:" + fileManagerEntity.fileName);
                return;
            }
            g16.strTroopFileUuid = r06.f294967a.toString();
            g16.status = 2;
            g16.fProgress = 0.0f;
            e eVar = new e();
            eVar.f208891a = false;
            eVar.f208895e = J;
            long j16 = g16.nSessionId;
            eVar.f208893c = j16;
            J.entrySessionID = j16;
            eVar.f208892b = 3;
            this.f208872b.put(Long.valueOf(J.ntElementId), eVar);
            if (TextUtils.isEmpty(fileManagerEntity.peerUid)) {
                fileManagerEntity.peerUid = FileManagerUtil.checkAndGetUid(fileManagerEntity.peerUid, fileManagerEntity.peerUin, "forwardFileFromOff");
            }
            final TargetFileInfo w3 = NTFileUtils.w(fileManagerEntity, g16);
            final Contact contact = new Contact(2, str, "");
            QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromOffline. src->" + M(fileManagerEntity) + " to->" + N(eVar.f208895e) + " filename:" + fileManagerEntity.fileName);
            com.tencent.mobileqq.filebrowser.toogle.a.b(new Function1() { // from class: com.tencent.mobileqq.filemanager.nt.bt
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit T;
                    T = cc.this.T(fileManagerEntity, w3, contact, (Pair) obj);
                    return T;
                }
            }, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.bu
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit W;
                    W = cc.this.W(w3, contact, g16);
                    return W;
                }
            });
        } catch (Exception unused) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromOffline troop uin error. fileName:" + fileManagerEntity.fileName);
        }
    }

    public boolean H(final FileManagerEntity fileManagerEntity, long j3, long j16, int i3, long j17, int i16) {
        com.tencent.mobileqq.troop.data.t k3 = TroopFileUtils.k(this.f208871a, j3, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId);
        if (k3 != null && k3.f294985s != null) {
            int i17 = fileManagerEntity.busId;
            if (i17 != 102 && i17 != 104) {
                TroopFileManager F = TroopFileManager.F(this.f208871a, j3);
                if (F != null) {
                    com.tencent.mobileqq.troop.data.n A = F.A(fileManagerEntity.strTroopFilePath);
                    if (A != null) {
                        i17 = A.f294919e;
                    } else {
                        QLog.w("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile. biz id err. force use 102.");
                    }
                } else {
                    QLog.w("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile. biz id err. force use 102..");
                }
                i17 = 102;
            }
            final FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
            fileManagerEntity2.copyFrom(fileManagerEntity);
            long g16 = NTFileUtils.g(2);
            fileManagerEntity2.uniseq = g16;
            com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity2, g16, 2);
            fileManagerEntity2.ntMsgId = NTFileUtils.g(2);
            fileManagerEntity2.peerUin = String.valueOf(j3);
            fileManagerEntity2.peerUid = String.valueOf(j3);
            fileManagerEntity2.TroopUin = j16;
            fileManagerEntity2.peerType = 1;
            fileManagerEntity2.fwSrcPeerUid = fileManagerEntity.peerUid;
            fileManagerEntity2.fwSrcPeerType = fileManagerEntity.peerType;
            fileManagerEntity2.fwSrcNtMsgId = fileManagerEntity.ntMsgId;
            fileManagerEntity2.fwSrcUniseq = fileManagerEntity.uniseq;
            fileManagerEntity2.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
            fileManagerEntity2.busId = i17;
            this.f208871a.getFileManagerDataCenter().v(fileManagerEntity2);
            int abs = Math.abs(new Random().nextInt());
            Bundle bundle = new Bundle();
            bundle.putLong("TRANS_PARAM_NT_MSGID", fileManagerEntity2.ntMsgId);
            bundle.putLong("TRANS_PARAM_NT_ELEMENTID", fileManagerEntity2.uniseq);
            bundle.putLong("TRANS_PARAM_UPLOAD_TIME", fileManagerEntity2.srvTime / 1000);
            bundle.putBoolean("TRANS_PARAM_NT_FLAG", true);
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, j16);
            int i18 = i17;
            com.tencent.mobileqq.troop.data.t t06 = O.t0(k3.f294985s, j3, k3.f294987u, k3.f294978l, k3.f294976j, k3.f294988v, abs, fileManagerEntity2.nSessionId, bundle);
            if (t06 == null) {
                QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile new TroopFileStatusInfo is null. fileName:" + fileManagerEntity.fileName);
                return false;
            }
            TroopFileTransferManager.Item J = O.J(t06.f294967a);
            if (J == null) {
                QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile item is null. fileName:" + fileManagerEntity.fileName);
                return false;
            }
            fileManagerEntity2.strTroopFileUuid = t06.f294967a.toString();
            fileManagerEntity2.status = 2;
            fileManagerEntity2.fProgress = 0.0f;
            e eVar = new e();
            eVar.f208891a = false;
            eVar.f208895e = J;
            long j18 = fileManagerEntity2.nSessionId;
            eVar.f208893c = j18;
            J.entrySessionID = j18;
            eVar.f208892b = 4;
            this.f208872b.put(Long.valueOf(J.ntElementId), eVar);
            com.tencent.mobileqq.troop.filemanager.b.f(j16, J, 4, 0);
            final TargetFileInfo y16 = NTFileUtils.y(fileManagerEntity, fileManagerEntity2, i18);
            final Contact contact = new Contact(2, String.valueOf(j16), "");
            QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile. src->" + M(fileManagerEntity) + " to->" + N(eVar.f208895e) + " filename:" + fileManagerEntity.fileName);
            com.tencent.mobileqq.filebrowser.toogle.a.b(new Function1() { // from class: com.tencent.mobileqq.filemanager.nt.bp
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit X;
                    X = cc.this.X(fileManagerEntity, y16, contact, (Pair) obj);
                    return X;
                }
            }, new Function0() { // from class: com.tencent.mobileqq.filemanager.nt.bs
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit a06;
                    a06 = cc.this.a0(y16, contact, fileManagerEntity2);
                    return a06;
                }
            });
            return true;
        }
        QLog.e("NTTroopFileTransferMgr", 1, "forwardFileFromTroopFile TroopFileStatusInfo is null. fileName:" + fileManagerEntity.fileName);
        return false;
    }

    public void I(final FileManagerEntity fileManagerEntity, String str, String str2, int i3) {
        if (fileManagerEntity == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardWeiYunFile wyEntity is null");
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, Long.valueOf(str2).longValue());
        if (O == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardWeiYunFile troop mgr is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        fileManagerEntity.ntMsgId = NTFileUtils.g(2);
        if (com.tencent.mobileqq.filemanager.util.j.f209387a.d()) {
            fileManagerEntity.uniseq = fileManagerEntity.nSessionId;
        } else {
            fileManagerEntity.uniseq = NTFileUtils.g(2);
        }
        int abs = Math.abs(new Random().nextInt());
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", fileManagerEntity.ntMsgId);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", fileManagerEntity.uniseq);
        com.tencent.mobileqq.troop.data.t s06 = O.s0(fileManagerEntity.WeiYunFileId, fileManagerEntity.fileName, fileManagerEntity.getFilePath(), fileManagerEntity.fileSize, 25, abs, 8888L, bundle);
        if (s06 == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardWeiYunFile TroopFileStatusInfo is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        TroopFileTransferManager.Item J = O.J(s06.f294967a);
        if (J == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "forwardWeiYunFile item is null. fileName:" + fileManagerEntity.fileName);
            return;
        }
        fileManagerEntity.strTroopFileUuid = s06.f294967a.toString();
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = 0.0f;
        fileManagerEntity.TroopUin = s06.f294971e;
        e eVar = new e();
        eVar.f208891a = false;
        eVar.f208895e = J;
        eVar.f208893c = fileManagerEntity.nSessionId;
        eVar.f208892b = 1;
        this.f208872b.put(Long.valueOf(J.ntElementId), eVar);
        TargetFileInfo z16 = NTFileUtils.z(fileManagerEntity, fileManagerEntity, 40);
        Contact contact = new Contact(2, str2, "");
        QLog.i("NTTroopFileTransferMgr", 1, "forwardFileFromWeiYun. src->" + M(fileManagerEntity) + " to->" + N(eVar.f208895e) + " filename:" + fileManagerEntity.fileName + " wyId:" + z16.getCommonFileInfo().getUuid());
        ((IMsgService) QRoute.api(IMsgService.class)).forwardFile(z16, contact, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.bv
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str3) {
                cc.this.c0(fileManagerEntity, i16, str3);
            }
        });
    }

    public void l0(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.getTrasferStatus() == 4) {
            n0(fileTransNotifyInfo);
        } else if (fileTransNotifyInfo.getTrasferStatus() == 6) {
            k0(fileTransNotifyInfo.getFileModelId(), fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), 0, true);
        } else {
            m0(fileTransNotifyInfo.getFileModelId(), fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), fileTransNotifyInfo.getFileErrCode(), fileTransNotifyInfo.getFileErrMsg(), fileTransNotifyInfo.getFileSrvErrCode(), fileTransNotifyInfo.getClientMsg());
        }
    }

    public void p0(FileTransNotifyInfo fileTransNotifyInfo) {
        String str;
        e eVar = this.f208872b.get(Long.valueOf(fileTransNotifyInfo.getMsgElementId()));
        if (eVar != null) {
            if (eVar.f208891a) {
                return;
            }
            TroopFileTransferManager.Item item = eVar.f208895e;
            item.ProgressValue = fileTransNotifyInfo.getFileProgress();
            long fileSpeed = fileTransNotifyInfo.getFileSpeed();
            if (fileSpeed > 1048576) {
                str = "\u52a0\u901f\u4e0a\u4f20 " + new DecimalFormat("0.00").format(((float) fileSpeed) / 1048576.0f) + "MB/s";
            } else if (fileSpeed > 1024) {
                str = "\u52a0\u901f\u4e0a\u4f20 " + new DecimalFormat("0.00").format(((float) fileSpeed) / 1024.0f) + "KB/s";
            } else {
                str = "\u52a0\u901f\u4e0a\u4f20 " + fileSpeed + "KB/s";
            }
            if (fileSpeed != 0) {
                item.mExcitingSpeed = str;
            }
            long j3 = item.troopuin;
            if (item.Status != 1) {
                com.tencent.mobileqq.troop.filemanager.b.e(j3, item, 1);
            }
            com.tencent.mobileqq.troop.filemanager.b.h(j3, item);
            return;
        }
        c J = J(fileTransNotifyInfo.getFileModelId());
        if (J != null) {
            TroopFileTransferManager.Item item2 = J.f208884d;
            long j16 = item2.troopuin;
            item2.ProgressValue = fileTransNotifyInfo.getFileProgress();
            long currentTimeMillis = System.currentTimeMillis();
            if (item2.Status != 8) {
                com.tencent.mobileqq.troop.filemanager.b.e(j16, item2, 8);
            }
            long j17 = J.f208881a;
            if (j17 == 0 || currentTimeMillis - j17 >= 1500) {
                J.f208881a = currentTimeMillis;
                com.tencent.mobileqq.troop.filemanager.b.h(j16, item2);
            }
        }
    }

    public void r0(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.getTrasferStatus() == 4) {
            t0(fileTransNotifyInfo);
        } else if (fileTransNotifyInfo.getTrasferStatus() == 6) {
            q0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId());
        } else {
            s0(fileTransNotifyInfo.getMsgId(), fileTransNotifyInfo.getMsgElementId(), fileTransNotifyInfo.getFileErrCode(), fileTransNotifyInfo.getFileErrMsg(), fileTransNotifyInfo.getFileSrvErrCode(), fileTransNotifyInfo.getClientMsg());
        }
    }

    public void u0(final Activity activity, final MsgRecord msgRecord, final NTFileManageBridger.f fVar) {
        QLog.i("NTTroopFileTransferMgr", 1, "reSendAioFileMsg msgId:" + msgRecord.getMsgId());
        final long longValue = Long.valueOf(msgRecord.getPeerUid()).longValue();
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f208871a, longValue);
        final TroopFileTransferManager.Item K = O.K(msgRecord.getMsgId());
        if (K == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "reSendAioFileMsg item is null");
            if (fVar != null) {
                fVar.onResult(-2, "troop item = null");
                return;
            }
            return;
        }
        NTFileUtils.f(this.f208875e);
        this.f208875e = null;
        if (activity != null) {
            this.f208875e = NTFileUtils.D(activity, new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.filemanager.nt.bx
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    cc.this.f0(msgRecord, K, longValue, activity, fVar, view, i3);
                }
            }, new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.nt.bz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cc.this.g0(fVar, view);
                }
            });
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "reSendAioFileMsg resume msgId:" + msgRecord.getMsgId() + N(K));
        O.g0(K.Id);
        if (fVar != null) {
            fVar.onResult(0, "");
        }
    }

    public void v0(final TroopFileTransferManager.Item item, NTFileManageBridger.g gVar) {
        if (item == null) {
            QLog.i("NTTroopFileTransferMgr", 1, "reSendFileToNt item err!!");
            if (gVar != null) {
                gVar.b(-1, "item err!!");
                return;
            }
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "reSendFileToNt strFilePath:" + item.LocalFile + " fileSize:" + item.ProgressTotal + N(item));
        e eVar = new e();
        eVar.f208891a = false;
        eVar.f208895e = item;
        eVar.f208894d = gVar;
        this.f208872b.put(Long.valueOf(item.ntElementId), eVar);
        ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(new Contact(2, String.valueOf(item.troopuin), ""), item.ntMsgId, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.bn
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                cc.this.i0(item, i3, str);
            }
        });
    }

    public void w0(final TroopFileTransferManager.Item item, NTFileManageBridger.g gVar) {
        if (item == null) {
            QLog.i("NTTroopFileTransferMgr", 1, "sendLocalFileToNt item err!!");
            if (gVar != null) {
                gVar.b(-1, "item err!!");
                return;
            }
            return;
        }
        QLog.i("NTTroopFileTransferMgr", 1, "sendLocalFileToNt strFilePath:" + item.LocalFile + " fileSize:" + item.ProgressTotal + N(item));
        FileElement fileElement = new FileElement();
        fileElement.setFileName(item.FileName);
        fileElement.setFilePath(item.LocalFile);
        fileElement.setFileSize(item.ProgressTotal);
        fileElement.setPicWidth(Integer.valueOf(item.width));
        fileElement.setPicHeight(Integer.valueOf(item.height));
        fileElement.setFolderId(item.mParentId);
        HashMap<Integer, String> hashMap = new HashMap<>();
        if (item.largeThumbnailFile != null) {
            hashMap.put(750, item.largeThumbnailFile);
        }
        if (item.middleThumbnailFile != null) {
            hashMap.put(Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384), item.middleThumbnailFile);
        }
        if (item.smallThumbFile != null) {
            hashMap.put(128, item.smallThumbFile);
        }
        if (!hashMap.isEmpty()) {
            fileElement.setPicThumbPath(hashMap);
        }
        MsgElement msgElement = new MsgElement();
        msgElement.setElementType(3);
        msgElement.setFileElement(fileElement);
        msgElement.setElementId(item.ntElementId);
        Contact contact = new Contact(2, String.valueOf(item.troopuin), "");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(msgElement);
        e eVar = new e();
        eVar.f208891a = false;
        eVar.f208895e = item;
        eVar.f208894d = gVar;
        this.f208872b.put(Long.valueOf(item.ntElementId), eVar);
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, item.ntMsgId, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.nt.bo
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                cc.this.j0(item, i3, str);
            }
        });
    }

    public final void y(long j3, com.tencent.mobileqq.troop.data.t tVar, long j16, long j17, String str, String str2, String str3, boolean z16) {
        long j18;
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            return;
        }
        FileManagerEntity D = b16.getFileManagerProxy().D(j17, String.valueOf(j3), 1);
        if (D != null) {
            b16.getFileManagerDataCenter().R(D.nSessionId);
        }
        if (!com.tencent.mobileqq.filemanager.util.j.f209387a.d()) {
            j18 = FileManagerUtil.genSessionId().longValue();
        } else {
            j18 = j17;
        }
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar, j18);
        newEntityByTroopFileInfo.ntMsgId = j16;
        newEntityByTroopFileInfo.uniseq = j17;
        newEntityByTroopFileInfo.isReaded = true;
        newEntityByTroopFileInfo.peerUin = String.valueOf(tVar.f294971e);
        newEntityByTroopFileInfo.peerUid = String.valueOf(tVar.f294971e);
        newEntityByTroopFileInfo.peerNick = com.tencent.mobileqq.utils.ac.l0(b16, newEntityByTroopFileInfo.peerUin);
        newEntityByTroopFileInfo.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        newEntityByTroopFileInfo.setCloudType(3);
        newEntityByTroopFileInfo.bSend = z16;
        newEntityByTroopFileInfo.status = 1;
        newEntityByTroopFileInfo.fProgress = 1.0f;
        newEntityByTroopFileInfo.TroopUin = j3;
        newEntityByTroopFileInfo.strFileMd5 = str;
        newEntityByTroopFileInfo.strFileSHA = str2;
        newEntityByTroopFileInfo.strFileSha3 = str3;
        newEntityByTroopFileInfo.imgHeight = tVar.f294983q;
        newEntityByTroopFileInfo.imgWidth = tVar.f294982p;
        int i3 = newEntityByTroopFileInfo.nFileType;
        if (i3 == 0 || i3 == 2) {
            if (TextUtils.isEmpty(str3)) {
                newEntityByTroopFileInfo.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(tVar.f294978l));
            }
            if (newEntityByTroopFileInfo.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT && TextUtils.isEmpty(newEntityByTroopFileInfo.strFileSHA)) {
                newEntityByTroopFileInfo.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(tVar.f294978l));
            }
        }
        newEntityByTroopFileInfo.fromScene = 0;
        newEntityByTroopFileInfo.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.getMd5(tVar.f294978l));
        try {
            newEntityByTroopFileInfo.localModifyTime = new VFSFile(tVar.f294978l).lastModified();
        } catch (Exception unused) {
        }
        QLog.i("NTTroopFileTransferMgr", 1, "addTroopFileToFM.fileName:" + newEntityByTroopFileInfo.fileName + " ntMsgId:" + j16 + " ntElementId:" + j17 + " sid:" + newEntityByTroopFileInfo.nSessionId + " filePath:" + newEntityByTroopFileInfo.getFilePath());
        b16.getFileManagerDataCenter().t(newEntityByTroopFileInfo);
        newEntityByTroopFileInfo.status = 1;
        b16.getFileManagerDataCenter().f0(newEntityByTroopFileInfo);
    }

    public void z(TroopFileTransferManager.Item item, Bundle bundle, int i3) {
        long j3;
        long j16;
        if (item == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "cancelDownloadNTFile error. item=null");
            return;
        }
        long K = K(item.Id);
        QLog.i("NTTroopFileTransferMgr", 1, "cancelDownloadNTFile strFileName:" + item.FileName + " fileSize:" + item.ProgressTotal + N(item) + " dwnTaskId:" + K);
        if (K == 0) {
            QLog.e("NTTroopFileTransferMgr", 1, "cancelDownloadNTFile error. dwnTaskId no exist");
            return;
        }
        if (J(K) == null) {
            QLog.e("NTTroopFileTransferMgr", 1, "cancelDownloadNTFile. but had done");
            return;
        }
        long j17 = item.ntMsgId;
        long j18 = item.ntElementId;
        if (bundle != null) {
            long j19 = bundle.getLong("TRANS_PARAM_NT_MSGID");
            long j26 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
            if ((j19 != 0 && j17 != 0 && j19 != j17) || (j26 != 0 && j18 != 0 && j26 != j18)) {
                QLog.w("NTTroopFileTransferMgr", 1, "cancelDownloadNTFile nt msgid/elemId is not match. item.msgid:" + j17 + " item.elemid:" + j18 + " reqNtMsgId:" + j19 + " reqNtElementId:" + j26 + " dwnTaskId:" + K);
                j3 = j19;
                j16 = j26;
                ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(j3, String.valueOf(item.troopuin), 2, j16, 1, 0, "", K, 0, 0));
                k0(K, item.ntMsgId, item.ntElementId, i3, false);
            }
        }
        j3 = j17;
        j16 = j18;
        ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(j3, String.valueOf(item.troopuin), 2, j16, 1, 0, "", K, 0, 0));
        k0(K, item.ntMsgId, item.ntElementId, i3, false);
    }

    public void o0(FileTransNotifyInfo fileTransNotifyInfo) {
    }
}
