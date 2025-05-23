package com.tencent.qqnt.aio.input.api;

import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/input/api/IInputAtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMatchAtSpanCount", "", "matcher", "Lkotlin/Function1;", "", "", "initInput", "", "editText", "Landroid/widget/EditText;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IInputAtApi extends QRouteApi {
    int getMatchAtSpanCount(@NotNull Function1<? super String, Boolean> matcher);

    void initInput(@NotNull EditText editText);

    void onDestroy();
}
