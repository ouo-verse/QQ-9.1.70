package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import dr.c;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGifMaterialManager {

    /* renamed from: f, reason: collision with root package name */
    private static final AEGifMaterialManager f63499f = new AEGifMaterialManager();

    /* renamed from: g, reason: collision with root package name */
    private static final Type f63500g = new a().getType();

    /* renamed from: a, reason: collision with root package name */
    private String f63501a = "";

    /* renamed from: b, reason: collision with root package name */
    private final Object f63502b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private List<AEGifCategoryWrapper> f63503c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, WeakReference<b>> f63504d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, MetaMaterial> f63505e = new HashMap();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface QueryType {
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends TypeToken<GetCategoryMaterialRsp> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(MetaMaterial metaMaterial);

        void b(MetaMaterial metaMaterial);

        void c(MetaMaterial metaMaterial, int i3);
    }

    AEGifMaterialManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AEGifCategoryWrapper> B() {
        ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync]");
        File file = new File(g.b.f65270a);
        File file2 = new File(g.b.f65271b);
        if (!file2.exists()) {
            ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile not exists");
            if (!file.exists()) {
                ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
                AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_EMOJI, 4);
                return new LinkedList();
            }
            ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
            return C(v(FileUtils.readFileContent(file)));
        }
        ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile exists");
        if (!file.exists()) {
            ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
            List<AEGifCategoryWrapper> v3 = v(FileUtils.readFileContent(file2));
            C(v3);
            FileUtils.moveFile(file2.getPath(), file.getPath());
            return v3;
        }
        ms.a.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
        List<AEGifCategoryWrapper> v16 = v(FileUtils.readFileContent(file));
        List<AEGifCategoryWrapper> v17 = v(FileUtils.readFileContent(file2));
        k(v16, v17);
        C(v17);
        FileUtils.deleteFile(file.getPath());
        FileUtils.moveFile(file2.getPath(), file.getPath());
        return v17;
    }

    private List<AEGifCategoryWrapper> C(List<AEGifCategoryWrapper> list) {
        MetaMaterial metaMaterial;
        ms.a.a("AEGifMaterialManager", "[updateMaterialStatus]");
        for (AEGifCategoryWrapper aEGifCategoryWrapper : list) {
            if (aEGifCategoryWrapper != null && !CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList)) {
                for (AEMaterialWrapper aEMaterialWrapper : aEGifCategoryWrapper.materialWrapperList) {
                    if (aEMaterialWrapper != null && !TextUtils.isEmpty(aEMaterialWrapper.f63553a) && (metaMaterial = aEMaterialWrapper.f63554b) != null) {
                        aEMaterialWrapper.f63558f = r(metaMaterial) ? 2 : 0;
                    }
                }
            }
        }
        return list;
    }

    private Map<String, MetaMaterial> i(List<AEGifCategoryWrapper> list) {
        MetaMaterial metaMaterial;
        ms.a.a("AEGifMaterialManager", "[buildMaterialMap]");
        HashMap hashMap = new HashMap();
        for (AEGifCategoryWrapper aEGifCategoryWrapper : list) {
            if (aEGifCategoryWrapper != null && !CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList)) {
                for (AEMaterialWrapper aEMaterialWrapper : aEGifCategoryWrapper.materialWrapperList) {
                    if (aEMaterialWrapper != null && !TextUtils.isEmpty(aEMaterialWrapper.f63553a) && (metaMaterial = aEMaterialWrapper.f63554b) != null) {
                        hashMap.put(aEMaterialWrapper.f63553a, metaMaterial);
                    }
                }
            }
        }
        return hashMap;
    }

    private void j(MetaMaterial metaMaterial) {
        ms.a.a("AEGifMaterialManager", "[deleteMaterialZipAndDir], metaMaterial.id=" + metaMaterial.f30533id);
        File file = new File(g.a.b.f65263l, metaMaterial.f30533id);
        File file2 = new File(g.a.b.f65262k, metaMaterial.f30533id);
        if (file.exists()) {
            FileUtils.deleteFile(file.getPath());
        }
        if (file2.exists()) {
            FileUtils.deleteDirectory(file2.getPath());
        }
    }

    private void k(List<AEGifCategoryWrapper> list, List<AEGifCategoryWrapper> list2) {
        MetaMaterial metaMaterial;
        ms.a.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial]");
        Map<String, MetaMaterial> i3 = i(list);
        Map<String, MetaMaterial> i16 = i(list2);
        for (Map.Entry<String, MetaMaterial> entry : i3.entrySet()) {
            String key = entry.getKey();
            MetaMaterial value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                if (!i16.containsKey(key) || (metaMaterial = i16.get(key)) == null || value.packageMd5.equals(metaMaterial.packageMd5)) {
                    value = null;
                }
                if (value != null) {
                    ms.a.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial] find outdated material id=" + value.f30533id);
                    j(value);
                }
            }
        }
    }

    private String m(MetaCategory metaCategory, String str) {
        Map<String, String> map = metaCategory.dynamicFields;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static AEGifMaterialManager o() {
        return f63499f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(MetaMaterial metaMaterial) {
        if (metaMaterial != null && !TextUtils.isEmpty(metaMaterial.f30533id)) {
            File file = new File(g.a.b.f65263l, metaMaterial.f30533id);
            if (!file.exists()) {
                return false;
            }
            File file2 = new File(g.a.b.f65262k, metaMaterial.f30533id);
            File file3 = new File(file2, IVideoFilterTools.CONFIG_FILE);
            File file4 = new File(file2, "params.dat");
            if (file3.exists() || file4.exists()) {
                return true;
            }
            try {
                ZipUtils.unZipFile(file, file2.getPath());
                return true;
            } catch (Exception e16) {
                ms.a.d("AEGifMaterialManager", "[materialExists] unZipFile raised exception", e16);
                return file3.exists() || file4.exists();
            }
        }
        ms.a.c("AEGifMaterialManager", "[materialExists] metaMaterial is invalid");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(MetaMaterial metaMaterial) {
        WeakReference<b> weakReference;
        b bVar;
        if (!this.f63504d.containsKey(metaMaterial.f30533id) || (weakReference = this.f63504d.get(metaMaterial.f30533id)) == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.b(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(MetaMaterial metaMaterial, int i3) {
        WeakReference<b> weakReference;
        b bVar;
        if (!this.f63504d.containsKey(metaMaterial.f30533id) || (weakReference = this.f63504d.get(metaMaterial.f30533id)) == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.c(metaMaterial, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16) {
        ms.a.a("AEGifMaterialManager", "[notifyGifCategoryListUpdated], validData=" + z16);
        com.tencent.aelight.camera.ae.config.b.c().postValue(Boolean.valueOf(z16));
    }

    private List<AEGifCategoryWrapper> v(String str) {
        AEMaterialWrapper aEMaterialWrapper;
        ms.a.a("AEGifMaterialManager", "[parseGifCategoryFromJson]");
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEGifMaterialManager", "[parseGifCategoryFromJson] jsonString is empty");
            return new LinkedList();
        }
        GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) GsonUtils.json2Obj(str, f63500g);
        if (getCategoryMaterialRsp != null && !CollectionUtils.isEmpty(getCategoryMaterialRsp.Categories)) {
            LinkedList linkedList = new LinkedList();
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < getCategoryMaterialRsp.Categories.size(); i3++) {
                MetaCategory metaCategory = getCategoryMaterialRsp.Categories.get(i3);
                if (metaCategory != null && !CollectionUtils.isEmpty(metaCategory.materials)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i16 = 0; i16 < metaCategory.materials.size(); i16++) {
                        MetaMaterial metaMaterial = metaCategory.materials.get(i16);
                        if (metaMaterial != null && !TextUtils.isEmpty(metaMaterial.f30533id)) {
                            Map<String, String> map = metaMaterial.additionalFields;
                            if (hashMap.get(metaMaterial.f30533id) == null) {
                                aEMaterialWrapper = new AEMaterialWrapper();
                                aEMaterialWrapper.f63553a = metaMaterial.f30533id;
                                aEMaterialWrapper.f63554b = metaMaterial;
                                if (map != null) {
                                    aEMaterialWrapper.f63555c = map.get("minimum_device_level");
                                    aEMaterialWrapper.f63556d = map.get("shield_devices");
                                }
                                boolean y16 = y(aEMaterialWrapper);
                                aEMaterialWrapper.f63557e = y16;
                                if (y16) {
                                    hashMap.put(metaMaterial.f30533id, aEMaterialWrapper);
                                } else {
                                    ms.a.a("AEGifMaterialManager", "can not add gif material id: " + aEMaterialWrapper.f63553a);
                                }
                            } else {
                                aEMaterialWrapper = (AEMaterialWrapper) hashMap.get(metaMaterial.f30533id);
                            }
                            if (aEMaterialWrapper.f63557e) {
                                linkedList2.add(aEMaterialWrapper);
                            }
                        }
                    }
                    if (CollectionUtils.isEmpty(linkedList2)) {
                        ms.a.c("AEGifMaterialManager", "[parseGifCategoryFromJson] materialWrapperList is empty, categoryId=" + metaCategory.f30532id);
                    } else {
                        AEGifCategoryWrapper aEGifCategoryWrapper = new AEGifCategoryWrapper();
                        aEGifCategoryWrapper.categoryId = metaCategory.f30532id;
                        aEGifCategoryWrapper.categoryName = metaCategory.name;
                        aEGifCategoryWrapper.materialWrapperList = linkedList2;
                        aEGifCategoryWrapper.showCategory = z(metaCategory);
                        aEGifCategoryWrapper.fontId = m(metaCategory, "font_id");
                        linkedList.add(aEGifCategoryWrapper);
                    }
                }
            }
            return linkedList;
        }
        ms.a.c("AEGifMaterialManager", "[parseGifCategoryFromJson] parsed response is empty");
        return new LinkedList();
    }

    private boolean z(MetaCategory metaCategory) {
        String m3 = m(metaCategory, "show_list");
        return !TextUtils.isEmpty(m3) && "true".equals(m3);
    }

    public void A() {
        ms.a.a("AEGifMaterialManager", "[updateGifCategoryListAsync]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.data.AEGifMaterialManager.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AEGifMaterialManager.this.f63502b) {
                    List B = AEGifMaterialManager.this.B();
                    if (!CollectionUtils.isEmpty(B)) {
                        AEGifMaterialManager.this.f63503c = B;
                    }
                    AEGifMaterialManager.this.u(!CollectionUtils.isEmpty(B));
                }
            }
        }, 64, null, true);
    }

    public String n() {
        return this.f63501a;
    }

    public String p(MetaMaterial metaMaterial) {
        return new File(g.a.b.f65262k, metaMaterial.f30533id).getAbsolutePath();
    }

    public boolean q(String str) {
        return this.f63505e.containsKey(str);
    }

    public void x(String str) {
        this.f63501a = str;
    }

    public void l(final AppInterface appInterface, final MetaMaterial metaMaterial, b bVar) {
        if (metaMaterial != null && !TextUtils.isEmpty(metaMaterial.f30533id)) {
            this.f63504d.put(metaMaterial.f30533id, new WeakReference<>(bVar));
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.data.AEGifMaterialManager.3

                /* compiled from: P */
                /* renamed from: com.tencent.aelight.camera.ae.data.AEGifMaterialManager$3$a */
                /* loaded from: classes32.dex */
                class a implements INetEngineListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f63508d;

                    a(String str) {
                        this.f63508d = str;
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onResp(NetResp netResp) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AEGifMaterialManager", 2, "onResp url: " + metaMaterial.packageUrl + " resultcode: " + netResp.mHttpCode);
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (AEGifMaterialManager.this.r(metaMaterial)) {
                            try {
                                ZipUtils.unZipFile(new File(this.f63508d, metaMaterial.f30533id), g.a.b.f65262k + File.separator);
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                AEGifMaterialManager.this.s(metaMaterial);
                                AEGifMaterialManager.this.f63505e.remove(metaMaterial.f30533id);
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        AEGifMaterialManager.this.t(metaMaterial, (int) ((j3 / j16) * 100));
                        if (AEGifMaterialManager.this.f63505e.containsKey(metaMaterial.f30533id)) {
                            return;
                        }
                        Map map = AEGifMaterialManager.this.f63505e;
                        MetaMaterial metaMaterial = metaMaterial;
                        map.put(metaMaterial.f30533id, metaMaterial);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AEGifMaterialManager.this.r(metaMaterial)) {
                        AEGifMaterialManager.this.s(metaMaterial);
                        AEGifMaterialManager.this.f63505e.remove(metaMaterial.f30533id);
                        return;
                    }
                    if (AEGifMaterialManager.this.q(metaMaterial.f30533id)) {
                        AEGifMaterialManager.this.t(metaMaterial, 0);
                        return;
                    }
                    String str = g.a.b.f65263l;
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a(str);
                    httpNetReq.mReqUrl = metaMaterial.packageUrl;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = new File(str, metaMaterial.f30533id).getPath();
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    if (QLog.isColorLevel()) {
                        QLog.i("AEGifMaterialManager", 2, "startDownloadTemplate, url: " + metaMaterial.packageUrl);
                    }
                }
            });
        } else if (bVar != null) {
            bVar.a(metaMaterial);
        }
    }

    private boolean y(AEMaterialWrapper aEMaterialWrapper) {
        if (aEMaterialWrapper == null) {
            return true;
        }
        if (c.a(aEMaterialWrapper.f63555c) > c.b()) {
            return false;
        }
        if (aEMaterialWrapper.f63556d != null) {
            if (aEMaterialWrapper.f63556d.contains(c.c())) {
                return false;
            }
        }
        return true;
    }

    public List<AEGifCategoryWrapper> w(int i3) {
        if (i3 != 2 && i3 != 3) {
            return new LinkedList(this.f63503c);
        }
        LinkedList linkedList = new LinkedList();
        boolean z16 = i3 == 2;
        for (AEGifCategoryWrapper aEGifCategoryWrapper : this.f63503c) {
            if (aEGifCategoryWrapper != null && aEGifCategoryWrapper.showCategory == z16) {
                linkedList.add(aEGifCategoryWrapper);
            }
        }
        return linkedList;
    }
}
