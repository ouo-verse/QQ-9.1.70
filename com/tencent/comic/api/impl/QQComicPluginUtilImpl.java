package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.plugin.c;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.a;
import com.tencent.comic.utils.d;
import com.tencent.mobileqq.hitrate.b;
import java.util.Observer;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class QQComicPluginUtilImpl implements IQQComicPluginUtil {
    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public boolean launchPlugin(Activity activity, Intent intent, String str, b bVar) {
        return QQComicPluginBridge.f(activity, intent, str, bVar);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void loadComicModule(Context context) {
        QQComicPluginBridge.g(context);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void notifyChangedWhenRuntimeCreated() {
        d dVar = QQComicPluginBridge.f99475d;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public boolean preloadPubilcProcess(c cVar, String str, AppRuntime appRuntime, String str2, int i3, long j3, int[] iArr, IQQComicPluginUtil.a aVar) {
        return com.tencent.comic.c.a(cVar, str, appRuntime, str2, i3, j3, iArr, aVar);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void reportHitRate(int i3, int i16, int i17, int i18, String str, String str2) {
        com.tencent.comic.b.a(a.a(), i3, i16, i17, i18, str, str2);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void reportPreload(AppRuntime appRuntime, int i3, int i16, long j3) {
        com.tencent.comic.utils.c.a(appRuntime, i3, i16, j3);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void setDownloadObserver(com.tencent.comic.jsp.b bVar) {
        boolean z16 = QQComicPluginBridge.f99473b;
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void setFirstInObserver(Observer observer) {
        QQComicPluginBridge.k(observer);
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void setJsPluginBuilder(com.tencent.comic.jsp.d dVar) {
        boolean z16 = QQComicPluginBridge.f99473b;
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void setPluginReady(boolean z16) {
        QQComicPluginBridge.f99473b = z16;
    }

    @Override // com.tencent.comic.api.IQQComicPluginUtil
    public void reportProcBeKiiled(AppRuntime appRuntime, int i3, int i16, int i17, long j3) {
        com.tencent.comic.b.b(appRuntime, i3, i16, i17, j3, new String[0]);
    }
}
