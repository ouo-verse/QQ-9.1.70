package com.tencent.mobileqq.vas.vipicon;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 -2\u00020\u0001:\u0003./0B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0010\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0003R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable;", "Lcom/tencent/mobileqq/vas/image/c;", "", "I", "", "imgPath", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "block", "G", "H", "", "isAsync", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable$b;", "E", "setLoadedListener", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "d", "Ljava/lang/String;", "scene", "e", "Lkotlin/jvm/functions/Function1;", "loadCallback", "f", "Landroid/graphics/drawable/Drawable;", "bgImg", tl.h.F, "fgImg", "", "i", "[Landroid/graphics/drawable/Drawable;", "letterImgs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "totalImgSize", "Ljava/util/concurrent/atomic/AtomicInteger;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicInteger;", "loadNum", "<init>", "(Ljava/lang/String;)V", "D", "a", "b", "c", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class AbsLetterScrollDrawable extends com.tencent.mobileqq.vas.image.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger loadNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super AbsLetterScrollDrawable, Unit> loadCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable bgImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable fgImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Drawable[] letterImgs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int totalImgSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "bgPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "letterPaths", "e", "fgPath", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class ImageFileData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String bgPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<String> letterPaths;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String fgPath;

        public ImageFileData() {
            this(null, null, null, 7, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBgPath() {
            return this.bgPath;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFgPath() {
            return this.fgPath;
        }

        @NotNull
        public final ArrayList<String> c() {
            return this.letterPaths;
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bgPath = str;
        }

        public final void e(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fgPath = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageFileData)) {
                return false;
            }
            ImageFileData imageFileData = (ImageFileData) other;
            if (Intrinsics.areEqual(this.bgPath, imageFileData.bgPath) && Intrinsics.areEqual(this.letterPaths, imageFileData.letterPaths) && Intrinsics.areEqual(this.fgPath, imageFileData.fgPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.bgPath.hashCode() * 31) + this.letterPaths.hashCode()) * 31) + this.fgPath.hashCode();
        }

        @NotNull
        public String toString() {
            return "ImageFileData(bgPath=" + this.bgPath + ", letterPaths=" + this.letterPaths + ", fgPath=" + this.fgPath + ")";
        }

        public ImageFileData(@NotNull String bgPath, @NotNull ArrayList<String> letterPaths, @NotNull String fgPath) {
            Intrinsics.checkNotNullParameter(bgPath, "bgPath");
            Intrinsics.checkNotNullParameter(letterPaths, "letterPaths");
            Intrinsics.checkNotNullParameter(fgPath, "fgPath");
            this.bgPath = bgPath;
            this.letterPaths = letterPaths;
            this.fgPath = fgPath;
        }

        public /* synthetic */ ImageFileData(String str, ArrayList arrayList, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? "" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\u0004\b&\u0010'J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010#\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010%\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable$c;", "Lcom/tencent/mobileqq/vas/image/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "d", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "", "e", "[Landroid/graphics/drawable/Drawable;", "letterDrawables", "f", "foregroundDrawable", "", "g", UserInfo.SEX_FEMALE, "getAnimProgress", "()F", "setAnimProgress", "(F)V", "animProgress", tl.h.F, "letterWidth", "i", "letterDel", "j", "letterStartX", "k", "letterEndX", "l", "letterDelY", "<init>", "(Landroid/graphics/drawable/Drawable;[Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends com.tencent.mobileqq.vas.image.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable backgroundDrawable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable[] letterDrawables;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable foregroundDrawable;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float animProgress;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final float letterWidth;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final float letterDel;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final float letterStartX;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final float letterEndX;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final float letterDelY;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(@NotNull Drawable backgroundDrawable, @NotNull Drawable[] letterDrawables, @NotNull Drawable foregroundDrawable) {
            super(r0);
            Intrinsics.checkNotNullParameter(backgroundDrawable, "backgroundDrawable");
            Intrinsics.checkNotNullParameter(letterDrawables, "letterDrawables");
            Intrinsics.checkNotNullParameter(foregroundDrawable, "foregroundDrawable");
            ArrayList arrayList = new ArrayList();
            arrayList.add(backgroundDrawable);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, letterDrawables);
            arrayList.add(foregroundDrawable);
            this.backgroundDrawable = backgroundDrawable;
            this.letterDrawables = letterDrawables;
            this.foregroundDrawable = foregroundDrawable;
            this.letterStartX = 0.5f;
            float intrinsicWidth = letterDrawables[0].getIntrinsicWidth() / backgroundDrawable.getIntrinsicWidth();
            this.letterWidth = intrinsicWidth;
            this.letterEndX = 0.5f - ((intrinsicWidth * letterDrawables.length) + (this.letterDel * (letterDrawables.length - 1)));
            this.letterDelY = (1.0f - (letterDrawables[0].getIntrinsicHeight() / backgroundDrawable.getIntrinsicHeight())) / 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x008d  */
        @Override // com.tencent.mobileqq.vas.image.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
            float f16;
            int i3;
            float f17;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            int i16 = 0;
            if (bounds == null) {
                rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            } else {
                rect = bounds;
            }
            int width = rect.width();
            int height = rect.height();
            float f18 = rect.bottom;
            float f19 = height;
            float f26 = this.letterDelY;
            int i17 = (int) (f18 - (f19 * f26));
            int i18 = (int) (rect.top + (f19 * f26));
            Drawable drawable = this.backgroundDrawable;
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
            com.tencent.cachedrawable.dynamicdrawable.d dVar = (com.tencent.cachedrawable.dynamicdrawable.d) drawable;
            int frameCount = dVar.getFrameCount();
            if (dVar.c() < frameCount / 2) {
                f16 = 0.0f;
            } else {
                f16 = ((r2 - r4) + 1) / (frameCount - r4);
            }
            this.animProgress = f16;
            drawable.setBounds(rect);
            drawable.draw(canvas);
            float f27 = this.animProgress;
            if (f27 > 0.0f) {
                int i19 = 255;
                if (f27 < 0.1f) {
                    f17 = 255 * (f27 / 0.1f);
                } else if (f27 > 0.9f) {
                    f17 = 255 * ((1.0f - f27) / 0.1f);
                } else {
                    i3 = 255;
                    if (i3 > 0) {
                        if (i3 < 255) {
                            canvas.saveLayerAlpha(rect.left, rect.top, rect.right, rect.bottom, i3);
                        }
                        Drawable[] drawableArr = this.letterDrawables;
                        int length = drawableArr.length;
                        int i26 = 0;
                        while (i16 < length) {
                            Drawable drawable2 = drawableArr[i16];
                            float f28 = this.letterStartX;
                            float f29 = this.letterWidth;
                            Drawable[] drawableArr2 = drawableArr;
                            float f36 = (i26 * (this.letterDel + f29)) + f28 + (this.animProgress * (this.letterEndX - f28));
                            float f37 = width;
                            int i27 = rect.left;
                            int i28 = length;
                            int i29 = (int) ((f36 * f37) + i27);
                            int i36 = (int) (((f36 + f29) * f37) + i27);
                            drawable2.setBounds(i29, i18, i36, i17);
                            if (i29 < rect.right && i36 > rect.left) {
                                drawable2.draw(canvas);
                            }
                            i26++;
                            i16++;
                            drawableArr = drawableArr2;
                            length = i28;
                            i19 = 255;
                        }
                        if (i3 < i19) {
                            canvas.restore();
                        }
                    }
                }
                i3 = (int) f17;
                if (i3 > 0) {
                }
            }
            Drawable drawable3 = this.foregroundDrawable;
            drawable3.setBounds(rect);
            drawable3.draw(canvas);
        }
    }

    public AbsLetterScrollDrawable(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
        this.loadNum = new AtomicInteger(0);
    }

    private final void G(final String imgPath, final Function1<? super Drawable, Unit> block) {
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(imgPath).i(this.scene).h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$preloadBackgroundImg$drawable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.y(1);
            }
        }).a();
        a16.I(false);
        a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$preloadBackgroundImg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isDebugVersion()) {
                    QLog.d("AbsLetterScrollDrawable", 1, "load " + imgPath + " end [" + Thread.currentThread() + "]");
                }
                block.invoke((Drawable) it);
            }
        });
    }

    private final void H(final String imgPath, final Function1<? super Drawable, Unit> block) {
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(imgPath).i(this.scene).a();
        a16.I(false);
        a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$preloadOtherImg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isDebugVersion()) {
                    QLog.d("AbsLetterScrollDrawable", 1, "load " + imgPath + " end [" + Thread.currentThread() + "]");
                }
                block.invoke((Drawable) it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        ImageFileData E = E();
        if (E == null) {
            return;
        }
        this.totalImgSize = E.c().size() + 2;
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        int size = E.c().size();
        Drawable[] drawableArr = new Drawable[size];
        final int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            drawableArr[i16] = com.tencent.mobileqq.vas.image.h.INSTANCE.a();
        }
        this.letterImgs = drawableArr;
        setTargetDrawableBuild(new Function0<c>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbsLetterScrollDrawable.c invoke() {
                Drawable drawable;
                Drawable[] drawableArr2;
                Drawable drawable2;
                drawable = AbsLetterScrollDrawable.this.bgImg;
                Intrinsics.checkNotNull(drawable);
                drawableArr2 = AbsLetterScrollDrawable.this.letterImgs;
                if (drawableArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("letterImgs");
                    drawableArr2 = null;
                }
                drawable2 = AbsLetterScrollDrawable.this.fgImg;
                Intrinsics.checkNotNull(drawable2);
                AbsLetterScrollDrawable.c cVar = new AbsLetterScrollDrawable.c(drawable, drawableArr2, drawable2);
                final AbsLetterScrollDrawable absLetterScrollDrawable = AbsLetterScrollDrawable.this;
                absLetterScrollDrawable.postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$3$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Function1 function1;
                        function1 = AbsLetterScrollDrawable.this.loadCallback;
                        if (function1 != null) {
                            function1.invoke(AbsLetterScrollDrawable.this);
                        }
                    }
                });
                return cVar;
            }
        });
        QLog.d("AbsLetterScrollDrawable", 2, "all image :" + E);
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$refresh$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                if (AbsLetterScrollDrawable.this.getIsLoadSuccess()) {
                    QLog.d("AbsLetterScrollDrawable", 2, "all image loaded");
                    AbsAsyncDrawable.load$default(AbsLetterScrollDrawable.this, false, 1, null);
                }
            }
        };
        for (Object obj : E.c()) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            H((String) obj, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Drawable d16) {
                    Drawable[] drawableArr2;
                    AtomicInteger atomicInteger;
                    Intrinsics.checkNotNullParameter(d16, "d");
                    drawableArr2 = AbsLetterScrollDrawable.this.letterImgs;
                    if (drawableArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("letterImgs");
                        drawableArr2 = null;
                    }
                    drawableArr2[i3] = d16;
                    atomicInteger = AbsLetterScrollDrawable.this.loadNum;
                    atomicInteger.incrementAndGet();
                    function0.invoke();
                }
            });
            i3 = i17;
        }
        G(E.getBgPath(), new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Drawable it) {
                AtomicInteger atomicInteger;
                Intrinsics.checkNotNullParameter(it, "it");
                FastDynamicDrawable fastDynamicDrawable = (FastDynamicDrawable) it;
                fastDynamicDrawable.d(new a(AbsLetterScrollDrawable.this));
                fastDynamicDrawable.restart();
                AbsLetterScrollDrawable.this.bgImg = fastDynamicDrawable;
                atomicInteger = AbsLetterScrollDrawable.this.loadNum;
                atomicInteger.incrementAndGet();
                function0.invoke();
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable$realInit$5$a", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements d.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AbsLetterScrollDrawable f311274a;

                a(AbsLetterScrollDrawable absLetterScrollDrawable) {
                    this.f311274a = absLetterScrollDrawable;
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onEnd() {
                    Object obj;
                    Object obj2;
                    obj = this.f311274a.bgImg;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                    ((com.tencent.cachedrawable.dynamicdrawable.d) obj).restart();
                    obj2 = this.f311274a.fgImg;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                    ((com.tencent.cachedrawable.dynamicdrawable.d) obj2).restart();
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onStart() {
                }
            }
        });
        H(E.getFgPath(), new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$realInit$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Drawable it) {
                AtomicInteger atomicInteger;
                Intrinsics.checkNotNullParameter(it, "it");
                AbsLetterScrollDrawable.this.fgImg = it;
                atomicInteger = AbsLetterScrollDrawable.this.loadNum;
                atomicInteger.incrementAndGet();
                function0.invoke();
            }
        });
    }

    @Nullable
    public abstract ImageFileData E();

    public final void F(boolean isAsync) {
        if (isAsync) {
            postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable$initData$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    AbsLetterScrollDrawable.this.I();
                }
            });
        } else {
            I();
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.loadNum.get() == this.totalImgSize) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.image.c
    public void setLoadedListener(@NotNull Function1<? super com.tencent.mobileqq.vas.image.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
    }
}
