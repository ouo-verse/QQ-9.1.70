package c11;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import androidx.core.util.Consumer;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.util.apng.decode.APNGParser;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t01.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0006B\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lc11/b;", "Lr01/a;", "Landroid/graphics/drawable/Animatable;", "Ljava/io/File;", "srcFile", "", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "Lcom/tencent/libra/request/b;", "requestInfo", "Landroidx/core/util/Consumer;", "decodeResultListener", "", "c", "", "getLogTag", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "res", "<init>", "(Landroid/content/res/Resources;)V", "libra-extension-apng-lib_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b implements r01.a<Animatable> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Resources res;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // r01.a
    public boolean a(@NotNull File srcFile) {
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        return APNGParser.a(srcFile.getAbsolutePath());
    }

    @Override // r01.a
    public boolean b(@NotNull Model<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return APNGParser.b(new e(model.c()));
    }

    @Override // r01.a
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<Animatable> decodeResultListener) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(decodeResultListener, "decodeResultListener");
        decodeResultListener.accept(new a(requestInfo.getSrcFile(), this.res, false, 4, null));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "LibraApngLibDecoder";
    }

    public b(@Nullable Resources resources) {
        this.res = resources;
    }

    public /* synthetic */ b(Resources resources, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : resources);
    }
}
