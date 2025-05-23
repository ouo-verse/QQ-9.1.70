package com.tencent.mobileqq.vas.vipicon;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u000e2\u00020\u0001:\u0003<=>B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\tH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0011\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010*\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R(\u00102\u001a\b\u0012\u0004\u0012\u00020\t0+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0003R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00107R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00107\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable;", "Lcom/tencent/mobileqq/vas/image/c;", "", "I", "", "imgPath", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "block", "H", "isAsync", UserInfo.SEX_FEMALE, "E", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setLoadedListener", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "d", "Ljava/lang/String;", "scene", "e", "Lkotlin/jvm/functions/Function1;", "getLoadCallback", "()Lkotlin/jvm/functions/Function1;", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "loadCallback", "f", "Landroid/graphics/drawable/Drawable;", "B", "()Landroid/graphics/drawable/Drawable;", "J", "(Landroid/graphics/drawable/Drawable;)V", "bgImg", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "K", "fgImg", "", "i", "[Landroid/graphics/drawable/Drawable;", "D", "()[Landroid/graphics/drawable/Drawable;", "L", "([Landroid/graphics/drawable/Drawable;)V", "letterImgs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "totalImgSize", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "loadNum", "playNum", "<init>", "(Ljava/lang/String;)V", "a", "b", "c", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class AbsLetterSwitchDrawable extends com.tencent.mobileqq.vas.image.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger loadNum;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger playNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super AbsLetterSwitchDrawable, Unit> loadCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable bgImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable fgImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected Drawable[] letterImgs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int totalImgSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "bgPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "letterPaths", "e", "fgPath", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class ImageFileData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String bgPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<String> letterPaths;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String fgPath;

        public ImageFileData() {
            this(null, null, null, 7, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBgPath() {
            return this.bgPath;
        }

        @Nullable
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

        public final void e(@Nullable String str) {
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
            int hashCode;
            int hashCode2 = ((this.bgPath.hashCode() * 31) + this.letterPaths.hashCode()) * 31;
            String str = this.fgPath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ImageFileData(bgPath=" + this.bgPath + ", letterPaths=" + this.letterPaths + ", fgPath=" + this.fgPath + ")";
        }

        public ImageFileData(@NotNull String bgPath, @NotNull ArrayList<String> letterPaths, @Nullable String str) {
            Intrinsics.checkNotNullParameter(bgPath, "bgPath");
            Intrinsics.checkNotNullParameter(letterPaths, "letterPaths");
            this.bgPath = bgPath;
            this.letterPaths = letterPaths;
            this.fgPath = str;
        }

        public /* synthetic */ ImageFileData(String str, ArrayList arrayList, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? null : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b(\u0010)J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\u00020\u00198\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010$\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0017\u0010'\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$c;", "Lcom/tencent/mobileqq/vas/image/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "d", "Landroid/graphics/drawable/Drawable;", "getBg", "()Landroid/graphics/drawable/Drawable;", VasProfileTemplatePreloadHelper.BACKGROUND, "", "e", "[Landroid/graphics/drawable/Drawable;", "getLetters", "()[Landroid/graphics/drawable/Drawable;", "letters", "f", "getFg", "fg", "", "g", UserInfo.SEX_FEMALE, "getWidth", "()F", "width", tl.h.F, "getDel", "del", "i", "getStartX", "startX", "j", "getDelY", "delY", "<init>", "(Landroid/graphics/drawable/Drawable;[Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends com.tencent.mobileqq.vas.image.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable bg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable[] letters;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable fg;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final float width;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final float del;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final float startX;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final float delY;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(@NotNull Drawable bg5, @NotNull Drawable[] letters, @Nullable Drawable drawable) {
            super(r0);
            Intrinsics.checkNotNullParameter(bg5, "bg");
            Intrinsics.checkNotNullParameter(letters, "letters");
            ArrayList arrayList = new ArrayList();
            arrayList.add(bg5);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, letters);
            if (drawable != null) {
                arrayList.add(drawable);
            }
            this.bg = bg5;
            this.letters = letters;
            this.fg = drawable;
            this.del = 0.01f;
            float intrinsicWidth = letters[0].getIntrinsicWidth() / bg5.getIntrinsicWidth();
            this.width = intrinsicWidth;
            float f16 = 2;
            this.startX = (1.0f - ((intrinsicWidth * letters.length) + (0.01f * (letters.length - 1)))) / f16;
            this.delY = (1.0f - (letters[0].getIntrinsicHeight() / bg5.getIntrinsicHeight())) / f16;
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
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
                if (!Intrinsics.areEqual(drawable, this.bg) && !Intrinsics.areEqual(drawable, this.fg)) {
                    float f16 = this.startX;
                    float f17 = this.width;
                    float f18 = f16 + (i3 * (this.del + f17));
                    float f19 = width;
                    int i16 = rect.left;
                    float f26 = rect.top;
                    float f27 = height;
                    float f28 = this.delY;
                    drawable.setBounds((int) ((f18 * f19) + i16), (int) (f26 + (f27 * f28)), (int) (((f18 + f17) * f19) + i16), (int) (rect.bottom - (f27 * f28)));
                    drawable.draw(canvas);
                    i3++;
                } else {
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                }
            }
        }
    }

    public AbsLetterSwitchDrawable(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
        this.loadNum = new AtomicInteger(0);
        this.playNum = new AtomicInteger(0);
    }

    public static /* synthetic */ void G(AbsLetterSwitchDrawable absLetterSwitchDrawable, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            absLetterSwitchDrawable.F(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initData");
    }

    private final void H(final String imgPath, final boolean reuse, final Function1<? super Drawable, Unit> block) {
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(imgPath).i(this.scene).h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$preloadImg$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!reuse) {
                    it.I(false);
                }
                it.y(1);
            }
        }).a();
        a16.I(false);
        a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$preloadImg$1
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
                    QLog.d("LetterSwitchDrawable", 1, "load " + imgPath + " end [" + Thread.currentThread() + "]");
                }
                block.invoke((Drawable) it);
                it.d(new a(this));
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$preloadImg$1$a", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements d.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AbsLetterSwitchDrawable f311291a;

                a(AbsLetterSwitchDrawable absLetterSwitchDrawable) {
                    this.f311291a = absLetterSwitchDrawable;
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onEnd() {
                    AtomicInteger atomicInteger;
                    int i3;
                    AtomicInteger atomicInteger2;
                    com.tencent.cachedrawable.dynamicdrawable.d dVar;
                    atomicInteger = this.f311291a.playNum;
                    int incrementAndGet = atomicInteger.incrementAndGet();
                    i3 = this.f311291a.totalImgSize;
                    if (incrementAndGet == i3 && this.f311291a.getNeedLoop()) {
                        atomicInteger2 = this.f311291a.playNum;
                        atomicInteger2.set(0);
                        Object bgImg = this.f311291a.getBgImg();
                        Intrinsics.checkNotNull(bgImg, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                        ((com.tencent.cachedrawable.dynamicdrawable.d) bgImg).restart();
                        Object fgImg = this.f311291a.getFgImg();
                        if (fgImg instanceof com.tencent.cachedrawable.dynamicdrawable.d) {
                            dVar = (com.tencent.cachedrawable.dynamicdrawable.d) fgImg;
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            dVar.restart();
                        }
                        for (Object obj : this.f311291a.D()) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                            ((com.tencent.cachedrawable.dynamicdrawable.d) obj).restart();
                        }
                    }
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onStart() {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        ImageFileData A = A();
        if (A == null) {
            return;
        }
        this.totalImgSize = A.c().size() + 1;
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        int size = A.c().size();
        Drawable[] drawableArr = new Drawable[size];
        for (int i3 = 0; i3 < size; i3++) {
            drawableArr[i3] = com.tencent.mobileqq.vas.image.h.INSTANCE.a();
        }
        L(drawableArr);
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Drawable invoke() {
                return AbsLetterSwitchDrawable.this.E();
            }
        });
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$refresh$1
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
                if (AbsLetterSwitchDrawable.this.getIsLoadSuccess()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LetterSwitchDrawable", 2, "all image loaded");
                    }
                    AbsAsyncDrawable.load$default(AbsLetterSwitchDrawable.this, false, 1, null);
                }
            }
        };
        final int i16 = 0;
        for (Object obj : A.c()) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            H((String) obj, false, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$4$1
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
                    AtomicInteger atomicInteger;
                    Intrinsics.checkNotNullParameter(d16, "d");
                    AbsLetterSwitchDrawable.this.D()[i16] = d16;
                    atomicInteger = AbsLetterSwitchDrawable.this.loadNum;
                    atomicInteger.incrementAndGet();
                    function0.invoke();
                }
            });
            i16 = i17;
        }
        H(A.getBgPath(), false, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$5
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
                AbsLetterSwitchDrawable.this.J(it);
                atomicInteger = AbsLetterSwitchDrawable.this.loadNum;
                atomicInteger.incrementAndGet();
                function0.invoke();
            }
        });
        String fgPath = A.getFgPath();
        if (fgPath != null) {
            H(fgPath, false, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$realInit$6$1
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
                    Intrinsics.checkNotNullParameter(it, "it");
                    AbsLetterSwitchDrawable.this.K(it);
                    function0.invoke();
                }
            });
        }
    }

    @Nullable
    public abstract ImageFileData A();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: B, reason: from getter */
    public final Drawable getBgImg() {
        return this.bgImg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: C, reason: from getter */
    public final Drawable getFgImg() {
        return this.fgImg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Drawable[] D() {
        Drawable[] drawableArr = this.letterImgs;
        if (drawableArr != null) {
            return drawableArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("letterImgs");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Drawable E() {
        Drawable drawable = this.bgImg;
        Intrinsics.checkNotNull(drawable);
        c cVar = new c(drawable, D(), this.fgImg);
        postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$getTargetDrawable$1$1
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
                Function1<AbsLetterSwitchDrawable, Unit> loadCallback = AbsLetterSwitchDrawable.this.getLoadCallback();
                if (loadCallback != null) {
                    loadCallback.invoke(AbsLetterSwitchDrawable.this);
                }
            }
        });
        return cVar;
    }

    public final void F(boolean isAsync) {
        if (isAsync) {
            postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable$initData$1
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
                    AbsLetterSwitchDrawable.this.I();
                }
            });
        } else {
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(@Nullable Drawable drawable) {
        this.bgImg = drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(@Nullable Drawable drawable) {
        this.fgImg = drawable;
    }

    protected final void L(@NotNull Drawable[] drawableArr) {
        Intrinsics.checkNotNullParameter(drawableArr, "<set-?>");
        this.letterImgs = drawableArr;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Function1<AbsLetterSwitchDrawable, Unit> getLoadCallback() {
        return this.loadCallback;
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
