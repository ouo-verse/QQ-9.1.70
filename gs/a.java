package gs;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import qs.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements c {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f403251e = {R.drawable.fhn, R.drawable.fhq, R.drawable.fho, R.drawable.fht, R.drawable.fhs};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f403252f = {R.drawable.fhp, R.drawable.fhn, R.drawable.fhq, R.drawable.fho, R.drawable.fht, R.drawable.fhs};

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f403253a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f403254b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f403255c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f403256d;

    public a(AppInterface appInterface, boolean z16, boolean z17, boolean z18) {
        this.f403253a = appInterface;
        this.f403254b = z16;
        this.f403255c = z17;
        this.f403256d = z18;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // gs.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ArrayList<d> arrayList, Context context) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (QLog.isColorLevel()) {
            QLog.e("CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke, mNeedMosaic:", Boolean.valueOf(this.f403254b), " mNeedPersonality:", Boolean.valueOf(this.f403255c), " mIsEditPic:", Boolean.valueOf(this.f403256d));
        }
        if (this.f403254b) {
            d dVar5 = new d(context.getResources().getDrawable(R.drawable.fhv), 1, 0);
            dVar5.f429432d = HardCodeUtil.qqStr(R.string.f171789l02);
            arrayList.add(dVar5);
        }
        if (this.f403255c) {
            boolean i3 = f.i();
            d dVar6 = null;
            if (this.f403253a != null && i3) {
                ArrayList<qs.a> h16 = PtvTemplateManager.j().h();
                if (h16 != null && !h16.isEmpty()) {
                    Iterator<qs.a> it = h16.iterator();
                    dVar = null;
                    dVar2 = null;
                    dVar3 = null;
                    dVar4 = null;
                    while (it.hasNext()) {
                        qs.a next = it.next();
                        "doodle_highlighter".equals(next.f429423b);
                        int intValue = Integer.valueOf(next.f429422a).intValue();
                        if ("doodle_image_family".equals(next.f429423b)) {
                            dVar3 = new d(context.getResources().getDrawable(R.drawable.er_), 2, intValue);
                            dVar3.f429432d = HardCodeUtil.qqStr(R.string.f171788l01);
                        } else if ("doodle_image_mouth".equals(next.f429423b)) {
                            dVar4 = new d(context.getResources().getDrawable(R.drawable.era), 2, intValue);
                            dVar4.f429432d = HardCodeUtil.qqStr(R.string.f171787l00);
                        } else if ("doodle_image_xin".equals(next.f429423b)) {
                            dVar2 = new d(context.getResources().getDrawable(R.drawable.erb), 2, intValue);
                            dVar2.f429432d = HardCodeUtil.qqStr(R.string.f171790l03);
                        } else if ("doodle_highlighter".equals(next.f429423b)) {
                            dVar6 = new d(context.getResources().getDrawable(R.drawable.er9), 2, intValue);
                            dVar6.f429432d = HardCodeUtil.qqStr(R.string.kzy);
                        } else if ("doodle_fireworks".equals(next.f429423b)) {
                            dVar = new d(context.getResources().getDrawable(R.drawable.er7), 2, intValue);
                            dVar.f429432d = HardCodeUtil.qqStr(R.string.kzz);
                        }
                    }
                    b(context, arrayList);
                    if (dVar6 != null) {
                        arrayList.add(dVar6);
                    }
                    if (dVar != null) {
                        arrayList.add(dVar);
                    }
                    if (dVar2 != null) {
                        arrayList.add(dVar2);
                    }
                    if (dVar3 != null) {
                        arrayList.add(dVar3);
                    }
                    if (dVar4 == null) {
                        arrayList.add(dVar4);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
                }
            }
            dVar = null;
            dVar2 = null;
            dVar3 = null;
            dVar4 = null;
            b(context, arrayList);
            if (dVar6 != null) {
            }
            if (dVar != null) {
            }
            if (dVar2 != null) {
            }
            if (dVar3 != null) {
            }
            if (dVar4 == null) {
            }
        } else {
            b(context, arrayList);
        }
    }

    public void b(Context context, ArrayList<d> arrayList) {
        int[] iArr;
        int[] iArr2;
        boolean z16 = this.f403256d;
        if (z16) {
            iArr = f403252f;
        } else {
            iArr = f403251e;
        }
        if (z16) {
            iArr2 = d.f429428f;
        } else {
            iArr2 = d.f429427e;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            arrayList.add(new d(context.getResources().getDrawable(iArr[i3]), 0, iArr2[i3]));
        }
    }
}
