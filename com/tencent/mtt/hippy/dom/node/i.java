package com.tencent.mtt.hippy.dom.node;

import android.graphics.Picture;
import android.text.Layout;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.HippyThreadRunnable;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private final Picture f337432b = new Picture();

    /* renamed from: a, reason: collision with root package name */
    private HippyHandlerThread f337431a = new HippyHandlerThread("text-warm-thread");

    private int b(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return layout.getHeight() - 0;
    }

    private int c(Layout layout) {
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int i3 = 0;
        for (int i16 = 0; i16 < lineCount; i16++) {
            i3 = Math.max(i3, (int) layout.getLineRight(i16));
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Layout layout) {
        try {
            layout.draw(this.f337432b.beginRecording(c(layout), b(layout)));
            this.f337432b.endRecording();
        } catch (Exception e16) {
            LogUtils.e("TextNode", "warmUpTextLayoutCache error", e16);
        }
    }

    public void a() {
        HippyHandlerThread hippyHandlerThread = this.f337431a;
        if (hippyHandlerThread != null) {
            hippyHandlerThread.quit();
        }
        this.f337431a = null;
    }

    public void a(Layout layout) {
        HippyHandlerThread hippyHandlerThread = this.f337431a;
        if (hippyHandlerThread == null || !hippyHandlerThread.isThreadAlive()) {
            return;
        }
        this.f337431a.runOnQueue(new HippyThreadRunnable<Layout>(layout) { // from class: com.tencent.mtt.hippy.dom.node.i.1
            @Override // com.tencent.mtt.hippy.common.HippyThreadRunnable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void run(Layout layout2) {
                i.this.d(layout2);
            }
        });
    }
}
