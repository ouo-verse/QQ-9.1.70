package com.tencent.mobileqq.qqlive.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqlive/utils/a;", "", "a", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J*\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rJ\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/utils/a$a;", "", "", "path", "", "c", "angle", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "f", "Landroid/graphics/BitmapFactory$Options;", "options", WadlProxyConsts.PARAM_FILENAME, "", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "e", "d", "filePath", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "doRotate", "b", "pathName", "opts", "a", "BUFFER_SIZE_DECODE_BITMAP", "I", "BUFFER_SIZE_DECODE_BOUND", "<init>", "()V", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final int c(String path) {
            try {
                Intrinsics.checkNotNull(path);
                int attributeInt = new ExifInterface(path).getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt != 8) {
                            return 0;
                        }
                        return 270;
                    }
                    return 90;
                }
                return 180;
            } catch (IOException e16) {
                e16.printStackTrace();
                return 0;
            }
        }

        private final Bitmap d(BitmapFactory.Options options, String fileName) {
            int i3 = 0;
            while (true) {
                if (i3 > 0 && options.inSampleSize > 7) {
                    return null;
                }
                try {
                    return a(fileName, options);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize++;
                    i3++;
                }
            }
        }

        private final Bitmap e(BitmapFactory.Options options, String fileName, boolean retry) {
            try {
                return a(fileName, options);
            } catch (OutOfMemoryError unused) {
                if (retry) {
                    return e(options, fileName, false);
                }
                return null;
            }
        }

        private final Bitmap f(int angle, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(angle);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        @Nullable
        public final Bitmap a(@Nullable String pathName, @Nullable BitmapFactory.Options opts) {
            FileInputStream fileInputStream;
            Bitmap decodeStream;
            Throwable th5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pathName, (Object) opts);
            }
            Bitmap bitmap = null;
            try {
                fileInputStream = new FileInputStream(pathName);
            } catch (Exception unused) {
                return bitmap;
            }
            try {
                try {
                    if (opts != null) {
                        try {
                            if (opts.inJustDecodeBounds) {
                                decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 2048), null, opts);
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileInputStream, null);
                                return decodeStream;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                CloseableKt.closeFinally(fileInputStream, th5);
                                throw th7;
                            }
                        }
                    }
                    CloseableKt.closeFinally(fileInputStream, null);
                    return decodeStream;
                } catch (Exception unused2) {
                    bitmap = decodeStream;
                    return bitmap;
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th8) {
                bitmap = decodeStream;
                th5 = th8;
                throw th5;
            }
            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, opts);
        }

        @Nullable
        public final Bitmap b(@Nullable String filePath, int maxWidth, int maxHeight, boolean doRotate) {
            int c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, this, filePath, Integer.valueOf(maxWidth), Integer.valueOf(maxHeight), Boolean.valueOf(doRotate));
            }
            if (!new File(filePath).exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            a(filePath, options);
            options.inJustDecodeBounds = false;
            int min = Math.min(options.outWidth / maxWidth, options.outHeight / maxHeight);
            if (min < 1) {
                min = 1;
            }
            options.inSampleSize = min;
            Bitmap e16 = e(options, filePath, true);
            if (e16 == null) {
                options.inSampleSize++;
                if (filePath != null) {
                    e16 = a.INSTANCE.d(options, filePath);
                } else {
                    e16 = null;
                }
            }
            if (e16 == null) {
                return null;
            }
            if (doRotate && (c16 = c(filePath)) != 0) {
                Bitmap f16 = f(c16, e16);
                e16.recycle();
                return f16;
            }
            return e16;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
