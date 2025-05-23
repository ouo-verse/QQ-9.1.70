package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;

/* loaded from: classes22.dex */
public class WsPicStickerContext extends WsStickerContext {
    private boolean addingTemplate;
    private boolean postRenderResult;

    public WsPicStickerContext(Context context) {
        super(context);
        this.addingTemplate = false;
        this.postRenderResult = true;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext
    @RequiresApi(api = 19)
    public void addView(View view, boolean z16) {
        if (!view.isAttachedToWindow() && !this.addingTemplate) {
            super.addView(view, true);
        }
    }

    public void setAddingTemplate(boolean z16) {
        this.addingTemplate = z16;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext
    public void removeAllViews() {
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContext
    protected void renderStickerEditView(long j3) {
    }
}
