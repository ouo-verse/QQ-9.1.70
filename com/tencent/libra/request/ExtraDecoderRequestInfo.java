package com.tencent.libra.request;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.cache.BitmapPool;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010 \u0012\b\u0010(\u001a\u0004\u0018\u00010%\u0012\u0006\u0010,\u001a\u00020)\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0015\u0010#R\u0019\u0010(\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b\n\u0010'R\u0017\u0010,\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b!\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/libra/request/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/io/File;", "a", "Ljava/io/File;", "g", "()Ljava/io/File;", "srcFile", "Lcom/tencent/libra/base/model/Model;", "b", "Lcom/tencent/libra/base/model/Model;", "e", "()Lcom/tencent/libra/base/model/Model;", "model", "c", "I", h.F, "()I", "width", "d", "height", "Lcom/tencent/libra/request/DecodeFormat;", "Lcom/tencent/libra/request/DecodeFormat;", "()Lcom/tencent/libra/request/DecodeFormat;", "decodeFormat", "", "f", "Ljava/util/Map;", "()Ljava/util/Map;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/libra/cache/BitmapPool;", "Lcom/tencent/libra/cache/BitmapPool;", "()Lcom/tencent/libra/cache/BitmapPool;", "bitmapPool", "Lcom/tencent/libra/request/SizeFormat;", "Lcom/tencent/libra/request/SizeFormat;", "()Lcom/tencent/libra/request/SizeFormat;", "sizeFormat", "<init>", "(Ljava/io/File;Lcom/tencent/libra/base/model/Model;IILcom/tencent/libra/request/DecodeFormat;Ljava/util/Map;Lcom/tencent/libra/cache/BitmapPool;Lcom/tencent/libra/request/SizeFormat;)V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.libra.request.b, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class ExtraDecoderRequestInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final File srcFile;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Model<?> model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DecodeFormat decodeFormat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, Object> extraData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final BitmapPool bitmapPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SizeFormat sizeFormat;

    public ExtraDecoderRequestInfo(@NotNull File srcFile, @Nullable Model<?> model, int i3, int i16, @NotNull DecodeFormat decodeFormat, @NotNull Map<String, ? extends Object> extraData, @Nullable BitmapPool bitmapPool, @NotNull SizeFormat sizeFormat) {
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        Intrinsics.checkNotNullParameter(decodeFormat, "decodeFormat");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(sizeFormat, "sizeFormat");
        this.srcFile = srcFile;
        this.model = model;
        this.width = i3;
        this.height = i16;
        this.decodeFormat = decodeFormat;
        this.extraData = extraData;
        this.bitmapPool = bitmapPool;
        this.sizeFormat = sizeFormat;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    @NotNull
    public final Map<String, Object> c() {
        return this.extraData;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final Model<?> e() {
        return this.model;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExtraDecoderRequestInfo) {
                ExtraDecoderRequestInfo extraDecoderRequestInfo = (ExtraDecoderRequestInfo) other;
                if (!Intrinsics.areEqual(this.srcFile, extraDecoderRequestInfo.srcFile) || !Intrinsics.areEqual(this.model, extraDecoderRequestInfo.model) || this.width != extraDecoderRequestInfo.width || this.height != extraDecoderRequestInfo.height || !Intrinsics.areEqual(this.decodeFormat, extraDecoderRequestInfo.decodeFormat) || !Intrinsics.areEqual(this.extraData, extraDecoderRequestInfo.extraData) || !Intrinsics.areEqual(this.bitmapPool, extraDecoderRequestInfo.bitmapPool) || !Intrinsics.areEqual(this.sizeFormat, extraDecoderRequestInfo.sizeFormat)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final SizeFormat getSizeFormat() {
        return this.sizeFormat;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final File getSrcFile() {
        return this.srcFile;
    }

    /* renamed from: h, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        File file = this.srcFile;
        int i26 = 0;
        if (file != null) {
            i3 = file.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        Model<?> model = this.model;
        if (model != null) {
            i16 = model.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (((((i27 + i16) * 31) + this.width) * 31) + this.height) * 31;
        DecodeFormat decodeFormat = this.decodeFormat;
        if (decodeFormat != null) {
            i17 = decodeFormat.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i18 = map.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        BitmapPool bitmapPool = this.bitmapPool;
        if (bitmapPool != null) {
            i19 = bitmapPool.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        SizeFormat sizeFormat = this.sizeFormat;
        if (sizeFormat != null) {
            i26 = sizeFormat.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        return "ExtraDecoderRequestInfo(srcFile=" + this.srcFile + ", model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", decodeFormat=" + this.decodeFormat + ", extraData=" + this.extraData + ", bitmapPool=" + this.bitmapPool + ", sizeFormat=" + this.sizeFormat + ")";
    }
}
