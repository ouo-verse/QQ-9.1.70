package com.tencent.mobileqq.qqecommerce.biz.hr.api;

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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H&R6\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`\u00158&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "", "Landroid/content/Context;", "context", "", "pageName", "", "params", "Landroid/util/Size;", "size", "Landroid/view/View;", "onCreate", "", DKHippyEvent.EVENT_STOP, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, AdMetricTag.EVENT_NAME, "data", "sendEvent", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/QQECHRViewEventCallback;", "getHrEventCallback", "()Lkotlin/jvm/functions/Function2;", "a", "(Lkotlin/jvm/functions/Function2;)V", "hrEventCallback", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ View a(e eVar, Context context, String str, Map map, Size size, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    size = null;
                }
                return eVar.onCreate(context, str, map, size);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreate");
        }
    }

    void a(@Nullable Function2<? super String, ? super JSONObject, Unit> function2);

    @NotNull
    View onCreate(@NotNull Context context, @NotNull String pageName, @NotNull Map<String, ? extends Object> params, @Nullable Size size);

    void onDestroy();

    void onResume();

    void onStop();

    void sendEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);
}
