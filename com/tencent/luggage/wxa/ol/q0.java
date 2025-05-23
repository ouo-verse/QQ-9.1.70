package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface q0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void onConfigurationChanged(Configuration configuration);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        boolean a(int i3, KeyEvent keyEvent);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(int i3, int i16);
    }

    int a(int i3);

    void a(float f16, float f17);

    void a(View.OnFocusChangeListener onFocusChangeListener);

    void a(com.tencent.luggage.wxa.kj.v vVar);

    void a(a aVar);

    void a(c cVar);

    void addTextChangedListener(TextWatcher textWatcher);

    void b();

    void b(View.OnFocusChangeListener onFocusChangeListener);

    void b(com.tencent.luggage.wxa.kj.v vVar);

    boolean d();

    void destroy();

    void e();

    boolean f();

    void g();

    com.tencent.luggage.wxa.pl.b getAutoFillController();

    Context getContext();

    int getInputId();

    View getInputPanel();

    char getLastKeyPressed();

    CharSequence getText();

    View getView();

    boolean h();

    void setFixed(boolean z16);

    void setInputId(int i3);

    void setOnKeyUpPostImeListener(b bVar);
}
