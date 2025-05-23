package com.tencent.mobileqq.widget;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.tencent.richframework.argus.node.ArgusTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_qq_setting_me", testTags = {"AUTO_PRELOAD"})
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/widget/QQSettingMeRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawer-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QQSettingMeRelativeLayout extends RelativeLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeRelativeLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
