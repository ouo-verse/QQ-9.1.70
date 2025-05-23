package ar;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements br.a, AEEditorOrderBroadcastReceiver.AEEditorOrderListener {

    /* renamed from: a, reason: collision with root package name */
    private final long f26778a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private final long f26779b = 5000;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, com.tencent.aelight.camera.aeeditor.data.b> f26780c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private boolean f26781d = false;

    /* renamed from: e, reason: collision with root package name */
    private AEEditorOrderBroadcastReceiver f26782e = new AEEditorOrderBroadcastReceiver(this);

    /* renamed from: f, reason: collision with root package name */
    private Queue<com.tencent.aelight.camera.aeeditor.data.b> f26783f = new ArrayDeque();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements TAVCut.Callback {
        a() {
        }

        @Override // com.tencent.qcircle.tavcut.TAVCut.Callback
        public void onDone(int i3) {
            ms.a.f("AEEditorProcessManager", "TAVCut init ret code = " + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final f f26785a = new f();
    }

    f() {
        this.f26782e.registerSelf(BaseApplication.getContext());
    }

    private void d(String str) {
        VideoExporter e16;
        ms.a.f("AEEditorProcessManager", "[cancel mission]");
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar == null || bVar.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY) || (e16 = bVar.f66111i.e()) == null) {
            return;
        }
        e16.cancel();
    }

    public static f g() {
        return b.f26785a;
    }

    private void k(String str) {
        ms.a.f("AEEditorProcessManager", "[remove mission]");
        AECameraPrefsUtil.f().q(str, 4);
        AECameraPrefsUtil.f().q(str + "sourcePath", 4);
        AECameraPrefsUtil.f().q(str + "outputPath", 4);
        AECameraPrefsUtil.f().q(str + "thumbPath", 4);
        AECameraPrefsUtil.f().q(str + "status", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieId", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieCenterX", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieCenterY", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieWidthScale", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieHeightScale", 4);
        AECameraPrefsUtil.f().q(str + "mKuolieRotate", 4);
    }

    private void n(String str) {
        ms.a.f("AEEditorProcessManager", "[save mission]");
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            AECameraPrefsUtil.f().p(str, bVar.f66112j.toString(), 4);
            AECameraPrefsUtil.f().p(str + "sourcePath", bVar.f66104b, 4);
            AECameraPrefsUtil.f().p(str + "outputPath", bVar.f66105c, 4);
            AECameraPrefsUtil.f().p(str + "thumbPath", bVar.f66106d, 4);
            AECameraPrefsUtil.f().p(str + "status", bVar.f66109g, 4);
            AECameraPrefsUtil.f().p(str + "materialID", bVar.f66116n, 4);
            AECameraPrefsUtil.f().p(str + "materialName", bVar.f66117o, 4);
            AECameraPrefsUtil.f().p(str + ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID, bVar.f66118p, 4);
            AECameraPrefsUtil.f().p(str + ZPlanPublishSource.FROM_SCHEME, bVar.f66119q, 4);
            AECameraPrefsUtil.f().n(str + "showCircleTakeSame", bVar.f66120r, 4);
            AECameraPrefsUtil.f().p(str + "mKuolieId", bVar.f66121s, 4);
            AECameraPrefsUtil.f().m(str + "mKuolieCenterX", bVar.f66122t, 4);
            AECameraPrefsUtil.f().m(str + "mKuolieCenterY", bVar.f66123u, 4);
            AECameraPrefsUtil.f().m(str + "mKuolieWidthScale", bVar.f66125w, 4);
            AECameraPrefsUtil.f().m(str + "mKuolieHeightScale", bVar.f66126x, 4);
            AECameraPrefsUtil.f().m(str + "mKuolieRotate", bVar.f66124v, 4);
        }
    }

    private void o(com.tencent.aelight.camera.aeeditor.data.b bVar) {
        Intent intent = new Intent();
        intent.setAction(bVar.f66109g);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra(AEEditorConstants.GENERATE_MATERIALID, bVar.f66116n);
        intent.putExtra(AEEditorConstants.GENERATE_MATERIALNAME, bVar.f66117o);
        intent.putExtra(AEEditorConstants.GENERATE_FILTERID, bVar.f66118p);
        intent.putExtra(AEEditorConstants.GENERATE_SCHEME, bVar.f66119q);
        intent.putExtra(AEEditorConstants.GENERATE_SHOW_CIRCLE_TAKE_SAME, bVar.f66120r);
        intent.putExtra(AEEditorConstants.GENERATE_PATH, bVar.f66103a);
        intent.putExtra(AEEditorConstants.GENERATE_MISSION, bVar.f66110h);
        intent.putExtra(AEEditorConstants.GENERATE_PROGRESS, bVar.f66107e);
        intent.putExtra(AEEditorConstants.GENERATE_THUMB_PTAH, bVar.f66106d);
        intent.putExtra(AEEditorConstants.GENERATE_ERRORCODE, bVar.f66113k);
        intent.putExtra(AEEditorConstants.GENERATE_ERRORMESSAGE, bVar.f66114l);
        intent.putExtra(AEEditorConstants.GENERATE_SOURCE_PATH, bVar.f66104b);
        intent.putExtra(AEEditorConstants.GENERATE_KUOLIEID, bVar.f66121s);
        intent.putExtra(AEEditorConstants.GENERATE_CENTERX, bVar.f66122t);
        intent.putExtra(AEEditorConstants.GENERATE_CENTERY, bVar.f66123u);
        intent.putExtra(AEEditorConstants.GENERATE_WIDTHSCALE, bVar.f66125w);
        intent.putExtra(AEEditorConstants.GENERATE_HEIGHTSCALE, bVar.f66126x);
        intent.putExtra(AEEditorConstants.GENERATE_ROTATE, bVar.f66124v);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    private void q() {
        if (this.f26783f.size() == 0) {
            ms.a.f("AEEditorProcessManager", "[tryStartNext] No mission");
            return;
        }
        com.tencent.aelight.camera.aeeditor.data.b peek = this.f26783f.peek();
        if (peek != null) {
            ms.a.f("AEEditorProcessManager", "[tryStartNext] next mission");
            peek.f66115m = System.currentTimeMillis();
            peek.f66111i.run();
        }
    }

    private void r(com.tencent.aelight.camera.aeeditor.data.b bVar) {
        if (this.f26783f.size() == 0) {
            ms.a.f("AEEditorProcessManager", "[tryStartTask] size 0");
            this.f26783f.add(bVar);
            bVar.f66115m = System.currentTimeMillis();
            bVar.f66111i.run();
            return;
        }
        com.tencent.aelight.camera.aeeditor.data.b peek = this.f26783f.peek();
        long currentTimeMillis = System.currentTimeMillis();
        if (peek != null && Math.abs(currentTimeMillis - peek.f66115m) > 5000) {
            ms.a.f("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
            this.f26783f.remove(peek);
            this.f26783f.add(bVar);
            q();
            return;
        }
        ms.a.f("AEEditorProcessManager", "[tryStartTask]Dog alive");
        this.f26783f.add(bVar);
    }

    @Override // br.a
    public void a(String str) {
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            bVar.f66115m = System.currentTimeMillis();
            bVar.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_DOWNLOADING;
        }
    }

    @Override // br.a
    public void b(String str, String str2) {
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            bVar.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY;
            bVar.f66103a = str2;
            bVar.f66107e = 1.0f;
            o(bVar);
            AECameraPrefsUtil.f().p(str + "status", bVar.f66109g, 4);
            this.f26783f.remove(bVar);
            q();
        }
    }

    @Override // br.a
    public void c(String str) {
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            bVar.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_CANEL;
            bVar.f66107e = 0.0f;
            this.f26783f.remove(bVar);
            q();
        }
    }

    public void e() {
        this.f26782e.unRegisterSelf(BaseApplication.getContext());
        this.f26783f.clear();
    }

    public com.tencent.aelight.camera.aeeditor.data.b f(String str) {
        Map<String, com.tencent.aelight.camera.aeeditor.data.b> map = this.f26780c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public MediaModel h(String str) {
        String j3 = AECameraPrefsUtil.f().j(str, "", 4);
        if (TextUtils.isEmpty(j3)) {
            return null;
        }
        return (MediaModel) GsonUtils.json2Obj(j3, MediaModel.class);
    }

    public void i() {
        if (!com.tencent.aelight.camera.ae.d.j()) {
            ms.a.a("AEEditorProcessManager", "AEKitForQQ.initWithConfig() fail");
        } else {
            if (!com.tencent.aelight.camera.ae.d.u()) {
                ms.a.a("AEEditorProcessManager", "loadBasicFeaturesInLight.init() fail");
            }
            if (!FeatureManager.Features.PAG.init()) {
                ms.a.a("AEEditorProcessManager", "PAG.init() fail");
            }
            if (!FeatureManager.Features.IMAGE_ALGO.init()) {
                ms.a.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
            }
        }
        TAVCut.initTAVCut(BaseApplication.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.y(), new a());
    }

    public boolean j() {
        if (this.f26781d) {
            return true;
        }
        for (Map.Entry<String, com.tencent.aelight.camera.aeeditor.data.b> entry : this.f26780c.entrySet()) {
            if (entry.getValue().f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_DOWNLOADING) || entry.getValue().f66109g.equals("AEEDITOR_GENERATE_STATUS_WAIT")) {
                return true;
            }
        }
        return false;
    }

    public void m(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, MediaModel mediaModel, String str9, float f16, float f17, float f18, float f19, float f26) {
        com.tencent.aelight.camera.aeeditor.data.b bVar;
        if (this.f26780c.get(str5) == null) {
            com.tencent.aelight.camera.aeeditor.data.b bVar2 = new com.tencent.aelight.camera.aeeditor.data.b(str, str2, str3, str4, i3, str5, str6, str7, str8, mediaModel, str9, f16, f17, f18, f19, f26);
            this.f26780c.put(str5, bVar2);
            n(str5);
            bVar = bVar2;
        } else {
            bVar = this.f26780c.get(str5);
            if (!bVar.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR) && !bVar.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_CANEL)) {
                if (bVar.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY)) {
                    o(bVar);
                    return;
                }
                return;
            }
        }
        bVar.f66111i = new AEEditorGenerateRunnable(str5, str6, str7, mediaModel, this);
        r(bVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver.AEEditorOrderListener
    public void onAEEditorCancel(String str) {
        d(str);
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver.AEEditorOrderListener
    public void onAEEditorRemove(String str) {
        k(str);
    }

    @Override // br.a
    public void onAETavSessionExportError(String str, long j3, String str2) {
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            bVar.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR;
            bVar.f66114l = str2;
            bVar.f66107e = 0.0f;
            bVar.f66113k = j3;
            o(bVar);
            this.f26783f.remove(bVar);
            q();
        }
    }

    @Override // br.a
    public void onAETavSessionExporting(String str, float f16) {
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar != null) {
            bVar.f66115m = System.currentTimeMillis();
            bVar.f66107e = f16;
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - bVar.f66108f) > 1000) {
                bVar.f66108f = currentTimeMillis;
                o(bVar);
            }
        }
    }

    public void p(boolean z16) {
        this.f26781d = z16;
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
            return;
        }
        com.tencent.aelight.camera.aeeditor.data.b bVar = this.f26780c.get(str);
        if (bVar == null) {
            String j3 = AECameraPrefsUtil.f().j(str + "sourcePath", "", 4);
            String j16 = AECameraPrefsUtil.f().j(str + "outputPath", "", 4);
            String j17 = AECameraPrefsUtil.f().j(str + "thumbPath", "", 4);
            String j18 = AECameraPrefsUtil.f().j(str + "status", "", 4);
            String j19 = AECameraPrefsUtil.f().j(str + "materialID", "", 4);
            String j26 = AECameraPrefsUtil.f().j(str + "materialName", "", 4);
            String j27 = AECameraPrefsUtil.f().j(str + ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID, "", 4);
            String j28 = AECameraPrefsUtil.f().j(str + ZPlanPublishSource.FROM_SCHEME, "", 4);
            int g16 = AECameraPrefsUtil.f().g(str + "showCircleTakeSame", 0, 4);
            String j29 = AECameraPrefsUtil.f().j(str + "mKuolieId", "", 4);
            float e16 = AECameraPrefsUtil.f().e(str + "mKuolieCenterX", 0.0f, 4);
            float e17 = AECameraPrefsUtil.f().e(str + "mKuolieCenterY", 0.0f, 4);
            float e18 = AECameraPrefsUtil.f().e(str + "mKuolieWidthScale", 0.0f, 4);
            float e19 = AECameraPrefsUtil.f().e(str + "mKuolieHeightScale", 0.0f, 4);
            float e26 = AECameraPrefsUtil.f().e(str + "mKuolieRotate", 0.0f, 4);
            if (!TextUtils.isEmpty(j3) && !TextUtils.isEmpty(j16) && !TextUtils.isEmpty(j17) && !TextUtils.isEmpty(j18)) {
                if (j18.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY)) {
                    ms.a.f("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
                    com.tencent.aelight.camera.aeeditor.data.b bVar2 = new com.tencent.aelight.camera.aeeditor.data.b(j19, j26, j27, j28, g16, str, j3, j16, j17, null, j29, e16, e17, e18, e19, e26);
                    bVar2.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY;
                    o(bVar2);
                    return;
                }
                MediaModel h16 = h(str);
                ms.a.f("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
                if (h16 == null) {
                    com.tencent.aelight.camera.aeeditor.data.b bVar3 = new com.tencent.aelight.camera.aeeditor.data.b(j19, j26, j27, j28, g16, str, j3, j16, j17, null, j29, e16, e17, e18, e19, e26);
                    bVar3.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR;
                    bVar3.f66113k = -2L;
                    ms.a.c("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
                    o(bVar3);
                    return;
                }
                m(j19, j26, j27, j28, g16, str, j3, j16, j17, h16, j29, e16, e17, e18, e19, e26);
                return;
            }
            com.tencent.aelight.camera.aeeditor.data.b bVar4 = new com.tencent.aelight.camera.aeeditor.data.b(j19, j26, j27, j28, g16, str, j3, j16, j17, null, j29, e16, e17, e18, e19, e26);
            bVar4.f66109g = AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR;
            bVar4.f66113k = -2L;
            ms.a.c("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
            o(bVar4);
            return;
        }
        ms.a.f("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
        m(bVar.f66116n, bVar.f66117o, bVar.f66118p, bVar.f66119q, bVar.f66120r, str, bVar.f66104b, bVar.f66105c, bVar.f66106d, bVar.f66112j, bVar.f66121s, bVar.f66122t, bVar.f66123u, bVar.f66125w, bVar.f66126x, bVar.f66124v);
    }
}
