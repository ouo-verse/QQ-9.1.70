package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import android.os.Handler;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/gldrawable/api/IFactoryStub;", "", "fromBundle", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "bundle", "Landroid/os/Bundle;", "fromFile", "file", "Ljava/io/File;", "setWorkHandler", "handler", "Landroid/os/Handler;", "useCache", "b", "", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface IFactoryStub {
    @Nullable
    IGLDrawable fromBundle(@NotNull Bundle bundle);

    @Nullable
    IGLDrawable fromFile(@NotNull File file);

    @NotNull
    IFactoryStub setWorkHandler(@Nullable Handler handler);

    @NotNull
    IFactoryStub useCache(boolean b16);
}
