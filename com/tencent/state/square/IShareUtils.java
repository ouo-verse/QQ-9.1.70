package com.tencent.state.square;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J]\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/IShareUtils;", "", "doShare", "", "uin", "", "contentPath", "contentType", "", "contentList", "", "operationList", "source", "(Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Integer;[Ljava/lang/Integer;Ljava/lang/Integer;)V", "getQrCode", "Landroid/graphics/Bitmap;", "shareLink", "imageSize", "imageMargin", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IShareUtils {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void doShare$default(IShareUtils iShareUtils, String str, String str2, int i3, Integer[] numArr, Integer[] numArr2, Integer num, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    str = null;
                }
                if ((i16 & 2) != 0) {
                    str2 = "";
                }
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                if ((i16 & 8) != 0) {
                    numArr = null;
                }
                if ((i16 & 16) != 0) {
                    numArr2 = null;
                }
                if ((i16 & 32) != 0) {
                    num = null;
                }
                iShareUtils.doShare(str, str2, i3, numArr, numArr2, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doShare");
        }

        public static /* synthetic */ Bitmap getQrCode$default(IShareUtils iShareUtils, String str, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i3 = 540;
                }
                if ((i17 & 4) != 0) {
                    i16 = 0;
                }
                return iShareUtils.getQrCode(str, i3, i16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQrCode");
        }
    }

    void doShare(@Nullable String uin, @NotNull String contentPath, int contentType, @Nullable Integer[] contentList, @Nullable Integer[] operationList, @Nullable Integer source);

    @Nullable
    Bitmap getQrCode(@Nullable String shareLink, int imageSize, int imageMargin);
}
