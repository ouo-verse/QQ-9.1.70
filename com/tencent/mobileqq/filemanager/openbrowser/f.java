package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.k;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.n;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.depend.RichMediaDownloadType;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class f implements com.tencent.mobileqq.richmedia.depend.f, com.tencent.mobileqq.richmedia.depend.d, com.tencent.mobileqq.richmedia.depend.a {

    /* renamed from: d, reason: collision with root package name */
    protected final QQAppInterface f209026d;

    /* renamed from: e, reason: collision with root package name */
    protected List<RichMediaBrowserInfo> f209027e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    protected List<RFWLayerItemMediaInfo> f209028f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    protected ConcurrentHashMap<String, RichMediaDownloadType> f209029h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    protected int f209030i = 0;

    /* renamed from: m, reason: collision with root package name */
    protected final List<j> f209031m = new ArrayList();
    protected final Map<String, Integer> C = new HashMap();
    protected final ArrayList<Long> D = new ArrayList<>();
    protected FMObserver E = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void A0(n nVar, int i3) {
            RichMediaDownloadType richMediaDownloadType;
            String valueOf = String.valueOf(nVar.f207834e);
            if (!f.this.C.containsKey(valueOf)) {
                return;
            }
            int intValue = f.this.C.get(valueOf).intValue();
            FileManagerEntity D = f.this.f209026d.getFileManagerDataCenter().D(nVar.f207834e);
            if (D == null) {
                QLog.i("MediaFileBrowseProcessorBase", 2, "onThumbDownLoadProgress: error, entity[" + nVar.f207834e + "] is null");
                return;
            }
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = f.this.f209028f.get(intValue);
            if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = f.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).K8(rFWLayerItemMediaInfo.getMediaId(), i3, D.fileSize, richMediaDownloadType);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void B0(n nVar) {
            RichMediaDownloadType richMediaDownloadType;
            String valueOf = String.valueOf(nVar.f207834e);
            if (!f.this.C.containsKey(valueOf)) {
                return;
            }
            int intValue = f.this.C.get(valueOf).intValue();
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = f.this.f209028f.get(intValue);
            if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = f.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(rFWLayerItemMediaInfo.getMediaId(), true, nVar.f207833d, richMediaDownloadType);
                f.this.f209029h.remove(rFWLayerItemMediaInfo.getMediaId());
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            RichMediaDownloadType richMediaDownloadType;
            RichMediaDownloadType richMediaDownloadType2;
            RichMediaDownloadType richMediaDownloadType3;
            if (!f.this.C.containsKey(String.valueOf(j16))) {
                return;
            }
            int intValue = f.this.C.get(String.valueOf(j16)).intValue();
            FileManagerEntity D = f.this.f209026d.getFileManagerDataCenter().D(j16);
            if (D == null) {
                QLog.i("MediaFileBrowseProcessorBase", 2, "onFileTransferEnd: error, entity[" + j16 + "] is null");
                return;
            }
            QLog.e("MediaFileBrowseProcessorBase", 1, "onFileTransferEnd sessionId:" + j16 + ", isSuccess:" + z16);
            if (z16) {
                int i17 = D.nFileType;
                if (i17 == 0) {
                    com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo = f.this.f209028f.get(intValue);
                    if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType3 = f.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                        ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(rFWLayerItemMediaInfo.getMediaId(), true, D.getFilePath(), richMediaDownloadType3);
                        f.this.f209029h.remove(rFWLayerItemMediaInfo.getMediaId());
                        return;
                    }
                    return;
                }
                if (i17 == 2) {
                    if (f.this.D.contains(Long.valueOf(j3))) {
                        Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                        if (baseContext != null) {
                            FileManagerUtil.saveToAlbum(baseContext, D.getFilePath());
                        } else {
                            QLog.i("MediaFileBrowseProcessorBase<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
                        }
                        f.this.D.remove(Long.valueOf(j3));
                    }
                    com.tencent.mobileqq.richmedia.depend.c d17 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = f.this.f209028f.get(intValue);
                    if (rFWLayerItemMediaInfo2 != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo2.getMediaId()) && (d17 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType2 = f.this.f209029h.get(rFWLayerItemMediaInfo2.getMediaId())) != null) {
                        ((com.tencent.mobileqq.richmedia.depend.b) d17).I7(rFWLayerItemMediaInfo2.getMediaId(), true, D.getFilePath(), richMediaDownloadType2);
                        f.this.f209029h.remove(rFWLayerItemMediaInfo2.getMediaId());
                        return;
                    }
                    return;
                }
                return;
            }
            if (i16 == -7003 || i16 == -6101) {
                D.status = 16;
            }
            int i18 = D.nFileType;
            if (i18 == 0) {
                com.tencent.mobileqq.richmedia.depend.c d18 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = f.this.f209028f.get(intValue);
                if (rFWLayerItemMediaInfo3 != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo3.getMediaId()) && (d18 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = f.this.f209029h.get(rFWLayerItemMediaInfo3.getMediaId())) != null) {
                    ((com.tencent.mobileqq.richmedia.depend.b) d18).I7(rFWLayerItemMediaInfo3.getMediaId(), false, "", richMediaDownloadType);
                    f.this.f209029h.remove(rFWLayerItemMediaInfo3.getMediaId());
                    return;
                }
                return;
            }
            if (i18 == 2) {
                mb1.a.f416517a.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean z16, long j3, long j16, String str, int i3) {
            RichMediaDownloadType richMediaDownloadType;
            if (!f.this.C.containsKey(String.valueOf(j16))) {
                return;
            }
            FileManagerEntity D = f.this.f209026d.getFileManagerDataCenter().D(j16);
            if (D == null) {
                QLog.i("MediaFileBrowseProcessorBase", 2, "OnFileTransferProgress: error, entity[" + j16 + "] is null");
                return;
            }
            int intValue = f.this.C.get(String.valueOf(j16)).intValue();
            if (D.nFileType == 0) {
                com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = f.this.f209028f.get(intValue);
                if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = f.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                    ((com.tencent.mobileqq.richmedia.depend.b) d16).K8(rFWLayerItemMediaInfo.getMediaId(), D.fProgress, D.fileSize, richMediaDownloadType);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements com.tencent.mobileqq.filemanager.core.i {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.data.b f209033d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f209034e;

        b(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar, String str) {
            this.f209033d = bVar;
            this.f209034e = str;
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void m(SuperPlayerVideoInfo superPlayerVideoInfo) {
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            if (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) {
                ArrayList<String> cookie = superPlayerVideoInfo.getCookie();
                Bundle bundle = new Bundle();
                bundle.putString("savepath", superPlayerVideoInfo.getLocalSavePath());
                bundle.putStringArrayList("cookies", cookie);
                bundle.putString("contextid", this.f209033d.a());
                bundle.putString(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, superPlayerVideoInfo.getFileId());
                ((com.tencent.mobileqq.richmedia.depend.b) d16).p9(this.f209034e, true, superPlayerVideoInfo.getLocalSavePath(), new ArrayList<>(Arrays.asList(superPlayerVideoInfo.getPlayUrls())), "");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void p(int i3, String str) {
            QLog.e("MediaFileBrowseProcessorBase", 1, "getFileVideoUrl onDownloadInfoError, errCode:" + i3 + ", errMsg:" + str);
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            if (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).p9(this.f209034e, false, "", new ArrayList<>(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements com.tencent.mobileqq.filemanager.core.j {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f209036d;

        c(String str) {
            this.f209036d = str;
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void d(int i3, int i16, long j3, long j16) {
            float f16 = ((float) j3) / ((float) j16);
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            if ((d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && f.this.f209029h.get(this.f209036d) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).K8(this.f209036d, f16, j16, RichMediaDownloadType.TYPE_SAVE_VIDEO);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void onDownloadError(int i3, int i16, String str) {
            QLog.i("MediaFileBrowseProcessorBase", 1, "-----------> onDownloadError mediaId:" + this.f209036d + ", errCode:" + i16 + ", extInfo:" + str);
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            if ((d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && f.this.f209029h.get(this.f209036d) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(this.f209036d, false, "", RichMediaDownloadType.TYPE_SAVE_VIDEO);
                f.this.f209029h.remove(this.f209036d);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void r(String str) {
            QLog.i("MediaFileBrowseProcessorBase", 1, "-----------> notify download finish mediaId:" + this.f209036d);
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            if ((d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && f.this.f209029h.get(this.f209036d) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(this.f209036d, true, str, RichMediaDownloadType.TYPE_SAVE_VIDEO);
                f.this.f209029h.remove(this.f209036d);
            }
        }
    }

    public f(QQAppInterface qQAppInterface) {
        this.f209026d = qQAppInterface;
        ShortVideoUtils.loadShortVideoSo(qQAppInterface);
    }

    private AIOFilePictureData d(int i3, FileInfo fileInfo) {
        AIOFilePictureData aIOFilePictureData = new AIOFilePictureData();
        aIOFilePictureData.msgId = i3;
        aIOFilePictureData.f281834h = fileInfo.k();
        aIOFilePictureData.F = fileInfo.l();
        aIOFilePictureData.size = fileInfo.l();
        aIOFilePictureData.E = false;
        aIOFilePictureData.G = false;
        return aIOFilePictureData;
    }

    private AIOFilePictureData e(int i3, FileManagerEntity fileManagerEntity) {
        String str;
        boolean z16;
        AIOFilePictureData aIOFilePictureData = new AIOFilePictureData();
        aIOFilePictureData.msgId = i3;
        String filePath = fileManagerEntity.getFilePath();
        String str2 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        if (filePath != null) {
            str = fileManagerEntity.getFilePath();
        } else {
            str = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        aIOFilePictureData.f281834h = str;
        String str3 = fileManagerEntity.strLargeThumPath;
        if (str3 == null) {
            str3 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        aIOFilePictureData.f281833f = str3;
        String str4 = fileManagerEntity.strMiddleThumPath;
        if (str4 != null) {
            str2 = str4;
        }
        aIOFilePictureData.f281832e = str2;
        long j3 = fileManagerEntity.fileSize;
        aIOFilePictureData.F = j3;
        aIOFilePictureData.size = j3;
        if (fileManagerEntity.status == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        aIOFilePictureData.E = z16;
        aIOFilePictureData.G = fileManagerEntity.sendCloudUnsuccessful();
        aIOFilePictureData.time = fileManagerEntity.originMsgTime;
        aIOFilePictureData.shmsgseq = fileManagerEntity.originShmsgseq;
        return aIOFilePictureData;
    }

    private AIOFilePictureData f(int i3, j jVar) {
        boolean z16;
        AIOFilePictureData aIOFilePictureData = new AIOFilePictureData();
        aIOFilePictureData.msgId = i3;
        aIOFilePictureData.f281834h = jVar.getFilePath();
        aIOFilePictureData.f281832e = jVar.u();
        aIOFilePictureData.f281833f = jVar.q();
        aIOFilePictureData.F = jVar.getFileSize();
        aIOFilePictureData.size = jVar.getFileSize();
        if (jVar.c() == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        aIOFilePictureData.E = z16;
        aIOFilePictureData.G = false;
        return aIOFilePictureData;
    }

    private RFWLayerPicInfo g(j jVar) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(jVar.getFileId());
        if (!TextUtils.isEmpty(jVar.getFilePath())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(jVar.getFilePath());
            rFWPicInfo.setUrl(jVar.getFilePath());
            rFWPicInfo.setSize(jVar.getFileSize());
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
        } else {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setLocalPath(AIOBrowserBaseData.MEDIA_FILE_NONE);
            rFWPicInfo2.setUrl(rFWPicInfo2.getLocalPath());
            rFWPicInfo2.setSize(jVar.getFileSize());
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo2);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo2);
        }
        if (!TextUtils.isEmpty(jVar.q())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo3.setLocalPath(jVar.q());
            rFWPicInfo3.setUrl(jVar.q());
            rFWPicInfo3.setSize(jVar.getFileSize());
            rFWLayerPicInfo.setBigPicInfo(rFWPicInfo3);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo3);
        }
        if (!TextUtils.isEmpty(jVar.u())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo4 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo4.setLocalPath(jVar.u());
            rFWPicInfo4.setUrl(jVar.u());
            rFWPicInfo4.setSize(jVar.getFileSize());
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo4);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo4);
        }
        return rFWLayerPicInfo;
    }

    private AIOFileVideoData i(int i3, FileInfo fileInfo) {
        AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
        aIOFileVideoData.msgId = i3;
        aIOFileVideoData.W = fileInfo.l();
        aIOFileVideoData.size = fileInfo.l();
        aIOFileVideoData.f281837d = fileInfo.j();
        aIOFileVideoData.f281838e = fileInfo.k();
        aIOFileVideoData.f281839f = fileInfo.k();
        aIOFileVideoData.I = true;
        aIOFileVideoData.isLocal = true;
        return aIOFileVideoData;
    }

    private AIOFileVideoData j(int i3, FileManagerEntity fileManagerEntity) {
        AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
        aIOFileVideoData.msgId = i3;
        aIOFileVideoData.size = fileManagerEntity.fileSize;
        aIOFileVideoData.f281837d = fileManagerEntity.fileName;
        aIOFileVideoData.f281842m = fileManagerEntity.imgHeight;
        aIOFileVideoData.f281841i = fileManagerEntity.imgWidth;
        aIOFileVideoData.time = fileManagerEntity.originMsgTime;
        aIOFileVideoData.shmsgseq = fileManagerEntity.originShmsgseq;
        if (q.f(fileManagerEntity.strLargeThumPath)) {
            aIOFileVideoData.f281838e = fileManagerEntity.strLargeThumPath;
        } else if (q.f(fileManagerEntity.strMiddleThumPath)) {
            aIOFileVideoData.f281838e = fileManagerEntity.strMiddleThumPath;
        } else if (q.f(fileManagerEntity.strThumbPath)) {
            aIOFileVideoData.f281838e = fileManagerEntity.strThumbPath;
        }
        aIOFileVideoData.f281840h = ((IQFileConfigManager) this.f209026d.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(fileManagerEntity.fileName)).f207738b;
        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
            aIOFileVideoData.f281839f = fileManagerEntity.getFilePath();
            aIOFileVideoData.W = fileManagerEntity.fileSize;
            aIOFileVideoData.I = true;
            aIOFileVideoData.isLocal = true;
        }
        return aIOFileVideoData;
    }

    private AIOFileVideoData k(int i3, j jVar) {
        AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
        aIOFileVideoData.msgId = i3;
        aIOFileVideoData.size = jVar.getFileSize();
        aIOFileVideoData.f281837d = jVar.getFileName();
        if (q.f(jVar.q())) {
            aIOFileVideoData.f281838e = jVar.q();
        } else if (q.f(jVar.u())) {
            aIOFileVideoData.f281838e = jVar.u();
        }
        aIOFileVideoData.f281840h = ((IQFileConfigManager) this.f209026d.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(jVar.getFileName())).f207738b;
        if (FileUtils.fileExistsAndNotEmpty(jVar.getFilePath())) {
            aIOFileVideoData.f281839f = jVar.getFilePath();
            aIOFileVideoData.W = jVar.getFileSize();
            aIOFileVideoData.I = true;
            aIOFileVideoData.isLocal = true;
        }
        return aIOFileVideoData;
    }

    private RFWLayerVideoInfo l(j jVar) {
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(jVar.getFileId());
        rFWLayerVideoInfo.setVideoOriginUrl(jVar.getFilePath());
        if (!TextUtils.isEmpty(jVar.getFilePath())) {
            rFWLayerVideoInfo.setCurrentVideoUrl(jVar.getFilePath());
        } else {
            rFWLayerVideoInfo.setCurrentVideoUrl("");
        }
        rFWLayerVideoInfo.setLocalPath(jVar.getFilePath());
        return rFWLayerVideoInfo;
    }

    private void m(String str) {
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        n(str, t(this.f209031m.get(h16)));
    }

    private void n(String str, com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        if (bVar == null) {
            QLog.e("MediaFileBrowseProcessorBase", 1, "downloadVideo, biz is null! checked!!!");
            return;
        }
        k b16 = com.tencent.mobileqq.filemanager.core.g.b(bVar);
        b16.f(new c(str));
        b16.d(true);
        b16.startDownload();
        com.tencent.mobileqq.filemanager.core.g.k(bVar.a(), true);
    }

    private void q(String str, com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        if (bVar == null) {
            QLog.e("MediaFileBrowseProcessorBase", 1, "getFileVideoUrl, biz is null! checked!!!");
            return;
        }
        k b16 = com.tencent.mobileqq.filemanager.core.g.b(bVar);
        b16.g(new b(bVar, str));
        b16.d(true);
        b16.startDownload();
    }

    private com.tencent.mobileqq.filemanager.fileviewer.data.b t(j jVar) {
        FileManagerEntity entity = jVar.getEntity();
        if (entity == null) {
            return null;
        }
        if (entity.getCloudType() == 12) {
            return (com.tencent.mobileqq.filemanager.fileviewer.data.b) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewVideoForGuild(this.f209026d, entity);
        }
        if (entity.getCloudType() == 13) {
            return new com.tencent.mobileqq.filemanager.fileviewer.data.h(this.f209026d, entity);
        }
        int i3 = entity.peerType;
        if (i3 == 0) {
            return new VideoForC2C(this.f209026d, entity);
        }
        if (i3 == 3000) {
            return new com.tencent.mobileqq.filemanager.fileviewer.data.g(this.f209026d, entity);
        }
        if (i3 == 1) {
            t n3 = TroopFileUtils.n(this.f209026d, entity);
            if (n3.f294967a == null) {
                QLog.w("MediaFileBrowseProcessorBase", 1, "statusInfo.Id is null, path:" + entity.strTroopFilePath);
                return null;
            }
            return new com.tencent.mobileqq.filemanager.fileviewer.data.i(n3);
        }
        QLog.w("MediaFileBrowseProcessorBase", 1, "unsuporrt peer type:" + entity.peerType);
        return null;
    }

    private boolean v(j jVar) {
        int c16;
        if (jVar.a() == 10 || (c16 = jVar.c()) == 0 || c16 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.a
    public void B8(@NonNull String str) {
        ReportController.o(null, "CliOper", "", "", "View_pic", "View_pic_menu", r(str), 0, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void C0(String str) {
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        com.tencent.mobileqq.filemanager.fileviewer.data.b t16 = t(this.f209031m.get(h16));
        if (!TextUtils.isEmpty(t16.a())) {
            com.tencent.mobileqq.filemanager.core.g.g(t16.a());
        }
    }

    public void L1(@NonNull String str, @NonNull RichMediaDownloadType richMediaDownloadType, Activity activity) {
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        this.f209029h.put(str, richMediaDownloadType);
        QLog.e("MediaFileBrowseProcessorBase", 1, "downloadMedia mediaId:" + str + ", type:" + richMediaDownloadType);
        j jVar = this.f209031m.get(h16);
        if (richMediaDownloadType != RichMediaDownloadType.TYPE_ORIGINAL_IMAGE && richMediaDownloadType != RichMediaDownloadType.TYPE_SAVE_ORIGINAL_IMAGE && richMediaDownloadType != RichMediaDownloadType.TYPE_LARGE_IMAGE) {
            if (richMediaDownloadType == RichMediaDownloadType.TYPE_THUMB_IMAGE) {
                o(str, jVar);
                return;
            } else {
                if (richMediaDownloadType == RichMediaDownloadType.TYPE_SAVE_VIDEO) {
                    m(str);
                    return;
                }
                return;
            }
        }
        x(jVar);
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void R1(Activity activity, @NonNull String str) {
        mb1.a aVar = mb1.a.f416517a;
        int h16 = aVar.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        j jVar = this.f209031m.get(h16);
        jVar.getFilePath();
        FileManagerEntity entity = jVar.getEntity();
        if (entity == null) {
            return;
        }
        ((IPrintApi) QRoute.api(IPrintApi.class)).getLocalFilePrintClick(activity, entity, false).onClick(null);
        RFWLayerItemMediaInfo i3 = aVar.i(str, this.f209028f);
        if (i3 != null && i3.isVideo()) {
            ReportController.o(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", 12, 0, "4", "5", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", 12, 0, "4", "5", "", "");
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.a
    public void V4(@NonNull String str) {
        ReportController.o(null, "dc00898", "", "", "0X800C48D", "0X800C48D", 5, 0, "4", "5", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RichMediaBrowserInfo a(int i3, FileInfo fileInfo) {
        RichMediaBrowserInfo richMediaBrowserInfo;
        if (fileInfo.getType() == 0) {
            richMediaBrowserInfo = new RichMediaBrowserInfo();
            richMediaBrowserInfo.baseData = d(i3, fileInfo);
        } else {
            richMediaBrowserInfo = null;
        }
        if (fileInfo.getType() == 2) {
            RichMediaBrowserInfo richMediaBrowserInfo2 = new RichMediaBrowserInfo();
            richMediaBrowserInfo2.baseData = i(i3, fileInfo);
            return richMediaBrowserInfo2;
        }
        return richMediaBrowserInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RichMediaBrowserInfo b(int i3, FileManagerEntity fileManagerEntity) {
        RichMediaBrowserInfo richMediaBrowserInfo;
        if (fileManagerEntity.nFileType == 0) {
            richMediaBrowserInfo = new RichMediaBrowserInfo();
            richMediaBrowserInfo.baseData = e(i3, fileManagerEntity);
        } else {
            richMediaBrowserInfo = null;
        }
        if (fileManagerEntity.nFileType == 2) {
            RichMediaBrowserInfo richMediaBrowserInfo2 = new RichMediaBrowserInfo();
            richMediaBrowserInfo2.baseData = j(i3, fileManagerEntity);
            return richMediaBrowserInfo2;
        }
        return richMediaBrowserInfo;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.a
    public void b6(@NonNull String str) {
        int i3;
        String str2;
        RFWLayerItemMediaInfo i16 = mb1.a.f416517a.i(str, this.f209028f);
        if (i16 != null) {
            if (i16.isVideo()) {
                i3 = 5;
                str2 = "0X800C491";
            } else {
                i3 = 2;
                str2 = "0X800C48D";
            }
            String str3 = str2;
            ReportController.o(null, "dc00898", "", "", str3, str3, i3, 0, "4", "1", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RichMediaBrowserInfo c(int i3, j jVar) {
        RichMediaBrowserInfo richMediaBrowserInfo;
        int fileType = jVar.getFileType();
        if (fileType == 0) {
            richMediaBrowserInfo = new RichMediaBrowserInfo();
            richMediaBrowserInfo.baseData = f(i3, jVar);
        } else {
            richMediaBrowserInfo = null;
        }
        if (fileType == 2) {
            RichMediaBrowserInfo richMediaBrowserInfo2 = new RichMediaBrowserInfo();
            richMediaBrowserInfo2.baseData = k(i3, jVar);
            return richMediaBrowserInfo2;
        }
        return richMediaBrowserInfo;
    }

    public void cancelDownload(@NonNull String str) {
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        QLog.e("MediaFileBrowseProcessorBase", 1, "cancelDownload mediaId:" + str);
        j jVar = this.f209031m.get(h16);
        if (jVar.v() == 0) {
            this.f209026d.getOnlineFileSessionCenter().u(jVar.getSessionId());
        } else {
            this.f209026d.getFileManagerEngine().i0(jVar.getSessionId());
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void g3(View view, String str) {
        FileManagerEntity entity;
        mb1.a aVar = mb1.a.f416517a;
        int h16 = aVar.h(str, this.f209028f);
        if (h16 >= this.f209031m.size() || (entity = this.f209031m.get(h16).getEntity()) == null) {
            return;
        }
        com.tencent.mobileqq.filemanager.fileviewer.c.c(null, entity).onClick(view);
        RFWLayerItemMediaInfo i3 = aVar.i(str, this.f209028f);
        if (i3 != null && i3.isVideo()) {
            ReportController.o(null, "dc00898", "", "", "0X800C493", "0X800C493", r(str), 0, "", String.valueOf(5), "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800C48F", "0X800C48F", r(str), 0, "", String.valueOf(3), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWLayerItemMediaInfo h(j jVar) {
        boolean z16;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        int fileType = jVar.getFileType();
        if (fileType == 0) {
            rFWLayerItemMediaInfo.setLayerPicInfo(g(jVar));
        }
        if (fileType == 2) {
            RFWLayerVideoInfo l3 = l(jVar);
            RFWLayerPicInfo g16 = g(jVar);
            rFWLayerItemMediaInfo.setLayerVideoInfo(l3);
            rFWLayerItemMediaInfo.setLayerPicInfo(g16);
        }
        rFWLayerItemMediaInfo.setMediaId(jVar.getFileId());
        if (jVar.c() == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        rFWLayerItemMediaInfo.setInvalid(z16);
        return rFWLayerItemMediaInfo;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.a
    public void n0(@NonNull String str) {
        ReportController.o(null, "dc00898", "", "", "0X800C491", "0X800C491", 5, 0, "4", "4", "", "");
    }

    public void o(String str, j jVar) {
        String str2;
        RichMediaDownloadType richMediaDownloadType;
        if (1 == jVar.v()) {
            if (jVar.getEntity().isZipInnerFile) {
                str2 = this.f209026d.getFileManagerEngine().q(jVar.getEntity());
            } else {
                str2 = this.f209026d.getFileManagerEngine().m(jVar.getEntity(), 7);
            }
        } else {
            String str3 = null;
            if (2 == jVar.v()) {
                FileManagerEngine fileManagerEngine = this.f209026d.getFileManagerEngine();
                String fileId = jVar.getFileId();
                if (jVar.s() != null) {
                    str3 = jVar.s().E;
                }
                str2 = fileManagerEngine.Z(fileId, str3, 7, jVar);
            } else {
                str2 = null;
            }
        }
        if (str2 != null) {
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.d.class.getName());
            if ((d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = this.f209029h.get(str)) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(str, true, str2, richMediaDownloadType);
                this.f209029h.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void onDestroy() {
        this.f209026d.getFileManagerNotifyCenter().deleteObserver(this.E);
    }

    public int p() {
        return this.f209030i;
    }

    public int r(String str) {
        RFWLayerItemMediaInfo i3 = mb1.a.f416517a.i(str, this.f209028f);
        if (i3 != null && i3.isVideo()) {
            return 5;
        }
        return 2;
    }

    public List<RFWLayerItemMediaInfo> s() {
        return this.f209028f;
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public Intent s3(@NonNull String str) {
        FileManagerEntity entity;
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size() || (entity = this.f209031m.get(h16).getEntity()) == null) {
            return null;
        }
        return QFileUtils.J(this.f209026d, null, entity);
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void s8(@NonNull String str) {
        int h16 = mb1.a.f416517a.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        q(str, t(this.f209031m.get(h16)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.f209026d.getFileManagerNotifyCenter().addObserver(this.E);
    }

    @Override // com.tencent.mobileqq.richmedia.depend.a
    public void u2(@NonNull String str) {
        ReportController.o(null, "CliOper", "", "", "View_pic", "View_pic_menu", r(str), 0, "0", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(int i3, int i16) {
        if ((i3 == 0 || 2 == i3) && i16 != 0) {
            return true;
        }
        return false;
    }

    protected void x(j jVar) {
        long sessionId = jVar.getSessionId();
        int v3 = jVar.v();
        if (v(jVar)) {
            if (v3 == 0) {
                this.f209026d.getOnlineFileSessionCenter().x(sessionId);
                return;
            } else {
                this.f209026d.getFileManagerEngine().o0(sessionId);
                return;
            }
        }
        if (v3 == 0) {
            this.f209026d.getOnlineFileSessionCenter().v(sessionId);
        } else {
            this.f209026d.getFileManagerEngine().t0(jVar.getEntity());
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.f
    public void x7(@NonNull String str) {
        String peerUin;
        mb1.a aVar = mb1.a.f416517a;
        int h16 = aVar.h(str, this.f209028f);
        if (h16 >= this.f209031m.size()) {
            return;
        }
        j jVar = this.f209031m.get(h16);
        int v3 = jVar.v();
        if (v3 != 1) {
            if (v3 == 3 || v3 == 5) {
                this.f209026d.getFileManagerEngine().F0(jVar.getFilePath(), null, this.f209026d.getAccount(), "", 0, false);
            }
        } else {
            if (jVar.o()) {
                peerUin = this.f209026d.getCurrentAccountUin();
            } else {
                peerUin = jVar.getPeerUin();
            }
            FileManagerEntity entity = jVar.getEntity();
            if (entity == null) {
                return;
            } else {
                this.f209026d.getFileManagerEngine().v0(entity, peerUin);
            }
        }
        RFWLayerItemMediaInfo i3 = aVar.i(str, this.f209028f);
        if (i3 != null && i3.isVideo()) {
            ReportController.o(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", 6, 0, "4", "5", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", 6, 0, "4", "5", "", "");
        }
    }
}
