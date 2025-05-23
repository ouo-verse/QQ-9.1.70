package com.tencent.qqnt.qbasealbum.urldrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0010\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/DecoderUtil;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "Landroid/graphics/BitmapFactory$Options;", "opts", "", "reportTAG", "Landroid/graphics/Bitmap;", "c", "b", "", BasicAnimation.KeyPath.ROTATION, "", "degrees", "d", "localMediaInfo", "Lkotlin/Pair;", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DecoderUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DecoderUtil f361588a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f361588a = new DecoderUtil();
        }
    }

    DecoderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean b(@NotNull LocalMediaInfo info, @NotNull Bitmap b16, int rotation) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(b16, "b");
        if (rotation == 0 && b16.getWidth() == info.getThumbWidth() && b16.getHeight() == info.getThumbWidth() && b16.getConfig() == Bitmap.Config.RGB_565) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @Nullable
    public static final Bitmap c(@NotNull LocalMediaInfo info, @Nullable BitmapFactory.Options opts, @NotNull String reportTAG) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(reportTAG, "reportTAG");
        Bitmap bitmap = null;
        try {
            final SafeBitmapFactory.SafeDecodeOption safeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
            safeDecodeOption.inOptions = opts;
            safeDecodeOption.inNeedFlashBackTest = true;
            bitmap = SafeBitmapFactory.safeDecode(info.getPath(), safeDecodeOption);
            ox3.a.a(reportTAG, new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.DecoderUtil$realDecodeBitmap$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SafeBitmapFactory.SafeDecodeOption.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "ThumbDecoder regionDecodeInfo:" + SafeBitmapFactory.SafeDecodeOption.this;
                }
            });
            if (!safeDecodeOption.isInJustDecodeBounds && safeDecodeOption.needRegionDecode) {
                HashMap<String, String> decodeParams = safeDecodeOption.getInfo();
                Intrinsics.checkNotNullExpressionValue(decodeParams, "decodeParams");
                decodeParams.put("from", reportTAG);
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        return bitmap;
    }

    @JvmStatic
    @NotNull
    public static final Bitmap d(@NotNull Bitmap b16, int degrees) {
        Intrinsics.checkNotNullParameter(b16, "b");
        if (degrees != 0 && (!b16.isRecycled())) {
            Matrix matrix = new Matrix();
            float f16 = 2;
            matrix.setRotate(degrees, b16.getWidth() / f16, b16.getHeight() / f16);
            try {
                Bitmap b26 = Bitmap.createBitmap(b16, 0, 0, b16.getWidth(), b16.getHeight(), matrix, true);
                if (!Intrinsics.areEqual(b16, b26)) {
                    b16.recycle();
                    Intrinsics.checkNotNullExpressionValue(b26, "b2");
                    return b26;
                }
                return b16;
            } catch (OutOfMemoryError e16) {
                throw e16;
            }
        }
        return b16;
    }

    @NotNull
    public final Pair<Integer, Integer> a(@NotNull LocalMediaInfo localMediaInfo) {
        boolean z16;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo);
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        int g16 = com.tencent.qqnt.qbasealbum.utils.d.f361649a.g();
        float mediaWidth = localMediaInfo.getMediaWidth() / localMediaInfo.getMediaHeight();
        if (localMediaInfo.getRotation() != 90 && localMediaInfo.getRotation() != 270) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f16 = g16 * mediaWidth;
        } else {
            f16 = g16 / mediaWidth;
        }
        int i3 = (int) f16;
        if (i3 == 0) {
            i3 = g16;
        }
        return new Pair<>(Integer.valueOf(g16), Integer.valueOf(i3));
    }
}
