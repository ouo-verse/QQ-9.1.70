package com.qzone.reborn.layer.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa extends o {
    private View H;
    private TextView I;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
        if (B9() != null) {
            B9().u5();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected boolean P9() {
        return true;
    }

    @Override // com.qzone.reborn.layer.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.cfm, (ViewGroup) null);
        this.H = inflate;
        N9(inflate);
        TextView textView = (TextView) this.H.findViewById(R.id.nm5);
        this.I = textView;
        textView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        ImageView imageView = (ImageView) this.H.findViewById(R.id.n0j);
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                aa.this.Q9(view2);
            }
        });
        ((ViewGroup) view).addView(this.H, layoutParams);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        if (this.f57984d == null) {
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        if (P9() && this.I != null) {
            if (D9(rFWLayerState) == 1) {
                this.I.setVisibility(8);
                return;
            }
            this.I.setText(C9(rFWLayerState) + "/" + D9(rFWLayerState));
            this.I.setVisibility(0);
        }
    }
}
