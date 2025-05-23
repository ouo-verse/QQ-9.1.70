package com.tencent.luggage.wxa.h6;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n implements m {
    @Override // com.tencent.luggage.wxa.h6.m
    public int a(int i3) {
        return i3;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean c() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean d() {
        return com.tencent.luggage.wxa.p003do.b.c();
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public int b(Context context) {
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 28) {
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
            Integer valueOf = (a16 == null || (window = a16.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : Integer.valueOf(rootWindowInsets.getStableInsetTop());
            if (valueOf != null) {
                return valueOf.intValue();
            }
        }
        return com.tencent.luggage.wxa.lo.f.b(context, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r4.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r4 = r4.getBoundingRects();
     */
    @Override // com.tencent.luggage.wxa.h6.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(Context context) {
        Window window;
        View decorView;
        DisplayCutout displayCutout;
        List boundingRects;
        if (Build.VERSION.SDK_INT >= 28) {
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
            int size = (a16 == null || (window = a16.getWindow()) == null || (decorView = window.getDecorView()) == null || (r4 = decorView.getRootWindowInsets()) == null || displayCutout == null || boundingRects == null) ? 0 : boundingRects.size();
            if (size <= 0) {
                return false;
            }
        } else if (!com.tencent.luggage.wxa.p003do.g.a(context) && !com.tencent.luggage.wxa.p003do.f.a(context) && !com.tencent.luggage.wxa.p003do.b.a(context)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean a(String str) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r4.getDisplayCutout();
     */
    @Override // com.tencent.luggage.wxa.h6.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Context context) {
        Window window;
        View decorView;
        DisplayCutout displayCutout;
        int safeInsetTop;
        if (Build.VERSION.SDK_INT >= 28) {
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
            if (a16 == null || (window = a16.getWindow()) == null || (decorView = window.getDecorView()) == null || (r4 = decorView.getRootWindowInsets()) == null || displayCutout == null) {
                return 0;
            }
            safeInsetTop = displayCutout.getSafeInsetTop();
            return safeInsetTop;
        }
        if (c(context)) {
            return com.tencent.luggage.wxa.lo.f.e(context);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public void a(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if (textPaint != null) {
            textPaint.setStrokeWidth(0.8f);
        }
    }
}
