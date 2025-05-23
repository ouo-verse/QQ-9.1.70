package com.tencent.aelight.camera.aeeditor.manage;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.i;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static volatile c f66161e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f66162a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<MetaMaterial> f66163b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f66164c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<d> f66165d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends TypeToken<ArrayList<MetaCategory>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends TypeToken<ArrayList<MetaCategory>> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.manage.c$c, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0570c extends TypeToken<ArrayList<MetaCategory>> {
        C0570c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a();

        void b();
    }

    public static c b() {
        if (f66161e == null) {
            synchronized (c.class) {
                if (f66161e == null) {
                    f66161e = new c();
                }
            }
        }
        return f66161e;
    }

    private static List<MetaCategory> c() {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        String i3 = i(AEEditorConstants.AE_EDITOR_DEFAULT_AUTO_TEMPLATE_JSON);
        if (!TextUtils.isEmpty(i3) && (arrayList = (ArrayList) new Gson().fromJson(i3, new C0570c().getType())) != null && !arrayList.isEmpty()) {
            arrayList2.clear();
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    private static List<MetaCategory> d(String str) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        String i3 = i(str);
        if (!TextUtils.isEmpty(i3) && (arrayList = (ArrayList) new Gson().fromJson(i3, new a().getType())) != null && !arrayList.isEmpty()) {
            arrayList2.clear();
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    private static List<MetaCategory> e(File file) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        String z16 = QIMPtvTemplateManager.z(file);
        if (!TextUtils.isEmpty(z16) && (arrayList = (ArrayList) new Gson().fromJson(z16, new b().getType())) != null && !arrayList.isEmpty()) {
            arrayList2.clear();
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    public String a(String str, String str2) {
        String path;
        synchronized (this.f66162a) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = new File(file.getPath(), str2).getPath();
        }
        return path;
    }

    public void f() {
        WeakReference<d> weakReference = this.f66165d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f66165d.get().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c8 A[Catch: all -> 0x00fd, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0021, B:8:0x0027, B:9:0x00c4, B:11:0x00c8, B:12:0x00cf, B:17:0x00dc, B:19:0x00e9, B:20:0x00fb, B:25:0x0036, B:28:0x0046, B:30:0x0078, B:34:0x0093), top: B:3:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<MetaCategory> g() {
        List<MetaCategory> c16;
        synchronized (this.f66162a) {
            new ArrayList();
            String str = i.f65580c;
            File file = new File(str, "editor_auto_template_update_template.json");
            File file2 = new File(str, AEEditorConstants.AE_EDITOR_AUTO_TEMPLATE_JSON);
            if (!file.exists()) {
                if (!file2.exists()) {
                    ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, newJson not exist ");
                    c16 = c();
                } else {
                    try {
                        c16 = e(file2);
                        ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, use oldJson");
                    } catch (Exception e16) {
                        FileUtils.deleteFile(file2.getPath());
                        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL, 4);
                        ms.a.c("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                        c16 = c();
                    }
                }
                if (this.f66163b == null) {
                    this.f66163b = new ArrayList<>();
                }
                if (this.f66163b.isEmpty()) {
                    for (int i3 = 0; i3 < 5; i3++) {
                        this.f66163b.add(new MetaMaterial());
                    }
                }
                MetaCategory metaCategory = new MetaCategory();
                metaCategory.name = "\u63a8\u8350";
                metaCategory.f30532id = "recommend";
                c16.add(0, metaCategory);
            } else {
                try {
                    List<MetaCategory> e17 = e(file);
                    FileUtils.moveFile(file.getPath(), file2.getPath());
                    ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, use newJson ");
                    c16 = e17;
                } catch (Exception e18) {
                    FileUtils.deleteFile(file.getPath());
                    ms.a.c("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exists: exception:" + e18.toString());
                    AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL, 4);
                    c16 = c();
                }
                if (this.f66163b == null) {
                }
                if (this.f66163b.isEmpty()) {
                }
                MetaCategory metaCategory2 = new MetaCategory();
                metaCategory2.name = "\u63a8\u8350";
                metaCategory2.f30532id = "recommend";
                c16.add(0, metaCategory2);
            }
        }
        return c16;
    }

    public List<MetaCategory> h(String str, String str2, String str3, boolean z16) {
        List<MetaCategory> list;
        ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile... parent:" + str + " newjson:" + str2 + " oldjson:" + str3);
        synchronized (this.f66162a) {
            List<MetaCategory> arrayList = new ArrayList<>();
            File file = new File(str, str2);
            File file2 = new File(str, str3);
            if (!file.exists()) {
                if (!file2.exists()) {
                    ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist ");
                    list = d(str3);
                } else {
                    try {
                        arrayList = e(file2);
                        ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
                    } catch (Exception e16) {
                        FileUtils.deleteFile(file2.getPath());
                        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL, 4);
                        ms.a.c("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                    }
                    list = arrayList;
                }
            } else {
                try {
                    arrayList = e(file);
                    if (z16) {
                        FileUtils.moveFile(file.getPath(), file2.getPath());
                    }
                    ms.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson isNeedMove:" + z16);
                } catch (Exception e17) {
                    FileUtils.deleteFile(file.getPath());
                    ms.a.c("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17.toString());
                    AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL, 4);
                }
                list = arrayList;
            }
        }
        return list;
    }

    public void j(ArrayList<MetaMaterial> arrayList, ArrayList<String> arrayList2) {
        this.f66163b = arrayList;
        this.f66164c = arrayList2;
        WeakReference<d> weakReference = this.f66165d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f66165d.get().b();
    }

    public static String i(String str) {
        InputStream inputStream = null;
        try {
            inputStream = BaseApplication.getContext().getAssets().open(str);
            String h16 = k.h(inputStream);
            if (inputStream == null) {
                return h16;
            }
            try {
                inputStream.close();
                return h16;
            } catch (IOException e16) {
                e16.printStackTrace();
                return h16;
            }
        } catch (Throwable th5) {
            try {
                ms.a.d("[AEEditor2]AEditorMaterialManager", "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
                th5.printStackTrace();
                return "";
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }
}
