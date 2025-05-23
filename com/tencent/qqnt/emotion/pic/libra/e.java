package com.tencent.qqnt.emotion.pic.libra;

import android.content.res.Resources;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/e;", "Lr01/a;", "Lr01/c;", "Ljava/io/File;", "srcFile", "", "a", "Lcom/tencent/libra/base/model/Model;", "model", "b", "Lcom/tencent/libra/request/b;", "requestInfo", "Landroidx/core/util/Consumer;", "decodeResultListener", "", "c", "", "getLogTag", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e implements r01.a<r01.c> {
    @Override // r01.a
    public boolean a(@NotNull File srcFile) {
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        if (RFWFileUtils.getFileType(srcFile.getAbsolutePath()) == FileType.GIF) {
            return true;
        }
        return false;
    }

    @Override // r01.a
    public boolean b(@NotNull Model<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (RFWFileUtils.getFileType(model.c()) == FileType.GIF) {
            return true;
        }
        return false;
    }

    @Override // r01.a
    public void c(@NotNull ExtraDecoderRequestInfo requestInfo, @NotNull Consumer<r01.c> decodeResultListener) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(decodeResultListener, "decodeResultListener");
        File srcFile = requestInfo.getSrcFile();
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        decodeResultListener.accept(new c(srcFile, resources, false, 4, null));
    }

    @Override // r01.a
    @NotNull
    public String getLogTag() {
        return "LibraLibGifDecoder";
    }
}
