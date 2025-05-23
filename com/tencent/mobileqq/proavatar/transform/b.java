package com.tencent.mobileqq.proavatar.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.layer.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/proavatar/transform/b;", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "Landroid/graphics/Bitmap;", "avatar", VasProfileTemplatePreloadHelper.BACKGROUND, "", "clipPercent", "e", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "d", "([Lcom/tencent/qqnt/avatar/meta/info/a;)F", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Z", "bitmapArr", "b", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/qqnt/avatar/layer/c;", "c", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;Landroid/graphics/Bitmap;)Lcom/tencent/qqnt/avatar/layer/c;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements com.tencent.qqnt.avatar.meta.transform.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/proavatar/transform/b$a;", "", "", "DEFAULT_CLIP_PERCENT", UserInfo.SEX_FEMALE, "OUT_BOUND_SCALE_PERCENT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.transform.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float d(com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr) {
        boolean z16;
        if (avatarInfoArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0.25f;
        }
        Object b16 = avatarInfoArr[0].b(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_CLIP_PERCENT);
        if (!(b16 instanceof Integer)) {
            return 0.25f;
        }
        Number number = (Number) b16;
        if (number.intValue() <= 0 || number.intValue() >= 100) {
            return 0.25f;
        }
        return number.floatValue() / 100.0f;
    }

    private final Bitmap e(Bitmap avatar, Bitmap bg5, float clipPercent) {
        int max = Math.max(avatar.getWidth(), avatar.getHeight());
        int height = (avatar.getHeight() * 2) - avatar.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        float f16 = (max - height) / 2.0f;
        float f17 = (max + height) / 2.0f;
        RectF rectF = new RectF(f16, f16, f17, f17);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.save();
        path.addArc(rectF, 0.0f, 360.0f);
        canvas.clipPath(path);
        canvas.drawBitmap(bg5, new Rect(0, 0, bg5.getWidth(), bg5.getHeight()), rectF, paint);
        canvas.restore();
        path.reset();
        canvas.save();
        path.addRect(0.0f, 0.0f, avatar.getWidth(), avatar.getHeight() * (1 - clipPercent), Path.Direction.CW);
        path.addArc(rectF, 0.0f, 360.0f);
        canvas.clipPath(path);
        paint.setShader(null);
        Rect rect = new Rect(0, 0, avatar.getWidth(), avatar.getHeight());
        canvas.drawBitmap(avatar, rect, rect, paint);
        canvas.restore();
        return createBitmap;
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    public boolean a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean, (Object) avatarInfoArr)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        if (avatarBean.a() != 1 || !avatarBean.f(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, false)) {
            return false;
        }
        for (com.tencent.qqnt.avatar.meta.info.a aVar : avatarInfoArr) {
            if (Intrinsics.areEqual(aVar.b(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, avatarBean, avatarInfoArr, bitmapArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmapArr, "bitmapArr");
        if (bitmapArr.length < 2) {
            return null;
        }
        try {
            return e(bitmapArr[0], bitmapArr[1], d(avatarInfoArr));
        } catch (Exception e16) {
            QLog.e("ZPlanOutBoundTransform", 1, "merge zplan avatar error:", e16);
            return null;
        }
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public c c(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap bitmap) {
        int roundToInt;
        int roundToInt2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, this, avatarBean, avatarInfoArr, bitmap);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        roundToInt = MathKt__MathJVMKt.roundToInt(bitmap.getWidth() / 1.3f);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(bitmap.getHeight() / 1.3f);
        int width = (bitmap.getWidth() - roundToInt) / 2;
        int height = (bitmap.getHeight() - roundToInt2) / 2;
        return new c(new Rect(width, height, roundToInt + width, roundToInt2 + height), true, null, 4, null);
    }
}
