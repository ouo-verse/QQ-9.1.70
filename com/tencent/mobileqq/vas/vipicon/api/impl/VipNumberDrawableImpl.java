package com.tencent.mobileqq.vas.vipicon.api.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.vipicon.NumberDownloadBusiness;
import com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable;
import com.tencent.state.data.SquareJSConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipNumberDrawable;", "", "itemId", "number", "", "isLongNumber", "isSmall", "Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "buildFileData", "Ljava/io/File;", "file", "Landroid/graphics/drawable/Drawable;", "loadDrawable", "newBigDrawable", "newSmallDrawable", "<init>", "()V", "a", "b", "c", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipNumberDrawableImpl implements IVipNumberDrawable {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$a;", "Lcom/tencent/mobileqq/vas/image/d;", "", "getIntrinsicHeight", "getIntrinsicWidth", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "d", "Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "getData", "()Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "data", "", "e", "Z", "isLongNumber", "f", "I", "getW", "()I", "w", "g", "getH", tl.h.F, "<init>", "(Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;Z)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends com.tencent.mobileqq.vas.image.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageFileData data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isLongNumber;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int w;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final int h;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(@NotNull ImageFileData data, boolean z16) {
            super(r0);
            Intrinsics.checkNotNullParameter(data, "data");
            ArrayList arrayList = new ArrayList();
            arrayList.add(data.getBgPath());
            Drawable icon = data.getIcon();
            Intrinsics.checkNotNull(icon);
            arrayList.add(icon);
            if (!z16) {
                arrayList.add(data.getNo());
            }
            arrayList.addAll(data.d());
            this.data = data;
            this.isLongNumber = z16;
            this.w = ImmersiveUtils.dpToPx(144.0f);
            this.h = ImmersiveUtils.dpToPx(32.0f);
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
            float f16;
            float f17;
            a aVar = this;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            int i3 = 0;
            if (bounds == null) {
                rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            } else {
                rect = bounds;
            }
            int width = rect.width();
            int height = rect.height();
            for (Drawable drawable : drawableStack) {
                if (Intrinsics.areEqual(drawable, aVar.data.getBgPath())) {
                    int i16 = (int) (height * 0.0625f);
                    drawable.getBounds().set(rect.left, rect.top + i16, rect.right, rect.bottom - i16);
                } else if (Intrinsics.areEqual(drawable, aVar.data.getIcon())) {
                    Rect bounds2 = drawable.getBounds();
                    int i17 = rect.left;
                    float f18 = width;
                    bounds2.set(((int) (0.027777778f * f18)) + i17, rect.top, i17 + ((int) (f18 * 0.25f)), rect.bottom);
                } else if (Intrinsics.areEqual(drawable, aVar.data.getNo())) {
                    Rect bounds3 = drawable.getBounds();
                    int i18 = rect.left;
                    float f19 = width;
                    int i19 = (int) (height * 0.1875f);
                    bounds3.set(((int) (0.2777778f * f19)) + i18, rect.top + i19, i18 + ((int) (f19 * 0.41666666f)), rect.bottom - i19);
                } else if (aVar.data.d().contains(drawable)) {
                    boolean z16 = aVar.isLongNumber;
                    if (z16) {
                        f16 = 22.0f;
                    } else {
                        f16 = 24.0f;
                    }
                    if (z16) {
                        f17 = 66.0f;
                    } else {
                        f17 = 120.0f;
                    }
                    Rect bounds4 = drawable.getBounds();
                    int i26 = rect.left;
                    float f26 = i3 * f16;
                    float f27 = width;
                    int i27 = (int) (height * 0.1875f);
                    bounds4.set(((int) (((f17 + f26) / 288.0f) * f27)) + i26, rect.top + i27, i26 + ((int) ((((f17 + f16) + f26) / 288.0f) * f27)), rect.bottom - i27);
                    i3++;
                }
                drawable.draw(canvas);
                aVar = this;
            }
        }

        @Override // com.tencent.mobileqq.vas.image.d, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.h;
        }

        @Override // com.tencent.mobileqq.vas.image.d, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.w;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$c;", "Lcom/tencent/mobileqq/vas/image/d;", "", "getIntrinsicHeight", "getIntrinsicWidth", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "d", "Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "getData", "()Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "data", "", "e", "Z", "isLongNumber", "f", "I", "getW", "()I", "w", "g", "getH", tl.h.F, "<init>", "(Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;Z)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends com.tencent.mobileqq.vas.image.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageFileData data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isLongNumber;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int w;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final int h;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(@NotNull ImageFileData data, boolean z16) {
            super(r0);
            Intrinsics.checkNotNullParameter(data, "data");
            ArrayList arrayList = new ArrayList();
            arrayList.add(data.getBgPath());
            if (!z16) {
                arrayList.add(data.getNo());
            }
            arrayList.addAll(data.d());
            this.data = data;
            this.isLongNumber = z16;
            this.w = ImmersiveUtils.dpToPx(108.0f);
            this.h = ImmersiveUtils.dpToPx(28.0f);
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
            float f16;
            float f17;
            c cVar = this;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            int i3 = 0;
            if (bounds == null) {
                rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            } else {
                rect = bounds;
            }
            int width = rect.width();
            int height = rect.height();
            for (Drawable drawable : drawableStack) {
                if (Intrinsics.areEqual(drawable, cVar.data.getBgPath())) {
                    drawable.getBounds().set(rect.left, rect.top, rect.right, rect.bottom);
                } else if (Intrinsics.areEqual(drawable, cVar.data.getNo())) {
                    Rect bounds2 = drawable.getBounds();
                    int i16 = rect.left;
                    float f18 = width;
                    int i17 = (int) (height * 0.14285715f);
                    bounds2.set(((int) (0.074074075f * f18)) + i16, rect.top + i17, i16 + ((int) (f18 * 0.25925925f)), rect.bottom - i17);
                } else if (cVar.data.d().contains(drawable)) {
                    boolean z16 = cVar.isLongNumber;
                    if (z16) {
                        f16 = 20.0f;
                    } else {
                        f16 = 24.0f;
                    }
                    if (z16) {
                        f17 = (216.0f - (9.0f * f16)) / 2.0f;
                    } else {
                        f17 = 64.0f;
                    }
                    float f19 = f17 + f16;
                    Rect bounds3 = drawable.getBounds();
                    int i18 = rect.left;
                    float f26 = i3 * f16;
                    float f27 = width;
                    int i19 = (int) (height * 0.14285715f);
                    bounds3.set(((int) (((f17 + f26) / 216.0f) * f27)) + i18, rect.top + i19, i18 + ((int) (((f19 + f26) / 216.0f) * f27)), rect.bottom - i19);
                    i3++;
                }
                drawable.draw(canvas);
                cVar = this;
            }
        }

        @Override // com.tencent.mobileqq.vas.image.d, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.h;
        }

        @Override // com.tencent.mobileqq.vas.image.d, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.w;
        }
    }

    private final ImageFileData buildFileData(int itemId, int number, boolean isLongNumber, boolean isSmall) {
        String str;
        Drawable drawable;
        if (itemId == 0) {
            return null;
        }
        NumberDownloadBusiness numberDownloadBusiness = (NumberDownloadBusiness) QQVasUpdateBusiness.getBusiness(NumberDownloadBusiness.class);
        if (!numberDownloadBusiness.isFileExists(itemId)) {
            VasLogNtReporter.INSTANCE.getVipNumber().reportLow("id[" + itemId + "] file not Exist");
            numberDownloadBusiness.startDownload(itemId);
            return null;
        }
        String savePath = numberDownloadBusiness.getSavePath(itemId);
        if (isSmall) {
            str = "bg.png";
        } else {
            str = "bg_big.png";
        }
        Drawable loadDrawable = loadDrawable(new File(savePath, str));
        if (!isSmall) {
            drawable = loadDrawable(new File(savePath, "icon.png"));
        } else {
            drawable = null;
        }
        ImageFileData imageFileData = new ImageFileData(loadDrawable, drawable, loadDrawable(new File(savePath, "tag.png")), null, 8, null);
        int i3 = 0;
        if (isLongNumber) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%09d", Arrays.copyOf(new Object[]{Integer.valueOf(number)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            if (format.length() > 9) {
                VasLogNtReporter.INSTANCE.getVipNumber().reportHighest("number[" + number + "] oversize");
                return null;
            }
            while (i3 < format.length()) {
                char charAt = format.charAt(i3);
                imageFileData.d().add(loadDrawable(new File(savePath, "num_" + charAt + ".png")));
                i3++;
            }
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%06d", Arrays.copyOf(new Object[]{Integer.valueOf(number)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            if (format2.length() > 6) {
                VasLogNtReporter.INSTANCE.getVipNumber().reportHighest("number[" + number + "] oversize");
                return null;
            }
            while (i3 < format2.length()) {
                char charAt2 = format2.charAt(i3);
                imageFileData.d().add(loadDrawable(new File(savePath, "num_" + charAt2 + ".png")));
                i3++;
            }
        }
        return imageFileData;
    }

    static /* synthetic */ ImageFileData buildFileData$default(VipNumberDrawableImpl vipNumberDrawableImpl, int i3, int i16, boolean z16, boolean z17, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z17 = false;
        }
        return vipNumberDrawableImpl.buildFileData(i3, i16, z16, z17);
    }

    private final Drawable loadDrawable(File file) {
        final String imgPath = file.getAbsolutePath();
        a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        Intrinsics.checkNotNullExpressionValue(imgPath, "imgPath");
        FastDynamicDrawable a17 = a16.d(imgPath).a();
        a17.I(false);
        a17.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.api.impl.VipNumberDrawableImpl$loadDrawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    VasLogNtReporter.INSTANCE.getVipNumber().reportLow("load " + imgPath + " end [" + Thread.currentThread() + "]");
                }
            }
        });
        return a17;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable
    @Nullable
    public Drawable newBigDrawable(int itemId, int number, boolean isLongNumber) {
        ImageFileData buildFileData$default = buildFileData$default(this, itemId, number, isLongNumber, false, 8, null);
        if (buildFileData$default == null) {
            return null;
        }
        return new a(buildFileData$default, isLongNumber);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable
    @Nullable
    public Drawable newSmallDrawable(int itemId, int number, boolean isLongNumber) {
        ImageFileData buildFileData = buildFileData(itemId, number, isLongNumber, true);
        if (buildFileData == null) {
            return null;
        }
        return new c(buildFileData, isLongNumber);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR'\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipNumberDrawableImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "setBgPath", "(Landroid/graphics/drawable/Drawable;)V", "bgPath", "b", "setIcon", "icon", "c", "setNo", "no", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", SquareJSConst.Params.PARAMS_NUMS, "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Ljava/util/ArrayList;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.vipicon.api.impl.VipNumberDrawableImpl$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class ImageFileData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Drawable bgPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Drawable icon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Drawable no;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<Drawable> nums;

        public ImageFileData(@NotNull Drawable bgPath, @Nullable Drawable drawable, @NotNull Drawable no5, @NotNull ArrayList<Drawable> nums) {
            Intrinsics.checkNotNullParameter(bgPath, "bgPath");
            Intrinsics.checkNotNullParameter(no5, "no");
            Intrinsics.checkNotNullParameter(nums, "nums");
            this.bgPath = bgPath;
            this.icon = drawable;
            this.no = no5;
            this.nums = nums;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Drawable getBgPath() {
            return this.bgPath;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Drawable getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Drawable getNo() {
            return this.no;
        }

        @NotNull
        public final ArrayList<Drawable> d() {
            return this.nums;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageFileData)) {
                return false;
            }
            ImageFileData imageFileData = (ImageFileData) other;
            if (Intrinsics.areEqual(this.bgPath, imageFileData.bgPath) && Intrinsics.areEqual(this.icon, imageFileData.icon) && Intrinsics.areEqual(this.no, imageFileData.no) && Intrinsics.areEqual(this.nums, imageFileData.nums)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.bgPath.hashCode() * 31;
            Drawable drawable = this.icon;
            if (drawable == null) {
                hashCode = 0;
            } else {
                hashCode = drawable.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.no.hashCode()) * 31) + this.nums.hashCode();
        }

        @NotNull
        public String toString() {
            return "ImageFileData(bgPath=" + this.bgPath + ", icon=" + this.icon + ", no=" + this.no + ", nums=" + this.nums + ")";
        }

        public /* synthetic */ ImageFileData(Drawable drawable, Drawable drawable2, Drawable drawable3, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(drawable, drawable2, drawable3, (i3 & 8) != 0 ? new ArrayList() : arrayList);
        }
    }
}
