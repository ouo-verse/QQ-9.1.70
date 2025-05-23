package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.multisave.a;
import com.tencent.mobileqq.filemanager.util.l;

/* compiled from: P */
/* loaded from: classes12.dex */
class QFileMultiSaveReq$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f208664d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ a.InterfaceC7581a f208665e;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        try {
            if (!TextUtils.isEmpty(l.a(this.f208664d))) {
                z16 = true;
            } else {
                z16 = false;
            }
            a.InterfaceC7581a interfaceC7581a = this.f208665e;
            if (interfaceC7581a != null) {
                if (z16) {
                    interfaceC7581a.onSuccess();
                } else {
                    interfaceC7581a.onError(-1, "save file fail. filePath[" + this.f208664d + "]");
                }
            }
        } catch (Exception e16) {
            a.InterfaceC7581a interfaceC7581a2 = this.f208665e;
            if (interfaceC7581a2 != null) {
                interfaceC7581a2.onError(-1, e16.getMessage());
            }
        }
    }
}
