package com.tencent.input.base.tool.emitter;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/input/base/tool/emitter/InputFunctionEmitter$addCallBack$lifeObserver$1", "Lcom/tencent/mvi/runtime/lifeobserver/LifeCycleWrapperObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class InputFunctionEmitter$addCallBack$lifeObserver$1 extends LifeCycleWrapperObserver {
    static IPatchRedirector $redirector_;

    @Override // com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        throw null;
    }
}
