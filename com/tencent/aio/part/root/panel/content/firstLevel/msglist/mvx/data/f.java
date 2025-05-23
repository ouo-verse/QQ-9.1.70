package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\u001e\u0010\u000e\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/f;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/e;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "c", "Lkotlin/Function1;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "notifyAction", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "model", "j", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface f extends IMsgListRepository, e {
    void c();

    void j(@NotNull a model);

    void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope);

    void m(@Nullable Function1<? super l, Unit> notifyAction);

    void onDestroy();
}
