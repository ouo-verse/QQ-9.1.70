package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.Color;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\"\u0017\u0010\u000b\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0017\u0010\r\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/as;", "", "", "c", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/as;)[Ljava/lang/String;", "", "index", "d", "a", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/as;", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/as;", "defaultConfig", "b", "flashShowConfig", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class au {

    /* renamed from: a, reason: collision with root package name */
    private static final as f63104a;

    /* renamed from: b, reason: collision with root package name */
    private static final as f63105b;

    static {
        Pair[] pairArr = {TuplesKt.to("\u6ee4\u955c", 0), TuplesKt.to("\u7f8e\u989c", 1), TuplesKt.to("\u7f8e\u5986", 2), TuplesKt.to("\u7f8e\u4f53", 3)};
        int parseColor = Color.parseColor("#8CFFFFFF");
        com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(1);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.data.AEMaterialManager");
        f63104a = new as(R.drawable.iun, pairArr, false, -1, parseColor, (AEMaterialManager) b16, false, R.string.y1t);
        Pair[] pairArr2 = {TuplesKt.to("\u7f8e\u989c", 1), TuplesKt.to("\u7f8e\u5986", 2), TuplesKt.to("\u7f8e\u4f53", 3)};
        int parseColor2 = Color.parseColor("#8CFFFFFF");
        com.tencent.aelight.camera.ae.control.b b17 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        f63105b = new as(R.drawable.iun, pairArr2, false, -1, parseColor2, (AEFlashShowMaterialManager) b17, true, R.string.y1t);
    }

    public static final as a() {
        return f63104a;
    }

    public static final as b() {
        return f63105b;
    }

    public static final String[] c(as asVar) {
        Intrinsics.checkNotNullParameter(asVar, "<this>");
        Pair<String, Integer>[] e16 = asVar.e();
        ArrayList arrayList = new ArrayList(e16.length);
        for (Pair<String, Integer> pair : e16) {
            arrayList.add(pair.getFirst());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public static final int d(as asVar, int i3) {
        Intrinsics.checkNotNullParameter(asVar, "<this>");
        if (i3 < 0 || i3 >= asVar.e().length) {
            return -1;
        }
        return asVar.e()[i3].getSecond().intValue();
    }
}
