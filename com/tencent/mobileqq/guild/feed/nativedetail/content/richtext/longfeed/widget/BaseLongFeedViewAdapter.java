package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/g;", "", "l", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "k", "", "j", "Landroid/view/View;", "view", "", "g", tl.h.F, "<init>", "()V", "a", "TYPE", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class BaseLongFeedViewAdapter implements com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO_COVER", "VIDEO", "THIRD_VIDEO", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum TYPE {
        IMAGE,
        VIDEO_COVER,
        VIDEO,
        THIRD_VIDEO
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void g(@Nullable View view) {
        if (view != null) {
            yl1.b.h(yl1.b.f450589a, view, "em_sgrp_forum_full_screen", null, 4, null);
        }
    }

    @NotNull
    public abstract String j();

    @NotNull
    public abstract TYPE k();

    public abstract boolean l();

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void h(@Nullable View view) {
    }
}
