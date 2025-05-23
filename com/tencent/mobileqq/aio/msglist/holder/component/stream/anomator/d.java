package com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator;

import android.animation.Animator;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/d;", "", "Landroid/widget/TextView;", "textView", "Landroid/animation/Animator;", "animation", "", "originContent", "streamContent", "", "endIndex", "", "a", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface d {
    void a(@Nullable TextView textView, @Nullable Animator animation, @NotNull CharSequence originContent, @NotNull CharSequence streamContent, int endIndex);

    void onAnimationCancel(@Nullable Animator animation);

    void onAnimationEnd(@Nullable Animator animation);

    void onAnimationStart(@Nullable Animator animation);
}
