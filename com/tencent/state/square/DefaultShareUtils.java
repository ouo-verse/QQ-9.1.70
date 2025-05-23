package com.tencent.state.square;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/DefaultShareUtils;", "Lcom/tencent/state/square/IShareUtils;", "()V", "doShare", "", "uin", "", "contentPath", "contentType", "", "contentList", "", "operationList", "shareType", "(Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Integer;[Ljava/lang/Integer;Ljava/lang/Integer;)V", "getQrCode", "Landroid/graphics/Bitmap;", "shareLink", "imageSize", "imageMargin", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultShareUtils implements IShareUtils {
    @Override // com.tencent.state.square.IShareUtils
    public void doShare(@Nullable String uin, @NotNull String contentPath, int contentType, @Nullable Integer[] contentList, @Nullable Integer[] operationList, @Nullable Integer shareType) {
        Intrinsics.checkNotNullParameter(contentPath, "contentPath");
    }

    @Override // com.tencent.state.square.IShareUtils
    @Nullable
    public Bitmap getQrCode(@Nullable String shareLink, int imageSize, int imageMargin) {
        return null;
    }
}
