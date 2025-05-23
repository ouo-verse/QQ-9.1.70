package com.tencent.zplan.meme.recorder;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J9\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/meme/recorder/a;", "", "Lcom/tencent/zplan/meme/b;", "T", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "recordKey", "listener", "", "recordAction", "(Landroid/content/Context;Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Lcom/tencent/zplan/meme/b;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    void onDestroy();

    <T extends b> void recordAction(@NotNull Context context, @NotNull MemeAction action, @NotNull String recordKey, @NotNull T listener);
}
