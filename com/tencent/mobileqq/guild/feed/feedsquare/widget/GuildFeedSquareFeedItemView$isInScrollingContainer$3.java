package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewParent;", "kotlin.jvm.PlatformType", "invoke", "(Landroid/view/ViewParent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildFeedSquareFeedItemView$isInScrollingContainer$3 extends Lambda implements Function1<ViewParent, Boolean> {
    public static final GuildFeedSquareFeedItemView$isInScrollingContainer$3 INSTANCE = new GuildFeedSquareFeedItemView$isInScrollingContainer$3();

    GuildFeedSquareFeedItemView$isInScrollingContainer$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(ViewParent viewParent) {
        while (viewParent != null && (viewParent instanceof ViewGroup)) {
            if (((ViewGroup) viewParent).shouldDelayChildPressedState()) {
                return Boolean.TRUE;
            }
            viewParent = viewParent.getParent();
        }
        return Boolean.FALSE;
    }
}
