package fv2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.effectreport.SpaAdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import java.util.HashMap;
import java.util.Map;
import pw2.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, String> f400842a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, String> f400843b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, String> f400844c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        this.f400842a.put(1, SpaEffectReportActionKey.ID_START_FROM_APP_CLIENT);
        this.f400842a.put(2, SpaEffectReportActionKey.ID_START_FROM_H5);
        this.f400842a.put(3, SpaEffectReportActionKey.ID_START_FROM_APP_DIRECT);
        this.f400842a.put(4, SpaEffectReportActionKey.ID_START_FROM_CONFIRM);
        this.f400842a.put(5, SpaEffectReportActionKey.ID_LINKAGE_AD_START_DOWNLOAD);
        this.f400842a.put(6, SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_START_DOWNLOAD);
        this.f400842a.put(7, SpaEffectReportActionKey.ID_START_FROM_H5_AUTO_DOWNLOAD);
        this.f400843b.put(1, SpaEffectReportActionKey.ID_FINISH_FROM_APP_CLIENT);
        this.f400843b.put(2, SpaEffectReportActionKey.ID_FINISH_FROM_H5);
        this.f400843b.put(3, SpaEffectReportActionKey.ID_FINISH_FROM_APP_DIRECT);
        this.f400843b.put(4, SpaEffectReportActionKey.ID_FINISH_FROM_CONFIRM);
        this.f400843b.put(5, SpaEffectReportActionKey.ID_LINKAGE_AD_COMPLETE_DOWNLOAD);
        this.f400843b.put(6, SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_COMPLETE_DOWNLOAD);
        this.f400843b.put(7, SpaEffectReportActionKey.ID_FINISH_FROM_H5_AUTO_DOWNLOAD);
        this.f400844c.put(1, SpaEffectReportActionKey.ID_INSTALL_FROM_APP_CLIENT);
        this.f400844c.put(2, SpaEffectReportActionKey.ID_INSTALL_FROM_H5);
        this.f400844c.put(3, SpaEffectReportActionKey.ID_INSTALL_FROM_APP_DIRECT);
        this.f400844c.put(4, SpaEffectReportActionKey.ID_INSTALL_FROM_CONFIRM);
        this.f400844c.put(5, SpaEffectReportActionKey.ID_LINKAGE_AD_COMPLETE_INSTALL);
        this.f400844c.put(6, SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_COMPLETE_INSTALL);
        this.f400844c.put(7, SpaEffectReportActionKey.ID_INSTALL_FROM_H5_AUTO_DOWNLOAD);
    }

    private String h(int i3) {
        return x.a(this.f400843b.get(Integer.valueOf(i3)));
    }

    private String i(int i3) {
        return x.a(this.f400842a.get(Integer.valueOf(i3)));
    }

    private String j(int i3) {
        return x.a(this.f400844c.get(Integer.valueOf(i3)));
    }

    private boolean k(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
        f fVar;
        if (bVar != null && (fVar = bVar.f303770a) != null && fVar.f303829t != null && eVar != null) {
            return false;
        }
        return true;
    }

    @Override // fv2.a
    public void c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
        if (k(bVar, eVar)) {
            return;
        }
        String j3 = j(bVar.f303770a.f303829t.from);
        SpaAdParam spaAdParam = bVar.f303770a.f303829t;
        iv2.c.c(spaAdParam.adId, spaAdParam.adPos, spaAdParam.adReport, spaAdParam.clickId, j3, spaAdParam.adReportKey, spaAdParam.adReportParam);
    }

    @Override // fv2.a
    public void d(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
        if (k(bVar, eVar)) {
            return;
        }
        String h16 = h(bVar.f303770a.f303829t.from);
        SpaAdParam spaAdParam = bVar.f303770a.f303829t;
        iv2.c.c(spaAdParam.adId, spaAdParam.adPos, spaAdParam.adReport, spaAdParam.clickId, h16, spaAdParam.adReportKey, spaAdParam.adReportParam);
    }

    @Override // fv2.a
    public void g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
        if (!k(bVar, eVar) && eVar.f()) {
            String i3 = i(bVar.f303770a.f303829t.from);
            SpaAdParam spaAdParam = bVar.f303770a.f303829t;
            iv2.c.c(spaAdParam.adId, spaAdParam.adPos, spaAdParam.adReport, spaAdParam.clickId, i3, spaAdParam.adReportKey, spaAdParam.adReportParam);
        }
    }

    @Override // fv2.a
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
    }

    @Override // fv2.a
    public void b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
    }

    @Override // fv2.a
    public void e(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
    }

    @Override // fv2.a
    public void f(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar, e eVar) {
    }
}
