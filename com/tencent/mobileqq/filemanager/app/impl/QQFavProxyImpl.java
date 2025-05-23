package com.tencent.mobileqq.filemanager.app.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class QQFavProxyImpl implements IQQFavProxy {
    static String FTL = "FavFileS ";
    static String TAG = "QQFavProxy<FileAssistant>";
    private BaseQQAppInterface mApp;
    private HashMap<Long, IQQFavProxy.a> mResultCbs = null;
    private HashSet<IQQFavProxy.b> mListeners = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGettedFileList(long j3, List<FavFileInfo> list, Bundle bundle) {
        int i3;
        boolean z16;
        String str = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FTL);
        sb5.append("onGettedFileList. reqTimeStamp:");
        sb5.append(j3);
        sb5.append(" size:");
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.i(str, 1, sb5.toString());
        if (this.mResultCbs != null) {
            if (bundle != null) {
                z16 = bundle.getBoolean("fecth_operate_end");
            } else {
                z16 = true;
            }
            IQQFavProxy.a aVar = this.mResultCbs.get(Long.valueOf(j3));
            if (aVar == null) {
                return;
            }
            if (aVar.f207019b == null) {
                aVar.f207019b = new ArrayList();
            }
            if (z16) {
                this.mResultCbs.remove(Long.valueOf(j3));
                if (list != null) {
                    aVar.f207019b.addAll(list);
                }
                if (bundle != null) {
                    aVar.f207018a = bundle.getLong("resultTimestamp");
                }
                aVar.a(0, aVar.f207019b, bundle);
                return;
            }
            QLog.i(TAG, 1, FTL + "onGettedFileList. fav is getting and waiting");
            if (list != null) {
                aVar.f207019b.addAll(list);
            }
            if (bundle != null) {
                aVar.f207018a = bundle.getLong("resultTimestamp");
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void addListener(IQQFavProxy.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mListeners.add(bVar);
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void cancelGetFileList(long j3) {
        QLog.i(TAG, 1, FTL + "cancelGetFileList. reqTimeStamp:" + j3);
        HashMap<Long, IQQFavProxy.a> hashMap = this.mResultCbs;
        if (hashMap != null) {
            hashMap.remove(Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void deleteListener(IQQFavProxy.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mListeners.remove(bVar);
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void downloadThumb(FavFileInfo favFileInfo, int i3) {
        int i16 = 64;
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 128;
            } else if (i3 == 2) {
                i16 = 320;
            } else if (i3 == 3) {
                i16 = 640;
            } else if (i3 == 4) {
                i16 = 1024;
            }
        }
        QLog.i(TAG, 1, FTL + "downloadThumb. favId:" + favFileInfo.f207672d + " format:" + i16);
        ((IQQFavHelper) this.mApp.getRuntimeService(IQQFavHelper.class)).downloadThumb(this.mApp, favFileInfo, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void getFileList(long j3, boolean z16, Bundle bundle, IQQFavProxy.a aVar) {
        QLog.i(TAG, 1, FTL + "getFileList. lastTimestamp:" + j3);
        if (this.mResultCbs == null) {
            this.mResultCbs = new HashMap<>();
        }
        if (aVar != null) {
            this.mResultCbs.put(Long.valueOf(j3), aVar);
        }
        ((IQQFavHelper) this.mApp.getRuntimeService(IQQFavHelper.class)).getFavList(this.mApp, j3, z16, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public long getGettedPartList(long j3, List<FavFileInfo> list) {
        List<FavFileInfo> list2;
        HashMap<Long, IQQFavProxy.a> hashMap = this.mResultCbs;
        if (hashMap != null) {
            IQQFavProxy.a aVar = hashMap.get(Long.valueOf(j3));
            if (list != null && aVar != null && (list2 = aVar.f207019b) != null) {
                list.addAll(list2);
            }
            if (aVar != null) {
                return aVar.f207018a;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = (BaseQQAppInterface) appRuntime;
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void onFileDownloaded(final long j3, final String str) {
        QLog.i(TAG, 1, FTL + "onFileDownloaded. favId:" + j3 + " strSavePath:" + str + "lz:" + this.mListeners.size());
        if (this.mListeners.size() == 0) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = QQFavProxyImpl.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((IQQFavProxy.b) it.next()).onFileDownloaded(j3, str);
                    }
                }
            });
            return;
        }
        Iterator<IQQFavProxy.b> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onFileDownloaded(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void onFileListRefreshed(final boolean z16, final Bundle bundle) {
        String str;
        if (bundle != null) {
            str = bundle.getString(IQQFavProxy.DELETE_FAVIDS);
        } else {
            str = "";
        }
        QLog.i(TAG, 1, FTL + "onFileListRefreshed. bSuc:" + z16 + " delFavIds:" + str);
        if (this.mListeners.size() == 0) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = QQFavProxyImpl.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((IQQFavProxy.b) it.next()).onFileListRefreshed(z16, bundle);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFileThumbUpdated(final long j3, final String str, int i3) {
        final int i16;
        Looper mainLooper;
        int i17 = 1;
        QLog.i(TAG, 1, FTL + "onFileThumbUpdated. favId:" + j3 + " strThumbPath:" + str + " format:" + i3 + " lz:" + this.mListeners.size());
        if (this.mListeners.size() == 0) {
            return;
        }
        if (i3 != 64) {
            if (i3 != 128) {
                if (i3 == 320) {
                    i17 = 2;
                }
            }
            i16 = i17;
            mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() == mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = QQFavProxyImpl.this.mListeners.iterator();
                        while (it.hasNext()) {
                            ((IQQFavProxy.b) it.next()).a(j3, i16, str);
                        }
                    }
                });
                return;
            }
            Iterator<IQQFavProxy.b> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().a(j3, i16, str);
            }
            return;
        }
        i16 = 0;
        mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void onGettedFileList(final long j3, final List<FavFileInfo> list, final Bundle bundle) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QQFavProxyImpl.this.handleGettedFileList(j3, list, bundle);
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public boolean refreshList(Bundle bundle) {
        QLog.i(TAG, 1, FTL + "refreshList.");
        return ((IQQFavHelper) this.mApp.getRuntimeService(IQQFavHelper.class)).refreshList(this.mApp, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy
    public void sendFavFiles(List<FavFileInfo> list, String str, String str2, int i3, Bundle bundle) {
        QLog.i(TAG, 1, FTL + "sendFavFiles. size:" + list.size() + " strToUin:" + str + " strToUid:" + str2 + " toUinType:" + i3);
        ((IQQFavHelper) this.mApp.getRuntimeService(IQQFavHelper.class)).forwardFavFileList(this.mApp, list, str, str2, i3);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
