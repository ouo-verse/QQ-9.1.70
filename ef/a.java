package ef;

import android.graphics.Color;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lef/a;", "", "", "colorStr", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396213a = new a();

    a() {
    }

    public final int a(String colorStr, int defaultColor) {
        if (colorStr == null) {
            return defaultColor;
        }
        try {
            return Color.parseColor(colorStr);
        } catch (Throwable unused) {
            return defaultColor;
        }
    }
}
