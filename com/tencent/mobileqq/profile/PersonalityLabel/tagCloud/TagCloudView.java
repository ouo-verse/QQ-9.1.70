package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TagCloudView extends View implements ISkinSetTypeface {
    static IPatchRedirector $redirector_;
    public static final int N;
    int C;
    Drawable D;
    int E;
    ColorStateList F;
    float G;
    private Matrix H;
    private Matrix I;
    private boolean J;
    private Bitmap K;
    b L;
    Paint M;

    /* renamed from: d, reason: collision with root package name */
    int f259949d;

    /* renamed from: e, reason: collision with root package name */
    Random f259950e;

    /* renamed from: f, reason: collision with root package name */
    List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> f259951f;

    /* renamed from: h, reason: collision with root package name */
    List<a> f259952h;

    /* renamed from: i, reason: collision with root package name */
    int f259953i;

    /* renamed from: m, reason: collision with root package name */
    int f259954m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f259955a;

        /* renamed from: b, reason: collision with root package name */
        float f259956b;

        /* renamed from: c, reason: collision with root package name */
        int f259957c;

        /* renamed from: d, reason: collision with root package name */
        int f259958d;

        public a(int i3, float f16, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f259955a = i3;
            this.f259956b = f16;
            this.f259957c = i16;
            this.f259958d = i17;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return super.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void n0(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements Comparator<Rect> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Point f259959d;

        public c(Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TagCloudView.this, (Object) point);
            } else {
                this.f259959d = point;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rect rect, Rect rect2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rect, (Object) rect2)).intValue();
            }
            return TagCloudView.l(new Point((int) ((rect.width() * 0.5f) + rect.left), (int) ((rect.height() * 0.5f) + rect.top)), this.f259959d) - TagCloudView.l(new Point((int) ((rect2.width() * 0.5f) + rect2.left), (int) ((rect2.height() * 0.5f) + rect2.top)), this.f259959d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements Comparator<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Random f259961d;

        /* renamed from: e, reason: collision with root package name */
        int f259962e;

        /* renamed from: f, reason: collision with root package name */
        int f259963f;

        public d(Random random, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TagCloudView.this, random, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f259961d = random;
            this.f259962e = i16;
            this.f259963f = i3;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar, com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            Point point = aVar.f259976h;
            int i3 = point.y;
            int i16 = this.f259962e;
            if (i3 <= i16) {
                Point point2 = aVar2.f259976h;
                if (point2.y <= i16) {
                    int i17 = point.x;
                    int i18 = this.f259963f;
                    if (i17 <= i18 && point2.x <= i18) {
                        return this.f259961d.nextInt(3) - 2;
                    }
                    return -(i17 - point2.x);
                }
            }
            return -(i3 - aVar2.f259976h.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements Comparator<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Point f259965d;

        public e(Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TagCloudView.this, (Object) point);
            } else {
                this.f259965d = point;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar, com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            return TagCloudView.l(aVar.b(), this.f259965d) - TagCloudView.l(aVar2.b(), this.f259965d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            N = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
    }

    public TagCloudView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    private static void b(List<Point> list, com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar, int i3, int i16) {
        if (!aVar.n()) {
            return;
        }
        Point point = aVar.f259975g;
        Point point2 = new Point(point.x, point.y);
        Point point3 = aVar.f259975g;
        Point point4 = new Point(point3.x + aVar.f259976h.x, point3.y);
        Point point5 = aVar.f259975g;
        Point point6 = new Point(point5.x, point5.y + aVar.f259976h.y);
        Point point7 = aVar.f259975g;
        int i17 = point7.x;
        Point point8 = aVar.f259976h;
        Point point9 = new Point(i17 + point8.x, point7.y + point8.y);
        if (!r(list, point2)) {
            list.add(point2);
        }
        if (!r(list, point4)) {
            list.add(point4);
        }
        if (!r(list, point6)) {
            list.add(point6);
        }
        if (!r(list, point9)) {
            list.add(point9);
        }
    }

    private void c(Canvas canvas, int i3) {
        boolean z16;
        float f16;
        float f17;
        int intrinsicWidth = this.D.getIntrinsicWidth();
        int intrinsicHeight = this.D.getIntrinsicHeight();
        if ((intrinsicWidth >= 0 && i3 != intrinsicWidth) || (intrinsicHeight >= 0 && i3 != intrinsicHeight)) {
            z16 = false;
        } else {
            z16 = true;
        }
        canvas.save();
        canvas.clipRect(0, 0, i3, i3);
        if (z16) {
            this.I = null;
            this.D.setBounds(0, 0, i3, i3);
        } else {
            this.D.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            Matrix matrix = new Matrix(this.H);
            this.I = matrix;
            float f18 = 0.0f;
            if (intrinsicWidth * i3 > i3 * intrinsicHeight) {
                float f19 = i3;
                f17 = f19 / intrinsicHeight;
                f18 = (f19 - (intrinsicWidth * f17)) * 0.5f;
                f16 = 0.0f;
            } else {
                float f26 = i3;
                float f27 = f26 / intrinsicWidth;
                f16 = (f26 - (intrinsicHeight * f27)) * 0.5f;
                f17 = f27;
            }
            matrix.setScale(f17, f17);
            this.I.postTranslate(Math.round(f18), Math.round(f16));
        }
        if (this.I == null) {
            this.D.draw(canvas);
        } else {
            canvas.save();
            canvas.concat(this.I);
            this.D.draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }

    private int d(List<Rect> list, int i3, int i16, int i17) {
        int i18 = i16 + i17;
        int i19 = (int) (i16 * 0.5f);
        for (int i26 = 0; i26 < list.size(); i26++) {
            Rect rect = list.get(i26);
            if (rect.top != 0 && (rect.centerY() >= i19 || rect.bottom == i16)) {
                rect.top += i17;
                rect.bottom += i17;
            }
        }
        return i18;
    }

    private void e(Rect rect) {
        boolean z16;
        float f16 = this.C * 0.5f;
        if (rect.left >= 0 && rect.top >= 0 && rect.height() >= f16 && rect.width() >= f16) {
            if (rect.width() >= this.C || rect.height() >= this.C) {
                int height = rect.height() * rect.width();
                int i3 = this.C;
                if (height >= i3 * i3) {
                    if (QLog.isDebugVersion()) {
                        QLog.i("TagCloudView", 4, "fillWithTags rect:" + rect);
                    }
                    boolean z17 = false;
                    if ((rect.width() >= this.C * 4 || rect.height() >= this.C * 4) && rect.width() > this.C && rect.height() > this.C) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    int g16 = g(rect);
                    if (g16 < 0) {
                        return;
                    }
                    com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = this.f259951f.get(g16);
                    float f17 = 0.8f;
                    int e16 = (int) (aVar.e() * 0.8f);
                    int d16 = (int) (aVar.d() * 0.8f);
                    if (e16 * d16 <= 0) {
                        return;
                    }
                    if (e16 <= rect.width() && d16 <= rect.height()) {
                        if (!z16) {
                            f17 = (this.f259950e.nextFloat() * 0.45f) + 0.5f;
                        }
                        int d17 = (int) (aVar.d() * f17);
                        this.f259952h.add(new a(g16, f17, rect.left, rect.top));
                        int e17 = rect.left + ((int) (aVar.e() * f17));
                        int i16 = rect.top;
                        Rect rect2 = new Rect(e17, i16, rect.right, i16 + d17);
                        Rect rect3 = new Rect(rect.left, rect.top + d17, rect.right, rect.bottom);
                        e(rect2);
                        e(rect3);
                        return;
                    }
                    float width = rect.width() / aVar.e();
                    float height2 = rect.height() / aVar.d();
                    if (width < height2) {
                        z17 = true;
                    }
                    if (!z17) {
                        width = height2;
                    }
                    int e18 = (int) ((aVar.e() * width) + 0.5f);
                    int d18 = (int) ((aVar.d() * width) + 0.5f);
                    int max = Math.max(rect.width() / e18, rect.height() / d16);
                    if (max > 30) {
                        QLog.i("TagCloudView", 1, "fillWithTags WARNING!!! " + max + " w:" + rect.width() + " h:" + rect.height() + " tagW:" + aVar.e() + " tagH:" + aVar.e() + " small:" + z16);
                        if (z16) {
                            return;
                        }
                    }
                    Rect rect4 = new Rect();
                    if (z17) {
                        rect4.set(rect.left, rect.top + d18, rect.right, rect.bottom);
                        e(rect4);
                    } else {
                        rect4.set(rect.left + e18, rect.top, rect.right, rect.bottom);
                        e(rect4);
                    }
                    this.f259952h.add(new a(g16, width, rect.left, rect.top));
                }
            }
        }
    }

    private static List<Rect> f(List<Point> list, List<Rect> list2, int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "findAllEmptyRect");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Point point = list.get(size);
            Rect n3 = n(point, list2, i3, i16, i17);
            if (n3 != null) {
                arrayList.add(n3);
                list2.add(n3);
                Point point2 = new Point(n3.left + n3.width(), n3.top);
                Point point3 = new Point(n3.left, n3.top + n3.height());
                Point point4 = new Point(n3.left + n3.width(), n3.top + n3.height());
                arrayList2.add(point2);
                arrayList2.add(point3);
                arrayList2.add(point4);
            }
            Rect o16 = o(point, list2, i3, i16, i17);
            if (o16 != null) {
                arrayList.add(o16);
                list2.add(o16);
                Point point5 = new Point(o16.left, o16.top);
                Point point6 = new Point(o16.left + o16.width(), o16.top);
                Point point7 = new Point(o16.left + o16.width(), o16.top + o16.height());
                arrayList2.add(point5);
                arrayList2.add(point6);
                arrayList2.add(point7);
            }
            list.remove(size);
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            Point point8 = (Point) arrayList2.get(size2);
            Rect n16 = n(point8, list2, i3, i16, i17);
            if (n16 != null) {
                arrayList.add(n16);
                list2.add(n16);
            }
            Rect o17 = o(point8, list2, i3, i16, i17);
            if (o17 != null) {
                arrayList.add(o17);
                list2.add(o17);
            }
            arrayList2.remove(size2);
        }
        return arrayList;
    }

    private int g(Rect rect) {
        int i3;
        int i16 = 3;
        int[] iArr = {-1, -1, -1};
        int[] iArr2 = {-1, -1, -1};
        int i17 = -1;
        int i18 = 0;
        for (int i19 = 0; i19 < this.f259951f.size(); i19++) {
            com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = this.f259951f.get(i19);
            int e16 = (int) (aVar.e() * 0.8f);
            int d16 = (int) (aVar.d() * 0.8f);
            if (e16 * d16 > 0) {
                if (e16 <= rect.width() && d16 <= rect.height()) {
                    i3 = (int) (aVar.f259977i * 0.8f);
                } else {
                    float width = rect.width() / aVar.e();
                    float height = rect.height() / aVar.d();
                    if (width >= height) {
                        width = height;
                    }
                    i3 = (int) (width * aVar.f259977i);
                }
                if (i3 > i17) {
                    iArr2[i18] = i3;
                    iArr[i18] = i19;
                    i18 = h(iArr2, true);
                    i17 = iArr2[i18];
                }
            }
        }
        int[] iArr3 = {-1, -1, -1};
        if (iArr[2] < 0) {
            if (iArr[1] >= 0) {
                i16 = 2;
            } else if (iArr[0] >= 0) {
                i16 = 1;
            } else {
                i16 = 0;
            }
        }
        if (i16 == 0) {
            return -1;
        }
        int i26 = 0;
        for (int i27 = 0; i27 < i16; i27++) {
            if (iArr2[i27] >= this.G * 12.0f) {
                iArr3[i26] = iArr[i27];
                i26++;
            }
        }
        if (i26 > 0) {
            return iArr3[this.f259950e.nextInt(i26)];
        }
        return iArr[h(iArr2, false)];
    }

    private int h(int[] iArr, boolean z16) {
        int i3 = iArr[0];
        int i16 = 0;
        for (int i17 = 0; i17 < iArr.length; i17++) {
            boolean z17 = true;
            if (!z16 ? iArr[i17] <= i3 : iArr[i17] >= i3) {
                z17 = false;
            }
            if (z17) {
                i3 = iArr[i17];
                i16 = i17;
            }
        }
        return i16;
    }

    private Rect i(List<Rect> list, int i3, int i16) {
        if (list == null) {
            return null;
        }
        Rect rect = list.get(0);
        float f16 = -1.0f;
        for (int i17 = 0; i17 < list.size(); i17++) {
            Rect rect2 = list.get(i17);
            float pow = (float) Math.pow(Math.pow(rect2.exactCenterX() - (i3 * 0.5f), 2.0d) + Math.pow(rect2.centerY() - (i16 * 0.5f), 2.0d), 0.5d);
            if (f16 < 0.0f) {
                f16 = pow;
            }
            if (pow > f16) {
                rect = rect2;
                f16 = pow;
            }
        }
        return rect;
    }

    private static List<Point> j(List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list, int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Point(0, 0));
        arrayList.add(new Point(i3, 0));
        arrayList.add(new Point(0, i16));
        arrayList.add(new Point(i3, i16));
        if (list == null) {
            return arrayList;
        }
        for (int i17 = 0; i17 < list.size(); i17++) {
            com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = list.get(i17);
            if (aVar.n() || !aVar.f259982n) {
                Point point = aVar.f259975g;
                Point point2 = new Point(point.x, point.y);
                Point point3 = aVar.f259975g;
                Point point4 = new Point(point3.x + aVar.f259976h.x, point3.y);
                Point point5 = aVar.f259975g;
                Point point6 = new Point(point5.x, point5.y + aVar.f259976h.y);
                Point point7 = aVar.f259975g;
                int i18 = point7.x;
                Point point8 = aVar.f259976h;
                Point point9 = new Point(i18 + point8.x, point7.y + point8.y);
                if (!r(arrayList, point2)) {
                    arrayList.add(point2);
                }
                if (!r(arrayList, point4)) {
                    arrayList.add(point4);
                }
                if (!r(arrayList, point6)) {
                    arrayList.add(point6);
                }
                if (!r(arrayList, point9)) {
                    arrayList.add(point9);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(Point point, Point point2) {
        return (int) (Math.pow(Math.abs(point.x - point2.x), 2.0d) + Math.pow(Math.abs(point.y - point2.y), 2.0d));
    }

    private static List<Rect> m(com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar, List<Point> list, List<Rect> list2, int i3, int i16) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i17 = 0; i17 < list.size(); i17++) {
            int i18 = list.get(i17).x;
            int i19 = list.get(i17).y;
            Point point = aVar.f259976h;
            Rect rect = new Rect(i18, i19, point.x + i18, point.y + i19);
            if (s(rect, list2, i3, i16)) {
                arrayList.add(rect);
            }
            Point point2 = aVar.f259976h;
            Rect rect2 = new Rect(i18 - point2.x, i19 - point2.y, i18, i19);
            if (s(rect2, list2, i3, i16)) {
                arrayList.add(rect2);
            }
            Point point3 = aVar.f259976h;
            Rect rect3 = new Rect(i18, i19 - point3.y, point3.x + i18, i19);
            if (s(rect3, list2, i3, i16)) {
                arrayList.add(rect3);
            }
            Point point4 = aVar.f259976h;
            Rect rect4 = new Rect(i18 - point4.x, i19, i18, point4.y + i19);
            if (s(rect4, list2, i3, i16)) {
                arrayList.add(rect4);
            }
        }
        return arrayList;
    }

    private static Rect n(Point point, List<Rect> list, int i3, int i16, int i17) {
        int i18 = point.x;
        int i19 = point.y;
        Rect rect = new Rect(i18, i19, i18 + i17, i19 + i17);
        if (rect.bottom > i16 || rect.right > i3 || rect.left < 0 || rect.top < 0 || q(list, rect, null)) {
            return null;
        }
        int i26 = i3 - point.x;
        rect.right = rect.left + i26;
        if (!(!q(list, rect, null))) {
            int i27 = i17;
            while (Math.abs(i27 - i26) > 2) {
                int i28 = (int) ((i26 + i27) * 0.5f);
                rect.right = rect.left + i28;
                if (!q(list, rect, null)) {
                    i27 = i28;
                } else {
                    i26 = i28;
                }
            }
            rect.right = i27 + rect.left;
        }
        int i29 = i16 - point.y;
        rect.bottom = rect.top + i29;
        if (!(!q(list, rect, null))) {
            while (Math.abs(i17 - i29) > 2) {
                int i36 = (int) ((i29 + i17) * 0.5f);
                rect.bottom = rect.top + i36;
                if (!q(list, rect, null)) {
                    i17 = i36;
                } else {
                    i29 = i36;
                }
            }
            rect.bottom = i17 + rect.top;
        }
        return rect;
    }

    private static Rect o(Point point, List<Rect> list, int i3, int i16, int i17) {
        int i18 = point.x;
        int i19 = point.y;
        Rect rect = new Rect(i18, i19 - i17, i18 + i17, i19);
        if (rect.bottom > i16 || rect.right > i3 || rect.left < 0 || rect.top < 0 || q(list, rect, null)) {
            return null;
        }
        int i26 = i3 - point.x;
        rect.right = rect.left + i26;
        if (!(!q(list, rect, null))) {
            int i27 = i17;
            while (Math.abs(i27 - i26) > 2) {
                int i28 = (int) ((i26 + i27) * 0.5f);
                rect.right = rect.left + i28;
                if (!q(list, rect, null)) {
                    i27 = i28;
                } else {
                    i26 = i28;
                }
            }
            rect.right = i27 + rect.left;
        }
        int i29 = point.y;
        rect.top = rect.bottom - i29;
        if (!(!q(list, rect, null))) {
            while (Math.abs(i17 - i29) > 2) {
                int i36 = (int) ((i29 + i17) * 0.5f);
                rect.top = rect.bottom - i36;
                if (!q(list, rect, null)) {
                    i17 = i36;
                } else {
                    i29 = i36;
                }
            }
            rect.top = rect.bottom - i17;
        }
        return rect;
    }

    private void p() {
        float f16 = getResources().getDisplayMetrics().density;
        this.G = f16;
        com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a.g((int) (f16 * 4.0f));
        this.D = new ColorDrawable(-16777216);
    }

    private static boolean q(List<Rect> list, Rect rect, Rect rect2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!list.get(i3).equals(rect2) && Rect.intersects(list.get(i3), rect)) {
                return true;
            }
        }
        return false;
    }

    private static boolean r(List<Point> list, Point point) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (point.equals(list.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private static boolean s(Rect rect, List<Rect> list, int i3, int i16) {
        int i17;
        int i18;
        if (rect.left < 0 || rect.top < 0 || (i17 = rect.right) < 0 || (i18 = rect.bottom) < 0 || i17 > i3 || i18 > i16) {
            return false;
        }
        for (int i19 = 0; i19 < list.size(); i19++) {
            if (Rect.intersects(rect, list.get(i19))) {
                return false;
            }
        }
        return true;
    }

    private int t(int i3, int i16) {
        List<Rect> m3;
        int i17 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "layoutChildren start w:" + i3 + " h:" + i16);
        }
        ArrayList arrayList = new ArrayList(this.f259951f.size());
        List<Point> j3 = j(null, i3, i16);
        ArrayList arrayList2 = new ArrayList(this.f259951f.size());
        arrayList2.addAll(this.f259951f);
        for (int i18 = 0; i18 < arrayList2.size(); i18++) {
            com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = (com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a) arrayList2.get(i18);
            if (!aVar.f259982n) {
                Point point = aVar.f259976h;
                if (point.x * point.y != 0) {
                    while (true) {
                        m3 = m(aVar, j3, arrayList, i3, i16);
                        if (m3 != null && m3.size() > 0) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("TagCloudView", 2, "layoutChildren enlarge");
                        }
                        i16 = d(arrayList, i3, i16, (int) (aVar.f259976h.y * 0.3f));
                        for (int i19 = 0; i19 < arrayList.size(); i19++) {
                            ((com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a) arrayList2.get(i19)).f259975g.x = arrayList.get(i19).left;
                            ((com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a) arrayList2.get(i19)).f259975g.y = arrayList.get(i19).top;
                        }
                        j3 = j(arrayList2, i3, i16);
                    }
                    if (m3.size() > 0) {
                        Rect i26 = i(m3, i3, i16);
                        Point point2 = aVar.f259975g;
                        point2.x = i26.left;
                        point2.y = i26.top;
                        arrayList.add(i26);
                        b(j3, aVar, i3, i16);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("TagCloudView", 4, "layoutChildren findTheFarest:" + i26);
                        }
                    }
                }
            }
            arrayList.add(new Rect());
        }
        Point point3 = new Point((int) (i3 * 0.5f), (int) (i16 * 0.5f));
        Collections.sort(this.f259951f, new e(point3));
        Collections.sort(arrayList, new c(point3));
        int size = this.f259951f.size();
        if (this.f259951f.size() < 6) {
            if (this.f259951f.size() >= 4) {
                i17 = 3;
            } else {
                i17 = size;
            }
        }
        w(arrayList, point3, i17);
        List<Rect> f16 = f(j(arrayList2, i3, i16), arrayList, i3, i16, this.C);
        for (int i27 = 0; i27 < f16.size(); i27++) {
            Rect rect = f16.get(i27);
            try {
                e(rect);
            } catch (StackOverflowError e16) {
                try {
                    QLog.i("TagCloudView", 1, "get StackOverflowError " + e16.getMessage() + " rect:" + rect + " tags:" + this.f259951f.toString(), e16);
                } catch (Exception unused) {
                }
            }
        }
        return i16;
    }

    private int u(int i3, int i16, List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list, int i17) {
        for (int i18 = 0; i18 < list.size(); i18++) {
            com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = list.get(i18);
            int i19 = aVar.i(i3);
            while (i19 > i17 * 1.0f && !aVar.f259982n) {
                aVar.m();
                float f16 = aVar.f259977i * 0.75f;
                aVar.f259977i = f16;
                aVar.f259981m.setTextSize(f16);
                i19 = aVar.i(i3);
            }
            if (!aVar.f259982n) {
                i16 = Math.max(i16, i19);
            }
        }
        return i16;
    }

    public static void v(List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).m();
        }
    }

    private void w(List<Rect> list, Point point, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < this.f259951f.size() && i16 < i3; i17++) {
            com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = this.f259951f.get(i17);
            if (!aVar.f259982n) {
                float f16 = point.x;
                float f17 = aVar.f259975g.x;
                Point point2 = aVar.f259976h;
                int i18 = (int) (f16 - (f17 + (point2.x * 0.5f)));
                int i19 = (int) (point.y - (r9.y + (point2.y * 0.5f)));
                Rect rect = list.get(i17);
                Rect rect2 = new Rect(rect);
                rect2.offset(i18, 0);
                if (q(list, rect2, rect)) {
                    int i26 = 0;
                    while (Math.abs(i18 - i26) > 1) {
                        int i27 = (int) ((i18 + i26) * 0.5f);
                        rect2.set(rect);
                        rect2.offset(i27, 0);
                        if (!q(list, rect2, rect)) {
                            i26 = i27;
                        } else {
                            i18 = i27;
                        }
                    }
                    i18 = i26;
                }
                if (Math.abs(i18) < Math.abs(this.C)) {
                    i18 = 0;
                }
                Rect rect3 = new Rect(rect);
                rect3.offset(i18, i19);
                if (q(list, rect3, rect)) {
                    int i28 = 0;
                    while (Math.abs(i19 - i28) > 1) {
                        int i29 = (int) ((i19 + i28) * 0.5f);
                        rect3.set(rect);
                        rect3.offset(i18, i29);
                        if (!q(list, rect3, rect)) {
                            i28 = i29;
                        } else {
                            i19 = i29;
                        }
                    }
                    i19 = i28;
                }
                if (Math.abs(i19) < Math.abs(this.C)) {
                    i19 = 0;
                }
                if (i18 > 0 || i19 > 0) {
                    i16++;
                    rect.offset(i18, i19);
                    Point point3 = aVar.f259975g;
                    point3.x = rect.left;
                    point3.y = rect.top;
                }
            }
        }
    }

    private void x() {
        int colorForState = this.F.getColorForState(getDrawableState(), 0);
        if (colorForState != this.E) {
            this.E = colorForState;
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.drawableStateChanged();
        ColorStateList colorStateList = this.F;
        if (colorStateList != null && colorStateList.isStateful()) {
            x();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else if (drawable == this.D) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.E;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        ArrayList arrayList;
        int i3;
        int i16;
        Rect rect;
        b bVar;
        Bitmap bitmap;
        boolean z16;
        int i17;
        boolean z17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) canvas);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("TagCloudView", 4, "onDraw");
        }
        int i19 = 0;
        if (this.L != null) {
            Bitmap bitmap2 = this.K;
            if (bitmap2 != null && (!this.J || (bitmap2.getWidth() == getMeasuredWidth() && this.K.getHeight() == getMeasuredHeight()))) {
                canvas2 = new Canvas(this.K);
                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            } else {
                Bitmap bitmap3 = this.K;
                if (bitmap3 != null) {
                    bitmap3.recycle();
                    this.K = null;
                }
                try {
                    this.K = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TagCloudView", 2, e16.getMessage());
                    }
                }
                if (this.K != null) {
                    canvas2 = new Canvas(this.K);
                }
            }
            Point point = new Point(0, 0);
            int paddingLeft = getPaddingLeft();
            arrayList = new ArrayList();
            arrayList.addAll(this.f259951f);
            i3 = 0;
            while (i3 < arrayList.size()) {
                com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = (com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a) arrayList.get(i3);
                if (!aVar.f259982n && aVar.n()) {
                    TextPaint textPaint = aVar.f259981m;
                    Point point2 = aVar.f259975g;
                    Point point3 = aVar.f259976h;
                    if (aVar.f259979k != 0) {
                        canvas2.save();
                        int i26 = point2.x;
                        int i27 = point2.y;
                        canvas2.clipRect(i26 + paddingLeft, i27, i26 + point3.x + paddingLeft, point3.y + i27);
                        canvas2.translate(point2.x + paddingLeft, point2.y);
                        float f16 = aVar.f259985q;
                        canvas2.scale(f16, f16);
                        canvas2.drawColor(aVar.f259979k);
                        canvas2.restore();
                    }
                    point.set(i19, i19);
                    int i28 = com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a.f259967u;
                    int i29 = aVar.f259987s;
                    if (i29 == 2) {
                        canvas2.save();
                        if (aVar.f259970b) {
                            boolean z18 = aVar.f259969a;
                            i18 = point3.y - (i28 * 2);
                            if (z18) {
                                point.set(i18 + i28 + i28, i28);
                                canvas2.translate(point2.x + i28 + paddingLeft, point2.y + i28);
                            } else {
                                point.set(i28, i28);
                                canvas2.translate((((point2.x + point3.x) - i18) - i28) + paddingLeft, point2.y + i28);
                            }
                        } else {
                            i18 = point3.x - (i28 * 2);
                            if (aVar.f259969a) {
                                point.set(i28, i18 + i28 + i28);
                                canvas2.translate(point2.x + i28 + paddingLeft, point2.y + i28);
                            } else {
                                point.set(i28, i28);
                                canvas2.translate(point2.x + i28 + paddingLeft, ((point2.y + point3.y) - i18) - i28);
                            }
                        }
                        if (this.D != null) {
                            c(canvas2, i18);
                        }
                        canvas2.restore();
                        z16 = true;
                    } else {
                        z16 = true;
                        if (i29 == 1) {
                            point.set(i28, i28);
                        }
                    }
                    if (aVar.f259987s != 0 && !aVar.f259982n) {
                        textPaint.setColor(-1);
                        textPaint.setAlpha(255);
                        z17 = z16;
                    } else {
                        textPaint.setColor(this.E);
                        if (aVar.f259982n) {
                            i17 = 64;
                        } else {
                            i17 = 255;
                        }
                        textPaint.setAlpha(i17);
                        z17 = false;
                    }
                    textPaint.setFakeBoldText(aVar.f259983o);
                    canvas2.save();
                    canvas2.translate(point.x + point2.x + paddingLeft, (point.y + point2.y) - ((aVar.f259985q * aVar.f259986r) + 0.5f));
                    if (aVar.f259970b) {
                        float f17 = aVar.f259985q;
                        canvas2.scale(f17, f17);
                        aVar.f259972d.draw(canvas2);
                    } else {
                        float f18 = aVar.f259985q;
                        canvas2.scale(f18, f18);
                        for (int i36 = 0; i36 < aVar.f259974f.size(); i36++) {
                            aVar.f259974f.get(i36).draw(canvas2);
                            canvas2.translate(r5.getWidth(), 0.0f);
                        }
                    }
                    canvas2.restore();
                    if (z17 && ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                        canvas2.save();
                        int i37 = point2.x;
                        int i38 = point2.y;
                        canvas2.clipRect(i37 + paddingLeft, i38, i37 + point3.x + paddingLeft, point3.y + i38);
                        canvas2.translate(point2.x + paddingLeft, point2.y);
                        float f19 = aVar.f259985q;
                        canvas2.scale(f19, f19);
                        canvas2.drawColor(Color.argb(127, 0, 0, 0));
                        canvas2.restore();
                    }
                }
                i3++;
                i19 = 0;
            }
            for (i16 = 0; i16 < this.f259952h.size(); i16++) {
                a aVar2 = this.f259952h.get(i16);
                com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar3 = this.f259951f.get(aVar2.f259955a);
                TextPaint textPaint2 = aVar3.f259981m;
                textPaint2.setColor(this.E);
                textPaint2.setAlpha(64);
                textPaint2.setFakeBoldText(false);
                Point point4 = new Point(aVar2.f259957c, aVar2.f259958d);
                canvas2.save();
                canvas2.translate(point4.x + paddingLeft, point4.y - (aVar3.f259986r * aVar2.f259956b));
                float f26 = aVar2.f259956b;
                canvas2.scale(f26, f26);
                if (aVar3.f259970b) {
                    aVar3.f259972d.draw(canvas2);
                } else {
                    for (int i39 = 0; i39 < aVar3.f259974f.size(); i39++) {
                        aVar3.f259974f.get(i39).draw(canvas2);
                        canvas2.translate(r7.getWidth(), 0.0f);
                    }
                }
                canvas2.restore();
            }
            rect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
            if (this.L != null && (bitmap = this.K) != null) {
                canvas.drawBitmap(bitmap, rect, rect, this.M);
            }
            if (this.J && (bVar = this.L) != null) {
                bVar.n0(this.K);
            }
            this.J = false;
        }
        canvas2 = canvas;
        Point point5 = new Point(0, 0);
        int paddingLeft2 = getPaddingLeft();
        arrayList = new ArrayList();
        arrayList.addAll(this.f259951f);
        i3 = 0;
        while (i3 < arrayList.size()) {
        }
        while (i16 < this.f259952h.size()) {
        }
        rect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.L != null) {
            canvas.drawBitmap(bitmap, rect, rect, this.M);
        }
        if (this.J) {
            bVar.n0(this.K);
        }
        this.J = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            size = Integer.MAX_VALUE;
        }
        int paddingLeft = size - (getPaddingLeft() + getPaddingRight());
        if (this.f259953i == i3) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        this.f259953i = i3;
        this.J = true;
        v(this.f259951f);
        this.f259952h.clear();
        int u16 = u(View.MeasureSpec.makeMeasureSpec(paddingLeft, mode), 0, this.f259951f, this.f259954m);
        int i17 = this.f259954m;
        if (u16 < i17) {
            u16 = i17;
        }
        Collections.sort(this.f259951f, new d(this.f259950e, (int) (paddingLeft * 0.7f), (int) (i17 * 0.7f)));
        int t16 = t(paddingLeft, u16);
        if (mode2 != 1073741824 && mode2 == Integer.MIN_VALUE && size2 > 0) {
            t16 = Math.min(size2, t16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "onMeasure, setDimension w:" + paddingLeft + " h:" + t16);
        }
        setMeasuredDimension(paddingLeft + getPaddingRight() + getPaddingRight(), t16);
    }

    public void setMaxEms(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f259949d = i3;
        }
    }

    public void setMinHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f259954m = i3;
        }
    }

    public void setOnUpdateDrawingListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        if (bVar != this.L) {
            this.L = bVar;
            if (bVar == null) {
                this.J = false;
                Bitmap bitmap = this.K;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.K = null;
                }
            } else {
                this.J = true;
            }
            invalidate();
        }
    }

    public void setTagIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = this.D;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.D);
            }
            this.D = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
            invalidate();
        }
    }

    public void setTags(List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        this.f259953i = N;
        this.f259951f.clear();
        this.f259952h.clear();
        this.f259951f.addAll(list);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.F = ColorStateList.valueOf(i3);
            x();
        }
    }

    public void setThreshold(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.C = i3;
        }
    }

    @Override // com.tencent.theme.ISkinSetTypeface
    public void setTypeface(Typeface typeface) {
        TextPaint textPaint;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) typeface);
            return;
        }
        List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list = this.f259951f;
        if (list != null) {
            for (com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar : list) {
                if (aVar != null && (textPaint = aVar.f259981m) != null) {
                    textPaint.setTypeface(typeface);
                }
            }
            invalidate();
        }
    }

    public TagCloudView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TagCloudView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f259950e = new Random();
        this.f259951f = new ArrayList();
        this.f259952h = new ArrayList();
        this.f259953i = N;
        this.f259954m = 0;
        this.C = 42;
        this.E = -16777216;
        this.H = new Matrix();
        this.J = false;
        this.M = new Paint(7);
        p();
    }

    public void setTextColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) colorStateList);
            return;
        }
        colorStateList.getClass();
        this.F = colorStateList;
        x();
    }
}
