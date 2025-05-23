package com.tencent.mobileqq.vas.gift;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BalanceExplainDialogView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    TextView f309262d;

    /* renamed from: e, reason: collision with root package name */
    TextView f309263e;

    /* renamed from: f, reason: collision with root package name */
    TextView f309264f;

    /* renamed from: h, reason: collision with root package name */
    TextView f309265h;

    /* renamed from: i, reason: collision with root package name */
    TextView f309266i;

    /* renamed from: m, reason: collision with root package name */
    URLImageView f309267m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BalanceExplainDialogData f309268d;

        a(BalanceExplainDialogData balanceExplainDialogData) {
            this.f309268d = balanceExplainDialogData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f309268d.moreAreaJumpUrl)) {
                BalanceExplainDialogView.this.d(this.f309268d.moreAreaJumpUrl);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public BalanceExplainDialogView(Context context) {
        super(context);
        c();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.h95, (ViewGroup) this, true);
        this.f309262d = (TextView) findViewById(R.id.vnu);
        this.f309263e = (TextView) findViewById(R.id.zta);
        this.f309264f = (TextView) findViewById(R.id.yxf);
        this.f309265h = (TextView) findViewById(R.id.f165377vr0);
        this.f309266i = (TextView) findViewById(R.id.yxd);
        this.f309267m = (URLImageView) findViewById(R.id.yxe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Intent intent = new Intent(getContext(), ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        intent.putExtra("url", str);
        getContext().startActivity(intent);
    }

    public void b(BalanceExplainDialogData balanceExplainDialogData) {
        URLImageView uRLImageView;
        if (balanceExplainDialogData == null) {
            return;
        }
        this.f309262d.setOnClickListener(new a(balanceExplainDialogData));
        String str = balanceExplainDialogData.descString;
        if (str != null) {
            this.f309263e.setText(str);
        }
        if (TextUtils.isEmpty(balanceExplainDialogData.marketingName)) {
            this.f309264f.setText(getContext().getString(R.string.f1643625m));
        } else {
            this.f309264f.setText(getContext().getString(R.string.f1643725n).replace("{scene_name}", balanceExplainDialogData.marketingName));
        }
        this.f309265h.setText(String.valueOf(balanceExplainDialogData.coinBalance));
        this.f309266i.setText(String.valueOf(balanceExplainDialogData.marketingBalance));
        if (!TextUtils.isEmpty(balanceExplainDialogData.marketingIconUrl) && (uRLImageView = this.f309267m) != null) {
            uRLImageView.setBackgroundURL(balanceExplainDialogData.marketingIconUrl);
        }
    }
}
