package c13;

import android.graphics.Rect;
import android.util.SparseArray;
import com.etrump.mixlayout.e;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ETDrawable f30234a;

    /* renamed from: b, reason: collision with root package name */
    private e f30235b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<Rect> f30236c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private int[] f30237d = new int[2];

    public a(ETDrawable eTDrawable, e eVar) {
        this.f30234a = eTDrawable;
        this.f30235b = eVar;
    }

    public int a(int i3, int i16) {
        this.f30234a.J(this.f30237d);
        Rect padding = this.f30234a.getPadding();
        e eVar = this.f30235b;
        int[] iArr = this.f30237d;
        return eVar.x((i3 - iArr[0]) - padding.left, (i16 - iArr[1]) - padding.top);
    }
}
