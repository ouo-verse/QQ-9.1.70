package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/gldrawable/api/AutoEtcOptions;", "Lcom/tencent/android/gldrawable/api/GLDrawableOptions;", "()V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "toBundle", "Landroid/os/Bundle;", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class AutoEtcOptions implements GLDrawableOptions {

    @NotNull
    public static final String NAME = "AutoETC";

    @NotNull
    private String filePath = "";

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filePath = str;
    }

    @Override // com.tencent.android.gldrawable.api.GLDrawableOptions
    @NotNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("type_flag", NAME);
        bundle.putString("filePath", this.filePath);
        return bundle;
    }
}
