package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u0014\u001a\u00020\u0012H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager;", "", "()V", "segHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "get", "Landroid/graphics/Bitmap;", "index", "", "key", "", "getCacheName", "preSegModel", "Lcom/tencent/qcircle/tavcut/aekit/PreSegModel;", "cropModel", "Lcom/tencent/qcircle/weseevideo/model/effect/CropModel;", "put", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "release", "BitmapWithKey", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class WSSegmentManager {
    public static final WSSegmentManager INSTANCE = new WSSegmentManager();
    private static final SparseArray<BitmapWithKey> segHashMap = new SparseArray<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "key", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final /* data */ class BitmapWithKey {

        @Nullable
        private final Bitmap bitmap;

        @NotNull
        private final String key;

        public BitmapWithKey(@Nullable Bitmap bitmap, @NotNull String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.bitmap = bitmap;
            this.key = key;
        }

        public static /* synthetic */ BitmapWithKey copy$default(BitmapWithKey bitmapWithKey, Bitmap bitmap, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bitmap = bitmapWithKey.bitmap;
            }
            if ((i3 & 2) != 0) {
                str = bitmapWithKey.key;
            }
            return bitmapWithKey.copy(bitmap, str);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final BitmapWithKey copy(@Nullable Bitmap bitmap, @NotNull String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new BitmapWithKey(bitmap, key);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof BitmapWithKey) {
                    BitmapWithKey bitmapWithKey = (BitmapWithKey) other;
                    if (!Intrinsics.areEqual(this.bitmap, bitmapWithKey.bitmap) || !Intrinsics.areEqual(this.key, bitmapWithKey.key)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        public int hashCode() {
            int i3;
            Bitmap bitmap = this.bitmap;
            int i16 = 0;
            if (bitmap != null) {
                i3 = bitmap.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str = this.key;
            if (str != null) {
                i16 = str.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "BitmapWithKey(bitmap=" + this.bitmap + ", key=" + this.key + ")";
        }

        public /* synthetic */ BitmapWithKey(Bitmap bitmap, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, (i3 & 2) != 0 ? "" : str);
        }
    }

    WSSegmentManager() {
    }

    @JvmStatic
    @Nullable
    public static final Bitmap get(int index, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        BitmapWithKey bitmapWithKey = segHashMap.get(index);
        if (bitmapWithKey == null || (!Intrinsics.areEqual(bitmapWithKey.getKey(), key))) {
            return null;
        }
        return bitmapWithKey.getBitmap();
    }

    @JvmStatic
    @Nullable
    public static final String getCacheName(@Nullable PreSegModel preSegModel, @Nullable CropModel cropModel) {
        if (preSegModel != null) {
            String str = preSegModel.getSegMaterial() + preSegModel.getOriginPic();
            if (cropModel != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                CropConfig cropConfig = cropModel.getCropConfig();
                Intrinsics.checkExpressionValueIsNotNull(cropConfig, "it.cropConfig");
                sb5.append(String.valueOf(cropConfig.getX()));
                CropConfig cropConfig2 = cropModel.getCropConfig();
                Intrinsics.checkExpressionValueIsNotNull(cropConfig2, "it.cropConfig");
                sb5.append(String.valueOf(cropConfig2.getY()));
                CropConfig cropConfig3 = cropModel.getCropConfig();
                Intrinsics.checkExpressionValueIsNotNull(cropConfig3, "it.cropConfig");
                sb5.append(String.valueOf(cropConfig3.getWidth()));
                CropConfig cropConfig4 = cropModel.getCropConfig();
                Intrinsics.checkExpressionValueIsNotNull(cropConfig4, "it.cropConfig");
                sb5.append(String.valueOf(cropConfig4.getHeight()));
                return sb5.toString();
            }
            return str;
        }
        return null;
    }

    @JvmStatic
    public static final void put(int index, @NotNull String key, @Nullable Bitmap bitmap) {
        Bitmap bitmap2;
        Intrinsics.checkParameterIsNotNull(key, "key");
        SparseArray<BitmapWithKey> sparseArray = segHashMap;
        BitmapWithKey bitmapWithKey = sparseArray.get(index);
        if (bitmapWithKey != null) {
            bitmap2 = bitmapWithKey.getBitmap();
        } else {
            bitmap2 = null;
        }
        if (bitmap != null) {
            sparseArray.put(index, new BitmapWithKey(bitmap.copy(bitmap.getConfig(), true), key));
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        }
    }

    @JvmStatic
    @RequiresApi(19)
    public static final void release() {
        Bitmap bitmap;
        int size = segHashMap.size();
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                BitmapWithKey bitmapWithKey = segHashMap.get(i3);
                if (bitmapWithKey != null && (bitmap = bitmapWithKey.getBitmap()) != null) {
                    bitmap.recycle();
                }
                if (i3 == size) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        SparseArray<BitmapWithKey> sparseArray = segHashMap;
        sparseArray.removeAtRange(0, sparseArray.size());
    }
}
