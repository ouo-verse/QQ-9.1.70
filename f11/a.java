package f11;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.file.info.IFileTypeInfo;
import com.tencent.biz.richframework.media.MediaType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.base.model.AssetPathModel;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.base.model.UriModel;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0015"}, d2 = {"Lf11/a;", "Lr01/a;", "Landroid/graphics/Bitmap;", "Lcom/tencent/libra/request/b;", "requestInfo", "d", "Ljava/io/File;", "srcFile", "", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "Landroidx/core/util/Consumer;", "decodeResultListener", "", "c", "", "getLogTag", "<init>", "()V", "libra-extension-video_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a implements r01.a<Bitmap> {
    private final Bitmap d(ExtraDecoderRequestInfo requestInfo) {
        int min = Math.min(requestInfo.getWidth(), requestInfo.getHeight());
        Model<?> e16 = requestInfo.e();
        if (e16 instanceof UriModel) {
            return c.f397590a.l(((UriModel) e16).a(), min);
        }
        if (e16 instanceof AssetPathModel) {
            Application application = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
            AssetFileDescriptor openFd = application.getAssets().openFd(((AssetPathModel) e16).a());
            Intrinsics.checkNotNullExpressionValue(openFd, "assets.openFd(model.get())");
            return c.p(openFd, min);
        }
        String absolutePath = requestInfo.getSrcFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "requestInfo.srcFile.absolutePath");
        return c.n(absolutePath, min);
    }

    @Override // r01.a
    public boolean a(@NotNull File srcFile) {
        MediaType mediaType;
        IFileTypeInfo typeInfo;
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        FileType fileType = RFWFileUtils.getFileType(srcFile.getAbsolutePath());
        if (fileType != null && (typeInfo = fileType.getTypeInfo()) != null) {
            mediaType = typeInfo.getMediaType();
        } else {
            mediaType = null;
        }
        if (mediaType == MediaType.VIDEO) {
            return true;
        }
        return false;
    }

    @Override // r01.a
    public boolean b(@NotNull Model<?> model) {
        MediaType mediaType;
        IFileTypeInfo typeInfo;
        Intrinsics.checkNotNullParameter(model, "model");
        FileType fileType = RFWFileUtils.getFileType(model.c());
        if (fileType != null && (typeInfo = fileType.getTypeInfo()) != null) {
            mediaType = typeInfo.getMediaType();
        } else {
            mediaType = null;
        }
        if (mediaType == MediaType.VIDEO) {
            return true;
        }
        return false;
    }

    @Override // r01.a
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<Bitmap> decodeResultListener) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(decodeResultListener, "decodeResultListener");
        decodeResultListener.accept(d(requestInfo));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "LibraVideoThumbDecoder";
    }
}
