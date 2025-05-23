package com.tencent.filament.zplan.app.api;

import android.view.TextureView;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&R\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "Lcom/tencent/filament/zplan/app/api/IEventTarget;", "Landroid/view/TextureView;", "getView", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "entry", "", "startWithEntry", "pause", "resume", "destroy", "Lsk0/a;", "getConfiguration", "()Lsk0/a;", "configuration", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IFilamentNativeAppV2305 extends IEventTarget {
    void destroy();

    @NotNull
    a getConfiguration();

    @NotNull
    TextureView getView();

    void pause();

    void resume();

    void startWithEntry(@Nullable c spanContext, @NotNull String entry);
}
