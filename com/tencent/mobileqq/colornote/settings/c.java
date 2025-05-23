package com.tencent.mobileqq.colornote.settings;

import android.R;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f201548a = {17039360, R.dimen.app_icon_size, R.id.empty};

    /* renamed from: b, reason: collision with root package name */
    private static final List<h> f201549b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends com.tencent.mobileqq.colornote.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ColorNoteCurd f201550a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ColorNote f201551b;

        a(ColorNoteCurd colorNoteCurd, ColorNote colorNote) {
            this.f201550a = colorNoteCurd;
            this.f201551b = colorNote;
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onDeleteColorNote(int i3, String str, boolean z16) {
            this.f201550a.a(this.f201551b.parseBundle());
        }
    }

    static {
        try {
            Iterator<Class<? extends h>> it = b.f201547a.iterator();
            while (it.hasNext()) {
                f201549b.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteHistoryManager", 1, "[static] ", e16);
        }
    }

    public static void a(ColorNote colorNote) {
        if (colorNote != null && !TextUtils.isEmpty(colorNote.getMainTitle())) {
            ColorNote e16 = com.tencent.mobileqq.colornote.data.a.e(colorNote);
            e16.setType(2);
            ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
            colorNoteCurd.f(e16.getServiceType(), e16.getSubType(), 2);
            colorNoteCurd.l(new a(colorNoteCurd, e16));
            c(MobileQQ.getMobileQQ().waitAppRuntime(null), e16.getServiceType());
        }
    }

    public static List<ColorNote> b(List<ColorNote> list) {
        if (list != null && list.size() > 3) {
            return list.subList(0, 3);
        }
        return list;
    }

    public static boolean c(AppRuntime appRuntime, int i3) {
        if (MobileQQ.sProcessId == 1) {
            List<ColorNote> g16 = g(appRuntime, i3);
            if (g16 != null && g16.size() > 20) {
                h(g16);
            }
        } else {
            ((IColorNoteHelper) appRuntime.getRuntimeService(IColorNoteHelper.class, "all")).clearHistoryNote(i3);
        }
        return true;
    }

    public static List<ColorNote> d(AppRuntime appRuntime, int i3) {
        return ((IColorNoteDataService) appRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getColorNotes(false, i3);
    }

    public static List<ColorNote> e(AppRuntime appRuntime, int i3) {
        List<ColorNote> g16 = g(appRuntime, i3);
        List<ColorNote> d16 = d(appRuntime, 0);
        if (g16 == null) {
            return null;
        }
        if (d16 != null && d16.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (ColorNote colorNote : g16) {
                Iterator<ColorNote> it = d16.iterator();
                while (it.hasNext()) {
                    if (com.tencent.mobileqq.colornote.data.a.f(colorNote, it.next())) {
                        arrayList.add(colorNote);
                    }
                }
            }
            g16.removeAll(arrayList);
        }
        return g16;
    }

    public static List<h> f() {
        return f201549b;
    }

    public static List<ColorNote> g(AppRuntime appRuntime, int i3) {
        return i(d(appRuntime, 2), i3);
    }

    private static void h(List<ColorNote> list) {
        if (list != null && list.size() >= 20) {
            ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
            for (int i3 = 9; i3 < list.size(); i3++) {
                ColorNote colorNote = list.get(i3);
                colorNoteCurd.f(colorNote.getServiceType(), colorNote.getSubType(), 2);
            }
        }
    }

    static List<ColorNote> i(List<ColorNote> list, int i3) {
        ArrayList arrayList = new ArrayList();
        for (ColorNote colorNote : list) {
            if (colorNote.getServiceType() == i3) {
                arrayList.add(0, colorNote);
            }
        }
        return arrayList;
    }
}
