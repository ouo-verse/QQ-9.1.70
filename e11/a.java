package e11;

import android.graphics.drawable.PictureDrawable;
import androidx.core.util.Consumer;
import com.caverock.androidsvg.SVG;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.h;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u00020\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Le11/a;", "Lr01/a;", "Landroid/graphics/drawable/PictureDrawable;", "", "path", "", "d", "Ljava/io/File;", "file", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "getLogTag", "Lcom/tencent/libra/request/b;", "requestInfo", "Landroidx/core/util/Consumer;", "decodeResultListener", "", "c", "<init>", "()V", "libra-extension-svg_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a implements r01.a<PictureDrawable> {
    private final boolean d(String path) {
        boolean endsWith$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, "svg", false, 2, null);
        return endsWith$default;
    }

    @Override // r01.a
    public boolean a(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return d(absolutePath);
    }

    @Override // r01.a
    public boolean b(@NotNull Model<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return d(model.f());
    }

    @Override // r01.a
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<PictureDrawable> decodeResultListener) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(decodeResultListener, "decodeResultListener");
        SVG fromInputStream = SVG.getFromInputStream(h.f118788a.a(requestInfo.e(), requestInfo.getSrcFile()));
        Intrinsics.checkNotNullExpressionValue(fromInputStream, "SVG.getFromInputStream(inputStream)");
        decodeResultListener.accept(new PictureDrawable(fromInputStream.renderToPicture()));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "SvgDecoder";
    }
}
