package com.tencent.libra.extension.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<GifDrawable> f118758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.f118758a = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        GifDrawable gifDrawable = this.f118758a.get();
        if (gifDrawable == null) {
            return;
        }
        if (message.what == -1) {
            gifDrawable.invalidateSelf();
            return;
        }
        Iterator<r01.d> it = gifDrawable.D.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
