package com.tencent.state.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.state.SquareRuntime;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J>\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e0\u0010J>\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/utils/FaceUtils;", "", "()V", "loadAvatarWithNearbyTinyId", "", "view", "Landroid/widget/ImageView;", "tinyId", "", "loadHeadIcon", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "srcUin", "isTroop", "", "checker", "Lkotlin/Function1;", "loadQQAvatar", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FaceUtils {
    public static final FaceUtils INSTANCE = new FaceUtils();

    FaceUtils() {
    }

    private final void loadQQAvatar(IFaceDecoder avatarFaceDecoder, final ImageView view, String srcUin, boolean isTroop, final Function1<? super String, Boolean> checker) {
        Bitmap bitmapFromCache = avatarFaceDecoder.getBitmapFromCache(srcUin, isTroop);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            view.setImageBitmap(bitmapFromCache);
        } else {
            avatarFaceDecoder.setDecodeTaskCompletionListener(new IDecodeTaskCompletionListener() { // from class: com.tencent.state.utils.FaceUtils$loadQQAvatar$1
                @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
                public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
                    if (((Boolean) Function1.this.invoke(uin)).booleanValue()) {
                        if (avatar != null) {
                            view.setImageBitmap(avatar);
                        } else {
                            view.setImageResource(R.drawable.i9d);
                        }
                    }
                }
            });
            avatarFaceDecoder.requestDecodeFace(srcUin, isTroop);
        }
    }

    public final void loadHeadIcon(IFaceDecoder avatarFaceDecoder, ImageView view, String srcUin, boolean isTroop, Function1<? super String, Boolean> checker) {
        Intrinsics.checkNotNullParameter(avatarFaceDecoder, "avatarFaceDecoder");
        Intrinsics.checkNotNullParameter(srcUin, "srcUin");
        Intrinsics.checkNotNullParameter(checker, "checker");
        if (view != null) {
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                loadAvatarWithNearbyTinyId(view, srcUin);
            } else {
                loadQQAvatar(avatarFaceDecoder, view, srcUin, isTroop, checker);
            }
        }
    }

    private final void loadAvatarWithNearbyTinyId(ImageView view, String tinyId) {
        view.setImageResource(R.drawable.i9d);
        Square.INSTANCE.getConfig().getObtainInstanceHelper().getNearByProAvatarService().loadAvatarWithTinyId(view, tinyId);
    }
}
