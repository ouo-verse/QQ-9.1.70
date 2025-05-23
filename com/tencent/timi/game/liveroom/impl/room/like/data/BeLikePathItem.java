package com.tencent.timi.game.liveroom.impl.room.like.data;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.liveroom.impl.room.like.LikeResourceMgr;
import com.tencent.timi.game.liveroom.impl.room.like.path.CurvePathProvider;
import fh4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/data/BeLikePathItem;", "Lcom/tencent/timi/game/liveroom/impl/room/like/data/MoveItem;", "resId", "", "likeResId", "", "size", "startPos", "Landroid/graphics/PointF;", "endPos", "duration", "", "pathProvider", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurvePathProvider;", "interpolator", "Landroid/view/animation/Interpolator;", "(ILjava/lang/String;ILandroid/graphics/PointF;Landroid/graphics/PointF;JLcom/tencent/timi/game/liveroom/impl/room/like/path/CurvePathProvider;Landroid/view/animation/Interpolator;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getResId", "()I", "getSize", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class BeLikePathItem extends MoveItem {

    @Nullable
    private Bitmap bitmap;
    private final int resId;
    private final int size;

    public /* synthetic */ BeLikePathItem(int i3, String str, int i16, PointF pointF, PointF pointF2, long j3, CurvePathProvider curvePathProvider, Interpolator interpolator, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, pointF, pointF2, j3, (i17 & 64) != 0 ? new CurvePathProvider(b.d(60), b.d(60), false, 4, null) : curvePathProvider, (i17 & 128) != 0 ? new LinearInterpolator() : interpolator);
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeLikePathItem(int i3, @NotNull String likeResId, int i16, @NotNull PointF startPos, @NotNull PointF endPos, long j3, @NotNull CurvePathProvider pathProvider, @NotNull Interpolator interpolator) {
        super(startPos, endPos, pathProvider, j3, interpolator);
        Bitmap likeImg;
        Intrinsics.checkNotNullParameter(likeResId, "likeResId");
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.resId = i3;
        this.size = i16;
        if (likeResId.length() > 0) {
            likeImg = LikeResourceMgr.INSTANCE.getLikeResBitmap(likeResId, Utils.n(i16, BaseApplication.getContext().getResources()), Utils.n(i16, BaseApplication.getContext().getResources()));
        } else {
            likeImg = LikeConfig.INSTANCE.getConfig().getLikeImg(i3, Utils.n(i16, BaseApplication.getContext().getResources()), Utils.n(i16, BaseApplication.getContext().getResources()));
        }
        this.bitmap = likeImg;
    }
}
