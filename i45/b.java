package i45;

import android.content.Context;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public class b implements a {
    @Override // i45.a
    public void a(Context context, int i3, int i16) {
        if (i3 >= i16) {
            e.b("PropertiesGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            e.c("PropertiesGrade", "update settings.properties when version update", true);
            b(context, i3);
        }
    }

    private void b(Context context, int i3) {
    }
}
