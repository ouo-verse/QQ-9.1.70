package com.tencent.qqnt.search.api;

import android.text.Spannable;
import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u00020\r8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/search/api/a;", "", "", "Ljava/lang/Class;", "barrierSpans", "Landroid/widget/EditText;", "editText", "", "b", "Landroid/text/Spannable;", "text", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getEnabled", "()Z", "setEnabled", "(Z)V", NodeProps.ENABLED, "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    void a(@NotNull Spannable text);

    void b(@NotNull List<? extends Class<?>> barrierSpans, @NotNull EditText editText);

    void onDestroy();

    void setEnabled(boolean z16);
}
