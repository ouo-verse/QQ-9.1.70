package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.guild.feed.api.IFeedStandardDialogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedStandardDialogApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IFeedStandardDialogApi;", "()V", "showFeedStandardDialog", "", "context", "Landroid/content/Context;", "dialogContent", "", "title", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class FeedStandardDialogApiImpl implements IFeedStandardDialogApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IFeedStandardDialogApi
    public void showFeedStandardDialog(@NotNull Context context, @NotNull String dialogContent, @NotNull String title, @Nullable DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogContent, "dialogContent");
        Intrinsics.checkNotNullParameter(title, "title");
        new com.tencent.mobileqq.guild.feed.nativepublish.utils.d(context, dialogContent, title, dismissListener).show();
    }
}
