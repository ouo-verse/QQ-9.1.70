package com.tencent.richframework.gallery.delegate.outer;

import com.tencent.libra.request.DecodeFormat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u00a8\u0006\u0003"}, d2 = {"getPicShowDecodeFormat", "Lcom/tencent/libra/request/DecodeFormat;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "function-gallery_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class IMediaShowStrategyProviderKt {
    @NotNull
    public static final DecodeFormat getPicShowDecodeFormat(@Nullable IMediaShowStrategyProvider iMediaShowStrategyProvider) {
        if (iMediaShowStrategyProvider != null && !iMediaShowStrategyProvider.useBitmapConfig8888()) {
            return DecodeFormat.PREFER_RGB_565;
        }
        return DecodeFormat.PREFER_ARGB_8888;
    }
}
