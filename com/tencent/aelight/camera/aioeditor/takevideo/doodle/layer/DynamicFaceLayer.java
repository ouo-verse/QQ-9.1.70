package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ir.i;
import ir.p;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DynamicFaceLayer extends FaceLayer {

    /* renamed from: e0, reason: collision with root package name */
    private boolean f67954e0;

    public DynamicFaceLayer(DoodleView doodleView) {
        super(doodleView);
        this.f67954e0 = false;
    }

    public static String r0(String str) {
        if (TextUtils.isEmpty(str) && !str.endsWith(".apng")) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "getDynamicStaticPicPath|path= " + str);
        }
        String str2 = str.substring(0, str.length() - 5) + ".bpng";
        if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "newPath= " + str2);
        }
        if (new File(str2).exists()) {
            return str2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
        }
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer
    protected boolean a0() {
        return W() >= 10;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer, tr.d
    public void clear() {
        super.clear();
        this.f67958b0.clear();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer, tr.a
    public String h() {
        return "DynamicFaceLayer";
    }

    @Override // tr.a
    public int i() {
        return Integer.MAX_VALUE;
    }

    @Override // tr.a
    public void o() {
        List<FaceLayer.b> list = this.K;
        if (list != null) {
            Iterator<FaceLayer.b> it = list.iterator();
            while (it.hasNext()) {
                Drawable drawable = it.next().f67963x;
                if (drawable instanceof p) {
                    ((p) drawable).o();
                }
            }
        }
        super.o();
    }

    public String p0(int i3, int i16, boolean z16) {
        int i17;
        DoodleView doodleView = this.f437143e;
        int i18 = doodleView.f68234d;
        int i19 = doodleView.f68235e;
        if (i3 > i16 && z16) {
            i16 = i3;
            i3 = i16;
        }
        float f16 = (i18 * 1.0f) / i19;
        float f17 = (i3 * 1.0f) / i16;
        int i26 = 0;
        if (f17 == f16) {
            i17 = 0;
        } else if (f16 > f17) {
            i19 = Math.round(i18 / f17);
            i26 = (i19 - this.f437143e.f68235e) / 2;
            i17 = 0;
        } else {
            i18 = Math.round(i19 * f17);
            DoodleView doodleView2 = this.f437143e;
            i19 = doodleView2.f68235e;
            i17 = (i18 - doodleView2.f68234d) / 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "layerParams=" + i18 + "*" + i19 + ",heightOffset=" + i26 + ",widthOffset=" + i17);
        }
        if (!this.f437143e.f68239m.s()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FaceLayer.b bVar : this.K) {
            DynamicStickerData dynamicStickerData = new DynamicStickerData();
            dynamicStickerData.centerP = bVar.f453045a;
            dynamicStickerData.scale = bVar.f453046b;
            dynamicStickerData.rotate = bVar.f453047c;
            dynamicStickerData.translateX = bVar.f453048d + i17;
            dynamicStickerData.translateY = bVar.f453049e + i26;
            dynamicStickerData.height = bVar.f453052h;
            dynamicStickerData.width = bVar.f453051g;
            dynamicStickerData.path = bVar.B;
            dynamicStickerData.type = bVar.K;
            dynamicStickerData.data = bVar.I;
            dynamicStickerData.layerWidth = i18;
            dynamicStickerData.layerHeight = i19;
            arrayList.add(dynamicStickerData);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "generateDynamicStickers|size= " + arrayList.size());
        }
        return zr.b.c(arrayList);
    }

    public void s0(boolean z16) {
        List<FaceLayer.b> list;
        URLDrawable uRLDrawable;
        Drawable currDrawable;
        if ((!this.f67954e0 && !z16) || (list = this.K) == null || list.isEmpty()) {
            return;
        }
        Iterator<FaceLayer.b> it = this.K.iterator();
        while (it.hasNext()) {
            Drawable drawable = it.next().f67963x;
            if (drawable != null && (drawable instanceof URLDrawable) && (uRLDrawable = (URLDrawable) drawable) != null && (currDrawable = uRLDrawable.getCurrDrawable()) != null && (currDrawable instanceof ApngDrawable) && ((ApngDrawable) currDrawable).getImage() != null) {
                if (z16) {
                    this.f67954e0 = true;
                    ApngImage.pauseByTag(13);
                } else {
                    this.f67954e0 = false;
                    ApngImage.playByTag(13);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t0(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2;
        Exception e16;
        if (this.f437143e.f68239m.s()) {
            canvas.save();
            float f16 = this.H;
            canvas.scale(f16, f16);
            for (FaceLayer.b bVar : this.K) {
                Drawable q06 = q0(r0(bVar.B));
                if (q06 != null) {
                    q06.setBounds(0, 0, (int) bVar.f453051g, (int) bVar.f453052h);
                }
                if (bVar.K == 3 && (drawable = bVar.f67963x) != null && (drawable instanceof i)) {
                    try {
                        drawable2 = new BitmapDrawable(this.f437142d.getResources(), ((i) drawable).h());
                        try {
                            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                        } catch (Exception e17) {
                            e16 = e17;
                            QLog.e("DynamicFaceLayer", 1, "saveStaticFrame fail, ", e16);
                            q06 = drawable2;
                            if (q06 == null) {
                            }
                        }
                    } catch (Exception e18) {
                        drawable2 = q06;
                        e16 = e18;
                    }
                    q06 = drawable2;
                }
                if (q06 == null) {
                    canvas.save();
                    canvas.concat(this.W.n(bVar));
                    canvas.save();
                    canvas.translate((-bVar.f453051g) / 2.0f, (-bVar.f453052h) / 2.0f);
                    q06.draw(canvas);
                    canvas.restore();
                    canvas.restore();
                }
            }
            canvas.restore();
        }
    }

    public static Drawable q0(String str) {
        BitmapDrawable bitmapDrawable = null;
        if (str == null) {
            return null;
        }
        try {
            Bitmap c16 = com.tencent.biz.qqstory.utils.b.c(str);
            if (c16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicFaceLayer", 2, "bitmap= " + c16.getWidth() + "*" + c16.getHeight());
                }
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(c16);
                try {
                    bitmapDrawable2.setBounds(0, 0, c16.getWidth(), c16.getHeight());
                    return bitmapDrawable2;
                } catch (OutOfMemoryError e16) {
                    bitmapDrawable = bitmapDrawable2;
                    e = e16;
                    e.printStackTrace();
                    return bitmapDrawable;
                }
            }
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("DynamicFaceLayer", 2, "bitmap is null path=" + str);
            return null;
        } catch (OutOfMemoryError e17) {
            e = e17;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer
    public void i0(final ArrayList<PasterParcelData> arrayList, boolean z16, JSONArray jSONArray) {
        BitmapDrawable bitmapDrawable;
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                PasterParcelData pasterParcelData = arrayList.get(i3);
                if (pasterParcelData.J == 3 && !TextUtils.isEmpty(pasterParcelData.K)) {
                    EditVideoParams editVideoParams = this.f437143e.f68239m;
                    boolean z17 = editVideoParams != null && editVideoParams.s();
                    i b16 = hr.c.b(BaseApplication.getContext(), pasterParcelData.K);
                    if (z17) {
                        bitmapDrawable = b16;
                    } else {
                        bitmapDrawable = b16 != 0 ? new BitmapDrawable(this.f437142d.getResources(), b16.h()) : null;
                    }
                    RectF rectF = pasterParcelData.E;
                    int i16 = (int) rectF.left;
                    int i17 = (int) rectF.right;
                    int i18 = (int) rectF.top;
                    int i19 = (int) rectF.bottom;
                    if (bitmapDrawable != null) {
                        bitmapDrawable.setBounds(i16, i18, i17, i19);
                        hd0.c.a("DynamicFaceLayer", "Create Normal FaceItem.");
                        PointF pointF = pasterParcelData.f66833e;
                        FaceLayer.b bVar = new FaceLayer.b(bitmapDrawable, new FaceLayer.d(pointF.x, pointF.y, pasterParcelData.f66834f, pasterParcelData.f66835h, pasterParcelData.f66836i, pasterParcelData.f66837m, (int) pasterParcelData.C, (int) pasterParcelData.D), pasterParcelData.F, pasterParcelData.G, pasterParcelData.H, pasterParcelData.J);
                        bVar.f453065u.set(pasterParcelData.Q);
                        bVar.I = pasterParcelData.K;
                        bVar.J = pasterParcelData.L;
                        bVar.C = 0;
                        bVar.D = 1;
                        bVar.E = hr.c.e(b16.i());
                        bVar.F = hr.c.d(b16.i());
                        if (bVar.E) {
                            this.f67958b0.add(bVar);
                            if (!TextUtils.isEmpty(pasterParcelData.I)) {
                                bVar.G = new TroopBarPOI("-1", "", pasterParcelData.I, 0, "", 0, "");
                                bVar.H = System.currentTimeMillis();
                            }
                        }
                        EditVideoParams editVideoParams2 = this.f437143e.f68239m;
                        if (editVideoParams2 != null && editVideoParams2.s()) {
                            bitmapDrawable.setCallback(this.f437143e);
                            this.K.add(bVar);
                        } else {
                            bVar.K = 0;
                            FaceLayer faceLayer = (FaceLayer) this.f437143e.t(FaceLayer.f67956d0);
                            if (faceLayer != null) {
                                faceLayer.K.add(bVar);
                            }
                        }
                    }
                }
                i3++;
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r5v8, types: [com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer$b] */
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        int i26;
                        FaceLayer.a aVar;
                        int i27;
                        int i28 = 0;
                        int i29 = 0;
                        while (i29 < arrayList.size()) {
                            PasterParcelData pasterParcelData2 = (PasterParcelData) arrayList.get(i29);
                            if (!TextUtils.isEmpty(pasterParcelData2.H)) {
                                if (((tr.a) DynamicFaceLayer.this).f437143e.f68239m != null && ((tr.a) DynamicFaceLayer.this).f437143e.f68239m.s()) {
                                    int[] iArr = new int[1];
                                    iArr[i28] = 13;
                                    URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), pasterParcelData2.H, "-Dynamic-", com.tencent.mobileqq.urldrawable.b.f306350a, iArr, "-Dynamic-", null);
                                    if (apngDrawable != null) {
                                        if (apngDrawable.getStatus() != 1) {
                                            apngDrawable.restartDownload();
                                        }
                                        apngDrawable.setCallback(((tr.a) DynamicFaceLayer.this).f437143e);
                                        drawable = apngDrawable;
                                    } else {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("DynamicFaceLayer", 2, "apng error");
                                        }
                                        drawable = null;
                                    }
                                } else {
                                    String r06 = DynamicFaceLayer.r0(pasterParcelData2.H);
                                    pasterParcelData2.H = r06;
                                    pasterParcelData2.J = i28;
                                    drawable = DynamicFaceLayer.q0(r06);
                                }
                                Drawable drawable2 = drawable;
                                RectF rectF2 = pasterParcelData2.E;
                                int i36 = (int) rectF2.left;
                                int i37 = (int) rectF2.right;
                                int i38 = (int) rectF2.top;
                                int i39 = (int) rectF2.bottom;
                                if (drawable2 != null) {
                                    drawable2.setBounds(i36, i38, i37, i39);
                                    if (TextUtils.isEmpty(pasterParcelData2.P)) {
                                        hd0.c.a("DynamicFaceLayer", "Create Normal FaceItem.");
                                        PointF pointF2 = pasterParcelData2.f66833e;
                                        i26 = i29;
                                        aVar = new FaceLayer.b(drawable2, new FaceLayer.d(pointF2.x, pointF2.y, pasterParcelData2.f66834f, pasterParcelData2.f66835h, pasterParcelData2.f66836i, pasterParcelData2.f66837m, (int) pasterParcelData2.C, (int) pasterParcelData2.D), pasterParcelData2.F, pasterParcelData2.G, pasterParcelData2.H, pasterParcelData2.J);
                                    } else {
                                        hd0.c.a("DynamicFaceLayer", "Create FaceAndTextItem with text:" + pasterParcelData2.P);
                                        PointF pointF3 = pasterParcelData2.f66833e;
                                        i26 = i29;
                                        FaceLayer.a aVar2 = new FaceLayer.a(drawable2, new FaceLayer.d(pointF3.x, pointF3.y, pasterParcelData2.f66834f, pasterParcelData2.f66835h, pasterParcelData2.f66836i, pasterParcelData2.f66837m, (int) pasterParcelData2.C, (int) pasterParcelData2.D, pasterParcelData2.P, pasterParcelData2.N, pasterParcelData2.M), pasterParcelData2.F, pasterParcelData2.G, pasterParcelData2.H, pasterParcelData2.J);
                                        aVar2.l();
                                        i28 = 0;
                                        aVar = aVar2;
                                    }
                                    aVar.C = i28;
                                    if (aVar.K != 1) {
                                        FaceLayer faceLayer2 = (FaceLayer) ((tr.a) DynamicFaceLayer.this).f437143e.t(FaceLayer.f67956d0);
                                        if (faceLayer2 != null) {
                                            try {
                                                Field declaredField = FaceLayer.b.class.getDeclaredField("L");
                                                declaredField.setAccessible(true);
                                                declaredField.set(aVar, faceLayer2);
                                            } catch (Exception e16) {
                                                if (QLog.isColorLevel()) {
                                                    i27 = 0;
                                                    QLog.d("DynamicFaceLayer", 2, "reflect faceLayer Item error : ", e16.getMessage());
                                                }
                                            }
                                            i27 = 0;
                                            faceLayer2.K.add(aVar);
                                            faceLayer2.n();
                                        } else {
                                            i27 = 0;
                                        }
                                    } else {
                                        i27 = 0;
                                        DynamicFaceLayer.this.K.add(aVar);
                                        DynamicFaceLayer.this.n();
                                    }
                                    i29 = i26 + 1;
                                    i28 = i27;
                                }
                            }
                            i27 = i28;
                            i26 = i29;
                            i29 = i26 + 1;
                            i28 = i27;
                        }
                    }
                }, 8, null, false);
                return;
            }
        }
    }

    @Override // tr.a
    public void v(Canvas canvas, float f16) {
    }
}
