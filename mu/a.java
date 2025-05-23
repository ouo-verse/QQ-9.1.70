package mu;

import android.content.Context;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {
    public static String a(boolean z16, boolean z17, boolean z18, Context context, boolean z19) {
        int i3;
        int i16;
        int i17 = R.string.d9v;
        if (z16) {
            if (!z19) {
                i17 = R.string.d9w;
            }
            return context.getString(i17);
        }
        if (z18) {
            if (z19) {
                i16 = R.string.f17783351;
            } else {
                i16 = R.string.f17785353;
            }
            return context.getString(i16);
        }
        if (z17) {
            if (z19) {
                i3 = R.string.f17782350;
            } else {
                i3 = R.string.f17784352;
            }
            return context.getString(i3);
        }
        return context.getString(R.string.d9v);
    }
}
