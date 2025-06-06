package com.tencent.mobileqq.wink.editor.export.compress.base;

import com.tencent.tav.core.ExportConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J&\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\r\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/compress/base/a;", "", "", "b", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/b;", "listener", "", "a", "inputPath", "outputPath", "Lcom/tencent/tav/core/ExportConfig;", "exportConfig", "c", "cancel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    void a(@Nullable b listener);

    @NotNull
    String b();

    void c(@Nullable String inputPath, @Nullable String outputPath, @Nullable ExportConfig exportConfig);

    void cancel();
}
