package com.tencent.mobileqq.nearbypro.media.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name */
    private View f253620d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new NBLayerDeleteMediaEvent());
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (!getActivity().getIntent().getBooleanExtra("NBP_GALLERY_TITLE", false)) {
            return;
        }
        this.f253620d = LayoutInflater.from(view.getContext()).inflate(R.layout.fnf, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        ((ImageView) this.f253620d.findViewById(R.id.zog)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.media.gallery.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.A9(view2);
            }
        });
        ((ImageView) this.f253620d.findViewById(R.id.zoh)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.media.gallery.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.B9(view2);
            }
        });
        ((ViewGroup) view).addView(this.f253620d, layoutParams);
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
    }
}
