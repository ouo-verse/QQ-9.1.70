package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.wxa.g7.d;
import com.tencent.luggage.wxa.hn.eh;
import com.tencent.luggage.wxa.i3.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mm/plugin/appbrand/WxaWxBrandPromptHelper$checkCanShow$3$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/luggage/wxa/i3/i;", "event", "", "a", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class WxaWxBrandPromptHelper$checkCanShow$3$1 extends IListener<i> {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f151839e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f151840f;

    @Override // com.tencent.mm.sdk.event.IListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean callback(i event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.d().f127761e, this.f151839e.getAppId()) && Intrinsics.areEqual(event.d().f127770n, this.f151839e.S().k())) {
            if (this.f151840f.isActive()) {
                eh ehVar = event.e().f127867n;
                if (ehVar != null) {
                    z16 = ehVar.f127579e;
                } else {
                    z16 = false;
                }
                w.d("Luggage.WxaWxBrandPromptHelper", "WxaRuntime.checkCanShow() return onLaunchWxaResponseReceived:" + z16);
                this.f151840f.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
            dead();
        }
        return false;
    }
}
