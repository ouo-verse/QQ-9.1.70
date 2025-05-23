package com.tencent.guild.aio.msglist.text.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/b;", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Path;", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", "[F", "getRadii", "()[F", "b", "([F)V", "radii", "", "value", UserInfo.SEX_FEMALE, "getRadius", "()F", "c", "(F)V", "radius", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/graphics/Bitmap;)V", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends BitmapDrawable {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f111937d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] radii;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float radius;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/b$a;", "", "", "LEFT_BOTTOM_DX", "I", "LEFT_BOTTOM_DY", "LEFT_TOP_DX", "LEFT_TOP_DY", "RIGHT_BOTTOM_DX", "RIGHT_BOTTOM_DY", "RIGHT_TOP_DX", "RIGHT_TOP_DY", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Bitmap bitmap) {
        super(bitmap);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = 0.0f;
        }
        this.radii = fArr;
        this.mPath = new Path();
    }

    private final Path a() {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        int width = bounds.width();
        int height = bounds.height();
        Path path = this.mPath;
        path.reset();
        path.moveTo(bounds.left + this.radii[0], bounds.top);
        float f16 = width;
        float[] fArr = this.radii;
        path.rLineTo((f16 - fArr[0]) - fArr[2], 0.0f);
        float[] fArr2 = this.radii;
        float f17 = fArr2[2];
        path.rQuadTo(f17, 0.0f, f17, fArr2[3]);
        float f18 = height;
        float[] fArr3 = this.radii;
        path.rLineTo(0.0f, (f18 - fArr3[3]) - fArr3[5]);
        float[] fArr4 = this.radii;
        float f19 = fArr4[5];
        path.rQuadTo(0.0f, f19, -fArr4[4], f19);
        float[] fArr5 = this.radii;
        path.rLineTo((fArr5[6] + fArr5[4]) - f16, 0.0f);
        float[] fArr6 = this.radii;
        float f26 = fArr6[6];
        path.rQuadTo(-f26, 0.0f, -f26, -fArr6[7]);
        float[] fArr7 = this.radii;
        path.rLineTo(0.0f, (fArr7[7] + fArr7[1]) - f18);
        float[] fArr8 = this.radii;
        float f27 = fArr8[1];
        path.rQuadTo(0.0f, -f27, fArr8[0], -f27);
        path.close();
        return path;
    }

    public final void b(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.radii = fArr;
    }

    public final void c(float f16) {
        this.radius = f16;
        int length = this.radii.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.radii[i3] = f16;
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        canvas.clipPath(a());
        super.draw(canvas);
        canvas.restore();
    }
}
