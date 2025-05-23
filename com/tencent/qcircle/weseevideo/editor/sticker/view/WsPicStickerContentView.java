package com.tencent.qcircle.weseevideo.editor.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes22.dex */
public class WsPicStickerContentView extends WsStickerContentView {
    private final List<WsStickerEditView> stickerEditViews;

    public WsPicStickerContentView(Context context) {
        super(context);
        this.stickerEditViews = new CopyOnWriteArrayList();
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerContentView, com.tencent.tavsticker.core.TAVStickerContentView, android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        WsStickerEditView wsStickerEditView = this.curStickerEditView;
        if (wsStickerEditView != null && !this.stickerEditViews.contains(wsStickerEditView)) {
            this.stickerEditViews.add(this.curStickerEditView);
        }
    }

    public List<WsStickerEditView> getStickerEditViews() {
        return this.stickerEditViews;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContentView
    protected void initStickerView() {
        for (WsStickerEditView wsStickerEditView : this.stickerEditViews) {
            if (wsStickerEditView.isNeedInitLocation()) {
                wsStickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerContentView
    protected void setNeedInitLocation() {
        Iterator<WsStickerEditView> it = this.stickerEditViews.iterator();
        while (it.hasNext()) {
            it.next().needInitLocation();
        }
    }

    public WsPicStickerContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.stickerEditViews = new CopyOnWriteArrayList();
    }

    public WsPicStickerContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.stickerEditViews = new CopyOnWriteArrayList();
    }
}
