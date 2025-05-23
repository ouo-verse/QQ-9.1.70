package com.qzone.business.plusunion.plusoperation;

import QZONE_OPERATION_ENTRANCE.EntranceRes;
import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.vas.an;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
class PlusMenuDecorates$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f44655d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ WeakReference f44656e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ EntranceRes f44657f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f44658h;
    final /* synthetic */ f this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (ApngDrawable.isApngFile(new File(this.f44655d))) {
                an.h().l(new a(), true);
            } else {
                QZLog.e("PlusMenuDecorates", 2, this.f44657f.resUrl, "is not apng");
            }
        } catch (IOException e16) {
            QZLog.e("PlusMenuDecorates", 2, this.f44657f.resUrl, "is not apng", e16);
        }
    }

    /* loaded from: classes39.dex */
    class a extends URLDrawableHandler.Adapter {
        a() {
        }

        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            View view = (View) PlusMenuDecorates$4.this.f44656e.get();
            if (view == null) {
                return;
            }
            QZLog.i("PlusMenuDecorates", 2, "SoLoadCallback onApngSoLoad");
            PlusMenuDecorates$4.this.getClass();
            PlusMenuDecorates$4 plusMenuDecorates$4 = PlusMenuDecorates$4.this;
            f.b(null, view, plusMenuDecorates$4.f44655d, plusMenuDecorates$4.f44657f, plusMenuDecorates$4.f44658h);
        }

        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int i3) {
        }
    }
}
