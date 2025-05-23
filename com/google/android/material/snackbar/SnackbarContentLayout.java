package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private TextView f34211d;

    /* renamed from: e, reason: collision with root package name */
    private Button f34212e;

    /* renamed from: f, reason: collision with root package name */
    private int f34213f;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    private static void c(@NonNull View view, int i3, int i16) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i3, ViewCompat.getPaddingEnd(view), i16);
        } else {
            view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), i16);
        }
    }

    private boolean d(int i3, int i16, int i17) {
        boolean z16;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f34211d.getPaddingTop() == i16 && this.f34211d.getPaddingBottom() == i17) {
            return z16;
        }
        c(this.f34211d, i16, i17);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i3, int i16) {
        this.f34211d.setAlpha(1.0f);
        long j3 = i16;
        long j16 = i3;
        this.f34211d.animate().alpha(0.0f).setDuration(j3).setStartDelay(j16).start();
        if (this.f34212e.getVisibility() == 0) {
            this.f34212e.setAlpha(1.0f);
            this.f34212e.animate().alpha(0.0f).setDuration(j3).setStartDelay(j16).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i3, int i16) {
        this.f34211d.setAlpha(0.0f);
        long j3 = i16;
        long j16 = i3;
        this.f34211d.animate().alpha(1.0f).setDuration(j3).setStartDelay(j16).start();
        if (this.f34212e.getVisibility() == 0) {
            this.f34212e.setAlpha(0.0f);
            this.f34212e.animate().alpha(1.0f).setDuration(j3).setStartDelay(j16).start();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f34211d = (TextView) findViewById(R.id.f86724sf);
        this.f34212e = (Button) findViewById(R.id.f86714se);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (d(1, r0, r0 - r2) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        if (r1 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        super.onMeasure(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (d(0, r0, r0) != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        super.onMeasure(i3, i16);
        boolean z17 = true;
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c98);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.c97);
        if (this.f34211d.getLayout().getLineCount() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || this.f34213f <= 0 || this.f34212e.getMeasuredWidth() <= this.f34213f) {
            if (!z16) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f34213f = i3;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
