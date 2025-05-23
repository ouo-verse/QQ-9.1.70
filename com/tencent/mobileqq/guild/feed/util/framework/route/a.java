package com.tencent.mobileqq.guild.feed.util.framework.route;

import androidx.annotation.MainThread;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "", "T", "Ljava/lang/Class;", "apiClass", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "clazz", DTConstants.TAG.API, "", "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    @MainThread
    <T> void a(@NotNull Class<T> clazz, T api);

    @MainThread
    @Nullable
    <T> T b(@NotNull Class<T> apiClass);
}
