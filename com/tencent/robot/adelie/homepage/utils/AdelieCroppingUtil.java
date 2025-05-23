package com.tencent.robot.adelie.homepage.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.kf.c;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.album.AdeliePreviewCustomization;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieUgcUtil;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/AdelieCroppingUtil;", "", "Landroid/graphics/Bitmap;", "source", "f", "g", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "maxSize", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", tl.h.F, "", "path", DomainData.DOMAIN_NAME, "o", "url", "k", "Lcom/tencent/robot/adelie/homepage/utils/AdelieCroppingUtil$a;", "e", "", "maxRatio", "d", "", "b", "J", "DELAY_TIME", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCroppingUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieCroppingUtil f366635a = new AdelieCroppingUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long DELAY_TIME = 100;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/AdelieCroppingUtil$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "c", "(Landroid/graphics/Bitmap;)V", "avatar", "b", "d", "cover", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class AdelieCroppedImageData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Bitmap avatar;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Bitmap cover;

        public AdelieCroppedImageData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Bitmap getAvatar() {
            return this.avatar;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Bitmap getCover() {
            return this.cover;
        }

        public final void c(@Nullable Bitmap bitmap) {
            this.avatar = bitmap;
        }

        public final void d(@Nullable Bitmap bitmap) {
            this.cover = bitmap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdelieCroppedImageData)) {
                return false;
            }
            AdelieCroppedImageData adelieCroppedImageData = (AdelieCroppedImageData) other;
            if (Intrinsics.areEqual(this.avatar, adelieCroppedImageData.avatar) && Intrinsics.areEqual(this.cover, adelieCroppedImageData.cover)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Bitmap bitmap = this.avatar;
            int i3 = 0;
            if (bitmap == null) {
                hashCode = 0;
            } else {
                hashCode = bitmap.hashCode();
            }
            int i16 = hashCode * 31;
            Bitmap bitmap2 = this.cover;
            if (bitmap2 != null) {
                i3 = bitmap2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "AdelieCroppedImageData(avatar=" + this.avatar + ", cover=" + this.cover + ")";
        }

        public AdelieCroppedImageData(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
            this.avatar = bitmap;
            this.cover = bitmap2;
        }

        public /* synthetic */ AdelieCroppedImageData(Bitmap bitmap, Bitmap bitmap2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : bitmap, (i3 & 2) != 0 ? null : bitmap2);
        }
    }

    AdelieCroppingUtil() {
    }

    private final Bitmap f(Bitmap source) {
        int i3;
        try {
            int width = source.getWidth();
            int height = source.getHeight();
            if (width != 0 && height != 0) {
                int min = Math.min(width, height);
                if (width > height) {
                    i3 = (width - height) / 2;
                } else {
                    i3 = 0;
                }
                Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawBitmap(source, new Rect(i3, 0, i3 + min, 0 + min), new Rect(0, 0, min, min), (Paint) null);
                return createBitmap;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("AdelieAvatarEditFragment", 1, "cropping avatar image error = " + e16);
            return null;
        }
    }

    private final Bitmap g(Bitmap source) {
        int coerceAtLeast;
        int coerceAtLeast2;
        try {
            int width = source.getWidth();
            int height = source.getHeight();
            if (width != 0 && height != 0) {
                float f16 = height;
                float f17 = width;
                float f18 = f16 / f17;
                if (f18 < 1.7777778f) {
                    int i3 = (int) (f16 / 1.7777778f);
                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((width - i3) / 2, 0);
                    return Bitmap.createBitmap(source, coerceAtLeast2, 0, i3, height);
                }
                if (f18 > 1.7777778f) {
                    int i16 = (int) (f17 * 1.7777778f);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((height - i16) / 2, 0);
                    return Bitmap.createBitmap(source, 0, coerceAtLeast, width, i16);
                }
                return source;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("AdelieAvatarEditFragment", 1, "cropping cover image error = " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(activity);
    }

    private final Bitmap j(Bitmap bitmap, int maxSize) {
        float f16;
        float f17;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= maxSize && height <= maxSize) {
            return bitmap;
        }
        if (width > height) {
            f16 = maxSize;
            f17 = width;
        } else {
            f16 = maxSize;
            f17 = height;
        }
        float f18 = f16 / f17;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * f18), (int) (height * f18), true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(bitma\u2026ewWidth, newHeight, true)");
        return createScaledBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Activity activity, Ref.ObjectRef tempPath) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(tempPath, "$tempPath");
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "activity.resources.displayMetrics");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(displayMetrics.widthPixels, displayMetrics.heightPixels);
        double d16 = ((coerceAtMost - 10) * 0.8f) + 0.5d;
        Intent cropActivity = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(activity, new Intent());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        cropActivity.putExtra(PeakConstants.CLIP_WIDTH, (int) d16);
        cropActivity.putExtra(PeakConstants.CLIP_HEIGHT, (int) ((d16 * 468.0d) / 334.0d));
        cropActivity.putExtra(PeakConstants.TARGET_WIDTH, 334);
        cropActivity.putExtra(PeakConstants.TARGET_HEIGHT, c.d.CTRL_INDEX);
        cropActivity.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        cropActivity.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String) tempPath.element);
        cropActivity.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        cropActivity.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
        cropActivity.putExtra(PeakConstants.COMPRESS_QUALITY, 70);
        cropActivity.putExtra(PeakConstants.TARGET_PATH, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/adelie/tmp/" + System.currentTimeMillis() + "_portrait_aio_background.tmp");
        activity.startActivityForResult(cropActivity, 135);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.String] */
    public static final void m(Ref.ObjectRef tempPath, final Runnable scopeTask, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(tempPath, "$tempPath");
        Intrinsics.checkNotNullParameter(scopeTask, "$scopeTask");
        if (loadState != LoadState.STATE_SUCCESS) {
            return;
        }
        QLog.i("AdelieUgcImageViewModel", 1, "load refer image success");
        String str = MobileQQ.sMobileQQ.getCacheDir().toString() + "/file/tmp";
        AdelieUgcUtil adelieUgcUtil = AdelieUgcUtil.f366571a;
        Bitmap resultBitMap = option.getResultBitMap();
        Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
        tempPath.element = adelieUgcUtil.l(resultBitMap, "result_origin.png", str);
        com.tencent.qqnt.adelie.homepage.utils.b.f348409a.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$starTemplateCropActivity$listener$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                scopeTask.run();
            }
        });
    }

    @NotNull
    public final Bitmap d(@NotNull Bitmap bitmap, int maxSize, float maxRatio) {
        float f16;
        float f17;
        int i3;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            if (width > height) {
                f16 = width;
                f17 = height;
            } else {
                f16 = height;
                f17 = width;
            }
            if (f16 / f17 > maxRatio) {
                int i16 = 0;
                if (width > height) {
                    int i17 = (int) (height * maxRatio);
                    int i18 = (width - i17) / 2;
                    width = i17;
                    i3 = 0;
                    i16 = i18;
                } else {
                    int i19 = (int) (width * maxRatio);
                    int i26 = (height - i19) / 2;
                    height = i19;
                    i3 = i26;
                }
                bitmap = Bitmap.createBitmap(bitmap, i16, i3, width, height);
            }
            Intrinsics.checkNotNullExpressionValue(bitmap, "croppedBitmap");
            return j(bitmap, maxSize);
        }
        return bitmap;
    }

    @NotNull
    public final AdelieCroppedImageData e(@NotNull Bitmap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new AdelieCroppedImageData(f(source), g(source));
    }

    public final void h(@NotNull final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ox3.a.g("AdelieCroppingUtil", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$preloadPeakProcess$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "[picker] initData";
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                AdelieCroppingUtil.i(activity);
            }
        }, 16, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(@NotNull final Activity activity, @Nullable String url) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (url == 0) {
            ox3.a.c("AdelieCroppingUtil", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$starTemplateCropActivity$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "startCoverCropActivity path is null";
                }
            });
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = url;
        final Runnable runnable = new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                AdelieCroppingUtil.l(activity, objectRef);
            }
        };
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (startsWith$default) {
            IPicLoadStateListener iPicLoadStateListener = new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.utils.g
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    AdelieCroppingUtil.m(Ref.ObjectRef.this, runnable, loadState, option);
                }
            };
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Option url2 = Option.obtain().setUrl(url);
            Intrinsics.checkNotNullExpressionValue(url2, "obtain().setUrl(url)");
            qQPicLoader.e(url2, iPicLoadStateListener);
            return;
        }
        runnable.run();
    }

    public final void n(@NotNull Activity activity, @Nullable String path) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (path == null) {
            ox3.a.c("AdelieCroppingUtil", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$startAvatarCropActivity$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "startAvatarCropActivity path is null";
                }
            });
            return;
        }
        ox3.a.g("AdeliePreviewCustomization", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$startAvatarCropActivity$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "startAvatarCropActivity AVATAR_CONFIG=" + AdeliePreviewCustomization.INSTANCE.a();
            }
        });
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "activity.resources.displayMetrics");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int i3 = (int) (((coerceAtMost - 10) * 0.8f) + 0.5d);
        Intent cropActivity = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(activity, new Intent());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        cropActivity.putExtra(PeakConstants.CLIP_WIDTH, i3);
        cropActivity.putExtra(PeakConstants.CLIP_HEIGHT, i3);
        AdeliePreviewCustomization.Companion companion = AdeliePreviewCustomization.INSTANCE;
        cropActivity.putExtra(PeakConstants.TARGET_WIDTH, companion.a().getCropSize());
        cropActivity.putExtra(PeakConstants.TARGET_HEIGHT, companion.a().getCropSize());
        cropActivity.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        cropActivity.putExtra("PhotoConst.SINGLE_PHOTO_PATH", path);
        cropActivity.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        cropActivity.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
        cropActivity.putExtra(PeakConstants.COMPRESS_QUALITY, companion.a().getCompressQuality());
        cropActivity.putExtra(PeakConstants.TARGET_PATH, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/adelie/tmp/" + System.currentTimeMillis() + "_portrait.tmp");
        activity.startActivityForResult(cropActivity, 134);
    }

    public final void o(@NotNull Activity activity, @Nullable String path) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (path == null) {
            ox3.a.c("AdelieCroppingUtil", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil$startCoverCropActivity$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "startCoverCropActivity path is null";
                }
            });
            return;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "activity.resources.displayMetrics");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(displayMetrics.widthPixels, displayMetrics.heightPixels);
        double d16 = ((coerceAtMost - 10) * 0.8f) + 0.5d;
        Intent cropActivity = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(activity, new Intent());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        cropActivity.putExtra(PeakConstants.CLIP_WIDTH, (int) d16);
        cropActivity.putExtra(PeakConstants.CLIP_HEIGHT, (int) ((d16 * 16.0d) / 9.0d));
        cropActivity.putExtra(PeakConstants.TARGET_WIDTH, 720);
        cropActivity.putExtra(PeakConstants.TARGET_HEIGHT, 1280);
        cropActivity.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        cropActivity.putExtra("PhotoConst.SINGLE_PHOTO_PATH", path);
        cropActivity.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        cropActivity.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
        cropActivity.putExtra(PeakConstants.COMPRESS_QUALITY, 70);
        cropActivity.putExtra(PeakConstants.TARGET_PATH, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/adelie/tmp/" + System.currentTimeMillis() + "_portrait_aio_background.tmp");
        activity.startActivityForResult(cropActivity, 135);
    }
}
