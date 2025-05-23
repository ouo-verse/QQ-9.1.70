package com.tencent.av.business.processor;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.av.business.manager.pendant.c;
import com.tencent.av.utils.m;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes3.dex */
public abstract class BaseConfigFileProcessor<T extends com.tencent.av.business.manager.pendant.c> {

    /* renamed from: a, reason: collision with root package name */
    protected AppRuntime f73459a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f73460b = new Object();

    public BaseConfigFileProcessor(AppRuntime appRuntime) {
        this.f73459a = appRuntime;
    }

    public static String e(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes != null && fileToBytes.length > 0) {
            return new String(fileToBytes, StandardCharsets.UTF_8);
        }
        return null;
    }

    private void g(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.processor.BaseConfigFileProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.moveFile(str, str2);
            }
        }, 64, null, false);
    }

    public abstract void b();

    public ArrayList<MetaMaterial> c(ArrayList<MetaCategory> arrayList) {
        ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<MetaCategory> it = arrayList.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                Iterator<MetaMaterial> it5 = next.materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next2 = it5.next();
                    next2.additionalFields.put("key_local_use_category_id", next.f30532id);
                    next2.additionalFields.put("key_local_use_category_name", next.name);
                    arrayList2.add(next2);
                }
                arrayList2.addAll(c(next.subCategories));
            }
        }
        return arrayList2;
    }

    public abstract String d();

    public abstract List<T> f(File file);

    public List<T> i(String str, String str2, String str3) {
        List<T> arrayList;
        if (QLog.isColorLevel()) {
            QLog.i("BaseFileProcessor", 2, "readAndParseConfigFile parent: " + str + " newJson: " + str2 + " oldJson: " + str3);
        }
        synchronized (this.f73460b) {
            arrayList = new ArrayList<>();
            File file = new File(str, str2);
            File file2 = new File(str, str3);
            if (!file.exists()) {
                if (!file2.exists()) {
                    QLog.e("BaseFileProcessor", 1, "readAndParseConfigFile -> old json not exist, new json not exist too");
                    b();
                } else {
                    try {
                        arrayList = f(file2);
                    } catch (Exception e16) {
                        FileUtils.deleteFile(file2.getPath());
                        b();
                        QLog.e("BaseFileProcessor", 1, "readAndParseConfigFile -> load oldJson exception " + e16.getMessage());
                    }
                }
            } else {
                try {
                    arrayList = f(file);
                    g(file.getPath(), file2.getPath());
                } catch (Exception e17) {
                    QLog.e("BaseFileProcessor", 1, "readAndParseConfigFile -> load newJson exception " + e17.getMessage());
                    FileUtils.deleteFile(file.getPath());
                    b();
                }
            }
        }
        return arrayList;
    }

    public void j(final String str, final String str2, final String str3) {
        QLog.i("BaseFileProcessor", 2, "updateConfigFile");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.processor.BaseConfigFileProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                Object valueOf;
                synchronized (BaseConfigFileProcessor.this.f73460b) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("updateConfigFile ");
                    String str4 = str;
                    if (str4 == null) {
                        valueOf = "";
                    } else {
                        valueOf = Integer.valueOf(str4.length());
                    }
                    sb5.append(valueOf);
                    sb5.append(" serviceId: ");
                    sb5.append(str2);
                    QLog.i("BaseFileProcessor", 2, sb5.toString());
                    FileUtils.writeFile(BaseConfigFileProcessor.this.d(), str);
                    m.b(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTree" + str2, str3);
                    QLog.i("BaseFileProcessor", 2, "updateConfigFile eTag " + str3);
                    BaseConfigFileProcessor.this.h();
                }
            }
        }, 64, null, false);
    }

    protected void h() {
    }
}
