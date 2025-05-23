package com.tencent.qcircle.tavcut.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.qcircle.tavcut.bean.Size;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVCutVideoView extends RelativeLayout {
    private FrameLayout stickerContainer;

    public TAVCutVideoView(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.stickerContainer = new FrameLayout(context);
    }

    public void adjustStickerContainer(final Size size) {
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.view.TAVCutVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if ((size.getWidth() * 1.0f) / size.getHeight() < (TAVCutVideoView.this.getWidth() * 1.0f) / TAVCutVideoView.this.getHeight()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (TAVCutVideoView.this.getHeight() * ((size.getWidth() * 1.0f) / size.getHeight())), TAVCutVideoView.this.getHeight());
                    layoutParams.addRule(14, -1);
                    if (TAVCutVideoView.this.stickerContainer.getParent() != null) {
                        ((ViewGroup) TAVCutVideoView.this.stickerContainer.getParent()).removeView(TAVCutVideoView.this.stickerContainer);
                    }
                    TAVCutVideoView tAVCutVideoView = TAVCutVideoView.this;
                    tAVCutVideoView.addView(tAVCutVideoView.stickerContainer, layoutParams);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(TAVCutVideoView.this.getWidth(), (int) (TAVCutVideoView.this.getWidth() / ((size.getWidth() * 1.0f) / size.getHeight())));
                layoutParams2.addRule(15, -1);
                if (TAVCutVideoView.this.stickerContainer.getParent() != null) {
                    ((ViewGroup) TAVCutVideoView.this.stickerContainer.getParent()).removeView(TAVCutVideoView.this.stickerContainer);
                }
                TAVCutVideoView tAVCutVideoView2 = TAVCutVideoView.this;
                tAVCutVideoView2.addView(tAVCutVideoView2.stickerContainer, layoutParams2);
            }
        });
    }

    public ViewGroup getStickerContainer() {
        return this.stickerContainer;
    }

    public TAVCutVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TAVCutVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
