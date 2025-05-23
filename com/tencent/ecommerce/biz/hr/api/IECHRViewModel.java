package com.tencent.ecommerce.biz.hr.api;

import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\nH&J\b\u0010\u001a\u001a\u00020\nH&J\b\u0010\u001b\u001a\u00020\nH&J$\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0016H&RP\u0010\u0002\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/api/IECHRViewModel;", "", "eventCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "", "Lcom/tencent/ecommerce/biz/hr/api/ECHRViewEventCallback;", "getEventCallback", "()Lkotlin/jvm/functions/Function2;", "setEventCallback", "(Lkotlin/jvm/functions/Function2;)V", "onCreate", "Landroid/view/View;", "context", "Landroid/content/Context;", "pageName", "params", "", "size", "Landroid/util/Size;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", DKHippyEvent.EVENT_STOP, "sendEvent", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECHRViewModel {
    @Nullable
    Function2<String, JSONObject, Unit> getEventCallback();

    @NotNull
    View onCreate(@NotNull Context context, @NotNull String pageName, @NotNull Map<String, ? extends Object> params, @Nullable Size size);

    void onDestroy();

    void onResume();

    void onStop();

    void sendEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);

    void setEventCallback(@Nullable Function2<? super String, ? super JSONObject, Unit> function2);
}
