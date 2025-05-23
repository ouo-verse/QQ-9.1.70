package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d implements b {

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f68327g;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a f68329i;

    /* renamed from: j, reason: collision with root package name */
    private a f68330j;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f68321a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<c> f68322b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private p f68323c = new p(this);

    /* renamed from: d, reason: collision with root package name */
    private f f68324d = new f(this);

    /* renamed from: e, reason: collision with root package name */
    private PersonalityOperator f68325e = new PersonalityOperator(this);

    /* renamed from: f, reason: collision with root package name */
    private h f68326f = new h(this);

    /* renamed from: h, reason: collision with root package name */
    private Matrix f68328h = new Matrix();

    /* renamed from: k, reason: collision with root package name */
    private int f68331k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f68332l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f68333m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f68334n = -1;

    /* renamed from: o, reason: collision with root package name */
    private c f68335o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f68336p = false;

    /* renamed from: q, reason: collision with root package name */
    private int f68337q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f68338r = 0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f68339s = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void e();
    }

    public d(Context context) {
    }

    private void A() {
        ms.a.f("DoodleOpController", "realAddLinePath---");
        this.f68321a.add(this.f68335o);
        c cVar = this.f68335o;
        if (cVar.f68320a == 102) {
            String str = ((l) cVar).f68407b;
            if (DoodleLayout.Q0) {
                id0.b.f(o(str, 0));
            } else {
                id0.b.i(o(str, 0));
            }
            int i3 = this.f68337q;
            if (i3 != -1) {
                ((l) this.f68335o).f68409d = i3;
            }
        }
    }

    public void B(int i3) {
        if (i3 != this.f68332l) {
            if (i3 == 0) {
                F();
                this.f68325e.o(false);
            } else {
                this.f68325e.i();
            }
            this.f68332l = i3;
            hd0.c.a("DoodleOpController", "refresh visibility:" + i3);
        }
    }

    public void C() {
        if (!this.f68321a.isEmpty()) {
            for (int i3 = 0; i3 < this.f68321a.size(); i3++) {
                this.f68321a.get(i3).a();
            }
        }
        if (!this.f68322b.isEmpty()) {
            Iterator<c> it = this.f68322b.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        hd0.c.a("Personality", "releaseAllPaths");
    }

    public void D() {
        if (this.f68322b.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f68322b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void E() {
        HashSet hashSet = new HashSet();
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f68320a == 102) {
                String o16 = o(((l) next).f68407b, 1);
                if (!hashSet.contains(o16)) {
                    hashSet.add(o16);
                }
            }
        }
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            String str = (String) it5.next();
            if (DoodleLayout.Q0) {
                id0.b.f(str);
            } else {
                id0.b.i(str);
            }
        }
    }

    public void F() {
        for (int size = this.f68321a.size() - 1; size >= 0; size--) {
            if (this.f68321a.get(size).f68320a == 102) {
                l lVar = (l) this.f68321a.get(size);
                lVar.f68411f = false;
                if (lVar.f68413h) {
                    return;
                }
            }
        }
    }

    public void H(Canvas canvas, float f16) {
        canvas.save();
        canvas.scale(f16, f16);
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f68320a == 104) {
                this.f68326f.e(canvas, new g(next, 1.0f), 0.0f);
            }
        }
        canvas.restore();
    }

    public void I(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleOpController", 2, "savePersonality start");
        }
        this.f68325e.r(i3);
        try {
            this.f68338r = 0;
            this.f68339s = true;
            while (this.f68338r < 25 && this.f68339s) {
                LockMethodProxy.sleep(200L);
                this.f68338r++;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DoodleOpController", 2, "savePersonality error " + e16.toString());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoodleOpController", 2, "savePersonality end");
        }
    }

    public void J(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a aVar) {
        this.f68329i = aVar;
    }

    public void K(a aVar) {
        this.f68330j = aVar;
    }

    public void L(Matrix matrix) {
        this.f68328h.set(matrix);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.b
    public int a() {
        return this.f68331k;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.b
    public void b() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a aVar = this.f68329i;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.b
    public void c(Bitmap bitmap) {
        this.f68327g = bitmap;
        this.f68339s = false;
        a aVar = this.f68330j;
        if (aVar != null) {
            aVar.e();
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoodleOpController", 2, "saveStillBitmap end bitmap:" + bitmap);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.b
    public void d(c cVar) {
        this.f68335o = cVar;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.b
    public void e(Runnable runnable) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a aVar = this.f68329i;
        if (aVar != null) {
            aVar.b(runnable);
        }
    }

    public void g() {
        Bitmap bitmap = this.f68327g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f68327g.recycle();
        this.f68327g = null;
    }

    public void h(Canvas canvas) {
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f68320a == 104) {
                canvas.save();
                canvas.concat(this.f68328h);
                this.f68326f.e(canvas, (g) next, 0.0f);
                canvas.restore();
            }
        }
    }

    public f i() {
        return this.f68324d;
    }

    public String j() {
        HashSet hashSet = new HashSet();
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                int i3 = next.f68320a;
                if (i3 == 101) {
                    hashSet.add(1);
                } else if (i3 != 111) {
                    switch (i3) {
                        case 103:
                        case 104:
                        case 105:
                            hashSet.add(3);
                            break;
                    }
                } else {
                    hashSet.add(2);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            sb5.append((Integer) it5.next());
            sb5.append("|");
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public int m() {
        return this.f68321a.size();
    }

    public List<String> n() {
        boolean z16;
        if (this.f68321a.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f68320a == 102) {
                l lVar = (l) next;
                Iterator it5 = arrayList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        z16 = false;
                        break;
                    }
                    if (TextUtils.equals((String) it5.next(), lVar.f68407b)) {
                        z16 = true;
                        break;
                    }
                }
                if (!z16) {
                    arrayList.add(lVar.f68407b);
                }
            }
        }
        return arrayList;
    }

    String o(String str, int i3) {
        if ("doodle_fireworks".equals(str)) {
            if (i3 == 0) {
                if (DoodleLayout.Q0) {
                    return "0X80079F0";
                }
                return "0X80079EE";
            }
            if (i3 == 1) {
                if (DoodleLayout.Q0) {
                    return "0X80079F1";
                }
                return "0X80079EF";
            }
        } else if ("doodle_image_xin".equals(str)) {
            if (i3 == 0) {
                if (DoodleLayout.Q0) {
                    return "0X80079EB";
                }
                return "0X80079E9";
            }
            if (i3 == 1) {
                if (DoodleLayout.Q0) {
                    return "0X80079EC";
                }
                return "0X80079EA";
            }
        } else if ("doodle_image_mouth".equals(str)) {
            if (i3 == 0) {
                if (DoodleLayout.Q0) {
                    return "0X80079E7";
                }
                return "0X80079E5";
            }
            if (i3 == 1) {
                if (DoodleLayout.Q0) {
                    return "0X80079E8";
                }
                return "0X80079E6";
            }
        } else if ("doodle_highlighter".equals(str)) {
            if (i3 == 0) {
                if (DoodleLayout.Q0) {
                    return "0X80079E3";
                }
                return "0X8007C0A";
            }
            if (i3 == 1) {
                if (DoodleLayout.Q0) {
                    return "0X80079E4";
                }
                return "0X8007C0B";
            }
        } else if ("doodle_image_family".equals(str)) {
            if (i3 == 0) {
                if (DoodleLayout.Q0) {
                    return "0X8007C06";
                }
                return "0X8007C08";
            }
            if (i3 == 1) {
                if (DoodleLayout.Q0) {
                    return "0X8007C07";
                }
                return "0X8007C09";
            }
        }
        return "";
    }

    public boolean p() {
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            if (it.next().f68320a == 102) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        if (p()) {
            return false;
        }
        if (this.f68321a.isEmpty()) {
            return true;
        }
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            if (it.next().f68320a != 103) {
                return false;
            }
        }
        return true;
    }

    public void r() {
        this.f68321a.clear();
        this.f68323c.d();
        this.f68326f.a();
        this.f68325e.h();
        this.f68324d.d();
    }

    public void s() {
        this.f68325e.n();
    }

    public void t() {
        g();
    }

    public void u(Canvas canvas, float f16) {
        if (this.f68321a.isEmpty() && this.f68336p) {
            canvas.drawColor(0);
            this.f68336p = false;
        }
        Iterator<c> it = this.f68321a.iterator();
        c cVar = null;
        while (it.hasNext()) {
            c next = it.next();
            if (next.f68320a == 105) {
                cVar = next;
            }
        }
        Iterator<c> it5 = this.f68321a.iterator();
        while (it5.hasNext()) {
            c next2 = it5.next();
            int i3 = next2.f68320a;
            if (i3 == 101) {
                this.f68336p = true;
                p pVar = this.f68323c;
                pVar.a(canvas, next2, pVar.b());
            } else if (i3 == 105) {
                this.f68336p = true;
                this.f68326f.e(canvas, (g) next2, f16);
                if (next2 == cVar) {
                    this.f68326f.l();
                }
            } else if (i3 == 111) {
                f fVar = this.f68324d;
                fVar.a(canvas, next2, fVar.b());
            }
        }
        if (cVar == null && this.f68336p) {
            this.f68326f.c(true);
        }
        this.f68323c.e();
    }

    public void v(Canvas canvas, float f16) {
        canvas.save();
        canvas.scale(f16, f16);
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i3 = next.f68320a;
            if (i3 == 101) {
                o oVar = new o(next, 1.0f);
                p pVar = this.f68323c;
                pVar.a(canvas, oVar, pVar.c());
            } else if (i3 == 111) {
                o oVar2 = new o(next, 1.0f);
                f fVar = this.f68324d;
                fVar.a(canvas, oVar2, fVar.c());
            }
        }
        canvas.restore();
    }

    public void w() {
        System.currentTimeMillis();
        this.f68325e.l();
        System.currentTimeMillis();
        for (int i3 = 0; i3 < this.f68321a.size(); i3++) {
            c cVar = this.f68321a.get(i3);
            if (cVar.f68320a == 102) {
                this.f68325e.m((l) cVar);
            }
        }
        System.currentTimeMillis();
        this.f68325e.k();
        System.currentTimeMillis();
        QLog.isColorLevel();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
    
        if (r2 != 3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean x(int i3, MotionEvent motionEvent) {
        int round = Math.round(motionEvent.getY());
        int round2 = Math.round(motionEvent.getX());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f68335o != null && ((Math.abs(round2 - this.f68333m) >= 3 || Math.abs(round - this.f68334n) >= 3) && motionEvent.getEventTime() - motionEvent.getDownTime() > 100)) {
                        A();
                        this.f68335o = null;
                        ms.a.f("DoodleOpController", "clear mCurPath after real add");
                    }
                }
            }
            if (this.f68335o != null) {
                this.f68335o = null;
                ms.a.f("DoodleOpController", "clear mCurPath when touch up or cancel");
            }
        } else {
            this.f68333m = Math.round(motionEvent.getX());
            this.f68334n = Math.round(motionEvent.getY());
        }
        e l3 = l(i3);
        if (l3 != null) {
            return l3.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean y() {
        if (this.f68321a.isEmpty()) {
            return false;
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f68321a;
        c remove = copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        this.f68322b.add(remove);
        id0.b.i("0X80076BF");
        id0.b.f("0X80075CC");
        int i3 = remove.f68320a;
        if (i3 == 103 || i3 == 104 || i3 == 105) {
            this.f68326f.m((g) remove);
        } else if (i3 == 102) {
            F();
            this.f68325e.q();
        }
        return true;
    }

    public void z(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleOpController", 2, "preSavePersonality");
        }
        this.f68325e.r(i3);
    }

    public void f(AppInterface appInterface, int i3) {
        this.f68337q = -1;
        if (this.f68331k == i3) {
            return;
        }
        String i16 = PtvTemplateManager.j().i(i3);
        if (i16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("DoodleOpController", 2, "changeStroke error ");
                return;
            }
            return;
        }
        this.f68325e.u(VideoSDKMaterialParser.parseVideoMaterialForEdit(i16, "params"));
        this.f68331k = i3;
        hd0.c.a("DoodleOpController", "change stroke" + i3);
    }

    public int[] k() {
        int[] iArr = {0, 0};
        if (this.f68321a.isEmpty()) {
            return iArr;
        }
        Iterator<c> it = this.f68321a.iterator();
        while (it.hasNext()) {
            int i3 = it.next().f68320a;
            if (i3 != 103 && i3 != 104) {
                iArr[0] = iArr[0] + 1;
            } else {
                iArr[1] = iArr[1] + 1;
            }
        }
        return iArr;
    }

    public void G(int i3) {
        if (i3 == 101) {
            this.f68323c.e();
        } else if (i3 == 104) {
            this.f68326f.n();
        } else if (i3 == 105) {
            this.f68326f.n();
        }
    }

    public e l(int i3) {
        if (i3 != 111) {
            switch (i3) {
                case 101:
                    return this.f68323c;
                case 102:
                    return this.f68325e;
                case 103:
                case 104:
                case 105:
                    return this.f68326f;
                default:
                    return null;
            }
        }
        return this.f68324d;
    }
}
