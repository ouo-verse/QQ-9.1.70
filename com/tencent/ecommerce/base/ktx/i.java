package com.tencent.ecommerce.base.ktx;

import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/i;", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "", "unregister", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper;", "a", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper;", "helper", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "b", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "listener", "", "isKeyboardOpened", "()Z", "<init>", "(Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper;Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class i implements ISoftKeyBoardStateListenerRegistry {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SoftKeyboardStateHelper helper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SoftKeyboardStateHelper.SoftKeyboardStateListener listener;

    public i(SoftKeyboardStateHelper softKeyboardStateHelper, SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        this.helper = softKeyboardStateHelper;
        this.listener = softKeyboardStateListener;
    }

    @Override // com.tencent.ecommerce.base.ktx.ISoftKeyBoardStateListenerRegistry
    public boolean isKeyboardOpened() {
        return this.helper.getIsSoftKeyboardOpened();
    }

    @Override // com.tencent.ecommerce.base.ktx.ISoftKeyBoardStateListenerRegistry
    public void unregister() {
        this.helper.e(this.listener);
    }
}
