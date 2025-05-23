package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0002\f\u001fB,\u0012#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R1\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper;", "", "", "message", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "realWidth", "realHeight", "maxOutputWidth", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "orientation", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", CustomImageProps.QUALITY, "e", "filePath", "b", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "updateCallback", "I", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ImgQuality", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWImgCompressHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> updateCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int maxOutputWidth;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "", "outputWidth", "", "(Ljava/lang/String;II)V", "getOutputWidth", "()I", "DEFAULT", "STANDARD", "HIGH", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class ImgQuality {
        private static final /* synthetic */ ImgQuality[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ImgQuality DEFAULT;
        public static final ImgQuality HIGH;
        public static final ImgQuality STANDARD;
        private final int outputWidth;

        private static final /* synthetic */ ImgQuality[] $values() {
            return new ImgQuality[]{DEFAULT, STANDARD, HIGH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46693);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            DEFAULT = new ImgQuality("DEFAULT", 0, 540);
            STANDARD = new ImgQuality("STANDARD", 1, 1080);
            HIGH = new ImgQuality("HIGH", 2, 2160);
            $VALUES = $values();
        }

        ImgQuality(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.outputWidth = i16;
            }
        }

        public static ImgQuality valueOf(String str) {
            return (ImgQuality) Enum.valueOf(ImgQuality.class, str);
        }

        public static ImgQuality[] values() {
            return (ImgQuality[]) $VALUES.clone();
        }

        public final int getOutputWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.outputWidth;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$a;", "", "", "DEFAULT_MAX_OUTPUT_WIDTH", "I", "HIGH_MAX_OUTPUT_WIDTH", "STANDARD_MAX_OUTPUT_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWImgCompressHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46694);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HWImgCompressHelper(@NotNull Function1<? super BaseItem, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) updateCallback);
        } else {
            this.updateCallback = updateCallback;
            this.maxOutputWidth = ImgQuality.DEFAULT.getOutputWidth();
        }
    }

    private final int a(int realWidth, int realHeight, int maxOutputWidth) {
        int i3;
        int coerceAtLeast;
        int min = Math.min(realWidth, realHeight);
        if (min > maxOutputWidth) {
            i3 = min / maxOutputWidth;
        } else {
            i3 = 1;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 1);
        return Integer.highestOneBit(coerceAtLeast);
    }

    private final void c(String message, ImageItem item) {
        QLog.e("HW.MediaEdit.HWImgCompressHelper", 1, message);
        item.setState(UploadOrDownloadState.COMPRESS_ERR);
        this.updateCallback.invoke(item);
    }

    private final Bitmap d(Bitmap bitmap, int orientation) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
        }
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e16) {
            QLog.e("HW.MediaEdit.HWImgCompressHelper", 1, "Error rotating bitmap: " + e16);
            return null;
        }
    }

    @Nullable
    public final String b(@NotNull String filePath, @NotNull ImageItem item) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath, (Object) item);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(item, "item");
        Bitmap bitmap2 = null;
        try {
            VFSFile vFSFile = new VFSFile(TroopHWJsPlugin.L());
            if (!vFSFile.exists()) {
                vFSFile.mkdirs();
            }
            int a16 = a(item.getWidth(), item.getHeight(), this.maxOutputWidth);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(vFSFile.getAbsolutePath() + "/" + new File(filePath).getName());
            QLog.i("HW.MediaEdit.HWImgCompressHelper", 1, "Original image width = " + item.getWidth() + ", height = " + item.getHeight() + ", calInSampleSize = " + a16);
            int attributeInt = new ExifInterface(filePath).getAttributeInt("Orientation", 1);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = a16;
            bitmap = BitmapFactory.decodeFile(filePath, options);
            if (bitmap == null) {
                c("Failed to decode bitmap from file: " + filePath, item);
                return null;
            }
            try {
                try {
                    Bitmap d16 = d(bitmap, attributeInt);
                    if (d16 == null) {
                        c("Failed to rotate bitmap for file: " + filePath, item);
                        bitmap.recycle();
                        return null;
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(sDKPrivatePath);
                        try {
                            if (!d16.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                c("Bitmap compression failed for file: " + filePath, item);
                                CloseableKt.closeFinally(fileOutputStream, null);
                                d16.recycle();
                                return null;
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, null);
                            d16.recycle();
                            return sDKPrivatePath;
                        } finally {
                        }
                    } catch (Exception e16) {
                        e = e16;
                        bitmap = d16;
                        c("Error compressing image: " + e, item);
                        if (bitmap == null) {
                            return null;
                        }
                        bitmap.recycle();
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        bitmap2 = d16;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bitmap2 = bitmap;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception e18) {
            e = e18;
            bitmap = null;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public final void e(@NotNull ImgQuality quality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) quality);
        } else {
            Intrinsics.checkNotNullParameter(quality, "quality");
            this.maxOutputWidth = quality.getOutputWidth();
        }
    }
}
