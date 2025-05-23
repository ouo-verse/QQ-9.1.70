package com.tencent.mobileqq.wink.editor.aielimination;

import android.graphics.Bitmap;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/IEditPicEliminateOpCallback;", "Ljava/io/Serializable;", "getOriginBitmap", "Landroid/graphics/Bitmap;", "onEliminateResult", "", "isDo", "", "resultBitmap", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface IEditPicEliminateOpCallback extends Serializable {
    @Nullable
    Bitmap getOriginBitmap();

    void onEliminateResult(boolean isDo, @Nullable Bitmap resultBitmap);
}
