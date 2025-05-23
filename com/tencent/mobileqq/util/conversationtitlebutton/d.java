package com.tencent.mobileqq.util.conversationtitlebutton;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0002H&J\b\u0010\u0018\u001a\u00020\u0004H&J\b\u0010\u0019\u001a\u00020\u0004H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/d;", "", "", "e", "", "f", "c", "i", "Landroid/view/View;", "view", "g", "resetVisibility", "onBeforeAccountChanged", "onAccountChanged", "onPostThemeChanged", "", "color", "d", com.tencent.luggage.wxa.c8.c.f123400v, "b", "needClear", tl.h.F, "tabChange", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "a", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface d {
    void a();

    void b(int alpha);

    void c();

    void d(int color);

    boolean e();

    void f();

    void g(@NotNull View view);

    void h(boolean needClear);

    void i();

    void onAccountChanged();

    void onBeforeAccountChanged();

    void onPause();

    void onPostThemeChanged();

    void onResume(boolean tabChange);

    void resetVisibility();
}
