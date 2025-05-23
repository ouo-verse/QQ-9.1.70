package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.FaceRects;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.aeeditor.module.aifilter.a;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes32.dex */
public abstract class AIFilterProxyBase {

    /* renamed from: e, reason: collision with root package name */
    private static final String f66166e = "AIFilterProxyBase";

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a.InterfaceC0571a> f66167a;

    /* renamed from: b, reason: collision with root package name */
    protected int f66168b = 1;

    /* renamed from: c, reason: collision with root package name */
    protected List<Bitmap> f66169c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    protected List<Bitmap> f66170d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3);

        void b(ArrayList<SmartFilterReqItem> arrayList);
    }

    public static List<Bitmap> e(List<String> list, List<com.tencent.aelight.camera.aeeditor.data.a> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i3 = 0; i3 < list.size() && i3 < list2.size(); i3++) {
                String str = list.get(i3);
                CropConfig cropConfig = list2.get(i3).f66102c;
                int max = Math.max(list2.get(i3).f66100a, list2.get(i3).f66101b);
                int i16 = 1;
                if (max > 400) {
                    while (max / i16 > 400) {
                        i16 *= 2;
                    }
                }
                String str2 = f66166e;
                ms.a.a(str2, "decodeBitmap: start ");
                Bitmap cropBitmap = BitmapUtil.cropBitmap(str, cropConfig, i16);
                ms.a.a(str2, "decodeBitmap: end ");
                arrayList.add(cropBitmap);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, List<Bitmap> list, a aVar) {
        ms.a.f(f66166e, "doFaceDetect");
        LinkedList linkedList = list == null ? null : new LinkedList(list);
        if (linkedList == null) {
            if (aVar != null) {
                aVar.a(-2);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bitmap bitmap : linkedList) {
            String str = f66166e;
            ms.a.a(str, "doFaceDetect start");
            Math.max(bitmap.getHeight(), bitmap.getWidth());
            ms.a.a(str, "doFaceDetect end");
        }
        ArrayList<SmartFilterReqItem> m3 = m(context, linkedList, arrayList);
        if (m3 == null || m3.size() == 0) {
            if (aVar != null) {
                aVar.a(-3);
            }
        } else if (aVar != null) {
            aVar.b(m3);
        }
    }

    public static ArrayList<FaceRects> i(PTFaceAttr pTFaceAttr) {
        ArrayList<FaceRects> arrayList = new ArrayList<>();
        if (pTFaceAttr != null) {
            for (List<PointF> list : pTFaceAttr.getAllFacePoints()) {
                if (list != null && list.size() > 0) {
                    float f16 = Float.MIN_VALUE;
                    float f17 = Float.MAX_VALUE;
                    float f18 = 0.0f;
                    float f19 = 0.0f;
                    float f26 = 0.0f;
                    float f27 = 0.0f;
                    float f28 = Float.MIN_VALUE;
                    float f29 = Float.MAX_VALUE;
                    for (PointF pointF : list) {
                        f29 = Math.min(f29, pointF.x);
                        f16 = Math.max(f16, pointF.x);
                        f17 = Math.min(f17, pointF.y);
                        f28 = Math.max(f28, pointF.y);
                        f18 = f29 / pTFaceAttr.getFaceDetWidth();
                        f19 = f17 / pTFaceAttr.getFaceDetHeight();
                        f26 = (f16 - f29) / pTFaceAttr.getFaceDetWidth();
                        f27 = (f28 - f17) / pTFaceAttr.getFaceDetHeight();
                    }
                    arrayList.add(new FaceRects(f18, f19, f26, f27));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<SmartFilterReqItem> m(Context context, List<Bitmap> list, List<PTFaceAttr> list2) {
        ArrayList<SmartFilterReqItem> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            arrayList.add(d(context, list.get(i3), (list2 == null || list2.size() <= i3) ? null : i(list2.get(i3))));
            i3++;
        }
        return arrayList;
    }

    protected boolean b(List<Bitmap> list) {
        Iterator<Bitmap> it = list.iterator();
        while (it.hasNext()) {
            if (!BitmapUtils.isLegal(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void c() {
        ms.a.f(f66166e, QCircleLpReportDc05507.KEY_CLEAR);
        List<Bitmap> list = this.f66169c;
        if (list != null && list.size() > 0) {
            Iterator<Bitmap> it = this.f66169c.iterator();
            while (it.hasNext()) {
                BitmapUtils.recycle(it.next());
            }
            this.f66169c.clear();
        }
        List<Bitmap> list2 = this.f66170d;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Iterator<Bitmap> it5 = this.f66170d.iterator();
        while (it5.hasNext()) {
            BitmapUtils.recycle(it5.next());
        }
        this.f66170d.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context, List<Bitmap> list, a aVar) {
        ms.a.f(f66166e, "faceDetect");
        if (list != null && b(list)) {
            FaceChangeUtils.runInGLThread(new Runnable(context, list, aVar) { // from class: com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase.3

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f66171d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ List f66172e;

                @Override // java.lang.Runnable
                public void run() {
                    AIFilterProxyBase.this.f(this.f66171d, this.f66172e, null);
                }
            }, false, "");
        } else if (aVar != null) {
            aVar.a(-2);
        }
    }

    public a.InterfaceC0571a j() {
        WeakReference<a.InterfaceC0571a> weakReference = this.f66167a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract c k(List<b> list);

    public void l() {
        ms.a.f(f66166e, "removeObserver");
        this.f66167a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c h() {
        return k(null);
    }

    private SmartFilterReqItem d(Context context, Bitmap bitmap, ArrayList<FaceRects> arrayList) {
        boolean z16;
        if (bitmap == null) {
            return null;
        }
        double sqrt = Math.sqrt(25600.0f / this.f66168b);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.getWidth() > sqrt || bitmap.getHeight() > sqrt) {
            Matrix matrix = new Matrix();
            float max = (float) Math.max(sqrt / bitmap.getWidth(), sqrt / bitmap.getHeight());
            matrix.postScale(max, max);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            z16 = true;
        } else {
            z16 = false;
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        SmartFilterReqItem smartFilterReqItem = new SmartFilterReqItem(byteArrayOutputStream.toByteArray(), arrayList);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (z16) {
            BitmapUtils.recycle(bitmap);
        }
        return smartFilterReqItem;
    }
}
