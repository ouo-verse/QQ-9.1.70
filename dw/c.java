package dw;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: j, reason: collision with root package name */
    int f395063j;

    /* renamed from: k, reason: collision with root package name */
    int f395064k;

    /* renamed from: l, reason: collision with root package name */
    int f395065l;

    /* renamed from: m, reason: collision with root package name */
    int f395066m;

    /* renamed from: n, reason: collision with root package name */
    int f395067n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f395068o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f395069p;

    /* renamed from: q, reason: collision with root package name */
    WeakReference<View.OnClickListener> f395070q;

    public c(int i3, int i16, int i17, int i18, String str, int i19, int i26, View.OnClickListener onClickListener) {
        super(i3, i16, i17, i18, str);
        this.f395065l = -1;
        this.f395066m = -1;
        this.f395067n = -1;
        this.f395070q = null;
        this.f395063j = i19;
        this.f395064k = i26;
        if (onClickListener != null) {
            this.f395070q = new WeakReference<>(onClickListener);
        }
    }

    @Override // dw.d, dw.b
    public int h() {
        return 3;
    }

    public int q() {
        return this.f395063j;
    }

    public int r() {
        return this.f395064k;
    }

    public int s() {
        return this.f395067n;
    }

    public int t() {
        return this.f395066m;
    }

    public boolean u() {
        return this.f395068o;
    }

    public int v() {
        return this.f395065l;
    }

    public boolean w() {
        return this.f395069p;
    }

    public void x(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f395070q = new WeakReference<>(onClickListener);
        } else {
            this.f395070q = null;
        }
    }

    public View.OnClickListener y() {
        WeakReference<View.OnClickListener> weakReference = this.f395070q;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.f395070q.get();
        }
        return null;
    }

    public c(int i3, int i16, int i17, int i18, String str, int i19, int i26, int i27, int i28) {
        super(i3, i16, i17, i18, str, i19, i26);
        this.f395065l = -1;
        this.f395066m = -1;
        this.f395067n = -1;
        this.f395070q = null;
        this.f395063j = i27;
        this.f395064k = i28;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends ClickableSpan {
        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
        }
    }
}
