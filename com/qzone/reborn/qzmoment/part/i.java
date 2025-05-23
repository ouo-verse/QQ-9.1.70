package com.qzone.reborn.qzmoment.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i extends an.a implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f58962d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f58963e;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.lvk && getActivity() != null) {
            getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        TextView textView = (TextView) view.findViewById(R.id.nkf);
        this.f58963e = textView;
        textView.setTextColor(ie0.a.f().g(view.getContext(), R.color.qui_common_text_nav_primary, 1002));
        ImageView imageView = (ImageView) view.findViewById(R.id.lvk);
        this.f58962d = imageView;
        imageView.setOnClickListener(this);
        rn.h.a(this.f58962d, "qui_chevron_left", R.color.qui_common_icon_white);
    }
}
