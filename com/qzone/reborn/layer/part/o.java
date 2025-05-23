package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends ap {
    protected View G;

    private void M9(Object obj) {
        if ((obj instanceof Boolean) && this.G != null) {
            this.G.setVisibility(((Boolean) obj).booleanValue() ? 8 : 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "hide_feedx_layer_head_mask")) {
            M9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(getContext()) + ViewUtils.dip2px(66.0f));
        View view2 = new View(getContext());
        this.G = view2;
        view2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.awl));
        this.G.setClickable(false);
        this.G.setEnabled(false);
        ((ViewGroup) view).addView(this.G, layoutParams);
    }

    public void N9(View view) {
    }
}
