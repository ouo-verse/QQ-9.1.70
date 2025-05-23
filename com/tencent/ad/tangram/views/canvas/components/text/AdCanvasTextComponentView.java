package com.tencent.ad.tangram.views.canvas.components.text;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasTextComponentView extends AdCanvasComponentView {
    private static final String TAG = "AdCanvasTextComponentView";

    @Nullable
    private AdCanvasTextComponentData value;

    public AdCanvasTextComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasTextComponentData adCanvasTextComponentData) {
        super(context, weakReference);
        init(context, adCanvasTextComponentData);
    }

    private void init(@Nullable Context context, @Nullable AdCanvasTextComponentData adCanvasTextComponentData) {
        startLoad();
        if (context != null && adCanvasTextComponentData != null && adCanvasTextComponentData.isValid()) {
            this.value = adCanvasTextComponentData;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            AdCanvasTextComponentData adCanvasTextComponentData2 = this.value;
            layoutParams.leftMargin = adCanvasTextComponentData2.marginLeft;
            layoutParams.topMargin = adCanvasTextComponentData2.marginTop;
            layoutParams.rightMargin = adCanvasTextComponentData2.marginRight;
            layoutParams.bottomMargin = adCanvasTextComponentData2.marginBottom;
            addView(relativeLayout);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setGravity(15);
            TextView textView = new TextView(context);
            textView.setId(8738);
            textView.setText(this.value.content);
            textView.setTextSize(this.value.fontSize);
            textView.setGravity(8388611);
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setTextColor(Color.parseColor("#000000"));
            relativeLayout.addView(textView);
            ((RelativeLayout.LayoutParams) textView.getLayoutParams()).topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            stopLoad(true);
            return;
        }
        stopLoad(false);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasTextComponentData getData() {
        return this.value;
    }
}
