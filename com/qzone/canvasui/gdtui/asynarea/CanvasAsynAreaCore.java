package com.qzone.canvasui.gdtui.asynarea;

import com.qzone.canvasui.gdtui.IGdtCanvasUi;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class CanvasAsynAreaCore implements IGdtCanvasUi {
    boolean inited = false;
    boolean used = false;

    protected abstract boolean needUpdate();

    protected abstract void onInit();

    protected abstract void onReset();

    protected abstract void onSetFeedData(BusinessFeedData businessFeedData);

    protected abstract void onUpdate();

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void reset() {
        if (this.used) {
            this.used = false;
            onReset();
        }
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void setFeedData(BusinessFeedData businessFeedData) {
        onSetFeedData(businessFeedData);
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void update() {
        if (needUpdate()) {
            if (!this.inited) {
                onInit();
                this.inited = true;
            }
            onUpdate();
            this.used = true;
        }
    }
}
