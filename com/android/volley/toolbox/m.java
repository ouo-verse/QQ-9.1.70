package com.android.volley.toolbox;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.d;
import java.io.File;

/* compiled from: P */
/* loaded from: classes.dex */
public class m {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        private File f31431a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f31432b;

        a(Context context) {
            this.f31432b = context;
        }

        @Override // com.android.volley.toolbox.d.c
        public File get() {
            if (this.f31431a == null) {
                this.f31431a = new File(this.f31432b.getCacheDir(), "volley");
            }
            return this.f31431a;
        }
    }

    @NonNull
    public static RequestQueue a(Context context) {
        return c(context, null);
    }

    @NonNull
    private static RequestQueue b(Context context, com.android.volley.f fVar) {
        RequestQueue requestQueue = new RequestQueue(new d(new a(context.getApplicationContext())), fVar);
        requestQueue.i();
        return requestQueue;
    }

    @NonNull
    public static RequestQueue c(Context context, com.android.volley.toolbox.a aVar) {
        b bVar;
        if (aVar == null) {
            bVar = new b(new h());
        } else {
            bVar = new b(aVar);
        }
        return b(context, bVar);
    }
}
