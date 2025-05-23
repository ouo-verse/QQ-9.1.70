package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ApngDecodeWrapper implements com.tencent.mobileqq.editor.composite.util.b {

    /* renamed from: a, reason: collision with root package name */
    private d f66802a;

    /* renamed from: b, reason: collision with root package name */
    private String f66803b;

    public ApngDecodeWrapper(String str, String str2) {
        this.f66803b = str;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public Bitmap getNextGifFrame(long j3) {
        d dVar = this.f66802a;
        if (dVar != null) {
            return dVar.b(j3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.editor.composite.util.b
    public int getType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public void init() {
        if (TextUtils.isEmpty(this.f66803b)) {
            return;
        }
        if (!((IVasApngIPCModule) QRoute.api(IVasApngIPCModule.class)).loadSoLib()) {
            ((IVasApngIPCModule) QRoute.api(IVasApngIPCModule.class)).download();
            if (QLog.isColorLevel()) {
                QLog.d("ApngDecodeWrapper", 2, "so not loaded");
                return;
            }
            return;
        }
        File file = new File(this.f66803b);
        if (file.exists() && file.isFile()) {
            try {
                this.f66802a = new d(file);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.GifDecoder
    public void release() {
        this.f66802a = null;
    }

    public ApngDecodeWrapper(String str) {
        this.f66803b = str;
    }
}
