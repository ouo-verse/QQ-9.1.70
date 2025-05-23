package com.tencent.tavcut.core.render.cover;

import android.graphics.Bitmap;
import com.tencent.tavcut.core.render.IRenderChainManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00070\tH&J,\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00070\tH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "", "getCoverAtTime", "Landroid/graphics/Bitmap;", "atTimeMs", "", "getCoverAtTimeAsync", "", "callback", "Lkotlin/Function1;", "getCoverAtTimesAsync", "", "getRenderChainManagerAndInit", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "release", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface ICoverProvider {
    @Nullable
    Bitmap getCoverAtTime(long atTimeMs);

    void getCoverAtTimeAsync(long atTimeMs, @NotNull Function1<? super Bitmap, Unit> callback);

    void getCoverAtTimesAsync(@NotNull List<Long> atTimeMs, @NotNull Function1<? super Bitmap, Unit> callback);

    @Nullable
    IRenderChainManager getRenderChainManagerAndInit();

    void release();
}
