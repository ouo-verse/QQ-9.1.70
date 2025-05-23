package com.tencent.ecommerce.biz.hr;

import android.content.Context;
import android.util.Size;
import android.view.View;
import bi0.ECHREvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.biz.hr.api.IECHRViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b*\u0010+J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aRN\u0010#\u001a:\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cj\u0004\u0018\u0001` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0094\u0001\u0010)\u001a:\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cj\u0004\u0018\u0001` 2>\u0010$\u001a:\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cj\u0004\u0018\u0001` 8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/c;", "Lcom/tencent/ecommerce/biz/hr/api/IECHRViewModel;", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lbi0/a;", "Landroid/content/Context;", "context", "", "pageName", "", "", "params", "Landroid/util/Size;", "size", "Landroid/view/View;", "onCreate", "", DKHippyEvent.EVENT_STOP, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, AdMetricTag.EVENT_NAME, "data", "sendEvent", "event", "a", "Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "d", "Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "ecHippyRenderView", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lorg/json/JSONObject;", "Lcom/tencent/ecommerce/biz/hr/api/ECHRViewEventCallback;", "e", "Lkotlin/jvm/functions/Function2;", "_eventCallback", "value", "getEventCallback", "()Lkotlin/jvm/functions/Function2;", "setEventCallback", "(Lkotlin/jvm/functions/Function2;)V", "eventCallback", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECHRViewModel, EventObserver<ECHREvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECHippyRenderView ecHippyRenderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function2<? super String, ? super JSONObject, Unit> _eventCallback;

    public c() {
        LifecycleEventBus.f100688b.d(ThreadMode.MAIN, ECHREvent.class, this);
    }

    @Override // com.tencent.ecommerce.base.eventbus.EventObserver
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onEvent(ECHREvent event) {
        Function2<? super String, ? super JSONObject, Unit> function2 = this._eventCallback;
        if (function2 != null) {
            function2.invoke(event.getEventName(), event.getData());
        }
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public Function2<String, JSONObject, Unit> getEventCallback() {
        return this._eventCallback;
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public View onCreate(Context context, String pageName, Map<String, ? extends Object> params, Size size) {
        ECHippyRenderView eCHippyRenderView = new ECHippyRenderView(context, null, null, 6, null);
        this.ecHippyRenderView = eCHippyRenderView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(params);
        Unit unit = Unit.INSTANCE;
        eCHippyRenderView.onAttach("", pageName, linkedHashMap, size);
        ECHippyRenderView eCHippyRenderView2 = this.ecHippyRenderView;
        Intrinsics.checkNotNull(eCHippyRenderView2);
        return eCHippyRenderView2;
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public void onDestroy() {
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onDetach();
        }
        LifecycleEventBus.f100688b.e(this);
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public void onResume() {
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onResume();
        }
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public void onStop() {
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onPause();
        }
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public void sendEvent(String eventName, Map<String, ? extends Object> data) {
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.sentEvent(eventName, data);
        }
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRViewModel
    public void setEventCallback(Function2<? super String, ? super JSONObject, Unit> function2) {
        this._eventCallback = function2;
    }
}
