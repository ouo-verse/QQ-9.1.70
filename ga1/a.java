package ga1;

import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.e;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ColorNoteCurd f401611a;

    /* renamed from: b, reason: collision with root package name */
    private f f401612b;

    /* renamed from: c, reason: collision with root package name */
    private e f401613c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f401614d = true;

    public a() {
        ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
        this.f401611a = colorNoteCurd;
        colorNoteCurd.l(new g());
        e eVar = new e();
        this.f401613c = eVar;
        eVar.e(this.f401611a);
    }

    private boolean a(int i3) {
        if (i3 != 16908289 && i3 != 16908292 && i3 != 16842752 && i3 != 16908290) {
            return false;
        }
        return true;
    }

    public void b() {
        c(true);
    }

    public void c(boolean z16) {
        boolean z17;
        ColorNote colorNote;
        boolean z18;
        f fVar = this.f401612b;
        boolean z19 = false;
        if (fVar != null && this.f401611a != null && this.f401613c != null) {
            try {
                colorNote = fVar.getColorNote();
            } catch (Exception e16) {
                QLog.e("ColorNoteStateNotice", 1, e16, new Object[0]);
                colorNote = null;
            }
            if (colorNote != null && a(colorNote.getServiceType())) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (colorNote != null && z18 && this.f401614d && z16) {
                if (!this.f401611a.j(colorNote.getServiceType(), colorNote.getSubType())) {
                    com.tencent.mobileqq.colornote.data.a.d(colorNote);
                    this.f401613c.i(colorNote);
                    return;
                }
                return;
            }
            Object[] objArr = new Object[8];
            objArr[0] = "[noticeRecentColorNote] colorNote: ";
            if (colorNote != null) {
                z19 = true;
            }
            objArr[1] = Boolean.valueOf(z19);
            objArr[2] = ", allowType: ";
            objArr[3] = Boolean.valueOf(z18);
            objArr[4] = ", isReady: ";
            objArr[5] = Boolean.valueOf(this.f401614d);
            objArr[6] = ", recentNote: ";
            objArr[7] = Boolean.valueOf(z16);
            QLog.d("ColorNoteStateNotice", 1, objArr);
            return;
        }
        Object[] objArr2 = new Object[6];
        objArr2[0] = "[noticeRecentColorNote] serviceInfo: ";
        if (fVar != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        objArr2[1] = Boolean.valueOf(z17);
        objArr2[2] = ", colorNoteCurd: ";
        if (this.f401611a != null) {
            z19 = true;
        }
        objArr2[3] = Boolean.valueOf(z19);
        objArr2[4] = "recentlyViewed: ";
        objArr2[5] = this.f401613c;
        QLog.d("ColorNoteStateNotice", 1, objArr2);
    }

    public void d() {
        f fVar;
        if (this.f401611a != null && (fVar = this.f401612b) != null) {
            ColorNote colorNote = fVar.getColorNote();
            if (colorNote != null) {
                this.f401611a.o(colorNote.getServiceType(), colorNote.getSubType(), false);
                ColorNote c16 = com.tencent.mobileqq.colornote.data.a.c(colorNote);
                this.f401611a.o(c16.getServiceType(), c16.getSubType(), false);
                if (QLog.isDevelopLevel()) {
                    QLog.d("ColorNoteStateNotice", 4, "[onPause] ColorNote: ", colorNote.toString());
                    return;
                }
                return;
            }
            QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
        }
    }

    public void e() {
        f fVar;
        if (this.f401611a != null && (fVar = this.f401612b) != null) {
            ColorNote colorNote = fVar.getColorNote();
            if (colorNote != null) {
                this.f401611a.o(colorNote.getServiceType(), colorNote.getSubType(), true);
                ColorNote c16 = com.tencent.mobileqq.colornote.data.a.c(colorNote);
                this.f401611a.o(c16.getServiceType(), c16.getSubType(), true);
                if (QLog.isDevelopLevel()) {
                    QLog.d("ColorNoteStateNotice", 4, "[onResume] ColorNote: ", colorNote.toString());
                    return;
                }
                return;
            }
            QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
        }
    }

    public void f(ColorNoteCurd colorNoteCurd) {
        this.f401611a = colorNoteCurd;
    }

    public void g(boolean z16) {
        this.f401614d = z16;
    }

    public void h(g gVar) {
        ColorNoteCurd colorNoteCurd = this.f401611a;
        if (colorNoteCurd != null) {
            colorNoteCurd.l(gVar);
        }
    }

    public void i(f fVar) {
        this.f401612b = fVar;
    }
}
