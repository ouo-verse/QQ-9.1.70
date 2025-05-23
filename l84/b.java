package l84;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0018\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\n"}, d2 = {"Landroid/widget/TextView;", "Lpv4/u;", "sceneIndexText", "", "defaultColorInt", "", "a", "", "netColorString", "b", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final void a(TextView textView, u uVar, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (uVar == null || (str = uVar.f427702a) == null) {
            str = "";
        }
        textView.setText(str);
        textView.setTextColor(b(uVar != null ? uVar.f427704c : null, i3));
    }

    public static final int b(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            QLog.e("ZootopiaBaseCard", 1, "(NOT CRASH) getFinalTxtColor error netColorString = " + str, e16);
            return i3;
        }
    }
}
