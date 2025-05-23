package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J0\u0010\u000e\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0007H&J\b\u0010\u000f\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/f;", "", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "dismissDialog", "", "isShowing", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Pair;", "", "", "index", "b", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface f {
    boolean a();

    void b(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList, @NotNull List<Pair<String, Integer>> index);

    void dismissDialog();

    boolean isShowing();

    void onDestroy();
}
