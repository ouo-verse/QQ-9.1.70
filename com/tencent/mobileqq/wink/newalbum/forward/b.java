package com.tencent.mobileqq.wink.newalbum.forward;

import android.graphics.Bitmap;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResConfig;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weclip.LoadModelTYPE;
import com.tencent.weclip.WeClip;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private WeClip f324228a;

    private boolean b(WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        int i3;
        boolean z16;
        int i16;
        int i17;
        try {
            WinkNewAlbumResConfig i18 = WinkNewAlbumResConfig.i();
            if (i18 != null) {
                i3 = i18.getThreadCount();
                boolean enableFP16 = i18.getEnableFP16();
                int startLiner = i18.getStartLiner();
                i17 = i18.getEndLiner();
                z16 = enableFP16;
                i16 = startLiner;
            } else {
                i3 = 2;
                z16 = true;
                i16 = 0;
                i17 = 1008;
            }
            f().e(i3, z16, i16, i17, winkNewAlbumResFetchResult.getIvStr(), winkNewAlbumResFetchResult.getKeyStr());
            return f().f(winkNewAlbumResFetchResult.getModelNcnnParamPath(), winkNewAlbumResFetchResult.getModelNcnnBinPath(), LoadModelTYPE.LoadOriginEncryptedFile);
        } catch (Exception e16) {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, e16, new Object[0]);
            return false;
        }
    }

    private WeClip f() {
        if (this.f324228a == null) {
            this.f324228a = new WeClip();
        }
        return this.f324228a;
    }

    public synchronized void a() {
        try {
            WeClip weClip = this.f324228a;
            if (weClip != null) {
                weClip.a();
                this.f324228a = null;
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, "clear clip complete! ");
        } catch (Exception e16) {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, e16, new Object[0]);
        }
    }

    public long c() {
        return f().b();
    }

    public String d() {
        return f().c();
    }

    public String e() {
        return f().d();
    }

    public boolean g(WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        String modelNcnnParamPath = winkNewAlbumResFetchResult.getModelNcnnParamPath();
        String modelNcnnBinPath = winkNewAlbumResFetchResult.getModelNcnnBinPath();
        if (!modelNcnnParamPath.isEmpty() && !modelNcnnBinPath.isEmpty()) {
            if (RFWFileUtils.fileExists(modelNcnnParamPath) && RFWFileUtils.fileExists(modelNcnnBinPath)) {
                return b(winkNewAlbumResFetchResult);
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, "model file doesn't exist!");
            return false;
        }
        QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, "model path is empty!");
        return false;
    }

    public String h() {
        return f().g();
    }

    public float[] i(Bitmap bitmap) {
        float[] fArr = new float[1024];
        try {
            return f().h(bitmap);
        } catch (Exception e16) {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardManager", 1, e16, new Object[0]);
            return fArr;
        }
    }

    public long j() {
        return f().j();
    }
}
