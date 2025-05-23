package ga1;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private View f401615a;

    /* renamed from: b, reason: collision with root package name */
    private ColorNoteCurd f401616b;

    /* renamed from: c, reason: collision with root package name */
    private f f401617c;

    /* renamed from: d, reason: collision with root package name */
    private Context f401618d;

    public b(Context context) {
        this.f401618d = context;
        ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
        this.f401616b = colorNoteCurd;
        colorNoteCurd.l(new g());
    }

    private ColorNote c() {
        f fVar = this.f401617c;
        if (fVar != null) {
            return fVar.getColorNote();
        }
        return null;
    }

    public boolean a() {
        return this.f401616b.d();
    }

    public void b() {
        ColorNote colorNote;
        f fVar = this.f401617c;
        if (fVar != null && (colorNote = fVar.getColorNote()) != null) {
            this.f401616b.e(colorNote.getServiceType(), colorNote.getSubType());
            ReportController.o(null, "dc00898", "", "", "0X800A748", "0X800A748", com.tencent.mobileqq.colornote.a.b(colorNote.mServiceType), 0, "", "", "", "");
        }
    }

    public ColorNote d() {
        f fVar = this.f401617c;
        if (fVar != null) {
            return fVar.getColorNote();
        }
        return null;
    }

    public f e() {
        return this.f401617c;
    }

    public void f() {
        ColorNote c16 = c();
        if (c16 != null) {
            this.f401616b.a(c16.parseBundle());
            if (c16.getServiceType() != 16973824) {
                ReportController.o(null, "dc00898", "", "", "0X800A743", "0X800A743", com.tencent.mobileqq.colornote.a.b(this.f401617c.getColorNote().mServiceType), 0, "", "", "", "");
            }
        }
    }

    public boolean g() {
        ColorNote colorNote;
        f fVar = this.f401617c;
        if (fVar != null && (colorNote = fVar.getColorNote()) != null) {
            return this.f401616b.j(colorNote.getServiceType(), colorNote.getSubType());
        }
        return false;
    }

    public boolean h(int i3, String str) {
        return this.f401616b.j(i3, str);
    }

    public void i() {
        com.tencent.mobileqq.colornote.data.a.E(this.f401618d);
        ReportController.o(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
    }

    public void j(View view) {
        this.f401615a = view;
    }

    public void k(g gVar) {
        this.f401616b.l(gVar);
    }

    public void l(f fVar) {
        this.f401617c = fVar;
    }

    public void m(ColorNote colorNote) {
        this.f401616b.m(colorNote);
    }
}
