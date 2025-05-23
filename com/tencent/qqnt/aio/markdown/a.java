package com.tencent.qqnt.aio.markdown;

import androidx.annotation.MainThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\n\u001a\u00020\bH'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/a;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/markdown/c;", "listener", "", "b", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    @MainThread
    void a(@NotNull c listener);

    @MainThread
    boolean b(@NotNull AIOMsgItem msgItem, @NotNull c listener);

    @MainThread
    void onDestroy();
}
