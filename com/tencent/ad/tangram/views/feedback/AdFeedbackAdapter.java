package com.tencent.ad.tangram.views.feedback;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdFeedbackAdapter {
    int getBackgroundColor(Context context);

    int getButtonTextColor(Context context);

    int getCancelButtonBackgroundColor(Context context);

    int getCancelButtonTextColor(Context context);

    int getDividerColor(Context context);

    int getIconColorFilter(Context context);

    int getMainDividerColor(Context context);
}
