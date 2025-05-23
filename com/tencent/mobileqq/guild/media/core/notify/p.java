package com.tencent.mobileqq.guild.media.core.notify;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J*\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J2\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J!\u0010\u000f\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/p;", "Lcom/tencent/mobileqq/guild/media/core/g;", "T", "Ljava/lang/Class;", "eventClz", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "listener", "", "V", "j", "Landroidx/lifecycle/LifecycleOwner;", "owner", "k0", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "event", "i", "(Lcom/tencent/mobileqq/guild/media/core/notify/x;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface p extends com.tencent.mobileqq.guild.media.core.g {
    <T> void V(@NotNull Class<T> eventClz, @NotNull o<T> listener);

    <T extends x> void i(@NotNull T event);

    <T> void j(@NotNull Class<T> eventClz, @NotNull o<T> listener);

    <T> void k0(@NotNull LifecycleOwner owner, @NotNull Class<T> eventClz, @NotNull o<T> listener);
}
