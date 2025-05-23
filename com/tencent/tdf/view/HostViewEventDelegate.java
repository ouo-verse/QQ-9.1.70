package com.tencent.tdf.view;

import android.view.View;
import com.tencent.tdf.embed.EmbeddedViewController;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface HostViewEventDelegate {
    View getTDFView();

    void onConvertToImageView();

    EmbeddedViewController onCreateEmbeddedViewController(String str, int i3, Map<String, String> map);

    View onCreateOverlaySurfaceView(long j3);

    void onEndFrame();

    void onRevertImageView();
}
