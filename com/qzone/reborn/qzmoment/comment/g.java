package com.qzone.reborn.qzmoment.comment;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f58886a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f58887b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            g.this.b(windowInsetsCompat);
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public g(View view) {
        c(view);
    }

    private void c(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new a());
    }

    private void d() {
        for (b bVar : this.f58886a) {
            if (bVar != null) {
                bVar.onSoftKeyboardClosed();
            }
        }
    }

    private void e(int i3) {
        for (b bVar : this.f58886a) {
            if (bVar != null) {
                bVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void a(b bVar) {
        this.f58886a.add(bVar);
    }

    public void b(WindowInsetsCompat windowInsetsCompat) {
        boolean isVisible = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime());
        int i3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        boolean z16 = this.f58887b;
        if (!z16 && isVisible) {
            this.f58887b = true;
            e(i3);
        } else {
            if (!z16 || isVisible) {
                return;
            }
            this.f58887b = false;
            d();
        }
    }

    public void f() {
        this.f58886a.clear();
    }
}
