package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    static final String f98366a = BuildConfigWrapper.getDomain();

    /* renamed from: h, reason: collision with root package name */
    private static bx f98367h;

    /* renamed from: b, reason: collision with root package name */
    Context f98368b;

    /* renamed from: c, reason: collision with root package name */
    UserMeta f98369c;

    /* renamed from: d, reason: collision with root package name */
    ai f98370d;

    /* renamed from: e, reason: collision with root package name */
    UploadProxy f98371e = null;

    /* renamed from: f, reason: collision with root package name */
    String f98372f = "";

    /* renamed from: g, reason: collision with root package name */
    String f98373g = "";

    bx() {
    }

    public static bx a() {
        if (f98367h == null) {
            synchronized (bx.class) {
                f98367h = new bx();
            }
        }
        return f98367h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            av.c("Exit file do not exist.", new Object[0]);
            return null;
        }
        String name = file.getName();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        String str3 = str2 + File.separator + name + ".zip";
        File file2 = FileUtil.zipFiles((List<String>) arrayList, str3, false) ? new File(str3) : null;
        FileUtil.deleteFile(file);
        return file2;
    }
}
