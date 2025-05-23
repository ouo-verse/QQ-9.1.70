package com.qwallet.data;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qwallet.data.ImageManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
class FramesDownloadManager$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        String p16 = a.p(a.f(null), a.e(null), a.a(null));
        if (TextUtils.isEmpty(p16)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(p16);
        str = a.f41551a;
        sb5.append(str);
        String sb6 = sb5.toString();
        if (!new File(sb6).exists()) {
            sparseArray = a.f41552b;
            synchronized (sparseArray) {
                int hashCode = a.f(null).hashCode();
                sparseArray2 = a.f41552b;
                ArrayList arrayList = (ArrayList) sparseArray2.get(hashCode);
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(null);
                    sparseArray3 = a.f41552b;
                    sparseArray3.append(hashCode, arrayList2);
                    FileUtils.delete(p16, false);
                    ImageManager.b bVar = new ImageManager.b();
                    bVar.f41482a = a.d(null);
                    bVar.f41483b = a.f(null);
                    bVar.f41501t = true;
                    a.e(null).f(bVar);
                    return;
                }
                arrayList.add(null);
                return;
            }
        }
        a.k(null, sb6, true);
    }
}
