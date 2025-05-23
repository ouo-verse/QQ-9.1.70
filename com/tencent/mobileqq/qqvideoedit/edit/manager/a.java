package com.tencent.mobileqq.qqvideoedit.edit.manager;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.qqvideoedit.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f275080f;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<MetaMaterial> f275082b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f275083c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<c> f275084d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f275081a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f275085e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8432a extends TypeToken<ArrayList<MetaCategory>> {
        C8432a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends TypeToken<ArrayList<MetaCategory>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface c {
        void a();

        void b();
    }

    public static a b() {
        if (f275080f == null) {
            synchronized (a.class) {
                if (f275080f == null) {
                    f275080f = new a();
                }
            }
        }
        return f275080f;
    }

    public static String d(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            mj2.a.c("[AEEditor2]AEditorMaterialManager_PTV", "loadFileContent error, ", e16);
            return null;
        }
    }

    private static List<MetaCategory> e(String str) {
        ArrayList arrayList = new ArrayList();
        String i3 = i(str);
        if (TextUtils.isEmpty(i3)) {
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList) new Gson().fromJson(i3, new C8432a().getType());
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private static List<MetaCategory> f(File file) {
        ArrayList arrayList = new ArrayList();
        String d16 = d(file);
        if (TextUtils.isEmpty(d16)) {
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList) new Gson().fromJson(d16, new b().getType());
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public static String i(String str) {
        InputStream inputStream = null;
        try {
            inputStream = com.tencent.mobileqq.qqvideoedit.a.c().getAssets().open(str);
            String h16 = k.h(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return h16;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return h16;
                }
            }
            return h16;
        } catch (Throwable th5) {
            try {
                mj2.a.c("[AEEditor2]AEditorMaterialManager", "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
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

    public String a(String str, String str2) {
        String path;
        synchronized (this.f275081a) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = new File(file.getPath(), str2).getPath();
        }
        return path;
    }

    public MetaCategory c() {
        ArrayList<MetaMaterial> arrayList = this.f275082b;
        if (arrayList != null && !arrayList.isEmpty()) {
            MetaCategory metaCategory = new MetaCategory();
            metaCategory.name = "\u63a8\u8350";
            metaCategory.f30532id = "recommend";
            metaCategory.materials = this.f275082b;
            return metaCategory;
        }
        return null;
    }

    public void g() {
        WeakReference<c> weakReference = this.f275084d;
        if (weakReference != null && weakReference.get() != null) {
            this.f275084d.get().a();
        }
        this.f275085e = true;
    }

    public List<MetaCategory> h(String str, String str2, String str3, boolean z16) {
        List<MetaCategory> list;
        mj2.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile... parent:" + str + " newjson:" + str2 + " oldjson:" + str3);
        synchronized (this.f275081a) {
            List<MetaCategory> arrayList = new ArrayList<>();
            File file = new File(str, str2);
            File file2 = new File(str, str3);
            if (!file.exists()) {
                if (!file2.exists()) {
                    mj2.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist ");
                    list = e(str3);
                } else {
                    try {
                        arrayList = f(file2);
                        mj2.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
                    } catch (Exception e16) {
                        FileUtils.deleteFile(file2.getPath());
                        AECameraPrefsUtil.b().f(AECameraPrefsUtil.f275089d, 4);
                        mj2.a.b("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16.toString());
                    }
                    list = arrayList;
                }
            } else {
                try {
                    arrayList = f(file);
                    if (z16) {
                        FileUtils.moveFile(file.getPath(), file2.getPath());
                    }
                    mj2.a.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson isNeedMove:" + z16);
                } catch (Exception e17) {
                    FileUtils.deleteFile(file.getPath());
                    mj2.a.b("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17.toString());
                    AECameraPrefsUtil.b().f(AECameraPrefsUtil.f275089d, 4);
                }
                list = arrayList;
            }
        }
        return list;
    }

    public void j(ArrayList<MetaMaterial> arrayList, ArrayList<String> arrayList2) {
        this.f275082b = arrayList;
        this.f275083c = arrayList2;
        WeakReference<c> weakReference = this.f275084d;
        if (weakReference != null && weakReference.get() != null) {
            this.f275084d.get().b();
        }
        this.f275085e = true;
    }

    public void k(boolean z16) {
        this.f275085e = z16;
    }
}
