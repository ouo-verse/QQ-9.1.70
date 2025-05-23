package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IAsyncDrawableConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/AsyncDrawableConfigImpl;", "Lcom/tencent/android/gldrawable/api/IAsyncDrawableConfig;", "()V", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class AsyncDrawableConfigImpl implements IAsyncDrawableConfig {
    private int requestLodingWidth = -1;
    private int requestLodingHeight = -1;

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public int getRequestLodingHeight() {
        return this.requestLodingHeight;
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public int getRequestLodingWidth() {
        return this.requestLodingWidth;
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public void setRequestLodingHeight(int i3) {
        this.requestLodingHeight = i3;
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public void setRequestLodingWidth(int i3) {
        this.requestLodingWidth = i3;
    }
}
