package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.MaterialRaceInfo;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.control.AEQIMAsyncManager;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.util.WeakReference;
import org.light.DeviceSupportUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMaterialManager extends AEQIMAsyncManager {

    /* renamed from: t, reason: collision with root package name */
    private static AEMaterialMetaData f63516t = null;

    /* renamed from: u, reason: collision with root package name */
    private static AEMaterialMetaData f63517u = null;

    /* renamed from: v, reason: collision with root package name */
    public static volatile boolean f63518v = false;

    /* renamed from: w, reason: collision with root package name */
    public static volatile boolean f63519w = false;

    /* renamed from: a, reason: collision with root package name */
    private yq2.b f63520a;

    /* renamed from: b, reason: collision with root package name */
    private AEMaterialCategory f63521b;

    /* renamed from: c, reason: collision with root package name */
    private AEMaterialCategory f63522c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f63523d = false;

    /* renamed from: e, reason: collision with root package name */
    private final List<AEMaterialCategory> f63524e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<AEMaterialCategory> f63525f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final List<AEMaterialCategory> f63526g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<AEMaterialCategory> f63527h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final List<AEMaterialMetaData> f63528i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private final List<AEMaterialMetaData> f63529j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private final Object f63530k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private final Object f63531l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private final Object f63532m = new Object();

    /* renamed from: n, reason: collision with root package name */
    private final Object f63533n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private boolean f63534o = false;

    /* renamed from: p, reason: collision with root package name */
    private final Object f63535p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<MaterialRaceInfo> f63536q = null;

    /* renamed from: r, reason: collision with root package name */
    private String f63537r = "";

    /* renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f63538s = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Comparator<MaterialRaceInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialRaceInfo materialRaceInfo, MaterialRaceInfo materialRaceInfo2) {
            if (materialRaceInfo.CategoryName.equals(materialRaceInfo2.CategoryName)) {
                return materialRaceInfo.CategoryName.compareTo(materialRaceInfo2.CategoryName);
            }
            return materialRaceInfo.Position - materialRaceInfo2.Position;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends TypeToken<ArrayList<ps.a>> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f63549d;

        c(WeakReference weakReference) {
            this.f63549d = weakReference;
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            AEMaterialMetaData q16 = AEMaterialManager.this.q(aEMaterialMetaData);
            if (q16 != null) {
                q16.usable = AEMaterialManager.W(aEMaterialMetaData);
            }
            WeakReference weakReference = this.f63549d;
            if (weakReference == null || weakReference.get() == 0) {
                return;
            }
            ((com.tencent.aelight.camera.download.a) this.f63549d.get()).onDownloadFinish(aEMaterialMetaData, z16, i3);
            if (q16 != null) {
                ms.a.f("AEMaterialManager", "\u3010END\u3011onDownloadFinish :" + q16.f69050id);
            }
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
            WeakReference weakReference = this.f63549d;
            if (weakReference == null || weakReference.get() == 0) {
                return;
            }
            ((com.tencent.aelight.camera.download.a) this.f63549d.get()).onProgressUpdate(aEMaterialMetaData, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.download.a f63551d;

        d(com.tencent.aelight.camera.download.a aVar) {
            this.f63551d = aVar;
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            AEMaterialMetaData q16 = AEMaterialManager.this.q(aEMaterialMetaData);
            if (q16 != null) {
                q16.usable = AEMaterialManager.W(aEMaterialMetaData);
            }
            com.tencent.aelight.camera.download.a aVar = this.f63551d;
            if (aVar != null) {
                aVar.onDownloadFinish(aEMaterialMetaData, z16, i3);
                if (q16 != null) {
                    ms.a.f("AEMaterialManager", "\u3010END\u3011onDownloadFinish :" + q16.f69050id);
                }
            }
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
            com.tencent.aelight.camera.download.a aVar = this.f63551d;
            if (aVar != null) {
                aVar.onProgressUpdate(aEMaterialMetaData, i3);
            }
        }
    }

    public AEMaterialManager() {
        AEMaterialCategory aEMaterialCategory = new AEMaterialCategory(G());
        this.f63521b = aEMaterialCategory;
        aEMaterialCategory.f69044d = new ArrayList(100);
        AEMaterialCategory aEMaterialCategory2 = new AEMaterialCategory(G());
        this.f63522c = aEMaterialCategory2;
        aEMaterialCategory2.f69044d = new ArrayList(100);
    }

    public static File C(AEMaterialMetaData aEMaterialMetaData) {
        return new File(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(AppInterface appInterface, String str, AEMaterialMetaData aEMaterialMetaData, com.tencent.aelight.camera.download.a aVar) {
        String str2;
        AEMaterialDownloader.l(appInterface, aEMaterialMetaData, str, new d(aVar));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u3010START\u3011startDownloadMaterial :");
        if (aEMaterialMetaData == null) {
            str2 = "null";
        } else {
            str2 = aEMaterialMetaData.f69050id;
        }
        sb5.append(str2);
        ms.a.f("AEMaterialManager", sb5.toString());
    }

    public static String D() {
        File file = new File(g.a.b.f65263l);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(AppInterface appInterface, String str, AEMaterialMetaData aEMaterialMetaData, com.tencent.aelight.camera.download.a aVar) {
        String str2;
        AEMaterialDownloader.l(appInterface, aEMaterialMetaData, str, new c(new WeakReference(aVar)));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u3010START\u3011startDownloadMaterial :");
        if (aEMaterialMetaData == null) {
            str2 = "null";
        } else {
            str2 = aEMaterialMetaData.f69050id;
        }
        sb5.append(str2);
        ms.a.f("AEMaterialManager", sb5.toString());
    }

    private AEMaterialMetaData E(String str) {
        synchronized (this.f63524e) {
            Iterator<AEMaterialCategory> it = this.f63525f.iterator();
            while (it.hasNext()) {
                for (AEMaterialMetaData aEMaterialMetaData : it.next().f69044d) {
                    if (aEMaterialMetaData.f69050id.equals(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AEMaterialManager", 2, "getNormalStickerMaterial---found id=" + str);
                        }
                        return aEMaterialMetaData;
                    }
                }
            }
            return null;
        }
    }

    @Nullable
    public static ArrayList<ps.a> F0(@Nullable String str) {
        return (ArrayList) GsonUtils.json2Obj(str, new b().getType());
    }

    public static boolean G0() {
        return V("ai.face3d");
    }

    public static AEMaterialMetaData H() {
        return f63516t;
    }

    public static boolean H0() {
        return V("ai.segmentHair");
    }

    public static AEMaterialMetaData J() {
        return f63517u;
    }

    private HashMap<String, AEMaterialCategory> K(@Nullable AEMaterialCategory aEMaterialCategory) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getSpecificCategory: item.name = ");
        if (aEMaterialCategory == null) {
            str = "null";
        } else {
            str = aEMaterialCategory.f69047h;
        }
        sb5.append(str);
        ms.a.a("AEMaterialManager", sb5.toString());
        HashMap<String, AEMaterialCategory> hashMap = new HashMap<>();
        AEMaterialCategory aEMaterialCategory2 = new AEMaterialCategory();
        AEMaterialCategory aEMaterialCategory3 = new AEMaterialCategory();
        if (aEMaterialCategory != null && aEMaterialCategory.f69044d != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (AEMaterialMetaData aEMaterialMetaData : aEMaterialCategory.f69044d) {
                if ("circleCamera".equals(aEMaterialMetaData.showEntry)) {
                    arrayList2.add(aEMaterialMetaData);
                } else {
                    arrayList.add(aEMaterialMetaData);
                }
            }
            aEMaterialCategory2.f69044d = arrayList;
            aEMaterialCategory2.f69045e = aEMaterialCategory.f69045e;
            aEMaterialCategory2.f69047h = aEMaterialCategory.f69047h;
            aEMaterialCategory2.f69046f = aEMaterialCategory.f69046f;
            aEMaterialCategory2.f69049m = aEMaterialCategory.f69049m;
            aEMaterialCategory2.f69048i = aEMaterialCategory.f69048i;
            aEMaterialCategory3.f69044d = arrayList2;
            aEMaterialCategory3.f69045e = aEMaterialCategory.f69045e;
            aEMaterialCategory3.f69047h = aEMaterialCategory.f69047h;
            aEMaterialCategory3.f69046f = aEMaterialCategory.f69046f;
            aEMaterialCategory3.f69049m = aEMaterialCategory.f69049m;
            aEMaterialCategory3.f69048i = aEMaterialCategory.f69048i;
            hashMap.put("normal_material", aEMaterialCategory2);
            hashMap.put("circle_material", aEMaterialCategory3);
            return hashMap;
        }
        ms.a.c("AEMaterialManager", "getSpecificCategory: item.materialList == null!");
        hashMap.put("normal_material", aEMaterialCategory2);
        hashMap.put("circle_material", aEMaterialCategory3);
        return hashMap;
    }

    public static String M() {
        File file = new File(g.a.b.f65264m);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file.getPath(), "camera_story_update_template.json").getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z16) {
        List<AEMaterialCategory> l06;
        ArrayList<MaterialRaceInfo> arrayList;
        List<AEMaterialMetaData> list;
        List<AEMaterialMetaData> list2;
        List<AEMaterialMetaData> list3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "initMaterialList enter---forceRefresh=" + z16);
        }
        synchronized (this) {
            if (this.f63523d && !z16) {
                ms.a.f("AEMaterialManager", "initMaterialList---has inited, fast return");
                return;
            }
            this.f63523d = true;
            ms.a.f("AEMaterialManager", "filament isSupport: " + G0());
            synchronized (this.f63533n) {
                l06 = l0();
            }
            if (l06 != null && !l06.isEmpty()) {
                synchronized (this.f63532m) {
                    this.f63524e.clear();
                    this.f63525f.clear();
                    this.f63526g.clear();
                    this.f63527h.clear();
                    this.f63524e.addAll(l06);
                    for (AEMaterialCategory aEMaterialCategory : l06) {
                        if (aEMaterialCategory != null && (list = aEMaterialCategory.f69044d) != null && !list.isEmpty()) {
                            for (AEMaterialMetaData aEMaterialMetaData : aEMaterialCategory.f69044d) {
                                if (aEMaterialMetaData != null) {
                                    aEMaterialMetaData.usable = W(aEMaterialMetaData);
                                }
                            }
                            if (S(aEMaterialCategory)) {
                                this.f63527h.add(aEMaterialCategory);
                            } else {
                                HashMap<String, AEMaterialCategory> K = K(aEMaterialCategory);
                                AEMaterialCategory aEMaterialCategory2 = K.get("normal_material");
                                AEMaterialCategory aEMaterialCategory3 = K.get("circle_material");
                                if (aEMaterialCategory3 != null && (list3 = aEMaterialCategory3.f69044d) != null && list3.size() > 0) {
                                    ms.a.a("AEMaterialManager", "initMaterialList: circleCategory = " + aEMaterialCategory3.toString());
                                    this.f63526g.add(aEMaterialCategory3);
                                }
                                if (aEMaterialCategory2 != null && (list2 = aEMaterialCategory2.f69044d) != null && list2.size() > 0) {
                                    this.f63525f.add(aEMaterialCategory2);
                                }
                            }
                        }
                    }
                }
                c0();
                Y();
                synchronized (this.f63532m) {
                    if (this.f63525f.size() > 0 && !G().equals(this.f63525f.get(0).f69047h)) {
                        this.f63525f.add(0, this.f63521b);
                    }
                    if (this.f63526g.size() > 0 && !G().equals(this.f63526g.get(0).f69047h)) {
                        this.f63526g.add(0, this.f63522c);
                    }
                }
                if (this.f63534o) {
                    synchronized (this.f63535p) {
                        if (this.f63536q == null) {
                            try {
                                ms.a.f("AEMaterialManager", "MaterialRace---wait request return");
                                this.f63535p.wait(500L);
                                ms.a.f("AEMaterialManager", "MaterialRace---wait request timeout");
                            } catch (InterruptedException unused) {
                                ms.a.f("AEMaterialManager", "MaterialRace---wait request interrupt");
                            }
                        }
                        arrayList = this.f63536q;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        synchronized (this.f63532m) {
                            z0(arrayList);
                        }
                    }
                }
                synchronized (this.f63532m) {
                    o();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AEMaterialManager", 2, "initMaterialList exit, cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                h0();
                return;
            }
            ms.a.c("AEMaterialManager", "initMaterialList: materials is empty !");
        }
    }

    private boolean Q() {
        List<AEMaterialMetaData> list;
        AEMaterialCategory aEMaterialCategory = this.f63522c;
        return (aEMaterialCategory == null || (list = aEMaterialCategory.f69044d) == null || list.size() < 100) ? false : true;
    }

    public static boolean R() {
        AEMaterialMetaData H = H();
        return (H == null || H.equals(AEMaterialMetaData.MATERIAL_NONE) || H.showCircleTakeSame == 0) ? false : true;
    }

    private boolean T() {
        AEMaterialCategory aEMaterialCategory = this.f63521b;
        return aEMaterialCategory != null && aEMaterialCategory.f69044d.size() >= 100;
    }

    private static boolean V(String str) {
        try {
            return DeviceSupportUtil.isAbilityDeviceSupport(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized boolean W(AEMaterialMetaData aEMaterialMetaData) {
        synchronized (AEMaterialManager.class) {
            if (aEMaterialMetaData != null) {
                if (!TextUtils.isEmpty(aEMaterialMetaData.name)) {
                    return i(aEMaterialMetaData);
                }
            }
            return false;
        }
    }

    private List<AEMaterialCategory> X(File file, File file2) throws AEMaterialConfigParser.AEMaterialConfigParseException {
        AEMaterialCategory aEMaterialCategory;
        AEMaterialMetaData aEMaterialMetaData;
        List<AEMaterialCategory> b06 = b0(file);
        List<AEMaterialCategory> b07 = b0(file2);
        if (b07 == null || b07.isEmpty()) {
            return b06;
        }
        for (AEMaterialCategory aEMaterialCategory2 : b06) {
            Iterator<AEMaterialCategory> it = b07.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aEMaterialCategory = null;
                    break;
                }
                aEMaterialCategory = it.next();
                if (aEMaterialCategory.f69047h.equals(aEMaterialCategory2.f69047h)) {
                    break;
                }
            }
            if (aEMaterialCategory == null) {
                Iterator<AEMaterialMetaData> it5 = aEMaterialCategory2.f69044d.iterator();
                while (it5.hasNext()) {
                    it5.next().deleteAllOldFile();
                }
            } else {
                for (AEMaterialMetaData aEMaterialMetaData2 : aEMaterialCategory2.f69044d) {
                    Iterator<AEMaterialMetaData> it6 = aEMaterialCategory.f69044d.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            aEMaterialMetaData = null;
                            break;
                        }
                        aEMaterialMetaData = it6.next();
                        if (aEMaterialMetaData2.f69050id.equals(aEMaterialMetaData.f69050id)) {
                            break;
                        }
                    }
                    if (aEMaterialMetaData == null) {
                        aEMaterialMetaData2.deleteAllOldFile();
                    } else if (!aEMaterialMetaData2.md5.equals(aEMaterialMetaData.md5)) {
                        aEMaterialMetaData2.deleteAllOldFile();
                    }
                }
            }
        }
        return b07;
    }

    private void Y() {
        AEMaterialMetaData v3;
        if (this.f63522c == null) {
            return;
        }
        String j3 = AECameraPrefsUtil.f().j("recent_circle_template_list_new" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "loadCircleRecentMaterial list=" + j3);
        }
        if (j3 == null) {
            return;
        }
        String[] split = j3.split("\\$");
        synchronized (this.f63531l) {
            this.f63522c.f69044d.clear();
            for (String str : split) {
                String[] split2 = str.split("\\|");
                if (split2 != null && split2.length == 2 && (v3 = v(split2[0])) != null) {
                    if (this.f63522c.f69044d.size() >= 100) {
                        return;
                    }
                    if (!this.f63522c.f69044d.contains(v3) && !v3.f69050id.equals("0")) {
                        this.f63522c.f69044d.add(v3);
                    }
                }
            }
        }
    }

    private List<AEMaterialCategory> a0() {
        ArrayList arrayList = new ArrayList();
        String a16 = com.tencent.aelight.camera.ae.config.b.a(getApp().getApp());
        if (TextUtils.isEmpty(a16)) {
            return arrayList;
        }
        try {
            ArrayList<AEMaterialCategory> d16 = AEMaterialConfigParser.d(a16);
            return (d16 == null || d16.isEmpty()) ? arrayList : d16;
        } catch (AEMaterialConfigParser.AEMaterialConfigParseException e16) {
            QLog.d("AEMaterialManager", 4, "loadMaterialListFromAssets err=" + e16.getMessage());
            return arrayList;
        }
    }

    private List<AEMaterialCategory> b0(File file) throws AEMaterialConfigParser.AEMaterialConfigParseException {
        ArrayList<AEMaterialCategory> d16;
        ArrayList arrayList = new ArrayList();
        String z16 = QIMPtvTemplateManager.z(file);
        return (TextUtils.isEmpty(z16) || (d16 = AEMaterialConfigParser.d(z16)) == null || d16.isEmpty()) ? arrayList : d16;
    }

    private void c0() {
        AEMaterialMetaData E;
        if (this.f63521b == null) {
            return;
        }
        String j3 = AECameraPrefsUtil.f().j("recent_template_list_new" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "loadRecentMaterial list=" + j3);
        }
        if (j3 == null) {
            return;
        }
        String[] split = j3.split("\\$");
        synchronized (this.f63530k) {
            this.f63521b.f69044d.clear();
            for (String str : split) {
                String[] split2 = str.split("\\|");
                if (split2 != null && split2.length == 2 && (E = E(split2[0])) != null) {
                    if (this.f63521b.f69044d.size() >= 100) {
                        return;
                    }
                    if (!this.f63521b.f69044d.contains(E) && !E.f69050id.equals("0")) {
                        this.f63521b.f69044d.add(E);
                    }
                }
            }
        }
    }

    private void e0() {
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.c(111, this.f63522c);
        }
    }

    private void h0() {
        if (getApp() != null) {
            getApp().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, true, null);
        }
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.c(116, new Object[0]);
        }
    }

    private void i0() {
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.c(111, this.f63521b);
        }
    }

    private static boolean k(AEMaterialMetaData aEMaterialMetaData) {
        try {
            return aEMaterialMetaData.unZipFile();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", e16.getMessage());
            }
            return new File(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON).exists();
        }
    }

    private List<AEMaterialCategory> l0() {
        List<AEMaterialCategory> a06;
        String str = g.a.b.f65264m;
        File file = new File(str, "camera_story_update_template.json");
        File file2 = new File(str, AECameraConstants.CAMERA_STORY_DEFAULT_JSON);
        if (!file.exists()) {
            if (!file2.exists()) {
                List<AEMaterialCategory> a07 = a0();
                ms.a.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
                o0();
                return a07;
            }
            try {
                List<AEMaterialCategory> b06 = b0(file2);
                ms.a.a("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
                return b06;
            } catch (AEMaterialConfigParser.AEMaterialConfigParseException e16) {
                FileUtils.deleteFile(file2.getPath());
                a06 = a0();
                ms.a.c("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                o0();
            }
        } else if (!file2.exists()) {
            try {
                a06 = b0(file);
                FileUtils.moveFile(file.getPath(), file2.getPath());
                ms.a.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
            } catch (AEMaterialConfigParser.AEMaterialConfigParseException e17) {
                FileUtils.deleteFile(file.getPath());
                List<AEMaterialCategory> a08 = a0();
                ms.a.c("AEMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17.toString());
                o0();
                return a08;
            }
        } else {
            try {
                a06 = X(file2, file);
                FileUtils.deleteFile(file2.getPath());
                FileUtils.moveFile(file.getPath(), file2.getPath());
                ms.a.a("AEMaterialManager", "readAndParseConfigFile -> try check update ");
            } catch (AEMaterialConfigParser.AEMaterialConfigParseException e18) {
                a06 = a0();
                ms.a.c("AEMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + e18.toString());
                o0();
            }
        }
        return a06;
    }

    private void o() {
        List<AEMaterialMetaData> y16 = y();
        List<AEMaterialMetaData> t16 = t();
        this.f63528i.clear();
        this.f63528i.addAll(r0(y16));
        this.f63529j.clear();
        this.f63529j.addAll(r0(t16));
    }

    private void o0() {
        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_STORY, 4);
        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_STORY_MAKEUP, 4);
        synchronized (this) {
            this.f63523d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AEMaterialMetaData q(AEMaterialMetaData aEMaterialMetaData) {
        AEMaterialMetaData aEMaterialMetaData2;
        boolean z16;
        Iterator<AEMaterialCategory> it = this.f63524e.iterator();
        AEMaterialMetaData aEMaterialMetaData3 = null;
        while (it.hasNext()) {
            List<AEMaterialMetaData> list = it.next().f69044d;
            if (list != null) {
                Iterator<AEMaterialMetaData> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        aEMaterialMetaData2 = aEMaterialMetaData3;
                        z16 = false;
                        break;
                    }
                    aEMaterialMetaData2 = it5.next();
                    if (aEMaterialMetaData2.equals(aEMaterialMetaData)) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    return aEMaterialMetaData2;
                }
                aEMaterialMetaData3 = aEMaterialMetaData2;
            }
        }
        return aEMaterialMetaData3;
    }

    private List<AEMaterialMetaData> r(List<AEMaterialCategory> list, String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f63532m) {
            Iterator<AEMaterialCategory> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AEMaterialCategory next = it.next();
                if (next.f69047h.equals(str)) {
                    arrayList.addAll(next.f69044d);
                    if (arrayList.size() > 0 && ((AEMaterialMetaData) arrayList.get(0)).equals(AEMaterialMetaData.MATERIAL_NONE)) {
                        arrayList.remove(0);
                    }
                }
            }
        }
        return new ArrayList(arrayList);
    }

    private List<AEMaterialMetaData> r0(List<AEMaterialMetaData> list) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (AEMaterialMetaData aEMaterialMetaData : list) {
            if (!aEMaterialMetaData.f69050id.contains(AECameraConstants.FILAMENT_MATERIAL_PREFIX) || G0()) {
                if (!aEMaterialMetaData.f69050id.contains(AECameraConstants.HAIRCOLOR_MATERIAL_PREFIX) || (DeviceUtils.hasDeviceNormal(BaseApplication.getContext()) && H0())) {
                    int i16 = i3 + 1;
                    if (i3 >= 10) {
                        break;
                    }
                    arrayList.add(aEMaterialMetaData);
                    i3 = i16;
                }
            }
        }
        return arrayList;
    }

    private List<AEMaterialMetaData> s(List<AEMaterialCategory> list, int i3) {
        AEMaterialCategory aEMaterialCategory;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f63531l) {
            if (list != null) {
                if (list.size() > i3 && (aEMaterialCategory = list.get(i3)) != null) {
                    arrayList.addAll(aEMaterialCategory.f69044d);
                    if (arrayList.size() > 0 && ((AEMaterialMetaData) arrayList.get(0)).equals(AEMaterialMetaData.MATERIAL_NONE)) {
                        arrayList.remove(0);
                    }
                }
            }
        }
        return new ArrayList(arrayList);
    }

    private List<AEMaterialMetaData> t() {
        return s(this.f63526g, 1);
    }

    private AEMaterialMetaData v(String str) {
        synchronized (this.f63524e) {
            Iterator<AEMaterialCategory> it = this.f63526g.iterator();
            while (it.hasNext()) {
                for (AEMaterialMetaData aEMaterialMetaData : it.next().f69044d) {
                    if (aEMaterialMetaData.f69050id.equals(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AEMaterialManager", 2, "getCircleStickerMaterial---found id=" + str);
                        }
                        return aEMaterialMetaData;
                    }
                }
            }
            return null;
        }
    }

    private List<AEMaterialMetaData> y() {
        return r(this.f63525f, HardCodeUtil.qqStr(R.string.j8c));
    }

    private void z0(ArrayList<MaterialRaceInfo> arrayList) {
        String str;
        ms.a.f("AEMaterialManager", "MaterialRace---sortAccordingRace");
        if (this.f63525f.isEmpty()) {
            return;
        }
        Collections.sort(arrayList, new a());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (AEMaterialCategory aEMaterialCategory : this.f63525f) {
            if (aEMaterialCategory != null) {
                hashMap.put(aEMaterialCategory.f69047h, aEMaterialCategory);
                List<AEMaterialMetaData> list = aEMaterialCategory.f69044d;
                if (list != null) {
                    for (AEMaterialMetaData aEMaterialMetaData : list) {
                        hashMap2.put(aEMaterialMetaData.f69050id, aEMaterialMetaData);
                    }
                }
            }
        }
        Iterator<MaterialRaceInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            MaterialRaceInfo next = it.next();
            AEMaterialMetaData aEMaterialMetaData2 = (AEMaterialMetaData) hashMap2.get(next.MaterialId);
            if (aEMaterialMetaData2 != null) {
                aEMaterialMetaData2.sysRaceId = next.RaceId;
                switch (next.Level) {
                    case 7:
                        str = "D";
                        break;
                    case 8:
                        str = BdhLogUtil.LogTag.Tag_Conn;
                        break;
                    case 9:
                        str = "B";
                        break;
                    case 10:
                        str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                        break;
                    default:
                        str = null;
                        break;
                }
                aEMaterialMetaData2.sysRaceLevel = str;
                AEMaterialCategory aEMaterialCategory2 = (AEMaterialCategory) hashMap.get(next.CategoryName);
                if (aEMaterialCategory2 != null) {
                    if (aEMaterialCategory2.f69044d == null) {
                        aEMaterialCategory2.f69044d = new ArrayList();
                    }
                    aEMaterialCategory2.f69044d.remove(aEMaterialMetaData2);
                    List<AEMaterialMetaData> list2 = aEMaterialCategory2.f69044d;
                    list2.add(Math.max(0, Math.min(next.Position, list2.size())), aEMaterialMetaData2);
                }
            }
        }
    }

    public void A0(final AppInterface appInterface, final String str, final AEMaterialMetaData aEMaterialMetaData, final com.tencent.aelight.camera.download.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.data.AEMaterialManager.5
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialManager.this.C0(appInterface, str, aEMaterialMetaData, aVar);
            }
        }, 128, null, true);
    }

    public List<AEMaterialCategory> B(boolean z16) {
        return this.f63525f;
    }

    public void B0(final AppInterface appInterface, final String str, final AEMaterialMetaData aEMaterialMetaData, final com.tencent.aelight.camera.download.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.data.AEMaterialManager.4
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialManager.this.D0(appInterface, str, aEMaterialMetaData, aVar);
            }
        }, 128, null, true);
    }

    public String I() {
        return this.f63537r;
    }

    public List<AEMaterialCategory> L() {
        return this.f63525f;
    }

    public void N(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.data.AEMaterialManager.1
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialManager.this.O(z16);
            }
        }, 64, null, false);
    }

    public void P(boolean z16) {
        O(z16);
    }

    public List<AEMaterialMetaData> Z(boolean z16, boolean z17) {
        List<AEMaterialMetaData> list;
        ms.a.f("AEMaterialManager", "loadDisplayHotList---requireServerData=" + z16);
        if (z16) {
            synchronized (this.f63538s) {
                if (!this.f63538s.get()) {
                    if (NetworkUtil.isNetworkAvailable()) {
                        ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
                        try {
                            ms.a.f("AEMaterialManager", "loadDisplayHotList---issue the request and wait");
                            this.f63538s.wait(90000L);
                            ms.a.f("AEMaterialManager", "loadDisplayHotList---awake from waiting");
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    } else {
                        ms.a.f("AEMaterialManager", "loadDisplayHotList---no network, skip request");
                    }
                }
            }
        }
        O(false);
        if (z17) {
            list = this.f63529j;
        } else {
            list = this.f63528i;
        }
        return new ArrayList(list);
    }

    public void f0(int i3, Object obj) {
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.c(i3, obj);
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + i3);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.control.AEQIMAsyncManager
    @Deprecated
    public synchronized void forceInit() {
    }

    public synchronized void g(yq2.c cVar, int i3) {
        if (this.f63520a == null) {
            this.f63520a = new yq2.b();
        }
        this.f63520a.a(cVar, i3);
    }

    public void g0(boolean z16, ArrayList<MaterialRaceInfo> arrayList) {
        synchronized (this.f63535p) {
            if (z16) {
                this.f63536q = arrayList;
            }
            ms.a.f("AEMaterialManager", "MaterialRace---notify got race info, really updated=" + z16);
            this.f63535p.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[Catch: NullPointerException -> 0x006d, AEMaterialConfigParseException -> 0x0072, TryCatch #2 {AEMaterialConfigParseException -> 0x0072, NullPointerException -> 0x006d, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0012, B:8:0x002d, B:9:0x0036, B:11:0x003c, B:16:0x004c, B:19:0x0050, B:22:0x0054, B:30:0x005d, B:34:0x001e), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(String str) {
        List<AEMaterialMetaData> r16;
        String str2;
        String str3;
        try {
            List<AEMaterialCategory> b06 = b0(new File(str));
            if (b06 != null && b06.size() != 0) {
                r16 = r(b06, HardCodeUtil.qqStr(R.string.f169889y52));
                ArrayList arrayList = new ArrayList();
                for (AEMaterialMetaData aEMaterialMetaData : r16) {
                    if (arrayList.size() < 10 && aEMaterialMetaData != null && (str2 = aEMaterialMetaData.f69050id) != null && (str3 = aEMaterialMetaData.iconurl) != null) {
                        arrayList.add(new ps.a(str2, str3));
                    }
                }
                AECameraPrefsUtil.f().p(PeakConstants.KEY_LATEST_MATERIAL, d0(arrayList), 4);
            }
            r16 = r(a0(), HardCodeUtil.qqStr(R.string.f169888y51));
            ArrayList arrayList2 = new ArrayList();
            while (r5.hasNext()) {
            }
            AECameraPrefsUtil.f().p(PeakConstants.KEY_LATEST_MATERIAL, d0(arrayList2), 4);
        } catch (AEMaterialConfigParser.AEMaterialConfigParseException e16) {
            e16.printStackTrace();
        } catch (NullPointerException e17) {
            e17.printStackTrace();
        }
    }

    public void j0() {
        ms.a.f("AEMaterialManager", "onConfigRequestCancel---notify all wait thread");
        synchronized (this.f63538s) {
            this.f63538s.notifyAll();
        }
    }

    public void k0() {
        ms.a.f("AEMaterialManager", "onConfigRequestDone---notify all wait thread");
        synchronized (this.f63538s) {
            this.f63538s.set(true);
            this.f63538s.notifyAll();
        }
    }

    public synchronized void m0(int i3) {
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.d(i3);
        }
    }

    public void n() {
        this.f63538s.set(false);
    }

    public synchronized void n0(yq2.c cVar) {
        yq2.b bVar = this.f63520a;
        if (bVar != null) {
            bVar.e(cVar);
        }
    }

    @Override // com.tencent.aelight.camera.ae.control.AEQIMAsyncManager, com.tencent.aelight.camera.ae.control.b
    @Deprecated
    public synchronized void onInit() {
    }

    public void p0() {
        List<AEMaterialMetaData> list;
        AEMaterialCategory aEMaterialCategory = this.f63522c;
        if (aEMaterialCategory == null || (list = aEMaterialCategory.f69044d) == null || list.isEmpty()) {
            return;
        }
        synchronized (this.f63531l) {
            StringBuilder sb5 = new StringBuilder();
            for (AEMaterialMetaData aEMaterialMetaData : this.f63522c.f69044d) {
                if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && !aEMaterialMetaData.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                    sb5.append(aEMaterialMetaData.f69050id);
                    sb5.append("|");
                    sb5.append(aEMaterialMetaData.categoryId);
                    sb5.append("$");
                }
            }
            if (TextUtils.isEmpty(sb5.toString())) {
                return;
            }
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            AECameraPrefsUtil.f().p("recent_circle_template_list_new" + account, sb5.toString(), 0);
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + sb5.toString());
            }
        }
    }

    public void q0() {
        AEMaterialCategory aEMaterialCategory = this.f63521b;
        if (aEMaterialCategory == null) {
            return;
        }
        List<AEMaterialMetaData> list = aEMaterialCategory.f69044d;
        if (list == null || !list.isEmpty()) {
            synchronized (this.f63530k) {
                StringBuilder sb5 = new StringBuilder();
                for (AEMaterialMetaData aEMaterialMetaData : this.f63521b.f69044d) {
                    if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && !aEMaterialMetaData.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                        sb5.append(aEMaterialMetaData.f69050id);
                        sb5.append("|");
                        sb5.append(aEMaterialMetaData.categoryId);
                        sb5.append("$");
                    }
                }
                if (TextUtils.isEmpty(sb5.toString())) {
                    return;
                }
                String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                AECameraPrefsUtil.f().p("recent_template_list_new" + account, sb5.toString(), 0);
                if (QLog.isColorLevel()) {
                    QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + sb5.toString());
                }
            }
        }
    }

    public List<AEMaterialCategory> u() {
        return this.f63526g;
    }

    public void u0(boolean z16) {
        this.f63534o = z16;
    }

    public void v0(AEMaterialMetaData aEMaterialMetaData) {
        String str;
        AEBaseReportParam U = AEBaseReportParam.U();
        String str2 = "";
        if (aEMaterialMetaData == null) {
            str = "";
        } else {
            str = aEMaterialMetaData.sysRaceId;
        }
        U.n1(str);
        AEBaseReportParam U2 = AEBaseReportParam.U();
        if (aEMaterialMetaData != null) {
            str2 = aEMaterialMetaData.sysRaceLevel;
        }
        U2.o1(str2);
    }

    public List<AEMaterialCategory> w() {
        return this.f63527h;
    }

    public void w0(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setSelectedMaterialAndNotify---info=");
        if (aEMaterialMetaData == null) {
            str = "null";
        } else {
            str = aEMaterialMetaData.f69050id;
        }
        sb5.append(str);
        sb5.append(", addToRecent=");
        sb5.append(z16);
        ms.a.f("AEMaterialManager", sb5.toString());
        f63516t = aEMaterialMetaData;
        f63517u = null;
        if (z16) {
            if (aEMaterialMetaData != null && "circleCamera".equals(aEMaterialMetaData.showEntry)) {
                s0(aEMaterialMetaData);
            } else {
                t0(aEMaterialMetaData);
            }
        }
        v0(aEMaterialMetaData);
        f0(113, null);
    }

    public List<AEMaterialMetaData> x(boolean z16) {
        List<AEMaterialMetaData> list;
        if (z16) {
            list = this.f63529j;
        } else {
            list = this.f63528i;
        }
        return new ArrayList(list);
    }

    public void x0(String str) {
        this.f63537r = str;
    }

    public void y0(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setSelectedWatermarkAndNotify---info=");
        if (aEMaterialMetaData == null) {
            str = "null";
        } else {
            str = aEMaterialMetaData.f69050id;
        }
        sb5.append(str);
        ms.a.f("AEMaterialManager", sb5.toString());
        f63517u = aEMaterialMetaData;
        f63516t = null;
        v0(aEMaterialMetaData);
        f0(z16 ? 1024 : 1025, null);
    }

    public void l() {
        f63516t = null;
    }

    public void m() {
        f63517u = null;
    }

    public static String F(AEQZoneMaterialMetaData aEQZoneMaterialMetaData) {
        if (aEQZoneMaterialMetaData == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((IAEPath) QRoute.api(IAEPath.class)).getQZoneCameraPathMaterialFinalUsable());
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEQZoneMaterialMetaData.f69050id);
        sb5.append(str);
        sb5.append(aEQZoneMaterialMetaData.f69050id);
        return sb5.toString();
    }

    @Nullable
    public static String d0(@Nullable ArrayList<ps.a> arrayList) {
        if (arrayList != null) {
            return GsonUtils.obj2Json(arrayList);
        }
        return null;
    }

    public AEMaterialMetaData A(String str, boolean z16) {
        List<AEMaterialCategory> list;
        List<AEMaterialMetaData> list2;
        if (z16) {
            list = this.f63526g;
        } else {
            list = this.f63525f;
        }
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null) {
                int i3 = 0;
                for (AEMaterialMetaData aEMaterialMetaData : list2) {
                    i3++;
                    if (aEMaterialMetaData.f69050id.equals(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + aEMaterialMetaData);
                        }
                        aEMaterialMetaData.firstcategoryname = aEMaterialCategory.f69047h;
                        aEMaterialMetaData.position = i3;
                        return aEMaterialMetaData;
                    }
                }
            }
        }
        return null;
    }

    public AEMaterialMetaData z(int i3, String str, boolean z16) {
        List<AEMaterialCategory> list;
        List<AEMaterialMetaData> list2;
        if (z16) {
            list = this.f63526g;
        } else {
            list = this.f63525f;
        }
        String str2 = "";
        boolean z17 = false;
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null && aEMaterialCategory.f69045e == i3) {
                String str3 = aEMaterialCategory.f69047h;
                int i16 = 0;
                for (AEMaterialMetaData aEMaterialMetaData : list2) {
                    i16++;
                    if (aEMaterialMetaData.f69050id.equals(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + aEMaterialMetaData);
                        }
                        aEMaterialMetaData.firstcategoryname = aEMaterialCategory.f69047h;
                        aEMaterialMetaData.position = i16;
                        return aEMaterialMetaData;
                    }
                }
                str2 = str3;
                z17 = true;
            }
        }
        if (!z17) {
            return null;
        }
        AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
        aEMaterialMetaData2.firstcategoryname = str2;
        aEMaterialMetaData2.categoryId = i3;
        aEMaterialMetaData2.f69050id = "";
        aEMaterialMetaData2.md5 = str2;
        return aEMaterialMetaData2;
    }

    private String G() {
        return HardCodeUtil.qqStr(R.string.qdw);
    }

    private int p(List<AEMaterialMetaData> list, String str) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).f69050id.equals(str)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public void E0(AppInterface appInterface, AEMaterialMetaData aEMaterialMetaData, com.tencent.aelight.camera.download.a aVar) {
        if (aEMaterialMetaData == null) {
            return;
        }
        B0(appInterface, aEMaterialMetaData.getZipDownloadPath(), aEMaterialMetaData, aVar);
    }

    public void s0(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null || aEMaterialMetaData.isNoneMaterial()) {
            return;
        }
        if (this.f63522c == null) {
            Y();
            return;
        }
        synchronized (this.f63531l) {
            int p16 = p(this.f63522c.f69044d, aEMaterialMetaData.f69050id);
            if (p16 == -1) {
                if (!Q()) {
                    this.f63522c.f69044d.add(0, aEMaterialMetaData);
                    e0();
                    if (QLog.isColorLevel()) {
                        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
                    }
                    this.f63522c.f69044d.remove(99);
                    this.f63522c.f69044d.add(0, aEMaterialMetaData);
                    e0();
                }
            } else if (p16 != 0) {
                this.f63522c.f69044d.remove(p16);
                this.f63522c.f69044d.add(0, aEMaterialMetaData);
                e0();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + p16);
            }
        }
    }

    public void t0(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null || aEMaterialMetaData.isNoneMaterial()) {
            return;
        }
        if (this.f63521b == null) {
            c0();
            return;
        }
        synchronized (this.f63530k) {
            int p16 = p(this.f63521b.f69044d, aEMaterialMetaData.f69050id);
            if (p16 == -1) {
                if (!T()) {
                    this.f63521b.f69044d.add(0, aEMaterialMetaData);
                    i0();
                    if (QLog.isColorLevel()) {
                        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
                    }
                    this.f63521b.f69044d.remove(99);
                    this.f63521b.f69044d.add(0, aEMaterialMetaData);
                    i0();
                }
            } else if (p16 != 0) {
                this.f63521b.f69044d.remove(p16);
                this.f63521b.f69044d.add(0, aEMaterialMetaData);
                i0();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + p16);
            }
        }
    }

    private boolean S(AEMaterialCategory aEMaterialCategory) {
        if (aEMaterialCategory == null) {
            return false;
        }
        if (aEMaterialCategory.f69045e == 30000) {
            return true;
        }
        return !aEMaterialCategory.C;
    }

    public static boolean U(VideoMaterial videoMaterial) {
        if (videoMaterial != null && videoMaterial.getLightAsset() != null) {
            List<String> C = AEResUtil.C(videoMaterial);
            return (C == null || C.isEmpty()) ? false : true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("material is null: ");
        sb5.append(videoMaterial == null);
        ms.a.c("AEMaterialManager", sb5.toString());
        return false;
    }

    public static boolean i(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null) {
            return false;
        }
        if (C(aEMaterialMetaData).exists()) {
            return true;
        }
        if (QzoneConfig.getMaterialZipDeleteSwitch()) {
            return false;
        }
        return k(aEMaterialMetaData);
    }

    public static boolean j(AEQZoneMaterialMetaData aEQZoneMaterialMetaData) {
        if (aEQZoneMaterialMetaData == null) {
            return false;
        }
        if (new File(F(aEQZoneMaterialMetaData)).exists()) {
            return true;
        }
        if (QzoneConfig.getMaterialZipDeleteSwitch()) {
            return false;
        }
        return k(aEQZoneMaterialMetaData);
    }

    @Override // com.tencent.aelight.camera.ae.control.AEQIMAsyncManager
    @Deprecated
    protected void initIndeed() {
    }
}
