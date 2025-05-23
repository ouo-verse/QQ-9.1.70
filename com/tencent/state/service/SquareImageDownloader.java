package com.tencent.state.service;

import android.content.Context;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/service/SquareImageDownloader;", "Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getStream", "Ljava/io/InputStream;", "imageUri", "", "extra", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareImageDownloader extends BaseImageDownloader {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareImageDownloader(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.nostra13.universalimageloader.core.download.BaseImageDownloader, com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String imageUri, Object extra) {
        FilamentAvatarCoverUri decode = FilamentAvatarCoverUri.INSTANCE.decode(imageUri);
        if (decode != null) {
            InputStream stream = super.getStream(decode.getRemoteUrl(), extra);
            Intrinsics.checkNotNullExpressionValue(stream, "super.getStream(cover.remoteUrl, extra)");
            return stream;
        }
        InputStream stream2 = super.getStream(imageUri, extra);
        Intrinsics.checkNotNullExpressionValue(stream2, "super.getStream(imageUri, extra)");
        return stream2;
    }
}
