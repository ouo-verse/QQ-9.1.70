package com.tencent.open.appcommon.now.download;

import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
class DownloadCenterImpl$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f340704d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        f.h("DownloadCenterImpl", "getQueryDownloadAction enter");
        ArrayList arrayList = new ArrayList();
        int size = this.f340704d.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadInfo downloadInfo = (DownloadInfo) this.f340704d.get(i3);
            if (DownloadManager.C().W(downloadInfo)) {
                arrayList.add(downloadInfo);
            }
        }
        Iterator it = this.this$0.f340706a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(arrayList);
        }
    }
}
