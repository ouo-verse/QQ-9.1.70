package com.tencent.libra.extension;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.core.util.Consumer;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.rlottie.a;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u00020\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/libra/extension/b;", "Lr01/a;", "Landroid/graphics/drawable/Drawable;", "", "path", "", "d", "Ljava/io/File;", "file", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "Lcom/tencent/libra/request/b;", "requestInfo", "Landroidx/core/util/Consumer;", "onDecodeResultListener", "", "c", "getLogTag", "<init>", "()V", "libra-extension-rlottie_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b implements r01.a<Drawable> {
    private final boolean d(String path) {
        boolean endsWith$default;
        boolean endsWith$default2;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ark.ARKMETADATA_JSON, false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(path, "zip", false, 2, null);
            if (!endsWith$default2) {
                return false;
            }
        }
        return true;
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
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<Drawable> onDecodeResultListener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(onDecodeResultListener, "onDecodeResultListener");
        Map<String, Object> c16 = requestInfo.c();
        boolean z17 = false;
        if (c16 != null && !c16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj = null;
        if (z16) {
            onDecodeResultListener.accept(null);
            return;
        }
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
        Object obj2 = c16.get("precache");
        if (obj2 instanceof Boolean) {
            obj = obj2;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            z17 = bool.booleanValue();
        }
        onDecodeResultListener.accept(new LibraRLottieAnimateDrawable(a.C9743a.b(application, requestInfo.getSrcFile().getAbsolutePath(), requestInfo.getWidth(), requestInfo.getHeight(), z17, true)));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "LibraRLottieDecoder";
    }
}
