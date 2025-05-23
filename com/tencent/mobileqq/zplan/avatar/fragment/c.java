package com.tencent.mobileqq.zplan.avatar.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.zplan.avatar.edit.AvatarCropV2Param;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/fragment/c;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "d", "", "srcPicPath", "desPicDirPath", "", "a", "Lcom/tencent/mobileqq/zplan/avatar/fragment/c$a;", "cropParam", "b", "Lcom/tencent/mobileqq/zplan/avatar/edit/a;", "param", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f331748a = new c();

    c() {
    }

    private final boolean a(String srcPicPath, String desPicDirPath) {
        if (!(srcPicPath.length() == 0)) {
            if (!(desPicDirPath.length() == 0) && new File(srcPicPath).exists() && new File(srcPicPath).isFile()) {
                File file = new File(desPicDirPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return true;
            }
        }
        return false;
    }

    private final void d(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public final String b(AvatarCropParam cropParam) {
        Intrinsics.checkNotNullParameter(cropParam, "cropParam");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            if (!a(cropParam.getSrcPicPath(), cropParam.getDesPicDirPath())) {
                QLog.e("ZPlanAvatarCropUtils", 1, "cropPic failed, type: " + cropParam.getType());
                return "";
            }
            Bitmap safeDecode = SafeBitmapFactory.safeDecode(cropParam.getSrcPicPath(), options);
            if (safeDecode == null) {
                return "";
            }
            int width = safeDecode.getWidth();
            int height = safeDecode.getHeight();
            double width2 = safeDecode.getWidth() / 1.3d;
            int topRate = (int) (cropParam.getTopRate() * width2);
            int bottomRate = (int) (cropParam.getBottomRate() * width2);
            int leftRate = (int) (cropParam.getLeftRate() * width2);
            int rightRate = (int) (width2 * cropParam.getRightRate());
            new Rect();
            Bitmap copy = Bitmap.createBitmap(safeDecode, leftRate, topRate, (safeDecode.getWidth() - leftRate) - rightRate, (safeDecode.getHeight() - topRate) - bottomRate).copy(safeDecode.getConfig(), true);
            if (copy == null) {
                return "";
            }
            if (cropParam.getType() == 1) {
                height -= bottomRate;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(copy, width, height, true);
            if (createScaledBitmap == null) {
                return "";
            }
            File file = new File(cropParam.getDesPicDirPath(), cropParam.getActionId() + ".png");
            if (file.exists()) {
                file.delete();
            }
            boolean a16 = com.tencent.biz.qqstory.utils.b.a(createScaledBitmap, Bitmap.CompressFormat.PNG, 100, file.getAbsolutePath());
            d(safeDecode);
            d(copy);
            d(createScaledBitmap);
            if (!a16) {
                return "";
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "{\n                desPic\u2026bsolutePath\n            }");
            return absolutePath;
        } catch (Throwable th5) {
            QLog.e("ZPlanAvatarCropUtils", 1, "cropPic failed, t: " + th5);
            return "";
        }
    }

    public final String c(AvatarCropV2Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap safeDecode = SafeBitmapFactory.safeDecode(param.getSrcPicPath(), options);
        if (safeDecode == null) {
            return "";
        }
        int startX = (int) param.getStartX();
        int startY = (int) param.getStartY();
        Rect rect = new Rect(startX, startY, (int) (startX + param.getWidth()), (int) (startY + param.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap((int) param.getWidth(), (int) param.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return "";
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(safeDecode, rect, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), (Paint) null);
        canvas.save();
        File file = new File(param.getDesPicDirPath(), param.getActionId() + ".png");
        if (file.exists()) {
            file.delete();
        }
        boolean a16 = com.tencent.biz.qqstory.utils.b.a(createBitmap, Bitmap.CompressFormat.PNG, 100, file.getAbsolutePath());
        d(safeDecode);
        d(createBitmap);
        if (!a16) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "{\n            desPicFile.absolutePath\n        }");
        return absolutePath;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0015\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\tB]\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\t\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/fragment/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "srcPicPath", "b", "c", "desPicDirPath", "", "D", "g", "()D", "topRate", "d", "bottomRate", "e", "leftRate", "rightRate", "getAppearanceKey", "appearanceKey", h.F, "I", "()I", "actionId", "i", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDDDLjava/lang/String;II)V", "j", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.fragment.c$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class AvatarCropParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String srcPicPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String desPicDirPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final double topRate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final double bottomRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final double leftRate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final double rightRate;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final String appearanceKey;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int actionId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        public AvatarCropParam(String srcPicPath, String desPicDirPath, double d16, double d17, double d18, double d19, String str, int i3, int i16) {
            Intrinsics.checkNotNullParameter(srcPicPath, "srcPicPath");
            Intrinsics.checkNotNullParameter(desPicDirPath, "desPicDirPath");
            this.srcPicPath = srcPicPath;
            this.desPicDirPath = desPicDirPath;
            this.topRate = d16;
            this.bottomRate = d17;
            this.leftRate = d18;
            this.rightRate = d19;
            this.appearanceKey = str;
            this.actionId = i3;
            this.type = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getActionId() {
            return this.actionId;
        }

        /* renamed from: b, reason: from getter */
        public final double getBottomRate() {
            return this.bottomRate;
        }

        /* renamed from: c, reason: from getter */
        public final String getDesPicDirPath() {
            return this.desPicDirPath;
        }

        /* renamed from: d, reason: from getter */
        public final double getLeftRate() {
            return this.leftRate;
        }

        /* renamed from: e, reason: from getter */
        public final double getRightRate() {
            return this.rightRate;
        }

        /* renamed from: f, reason: from getter */
        public final String getSrcPicPath() {
            return this.srcPicPath;
        }

        /* renamed from: g, reason: from getter */
        public final double getTopRate() {
            return this.topRate;
        }

        /* renamed from: h, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.srcPicPath.hashCode() * 31) + this.desPicDirPath.hashCode()) * 31) + com.tencent.mobileqq.zootopia.webview.f.a(this.topRate)) * 31) + com.tencent.mobileqq.zootopia.webview.f.a(this.bottomRate)) * 31) + com.tencent.mobileqq.zootopia.webview.f.a(this.leftRate)) * 31) + com.tencent.mobileqq.zootopia.webview.f.a(this.rightRate)) * 31;
            String str = this.appearanceKey;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actionId) * 31) + this.type;
        }

        public String toString() {
            return "AvatarCropParam(srcPicPath=" + this.srcPicPath + ", desPicDirPath=" + this.desPicDirPath + ", topRate=" + this.topRate + ", bottomRate=" + this.bottomRate + ", leftRate=" + this.leftRate + ", rightRate=" + this.rightRate + ", appearanceKey=" + this.appearanceKey + ", actionId=" + this.actionId + ", type=" + this.type + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarCropParam)) {
                return false;
            }
            AvatarCropParam avatarCropParam = (AvatarCropParam) other;
            return Intrinsics.areEqual(this.srcPicPath, avatarCropParam.srcPicPath) && Intrinsics.areEqual(this.desPicDirPath, avatarCropParam.desPicDirPath) && Double.compare(this.topRate, avatarCropParam.topRate) == 0 && Double.compare(this.bottomRate, avatarCropParam.bottomRate) == 0 && Double.compare(this.leftRate, avatarCropParam.leftRate) == 0 && Double.compare(this.rightRate, avatarCropParam.rightRate) == 0 && Intrinsics.areEqual(this.appearanceKey, avatarCropParam.appearanceKey) && this.actionId == avatarCropParam.actionId && this.type == avatarCropParam.type;
        }
    }
}
