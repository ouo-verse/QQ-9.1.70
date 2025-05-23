package com.tencent.mobileqq.nearbypro.part;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/a;", "", "", "r3", "", "bh", "Landroidx/lifecycle/LifecycleOwner;", "c9", "Landroid/content/Context;", "getContext", "", "key", "data", "t5", "action", "e6", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    void bh();

    @NotNull
    LifecycleOwner c9();

    @Nullable
    Object e6(@NotNull String action, @Nullable Object data);

    @NotNull
    Context getContext();

    boolean r3();

    void t5(@NotNull String key, @Nullable Object data);
}
