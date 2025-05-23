package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<AEMaterialCategory> f63564a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f63565b = false;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<InterfaceC0550b> f63566c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f63567a = new b();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0550b {
        void a();
    }

    b() {
    }

    public static b a() {
        return a.f63567a;
    }

    private List<AEMaterialCategory> c(File file, File file2) throws AEMaterialConfigParser.AEMaterialConfigParseException {
        AEMaterialCategory aEMaterialCategory;
        AEMaterialMetaData aEMaterialMetaData;
        List<AEMaterialCategory> d16 = d(file);
        List<AEMaterialCategory> d17 = d(file2);
        if (d17 == null || d17.isEmpty()) {
            return d16;
        }
        for (AEMaterialCategory aEMaterialCategory2 : d16) {
            Iterator<AEMaterialCategory> it = d17.iterator();
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
        return d17;
    }

    private List<AEMaterialCategory> d(File file) throws AEMaterialConfigParser.AEMaterialConfigParseException {
        ArrayList<AEMaterialCategory> d16;
        ArrayList arrayList = new ArrayList();
        String z16 = QIMPtvTemplateManager.z(file);
        return (TextUtils.isEmpty(z16) || (d16 = AEMaterialConfigParser.d(z16)) == null || d16.isEmpty()) ? arrayList : d16;
    }

    private List<AEMaterialCategory> f() {
        ArrayList arrayList;
        List<AEMaterialCategory> c16;
        File file = new File(g.d.f65294b);
        File file2 = new File(g.d.f65293a);
        if (!file.exists()) {
            if (!file2.exists()) {
                ArrayList arrayList2 = new ArrayList();
                ms.a.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
                h();
                return arrayList2;
            }
            try {
                List<AEMaterialCategory> d16 = d(file2);
                ms.a.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
                return d16;
            } catch (AEMaterialConfigParser.AEMaterialConfigParseException e16) {
                FileUtils.deleteFile(file2.getPath());
                arrayList = new ArrayList();
                ms.a.c("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                h();
            }
        } else {
            if (!file2.exists()) {
                try {
                    c16 = d(file);
                    FileUtils.moveFile(file.getPath(), file2.getPath());
                    ms.a.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
                } catch (AEMaterialConfigParser.AEMaterialConfigParseException e17) {
                    FileUtils.deleteFile(file.getPath());
                    ArrayList arrayList3 = new ArrayList();
                    ms.a.c("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17.toString());
                    h();
                    return arrayList3;
                }
            } else {
                try {
                    c16 = c(file2, file);
                    FileUtils.deleteFile(file2.getPath());
                    FileUtils.moveFile(file.getPath(), file2.getPath());
                    ms.a.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> try check update ");
                } catch (AEMaterialConfigParser.AEMaterialConfigParseException e18) {
                    arrayList = new ArrayList();
                    ms.a.c("AEWatermarkMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + e18.toString());
                    h();
                }
            }
            return c16;
        }
        return arrayList;
    }

    private void h() {
        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_WATERMARK, 4);
        synchronized (this) {
            this.f63565b = false;
        }
    }

    public synchronized List<AEMaterialCategory> b() {
        ms.a.f("AEWatermarkMaterialManager", "getMaterialsSync---mHasLoaded=" + this.f63565b);
        if (this.f63565b) {
            return new ArrayList(this.f63564a);
        }
        List<AEMaterialCategory> f16 = f();
        g(f16);
        this.f63564a.clear();
        this.f63564a.addAll(f16);
        this.f63565b = true;
        return new ArrayList(this.f63564a);
    }

    public synchronized void e() {
        ms.a.f("AEWatermarkMaterialManager", "onConfigUpdated---");
        this.f63565b = false;
        Iterator<InterfaceC0550b> it = this.f63566c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void g(List<AEMaterialCategory> list) {
        List<AEMaterialMetaData> list2;
        if (list == null) {
            return;
        }
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null) {
                for (AEMaterialMetaData aEMaterialMetaData : list2) {
                    if (aEMaterialMetaData != null) {
                        aEMaterialMetaData.usable = AEMaterialManager.W(aEMaterialMetaData);
                    }
                }
            }
        }
    }
}
