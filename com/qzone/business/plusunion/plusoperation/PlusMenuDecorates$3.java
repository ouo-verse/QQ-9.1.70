package com.qzone.business.plusunion.plusoperation;

import QZONE_OPERATION_ENTRANCE.EntranceRes;
import android.view.View;
import com.qzone.business.plusunion.plusoperation.f;
import com.tencent.open.base.MD5Utils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
class PlusMenuDecorates$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ EntranceRes f44651d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f44652e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ View f44653f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f44654h;
    final /* synthetic */ f this$0;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        if (com.tencent.image.ApngDrawable.isApngFile(r0) != false) goto L9;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str = CacheManager.getPlusDecorateDir() + File.separator + MD5Utils.toMD5(this.f44651d.resUrl);
        File file = new File(str);
        boolean z16 = false;
        boolean z17 = true;
        try {
            if (file.exists()) {
            }
            z16 = true;
            z17 = z16;
        } catch (IOException e16) {
            QZLog.i("PlusMenuDecorates", 2, "itemId:", Integer.valueOf(this.f44652e), " decorate res  is invalidate", e16);
        }
        if (z17) {
            EntranceRes entranceRes = this.f44651d;
            f.a(null, entranceRes.resUrl, new f.a(null, str, this.f44653f, entranceRes, this.f44654h));
        } else {
            f.c(null, str, new WeakReference(this.f44653f), this.f44651d, this.f44654h);
        }
    }
}
