package com.tencent.mobileqq.wink.edit.manager;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h {

    /* renamed from: h, reason: collision with root package name */
    private static volatile h f318431h;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<MetaMaterial> f318433b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<MetaMaterial> f318434c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f318435d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<MetaMaterial> f318436e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f318432a = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final List<c> f318437f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f318438g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends TypeToken<ArrayList<MetaCategory>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends TypeToken<ArrayList<MetaCategory>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void a();

        void b(ArrayList<MetaMaterial> arrayList);
    }

    public static h d() {
        if (f318431h == null) {
            synchronized (h.class) {
                if (f318431h == null) {
                    f318431h = new h();
                }
            }
        }
        return f318431h;
    }

    public static String h(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            w53.b.d("[AEEditor2]AEditorMaterialManager_PTV", "loadFileContent error, ", e16);
            return null;
        }
    }

    private static ArrayList<MetaCategory> i(String str) {
        ArrayList<MetaCategory> arrayList = new ArrayList<>();
        String m3 = m(str);
        if (TextUtils.isEmpty(m3)) {
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList) new Gson().fromJson(m3, new a().getType());
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private static ArrayList<MetaCategory> j(File file) {
        ArrayList<MetaCategory> arrayList = new ArrayList<>();
        try {
            String h16 = h(file);
            if (TextUtils.isEmpty(h16)) {
                return arrayList;
            }
            ArrayList arrayList2 = (ArrayList) new Gson().fromJson(h16, new b().getType());
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList.clear();
                arrayList.addAll(arrayList2);
            }
            return arrayList;
        } catch (OutOfMemoryError e16) {
            ms.a.c("[AEEditor2]AEditorMaterialManager", "error : " + e16.getMessage());
            return arrayList;
        }
    }

    public static String m(String str) {
        InputStream inputStream = null;
        try {
            inputStream = com.tencent.mobileqq.wink.b.c().getAssets().open(str);
            String h16 = com.tencent.biz.common.util.k.h(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return h16;
                } catch (IOException unused) {
                    return h16;
                }
            }
            return h16;
        } catch (Throwable th5) {
            try {
                w53.b.d("[AEEditor2]AEditorMaterialManager", "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return "";
            } catch (Throwable th6) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th6;
            }
        }
    }

    public void a(c cVar) {
        if (this.f318437f.contains(cVar)) {
            return;
        }
        this.f318437f.add(cVar);
    }

    public String b(String str, String str2) {
        String path;
        synchronized (this.f318432a) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = new File(file.getPath(), str2).getPath();
        }
        return path;
    }

    public MetaCategory c(List<MetaMaterial> list, List<MetaMaterial> list2) {
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.name = "\u6536\u85cf";
        metaCategory.f30532id = "star";
        List<String> d16 = f.e().d();
        ArrayList<MetaMaterial> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList2.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            arrayList2.addAll(list2);
        }
        if (arrayList2.isEmpty()) {
            return metaCategory;
        }
        ArrayList arrayList3 = new ArrayList(d16);
        for (String str : d16) {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    MetaMaterial metaMaterial = (MetaMaterial) it.next();
                    if (Objects.equals(metaMaterial.f30533id, str)) {
                        arrayList3.remove(str);
                        MetaMaterial copy = metaMaterial.copy();
                        com.tencent.mobileqq.wink.editor.c.o1(copy, "star");
                        com.tencent.mobileqq.wink.editor.c.p1(copy, "\u6536\u85cf");
                        if (!arrayList.contains(copy)) {
                            arrayList.add(copy);
                        }
                    }
                }
            }
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            f.e().b((String) it5.next());
        }
        metaCategory.materials = arrayList;
        return metaCategory;
    }

    public MetaCategory e() {
        ArrayList<MetaMaterial> arrayList = this.f318433b;
        if (arrayList != null && !arrayList.isEmpty()) {
            MetaCategory metaCategory = new MetaCategory();
            metaCategory.name = "\u63a8\u8350";
            metaCategory.f30532id = "recommend";
            metaCategory.materials = this.f318433b;
            return metaCategory;
        }
        return null;
    }

    public ArrayList<MetaMaterial> f() {
        return this.f318434c;
    }

    public boolean g() {
        return this.f318438g;
    }

    public void k() {
        for (c cVar : this.f318437f) {
            if (cVar != null) {
                cVar.a();
            }
        }
        this.f318438g = true;
    }

    public ArrayList<MetaCategory> l(String str, String str2, String str3, boolean z16) {
        ArrayList<MetaCategory> arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile... parent:" + str + " newjson:" + str2 + " oldjson:" + str3);
        synchronized (this.f318432a) {
            ArrayList<MetaCategory> arrayList2 = new ArrayList<>();
            File file = new File(str, str2);
            File file2 = new File(str, str3);
            if (!file.exists()) {
                if (!file2.exists()) {
                    w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist ");
                    arrayList = i(str3);
                    l73.a.f413927a.c(arrayList);
                    w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                } else {
                    try {
                        arrayList2 = j(file2);
                        w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
                    } catch (Exception e16) {
                        FileUtils.deleteFile(file2.getPath());
                        AECameraPrefsUtil.c().l(AECameraPrefsUtil.f318466d, 4);
                        w53.b.c("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                    }
                    arrayList = arrayList2;
                    l73.a.f413927a.c(arrayList);
                    w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
            } else {
                try {
                    arrayList2 = j(file);
                    if (z16) {
                        FileUtils.moveFile(file.getPath(), file2.getPath());
                    }
                    w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson isNeedMove:" + z16);
                } catch (Exception e17) {
                    FileUtils.deleteFile(file.getPath());
                    w53.b.c("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17.toString());
                    AECameraPrefsUtil.c().l(AECameraPrefsUtil.f318466d, 4);
                }
                arrayList = arrayList2;
                l73.a.f413927a.c(arrayList);
                w53.b.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        }
        return arrayList;
    }

    public void n(c cVar) {
        this.f318437f.remove(cVar);
    }

    public void o(ArrayList<MetaMaterial> arrayList, ArrayList<String> arrayList2) {
        this.f318433b = arrayList;
        this.f318435d = arrayList2;
        for (c cVar : this.f318437f) {
            if (cVar != null) {
                cVar.b(arrayList);
            }
        }
        this.f318438g = true;
    }

    public void p(boolean z16) {
        this.f318438g = z16;
    }

    public void q(ArrayList<MetaMaterial> arrayList, ArrayList<String> arrayList2) {
        this.f318434c = arrayList;
    }
}
