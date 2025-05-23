package com.tencent.xweb;

import android.content.Context;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes27.dex */
public abstract class XWebExtendPluginNativeViewDelegate {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f385062a;

    public abstract Context getContext();

    public FrameLayout getRootView() {
        if (this.f385062a.get() != null) {
            return ((XWebExtendPluginNativeViewClient) this.f385062a.get()).getRootView();
        }
        return null;
    }

    public abstract void onCreate(int i3, int i16);

    public abstract void onDestroy();

    public abstract void onSizeChanged(int i3, int i16);

    public void setClient(XWebExtendPluginNativeViewClient xWebExtendPluginNativeViewClient) {
        this.f385062a = new WeakReference(xWebExtendPluginNativeViewClient);
    }
}
