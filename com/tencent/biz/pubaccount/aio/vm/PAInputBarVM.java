package com.tencent.biz.pubaccount.aio.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.base.mvvm.b;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/vm/PAInputBarVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "intent", "j", "<init>", "()V", "d", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PAInputBarVM extends b<PAInputIntent, PAInputUIState> implements LifecycleObserver {
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(PAInputIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        ((a) getMContext()).d().getLifecycle().removeObserver(this);
        super.onDestroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        updateUI(new PAInputUIState.OnResumeState());
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.d().getLifecycle().addObserver(this);
    }
}
