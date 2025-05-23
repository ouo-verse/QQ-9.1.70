package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public File f30175a;

    /* renamed from: b, reason: collision with root package name */
    public Context f30176b;

    public j(Context context) {
        if (context == null) {
            return;
        }
        this.f30176b = context.getApplicationContext();
        try {
            this.f30175a = new File(context.getExternalFilesDir("data").getAbsolutePath() + "/d_l");
        } catch (Throwable unused) {
            this.f30175a = null;
        }
    }
}
