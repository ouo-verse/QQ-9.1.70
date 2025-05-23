package com.qzone.proxy.feedcomponent.text;

import android.text.TextUtils;
import com.qzone.util.am;
import com.qzone.widget.x;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class TextCellParser {
    public static final int DEFAULT_BOUND_VALUE = -1;
    public static final int DEFAULT_EMOJI_HEIGHT = ViewUtils.dip2px(17.0f);

    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f50687a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<TextCell> f50688b;

        public a(boolean z16, ArrayList<TextCell> arrayList) {
            this.f50687a = z16;
            this.f50688b = arrayList;
        }
    }

    public static ArrayList<TextCell> parseContent(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16) {
        return parseContent(textLayoutBase, charSequence, i3, z16, true, -1);
    }

    public static a parseContentEx(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16, boolean z17, int i16) {
        ArrayList<TextCell> e16;
        if (TextUtils.isEmpty(charSequence)) {
            return new a(false, new ArrayList());
        }
        int hashCode = charSequence.hashCode();
        if (z17 && (e16 = m.b().e(hashCode)) != null && !e16.isEmpty()) {
            return new a(true, e16);
        }
        new ArrayList();
        if (i16 == -1) {
            i16 = i3 - com.qzone.proxy.feedcomponent.util.g.a(1.5f);
        }
        ArrayList<TextCell> richCells = getRichCells(textLayoutBase, charSequence, i16, z16);
        if (z17) {
            m.b().g(hashCode, richCells);
        }
        return new a(false, richCells);
    }

    public static String toPlainText(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<TextCell> parseContent = parseContent(null, str, DEFAULT_EMOJI_HEIGHT, false);
        StringBuilder sb5 = new StringBuilder();
        Iterator<TextCell> it = parseContent.iterator();
        while (it.hasNext()) {
            String text = it.next().getText();
            if (text != null) {
                sb5.append(text);
            }
        }
        return sb5.toString();
    }

    private static ArrayList<TextCell> getRichCells(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16) {
        boolean z17;
        ArrayList<TextCell> arrayList = new ArrayList<>();
        ArrayList<TextCell> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList(5);
        arrayList3.add(new x8.a(x.f61173c));
        arrayList3.add(new x8.c(x.f61174d));
        arrayList3.add(new x8.f(textLayoutBase, am.f59788c));
        arrayList3.add(new x8.b(lp.c.f415328o));
        arrayList3.add(new x8.f(textLayoutBase, QzoneEmotionUtils.patternSpecialEmo));
        arrayList3.add(new x8.f(textLayoutBase, lp.c.f415332s));
        arrayList3.add(new x8.d(x.f61177g));
        arrayList3.add(new x8.a(x.f61176f));
        arrayList3.add(new x8.k(lp.c.f415331r));
        arrayList3.add(new x8.l(x.f61175e));
        arrayList3.add(new x8.h(textLayoutBase, x.f61179i));
        arrayList3.add(new x8.h(textLayoutBase, x.f61180j));
        arrayList3.add(new x8.g(lp.c.f415329p));
        arrayList3.add(new x8.i(textLayoutBase, lp.c.f415330q));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            ((x8.j) it.next()).e(charSequence.toString());
        }
        int length = charSequence.length();
        StringBuilder sb5 = new StringBuilder(length);
        ArrayList<TextCell> arrayList4 = arrayList2;
        int i16 = 0;
        while (i16 < length) {
            Iterator it5 = arrayList3.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z17 = false;
                    break;
                }
                x8.j jVar = (x8.j) it5.next();
                if (jVar.d(i16)) {
                    if (sb5.length() > 0) {
                        arrayList.add(new TextCell(0, sb5.toString()));
                        sb5.delete(0, sb5.length());
                    }
                    arrayList4.clear();
                    arrayList4 = jVar.c(i3, z16, textLayoutBase, charSequence, arrayList4);
                    if (arrayList4 != null) {
                        arrayList.addAll(arrayList4);
                    }
                    z17 = true;
                    i16 = jVar.b() - 1;
                }
            }
            if (!z17) {
                sb5.append(charSequence.charAt(i16));
            }
            i16++;
        }
        if (sb5.length() > 0) {
            arrayList.add(new TextCell(0, sb5.toString()));
        }
        return arrayList;
    }

    public static ArrayList<TextCell> parseContent(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16, boolean z17) {
        return parseContent(textLayoutBase, charSequence, i3, z16, z17, -1);
    }

    public static ArrayList<TextCell> parseContent(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16, boolean z17, int i16) {
        ArrayList<TextCell> e16;
        if (TextUtils.isEmpty(charSequence)) {
            return new ArrayList<>();
        }
        int hashCode = charSequence.hashCode() + (i3 * 100);
        if (z17 && (e16 = m.b().e(hashCode)) != null && !e16.isEmpty()) {
            return e16;
        }
        if (i16 == -1) {
            i16 = i3 - com.qzone.proxy.feedcomponent.util.g.a(1.5f);
        }
        ArrayList<TextCell> richCells = getRichCells(textLayoutBase, charSequence, i16, z16);
        if (z17) {
            m.b().g(hashCode, richCells);
        }
        return richCells;
    }
}
