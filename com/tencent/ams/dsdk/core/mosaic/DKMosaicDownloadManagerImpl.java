package com.tencent.ams.dsdk.core.mosaic;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKCustomAbilityProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.download.DKDownloadManager;
import com.tencent.ams.dsdk.download.DefaultDownloadManager;
import com.tencent.ams.dsdk.download.DownloadItem;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.mosaic.jsengine.common.download.IDownload;
import com.tencent.ams.mosaic.jsengine.common.download.IDownloadStatus;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicDownloadManagerImpl implements IMosaicDownloadManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicDownloadManagerImpl";
    private final Context mContext;
    private DKDownloadManager mDKDownloadManager;
    private final DKEngine mEngine;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class DownloadStatus implements IDownloadStatus {
        static IPatchRedirector $redirector_;
        private int mDownloadStatus;
        private float mProgress;

        DownloadStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownloadStatus
        public int getDownloadStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.mDownloadStatus;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownloadStatus
        public float progress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.mProgress;
        }

        /* synthetic */ DownloadStatus(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class MosaicDownloadCallbackWrapper implements DKDownloadManager.Callback {
        static IPatchRedirector $redirector_;
        private final IMosaicDownloadManager.a mCallback;
        private final String mFilePath;

        public MosaicDownloadCallbackWrapper(String str, IMosaicDownloadManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
            } else {
                this.mCallback = aVar;
                this.mFilePath = str;
            }
        }

        @IMosaicDownloadManager.ErrorCode
        private int convertErrorCode(int i3) {
            switch (i3) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                default:
                    return 7;
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(4);
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.a(this.mFilePath);
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(convertErrorCode(i3));
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onDownloadPause();
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onDownloadResume();
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onDownloadStart();
            }
        }

        @Override // com.tencent.ams.dsdk.download.DKDownloadManager.Callback
        public void onDownloadUpdate(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            IMosaicDownloadManager.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.b((int) j3, (int) j16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class MosaicDownloadWrapper implements IDownload {
        static IPatchRedirector $redirector_;
        private final DKDownloadManager.IDownloader mDownloader;

        public MosaicDownloadWrapper(DKDownloadManager.IDownloader iDownloader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iDownloader);
            } else {
                this.mDownloader = iDownloader;
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public boolean cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null && iDownloader.cancel()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public int getDownloadStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null) {
                return iDownloader.getDownloadStatus();
            }
            return 0;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public float getDownloadedProgress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null) {
                return iDownloader.getDownloadedProgress();
            }
            return 0.0f;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public boolean isRunning() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null && iDownloader.isRunning()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public boolean pause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null && iDownloader.pause()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public boolean resume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null && iDownloader.resume()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownload
        public boolean start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            DKDownloadManager.IDownloader iDownloader = this.mDownloader;
            if (iDownloader != null && iDownloader.start()) {
                return true;
            }
            return false;
        }
    }

    public DKMosaicDownloadManagerImpl(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private static DownloadItem getDownloadItem(IMosaicDownloadManager.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            return new DownloadItem(bVar.getUrl(), bVar.a(), 0L, 0L, bVar.b(), bVar.getName()).query();
        } catch (Throwable th5) {
            DLog.e(TAG, "query download item error.", th5);
            return null;
        }
    }

    private DKDownloadManager getDownloadManager() {
        DKCustomAbilityProvider customAbilityProvider;
        DKDownloadManager dKDownloadManager = this.mDKDownloadManager;
        if (dKDownloadManager != null) {
            return dKDownloadManager;
        }
        DKEngine dKEngine = this.mEngine;
        DKDownloadManager dKDownloadManager2 = null;
        if (dKEngine == null) {
            customAbilityProvider = null;
        } else {
            customAbilityProvider = dKEngine.getCustomAbilityProvider();
        }
        if (customAbilityProvider != null) {
            dKDownloadManager2 = customAbilityProvider.getDownloadManager(this.mContext);
        }
        if (dKDownloadManager2 == null) {
            dKDownloadManager2 = new DefaultDownloadManager();
        }
        this.mDKDownloadManager = dKDownloadManager2;
        return dKDownloadManager2;
    }

    private DKDownloadManager.IDownloader initDownloader(IMosaicDownloadManager.b bVar, IMosaicDownloadManager.a aVar) {
        if (bVar == null) {
            if (aVar != null) {
                aVar.onFailed(1);
                return null;
            }
            return null;
        }
        String b16 = bVar.b();
        String name = bVar.getName();
        DownloadRequest build = new DownloadRequest.Builder().setUrl(bVar.getUrl()).setFileMd5(bVar.a()).setFolder(b16).setName(name).setMaxRetryCount(1).setExtendInfo(bVar.c()).build();
        if (!TextUtils.isEmpty(b16)) {
            name = new File(b16, name).getAbsolutePath();
        }
        return getDownloadManager().download(build, new MosaicDownloadCallbackWrapper(name, aVar));
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager
    public IDownload download(IMosaicDownloadManager.b bVar, IMosaicDownloadManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IDownload) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) aVar);
        }
        DKDownloadManager.IDownloader initDownloader = initDownloader(bVar, aVar);
        if (initDownloader == null) {
            return null;
        }
        return new MosaicDownloadWrapper(initDownloader);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager
    public IDownloadStatus queryDownload(IMosaicDownloadManager.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IDownloadStatus) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
        DownloadStatus downloadStatus = new DownloadStatus(null);
        if (bVar == null) {
            return downloadStatus;
        }
        bVar.b();
        bVar.getName();
        bVar.a();
        DKDownloadManager.IDownloader initDownloader = initDownloader(bVar, null);
        if (initDownloader != null) {
            downloadStatus.mDownloadStatus = initDownloader.getDownloadStatus();
            downloadStatus.mProgress = initDownloader.getDownloadedProgress();
            DLog.i("DKMosaicDownloadManagerImpl queryDownload getDownloadStatus");
        } else {
            DLog.i("DKMosaicDownloadManagerImpl queryDownload getDownloadStatus downloader == null");
        }
        return downloadStatus;
    }

    public DKMosaicDownloadManagerImpl(Context context, DKEngine dKEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) dKEngine);
        } else {
            this.mEngine = dKEngine;
            this.mContext = context;
        }
    }
}
