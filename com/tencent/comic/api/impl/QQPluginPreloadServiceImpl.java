package com.tencent.comic.api.impl;

import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.comic.api.plugin.b;
import com.tencent.comic.d;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class QQPluginPreloadServiceImpl implements IQQPluginPreloadService {
    public d manager;

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.manager = new d(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        d dVar = this.manager;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.tencent.comic.api.IQQPluginPreloadService
    public void preload(int i3) {
    }

    @Override // com.tencent.comic.api.IQQPluginPreloadService
    public void preload(int i3, int i16) {
    }

    @Override // com.tencent.comic.api.IQQPluginPreloadService
    public void preload(b bVar, int i3) {
    }
}
