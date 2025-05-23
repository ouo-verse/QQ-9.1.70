package ew0;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lew0/a;", "Lew0/e;", "", "p", "I", "getResId", "()I", "resId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "size", "Landroid/graphics/Bitmap;", "r", "Landroid/graphics/Bitmap;", h.F, "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/PointF;", "startPos", "endPos", "", "duration", "Lfw0/a;", "pathProvider", "Landroid/view/animation/Interpolator;", "interpolator", "<init>", "(IILandroid/graphics/PointF;Landroid/graphics/PointF;JLfw0/a;Landroid/view/animation/Interpolator;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends e {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int resId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int size;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i3, int i16, @NotNull PointF startPos, @NotNull PointF endPos, long j3, @NotNull fw0.a pathProvider, @NotNull Interpolator interpolator) {
        super(startPos, endPos, pathProvider, j3, interpolator);
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.resId = i3;
        this.size = i16;
        this.bitmap = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().m(i3, Utils.n(i16, BaseApplication.getContext().getResources()), Utils.n(i16, BaseApplication.getContext().getResources()));
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: i, reason: from getter */
    public final int getSize() {
        return this.size;
    }
}
