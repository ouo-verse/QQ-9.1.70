package com.tencent.mobileqq.vas.image;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/image/AsyncDrawableConfigImpl;", "Lcom/tencent/mobileqq/vas/image/IAsyncDrawableConfig;", "()V", "requestLayoutAfterDrawableChange", "", "getRequestLayoutAfterDrawableChange", "()Z", "setRequestLayoutAfterDrawableChange", "(Z)V", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "scaleXY", "", "getScaleXY", "()F", "setScaleXY", "(F)V", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AsyncDrawableConfigImpl implements IAsyncDrawableConfig {
    private int requestLodingWidth = -1;
    private int requestLodingHeight = -1;
    private boolean requestLayoutAfterDrawableChange = true;
    private float scaleXY = 1.0f;

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public boolean getRequestLayoutAfterDrawableChange() {
        return this.requestLayoutAfterDrawableChange;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public int getRequestLodingHeight() {
        return this.requestLodingHeight;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public int getRequestLodingWidth() {
        return this.requestLodingWidth;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public float getScaleXY() {
        return this.scaleXY;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLayoutAfterDrawableChange(boolean z16) {
        this.requestLayoutAfterDrawableChange = z16;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLodingHeight(int i3) {
        this.requestLodingHeight = i3;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLodingWidth(int i3) {
        this.requestLodingWidth = i3;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setScaleXY(float f16) {
        this.scaleXY = f16;
    }
}
