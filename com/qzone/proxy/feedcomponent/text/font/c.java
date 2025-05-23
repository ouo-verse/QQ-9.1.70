package com.qzone.proxy.feedcomponent.text.font;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.qzone.proxy.feedcomponent.text.QzoneFontManager;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements QzoneFontManager.b {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<TextCellLayout> f50741a;

    /* renamed from: b, reason: collision with root package name */
    private int f50742b;

    public c(TextCellLayout textCellLayout, int i3) {
        this.f50741a = new WeakReference<>(textCellLayout);
        this.f50742b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(TextCellLayout textCellLayout, Typeface typeface) {
        textCellLayout.O0 = typeface;
        View attachedView = textCellLayout.f50663z1.getAttachedView();
        if (attachedView != null) {
            textCellLayout.forceRequestLayout();
            attachedView.requestLayout();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.QzoneFontManager.b
    public void a(final Typeface typeface) {
        final TextCellLayout textCellLayout = this.f50741a.get();
        if (textCellLayout == null || textCellLayout.N0 != this.f50742b || typeface == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.font.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(TextCellLayout.this, typeface);
            }
        });
    }
}
