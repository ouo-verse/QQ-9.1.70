package com.tencent.luggage.wxa.b4;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QBarImageUtil;
import com.tencent.qbar.QbarNative;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f121838c;

    /* renamed from: a, reason: collision with root package name */
    public String f121836a = "BaseQBarAIDecoder";

    /* renamed from: d, reason: collision with root package name */
    public Object f121839d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public List f121840e = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public QBar f121837b = new QBar();

    public a(String str) {
        this.f121836a += "_" + str;
    }

    public void a(int i3, QbarNative.QbarAiModelParam qbarAiModelParam) {
        if (this.f121838c) {
            return;
        }
        try {
            synchronized (this.f121839d) {
                int init = this.f121837b.init(1, i3, "ANY", "UTF-8", qbarAiModelParam);
                if (init != 0) {
                    w.d(this.f121836a, "init qbar error, " + init);
                    return;
                }
                this.f121838c = true;
                w.d(this.f121836a, "init qbar success");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean b() {
        return this.f121838c;
    }

    public void c() {
        synchronized (this.f121839d) {
            this.f121838c = false;
            QBar qBar = this.f121837b;
            if (qBar != null) {
                qBar.release();
            }
        }
    }

    public final List b(byte[] bArr, int i3, int i16, List list, List list2) {
        long currentTimeMillis = System.currentTimeMillis();
        int scanImage = this.f121837b.scanImage(bArr, i3, i16);
        if (scanImage < 0) {
            w.b(this.f121836a, "scanImage result " + scanImage);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f121837b.GetResults(3, arrayList, null, list2);
        this.f121837b.GetCodeDetectInfo(3, this.f121840e, arrayList2);
        if (list != null) {
            list.addAll(arrayList2);
        }
        if (arrayList.size() == 0) {
            w.b(this.f121836a, String.format("get no results ,cost %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        w.d(this.f121836a, String.format("get %d results ,cost %dms", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return arrayList;
    }

    public List a(int[] iArr, Point point, List list) {
        w.d(this.f121836a, String.format("decode, size %s", point.toString()));
        if (iArr != null && iArr.length > 0) {
            int i3 = point.x;
            int i16 = point.y;
            byte[] bArr = new byte[i3 * i16];
            int TransBytes = QBarImageUtil.TransBytes(iArr, bArr, i3, i16);
            if (TransBytes != 0) {
                w.b(this.f121836a, "rotate result " + TransBytes);
                return null;
            }
            return b(bArr, point.x, point.y, null, list);
        }
        w.f(this.f121836a, "prepareGrayData , data is null");
        return null;
    }

    public QbarNative.QBarZoomInfo a() {
        return this.f121837b.GetZoomInfo();
    }

    public byte[] a(byte[] bArr, Point point, int i3, Rect rect, int[] iArr) {
        if (bArr != null && bArr.length > 0) {
            w.d(this.f121836a, String.format("cropGrayData, size %s, rect %s, rotation %d", point, rect, Integer.valueOf(i3)));
            int width = rect != null ? rect.width() : point.x;
            int height = rect != null ? rect.height() : point.y;
            int i16 = rect != null ? rect.left : 0;
            int i17 = rect != null ? rect.top : 0;
            byte[] bArr2 = new byte[((width * height) * 3) / 2];
            synchronized (this.f121839d) {
                int gray_rotate_crop_sub = QBarImageUtil.gray_rotate_crop_sub(bArr2, iArr, bArr, point.x, point.y, i16, i17, width, height, i3, 0);
                if (gray_rotate_crop_sub == 0) {
                    return bArr2;
                }
                w.b(this.f121836a, "rotate result " + gray_rotate_crop_sub);
                return null;
            }
        }
        w.f(this.f121836a, "prepareGrayData , data is null");
        return null;
    }

    public List a(byte[] bArr, int i3, int i16, List list, List list2) {
        List b16;
        synchronized (this.f121839d) {
            b16 = b(bArr, i3, i16, list, list2);
        }
        return b16;
    }

    public int a(int[] iArr) {
        int[] iArr2;
        int i3 = 0;
        if (iArr != null) {
            iArr2 = new int[iArr.length];
            int length = iArr.length;
            int i16 = 0;
            while (i3 < length) {
                iArr2[i16] = iArr[i3];
                i3++;
                i16++;
            }
        } else {
            iArr2 = new int[]{2, 1, 4, 5};
        }
        return this.f121837b.setReaders(iArr2, iArr2.length);
    }
}
