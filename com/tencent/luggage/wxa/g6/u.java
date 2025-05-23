package com.tencent.luggage.wxa.g6;

import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.util.LuggageActivityHelper;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface u extends t {
    void a(Window window);

    void a(LuggageActivityHelper.d dVar);

    void a(r rVar);

    void b();

    ViewGroup c();

    void n();

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener);

    void setTheme(int i3);
}
