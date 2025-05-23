package com.google.android.filament.android;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Renderer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DisplayHelper {

    /* renamed from: a, reason: collision with root package name */
    private Handler f33049a = null;

    /* renamed from: b, reason: collision with root package name */
    private DisplayManager f33050b;

    /* renamed from: c, reason: collision with root package name */
    private Display f33051c;

    /* renamed from: d, reason: collision with root package name */
    private Renderer f33052d;

    /* renamed from: e, reason: collision with root package name */
    private DisplayManager.DisplayListener f33053e;

    public DisplayHelper(@NonNull Context context) {
        this.f33050b = (DisplayManager) context.getSystemService("display");
    }

    @NonNull
    public static Renderer.b d(@NonNull Display display, @Nullable Renderer.b bVar) {
        if (bVar == null) {
            bVar = new Renderer.b();
        }
        bVar.f32970a = e(display);
        return bVar;
    }

    public static float e(@NonNull Display display) {
        return display.getRefreshRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Renderer renderer = this.f33052d;
        if (renderer != null) {
            renderer.setDisplayInfo(d(this.f33051c, renderer.getDisplayInfo()));
        }
    }

    public void b(@NonNull Renderer renderer, @NonNull Display display) {
        if (renderer == this.f33052d && display == this.f33051c) {
            return;
        }
        this.f33052d = renderer;
        this.f33051c = display;
        a aVar = new a(display);
        this.f33053e = aVar;
        this.f33050b.registerDisplayListener(aVar, this.f33049a);
        Handler handler = this.f33049a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.filament.android.DisplayHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    DisplayHelper.this.f();
                }
            });
        } else {
            f();
        }
    }

    public void c() {
        DisplayManager.DisplayListener displayListener = this.f33053e;
        if (displayListener != null) {
            this.f33050b.unregisterDisplayListener(displayListener);
            this.f33053e = null;
            this.f33051c = null;
            this.f33052d = null;
        }
    }

    protected void finalize() throws Throwable {
        try {
            c();
        } finally {
            super.finalize();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Display f33054a;

        a(Display display) {
            this.f33054a = display;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            if (i3 == this.f33054a.getDisplayId()) {
                DisplayHelper.this.f();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }
}
