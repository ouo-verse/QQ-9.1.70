package com.tencent.minibox.dynamic.api;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/minibox/dynamic/api/IReceiverDelegate;", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface IReceiverDelegate {
    void onReceive(@NotNull Context context, @Nullable Intent intent);
}
