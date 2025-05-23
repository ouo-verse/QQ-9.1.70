package com.tencent.mobileqq.guild.feed.api.impl;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.feed.api.IFeedDebugFeatureApi;
import com.tencent.mobileqq.guild.feed.debug.FeedEditorSchemeDebugFragmentImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedDebugFeatureApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IFeedDebugFeatureApi;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/guild/feed/api/e;", "createFeedEditorSchemeDebugFragmentImpl", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDebugFeatureApiImpl implements IFeedDebugFeatureApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IFeedDebugFeatureApi
    @NotNull
    public com.tencent.mobileqq.guild.feed.api.e createFeedEditorSchemeDebugFragmentImpl(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new FeedEditorSchemeDebugFragmentImpl(fragment);
    }
}
