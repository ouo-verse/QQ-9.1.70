package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.highlight;

import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import dq0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/highlight/CommentHighlightAbility;", "", "Landroid/view/View;", "view", "", "bgRes", "", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentHighlightAbility {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommentHighlightAbility f220918a = new CommentHighlightAbility();

    CommentHighlightAbility() {
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        b.INSTANCE.b(view);
    }

    public final void b(@NotNull final View view, @DrawableRes @ColorRes final int bgRes) {
        Intrinsics.checkNotNullParameter(view, "view");
        b.Companion.d(b.INSTANCE, view, 900L, 0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.highlight.CommentHighlightAbility$highLightItemView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                view.setBackgroundResource(bgRes);
            }
        }, 4, null);
    }
}
