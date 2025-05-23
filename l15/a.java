package l15;

import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f413697a;

    public static a a() {
        if (f413697a == null) {
            synchronized (a.class) {
                if (f413697a == null) {
                    f413697a = new a();
                }
            }
        }
        return f413697a;
    }

    public Drawable b(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener) {
        return QzoneHuangzuanVipIconShow.getInstance().getLayers(i3, i16, z16, z17, str, i17, i18, str2, vipResourcesListener, 0);
    }

    public Drawable c(int i3, int i16, boolean z16, boolean z17, String str, int i17, VipResourcesListener vipResourcesListener) {
        return b(i3, i16, z16, z17, str, i17, 100, null, vipResourcesListener);
    }
}
