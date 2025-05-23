package com.tencent.state.square.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "", "onDecodeTaskCompleted", "", "remainingTasks", "", "type", "uin", "", "avatar", "Landroid/graphics/Bitmap;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IDecodeTaskCompletionListener {
    void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar);
}
