package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontService;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private int f50724c;

    /* renamed from: d, reason: collision with root package name */
    private int f50725d;

    /* renamed from: e, reason: collision with root package name */
    private int f50726e;

    /* renamed from: f, reason: collision with root package name */
    private int f50727f;

    /* renamed from: g, reason: collision with root package name */
    private String f50728g;

    /* renamed from: h, reason: collision with root package name */
    private Point f50729h;

    /* renamed from: i, reason: collision with root package name */
    private int f50730i;

    /* renamed from: j, reason: collision with root package name */
    private int f50731j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f50732k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f50733l;

    /* renamed from: m, reason: collision with root package name */
    private IETFont f50734m;

    /* renamed from: n, reason: collision with root package name */
    private Point[] f50735n;

    /* renamed from: o, reason: collision with root package name */
    private Object[] f50736o;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<TextCellLayout.g> f50738q;

    /* renamed from: a, reason: collision with root package name */
    private Rect f50722a = new Rect(1000, 1000, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    private Rect f50723b = new Rect(1000, 1000, 0, 0);

    /* renamed from: p, reason: collision with root package name */
    private int f50737p = 0;

    private static int l(char c16, char c17) {
        return ((c16 << '\n') + c17) - 56613888;
    }

    private void m(Rect rect, Rect rect2) {
        int i3 = rect2.left;
        if (i3 < rect.left) {
            rect.left = i3;
        }
        int i16 = rect2.top;
        if (i16 < rect.top) {
            rect.top = i16;
        }
        int i17 = rect2.right;
        if (i17 > rect.right) {
            rect.right = i17;
        }
        int i18 = rect2.bottom;
        if (i18 > rect.bottom) {
            rect.bottom = i18;
        }
    }

    public IETFont e() {
        return this.f50734m;
    }

    public int f() {
        return this.f50725d;
    }

    public int g() {
        return this.f50724c;
    }

    public int h() {
        return this.f50726e;
    }

    public int i() {
        return this.f50727f;
    }

    public Rect j() {
        return this.f50722a;
    }

    public boolean k(ArrayList<TextCellLayout.g> arrayList, int i3, int i16, int i17, int i18, boolean z16, boolean z17, IETFont iETFont) {
        int height;
        IETFont iETFont2;
        ArrayList<TextCellLayout.g> arrayList2 = this.f50738q;
        if (arrayList2 != null && d(arrayList2).equals(d(arrayList)) && (iETFont2 = this.f50734m) != null && iETFont2.equals(iETFont) && i18 == this.f50731j && i17 == this.f50730i && z16 == this.f50732k) {
            return false;
        }
        this.f50726e = 0;
        this.f50727f = 0;
        this.f50734m = iETFont;
        this.f50724c = i3;
        this.f50725d = i16;
        this.f50731j = i18;
        this.f50732k = z16;
        this.f50733l = z17;
        this.f50730i = i17;
        StringBuilder sb5 = new StringBuilder();
        this.f50738q = new ArrayList<>();
        if (z17) {
            Iterator<TextCellLayout.g> it = arrayList.iterator();
            while (it.hasNext()) {
                TextCellLayout.g next = it.next();
                TextCellLayout.g gVar = new TextCellLayout.g();
                int h16 = next.h();
                if (h16 != 0) {
                    for (int i19 = 0; i19 < h16; i19++) {
                        TextCell d16 = next.d(i19);
                        Rect g16 = next.g(i19);
                        gVar.c(d16, g16);
                        m(this.f50722a, g16);
                        if (!(d16 instanceof EmoCell) && !(d16 instanceof SystemEmoCell)) {
                            sb5.append(d16.getText());
                        }
                    }
                    this.f50738q.add(gVar);
                }
            }
        } else {
            Iterator<TextCellLayout.g> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                TextCellLayout.g next2 = it5.next();
                TextCellLayout.g gVar2 = new TextCellLayout.g();
                int h17 = next2.h();
                if (h17 != 0) {
                    for (int i26 = 0; i26 < h17; i26++) {
                        TextCell d17 = next2.d(i26);
                        Rect g17 = next2.g(i26);
                        int i27 = d17.type;
                        if ((i27 == 3 || i27 == 9) && d17.useDefaultFont) {
                            m(this.f50723b, g17);
                        } else {
                            m(this.f50722a, g17);
                            if (!(d17 instanceof EmoCell) && !(d17 instanceof SystemEmoCell)) {
                                sb5.append(d17.getText());
                            }
                        }
                        gVar2.c(d17, g17);
                    }
                    this.f50738q.add(gVar2);
                }
            }
            if (this.f50738q.size() == 1) {
                this.f50726e = this.f50723b.right;
                this.f50724c = this.f50722a.width();
                if (this.f50725d > this.f50722a.height()) {
                    height = this.f50725d;
                } else {
                    height = this.f50722a.height();
                }
                this.f50725d = height;
                this.f50730i = this.f50724c;
            }
        }
        this.f50728g = sb5.toString();
        this.f50729h = new Point(this.f50726e, this.f50727f);
        return true;
    }

    private IETSegment[] b(ArrayList<TextCellLayout.g> arrayList) {
        TextCellLayout.g gVar;
        int i3;
        ArrayList arrayList2;
        Rect rect;
        int width;
        float width2;
        IETFont iETFont;
        int i16;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        this.f50737p = arrayList.size();
        Iterator<TextCellLayout.g> it = arrayList.iterator();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (it.hasNext()) {
            TextCellLayout.g next = it.next();
            int h16 = next.h();
            if (h16 != 0) {
                Rect rect2 = new Rect(1000, 1000, i17, i17);
                int i28 = i17;
                int i29 = i28;
                while (i28 < h16) {
                    TextCell d16 = next.d(i28);
                    Rect g16 = next.g(i28);
                    Iterator<TextCellLayout.g> it5 = it;
                    if (d16 instanceof ComboNetImageCell) {
                        arrayList2 = arrayList3;
                        gVar = next;
                        i3 = h16;
                        rect = rect2;
                    } else {
                        gVar = next;
                        boolean z16 = this.f50733l || !(((i16 = d16.type) == 3 || i16 == 9) && d16.useDefaultFont);
                        int i36 = g16.top - i18;
                        i3 = h16;
                        if (z16) {
                            m(rect2, g16);
                            IETSegment createETSegment = ((IETFontService) QRoute.api(IETFontService.class)).createETSegment();
                            arrayList2 = arrayList3;
                            createETSegment.setType(0);
                            rect = rect2;
                            createETSegment.setCodePoint(-1);
                            createETSegment.setTextOffset(0);
                            createETSegment.setTextLength(0);
                            createETSegment.setLineNum(0);
                            createETSegment.setTextSize(0);
                            createETSegment.setX(0);
                            createETSegment.setY(0);
                            if (d16 instanceof EmoCell) {
                                createETSegment.setType(2);
                                int i37 = i26 + 1;
                                createETSegment.setCodePoint(i26);
                                createETSegment.setY(i36 + i18);
                                EmoCell emoCell = (EmoCell) d16;
                                int width3 = (int) emoCell.getWidth(null);
                                arrayList4.add(((IETFontService) QRoute.api(IETFontService.class)).createETImageSpan(emoCell.getEmoDrawable()));
                                i26 = i37;
                                width = width3;
                            } else if (d16 instanceof SystemEmoCell) {
                                if (d16.getText().length() > 1) {
                                    createETSegment.setCodePoint(l(d16.getText().charAt(0), d16.getText().charAt(1)));
                                } else {
                                    createETSegment.setCodePoint(d16.getText().charAt(0));
                                }
                                createETSegment.setType(1);
                                createETSegment.setY(i36 + i18);
                                width = (int) ((SystemEmoCell) d16).getWidth(null);
                            } else {
                                String text = d16.getText();
                                if (text != null) {
                                    createETSegment.setTextLength(text.length());
                                    createETSegment.setTextOffset(i27);
                                    createETSegment.setType(0);
                                    i27 += text.length();
                                    createETSegment.setY((i36 + i18) - 0);
                                    width = g16.width();
                                } else {
                                    width = 0;
                                }
                            }
                            createETSegment.setX(i29);
                            int i38 = (int) d16.fontSize;
                            if (d16.useSuperFont && (iETFont = this.f50734m) != null) {
                                i38 = iETFont.getSize();
                            }
                            createETSegment.setTextSize(i38);
                            createETSegment.setLineNum(i19);
                            arrayList5.add(createETSegment);
                        } else {
                            arrayList2 = arrayList3;
                            rect = rect2;
                            if (d16 instanceof EmoCell) {
                                width2 = ((EmoCell) d16).getWidth(null);
                            } else if (d16 instanceof SystemEmoCell) {
                                width2 = ((SystemEmoCell) d16).getWidth(null);
                            } else {
                                width = g16.width();
                            }
                            width = (int) width2;
                        }
                        i29 += width;
                    }
                    i28++;
                    it = it5;
                    next = gVar;
                    h16 = i3;
                    arrayList3 = arrayList2;
                    rect2 = rect;
                }
                ArrayList arrayList6 = arrayList3;
                Rect rect3 = rect2;
                Point point = new Point(0, 0);
                Point point2 = new Point(0, 0);
                point.x = rect3.left;
                point.y = rect3.top;
                arrayList6.add(point);
                point2.x = rect3.right;
                point2.y = rect3.bottom;
                arrayList6.add(point2);
                i18 += rect3.height();
                i19++;
                i17 = 0;
                arrayList3 = arrayList6;
                it = it;
            }
        }
        ArrayList arrayList7 = arrayList3;
        this.f50736o = arrayList4.toArray();
        this.f50735n = (Point[]) arrayList7.toArray(new Point[arrayList7.size()]);
        return (IETSegment[]) arrayList5.toArray(new IETSegment[arrayList5.size()]);
    }

    public IETDecoration a(IETEngine iETEngine, boolean z16) {
        return ((IETFontService) QRoute.api(IETFontService.class)).createDecorationSpace(iETEngine, this.f50728g, this.f50724c, this.f50725d, this.f50729h, this.f50730i, this.f50735n, this.f50737p, b(this.f50738q), this.f50736o, this.f50732k, this.f50731j, this.f50733l, this.f50734m, z16);
    }

    public String d(ArrayList<TextCellLayout.g> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                TextCellLayout.g gVar = arrayList.get(i3);
                int h16 = gVar.h();
                for (int i16 = 0; i16 < h16; i16++) {
                    sb5.append(gVar.d(i16).getText());
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public void c(IETEngine iETEngine, Bitmap bitmap, IETDecoration iETDecoration, boolean z16) {
        int i3;
        if (iETEngine == null || bitmap == null || this.f50724c <= 0 || this.f50725d <= 0 || iETDecoration == null) {
            return;
        }
        int i16 = 0;
        if (z16) {
            iETDecoration.drawSceneSpace(bitmap, 0, 0, this.f50734m);
            return;
        }
        Rect margins = iETDecoration.getMargins();
        if (margins != null) {
            int i17 = margins.left + 0;
            i3 = 0 + margins.top;
            i16 = i17;
        } else {
            i3 = 0;
        }
        iETDecoration.drawBackgroundSpace(bitmap, this.f50734m, i16, i3);
    }
}
