package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.w;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208304a;

    /* renamed from: b, reason: collision with root package name */
    private FileManagerEntity f208305b;

    /* renamed from: c, reason: collision with root package name */
    private List<j> f208306c;

    /* renamed from: d, reason: collision with root package name */
    private j f208307d;

    /* renamed from: e, reason: collision with root package name */
    private int f208308e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f208309f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f208310g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements FileBrowserManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f208311a;

        a(BaseActivity baseActivity) {
            this.f208311a = baseActivity;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.e
        public FileBrowserModelBase a() {
            List<j> d16;
            int f16;
            int g16 = e.this.g();
            if (g16 != 1) {
                if (g16 != 2) {
                    f16 = 0;
                    if (g16 != 3) {
                        d16 = null;
                    } else {
                        d16 = new ArrayList<>(1);
                        d16.add(e.this.c());
                    }
                } else {
                    d16 = e.this.d();
                    f16 = e.this.f();
                }
            } else {
                d16 = e.this.d();
                f16 = e.this.f();
            }
            if (d16 == null || d16.size() <= 0) {
                return null;
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "fileAdapterList " + d16.size() + " ,fileIndex " + f16);
            j jVar = d16.get(f16);
            int v3 = jVar.v();
            int b16 = jVar.b();
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getFileModelCreater, fileCloudType " + v3 + ", filePeerType " + b16);
            if (v3 == 7) {
                return null;
            }
            if (v3 == 9) {
                return new DocsExportFileModel(e.this.f208304a, this.f208311a, d16, f16);
            }
            if (v3 == 13) {
                return new com.tencent.mobileqq.filemanager.fileviewer.model.c(e.this.f208304a, this.f208311a, d16, f16);
            }
            if (b16 != 6000 && b16 != 6003) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getFileModelCreater \u6570\u636e\u7ebf\uff1f");
                return new C2CFileModel(e.this.f208304a, this.f208311a, d16, f16);
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getFileModelCreater \u6570\u636e\u7ebf\uff1f");
            return new com.tencent.mobileqq.filemanager.fileviewer.model.a(e.this.f208304a, this.f208311a, d16, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(QQAppInterface qQAppInterface) {
        this.f208304a = qQAppInterface;
    }

    private FileManagerEntity b(WeiYunFileInfo weiYunFileInfo) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.WeiYunDirKey = weiYunFileInfo.f209604e;
        fileManagerEntity.WeiYunFileId = weiYunFileInfo.f209603d;
        fileManagerEntity.fileName = weiYunFileInfo.f209605f;
        fileManagerEntity.strLargeThumPath = weiYunFileInfo.E;
        fileManagerEntity.strFileSHA = weiYunFileInfo.J;
        fileManagerEntity.strFileMd5 = weiYunFileInfo.I;
        long j3 = weiYunFileInfo.f209607i;
        fileManagerEntity.lastTime = j3;
        fileManagerEntity.srvTime = j3;
        fileManagerEntity.fileSize = weiYunFileInfo.f209606h;
        fileManagerEntity.nFileType = 0;
        fileManagerEntity.cloudType = 2;
        return fileManagerEntity;
    }

    protected static boolean h(int i3, int i16) {
        if (i3 != 0 || i16 == 0) {
            return false;
        }
        return true;
    }

    public j c() {
        return this.f208307d;
    }

    public List<j> d() {
        return this.f208306c;
    }

    public FileBrowserManager.e e(BaseActivity baseActivity) {
        return new a(baseActivity);
    }

    public int f() {
        return this.f208308e;
    }

    public int g() {
        return this.f208309f;
    }

    public boolean i(Intent intent) {
        List<j> list;
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        if (forwardFileInfo == null) {
            return false;
        }
        long n3 = forwardFileInfo.n();
        FileManagerEntity D = this.f208304a.getFileManagerDataCenter().D(n3);
        this.f208305b = D;
        if (D == null) {
            if (forwardFileInfo.c() == 9) {
                this.f208305b = w.a(forwardFileInfo);
            } else {
                WeiYunFileInfo u16 = forwardFileInfo.u();
                if (u16 != null) {
                    this.f208305b = b(u16);
                }
            }
        }
        FileManagerEntity fileManagerEntity = this.f208305b;
        if (fileManagerEntity == null) {
            QLog.e("FileViewerParamParser", 1, "FileViewerParamParsernot found, bug. sessionid:" + String.valueOf(n3));
            return false;
        }
        if (5 != fileManagerEntity.cloudType) {
            FileManagerUtil.associateLocalWithCloud(fileManagerEntity);
        }
        FileManagerEntity fileManagerEntity2 = this.f208305b;
        if (h(fileManagerEntity2.nFileType, fileManagerEntity2.getCloudType())) {
            boolean l3 = l(intent, forwardFileInfo);
            if (!l3 && (((list = this.f208306c) == null || list.size() <= 0) && this.f208305b != null)) {
                ArrayList arrayList = new ArrayList();
                this.f208306c = arrayList;
                this.f208308e = 0;
                arrayList.add(d.f(this.f208304a, this.f208305b));
                return true;
            }
            return l3;
        }
        this.f208307d = d.f(this.f208304a, this.f208305b);
        this.f208309f = 3;
        return true;
    }

    protected boolean j(Intent intent) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("Aio_Uinseq_ImageList");
        int i3 = 0;
        if (stringArrayListExtra == null) {
            return false;
        }
        this.f208306c = new ArrayList();
        Iterator<String> it = stringArrayListExtra.iterator();
        while (it.hasNext()) {
            long parseLong = Long.parseLong(it.next());
            FileManagerDataCenter fileManagerDataCenter = this.f208304a.getFileManagerDataCenter();
            FileManagerEntity fileManagerEntity = this.f208305b;
            FileManagerEntity C = fileManagerDataCenter.C(parseLong, fileManagerEntity.peerUin, fileManagerEntity.peerType, -1L);
            if (C != null) {
                if (C.nSessionId == this.f208305b.nSessionId) {
                    this.f208308e = i3;
                } else if (!h(C.nFileType, C.getCloudType())) {
                }
                i3++;
                this.f208306c.add(d.f(this.f208304a, C));
            }
        }
        return true;
    }

    protected boolean k(Intent intent) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("Aio_SessionId_ImageList");
        int i3 = 0;
        if (stringArrayListExtra == null) {
            return false;
        }
        this.f208306c = new ArrayList();
        Iterator<String> it = stringArrayListExtra.iterator();
        while (it.hasNext()) {
            FileManagerEntity C = this.f208304a.getFileManagerDataCenter().C(0L, "", 0, Long.parseLong(it.next()));
            if (C != null) {
                if (C.nSessionId == this.f208305b.nSessionId) {
                    this.f208308e = i3;
                } else if (!h(C.nFileType, C.getCloudType())) {
                }
                i3++;
                this.f208306c.add(d.f(this.f208304a, C));
            }
        }
        return true;
    }

    protected boolean l(Intent intent, ForwardFileInfo forwardFileInfo) {
        boolean m3;
        if (intent.getBooleanExtra("is_in_zip", false)) {
            m3 = r(forwardFileInfo);
        } else {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "parseImageGallery " + forwardFileInfo.getType());
            switch (forwardFileInfo.getType()) {
                case 10000:
                case 10006:
                    m3 = m(intent);
                    break;
                case 10001:
                    m3 = o();
                    break;
                case 10002:
                    if (QLog.isDevelopLevel()) {
                        QLog.w("FileViewerParamParser", 4, "parseImageGallery: not support OfflineFile type");
                    }
                    m3 = false;
                    break;
                case 10003:
                    m3 = q(intent);
                    break;
                case 10004:
                    m3 = j(intent);
                    break;
                case 10005:
                case 10008:
                default:
                    if (QLog.isDevelopLevel()) {
                        QLog.w("FileViewerParamParser", 4, "parseImageGallery: type[" + forwardFileInfo.getType() + "] is not implemented");
                    }
                    m3 = false;
                    break;
                case 10007:
                    m3 = p();
                    break;
                case 10009:
                    m3 = k(intent);
                    break;
                case 10010:
                    m3 = n();
                    break;
            }
        }
        this.f208309f = 1;
        if (!m3) {
            QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + forwardFileInfo.getType() + "] return false");
        } else if (this.f208306c.size() == 0) {
            QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + forwardFileInfo.getType() + "] list is empty");
            return false;
        }
        return m3;
    }

    protected boolean m(Intent intent) {
        ArrayList<FileInfo> fileViewerLocalFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getFileViewerLocalFiles();
        boolean z16 = false;
        if (fileViewerLocalFiles == null || fileViewerLocalFiles.size() == 0) {
            return false;
        }
        int intExtra = intent.getIntExtra("clicked_file_hashcode", 0);
        this.f208306c = new ArrayList();
        Iterator<FileInfo> it = fileViewerLocalFiles.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (!z16 && next.hashCode() == intExtra) {
                this.f208308e = i3;
                this.f208306c.add(d.f(this.f208304a, this.f208305b));
                z16 = true;
            } else {
                this.f208306c.add(d.h(next));
            }
            i3++;
        }
        ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).clearFileViewerLocalFiles();
        return true;
    }

    protected boolean n() {
        String str;
        List<FileManagerEntity> t16 = this.f208304a.getFileManagerProxy().t();
        int i3 = 0;
        if (t16 == null || t16.size() == 0) {
            return false;
        }
        this.f208306c = new ArrayList();
        for (FileManagerEntity fileManagerEntity : t16) {
            if (5 == fileManagerEntity.getCloudType() && this.f208305b.nOlSenderProgress == fileManagerEntity.nOlSenderProgress && ((str = this.f208310g) == null || str.trim().length() == 0 || this.f208310g.equals(fileManagerEntity.peerUin))) {
                if (fileManagerEntity.nSessionId == this.f208305b.nSessionId) {
                    this.f208308e = i3;
                } else if (!h(fileManagerEntity.nFileType, fileManagerEntity.getCloudType())) {
                }
                i3++;
                this.f208306c.add(d.f(this.f208304a, fileManagerEntity));
            }
        }
        return true;
    }

    protected boolean o() {
        List<FileManagerEntity> t16 = this.f208304a.getFileManagerProxy().t();
        int i3 = 0;
        if (t16 == null || t16.size() == 0) {
            return false;
        }
        this.f208306c = new ArrayList();
        for (FileManagerEntity fileManagerEntity : t16) {
            String str = this.f208310g;
            if (str == null || str.trim().length() == 0 || this.f208310g.equals(fileManagerEntity.peerUin)) {
                if (fileManagerEntity.nSessionId == this.f208305b.nSessionId) {
                    this.f208308e = i3;
                } else if (!h(fileManagerEntity.nFileType, fileManagerEntity.getCloudType())) {
                }
                i3++;
                this.f208306c.add(d.f(this.f208304a, fileManagerEntity));
            }
        }
        return true;
    }

    protected boolean p() {
        ArrayList<FileManagerEntity> recentFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getRecentFiles();
        Set<FileInfo> localFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
        ArrayList<WeiYunFileInfo> weiYunFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles();
        this.f208306c = new ArrayList();
        if (recentFiles != null && recentFiles.size() > 0) {
            Iterator<FileManagerEntity> it = recentFiles.iterator();
            while (it.hasNext()) {
                FileManagerEntity next = it.next();
                if (next.nFileType == 0) {
                    this.f208306c.add(d.f(this.f208304a, next));
                }
            }
        }
        if (localFiles != null && localFiles.size() > 0) {
            for (FileInfo fileInfo : localFiles) {
                if (fileInfo.getType() == 0) {
                    this.f208306c.add(d.h(fileInfo));
                }
            }
        }
        if (weiYunFiles != null && weiYunFiles.size() > 0) {
            Iterator<WeiYunFileInfo> it5 = weiYunFiles.iterator();
            while (it5.hasNext()) {
                WeiYunFileInfo next2 = it5.next();
                if (FileManagerUtil.getFileType(next2.f209605f) == 0) {
                    this.f208306c.add(d.g(this.f208304a, next2));
                }
            }
        }
        if (this.f208306c.size() > 0) {
            return true;
        }
        return false;
    }

    protected boolean q(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("local_weiyun_list");
        int i3 = 0;
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            return false;
        }
        this.f208306c = new ArrayList();
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) it.next();
            String str = weiYunFileInfo.f209603d;
            if (str != null && str.equalsIgnoreCase(this.f208305b.WeiYunFileId)) {
                this.f208308e = i3;
            } else if (FileManagerUtil.getFileType(weiYunFileInfo.f209605f) != 0) {
                if (weiYunFileInfo.K && weiYunFileInfo.f209605f.toLowerCase().endsWith("heic")) {
                }
            }
            i3++;
            this.f208306c.add(d.g(this.f208304a, weiYunFileInfo));
        }
        return true;
    }

    protected boolean r(ForwardFileInfo forwardFileInfo) {
        ArrayList<Long> o16 = forwardFileInfo.o();
        this.f208306c = new ArrayList();
        Iterator<Long> it = o16.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            FileManagerEntity M = this.f208304a.getFileManagerDataCenter().M(it.next().longValue());
            if (M != null) {
                if (q.f(M.getFilePath())) {
                    M.status = 1;
                }
                if (M.nSessionId == this.f208305b.nSessionId) {
                    this.f208308e = i3;
                } else if (!h(M.nFileType, M.getCloudType())) {
                }
                i3++;
                this.f208306c.add(d.f(this.f208304a, M));
            }
        }
        return true;
    }

    public void s(String str) {
        this.f208310g = str;
    }
}
