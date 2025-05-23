package com.tencent.mobileqq.troop.filemanager;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.data.i;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.k;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileTransferMgr extends TroopFileTransferManager {
    static IPatchRedirector $redirector_;
    private static Handler U;
    static final /* synthetic */ boolean V;
    protected TroopFileDownloadMgr.FileDownloadMgrObserver Q;
    protected int R;
    protected int S;
    protected Map<Long, TroopFileTransferManager.Item> T;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends TroopFileDownloadMgr.FileDownloadMgrObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferMgr.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver
        protected void c(Set<Long> set) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) set);
                return;
            }
            TroopFileTransferMgr troopFileTransferMgr = TroopFileTransferMgr.this;
            troopFileTransferMgr.S = 1;
            if (set != null && set.contains(Long.valueOf(((TroopFileTransferManager) troopFileTransferMgr).K))) {
                TroopFileTransferMgr.this.S = 2;
            }
            TroopFileTransferMgr troopFileTransferMgr2 = TroopFileTransferMgr.this;
            int i3 = troopFileTransferMgr2.R;
            if (i3 > 0) {
                if (troopFileTransferMgr2.S == 2 || i3 == 2) {
                    TroopFileError.h(((TroopFileTransferManager) troopFileTransferMgr2).J, ((TroopFileTransferManager) TroopFileTransferMgr.this).K, 107);
                }
                TroopFileTransferMgr troopFileTransferMgr3 = TroopFileTransferMgr.this;
                troopFileTransferMgr3.R = 0;
                troopFileTransferMgr3.S = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements s {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager.Item f295723a;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a implements QFileAppStorePromoteManager.f {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void a(boolean z16, AppDetail appDetail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), appDetail);
                    return;
                }
                TroopFileTransferManager.Item item = b.this.f295723a;
                item.yybApkPackageName = appDetail.packageName;
                item.yybApkName = appDetail.appName;
                item.yybApkIconUrl = appDetail.iconUrl;
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                QLog.i("TroopFileTransferMgr", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + b.this.f295723a.yybApkName + "]");
                if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
                    b bVar = b.this;
                    TroopFileTransferMgr.this.o0(bVar.f295723a, 3, 106);
                }
                ((TroopFileTransferManager) TroopFileTransferMgr.this).J.getFileManagerEngine().V().f(((TroopFileTransferManager) TroopFileTransferMgr.this).K, b.this.f295723a, null);
            }
        }

        b(TroopFileTransferManager.Item item) {
            this.f295723a = item;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferMgr.this, (Object) item);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.s
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                ((TroopFileTransferManager) TroopFileTransferMgr.this).J.getFileManagerEngine().J().g(str2, new a());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
        } else {
            V = true;
        }
    }

    public TroopFileTransferMgr(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, Long.valueOf(j3));
            return;
        }
        this.R = 0;
        this.S = 0;
        this.T = new HashMap();
        this.J = qQAppInterface;
        this.K = j3;
    }

    public static void N0(Runnable runnable, boolean z16) {
        if (U == null) {
            synchronized (TroopFileTransferMgr.class) {
                U = new Handler(Looper.getMainLooper());
            }
        }
        if (!z16 && Thread.currentThread() == U.getLooper().getThread()) {
            runnable.run();
        } else {
            U.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (str != null && str.startsWith(sDKPrivatePath)) {
            new VFSFile(str).delete();
            return;
        }
        e.b.e("TroopFileTransferMgr", e.b.f295938b, "delete file not private: " + str);
    }

    private synchronized void P0(long j3, TroopFileTransferManager.Item item) {
        if (j3 != 0 && item != null) {
            this.T.put(Long.valueOf(j3), item);
        }
    }

    private void Q0(TroopFileTransferManager.Item item, long j3, long j16) {
        TroopFileTransferManager.Item item2 = new TroopFileTransferManager.Item();
        item2.troopuin = item.troopuin;
        item2.LocalFile = item.LocalFile;
        item2.ntMsgId = j3;
        item2.ntElementId = j16;
        item2.Status = item.Status;
        this.J.getNTFileManageBridger().N0(item2, true);
        com.tencent.mobileqq.troop.filemanager.b.h(item.troopuin, item2);
        t info = item.getInfo(item.troopuin);
        info.J = j3;
        info.K = j16;
        this.J.getNTFileManageBridger().G(info.f294971e, info, j3, j16, HexUtil.bytes2HexStr(item.Md5), HexUtil.bytes2HexStr(item.Sha), item.Sha3, false);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public boolean A(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n z16 = M.z(str, str2, 0L, i3, null);
                if (z16 == null) {
                    return false;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(z16.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(z16);
                    V(item);
                }
                TroopFileDownloadMgr.g().h(this.K, item);
                return true;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public t A0(String str, boolean z16, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (t) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), bundle);
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n s16 = M.s(str);
                if (s16 == null) {
                    return null;
                }
                U();
                TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(s16);
                item.BusId = 102;
                item.isFromAIO = z16;
                item.RandomNum = i3;
                item.fromScene = k.e(bundle);
                VFSFile vFSFile = new VFSFile(str);
                if (vFSFile.exists()) {
                    item.origLastModifyTime = vFSFile.lastModified();
                }
                item.ntMsgId = NTFileUtils.g(2);
                item.ntElementId = NTFileUtils.g(2);
                V(item);
                if (FileManagerUtil.getFileType(str) == 5) {
                    ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(str, new b(item));
                } else {
                    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
                        o0(item, 3, 106);
                    }
                    this.J.getFileManagerEngine().V().f(this.K, item, null);
                }
                return item.getInfo(this.K);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public boolean B(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) uuid)).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n B = M.B(uuid);
                if (B == null) {
                    return false;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(uuid);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(B);
                    V(item);
                }
                TroopFileDownloadMgr.g().h(this.K, item);
                return true;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void B0(Collection<String> collection, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, collection, Boolean.valueOf(z16));
            return;
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
                    z17 = false;
                }
                for (String str : collection) {
                    n s16 = M.s(str);
                    if (s16 != null) {
                        U();
                        TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(s16);
                        item.BusId = 102;
                        item.isFromAIO = z16;
                        VFSFile vFSFile = new VFSFile(str);
                        if (vFSFile.exists()) {
                            item.origLastModifyTime = vFSFile.lastModified();
                        }
                        item.ntMsgId = NTFileUtils.g(2);
                        item.ntElementId = NTFileUtils.g(2);
                        V(item);
                        if (z17) {
                            o0(item, 3, 106);
                        } else {
                            this.J.getFileManagerEngine().V().f(this.K, item, null);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public boolean C(String str, String str2, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), bundle)).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                int fileType = FileManagerUtil.getFileType(q.j(str2));
                if (fileType != 0 && fileType != 2) {
                    return false;
                }
                n z16 = M.z(str, str2, 0L, i3, bundle);
                if (z16 == null) {
                    return false;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(z16.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(z16);
                    V(item);
                }
                TroopFileThumbnailMgr.j().h(this.K, item, i16);
                return true;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized boolean C0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uuid)).booleanValue();
        }
        U();
        TroopFileTransferManager.Item item = this.L.get(uuid);
        boolean z16 = false;
        if (item == null) {
            return false;
        }
        int t16 = TroopFileDownloadMgr.g().t(uuid, null);
        if (FileManagerUtil.getFileType(item.FileName) == 2 && QFileUtils.e0(this.J)) {
            g.a(item.FilePath);
            n0(item, 9);
        }
        if (t16 == 0) {
            z16 = true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public boolean D(UUID uuid, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) uuid, i3)).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n B = M.B(uuid);
                if (B == null) {
                    return false;
                }
                int fileType = FileManagerUtil.getFileType(q.j(B.f294917c));
                if (fileType != 0 && fileType != 2) {
                    return false;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(uuid);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(B);
                    V(item);
                }
                TroopFileThumbnailMgr.j().h(this.K, item, i3);
                return true;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized boolean D0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uuid)).booleanValue();
        }
        U();
        if (this.L.get(uuid) == null) {
            return false;
        }
        return this.J.getFileManagerEngine().V().c(uuid);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized TroopFileTransferManager.Item K(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopFileTransferManager.Item) iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
        return this.T.get(Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public TroopFileTransferManager.Item P(String str, String str2, long j3, int i3, Bundle bundle) {
        boolean z16;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TroopFileTransferManager.Item) iPatchRedirector.redirect((short) 13, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n z18 = M.z(str, str2, j3, i3, bundle);
                if (z18 == null) {
                    return null;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(z18.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(z18);
                    z16 = true;
                } else {
                    z16 = false;
                }
                item.FileName = str2;
                item.ProgressTotal = j3;
                item.ProgressValue = 0L;
                if (z16) {
                    V(item);
                } else {
                    if (bundle != null) {
                        j16 = bundle.getLong("TRANS_PARAM_NT_MSGID");
                        j17 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
                    } else {
                        j16 = 0;
                        j17 = 0;
                    }
                    if (item.ntMsgId == 0 && j16 != 0) {
                        item.ntMsgId = j16;
                        z17 = true;
                    }
                    if (item.ntElementId == 0 && j17 != 0) {
                        item.ntElementId = j17;
                        z17 = true;
                    }
                    if (z17) {
                        QLog.w("TroopFileTransferMgr", 1, "update troopitem:" + item.Id.toString() + " ntMsgId:" + item.ntMsgId + " ntElementId:" + item.ntElementId);
                        com.tencent.mobileqq.troop.filemanager.b.d(this.K, item);
                    }
                }
                return item;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        super.S();
        if (this.Q == null) {
            this.Q = new a();
            TroopFileDownloadMgr.g().addObserver(this.Q);
        }
        e.b.c("TroopFileTransferMgr", e.b.f295938b, "init");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if (r1.hasNext() == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        r2 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r2.Id == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
    
        com.tencent.mobileqq.troop.filemanager.e.b.b("TroopFileTransferMgr", com.tencent.mobileqq.troop.filemanager.e.b.f295938b, "entity.Id is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        if (r2.isCheckPrivateDir != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
    
        r2.isCheckPrivateDir = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        if (android.text.TextUtils.isEmpty(r2.smallThumbFile) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        r2.smallThumbFile = com.tencent.mobileqq.vfs.VFSAssistantUtils.getSDKPrivatePath(r2.smallThumbFile);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
    
        if (android.text.TextUtils.isEmpty(r2.largeThumbnailFile) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        r2.largeThumbnailFile = com.tencent.mobileqq.vfs.VFSAssistantUtils.getSDKPrivatePath(r2.largeThumbnailFile);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        if (android.text.TextUtils.isEmpty(r2.middleThumbnailFile) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r2.middleThumbnailFile = com.tencent.mobileqq.vfs.VFSAssistantUtils.getSDKPrivatePath(r2.middleThumbnailFile);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
    
        r3 = new com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item(r2);
        r6.L.put(r2.Id, r3);
        P0(r3.ntMsgId, r3);
     */
    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (this.N) {
            return;
        }
        this.N = true;
        List<TroopFileTansferItemEntity> e16 = this.J.getProxyManager().n().e(this.K);
        this.L = new ConcurrentHashMap();
        if (!V && e16 == null) {
            throw new AssertionError();
        }
        for (TroopFileTransferManager.Item item : this.L.values()) {
            int i3 = item.Status;
            if (i3 != 0 && i3 != 1) {
                if (i3 == 8) {
                    item.Status = 10;
                }
            } else {
                item.Status = 3;
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopFileTransferMgr.this.l();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, true);
        } else {
            l();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected synchronized void V(TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        this.L.put(item.Id, item);
        long j3 = item.ntMsgId;
        if (j3 != 0) {
            P0(j3, item);
        }
        if (item.troopuin == 0) {
            item.troopuin = this.K;
        }
        long j16 = item.troopuin;
        if (j16 != this.K) {
            String valueOf = String.valueOf(j16);
            String valueOf2 = String.valueOf(this.K);
            e.b.e("TroopFileTransferMgr", e.b.f295938b, "newItem troop confit. item.troopuin:" + LogUtil.wrapLogUin(valueOf) + " mTroopUin" + LogUtil.wrapLogUin(valueOf2));
            item.troopuin = this.K;
        }
        this.J.getProxyManager().n().a(item, null);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected synchronized void X(TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) item);
        } else {
            com.tencent.mobileqq.troop.filemanager.b.h(this.K, item);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        e.b.c("TroopFileTransferMgr", e.b.f295938b, "release");
        if (this.Q != null) {
            TroopFileDownloadMgr.g().deleteObserver(this.Q);
            this.Q = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized TroopFileTransferManager.Item b0(UUID uuid, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopFileTransferManager.Item) iPatchRedirector.redirect((short) 6, this, uuid, Boolean.valueOf(z16));
        }
        TroopFileTransferManager.Item remove = this.L.remove(uuid);
        if (z16 && remove != null) {
            this.J.getProxyManager().n().d(this.K, uuid);
        }
        return remove;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized boolean e0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) uuid)).booleanValue();
        }
        return f0(uuid, null);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized boolean f0(UUID uuid, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) uuid, (Object) bundle)).booleanValue();
        }
        U();
        TroopFileTransferManager.Item item = this.L.get(uuid);
        boolean z16 = false;
        if (item == null) {
            return false;
        }
        if (item.isZipInnerFile) {
            TroopFileDownloadMgr.g().q(this.K, item, bundle);
            return true;
        }
        if (TroopFileDownloadMgr.g().o(this.K, item, bundle) == 0) {
            z16 = true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized boolean g0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uuid)).booleanValue();
        }
        U();
        TroopFileTransferManager.Item item = this.L.get(uuid);
        boolean z16 = false;
        if (item == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("resend", true);
        if (this.J.getFileManagerEngine().V().f(this.K, item, bundle) == 0) {
            z16 = true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    @Deprecated
    protected synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            e.b.e("TroopFileTransferMgr", e.b.f295938b, "!!!warning: oldver fun: Interrupt be called");
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void i0(TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
        } else {
            com.tencent.mobileqq.troop.filemanager.b.d(this.K, item);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    @Deprecated
    protected synchronized boolean j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        e.b.e("TroopFileTransferMgr", e.b.f295938b, "!!!warning: oldver fun: saveStatus be called");
        return true;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected synchronized void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        U();
        for (TroopFileTransferManager.Item item : this.L.values()) {
            if (item.W2MPause == 2) {
                item.W2MPause = 0;
                Bundle bundle = new Bundle();
                int i3 = item.Status;
                if (i3 != 0 && i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 8) {
                            if (i3 == 9) {
                                bundle.putBoolean("_wifi2mobile_resume_", true);
                                if (item.isZipInnerFile) {
                                    TroopFileDownloadMgr.g().q(this.K, item, bundle);
                                } else {
                                    TroopFileDownloadMgr.g().o(this.K, item, bundle);
                                }
                            }
                        }
                    } else {
                        bundle.putBoolean("_wifi2mobile_resume_", true);
                        this.J.getFileManagerEngine().V().f(this.K, item, bundle);
                    }
                }
                item.Pausing = 0;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected synchronized void o0(TroopFileTransferManager.Item item, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, item, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            com.tencent.mobileqq.troop.filemanager.b.f(this.K, item, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public synchronized void p(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uuid);
            return;
        }
        U();
        TroopFileTransferManager.Item item = this.L.get(uuid);
        if (item == null) {
            return;
        }
        e.b.c("TroopFileTransferMgr", e.b.f295938b, "[" + uuid.toString() + "] cancelDownload");
        ThreadManagerV2.post(new Runnable(item, uuid) { // from class: com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopFileTransferManager.Item f295720d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ UUID f295721e;

            {
                this.f295720d = item;
                this.f295721e = uuid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopFileTransferMgr.this, item, uuid);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                TroopFileTransferManager.Item item2 = this.f295720d;
                switch (item2.Status) {
                    case 9:
                    case 10:
                        String str = item2.TmpFile;
                        if (str != null) {
                            TroopFileTransferMgr.this.O0(str);
                            arrayList.add(this.f295720d.TmpFile);
                            break;
                        }
                        break;
                    case 11:
                        String str2 = item2.LocalFile;
                        if (str2 != null) {
                            TroopFileTransferMgr.this.O0(str2);
                            arrayList.add(this.f295720d.LocalFile);
                            break;
                        }
                        break;
                    default:
                        return;
                }
                TroopFileTransferMgr.this.b0(this.f295721e, true);
                TroopFileTransferManager.Item item3 = this.f295720d;
                item3.StatusUpdateTimeMs = 0L;
                item3.ErrorCode = 0;
                item3.LocalFile = null;
                TroopFileTransferMgr.this.n0(item3, 7);
            }
        }, 5, null, false);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected synchronized void p0(TroopFileTransferManager.Item item, int i3, TroopFileError.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, item, Integer.valueOf(i3), bVar);
        } else {
            com.tencent.mobileqq.troop.filemanager.b.g(this.K, item, i3, bVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    protected boolean s(TroopFileTransferManager.Item item, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) item, i3)).booleanValue();
        }
        return TroopFileThumbnailMgr.e(this.K, item, i3);
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public boolean t(UUID uuid, long j3, long j16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, uuid, Long.valueOf(j3), Long.valueOf(j16), bundle)).booleanValue();
        }
        TroopFileTransferManager.Item J = J(uuid);
        if (J == null) {
            return false;
        }
        if (J.ntMsgId == 0 && j3 != 0) {
            J.ntMsgId = j3;
            z16 = true;
        }
        if (J.ntElementId == 0 && j16 != 0) {
            J.ntElementId = j16;
            z16 = true;
        }
        if (J.UploadTime == 0 && bundle != null) {
            J.UploadTime = (int) bundle.getLong("TRANS_PARAM_UPLOAD_TIME");
            z16 = true;
        }
        if (z16) {
            QLog.w("TroopFileTransferMgr", 1, "checkUpdateNtMsgAndElemId:" + uuid.toString() + " ntMsgId:" + J.ntMsgId + " ntElementId:" + J.ntElementId);
            i0(J);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public t t0(String str, long j3, String str2, String str3, long j16, int i3, int i16, long j17, Bundle bundle) {
        TroopFileTransferManager.Item J;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (t) iPatchRedirector.redirect((short) 25, this, str, Long.valueOf(j3), str2, str3, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j17), bundle);
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n d16 = M.d(str2, j16, 102, bundle);
                if (d16 == null) {
                    return null;
                }
                U();
                TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(d16);
                item.RandomNum = i16;
                item.ForwardPath = str;
                item.ForwardTroopuin = j3;
                item.ForwardBusId = i3;
                item.Status = 4;
                item.LocalFile = str3;
                item.entrySessionID = j17;
                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) com.tencent.mobileqq.filemanager.fileviewer.c.w(this.J.getMessageFacade(), String.valueOf(j3), 1, str);
                if (messageForTroopFile != null) {
                    item.width = messageForTroopFile.width;
                    item.height = messageForTroopFile.height;
                    item.yybApkPackageName = messageForTroopFile.yybApkPackageName;
                    item.yybApkName = messageForTroopFile.yybApkName;
                    item.yybApkIconUrl = messageForTroopFile.yybApkIconUrl;
                }
                TroopFileTransferManager O = TroopFileTransferManager.O(this.J, j3);
                if (O != null && messageForTroopFile != null && !TextUtils.isEmpty(messageForTroopFile.uuid) && (J = O.J(UUID.fromString(messageForTroopFile.uuid))) != null) {
                    item.largeThumbnailFile = J.largeThumbnailFile;
                    item.middleThumbnailFile = J.middleThumbnailFile;
                }
                V(item);
                if (bundle != null) {
                    z16 = bundle.getBoolean("TRANS_PARAM_NT_FLAG", false);
                }
                if (!z16) {
                    TroopFileToTroopForwarder h16 = TroopFileToTroopForwarder.h(this.K, item);
                    if (h16 == null) {
                        return null;
                    }
                    h16.g();
                }
                return item.getInfo(this.K);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void u(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) nVar);
            return;
        }
        synchronized (M()) {
            synchronized (this) {
                if (nVar == null) {
                    return;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(nVar.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(nVar);
                    V(item);
                }
                item.largeThumbnailFile = nVar.f294938x;
                item.middleThumbnailFile = nVar.f294939y;
                item.smallThumbFile = nVar.f294937w;
                i0(item);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void w0(String str, String str2, long j3, int i3, TroopFileTransferManager.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), cVar);
            return;
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                n d16 = M.d(str2, j3, 25, null);
                if (d16 == null) {
                    return;
                }
                U();
                TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(d16);
                item.ForwardPath = str;
                item.ForwardTroopuin = Long.valueOf(this.J.getCurrentAccountUin()).longValue();
                item.ForwardBusId = i3;
                item.Status = 4;
                item.BusId = 25;
                V(item);
                com.tencent.mobileqq.troop.filemanager.forward.a e16 = com.tencent.mobileqq.troop.filemanager.forward.a.e(this.K, item);
                if (e16 != null) {
                    e16.g(cVar);
                    e16.c();
                } else {
                    e.b.b("TroopFileTransferMgr", e.b.f295938b, "startCopyToWeiyun forwarder=null");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public t x0(String str, String str2, long j3, int i3, Bundle bundle) {
        boolean z16;
        long j16;
        long j17;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (t) iPatchRedirector.redirect((short) 14, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n z19 = M.z(str, str2, j3, i3, bundle);
                if (z19 == null) {
                    QLog.i("TroopFileTransferMgr", 1, "startDownload filePath:" + str + ", fileSize:" + j3 + ", busId:" + i3 + ", file null");
                    return null;
                }
                U();
                TroopFileTransferManager.Item item = this.L.get(z19.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(z19);
                    z16 = true;
                } else {
                    if (item.UploadTime == 0) {
                        item.UploadTime = z19.f();
                    }
                    int i16 = item.Status;
                    if (i16 != 7 && i16 != 10 && i16 != 9 && ((i16 != 11 || FileUtils.fileExists(z19.f294934t)) && (item.Status != 6 || FileUtils.fileExists(z19.f294934t)))) {
                        int i17 = item.Status;
                        if ((i17 == 11 || i17 == 6) && FileUtils.fileExists(z19.f294934t) && bundle != null) {
                            long j18 = bundle.getLong("TRANS_PARAM_NT_MSGID");
                            long j19 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
                            QLog.w("TroopFileTransferMgr", 1, "startDownload nt msgid/elemId is not match. item.msgid:" + item.ntMsgId + " item.elemid:" + item.ntElementId + " reqNtMsgId:" + j18 + " reqNtElementId:" + j19);
                            Q0(item, j18, j19);
                        }
                        return null;
                    }
                    z16 = false;
                }
                item.FileName = str2;
                item.ProgressTotal = j3;
                item.ProgressValue = 0L;
                if (z16) {
                    V(item);
                } else {
                    if (bundle != null) {
                        j16 = bundle.getLong("TRANS_PARAM_NT_MSGID");
                        j17 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
                    } else {
                        j16 = 0;
                        j17 = 0;
                    }
                    if (j16 != 0) {
                        item.ntMsgId = j16;
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (j17 != 0) {
                        item.ntElementId = j17;
                        z18 = true;
                    } else {
                        z18 = z17;
                    }
                    if (z18) {
                        QLog.w("TroopFileTransferMgr", 1, "update troopitem:" + item.Id.toString() + " ntMsgId:" + item.ntMsgId + " ntElementId:" + item.ntElementId);
                        com.tencent.mobileqq.troop.filemanager.b.d(this.K, item);
                    }
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopFileTransferMgr", 4, "startDownload, fileName:" + str2 + ", status:" + item.Status + ", filePath:" + str);
                }
                if (FileManagerUtil.getFileType(item.FileName) == 2 && QFileUtils.e0(this.J)) {
                    g.b(new i(item.getInfo(this.K))).startDownload();
                } else {
                    TroopFileDownloadMgr.g().o(this.K, item, bundle);
                }
                String j26 = q.j(str2);
                ReportController.o(this.J, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", this.K + "", j26, "");
                return item.getInfo(this.K);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void y(TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) item);
            return;
        }
        TroopFileUploadFeedsSender b16 = TroopFileUploadFeedsSender.b(this.K, item);
        if (b16 != null) {
            b16.c();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public int y0(FileManagerEntity fileManagerEntity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileManagerEntity)).intValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                n z17 = M.z(fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId, null);
                if (z17 == null) {
                    return -1;
                }
                z17.f294915a = UUID.fromString(fileManagerEntity.strTroopFileID);
                U();
                TroopFileTransferManager.Item item = this.L.get(z17.f294915a);
                if (item == null) {
                    item = new TroopFileTransferManager.Item(z17);
                    z16 = true;
                } else {
                    if (FileManagerUtil.fileExist(item.LocalFile) && item.Status != 7) {
                        return -2;
                    }
                    z16 = false;
                }
                item.FileName = fileManagerEntity.fileName;
                item.ProgressTotal = fileManagerEntity.fileSize;
                item.ProgressValue = 0L;
                item.isZipInnerFile = true;
                item.zipType = fileManagerEntity.zipType;
                item.zipBusId = fileManagerEntity.busId;
                item.zipInnerPath = fileManagerEntity.zipInnerPath;
                item.zipFilePath = fileManagerEntity.zipFilePath;
                if (z16) {
                    V(item);
                }
                QLog.i("TroopFileTransferMgr", 1, "<TroopFile> [" + item.Id.toString() + "] startDownloadZipInnerFile strTroopFilePath. " + fileManagerEntity.strTroopFilePath + " zipFilePath:" + fileManagerEntity.zipFilePath + " zipInnerPath:" + fileManagerEntity.zipInnerPath + " zipFileId:" + fileManagerEntity.zipFileId + " busId:" + fileManagerEntity.busId);
                TroopFileDownloadMgr.g().q(this.K, item, null);
                return 0;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    @Deprecated
    protected void z(TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) item);
        } else {
            e.b.e("TroopFileTransferMgr", e.b.f295938b, "!!!warning: oldver fun: doReqUpload be called");
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager
    public void z0(List<t> list) {
        n d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            TroopFileManager M = M();
            synchronized (M) {
                synchronized (this) {
                    U();
                    ArrayList arrayList = new ArrayList();
                    for (t tVar : list) {
                        if (!TextUtils.isEmpty(tVar.f294985s) && (d16 = M.d(tVar.f294987u, tVar.f294976j, 25, null)) != null) {
                            TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(d16);
                            V(item);
                            item.ForwardPath = tVar.f294985s;
                            item.ForwardTroopuin = Long.valueOf(this.J.getCurrentAccountUin()).longValue();
                            item.ForwardBusId = tVar.f294988v;
                            item.Status = 4;
                            item.BusId = 25;
                            arrayList.add(item);
                        }
                    }
                    if (arrayList.size() == 0) {
                        return;
                    }
                    com.tencent.mobileqq.troop.filemanager.forward.b c16 = com.tencent.mobileqq.troop.filemanager.forward.b.c(this.K, arrayList);
                    if (c16 != null) {
                        c16.b();
                    } else {
                        e.b.b("TroopFileTransferMgr", e.b.f295938b, "startMultiCopyToWeiyun forwarder=null");
                    }
                }
            }
        }
    }
}
