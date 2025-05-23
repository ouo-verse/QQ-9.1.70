package com.tencent.luggage.wxa.z1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kj.n0;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.r0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends FrameLayout implements r0 {

    /* renamed from: a, reason: collision with root package name */
    public c f146177a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z1.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class ViewOnTouchListenerC6966b implements View.OnTouchListener {
        public ViewOnTouchListenerC6966b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void b(View view);
    }

    public b(Context context) {
        super(context);
        this.f146177a = null;
    }

    @Override // com.tencent.luggage.wxa.kj.z.b
    public void a(int i3) {
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if ((view instanceof com.tencent.luggage.wxa.ye.b) && !view.hasOnClickListeners()) {
            view.setOnTouchListener(new ViewOnTouchListenerC6966b());
        }
        c cVar = this.f146177a;
        if (cVar != null) {
            cVar.b(view);
        }
    }

    public void setNativeWidgetAddedCallback(c cVar) {
        this.f146177a = cVar;
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void a(n0 n0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void a(o0 o0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.d0
    public void a(boolean z16, int i3, int i16, int i17, int i18) {
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public ViewGroup getContainer() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void setupWebViewTouchInterceptor(@NonNull o0 o0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.f0
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
    }
}
