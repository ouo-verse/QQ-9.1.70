package com.tencent.ad.tangram.views.xijing;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdButtonView extends TextView {
    private static final String TAG = "GdtButtonView";

    public AdButtonView(@NonNull Context context, AdButtonData adButtonData) {
        super(context);
        init(context, adButtonData);
    }

    @TargetApi(16)
    private void init(@NonNull Context context, @Nullable AdButtonData adButtonData) {
        if (adButtonData != null && adButtonData.isValid()) {
            setGravity(17);
            setText(adButtonData.text.text);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
            int dp2px = AdUIUtils.dp2px(2.0f, context.getResources());
            setPadding(dp2px, 0, dp2px, 0);
            setTextSize(0, adButtonData.text.size);
            setTextColor(adButtonData.text.color);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(adButtonData.borderCornerRadius);
            gradientDrawable.setColor(adButtonData.backgroundColor);
            setBackground(gradientDrawable);
            return;
        }
        AdLog.e(TAG, "init error");
    }
}
