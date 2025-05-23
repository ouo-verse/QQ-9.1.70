package com.tencent.filament.zplan.engine;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/filament/zplan/engine/RenderCallback;", "", "onFrameRendered", "", "pixelsAddress", "", "pixelsSize", "width", "", "height", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface RenderCallback {
    void onFrameRendered(long pixelsAddress, long pixelsSize, int width, int height);
}
