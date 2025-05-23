package com.tencent.mobileqq.zplan.meme.frameanim;

import android.content.res.Configuration;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&J\u0014\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u0002H&J\b\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\u0002H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\nH&J\b\u0010 \u001a\u00020\u0002H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/g;", "", "", "resume", "pause", "stop", "release", "", "onTabQzone", "d", "", "scene", "g", "show", "f", tl.h.F, "j", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "avatarOverlayViewWiringHelper", "i", "b", "onAccountChanged", "onThemeChange", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/zplan/meme/frameanim/d;", "listener", "k", "type", "c", "e", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface g {
    void a();

    void b();

    void c(int type);

    void d(boolean onTabQzone);

    int e();

    void f(boolean show);

    boolean g(int scene);

    @Nullable
    Object h();

    void i(@Nullable e avatarOverlayViewWiringHelper);

    @Nullable
    Object j();

    void k(@NotNull d listener);

    void onAccountChanged();

    void onConfigurationChanged(@NotNull Configuration newConfig);

    void onThemeChange();

    void pause();

    void release();

    void resume();

    void stop();
}
