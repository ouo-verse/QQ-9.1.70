package com.tencent.qqnt.emotion.pic.libra;

import android.graphics.drawable.Animatable;
import androidx.core.util.Consumer;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.util.apng.decode.APNGParser;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u5df2\u628a Apng \u89e3\u7801\u529f\u80fd\u4e0b\u6c89\u5230 Libra\uff0c\u5f15\u5165 coms_rfw_pic_extension_apng_lib \u5e76\u4f7f\u7528 LibraApngLibDecoder \u66ff\u4ee3")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/d;", "Lr01/a;", "Landroid/graphics/drawable/Animatable;", "Ljava/io/File;", "srcFile", "", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "Lcom/tencent/libra/request/b;", "requestInfo", "Landroidx/core/util/Consumer;", "decodeResultListener", "", "c", "", "getLogTag", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d implements r01.a<Animatable> {
    @Override // r01.a
    public boolean a(@NotNull File srcFile) {
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        return APNGParser.a(srcFile.getAbsolutePath());
    }

    @Override // r01.a
    public boolean b(@NotNull Model<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return APNGParser.b(new t01.e(model.c()));
    }

    @Override // r01.a
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<Animatable> decodeResultListener) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(decodeResultListener, "decodeResultListener");
        decodeResultListener.accept(new b(requestInfo.getSrcFile(), BaseApplication.getContext().getResources()));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "LibApngSoDecoder";
    }
}
