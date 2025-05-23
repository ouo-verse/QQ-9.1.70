package com.tencent.tavkit.report;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVAutoTestHelper {

    @Nullable
    private static RenderListener listener;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface RenderListener {
        void onRender(CMSampleBuffer cMSampleBuffer);
    }

    public static synchronized void onRender(CMSampleBuffer cMSampleBuffer) {
        synchronized (TAVAutoTestHelper.class) {
            RenderListener renderListener = listener;
            if (renderListener != null) {
                renderListener.onRender(cMSampleBuffer);
            }
        }
    }

    public static synchronized void setListener(@Nullable RenderListener renderListener) {
        synchronized (TAVAutoTestHelper.class) {
            listener = renderListener;
        }
    }
}
