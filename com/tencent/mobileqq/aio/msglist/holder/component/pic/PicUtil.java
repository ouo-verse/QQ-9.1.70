package com.tencent.mobileqq.aio.msglist.holder.component.pic;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ<\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J<\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J2\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J2\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u001e\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u001e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002J\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010$\u001a\u00020#J2\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b(\u0010*\u001a\u0004\b+\u0010,R\u0017\u00101\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010.\u001a\u0004\b/\u00100R\u0017\u00107\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010:\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u00100R\u0017\u0010=\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R\u001b\u0010A\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010?\u001a\u0004\b;\u0010@R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b8\u0010@R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010?\u001a\u0004\b3\u0010@R\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/pic/PicUtil;", "", "", "width", "height", "", "limitSize", "thumbMinSize", "thumbMaxSize", "Lkotlin/Pair;", DomainData.DOMAIN_NAME, "isDynamic", "isEmotion", "o", "j", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "size", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "g", "thumbWidth", "thumbHigh", h.F, "i", "a", "widthPx", "heightPx", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "viewHeight", ReportConstant.COSTREPORT_PREFIX, "viewWidth", "r", "", "path", "c", "imageWidth", "imageHeight", "b", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "I", "l", "()I", "screenWidth", "", "d", UserInfo.SEX_FEMALE, "getDensity", "()F", "density", "e", "getQuiIconColorToken", "quiIconColorToken", "f", "k", "quiIconSize", "Landroid/graphics/Bitmap;", "Lkotlin/Lazy;", "()Landroid/graphics/Bitmap;", "imgLoadingBitmap", "imgFailBitmap", "imgExpiredBitmap", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "picApi", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PicUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PicUtil f191410a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Resources resources;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int screenWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final float density;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int quiIconColorToken;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int quiIconSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy imgLoadingBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy imgFailBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy imgExpiredBitmap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IPicAIOApi picApi;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        f191410a = new PicUtil();
        Resources resources2 = BaseApplication.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
        resources = resources2;
        screenWidth = resources2.getDisplayMetrics().widthPixels;
        density = resources2.getDisplayMetrics().density;
        quiIconColorToken = R.color.qui_common_icon_tertiary;
        quiIconSize = ViewUtils.f352270a.a(28.0f);
        lazy = LazyKt__LazyJVMKt.lazy(PicUtil$imgLoadingBitmap$2.INSTANCE);
        imgLoadingBitmap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(PicUtil$imgFailBitmap$2.INSTANCE);
        imgFailBitmap = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(PicUtil$imgExpiredBitmap$2.INSTANCE);
        imgExpiredBitmap = lazy3;
        QRouteApi api = QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPicAIOApi::class.java)");
        picApi = (IPicAIOApi) api;
    }

    PicUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap d() {
        return (Bitmap) imgExpiredBitmap.getValue();
    }

    private final Bitmap e() {
        return (Bitmap) imgFailBitmap.getValue();
    }

    private final Bitmap f() {
        return (Bitmap) imgLoadingBitmap.getValue();
    }

    private final int j(boolean isEmotion, int width, int height) {
        if (!isEmotion) {
            width = p.a(width);
        }
        if (!isEmotion) {
            height = p.a(height);
        }
        return Math.max(width, height);
    }

    private final Pair<Integer, Integer> n(int width, int height, boolean limitSize, int thumbMinSize, int thumbMaxSize) {
        float f16;
        float f17;
        int coerceAtMost;
        int coerceAtMost2;
        if (width == 0 && height == 0) {
            width = thumbMaxSize;
            height = width;
        } else if (width >= thumbMinSize && height >= thumbMinSize) {
            if (width >= thumbMaxSize || height >= thumbMaxSize) {
                float f18 = thumbMaxSize;
                if (width > height) {
                    f16 = width;
                } else {
                    f16 = height;
                }
                float f19 = f18 / f16;
                float f26 = thumbMinSize;
                if (width > height) {
                    f17 = height;
                } else {
                    f17 = width;
                }
                float max = Math.max(f19, f26 / f17);
                width = (int) ((width * max) + 0.5f);
                height = (int) ((height * max) + 0.5f);
            }
        } else if (width < height) {
            int i3 = (int) ((height * (thumbMinSize / width)) + 0.5f);
            if (i3 > thumbMaxSize) {
                height = thumbMaxSize;
            } else {
                height = i3;
            }
            width = thumbMinSize;
        } else {
            width = (int) ((width * (thumbMinSize / height)) + 0.5f);
            if (width > thumbMaxSize) {
                width = thumbMaxSize;
            }
            height = thumbMinSize;
        }
        if (limitSize) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(width, thumbMaxSize);
            Integer valueOf = Integer.valueOf(coerceAtMost);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(height, thumbMaxSize);
            return new Pair<>(valueOf, Integer.valueOf(coerceAtMost2));
        }
        return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
    }

    private final Pair<Integer, Integer> o(int width, int height, boolean isDynamic, boolean isEmotion, boolean limitSize) {
        int j3 = j(isEmotion, width, height);
        IPicAIOApi iPicAIOApi = picApi;
        return n(width, height, limitSize, iPicAIOApi.getThumbMinDp(isDynamic, isEmotion, j3), iPicAIOApi.getThumbMaxDp(isDynamic, isEmotion, j3));
    }

    @NotNull
    public final Drawable a(int thumbWidth, int thumbHigh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(thumbWidth), Integer.valueOf(thumbHigh));
        }
        Resources resources2 = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getContext().resources");
        return new com.tencent.mobileqq.qqui.widget.a(resources2, d(), thumbWidth, thumbHigh, ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.j8b), quiIconColorToken);
    }

    @NotNull
    public final Pair<Integer, Integer> b(int imageWidth, int imageHeight, int viewWidth, int viewHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Pair) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(imageWidth), Integer.valueOf(imageHeight), Integer.valueOf(viewWidth), Integer.valueOf(viewHeight));
        }
        if (imageWidth > viewWidth && imageHeight > viewHeight) {
            if ((imageWidth * 1.0f) / imageHeight > (viewWidth * 1.0f) / viewHeight) {
                return new Pair<>(Integer.valueOf(s(imageWidth, imageHeight, viewHeight)), Integer.valueOf(viewHeight));
            }
            return new Pair<>(Integer.valueOf(viewWidth), Integer.valueOf(r(imageWidth, imageHeight, viewWidth)));
        }
        QLog.i("PicUtil", 1, "[getImageDecodeSize] small image, imageSize=" + imageWidth + "," + imageHeight + " viewSize=" + viewWidth + "," + viewHeight);
        return new Pair<>(Integer.valueOf(viewWidth), Integer.valueOf(viewHeight));
    }

    @NotNull
    public final Pair<Integer, Integer> c(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Pair) iPatchRedirector.redirect((short) 17, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        } catch (Exception e16) {
            QLog.i("PicUtil", 1, "[getImageSize] exc=" + e16);
            return new Pair<>(0, 0);
        }
    }

    @NotNull
    public final Drawable g(int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(width), Integer.valueOf(height));
        }
        Resources resources2 = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getContext().resources");
        return new com.tencent.mobileqq.qqui.widget.a(resources2, f(), width, height, ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.j8b), quiIconColorToken);
    }

    @NotNull
    public final Drawable h(int thumbWidth, int thumbHigh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(thumbWidth), Integer.valueOf(thumbHigh));
        }
        Resources resources2 = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getContext().resources");
        return new com.tencent.mobileqq.qqui.widget.a(resources2, e(), thumbWidth, thumbHigh, ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.j8b), quiIconColorToken);
    }

    @NotNull
    public final Drawable i(int thumbWidth, int thumbHigh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(thumbWidth), Integer.valueOf(thumbHigh));
        }
        Resources resources2 = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getContext().resources");
        return new com.tencent.mobileqq.qqui.widget.a(resources2, f(), thumbWidth, thumbHigh, new ColorDrawable(0), quiIconColorToken);
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return quiIconSize;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return screenWidth;
    }

    @NotNull
    public final Pair<Integer, Integer> m(int widthPx, int heightPx, boolean isDynamic, boolean isEmotion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Pair) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(widthPx), Integer.valueOf(heightPx), Boolean.valueOf(isDynamic), Boolean.valueOf(isEmotion));
        }
        Pair<Integer, Integer> o16 = o(widthPx, heightPx, isDynamic, isEmotion, false);
        return new Pair<>(Integer.valueOf(p.c(o16.getFirst().intValue())), Integer.valueOf(p.c(o16.getSecond().intValue())));
    }

    @NotNull
    public final Pair<Integer, Integer> p(int widthPx, int heightPx, boolean isDynamic, boolean isEmotion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(widthPx), Integer.valueOf(heightPx), Boolean.valueOf(isDynamic), Boolean.valueOf(isEmotion));
        }
        Pair<Integer, Integer> o16 = o(widthPx, heightPx, isDynamic, isEmotion, true);
        return new Pair<>(Integer.valueOf(p.c(o16.getFirst().intValue())), Integer.valueOf(p.c(o16.getSecond().intValue())));
    }

    public final boolean q(@NotNull PicSize size, @NotNull MsgElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) size, (Object) element)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.elementType == 2) {
            return new File(AIOPicDownloader.f190570a.p(element, size)).exists();
        }
        return false;
    }

    public final int r(int width, int height, int viewWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(viewWidth))).intValue();
        }
        return (int) ((height * ((viewWidth * 1.0f) / width)) + 0.5f);
    }

    public final int s(int width, int height, int viewHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(viewHeight))).intValue();
        }
        return (int) ((width * ((viewHeight * 1.0f) / height)) + 0.5f);
    }
}
