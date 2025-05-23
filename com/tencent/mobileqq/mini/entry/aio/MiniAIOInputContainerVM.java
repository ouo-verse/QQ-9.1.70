package com.tencent.mobileqq.mini.entry.aio;

import at.a;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvvm.b;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.f;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/aio/MiniAIOInputContainerVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/f$c;", "intent", "", "handleInputLayoutChange", "handleIntent", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAIOInputContainerVM extends b<a, InputUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void handleInputLayoutChange(f.c intent) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.InputLayoutChange(intent.b(), intent.d(), intent.c(), intent.a()));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.BottomLayoutHeightChange(intent.a() - intent.d()));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public /* bridge */ /* synthetic */ Set getSubscribeEventNames() {
        return com.tencent.mvi.base.route.f.a(this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public /* bridge */ /* synthetic */ Set getSubscribeEventRNames() {
        return com.tencent.mvi.base.route.f.b(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof f.c) {
            handleInputLayoutChange((f.c) intent);
        }
    }
}
