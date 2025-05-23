package com.tencent.mobileqq.wink.edit.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkEditorResManager extends WinkEditorResDownloader {

    /* renamed from: o, reason: collision with root package name */
    private static volatile WinkEditorResManager f318246o;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318247h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318248i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318249j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318250k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318251l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318252m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f318253n;

    WinkEditorResManager() {
        super("winkEdit/wink_editor_download_resources.json", "WinkEditorResManager", u53.b.f438371b);
        this.f318247h = new LinkedHashMap();
        this.f318248i = new LinkedHashMap();
        this.f318249j = new LinkedHashMap();
        this.f318250k = new ConcurrentHashMap();
        this.f318251l = new LinkedHashMap();
        this.f318252m = new LinkedHashMap();
        this.f318253n = new LinkedHashMap();
    }

    public static WinkEditorResManager q() {
        if (f318246o == null) {
            synchronized (WinkEditorResManager.class) {
                if (f318246o == null) {
                    f318246o = new WinkEditorResManager();
                }
            }
        }
        return f318246o;
    }

    public void n(final String str, final ResDownLoadListener resDownLoadListener) {
        if (TextUtils.isEmpty(str)) {
            if (resDownLoadListener != null) {
                resDownLoadListener.onDownloadFinish(false);
                return;
            }
            return;
        }
        j(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorResManager.1
            @Override // java.lang.Runnable
            public void run() {
                w53.b.f(WinkEditorResManager.this.f318233c, "downLoadResource--by user--BEGIN id: " + str);
                WinkEditorResManager winkEditorResManager = WinkEditorResManager.this;
                winkEditorResManager.m(winkEditorResManager.f318231a);
                AEEditorDownloadResBean d16 = WinkEditorResManager.this.d(str);
                if (d16 != null) {
                    WinkEditorResManager.this.b(d16, resDownLoadListener);
                    return;
                }
                w53.b.c(WinkEditorResManager.this.f318233c, "downLoadResource--by user--FAIL, no download config for id: " + str);
                ResDownLoadListener resDownLoadListener2 = resDownLoadListener;
                if (resDownLoadListener2 != null) {
                    resDownLoadListener2.onDownloadFinish(false);
                }
            }
        });
    }

    @NonNull
    public String o(MetaMaterial metaMaterial) {
        return k.c(this.f318232b, metaMaterial.f30533id, metaMaterial.packageMd5);
    }

    public String p(MetaMaterial metaMaterial) {
        return k.c(this.f318232b, metaMaterial.f30533id, metaMaterial.packageMd5) + File.separator + "effectInfo.json";
    }
}
