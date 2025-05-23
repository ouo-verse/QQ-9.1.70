package com.tencent.mobileqq.qwallet.utils.impl;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f279278a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f279279b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f279280c;

        a(boolean z16, boolean z17, int i3) {
            this.f279278a = z16;
            this.f279279b = z17;
            this.f279280c = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            boolean z16 = this.f279278a;
            if (z16 && this.f279279b) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f279280c);
                return;
            }
            if (z16) {
                int width = view.getWidth();
                int height = view.getHeight();
                int i3 = this.f279280c;
                outline.setRoundRect(0, 0, width, height + i3, i3);
                return;
            }
            if (this.f279279b) {
                outline.setRoundRect(0, -this.f279280c, view.getWidth(), view.getHeight(), this.f279280c);
            }
        }
    }

    public static void a(View view, float f16) {
        b(view, f16, true, true);
    }

    public static void b(View view, float f16, boolean z16, boolean z17) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new a(z16, z17, ViewUtils.dip2px(f16)));
        view.setClipToOutline(true);
    }
}
