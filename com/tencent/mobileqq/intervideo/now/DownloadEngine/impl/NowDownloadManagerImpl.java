package com.tencent.mobileqq.intervideo.now.DownloadEngine.impl;

import android.content.Context;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.a;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowDownloadManagerImpl implements INowDownloadManager {
    private c nowDownloadManager;

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void addDownloadListener(String str, a aVar) {
        this.nowDownloadManager.d(str, aVar);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void addNowDownloadTask(Object obj) {
        this.nowDownloadManager.e((f52.a) obj);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void init(Context context) {
        this.nowDownloadManager.h(context);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void removeDownloadListener(String str) {
        this.nowDownloadManager.i(str);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void removeDownloadTask(String str, boolean z16) {
        this.nowDownloadManager.j(str, z16);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void startDownload(Object obj) {
        this.nowDownloadManager.m((f52.a) obj);
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public void unInit() {
        this.nowDownloadManager.n();
    }

    @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
    public INowDownloadManager createObject(boolean z16) {
        if (z16) {
            this.nowDownloadManager = c.f238295h;
        } else {
            this.nowDownloadManager = new c();
        }
        return this;
    }
}
