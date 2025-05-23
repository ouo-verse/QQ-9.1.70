package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class x extends ReportDialog implements View.OnClickListener {
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private TextView F;
    private RelativeLayout G;
    private TextView H;
    private RelativeLayout I;
    private ImageView J;
    private TextView K;
    private com.tencent.mobileqq.gamecenter.data.m L;

    public x(@NonNull Context context, int i3) {
        super(context, i3);
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    private void N(String str, ImageView imageView, int i3, int i16) {
        URLDrawable uRLDrawable;
        if (!TextUtils.isEmpty(str) && imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            if (!TextUtils.isEmpty(str)) {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setLoadingDrawable(new ColorDrawable(0));
                apngOptions.setRequestWidth(i3);
                apngOptions.setRequestHeight(i16);
                uRLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(x.class.getName(), str, apngOptions);
            } else {
                uRLDrawable = null;
            }
            if (uRLDrawable == null) {
                QLog.w("KingRedPackFloatView", 1, "drawable is null.");
            } else {
                imageView.setBackground(uRLDrawable);
            }
        }
    }

    private URLDrawable O(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = 23;
        obtain.mRequestHeight = 23;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setTag(com.tencent.mobileqq.gamecenter.utils.l.a(23, 23, 11));
        drawable.setDecodeHandler(com.tencent.mobileqq.gamecenter.utils.l.f213444a);
        return drawable;
    }

    private void P(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    private void Q() {
        if (this.L == null) {
            QLog.e("KingRedPackFloatView", 1, "[handleAble2OpenCase],redPackInfo is null.");
            return;
        }
        this.G.setVisibility(8);
        this.H.setVisibility(0);
        this.E.setVisibility(0);
        this.K.setVisibility(8);
        this.I.setVisibility(8);
        W(this.L.f212037b);
        if (!TextUtils.isEmpty(this.L.f212044i)) {
            int d16 = com.tencent.mobileqq.gamecenter.utils.c.d(84.0f, getContext().getResources());
            N(this.L.f212044i, this.E, d16, d16);
        }
        if (!TextUtils.isEmpty(this.L.f212043h)) {
            this.H.setText(this.L.f212043h);
        }
    }

    private void R() {
        if (this.L == null) {
            QLog.e("KingRedPackFloatView", 1, "[handleNotAble2OpenCase],redPackInfo is null.");
            return;
        }
        this.G.setVisibility(0);
        this.H.setVisibility(8);
        this.E.setVisibility(8);
        this.K.setVisibility(0);
        this.I.setVisibility(0);
        W(this.L.f212038c);
        if (!TextUtils.isEmpty(this.L.f212040e)) {
            this.D.setImageDrawable(O(this.L.f212040e));
        }
        if (!TextUtils.isEmpty(this.L.f212041f)) {
            this.F.setText(this.L.f212041f);
        }
        if (!TextUtils.isEmpty(this.L.f212042g)) {
            this.K.setText(this.L.f212042g);
        }
    }

    private void W(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        N(str, this.C, com.tencent.mobileqq.gamecenter.utils.c.d(321.0f, getContext().getResources()), com.tencent.mobileqq.gamecenter.utils.c.d(480.0f, getContext().getResources()));
    }

    public void S() {
        try {
            getWindow().setFlags(16777216, 16777216);
        } catch (Exception e16) {
            QLog.e("KingRedPackFloatView", 1, e16.getMessage());
        }
        super.setContentView(R.layout.fdk);
        this.C = (ImageView) findViewById(R.id.y7x);
        this.D = (ImageView) findViewById(R.id.f165909du3);
        this.E = (ImageView) findViewById(R.id.y6n);
        this.F = (TextView) findViewById(R.id.f110566iv);
        this.G = (RelativeLayout) findViewById(R.id.f759840f);
        this.H = (TextView) findViewById(R.id.f112566o_);
        this.I = (RelativeLayout) findViewById(R.id.f75393yu);
        this.J = (ImageView) findViewById(R.id.dum);
        this.K = (TextView) findViewById(R.id.f107876bl);
        this.J.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.I.setOnClickListener(this);
    }

    public void U(com.tencent.mobileqq.gamecenter.data.m mVar) {
        this.L = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.gamecenter.data.m mVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            dismiss();
        } else if (view == this.E) {
            com.tencent.mobileqq.gamecenter.data.m mVar2 = this.L;
            if (mVar2 != null) {
                P(mVar2.f212044i);
                dismiss();
            }
        } else if (view == this.I && (mVar = this.L) != null) {
            P(mVar.f212045j);
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        com.tencent.mobileqq.gamecenter.data.m mVar = this.L;
        if (mVar == null) {
            QLog.e("KingRedPackFloatView", 1, "redPackInfo is null.");
        } else if (mVar.f212036a == 0) {
            Q();
        } else {
            R();
        }
    }
}
