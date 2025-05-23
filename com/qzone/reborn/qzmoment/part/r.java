package com.qzone.reborn.qzmoment.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f58979d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f58980e;

    private void C9() {
        fo.c.o(this.f58979d, "em_bas_back_button", null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.lck && getActivity() != null) {
            getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f58979d = (ImageView) view.findViewById(R.id.lck);
        this.f58980e = (TextView) view.findViewById(R.id.nja);
        this.f58979d.setOnClickListener(this);
        rn.h.a(this.f58979d, "qui_chevron_left", R.color.qui_common_text_primary);
        C9();
    }
}
