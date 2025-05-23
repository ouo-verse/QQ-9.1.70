package com.tencent.state.square.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/api/IFaceDecoder;", "", "destroy", "", "getBitmapFromCache", "Landroid/graphics/Bitmap;", "uin", "", "isTroop", "", "requestDecodeFace", "setDecodeTaskCompletionListener", "listenerI", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IFaceDecoder {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Bitmap getBitmapFromCache$default(IFaceDecoder iFaceDecoder, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iFaceDecoder.getBitmapFromCache(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBitmapFromCache");
        }

        public static /* synthetic */ boolean requestDecodeFace$default(IFaceDecoder iFaceDecoder, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iFaceDecoder.requestDecodeFace(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestDecodeFace");
        }
    }

    void destroy();

    @Nullable
    Bitmap getBitmapFromCache(@NotNull String uin, boolean isTroop);

    boolean requestDecodeFace(@NotNull String uin, boolean isTroop);

    void setDecodeTaskCompletionListener(@NotNull IDecodeTaskCompletionListener listenerI);
}
