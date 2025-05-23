package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedStandardDialogApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "showFeedStandardDialog", "", "context", "Landroid/content/Context;", "dialogContent", "", "title", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IFeedStandardDialogApi extends QRouteApi {
    void showFeedStandardDialog(@NotNull Context context, @NotNull String dialogContent, @NotNull String title, @Nullable DialogInterface.OnDismissListener dismissListener);
}
