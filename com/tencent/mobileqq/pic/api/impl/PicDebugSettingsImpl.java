package com.tencent.mobileqq.pic.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.pic.api.IPicDebugSettings;
import com.tencent.mobileqq.qdispatchqueue.d;
import com.tencent.mobileqq.qdispatchqueue.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FilenameFilter;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PicDebugSettingsImpl implements IPicDebugSettings {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PicDebugSettings";
    private boolean isAvcodecInfoCache;
    private boolean isImageMemoryCacheDisabled;
    private boolean isSimulateFileImageExpire;
    private boolean isSimulateFileVideoExpire;
    private boolean isSimulateImageExpire;
    private boolean isSimulateVideoExpire;
    private boolean isVideoAutoPlayDisabled;
    private final Handler mainHandler;
    private final i queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements FilenameFilter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return !str.contains("chatthumb");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return !str.contains("thumbs");
        }
    }

    public PicDebugSettingsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.queue = d.c("pic-debug", true);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.isSimulateImageExpire = false;
        this.isSimulateVideoExpire = false;
        this.isSimulateFileImageExpire = false;
        this.isAvcodecInfoCache = false;
        this.isSimulateFileVideoExpire = false;
        this.isVideoAutoPlayDisabled = false;
        this.isImageMemoryCacheDisabled = false;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void cleanChatImageThumbs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.pic.api.impl.PicDebugSettingsImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    k.b(RmVFSUtils.getVFSPath(AbsDownloader.CHAT_IMAGE_ROOT + "chatthumb"));
                    PicDebugSettingsImpl.this.notifyCleanComplete();
                }
            });
        }
    }

    void cleanChatImageWithoutThumbs() {
        File[] listFiles = new File(RmVFSUtils.getVFSPath(AbsDownloader.CHAT_IMAGE_ROOT)).listFiles(new a());
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    file.delete();
                } else {
                    k.b(file.getAbsolutePath());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void cleanChatImages() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.pic.api.impl.PicDebugSettingsImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PicDebugSettingsImpl.this.cleanChatImageWithoutThumbs();
                        PicDebugSettingsImpl.this.notifyCleanComplete();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void cleanChatVideoThumbs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.pic.api.impl.PicDebugSettingsImpl.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        k.b(RmVFSUtils.getVFSPath(j.k()));
                        PicDebugSettingsImpl.this.notifyCleanComplete();
                    }
                }
            });
        }
    }

    void cleanChatVideoWithoutThumb() {
        File[] listFiles = new File(RmVFSUtils.getVFSPath(j.h())).listFiles(new b());
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    k.b(file.getAbsolutePath());
                } else {
                    file.delete();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void cleanChatVideos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.pic.api.impl.PicDebugSettingsImpl.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PicDebugSettingsImpl.this.cleanChatVideoWithoutThumb();
                        PicDebugSettingsImpl.this.notifyCleanComplete();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isAvcodecInfoCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isAvcodecInfoCache;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isMemoryImageCacheDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isImageMemoryCacheDisabled;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isSimulateFileImageExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isSimulateFileImageExpire;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isSimulateFileVideoExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isSimulateFileVideoExpire;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isSimulateImageExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isSimulateImageExpire;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isSimulateVideoExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isSimulateVideoExpire;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public boolean isVideoAutoPlayDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isVideoAutoPlayDisabled;
    }

    void notifyCleanComplete() {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.pic.api.impl.PicDebugSettingsImpl.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicDebugSettingsImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(BaseApplication.getContext(), "\u64cd\u4f5c\u5b8c\u6210", 1).show();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void resetBubbleTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        String account = MobileQQ.sMobileQQ.waitAppRuntime().getAccount();
        QMMKV.from(context, "common_mmkv_configurations").encodeInt(account + "_bubble_view_show_count", 0);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setAvcodecInfoCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isAvcodecInfoCache = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setMemoryImageCacheDisabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isImageMemoryCacheDisabled = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setSimulateFileImageExpire(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isSimulateFileImageExpire = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setSimulateFileVideoExpire(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isSimulateFileVideoExpire = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setSimulateImageExpire(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isSimulateImageExpire = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setSimulateVideoExpire(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isSimulateVideoExpire = z16;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicDebugSettings
    public void setVideoAutoPlayDisabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.isVideoAutoPlayDisabled = z16;
        }
    }
}
