package com.tencent.qqmini.miniapp.core.model;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EmbeddedState {
    private boolean enableEmbeddedVideo = false;
    private boolean enableEmbeddedCanvas = false;
    private boolean enableEmbeddedLive = false;
    private boolean enableEmbeddedElement = false;

    public boolean isEnableEmbeddedCanvas() {
        return this.enableEmbeddedCanvas;
    }

    public boolean isEnableEmbeddedElement() {
        return this.enableEmbeddedElement;
    }

    public boolean isEnableEmbeddedLive() {
        return this.enableEmbeddedLive;
    }

    public boolean isEnableEmbeddedVideo() {
        return this.enableEmbeddedVideo;
    }

    public void setEnableEmbeddedCanvas(boolean z16) {
        this.enableEmbeddedCanvas = z16;
    }

    public void setEnableEmbeddedElement(boolean z16) {
        this.enableEmbeddedElement = z16;
    }

    public void setEnableEmbeddedLive(boolean z16) {
        this.enableEmbeddedLive = z16;
    }

    public void setEnableEmbeddedVideo(boolean z16) {
        this.enableEmbeddedVideo = z16;
    }
}
