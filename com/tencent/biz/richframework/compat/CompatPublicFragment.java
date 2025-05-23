package com.tencent.biz.richframework.compat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes5.dex */
public class CompatPublicFragment extends Fragment implements IFragmentCallbacks {
    private Handler mMainHandler;

    public CompatPublicFragment() {
    }

    public /* synthetic */ void beforeFinish() {
        f.a(this);
    }

    public /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return f.b(this, i3, keyEvent);
    }

    public Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }

    public /* synthetic */ boolean onBackEvent() {
        return f.h(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public /* synthetic */ void onFinish() {
        f.i(this);
    }

    public /* synthetic */ void onNewIntent(Intent intent) {
        f.j(this, intent);
    }

    public /* synthetic */ void onPostThemeChanged() {
        f.k(this);
    }

    public /* synthetic */ void onWindowFocusChanged(boolean z16) {
        f.n(this, z16);
    }

    public /* synthetic */ boolean overrideFinish() {
        return f.o(this);
    }

    public CompatPublicFragment(int i3) {
        super(i3);
    }
}
