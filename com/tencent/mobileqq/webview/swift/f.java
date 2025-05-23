package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/f;", "Lcom/tencent/mobileqq/webview/swift/c;", "Landroid/content/Intent;", "intent", "", "url", ZPlanPublishSource.FROM_SCHEME, "", "providePreCreatePlugins", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface f extends c {
    @NotNull
    String[] providePreCreatePlugins(@NotNull Intent intent, @NotNull String url, @Nullable String scheme);
}
