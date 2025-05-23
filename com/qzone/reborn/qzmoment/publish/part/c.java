package com.qzone.reborn.qzmoment.publish.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.NetworkState;
import rn.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends an.a implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f59025d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f59026e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f59027f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f59028h;

    /* renamed from: i, reason: collision with root package name */
    private pn.b f59029i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    private void C9(Context context) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.s("\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\u662f\u5426\u6b63\u5e38", 4);
        } else {
            this.f59029i.Q1(context);
            broadcastMessage("hide_keyboard_and_emo", null);
        }
    }

    private void D9() {
        DialogUtil.createCustomDialog(getActivity(), 230, HardCodeUtil.qqStr(R.string.f1338377), HardCodeUtil.qqStr(R.string.f1338276), HardCodeUtil.qqStr(R.string.f1338175), (String) null, (DialogInterface.OnClickListener) null, new a()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.mkp /* 1745224371 */:
                D9();
                break;
            case R.id.mlg /* 1745224399 */:
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                    break;
                }
                break;
            case R.id.mlh /* 1745224400 */:
                C9(view.getContext());
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f59025d = (TextView) view.findViewById(R.id.mlg);
        TextView textView = (TextView) view.findViewById(R.id.mko);
        this.f59026e = textView;
        textView.setText(QZoneConfigHelper.t0());
        this.f59027f = (ImageView) view.findViewById(R.id.mkp);
        this.f59028h = (TextView) view.findViewById(R.id.mlh);
        this.f59025d.setOnClickListener(this);
        this.f59027f.setOnClickListener(this);
        this.f59028h.setOnClickListener(this);
        h.a(this.f59027f, "qui_question_mark_circle", R.color.qui_common_icon_tertiary);
        fo.c.o(this.f59025d, "em_bas_cancel_button", null);
        fo.c.o(this.f59028h, "em_bas_publish_button", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.f59029i = (pn.b) getViewModel(pn.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }
}
