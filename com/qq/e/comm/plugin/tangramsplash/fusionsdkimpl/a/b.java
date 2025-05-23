package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.i.f;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.tangramsplash.c.e;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.resdownload.ResRequest;
import com.tencent.ams.fusion.service.resdownload.d;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements com.tencent.ams.fusion.service.resdownload.c {

    /* renamed from: a, reason: collision with root package name */
    f f40005a = f.a(GDTADManager.getInstance().getAppContext());

    @Override // com.tencent.ams.fusion.service.resdownload.c
    public void a(ResRequest resRequest, com.tencent.ams.fusion.service.resdownload.a aVar) {
        if (!(resRequest instanceof d)) {
            GDTLogger.e("startDownload with null resRequest");
            return;
        }
        d dVar = (d) resRequest;
        if (dVar.f() instanceof r) {
            r rVar = (r) dVar.f();
            if (a(dVar, rVar)) {
                GDTLogger.i("TGDownloadServiceImpl: startDownload, resource url(" + dVar.a() + ") has download finish, return");
                if (aVar != null) {
                    aVar.e();
                    return;
                }
                return;
            }
            h a16 = new h.a().c(resRequest.a()).a(resRequest.b()).a(new File(resRequest.c())).a(resRequest.d()).b(rVar.al()).a();
            GDTLogger.i("PcdnSDKManager mOpenPcdn :" + rVar.ah() + " mSafeTimeout :" + rVar.aj() + " mEmergencyTimeout :" + rVar.ak());
            if (rVar.ah() && com.qq.e.comm.plugin.h.d.b()) {
                e.a().a(rVar.f(), rVar.s(), dVar.a(), dVar.e(), false, rVar.ak(), rVar.aj(), rVar.y(), dVar.g(), a16.b(), a16, aVar, rVar.ai());
                return;
            }
            GDTLogger.d("fusion download start : file name :" + resRequest.b() + ", url :" + resRequest.a());
            a(dVar, rVar, a16, resRequest.a(), this.f40005a, aVar);
        }
    }

    private void a(d dVar, r rVar, h hVar, String str, f fVar, com.tencent.ams.fusion.service.resdownload.a aVar) {
        a aVar2 = new a(dVar, rVar);
        aVar2.a(aVar);
        fVar.a(hVar, str, aVar2);
    }

    private boolean a(d dVar, r rVar) {
        if (dVar == null) {
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, req is null, return false");
            return false;
        }
        if (rVar == null) {
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, adInfo is null, return false");
            return false;
        }
        File a16 = at.a(dVar.e(), rVar.s(), dVar.a());
        if (a16 != null && a16.exists()) {
            if (dVar.e() == 3) {
                GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, src had downloaded and src is a zip, unzip src");
                c.a(dVar, rVar);
            }
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, src had downloaded, return true");
            return true;
        }
        if (dVar.e() != 3) {
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, src is not existed and not a zip resource, return false");
            return false;
        }
        InteractiveInfo bJ = rVar.bJ();
        if (bJ == null) {
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, interactiveInfo is null, return false");
            return false;
        }
        String a17 = dVar.a();
        if (TextUtils.isEmpty(a17)) {
            GDTLogger.i("TGDownloadServiceImpl: isResourceDownloaded, url is null or empty, return false");
            return false;
        }
        if (rVar.aI() && a17.equals(bJ.K())) {
            return com.qq.e.comm.plugin.tangramsplash.b.c.b(rVar);
        }
        if (rVar.aJ() && a17.equals(bJ.K())) {
            return com.qq.e.comm.plugin.tangramsplash.b.c.c(rVar);
        }
        return false;
    }
}
