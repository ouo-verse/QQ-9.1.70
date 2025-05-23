package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFlashTransferDTReportApi;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.v;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.depend.RichMediaDownloadType;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;

/* loaded from: classes12.dex */
public class FlashTransferMediaFileBrowseProcessor extends f implements com.tencent.mobileqq.richmedia.depend.e {
    private List<FileManagerEntity> F;
    private FileManagerEntity G;
    private int H;

    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void W(Object[] objArr) {
            RichMediaDownloadType richMediaDownloadType;
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            int intValue = ((Integer) objArr2[1]).intValue();
            long longValue2 = ((Long) objArr2[2]).longValue();
            int h16 = mb1.a.f416517a.h(String.valueOf(longValue), FlashTransferMediaFileBrowseProcessor.this.f209028f);
            if (h16 >= FlashTransferMediaFileBrowseProcessor.this.f209031m.size()) {
                return;
            }
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = FlashTransferMediaFileBrowseProcessor.this.f209028f.get(h16);
            if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = FlashTransferMediaFileBrowseProcessor.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).K8(rFWLayerItemMediaInfo.getMediaId(), intValue / 100.0f, longValue2, richMediaDownloadType);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void X(Object[] objArr) {
            RichMediaDownloadType richMediaDownloadType;
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            boolean booleanValue = ((Boolean) objArr2[1]).booleanValue();
            String str = (String) objArr2[2];
            int h16 = mb1.a.f416517a.h(String.valueOf(longValue), FlashTransferMediaFileBrowseProcessor.this.f209028f);
            if (h16 >= FlashTransferMediaFileBrowseProcessor.this.f209031m.size()) {
                return;
            }
            j jVar = FlashTransferMediaFileBrowseProcessor.this.f209031m.get(h16);
            FileManagerEntity queryFileEntity = ((IQQFileDataCenter) FlashTransferMediaFileBrowseProcessor.this.f209026d.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(0L, "", 0, longValue);
            if (queryFileEntity != null) {
                jVar.d(queryFileEntity);
            } else {
                jVar.getEntity().strFilePath = str;
            }
            com.tencent.mobileqq.richmedia.depend.c d16 = com.tencent.mobileqq.richmedia.e.f281568a.d(com.tencent.mobileqq.richmedia.depend.b.class.getName());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = FlashTransferMediaFileBrowseProcessor.this.f209028f.get(h16);
            if (rFWLayerItemMediaInfo != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId()) && (d16 instanceof com.tencent.mobileqq.richmedia.depend.b) && (richMediaDownloadType = FlashTransferMediaFileBrowseProcessor.this.f209029h.get(rFWLayerItemMediaInfo.getMediaId())) != null) {
                ((com.tencent.mobileqq.richmedia.depend.b) d16).I7(rFWLayerItemMediaInfo.getMediaId(), booleanValue, str, richMediaDownloadType);
                FlashTransferMediaFileBrowseProcessor.this.f209029h.remove(rFWLayerItemMediaInfo.getMediaId());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FlashTransferMediaFileBrowseProcessor(Object obj, List<FileManagerEntity> list, int i3) {
        super(r6);
        QQAppInterface qQAppInterface = (QQAppInterface) obj;
        this.H = -1;
        this.F = list;
        for (FileManagerEntity fileManagerEntity : list) {
            RFWLayerItemMediaInfo d16 = mb1.a.f416517a.d(fileManagerEntity);
            if (fileManagerEntity.nFileType == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", "https://qfile.qq.com");
                hashMap.put("x-device-id", o.c());
                d16.getLayerVideoInfo().setHttpHeader(hashMap);
            }
            this.f209028f.add(d16);
            this.f209031m.add(com.tencent.mobileqq.filemanager.fileviewer.d.f(qQAppInterface, fileManagerEntity));
        }
        this.f209030i = i3;
        this.E = new a();
        u();
    }

    @Override // com.tencent.mobileqq.richmedia.depend.e
    public void A1(int i3, @Nullable RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        Activity topActivity;
        if (rFWLayerItemMediaInfo == null) {
            return;
        }
        FileManagerEntity queryFileEntity = ((IQQFileDataCenter) this.f209026d.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(0L, "", 0, Long.parseLong(rFWLayerItemMediaInfo.getMediaId()));
        if (queryFileEntity == null || !FileUtils.fileExists(queryFileEntity.strFilePath)) {
            Iterator<FileManagerEntity> it = this.F.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FileManagerEntity next = it.next();
                if (next.nSessionId == Long.valueOf(rFWLayerItemMediaInfo.getMediaId()).longValue()) {
                    queryFileEntity = next;
                    break;
                }
            }
        }
        if (queryFileEntity == null || (topActivity = Foreground.getTopActivity()) == null) {
            return;
        }
        if (i3 == 0) {
            FileManagerEntity fileManagerEntity = this.G;
            if (fileManagerEntity != null) {
                if (fileManagerEntity.nSessionId == queryFileEntity.nSessionId && this.H == i3) {
                    return;
                } else {
                    ((IFlashTransferDTReportApi) QRoute.api(IFlashTransferDTReportApi.class)).reportFileBrowse(topActivity, this.G, false);
                }
            }
            ((IFlashTransferDTReportApi) QRoute.api(IFlashTransferDTReportApi.class)).reportFileBrowse(topActivity, queryFileEntity, true);
            this.G = queryFileEntity;
            this.H = i3;
            return;
        }
        if (i3 == 1) {
            ((IFlashTransferDTReportApi) QRoute.api(IFlashTransferDTReportApi.class)).reportFileBrowse(topActivity, queryFileEntity, false);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.e
    public boolean C6(@Nullable RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        FileManagerEntity queryFileEntity = ((IQQFileDataCenter) this.f209026d.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(0L, "", 0, Long.parseLong(rFWLayerItemMediaInfo.getMediaId()));
        if (queryFileEntity != null && FileUtils.fileExists(queryFileEntity.strFilePath)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.openbrowser.f, com.tencent.mobileqq.richmedia.depend.d
    public void L1(@NonNull final String str, @NonNull final RichMediaDownloadType richMediaDownloadType, Activity activity) {
        int h16;
        v d16 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
        if (d16 == null || (h16 = mb1.a.f416517a.h(str, this.f209028f)) >= this.f209031m.size()) {
            return;
        }
        if (this.f209029h.containsKey(str) && this.f209029h.get(str) == richMediaDownloadType) {
            return;
        }
        this.f209029h.put(str, richMediaDownloadType);
        final j jVar = this.f209031m.get(h16);
        if (richMediaDownloadType != RichMediaDownloadType.TYPE_LARGE_IMAGE && richMediaDownloadType != RichMediaDownloadType.TYPE_THUMB_IMAGE) {
            d16.a(jVar.getEntity());
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.openbrowser.FlashTransferMediaFileBrowseProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getThumbImgSaveRootDirectory(jVar.getEntity().fileSetId) + "/" + jVar.getEntity().fileName;
                    if (!FileUtils.fileExists(str2)) {
                        QLog.d("FlashTransferImageBrowseProcessor", 1, "downloadThumbImage. mediaId: " + str + ", type: " + richMediaDownloadType + ", filename: " + jVar.getEntity().fileName + ", localPath: " + str2);
                        str2 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).downloadThumbImage(jVar.getEntity().strMiddleThumPath, str2);
                    }
                    ((QQAppInterface) ah.W()).getFileManagerNotifyCenter().b(true, 56, new Object[]{Long.valueOf(jVar.getEntity().nSessionId), Boolean.valueOf(!TextUtils.isEmpty(str2)), str2});
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.e
    public String a5() {
        return "biz_src_jc_flash_transfer";
    }

    @Override // com.tencent.mobileqq.filemanager.openbrowser.f, com.tencent.mobileqq.richmedia.depend.d
    public void cancelDownload(@NonNull String str) {
        int h16;
        v d16 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
        if (d16 == null || (h16 = mb1.a.f416517a.h(str, this.f209028f)) >= this.f209031m.size()) {
            return;
        }
        d16.b(this.f209031m.get(h16).getEntity());
    }

    @Override // com.tencent.mobileqq.richmedia.depend.e
    public Map<String, Object> getReportParams() {
        return new HashMap();
    }
}
