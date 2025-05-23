package com.tencent.ecommerce.base.imageloader.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&JM\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\fj\u0002`\u0011H&J\b\u0010\u0014\u001a\u00020\nH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "", "Landroid/content/Context;", "context", "", "path", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "", "load", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "fetchDrawable", "cleanCache", "b", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECImageLoader {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IECImageLoader iECImageLoader, Context context, String str, ImageLoaderOption imageLoaderOption, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    imageLoaderOption = null;
                }
                iECImageLoader.fetchDrawable(context, str, imageLoaderOption, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchDrawable");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010-\u00a2\u0006\u0004\b2\u00103J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R$\u0010(\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b\u0014\u0010\"\"\u0004\b'\u0010$R\u0017\u0010+\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b&\u0010*R\u0017\u0010,\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b\u0010\u0010*R%\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\t\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", h.F, "()I", "setWidthPx", "(I)V", "widthPx", "b", "d", "setHeightPx", "heightPx", "c", "g", "setRadiusPx", "radiusPx", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "scaleType", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loadingDrawable", "f", "setErrorDrawable", "errorDrawable", "Z", "()Z", "needResize", "disallowHardwareDecode", "", "i", "Ljava/util/Map;", "()Ljava/util/Map;", "context", "<init>", "(IIILandroid/widget/ImageView$ScaleType;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZZLjava/util/Map;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.imageloader.api.IECImageLoader$b, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class ImageLoaderOption {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int widthPx;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int heightPx;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int radiusPx;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private ImageView.ScaleType scaleType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Drawable loadingDrawable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Drawable errorDrawable;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needResize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean disallowHardwareDecode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Map<String, Object> context;

        public ImageLoaderOption(int i3, int i16, int i17, @Nullable ImageView.ScaleType scaleType, @Nullable Drawable drawable, @Nullable Drawable drawable2, boolean z16, boolean z17, @Nullable Map<String, ? extends Object> map) {
            this.widthPx = i3;
            this.heightPx = i16;
            this.radiusPx = i17;
            this.scaleType = scaleType;
            this.loadingDrawable = drawable;
            this.errorDrawable = drawable2;
            this.needResize = z16;
            this.disallowHardwareDecode = z17;
            this.context = map;
        }

        @Nullable
        public final Map<String, Object> a() {
            return this.context;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDisallowHardwareDecode() {
            return this.disallowHardwareDecode;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Drawable getErrorDrawable() {
            return this.errorDrawable;
        }

        /* renamed from: d, reason: from getter */
        public final int getHeightPx() {
            return this.heightPx;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final Drawable getLoadingDrawable() {
            return this.loadingDrawable;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof ImageLoaderOption) {
                    ImageLoaderOption imageLoaderOption = (ImageLoaderOption) other;
                    if (this.widthPx != imageLoaderOption.widthPx || this.heightPx != imageLoaderOption.heightPx || this.radiusPx != imageLoaderOption.radiusPx || !Intrinsics.areEqual(this.scaleType, imageLoaderOption.scaleType) || !Intrinsics.areEqual(this.loadingDrawable, imageLoaderOption.loadingDrawable) || !Intrinsics.areEqual(this.errorDrawable, imageLoaderOption.errorDrawable) || this.needResize != imageLoaderOption.needResize || this.disallowHardwareDecode != imageLoaderOption.disallowHardwareDecode || !Intrinsics.areEqual(this.context, imageLoaderOption.context)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getNeedResize() {
            return this.needResize;
        }

        /* renamed from: g, reason: from getter */
        public final int getRadiusPx() {
            return this.radiusPx;
        }

        /* renamed from: h, reason: from getter */
        public final int getWidthPx() {
            return this.widthPx;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16;
            int i17;
            int i18 = ((((this.widthPx * 31) + this.heightPx) * 31) + this.radiusPx) * 31;
            ImageView.ScaleType scaleType = this.scaleType;
            int i19 = 0;
            if (scaleType != null) {
                i3 = scaleType.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (i18 + i3) * 31;
            Drawable drawable = this.loadingDrawable;
            if (drawable != null) {
                i16 = drawable.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 31;
            Drawable drawable2 = this.errorDrawable;
            if (drawable2 != null) {
                i17 = drawable2.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 31;
            boolean z16 = this.needResize;
            int i29 = 1;
            int i36 = z16;
            if (z16 != 0) {
                i36 = 1;
            }
            int i37 = (i28 + i36) * 31;
            boolean z17 = this.disallowHardwareDecode;
            if (!z17) {
                i29 = z17 ? 1 : 0;
            }
            int i38 = (i37 + i29) * 31;
            Map<String, Object> map = this.context;
            if (map != null) {
                i19 = map.hashCode();
            }
            return i38 + i19;
        }

        @NotNull
        public String toString() {
            return "ImageLoaderOption(widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", radiusPx=" + this.radiusPx + ", scaleType=" + this.scaleType + ", loadingDrawable=" + this.loadingDrawable + ", errorDrawable=" + this.errorDrawable + ", needResize=" + this.needResize + ", disallowHardwareDecode=" + this.disallowHardwareDecode + ", context=" + this.context + ")";
        }

        public /* synthetic */ ImageLoaderOption(int i3, int i16, int i17, ImageView.ScaleType scaleType, Drawable drawable, Drawable drawable2, boolean z16, boolean z17, Map map, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i16, (i18 & 4) != 0 ? 0 : i17, (i18 & 8) != 0 ? null : scaleType, (i18 & 16) != 0 ? null : drawable, (i18 & 32) != 0 ? null : drawable2, (i18 & 64) != 0 ? true : z16, (i18 & 128) != 0 ? false : z17, (i18 & 256) != 0 ? null : map);
        }
    }

    void cleanCache();

    void fetchDrawable(@NotNull Context context, @NotNull String path, @Nullable ImageLoaderOption option, @NotNull Function1<? super Drawable, Unit> callback);

    void load(@NotNull Context context, @NotNull String path, @NotNull ImageView imageView, @NotNull ImageLoaderOption option);
}
