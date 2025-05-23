package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020\r\u00a2\u0006\u0004\b\u001f\u0010\"B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010$J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleColor;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/d;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/e;", "doodleItem", "Landroid/graphics/Paint;", "paint", "", DownloadInfo.spKey_Config, "copy", "", "a", "I", "mColor", "Landroid/graphics/Bitmap;", "b", "Landroid/graphics/Bitmap;", "mBitmap", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleColor$Type;", "c", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleColor$Type;", HttpMsg.MTYPE, "Landroid/graphics/Matrix;", "d", "Landroid/graphics/Matrix;", "mMatrix", "Landroid/graphics/Shader$TileMode;", "e", "Landroid/graphics/Shader$TileMode;", "mTileX", "f", "mTileY", "<init>", "()V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "(Landroid/graphics/Bitmap;)V", "color", "(I)V", "Type", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DoodleColor implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Bitmap mBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Type mType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Matrix mMatrix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Shader.TileMode mTileX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Shader.TileMode mTileY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleColor$Type;", "", "(Ljava/lang/String;I)V", "COLOR", "BITMAP", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum Type {
        COLOR,
        BITMAP
    }

    public DoodleColor() {
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        this.mTileX = tileMode;
        this.mTileY = tileMode;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.d
    public void config(@Nullable e doodleItem, @Nullable Paint paint) {
        Type type = this.mType;
        Bitmap bitmap = null;
        if (type == Type.COLOR) {
            Intrinsics.checkNotNull(paint);
            paint.setColor(this.mColor);
            paint.setShader(null);
        } else if (type == Type.BITMAP) {
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBitmap");
            } else {
                bitmap = bitmap2;
            }
            BitmapShader bitmapShader = new BitmapShader(bitmap, this.mTileX, this.mTileY);
            bitmapShader.setLocalMatrix(this.mMatrix);
            Intrinsics.checkNotNull(paint);
            paint.setShader(bitmapShader);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.d
    @Nullable
    public d copy() {
        DoodleColor doodleColor;
        if (this.mType == Type.COLOR) {
            doodleColor = new DoodleColor(this.mColor);
        } else {
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBitmap");
                bitmap = null;
            }
            doodleColor = new DoodleColor(bitmap);
        }
        doodleColor.mTileX = this.mTileX;
        doodleColor.mTileY = this.mTileY;
        doodleColor.mMatrix = new Matrix(this.mMatrix);
        return doodleColor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoodleColor(@NotNull Bitmap bitmap) {
        this();
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.mType = Type.BITMAP;
        this.mBitmap = bitmap;
    }

    public DoodleColor(int i3) {
        this();
        this.mType = Type.COLOR;
        this.mColor = i3;
    }
}
