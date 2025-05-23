package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements ThumbHttpDownloader.b {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f207631a;

    /* renamed from: b, reason: collision with root package name */
    protected LinkedHashMap<Long, C7549a> f207632b = new LinkedHashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7549a {

        /* renamed from: a, reason: collision with root package name */
        public long f207633a;

        /* renamed from: b, reason: collision with root package name */
        public FileManagerEntity f207634b;

        public C7549a(FileManagerEntity fileManagerEntity) {
            this.f207634b = fileManagerEntity;
        }
    }

    public a(QQAppInterface qQAppInterface) {
        this.f207631a = qQAppInterface;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void c(long j3, boolean z16, int i3, String str, ThumbHttpDownloader.a aVar) {
        QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted suc:" + z16 + " retCode[" + i3 + "] thumbPath:" + str);
        q(j3);
    }

    protected final void h(C7549a c7549a) {
        if (c7549a == null) {
            QLog.e("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb] addSession = null");
            return;
        }
        synchronized (this.f207632b) {
            QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + c7549a.f207633a + "] addSession");
            this.f207632b.put(Long.valueOf(c7549a.f207633a), c7549a);
            if (QLog.isDevelopLevel()) {
                Iterator<Long> it = this.f207632b.keySet().iterator();
                while (it.hasNext()) {
                    QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call addSession ID[" + it.next().longValue() + "] in mMapDowloadSession");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(C7549a c7549a, String str, boolean z16) {
        boolean z17;
        Object obj = c7549a.f207634b.mContext;
        if (obj != null && (obj instanceof String) && "igonFlow".equalsIgnoreCase((String) obj)) {
            c7549a.f207634b.mContext = null;
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !((IFMConfig) QRoute.api(IFMConfig.class)).preDownloadThumb() && FileManagerUtil.is2GOr3G()) {
            QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + c7549a.f207634b.nSessionId + "] size(wh)[" + c7549a.f207634b.imgWidth + ":" + c7549a.f207634b.imgHeight + "]autoDownload Thumb switch is off!");
            return;
        }
        long h16 = this.f207631a.getFileManagerEngine().X().h(str, this, z16);
        if (h16 == -1) {
            QLog.w("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + c7549a.f207634b.nSessionId + "] size(wh)[" + c7549a.f207634b.imgWidth + ":" + c7549a.f207634b.imgHeight + "] thumb is Downloading,waiting please!");
            return;
        }
        FileManagerEntity fileManagerEntity = c7549a.f207634b;
        int i3 = fileManagerEntity.mThumbRetryCount;
        fileManagerEntity.mThumbRetryCount = i3 + 1;
        if (i3 > 10) {
            QLog.w("BaseThumbDownloader<FileAssistant>", 1, "thumb retry over 10 count, igon!");
            return;
        }
        c7549a.f207633a = h16;
        h(c7549a);
        this.f207631a.getFileManagerEngine().X().l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        File file = new File(lc1.b.a().getDefaultThumbPath());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final C7549a k(long j3) {
        C7549a c7549a;
        synchronized (this.f207632b) {
            c7549a = this.f207632b.get(Long.valueOf(j3));
        }
        return c7549a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String l(int i3) {
        switch (i3) {
            case 0:
                return "16*16";
            case 1:
                return "32*32";
            case 2:
            default:
                return "64*64";
            case 3:
                return "128*128";
            case 4:
                return "320*320";
            case 5:
                return "384*384";
            case 6:
                return "640*640";
            case 7:
                return "750*750";
            case 8:
                return "1024*1024";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String m(int i3, String str) {
        String str2;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 6) {
                                if (i3 != 8) {
                                    str2 = "x-video-";
                                } else {
                                    str2 = "screen-video-";
                                }
                            } else {
                                str2 = "xlarge-video-";
                            }
                        } else {
                            str2 = "large-video-";
                        }
                    } else {
                        str2 = "middle-video-";
                    }
                } else {
                    str2 = "small-video-";
                }
            } else {
                str2 = "minni-video-";
            }
        } else {
            str2 = "micro-video-";
        }
        return str2 + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int n(String str) {
        String j3 = q.j(str);
        if (".mp4".equalsIgnoreCase(j3)) {
            return 17;
        }
        if (".rmvb".equalsIgnoreCase(j3)) {
            return 18;
        }
        if (".avi".equalsIgnoreCase(j3)) {
            return 19;
        }
        if (".wmv".equalsIgnoreCase(j3)) {
            return 20;
        }
        if (".flv".equalsIgnoreCase(j3)) {
            return 21;
        }
        if (".3gp".equalsIgnoreCase(j3)) {
            return 22;
        }
        if (".mkv".equalsIgnoreCase(j3)) {
            return 23;
        }
        if (".asf".equalsIgnoreCase(j3)) {
            return 26;
        }
        if (".vob".equalsIgnoreCase(j3)) {
            return 27;
        }
        if (".m4v".equalsIgnoreCase(j3)) {
            return 28;
        }
        if (".f4v".equalsIgnoreCase(j3)) {
            return 29;
        }
        if (".mov".equalsIgnoreCase(j3)) {
            return 30;
        }
        if (".mpeg".equalsIgnoreCase(j3)) {
            return 31;
        }
        if (".mpg".equalsIgnoreCase(j3)) {
            return 32;
        }
        if (".rm".equalsIgnoreCase(j3)) {
            return 33;
        }
        if (".webm".equalsIgnoreCase(j3)) {
            return 34;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(long j3, boolean z16, String str, int i3, String str2, String str3, String str4, boolean z17, String str5, short s16, String str6) {
        QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrlResult suc:" + z16 + " strDomain:" + str + " port:" + i3 + " urlParam:" + str2 + " cookie:" + str4);
        this.f207631a.getFileManagerEngine().X().g(j3, z16, str, i3, str2, str3, str4, z17, str5, s16, str6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(long j3, boolean z16, String str, int i3, String str2, String str3, String str4, boolean z17, String str5, short s16, String str6, Bundle bundle) {
        QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrlResult suc:" + z16 + " strDomain:" + str + " port:" + i3 + " urlParam:" + str2 + " cookie:" + str4);
        this.f207631a.getFileManagerEngine().X().g(j3, z16, str, i3, str2, str3, str4, z17, str5, s16, str6, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(long j3) {
        synchronized (this.f207632b) {
            QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] removeSession");
            if (QLog.isDevelopLevel()) {
                Iterator<Long> it = this.f207632b.keySet().iterator();
                while (it.hasNext()) {
                    QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call removeSession ID[" + it.next().longValue() + "] in mMapDowloadSession");
                }
            }
            this.f207632b.remove(Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void f(long j3, int i3, ThumbHttpDownloader.a aVar) {
    }
}
