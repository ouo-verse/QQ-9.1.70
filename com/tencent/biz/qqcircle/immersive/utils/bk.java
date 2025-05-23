package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bk {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f90191a;

        a(int i3) {
            this.f90191a = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.tencent.qqnt.base.utils.c.f353052a.b(this.f90191a));
        }
    }

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Activity b(View view) {
        if (view == null) {
            return null;
        }
        return a(view.getContext());
    }

    public static void c(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    public static void d(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(i3));
    }
}
