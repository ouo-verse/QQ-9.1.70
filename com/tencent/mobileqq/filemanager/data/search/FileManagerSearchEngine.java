package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntitySearchPCPart;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeAuthenticationType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeFileType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeType;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import com.tencent.qqnt.kernel.nativeinterface.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerSearchEngine implements on2.b<c> {
    static int E;

    /* renamed from: d, reason: collision with root package name */
    AppInterface f207850d;

    /* renamed from: e, reason: collision with root package name */
    int f207851e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f207852f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    ArrayList<c> f207853h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    int f207854i = 0;

    /* renamed from: m, reason: collision with root package name */
    IKernelFileBridgeClientListener f207855m = new a();
    private long C = 0;
    private SearchRunnable D = new SearchRunnable();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        pn2.a f207856d;

        /* renamed from: e, reason: collision with root package name */
        on2.d<c> f207857e;

        SearchRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn2.a aVar;
            pn2.a aVar2;
            try {
                aVar = this.f207856d;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (aVar == null) {
                this.f207857e.onFinish(new ArrayList(), 6);
                return;
            }
            String str = aVar.f426495a;
            if (FileManagerSearchEngine.this.h()) {
                String str2 = "";
                Bundle bundle = aVar.f426496b;
                if (bundle != null) {
                    str2 = bundle.getString("search_pc_file_id");
                }
                FileManagerSearchEngine.this.C = FileManagerSearchEngine.f();
                if (QLog.isColorLevel()) {
                    QLog.d("FileManagerSearchEngine", 2, "searchFolderForFiles. sessionId: " + FileManagerSearchEngine.this.C + ", pcFileId: " + str2 + ", keyword: " + aVar.f426495a);
                }
                synchronized (this) {
                    ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().searchFolderForFiles(FileManagerSearchEngine.this.C, str2, aVar.f426495a);
                }
                return;
            }
            List<c> a16 = FileManagerSearchEngine.this.a(aVar);
            synchronized (this) {
                if (this.f207857e != null && aVar == (aVar2 = this.f207856d) && str.equals(aVar2.f426495a)) {
                    this.f207857e.onFinish(a16, 1);
                }
            }
            return;
            e16.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements IKernelFileBridgeClientListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7551a implements IOperateCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207859a;

            C7551a(String str) {
                this.f207859a = str;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                if (i3 != 0) {
                    FileManagerSearchEngine.this.f207852f.remove(this.f207859a);
                }
            }
        }

        a() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onAuthenticationSuccess(FileBridgeAuthenticationType fileBridgeAuthenticationType) {
            ah.a(this, fileBridgeAuthenticationType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType) {
            ah.b(this, wiFiPhotoConnectionType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onDisconnected(int i3) {
            ah.c(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onFileDownloadComplete(String str, int i3, String str2) {
            ah.d(this, str, i3, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onFileDownloadProgress(String str, long j3, long j16) {
            ah.e(this, str, j3, j16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onFileDownloadSpeed(String str, long j3) {
            ah.f(this, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onFileDownloadStateChange(String str, FileBridgeDownloadState fileBridgeDownloadState) {
            ah.g(this, str, fileBridgeDownloadState);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedHostSetPassword() {
            ah.h(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedShowDownloadCompleteToast() {
            ah.i(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedUserInputPassword() {
            ah.j(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onReconnecting() {
            ah.k(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public void onSearchFolderForFiles(long j3, int i3, ArrayList<FileBridgeNodeInfo> arrayList) {
            boolean z16;
            if (FileManagerSearchEngine.this.D.f207857e != null && j3 == FileManagerSearchEngine.this.C) {
                FileManagerSearchEngine.this.f207852f.clear();
                FileManagerSearchEngine.this.f207853h.clear();
                FileManagerSearchEngine.this.f207854i = i3;
                if (arrayList != null) {
                    QLog.d("FileManagerSearchEngine", 2, "onSearchFolderForFiles. sessionId: " + j3 + ", code: " + i3 + ", content.size: " + arrayList.size());
                    Iterator<FileBridgeNodeInfo> it = arrayList.iterator();
                    int i16 = 0;
                    while (it.hasNext()) {
                        FileBridgeNodeInfo next = it.next();
                        i16++;
                        c cVar = new c();
                        ArrayList arrayList2 = new ArrayList();
                        FileManagerEntity fileManagerEntity = new FileManagerEntity();
                        FileManagerEntitySearchPCPart fileManagerEntitySearchPCPart = fileManagerEntity.searchPCPart;
                        fileManagerEntitySearchPCPart.f207685a = next.fileId;
                        if (next.nodeType == FileBridgeNodeType.KDIRECTORY) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        fileManagerEntitySearchPCPart.f207687c = z16;
                        fileManagerEntity.nFileType = next.fileType.ordinal();
                        fileManagerEntity.searchPCPart.f207688d = next.dirType.ordinal();
                        fileManagerEntity.fileName = next.name;
                        fileManagerEntity.fileSize = next.fileSize;
                        FileManagerEntitySearchPCPart fileManagerEntitySearchPCPart2 = fileManagerEntity.searchPCPart;
                        fileManagerEntitySearchPCPart2.f207686b = next.creationTime;
                        fileManagerEntity.lastTime = next.lastModificationTime;
                        fileManagerEntitySearchPCPart2.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KNULL;
                        FileBridgeDownloadState fileBridgeDownloadState = next.downloadState;
                        if (fileBridgeDownloadState == FileBridgeDownloadState.KDOWNLOADING) {
                            fileManagerEntitySearchPCPart2.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KDOWNLOADING;
                        } else if (fileBridgeDownloadState == FileBridgeDownloadState.KCOMPLETE) {
                            fileManagerEntitySearchPCPart2.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KCOMPLETE;
                        } else if (fileBridgeDownloadState == FileBridgeDownloadState.KFAILED) {
                            fileManagerEntitySearchPCPart2.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KFAILED;
                        } else if (fileBridgeDownloadState == FileBridgeDownloadState.KWAITING) {
                            fileManagerEntitySearchPCPart2.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KDOWNLOADING;
                        }
                        fileManagerEntitySearchPCPart2.f207690f = next.downloadProgress;
                        fileManagerEntitySearchPCPart2.f207691g = next.downloadSpeed;
                        fileManagerEntity.strFilePath = next.localSavePath;
                        FileBridgeFileType fileBridgeFileType = next.fileType;
                        if (fileBridgeFileType == FileBridgeFileType.KPIC || fileBridgeFileType == FileBridgeFileType.KVIDEO) {
                            FileManagerSearchEngine.this.f207852f.add(next.fileId);
                        }
                        arrayList2.add(fileManagerEntity);
                        if (QLog.isColorLevel()) {
                            QLog.d("FileManagerSearchEngine", 2, "onSearchFolderForFiles. sessionId: " + j3 + ", code: " + i3 + ", idx: " + i16 + ", filename: " + next.name + ", fileid: " + next.fileId + ", nodeType: " + next.nodeType + ", fileType: " + next.fileType + ", dirType: " + next.dirType + ", fileSize: " + next.fileSize + ", pathOnDesktop: " + next.pathOnDesktop + ", creationTime: " + next.creationTime + ", lastModificationTime: " + next.lastModificationTime + ", downloadState: " + next.downloadState + ", downloadProgress: " + next.downloadProgress + ", downloadSpeed: " + next.downloadSpeed + ", localSavePath: " + next.localSavePath);
                        }
                        cVar.G.addAll(arrayList2);
                        cVar.H = FileManagerSearchEngine.this.D.f207856d.f426495a;
                        cVar.K = FileManagerSearchEngine.this.f207851e;
                        cVar.H();
                        FileManagerSearchEngine.this.f207853h.add(cVar);
                    }
                } else {
                    QLog.e("FileManagerSearchEngine", 1, "onSearchFolderForFiles. sessionId: " + j3 + ", code: " + i3);
                }
                if (FileManagerSearchEngine.this.f207852f.size() == 0) {
                    synchronized (this) {
                        if (FileManagerSearchEngine.this.D.f207857e != null) {
                            on2.d<c> dVar = FileManagerSearchEngine.this.D.f207857e;
                            FileManagerSearchEngine fileManagerSearchEngine = FileManagerSearchEngine.this;
                            dVar.onFinish(fileManagerSearchEngine.f207853h, fileManagerSearchEngine.f207854i);
                        }
                    }
                    return;
                }
                ThumbConfig thumbConfig = new ThumbConfig(0, 0, 0, 1);
                Iterator<String> it5 = FileManagerSearchEngine.this.f207852f.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().getThumbnail(false, next2, thumbConfig, new C7551a(next2));
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onStateChange(FileBridgeClientState fileBridgeClientState) {
            ah.m(this, fileBridgeClientState);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public void onThumbDownloadComplete(String str, int i3, String str2) {
            if (i3 == 0) {
                Iterator<c> it = FileManagerSearchEngine.this.f207853h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next.G.get(0).searchPCPart.f207685a.equals(str)) {
                        next.G.get(0).strThumbPath = str2;
                        break;
                    }
                }
            }
            FileManagerSearchEngine.this.f207852f.remove(str);
            if (FileManagerSearchEngine.this.f207852f.size() == 0) {
                synchronized (this) {
                    if (FileManagerSearchEngine.this.D.f207857e != null) {
                        on2.d<c> dVar = FileManagerSearchEngine.this.D.f207857e;
                        FileManagerSearchEngine fileManagerSearchEngine = FileManagerSearchEngine.this;
                        dVar.onFinish(fileManagerSearchEngine.f207853h, fileManagerSearchEngine.f207854i);
                    }
                }
            }
        }
    }

    public FileManagerSearchEngine(AppInterface appInterface, int i3) {
        this.f207851e = -1;
        this.f207850d = appInterface;
        this.f207851e = i3;
    }

    static /* bridge */ /* synthetic */ long f() {
        return g();
    }

    private static long g() {
        E = (E + 1) % 1000;
        return (System.currentTimeMillis() * 1000) + E;
    }

    @Override // on2.b
    public List<c> a(pn2.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerSearchEngine", 2, "start search " + aVar);
        }
        Map<String, List<FileManagerEntity>> T = ((QQAppInterface) this.f207850d).getFileManagerDataCenter().T(aVar.f426495a);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = T.keySet().iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            c cVar = new c();
            List<FileManagerEntity> list = T.get(next);
            ArrayList arrayList2 = new ArrayList();
            for (FileManagerEntity fileManagerEntity : list) {
                if (!fileManagerEntity.bDelInFM) {
                    arrayList2.add(fileManagerEntity);
                    if (fileManagerEntity.nFileType == 13) {
                        z16 = true;
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                if (z16) {
                    int i3 = this.f207851e;
                    if (i3 == 1) {
                        ReportController.o(this.f207850d, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
                    } else if (i3 == 8) {
                        ReportController.o(this.f207850d, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
                    }
                }
                cVar.G.addAll(arrayList2);
                cVar.H = aVar.f426495a;
                cVar.K = this.f207851e;
                cVar.H();
                arrayList.add(cVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerSearchEngine", 2, "search finish keyword=", aVar.f426495a, " result=", arrayList);
        }
        return arrayList;
    }

    @Override // on2.b
    public void c(pn2.a aVar, on2.d<c> dVar) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerSearchEngine", 2, "searchAsync " + aVar);
        }
        if (aVar != null && (str = aVar.f426495a) != null && !TextUtils.isEmpty(str.trim())) {
            synchronized (this.D) {
                SearchRunnable searchRunnable = this.D;
                searchRunnable.f207856d = aVar;
                searchRunnable.f207857e = dVar;
                ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
                ThreadManagerV2.executeOnFileThread(this.D);
            }
        }
    }

    @Override // on2.b
    public void cancel() {
        synchronized (this.D) {
            if (this.D.f207857e != null) {
                if (h()) {
                    QLog.d("FileManagerSearchEngine", 2, "cancelSearchFolderForFiles. sessionId: " + this.C);
                    ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().cancelSearchFolderForFiles(this.C);
                }
                SearchRunnable searchRunnable = this.D;
                searchRunnable.f207856d = null;
                searchRunnable.f207857e = null;
                ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
            }
        }
    }

    @Override // on2.b
    public void destroy() {
        if (h()) {
            ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().I0(this.f207855m);
        }
    }

    protected boolean h() {
        int i3 = this.f207851e;
        if (i3 != 22 && i3 != 23) {
            return false;
        }
        return true;
    }

    @Override // on2.b
    public void init() {
        ((QQAppInterface) this.f207850d).getFileManagerProxy().init();
        if (h()) {
            ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().addKernelFileBridgeClientListener(this.f207855m);
        }
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
