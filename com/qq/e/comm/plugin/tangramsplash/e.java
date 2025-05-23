package com.qq.e.comm.plugin.tangramsplash;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.TGSPPIV2;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements TGSPPIV2 {

    /* renamed from: a, reason: collision with root package name */
    private static final com.qq.e.comm.plugin.tangramsplash.c.e f39880a = com.qq.e.comm.plugin.tangramsplash.c.e.a();

    /* renamed from: b, reason: collision with root package name */
    private static final e f39881b = new e();

    /* renamed from: c, reason: collision with root package name */
    private com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d f39882c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39883d;

    e() {
        this.f39883d = false;
        boolean a16 = com.qq.e.comm.plugin.j.c.a();
        this.f39883d = a16;
        if (a16) {
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d a17 = com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d.a();
            this.f39882c = a17;
            a17.b();
        }
    }

    public static TGSPPIV2 a() {
        return f39881b;
    }

    @Override // com.qq.e.comm.pi.TGSPPI
    public void downloadRes(String str, boolean z16) {
        f39880a.a(str, z16);
    }

    @Override // com.qq.e.comm.pi.TGSPPIV2, com.qq.e.comm.pi.TGSPPI
    public void pauseDownload() {
        com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(true);
        com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a();
    }

    @Override // com.qq.e.comm.pi.TGSPPI
    public void preload(Context context, String str, String str2, LoadAdParams loadAdParams, ICustomAdDataGenerator iCustomAdDataGenerator) {
        if (loadAdParams != null) {
            com.qq.e.comm.plugin.j.e.a().a(loadAdParams.getExperimentType(), loadAdParams.getExperimentId(), str2);
            if (!loadAdParams.canSetupRequest()) {
                GDTLogger.e("not allow setup preload request, select now");
                c.b bVar = new c.b();
                bVar.f40338e = loadAdParams;
                bVar.f40334a = str;
                bVar.f40335b = str2;
                bVar.f40341h = iCustomAdDataGenerator;
                bVar.f40337d = new l(str2, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
                bVar.f40336c = com.qq.e.comm.plugin.k.a.a(str, str2, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
                com.qq.e.comm.plugin.tangramsplash.c.e.a().a(bVar, loadAdParams.isHotStart());
                return;
            }
        }
        com.qq.e.comm.plugin.i.f.a(context).a(false);
        if (this.f39883d) {
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c c16 = this.f39882c.c();
            if (c16 != null) {
                c16.a(iCustomAdDataGenerator);
            }
            new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c(str, str2, loadAdParams).a();
            return;
        }
        f39880a.a(context, str, str2, loadAdParams);
    }

    @Override // com.qq.e.comm.pi.TGSPPIV2
    public void removeListener(int i3) {
        f39880a.a(i3);
    }

    @Override // com.qq.e.comm.pi.TGSPPIV2
    public void resetNotAllowDownloadStatus() {
        com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(false);
    }

    @Override // com.qq.e.comm.pi.TGSPPI
    public void setPreloadListener(ADListener aDListener, int i3) {
        f39880a.a(aDListener, i3);
    }
}
