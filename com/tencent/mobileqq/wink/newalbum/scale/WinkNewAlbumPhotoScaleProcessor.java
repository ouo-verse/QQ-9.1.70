package com.tencent.mobileqq.wink.newalbum.scale;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.utils.f;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes21.dex */
public class WinkNewAlbumPhotoScaleProcessor extends com.tencent.mobileqq.wink.newalbum.processor.b {
    private long C;
    private long D;
    private long E;
    private final LinkedBlockingQueue<WinkNewAlbumContext> F;
    private final AtomicBoolean G;

    /* renamed from: m, reason: collision with root package name */
    private final int f324334m;

    /* loaded from: classes21.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumContext f324335a;

        a(WinkNewAlbumContext winkNewAlbumContext) {
            this.f324335a = winkNewAlbumContext;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.scale.c
        public void a(boolean z16, String str, boolean z17) {
            if (QLog.isColorLevel()) {
                QLog.d(WinkNewAlbumPhotoScaleProcessor.this.b(), 1, "scale photo result: " + z16 + "; useCache: " + z17);
            }
            if (z16) {
                this.f324335a.x(str);
            }
            if (!z17) {
                this.f324335a.w(WinkNewAlbumPhotoScaleProcessor.this.C);
                this.f324335a.v(WinkNewAlbumPhotoScaleProcessor.this.D);
                this.f324335a.u(WinkNewAlbumPhotoScaleProcessor.this.E);
            }
            this.f324335a.s(z16);
            WinkNewAlbumPhotoScaleProcessor.this.i(this.f324335a);
        }
    }

    public WinkNewAlbumPhotoScaleProcessor(com.tencent.mobileqq.wink.newalbum.processor.a aVar, String str) {
        super(aVar, str);
        this.f324334m = w83.b.f445025a.t();
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = new LinkedBlockingQueue<>();
        this.G = new AtomicBoolean(false);
        A();
    }

    private void A() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.scale.WinkNewAlbumPhotoScaleProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(WinkNewAlbumPhotoScaleProcessor.this.b(), 1, "start scale!");
                while (!WinkNewAlbumPhotoScaleProcessor.this.G.get()) {
                    try {
                        WinkNewAlbumContext winkNewAlbumContext = (WinkNewAlbumContext) WinkNewAlbumPhotoScaleProcessor.this.F.poll();
                        if (winkNewAlbumContext != null) {
                            WinkNewAlbumPhotoScaleProcessor.this.B(winkNewAlbumContext);
                        }
                    } catch (Exception e16) {
                        QLog.d(WinkNewAlbumPhotoScaleProcessor.this.b(), 1, e16, new Object[0]);
                    }
                }
                QLog.i(WinkNewAlbumPhotoScaleProcessor.this.b(), 1, "timeCost:" + (System.currentTimeMillis() - WinkNewAlbumPhotoScaleProcessor.this.getStartTime()));
                WinkNewAlbumPhotoScaleProcessor.this.r();
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(WinkNewAlbumContext winkNewAlbumContext) {
        Bitmap z16;
        String path = winkNewAlbumContext.getMetaData().getPath();
        String v3 = v(winkNewAlbumContext.getMetaData());
        String w3 = w(v3);
        c scaledCallback = winkNewAlbumContext.getScaledCallback();
        String str = "";
        boolean z17 = true;
        if (StringUtil.isEmpty(v3)) {
            x(scaledCallback, false, "", false);
            QLog.d(b(), 1, "photoID is empty! isLast: " + winkNewAlbumContext.getIsLast());
            return;
        }
        if (!WinkNewAlbumDatabaseImp.u(v3) && !s(w3)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.C = 0L;
            this.D = 0L;
            this.E = 0L;
            try {
                try {
                    if (winkNewAlbumContext.getMetaData().D()) {
                        z16 = f11.c.n(path, this.f324334m);
                        if (z16 != null && (z16.getWidth() != this.f324334m || z16.getHeight() != this.f324334m)) {
                            int i3 = this.f324334m;
                            z16 = Bitmap.createScaledBitmap(z16, i3, i3, true);
                        }
                        this.C = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        int i16 = this.f324334m;
                        z16 = z(path, i16, i16);
                        this.D = System.currentTimeMillis() - currentTimeMillis;
                    }
                } catch (Exception e16) {
                    QLog.d(b(), 1, e16, new Object[0]);
                    str = "scale fail!" + e16;
                    f.n(null);
                    z17 = false;
                }
                if (z16 == null) {
                    String str2 = "cannot find bitmap! please check origin Path: " + path;
                    QLog.d(b(), 1, str2);
                    y(str2);
                    f.n(z16);
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                File t16 = f.t(w3, z16);
                this.E = System.currentTimeMillis() - currentTimeMillis2;
                if (QLog.isColorLevel()) {
                    QLog.i("WinkNewAlbumPhotoScaleProcessor", 2, "saveScaledPhotoCost:" + this.E);
                }
                if (t16 == null) {
                    z17 = false;
                }
                f.n(z16);
                if (!z17) {
                    y(str);
                }
                x(scaledCallback, z17, w3, false);
                return;
            } catch (Throwable th5) {
                f.n(null);
                throw th5;
            }
        }
        x(scaledCallback, true, w3, true);
    }

    private void q() {
        this.G.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.G.set(true);
        this.F.clear();
    }

    private static boolean s(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    private WinkPublishQualityReportData t(String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_ALBUM_SCALE_RESULT").traceId(getTraceId());
        if (str.isEmpty()) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        WinkPublishQualityReportData.Builder ext3 = traceId.retCode(str2).ext1(this.D + "").ext2(this.E + "").ext3(this.C + "");
        if (str.isEmpty()) {
            str = "fail but no result!";
        }
        return ext3.desc(str).attachInfo("Peak").getReportData();
    }

    public static String u() {
        return ".data";
    }

    private static String v(z83.a aVar) {
        if (aVar != null && !aVar.getId().isEmpty()) {
            return aVar.getId();
        }
        return "";
    }

    private String w(String str) {
        String str2 = r83.a.WINK_NEWALBUM_SCALED_RES_ROOT_PATH;
        if (StringUtil.isEmpty(str)) {
            QLog.d(b(), 1, "photo ID is empty!");
            return "";
        }
        return str2 + str + ".data";
    }

    private static void x(c cVar, boolean z16, String str, boolean z17) {
        if (cVar != null) {
            cVar.a(z16, str, z17);
        }
    }

    private void y(String str) {
        h(t(str));
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        if (winkNewAlbumContext == null) {
            QLog.d(b(), 1, "context is null");
            return;
        }
        super.a(winkNewAlbumContext);
        winkNewAlbumContext.y(new a(winkNewAlbumContext));
        this.F.offer(winkNewAlbumContext);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @NonNull
    public String b() {
        return super.b() + "WinkNewAlbumPhotoScaleProcessor";
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void i(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        super.i(winkNewAlbumContext);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        q();
        QLog.d(b(), 1, "scale processor stop!");
    }

    public Bitmap z(String str, int i3, int i16) {
        Bitmap bitmap = null;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            try {
                if (decodeFile == null) {
                    QLog.d(b(), 1, "cannot find bitmap! please check origin Path: " + str);
                    return null;
                }
                return Bitmap.createScaledBitmap(decodeFile, i3, i16, true);
            } catch (Exception e16) {
                e = e16;
                bitmap = decodeFile;
                QLog.d(b(), 1, e, new Object[0]);
                return bitmap;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
    }
}
