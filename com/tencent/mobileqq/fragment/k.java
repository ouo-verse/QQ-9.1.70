package com.tencent.mobileqq.fragment;

import android.app.Activity;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/fragment/k;", "", "", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "", "k2", "Landroid/app/Activity;", "d0", "Lmqq/app/AppRuntime;", "getAppRuntime", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface k {
    @Nullable
    Activity d0();

    @Nullable
    AppRuntime getAppRuntime();

    void hideLoading();

    @Nullable
    String k2();

    void showLoading();
}
