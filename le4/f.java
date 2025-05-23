package le4;

import android.media.MediaFormat;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "filePath", "Lcom/tencent/tav/asset/URLAsset;", "a", "lib_tavcut_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class f {
    @Nullable
    public static final URLAsset a(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setDataSource(filePath);
        ArrayList<MediaFormat> mediaFormats = ExtractorUtils.getMediaFormats(assetExtractor);
        Intrinsics.checkExpressionValueIsNotNull(mediaFormats, "ExtractorUtils.getMediaFormats(assetExtractor)");
        assetExtractor.release();
        if (mediaFormats.isEmpty()) {
            return null;
        }
        try {
            return new URLAsset(filePath, false);
        } catch (RuntimeException e16) {
            ee4.b.b("TavAssetCreator", "createURLAsset error, file path: " + filePath + ", exception: " + String.valueOf(e16.getCause()));
            return null;
        }
    }
}
