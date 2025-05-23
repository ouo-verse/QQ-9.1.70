package com.tencent.gdtad.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GdtAdView {
    void destroy(Context context);

    @Nullable
    View getView();

    void pause(Context context);

    void resume(Context context);
}
