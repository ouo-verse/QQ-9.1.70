package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.part.c;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class PlayDownloadManagerWrap {
    private static final String TAG = "PlayDownloadManagerWrap";
    private WeakReference<c> mPartManager;
    private final Map<String, com.tencent.aelight.camera.download.a> downloadingMap = new HashMap();
    private final Map<String, List<IProgressObserver>> observerMap = new HashMap();
    private String finalDownloadId = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class InstanceHolder {
        public static final PlayDownloadManagerWrap multiDownloadManager = new PlayDownloadManagerWrap();

        InstanceHolder() {
        }
    }

    PlayDownloadManagerWrap() {
    }

    private void addDownloadListener(String str, com.tencent.aelight.camera.download.a aVar) {
        synchronized (this.downloadingMap) {
            this.downloadingMap.put(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDownloadListener(String str) {
        synchronized (this.downloadingMap) {
            this.downloadingMap.remove(str);
        }
    }

    public static PlayDownloadManagerWrap getInstance() {
        return InstanceHolder.multiDownloadManager;
    }

    private boolean isListenerExits(String str) {
        boolean z16;
        synchronized (this.downloadingMap) {
            z16 = this.downloadingMap.get(str) != null;
        }
        return z16;
    }

    public synchronized void addProgressObserver(String str, IProgressObserver iProgressObserver) {
        if (iProgressObserver != null) {
            List<IProgressObserver> list = this.observerMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.contains(iProgressObserver)) {
                list.add(iProgressObserver);
                this.observerMap.put(str, list);
            }
        }
    }

    public Map<String, com.tencent.aelight.camera.download.a> getDownloadingMap() {
        return this.downloadingMap;
    }

    public String getFinalDownloadId() {
        return this.finalDownloadId;
    }

    public synchronized void notifyDownloadFinish(final AEMaterialMetaData aEMaterialMetaData, boolean z16) {
        if (aEMaterialMetaData == null) {
            return;
        }
        String str = aEMaterialMetaData.f69050id;
        List<IProgressObserver> list = this.observerMap.get(str);
        String str2 = this.finalDownloadId;
        if (str2 != null && str2.equals(str) && z16 && aEMaterialMetaData.equals(AEPlayShowGridAdapter.selectedMaterial)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    int i3 = aEMaterialMetaData.playShowType;
                    if (i3 == 0) {
                        if (PlayDownloadManagerWrap.this.mPartManager == null || PlayDownloadManagerWrap.this.mPartManager.get() == 0) {
                            return;
                        }
                        AEPlayShowGridAdapter.selectedMidMaterial = aEMaterialMetaData;
                        ((c) PlayDownloadManagerWrap.this.mPartManager.get()).q(393218, aEMaterialMetaData);
                        return;
                    }
                    if ((i3 != 4 && i3 != 5 && i3 != 6 && i3 != 7) || PlayDownloadManagerWrap.this.mPartManager == null || PlayDownloadManagerWrap.this.mPartManager.get() == 0) {
                        return;
                    }
                    ((c) PlayDownloadManagerWrap.this.mPartManager.get()).q(655361, aEMaterialMetaData);
                }
            });
        }
        if (list == null) {
            this.observerMap.remove(str);
            return;
        }
        Iterator<IProgressObserver> it = list.iterator();
        while (it.hasNext()) {
            it.next().onDownloadFinish(str, z16);
        }
        this.observerMap.remove(str);
    }

    public synchronized void notifyDownloadProgress(String str, int i3) {
        List<IProgressObserver> list = this.observerMap.get(str);
        if (list == null) {
            this.observerMap.remove(str);
            return;
        }
        Iterator<IProgressObserver> it = list.iterator();
        while (it.hasNext()) {
            it.next().onProgressUpdate(str, i3);
        }
    }

    public synchronized void removeProgressObserver(String str, IProgressObserver iProgressObserver) {
        List<IProgressObserver> list = this.observerMap.get(str);
        if (list != null && list.size() > 1) {
            Iterator<IProgressObserver> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == iProgressObserver) {
                    it.remove();
                }
            }
        }
        if (list == null || list.size() < 1) {
            this.observerMap.remove(str);
        }
    }

    public void startDownload(c cVar, final AEMaterialManager aEMaterialManager, final AEMaterialMetaData aEMaterialMetaData) {
        if (isListenerExits(aEMaterialMetaData.f69050id)) {
            return;
        }
        WeakReference<c> weakReference = this.mPartManager;
        if (weakReference == null || weakReference.get() == null) {
            this.mPartManager = new WeakReference<>(cVar);
        }
        final DownloadProcessListener downloadProcessListener = new DownloadProcessListener();
        addDownloadListener(aEMaterialMetaData.f69050id, downloadProcessListener);
        this.finalDownloadId = aEMaterialMetaData.f69050id;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.1
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialManager aEMaterialManager2 = aEMaterialManager;
                aEMaterialManager2.E0(aEMaterialManager2.getApp(), aEMaterialMetaData, downloadProcessListener);
                aEMaterialMetaData.downloading = true;
            }
        }, 128, null, true);
    }

    public void clearObserver() {
        this.mPartManager = null;
        this.observerMap.clear();
    }

    /* loaded from: classes32.dex */
    private static class DownloadProcessListener implements com.tencent.aelight.camera.download.a {
        DownloadProcessListener() {
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            if (aEMaterialMetaData == null) {
                return;
            }
            aEMaterialMetaData.downloading = false;
            if (z16) {
                aEMaterialMetaData.usable = true;
            } else {
                QLog.e(PlayDownloadManagerWrap.TAG, 1, "download failed with id: " + aEMaterialMetaData.f69050id);
            }
            PlayDownloadManagerWrap.getInstance().notifyDownloadFinish(aEMaterialMetaData, z16);
            PlayDownloadManagerWrap.getInstance().deleteDownloadListener(aEMaterialMetaData.f69050id);
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
            if (i3 <= 1) {
                return;
            }
            PlayDownloadManagerWrap.getInstance().notifyDownloadProgress(aEMaterialMetaData.f69050id, i3);
        }
    }
}
