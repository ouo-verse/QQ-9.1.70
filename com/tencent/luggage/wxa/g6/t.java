package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mm.ui.BaseActivity;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface t extends LifecycleOwner, ViewModelStoreOwner {
    View findViewById(int i3);

    void finish();

    Context getContext();

    Intent getIntent();

    r getPage();

    int getRequestedOrientation();

    Window getWindow();

    void hideActionbarLine();

    boolean isFinishing();

    void overridePendingTransition(int i3, int i16);

    void runOnUiThread(Runnable runnable);

    void setActionBarColor(int i3);

    void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i3, BaseActivity.h hVar);

    void setContentView(int i3);

    void setIntent(Intent intent);

    void setResult(int i3);

    void setResult(int i3, Intent intent);

    void setTitle(int i3);

    void setTitle(CharSequence charSequence);

    void showActionbarLine();

    void superOnBackPressed();
}
