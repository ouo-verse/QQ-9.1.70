package com.tencent.tavcut.core.session;

import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tav.coremedia.TextureInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/core/session/IRenderCallback;", "", "onBeforeRender", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "onRender", "textureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IRenderCallback {
    void onBeforeRender(long timeStamp);

    void onRender(long timeStamp, @NotNull TextureInfo textureInfo);
}
